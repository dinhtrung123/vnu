package dtt.vn.user.quanly.keys;

public class CapNhatMatKhauKeys {
	public static class Base {
		public static final String ID = "id";
		public static final String PASSWORD_OLD = "password_old";
		public static final String PASSWORD_NEW = "password_new";
		public static final String PASSWORD_CONFIRM = "passwordConfirm";
		public static final String HOTEN = "hoTen";
		public static final String TEN_THUONGGOI = "tenThuongGoi";
		public static final String NGAYSINH = "ngaySinh";
		public static final String MASOTHUE = "maSoThue";
		public static final String QUOCGIA = "quocGia";
		public static final String GIOITINH = "gioiTinh";
		public static final String TINHTHANH = "tinhThanh";
		public static final String QUANHUYEN = "quanHuyen";
		public static final String PHUONGXA = "phuongXa";
		public static final String DIACHI_CHITIET = "diaChiChiTiet";
		public static final String CMND_HOCHIEU = "cmnd_hoChieu";
		public static final String NOICAP = "noiCap";
		public static final String NGAYCAP = "ngayCap";
		public static final String DIENTHOAI = "dienThoai";
		public static final String EMAIL = "email";	
		public static final String USER_ID = "user_id";
	}
	
	public static class ErrorMessageKeys {
		
		public static final String ORG_OEP_USER_DANGKY_EMPTY_PASSWORD_OLD = "org.oep.user.portlet.updatepasssworduser.message.empty.password.old";
		public static final String ORG_OEP_USER_DANGKY_EMPTY_PASSWORD_NEW = "org.oep.user.portlet.updatepasssworduser.message.empty.password.new";
		public static final String ORG_OEP_USER_DANGKY_VALIDATE_PASSWORD_NEW = "org.oep.user.portlet.updatepasssworduser.message.validate.password.new";
		public static final String ORG_OEP_USER_DANGKY_EMPTY_PASSWORD_CONFIRM = "org.oep.user.portlet.updatepasssworduser.message.empty.password.confirm";
		public static final String ORG_OEP_USER_DANGKY_PASSWORD_NEW_NOT_DUPLICATE_PASSWORD_CONFIRM = "org.oep.user.portlet.updatepasssworduser.message.empty.password.confirm.not.duplicate";
		public static final String ORG_OEP_USER_DANGKY_PASSWORD_ERROR = "org.oep.user.portlet.updatepasssworduser.message.error.password";
		
	}
	public class Notification {
		 public static final String UPDATE_PASS_SUCCESS = "org.oep.user.portlet.updatepasssworduser.message.success.update.pass";
		 public static final String UPDATE_PASS_FALSE = "org.oep.user.portlet.updatepasssworduser.message.false.update.pass.keycloak";
		 public static final String EMPTY_ACCOUNT = "org.oep.user.portlet.updatepasssworduser.message.empty.account";
		 public static final String UPDATE_PASS_KEYCLOAK_SUCCESS = "org.oep.user.portlet.updatepasssworduser.message.success.update.pass.keycloak";
	}
}
