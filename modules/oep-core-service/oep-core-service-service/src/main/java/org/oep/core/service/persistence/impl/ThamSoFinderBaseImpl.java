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

import org.oep.core.model.ThamSo;
import org.oep.core.service.persistence.ThamSoPersistence;

/**
 * @author manhlb
 * @generated
 */
public class ThamSoFinderBaseImpl extends BasePersistenceImpl<ThamSo> {

	public ThamSoFinderBaseImpl() {
		setModelClass(ThamSo.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("className", "classname");
		dbColumnNames.put("classPK", "classpk");
		dbColumnNames.put("loaiId", "loai_id");
		dbColumnNames.put("giaTri", "giatri");
		dbColumnNames.put("moTa", "mota");
		dbColumnNames.put("trangThai", "trangthai");
		dbColumnNames.put("quyenTacDong", "quyen_tac_dong");

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
		return getThamSoPersistence().getBadColumnNames();
	}

	/**
	 * Returns the tham so persistence.
	 *
	 * @return the tham so persistence
	 */
	public ThamSoPersistence getThamSoPersistence() {
		return thamSoPersistence;
	}

	/**
	 * Sets the tham so persistence.
	 *
	 * @param thamSoPersistence the tham so persistence
	 */
	public void setThamSoPersistence(ThamSoPersistence thamSoPersistence) {
		this.thamSoPersistence = thamSoPersistence;
	}

	@BeanReference(type = ThamSoPersistence.class)
	protected ThamSoPersistence thamSoPersistence;

	private static final Log _log = LogFactoryUtil.getLog(
		ThamSoFinderBaseImpl.class);

}