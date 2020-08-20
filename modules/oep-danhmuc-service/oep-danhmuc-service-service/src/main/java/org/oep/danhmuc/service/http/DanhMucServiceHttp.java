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

package org.oep.danhmuc.service.http;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import org.oep.danhmuc.service.DanhMucServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>DanhMucServiceUtil</code> service
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
 * @see DanhMucServiceSoap
 * @generated
 */
@ProviderType
public class DanhMucServiceHttp {

	public static org.oep.danhmuc.model.DanhMucSoap[] getDanhMuc_By_Nhom_Muc(
		HttpPrincipal httpPrincipal, String maNhom, int level,
		boolean isActive) {

		try {
			MethodKey methodKey = new MethodKey(
				DanhMucServiceUtil.class, "getDanhMuc_By_Nhom_Muc",
				_getDanhMuc_By_Nhom_MucParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, maNhom, level, isActive);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (org.oep.danhmuc.model.DanhMucSoap[])returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static org.oep.danhmuc.model.DanhMucSoap getDanhMuc_By_Nhom_Muc_Ten(
		HttpPrincipal httpPrincipal, String maNhom, int level, String ten,
		boolean isActive) {

		try {
			MethodKey methodKey = new MethodKey(
				DanhMucServiceUtil.class, "getDanhMuc_By_Nhom_Muc_Ten",
				_getDanhMuc_By_Nhom_Muc_TenParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, maNhom, level, ten, isActive);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (org.oep.danhmuc.model.DanhMucSoap)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static org.oep.danhmuc.model.DanhMucSoap getDanhMuc_By_Nhom_Muc_Ma(
		HttpPrincipal httpPrincipal, String maNhom, int level, String ma,
		boolean isActive) {

		try {
			MethodKey methodKey = new MethodKey(
				DanhMucServiceUtil.class, "getDanhMuc_By_Nhom_Muc_Ma",
				_getDanhMuc_By_Nhom_Muc_MaParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, maNhom, level, ma, isActive);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (org.oep.danhmuc.model.DanhMucSoap)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static org.oep.danhmuc.model.DanhMucSoap[] getAll(
		HttpPrincipal httpPrincipal, long nhomId, boolean isActive) {

		try {
			MethodKey methodKey = new MethodKey(
				DanhMucServiceUtil.class, "getAll", _getAllParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, nhomId, isActive);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (org.oep.danhmuc.model.DanhMucSoap[])returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static org.oep.danhmuc.model.DanhMucSoap[] getDanhMuc_By_ChaId(
		HttpPrincipal httpPrincipal, long chaId, boolean isActive) {

		try {
			MethodKey methodKey = new MethodKey(
				DanhMucServiceUtil.class, "getDanhMuc_By_ChaId",
				_getDanhMuc_By_ChaIdParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, chaId, isActive);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (org.oep.danhmuc.model.DanhMucSoap[])returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static org.oep.danhmuc.model.DanhMucSoap getDanhMuc_By_Ma(
		HttpPrincipal httpPrincipal, String ma, boolean isActive) {

		try {
			MethodKey methodKey = new MethodKey(
				DanhMucServiceUtil.class, "getDanhMuc_By_Ma",
				_getDanhMuc_By_MaParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, ma, isActive);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (org.oep.danhmuc.model.DanhMucSoap)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static org.oep.danhmuc.model.DanhMucSoap[] getDanhMuc_By_Ma_Muc(
		HttpPrincipal httpPrincipal, String ma, int muc) {

		try {
			MethodKey methodKey = new MethodKey(
				DanhMucServiceUtil.class, "getDanhMuc_By_Ma_Muc",
				_getDanhMuc_By_Ma_MucParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(methodKey, ma, muc);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (org.oep.danhmuc.model.DanhMucSoap[])returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static org.oep.danhmuc.model.DanhMucSoap[] getDanhMuc_By_Muc(
		HttpPrincipal httpPrincipal, long chaId, int level, boolean isActive) {

		try {
			MethodKey methodKey = new MethodKey(
				DanhMucServiceUtil.class, "getDanhMuc_By_Muc",
				_getDanhMuc_By_MucParameterTypes7);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, chaId, level, isActive);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (org.oep.danhmuc.model.DanhMucSoap[])returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static org.oep.danhmuc.model.DanhMucSoap[] timKiem(
		HttpPrincipal httpPrincipal, long chaId, String ten, String groupId,
		String muc, int start, int end) {

		try {
			MethodKey methodKey = new MethodKey(
				DanhMucServiceUtil.class, "timKiem", _timKiemParameterTypes8);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, chaId, ten, groupId, muc, start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (org.oep.danhmuc.model.DanhMucSoap[])returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static int countByTimKiem(
		HttpPrincipal httpPrincipal, long chaId, String ten, String groupId,
		String muc) {

		try {
			MethodKey methodKey = new MethodKey(
				DanhMucServiceUtil.class, "countByTimKiem",
				_countByTimKiemParameterTypes9);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, chaId, ten, groupId, muc);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static org.oep.danhmuc.model.DanhMucSoap getDanhMuc_Con_DauTien(
		HttpPrincipal httpPrincipal, long chaId,
		com.liferay.portal.kernel.util.OrderByComparator asc) {

		try {
			MethodKey methodKey = new MethodKey(
				DanhMucServiceUtil.class, "getDanhMuc_Con_DauTien",
				_getDanhMuc_Con_DauTienParameterTypes10);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, chaId, asc);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (org.oep.danhmuc.model.DanhMucSoap)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static org.oep.danhmuc.model.DanhMucSoap getDanhMuc_Con_CuoiCung(
		HttpPrincipal httpPrincipal, long chaId,
		com.liferay.portal.kernel.util.OrderByComparator asc) {

		try {
			MethodKey methodKey = new MethodKey(
				DanhMucServiceUtil.class, "getDanhMuc_Con_CuoiCung",
				_getDanhMuc_Con_CuoiCungParameterTypes11);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, chaId, asc);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (org.oep.danhmuc.model.DanhMucSoap)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static org.oep.danhmuc.model.DanhMucSoap[] searchItem(
		HttpPrincipal httpPrincipal, long idCha, String ten, String groupId,
		String muc, int start, int end) {

		try {
			MethodKey methodKey = new MethodKey(
				DanhMucServiceUtil.class, "searchItem",
				_searchItemParameterTypes12);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, idCha, ten, groupId, muc, start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (org.oep.danhmuc.model.DanhMucSoap[])returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static org.oep.danhmuc.model.DanhMucSoap[] getByP(
		HttpPrincipal httpPrincipal, long chaId) {

		try {
			MethodKey methodKey = new MethodKey(
				DanhMucServiceUtil.class, "getByP", _getByPParameterTypes13);

			MethodHandler methodHandler = new MethodHandler(methodKey, chaId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (org.oep.danhmuc.model.DanhMucSoap[])returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static org.oep.danhmuc.model.DanhMucSoap getByT(
		HttpPrincipal httpPrincipal, String ten) {

		try {
			MethodKey methodKey = new MethodKey(
				DanhMucServiceUtil.class, "getByT", _getByTParameterTypes14);

			MethodHandler methodHandler = new MethodHandler(methodKey, ten);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (org.oep.danhmuc.model.DanhMucSoap)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static org.oep.danhmuc.model.DanhMucSoap getByP_T(
		HttpPrincipal httpPrincipal, long chaId, String ten) {

		try {
			MethodKey methodKey = new MethodKey(
				DanhMucServiceUtil.class, "getByP_T",
				_getByP_TParameterTypes15);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, chaId, ten);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (org.oep.danhmuc.model.DanhMucSoap)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static org.oep.danhmuc.model.DanhMucSoap getByM(
		HttpPrincipal httpPrincipal, String ma) {

		try {
			MethodKey methodKey = new MethodKey(
				DanhMucServiceUtil.class, "getByM", _getByMParameterTypes16);

			MethodHandler methodHandler = new MethodHandler(methodKey, ma);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (org.oep.danhmuc.model.DanhMucSoap)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static org.oep.danhmuc.model.DanhMucSoap getItemWithMaxDisplayIndex(
		HttpPrincipal httpPrincipal, long idCha) {

		try {
			MethodKey methodKey = new MethodKey(
				DanhMucServiceUtil.class, "getItemWithMaxDisplayIndex",
				_getItemWithMaxDisplayIndexParameterTypes17);

			MethodHandler methodHandler = new MethodHandler(methodKey, idCha);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (org.oep.danhmuc.model.DanhMucSoap)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static org.oep.danhmuc.model.DanhMucSoap
		getItemWithMaxDisplayIndexByMuc(HttpPrincipal httpPrincipal, int muc) {

		try {
			MethodKey methodKey = new MethodKey(
				DanhMucServiceUtil.class, "getItemWithMaxDisplayIndexByMuc",
				_getItemWithMaxDisplayIndexByMucParameterTypes18);

			MethodHandler methodHandler = new MethodHandler(methodKey, muc);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (org.oep.danhmuc.model.DanhMucSoap)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static org.oep.danhmuc.model.DanhMucSoap[] getByMUC(
		HttpPrincipal httpPrincipal, int muc) {

		try {
			MethodKey methodKey = new MethodKey(
				DanhMucServiceUtil.class, "getByMUC",
				_getByMUCParameterTypes19);

			MethodHandler methodHandler = new MethodHandler(methodKey, muc);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (org.oep.danhmuc.model.DanhMucSoap[])returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static org.oep.danhmuc.model.DanhMucSoap getByTT(
			HttpPrincipal httpPrincipal, int thuTuHienThi)
		throws com.liferay.portal.kernel.exception.SystemException {

		try {
			MethodKey methodKey = new MethodKey(
				DanhMucServiceUtil.class, "getByTT", _getByTTParameterTypes20);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, thuTuHienThi);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof
						com.liferay.portal.kernel.exception.SystemException) {

					throw (com.liferay.portal.kernel.exception.SystemException)
						e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (org.oep.danhmuc.model.DanhMucSoap)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(DanhMucServiceHttp.class);

	private static final Class<?>[] _getDanhMuc_By_Nhom_MucParameterTypes0 =
		new Class[] {String.class, int.class, boolean.class};
	private static final Class<?>[] _getDanhMuc_By_Nhom_Muc_TenParameterTypes1 =
		new Class[] {String.class, int.class, String.class, boolean.class};
	private static final Class<?>[] _getDanhMuc_By_Nhom_Muc_MaParameterTypes2 =
		new Class[] {String.class, int.class, String.class, boolean.class};
	private static final Class<?>[] _getAllParameterTypes3 = new Class[] {
		long.class, boolean.class
	};
	private static final Class<?>[] _getDanhMuc_By_ChaIdParameterTypes4 =
		new Class[] {long.class, boolean.class};
	private static final Class<?>[] _getDanhMuc_By_MaParameterTypes5 =
		new Class[] {String.class, boolean.class};
	private static final Class<?>[] _getDanhMuc_By_Ma_MucParameterTypes6 =
		new Class[] {String.class, int.class};
	private static final Class<?>[] _getDanhMuc_By_MucParameterTypes7 =
		new Class[] {long.class, int.class, boolean.class};
	private static final Class<?>[] _timKiemParameterTypes8 = new Class[] {
		long.class, String.class, String.class, String.class, int.class,
		int.class
	};
	private static final Class<?>[] _countByTimKiemParameterTypes9 =
		new Class[] {long.class, String.class, String.class, String.class};
	private static final Class<?>[] _getDanhMuc_Con_DauTienParameterTypes10 =
		new Class[] {
			long.class, com.liferay.portal.kernel.util.OrderByComparator.class
		};
	private static final Class<?>[] _getDanhMuc_Con_CuoiCungParameterTypes11 =
		new Class[] {
			long.class, com.liferay.portal.kernel.util.OrderByComparator.class
		};
	private static final Class<?>[] _searchItemParameterTypes12 = new Class[] {
		long.class, String.class, String.class, String.class, int.class,
		int.class
	};
	private static final Class<?>[] _getByPParameterTypes13 = new Class[] {
		long.class
	};
	private static final Class<?>[] _getByTParameterTypes14 = new Class[] {
		String.class
	};
	private static final Class<?>[] _getByP_TParameterTypes15 = new Class[] {
		long.class, String.class
	};
	private static final Class<?>[] _getByMParameterTypes16 = new Class[] {
		String.class
	};
	private static final Class<?>[]
		_getItemWithMaxDisplayIndexParameterTypes17 = new Class[] {long.class};
	private static final Class<?>[]
		_getItemWithMaxDisplayIndexByMucParameterTypes18 = new Class[] {
			int.class
		};
	private static final Class<?>[] _getByMUCParameterTypes19 = new Class[] {
		int.class
	};
	private static final Class<?>[] _getByTTParameterTypes20 = new Class[] {
		int.class
	};

}