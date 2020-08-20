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

package org.oep.danhmuc.service;

import aQute.bnd.annotation.ProviderType;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for DanhMuc. This utility wraps
 * <code>org.oep.danhmuc.service.impl.DanhMucServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author nhanvienDTT
 * @see DanhMucService
 * @generated
 */
@ProviderType
public class DanhMucServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>org.oep.danhmuc.service.impl.DanhMucServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static int countByTimKiem(
		long chaId, String ten, String groupId, String muc) {

		return getService().countByTimKiem(chaId, ten, groupId, muc);
	}

	public static org.oep.danhmuc.model.DanhMucSoap[] getAll(
		long nhomId, boolean isActive) {

		return getService().getAll(nhomId, isActive);
	}

	public static org.oep.danhmuc.model.DanhMucSoap getByM(String ma) {
		return getService().getByM(ma);
	}

	public static org.oep.danhmuc.model.DanhMucSoap[] getByMUC(int muc) {
		return getService().getByMUC(muc);
	}

	public static org.oep.danhmuc.model.DanhMucSoap[] getByP(long chaId) {
		return getService().getByP(chaId);
	}

	public static org.oep.danhmuc.model.DanhMucSoap getByP_T(
		long chaId, String ten) {

		return getService().getByP_T(chaId, ten);
	}

	public static org.oep.danhmuc.model.DanhMucSoap getByT(String ten) {
		return getService().getByT(ten);
	}

	public static org.oep.danhmuc.model.DanhMucSoap getByTT(int thuTuHienThi)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getByTT(thuTuHienThi);
	}

	public static org.oep.danhmuc.model.DanhMucSoap[] getDanhMuc_By_ChaId(
		long chaId, boolean isActive) {

		return getService().getDanhMuc_By_ChaId(chaId, isActive);
	}

	public static org.oep.danhmuc.model.DanhMucSoap getDanhMuc_By_Ma(
		String ma, boolean isActive) {

		return getService().getDanhMuc_By_Ma(ma, isActive);
	}

	public static org.oep.danhmuc.model.DanhMucSoap[] getDanhMuc_By_Ma_Muc(
		String ma, int muc) {

		return getService().getDanhMuc_By_Ma_Muc(ma, muc);
	}

	public static org.oep.danhmuc.model.DanhMucSoap[] getDanhMuc_By_Muc(
		long chaId, int level, boolean isActive) {

		return getService().getDanhMuc_By_Muc(chaId, level, isActive);
	}

	public static org.oep.danhmuc.model.DanhMucSoap[] getDanhMuc_By_Nhom_Muc(
		String maNhom, int level, boolean isActive) {

		return getService().getDanhMuc_By_Nhom_Muc(maNhom, level, isActive);
	}

	public static org.oep.danhmuc.model.DanhMucSoap getDanhMuc_By_Nhom_Muc_Ma(
		String maNhom, int level, String ma, boolean isActive) {

		return getService().getDanhMuc_By_Nhom_Muc_Ma(
			maNhom, level, ma, isActive);
	}

	public static org.oep.danhmuc.model.DanhMucSoap getDanhMuc_By_Nhom_Muc_Ten(
		String maNhom, int level, String ten, boolean isActive) {

		return getService().getDanhMuc_By_Nhom_Muc_Ten(
			maNhom, level, ten, isActive);
	}

	public static org.oep.danhmuc.model.DanhMucSoap getDanhMuc_Con_CuoiCung(
		long chaId, com.liferay.portal.kernel.util.OrderByComparator asc) {

		return getService().getDanhMuc_Con_CuoiCung(chaId, asc);
	}

	public static org.oep.danhmuc.model.DanhMucSoap getDanhMuc_Con_DauTien(
		long chaId, com.liferay.portal.kernel.util.OrderByComparator asc) {

		return getService().getDanhMuc_Con_DauTien(chaId, asc);
	}

	public static org.oep.danhmuc.model.DanhMucSoap getItemWithMaxDisplayIndex(
		long idCha) {

		return getService().getItemWithMaxDisplayIndex(idCha);
	}

	public static org.oep.danhmuc.model.DanhMucSoap
		getItemWithMaxDisplayIndexByMuc(int muc) {

		return getService().getItemWithMaxDisplayIndexByMuc(muc);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static org.oep.danhmuc.model.DanhMucSoap[] searchItem(
		long idCha, String ten, String groupId, String muc, int start,
		int end) {

		return getService().searchItem(idCha, ten, groupId, muc, start, end);
	}

	public static org.oep.danhmuc.model.DanhMucSoap[] timKiem(
		long chaId, String ten, String groupId, String muc, int start,
		int end) {

		return getService().timKiem(chaId, ten, groupId, muc, start, end);
	}

	public static DanhMucService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<DanhMucService, DanhMucService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(DanhMucService.class);

		ServiceTracker<DanhMucService, DanhMucService> serviceTracker =
			new ServiceTracker<DanhMucService, DanhMucService>(
				bundle.getBundleContext(), DanhMucService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}