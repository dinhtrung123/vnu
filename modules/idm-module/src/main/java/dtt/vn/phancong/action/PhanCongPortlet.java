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
package dtt.vn.phancong.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import dtt.vn.account.business.Constantes;
import dtt.vn.account.util.MessageUtils;
import dtt.vn.vnpost.model.Account;
import dtt.vn.vnpost.model.WorkItem;
import dtt.vn.vnpost.service.AccountLocalServiceUtil;
import dtt.vn.vnpost.service.WorkItemLocalServiceUtil;


import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
        "com.liferay.portlet.display-category=IdmPortlet",
        "com.liferay.portlet.instanceable=true",
        "com.liferay.portlet.header-portlet-css=/css/main.css",
        "com.liferay.portlet.footer-portlet-javascript=/js/main.js",
        "javax.portlet.display-name=Phan Cong",
        "javax.portlet.init-param.template-path=/",
        "javax.portlet.resource-bundle=content.Language",
        "javax.portlet.security-role-ref=power-user,user",
        "javax.portlet.init-param.view-template=/phancongportlet/view.jsp"
    },
    service = Portlet.class
)
public class PhanCongPortlet extends MVCPortlet {
	//
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		// TODO Auto-generated method stub
		String resourceID = resourceRequest.getResourceID();
		System.out.println(resourceID);
		PrintWriter writer = resourceResponse.getWriter();
		writer.write("1");
	}
	public void phanCongXuLy(ActionRequest request, ActionResponse response) {
	    try {
        	doPhanCong(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            SessionErrors.add(request, "aceitem-add-tech-error");
            
            PortalUtil.copyRequestParameters(request, response);
            MessageUtils.hideDefualtErrorMessage(request);
            response.setRenderParameter("jspPage", "/phancongportlet/view.jsp");
            
        }		  
	  
	}
	
	
	  private void doPhanCong(ActionRequest request, ActionResponse response) throws Exception {
		  
			long accountId = ParamUtil.getLong(request, "accountId");
			long userId = ParamUtil.getLong(request, "userId");
			
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			
			try {
				Account account = AccountLocalServiceUtil.fetchAccount(accountId);
				account.setAssignUserId(userId);
				account.setProcessStatus(Constantes.XuLy.XULY);
				AccountLocalServiceUtil.updateAccount(account);  
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
				workItem.setAccountId(account.getAccountId());			
				WorkItemLocalServiceUtil.addWorkItem(workItem);
				
				MessageUtils.hideDefualtSuccessMessage(request);
			} catch ( SystemException e) {
				e.printStackTrace();
			}
		  
	
		  MessageUtils.hideDefualtSuccessMessage(request);
		  response.setRenderParameter("jspPage", "/html/phancong/view.jsp");
	  }
}