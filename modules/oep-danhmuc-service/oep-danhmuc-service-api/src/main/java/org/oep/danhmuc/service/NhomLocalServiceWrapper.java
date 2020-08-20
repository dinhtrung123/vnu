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
 * Provides a wrapper for {@link NhomLocalService}.
 *
 * @author nhanvienDTT
 * @see NhomLocalService
 * @generated
 */
@ProviderType
public class NhomLocalServiceWrapper
	implements NhomLocalService, ServiceWrapper<NhomLocalService> {

	public NhomLocalServiceWrapper(NhomLocalService nhomLocalService) {
		_nhomLocalService = nhomLocalService;
	}

	/**
	 * Adds the nhom to the database. Also notifies the appropriate model listeners.
	 *
	 * @param nhom the nhom
	 * @return the nhom that was added
	 */
	@Override
	public org.oep.danhmuc.model.Nhom addNhom(org.oep.danhmuc.model.Nhom nhom) {
		return _nhomLocalService.addNhom(nhom);
	}

	/**
	 * Creates a new nhom with the primary key. Does not add the nhom to the database.
	 *
	 * @param id the primary key for the new nhom
	 * @return the new nhom
	 */
	@Override
	public org.oep.danhmuc.model.Nhom createNhom(long id) {
		return _nhomLocalService.createNhom(id);
	}

	/**
	 * Deletes the nhom with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the nhom
	 * @return the nhom that was removed
	 * @throws PortalException if a nhom with the primary key could not be found
	 */
	@Override
	public org.oep.danhmuc.model.Nhom deleteNhom(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _nhomLocalService.deleteNhom(id);
	}

	/**
	 * Deletes the nhom from the database. Also notifies the appropriate model listeners.
	 *
	 * @param nhom the nhom
	 * @return the nhom that was removed
	 */
	@Override
	public org.oep.danhmuc.model.Nhom deleteNhom(
		org.oep.danhmuc.model.Nhom nhom) {

		return _nhomLocalService.deleteNhom(nhom);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _nhomLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _nhomLocalService.dynamicQuery();
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

		return _nhomLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>org.oep.danhmuc.model.impl.NhomModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _nhomLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>org.oep.danhmuc.model.impl.NhomModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _nhomLocalService.dynamicQuery(
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

		return _nhomLocalService.dynamicQueryCount(dynamicQuery);
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

		return _nhomLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public org.oep.danhmuc.model.Nhom fetchNhom(long id) {
		return _nhomLocalService.fetchNhom(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _nhomLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _nhomLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the nhom with the primary key.
	 *
	 * @param id the primary key of the nhom
	 * @return the nhom
	 * @throws PortalException if a nhom with the primary key could not be found
	 */
	@Override
	public org.oep.danhmuc.model.Nhom getNhom(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _nhomLocalService.getNhom(id);
	}

	@Override
	public org.oep.danhmuc.model.Nhom getNhomByMa(String maNhom)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _nhomLocalService.getNhomByMa(maNhom);
	}

	/**
	 * Returns a range of all the nhoms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>org.oep.danhmuc.model.impl.NhomModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of nhoms
	 * @param end the upper bound of the range of nhoms (not inclusive)
	 * @return the range of nhoms
	 */
	@Override
	public java.util.List<org.oep.danhmuc.model.Nhom> getNhoms(
		int start, int end) {

		return _nhomLocalService.getNhoms(start, end);
	}

	/**
	 * Returns the number of nhoms.
	 *
	 * @return the number of nhoms
	 */
	@Override
	public int getNhomsCount() {
		return _nhomLocalService.getNhomsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _nhomLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _nhomLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the nhom in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param nhom the nhom
	 * @return the nhom that was updated
	 */
	@Override
	public org.oep.danhmuc.model.Nhom updateNhom(
		org.oep.danhmuc.model.Nhom nhom) {

		return _nhomLocalService.updateNhom(nhom);
	}

	@Override
	public NhomLocalService getWrappedService() {
		return _nhomLocalService;
	}

	@Override
	public void setWrappedService(NhomLocalService nhomLocalService) {
		_nhomLocalService = nhomLocalService;
	}

	private NhomLocalService _nhomLocalService;

}