package dtt.vn.user.business;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import org.oep.core.model.LogSMS;
import org.oep.core.service.LogSMSLocalServiceUtil;
import org.oep.core.service.ThamSoLocalServiceUtil;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.SAXReaderUtil;

import dtt.vn.user.common.utils.DateUtil;

public class SmsServices {
	
	public static String getGiaTriThamSo(String key){
		return ThamSoLocalServiceUtil.getValue(key, "");
	}
	public static String getHinhThucKichHoat(String key){
		return ThamSoLocalServiceUtil.getValue(key, "");
	}
	
	public static void main(String[] args) throws MalformedURLException, IOException {
		String wsURL = "http://brandsms.vn:8018/VMGAPI.asmx?wsdl";

		String xml="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n" + 
				"   <soapenv:Header/>\r\n" + 
				"   <soapenv:Body>\r\n" + 
				"      <tem:BulkSendSms>\r\n" + 
				"         <tem:msisdn>[$msisdn$]</tem:msisdn>\r\n" + 
				"         <tem:alias>[$alias$]</tem:alias>\r\n" + 
				"         <tem:message>[$message$]</tem:message>\r\n" + 
				"         <tem:sendTime>[$sendTime$]</tem:sendTime>\r\n" + 
				"         <tem:authenticateUser>[$username$]</tem:authenticateUser>\r\n" + 
				"         <tem:authenticatePass>[$password$]</tem:authenticatePass>\r\n" + 
				"      </tem:BulkSendSms>\r\n" + 
				"   </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>";
		
	}

	public static String sendSMS(String wsURL, String xml, String phone, String otp) throws MalformedURLException, IOException {

		// Code to make a webservice HTTP request
		//OtpServices otp = new OtpServices();
		String responseString = "";
		String outputString = "";
		URL url = new URL(wsURL);
		URLConnection connection = url.openConnection();
		HttpURLConnection httpConn = (HttpURLConnection) connection;
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		String xmlInput = xml.replace("[$msisdn$]", phone);
		
		String message = "Nhap OTP: [$otp$] de xac thuc tai khoan. OTP co hieu luc 1 phut. Khong cung cap OTP cho bat ky ai";
		message = message.replace("[$otp$]", String.valueOf(otp));
		
		String alias = getGiaTriThamSo("VMG_ALIAS");
		String accountName = getGiaTriThamSo("VMG_ACCOUNT");
		String PWD = getGiaTriThamSo("VMG_PWD");
		
		xmlInput = xmlInput.replace("[$alias$]", alias);
		xmlInput = xmlInput.replace("[$message$]", message);
		xmlInput = xmlInput.replace("[$sendTime$]", "");
		xmlInput = xmlInput.replace("[$username$]", accountName);
		xmlInput = xmlInput.replace("[$password$]", PWD);
		
		LogSMS lSms = LogSMSLocalServiceUtil.createLogSMS(CounterLocalServiceUtil.increment());
		lSms.setPhone(phone);
		lSms.setSentDateTime(new Date());
		LogSMSLocalServiceUtil.updateLogSMS(lSms);
		long logId = lSms.getId();
		
		byte[] buffer = new byte[xmlInput.length()];
		buffer = xmlInput.getBytes();
		bout.write(buffer);
		byte[] b = bout.toByteArray();
		// Set the appropriate HTTP parameters.
		httpConn.setRequestProperty("Content-Length", String.valueOf(b.length));
		httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
		httpConn.setRequestMethod("POST");
		httpConn.setDoOutput(true);
		httpConn.setDoInput(true);
		OutputStream out = httpConn.getOutputStream();
		// Write the content of the request to the outputstream of the HTTP
		// Connection.
		out.write(b);
		out.close();
		// Ready with sending the request.

		// Read the response.
		InputStreamReader isr = new InputStreamReader(httpConn.getInputStream());
		BufferedReader in = new BufferedReader(isr);

		// Write the SOAP message response to a String.
		while ((responseString = in.readLine()) != null) {
			outputString = outputString + responseString;
			getAndAddToSMSLog(logId, outputString, phone);
		}
		// reponse code add to SMS log
		
		
		//end
		return outputString;
	}
	public static int getAndAddToSMSLog(long logId, String output, String phone){
		try {
			Document doc = Jsoup.parse(output.replace("<?xml version=\"1.0\" encoding=\"utf-8\"?>", ""), "", Parser.xmlParser());
			String errorcode = doc.select("error_code").first() == null ? "" : doc.select("error_code").first().text();
			String error_detail = doc.select("error_detail").first() == null ? "" : doc.select("error_detail").first().text();
			String messageId = doc.select("messageId").first() == null ? "" : doc.select("messageId").first().text();
			String response_date = doc.select("response_date").first() == null ? "" : doc.select("response_date").first().text();
			
			System.out.println(" error_code= " + errorcode + " error_detail= " + error_detail +  " messageId= " + messageId );
			LogSMS logSMS = LogSMSLocalServiceUtil.fetchLogSMS(logId);
			logSMS.setErrorCode(errorcode);
			logSMS.setErrorDetail(error_detail);
			logSMS.setResponseDate(new Date());
			logSMS.setMessageId((messageId==null || messageId.equals(""))?-1:Long.parseLong(messageId));			
			LogSMSLocalServiceUtil.updateLogSMS(logSMS);
			return 0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 1;
		
		
	}
	
}
