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

import java.rmi.RemoteException;

import org.oep.danhmuc.service.DanhMucServiceUtil;

/**
 * Provides the SOAP utility for the
 * <code>DanhMucServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>org.oep.danhmuc.model.DanhMucSoap</code>. If the method in the
 * service utility returns a
 * <code>org.oep.danhmuc.model.DanhMuc</code>, that is translated to a
 * <code>org.oep.danhmuc.model.DanhMucSoap</code>. Methods that SOAP
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
 * @author nhanvienDTT
 * @see DanhMucServiceHttp
 * @generated
 */
@ProviderType
public class DanhMucServiceSoap {

	public static org.oep.danhmuc.model.DanhMucSoap[] getDanhMuc_By_Nhom_Muc(
			String maNhom, int level, boolean isActive)
		throws RemoteException {

		try {
			org.oep.danhmuc.model.DanhMucSoap[] returnValue =
				DanhMucServiceUtil.getDanhMuc_By_Nhom_Muc(
					maNhom, level, isActive);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static org.oep.danhmuc.model.DanhMucSoap getDanhMuc_By_Nhom_Muc_Ten(
			String maNhom, int level, String ten, boolean isActive)
		throws RemoteException {

		try {
			org.oep.danhmuc.model.DanhMucSoap returnValue =
				DanhMucServiceUtil.getDanhMuc_By_Nhom_Muc_Ten(
					maNhom, level, ten, isActive);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static org.oep.danhmuc.model.DanhMucSoap getDanhMuc_By_Nhom_Muc_Ma(
			String maNhom, int level, String ma, boolean isActive)
		throws RemoteException {

		try {
			org.oep.danhmuc.model.DanhMucSoap returnValue =
				DanhMucServiceUtil.getDanhMuc_By_Nhom_Muc_Ma(
					maNhom, level, ma, isActive);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static org.oep.danhmuc.model.DanhMucSoap[] getAll(
			long nhomId, boolean isActive)
		throws RemoteException {

		try {
			org.oep.danhmuc.model.DanhMucSoap[] returnValue =
				DanhMucServiceUtil.getAll(nhomId, isActive);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static org.oep.danhmuc.model.DanhMucSoap[] getDanhMuc_By_ChaId(
			long chaId, boolean isActive)
		throws RemoteException {

		try {
			org.oep.danhmuc.model.DanhMucSoap[] returnValue =
				DanhMucServiceUtil.getDanhMuc_By_ChaId(chaId, isActive);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static org.oep.danhmuc.model.DanhMucSoap getDanhMuc_By_Ma(
			String ma, boolean isActive)
		throws RemoteException {

		try {
			org.oep.danhmuc.model.DanhMucSoap returnValue =
				DanhMucServiceUtil.getDanhMuc_By_Ma(ma, isActive);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static org.oep.danhmuc.model.DanhMucSoap[] getDanhMuc_By_Ma_Muc(
			String ma, int muc)
		throws RemoteException {

		try {
			org.oep.danhmuc.model.DanhMucSoap[] returnValue =
				DanhMucServiceUtil.getDanhMuc_By_Ma_Muc(ma, muc);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static org.oep.danhmuc.model.DanhMucSoap[] getDanhMuc_By_Muc(
			long chaId, int level, boolean isActive)
		throws RemoteException {

		try {
			org.oep.danhmuc.model.DanhMucSoap[] returnValue =
				DanhMucServiceUtil.getDanhMuc_By_Muc(chaId, level, isActive);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static org.oep.danhmuc.model.DanhMucSoap[] timKiem(
			long chaId, String ten, String groupId, String muc, int start,
			int end)
		throws RemoteException {

		try {
			org.oep.danhmuc.model.DanhMucSoap[] returnValue =
				DanhMucServiceUtil.timKiem(
					chaId, ten, groupId, muc, start, end);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countByTimKiem(
			long chaId, String ten, String groupId, String muc)
		throws RemoteException {

		try {
			int returnValue = DanhMucServiceUtil.countByTimKiem(
				chaId, ten, groupId, muc);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static org.oep.danhmuc.model.DanhMucSoap getDanhMuc_Con_DauTien(
			long chaId, com.liferay.portal.kernel.util.OrderByComparator asc)
		throws RemoteException {

		try {
			org.oep.danhmuc.model.DanhMucSoap returnValue =
				DanhMucServiceUtil.getDanhMuc_Con_DauTien(chaId, asc);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static org.oep.danhmuc.model.DanhMucSoap getDanhMuc_Con_CuoiCung(
			long chaId, com.liferay.portal.kernel.util.OrderByComparator asc)
		throws RemoteException {

		try {
			org.oep.danhmuc.model.DanhMucSoap returnValue =
				DanhMucServiceUtil.getDanhMuc_Con_CuoiCung(chaId, asc);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static org.oep.danhmuc.model.DanhMucSoap[] searchItem(
			long idCha, String ten, String groupId, String muc, int start,
			int end)
		throws RemoteException {

		try {
			org.oep.danhmuc.model.DanhMucSoap[] returnValue =
				DanhMucServiceUtil.searchItem(
					idCha, ten, groupId, muc, start, end);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static org.oep.danhmuc.model.DanhMucSoap[] getByP(long chaId)
		throws RemoteException {

		try {
			org.oep.danhmuc.model.DanhMucSoap[] returnValue =
				DanhMucServiceUtil.getByP(chaId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static org.oep.danhmuc.model.DanhMucSoap getByT(String ten)
		throws RemoteException {

		try {
			org.oep.danhmuc.model.DanhMucSoap returnValue =
				DanhMucServiceUtil.getByT(ten);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static org.oep.danhmuc.model.DanhMucSoap getByP_T(
			long chaId, String ten)
		throws RemoteException {

		try {
			org.oep.danhmuc.model.DanhMucSoap returnValue =
				DanhMucServiceUtil.getByP_T(chaId, ten);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static org.oep.danhmuc.model.DanhMucSoap getByM(String ma)
		throws RemoteException {

		try {
			org.oep.danhmuc.model.DanhMucSoap returnValue =
				DanhMucServiceUtil.getByM(ma);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static org.oep.danhmuc.model.DanhMucSoap getItemWithMaxDisplayIndex(
			long idCha)
		throws RemoteException {

		try {
			org.oep.danhmuc.model.DanhMucSoap returnValue =
				DanhMucServiceUtil.getItemWithMaxDisplayIndex(idCha);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static org.oep.danhmuc.model.DanhMucSoap
			getItemWithMaxDisplayIndexByMuc(int muc)
		throws RemoteException {

		try {
			org.oep.danhmuc.model.DanhMucSoap returnValue =
				DanhMucServiceUtil.getItemWithMaxDisplayIndexByMuc(muc);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static org.oep.danhmuc.model.DanhMucSoap[] getByMUC(int muc)
		throws RemoteException {

		try {
			org.oep.danhmuc.model.DanhMucSoap[] returnValue =
				DanhMucServiceUtil.getByMUC(muc);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static org.oep.danhmuc.model.DanhMucSoap getByTT(int thuTuHienThi)
		throws RemoteException {

		try {
			org.oep.danhmuc.model.DanhMucSoap returnValue =
				DanhMucServiceUtil.getByTT(thuTuHienThi);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(DanhMucServiceSoap.class);

}