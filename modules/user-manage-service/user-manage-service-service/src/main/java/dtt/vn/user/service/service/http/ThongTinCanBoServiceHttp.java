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

package dtt.vn.user.service.service.http;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import dtt.vn.user.service.service.ThongTinCanBoServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>ThongTinCanBoServiceUtil</code> service
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
 * @author nhanvienDTT
 * @see ThongTinCanBoServiceSoap
 * @generated
 */
@ProviderType
public class ThongTinCanBoServiceHttp {

	public static boolean importCanBos(
		HttpPrincipal httpPrincipal, String modelarr) {

		try {
			MethodKey methodKey = new MethodKey(
				ThongTinCanBoServiceUtil.class, "importCanBos",
				_importCanBosParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, modelarr);

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

	public static boolean importTochucs(
		HttpPrincipal httpPrincipal, String modelarr, long parentOrgId) {

		try {
			MethodKey methodKey = new MethodKey(
				ThongTinCanBoServiceUtil.class, "importTochucs",
				_importTochucsParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, modelarr, parentOrgId);

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

	private static Log _log = LogFactoryUtil.getLog(
		ThongTinCanBoServiceHttp.class);

	private static final Class<?>[] _importCanBosParameterTypes0 = new Class[] {
		String.class
	};
	private static final Class<?>[] _importTochucsParameterTypes1 =
		new Class[] {String.class, long.class};

}