package dtt.vn.user.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Random;

import javax.portlet.ActionRequest;

import org.oep.core.model.ThamSo;
import org.oep.core.service.MailLocalServiceUtil;
import org.oep.core.service.ThamSoLocalServiceUtil;

import com.google.gson.Gson;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Validator;

import dtt.vn.user.business.OtpServices;
import dtt.vn.user.common.utils.DateUtil;
import dtt.vn.user.model.DangKyCongDanModel;
import dtt.vn.user.model.DangKyToChucModel;
import dtt.vn.user.service.model.ThongTinDangKy;
import dtt.vn.user.service.service.ThongTinDangKyLocalServiceUtil;

import com.liferay.portal.kernel.theme.ThemeDisplay;

public class DangKyQuyTrinhUtil {
	private static Log log = LogFactoryUtil.getLog(DangKyQuyTrinhUtil.class.getName()); 
	
	public static String getGiaTriThamSo(String key){
		return ThamSoLocalServiceUtil.getValue(key, "");
	}
	public static String getHinhThucKichHoat(String key){
		return ThamSoLocalServiceUtil.getValue(key, "");
	}
	
	public static String getMoTaThamSo(long groupId, String key){
		return ThamSoLocalServiceUtil.getValue(groupId, key)!=null?ThamSoLocalServiceUtil.getValue(groupId, key).getMoTa():"";
	}
	
	public static ThamSo updateThamSo(long groupId, String maThamSo, Object giaTri) throws SystemException{
		ThamSo thamSo = ThamSoLocalServiceUtil.getValue(groupId, maThamSo);
		if(thamSo == null){
			
			thamSo = ThamSoLocalServiceUtil.createThamSo(CounterLocalServiceUtil.increment(ThamSo.class.getName()));
			thamSo.setTrangThai(true);
			thamSo.setQuyenTacDong(0);
			thamSo.setMa(maThamSo);
			thamSo.setLoaiId(1);
			thamSo.setGroupId(groupId);
		}
		thamSo.setGiaTri(String.valueOf(giaTri));
		return ThamSoLocalServiceUtil.updateThamSo(thamSo);
	}
	public static DangKyToChucModel getModelFromJsonNoiDungToChuc(String jsonNoiDung){
		Gson gson = new Gson();
		try{
			return gson.fromJson(jsonNoiDung, DangKyToChucModel.class);
		}catch(Exception e){
			log.error(e);
		}
		return null;
	}
	
	public static DangKyCongDanModel getModelFromJsonNoiDungCongDan(String jsonNoiDung){
		Gson gson = new Gson();
		try{
			return gson.fromJson(jsonNoiDung, DangKyCongDanModel.class);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getJsonNoiDungDangKyToChuc(DangKyToChucModel model){
		String json ="";
		
		try {
			Gson gson = new Gson();
			json = gson.toJson(model);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return json;
	}
	
	public static String getJsonNoiDungDangKyCongDan(DangKyCongDanModel model){
		String json ="";
		try {
			Gson gson = new Gson();
			json = gson.toJson(model);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return json;
	}
	public static String getMaKichHoat(){
		Random rnd = new Random();
		int n = 100000 + rnd.nextInt(900000);
		return DateUtil.parseDateToString(new Date(), "ddMMyyyyHHmmss") + n;
	}
	
	public static String getMd5Hash(String input){
		try {
			if(Validator.isNotNull(input)){
		        MessageDigest md = java.security.MessageDigest.getInstance("MD5");
		        byte[] array = md.digest(input.getBytes());
		        StringBuffer sb = new StringBuffer();
		        for (int i = 0; i < array.length; ++i) {
		          sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
		       }
		        return sb.toString();
			}else{
				return "";
			}
	    } catch (NoSuchAlgorithmException e) {
	    	e.printStackTrace();
	    }
	    return "";
	}
	
	public static void guiMailKichHoatDoanhNghiep(ActionRequest actionRequest, ThemeDisplay themeDisplay, String tenDoanhNghiep, String maSoKinhDoanh, 
			String emailAddress, String url){
		try{
			String subject = getGiaTriThamSo("MAIL_TEMPLATE_KH_TK_DN");
			String body = getMoTaThamSo(themeDisplay.getScopeGroupId(), "MAIL_TEMPLATE_KH_TK_DN");

			body = body.replace("[$url]", url);
			body = body.replace("[$ten]", tenDoanhNghiep);
			body = body.replace("[$maSoKinhDoanh]", maSoKinhDoanh);
			if(MailLocalServiceUtil.send(emailAddress, subject, body))
			{
				SessionMessages.add(actionRequest, "thongBaoTaoTaiKhoanDN");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void guiMailKichHoatCongDan(ActionRequest actionRequest, ThemeDisplay themeDisplay, String hoTen, 
			String emailAddress, String url){
		try{
			String subject = getGiaTriThamSo("MAIL_TEMPLATE_KH_TK_CD");
			String body = getMoTaThamSo(themeDisplay.getScopeGroupId(), "MAIL_TEMPLATE_KH_TK_CD");
			body = body.replace("[$url]", url);
			body = body.replace("[$ten]", hoTen);
			if(MailLocalServiceUtil.send(emailAddress, subject, body))
			{
				SessionMessages.add(actionRequest, "thongBaoTaoTaiKhoanCD");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	public static void guiMailThongBaoChoQuanTriHeThongDN(ActionRequest actionRequest, ThemeDisplay themeDisplay, 
			String tenDoanhNghiep, String maSoKinhDoanh, String emailAddress){
		try{
			String subject = getGiaTriThamSo("MAIL_TEMPLATE_TB_DK_TK_DN");
			String body = getMoTaThamSo(themeDisplay.getScopeGroupId(), "MAIL_TEMPLATE_TB_DK_TK_DN");
			body = body.replace("[$ten]", tenDoanhNghiep);
			body = body.replace("[$maSoKinhDoanh]", maSoKinhDoanh);
			body = body.replace("[$emailAddress]", emailAddress);
			String[] toAddress = getGiaTriThamSo("DANH_SACH_MAIL_THONG_BAO_DKTK").trim().split(",");
			MailLocalServiceUtil.send(toAddress, subject, body);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void guiMailThongBaoChoQuanTriHeThongCD(ActionRequest actionRequest, ThemeDisplay themeDisplay, 
			String hoTen, String emailAddress){
		try{
			String subject = getGiaTriThamSo("MAIL_TEMPLATE_TB_DK_TK_CD");
			String body = getMoTaThamSo(themeDisplay.getScopeGroupId(), "MAIL_TEMPLATE_TB_DK_TK_CD");
			body = body.replace("[$ten]", hoTen);
			body = body.replace("[$emailAddress]", emailAddress);
			String[] toAddress = getGiaTriThamSo("DANH_SACH_MAIL_THONG_BAO_DKTK").trim().split(",");
			MailLocalServiceUtil.send(toAddress, subject, body);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void guiMailCapTaiKhoanDN(ActionRequest actionRequest, ThemeDisplay themeDisplay, 
			String tenDoanhNghiep, String emailAddress, String password, String userName){
		try{
			String subject = getGiaTriThamSo("MAIL_DN_DANGKY");
			String body = getMoTaThamSo(themeDisplay.getScopeGroupId(), "MAIL_DN_DANGKY");
			body = body.replace("[$ten]", tenDoanhNghiep);
			body = body.replace("[$userName]", emailAddress);
			body = body.replace("[$email]", userName);
			body = body.replace("[$password]", password);
			MailLocalServiceUtil.send(emailAddress, subject, body);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void guiMailCapTaiKhoanCD(ActionRequest actionRequest, ThemeDisplay themeDisplay, 
			String hoTen, String emailAddress, String password, String userName){
		try{
			String subject = getGiaTriThamSo("MAIL_CD_DANGKY");
			String body = getMoTaThamSo(themeDisplay.getScopeGroupId(), "MAIL_CD_DANGKY");
			body = body.replace("[$ten]", hoTen);
			body = body.replace("[$userName]", emailAddress);
			body = body.replace("[$email]", userName);
			body = body.replace("[$password]", password);
			MailLocalServiceUtil.send(emailAddress, subject, body);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void guiLaiMSMOTP( String userName){
		OtpServices otp = new OtpServices();
		
		try {
			int otpCode = otp.generateOTP(userName);
			ThongTinDangKy ttdk = ThongTinDangKyLocalServiceUtil.getByUserName(userName);
			if(ttdk != null){
				ttdk.setMaKichHoat(String.valueOf(otpCode));
				ThongTinDangKyLocalServiceUtil.updateThongTinDangKy(ttdk);
				log.info("In DangKyQuyTrinhUtil.guilaiOTP cap nhat otp thanh cong");
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}
}
