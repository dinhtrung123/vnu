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
package org.oep.core.thamso.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import org.oep.core.model.ThamSo;
import org.oep.core.service.ThamSoLocalServiceUtil;
import org.oep.core.service.util.LiferayOrganizationUtil;
import org.oep.util.PortletKeys;
import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
        "com.liferay.portlet.display-category=Quan Tri He Thong",
        "com.liferay.portlet.header-portlet-css=/css/main.css",
        "com.liferay.portlet.footer-portlet-javascript=/js/main.js",
        "com.liferay.portlet.instanceable=true",
        "javax.portlet.init-param.template-path=/",
        "javax.portlet.display-name=QuanTriThamSo",
        "javax.portlet.resource-bundle=content.Language",
        "javax.portlet.security-role-ref=power-user,user",
        "javax.portlet.init-param.view-template=/quanlythamsoportlet/view.jsp"
    },
    service = Portlet.class
)
public class QuanLyThamSoPortlet extends MVCPortlet {
	private static Log log = LogFactoryUtil.getLog(QuanLyThamSoPortlet.class);
	
	
	public void deleteParam(ActionRequest actionRequest, ActionResponse actionResponse) {
		long id = ParamUtil.getLong(actionRequest, "thamSoId");
		
		try {
			ThamSo param = ThamSoLocalServiceUtil.getThamSo(id);
			ThamSoLocalServiceUtil.deleteThamSo(param);
		} catch (Exception e) {
			SessionErrors.add(actionRequest, "org.oep.core.portlet.thamso.error.generic");
			log.error(e);
		}
	}
	
	public void addParam(ActionRequest actionRequest, ActionResponse actionResponse) throws NoSuchFieldException {
		
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		ThamSoForm thamSoForm = new ThamSoForm();
		thamSoForm.saveForm(actionRequest, true);
		
		if(SessionErrors.isEmpty(actionRequest)){
			try{
				long groupId = PortalUtil.getScopeGroupId(actionRequest);
				addUpdateParam(themeDisplay.getUser(), groupId, thamSoForm);
				actionResponse.sendRedirect(ParamUtil.getString(actionRequest, PortletKeys.REDIRECT_PAGE));
			}catch(Exception e){
				SessionErrors.add(actionRequest, "org.oep.core.portlet.thamso.error.generic");
				log.error(e);
			}
		}else{			
			PortalUtil.copyRequestParameters(actionRequest, actionResponse);
			actionRequest.setAttribute("thamSoForm", thamSoForm);
		}		
	}
	
	private void addUpdateParam(User user, long groupId, ThamSoForm f) throws Exception {
		ThamSo thamSoCu = ThamSoLocalServiceUtil.fetchThamSo(f.thamSoId);
		ThamSo thamSo;
		if(f.thamSoId == 0){
			thamSo = ThamSoLocalServiceUtil.addThamSo(groupId, f.loaiId, f.ma, f.giaTri, f.moTa, f.trangThai, 0);
		}else{
			thamSo = ThamSoLocalServiceUtil.updateThamSo(f.thamSoId, f.loaiId, f.ma, f.giaTri, f.moTa, f.trangThai);			
		}
		//PhienBanLocalServiceUtil.logDataChange(thamSo.getId(), thamSoCu, thamSo, user, "");
	}
	
}