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

package dtt.vn.user.service.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DataImportService}.
 *
 * @author nhanvienDTT
 * @see DataImportService
 * @generated
 */
@ProviderType
public class DataImportServiceWrapper
	implements DataImportService, ServiceWrapper<DataImportService> {

	public DataImportServiceWrapper(DataImportService dataImportService) {
		_dataImportService = dataImportService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dataImportService.getOSGiServiceIdentifier();
	}

	@Override
	public DataImportService getWrappedService() {
		return _dataImportService;
	}

	@Override
	public void setWrappedService(DataImportService dataImportService) {
		_dataImportService = dataImportService;
	}

	private DataImportService _dataImportService;

}