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

package org.oep.core.service.persistence;

import aQute.bnd.annotation.ProviderType;

/**
 * @author manhlb
 * @generated
 */
@ProviderType
public interface TrungTamHanhChinhFinder {

	public java.util.List<org.oep.core.model.TrungTamHanhChinh> searchTTHC(
		String ten_ma, long coQuanQuanLyId, int trangThai, int start, int end);

	public int countTTHC(String ten_ma, long coQuanQuanLyId, int trangThai);

}