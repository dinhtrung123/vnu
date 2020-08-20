package dtt.vn.xacminh.business;

import javax.mail.internet.InternetAddress;

import org.oep.core.service.MailLocalServiceUtil;
import org.oep.core.service.ThamSoLocalServiceUtil;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.configuration.ConfigurationFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.util.ContentUtil;


public class XacMinhBusiness {
	
	private static Log log = LogFactoryUtil.getLog(XacMinhBusiness.class.getName()); 
	
	
	private static final Configuration _configuration = ConfigurationFactoryUtil
		    .getConfiguration(PortalClassLoaderUtil.getClassLoader(), "portlet");
	
	public static String getGiaTriThamSo(String key){
		return ThamSoLocalServiceUtil.getValue(key, "");
	}
	
	
	//test
	public static String getMoTaThamSo(long groupId, String key){
		return ThamSoLocalServiceUtil.getValue(groupId, key)!=null?ThamSoLocalServiceUtil.getValue(groupId, key).getMoTa():"";
	}
	public static void sendEmailNotification(String[] emailAddress,String Hoten,String username) {
		try {	
			/*InternetAddress[] internetAddresses = new InternetAddress[emailAddress.length];
			InternetAddress fromAddresses = new InternetAddress("vnpostmail1@gmail.com");
			for (int i = 0; i < emailAddress.length; i++) {
				internetAddresses[i] = new InternetAddress(emailAddress[i]);
			}

			String body = ContentUtil.get("/formbbxn/emailxacminh.tmpl", true);
			body = StringUtil.replace(body, new String[] { "[$NAME$]", "[$CONTENT]", "[$SIGNATURE]" },
					new String[] { Hoten,_configuration.get("mail.remind.xacminh.setSetBody").replace("[$tendangnhap$]", username), "VNPOST" });

			MailMessage mailMessage = new MailMessage();
			mailMessage.setFrom(fromAddresses);
			mailMessage.setTo(internetAddresses);
			mailMessage.setSubject(_configuration.get("mail.xacminh.setSubject"));
			mailMessage.setBody(body);
			mailMessage.setHTMLFormat(true);
			MailServiceUtil.sendEmail(mailMessage);*/
			String body = ContentUtil.get("/formbbxn/emailxacminh.tmpl", true);
			body = StringUtil.replace(body, new String[] { "[$NAME$]", "[$CONTENT]", "[$SIGNATURE]" },
					new String[] { Hoten,_configuration.get("mail.remind.xacminh.setSetBody").replace("[$tendangnhap$]", username), "VNPOST" });
			if(MailLocalServiceUtil.send(emailAddress, _configuration.get("mail.xacminh.setSubject"), body))
			{
				//SessionMessages.add(actionRequest, "thongBaoTaoTaiKhoanDN");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void sendMailThongBaoXacMinhSai(ThemeDisplay themeDisplay, String emailAddress, String hoTen, String username){
		try {
			String subject = getGiaTriThamSo("MAIL_TEMPLATE_TB_XM_SAI");
			String body = getMoTaThamSo(themeDisplay.getScopeGroupId(), "MAIL_TEMPLATE_TB_XM_SAI");
			body = body.replace("[$tendangnhap$]", username);
			body = body.replace("[$ten]", hoTen);
			body = body.replace("[$email]", emailAddress);
			if(MailLocalServiceUtil.send(emailAddress, subject, body)){
				log.info("In XacMinhBusiness gui mail thong bao thanh cong");
			}else {
				log.info("In XacMinhBusiness gui mail thong bao that bai");
			}
			
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}
}
