package dtt.vn.user.business;

import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.configuration.ConfigurationFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
//import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
//import java.util.Enumeration;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletSession;
//import javax.portlet.PortletSession;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.oep.core.service.ThamSoLocalServiceUtil;
import org.oep.danhmuc.model.DanhMuc;
import org.oep.danhmuc.service.DanhMucLocalServiceUtil;

import dtt.vn.user.keycloak.connect.ConvertAttributes;
import dtt.vn.user.keycloak.connect.KeycloakUtils;
import dtt.vn.user.keys.Constantes;
import dtt.vn.user.keys.DangKyTaiKhoanKeys;
import dtt.vn.user.model.DangKyCongDanModel;
import dtt.vn.user.model.DangKyToChucModel;
import dtt.vn.user.service.model.ThongTinDangKy;
import dtt.vn.user.service.service.ThongTinDangKyLocalServiceUtil;
import dtt.vn.user.utils.DangKyQuyTrinhUtil;
import dtt.vn.user.utils.LiferayUserUtil;
import dtt.vn.vnpost.model.Account;
import dtt.vn.vnpost.model.WorkItem;
import dtt.vn.vnpost.service.AccountLocalServiceUtil;
import dtt.vn.vnpost.service.WorkItemLocalServiceUtil;

public class DangKyTaiKhoanBusiness {
	private static Log log = LogFactoryUtil.getLog(DangKyTaiKhoanBusiness.class.getName());
	private static final Configuration _configuration = ConfigurationFactoryUtil
		    .getConfiguration(PortalClassLoaderUtil.getClassLoader(), "portlet");

	public static void getQuanHuyenByTinhThanh(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws SystemException, IOException {
		long thanhPhoId = ParamUtil.getLong(resourceRequest, DangKyTaiKhoanKeys.DangKyCongDan.TINH_THANH);
		List<DanhMuc> listQuanHuyens = null;
		if (thanhPhoId != 0) {
			listQuanHuyens = DanhMucLocalServiceUtil.getDanhMuc_By_ChaId(thanhPhoId, true);
		}

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		for (int i = 0; listQuanHuyens != null && i < listQuanHuyens.size(); i++) {
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put("id", listQuanHuyens.get(i).getId());
			jsonObject.put("key", listQuanHuyens.get(i).getTen());
			jsonArray.put(jsonObject);
		}

		resourceResponse.setContentType("text/html");
		PrintWriter writer = resourceResponse.getWriter();
		writer.write(jsonArray.toString());
	}

	public static void getQuanHuyenByTinhThanh_ToChuc(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws SystemException, IOException {
		long thanhPhoId = ParamUtil.getLong(resourceRequest, DangKyTaiKhoanKeys.DangKyToChuc.TINH_THANH);
		List<DanhMuc> listQuanHuyens = null;
		if (thanhPhoId != 0) {
			listQuanHuyens = DanhMucLocalServiceUtil.getDanhMuc_By_ChaId(thanhPhoId, true);
		}

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		for (int i = 0; listQuanHuyens != null && i < listQuanHuyens.size(); i++) {
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put("id", listQuanHuyens.get(i).getId());
			jsonObject.put("key", listQuanHuyens.get(i).getTen());
			jsonArray.put(jsonObject);
		}

		resourceResponse.setContentType("text/html");
		PrintWriter writer = resourceResponse.getWriter();
		writer.write(jsonArray.toString());
	}

	public static void getPhuongXaByQuanHuyen(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws SystemException, IOException {
		long quanHuyenId = ParamUtil.getLong(resourceRequest, DangKyTaiKhoanKeys.DangKyCongDan.QUAN_HUYEN);
		List<DanhMuc> listPhuongXas = null;
		if (quanHuyenId != 0) {
			listPhuongXas = DanhMucLocalServiceUtil.getDanhMuc_By_ChaId(quanHuyenId, true);
		}

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		for (int i = 0; listPhuongXas != null && i < listPhuongXas.size(); i++) {
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put("id", listPhuongXas.get(i).getId());
			jsonObject.put("key", listPhuongXas.get(i).getTen());
			jsonArray.put(jsonObject);
		}

		resourceResponse.setContentType("text/html");
		PrintWriter writer = resourceResponse.getWriter();
		writer.write(jsonArray.toString());
	}

	public static void getPhuongXaByQuanHuyen_ToChuc(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws SystemException, IOException {
		long quanHuyenId = ParamUtil.getLong(resourceRequest, DangKyTaiKhoanKeys.DangKyToChuc.QUAN_HUYEN);
		List<DanhMuc> listPhuongXas = null;
		if (quanHuyenId != 0) {
			listPhuongXas = DanhMucLocalServiceUtil.getDanhMuc_By_ChaId(quanHuyenId, true);
		}

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		for (int i = 0; listPhuongXas != null && i < listPhuongXas.size(); i++) {
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put("id", listPhuongXas.get(i).getId());
			jsonObject.put("key", listPhuongXas.get(i).getTen());
			jsonArray.put(jsonObject);
		}

		resourceResponse.setContentType("text/html");
		PrintWriter writer = resourceResponse.getWriter();
		writer.write(jsonArray.toString());
	}

	public static void getQuanHuyenByTinhThanhKhaiSinh(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws SystemException, IOException {
		long thanhPhoId = ParamUtil.getLong(resourceRequest, DangKyTaiKhoanKeys.DangKyCongDan.TINH_THANH);
		List<DanhMuc> listQuanHuyens = null;
		if (thanhPhoId != 0) {
			listQuanHuyens = DanhMucLocalServiceUtil.getDanhMuc_By_ChaId(thanhPhoId, true);
		}

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		for (int i = 0; listQuanHuyens != null && i < listQuanHuyens.size(); i++) {
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put("id", listQuanHuyens.get(i).getId());
			jsonObject.put("key", listQuanHuyens.get(i).getTen());
			jsonArray.put(jsonObject);
		}

		resourceResponse.setContentType("text/html");
		PrintWriter writer = resourceResponse.getWriter();
		writer.write(jsonArray.toString());
	}

	public static void getQuanHuyenByTinhThanhThuongTru(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws SystemException, IOException {
		long tinhThanhTR = ParamUtil.getLong(resourceRequest, DangKyTaiKhoanKeys.DangKyCongDan.TINH_THANH_THUONG_TRU);
		List<DanhMuc> listQuanHuyenTRs = null;
		if (tinhThanhTR != 0) {
			listQuanHuyenTRs = DanhMucLocalServiceUtil.getDanhMuc_By_ChaId(tinhThanhTR, true);
		}

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		for (int i = 0; listQuanHuyenTRs != null && i < listQuanHuyenTRs.size(); i++) {
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put("id", listQuanHuyenTRs.get(i).getId());
			jsonObject.put("key", listQuanHuyenTRs.get(i).getTen());
			jsonArray.put(jsonObject);
		}

		resourceResponse.setContentType("text/html");
		PrintWriter writer = resourceResponse.getWriter();
		writer.write(jsonArray.toString());
	}

	public static void getQuanHuyenByTinhThanhHienTai(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws SystemException, IOException {
		long tinhThanhHT = ParamUtil.getLong(resourceRequest, DangKyTaiKhoanKeys.DangKyCongDan.TINH_THANH_HIEN_TAI);
		List<DanhMuc> listQuanHuyenHTs = null;
		if (tinhThanhHT != 0) {
			listQuanHuyenHTs = DanhMucLocalServiceUtil.getDanhMuc_By_ChaId(tinhThanhHT, true);
		}

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		for (int i = 0; listQuanHuyenHTs != null && i < listQuanHuyenHTs.size(); i++) {
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put("id", listQuanHuyenHTs.get(i).getId());
			jsonObject.put("key", listQuanHuyenHTs.get(i).getTen());
			jsonArray.put(jsonObject);
		}

		resourceResponse.setContentType("text/html");
		PrintWriter writer = resourceResponse.getWriter();
		writer.write(jsonArray.toString());
	}

	public static void getQuanHuyenByTinhThanhXacMinh(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws SystemException, IOException {
		long tinhThanhXM = ParamUtil.getLong(resourceRequest, DangKyTaiKhoanKeys.DangKyCongDan.TINH_THANH_XAC_MINH);
		List<DanhMuc> listQuanHuyenXMs = null;
		if (tinhThanhXM != 0) {
			listQuanHuyenXMs = DanhMucLocalServiceUtil.getDanhMuc_By_ChaId(tinhThanhXM, true);
		}

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		for (int i = 0; listQuanHuyenXMs != null && i < listQuanHuyenXMs.size(); i++) {
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put("id", listQuanHuyenXMs.get(i).getId());
			jsonObject.put("key", listQuanHuyenXMs.get(i).getTen());
			jsonArray.put(jsonObject);
		}

		resourceResponse.setContentType("text/html");
		PrintWriter writer = resourceResponse.getWriter();
		writer.write(jsonArray.toString());
	}

	public static void getPhuongXaByQuanHuyenKhaiSinh(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws SystemException, IOException {
		long quanHuyenId = ParamUtil.getLong(resourceRequest, DangKyTaiKhoanKeys.DangKyCongDan.QUAN_HUYEN);
		List<DanhMuc> listPhuongXas = null;
		if (quanHuyenId != 0) {
			listPhuongXas = DanhMucLocalServiceUtil.getDanhMuc_By_ChaId(quanHuyenId, true);
		}

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		for (int i = 0; listPhuongXas != null && i < listPhuongXas.size(); i++) {
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put("id", listPhuongXas.get(i).getId());
			jsonObject.put("key", listPhuongXas.get(i).getTen());
			jsonArray.put(jsonObject);
		}

		resourceResponse.setContentType("text/html");
		PrintWriter writer = resourceResponse.getWriter();
		writer.write(jsonArray.toString());
	}

	public static void getPhuongXaByQuanHuyenThuongTru(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws SystemException, IOException {
		long quanHuyenTR = ParamUtil.getLong(resourceRequest, DangKyTaiKhoanKeys.DangKyCongDan.QUAN_HUYEN_THUONG_TRU);
		List<DanhMuc> listPhuongXaTRs = null;
		if (quanHuyenTR != 0) {
			listPhuongXaTRs = DanhMucLocalServiceUtil.getDanhMuc_By_ChaId(quanHuyenTR, true);
		}

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		for (int i = 0; listPhuongXaTRs != null && i < listPhuongXaTRs.size(); i++) {
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put("id", listPhuongXaTRs.get(i).getId());
			jsonObject.put("key", listPhuongXaTRs.get(i).getTen());
			jsonArray.put(jsonObject);
		}

		resourceResponse.setContentType("text/html");
		PrintWriter writer = resourceResponse.getWriter();
		writer.write(jsonArray.toString());
	}

	public static void getPhuongXaByQuanHuyenHienTai(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws SystemException, IOException {
		long quanHuyenHT = ParamUtil.getLong(resourceRequest, DangKyTaiKhoanKeys.DangKyCongDan.QUAN_HUYEN_HIEN_TAI);
		List<DanhMuc> listPhuongXaHTs = null;
		if (quanHuyenHT != 0) {
			listPhuongXaHTs = DanhMucLocalServiceUtil.getDanhMuc_By_ChaId(quanHuyenHT, true);
		}

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		for (int i = 0; listPhuongXaHTs != null && i < listPhuongXaHTs.size(); i++) {
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put("id", listPhuongXaHTs.get(i).getId());
			jsonObject.put("key", listPhuongXaHTs.get(i).getTen());
			jsonArray.put(jsonObject);
		}

		resourceResponse.setContentType("text/html");
		PrintWriter writer = resourceResponse.getWriter();
		writer.write(jsonArray.toString());
	}

	public static void getPhuongXaByQuanHuyenXacMinh(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws SystemException, IOException {
		long quanHuyenXM = ParamUtil.getLong(resourceRequest, DangKyTaiKhoanKeys.DangKyCongDan.QUAN_HUYEN_XAC_MINH);
		List<DanhMuc> listPhuongXaXMs = null;
		if (quanHuyenXM != 0) {
			listPhuongXaXMs = DanhMucLocalServiceUtil.getDanhMuc_By_ChaId(quanHuyenXM, true);
		}

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		for (int i = 0; listPhuongXaXMs != null && i < listPhuongXaXMs.size(); i++) {
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put("id", listPhuongXaXMs.get(i).getId());
			jsonObject.put("key", listPhuongXaXMs.get(i).getTen());
			jsonArray.put(jsonObject);
		}

		resourceResponse.setContentType("text/html");
		PrintWriter writer = resourceResponse.getWriter();
		writer.write(jsonArray.toString());
	}

	public static boolean _doDangKy_CongDan (ActionRequest request, ActionResponse response){
		Date newDate = new Date();
		String userName = ParamUtil.getString(	request, DangKyTaiKhoanKeys.DangKyCongDan.USER_NAME);
		String matKhau = ParamUtil.getString(	request, DangKyTaiKhoanKeys.DangKyCongDan.MAT_KHAU);
		String matKhauConfirm = ParamUtil.getString(	request, DangKyTaiKhoanKeys.DangKyCongDan.MAT_KHAU_CONFIRM);
		String hoTen = ParamUtil.getString(	request, DangKyTaiKhoanKeys.DangKyCongDan.HO_TEN);
		String gioiTinh = ParamUtil.getString(	request, DangKyTaiKhoanKeys.DangKyCongDan.GIOI_TINH);
		String ngaySinh = ParamUtil.getString(	request, DangKyTaiKhoanKeys.DangKyCongDan.NGAY_SINH);
		String cmnd = ParamUtil.getString(	request, DangKyTaiKhoanKeys.DangKyCongDan.SO_CMND);
		String email = ParamUtil.getString(	request, DangKyTaiKhoanKeys.DangKyCongDan.EMAIL);
		String soDienThoai = ParamUtil.getString(	request, DangKyTaiKhoanKeys.DangKyCongDan.DIEN_THOAI);
		String tinhId = ParamUtil.getString(request, DangKyTaiKhoanKeys.DangKyCongDan.TINH_THANH_CONG_DAN);
		String quanHuyenIdCd = ParamUtil.getString(	request, DangKyTaiKhoanKeys.DangKyCongDan.QUAN_HUYEN_CONG_DAN);
		String phuongXaIdCd = ParamUtil.getString(	request, DangKyTaiKhoanKeys.DangKyCongDan.PHUONG_XA_CONG_DAN);
		String diaChi_ChiTiet = ParamUtil.getString(request, DangKyTaiKhoanKeys.DangKyCongDan.DIACHI_CHITIET);
		String maXacNhan = ParamUtil.getString(request, DangKyTaiKhoanKeys.DangKyCongDan.MA_XACNHAN);
		String maKichHoat = ParamUtil.getString(request, DangKyTaiKhoanKeys.DangKyCongDan.MA_KICHHOAT);
		String kichHoatUrl = ParamUtil.getString(request, DangKyTaiKhoanKeys.DangKyCongDan.KICHHOAT_URL);
		String catpchaText = getCaptchaValueFromSession(request, response);
		String hinhThuc_KichHoat = ParamUtil.getString(request, DangKyTaiKhoanKeys.DangKyCongDan.hinhThucKichHoat);
		String xacThucDYT = ParamUtil.getString(request, DangKyTaiKhoanKeys.DangKyCongDan.HinhThuc_XacThuc_DaYeuTo);
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		boolean isSuccess = false;
		if(maXacNhan.equals(catpchaText)){
			isSuccess = ValidateData.validateForm(matKhau, matKhauConfirm, email, userName, hoTen, gioiTinh, ngaySinh, cmnd, 
					soDienThoai, tinhId, quanHuyenIdCd, phuongXaIdCd, diaChi_ChiTiet,hinhThuc_KichHoat, xacThucDYT, request, response);
		}else {
			SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_CONGDAN_CAPTCHA_INVALID);
		}
		/*isSuccess = ValidateData.validateForm(matKhau, matKhauConfirm, email, userName, hoTen, gioiTinh, ngaySinh, cmnd, 
				soDienThoai, tinhId, quanHuyenIdCd, phuongXaIdCd, diaChi_ChiTiet,hinhThuc_KichHoat, xacThucDYT, request, response);*/
		
		log.info("validate :"+isSuccess);
		if(isSuccess == true){
			DangKyCongDanModel model = new DangKyCongDanModel();
			model.setEmail(email);
			model.setUserName(userName);
			model.setPassword(matKhau);
			model.setHoTen(hoTen);
			model.setNgaySinh(ngaySinh);
			model.setDiaChiChiTiet(diaChi_ChiTiet);
			model.setSoCMND(cmnd);
			model.setDienThoai(soDienThoai);
			model.setGioiTinhId(Long.parseLong(gioiTinh));
			model.setTinhId(Long.parseLong(tinhId));
			model.setQuanHuyenId(Long.parseLong(quanHuyenIdCd));
			model.setPhuongXaId(Long.parseLong(phuongXaIdCd));
			model.setDaYeuto(xacThucDYT);
			if(hinhThuc_KichHoat.equals(ThamSoLocalServiceUtil.getValue("HINHTHUCKICHHOAT_EMAIL", ""))){
				log.info("In DangKyQuyTrinhBusiness.luuLaiCongDan, hinh thuc kich hoat qua EMAIL");
				ThongTinDangKy ttdk = ThongTinDangKyLocalServiceUtil.addThongTinDangKy(email, userName,cmnd, maKichHoat, DangKyTaiKhoanKeys.Base.DOITUONG_SUDUNG_CONGDAN, "","email",newDate);
				ttdk.setNoiDung(DangKyQuyTrinhUtil.getJsonNoiDungDangKyCongDan(model));
				ThongTinDangKyLocalServiceUtil.updateThongTinDangKy(ttdk);
				log.info("In DangKyQuyTrinhBusiness.luuLaiDangKyCongDan, them thong tin dang ky thanh cong.");
				log.info("In DangKyQuyTrinhBusiness.luuLaiDangKyCongDan, gui mail...");
				DangKyQuyTrinhUtil.guiMailKichHoatCongDan(request, themeDisplay, hoTen, email, kichHoatUrl);
				log.info("In DangKyQuyTrinhBusiness.luuLaiDangKyCongDan, gui mail thanh cong.");
				response.setRenderParameter("thongBaoTaoTaiKhoanCD", "success");
				response.setRenderParameter("hienthongbaoTTKCD", "success");
			}else if (hinhThuc_KichHoat.equals(ThamSoLocalServiceUtil.getValue("HINHTHUCKICHHOAT_SMS", ""))) {
				log.info("In DangKyQuyTrinhBusiness.luuLaiCongDan, hinh thuc kich hoat qua SMS");
				OtpServices otp = new OtpServices();
				log.info("key otp : "+userName);
				int otpCode = otp.generateOTP(userName);
				log.info("ma otp : "+String.valueOf(otpCode));
				ThongTinDangKy ttdk = ThongTinDangKyLocalServiceUtil.addThongTinDangKy(email, userName,cmnd, String.valueOf(otpCode), DangKyTaiKhoanKeys.Base.DOITUONG_SUDUNG_CONGDAN, "","sms",newDate);
				ttdk.setNoiDung(DangKyQuyTrinhUtil.getJsonNoiDungDangKyCongDan(model));
				ThongTinDangKyLocalServiceUtil.updateThongTinDangKy(ttdk);
				log.info("In DangKyQuyTrinhBusiness.luuLaiDangKyCongDan, them thong tin dang ky thanh cong.");
				log.info("In DangKyQuyTrinhBusiness.luuLaiDangKyCongDan, gui tin nhan OTP.....");
				try {
					boolean choPhepGuiOTP = DangKyQuyTrinhUtil.getGiaTriThamSo("CHO_PHEP_GUI_OTP_SMS").equals("1");
					if(choPhepGuiOTP){
						String smsResponse = SmsServices.sendSMS(dtt.vn.user.keys.PortletKeys.END_POINT_OTP_SMS, dtt.vn.user.keys.PortletKeys.XML_OTPSMS, soDienThoai, String.valueOf(otpCode));
						log.info("In DangKyQuyTrinhBusiness.luuLaiDangKyCongDan, gui tin nhan OTP thanh cong" + smsResponse);
					}else {
						log.info("InDangKyTaiKhoanBusiness.themmoiCongDan gui SMS OTP khong cho phep boi quan tri vien");
					}
					
				} catch (Exception e) {
					log.error(e.getMessage());
				}
				response.setRenderParameter("thongBaoOtpCD", "success");
				response.setRenderParameter("maOTP", String.valueOf(otpCode));
				response.setRenderParameter("userName", userName);
			}
			PortalUtil.copyRequestParameters(request, response);
			
		}
		
		return isSuccess;
	}
	public static boolean _doDangKy_ToChuc (ActionRequest request, ActionResponse response){
		Date newDate = new Date();
		String userName = ParamUtil.getString(request, DangKyTaiKhoanKeys.DangKyToChuc.USER_NAME);
		String matKhau = ParamUtil.getString(request, DangKyTaiKhoanKeys.DangKyToChuc.MAT_KHAU);
		String matKhauConfirm = ParamUtil.getString(request, DangKyTaiKhoanKeys.DangKyToChuc.MAT_KHAU_CONFIRM);
		String cmnd = ParamUtil.getString(	request, DangKyTaiKhoanKeys.DangKyToChuc.SO_CMND);
		String email = ParamUtil.getString(	request, DangKyTaiKhoanKeys.DangKyToChuc.EMAIL);
		String soDienThoai = ParamUtil.getString(request, DangKyTaiKhoanKeys.DangKyToChuc.DIEN_THOAI);
		String tinhId = ParamUtil.getString(request, DangKyTaiKhoanKeys.DangKyToChuc.TINH_THANH);
		String quanHuyenId = ParamUtil.getString(request, DangKyTaiKhoanKeys.DangKyToChuc.QUAN_HUYEN);
		String phuongXaId = ParamUtil.getString(request, DangKyTaiKhoanKeys.DangKyToChuc.PHUONG_XA);
		String diaChi_ChiTiet = ParamUtil.getString(request, DangKyTaiKhoanKeys.DangKyToChuc.DIACHI_CHITIET);
		String maSothue = ParamUtil.getString(request, DangKyTaiKhoanKeys.DangKyToChuc.MA_SO_THUE);
		String tenToChuc = ParamUtil.getString(request, DangKyTaiKhoanKeys.DangKyToChuc.TEN_TO_CHUC);
		String nguoiDaiDien = ParamUtil.getString(request, DangKyTaiKhoanKeys.DangKyToChuc.NGUOI_DAI_DIEN);
		String maXacNhan = ParamUtil.getString(request, DangKyTaiKhoanKeys.DangKyToChuc.MA_XACNHAN);
		String maKichHoat = ParamUtil.getString(request, DangKyTaiKhoanKeys.DangKyCongDan.MA_KICHHOAT);
		String kichHoatUrl = ParamUtil.getString(request, DangKyTaiKhoanKeys.DangKyCongDan.KICHHOAT_URL);
		String hinhThuc_KichHoat = ParamUtil.getString(request, DangKyTaiKhoanKeys.DangKyToChuc.hinhThucKichHoatTC);
		String xacThucDYT = ParamUtil.getString(request, DangKyTaiKhoanKeys.DangKyToChuc.HinhThuc_XacThuc_DaYeuToTC);
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		boolean isSuccess = false;
		
		String catpchaText = getCaptchaValueFromSession(request, response);
		if(maXacNhan.equals(catpchaText)){
			isSuccess = ValidateData.validateForm_ToChuc(matKhau, matKhauConfirm, email, userName, tenToChuc, soDienThoai, maSothue, nguoiDaiDien, tinhId, 
					quanHuyenId, phuongXaId, cmnd, diaChi_ChiTiet,hinhThuc_KichHoat, xacThucDYT, request, response);
		}else {
			SessionErrors.add(request,DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_DANGKY_TOCHUC_CAPTCHA_INVALID);
		}
		/*isSuccess = ValidateData.validateForm_ToChuc(matKhau, matKhauConfirm, email, userName, tenToChuc, soDienThoai, maSothue, nguoiDaiDien, tinhId, 
				quanHuyenId, phuongXaId, cmnd, diaChi_ChiTiet,hinhThuc_KichHoat, xacThucDYT, request, response);*/
		if(isSuccess==true){
			DangKyToChucModel model = new DangKyToChucModel();
			try {
				model.setUserName(userName);
				model.setEmail(email);
				model.setTenToChuc(tenToChuc);
				model.setDiaChiChiTiet(diaChi_ChiTiet);
				model.setDienThoaiNDD(soDienThoai);
				model.setTaxCode(maSothue);
				model.setPassword(matKhau);
				model.setNguoiDaiDien(nguoiDaiDien);
				model.setSoCMND_NDD(cmnd);
				model.setTinhId(Long.parseLong(tinhId));
				model.setQuanHuyenId(Long.parseLong(quanHuyenId));
				model.setPhuongXaId(Long.parseLong(phuongXaId));
				model.setDaYeuto(xacThucDYT);
			} catch (Exception e) {
				log.error(e.getMessage());
			}
			//Them thong tin dang ky
			if(hinhThuc_KichHoat.equals(ThamSoLocalServiceUtil.getValue("HINHTHUCKICHHOAT_EMAIL", ""))){
				log.info("In DangKyQuyTrinhBusiness.luuLaiToChuc, hinh thuc kich hoat qua EMAIL");
				log.info("In DangKyQuyTrinhBusiness.luuLaiDangKyDoanhNghiep, them thong tin dang ky....");
				ThongTinDangKy ttdk = ThongTinDangKyLocalServiceUtil.addThongTinDangKy(email, userName,maSothue, maKichHoat, DangKyTaiKhoanKeys.Base.DOITUONG_SUDUNG_TOCHUC, "","email",newDate);
				ttdk.setNoiDung(DangKyQuyTrinhUtil.getJsonNoiDungDangKyToChuc(model));
				log.info("json noi dung : "+DangKyQuyTrinhUtil.getJsonNoiDungDangKyToChuc(model));
				ThongTinDangKyLocalServiceUtil.updateThongTinDangKy(ttdk);		
				log.info("In DangKyQuyTrinhBusiness.luuLaiDangKyToChuc, them thong tin dang ky thanh cong.");
				log.info("In DangKyQuyTrinhBusiness.luuLaiDangKyToChuc, gui mail...");
				DangKyQuyTrinhUtil.guiMailKichHoatDoanhNghiep(request, themeDisplay, model.getTenToChuc(), model.getTaxCode(), model.getEmail(), kichHoatUrl);
				log.info("In DangKyQuyTrinhBusiness.luuLaiDangKyToChuc, gui mail thanh cong.");
				response.setRenderParameter("thongBaoTaoTaiKhoanDN", "success");
				response.setRenderParameter("hienthongbaoTTKDN", "success");
				
			}else if (hinhThuc_KichHoat.equals(ThamSoLocalServiceUtil.getValue("HINHTHUCKICHHOAT_SMS", ""))) {
				log.info("In DangKyQuyTrinhBusiness.luuLaiToChuc, hinh thuc kich hoat qua SMS");
				OtpServices otp = new OtpServices();
				log.info("key otp : "+userName);
				int otpCode = otp.generateOTP(userName);
				log.info("ma otp : "+String.valueOf(otpCode));
				ThongTinDangKy ttdk = ThongTinDangKyLocalServiceUtil.addThongTinDangKy(email, userName,maSothue, String.valueOf(otpCode), DangKyTaiKhoanKeys.Base.DOITUONG_SUDUNG_TOCHUC, "","sms",newDate);
				ttdk.setNoiDung(DangKyQuyTrinhUtil.getJsonNoiDungDangKyToChuc(model));
				log.info("json noi dung : "+DangKyQuyTrinhUtil.getJsonNoiDungDangKyToChuc(model));
				ThongTinDangKyLocalServiceUtil.updateThongTinDangKy(ttdk);		
				log.info("In DangKyQuyTrinhBusiness.luuLaiToChuc, them thong tin dang ky thanh cong.");
				log.info("In DangKyQuyTrinhBusiness.luuLaiToChuc, gui tin nhan OTP.....");
				try {
					boolean choPhepGuiOTP = DangKyQuyTrinhUtil.getGiaTriThamSo("CHO_PHEP_GUI_OTP_SMS").equals("1");
					if(choPhepGuiOTP){
						String smsResponse = SmsServices.sendSMS(dtt.vn.user.keys.PortletKeys.END_POINT_OTP_SMS, dtt.vn.user.keys.PortletKeys.XML_OTPSMS, soDienThoai, String.valueOf(otpCode));
						log.info("In DangKyQuyTrinhBusiness.luuLaiToChuc, gui tin nhan OTP thanh cong" + smsResponse);
					}else {
						log.info("InDangKyTaiKhoanBusiness.themmoiToChuc gui SMS OTP khong cho phep boi quan tri vien");
					}
					
				} catch (Exception e) {
					log.error(e.getMessage());
				}
				response.setRenderParameter("thongBaoOtpTC", "success");
				response.setRenderParameter("maOTP", String.valueOf(otpCode));
				response.setRenderParameter("userName", userName);
			}
			PortalUtil.copyRequestParameters(request, response);
			
		}
		return isSuccess;
		
	}
	
	private static String getCaptchaValueFromSession (ActionRequest request, ActionResponse response){
		PortletSession session = request.getPortletSession();
		Enumeration<String> atNames = session.getAttributeNames();
		while (atNames.hasMoreElements()) {
			String name = atNames.nextElement();
			if (name.contains(DangKyTaiKhoanKeys.Base.CAPTCHA_TEXT)) {
				return (String) session.getAttribute(name);
			}
		}
		return null;
		
	}

	private static ThongTinDangKy getMatchedThongTinDangKy(List<ThongTinDangKy> listThongTinDangKys,
			String maKichHoatMd5) {
		if (listThongTinDangKys != null && listThongTinDangKys.size() > 0) {
			for (ThongTinDangKy ttdk : listThongTinDangKys) {
				if (DangKyQuyTrinhUtil.getMd5Hash(ttdk.getMaKichHoat()).equals(maKichHoatMd5)) {
					return ttdk;
				}
			}
		}
		return null;
	}

	public static void kichHoatCongDan(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		int gender = 0;
		Account acc_cd = null;
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		List<ThongTinDangKy> listThongTinDangKys = ThongTinDangKyLocalServiceUtil.getThongTinDangKies(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		String maKichHoatMd5 = ParamUtil.getString(actionRequest, "maKichHoatMD5");
		ThongTinDangKy ttdk = getMatchedThongTinDangKy(listThongTinDangKys, maKichHoatMd5);
		boolean choPhepTaoTaiKhoan = DangKyQuyTrinhUtil.getGiaTriThamSo("CHO_PHEP_TAO_TAI_KHOAN").equals("1");
		if (ttdk != null) {
			DangKyCongDanModel model = DangKyQuyTrinhUtil.getModelFromJsonNoiDungCongDan(ttdk.getNoiDung());
			if (model != null) {
				if (choPhepTaoTaiKhoan) {
					try {
						if (model.getGioiTinhId() == 20501) {
							gender = Constantes.Gender.NAM;
						} else {
							gender = Constantes.Gender.NU;
						}
						try {
							date = formatter.parse(model.getNgaySinh());

						} catch (ParseException e) {
							e.printStackTrace();
						}
						acc_cd = AccountLocalServiceUtil.themMoi(themeDisplay.getCompanyId(),
								themeDisplay.getLayout().getGroupId(), themeDisplay.getUserId(), new Date(), new Date(),
								null, Constantes.TrangThaiKeys.Cho_Xac_Minh, Constantes.XuLy.XULY,
								Constantes.AccountType.CONG_DAN, model.getUserName(), null, model.getHoTen(), gender,
								date, model.getDiaChiChiTiet(), model.getEmail(), model.getSoCMND(),
								model.getDienThoai(), String.valueOf(model.getTinhId()),
								String.valueOf(model.getQuanHuyenId()), String.valueOf(model.getPhuongXaId()),
								Constantes.IpLevel.MUC_1, null);

						WorkItem workItem = WorkItemLocalServiceUtil.createWorkItem();
						workItem.setGroupId(themeDisplay.getLayout().getGroupId());
						workItem.setCreateDate(new Date());
						workItem.setStartTime(new Date());
						workItem.setEndTime(new Date());
						workItem.setTitle(Constantes.WorkItem.Title.TAO_MOI);
						workItem.setStatus(Constantes.WorkItem.STATUS.NEW);
						workItem.setAccountId(acc_cd.getAccountId());
						workItem.setUserId(themeDisplay.getUserId());
						WorkItemLocalServiceUtil.addWorkItem(workItem);
						log.info("__________Tao ho so CD tren Liferay thanh cong__________");
					} catch (Exception e) {
						log.error(e);
					}
					try {
						boolean choPhepTaoTaiKhoanLR = DangKyQuyTrinhUtil.getGiaTriThamSo("CHO_PHEP_TAO_TAI_KHOAN_LR").equals("1");
						if (choPhepTaoTaiKhoanLR) {
							log.info("__________Tao tai khoan cho cong dan tren Liferay...__________");
							try {
								String screename = "";
								if(ValidateData.validateEmailAddress(model.getUserName())) {
									screename = model.getUserName().split("@")[0];
								}else {
									screename = model.getUserName();
								}
								long userId = LiferayUserUtil.createUser(themeDisplay.getCompanyId(), model.getEmail(),
										screename, model.getPassword(), model.getHoTen(), false, _configuration.get("dangky.label.canhan"));
								log.info("__________Tao tai khoan cong dan thanh cong tren Liferay, userID = __________" + userId);
							} catch (PortalException e) {
								log.error(e.getMessage());
							}
						} else {
							log.info("__________Funciton tao tai khoan Liferay Off!!!__________");
						}
					} catch (Exception e) {
						log.error(e.getMessage());
					}
					try {
						boolean choPhepTaoTaiKhoanKC = DangKyQuyTrinhUtil.getGiaTriThamSo("CHO_PHEP_TAO_TAI_KHOAN_KC").equals("1");
						if (choPhepTaoTaiKhoanKC) {
							log.info("__________Tao tai khoan cho cong dan tren Keycloak...__________");
							try {
								String screename = "";
								if(ValidateData.validateEmailAddress(model.getUserName())) {
									screename = model.getUserName().split("@")[0];
								}else {
									screename = model.getUserName();
								}
								KeycloakUtils.addUser(screename, model.getEmail(), model.getPassword(),
										_configuration.get("dangky.label.canhan"), model.getHoTen(), ConvertAttributes._Convert_CD(acc_cd, 1,model.getDaYeuTo()), model.getDaYeuTo()); 
								log.info("__________Tao tai khoan cong dan thanh cong tren Keycloak __________");
							} catch (Exception e) {
								log.error(e);
							}
						} else {
							log.info("__________Funciton tao tai khoan Keycloak Off!!!__________");
						}
					} catch (Exception e) {
						log.error(e.getMessage());
					}
					DangKyQuyTrinhUtil.guiMailCapTaiKhoanCD(actionRequest, themeDisplay, model.getHoTen(), model.getEmail(), model.getPassword(), model.getUserName());
					log.info("__________Gui mail cap tai khoan thanh cong__________");
					log.info("__________Xoa thong tin dang ky trong table ttnd_thongtindangky....__________");
					ThongTinDangKyLocalServiceUtil.deleteThongTinDangKy(ttdk);
					log.info("__________Xoa thong tin dang ky trong table ttnd_thongtindangky thanh cong__________");
				}
				if (choPhepTaoTaiKhoan) {
					SessionMessages.add(actionRequest, "kichHoatThanhCong1CD");
					actionResponse.setRenderParameter("kichHoatThanhCong1CD", "success");
					actionResponse.setRenderParameter("thongbaoKichHoatCD1", "success");
					log.info("__________Kich hoat cong dan thanh cong__________");
				} else {
					SessionMessages.add(actionRequest, "kichHoatThanhCong2CD");
					actionResponse.setRenderParameter("kichHoatThanhCong2CD", "success");
					actionResponse.setRenderParameter("thongbaoKichHoatCD2", "success");
				}
			} else {
				SessionMessages.add(actionRequest, "daKichHoatCD");
				actionResponse.setRenderParameter("daKichHoatCD", "success");
				actionResponse.setRenderParameter("thongbaodaKichHoatCD", "success");
				log.info("__________Da kich hoat cong dan__________");
			}

		}

	}

	public static void kichHoatDoanhNghiep(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException {
		Account acc_tc = null;
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		List<ThongTinDangKy> listThongTinDangKys = ThongTinDangKyLocalServiceUtil.getThongTinDangKies(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		String maKichHoatMd5 = ParamUtil.getString(actionRequest, "maKichHoatMD5");
		ThongTinDangKy ttdk = getMatchedThongTinDangKy(listThongTinDangKys, maKichHoatMd5);
		boolean choPhepTaoTaiKhoan = DangKyQuyTrinhUtil.getGiaTriThamSo("CHO_PHEP_TAO_TAI_KHOAN").equals("1");
		if (ttdk != null) {
			DangKyToChucModel model = DangKyQuyTrinhUtil.getModelFromJsonNoiDungToChuc(ttdk.getNoiDung());
			if (model != null) {
				if (choPhepTaoTaiKhoan) {
					try {
						acc_tc = AccountLocalServiceUtil.themMoi(themeDisplay.getCompanyId(),
								themeDisplay.getLayout().getGroupId(), themeDisplay.getUserId(), new Date(), new Date(),
								null, Constantes.TrangThaiKeys.Cho_Xac_Minh, Constantes.XuLy.XULY,
								Constantes.AccountType.TO_CHUC, model.getUserName(), model.getNguoiDaiDien(),
								model.getTenToChuc(), 0, null, model.getDiaChiChiTiet(), model.getEmail(),
								model.getSoCMND_NDD(), model.getDienThoaiNDD(), String.valueOf(model.getTinhId()),
								String.valueOf(model.getQuanHuyenId()), String.valueOf(model.getPhuongXaId()),
								Constantes.IpLevel.MUC_1, model.getTaxCode());

						WorkItem workItem = WorkItemLocalServiceUtil.createWorkItem();
						workItem.setGroupId(themeDisplay.getLayout().getGroupId());
						workItem.setCreateDate(new Date());
						workItem.setStartTime(new Date());
						workItem.setEndTime(new Date());
						workItem.setTitle(Constantes.WorkItem.Title.TAO_MOI);
						workItem.setStatus(Constantes.WorkItem.STATUS.NEW);
						workItem.setAccountId(acc_tc.getAccountId());
						workItem.setUserId(themeDisplay.getUserId());
						WorkItemLocalServiceUtil.addWorkItem(workItem);
						log.info("__________Tao ho so TC tren LF thanh cong__________");
					} catch (Exception e) {
						log.error(e);
					}

					try {
						boolean choPhepTaoTaiKhoanLR = DangKyQuyTrinhUtil.getGiaTriThamSo("CHO_PHEP_TAO_TAI_KHOAN_LR").equals("1");
						if (choPhepTaoTaiKhoanLR) {
							log.info("__________Tao tai khoan cho to chuc trong truong hop cho phep tao tai khoan__________....");
							try {
								String screename = "";
								if(ValidateData.validateEmailAddress(model.getUserName())) {
									screename = model.getUserName().split("@")[0];
								}else {
									screename = model.getUserName();
								}
								long userId = LiferayUserUtil.createUser(themeDisplay.getCompanyId(), model.getEmail(),
										screename, model.getPassword(), model.getTenToChuc(), true, _configuration.get("dangky.label.tochuc"));
								log.info("__________tao tai khoan cho to chuc thanh cong, userId__________" + userId);
							} catch (PortalException e) {
								log.error(e.getMessage());
							}
						} else {
							log.info("__________Funciton tao tai khoan Liferay Off!!!__________");
						}
					} catch (Exception e) {
						log.error(e.getMessage());
					}

					try {
						boolean choPhepTaoTaiKhoanKC = DangKyQuyTrinhUtil.getGiaTriThamSo("CHO_PHEP_TAO_TAI_KHOAN_KC").equals("1");
						if (choPhepTaoTaiKhoanKC) {
							log.info("__________Tao tai khoan cho to chuc tren POSTID trong truong hop cho phep tao tai khoan__________....");
							try {
								String screename = "";
								if(ValidateData.validateEmailAddress(model.getUserName())) {
									screename = model.getUserName().split("@")[0];
								}else {
									screename = model.getUserName();
								}
								KeycloakUtils.addUser(screename, model.getEmail(), model.getPassword(),
										_configuration.get("dangky.label.tochuc"), model.getTenToChuc(),
										ConvertAttributes._Convert_TC(acc_tc, 1,model.getDaYeuTo()), model.getDaYeuTo());
								log.info("__________Tao tai khoan cho to chuc tren POSTID thanh cong__________");
							} catch (Exception e) {
								log.error(e);
							}
						} else {
							log.info("__________Funciton tao tai khoan Keycloak Off!!!__________");
						}
					} catch (Exception e) {
						log.error(e.getMessage());
					}
					DangKyQuyTrinhUtil.guiMailCapTaiKhoanDN(actionRequest, themeDisplay, model.getTenToChuc(), model.getEmail(), model.getPassword(), model.getUserName());
					log.info("__________Gui mail cap tai khoan to chuc thanh cong__________");
					log.info("__________Xoa thong tin dang ky trong table ttnd_thongtindangky...__________");
					ThongTinDangKyLocalServiceUtil.deleteThongTinDangKy(ttdk);
					log.info("__________Xoa thong tin dang ky thanh cong__________");
				}
				if (choPhepTaoTaiKhoan) {
					SessionMessages.add(actionRequest, "kichHoatThanhCong1DN");
					actionResponse.setRenderParameter("kichHoatThanhCong1DN", "success");
					actionResponse.setRenderParameter("thongbaokichHoatThanhCong1DN", "success");
					log.info("__________Kich hoat to chuc thanh cong__________");
				} else {
					SessionMessages.add(actionRequest, "kichHoatThanhCong2DN");
					actionResponse.setRenderParameter("kichHoatThanhCong2DN", "success");
					actionResponse.setRenderParameter("thongbaokichHoatThanhCong2DN", "success");
				}
			} else {
				SessionMessages.add(actionRequest, "daKichHoatDN");
				actionResponse.setRenderParameter("daKichHoatDN", "success");
				actionResponse.setRenderParameter("thongbaodaKichHoatDN", "success");
				log.info("__________Da kich hoat tai khoan to chuc__________");
			}
		}
	}

	public static boolean kichHoatOTPCongDan(ActionRequest request, ActionResponse response) {
		boolean success = false;
		log.info("__________Kich hoat OTP cong dan...__________");
		String userName = ParamUtil.getString(request, "userName");
		String otpText = request.getParameter("otpText");
		log.info("__________userName__________" + userName);
		log.info("__________Gia tri nhap vao__________" + otpText);
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		Account acc_cd = null;
		int gender = 0;
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		/* long companyId = themeDisplay.getCompanyId(); */
		ThongTinDangKy ttdk = null;
		ttdk = ThongTinDangKyLocalServiceUtil.getByUserName(userName);
		if (ttdk != null) {
			if (otpText.equals(ttdk.getMaKichHoat())) {
				boolean choPhepTaoTaiKhoan = DangKyQuyTrinhUtil.getGiaTriThamSo("CHO_PHEP_TAO_TAI_KHOAN").equals("1");
				if (ttdk != null) {
					DangKyCongDanModel model = DangKyQuyTrinhUtil.getModelFromJsonNoiDungCongDan(ttdk.getNoiDung());
					if (model != null) {
						if (choPhepTaoTaiKhoan) {
							try {
								if (model.getGioiTinhId() == 20501) {
									gender = Constantes.Gender.NAM;
								} else {
									gender = Constantes.Gender.NU;
								}
								try {
									date = formatter.parse(model.getNgaySinh());

								} catch (ParseException e) {
									e.printStackTrace();
								}
								acc_cd = AccountLocalServiceUtil.themMoi(themeDisplay.getCompanyId(),
										themeDisplay.getLayout().getGroupId(), themeDisplay.getUserId(), new Date(),
										new Date(), null, Constantes.TrangThaiKeys.Cho_Xac_Minh, Constantes.XuLy.XULY,
										Constantes.AccountType.CONG_DAN, model.getUserName(), null, model.getHoTen(),
										gender, date, model.getDiaChiChiTiet(), model.getEmail(), model.getSoCMND(),
										model.getDienThoai(), String.valueOf(model.getTinhId()),
										String.valueOf(model.getQuanHuyenId()), String.valueOf(model.getPhuongXaId()),
										Constantes.IpLevel.MUC_1, null);

								WorkItem workItem = WorkItemLocalServiceUtil.createWorkItem();
								workItem.setGroupId(themeDisplay.getLayout().getGroupId());
								workItem.setCreateDate(new Date());
								workItem.setStartTime(new Date());
								workItem.setEndTime(new Date());
								workItem.setTitle(Constantes.WorkItem.Title.TAO_MOI);
								workItem.setStatus(Constantes.WorkItem.STATUS.NEW);
								workItem.setAccountId(acc_cd.getAccountId());
								workItem.setUserId(themeDisplay.getUserId());
								WorkItemLocalServiceUtil.addWorkItem(workItem);
								log.info("__________Tao ho so CD tren LF thanh cong__________");
							} catch (Exception e) {
								log.error(e);
							}
							try {
								boolean choPhepTaoTaiKhoanLR = DangKyQuyTrinhUtil.getGiaTriThamSo("CHO_PHEP_TAO_TAI_KHOAN_LR").equals("1");
								if (choPhepTaoTaiKhoanLR) {
									log.info("__________Tao tai khoan cho cong dan trong truong hop cho phep tao tai khoan....__________");
									try {
										String screename = "";
										if(ValidateData.validateEmailAddress(model.getUserName())) {
											screename = model.getUserName().split("@")[0];
										}else {
											screename = model.getUserName();
										}
										long userId = LiferayUserUtil.createUser(themeDisplay.getCompanyId(),
												model.getEmail(), screename, model.getPassword(), model.getHoTen(), false, _configuration.get("dangky.label.canhan"));
										log.info("__________tao tai khoan cho cong dan thanh cong, userId = __________" + userId);
									} catch (PortalException e) {
										log.error(e.getMessage());
									}
								} else {
									log.info("__________Funciton tao tai khoan Liferay Off!!!__________");
								}
							} catch (Exception e) {
								log.error(e.getMessage());
							}
							try {
								boolean choPhepTaoTaiKhoanKC = DangKyQuyTrinhUtil.getGiaTriThamSo("CHO_PHEP_TAO_TAI_KHOAN_KC").equals("1");
								if (choPhepTaoTaiKhoanKC) {
									log.info("__________Tao tai khoan cho cong dan tren POSTID trong truong hop cho phep tao tai khoan....__________");
									try {
										String screename = "";
										if(ValidateData.validateEmailAddress(model.getUserName())) {
											screename = model.getUserName().split("@")[0];
										}else {
											screename = model.getUserName();
										}
										KeycloakUtils.addUser(screename, model.getEmail(),
												model.getPassword(), _configuration.get("dangky.label.canhan"), model.getHoTen(),
												ConvertAttributes._Convert_CD(acc_cd, 0,model.getDaYeuTo()), model.getDaYeuTo());
										log.info("__________tao tai khoan cho cong dan tren POSTID thanh cong__________");
									} catch (Exception e) {
										log.error(e);
									}
								} else {
									log.info("__________Funciton tao tai khoan Keycloak Off!!!__________");
								}
							} catch (Exception e) {
								log.error(e.getMessage());
							}
							DangKyQuyTrinhUtil.guiMailCapTaiKhoanCD(request, themeDisplay, model.getHoTen(), model.getEmail(), model.getPassword(), model.getUserName());
							log.info("__________Gui mail cap tai khoan CD thanh cong__________");
							log.info("__________Xoa thong tin dang ky trong table ttnd_thongtindangky....__________");
							ThongTinDangKyLocalServiceUtil.deleteThongTinDangKy(ttdk);
							log.info("__________Xoa thong tin dang ky thanh cong__________");
							success = true;
						}
						if (choPhepTaoTaiKhoan) {
							SessionMessages.add(request, "kichHoatThanhCong1CD");
							response.setRenderParameter("kichHoatThanhCong1CD", "success");
							response.setRenderParameter("thongbaoKichHoatCD1", "success");
						} else {
							SessionMessages.add(request, "kichHoatThanhCong2CD");
							response.setRenderParameter("kichHoatThanhCong2CD", "success");
							response.setRenderParameter("thongbaoKichHoatCD2", "success");
						}
					} else {
						SessionMessages.add(request, "daKichHoatCD");
						response.setRenderParameter("daKichHoatCD", "success");
						response.setRenderParameter("thongbaodaKichHoatCD", "success");
					}

				}
			} else {
				log.info("__________OTP khong dung__________");
				response.setRenderParameter("thongBaoOtpCD", "success");
				response.setRenderParameter("maOTP", otpText);
				response.setRenderParameter("userName", userName);
				response.setRenderParameter("error", DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_KICHHOAT_CONGDAN_OTP_INVALID);
			}

		} else {
			SessionMessages.add(request, "daKichHoatCD");
			response.setRenderParameter("daKichHoatCD", "success");
			response.setRenderParameter("thongbaodaKichHoatCD", "success");
		}
		PortalUtil.copyRequestParameters(request, response);
		return success;
	}

	public static boolean kichHoatOTPToChuc(ActionRequest request, ActionResponse response) {
		boolean sucess = false;
		log.info("__________Kich hoat OTP to chuc...__________");
		String userName = ParamUtil.getString(request, "userName");
		String otpText = request.getParameter("otpText");
		log.info("__________userName__________" + userName);
		log.info("__________Gai tri nhap vao__________" + otpText);
		Account acc_tc = null;
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		ThongTinDangKy ttdk = null;
		ttdk = ThongTinDangKyLocalServiceUtil.getByUserName(userName);
		if (ttdk != null) {
			if (otpText.equals(ttdk.getMaKichHoat())) {
				boolean choPhepTaoTaiKhoan = DangKyQuyTrinhUtil.getGiaTriThamSo("CHO_PHEP_TAO_TAI_KHOAN").equals("1");
				if (ttdk != null) {
					DangKyToChucModel model = DangKyQuyTrinhUtil.getModelFromJsonNoiDungToChuc(ttdk.getNoiDung());
					if (model != null) {
						if (choPhepTaoTaiKhoan) {
							log.info("__________tao tai khoan cho to chuc tren LF trong truong hop cho phep tao tai khoan...__________");
							try {
								acc_tc = AccountLocalServiceUtil.themMoi(themeDisplay.getCompanyId(),
										themeDisplay.getLayout().getGroupId(), themeDisplay.getUserId(), new Date(),
										new Date(), null, Constantes.TrangThaiKeys.Cho_Xac_Minh, Constantes.XuLy.XULY,
										Constantes.AccountType.TO_CHUC, model.getUserName(), model.getNguoiDaiDien(),
										model.getTenToChuc(), 0, null, model.getDiaChiChiTiet(), model.getEmail(),
										model.getSoCMND_NDD(), model.getDienThoaiNDD(),
										String.valueOf(model.getTinhId()), String.valueOf(model.getQuanHuyenId()),
										String.valueOf(model.getPhuongXaId()), Constantes.IpLevel.MUC_1,
										model.getTaxCode());

								WorkItem workItem = WorkItemLocalServiceUtil.createWorkItem();
								workItem.setGroupId(themeDisplay.getLayout().getGroupId());
								workItem.setCreateDate(new Date());
								workItem.setStartTime(new Date());
								workItem.setEndTime(new Date());
								workItem.setTitle(Constantes.WorkItem.Title.TAO_MOI);
								workItem.setStatus(Constantes.WorkItem.STATUS.NEW);
								workItem.setAccountId(acc_tc.getAccountId());
								workItem.setUserId(themeDisplay.getUserId());
								WorkItemLocalServiceUtil.addWorkItem(workItem);
								log.info("__________Them moi to chuc tren LF thanh cong__________");
							} catch (Exception e) {
								log.error(e.getMessage());
							}
							log.info("__________Tao tai khoan cho to chuc trong truong hop cho phep tao tai khoan...__________");
							try {
								boolean choPhepTaoTaiKhoanLR = DangKyQuyTrinhUtil.getGiaTriThamSo("CHO_PHEP_TAO_TAI_KHOAN_LR").equals("1");
								if (choPhepTaoTaiKhoanLR) {
									try {
										String screename = "";
										if(ValidateData.validateEmailAddress(model.getUserName())) {
											screename = model.getUserName().split("@")[0];
										}else {
											screename = model.getUserName();
										}
										long userId = LiferayUserUtil.createUser(themeDisplay.getCompanyId(),
												model.getEmail(), screename, model.getPassword(), model.getTenToChuc(), true, _configuration.get("dangky.label.tochuc"));
										log.info("__________Tao tai khoan cho to chuc thanh cong, userId =__________ "+ userId);
									} catch (PortalException e) {
										log.error(e.getMessage());
									}
								} else {
									log.info("__________Funciton tao tai khoan Liferay Off!!!__________");
								}
							} catch (Exception e) {
								log.error(e.getMessage());
							}

							try {
								boolean choPhepTaoTaiKhoanKC = DangKyQuyTrinhUtil
										.getGiaTriThamSo("CHO_PHEP_TAO_TAI_KHOAN_KC").equals("1");
								if (choPhepTaoTaiKhoanKC) {
									log.info("__________Tao tai khoan cho to chuc tren POSTID trong truong hop cho phep tao tai khoan...__________");
									try {
										String screename = "";
										if(ValidateData.validateEmailAddress(model.getUserName())) {
											screename = model.getUserName().split("@")[0];
										}else {
											screename = model.getUserName();
										}
										KeycloakUtils.addUser(screename, model.getEmail(),
												model.getPassword(), _configuration.get("dangky.label.tochuc"), model.getTenToChuc(),
												ConvertAttributes._Convert_TC(acc_tc, 0,model.getDaYeuTo()), model.getDaYeuTo());
										log.info("__________Tao tai khoan cho to chuc tren POSTID thanh cong__________");
									} catch (Exception e) {
										log.error(e);
									}
								} else {
									log.info("__________Funciton tao tai khoan Keycloak Off!!!__________");
								}
							} catch (Exception e) {
								log.error(e.getMessage());
							}
							DangKyQuyTrinhUtil.guiMailCapTaiKhoanDN(request, themeDisplay, model.getTenToChuc(), model.getEmail(), model.getPassword(), model.getUserName());
							log.info("__________Gui mail cap tai khoan TC thanh cong__________");
							log.info("__________Xoa thong tin dang ky trong bang thongtindangky...__________");
							ThongTinDangKyLocalServiceUtil.deleteThongTinDangKy(ttdk);
							log.info("__________Xoa thong tin dang ky thanh cong__________");
							sucess = true;
						}
						if (choPhepTaoTaiKhoan) {
							SessionMessages.add(request, "kichHoatThanhCong1DN");
							response.setRenderParameter("kichHoatThanhCong1DN", "success");
							response.setRenderParameter("thongbaokichHoatThanhCong1DN", "success");
							log.info("__________kich hoat to chuc thanh cong__________");
						} else {
							SessionMessages.add(request, "kichHoatThanhCong2DN");
							response.setRenderParameter("kichHoatThanhCong2DN", "success");
							response.setRenderParameter("thongbaokichHoatThanhCong2DN", "success");
						}
					} else {
						SessionMessages.add(request, "daKichHoatDN");
						response.setRenderParameter("daKichHoatDN", "success");
						response.setRenderParameter("thongbaodaKichHoatDN", "success");
						log.info("__________da kich hoat tai khoan to chuc__________");

					}

				}

			} else {
				log.info("__________OTP khong dung__________");
				response.setRenderParameter("thongBaoOtpTC", "success");
				response.setRenderParameter("maOTP", otpText);
				response.setRenderParameter("userName", userName);
				response.setRenderParameter("error",DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_KICHHOAT_TOCHUC_OTP_INVALID);
			}
		}
		return sucess;

	}
}
