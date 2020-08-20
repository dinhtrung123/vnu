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

import org.oep.core.model.LogSMS;
import org.oep.core.service.persistence.LogSMSPersistence;

/**
 * @author manhlb
 * @generated
 */
public class LogSMSFinderBaseImpl extends BasePersistenceImpl<LogSMS> {

	public LogSMSFinderBaseImpl() {
		setModelClass(LogSMS.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("sentDateTime", "sent_date_time");
		dbColumnNames.put("responseDate", "response_date");
		dbColumnNames.put("errorCode", "error_code");
		dbColumnNames.put("errorDetail", "error_detail");
		dbColumnNames.put("messageId", "message_id");

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
		return getLogSMSPersistence().getBadColumnNames();
	}

	/**
	 * Returns the log sms persistence.
	 *
	 * @return the log sms persistence
	 */
	public LogSMSPersistence getLogSMSPersistence() {
		return logSMSPersistence;
	}

	/**
	 * Sets the log sms persistence.
	 *
	 * @param logSMSPersistence the log sms persistence
	 */
	public void setLogSMSPersistence(LogSMSPersistence logSMSPersistence) {
		this.logSMSPersistence = logSMSPersistence;
	}

	@BeanReference(type = LogSMSPersistence.class)
	protected LogSMSPersistence logSMSPersistence;

	private static final Log _log = LogFactoryUtil.getLog(
		LogSMSFinderBaseImpl.class);

}