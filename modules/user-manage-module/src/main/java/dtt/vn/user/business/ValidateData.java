package dtt.vn.user.business;

import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.servlet.SessionErrors;

import dtt.vn.user.common.utils.DateUtil;
import dtt.vn.user.keys.DangKyTaiKhoanKeys;
import dtt.vn.vnpost.service.AccountLocalServiceUtil;

public class ValidateData {
	
	/* Kiem tra tinh hop le ho ten */
	 public static boolean validateName(String name) {
		 boolean result = false;
		 if(name.length() < 200) {
	        String strPattern = "^[\\p{L} .'-]+$";
	        Pattern p;
	        Matcher m;
	        int flag = Pattern.CASE_INSENSITIVE;
	        p = Pattern.compile(strPattern, flag);
	        m = p.matcher(name);
	        result = m.find();
		 }
		 return result;
	    }
	
	
	 
	/* Kiem tra tinh hop le dia chi email */
	public static boolean validateEmailAddress(String email) {
		boolean result = false;
		
		String regex = "\\b[a-zA-Z0-9._-]+@[a-z0-9.-]+\\.[a-z]{2,4}\\b";

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
	
/*Kiem tra tinh hop le cap nhat mat khau*/ 
	private static boolean validateusernameformatDuyenDTT(String username) {
		try {
			String FRIST_PATTERN = 
	                "^[-a-zA-Z0-9._]+";
			String AFTER_PATTERN = 
	                "^[-a-zA-Z0-9.]+";
			String[] arraystr = username.split("@");
			if(arraystr.length == 2) {
				if(Pattern.matches(FRIST_PATTERN, arraystr[0]) && Pattern.matches(AFTER_PATTERN, arraystr[1])) {
					return true;
				}
			}else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	public static boolean validateForm( String password_new, String password_confirm,String email,String userName ,String hoTen, String gioitinhId, 
			String ngaySinh, String cmnd, String dienThoai, String tinhThanh, String quanHuyen, String phuongXa, String diaChi, String hinhthucKH,
			String xacThucDYT, ActionRequest request, ActionResponse response){
		boolean result = true;
		
		if(hinhthucKH.equals("") && xacThucDYT.equals("XTSMSOTP")){
			if(email.equals("") && dienThoai.equals("")) {
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.ORG_OEP_USER_DANGKY_EMPTY_EMAIL);
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EMPTY_DIENTHOAI);
				result = false;
			} else if(!email.equals("") && dienThoai.equals("")) {
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EMPTY_DIENTHOAI_SMSOTP);
				result = false;
			} else if(email.equals("") && !dienThoai.equals("")) {
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.ORG_OEP_USER_DANGKY_EMPTY_EMAIL);
				result = false;
			}
			SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_ACTIVEMETHOD_EMPTY);
			result = false;
		} else if(hinhthucKH.equals("") && !xacThucDYT.equals("XTSMSOTP")) {
			if(email.equals("") && dienThoai.equals("")) {
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.ORG_OEP_USER_DANGKY_EMPTY_EMAIL);
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EMPTY_DIENTHOAI);
				result = false;
			} else if(email.equals("") && !dienThoai.equals("")) {
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.ORG_OEP_USER_DANGKY_EMPTY_EMAIL);
				result = false;
			}
			SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_ACTIVEMETHOD_EMPTY);
			result = false;
		}
		
		if(hinhthucKH.equals("215029") && xacThucDYT.equals("XTSMSOTP")) {
			if(email.equals("") && dienThoai.equals("")) {
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.ORG_OEP_USER_DANGKY_EMPTY_EMAIL);
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EMPTY_DIENTHOAI);
				result = false;
			} else if(!email.equals("") && dienThoai.equals("")) {
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EMPTY_DIENTHOAI_SMSOTP);
				result = false;
			} else if(email.equals("") && !dienThoai.equals("")) {
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.ORG_OEP_USER_DANGKY_EMPTY_EMAIL_KH);
				result = false;
			}
		} else if(hinhthucKH.equals("215029") && !xacThucDYT.equals("XTSMSOTP")) {
			if(email.equals("") && dienThoai.equals("")) {
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.ORG_OEP_USER_DANGKY_EMPTY_EMAIL);
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EMPTY_DIENTHOAI);
				result = false;
			} else if(email.equals("") && !dienThoai.equals("")) {
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.ORG_OEP_USER_DANGKY_EMPTY_EMAIL_KH);
				result = false;
			}
		}
		
		if(hinhthucKH.equals("215030") && xacThucDYT.equals("XTSMSOTP")) {
			if(email.equals("") && dienThoai.equals("")) {
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.ORG_OEP_USER_DANGKY_EMPTY_EMAIL);
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EMPTY_DIENTHOAI);
				result = false;
			} else if(!email.equals("") && dienThoai.equals("")) {
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EMPTY_DIENTHOAI_SMSOTP_OTPSMS);
				result = false;
			} else if(email.equals("") && !dienThoai.equals("")) {
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.ORG_OEP_USER_DANGKY_EMPTY_EMAIL);
				result = false;
			}
		} else if(hinhthucKH.equals("215030") && !xacThucDYT.equals("XTSMSOTP")) {
			if(email.equals("") && dienThoai.equals("")) {
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.ORG_OEP_USER_DANGKY_EMPTY_EMAIL);
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EMPTY_DIENTHOAI);
				result = false;
			} else if(!email.equals("") && dienThoai.equals("")) {
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EMPTY_DIENTHOAI_OTPSMS);
				result = false;
			} else if(email.equals("") && !dienThoai.equals("")) {
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.ORG_OEP_USER_DANGKY_EMPTY_EMAIL);
				result = false;
			}
		}
		
		if(password_new.equals("")){
			SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EMPTY_PWD);
			result = false;
		} else if(password_new.length() < 8){
			SessionErrors.add(request, DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_SHORT_PWD);
			result = false;
		} 
		
		if(password_confirm.equals("")){
			SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EMPTY_PWD_CONFIRM);
			result = false;
		} else if(!password_new.equals(password_confirm)){
			SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_NOT_DUPLICATE_PWD);
			result = false;
		}
		
		if(!email.equals("")) {
			if(validateEmailAddress(email) == false){
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_INVALID_EMAIL);
				result = false;
			} else {
				if(AccountLocalServiceUtil.isEmailExists(email)==true){
					SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EXISTS_EMAIL);
					result = false;
				}
			}
		}
		
		if(!dienThoai.equals("")){
			if(validateNumberPhone(dienThoai)== false){
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_INVALID_DIENTHOAI);
				result = false;
			}else {
				if(!AccountLocalServiceUtil.isphoneExists(dienThoai)) {
					SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EXISTS_DIENTHOAI);
					result = false;
				}
			}
		}
		
		if(userName.equals("")){
			SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EMPTY_USERNAME);
			result = false;
		}else{
			if(!validateEmailAddress(userName)) {
				Pattern p = Pattern.compile("[^A-Za-z0-9._]", Pattern.CASE_INSENSITIVE);
				Matcher m = p.matcher(userName);
				boolean b = m.find();
				if(b){
					SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_INVALID_USERNAME);
					result = false;
			         }
				else if(AccountLocalServiceUtil.isAccountNameExists(userName)){
					SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EXISTS_USERNAME);
					result = false;
				}
			} else {
				if(AccountLocalServiceUtil.isAccountNameExists(userName)){
					SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EXISTS_USERNAME);
					result = false;
				}
			}
		}
		
		if(hoTen.equals("")){
			SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EMPTY_HOTEN);
			result = false;
		} else if(!hoTen.equals("")){
			if(validateName(hoTen)==false){
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_INVALID_HOTEN);
				result = false;
			}
		}
		if(gioitinhId.equals("")){
			SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EMPTY_GIOITINH);
			result = false;
		}
		if(ngaySinh.equals("")){
			SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EMPTY_NGAYSINH);
			result = false;
		}else {
				boolean nsPar = DateUtil.isValidFormat( DateUtil.DATE_FORMAT_D_M_Y,ngaySinh,Locale.ENGLISH);
				if(!nsPar) {
					SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_INVALID_NGAYSINH);
					result = false;
				}
		
		}
		if(cmnd.equals("")){
			SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EMPTY_CMND);
			result = false;
		}else {
			if(cmnd.length()<9){
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_INVALID_CMND);
				result = false;
			}else {
				Pattern p = Pattern.compile("[^A-Za-z0-9]", Pattern.CASE_INSENSITIVE);
				Matcher m = p.matcher(cmnd);
				boolean b = m.find();
				if(b){
					SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_INVALID_CMND);
					result = false;
				}else if(AccountLocalServiceUtil.isAccountNameExists(userName)){
					SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_USERNAME_EXISTS);
					result = false;
				}
			} 
		}
		
		if(tinhThanh.equals("0")){
			SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EMPTY_TINH);
			result = false;
		}
		if(quanHuyen.equals("0")){
			SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EMPTY_QUANHUYEN);
			result = false;
		}
		if(phuongXa.equals("0")){
			SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EMPTY_PHUONGXA);
			result = false;
		}
		if(diaChi.equals("")){
			SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_EMPTY_DIACHI);
			result = false;
		}

		return result;
	}
	
	public static boolean validateForm_ToChuc(String matkhau, String matkhauConfirm, String email, String userName ,
			String tenToChuc, String dienThoai, String mst, String nguoidaidien, String tinh, String huyen, String phuongXa, 
			String cmnd, String diaChi,String hinhThucKH, String xacThucDYT,
			ActionRequest request, ActionResponse response){
		boolean result = true;
		
		if(hinhThucKH.equals("") && xacThucDYT.equals("XTSMSOTP")){
			if(email.equals("") && dienThoai.equals("")) {
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_EMAIL_EMPTY);
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_SDT_EMPTY);
				result = false;
			} else if(!email.equals("") && dienThoai.equals("")) {
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_SDT_EMPTY_SMSOTP);
				result = false;
			} else if(email.equals("") && !dienThoai.equals("")) {
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_EMAIL_EMPTY);
				result = false;
			}
			SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_ACTIVEMETHOD_EMPTY);
			result = false;
		} else if(hinhThucKH.equals("") && !xacThucDYT.equals("XTSMSOTP")) {
			if(email.equals("") && dienThoai.equals("")) {
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_EMAIL_EMPTY);
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_SDT_EMPTY);
				result = false;
			} else if(email.equals("") && !dienThoai.equals("")) {
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_EMAIL_EMPTY);
				result = false;
			}
			SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_ACTIVEMETHOD_EMPTY);
			result = false;
		}
		
		if(hinhThucKH.equals("215029") && xacThucDYT.equals("XTSMSOTP")) {
			if(email.equals("") && dienThoai.equals("")) {
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_EMAIL_EMPTY);;
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_SDT_EMPTY);
				result = false;
			} else if(!email.equals("") && dienThoai.equals("")) {
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_SDT_EMPTY_SMSOTP);
				result = false;
			} else if(email.equals("") && !dienThoai.equals("")) {
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_EMAIL_EMPTY_KH);
				result = false;
			}
		} else if(hinhThucKH.equals("215029") && !xacThucDYT.equals("XTSMSOTP")) {
			if(email.equals("") && dienThoai.equals("")) {
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_EMAIL_EMPTY);;
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_SDT_EMPTY);
				result = false;
			} else if(email.equals("") && !dienThoai.equals("")) {
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_EMAIL_EMPTY_KH);
				result = false;
			}
		}
		
		if(hinhThucKH.equals("215030") && xacThucDYT.equals("XTSMSOTP")) {
			if(email.equals("") && dienThoai.equals("")) {
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_EMAIL_EMPTY);
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_SDT_EMPTY);
				result = false;
			} else if(!email.equals("") && dienThoai.equals("")) {
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_SDT_EMPTY_SMSOTP_OTPSMS);
				result = false;
			} else if(email.equals("") && !dienThoai.equals("")) {
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_EMAIL_EMPTY);
				result = false;
			}
		} else if(hinhThucKH.equals("215030") && !xacThucDYT.equals("XTSMSOTP")) {
			if(email.equals("") && dienThoai.equals("")) {
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_EMAIL_EMPTY);
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_SDT_EMPTY);
				result = false;
			} else if(!email.equals("") && dienThoai.equals("")) {
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_SDT_EMPTY_OTPSMS);
				result = false;
			} else if(email.equals("") && !dienThoai.equals("")) {
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_EMAIL_EMPTY);
				result = false;
			}
		}
		// cu
		/*if(hinhThucKH.equals("")){
			if(email.equals("") && dienThoai.equals("")) {
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_EMAIL_EMPTY);
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_SDT_EMPTY);
				result = false;
			}
			SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_ACTIVEMETHOD_EMPTY);
			result = false;
		}
		
		if(hinhThucKH.equals("215029") && xacThucDYT.equals("XTSMSOTP")) {
			if(email.equals("") && dienThoai.equals("")) {
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_EMAIL_EMPTY);
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_SDT_EMPTY);
				result = false;
			} else if(!email.equals("") && dienThoai.equals("")) {
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_SDT_EMPTY_SMSOTP);
				result = false;
			} else if(email.equals("") && !dienThoai.equals("")) {
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_EMAIL_EMPTY_KH);
				result = false;
			}
		} else if(hinhThucKH.equals("215029") && !xacThucDYT.equals("XTSMSOTP")) {
			if(email.equals("") && dienThoai.equals("")) {
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_EMAIL_EMPTY);
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_SDT_EMPTY);
				result = false;
			} else if(email.equals("") && !dienThoai.equals("")) {
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_EMAIL_EMPTY_KH);
				result = false;
			}
		}
		
		if(hinhThucKH.equals("215030") && xacThucDYT.equals("XTSMSOTP")) {
			if(email.equals("") && dienThoai.equals("")) {
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_EMAIL_EMPTY);
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_SDT_EMPTY);
				result = false;
			} else if(!email.equals("") && dienThoai.equals("")) {
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_SDT_EMPTY_SMSOTP_OTPSMS);
				result = false;
			}
		} else if(hinhThucKH.equals("215030") && !xacThucDYT.equals("XTSMSOTP")) {
			if(email.equals("") && dienThoai.equals("")) {
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_EMAIL_EMPTY);
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_SDT_EMPTY);
				result = false;
			} else if(!email.equals("") && dienThoai.equals("")) {
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_SDT_EMPTY_OTPSMS);
				result = false;
			}
		}*/
		if(matkhau.equals("")){
			SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_EMPTY_PWD);
			result = false;
		} else if(matkhau.length() < 8){
			SessionErrors.add(request, DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_SHORT_PWD);
			result = false;
		} 
		
		if(matkhauConfirm.equals("")){
			SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_EMPTY_PWD_CONFIRM);
			result = false;
		} else if(!matkhau.equals(matkhauConfirm)){
			SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_NOT_DUPLICATE_PWD);
			result = false;
		}
		
		if(email.equals("")){
			if(dienThoai.equals("")){
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_EMAIL_EMPTY);
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_SDT_EMPTY);
				result = false;
			}
		}else if(!email.equals("")) {
			if(validateEmailAddress(email) == false){
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_EMAIL_INVALID);
				result = false;
			} else {
				if(AccountLocalServiceUtil.isEmailExists(email)==true){
					SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_EMAIL_EXISTS);
					result = false;
				}
			}
		}
		
		if(!dienThoai.equals("")){
			if(validateNumberPhone(dienThoai)== false){
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_SDT_INVALID);
				result = false;
			}else {
				if(!AccountLocalServiceUtil.isphoneExists(dienThoai)) {
					SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_EXISTS_DIENTHOAI);
					result = false;
				}
			}
		}
		
		if(userName.equals("")){
			SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_USERNAME_EMPTY);
			result = false;
		}else{
			if(!validateEmailAddress(userName)) {
				Pattern p = Pattern.compile("[^A-Za-z0-9._]", Pattern.CASE_INSENSITIVE);
				Matcher m = p.matcher(userName);
				boolean b = m.find();
				if(b){
					SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_USERNAME_INVALID);
					result = false;
			         }
				else if(AccountLocalServiceUtil.isAccountNameExists(userName)){
					SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_USERNAME_EXISTS);
					result = false;
				}
			} else {
				if(AccountLocalServiceUtil.isAccountNameExists(userName)){
					SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_USERNAME_EXISTS);
					result = false;
				}
			}
		}
		
		if(tenToChuc.equals("")){
			SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_TEN_TOCHUC_EMPTY);
			result = false;
		} else if(!tenToChuc.equals("")){
			if(validateName(tenToChuc)==false){
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_TEN_TOCHUC_INVALID);
				result = false;
			}
		}
		if(nguoidaidien.equals("")){
			SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_NGUOIDAIDIEN_EMPTY);
			result = false;
		} else if(!nguoidaidien.equals("")){
			if(validateName(nguoidaidien)==false){
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_NGUOIDAIDIEN_INVALID);
				result = false;
			}
		}
		if(cmnd.equals("")){
			SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_CMND_EMPTY);
			result = false;
		}else {
			if(cmnd.length()<9){
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_CMND_INVALID);
				result = false;
			}else {
				if(AccountLocalServiceUtil.ispersonalIdExists(cmnd)==true){
					SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_EXISTS_CMND);
					result = false;
				}
			}
		}
		
		
		if(tinh.equals("0")){
			SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_TINH_EMPTY);
			result = false;
		}
		if(huyen.equals("0")){
			SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_QUANHUYEN_EMPTY);
			result = false;
		}
		if(phuongXa.equals("0")){
			SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_PHUONGXA_EMPTY);
			result = false;
		}
		if(diaChi.equals("")){
			SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_DIACHI_EMPTY);
			result = false;
		}
		if(mst.equals("")){
			SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_MST_EMPTY);
			result = false;
		}else {
			if(!AccountLocalServiceUtil.ismstExists(mst)) {
				SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_MST_EXISTS);
				result = false;
			}
		}

		return result;
		
	}
	
}