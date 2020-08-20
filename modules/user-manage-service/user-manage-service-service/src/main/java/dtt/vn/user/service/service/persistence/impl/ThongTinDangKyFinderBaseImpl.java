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

package dtt.vn.user.service.service.persistence.impl;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;

import dtt.vn.user.service.model.ThongTinDangKy;
import dtt.vn.user.service.service.persistence.ThongTinDangKyPersistence;

import java.lang.reflect.Field;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author nhanvienDTT
 * @generated
 */
public class ThongTinDangKyFinderBaseImpl
	extends BasePersistenceImpl<ThongTinDangKy> {

	public ThongTinDangKyFinderBaseImpl() {
		setModelClass(ThongTinDangKy.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("emailAddress", "email_address");
		dbColumnNames.put("userName", "username");
		dbColumnNames.put("soGiayTo", "sogiayto");
		dbColumnNames.put("maKichHoat", "makichhoat");
		dbColumnNames.put("activeType", "activetype");
		dbColumnNames.put("doiTuongSuDungId", "doituongsudung_id");
		dbColumnNames.put("noiDung", "noidung");
		dbColumnNames.put("ngayTao", "ngaytao");

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
		return getThongTinDangKyPersistence().getBadColumnNames();
	}

	/**
	 * Returns the thong tin dang ky persistence.
	 *
	 * @return the thong tin dang ky persistence
	 */
	public ThongTinDangKyPersistence getThongTinDangKyPersistence() {
		return thongTinDangKyPersistence;
	}

	/**
	 * Sets the thong tin dang ky persistence.
	 *
	 * @param thongTinDangKyPersistence the thong tin dang ky persistence
	 */
	public void setThongTinDangKyPersistence(
		ThongTinDangKyPersistence thongTinDangKyPersistence) {

		this.thongTinDangKyPersistence = thongTinDangKyPersistence;
	}

	@BeanReference(type = ThongTinDangKyPersistence.class)
	protected ThongTinDangKyPersistence thongTinDangKyPersistence;

	private static final Log _log = LogFactoryUtil.getLog(
		ThongTinDangKyFinderBaseImpl.class);

}