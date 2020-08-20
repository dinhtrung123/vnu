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
package dtt.vn.xacminh.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;

import org.osgi.service.component.annotations.Component;

import com.google.gson.Gson;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.util.DLUtil;
import com.liferay.portal.kernel.exception.ImageResolutionException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.util.ContentUtil;

import dtt.vn.account.business.Constantes;
import dtt.vn.account.business.IConstants;
import dtt.vn.account.util.AccountEnum;
import dtt.vn.account.util.AccountUtil;
import dtt.vn.account.util.ConnectWsUtils;
import dtt.vn.account.util.MessageUtils;
import dtt.vn.account.util.MyLanguageUtil;
import dtt.vn.account.util.PortletKeysUtil;
import dtt.vn.account.util.QRUtils;
import dtt.vn.account.util.UploadFileUtils;
import dtt.vn.vnpost.model.Account;
import dtt.vn.vnpost.model.Photo;
import dtt.vn.vnpost.model.WorkItem;
import dtt.vn.vnpost.service.AccountLocalServiceUtil;
import dtt.vn.vnpost.service.PhotoLocalServiceUtil;
import dtt.vn.vnpost.service.WorkItemLocalServiceUtil;
import dtt.vn.xacminh.business.MessageObject;
import dtt.vn.xacminh.business.ObjectInBienBan;
import dtt.vn.xacminh.business.SearchObject;
import dtt.vn.xacminh.business.XacMinhBusiness;
import dtt.vn.xacminh.business.YkienCanBoObject;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@Component(
	immediate = true,
	property = {
        "com.liferay.portlet.display-category=IdmPortlet",
        "com.liferay.portlet.instanceable=true",
        "com.liferay.portlet.header-portlet-css=/css/main.css",
        "com.liferay.portlet.header-portlet-css=/css/oep-style.css",
        "com.liferay.portlet.header-portlet-javascript=/js/jQueryRotate.js",
        "javax.portlet.display-name=XacMinhPortlet",
        "javax.portlet.init-param.template-path=/",
        "javax.portlet.resource-bundle=content.Language",
        "javax.portlet.security-role-ref=power-user,user",
        "javax.portlet.init-param.view-template=/xacminhportlet/view.jsp"
    },
    service = Portlet.class
)

public class XacMinhPortlet extends MVCPortlet {
	static Log log = LogFactoryUtil.getLog(XacMinhPortlet.class);
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws PortletException, IOException {
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
		// TODO Auto-generated method stub
		try {
			
			String pathimage = System.getProperty("catalina.base")+"/conf/vnpost-logo.png";
			String pathcut = System.getProperty("catalina.base")+"/conf/cut.png";
			PrintWriter writer = resourceResponse.getWriter();
			String resourceId = resourceRequest.getResourceID();
			if(resourceId.equals("xemtruocbienban")) {
				boolean iscanhan = ParamUtil.getBoolean(resourceRequest, "iscanhan",true);
				if(iscanhan) {
					String datasend = ParamUtil.getString(resourceRequest, "datasend","");
					String dataplain = new String(DatatypeConverter.parseBase64Binary(datasend),"UTF-8");
					Map<String, Object> parameters = new HashMap<String, Object>();
					ObjectInBienBan bb = new Gson().fromJson(dataplain, ObjectInBienBan.class);
					
					byte[] qrCode = QRUtils.generateQRCodeImage(bb.getAccountId(), 150, 150);
					parameters.put("pathimage", pathimage);
					parameters.put("pathcut", pathcut);
					parameters.put("tentaikhoan", bb.getTentaikhoan());
					parameters.put("email", bb.getEmailtaikhoan());
					parameters.put("address", bb.getDiachi());
					parameters.put("hoten", bb.getHoten());
					parameters.put("gioitinh", bb.getGioitinh());
					parameters.put("giayto", bb.getLoaigiayto());
					parameters.put("ngaycap", bb.getNgaycap());
					parameters.put("giaytolienquan", bb.getGiaytolienquan());
					parameters.put("phone",bb.getDienthoai());
					parameters.put("ngaysinh", bb.getNgaysinh());
					parameters.put("quoctich", bb.getQuoctich());
					parameters.put("sogiayto", bb.getSogiayto());
					parameters.put("noicap", bb.getNoicap());
					parameters.put("xacminhky",bb.getTennguoixacminh());
					parameters.put("khachky", bb.getTenkhachhang());
					parameters.put("ngaydangky", bb.getNgaydangky());
					parameters.put("qrcode", DatatypeConverter.printBase64Binary(qrCode));
					String jrxml = ContentUtil.get("/formbbxn/BBXN.jrxml", true);
					JasperReport jasperReport = JasperCompileManager.compileReport(new ByteArrayInputStream(jrxml.getBytes()));
					JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
		            JasperExportManager.exportReportToPdfStream(jasperPrint, baos);
		            String base64pdf = DatatypeConverter.printBase64Binary(baos.toByteArray());
		            writer.write(base64pdf);
				}else {
					String datasend = ParamUtil.getString(resourceRequest, "datasend","");
					String dataplain = new String(DatatypeConverter.parseBase64Binary(datasend),"UTF-8");
					Map<String, Object> parameters = new HashMap<String, Object>();
					ObjectInBienBan bb = new Gson().fromJson(dataplain, ObjectInBienBan.class);
					byte[] qrCode = QRUtils.generateQRCodeImage(bb.getAccountId(), 150, 150);
					parameters.put("pathimage", pathimage);
					parameters.put("pathcut", pathcut);
					parameters.put("tentaikhoan", bb.getTentaikhoan());
					parameters.put("email", bb.getEmailtaikhoan());
					parameters.put("address", bb.getDiachi());
					parameters.put("hoten", bb.getHoten());
					parameters.put("gioitinh", bb.getGioitinh());
					parameters.put("giayto", bb.getLoaigiayto());
					parameters.put("ngaycap", bb.getNgaycap());
					parameters.put("giaytolienquan", bb.getGiaytolienquan());
					parameters.put("phone",bb.getDienthoai());
					parameters.put("ngaysinh", bb.getNgaysinh());
					parameters.put("quoctich", bb.getQuoctich());
					parameters.put("sogiayto", bb.getSogiayto());
					parameters.put("noicap", bb.getNoicap());
					parameters.put("xacminhky",bb.getTennguoixacminh());
					parameters.put("khachky", bb.getTenkhachhang());
					parameters.put("ngaydangky", bb.getNgaydangky());
					parameters.put("qrcode", DatatypeConverter.printBase64Binary(qrCode));
					String jrxml = ContentUtil.get("/formbbxn/BBXNTC.jrxml", true);
					JasperReport jasperReport = JasperCompileManager.compileReport(new ByteArrayInputStream(jrxml.getBytes()));
					JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
		            JasperExportManager.exportReportToPdfStream(jasperPrint, baos);
		            String base64pdf = DatatypeConverter.printBase64Binary(baos.toByteArray());
		            writer.write(base64pdf);
				}
				
			}else if(resourceId.equals("viewqrcode")) {
				String dataqr = ParamUtil.getString(resourceRequest, "dataqr","");
				byte[] qrCode = QRUtils.generateQRCodeImage(dataqr, 500, 500);
				 String base64qr = DatatypeConverter.printBase64Binary(qrCode);
		            writer.write(base64qr);
			}else if(resourceId.equals("getDataXacMinh")) {
				String database = ParamUtil.getString(resourceRequest, "databasesend","");
				String data =new String(DatatypeConverter.parseBase64Binary(database),"UTF-8");
				SearchObject sObj = new Gson().fromJson(data, SearchObject.class);
				String dataXacMinh = ConnectWsUtils.connectServer("http://localhost:8081/checkdata",data,"application/json");
		            writer.write(dataXacMinh);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void saveAccount(ActionRequest request, ActionResponse response) {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
			SessionErrors.add(request, "aceitem-add-tech-error");
			PortalUtil.copyRequestParameters(request, response);
			MessageUtils.hideDefualtErrorMessage(request);
			response.setRenderParameter("jspPage", "/xacminhportlet/view.jsp");
		}
	}
	public void actionMethodInBienban(ActionRequest request, ActionResponse response) {
		
		try {
			String datasend = ParamUtil.getString(request, "datasend","");
			String dataplain = new String(DatatypeConverter.parseBase64Binary(datasend),"UTF-8");
			Map<String, Object> parameters = new HashMap<String, Object>();
			ObjectInBienBan bb = new Gson().fromJson(dataplain, ObjectInBienBan.class);
			parameters.put("tentaikhoan", bb.getTentaikhoan());
			parameters.put("email", bb.getEmailtaikhoan());
			parameters.put("address", bb.getDiachi());
			parameters.put("hoten", bb.getHoten());
			parameters.put("gioitinh", bb.getGioitinh());
			parameters.put("giayto", bb.getLoaigiayto());
			parameters.put("ngaycap", bb.getNgaycap());
			parameters.put("giaytolienquan", bb.getGiaytolienquan());
			parameters.put("phone",bb.getDienthoai());
			parameters.put("ngaysinh", bb.getNgaysinh());
			parameters.put("quoctich", bb.getQuoctich());
			parameters.put("sogiayto", bb.getSogiayto());
			parameters.put("noicap", bb.getNoicap());
			parameters.put("xacminhky",bb.getTennguoixacminh());
			parameters.put("khachky", bb.getTenkhachhang());
			parameters.put("ngaydangky", bb.getNgaydangky());
			String jrxml = ContentUtil.get("/formbbxn/BBXN.jrxml", true);
			JasperReport jasperReport = JasperCompileManager.compileReport(new ByteArrayInputStream(jrxml.getBytes()));
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, baos);
			HttpServletResponse res = PortalUtil.getHttpServletResponse(response);
			res.getOutputStream().write(baos.toByteArray());
			res.addHeader("Content-disposition", "attachment; filename=" + "BBXN-"+bb.getTentaikhoan()+".pdf");
			res.setContentType("application/pdf");
			res.flushBuffer();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void actionMethodXacminh(ActionRequest request, ActionResponse response) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		boolean isSucess = false;
		try {
			HttpServletRequest request1 = PortalUtil.getHttpServletRequest(request);
			String ykiencanboxacminh = ParamUtil.getString(request, "ykiencanboxacminh","").trim();
			
			long accountID = ParamUtil.getLong(request, "acid",0);
			long cocsxm = ParamUtil.getLong(request, "cocsxm",0);
			
			long luutam = ParamUtil.getLong(request, "luutam",-1);
			List <Photo> listphoto = PhotoLocalServiceUtil.getPhotosbyImageType_classPK(1, accountID, -1, -1);
			for(Photo pt : listphoto){
				PhotoLocalServiceUtil.deletePhoto(pt.getImageId());
			}
			String base64jsonthongtin = ParamUtil.getString(request, "jsonthongtin","");
			String jsonthongtin = new String(DatatypeConverter.parseBase64Binary(base64jsonthongtin));
			MessageObject[] jsonobj = new Gson().fromJson(jsonthongtin, MessageObject[].class);
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
			int indexsub = 0;
			for(MessageObject mes: jsonobj){
				int index =Integer.parseInt(mes.getId());
				String urlimageold = ParamUtil.getString(request, "url-image-"+index,"").trim();
				String url = "", contentType = "";
				String urlThumdinhkem ="";
				if(urlimageold.equals("")) {
					List<FileEntry> listFileEntry = UploadFileUtils.upload(uploadRequest, request, "filexacminhdinhkem-" + index, UUID.randomUUID().toString(), 0);
					
					
					
					
					if (Validator.isNotNull(listFileEntry) && listFileEntry.size()>0) {
						url = "/c/document_library/get_file?uuid="+listFileEntry.get(0).getUuid()+"&groupId="+themeDisplay.getScopeGroupId();
						contentType = listFileEntry.get(0).getExtension();
						 urlThumdinhkem = DLUtil.getThumbnailSrc(listFileEntry.get(0), listFileEntry.get(0).getFileVersion(), null, themeDisplay);
						indexsub = urlThumdinhkem.indexOf("/document");
					}
				}else {
					url = urlimageold;
				}
				
				
				mes.setUrlfile((urlThumdinhkem==null || urlThumdinhkem.equals(""))?url:urlThumdinhkem.substring(indexsub));
				Photo photo = PhotoLocalServiceUtil.createPhoto(CounterLocalServiceUtil.increment());
				photo.setClassName(mes.getLoaigt());
				photo.setClassPK(accountID);
				photo.setDescription("");
				photo.setImageType(1);
				photo.setContentType(contentType);
				photo.setApproved(true);
				photo.setUploadDate(new Date());
				photo.setMessage(mes.toString());
				PhotoLocalServiceUtil.addPhoto(photo);
			}
			
			Account acc = AccountLocalServiceUtil.getAccount(accountID);
			acc.setIdDBXM(cocsxm);
			String ykiencanboinsert = "";
			if(ykiencanboxacminh != null && !ykiencanboxacminh.contentEquals("")) {
				YkienCanBoObject ykien = new YkienCanBoObject();
				ykien.yKienCanBoXacMinh = ykiencanboxacminh;
				ykien.yKienCanBoPheDuyet = "";
				ykiencanboinsert = new Gson().toJson(ykien);
			}
			acc.setMessage(ykiencanboinsert);
			if(luutam == 0){
				acc.setAccountStatus(PortletKeysUtil.TrangThaiKeys.Dang_Xac_Minh);
				request.setAttribute("message", MyLanguageUtil.get(request1, request.getLocale(), "dtt.vn.xacminh.portlet.luutam.success"));
			}else if(luutam == 1){
				
					//acc.setIpLevel(3);
				
				request.setAttribute("message", MyLanguageUtil.get(request1, request.getLocale(), "dtt.vn.xacminh.portlet.xacminhdung.success"));
				acc.setAccountStatus(PortletKeysUtil.TrangThaiKeys.Cho_Phe_Duyet);
				acc.setModifiedDate(new Date());
			}
			else if (luutam ==2) {
				request.setAttribute("message", MyLanguageUtil.get(request1, request.getLocale(), "dtt.vn.xacminh.portlet.xacminhsai.success"));
				acc.setAccountStatus(PortletKeysUtil.TrangThaiKeys.Da_Tra_KQ_Khong_Hop_Le);
				String[] emailAddress = {acc.getEmail()};
				try {
					log.info("thuc hien gui mail cho nguoi dung khi xac minh sai.......");
					XacMinhBusiness.sendMailThongBaoXacMinhSai(themeDisplay, acc.getEmail(), acc.getFullName(), acc.getAccountName());
					log.info("thuc hien gui mail cho nguoi dung khi xac minh sai thanh cong");
				} catch (Exception e) {
					log.error(e.getMessage());
				}
				
			}
			AccountLocalServiceUtil.updateAccount(acc);
			doAddWorkiTemnew(request,accountID);
			MessageUtils.hideDefualtSuccessMessage(request);
			isSucess = true;
			request.setAttribute("isSucess", isSucess);
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.toString());
		}
	}

	public void xacMinh(ActionRequest request, ActionResponse response) {
		try {
			long accountId = ParamUtil.getLong(request, "acid");
			int xacminh = ParamUtil.getInteger(request, Constants.CMD);
			int ipLevel = 3;// ParamUtil.getInteger(request, "ipLevel");
			Account account = AccountLocalServiceUtil.fetchAccount(accountId);
			account.setProcessStatus(Constantes.XuLy.PHE_DUYET);
			account.setAccountStatus(xacminh);
			account.setIpLevel(ipLevel);
			AccountLocalServiceUtil.updateAccount(account);
			doAddWorkiTem(request);

		} catch (Exception e) {
			e.printStackTrace();
			PortalUtil.copyRequestParameters(request, response);
			MessageUtils.hideDefualtErrorMessage(request);
			response.setRenderParameter("jspPage", "/xacminhportlet/view.jsp");
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

		workItem.setTitle("Xác minh tài khoản");
		workItem.setStatus("NEW");
		workItem.setAccountId(accountId);
		WorkItemLocalServiceUtil.addWorkItem(workItem);

	}

	public void doAddWorkiTemnew(ActionRequest request, long accountId) throws SystemException {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		WorkItem workItem = WorkItemLocalServiceUtil.createWorkItem();
		workItem.setGroupId(themeDisplay.getLayout().getGroupId());
		workItem.setCreateDate(new Date());
		workItem.setStartTime(new Date());

		workItem.setTitle("Xác minh tài khoản");
		workItem.setStatus("UPDATE");
		workItem.setAccountId(accountId);
		WorkItemLocalServiceUtil.addWorkItem(workItem);

	}

	public void khongXacMinh(ActionRequest request, ActionResponse response) {
		try {
			long accountId = ParamUtil.getLong(request, "accountId");
			int xacminh = ParamUtil.getInteger(request, Constants.CMD);
			Account account = AccountLocalServiceUtil.fetchAccount(accountId);
			account.setProcessStatus(xacminh);
			account.setAccountStatus(Constantes.XuLy.PHE_DUYET);
			AccountLocalServiceUtil.updateAccount(account);
			doAddWorkiTem(request);
		} catch (Exception e) {
			e.printStackTrace();
			SessionErrors.add(request, "aceitem-add-tech-error");
			PortalUtil.copyRequestParameters(request, response);
			MessageUtils.hideDefualtErrorMessage(request);
			response.setRenderParameter("jspPage", "/xacminhportlet/view.jsp");
		}
	}

	public void verifyCMT_bk(ActionRequest actionRequest, ActionResponse response)
			throws SystemException, ImageResolutionException {
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		long accountId = ParamUtil.getLong(uploadPortletRequest, "accountId");
		Account account = AccountLocalServiceUtil.fetchAccount(accountId);

		for (int i = 0; i < 3; i++) {
			File profilePhoto = uploadPortletRequest.getFile("profilePhoto_" + i);
			if (Validator.isNotNull(profilePhoto) && profilePhoto.length() > 0) {
				long imageId = ParamUtil.getLong(uploadPortletRequest, "imageId_" + i, 0l);
				String description = ParamUtil.getString(uploadPortletRequest, "description_" + i);
				PhotoLocalServiceUtil.upload(imageId, account.getAccountId(), profilePhoto, IConstants.CMT, description,
						"");
				account.setMessage("Xác minh thông tin Chứng minh thư");

				AccountLocalServiceUtil.updateAccount(account);
			}

		}
		MessageUtils.hideDefualtErrorMessage(actionRequest);
		response.setRenderParameter("requestSuccess", "true");
		response.setRenderParameter("accountId", Long.toString(accountId));
		response.setRenderParameter("jspPage", "/html/xacminh/popup-cmt-verify.jsp");

	}

	public void verifyCMT(ActionRequest req, ActionResponse resp) {
		try {
			UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(req);
			long accountId = ParamUtil.getLong(uploadPortletRequest, "accountId");
			Account account = AccountLocalServiceUtil.fetchAccount(accountId);
			String responseIndexesString = uploadPortletRequest.getParameter("responseIndexes");

			List<Photo> photos = null;
			JSONObject additionalInfo = JSONFactoryUtil.createJSONObject();
			JSONObject doVerifyInfo = JSONFactoryUtil.createJSONObject();

			if (Validator.isNull(account.getMessage())) {
				additionalInfo = JSONFactoryUtil.createJSONObject();
			} else {
				additionalInfo = JSONFactoryUtil.createJSONObject(account.getMessage());
			}

			for (AccountEnum env : AccountEnum.values()) {
				String _check = ParamUtil.getString(uploadPortletRequest, env.name());
				if (Validator.isNull(_check)) {
					_check = "false";
				}
				if ("true".equals(_check)) {
					if (!additionalInfo.getBoolean(env.name())) {
						doVerifyInfo.put(env.name(), "true");
					}
				}
				additionalInfo.put(env.name(), _check);
			}

			int[] responseIndexes = StringUtil.split(responseIndexesString, 0);
			List<Long> photoIds = new ArrayList<Long>();

			for (int responseIndex : responseIndexes) {
				long imageId = ParamUtil.getLong(uploadPortletRequest, "imageId_" + responseIndex, 0l);
				photoIds.add(imageId);
			}

			for (Photo photo : photos) {
				if (!photoIds.contains(photo.getImageId())) {
					PhotoLocalServiceUtil.deletePhoto(photo.getImageId());
				}
			}

			for (int i : responseIndexes) {
				File profilePhoto = uploadPortletRequest.getFile("profilePhoto_" + i);
				if (Validator.isNotNull(profilePhoto) && profilePhoto.length() > 0) {
					long imageId = ParamUtil.getLong(uploadPortletRequest, "imageId_" + i, 0l);
					String description = ParamUtil.getString(uploadPortletRequest, "description_" + i);
					Photo photo = PhotoLocalServiceUtil.upload(imageId, account.getAccountId(), profilePhoto,
							IConstants.CMT, description, doVerifyInfo.toString());

					account.setMessage(additionalInfo.toString());

					AccountLocalServiceUtil.updateAccount(account);
				}
			}

			MessageUtils.hideDefualtErrorMessage(req);
			resp.setRenderParameter("accountId", Long.toString(accountId));
			resp.setRenderParameter("jspPage", "/html/xacminh/popup-cmt-verify.jsp");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}