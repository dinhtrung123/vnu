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
package dtt.vn.pheduyet.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;

import com.google.gson.Gson;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import dtt.vn.account.util.AccountUtil;
import dtt.vn.account.util.KeycloakUtils;
import dtt.vn.account.util.MyLanguageUtil;
import dtt.vn.account.util.PortletKeysUtil;
import dtt.vn.account.util.QRUtils;
import dtt.vn.pheduyet.business.PheDuyetBusiness;
import dtt.vn.vnpost.model.Account;
import dtt.vn.vnpost.model.WorkItem;
import dtt.vn.vnpost.service.AccountLocalServiceUtil;
import dtt.vn.vnpost.service.WorkItemLocalServiceUtil;
import dtt.vn.pheduyet.business.YkienCanBoObject;

import org.osgi.service.component.annotations.Component;
@Component(
	immediate = true,
	property = {
        "com.liferay.portlet.display-category=IdmPortlet",
        "com.liferay.portlet.instanceable=true",
        "com.liferay.portlet.header-portlet-css=/css/main.css",
        "com.liferay.portlet.footer-portlet-javascript=/js/jQueryRotate.js",
        "javax.portlet.display-name=PheDuyetPortlet",
        "javax.portlet.init-param.template-path=/",
        "javax.portlet.resource-bundle=content.Language",
        "javax.portlet.security-role-ref=power-user,user",
        "javax.portlet.init-param.view-template=/pheduyetportlet/view.jsp"
    },
    service = Portlet.class
)
public class PheDuyetPortlet extends MVCPortlet {
	private static Log log = LogFactoryUtil.getLog(PheDuyetPortlet.class.getName());
	@Override
	public void render(RenderRequest renderRequest,	RenderResponse renderResponse) throws PortletException, IOException {

		try {
			AccountUtil.getAccount(renderRequest);
			super.render(renderRequest, renderResponse);
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		PrintWriter writer = resourceResponse.getWriter();
		String resourceId = resourceRequest.getResourceID();
		if(resourceId.equals("viewqrcode")) {
			String dataqr = ParamUtil.getString(resourceRequest, "dataqr","");
			byte[] qrCode = QRUtils.generateQRCodeImage(dataqr, 500, 500);
			 String base64qr = DatatypeConverter.printBase64Binary(qrCode);
	            writer.write(base64qr);
		}
	}
	
	public void actionPheDuyet(ActionRequest request, ActionResponse actionResponse){
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		HttpServletRequest request1 = PortalUtil.getHttpServletRequest(request);
		String ykiencanbopheduyet = ParamUtil.getString(request, "ykiencanbopheduyet","").trim();
		long accountID            = ParamUtil.getLong(request, "acid",0);
		long pheDuyet             = ParamUtil.getLong(request, "pheduyet",-1);
		
		try {
			Account account = AccountLocalServiceUtil.getAccount(accountID);
			String messageaccount = account.getMessage();
			YkienCanBoObject ykien = new YkienCanBoObject();
			if(!messageaccount.equals("")){
				ykien = new Gson().fromJson(messageaccount, YkienCanBoObject.class);
			}
			ykien.yKienCanBoPheDuyet = ykiencanbopheduyet;
			account.setMessage(new Gson().toJson(ykien));
			int ipLevelTuChoiDuyet = 1;
			int ipLevelDongYDuyet  = 3;
			if(pheDuyet == 0){
				account.setAccountStatus(PortletKeysUtil.TrangThaiKeys.Da_Tra_KQ_Khong_Hop_Le);
				request.setAttribute("message", MyLanguageUtil.get(request1, request.getLocale(), "dtt.vn.pheduyet.message.tuchoi"));
				account.setIpLevel(ipLevelTuChoiDuyet);
				AccountLocalServiceUtil.updateAccount(account);
				try {
					log.info("Thuc hien gui mail thong bao PHE DUYET TU CHOI........");
					PheDuyetBusiness.sendMailThongBaoPheDuyetSai(themeDisplay, account.getEmail(), account.getFullName(), account.getAccountName());
					log.info("Thuc hien gui mail thong bao PHE DUYET TU CHOI thanh cong");
					KeycloakUtils.updateUser(accountID, ipLevelTuChoiDuyet);
				} catch (Exception e) {
					log.error(e.getMessage());
				}
			}
			if(pheDuyet == 1){
				account.setAccountStatus(PortletKeysUtil.TrangThaiKeys.Cap_Chung_Nhan_Dinh_Danh);
				request.setAttribute("message", MyLanguageUtil.get(request1, request.getLocale(), "dtt.vn.pheduyet.message.success"));
				account.setModifiedDate(new Date());
				account.setIpLevel(ipLevelDongYDuyet);
				AccountLocalServiceUtil.updateAccount(account);
				try {
					log.info("Thuc hien gui mail thong bao phe duyet DONG Y........");
					PheDuyetBusiness.sendMailThongBaoPheDuyetDung(themeDisplay, account.getEmail(), account.getFullName(), account.getAccountName());
					log.info("Thuc hien gui mail thong bao phe duyet DONG Y thanh cong");
					KeycloakUtils.updateUser(accountID, ipLevelDongYDuyet);
				} catch (Exception e) {
					log.error(e.getMessage());
				}
			}
			boolean isSucess = true;
			request.setAttribute("isSucess", isSucess);
			
			
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doAddWorkiTem(ActionRequest request) throws SystemException {
    	long accountId = ParamUtil.getLong(request, "accountId");
    	ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		WorkItem workItem = WorkItemLocalServiceUtil.getWorkItemByAccountId(accountId);
		workItem.setEndTime(new Date());
		workItem.setUserId(themeDisplay.getUserId());
		workItem.setStatus("COMPLETE");
		WorkItemLocalServiceUtil.updateWorkItem(workItem);
		
		// Insert new Item
		workItem = WorkItemLocalServiceUtil.createWorkItem();
		workItem.setGroupId(themeDisplay.getLayout().getGroupId());
		workItem.setCreateDate(new Date());
		workItem.setStartTime(new Date());
		
		workItem.setTitle("Xử lý hồ sơ");
		workItem.setStatus("NEW");
		workItem.setAccountId(accountId);			
		WorkItemLocalServiceUtil.addWorkItem(workItem);
		
	}
	
}