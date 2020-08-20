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
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.ListTypeConstants;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;

import dtt.vn.user.service.model.ThongTinCanBo;
import dtt.vn.user.service.service.ThongTinCanBoLocalServiceUtil;
import dtt.vn.user.service.service.base.ThongTinCanBoServiceBaseImpl;
import dtt.vn.user.service.service.util.CanBoModel;
import dtt.vn.user.service.service.util.ToChucModel;

/**
 * The implementation of the thong tin can bo remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>dtt.vn.user.service.service.ThongTinCanBoService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author nhanvienDTT
 * @see ThongTinCanBoServiceBaseImpl
 */
public class ThongTinCanBoServiceImpl extends ThongTinCanBoServiceBaseImpl {

	private static Log log = LogFactoryUtil.getLog(ThongTinCanBoServiceImpl.class);
	@AccessControlled(guestAccessEnabled=true)
	public boolean importCanBos(String modelarr){
		
		boolean result = false;
		log.info("thuc hien convert array....");
		CanBoModel[] canboArr = new Gson().fromJson(modelarr, CanBoModel[].class);
		log.info("convert thanh cong");
		for(CanBoModel model : canboArr){
			ThongTinCanBo thongTinCanBo = 
					ThongTinCanBoLocalServiceUtil.addThongTinCanBo(model.getEmail(), model.getUserName(), model.getUserRole(), model.toString());
			
		}
		return result;
		
	}
	
	@AccessControlled(guestAccessEnabled=true)
	public boolean importTochucs(String modelarr, long parentOrgId){
		
		boolean result = false;
		log.info("thuc hien convert array....");
		ToChucModel[] toChucArr = new Gson().fromJson(modelarr, ToChucModel[].class);
		log.info("convert thanh cong");
		for(ToChucModel model : toChucArr){
			try {
				ThongTinCanBo thongTinCanBo = 
						ThongTinCanBoLocalServiceUtil.addThongTinCanBo(model.getAddress(), model.getUnitName(), model.getParentUnitName(), model.toString());
				ThongTinCanBoServiceImpl.importTochuc(model.getUnitName(), model.getParentUnitName(), parentOrgId, model.toString());
			} catch (Exception e) {
				log.error("xay ra loi");
			}
		}
		log.info("Them ban ghi thanh cong");
		return result;
		
	}
	private static String importTochuc (String tenTochuc, String loaiToChuc, long parentOrgId, String jsonNoiDung){
		ServiceContext serviceContext = null ;

		try {
			OrganizationLocalServiceUtil.addOrganization(20139, parentOrgId, tenTochuc, "organization", 0, 17, 12017, jsonNoiDung, true, serviceContext);
			log.info("Them to chuc thanh cong");
		} catch (PortalException e) {
			
			e.printStackTrace();
		}
		
		
		
		
		return null;
		
	}
	
}