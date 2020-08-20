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

package dtt.vn.user.service.service.persistence;

import aQute.bnd.annotation.ProviderType;

/**
 * @author nhanvienDTT
 * @generated
 */
@ProviderType
public interface DataImportFinder {

	public java.util.List<dtt.vn.user.service.model.DataImport> searchForImport(
		int hasImport, String screenName, String lastName, String email,
		String role, String tungay, String denngay, int start, int end);

	public int countForImport(
		int hasImport, String screenName, String lastName, String email,
		String role, String tungay, String denngay);

}