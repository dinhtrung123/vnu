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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.oep.danhmuc.model.DanhMucSoap;

/**
 * Provides the remote service interface for DanhMuc. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author nhanvienDTT
 * @see DanhMucServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@OSGiBeanProperties(
	property = {
		"json.web.service.context.name=danhmuc",
		"json.web.service.context.path=DanhMuc"
	},
	service = DanhMucService.class
)
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface DanhMucService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DanhMucServiceUtil} to access the danh muc remote service. Add custom service methods to <code>org.oep.danhmuc.service.impl.DanhMucServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public int countByTimKiem(
		long chaId, String ten, String groupId, String muc);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DanhMucSoap[] getAll(long nhomId, boolean isActive);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DanhMucSoap getByM(String ma);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DanhMucSoap[] getByMUC(int muc);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DanhMucSoap[] getByP(long chaId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DanhMucSoap getByP_T(long chaId, String ten);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DanhMucSoap getByT(String ten);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DanhMucSoap getByTT(int thuTuHienThi) throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DanhMucSoap[] getDanhMuc_By_ChaId(long chaId, boolean isActive);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DanhMucSoap getDanhMuc_By_Ma(String ma, boolean isActive);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DanhMucSoap[] getDanhMuc_By_Ma_Muc(String ma, int muc);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DanhMucSoap[] getDanhMuc_By_Muc(
		long chaId, int level, boolean isActive);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DanhMucSoap[] getDanhMuc_By_Nhom_Muc(
		String maNhom, int level, boolean isActive);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DanhMucSoap getDanhMuc_By_Nhom_Muc_Ma(
		String maNhom, int level, String ma, boolean isActive);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DanhMucSoap getDanhMuc_By_Nhom_Muc_Ten(
		String maNhom, int level, String ten, boolean isActive);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DanhMucSoap getDanhMuc_Con_CuoiCung(
		long chaId, OrderByComparator asc);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DanhMucSoap getDanhMuc_Con_DauTien(
		long chaId, OrderByComparator asc);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DanhMucSoap getItemWithMaxDisplayIndex(long idCha);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DanhMucSoap getItemWithMaxDisplayIndexByMuc(int muc);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DanhMucSoap[] searchItem(
		long idCha, String ten, String groupId, String muc, int start, int end);

	public DanhMucSoap[] timKiem(
		long chaId, String ten, String groupId, String muc, int start, int end);

}