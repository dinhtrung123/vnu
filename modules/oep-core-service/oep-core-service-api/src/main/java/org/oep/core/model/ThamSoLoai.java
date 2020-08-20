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

package org.oep.core.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the ThamSoLoai service. Represents a row in the &quot;oep_thamso_loai&quot; database table, with each column mapped to a property of this class.
 *
 * @author manhlb
 * @see ThamSoLoaiModel
 * @generated
 */
@ImplementationClassName("org.oep.core.model.impl.ThamSoLoaiImpl")
@ProviderType
public interface ThamSoLoai extends PersistedModel, ThamSoLoaiModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>org.oep.core.model.impl.ThamSoLoaiImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ThamSoLoai, Long> ID_ACCESSOR =
		new Accessor<ThamSoLoai, Long>() {

			@Override
			public Long get(ThamSoLoai thamSoLoai) {
				return thamSoLoai.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<ThamSoLoai> getTypeClass() {
				return ThamSoLoai.class;
			}

		};

}