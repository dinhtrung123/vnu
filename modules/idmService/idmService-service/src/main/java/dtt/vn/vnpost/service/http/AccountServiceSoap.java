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

package dtt.vn.vnpost.service.http;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import dtt.vn.vnpost.service.AccountServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * <code>AccountServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>dtt.vn.vnpost.model.AccountSoap</code>. If the method in the
 * service utility returns a
 * <code>dtt.vn.vnpost.model.Account</code>, that is translated to a
 * <code>dtt.vn.vnpost.model.AccountSoap</code>. Methods that SOAP
 * cannot safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AccountServiceHttp
 * @generated
 */
@ProviderType
public class AccountServiceSoap {

	public static dtt.vn.vnpost.model.AccountSoap getAccountByIds(
			long accountId)
		throws RemoteException {

		try {
			dtt.vn.vnpost.model.AccountSoap returnValue =
				AccountServiceUtil.getAccountByIds(accountId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static dtt.vn.vnpost.model.AccountSoap[] getTotalAccountByStatus(
			int accountStatus, int accountType, int start, int end)
		throws RemoteException {

		try {
			dtt.vn.vnpost.model.AccountSoap[] returnValue =
				AccountServiceUtil.getTotalAccountByStatus(
					accountStatus, accountType, start, end);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static String UploadFiles(String mangGiayTo) throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue =
				AccountServiceUtil.UploadFiles(mangGiayTo);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static boolean XacMinhTaiKhoan(
			long accountId, int XacMinhType, String yKienCanBo)
		throws RemoteException {

		try {
			boolean returnValue = AccountServiceUtil.XacMinhTaiKhoan(
				accountId, XacMinhType, yKienCanBo);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static String PheDuyetTaiKhoan(
			long accountId, int method, String yKienCanBoPheDuyet)
		throws RemoteException {

		try {
			com.liferay.portal.kernel.json.JSONObject returnValue =
				AccountServiceUtil.PheDuyetTaiKhoan(
					accountId, method, yKienCanBoPheDuyet);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static dtt.vn.vnpost.model.PhotoSoap[] getThuocTinhXacMinhs(
			String classPK)
		throws RemoteException {

		try {
			dtt.vn.vnpost.model.PhotoSoap[] returnValue =
				AccountServiceUtil.getThuocTinhXacMinhs(classPK);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static dtt.vn.vnpost.model.AccountSoap[] searchAccountByKeyWord(
			String keyword, int tinhtrang, String email, String userName,
			String fullName, String telNo)
		throws RemoteException {

		try {
			dtt.vn.vnpost.model.AccountSoap[] returnValue =
				AccountServiceUtil.searchAccountByKeyWord(
					keyword, tinhtrang, email, userName, fullName, telNo);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static String getDiaChiChiTiet(long accountId)
		throws RemoteException {

		try {
			String returnValue = AccountServiceUtil.getDiaChiChiTiet(accountId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(AccountServiceSoap.class);

}