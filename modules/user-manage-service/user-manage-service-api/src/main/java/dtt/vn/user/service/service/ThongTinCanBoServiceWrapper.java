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
 * Provides a wrapper for {@link ThongTinCanBoService}.
 *
 * @author nhanvienDTT
 * @see ThongTinCanBoService
 * @generated
 */
@ProviderType
public class ThongTinCanBoServiceWrapper
	implements ThongTinCanBoService, ServiceWrapper<ThongTinCanBoService> {

	public ThongTinCanBoServiceWrapper(
		ThongTinCanBoService thongTinCanBoService) {

		_thongTinCanBoService = thongTinCanBoService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _thongTinCanBoService.getOSGiServiceIdentifier();
	}

	@Override
	public boolean importCanBos(String modelarr) {
		return _thongTinCanBoService.importCanBos(modelarr);
	}

	@Override
	public boolean importTochucs(String modelarr, long parentOrgId) {
		return _thongTinCanBoService.importTochucs(modelarr, parentOrgId);
	}

	@Override
	public ThongTinCanBoService getWrappedService() {
		return _thongTinCanBoService;
	}

	@Override
	public void setWrappedService(ThongTinCanBoService thongTinCanBoService) {
		_thongTinCanBoService = thongTinCanBoService;
	}

	private ThongTinCanBoService _thongTinCanBoService;

}