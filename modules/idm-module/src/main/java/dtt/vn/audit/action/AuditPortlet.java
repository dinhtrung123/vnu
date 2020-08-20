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
package dtt.vn.audit.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.configuration.ConfigurationFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import org.oep.danhmuc.model.DanhMuc;
import org.oep.danhmuc.service.DanhMucLocalServiceUtil;
import org.osgi.service.component.annotations.Component;

import dtt.vn.account.util.DateUtil;
import dtt.vn.audit.model.AuditEvent;
import dtt.vn.audit.service.AuditEventLocalServiceUtil;


@Component(
	immediate = true,
	property = {
        "com.liferay.portlet.display-category=IdmPortlet",
        "javax.portlet.display-name=Audit Report",
        "com.liferay.portlet.instanceable=true",
        "javax.portlet.init-param.template-path=/",
        "com.liferay.portlet.header-portlet-css=/css/oep-style.css",
        "com.liferay.portlet.footer-portlet-javascript=/js/main.js",
        "javax.portlet.resource-bundle=content.Language",
        "javax.portlet.security-role-ref=power-user,user",
        "javax.portlet.init-param.view-template=/auditportlet/view.jsp"
    },
    service = Portlet.class
)
public class AuditPortlet extends MVCPortlet {
	private static Log log = LogFactoryUtil.getLog(AuditPortlet.class.getName()); 
	private static final Configuration _configuration = ConfigurationFactoryUtil
		    .getConfiguration(PortalClassLoaderUtil.getClassLoader(), "portlet");
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException{
		String resourceId = resourceRequest.getResourceID();
		if("getQuanHuyenByTinhThanh".equals(resourceId)){
			try{
				getQuanHuyenByTinhThanh(resourceRequest, resourceResponse);
			}catch(IOException e){
				log.error(e);
			}
		}else if("getPhuongXaByQuanHuyen".equals(resourceId)){
			try{
				getPhuongXaByQuanHuyen(resourceRequest, resourceResponse);
			}catch(IOException e){
				log.error(e);
			}
		}
		
	}
	public void downloadcsv(ActionRequest request, ActionResponse response) {
		try {
			String tendangnhap = ParamUtil.getString(request, "tendangnhapcsv","");
			String tennguoidung = ParamUtil.getString(request, "fullnamecsv","");
			String tungay = ParamUtil.getString(request, "tungaycsv","");
			String denngay = ParamUtil.getString(request, "denngaycsv","");
			List<AuditEvent> listEvent = AuditEventLocalServiceUtil.searchcustom(tendangnhap, tungay, denngay, -1, -1,tennguoidung);
			byte[] exfilebyte = exportCSVFile(listEvent);
			HttpServletResponse res = PortalUtil.getHttpServletResponse(response);
			res.getOutputStream().write(exfilebyte);
			res.addHeader("Content-disposition", "attachment; filename=" + "Nhat-ky-thao-tac-"+DateUtil.formatDate(new Date(), DateUtil.DATE_FORMAT_D_M_Y)+".csv");
			res.setContentType(ContentTypes.APPLICATION_TEXT);
			res.flushBuffer();
//			String contentType = ContentTypes.APPLICATION_TEXT;
//			PortletResponseUtil.sendFile(request, response, "123.csv", exfilebyte, contentType);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public  void getQuanHuyenByTinhThanh(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws SystemException, IOException{
		long thanhPhoId = ParamUtil.getLong(resourceRequest, "tinhThanhIdCd");
		List<DanhMuc> listQuanHuyens = null;
		if(thanhPhoId != 0){
			listQuanHuyens = DanhMucLocalServiceUtil.getDanhMuc_By_ChaId(thanhPhoId, true);
		}
		
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		for(int i = 0; listQuanHuyens != null && i < listQuanHuyens.size(); i++){
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put("id", listQuanHuyens.get(i).getId());
			jsonObject.put("key", listQuanHuyens.get(i).getTen());
			jsonArray.put(jsonObject);
		}
		
		resourceResponse.setContentType("text/html");
		PrintWriter writer = resourceResponse.getWriter();
		writer.write(jsonArray.toString());
	}
	public  void getPhuongXaByQuanHuyen(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws SystemException, IOException{
		long quanHuyenId = ParamUtil.getLong(resourceRequest, "quanHuyenIdCd");
		List<DanhMuc> listPhuongXas = null;
		if(quanHuyenId != 0){
			listPhuongXas = DanhMucLocalServiceUtil.getDanhMuc_By_ChaId(quanHuyenId, true);
		}
		
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		for(int i = 0; listPhuongXas != null && i < listPhuongXas.size(); i++){
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put("id", listPhuongXas.get(i).getId());
			jsonObject.put("key", listPhuongXas.get(i).getTen());
			jsonArray.put(jsonObject);
		}
		
		resourceResponse.setContentType("text/html");
		PrintWriter writer = resourceResponse.getWriter();
		writer.write(jsonArray.toString());
	}
	public  byte[] exportCSVFile(List<AuditEvent> listRecords){
		StringBundler sb = new StringBundler();
		sb.append("\uFEFF");
		String[] headers = {_configuration.get("idm.vnpost.audit.csv.stt"), _configuration.get("idm.vnpost.audit.csv.tentaikhoan"), _configuration.get("idm.vnpost.audit.csv.tennguoidung"), _configuration.get("idm.vnpost.audit.csv.donvicongtac"),
				_configuration.get("idm.vnpost.audit.csv.chucdanh"),_configuration.get("idm.vnpost.audit.csv.noidungthaotac"),_configuration.get("idm.vnpost.audit.csv.thoidiemthaotac")};
		for(String s : headers){
			sb.append(s);
			sb.append(",");
		}
		sb.setIndex(sb.index()-1);
		sb.append(CharPool.NEW_LINE);
		
		int stt = 1;
		for(AuditEvent i: listRecords){
			sb.append(stt++);
			sb.append(",");
			sb.append(i.getUserName());
			sb.append(",");
			sb.append(i.getMessage());
			sb.append(",");
			sb.append("");
			sb.append(",");
			sb.append("");
			sb.append(",");
			sb.append(i.getAdditionalInfo());
			sb.append(",");
			sb.append(DateUtil.parseDateToString(i.getCreateDate(), DateUtil.DATE_FORMAT_D_M_Y));
			sb.append(CharPool.NEW_LINE);
			
		}
		return sb.toString().getBytes();
	}
	
}