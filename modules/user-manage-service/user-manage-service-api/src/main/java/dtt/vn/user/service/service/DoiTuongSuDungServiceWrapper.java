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
 * Provides a wrapper for {@link DoiTuongSuDungService}.
 *
 * @author nhanvienDTT
 * @see DoiTuongSuDungService
 * @generated
 */
@ProviderType
public class DoiTuongSuDungServiceWrapper
	implements DoiTuongSuDungService, ServiceWrapper<DoiTuongSuDungService> {

	public DoiTuongSuDungServiceWrapper(
		DoiTuongSuDungService doiTuongSuDungService) {

		_doiTuongSuDungService = doiTuongSuDungService;
	}

	@Override
	public dtt.vn.user.service.model.DoiTuongSuDungSoap getDoiTuongSuDungByMa(
		String ma) {

		return _doiTuongSuDungService.getDoiTuongSuDungByMa(ma);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _doiTuongSuDungService.getOSGiServiceIdentifier();
	}

	@Override
	public DoiTuongSuDungService getWrappedService() {
		return _doiTuongSuDungService;
	}

	@Override
	public void setWrappedService(DoiTuongSuDungService doiTuongSuDungService) {
		_doiTuongSuDungService = doiTuongSuDungService;
	}

	private DoiTuongSuDungService _doiTuongSuDungService;

}