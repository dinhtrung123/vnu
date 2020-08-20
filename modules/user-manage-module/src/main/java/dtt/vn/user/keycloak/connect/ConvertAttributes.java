package dtt.vn.user.keycloak.connect;

import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.oep.danhmuc.service.DanhMucLocalServiceUtil;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import dtt.vn.user.common.utils.DateUtil;
import dtt.vn.vnpost.model.Account;

public class ConvertAttributes {
		public static Map<String, List<String>> _Convert_CD (Account account, int activeType, String daYeuTo){
			String ngaySinh ="";
			String validDate = "";
			String expiredDate ="";
			String gioiTinh = "1";
			String diaChiChiTiet ="";
			Calendar c1 = Calendar.getInstance();
			if(account.getGender()==1){
				gioiTinh = "1"; // nam
			}else {
				gioiTinh = "2";// nu
			}
			if(account.getCreateDate()!=null){
				validDate = DateUtil.parseDateToString(account.getCreateDate(), DateUtil.DATE_FORMAT_Y_M_D_H);
			}
			if(account.getModifiedDate()!=null){
				c1.roll(Calendar.YEAR, 1);
				expiredDate = DateUtil.parseDateToString(c1.getTime(), DateUtil.DATE_FORMAT_Y_M_D_KEYCLOAK);
			}
			if(account.getBirthdate()!=null){
				ngaySinh = DateUtil.parseDateToString(account.getBirthdate(), DateUtil.DATE_FORMAT_Y_M_D);
			}
			diaChiChiTiet = account.getAddress()+", "+DanhMucLocalServiceUtil.fetchDanhMuc(Long.parseLong(account.getWardCode())).getTen()+", "+DanhMucLocalServiceUtil.fetchDanhMuc(Long.parseLong(account.getDistrictCode())).getTen()+", "+ DanhMucLocalServiceUtil.fetchDanhMuc(Long.parseLong(account.getCityCode())).getTen();
			 Map<String, List<String>> map = new HashMap<String, List<String>>();
			 map.put("LoaiTaiKhoan", Arrays.asList(String.valueOf(account.getAccountType())));
			 map.put("MaSoThue", Arrays.asList(account.getTaxCode()));
			 map.put("SoCMND", Arrays.asList(account.getPersonalId()));
			 map.put("SoDinhDanh", Arrays.asList(""));
			 map.put("MaBHXH", Arrays.asList(""));
			 map.put("HoChieu", Arrays.asList(""));
			 map.put("HoVaTen", Arrays.asList(account.getFullName()));
			 map.put("ThuDienTu", Arrays.asList(account.getEmail()));
			 map.put("SoDienThoai", Arrays.asList(account.getTelNo()));
			 map.put("GioiTinh", Arrays.asList(gioiTinh));
			 map.put("NgayThangNamSinh",Arrays.asList(ngaySinh));
			 map.put("NoiSinh", Arrays.asList(account.getFamilyRegNo()));
			 map.put("QueQuan", Arrays.asList(account.getNativePlace()));
			 map.put("DiaChiThuongTru", Arrays.asList(diaChiChiTiet));
			 map.put("DiaChi", Arrays.asList(diaChiChiTiet));
			 map.put("TechID", Arrays.asList(""));
			 map.put("arc_values", Arrays.asList("2"));
			 
			 if(daYeuTo.equals("XTSMSOTP")){
				 map.put("mobile_number", Arrays.asList(account.getTelNo()));
			 }
			 if(daYeuTo.equals("XTSMARTOTP")){
				 map.put("mobile_number", Arrays.asList(account.getTelNo()));
				 map.put("mobile_number_verified", Arrays.asList(account.getTelNo()));
			 }
			 
			 map.put("authType", Arrays.asList(daYeuTo));
			 map.put("userProfileUri", Arrays.asList("https://idm.vnpost.vn/group/control_panel/manage?p_p_id=com_liferay_my_account_web_portlet_MyAccountPortlet&p_p_lifecycle=1&p_p_state=maximized&p_p_mode=view"));
			 map.put("logoutUri", Arrays.asList("https://postid.vnpost.vn/auth/realms/idp/protocol/openid-connect/logout?redirect_uri=https://dichvucongquocgia.vnpt.vn"));
			 if(activeType == 1){
					map.put("XacNhan_ThuDienTu", Arrays.asList("true"));
					map.put("XacNhan_SoDienThoai", Arrays.asList("false"));
			}
			 if(activeType == 0){
				 	map.put("XacNhan_ThuDienTu", Arrays.asList("false"));
					map.put("XacNhan_SoDienThoai", Arrays.asList("true"));
			 }
			 if(activeType == 2){
				 	map.put("XacNhan_ThuDienTu", Arrays.asList("false"));
					map.put("XacNhan_SoDienThoai", Arrays.asList("false"));
			 }
			 
			 JSONObject loAs = new JSONFactoryUtil().createJSONObject();
			 	loAs.put("claim","SoCMND");
			 	loAs.put("level", String.valueOf(account.getIpLevel()));
			 	loAs.put("src", "VNPOST");
			 	loAs.put("validDate", validDate);
			 	loAs.put("expired_date", expiredDate);
			 map.put("loAs", Arrays.asList(loAs.toJSONString()));
			return map;
			
		}
		
		public static Map<String, List<String>> _Convert_TC (Account account, int activeType, String daYeuTo){
			String validDate = "";
			String expiredDate ="";
			String diaChiChiTiet ="";
			Calendar c1 = Calendar.getInstance();
			if(account.getCreateDate()!=null){
				validDate = DateUtil.parseDateToString(account.getCreateDate(), DateUtil.DATE_FORMAT_Y_M_D_H);
			}
			if(account.getModifiedDate()!=null){
				c1.roll(Calendar.YEAR, 1);
				expiredDate = DateUtil.parseDateToString(c1.getTime(), DateUtil.DATE_FORMAT_Y_M_D_KEYCLOAK);
			}
			diaChiChiTiet = account.getAddress()+", "+DanhMucLocalServiceUtil.fetchDanhMuc(Long.parseLong(account.getWardCode())).getTen()+", "+DanhMucLocalServiceUtil.fetchDanhMuc(Long.parseLong(account.getDistrictCode())).getTen()+", "+ DanhMucLocalServiceUtil.fetchDanhMuc(Long.parseLong(account.getCityCode())).getTen();
			 Map<String, List<String>> map = new HashMap<String, List<String>>();
			 map.put("LoaiTaiKhoan", Arrays.asList(String.valueOf(account.getAccountType())));
			 map.put("MaSoThue", Arrays.asList(account.getTaxCode()));
			 map.put("MaSoDoanhNghiep", Arrays.asList());
			 map.put("TenDoanhNghiep", Arrays.asList(account.getFullName()));
			 map.put("ThuDienTu", Arrays.asList(account.getEmail()));
			 map.put("SoDienThoai", Arrays.asList(account.getTelNo()));
			 map.put("DiaChi", Arrays.asList(diaChiChiTiet));
			 map.put("TechID", Arrays.asList(""));
			 map.put("arc_values", Arrays.asList("2"));
			 map.put("userProfileUri", Arrays.asList("https://idm.vnpost.vn/group/control_panel/manage?p_p_id=com_liferay_my_account_web_portlet_MyAccountPortlet&p_p_lifecycle=1&p_p_state=maximized&p_p_mode=view"));
			 map.put("logoutUri", Arrays.asList("https://postid.vnpost.vn/auth/realms/idp/protocol/openid-connect/logout?redirect_uri=https://dichvucongquocgia.vnpt.vn"));
			 map.put("mobile_number", Arrays.asList(account.getTelNo()));
			 map.put("authType", Arrays.asList(daYeuTo));
			 if(activeType == 1){
					map.put("XacNhan_ThuDienTu", Arrays.asList("true"));
					map.put("XacNhan_SoDienThoai", Arrays.asList("false"));
			}
			 if(activeType == 0){
				 	map.put("XacNhan_ThuDienTu", Arrays.asList("false"));
					map.put("XacNhan_SoDienThoai", Arrays.asList("true"));
			 }
			 if(activeType == 2){
				 	map.put("XacNhan_ThuDienTu", Arrays.asList("false"));
					map.put("XacNhan_SoDienThoai", Arrays.asList("false"));
			 }
			 
			 JSONObject loAs = new JSONFactoryUtil().createJSONObject();
			 	loAs.put("claim", "DN-MaSoThue");
			 	loAs.put("level", String.valueOf(account.getIpLevel()));
			 	loAs.put("src", "");
			 	loAs.put("validDate", validDate);
			 	loAs.put("expired_date", expiredDate);
			 map.put("loAs", Arrays.asList(loAs.toJSONString()));
			return map;
			
		}
}
