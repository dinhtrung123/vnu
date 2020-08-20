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
package dtt.vn.user.thongtintaikhoan.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.IOException;

import org.oep.core.model.MappingVmap;
import org.oep.core.service.MappingVmapLocalServiceUtil;
import org.osgi.service.component.annotations.Component;

import dtt.vn.user.business.DangKyTaiKhoanBusiness;
import dtt.vn.user.common.utils.DateUtil;
import dtt.vn.user.keycloak.connect.KeycloakUtils;
import dtt.vn.user.utils.MyLanguageUtil;
import dtt.vn.vnpost.model.Account;
import dtt.vn.vnpost.service.AccountLocalServiceUtil;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=ThongTinTKDVC",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.display-name=ThongTinTaiKhoanDVCPortlet",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.init-param.view-template=/thongtintaikhoandvcportlet/view.jsp"
	},
	service = Portlet.class
)
public class ThongTinTaiKhoanDVCPortlet extends MVCPortlet {
	private static Log log = LogFactoryUtil.getLog(ThongTinTaiKhoanDVCPortlet.class);
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		// TODO Auto-generated method stub
		super.doView(renderRequest, renderResponse);
	}
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException{
		String resourceId = resourceRequest.getResourceID();
		if("getQuanHuyenByTinhThanh".equals(resourceId)){
			try{
				DangKyTaiKhoanBusiness.getQuanHuyenByTinhThanh(resourceRequest, resourceResponse);
			}catch(IOException e){
				e.printStackTrace();
			}
		}else if("getPhuongXaByQuanHuyen".equals(resourceId)){
			try{
				DangKyTaiKhoanBusiness.getPhuongXaByQuanHuyen(resourceRequest, resourceResponse);
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	public void actionMethodSaveViTri(ActionRequest request, ActionResponse response) {
		int message = 0;
		boolean iserror = true;
		HttpServletRequest request1 = PortalUtil.getHttpServletRequest(request);
		try {
			String longvitri  = ParamUtil.getString(request, "longvitri","");
			String latvitri 			 = ParamUtil.getString(request, "latvitri","");
			long accountidvitri      = ParamUtil.getLong(request, "accountidvitri",0);
			
			
			if(longvitri.equals("") || latvitri.equals("")|| accountidvitri == 0) {
				message =0;
			}else {
				MappingVmap vmap = null;
				if(MappingVmapLocalServiceUtil.getToaDo(Account.class.getName(), accountidvitri)!=null) {
					vmap =MappingVmapLocalServiceUtil.updateToaDo(Account.class.getName(), accountidvitri, latvitri, longvitri, "");	
				}else {
					 vmap =MappingVmapLocalServiceUtil.addMapping(Account.class.getName(),accountidvitri, latvitri, longvitri, "");	
				}
				if(vmap == null) {
					//khong thanh cong
					message =1;
				}else {
					//thanh cong
					iserror = false;
					message =2;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			message =3;
		}
		request.setAttribute("message", MyLanguageUtil.get(request1, request.getLocale(), "thongtindinhdanh.message."+message));
		request.setAttribute("iserror", iserror);
	}
	public void actionMethodSave(ActionRequest request, ActionResponse response) {
		try {
			//System.out.println("Ä�Ã£ vÃ o save");
			long accountid = ParamUtil.getLong(request, "accountidedit",0);
			long userid = ParamUtil.getLong(request, "useridedit",0);
			String hoten = ParamUtil.getString(request, "hoten","").trim();
			int gioitinh = ParamUtil.getInteger(request, "gioitinh",0);
			String ngaysinh = ParamUtil.getString(request, "ngaysinh","").trim();
			String sdt = ParamUtil.getString(request, "sdt","").trim();
			String matinh = ParamUtil.getString(request,"matinh","").trim();
			String mahuyen = ParamUtil.getString(request,"mahuyen","").trim();
			String maxa = ParamUtil.getString(request,"maxa","").trim();
			String machitiet =  ParamUtil.getString(request, "machitiet","").trim();
			
			Account acc = AccountLocalServiceUtil.getAccount(accountid);
			if(acc != null) {
				acc.setFullName(hoten);
				acc.setGender(gioitinh);
				acc.setBirthdate(DateUtil.parseStringToDate(ngaysinh, DateUtil.DATE_FORMAT_D_M_Y));
				acc.setTelNo(sdt);
				if(!matinh.equals("") && !mahuyen.equals("") && !maxa.equals("") && !machitiet.equals("")) {
					acc.setCityCode(matinh);
					acc.setDistrictCode(mahuyen);
					acc.setWardCode(maxa);
					acc.setAddress(machitiet);
				}
				acc = AccountLocalServiceUtil.updateAccount(acc);
				if(acc == null) {
					log.info("CAP NHAT TAI KHOAN KHONG THANH CONG");
				}else {
					log.info("CAP NHAT TAI KHOAN THANH CONG");
					User userliferay = UserLocalServiceUtil.getUser(userid);
					userliferay.setLastName(hoten);
					userliferay = UserLocalServiceUtil.updateUser(userliferay);
					if(userliferay != null) {
						KeycloakUtils.updateUser(accountid, 1, "XTSMARTOTP");
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}