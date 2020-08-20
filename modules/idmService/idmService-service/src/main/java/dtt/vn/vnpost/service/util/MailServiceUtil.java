package dtt.vn.vnpost.service.util;


import org.oep.core.service.MailLocalServiceUtil;
import org.oep.core.service.ThamSoLocalServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;


public class MailServiceUtil {
	
private static Log log = LogFactoryUtil.getLog(MailServiceUtil.class.getName()); 
	
	public static String getGiaTriThamSo(String key){
		return ThamSoLocalServiceUtil.getValue(key, "");
	}
	
	public static String getMoTaThamSo(long groupId, String key){
		return ThamSoLocalServiceUtil.getValue(groupId, key)!=null?ThamSoLocalServiceUtil.getValue(groupId, key).getMoTa():"";
	}
	
	public static void sendMailThongBaoPheDuyetSai(String emailAddress, String hoTen, String username){
		try {
			String ScopeGroupId = ThamSoLocalServiceUtil.getValue("SCOPE_GROUP_ID", "20126");
			String subject = getGiaTriThamSo("MAIL_TEMPLATE_TB_PD_SAI");
			String body = getMoTaThamSo(Long.parseLong(ScopeGroupId), "MAIL_TEMPLATE_TB_PD_SAI");
			body = body.replace("[$tendangnhap$]", username);
			body = body.replace("[$email]", emailAddress);
			body = body.replace("[$ten]", hoTen);
			if(MailLocalServiceUtil.send(emailAddress, subject, body)){
				log.info("In ApiService gui mail thong bao thanh cong");
			}else {
				log.info("In ApiService gui mail thong bao that bai");
			}
			
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}
	
	public static void sendMailThongBaoPheDuyetDung(String emailAddress, String hoTen, String username){
		try {
			String ScopeGroupId = ThamSoLocalServiceUtil.getValue("SCOPE_GROUP_ID", "20126");
			String subject = getGiaTriThamSo("MAIL_TEMPLATE_TB_PD_DUNG");
			String body = getMoTaThamSo(Long.parseLong(ScopeGroupId), "MAIL_TEMPLATE_TB_PD_DUNG");
			body = body.replace("[$tendangnhap$]", username);
			body = body.replace("[$email]", emailAddress);
			body = body.replace("[$ten]", hoTen);
			if(MailLocalServiceUtil.send(emailAddress, subject, body)){
				log.info("In ApiService gui mail thong bao thanh cong");
			}else {
				log.info("In ApiService gui mail thong bao that bai");
			}
			
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}
	
	public static void sendMailThongBaoXacMinhSai(String emailAddress, String hoTen, String username){
		try {
			String ScopeGroupId = ThamSoLocalServiceUtil.getValue("SCOPE_GROUP_ID", "20126");
			String subject = getGiaTriThamSo("MAIL_TEMPLATE_TB_XM_SAI");
			String body = getMoTaThamSo(Long.parseLong(ScopeGroupId), "MAIL_TEMPLATE_TB_XM_SAI");
			body = body.replace("[$tendangnhap$]", username);
			body = body.replace("[$email]", emailAddress);
			body = body.replace("[$ten]", hoTen);
			if(MailLocalServiceUtil.send(emailAddress, subject, body)){
				log.info("In ApiService gui mail thong bao thanh cong");
			}else {
				log.info("In ApiService gui mail thong bao that bai");
			}
			
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

}
