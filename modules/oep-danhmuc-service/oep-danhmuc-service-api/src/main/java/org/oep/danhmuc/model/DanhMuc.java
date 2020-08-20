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

package org.oep.danhmuc.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the DanhMuc service. Represents a row in the &quot;data_item&quot; database table, with each column mapped to a property of this class.
 *
 * @author nhanvienDTT
 * @see DanhMucModel
 * @generated
 */
@ImplementationClassName("org.oep.danhmuc.model.impl.DanhMucImpl")
@ProviderType
public interface DanhMuc extends DanhMucModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>org.oep.danhmuc.model.impl.DanhMucImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<DanhMuc, Long> ID_ACCESSOR =
		new Accessor<DanhMuc, Long>() {

			@Override
			public Long get(DanhMuc danhMuc) {
				return danhMuc.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<DanhMuc> getTypeClass() {
				return DanhMuc.class;
			}

		};

}