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

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

import org.oep.danhmuc.exception.NoSuchDanhMucException;
import org.oep.danhmuc.model.DanhMuc;

/**
 * Provides the local service interface for DanhMuc. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author nhanvienDTT
 * @see DanhMucLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface DanhMucLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DanhMucLocalServiceUtil} to access the danh muc local service. Add custom service methods to <code>org.oep.danhmuc.service.impl.DanhMucLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	 * Adds the danh muc to the database. Also notifies the appropriate model listeners.
	 *
	 * @param danhMuc the danh muc
	 * @return the danh muc that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public DanhMuc addDanhMuc(DanhMuc danhMuc);

	public int countByTimKiem(
		long chaId, String ten, String groupId, String muc);

	/**
	 * Creates a new danh muc with the primary key. Does not add the danh muc to the database.
	 *
	 * @param id the primary key for the new danh muc
	 * @return the new danh muc
	 */
	@Transactional(enabled = false)
	public DanhMuc createDanhMuc(long id);

	/**
	 * Deletes the danh muc from the database. Also notifies the appropriate model listeners.
	 *
	 * @param danhMuc the danh muc
	 * @return the danh muc that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public DanhMuc deleteDanhMuc(DanhMuc danhMuc);

	/**
	 * Deletes the danh muc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the danh muc
	 * @return the danh muc that was removed
	 * @throws PortalException if a danh muc with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public DanhMuc deleteDanhMuc(long id) throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>org.oep.danhmuc.model.impl.DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>org.oep.danhmuc.model.impl.DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DanhMuc fetchDanhMuc(long id);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * This is fucntion get All DanhMuc
	 *
	 * @param nhomId
	 :
	 * @param isActive
	 : if true : get Item have got status=1,if false : get All
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DanhMuc> getAll(long nhomId, boolean isActive);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DanhMuc> getAllByIds(long[] ids) throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DanhMuc> getAllByNhomId(long nhomId) throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DanhMuc> getAllByNhomIdMuc(long nhomId, int muc)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DanhMuc> getByIds(long[] ids) throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DanhMuc getByM(String ma) throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DanhMuc> getByMUC(int muc) throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DanhMuc> getByP(long chaId) throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DanhMuc getByP_T(long chaId, String ten) throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DanhMuc getByT(String ten) throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DanhMuc getByTT(int thuTuHienThi) throws SystemException;

	/**
	 * Returns the danh muc with the primary key.
	 *
	 * @param id the primary key of the danh muc
	 * @return the danh muc
	 * @throws PortalException if a danh muc with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DanhMuc getDanhMuc(long id) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DanhMuc> getDanhMuc_By_ChaId(long chaId, boolean isActive)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DanhMuc getDanhMuc_By_Ma(String ma, boolean isActive);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DanhMuc> getDanhMuc_By_Ma_Muc(String ma, int muc)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DanhMuc> getDanhMuc_By_Muc(
		long chaId, int level, boolean isActive);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DanhMuc> getDanhMuc_By_Nhom_Muc(
			String maNhom, int level, boolean isActive)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DanhMuc getDanhMuc_By_Nhom_Muc_Ma(
			String maNhom, int level, String ma, boolean isActive)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DanhMuc getDanhMuc_By_Nhom_Muc_Ten(
			String maNhom, int level, String ten, boolean isActive)
		throws NoSuchDanhMucException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DanhMuc getDanhMuc_Con_CuoiCung(long chaId, OrderByComparator asc)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DanhMuc getDanhMuc_Con_DauTien(long chaId, OrderByComparator asc)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DanhMuc getDanhMucByNhomIdMa(long nhomId, String ma)
		throws SystemException;

	/**
	 * Returns a range of all the danh mucs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>org.oep.danhmuc.model.impl.DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @return the range of danh mucs
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DanhMuc> getDanhMucs(int start, int end);

	/**
	 * Returns the number of danh mucs.
	 *
	 * @return the number of danh mucs
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getDanhMucsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DanhMuc getItemWithMaxDisplayIndex(long idCha)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DanhMuc getItemWithMaxDisplayIndexByMuc(int muc)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DanhMuc getNextItem(long chaId, DanhMuc item) throws SystemException;

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DanhMuc> searchItem(
		long idCha, String ten, String groupId, String muc, int start, int end);

	public DanhMuc suaDanhMuc(
			long danhMucId, long nhomId, String ma, String name, String moTa,
			boolean trangThai, int thuTuHienThi)
		throws PortalException, SystemException;

	public DanhMuc themMoiDanhMuc(
			long nhomId, long chaId, String ma, String maGiaPha, String ten,
			String moTa, boolean trangThai, int muc, int thuTuHienThi)
		throws PortalException, SystemException;

	public List<DanhMuc> timKiem(
		long chaId, String ten, String groupId, String muc, int start, int end);

	/**
	 * Updates the danh muc in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param danhMuc the danh muc
	 * @return the danh muc that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public DanhMuc updateDanhMuc(DanhMuc danhMuc);

	public DanhMuc xoaDanhMuc(long danhMucId);

}