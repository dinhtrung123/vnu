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

package org.oep.core.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LogSMSService}.
 *
 * @author manhlb
 * @see LogSMSService
 * @generated
 */
@ProviderType
public class LogSMSServiceWrapper
	implements LogSMSService, ServiceWrapper<LogSMSService> {

	public LogSMSServiceWrapper(LogSMSService logSMSService) {
		_logSMSService = logSMSService;
	}

	@Override
	public boolean addSMSLog(
		String error_code, String phone, String error_detail,
		String messageId) {

		return _logSMSService.addSMSLog(
			error_code, phone, error_detail, messageId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _logSMSService.getOSGiServiceIdentifier();
	}

	@Override
	public LogSMSService getWrappedService() {
		return _logSMSService;
	}

	@Override
	public void setWrappedService(LogSMSService logSMSService) {
		_logSMSService = logSMSService;
	}

	private LogSMSService _logSMSService;

}