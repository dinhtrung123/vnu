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
 * Provides a wrapper for {@link ThamSoLoaiLocalService}.
 *
 * @author manhlb
 * @see ThamSoLoaiLocalService
 * @generated
 */
@ProviderType
public class ThamSoLoaiLocalServiceWrapper
	implements ThamSoLoaiLocalService, ServiceWrapper<ThamSoLoaiLocalService> {

	public ThamSoLoaiLocalServiceWrapper(
		ThamSoLoaiLocalService thamSoLoaiLocalService) {

		_thamSoLoaiLocalService = thamSoLoaiLocalService;
	}

	/**
	 * Adds the tham so loai to the database. Also notifies the appropriate model listeners.
	 *
	 * @param thamSoLoai the tham so loai
	 * @return the tham so loai that was added
	 */
	@Override
	public org.oep.core.model.ThamSoLoai addThamSoLoai(
		org.oep.core.model.ThamSoLoai thamSoLoai) {

		return _thamSoLoaiLocalService.addThamSoLoai(thamSoLoai);
	}

	/**
	 * Creates a new tham so loai with the primary key. Does not add the tham so loai to the database.
	 *
	 * @param id the primary key for the new tham so loai
	 * @return the new tham so loai
	 */
	@Override
	public org.oep.core.model.ThamSoLoai createThamSoLoai(long id) {
		return _thamSoLoaiLocalService.createThamSoLoai(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _thamSoLoaiLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the tham so loai with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the tham so loai
	 * @return the tham so loai that was removed
	 * @throws PortalException if a tham so loai with the primary key could not be found
	 */
	@Override
	public org.oep.core.model.ThamSoLoai deleteThamSoLoai(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _thamSoLoaiLocalService.deleteThamSoLoai(id);
	}

	/**
	 * Deletes the tham so loai from the database. Also notifies the appropriate model listeners.
	 *
	 * @param thamSoLoai the tham so loai
	 * @return the tham so loai that was removed
	 */
	@Override
	public org.oep.core.model.ThamSoLoai deleteThamSoLoai(
		org.oep.core.model.ThamSoLoai thamSoLoai) {

		return _thamSoLoaiLocalService.deleteThamSoLoai(thamSoLoai);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _thamSoLoaiLocalService.dynamicQuery();
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

		return _thamSoLoaiLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>org.oep.core.model.impl.ThamSoLoaiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _thamSoLoaiLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>org.oep.core.model.impl.ThamSoLoaiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _thamSoLoaiLocalService.dynamicQuery(
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

		return _thamSoLoaiLocalService.dynamicQueryCount(dynamicQuery);
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

		return _thamSoLoaiLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public org.oep.core.model.ThamSoLoai fetchThamSoLoai(long id) {
		return _thamSoLoaiLocalService.fetchThamSoLoai(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _thamSoLoaiLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<org.oep.core.model.ThamSoLoai> getAll()
		throws com.liferay.portal.kernel.exception.SystemException {

		return _thamSoLoaiLocalService.getAll();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _thamSoLoaiLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _thamSoLoaiLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _thamSoLoaiLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the tham so loai with the primary key.
	 *
	 * @param id the primary key of the tham so loai
	 * @return the tham so loai
	 * @throws PortalException if a tham so loai with the primary key could not be found
	 */
	@Override
	public org.oep.core.model.ThamSoLoai getThamSoLoai(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _thamSoLoaiLocalService.getThamSoLoai(id);
	}

	/**
	 * Returns a range of all the tham so loais.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>org.oep.core.model.impl.ThamSoLoaiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tham so loais
	 * @param end the upper bound of the range of tham so loais (not inclusive)
	 * @return the range of tham so loais
	 */
	@Override
	public java.util.List<org.oep.core.model.ThamSoLoai> getThamSoLoais(
		int start, int end) {

		return _thamSoLoaiLocalService.getThamSoLoais(start, end);
	}

	/**
	 * Returns the number of tham so loais.
	 *
	 * @return the number of tham so loais
	 */
	@Override
	public int getThamSoLoaisCount() {
		return _thamSoLoaiLocalService.getThamSoLoaisCount();
	}

	/**
	 * Updates the tham so loai in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param thamSoLoai the tham so loai
	 * @return the tham so loai that was updated
	 */
	@Override
	public org.oep.core.model.ThamSoLoai updateThamSoLoai(
		org.oep.core.model.ThamSoLoai thamSoLoai) {

		return _thamSoLoaiLocalService.updateThamSoLoai(thamSoLoai);
	}

	@Override
	public ThamSoLoaiLocalService getWrappedService() {
		return _thamSoLoaiLocalService;
	}

	@Override
	public void setWrappedService(
		ThamSoLoaiLocalService thamSoLoaiLocalService) {

		_thamSoLoaiLocalService = thamSoLoaiLocalService;
	}

	private ThamSoLoaiLocalService _thamSoLoaiLocalService;

}