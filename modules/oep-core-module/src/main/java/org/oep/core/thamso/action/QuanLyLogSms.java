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

import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;


import org.oep.core.logsms.bussiness.QuanLyLogSmsBussiness;
import org.oep.core.model.LogSMS;
import org.oep.core.service.LogSMSLocalServiceUtil;
import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
        "com.liferay.portlet.display-category=Quan Tri He Thong",
        "com.liferay.portlet.header-portlet-css=/css/main.css",
        "com.liferay.portlet.footer-portlet-javascript=/js/main.js",
        "com.liferay.portlet.instanceable=true",
        "javax.portlet.init-param.template-path=/",
        "javax.portlet.display-name=QuanLyLogSms",
        "javax.portlet.resource-bundle=content.Language",
        "javax.portlet.security-role-ref=power-user,user",
        "javax.portlet.init-param.view-template=/quanlylogsms/view.jsp"
    },
    service = Portlet.class
)
public class QuanLyLogSms extends MVCPortlet {
	private static Log log = LogFactoryUtil.getLog(QuanLyLogSms.class);
	
	
	public void downloadcsv(ActionRequest request, ActionResponse response) {
		try {
			String keyword = ParamUtil.getString(request, "phone","");
			String tungay = ParamUtil.getString(request, "tungaycsv","");
			String denngay = ParamUtil.getString(request, "denngaycsv","");
			List<LogSMS> listEvent = LogSMSLocalServiceUtil.searchByPhone(keyword, tungay, denngay, -1, -1);
			byte[] exfilebyte = QuanLyLogSmsBussiness.exportCSVFile(listEvent);
			HttpServletResponse res = PortalUtil.getHttpServletResponse(response);
			res.getOutputStream().write(exfilebyte);
			res.addHeader("Content-disposition", "attachment; filename=" + "Quan-ly-log-sms-"+org.oep.util.DateUtil.formatDate(new Date(), org.oep.util.DateUtil.DATE_FORMAT_D_M_Y)+".csv");
			res.setContentType(ContentTypes.APPLICATION_TEXT);
			res.flushBuffer();
//			String contentType = ContentTypes.APPLICATION_TEXT;
//			PortletResponseUtil.sendFile(request, response, "123.csv", exfilebyte, contentType);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}