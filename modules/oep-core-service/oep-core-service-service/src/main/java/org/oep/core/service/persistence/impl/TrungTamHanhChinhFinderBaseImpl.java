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

package org.oep.core.service.persistence.impl;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;

import java.lang.reflect.Field;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.oep.core.model.TrungTamHanhChinh;
import org.oep.core.service.persistence.TrungTamHanhChinhPersistence;

/**
 * @author manhlb
 * @generated
 */
public class TrungTamHanhChinhFinderBaseImpl
	extends BasePersistenceImpl<TrungTamHanhChinh> {

	public TrungTamHanhChinhFinderBaseImpl() {
		setModelClass(TrungTamHanhChinh.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("donViId", "donvi_id");
		dbColumnNames.put("donViIds", "donvi_ids");
		dbColumnNames.put("thongTinLienHe", "thongtin_lienhe");
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
		return getTrungTamHanhChinhPersistence().getBadColumnNames();
	}

	/**
	 * Returns the trung tam hanh chinh persistence.
	 *
	 * @return the trung tam hanh chinh persistence
	 */
	public TrungTamHanhChinhPersistence getTrungTamHanhChinhPersistence() {
		return trungTamHanhChinhPersistence;
	}

	/**
	 * Sets the trung tam hanh chinh persistence.
	 *
	 * @param trungTamHanhChinhPersistence the trung tam hanh chinh persistence
	 */
	public void setTrungTamHanhChinhPersistence(
		TrungTamHanhChinhPersistence trungTamHanhChinhPersistence) {

		this.trungTamHanhChinhPersistence = trungTamHanhChinhPersistence;
	}

	@BeanReference(type = TrungTamHanhChinhPersistence.class)
	protected TrungTamHanhChinhPersistence trungTamHanhChinhPersistence;

	private static final Log _log = LogFactoryUtil.getLog(
		TrungTamHanhChinhFinderBaseImpl.class);

}