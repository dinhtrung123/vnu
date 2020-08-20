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

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import dtt.vn.user.service.model.DoiTuongSuDungSoap;
import dtt.vn.user.service.service.base.DoiTuongSuDungServiceBaseImpl;

/**
 * The implementation of the doi tuong su dung remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>dtt.vn.user.service.service.DoiTuongSuDungService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author nhanvienDTT
 * @see DoiTuongSuDungServiceBaseImpl
 */
public class DoiTuongSuDungServiceImpl extends DoiTuongSuDungServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>dtt.vn.user.service.service.DoiTuongSuDungServiceUtil</code> to access the doi tuong su dung remote service.
	 */
private static Log log = LogFactoryUtil.getLog(DoiTuongSuDungServiceImpl.class);
	
	public DoiTuongSuDungSoap getDoiTuongSuDungByMa(String ma) {
		try {
			if(doiTuongSuDungLocalService.getDoiTuongSuDungByMa(ma)!= null){
				return DoiTuongSuDungSoap.toSoapModel(doiTuongSuDungLocalService.getDoiTuongSuDungByMa(ma));
			}else{
				return null;
			}
		} catch (SystemException e) {
			log.error(e);
		}
		return null;
	}
}