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
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import dtt.vn.vnpost.service.AccountServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>AccountServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AccountServiceSoap
 * @generated
 */
@ProviderType
public class AccountServiceHttp {

	public static dtt.vn.vnpost.model.AccountSoap getAccountByIds(
		HttpPrincipal httpPrincipal, long accountId) {

		try {
			MethodKey methodKey = new MethodKey(
				AccountServiceUtil.class, "getAccountByIds",
				_getAccountByIdsParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, accountId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (dtt.vn.vnpost.model.AccountSoap)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static dtt.vn.vnpost.model.AccountSoap[] getTotalAccountByStatus(
		HttpPrincipal httpPrincipal, int accountStatus, int accountType,
		int start, int end) {

		try {
			MethodKey methodKey = new MethodKey(
				AccountServiceUtil.class, "getTotalAccountByStatus",
				_getTotalAccountByStatusParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, accountStatus, accountType, start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (dtt.vn.vnpost.model.AccountSoap[])returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.portal.kernel.json.JSONObject UploadFiles(
		HttpPrincipal httpPrincipal, String mangGiayTo) {

		try {
			MethodKey methodKey = new MethodKey(
				AccountServiceUtil.class, "UploadFiles",
				_UploadFilesParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, mangGiayTo);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (com.liferay.portal.kernel.json.JSONObject)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static boolean XacMinhTaiKhoan(
		HttpPrincipal httpPrincipal, long accountId, int XacMinhType,
		String yKienCanBo) {

		try {
			MethodKey methodKey = new MethodKey(
				AccountServiceUtil.class, "XacMinhTaiKhoan",
				_XacMinhTaiKhoanParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, accountId, XacMinhType, yKienCanBo);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return ((Boolean)returnObj).booleanValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.portal.kernel.json.JSONObject PheDuyetTaiKhoan(
		HttpPrincipal httpPrincipal, long accountId, int method,
		String yKienCanBoPheDuyet) {

		try {
			MethodKey methodKey = new MethodKey(
				AccountServiceUtil.class, "PheDuyetTaiKhoan",
				_PheDuyetTaiKhoanParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, accountId, method, yKienCanBoPheDuyet);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (com.liferay.portal.kernel.json.JSONObject)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static dtt.vn.vnpost.model.PhotoSoap[] getThuocTinhXacMinhs(
		HttpPrincipal httpPrincipal, String classPK) {

		try {
			MethodKey methodKey = new MethodKey(
				AccountServiceUtil.class, "getThuocTinhXacMinhs",
				_getThuocTinhXacMinhsParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(methodKey, classPK);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (dtt.vn.vnpost.model.PhotoSoap[])returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static dtt.vn.vnpost.model.AccountSoap[] searchAccountByKeyWord(
		HttpPrincipal httpPrincipal, String keyword, int tinhtrang,
		String email, String userName, String fullName, String telNo) {

		try {
			MethodKey methodKey = new MethodKey(
				AccountServiceUtil.class, "searchAccountByKeyWord",
				_searchAccountByKeyWordParameterTypes7);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, keyword, tinhtrang, email, userName, fullName,
				telNo);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (dtt.vn.vnpost.model.AccountSoap[])returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static String getDiaChiChiTiet(
		HttpPrincipal httpPrincipal, long accountId) {

		try {
			MethodKey methodKey = new MethodKey(
				AccountServiceUtil.class, "getDiaChiChiTiet",
				_getDiaChiChiTietParameterTypes8);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, accountId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (String)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(AccountServiceHttp.class);

	private static final Class<?>[] _getAccountByIdsParameterTypes0 =
		new Class[] {long.class};
	private static final Class<?>[] _getTotalAccountByStatusParameterTypes1 =
		new Class[] {int.class, int.class, int.class, int.class};
	private static final Class<?>[] _UploadFilesParameterTypes2 = new Class[] {
		String.class
	};
	private static final Class<?>[] _XacMinhTaiKhoanParameterTypes3 =
		new Class[] {long.class, int.class, String.class};
	private static final Class<?>[] _PheDuyetTaiKhoanParameterTypes4 =
		new Class[] {long.class, int.class, String.class};
	private static final Class<?>[] _getThuocTinhXacMinhsParameterTypes5 =
		new Class[] {String.class};
	private static final Class<?>[] _searchAccountByKeyWordParameterTypes7 =
		new Class[] {
			String.class, int.class, String.class, String.class, String.class,
			String.class
		};
	private static final Class<?>[] _getDiaChiChiTietParameterTypes8 =
		new Class[] {long.class};

}