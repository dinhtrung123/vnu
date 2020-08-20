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
 * Provides a wrapper for {@link ThongTinDangKyService}.
 *
 * @author nhanvienDTT
 * @see ThongTinDangKyService
 * @generated
 */
@ProviderType
public class ThongTinDangKyServiceWrapper
	implements ThongTinDangKyService, ServiceWrapper<ThongTinDangKyService> {

	public ThongTinDangKyServiceWrapper(
		ThongTinDangKyService thongTinDangKyService) {

		_thongTinDangKyService = thongTinDangKyService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _thongTinDangKyService.getOSGiServiceIdentifier();
	}

	@Override
	public String resgisteruser(String base64request) {
		return _thongTinDangKyService.resgisteruser(base64request);
	}

	@Override
	public ThongTinDangKyService getWrappedService() {
		return _thongTinDangKyService;
	}

	@Override
	public void setWrappedService(ThongTinDangKyService thongTinDangKyService) {
		_thongTinDangKyService = thongTinDangKyService;
	}

	private ThongTinDangKyService _thongTinDangKyService;

}