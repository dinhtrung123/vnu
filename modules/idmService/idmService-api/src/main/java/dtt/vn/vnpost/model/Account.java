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

package dtt.vn.vnpost.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Account service. Represents a row in the &quot;idm_Account&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see AccountModel
 * @generated
 */
@ImplementationClassName("dtt.vn.vnpost.model.impl.AccountImpl")
@ProviderType
public interface Account extends AccountModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>dtt.vn.vnpost.model.impl.AccountImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Account, Long> ACCOUNT_ID_ACCESSOR =
		new Accessor<Account, Long>() {

			@Override
			public Long get(Account account) {
				return account.getAccountId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Account> getTypeClass() {
				return Account.class;
			}

		};

	public java.util.List<dtt.vn.vnpost.model.Photo> getPhotos();

	public java.util.List<dtt.vn.vnpost.model.Photo> getPhotos(
		String className);

	public String getPhotoURL(
		com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay,
		long imageId);

	public String getThumbnailURL(
		com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay,
		long thumbnailId);

}