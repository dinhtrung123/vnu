/**
 * Copyright 2000-present Liferay, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dtt.vn.user.dangky.kichhoat;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import dtt.vn.user.business.DangKyTaiKhoanBusiness;
import dtt.vn.user.business.OtpServices;
import dtt.vn.user.business.SmsServices;
import dtt.vn.user.dangky.DangKyTaiKhoanPortlet;
import dtt.vn.user.keys.DangKyTaiKhoanKeys;
import dtt.vn.user.keys.KichHoatTaiKhoanKeys;
import dtt.vn.user.model.DangKyCongDanModel;
import dtt.vn.user.model.DangKyToChucModel;
import dtt.vn.user.service.model.ThongTinDangKy;
import dtt.vn.user.service.service.ThongTinDangKyLocalServiceUtil;
import dtt.vn.user.utils.DangKyQuyTrinhUtil;
import dtt.vn.user.vmap.connect.VmapSearchAPI;

import org.oep.danhmuc.model.DanhMuc;
import org.oep.danhmuc.service.DanhMucLocalServiceUtil;
import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
        "com.liferay.portlet.display-category=KichHoatTaiKhoan",
        
        "com.liferay.portlet.header-portlet-css=/css/oep-style.css",
        "com.liferay.portlet.header-portlet-javascript=/js/main.js",
        "com.liferay.portlet.header-portlet-javascript=/js/oep-commons.js",
        "com.liferay.portlet.header-portlet-javascript=/js/multiple-select.js",
        "com.liferay.portlet.header-portlet-javascript=/js/bootstrap.js",
        "com.liferay.portlet.header-portlet-javascript=/js/bootstrap-select.js",
        "com.liferay.portlet.header-portlet-javascript=/js/jquery-1.11.3.min.js",
        "com.liferay.portlet.header-portlet-javascript=/js/jquery-1.9.1.min.js",
        "com.liferay.portlet.header-portlet-javascript=/js/jquery.ui.core.js",
        "com.liferay.portlet.header-portlet-javascript=/js/jquery.ui.timepicker.js",
        "com.liferay.portlet.instanceable=false",
        "com.liferay.portlet.private-request-attributes=false",
		"com.liferay.portlet.private-session-attributes=false",
		"com.liferay.portlet.layout-cacheable=false",
        "javax.portlet.init-param.template-path=/",
        "javax.portlet.display-name=KichHoatTaiKhoanPortlet",
        "javax.portlet.resource-bundle=content.Language",
        "javax.portlet.security-role-ref=administrator,power-user,user,guest",
        "javax.portlet.init-param.view-template=/kichhoattaikhoanportlet/view.jsp"
    },
    service = Portlet.class
)
	public class KichHoatTaiKhoanPortlet extends MVCPortlet {
	
		private static Log log = LogFactoryUtil.getLog(KichHoatTaiKhoanPortlet.class);
		
		
		public void kichHoatTaiKhoanCD (ActionRequest request , ActionResponse response){
			log.info("kich Hoat Lai Tai Khoan CD.......");
			DangKyTaiKhoanBusiness.kichHoatCongDan(request, response);
		}
		
		public void kichHoatTaiKhoanTC (ActionRequest request , ActionResponse response){
			log.info("kich Hoat Lai Tai Khoan CD.......");
			DangKyTaiKhoanBusiness.kichHoatDoanhNghiep(request, response);
		}
		
		
	
		public void guiLaiMaKichHoat (ActionRequest request , ActionResponse response){
			
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			boolean isSuccess = false;
			String userName = request.getParameter("userName");
			String matKhau = request.getParameter("matKhau");
			String hinhThucNhanMaKH = request.getParameter("HinhThucKichHoat");
			String maKichHoatEMAIL = ParamUtil.getString(request, KichHoatTaiKhoanKeys.KichHoat.MA_KICHHOAT);
			String kichHoatCDUrl = ParamUtil.getString(request, KichHoatTaiKhoanKeys.KichHoat.KICHHOAT_CD_URL);
			String kichHoatTCUrl = ParamUtil.getString(request, KichHoatTaiKhoanKeys.KichHoat.KICHHOAT_TC_URL);
			DanhMuc checkKH = DanhMucLocalServiceUtil.getByM(hinhThucNhanMaKH);
			
			ThongTinDangKy thongTinDangKy = null;
			thongTinDangKy = ThongTinDangKyLocalServiceUtil.getByUserName(userName);
			if(thongTinDangKy != null){
				int doiTuongSuDungId = thongTinDangKy.getDoiTuongSuDungId();
				if(doiTuongSuDungId == 1){
					DangKyCongDanModel modelCD = null;
					log.info("In KICHHOAT_TAIKHOAN_PORTLET : guiLaiMaKichHoat Convert Model : Cong Dan..........");
					modelCD = DangKyQuyTrinhUtil.getModelFromJsonNoiDungCongDan(thongTinDangKy.getNoiDung());
					log.info("In KICHHOAT_TAIKHOAN_PORTLET : guiLaiMaKichHoat Convert Model : Cong Dan thanh cong");
					
					if(modelCD != null){
						isSuccess = matKhau.equals(modelCD.getPassword());
						if(isSuccess == true){
							if(checkKH.getMa().equals("THKHTKEMAIL")){
								log.info("In KICHHOAT_TAIKHOAN_PORTLET : guiLaiMaKichHoat hinh thuc kich hoat Cong Dan: EMAIL");
								log.info("In KICHHOAT_TAIKHOAN_PORTLET : guiLaiMaKichHoat update Ma kich hoat Cong Dan.....");
								thongTinDangKy.setMaKichHoat(maKichHoatEMAIL);
								thongTinDangKy.setActiveType("email");
								ThongTinDangKyLocalServiceUtil.updateThongTinDangKy(thongTinDangKy);
								log.info("In KICHHOAT_TAIKHOAN_PORTLET : guiLaiMaKichHoat update Ma kich hoat thanh cong");
								log.info("In KICHHOAT_TAIKHOAN_PORTLET : guiLaiMaKichHoat Gui Mail kich hoat tai khoan : Cong Dan..........");
								DangKyQuyTrinhUtil.guiMailKichHoatCongDan(request, themeDisplay, modelCD.getHoTen(), modelCD.getEmail(), kichHoatCDUrl);
								log.info("In KICHHOAT_TAIKHOAN_PORTLET : guiLaiMaKichHoat Gui Mail kich hoat tai khoan : Cong Dan thanh cong");
								response.setRenderParameter("thongBaoTaoTaiKhoanCD", "success");
								response.setRenderParameter("hienthongbaoTTKCD", "success");
							}
							if(checkKH.getMa().equals("THKHTKSMS")){
								log.info("In KICHHOAT_TAIKHOAN_PORTLET : guiLaiMaKichHoat hinh thuc kich hoat Cong Dan: SMS");
								log.info("In KICHHOAT_TAIKHOAN_PORTLET : guiLaiMaKichHoat update Ma kich hoat Cong Dan.....");
								OtpServices otp = new OtpServices();
								log.info("key otp : "+thongTinDangKy.getUserName());
								int otpCode = otp.generateOTP(thongTinDangKy.getUserName());
								log.info("ma otp : "+String.valueOf(otpCode));
								thongTinDangKy.setMaKichHoat(String.valueOf(otpCode));
								thongTinDangKy.setActiveType("sms");
								ThongTinDangKyLocalServiceUtil.updateThongTinDangKy(thongTinDangKy);
								log.info("In KICHHOAT_TAIKHOAN_PORTLET : guiLaiMaKichHoat update Ma kich hoat thanh cong");
								try {
									boolean choPhepGuiOTP = DangKyQuyTrinhUtil.getGiaTriThamSo("CHO_PHEP_GUI_OTP_SMS").equals("1");
									if(choPhepGuiOTP){
										String smsResponse = SmsServices.sendSMS(dtt.vn.user.keys.PortletKeys.END_POINT_OTP_SMS, dtt.vn.user.keys.PortletKeys.XML_OTPSMS, modelCD.getDienThoai(), String.valueOf(otpCode));
										log.info("In KICHHOAT_TAIKHOAN_PORTLET.guiLaiMaKichHoat, gui tin nhan OTP thanh cong" + smsResponse);
									}else {
										log.info("KICHHOAT_TAIKHOAN_PORTLET.guiLaiMaKichHoat gui SMS OTP khong cho phep boi quan tri vien");
									}
								} catch (Exception e) {
									log.error(e.getMessage());
								}
								response.setRenderParameter("thongBaoOtpTC", "success");
								response.setRenderParameter("maOTP", String.valueOf(otpCode));
								response.setRenderParameter("userName", modelCD.getUserName());
							}
						}else {
							response.setRenderParameter("error", DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_KICHHOAT_CONGDAN_OTP_INVALID);
						}
						
						
					}else {
						log.info("In KICHHOAT_TAIKHOAN_PORTLET : guiLaiMaKichHoat : Convert modelCD xay ra loi : model null");
					}
				}
				if(doiTuongSuDungId == 2){
					log.info("In KICHHOAT_TAIKHOAN_PORTLET : guiLaiMaKichHoat Convert Model : To Chuc..........");
					DangKyToChucModel modelTC = DangKyQuyTrinhUtil.getModelFromJsonNoiDungToChuc(thongTinDangKy.getNoiDung());
					log.info("In KICHHOAT_TAIKHOAN_PORTLET : guiLaiMaKichHoat Convert Model : To Chuc thanh cong");
					if(modelTC != null){
						isSuccess = matKhau.equals(modelTC.getPassword());
						if(isSuccess == true){
							if(checkKH.getMa().equals("THKHTKEMAIL")){
								log.info("In KICHHOAT_TAIKHOAN_PORTLET : guiLaiMaKichHoat hinh thuc kich hoat To Chuc: EMAIL");
								log.info("In KICHHOAT_TAIKHOAN_PORTLET : guiLaiMaKichHoat update Ma kich hoat To Chuc.....");
								thongTinDangKy.setMaKichHoat(maKichHoatEMAIL);
								thongTinDangKy.setActiveType("email");
								ThongTinDangKyLocalServiceUtil.updateThongTinDangKy(thongTinDangKy);
								log.info("In KICHHOAT_TAIKHOAN_PORTLET : guiLaiMaKichHoat update Ma kich hoat thanh cong");
								log.info("In KICHHOAT_TAIKHOAN_PORTLET : guiLaiMaKichHoat Gui Mail kich hoat tai khoan : To Chuc..........");
								DangKyQuyTrinhUtil.guiMailKichHoatDoanhNghiep(request, themeDisplay, modelTC.getTenToChuc(), modelTC.getTaxCode(), modelTC.getEmail(), kichHoatTCUrl);
								log.info("In KICHHOAT_TAIKHOAN_PORTLET : guiLaiMaKichHoat Gui Mail kich hoat tai khoan : To Chuc thanh cong");
								response.setRenderParameter("thongBaoTaoTaiKhoanDN", "success");
								response.setRenderParameter("hienthongbaoTTKDN", "success");
							}
							if(checkKH.getMa().equals("THKHTKSMS")){
								log.info("In KICHHOAT_TAIKHOAN_PORTLET : guiLaiMaKichHoat hinh thuc kich hoat To Chuc: SMS");
								log.info("In KICHHOAT_TAIKHOAN_PORTLET : guiLaiMaKichHoat update Ma kich hoat To Chuc.....");
								OtpServices otp = new OtpServices();
								log.info("key otp : "+modelTC.getUserName());
								int otpCode = otp.generateOTP(modelTC.getUserName());
								log.info("ma otp : "+String.valueOf(otpCode));
								thongTinDangKy.setMaKichHoat(String.valueOf(otpCode));
								thongTinDangKy.setActiveType("sms");
								ThongTinDangKyLocalServiceUtil.updateThongTinDangKy(thongTinDangKy);
								log.info("In KICHHOAT_TAIKHOAN_PORTLET : guiLaiMaKichHoat update Ma kich hoat thanh cong");
								try {
									boolean choPhepGuiOTP = DangKyQuyTrinhUtil.getGiaTriThamSo("CHO_PHEP_GUI_OTP_SMS").equals("1");
									if(choPhepGuiOTP){
										String smsResponse = SmsServices.sendSMS(dtt.vn.user.keys.PortletKeys.END_POINT_OTP_SMS, dtt.vn.user.keys.PortletKeys.XML_OTPSMS, modelTC.getDienThoaiNDD(), String.valueOf(otpCode));
										log.info("In KICHHOAT_TAIKHOAN_PORTLET.guiLaiMaKichHoat, gui tin nhan OTP thanh cong" + smsResponse);
									}else {
										log.info("KICHHOAT_TAIKHOAN_PORTLET.guiLaiMaKichHoat gui SMS OTP khong cho phep boi quan tri vien");
									}
								} catch (Exception e) {
									log.error(e.getMessage());
								}
								response.setRenderParameter("thongBaoOtpTC", "success");
								response.setRenderParameter("maOTP", String.valueOf(otpCode));
								response.setRenderParameter("userName", modelTC.getUserName());
							}
						}
					}else {
						log.info("In KICHHOAT_TAIKHOAN_PORTLET : guiLaiMaKichHoat : Convert modelTC xay ra loi : model null");
					}
				}
			}else {
				response.setRenderParameter("error", DangKyTaiKhoanKeys.ErrorMessageKeys.DTT_VN_USER_KICHHOAT_CONGDAN_OTP_INVALID);
			}
			
			request.setAttribute("isSucess", isSuccess);
			SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			PortalUtil.copyRequestParameters(request, response);
		}
		
		
		
		
		
		public void kichHoatOTP (ActionRequest request, ActionResponse response){
			boolean sucess = false;
			String userName = ParamUtil.getString(request, "userName");
			ThongTinDangKy ttdk = null;
			ttdk = ThongTinDangKyLocalServiceUtil.getByUserName(userName);
			if(ttdk != null){
				int doiTuongSuDungId = ttdk.getDoiTuongSuDungId();
				if(doiTuongSuDungId == 1){
					sucess = DangKyTaiKhoanBusiness.kichHoatOTPCongDan(request, response);
					request.setAttribute("isSucess", sucess);
				}else if(doiTuongSuDungId == 2){
					sucess = DangKyTaiKhoanBusiness.kichHoatOTPToChuc(request, response);
					request.setAttribute("isSucess", sucess);
				}
			}
			PortalUtil.copyRequestParameters(request, response);
		}
		
	}




















