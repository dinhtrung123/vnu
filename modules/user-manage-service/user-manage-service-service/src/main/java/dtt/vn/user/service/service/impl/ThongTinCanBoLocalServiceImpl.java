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

import java.util.List;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;

import dtt.vn.user.service.model.ThongTinCanBo;
import dtt.vn.user.service.model.ThongTinDangKy;
import dtt.vn.user.service.service.base.ThongTinCanBoLocalServiceBaseImpl;

/**
 * The implementation of the thong tin can bo local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>dtt.vn.user.service.service.ThongTinCanBoLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author nhanvienDTT
 * @see ThongTinCanBoLocalServiceBaseImpl
 */
public class ThongTinCanBoLocalServiceImpl
	extends ThongTinCanBoLocalServiceBaseImpl {

	public ThongTinCanBo addThongTinCanBo (String emailAddress,String userName,String nameRole,String noiDung){
		ThongTinCanBo model = thongTinCanBoPersistence.create(CounterLocalServiceUtil.increment(ThongTinCanBo.class.getName()));
		model.setEmailAddress(emailAddress);
		model.setNameRole(nameRole);
		model.setUserName(userName);
		model.setNoiDung(noiDung);
		return thongTinCanBoPersistence.update(model);
		
	}
	public ThongTinCanBo getByEmail (String emailAddress){
		return thongTinCanBoPersistence.fetchByemailAddress(emailAddress);
	}
	public ThongTinCanBo getByUserName (String userName){
		return thongTinCanBoPersistence.fetchByuserName(userName);
	}
	public List<ThongTinCanBo> getByRoleName (String nameRole){
		return thongTinCanBoPersistence.findBynameRole(nameRole);
	}
	
	
}