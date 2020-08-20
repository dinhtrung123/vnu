package dtt.vn.user.service.service.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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
	public static String createRandomPassword() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 9) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

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
	
	public static boolean guiMailKichHoatDoanhNghiep(String tenDoanhNghiep, String maSoKinhDoanh, 
			String emailAddress, String url){
		try{
			String subject = getGiaTriThamSo("MAIL_TEMPLATE_KH_TK_DN");
			String body = getMoTaThamSo(20126, "MAIL_TEMPLATE_KH_TK_DN");

			body = body.replace("[$url]", url);
			body = body.replace("[$ten]", tenDoanhNghiep);
			body = body.replace("[$maSoKinhDoanh]", maSoKinhDoanh);
			if(MailLocalServiceUtil.send(emailAddress, subject, body))
			{
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return false;
	}
	public static boolean guiMailKichHoatCongDan(String hoTen, 
			String emailAddress, String url){
		try{
			String subject = getGiaTriThamSo("MAIL_TEMPLATE_KH_TK_CD");
			String body = getMoTaThamSo(20126, "MAIL_TEMPLATE_KH_TK_CD");
			body = body.replace("[$url]", url);
			body = body.replace("[$ten]", hoTen);
			if(MailLocalServiceUtil.send(emailAddress, subject, body))
			{
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	public static void guiMailThongBaoChoQuanTriHeThongDN( ThemeDisplay themeDisplay, 
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
	
	public static void guiMailThongBaoChoQuanTriHeThongCD(ThemeDisplay themeDisplay, 
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
	
	public static void guiMailCapTaiKhoanDN(ThemeDisplay themeDisplay, 
			String tenDoanhNghiep, String emailAddress, String password){
		try{
			String subject = getGiaTriThamSo("MAIL_DN_DANGKY");
			String body = getMoTaThamSo(themeDisplay.getScopeGroupId(), "MAIL_DN_DANGKY");
			body = body.replace("[$ten]", tenDoanhNghiep);
			body = body.replace("[$userName]", emailAddress);
			body = body.replace("[$password]", password);
			MailLocalServiceUtil.send(emailAddress, subject, body);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void guiMailCapTaiKhoanCD(ThemeDisplay themeDisplay, 
			String hoTen, String emailAddress, String password){
		try{
			String subject = getGiaTriThamSo("MAIL_CD_DANGKY");
			String body = getMoTaThamSo(themeDisplay.getScopeGroupId(), "MAIL_CD_DANGKY");
			body = body.replace("[$ten]", hoTen);
			body = body.replace("[$userName]", emailAddress);
			body = body.replace("[$password]", password);
			MailLocalServiceUtil.send(emailAddress, subject, body);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/* Kiem tra tinh hop le dia chi email */
	public static boolean validateEmailAddress(String email) {
		boolean result = false;
		
		String regex = "\\b[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}\\b";

		Pattern pattern = Pattern.compile(regex);

		Matcher matcher = pattern.matcher(email);

		if (matcher.matches()) {
			result = true;
		}
		return result;

	}
	
	/* Kiem tra tinh hop le so dien thoai */
	public static boolean validateNumberPhone(String numberPhone) {
		boolean result = false;
		 if (numberPhone.length() < 20) {
           String strPattern = "[^0-9]";
           Pattern p;
           Matcher m;
           int flag = Pattern.CASE_INSENSITIVE;
           p = Pattern.compile(strPattern, flag);
           m = p.matcher(numberPhone);
           result = !m.find();
	            
	      }
		return result;
	}
	
	
	/* Kiem tra tinh hop le number */
	public static boolean validateNumber(String String) {
		boolean result = false;
		
       String strPattern = "[^0-9]";
       Pattern p;
       Matcher m;
       int flag = Pattern.CASE_INSENSITIVE;
       p = Pattern.compile(strPattern, flag);
       m = p.matcher(String);
       result = !m.find();
	           
		return result;
	}
	
	/* Kiem tra tinh hop le số Hộ chiếu */
	public static boolean validateHoChieu(String hoChieu) {
       boolean check = false;
		if (hoChieu.length() == 8) {
           String strPattern = "[^A-Z]+[0-9]";
           Pattern p = Pattern.compile(strPattern);
           Matcher m = p.matcher(hoChieu);
           check = m.find();
       }
       return check;
           
           
   }

	
	/* Kiem tra tinh hop le so CMND */
	public static boolean validateSoCMND(String cmnd) {
		boolean result = false;
		 if (cmnd.length() == 9 || cmnd.length() == 12) {
           String strPattern = "[^0-9]";
           Pattern p;
           Matcher m;
           int flag = Pattern.CASE_INSENSITIVE;
           p = Pattern.compile(strPattern, flag);
           m = p.matcher(cmnd);
           result = !m.find();
	            
	      }
		return result;
	}
	
	/* Kiem tra tinh hop le ngay cap CMND */
	public static boolean checkDateNow(String dateString) {
		boolean result = false;
		Date dateNow = new Date();
		
		Date date = DateUtil.parseStringToDate(dateString, DateUtil.DATE_FORMAT_D_M_Y);
		
		if(date != null && date.before(dateNow)) {
			result = true;
		}
		
		return result;
	}
}
