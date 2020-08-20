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
package dtt.vn.user.quanlytaikhoan.action;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.xml.bind.DatatypeConverter;

import org.oep.core.model.MappingVmap;
import org.oep.core.service.MappingVmapLocalServiceUtil;
import org.osgi.service.component.annotations.Component;

import com.google.gson.Gson;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.util.DLUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import dtt.vn.user.common.utils.GhiChuObject;
import dtt.vn.user.business.DangKyTaiKhoanBusiness;
import dtt.vn.user.dangky.DangKyTaiKhoanPortlet;
import dtt.vn.user.keycloak.connect.KeycloakUtils;
import dtt.vn.user.keys.DangKyTaiKhoanKeys;
import dtt.vn.user.quanly.business.MessageObject;
import dtt.vn.user.quanly.business.UploadFileUtils;
import dtt.vn.user.quanly.business.UserBusiness;
import dtt.vn.user.quanly.keys.CapNhatMatKhauKeys;

import com.liferay.portal.kernel.model.User;
import dtt.vn.vnpost.model.Account;
import dtt.vn.vnpost.model.Photo;
import dtt.vn.vnpost.service.AccountLocalServiceUtil;
import dtt.vn.vnpost.service.PhotoLocalServiceUtil;
import dtt.vn.user.keys.PortletKeysUtil;

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
        "javax.portlet.init-param.template-path=/",
        "javax.portlet.display-name=QuanLyTaiKhoanPortlet",
        "javax.portlet.resource-bundle=content.Language",
        "javax.portlet.security-role-ref=power-user,user",
        "javax.portlet.init-param.view-template=/quanlytaikhoanportlet/view.jsp"
    },
    service = Portlet.class
)
public class QuanLyTaiKhoanPortlet extends MVCPortlet {
	
	private static Log log = LogFactoryUtil.getLog(DangKyTaiKhoanPortlet.class);
	
	@SuppressWarnings("deprecation")
	public void updateQLTK(ActionRequest request,ActionResponse response) throws IOException, PortletException {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			User    currentUser          = null;
			boolean isSucess             = false;
			int indexarray = 0;
			currentUser                  = PortalUtil.getUser(request);
			Account acc                  = AccountLocalServiceUtil.getAccountByEmail(currentUser.getEmailAddress());
			String[]  ghichuinsert = null;
			String longstr         = ParamUtil.getString(request, "longmap","");
			String latstr         = ParamUtil.getString(request, "latmap","");
			if(acc.getAccountType() == PortletKeysUtil.LoaiDoiTuongKeys.Ca_Nhan){
					SimpleDateFormat format  = new SimpleDateFormat("dd/MM/yyyy");
					String hoTen             = ParamUtil.getString(	request, "hovaten");
					int    gioiTinh          = ParamUtil.getInteger(request, "gioitinh");
					String ngaySinh          = ParamUtil.getString(	request, "startDate");
					String cmnd              = ParamUtil.getString(	request, "sogiayto");
					String soDienThoai       = ParamUtil.getString(	request, "dienthoaididong");
					String quocTich          = ParamUtil.getString(request, "quoctich");
					String soHoKhau			 = ParamUtil.getString(request, "sosohokhau");
					String ngayCap           = ParamUtil.getString(request, "ngaycap");
					String noiCap			 = ParamUtil.getString(request, "noicap");
					String hoTenCha 		 = ParamUtil.getString(request, "hotencha");
					String hoTenNguoiGiamHo  = ParamUtil.getString(request, "hotennguoigiamho");
					String hoTenMe 			 = ParamUtil.getString(request, "hotenme");
					String hoTenVoChong      = ParamUtil.getString(request, "hotenvochong");
					String hoTenChuHo		 = ParamUtil.getString(request, "hotenchuho");
					String quocGia           = ParamUtil.getString(request, DangKyTaiKhoanKeys.DangKyCongDan.QUOC_TICH_THUONG_TRU);
					String tinhThanhTT       = ParamUtil.getString(request, DangKyTaiKhoanKeys.DangKyCongDan.TINH_THANH_THUONG_TRU);
					String quanHuyenTT       = ParamUtil.getString(request, DangKyTaiKhoanKeys.DangKyCongDan.QUAN_HUYEN_THUONG_TRU);
					String phuongXaTT        = ParamUtil.getString(request, DangKyTaiKhoanKeys.DangKyCongDan.PHUONG_XA_THUONG_TRU);
					String diaChiChiTietTT   = ParamUtil.getString(request, "diachithuongtru");
					String tinhThanhXM       = ParamUtil.getString(request, DangKyTaiKhoanKeys.DangKyCongDan.TINH_THANH_XAC_MINH);
					String quanHuyenXM       = ParamUtil.getString(request, DangKyTaiKhoanKeys.DangKyCongDan.QUAN_HUYEN_XAC_MINH);
					String phuongXaXM        = ParamUtil.getString(request, DangKyTaiKhoanKeys.DangKyCongDan.PHUONG_XA_XAC_MINH);
					String diaChiXM			 = ParamUtil.getString(request, "diachixacminh");
					String base64jsonthongtin= ParamUtil.getString(	request, "jsonthongtin");
					List<Photo> listphoto    = PhotoLocalServiceUtil.getPhotosbyImageType_classPK(0, acc.getAccountId(), -1, -1);
					for(Photo pt : listphoto){
						PhotoLocalServiceUtil.deletePhoto(pt.getImageId());
					}
					String jsonthongtin = new String(DatatypeConverter.parseBase64Binary(base64jsonthongtin));
					MessageObject[] jsonobj = new Gson().fromJson(jsonthongtin, MessageObject[].class);
					ghichuinsert = new String[jsonobj.length];
					UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
					int indexsub = 0;
					for(MessageObject mes: jsonobj){
						
						String  ghichuupload         = ParamUtil.getString(request, "ghichuupload"+mes.getId(),"").trim();
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
						photo.setClassPK(acc.getAccountId());
						photo.setDescription("");
						photo.setImageType(0);
						photo.setContentType(contentType);
						photo.setApproved(true);
						photo.setUploadDate(new Date());
						photo.setMessage(mes.toString());
						PhotoLocalServiceUtil.addPhoto(photo);
						
						ghichuinsert[indexarray] = ghichuupload == null?"":ghichuupload;
						indexarray++;
						
					}
					try {
						if(ngaySinh.equals("")) {
							acc.setBirthdate(null);
						} else {
							acc.setBirthdate(format.parse(ngaySinh));
						}
						acc.setFullName(hoTen);
						acc.setGender(gioiTinh);
						acc.setPersonalId(cmnd);
						acc.setTelNo(soDienThoai);
						acc.setNationality(quocTich);
						acc.setFamilyRegNo(soHoKhau);
						if(ngayCap.equals("")) {
							acc.setRangeDate(null);
						} else {
							acc.setRangeDate(format.parse(ngayCap));
						}
						acc.setIssuedBy(noiCap);
						acc.setFatherName(hoTenCha);
						acc.setMotherName(hoTenMe);
						acc.setGuardianName(hoTenNguoiGiamHo);
						acc.setSpouseName(hoTenVoChong);
						acc.setHeadHouseholdName(hoTenChuHo);
						acc.setNation(quocGia);
						acc.setCityCode(tinhThanhTT);
						acc.setDistrictCode(quanHuyenTT);
						acc.setWardCode(phuongXaTT);
						acc.setAddress(diaChiChiTietTT);
						acc.setCityCodeXM(tinhThanhXM);
						acc.setDistrictCodeXM(quanHuyenXM);
						acc.setWardCodeXM(phuongXaXM);
						acc.setAddressXM(diaChiXM);
						AccountLocalServiceUtil.updateAccount(acc);
						KeycloakUtils.updateUser(acc.getAccountId(), 1, "");
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			} else if(acc.getAccountType() == PortletKeysUtil.LoaiDoiTuongKeys.To_Chuc){
				SimpleDateFormat format  = new SimpleDateFormat("dd/MM/yyyy");
				String tenToChuc         = ParamUtil.getString(request, "tentochuc");
				String maSoThue          = ParamUtil.getString(request, "masothue");
				String nguoiDaiDien      = ParamUtil.getString(request, "nguoidaidien");
				String soGiayToNDD		 = ParamUtil.getString(request, "sogiaytonguoidaidien");
				String soDTNDD			 = ParamUtil.getString(request, "sdtnguoidaidien");
				String toChucCapTren	 = ParamUtil.getString(request, "tochuccaptren");
				String fax    			 = ParamUtil.getString(request, "fax");
				String ngayCap			 = ParamUtil.getString(request, "startDate");
				String noiCap			 = ParamUtil.getString(request, "noicap");
				String tinhThanhTT       = ParamUtil.getString(request, DangKyTaiKhoanKeys.DangKyCongDan.TINH_THANH_THUONG_TRU);
				String quanHuyenTT       = ParamUtil.getString(request, DangKyTaiKhoanKeys.DangKyCongDan.QUAN_HUYEN_THUONG_TRU);
				String phuongXaTT        = ParamUtil.getString(request, DangKyTaiKhoanKeys.DangKyCongDan.PHUONG_XA_THUONG_TRU);
				String diaChiChiTietTT   = ParamUtil.getString(request, "diachithuongtru");
				String tinhThanhXM       = ParamUtil.getString(request, DangKyTaiKhoanKeys.DangKyCongDan.TINH_THANH_XAC_MINH);
				String quanHuyenXM       = ParamUtil.getString(request, DangKyTaiKhoanKeys.DangKyCongDan.QUAN_HUYEN_XAC_MINH);
				String phuongXaXM        = ParamUtil.getString(request, DangKyTaiKhoanKeys.DangKyCongDan.PHUONG_XA_XAC_MINH);
				String diaChiXM			 = ParamUtil.getString(request, "diachixacminh");
				String base64jsonthongtin= ParamUtil.getString(	request, "jsonthongtin");
				List<Photo> listphoto    = PhotoLocalServiceUtil.getPhotosbyImageType_classPK(0, acc.getAccountId(), -1, -1);
				for(Photo pt : listphoto){
					PhotoLocalServiceUtil.deletePhoto(pt.getImageId());
				}
				String jsonthongtin = new String(DatatypeConverter.parseBase64Binary(base64jsonthongtin));
				MessageObject[] jsonobj = new Gson().fromJson(jsonthongtin, MessageObject[].class);
				ghichuinsert = new String[jsonobj.length];
				UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
				int indexsub = 0;
				for(MessageObject mes: jsonobj){
					
					String  ghichuupload         = ParamUtil.getString(request, "ghichuupload"+mes.getId(),"").trim();
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
					photo.setClassPK(acc.getAccountId());
					photo.setDescription("");
					photo.setImageType(0);
					photo.setContentType(contentType);
					photo.setApproved(true);
					photo.setUploadDate(new Date());
					photo.setMessage(mes.toString());
					PhotoLocalServiceUtil.addPhoto(photo);
					
					ghichuinsert[indexarray] = ghichuupload == null?"":ghichuupload;
					indexarray++;
					
				}
				acc.setFullName(tenToChuc);
				acc.setTaxCode(maSoThue);
				acc.setLegalDelegate(nguoiDaiDien);
				acc.setPersonalId(soGiayToNDD);
				acc.setRepresentativeTelNo(soDTNDD);
				acc.setSuperiorOrganization(toChucCapTren);
				acc.setFax(fax);
				if(ngayCap.equals("")) {
					acc.setRangeDate(null);
				} else {
					acc.setRangeDate(format.parse(ngayCap));
				}
				acc.setIssuedBy(noiCap);
				acc.setCityCode(tinhThanhTT);
				acc.setDistrictCode(quanHuyenTT);
				acc.setWardCode(phuongXaTT);
				acc.setAddress(diaChiChiTietTT);
				acc.setCityCodeXM(tinhThanhXM);
				acc.setDistrictCodeXM(quanHuyenXM);
				acc.setWardCodeXM(phuongXaXM);
				acc.setAddressXM(diaChiXM);
				AccountLocalServiceUtil.updateAccount(acc);
				KeycloakUtils.updateUser(acc.getAccountId(), 1, "");
			}
			GhiChuObject objGhichu = new GhiChuObject();
			objGhichu.ghiChuUpLoad = ghichuinsert;
			String ghichu = new Gson().toJson(objGhichu);
			acc.setNote(ghichu);
			
			if(!latstr.trim().equals("")) {
				MappingVmap vmap = null;
				log.info("=====Update account thanh cong, ten ca nhan/to chuc=====" + " " + acc.getFullName());
				if(MappingVmapLocalServiceUtil.getToaDo(Account.class.getName(), acc.getAccountId())!=null) {
					vmap =MappingVmapLocalServiceUtil.updateToaDo(Account.class.getName(), acc.getAccountId(), latstr, longstr, "");	
				}else {
					 vmap =MappingVmapLocalServiceUtil.addMapping(Account.class.getName(), acc.getAccountId(), latstr, longstr, "");	
				}
				
				if(vmap != null) {
					log.info("Add Vmap Success");
				}else {
					log.info("Add Vmap Error");
				}
			}
			
			request.setAttribute("isSucess", isSucess);
	        SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			request.setAttribute("selectedTab", DangKyTaiKhoanKeys.Tabs.CapNhat_Tab);
			request.setAttribute("isdone", true);
			response.setRenderParameter("userId", String.valueOf(currentUser.getUserId()));
			response.setRenderParameter("tinhThanhTR", acc.getCityCode());
			response.setRenderParameter("quanHuyenTR", acc.getDistrictCode());
			response.setRenderParameter("phuongXaTR", acc.getWardCode());
			response.setRenderParameter("tinhThanhXM", acc.getCityCodeXM());
			response.setRenderParameter("quanHuyenXM", acc.getDistrictCodeXM());
			response.setRenderParameter("phuongXaXM", acc.getWardCodeXM());
			response.setRenderParameter("quocTichId", acc.getNation());
			response.setRenderParameter("jspPage", "/quanlytaikhoanportlet/view.jsp");
		} catch (Exception e) {
			log.error(e);
		}
	}
	public void updatePasswordUser(ActionRequest request, ActionResponse response) throws PortalException, SystemException, IOException
	{
		long userId = ParamUtil.getLong(request, CapNhatMatKhauKeys.Base.USER_ID);
		log.info("userId....." + userId);
		String password_old = ParamUtil.getString(request, CapNhatMatKhauKeys.Base.PASSWORD_OLD);
		String password_new = ParamUtil.getString(request, CapNhatMatKhauKeys.Base.PASSWORD_NEW);
		String passowrd_confirm = ParamUtil.getString(request, CapNhatMatKhauKeys.Base.PASSWORD_CONFIRM);
		request.setAttribute("selectedTab", DangKyTaiKhoanKeys.Tabs.MatKhau_Tab);
		UserBusiness userBusiness = new UserBusiness();
		userBusiness.updatePasswordUser(userId, password_old, password_new, passowrd_confirm, request, response);
		SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		PortalUtil.copyRequestParameters(request, response);		

	}
	
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException{
		String resourceId = resourceRequest.getResourceID();
		if("getQuanHuyenByTinhThanhKhaiSinh".equals(resourceId)){
			try{
				DangKyTaiKhoanBusiness.getQuanHuyenByTinhThanhKhaiSinh(resourceRequest, resourceResponse);
			}catch(IOException e){
				log.error(e);
			}
		}else if("getPhuongXaByQuanHuyenKhaiSinh".equals(resourceId)){
			try{
				DangKyTaiKhoanBusiness.getPhuongXaByQuanHuyenKhaiSinh(resourceRequest, resourceResponse);
			}catch(IOException e){
				log.error(e);
			}
		}if("getQuanHuyenByTinhThanhThuongTru".equals(resourceId)){
			try{
					DangKyTaiKhoanBusiness.getQuanHuyenByTinhThanhThuongTru(resourceRequest, resourceResponse);
			}catch(IOException e){
					log.error(e);
			}
		}else if("getPhuongXaByQuanHuyenThuongTru".equals(resourceId)){
			try{
					DangKyTaiKhoanBusiness.getPhuongXaByQuanHuyenThuongTru(resourceRequest, resourceResponse);
			}catch(IOException e){
					log.error(e);
			}
		}if("getQuanHuyenByTinhThanhHienTai".equals(resourceId)){
			try{
				DangKyTaiKhoanBusiness.getQuanHuyenByTinhThanhHienTai(resourceRequest, resourceResponse);
			}catch(IOException e){
				log.error(e);
			}
		}else if("getPhuongXaByQuanHuyenHienTai".equals(resourceId)){
			try{
				DangKyTaiKhoanBusiness.getPhuongXaByQuanHuyenHienTai(resourceRequest, resourceResponse);
			}catch(IOException e){
				log.error(e);
			}
		}if("getQuanHuyenByTinhThanhXacMinh".equals(resourceId)){
			try{
				DangKyTaiKhoanBusiness.getQuanHuyenByTinhThanhXacMinh(resourceRequest, resourceResponse);
			}catch(IOException e){
				log.error(e);
			}
		}else if("getPhuongXaByQuanHuyenXacMinh".equals(resourceId)){
			try{
				DangKyTaiKhoanBusiness.getPhuongXaByQuanHuyenXacMinh(resourceRequest, resourceResponse);
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
		}
	}
}
