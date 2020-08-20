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

import com.liferay.portal.kernel.exception.SystemException;

import dtt.vn.vnpost.model.Nhom;
import dtt.vn.vnpost.service.base.NhomLocalServiceBaseImpl;

/**
 * The implementation of the nhom local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>dtt.vn.vnpost.service.NhomLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NhomLocalServiceBaseImpl
 */
public class NhomLocalServiceImpl extends NhomLocalServiceBaseImpl {

	public Nhom getNhomByMa(String maNhom) throws SystemException {
		return nhomPersistence.fetchByMa(maNhom);
	}
}