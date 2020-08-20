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

package dtt.vn.vnpost.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PhotoService}.
 *
 * @author Brian Wing Shun Chan
 * @see PhotoService
 * @generated
 */
@ProviderType
public class PhotoServiceWrapper
	implements PhotoService, ServiceWrapper<PhotoService> {

	public PhotoServiceWrapper(PhotoService photoService) {
		_photoService = photoService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _photoService.getOSGiServiceIdentifier();
	}

	@Override
	public PhotoService getWrappedService() {
		return _photoService;
	}

	@Override
	public void setWrappedService(PhotoService photoService) {
		_photoService = photoService;
	}

	private PhotoService _photoService;

}