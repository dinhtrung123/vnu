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

package dtt.vn.user.service.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the DataImport service. Represents a row in the &quot;idm_dataimport&quot; database table, with each column mapped to a property of this class.
 *
 * @author nhanvienDTT
 * @see DataImportModel
 * @generated
 */
@ImplementationClassName("dtt.vn.user.service.model.impl.DataImportImpl")
@ProviderType
public interface DataImport extends DataImportModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>dtt.vn.user.service.model.impl.DataImportImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<DataImport, Long> ID_ACCESSOR =
		new Accessor<DataImport, Long>() {

			@Override
			public Long get(DataImport dataImport) {
				return dataImport.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<DataImport> getTypeClass() {
				return DataImport.class;
			}

		};

}