/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package dtt.vn.vnpost.service.impl;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Base64;
import java.util.Base64.Decoder;

import javax.imageio.ImageIO;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonBooleanFormatVisitor;
import com.google.gson.Gson;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.configuration.ConfigurationFactoryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.RoleConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import dtt.vn.vnpost.model.Account;
import dtt.vn.vnpost.model.AccountSoap;
import dtt.vn.vnpost.model.Photo;
import dtt.vn.vnpost.model.PhotoSoap;
import dtt.vn.vnpost.model.WorkItem;
import dtt.vn.vnpost.service.AccountLocalServiceUtil;
import dtt.vn.vnpost.service.AccountServiceUtil;
import dtt.vn.vnpost.service.DanhMucLocalServiceUtil;
import dtt.vn.vnpost.service.PhotoLocalServiceUtil;
import dtt.vn.vnpost.service.WorkItemLocalServiceUtil;
import dtt.vn.vnpost.service.base.AccountServiceBaseImpl;
import dtt.vn.vnpost.service.util.APIKeys;
import dtt.vn.vnpost.service.util.APIUtils;
import dtt.vn.vnpost.service.util.GiayToObject;
import dtt.vn.vnpost.service.util.MailServiceUtil;
import dtt.vn.vnpost.service.util.MessageObject;
import dtt.vn.vnpost.service.util.PortalUtil;
import dtt.vn.vnpost.service.util.PortletKeysUtil;
import dtt.vn.vnpost.service.util.UploadFileUtils;
import dtt.vn.vnpost.service.util.YkienCanBoObject;




public class AccountServiceImpl extends AccountServiceBaseImpl {
	private static Log log = LogFactoryUtil.getLog(AccountServiceImpl.class);
	private static final Configuration _configuration = ConfigurationFactoryUtil
		    .getConfiguration(PortalClassLoaderUtil.getClassLoader(), "portlet");
	
	@AccessControlled(guestAccessEnabled=true)
	public AccountSoap getAccountByIds (long accountId){
		try {
			return AccountSoap.toSoapModel(AccountLocalServiceUtil.fetchAccount(accountId));
		} catch (Exception e) {
			log.error("API getAccountByIds "+e);
		}
		return null;
	}
	@AccessControlled(guestAccessEnabled=true)
	public AccountSoap[] getTotalAccountByStatus (int accountStatus, int accountType,int start, int end){
		try {
			int total = AccountLocalServiceUtil.getTotalAccountCountByStatus(accountStatus, accountType, "", 2, 0, start, end);
			return AccountSoap.toSoapModels(AccountLocalServiceUtil.getAccountByStatus(accountStatus, accountType, "", 2, 0, start, end));
		} catch (Exception e) {
			log.error(e);
		}
		return null;
	}
	
	@AccessControlled(guestAccessEnabled=true)
	public JSONObject UploadFiles (String mangGiayTo){
		//public JSONObject UploadFiles (long folderId,String title, long repositoryId, String fileStr){
		log.info("API uploadLifes...");
		JSONObject result = JSONFactoryUtil.createJSONObject();
		String urlFile = "";
		try {
			log.info("thuc hien convert array....");
			GiayToObject[] giayToXacMinharr = new Gson().fromJson(mangGiayTo, GiayToObject[].class);
			log.info("convert thanh cong");
			for(GiayToObject giayToObject :giayToXacMinharr){
				 urlFile = AccountServiceImpl.Uploads(giayToObject.getBase64());
				 MessageObject mes = new MessageObject();
				 mes.setId(giayToObject.getId());
				 mes.setAttrkey(giayToObject.getAttrkey());
				 mes.setThuoctinh(giayToObject.getThuoctinh());
				 mes.setLoaigt(giayToObject.getMagt());
				 mes.setUrlfile(urlFile);
				 Photo photo = PhotoLocalServiceUtil.createPhoto(CounterLocalServiceUtil.increment());
					photo.setClassName(giayToObject.getMagt());
					photo.setClassPK(Long.parseLong(giayToObject.getAccountId()));
					photo.setDescription(_configuration.get("portal.fileentry.upload.Description"));
					photo.setImageType(1);
					photo.setContentType("");
					photo.setApproved(true);
					photo.setUploadDate(new Date());
					photo.setMessage(mes.toString());
					PhotoLocalServiceUtil.addPhoto(photo);
					
			}
			result.put("response", true);
			result.put("message", "upload thanh cong");
		} catch (Exception e) {
			log.error(e);
			result.put("response", false);
			result.put("message", e.getMessage());
		}
		return result;
		
	}
	
	
	@AccessControlled(guestAccessEnabled=true)
	public boolean XacMinhTaiKhoan ( long accountId, int XacMinhType, String yKienCanBo){
		boolean result = false;
		Account account = null;
		account = AccountLocalServiceUtil.fetchAccount(accountId);
		try {
			if (account != null) {
				if(XacMinhType == APIKeys.CapNhat.XacMinh.XAC_MINH_DUNG){
					account.setAccountStatus(PortletKeysUtil.TrangThaiKeys.Cho_Phe_Duyet);//trang thai tai khoan cho phe duyet
				}else {
					account.setAccountStatus(PortletKeysUtil.TrangThaiKeys.Da_Tra_KQ_Khong_Hop_Le);//trang thai tai khoan da tra ket qua khong hop le
					try {
						log.info("thuc hien gui mail cho nguoi dung khi xac minh sai.......");
						MailServiceUtil.sendMailThongBaoXacMinhSai(account.getEmail(), account.getFullName(), account.getAccountName());
						log.info("thuc hien gui mail cho nguoi dung khi xac minh sai thanh cong");
					} catch (Exception e) {
						log.error(e.getMessage());
					}
				}
				String ykiencanboinsert= "";
				if(yKienCanBo != null && !yKienCanBo.contentEquals("")) {
					YkienCanBoObject ykien = new YkienCanBoObject();
					ykien.yKienCanBoXacMinh = yKienCanBo;
					ykien.yKienCanBoPheDuyet = "";
					ykiencanboinsert = new Gson().toJson(ykien);
				}
				account.setMessage(ykiencanboinsert);
				account.setModifiedDate(new Date());
				AccountLocalServiceUtil.updateAccount(account);
				
				WorkItem workItem = WorkItemLocalServiceUtil.createWorkItem();
				workItem.setGroupId(20126);
				workItem.setCreateDate(new Date());
				workItem.setStartTime(new Date());

				workItem.setTitle("XACMINH_TAIKHOAN");
				workItem.setStatus("UPDATE");
				workItem.setAccountId(accountId);
				WorkItemLocalServiceUtil.addWorkItem(workItem);
				result= true;
				log.info(" API xac minh thanh cong");
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return result;
		
	}
	
	@AccessControlled(guestAccessEnabled=true)
	public JSONObject PheDuyetTaiKhoan (long accountId , int method,String yKienCanBoPheDuyet){
		JSONObject result = JSONFactoryUtil.createJSONObject();
		Account account = AccountLocalServiceUtil.fetchAccount(accountId);
		if(account != null){
			log.info("account khac null");
			if(method == APIKeys.CapNhat.PheDuyet.PHE_DUYET){
				log.info("thuc hien phe duyet");
				account.setAccountStatus(PortletKeysUtil.TrangThaiKeys.Cap_Chung_Nhan_Dinh_Danh);
				account.setModifiedDate(new Date());
				account.setIpLevel(3);
				AccountLocalServiceUtil.updateAccount(account);
				APIUtils.doAddWorkItem(accountId, method);
				result.put("response", true);
				result.put("message", "Cap nhat phe duyet thanh cong");
				try {
					log.info("Thuc hien gui mail thong bao phe duyet DONG Y........");
					MailServiceUtil.sendMailThongBaoPheDuyetDung(account.getEmail(), account.getFullName(), account.getAccountName());
					log.info("Thuc hien gui mail thong bao phe duyet DONG Y thanh cong");
				} catch (Exception e) {
					log.error(e.getMessage());
				}
				log.info("Cap nhat thanh cong");
			}
			if(method == APIKeys.CapNhat.PheDuyet.TU_CHOI){
				log.info("tu choi phe duyet");
				account.setAccountStatus(PortletKeysUtil.TrangThaiKeys.Da_Tra_KQ_Khong_Hop_Le);
				account.setModifiedDate(new Date());
				
				String messageaccount = account.getMessage();
				YkienCanBoObject ykien = new YkienCanBoObject();
				if(!messageaccount.equals("")){
					ykien = new Gson().fromJson(messageaccount, YkienCanBoObject.class);
				}
				ykien.yKienCanBoPheDuyet = yKienCanBoPheDuyet;
				account.setMessage(new Gson().toJson(ykien));
				AccountLocalServiceUtil.updateAccount(account);
				APIUtils.doAddWorkItem(accountId, method);
				result.put("response", true);
				result.put("message", "Cap nhat phe duyet thanh cong");
				log.info("Cap nhat thanh cong");
				try {
					log.info("Thuc hien gui mail thong bao PHE DUYET TU CHOI........");
					MailServiceUtil.sendMailThongBaoPheDuyetSai(account.getEmail(), account.getFullName(), account.getAccountName());
					log.info("Thuc hien gui mail thong bao PHE DUYET TU CHOI thanh cong");
				} catch (Exception e) {
					log.error(e.getMessage());
				}
				
			}
			
		}else {
			result.put("response", false);
			result.put("message", "khong tim thay Account voi accountId truyen vao");
			log.error("khong tim thay account");
		}
		
		return result;
		
		
	}
	
	@AccessControlled(guestAccessEnabled=true)
	public PhotoSoap[] getThuocTinhXacMinhs (String classPK){
		try {
			List<Photo> listGiayTo = PhotoLocalServiceUtil.getPhotoByClassPK(classPK);
			return PhotoSoap.toSoapModels(listGiayTo);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
		
	}
	private static  String Uploads(String base64){
		String urlFile ="";
		ServiceContext serviceContext = new ServiceContext() ;
		serviceContext.setScopeGroupId(20126);
		serviceContext.setUserId(20139);
		String title ="";
		try {
	        byte[] imgBytes = Base64.getDecoder().decode(base64);   
	       BufferedImage bufImg = ImageIO.read(new ByteArrayInputStream(imgBytes));
	       File imgOutFile = new File(UUID.randomUUID().toString()+".png");
	       ImageIO.write(bufImg, "png", imgOutFile);
	       title = imgOutFile.getName();
			 log.info("convert string base64 to file success");
			FileEntry fileEntry =DLAppLocalServiceUtil.addFileEntry(20139,Long.parseLong( _configuration.get("portal.folder.upload.repositoryId")),Long.parseLong( _configuration.get("portal.folder.upload.folderId")), "mobileFileName", MimeTypesUtil.getContentType(imgOutFile), title, "", "", imgOutFile, serviceContext);
			urlFile = "/c/document_library/get_file?uuid="+ fileEntry.getUuid() + "&groupId=" + Long.parseLong( _configuration.get("portal.folder.upload.repositoryId"));
			try {
				APIUtils.setFilePermissions(fileEntry);
				log.info("uploadfile thanh cong");
			} catch (Exception e) {
				log.error(e.getMessage());
			}
			
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
		return urlFile;
	}
	
	
	@AccessControlled(guestAccessEnabled=true)
	public AccountSoap[] searchAccountByKeyWord (String keyword,int tinhtrang,String email, String userName, String fullName,String telNo){
		int endCount = 0;
		try {
			endCount = AccountLocalServiceUtil.countAccountForAPI(keyword,tinhtrang,email, userName, fullName, telNo);
			return AccountSoap.toSoapModels(AccountLocalServiceUtil.searchAccountForAPI(keyword,tinhtrang,email, userName, fullName, telNo, 0, endCount));
		} catch (Exception e) {
			log.error(e.getMessage());
		}
				return null;
		
	}
	
	@AccessControlled(guestAccessEnabled=true)
	public String getDiaChiChiTiet( long accountId){
		String result = null;
		String diaChiChiTiet = null;
		String wardXM = "";
		String districtXM = "";
		String cityXM = "";
		try {
			Account account = AccountLocalServiceUtil.fetchAccount(accountId);
			if(account != null){
				wardXM =DanhMucLocalServiceUtil.fetchDanhMuc(Long.parseLong(account.getWardCode()))==null?"": DanhMucLocalServiceUtil.fetchDanhMuc(Long.parseLong(account.getWardCode()))
						.getTen();
    			districtXM =DanhMucLocalServiceUtil.fetchDanhMuc(Long.parseLong(account.getDistrictCode()))==null?"": DanhMucLocalServiceUtil.fetchDanhMuc(Long.parseLong(account.getDistrictCode())).
						getTen();
    			cityXM = DanhMucLocalServiceUtil.fetchDanhMuc(Long.parseLong(account.getCityCode()))==null?"": DanhMucLocalServiceUtil.fetchDanhMuc(Long.parseLong(account.getCityCode())).getTen();
    			
    			diaChiChiTiet =account.getAddress()+"-"+wardXM+"-"+districtXM+"-"+ cityXM;
    			result = diaChiChiTiet;
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			result = "invalid accountId";
		}
		return result;
	}

}

