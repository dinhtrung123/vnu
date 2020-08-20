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

package dtt.vn.user.service.service.impl;

import com.google.gson.Gson;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.configuration.ConfigurationFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.DatatypeConverter;

import dtt.vn.user.service.model.ThongTinDangKy;
import dtt.vn.user.service.service.ThongTinDangKyLocalServiceUtil;
import dtt.vn.user.service.service.base.ThongTinDangKyServiceBaseImpl;
import dtt.vn.user.service.service.util.DangKyCongDanModel;
import dtt.vn.user.service.service.util.DangKyQuyTrinhUtil;
import dtt.vn.user.service.service.util.DangKyToChucModel;
import dtt.vn.user.service.service.util.DateUtil;
import dtt.vn.user.service.service.util.JsonRequestRegister;
import dtt.vn.user.service.service.util.RegisterReponseModal;
import dtt.vn.vnpost.service.AccountLocalServiceUtil;

/**
 * The implementation of the thong tin dang ky remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>dtt.vn.user.service.service.ThongTinDangKyService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author nhanvienDTT
 * @see ThongTinDangKyServiceBaseImpl
 */
public class ThongTinDangKyServiceImpl extends ThongTinDangKyServiceBaseImpl {
	@AccessControlled(guestAccessEnabled=true)
	public String resgisteruser (String base64request){
		List<String> errorStr = new ArrayList<String>();
		String portalURL = PortalUtil.getPortalURL(
				CompanyLocalServiceUtil.getCompanies().get(0).getVirtualHostname(), PortalUtil.getPortalPort(false), false);
		List<RegisterReponseModal> listres = new ArrayList<RegisterReponseModal>();
		String hostname = PropsUtil.get("myurl.hostname");
		String urlkichhoatTC = hostname+"/web/guest/dangky/-/action/kichHoatDoanhNghiep/maKichHoat/";
		String urlkichhoatCD = hostname+"/web/guest/dangky/-/action/kichHoatCongDan/maKichHoat/";
		boolean result = true;
		try {
			String strrequest = new String(DatatypeConverter.parseBase64Binary(base64request),"UTF-8");
			JsonRequestRegister[] objectjson = new Gson().fromJson(strrequest,JsonRequestRegister[].class);
			for(JsonRequestRegister item : objectjson) {
				RegisterReponseModal res = new RegisterReponseModal();
				String username =item.username;
				String fullname=item.fullname;
				String email=item.email;
				String personalID=item.personalID;
				String brithday=item.brithday;
				String phone=item.phone;
				long citycode=item.citycode;
				long districtcode=item.districtcode;
				long wardscode=item.wardscode;
				int type = item.type;
				String taxcode = item.taxcode;
				String  address = item.address;
				long sex = 0;
				
				if(email.equals("")){
					errorStr.add("Email is empty");
					result = false;
				}else if(!email.equals("")) {
					if(DangKyQuyTrinhUtil.validateEmailAddress(email) == false){
						errorStr.add("Email is invalid");
						result = false;
					} else {
						if(AccountLocalServiceUtil.isEmailExists(email)==true){
							errorStr.add("Email is exists");
							result = false;
						}
					}
				}
				
				 if(!phone.equals("")){
					if(DangKyQuyTrinhUtil.validateNumberPhone(phone)== false){
						errorStr.add("Phone is invalid");
						result = false;
					}else {
						if(!AccountLocalServiceUtil.isphoneExists(phone)) {
							errorStr.add("Phone is exists");
							result = false;
						}
					}
				}
				
				if(username.equals("")){
					errorStr.add("Username is empty");
					result = false;
				}else{
					Pattern p = Pattern.compile("[^A-Za-z0-9.]", Pattern.CASE_INSENSITIVE);
					Matcher m = p.matcher(username);
					boolean b = m.find();
					if(b){
						errorStr.add("Username is invalid");
						result = false;
				      }else {
				    	  if(AccountLocalServiceUtil.isAccountNameExists(username)==true){
								
								errorStr.add("Username is invalid");
								result = false;
							}  
				      }
				}
				
				
				if(fullname.equals("")){
					errorStr.add("Username is empty");
					result = false;
				} 
				
				if(brithday.equals("")){
					
				}else {
						boolean nsPar = DateUtil.isValidFormat( DateUtil.DATE_FORMAT_D_M_Y,brithday,Locale.ENGLISH);
						if(!nsPar) {
							
							result = false;
						}
				
				}
				if(!taxcode.equals("")) {
					if(!AccountLocalServiceUtil.ismstExists(taxcode)) {
						errorStr.add("taxcode is exists");
						result = false;
					}	
				}
				
				if(personalID.equals("")){
					
				}else {
					if(personalID.length()<9){
						errorStr.add("CMND/CCCD is invalid");
						result = false;
					}else {
						Pattern p = Pattern.compile("[^A-Za-z0-9]", Pattern.CASE_INSENSITIVE);
						Matcher m = p.matcher(personalID);
						boolean b = m.find();
						if(b){
							errorStr.add("CMND/CCCD is invalid");
							result = false;
						     } else {
						    	 if(AccountLocalServiceUtil.ispersonalIdExists(personalID)==true){
						    		 errorStr.add("CMND/CCCD is exists");
										result = false;
									}
						     }
					}
				}
				
				/*if(citycode.equals("0")){
					
				}
				if(districtcode.equals("0")){
					
				}
				if(wardscode.equals("0")){
					
				}
				if(address.equals("")){
					
				}*/
				String makichhoat = DangKyQuyTrinhUtil.getMaKichHoat();
				if(result) {
					if(type == 0) {
						DangKyCongDanModel model = new DangKyCongDanModel();
						model.setEmail(email);
						model.setUserName(username);
						model.setPassword(DangKyQuyTrinhUtil.createRandomPassword());
						model.setHoTen(fullname);
						model.setNgaySinh(brithday);
						model.setDiaChiChiTiet(address);
						model.setSoCMND(personalID);
						model.setDienThoai(phone);
						model.setGioiTinhId(sex);
						model.setTinhId(citycode);
						model.setQuanHuyenId(districtcode);
						model.setPhuongXaId(wardscode);
						String jsonObject = DangKyQuyTrinhUtil.getJsonNoiDungDangKyCongDan(model);
						
						ThongTinDangKy ttdk = ThongTinDangKyLocalServiceUtil.addThongTinDangKy(email, username, personalID,
								makichhoat, 1, jsonObject, "email", new Date());
						
						if(ttdk != null) {
							
							if(DangKyQuyTrinhUtil.guiMailKichHoatCongDan( fullname, email, urlkichhoatCD+DangKyQuyTrinhUtil.getMd5Hash(makichhoat))) {
								res.reponsecode = 200;
							}else {
								errorStr.add("inserted account but can not send mail");
								res.reponsecode = 400;
							}
							
						}else {
							errorStr.add("Not insert account");
							res.reponsecode = 400;
						}
					}else {
						DangKyToChucModel model = new DangKyToChucModel();
						
							model.setUserName(username);
							model.setEmail(email);
							model.setTenToChuc(fullname);
							model.setDiaChiChiTiet("");
							model.setDienThoaiNDD(phone);
							model.setTaxCode(taxcode);
							model.setPassword(DangKyQuyTrinhUtil.createRandomPassword());
							model.setNguoiDaiDien("");
							model.setSoCMND_NDD(personalID);
							model.setTinhId(citycode);
							model.setQuanHuyenId(districtcode);
							model.setPhuongXaId(wardscode);
							ThongTinDangKy ttdk = ThongTinDangKyLocalServiceUtil.addThongTinDangKy(email, username, taxcode,
									makichhoat, 2, DangKyQuyTrinhUtil.getJsonNoiDungDangKyToChuc(model), "email", new Date());
							if(ttdk != null) {
								
								if(DangKyQuyTrinhUtil.guiMailKichHoatDoanhNghiep(model.getTenToChuc(),
										model.getTaxCode(), model.getEmail(), urlkichhoatTC+DangKyQuyTrinhUtil.getMd5Hash(makichhoat))) {
									res.reponsecode = 200;
								}else {
									errorStr.add("inserted account but can not send mail");
									res.reponsecode = 400;
								}
							}else {
								errorStr.add("Not insert account");
								res.reponsecode = 400;
							}
					}
				}else {
					res.reponsecode = 400;
				}
				
				String [] resDe = new String[errorStr.size()];
				errorStr.toArray(resDe);
				res.detail = resDe;
				res.username = username;
				listres.add(res);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new Gson().toJson(listres);
	}
	
	
	/*private static Log log = LogFactoryUtil.getLog(ThongTinDangKyServiceImpl.class);
	private static final Configuration _configuration = ConfigurationFactoryUtil
		    .getConfiguration(PortalClassLoaderUtil.getClassLoader(), "portlet");
	@AccessControlled(guestAccessEnabled=true)
	public String resgisteruser (String username , String fullname,String email,long sex,String personalID,String brithday,String phone,String citycode,String districtcode,String wardscode, String address){
		List<String> errorStr = new ArrayList<String>();
		ServiceContext context = new ServiceContext();
		String urlkichhoat = "http://idm.dtt.vn/web/guest/dangky/-/action/kichHoatDoanhNghiep/maKichHoat/";
		boolean result = false;
		try {
			
			if(email.equals("")){
				errorStr.add("Email is empty");
				result = false;
			}else if(!email.equals("")) {
				if(DangKyQuyTrinhUtil.validateEmailAddress(email) == false){
					errorStr.add("Email is invalid");
					result = false;
				} else {
					if(AccountLocalServiceUtil.isEmailExists(email)==true){
						errorStr.add("Email is exists");
						result = false;
					}
				}
			}
			
			 if(!phone.equals("")){
				if(DangKyQuyTrinhUtil.validateNumberPhone(phone)== false){
					errorStr.add("Phone is invalid");
					result = false;
				}else {
					if(!AccountLocalServiceUtil.isphoneExists(phone)) {
						errorStr.add("Phone is exists");
						result = false;
					}
				}
			}
			
			if(username.equals("")){
				errorStr.add("Username is empty");
				result = false;
			}else{
				Pattern p = Pattern.compile("[^A-Za-z0-9.]", Pattern.CASE_INSENSITIVE);
				Matcher m = p.matcher(username);
				boolean b = m.find();
				if(b){
					errorStr.add("Username is invalid");
					result = false;
			      }
			}
			
			if(AccountLocalServiceUtil.isAccountNameExists(username)==true){
				
				errorStr.add("Username is invalid");
				result = false;
			}
			if(fullname.equals("")){
				errorStr.add("Username is empty");
				result = false;
			} 
			
			if(brithday.equals("")){
				
			}else {
					boolean nsPar = DateUtil.isValidFormat( DateUtil.DATE_FORMAT_D_M_Y,brithday,Locale.ENGLISH);
					if(!nsPar) {
						errorStr.add("brithday is invalid");
						result = false;
					}
			
			}
			if(personalID.equals("")){
				
			}else {
				if(personalID.length()<9){
					errorStr.add("CMND/CCCD is invalid");
					result = false;
				}else {
					Pattern p = Pattern.compile("[^A-Za-z0-9]", Pattern.CASE_INSENSITIVE);
					Matcher m = p.matcher(personalID);
					boolean b = m.find();
					if(b){
						errorStr.add("CMND/CCCD is invalid");
						result = false;
					     } else {
					    	 if(AccountLocalServiceUtil.ispersonalIdExists(personalID)==true){
					    		 errorStr.add("CMND/CCCD is exists");
									result = false;
								}
					     }
				}
			}
			
			if(!citycode.equals("0")){
				
			}
			if(districtcode.equals("0")){
				
			}
			if(wardscode.equals("0")){
				
			}
			if(address.equals("")){
				
			}
			
			if(result) {
				DangKyCongDanModel model = new DangKyCongDanModel();
				model.setEmail(email);
				model.setUserName(username);
				model.setPassword(DangKyQuyTrinhUtil.createRandomPassword());
				model.setHoTen(fullname);
				model.setNgaySinh(brithday);
				model.setDiaChiChiTiet(address);
				model.setSoCMND(personalID);
				model.setDienThoai(phone);
				model.setGioiTinhId(sex);
				model.setTinhId(Long.parseLong(citycode));
				model.setQuanHuyenId(Long.parseLong(districtcode));
				model.setPhuongXaId(Long.parseLong(wardscode));
				String jsonObject = DangKyQuyTrinhUtil.getJsonNoiDungDangKyCongDan(model);
				String makichhoat = DangKyQuyTrinhUtil.getMaKichHoat();
				ThongTinDangKy ttdk = ThongTinDangKyLocalServiceUtil.addThongTinDangKy(email, username, personalID,
						makichhoat, 1, jsonObject, "email", new Date());
				
				if(ttdk != null) {
					DangKyQuyTrinhUtil.guiMailKichHoatCongDan( fullname, email, urlkichhoat+DangKyQuyTrinhUtil.getMd5Hash(makichhoat));
				}
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			errorStr.add("Exception:"+ e.getMessage());
			result = false;
		}
		RegisterReponseModal res = new RegisterReponseModal();
		if(result) {
			res.reponsecode = 200;
		}else {
			res.reponsecode = 400;
		}
		
		
		
		String [] resDe = new String[errorStr.size()];
		errorStr.toArray(resDe);
		res.detail = resDe;
		
		return new Gson().toJson(res);
		
	}*/
	
}