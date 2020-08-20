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

import dtt.vn.user.service.model.DataImport;
import dtt.vn.user.service.service.persistence.DataImportPersistence;

import java.lang.reflect.Field;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author nhanvienDTT
 * @generated
 */
public class DataImportFinderBaseImpl extends BasePersistenceImpl<DataImport> {

	public DataImportFinderBaseImpl() {
		setModelClass(DataImport.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("screenName", "screen_name");
		dbColumnNames.put("firstName", "first_name");
		dbColumnNames.put("lastName", "last_name");
		dbColumnNames.put("emailAddress", "email_address");
		dbColumnNames.put("jobTitle", "job_title");
		dbColumnNames.put("nameRole", "role_name");
		dbColumnNames.put("numberId", "number_id");
		dbColumnNames.put("hasImport", "has_import");
		dbColumnNames.put("errorMsg", "error_message");
		dbColumnNames.put("insertDate", "insert_date");

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
		return getDataImportPersistence().getBadColumnNames();
	}

	/**
	 * Returns the data import persistence.
	 *
	 * @return the data import persistence
	 */
	public DataImportPersistence getDataImportPersistence() {
		return dataImportPersistence;
	}

	/**
	 * Sets the data import persistence.
	 *
	 * @param dataImportPersistence the data import persistence
	 */
	public void setDataImportPersistence(
		DataImportPersistence dataImportPersistence) {

		this.dataImportPersistence = dataImportPersistence;
	}

	@BeanReference(type = DataImportPersistence.class)
	protected DataImportPersistence dataImportPersistence;

	private static final Log _log = LogFactoryUtil.getLog(
		DataImportFinderBaseImpl.class);

}