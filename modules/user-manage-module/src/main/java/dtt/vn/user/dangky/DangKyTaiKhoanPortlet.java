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
package dtt.vn.user.dangky;

//import com.liferay.portal.kernel.captcha.CaptchaTextException;
import com.liferay.portal.kernel.captcha.CaptchaUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
//import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import dtt.vn.user.business.DangKyTaiKhoanBusiness;
import dtt.vn.user.keys.DangKyTaiKhoanKeys;

@SuppressWarnings("deprecation")
@Component(
	immediate = true,
	property = {
        "com.liferay.portlet.display-category=DangKyTaiKhoan",
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
        "javax.portlet.display-name=DangKyTaiKhoanPortlet",
        "javax.portlet.resource-bundle=content.Language",
        "javax.portlet.security-role-ref=administrator,power-user,user,guest",
        "javax.portlet.init-param.view-template=/dangkytaikhoanportlet/view.jsp"
    },
    service = Portlet.class
)
public class DangKyTaiKhoanPortlet extends MVCPortlet {
	private static Log log = LogFactoryUtil.getLog(DangKyTaiKhoanPortlet.class);
	
	/*public void first(ActionRequest actionRequest,ActionResponse actionResponse) throws IOException, PortletException {
		boolean isSucess = false;
		try {
			CaptchaUtil.check(actionRequest);
			log.info("__________CAPTCHA verification successful__________");
			isSucess = DangKyTaiKhoanBusiness._doDangKy_CongDan(actionRequest, actionResponse);
			actionRequest.setAttribute("isSucess", isSucess);
			SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			PortalUtil.copyRequestParameters(actionRequest, actionResponse);
			
		} catch (Exception exception) {
			if (exception instanceof CaptchaTextException) {
				SessionErrors.add(actionRequest, exception.getClass(), exception);
				log.error("__________CAPTCHA verification failed__________");
			}
		}
		actionRequest.setAttribute("selectedTab", DangKyTaiKhoanKeys.Tabs.CongDan_Tab);
	}
		
	public void second(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
		boolean isSucess = false;
		try {
			CaptchaUtil.check(actionRequest);
			log.info("__________CAPTCHA verification successful__________");
			isSucess = DangKyTaiKhoanBusiness._doDangKy_ToChuc(actionRequest, actionResponse);
			actionRequest.setAttribute("isSucess", isSucess);
			SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			PortalUtil.copyRequestParameters(actionRequest, actionResponse);
			
		} catch (Exception exception) {
			if (exception instanceof CaptchaTextException) {
				SessionErrors.add(actionRequest, exception.getClass(), exception);
				log.error("__________CAPTCHA verification failed__________");
			}
		}
		actionRequest.setAttribute("selectedTab", DangKyTaiKhoanKeys.Tabs.ToChuc_Tab);
	}*/
	public void first(ActionRequest request,ActionResponse response) throws IOException, PortletException {
		boolean isSucess = false;
		 isSucess = DangKyTaiKhoanBusiness._doDangKy_CongDan(request, response);
		 request.setAttribute("isSucess", isSucess);
		SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		PortalUtil.copyRequestParameters(request, response);
		request.setAttribute("selectedTab",DangKyTaiKhoanKeys.Tabs.CongDan_Tab);
		}
		
	public void second(ActionRequest request,ActionResponse response) throws IOException, PortletException {
		boolean isSucess = false;
		isSucess = DangKyTaiKhoanBusiness._doDangKy_ToChuc(request, response);
		 request.setAttribute("isSucess", isSucess);
		SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		PortalUtil.copyRequestParameters(request, response);
		request.setAttribute("selectedTab", DangKyTaiKhoanKeys.Tabs.ToChuc_Tab);
		}
	
	public void kichHoatDoanhNghiep(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException{
		DangKyTaiKhoanBusiness.kichHoatDoanhNghiep(actionRequest, actionResponse);
	}
	
	public void kichHoatCongDan(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException{
		DangKyTaiKhoanBusiness.kichHoatCongDan(actionRequest, actionResponse);
	}
	public void kichHoatOTPCongDan(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException{
		boolean sucess = false;
		sucess = DangKyTaiKhoanBusiness.kichHoatOTPCongDan(actionRequest, actionResponse);
		actionRequest.setAttribute("isSucess", sucess);
		PortalUtil.copyRequestParameters(actionRequest, actionResponse);
	}
	public void kichHoatOTPToChuc(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException{
		boolean sucess = false;
		DangKyTaiKhoanBusiness.kichHoatOTPToChuc(actionRequest, actionResponse);
		actionRequest.setAttribute("isSucess", sucess);
		PortalUtil.copyRequestParameters(actionRequest, actionResponse);
	}
	public void guiLaiOTP(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException{
		log.info("gui lai OTP");
	}
	
	
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException{
		String resourceId = resourceRequest.getResourceID();
		if("getQuanHuyenByTinhThanh".equals(resourceId)){
			try{
				DangKyTaiKhoanBusiness.getQuanHuyenByTinhThanh(resourceRequest, resourceResponse);
			}catch(IOException e){
				log.error(e);
			}
		}else if("getPhuongXaByQuanHuyen".equals(resourceId)){
			try{
				DangKyTaiKhoanBusiness.getPhuongXaByQuanHuyen(resourceRequest, resourceResponse);
			}catch(IOException e){
				log.error(e);
			}
		}else if("getQuanHuyenByTinhThanhToChuc".equals(resourceId)){
			try{
				DangKyTaiKhoanBusiness.getQuanHuyenByTinhThanh_ToChuc(resourceRequest, resourceResponse);
			}catch(SystemException e){
				log.error(e);
			}catch(IOException e){
				log.error(e);
			}
		}else if("getPhuongXaByQuanHuyenToChuc".equals(resourceId)){
			try{
				DangKyTaiKhoanBusiness.getPhuongXaByQuanHuyen_ToChuc(resourceRequest, resourceResponse);
			}catch(SystemException e){
				log.error(e);
			}catch(IOException e){
				log.error(e);
			}
		}else {
			try {
				CaptchaUtil.serveImage(resourceRequest, resourceResponse);
			} catch (Exception e) {
				log.error(e);
			}
		}
	}
	

	
	}