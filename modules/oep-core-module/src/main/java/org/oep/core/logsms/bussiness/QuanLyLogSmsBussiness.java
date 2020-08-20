package org.oep.core.logsms.bussiness;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.oep.core.model.LogSMS;

import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.configuration.ConfigurationFactoryUtil;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.StringBundler;


public class QuanLyLogSmsBussiness {
	private static final Configuration _configuration = ConfigurationFactoryUtil
		    .getConfiguration(PortalClassLoaderUtil.getClassLoader(), "portlet");
	
	public String getMessageFromCode(String messageId){
		try {
			String message = _configuration.get("log.sms.messageId."+messageId);
			if(message == null || message.equals("")){
				return "";
			}else{
				return message;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "";
		
	}
	public String getErrorFromCode(String ErrorCode){
		try {
			String message = _configuration.get("log.sms.errorId."+ErrorCode);
			return message;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "";
		
	}
	public static byte[] exportCSVFile(List<LogSMS> listRecords){
		StringBundler sb = new StringBundler();
		sb.append("\uFEFF");
		String[] headers = {_configuration.get("idm.vnpost.logsms.csv.stt"), _configuration.get("idm.vnpost.logsms.csv.sdt"), _configuration.get("idm.vnpost.logsms.csv.sent"), _configuration.get("idm.vnpost.logsms.csv.messageid"),
				_configuration.get("idm.vnpost.logsms.csv.errorcode"),_configuration.get("idm.vnpost.logsms.csv.errordetail"),_configuration.get("idm.vnpost.logsms.csv.response")};
		for(String s : headers){
			sb.append(s);
			sb.append(",");
		}
		sb.setIndex(sb.index()-1);
		sb.append(CharPool.NEW_LINE);
		
		int stt = 1;
		for(LogSMS i: listRecords){
			sb.append(stt++);
			sb.append(",");
			sb.append(i.getPhone());
			sb.append(",");
			sb.append(org.oep.util.DateUtil.parseDateToString(i.getSentDateTime(), org.oep.util.DateUtil.DATE_FORMAT_D_M_Y_H_M_S));
			sb.append(",");
			sb.append("");
			sb.append(i.getMessageId());
			sb.append("");
			sb.append(i.getErrorCode());
			sb.append(",");
			sb.append(i.getErrorDetail());
			sb.append(",");
			sb.append(org.oep.util.DateUtil.parseDateToString(i.getResponseDate(), org.oep.util.DateUtil.DATE_FORMAT_D_M_Y_H_M_S));
			sb.append(CharPool.NEW_LINE);
			
		}
		return sb.toString().getBytes();
	}
}
