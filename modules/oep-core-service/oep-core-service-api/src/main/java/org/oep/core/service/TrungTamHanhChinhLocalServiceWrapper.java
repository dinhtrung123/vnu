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

package org.oep.core.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TrungTamHanhChinhLocalService}.
 *
 * @author manhlb
 * @see TrungTamHanhChinhLocalService
 * @generated
 */
@ProviderType
public class TrungTamHanhChinhLocalServiceWrapper
	implements TrungTamHanhChinhLocalService,
			   ServiceWrapper<TrungTamHanhChinhLocalService> {

	public TrungTamHanhChinhLocalServiceWrapper(
		TrungTamHanhChinhLocalService trungTamHanhChinhLocalService) {

		_trungTamHanhChinhLocalService = trungTamHanhChinhLocalService;
	}

	@Override
	public void addOrUpdate(
			long id, long coQuanQuanLyId, String ten, String ma,
			String donVi_Ids, int trangThai, String thongTinLienHe)
		throws com.liferay.portal.kernel.exception.SystemException {

		_trungTamHanhChinhLocalService.addOrUpdate(
			id, coQuanQuanLyId, ten, ma, donVi_Ids, trangThai, thongTinLienHe);
	}

	/**
	 * Adds the trung tam hanh chinh to the database. Also notifies the appropriate model listeners.
	 *
	 * @param trungTamHanhChinh the trung tam hanh chinh
	 * @return the trung tam hanh chinh that was added
	 */
	@Override
	public org.oep.core.model.TrungTamHanhChinh addTrungTamHanhChinh(
		org.oep.core.model.TrungTamHanhChinh trungTamHanhChinh) {

		return _trungTamHanhChinhLocalService.addTrungTamHanhChinh(
			trungTamHanhChinh);
	}

	@Override
	public int countTTHC(String ten_ma, long coQuanQuanLyId, int trangThai) {
		return _trungTamHanhChinhLocalService.countTTHC(
			ten_ma, coQuanQuanLyId, trangThai);
	}

	/**
	 * Creates a new trung tam hanh chinh with the primary key. Does not add the trung tam hanh chinh to the database.
	 *
	 * @param id the primary key for the new trung tam hanh chinh
	 * @return the new trung tam hanh chinh
	 */
	@Override
	public org.oep.core.model.TrungTamHanhChinh createTrungTamHanhChinh(
		long id) {

		return _trungTamHanhChinhLocalService.createTrungTamHanhChinh(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _trungTamHanhChinhLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the trung tam hanh chinh with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the trung tam hanh chinh
	 * @return the trung tam hanh chinh that was removed
	 * @throws PortalException if a trung tam hanh chinh with the primary key could not be found
	 */
	@Override
	public org.oep.core.model.TrungTamHanhChinh deleteTrungTamHanhChinh(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _trungTamHanhChinhLocalService.deleteTrungTamHanhChinh(id);
	}

	/**
	 * Deletes the trung tam hanh chinh from the database. Also notifies the appropriate model listeners.
	 *
	 * @param trungTamHanhChinh the trung tam hanh chinh
	 * @return the trung tam hanh chinh that was removed
	 */
	@Override
	public org.oep.core.model.TrungTamHanhChinh deleteTrungTamHanhChinh(
		org.oep.core.model.TrungTamHanhChinh trungTamHanhChinh) {

		return _trungTamHanhChinhLocalService.deleteTrungTamHanhChinh(
			trungTamHanhChinh);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _trungTamHanhChinhLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _trungTamHanhChinhLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>org.oep.core.model.impl.TrungTamHanhChinhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _trungTamHanhChinhLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>org.oep.core.model.impl.TrungTamHanhChinhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _trungTamHanhChinhLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _trungTamHanhChinhLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _trungTamHanhChinhLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public org.oep.core.model.TrungTamHanhChinh fetchTrungTamHanhChinh(
		long id) {

		return _trungTamHanhChinhLocalService.fetchTrungTamHanhChinh(id);
	}

	@Override
	public org.oep.core.model.TrungTamHanhChinh findByDonViXuLyId(
		long donvixulyId) {

		return _trungTamHanhChinhLocalService.findByDonViXuLyId(donvixulyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _trungTamHanhChinhLocalService.getActionableDynamicQuery();
	}

	@Override
	public org.oep.core.model.TrungTamHanhChinh getByCoQuanQuanLyId(
		long coQuanQuanLyId) {

		return _trungTamHanhChinhLocalService.getByCoQuanQuanLyId(
			coQuanQuanLyId);
	}

	@Override
	public org.oep.core.model.TrungTamHanhChinh getByMa(String ma)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _trungTamHanhChinhLocalService.getByMa(ma);
	}

	@Override
	public long[] getDonViXuLyIds(long trungTamHanhChinhId) {
		return _trungTamHanhChinhLocalService.getDonViXuLyIds(
			trungTamHanhChinhId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _trungTamHanhChinhLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _trungTamHanhChinhLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _trungTamHanhChinhLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the trung tam hanh chinh with the primary key.
	 *
	 * @param id the primary key of the trung tam hanh chinh
	 * @return the trung tam hanh chinh
	 * @throws PortalException if a trung tam hanh chinh with the primary key could not be found
	 */
	@Override
	public org.oep.core.model.TrungTamHanhChinh getTrungTamHanhChinh(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _trungTamHanhChinhLocalService.getTrungTamHanhChinh(id);
	}

	/**
	 * Returns a range of all the trung tam hanh chinhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>org.oep.core.model.impl.TrungTamHanhChinhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of trung tam hanh chinhs
	 * @param end the upper bound of the range of trung tam hanh chinhs (not inclusive)
	 * @return the range of trung tam hanh chinhs
	 */
	@Override
	public java.util.List<org.oep.core.model.TrungTamHanhChinh>
		getTrungTamHanhChinhs(int start, int end) {

		return _trungTamHanhChinhLocalService.getTrungTamHanhChinhs(start, end);
	}

	/**
	 * Returns the number of trung tam hanh chinhs.
	 *
	 * @return the number of trung tam hanh chinhs
	 */
	@Override
	public int getTrungTamHanhChinhsCount() {
		return _trungTamHanhChinhLocalService.getTrungTamHanhChinhsCount();
	}

	@Override
	public java.util.List<org.oep.core.model.TrungTamHanhChinh>
		searchByTen_Ma_CQQL(
			String ten_ma, long coQuanQuanLyId, int trangThai, int start,
			int end) {

		return _trungTamHanhChinhLocalService.searchByTen_Ma_CQQL(
			ten_ma, coQuanQuanLyId, trangThai, start, end);
	}

	/**
	 * Updates the trung tam hanh chinh in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param trungTamHanhChinh the trung tam hanh chinh
	 * @return the trung tam hanh chinh that was updated
	 */
	@Override
	public org.oep.core.model.TrungTamHanhChinh updateTrungTamHanhChinh(
		org.oep.core.model.TrungTamHanhChinh trungTamHanhChinh) {

		return _trungTamHanhChinhLocalService.updateTrungTamHanhChinh(
			trungTamHanhChinh);
	}

	@Override
	public TrungTamHanhChinhLocalService getWrappedService() {
		return _trungTamHanhChinhLocalService;
	}

	@Override
	public void setWrappedService(
		TrungTamHanhChinhLocalService trungTamHanhChinhLocalService) {

		_trungTamHanhChinhLocalService = trungTamHanhChinhLocalService;
	}

	private TrungTamHanhChinhLocalService _trungTamHanhChinhLocalService;

}