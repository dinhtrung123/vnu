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
 * The extended model interface for the TrungTamHanhChinh service. Represents a row in the &quot;idm_trungtamhanhchinh&quot; database table, with each column mapped to a property of this class.
 *
 * @author manhlb
 * @see TrungTamHanhChinhModel
 * @generated
 */
@ImplementationClassName("org.oep.core.model.impl.TrungTamHanhChinhImpl")
@ProviderType
public interface TrungTamHanhChinh
	extends PersistedModel, TrungTamHanhChinhModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>org.oep.core.model.impl.TrungTamHanhChinhImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<TrungTamHanhChinh, Long> ID_ACCESSOR =
		new Accessor<TrungTamHanhChinh, Long>() {

			@Override
			public Long get(TrungTamHanhChinh trungTamHanhChinh) {
				return trungTamHanhChinh.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<TrungTamHanhChinh> getTypeClass() {
				return TrungTamHanhChinh.class;
			}

		};

}