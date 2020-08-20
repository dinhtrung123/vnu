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

package dtt.vn.vnpost.service;

import aQute.bnd.annotation.ProviderType;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for Account. This utility wraps
 * <code>dtt.vn.vnpost.service.impl.AccountServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see AccountService
 * @generated
 */
@ProviderType
public class AccountServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>dtt.vn.vnpost.service.impl.AccountServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static dtt.vn.vnpost.model.AccountSoap getAccountByIds(
		long accountId) {

		return getService().getAccountByIds(accountId);
	}

	public static String getDiaChiChiTiet(long accountId) {
		return getService().getDiaChiChiTiet(accountId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static dtt.vn.vnpost.model.PhotoSoap[] getThuocTinhXacMinhs(
		String classPK) {

		return getService().getThuocTinhXacMinhs(classPK);
	}

	public static dtt.vn.vnpost.model.AccountSoap[] getTotalAccountByStatus(
		int accountStatus, int accountType, int start, int end) {

		return getService().getTotalAccountByStatus(
			accountStatus, accountType, start, end);
	}

	public static com.liferay.portal.kernel.json.JSONObject PheDuyetTaiKhoan(
		long accountId, int method, String yKienCanBoPheDuyet) {

		return getService().PheDuyetTaiKhoan(
			accountId, method, yKienCanBoPheDuyet);
	}

	public static dtt.vn.vnpost.model.AccountSoap[] searchAccountByKeyWord(
		String keyword, int tinhtrang, String email, String userName,
		String fullName, String telNo) {

		return getService().searchAccountByKeyWord(
			keyword, tinhtrang, email, userName, fullName, telNo);
	}

	public static com.liferay.portal.kernel.json.JSONObject UploadFiles(
		String mangGiayTo) {

		return getService().UploadFiles(mangGiayTo);
	}

	public static boolean XacMinhTaiKhoan(
		long accountId, int XacMinhType, String yKienCanBo) {

		return getService().XacMinhTaiKhoan(accountId, XacMinhType, yKienCanBo);
	}

	public static AccountService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AccountService, AccountService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AccountService.class);

		ServiceTracker<AccountService, AccountService> serviceTracker =
			new ServiceTracker<AccountService, AccountService>(
				bundle.getBundleContext(), AccountService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}