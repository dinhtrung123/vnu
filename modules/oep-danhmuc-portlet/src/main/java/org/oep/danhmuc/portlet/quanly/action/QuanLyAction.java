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
package org.oep.danhmuc.portlet.quanly.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import org.oep.danhmuc.exception.DuplicateCodeException;
import org.oep.danhmuc.exception.DuplicateNameException;
import org.oep.danhmuc.exception.FileTypeNotSupportException;
import org.oep.danhmuc.model.DanhMuc;
import org.oep.danhmuc.portlet.quanly.business.QuanLyBusiness;
import org.oep.danhmuc.portlet.quanly.configuration.QuanLyConfiguration;
import org.oep.danhmuc.portlet.quanly.keys.QuanLyKeys;
import org.oep.danhmuc.service.DanhMucLocalServiceUtil;
import org.oep.danhmuc.util.PortletKeys;
import org.oep.danhmuc.util.QuanlyUtil;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

@Component(
	configurationPid = "org.oep.danhmuc.portlet.quanly.configuration.QuanLyConfiguration",
	immediate = true,
	property = {
        "com.liferay.portlet.display-category=QuanLy DanhMuc",
        "javax.portlet.display-name=QL DanhMuc Portlet",
        "com.liferay.portlet.instanceable=true",
        "com.liferay.portlet.header-portlet-css=/css/main.css",
        "com.liferay.portlet.footer-portlet-javascript=/js/main.js",
        "javax.portlet.init-param.template-path=/",
        "javax.portlet.resource-bundle=content.Language",
        "javax.portlet.security-role-ref=power-user,user",
        "javax.portlet.init-param.view-template=/quanlyaction/view.jsp",
    },
    service = Portlet.class
)
public class QuanLyAction extends MVCPortlet {
	Log log = LogFactoryUtil.getLog(QuanLyAction.class);
	
public void ghiLaiItem(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
//		String themItemPage = ParamUtil.getString(actionRequest, "themItemPage");
		int checkAddEdit = ParamUtil.getInteger(actionRequest, QuanLyKeys.Base.CHECK_ADD_EDIT);
		long selectedId = ParamUtil.getLong(actionRequest, QuanLyKeys.Base.SELECTED_ID);
		String ten = ParamUtil.getString(actionRequest, QuanLyKeys.Base.TEN);
		String ma = ParamUtil.getString(actionRequest, QuanLyKeys.Base.MA);	
		String moTa = ParamUtil.getString(actionRequest, QuanLyKeys.Base.MOTA);		
		long nhomId = ParamUtil.getLong(actionRequest, QuanLyKeys.Base.NHOM_DANH_MUC);
		boolean trangThai = ParamUtil.getBoolean(actionRequest, QuanLyKeys.Base.TRANG_THAI);
		long idTiepTheo = ParamUtil.getLong(actionRequest, QuanLyKeys.Base.THUTU_HIENTHI);
		//laay gia tri cua nhomId
		if(checkAddEdit == 0 && selectedId == 0 ){
			nhomId = ParamUtil.getLong(actionRequest, QuanLyKeys.Base.NHOM_DANH_MUC);
		}
		else{
			DanhMuc danhMuc = DanhMucLocalServiceUtil.fetchDanhMuc(selectedId);
			if(checkAddEdit == 1 && danhMuc.getChaId() == 0){
				nhomId = ParamUtil.getLong(actionRequest, QuanLyKeys.Base.NHOM_DANH_MUC);
			}else{
				nhomId = danhMuc.getNhomId();
			}
		}
		
		if(QuanLyBusiness.validateData(checkAddEdit, selectedId, nhomId, ten, ma, actionRequest)){
				QuanLyBusiness.addUpdateItem(selectedId, ten, ma, moTa, nhomId, trangThai, idTiepTheo, checkAddEdit, actionRequest, actionResponse);
				actionResponse.sendRedirect(ParamUtil.getString(actionRequest, PortletKeys.REDIRECT_PAGE));
		}
		
		PortalUtil.copyRequestParameters(actionRequest, actionResponse);
		
	}
	
	
	
	
	public void xoaItem(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		long selectedId = ParamUtil.getLong(actionRequest, QuanLyKeys.Base.SELECTED_ID);
		DanhMuc danhMuc = DanhMucLocalServiceUtil.fetchDanhMuc(selectedId);
		boolean isActive = false;
		List<DanhMuc> listCon = DanhMucLocalServiceUtil.getDanhMuc_By_ChaId(danhMuc.getId(), isActive);
		if(listCon.isEmpty()){
			QuanLyBusiness.deleteDanhMucUpdateDisplayIndex(selectedId);
			actionResponse.sendRedirect(ParamUtil.getString(actionRequest, PortletKeys.REDIRECT_PAGE));
		}
		else{
			SessionErrors.add(actionRequest, QuanLyKeys.ErrorMessageKeys.ORG_OEP_DANHMUC_ERROR_ITEM_HAS_CHILD);
			actionResponse.sendRedirect(ParamUtil.getString(actionRequest, PortletKeys.REDIRECT_PAGE));
		}
		
	}
	
	public void xoaItemDuocChon(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
	String itemIds = ParamUtil.getString(actionRequest, QuanLyKeys.Base.ITEM_IDS);
	long[] itemIdArr = QuanlyUtil.convertToLongArray(itemIds, ",");
	if(itemIdArr.length >0){
		for(int i = 0; i < itemIdArr.length; i ++){
			DanhMuc item = DanhMucLocalServiceUtil.fetchDanhMuc(itemIdArr[i]);
			List<DanhMuc> listCon = DanhMucLocalServiceUtil.getByP(item.getId());
			if(!listCon.isEmpty()){
				SessionErrors.add(actionRequest, QuanLyKeys.ErrorMessageKeys.ORG_OEP_DANHMUC_ERROR_ITEM_HAS_CHILD);
				actionResponse.sendRedirect(ParamUtil.getString(actionRequest, PortletKeys.REDIRECT_PAGE));
			}
		}
		if(SessionErrors.isEmpty(actionRequest)){
			for(int i = 0; i < itemIdArr.length; i ++){
				QuanLyBusiness.deleteDanhMucUpdateDisplayIndex(itemIdArr[i]);
			}
			actionResponse.sendRedirect(ParamUtil.getString(actionRequest, PortletKeys.REDIRECT_PAGE));
		}
		else{
			actionResponse.sendRedirect(ParamUtil.getString(actionRequest, PortletKeys.REDIRECT_PAGE));
		}
	}
	else{
		SessionErrors.add(actionRequest, QuanLyKeys.ErrorMessageKeys.ORG_OEP_DANHMUC_ERROR_NO_ITEM_SELECTED);
		actionResponse.sendRedirect(ParamUtil.getString(actionRequest, PortletKeys.REDIRECT_PAGE));
	}
}
	
	public void xoaTatItem(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception{
		long selectedId = ParamUtil.getLong(actionRequest, QuanLyKeys.Base.SELECTED_ID);
		DanhMuc item = DanhMucLocalServiceUtil.fetchDanhMuc(selectedId);
		List<DanhMuc> listItems = null;
		if(item != null){
			listItems = DanhMucLocalServiceUtil.getByP(item.getId());
		}
		else{
			listItems = DanhMucLocalServiceUtil.getByMUC(0);
		}
		if(!QuanLyBusiness.validateXoaListDanhMuc(listItems, actionRequest, actionResponse)){
			if(SessionErrors.isEmpty(actionRequest)){
				QuanLyBusiness.xoaTatDanhMuc(listItems);
			}
			actionResponse.sendRedirect(ParamUtil.getString(actionRequest, PortletKeys.REDIRECT_PAGE));
		}
		else{
			actionResponse.sendRedirect(ParamUtil.getString(actionRequest, PortletKeys.REDIRECT_PAGE));
		}
		
	}
	
	public void importDanhMuc(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		PortalUtil.copyRequestParameters(actionRequest, actionResponse);
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		long selectedId = ParamUtil.getLong(uploadPortletRequest, QuanLyKeys.Base.SELECTED_ID);
		DanhMuc item = DanhMucLocalServiceUtil.fetchDanhMuc(selectedId);
		long nhomId = ParamUtil.getLong(uploadPortletRequest, QuanLyKeys.Base.NHOM_DANH_MUC);
		if(nhomId ==0){
			SessionErrors.add(actionRequest, QuanLyKeys.ErrorMessageKeys.ORG_OEP_DANHMUC_ERROR_NO_GROUP_SELECTED);
		}
		File uploadedFile = uploadPortletRequest.getFile(QuanLyKeys.Base.IMPORT_FILE);
		List<String> listRecords = new ArrayList<String>();
		try{
			listRecords = QuanlyUtil.importCSVFile(uploadedFile);
		}
		catch(FileTypeNotSupportException e){
			SessionErrors.add(actionRequest, QuanLyKeys.ErrorMessageKeys.ORG_OEP_DANHMUC_ERROR_INVALID_FILE_FORMAT);
		}
		catch(FileNotFoundException e){
			SessionErrors.add(actionRequest, QuanLyKeys.ErrorMessageKeys.ORG_OEP_DANHMUC_ERROR_FILE_NOT_FOUND);
		}
		DanhMuc itemMaxIndex = null;
		OrderByComparator asc = null;
		if(item != null){
			itemMaxIndex = DanhMucLocalServiceUtil.getDanhMuc_Con_CuoiCung(item.getId(), asc);
		}
		else{
			itemMaxIndex = DanhMucLocalServiceUtil.getItemWithMaxDisplayIndexByMuc(0);
		}
		int thuTuHienThi = 0;
		if(itemMaxIndex != null){
			thuTuHienThi = itemMaxIndex.getThuTuHienThi();
		}
		if(SessionErrors.isEmpty(actionRequest)){
			try{
				for(String s:listRecords){					
					thuTuHienThi +=1;
					String[] recordArr = s.split(",");
					if(recordArr.length < 4){
						recordArr = s.split(";");
					}
					boolean trangThai = false;
					int i = Integer.parseInt(recordArr[3]);
					if(i == 1) trangThai = true;
					else trangThai = false;
					QuanLyBusiness.importItem(selectedId, recordArr[0], recordArr[1], recordArr[2], nhomId, trangThai, thuTuHienThi);
				}
				actionResponse.setRenderParameter("requestSuccess", String.valueOf(true));
			}
			catch (DuplicateNameException e){
				SessionErrors.add(actionRequest, QuanLyKeys.ErrorMessageKeys.ORG_OEP_DANHMUC_ERROR_IMPORT_DUPLICATE_NAME);
				actionResponse.setRenderParameter("requestSuccess", String.valueOf(false));
			}
			catch (DuplicateCodeException e){
				SessionErrors.add(actionRequest, QuanLyKeys.ErrorMessageKeys.ORG_OEP_DANHMUC_ERROR_IMPORT_DUPLICATE_CODE);
				actionResponse.setRenderParameter("requestSuccess", String.valueOf(false));
			}
			catch(NumberFormatException e){
				SessionErrors.add(actionRequest, QuanLyKeys.ErrorMessageKeys.ORG_OEP_DANHMUC_ERROR_INVALID_IMPORT_CONTENT);
				actionResponse.setRenderParameter("requestSuccess", String.valueOf(false));
			}
			
		}
		else{
			actionResponse.setRenderParameter("requestSuccess", String.valueOf(false));
		}
		
	}
	
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException, IOException {
		String type = ParamUtil.getString(resourceRequest, "type");
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		if("getThuTuHienThi".equals(type)){
			try{
				jsonArray = getThuTuHienThi(resourceRequest, resourceResponse);
			}catch(SystemException e){
				log.error(e);
			}catch(IOException e){
				log.error(e);
			}
		}else{
			long selectedId = ParamUtil.getLong(resourceRequest, QuanLyKeys.Base.SELECTED_ID);
			DanhMuc item = null;
			try {
				item = DanhMucLocalServiceUtil.fetchDanhMuc(selectedId);
			} catch (SystemException e) {
				log.error(e);
			}
			String nhomId = ParamUtil.getString(resourceRequest, QuanLyKeys.Base.ID_NHOM);
			String fileName = ParamUtil.getString(resourceRequest, QuanLyKeys.Base.FILE_NAME);
			List<DanhMuc> listRecords = new ArrayList<DanhMuc>();
			if(item != null){
				listRecords = DanhMucLocalServiceUtil.searchItem(item.getId(), "", nhomId, "", -1, -1);
			}
			else{
				listRecords = DanhMucLocalServiceUtil.searchItem(0, "", nhomId, "", -1, -1);
			}
			byte[] records = QuanlyUtil.exportCSVFile(listRecords);
			String contentType = ContentTypes.APPLICATION_TEXT;
			PortletResponseUtil.sendFile(resourceRequest, resourceResponse, fileName, records, contentType);
			return;
		}
		
		resourceResponse.setContentType("text/html");
		PrintWriter writer = resourceResponse.getWriter();
		writer.write(jsonArray.toString());
	}
	
	protected JSONArray getThuTuHienThi(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws SystemException, IOException{
		long nhomDanhMucId = ParamUtil.getLong(resourceRequest, "nhomDanhMucId");
		List<DanhMuc> listAnhChi = new ArrayList<DanhMuc>();
		listAnhChi = DanhMucLocalServiceUtil.getAllByNhomIdMuc(nhomDanhMucId, 1);

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		for(int i = 0; listAnhChi != null && i < listAnhChi.size(); i++){
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put("id", listAnhChi.get(i).getId());
			jsonObject.put("name", listAnhChi.get(i).getTen());
			jsonArray.put(jsonObject);
		}
		
		return jsonArray;
	}
	 @Override
	 public void doView(RenderRequest renderRequest,
	     RenderResponse renderResponse) throws IOException, PortletException {

	     renderRequest.setAttribute(
	    		 QuanLyConfiguration.class.getName(), _quanlyConfiguration);
	        log.info("#########nhom danh muc##########"+_quanlyConfiguration.getNhomDanhMuc()); 

	     super.doView(renderRequest, renderResponse);
	 }

	
	@Activate
	@Modified
	protected void activate(Map<Object, Object> properties) {
		log.info("#####Calling activate() method######");
		
		_quanlyConfiguration = ConfigurableUtil.createConfigurable(QuanLyConfiguration.class, properties);
		
	}
	private volatile QuanLyConfiguration _quanlyConfiguration;  
	
}