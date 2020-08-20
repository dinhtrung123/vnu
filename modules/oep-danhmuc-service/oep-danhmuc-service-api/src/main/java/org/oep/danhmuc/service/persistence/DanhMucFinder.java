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

package org.oep.danhmuc.service.persistence;

import aQute.bnd.annotation.ProviderType;

/**
 * @author nhanvienDTT
 * @generated
 */
@ProviderType
public interface DanhMucFinder {

	public int countItem(
		long idCha, String keyWord, String groupId, String muc);

	public java.util.List<org.oep.danhmuc.model.DanhMuc> searchItem(
		long idCha, String keyWord, String groupId, String muc, int start,
		int end);

	public org.oep.danhmuc.model.DanhMuc getDanhMucWithMaxDisplayIndex(
		long idCha);

	public org.oep.danhmuc.model.DanhMuc getItemWithMaxDisplayIndexByMuc(
		int muc);

}