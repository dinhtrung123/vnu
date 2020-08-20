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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DanhMucService}.
 *
 * @author nhanvienDTT
 * @see DanhMucService
 * @generated
 */
@ProviderType
public class DanhMucServiceWrapper
	implements DanhMucService, ServiceWrapper<DanhMucService> {

	public DanhMucServiceWrapper(DanhMucService danhMucService) {
		_danhMucService = danhMucService;
	}

	@Override
	public int countByTimKiem(
		long chaId, String ten, String groupId, String muc) {

		return _danhMucService.countByTimKiem(chaId, ten, groupId, muc);
	}

	@Override
	public org.oep.danhmuc.model.DanhMucSoap[] getAll(
		long nhomId, boolean isActive) {

		return _danhMucService.getAll(nhomId, isActive);
	}

	@Override
	public org.oep.danhmuc.model.DanhMucSoap getByM(String ma) {
		return _danhMucService.getByM(ma);
	}

	@Override
	public org.oep.danhmuc.model.DanhMucSoap[] getByMUC(int muc) {
		return _danhMucService.getByMUC(muc);
	}

	@Override
	public org.oep.danhmuc.model.DanhMucSoap[] getByP(long chaId) {
		return _danhMucService.getByP(chaId);
	}

	@Override
	public org.oep.danhmuc.model.DanhMucSoap getByP_T(long chaId, String ten) {
		return _danhMucService.getByP_T(chaId, ten);
	}

	@Override
	public org.oep.danhmuc.model.DanhMucSoap getByT(String ten) {
		return _danhMucService.getByT(ten);
	}

	@Override
	public org.oep.danhmuc.model.DanhMucSoap getByTT(int thuTuHienThi)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _danhMucService.getByTT(thuTuHienThi);
	}

	@Override
	public org.oep.danhmuc.model.DanhMucSoap[] getDanhMuc_By_ChaId(
		long chaId, boolean isActive) {

		return _danhMucService.getDanhMuc_By_ChaId(chaId, isActive);
	}

	@Override
	public org.oep.danhmuc.model.DanhMucSoap getDanhMuc_By_Ma(
		String ma, boolean isActive) {

		return _danhMucService.getDanhMuc_By_Ma(ma, isActive);
	}

	@Override
	public org.oep.danhmuc.model.DanhMucSoap[] getDanhMuc_By_Ma_Muc(
		String ma, int muc) {

		return _danhMucService.getDanhMuc_By_Ma_Muc(ma, muc);
	}

	@Override
	public org.oep.danhmuc.model.DanhMucSoap[] getDanhMuc_By_Muc(
		long chaId, int level, boolean isActive) {

		return _danhMucService.getDanhMuc_By_Muc(chaId, level, isActive);
	}

	@Override
	public org.oep.danhmuc.model.DanhMucSoap[] getDanhMuc_By_Nhom_Muc(
		String maNhom, int level, boolean isActive) {

		return _danhMucService.getDanhMuc_By_Nhom_Muc(maNhom, level, isActive);
	}

	@Override
	public org.oep.danhmuc.model.DanhMucSoap getDanhMuc_By_Nhom_Muc_Ma(
		String maNhom, int level, String ma, boolean isActive) {

		return _danhMucService.getDanhMuc_By_Nhom_Muc_Ma(
			maNhom, level, ma, isActive);
	}

	@Override
	public org.oep.danhmuc.model.DanhMucSoap getDanhMuc_By_Nhom_Muc_Ten(
		String maNhom, int level, String ten, boolean isActive) {

		return _danhMucService.getDanhMuc_By_Nhom_Muc_Ten(
			maNhom, level, ten, isActive);
	}

	@Override
	public org.oep.danhmuc.model.DanhMucSoap getDanhMuc_Con_CuoiCung(
		long chaId, com.liferay.portal.kernel.util.OrderByComparator asc) {

		return _danhMucService.getDanhMuc_Con_CuoiCung(chaId, asc);
	}

	@Override
	public org.oep.danhmuc.model.DanhMucSoap getDanhMuc_Con_DauTien(
		long chaId, com.liferay.portal.kernel.util.OrderByComparator asc) {

		return _danhMucService.getDanhMuc_Con_DauTien(chaId, asc);
	}

	@Override
	public org.oep.danhmuc.model.DanhMucSoap getItemWithMaxDisplayIndex(
		long idCha) {

		return _danhMucService.getItemWithMaxDisplayIndex(idCha);
	}

	@Override
	public org.oep.danhmuc.model.DanhMucSoap getItemWithMaxDisplayIndexByMuc(
		int muc) {

		return _danhMucService.getItemWithMaxDisplayIndexByMuc(muc);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _danhMucService.getOSGiServiceIdentifier();
	}

	@Override
	public org.oep.danhmuc.model.DanhMucSoap[] searchItem(
		long idCha, String ten, String groupId, String muc, int start,
		int end) {

		return _danhMucService.searchItem(idCha, ten, groupId, muc, start, end);
	}

	@Override
	public org.oep.danhmuc.model.DanhMucSoap[] timKiem(
		long chaId, String ten, String groupId, String muc, int start,
		int end) {

		return _danhMucService.timKiem(chaId, ten, groupId, muc, start, end);
	}

	@Override
	public DanhMucService getWrappedService() {
		return _danhMucService;
	}

	@Override
	public void setWrappedService(DanhMucService danhMucService) {
		_danhMucService = danhMucService;
	}

	private DanhMucService _danhMucService;

}