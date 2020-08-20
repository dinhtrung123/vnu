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

package org.oep.danhmuc.service.persistence.impl;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;

import java.lang.reflect.Field;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.oep.danhmuc.model.DanhMuc;
import org.oep.danhmuc.service.persistence.DanhMucPersistence;

/**
 * @author nhanvienDTT
 * @generated
 */
public class DanhMucFinderBaseImpl extends BasePersistenceImpl<DanhMuc> {

	public DanhMucFinderBaseImpl() {
		setModelClass(DanhMuc.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("nhomId", "nhom_id");
		dbColumnNames.put("ten", "TEN");
		dbColumnNames.put("moTa", "mota");
		dbColumnNames.put("chaId", "cha_id");
		dbColumnNames.put("thuTuHienThi", "thutu_hienthi");
		dbColumnNames.put("maGiaPha", "ma_giapha");
		dbColumnNames.put("trangThai", "trangthai");

		try {
			Field field = BasePersistenceImpl.class.getDeclaredField(
				"_dbColumnNames");

			field.setAccessible(true);

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	@Override
	public Set<String> getBadColumnNames() {
		return getDanhMucPersistence().getBadColumnNames();
	}

	/**
	 * Returns the danh muc persistence.
	 *
	 * @return the danh muc persistence
	 */
	public DanhMucPersistence getDanhMucPersistence() {
		return danhMucPersistence;
	}

	/**
	 * Sets the danh muc persistence.
	 *
	 * @param danhMucPersistence the danh muc persistence
	 */
	public void setDanhMucPersistence(DanhMucPersistence danhMucPersistence) {
		this.danhMucPersistence = danhMucPersistence;
	}

	@BeanReference(type = DanhMucPersistence.class)
	protected DanhMucPersistence danhMucPersistence;

	private static final Log _log = LogFactoryUtil.getLog(
		DanhMucFinderBaseImpl.class);

}