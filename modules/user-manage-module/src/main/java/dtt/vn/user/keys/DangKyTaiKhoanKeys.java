
package dtt.vn.user.keys;

public class DangKyTaiKhoanKeys {
	
	public class Base {
		
		public static final int DOITUONG_SUDUNG_CONGDAN = 1;
		public static final int DOITUONG_SUDUNG_TOCHUC = 2;
		
		public static final String Section_ToChuc ="dtt.vn.user.dangky.secsion.tochuc";
		public static final String TAB = "tab";
		public static final String ENTERED_CAPTCHA_TEXT = "captchaText";
		public static final String CAPTCHA_TEXT = "CAPTCHA_TEXT";
		
		
		public static final String COMPANY_ID = "companyId";
		
		public static final String AUTH_TYPE_EA = "emailAddress";
		public static final String AUTH_TYPE_ID = "userId";
		public static final String AUTH_TYPE_SN = "screenName";
		
		//Tham so cho dang ky quy trinh doanh nghiep
		public static final String THONG_BAO_TAO_TAI_KHOAN_DN = "THONG_BAO_TAO_TAI_KHOAN_DN";
		public static final String TB_KH_TK_THANHCONG_1_DN = "TB_KH_TK_THANHCONG_1_DN";
		public static final String TB_KH_TK_THANHCONG_2_DN = "TB_KH_TK_THANHCONG_2_DN";
		public static final String TB_DA_KICH_HOAT_DN = "TB_DA_KICH_HOAT_DN";
		
		public static final String THONG_BAO_GUILAI_MAKH_DN = "THONG_BAO_GUILAI_MAKH_DN";
		public static final String THONG_BAO_GUILAI_MAKH_CD = "THONG_BAO_GUILAI_MAKH_CD";
		
		//Tham so cho dang ky quy trinh cong dan
		public static final String THONG_BAO_TAO_TAI_KHOAN_CD = "THONG_BAO_TAO_TAI_KHOAN_CD";
		public static final String TB_KH_TK_THANHCONG_1_CD = "TB_KH_TK_THANHCONG_1_CD";
		public static final String TB_KH_TK_THANHCONG_2_CD = "TB_KH_TK_THANHCONG_2_CD";
		public static final String TB_DA_KICH_HOAT_CD = "TB_DA_KICH_HOAT_CD";
		public static final String THONG_BAO_KICHHOAT_OTP_CD ="THONG_BAO_KICHHOAT_OTP_CD";
		
		public static final String THAMSO_TINH_DEFAULT_ID = "THAMSO_TINH_DEFAULT_ID";
	}
	
	public class ConfigKeys{
		public static final String CHO_PHEP_TAO_TAI_KHOAN = "CHO_PHEP_TAO_TAI_KHOAN";
		public static final String LH_DK_CONGDAN = "LH_DK_CONGDAN";
		public static final String LH_DK_TOCHUC = "LH_DK_TOCHUC";
		public static final String LH_DK_DOANHNGHIEP = "LH_DK_DOANHNGHIEP";
		public static final String ROLE_DEFAULT_CD = "ROLE_DEFAULT_CD";
		public static final String ROLE_DEFAULT_DN = "ROLE_DEFAULT_DN";
		public static final String YC_XACNHAN_KH_TK = "YC_XAC_NHAN_KH_TK";
		public static final String YC_DOI_MK_LAN_DAU = "YC_DOI_MK_LAN_DAU";
		public static final String NHOM_DOI_TUONG_SU_DUNG = "nhomDoiTuongSuDung";
		public static final String DOI_TUONG_SU_DUNG = "doiTuongSuDung";
	}
	public class Tabs{
		public static final int DOANH_NGHIEP = 0;
		public static final int CONG_DAN = 1;
		public static final int TOCHUC = 2;
		public static final String CongDan_Tab ="taikhoan.per";
		public static final String ToChuc_Tab ="taikhoan.or";
		public static final String CapNhat_Tab = "capnhat";
		public static final String MatKhau_Tab = "doimatkhau";
		public static final String XacThuc_Tab = "trinhxacthuc";
	}
	
	public class DangKyCongDan{
		public static final String EMAIL = "email";
		public static final String HO_TEN = "hoTen";
		public static final String TINH_THANH = "tinhThanhId";
		public static final String TINH_THANH_CONG_DAN = "tinhThanhIdCd";
		public static final String QUAN_HUYEN = "quanHuyenId";
		public static final String QUAN_HUYEN_CONG_DAN = "quanHuyenIdCd";
		public static final String PHUONG_XA = "phuongXaId";
		public static final String PHUONG_XA_CONG_DAN = "phuongXaIdCd";
		public static final String TINH_THANH_THUONG_TRU = "tinhThanhTR";
		public static final String QUAN_HUYEN_THUONG_TRU = "quanHuyenTR";
		public static final String PHUONG_XA_THUONG_TRU = "phuongXaTR";
		public static final String TINH_THANH_HIEN_TAI = "tinhThanhHT";
		public static final String QUAN_HUYEN_HIEN_TAI = "quanHuyenHT";
		public static final String PHUONG_XA_HIEN_TAI = "phuongXaHT";
		public static final String TINH_THANH_XAC_MINH = "tinhThanhXM";
		public static final String QUAN_HUYEN_XAC_MINH = "quanHuyenXM";
		public static final String PHUONG_XA_XAC_MINH = "phuongXaXM";
		public static final String SO_CMND = "soCMND";
		public static final String NGAYCAP_CMND = "ngayCapCMND";
		public static final String NOICAP_CMND = "noiCapCMND";
		public static final String FILE_CMND = "fileCMND";
		public static final String FILE_CMND_LBL = "fileCMNDLbl";
		public static final String MA_KICHHOAT = "maKichHoat";
		public static final String KICHHOAT_URL = "kichHoatUrl";
		public static final String MA_XACNHAN = "maXacNhan";
		public static final String NGAY_SINH = "ngaySinh";
		public static final String QUOC_TICH_KHAI_SINH = "quocTichId";
		public static final String QUOC_TICH_THUONG_TRU = "quocTichId";
		public static final String QUOC_TICH_HIEN_TAI = "quocTichId";
		public static final String GIOI_TINH = "gioiTinhId";
		public static final String DIACHI_CHITIET = "diaChiChiTiet";
		public static final String USER_NAME = "userName";
		public static final String DIEN_THOAI = "dienThoaiId";
		public static final String MAT_KHAU = "matKhau";
		public static final String MAT_KHAU_CONFIRM = "matKhauConfirm";
		public static final String KichHoat_TaiKhoan_SDT ="kichHoatQuaSDT";
		public static final String KichHoat_TaiKhoan_Email ="kichHoatQuaEmail";
		public static final String hinhThucKichHoat="hinhThucKichHoat";
		public static final String HinhThuc_XacThuc_DaYeuTo = "hinhThucXacThuc";
		public static final String OTP_KichHoat = "otpKichHoat";
		public static final String XT_DAYEUTO_TYPE = "xtdayeutotype";
		
		public static final int OTP_kichHoat_MAX_LENGTH = 10;
		public static final int EMAIL_MAX_LENGTH = 250;
		public static final int HO_TEN_MAX_LENGTH = 500;
		public static final int SOCMND_MAX_LENGTH = 300;
		public static final int DIACHI_CHITIET_MAX_LENGTH = 500;
		public static final int MA_XACNHAN_MAX_LENGTH = 10;
		public static final int DIEN_THOAI_MAX_LENGTH = 20;
		public static final int USER_NAME_MAXLENGTH = 80;
	}
	
	public class DangKyToChuc {
		public static final String USER_NAME = "userName_TC";
		public static final String TINH_THANH = "tinhThanh_TCId";
		public static final String QUAN_HUYEN = "quanHuyen_TCId";
		public static final String PHUONG_XA = "phuongXa_TCId";
		public static final String DIACHI_CHITIET = "diaChiChiTiet_TC";
		public static final String EMAIL = "email_TC";
		public static final String DIEN_THOAI = "soDienThoai_TC";
		public static final String MAT_KHAU = "matKhau_TC";
		public static final String MAT_KHAU_CONFIRM = "matKhauConfirm_TC";
		public static final String TEN_TO_CHUC = "tenToChuc_TC";
		public static final String MA_SO_THUE = "maSoThue_TC";
		public static final String NGUOI_DAI_DIEN = "nguoiDaiDien_TC";
		public static final String SO_CMND = "soCMND_TC";
		public static final String MA_XACNHAN = "maXacNhan_TC";
		public static final String hinhThucKichHoatTC="hinhThucKichHoat_tc";
		public static final String MA_KICHHOAT = "maKichHoat";
		public static final String KICHHOAT_URL = "kichHoatUrl";
		public static final String HinhThuc_XacThuc_DaYeuToTC = "hinhThucXacThucTC";
		public static final String OTP_KichHoatTC = "otpKichHoatTC";
		public static final String XT_DAYEUTO_TYPETC ="xtdayeutotypetc";
		
		public static final int MA_XACNHAN_MAX_LENGTH = 10;
		public static final int DIACHI_CHITIET_MAX_LENGTH = 500;
		public static final int USER_NAME_MAXLENGTH = 80;
	}
	
	
	public static class ErrorMessageKeys {
		
		
		public static final String DTT_VN_USER_DANGKY_CONGDAN_ACTIVEMETHOD_EMPTY ="dtt.vn.user.dangky.congdan.error.activetype.empty";
		public static final String DTT_VN_USER_DANGKY_TOCHUC_ACTIVEMETHOD_EMPTY = "dtt.vn.user.dangky.tochuc.error.activetype.empty";
		
		public static final String ORG_OEP_USER_DANGKY_EMPTY_PASSWORD_OLD = "org.oep.user.portlet.updatepasssworduser.message.empty.password.old";
		public static final String ORG_OEP_USER_DANGKY_EMPTY_PASSWORD_NEW = "org.oep.user.portlet.updatepasssworduser.message.empty.password.new";
		public static final String ORG_OEP_USER_DANGKY_VALIDATE_PASSWORD_NEW = "org.oep.user.portlet.updatepasssworduser.message.validate.password.new";
		public static final String ORG_OEP_USER_DANGKY_EMPTY_PASSWORD_CONFIRM = "org.oep.user.portlet.updatepasssworduser.message.empty.password.confirm";
		public static final String ORG_OEP_USER_DANGKY_PASSWORD_NEW_NOT_DUPLICATE_PASSWORD_CONFIRM = "org.oep.user.portlet.updatepasssworduser.message.empty.password.confirm.not.duplicate";
		
		
		public static final String DTT_VN_USER_DANGKY_CONGDAN_EMPTY_PWD = "dtt.vn.user.dangky.congdan.error.pwd.empty";
		public static final String DTT_VN_USER_DANGKY_CONGDAN_SHORT_PWD = "dtt.vn.user.dangky.congdan.error.pwd.short";
		public static final String DTT_VN_USER_DANGKY_CONGDAN_EMPTY_PWD_CONFIRM = "dtt.vn.user.dangky.congdan.error.pwd.confirm.empty";
		public static final String DTT_VN_USER_DANGKY_CONGDAN_INVALID_PWD = "dtt.vn.user.dangky.congdan.error.pwd.invalid";
		public static final String DTT_VN_USER_DANGKY_CONGDAN_NOT_DUPLICATE_PWD = "dtt.vn.user.dangky.congdan.error.pwd.not.duplicate";
		
		public static final String DTT_VN_USER_DANGKY_TOCHUC_EMPTY_PWD = "dtt.vn.user.dangky.tochuc.error.password.empty";
		public static final String DTT_VN_USER_DANGKY_TOCHUC_SHORT_PWD = "dtt.vn.user.dangky.congdan.error.pwd.short";
		public static final String DTT_VN_USER_DANGKY_TOCHUC_EMPTY_PWD_CONFIRM = "dtt.vn.user.dangky.tochuc.error.password.confirm.empty";
		public static final String DTT_VN_USER_DANGKY_TOCHUC_INVALID_PWD = "dtt.vn.user.dangky.tochuc.error.password.invalid";
		public static final String DTT_VN_USER_DANGKY_TOCHUC_NOT_DUPLICATE_PWD = "dtt.vn.user.dangky.tochuc.error.password.confirm.not.duplicate";
		
		public static final String ORG_OEP_USER_DANGKY_EMPTY_EMAIL = "dtt.vn.user.dangky.congdan.error.empty.email";
		public static final String DTT_VN_USER_DANGKY_CONGDAN_EXISTS_EMAIL = "dtt.vn.user.dangky.congdan.error.exists.email";
		public static final String DTT_VN_USER_DANGKY_CONGDAN_INVALID_EMAIL = "dtt.vn.user.dangky.congdan.error.email";
		public static final String DTT_VN_USER_DANGKY_CONGDAN_EMPTY_USERNAME = "dtt.vn.user.dangky.congdan.error.username.empty";
		public static final String DTT_VN_USER_DANGKY_CONGDAN_EXISTS_USERNAME = "dtt.vn.user.dangky.congdan.error.username.exists";
		public static final String DTT_VN_USER_DANGKY_CONGDAN_EMPTY_HOTEN ="dtt.vn.user.dangky.congdan.error.hoten.empty";
		public static final String DTT_VN_USER_DANGKY_CONGDAN_EMPTY_GIOITINH ="dtt.vn.user.dangky.congdan.error.gioitinh.empty";
		public static final String DTT_VN_USER_DANGKY_CONGDAN_EMPTY_NGAYSINH ="dtt.vn.user.dangky.congdan.error.ngaysinh";
		public static final String DTT_VN_USER_DANGKY_CONGDAN_INVALID_NGAYSINH ="dtt.vn.user.dangky.congdan.invalid.ngaysinh";
		public static final String DTT_VN_USER_DANGKY_CONGDAN_EMPTY_CMND ="dtt.vn.user.dangky.congdan.error.cmnd.empty";
		public static final String DTT_VN_USER_DANGKY_CONGDAN_EXISTS_CMND ="dtt.vn.user.dangky.congdan.error.cmnd.exists";
		public static final String DTT_VN_USER_DANGKY_CONGDAN_EMPTY_DIENTHOAI ="dtt.vn.user.dangky.congdan.error.dienthoai.empty";
		public static final String DTT_VN_USER_DANGKY_CONGDAN_EMPTY_TINH ="dtt.vn.user.dangky.congdan.error.tinhthanh.empty";
		public static final String DTT_VN_USER_DANGKY_CONGDAN_EMPTY_QUANHUYEN ="dtt.vn.user.dangky.congdan.error.quanhuyen.empty";
		public static final String DTT_VN_USER_DANGKY_CONGDAN_EMPTY_PHUONGXA ="dtt.vn.user.dangky.congdan.error.phuongxa.empty";
		public static final String DTT_VN_USER_DANGKY_CONGDAN_EMPTY_DIACHI ="dtt.vn.user.dangky.congdan.error.diachichitiet.empty";
		public static final String DTT_VN_USER_DANGKY_CONGDAN_INVALID_USERNAME = "dtt.vn.user.dangky.congdan.error.username.invalid";
		public static final String DTT_VN_USER_DANGKY_CONGDAN_INVALID_CMND ="dtt.vn.user.dangky.congdan.error.cmnd.invalid";
		public static final String DTT_VN_USER_DANGKY_CONGDAN_INVALID_DIENTHOAI ="dtt.vn.user.dangky.congdan.error.dienthoai.invalid";
		public static final String DTT_VN_USER_DANGKY_CONGDAN_EXISTS_DIENTHOAI ="dtt.vn.user.dangky.congdan.error.dienthoai.exists";
		public static final String DTT_VN_USER_DANGKY_CONGDAN_INVALID_HOTEN = "dtt.vn.user.dangky.congdan.error.hoten.invalid";
		public static final String ORG_OEP_USER_DANGKY_EMPTY_EMAIL_KH = "dtt.vn.user.dangky.congdan.emty.email.kh";
		public static final String DTT_VN_USER_DANGKY_CONGDAN_EMPTY_DIENTHOAI_OTPSMS = "dtt.vn.user.dangky.congdan.emty.sdt.otpsms";
		public static final String DTT_VN_USER_DANGKY_CONGDAN_EMPTY_DIENTHOAI_SMSOTP = "dtt.vn.user.dangky.congdan.emty.sdt.smsotp";
		public static final String DTT_VN_USER_DANGKY_CONGDAN_EMPTY_DIENTHOAI_SMSOTP_OTPSMS = "dtt.vn.user.dangky.congdan.emty.sdt.smsotpsms";
		
		public static final String DTT_VN_USER_DANGKY_TOCHUC_EXISTS_CMND ="dtt.vn.user.dangky.tochuc.error.cmnd.exists";
		public static final String DTT_VN_USER_DANGKY_TOCHUC_USERNAME_EMPTY = "dtt.vn.user.dangky.tochuc.error.username.empty";
		public static final String DTT_VN_USER_DANGKY_TOCHUC_USERNAME_EXISTS = "dtt.vn.user.dangky.tochuc.error.username.exists";
		public static final String DTT_VN_USER_DANGKY_TOCHUC_USERNAME_INVALID = "dtt.vn.user.dangky.tochuc.error.username.invalid";
		public static final String DTT_VN_USER_DANGKY_TOCHUC_PASSWORD_EMPTY = "dtt.vn.user.dangky.tochuc.error.password.empty";
		public static final String DTT_VN_USER_DANGKY_TOCHUC_PASSWORD_INVALID ="dtt.vn.user.dangky.tochuc.error.password.invalid";
		public static final String DTT_VN_USER_DANGKY_TOCHUC_PASSWORD_CONFIRM_EMPTY ="dtt.vn.user.dangky.tochuc.error.password.confirm.empty";
		public static final String DTT_VN_USER_DANGKY_TOCHUC_PASSWORD_CONFIRM_NOT_DUPLICATE ="dtt.vn.user.dangky.tochuc.error.password.confirm.not.duplicate";
		public static final String DTT_VN_USER_DANGKY_TOCHUC_EMAIL_EMPTY = "dtt.vn.user.dangky.tochuc.error.empty.email";
		public static final String DTT_VN_USER_DANGKY_TOCHUC_EMAIL_EXISTS = "dtt.vn.user.dangky.tochuc.error.exists.email";
		public static final String DTT_VN_USER_DANGKY_TOCHUC_EMAIL_INVALID ="dtt.vn.user.dangky.tochuc.error.email";
		public static final String DTT_VN_USER_DANGKY_TOCHUC_TEN_TOCHUC_EMPTY ="dtt.vn.user.dangky.tochuc.error.tentochuc.empty";
		public static final String DTT_VN_USER_DANGKY_TOCHUC_TEN_TOCHUC_INVALID ="dtt.vn.user.dangky.tochuc.error.tentochuc.invalid";
		public static final String DTT_VN_USER_DANGKY_TOCHUC_MST_EMPTY ="dtt.vn.user.dangky.tochuc.error.mst.empty";
		public static final String DTT_VN_USER_DANGKY_TOCHUC_MST_EXISTS ="dtt.vn.user.dangky.tochuc.error.mst.exists";
		public static final String DTT_VN_USER_DANGKY_TOCHUC_MST_INVALID ="dtt.vn.user.dangky.tochuc.error.mst.invalid";
		public static final String DTT_VN_USER_DANGKY_TOCHUC_SDT_EMPTY ="dtt.vn.user.dangky.tochuc.error.dienthoai.empty";
		public static final String DTT_VN_USER_DANGKY_TOCHUC_SDT_INVALID ="dtt.vn.user.dangky.tochuc.error.dienthoai.invalid";
		public static final String DTT_VN_USER_DANGKY_TOCHUC_EXISTS_DIENTHOAI ="dtt.vn.user.dangky.tochuc.error.dienthoai.exists";
		public static final String DTT_VN_USER_DANGKY_TOCHUC_NGUOIDAIDIEN_EMPTY ="dtt.vn.user.dangky.tochuc.error.nguoidaidien.empty";
		public static final String DTT_VN_USER_DANGKY_TOCHUC_NGUOIDAIDIEN_INVALID ="dtt.vn.user.dangky.tochuc.error.nguoidaidien.invalid";
		public static final String DTT_VN_USER_DANGKY_TOCHUC_CMND_EMPTY = "dtt.vn.user.dangky.tochuc.error.cmnd.empty";
		public static final String DTT_VN_USER_DANGKY_TOCHUC_CMND_INVALID ="dtt.vn.user.dangky.tochuc.error.cmnd.invalid";
		public static final String DTT_VN_USER_DANGKY_TOCHUC_TINH_EMPTY="dtt.vn.user.dangky.tochuc.error.tinhthanh.empty";
		public static final String DTT_VN_USER_DANGKY_TOCHUC_QUANHUYEN_EMPTY="dtt.vn.user.dangky.tochuc.error.quanhuyen.empty";
		public static final String DTT_VN_USER_DANGKY_TOCHUC_PHUONGXA_EMPTY ="dtt.vn.user.dangky.tochuc.error.phuongxa.empty";
		public static final String DTT_VN_USER_DANGKY_TOCHUC_DIACHI_EMPTY="dtt.vn.user.dangky.tochuc.error.diachichitiet.empty";
		public static final String DTT_VN_USER_DANGKY_TOCHUC_EMAIL_EMPTY_KH="dtt.vn.user.dangky.tochuc.error.email.emptykh";
		public static final String DTT_VN_USER_DANGKY_TOCHUC_SDT_EMPTY_OTPSMS="dtt.vn.user.dangky.tochuc.error.sdt.emptyotpsms";
		public static final String DTT_VN_USER_DANGKY_TOCHUC_SDT_EMPTY_SMSOTP="dtt.vn.user.dangky.tochuc.error.sdt.emptysmsotp";
		public static final String DTT_VN_USER_DANGKY_TOCHUC_SDT_EMPTY_SMSOTP_OTPSMS ="dtt.vn.user.dangky.tochuc.error.sdt.emptysmsotpsms";
		
		
		public static final String DTT_VN_USER_DANGKY_CONGDAN_CAPTCHA_INVALID = "dtt.vn.user.dangky.congdan.error.captcha";
		public static final String DTT_VN_USER_DANGKY_TOCHUC_CAPTCHA_INVALID = "dtt.vn.user.dangky.tochuc.error.captcha";
		
		public static final String DTT_VN_USER_KICHHOAT_CONGDAN_OTP_INVALID ="dtt.vn.user.otp.error.invalid";
		public static final String DTT_VN_USER_KICHHOAT_TOCHUC_OTP_INVALID ="dtt.vn.user.otp.error.invalid";
		
		public static final String DTT_VN_USER_KICHHOATLAI_GUIMA_INVALID ="dtt.vn.user.dangky.kichhoatlai.validate.error";
		
		
		
	}
}



