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
 * Provides a wrapper for {@link PhanQuyenLocalService}.
 *
 * @author manhlb
 * @see PhanQuyenLocalService
 * @generated
 */
@ProviderType
public class PhanQuyenLocalServiceWrapper
	implements PhanQuyenLocalService, ServiceWrapper<PhanQuyenLocalService> {

	public PhanQuyenLocalServiceWrapper(
		PhanQuyenLocalService phanQuyenLocalService) {

		_phanQuyenLocalService = phanQuyenLocalService;
	}

	/**
	 * Adds the phan quyen to the database. Also notifies the appropriate model listeners.
	 *
	 * @param phanQuyen the phan quyen
	 * @return the phan quyen that was added
	 */
	@Override
	public org.oep.core.model.PhanQuyen addPhanQuyen(
		org.oep.core.model.PhanQuyen phanQuyen) {

		return _phanQuyenLocalService.addPhanQuyen(phanQuyen);
	}

	@Override
	public org.oep.core.model.PhanQuyen capQuyen(
		String classname, long classpk, String giatri) {

		return _phanQuyenLocalService.capQuyen(classname, classpk, giatri);
	}

	/**
	 * Creates a new phan quyen with the primary key. Does not add the phan quyen to the database.
	 *
	 * @param id the primary key for the new phan quyen
	 * @return the new phan quyen
	 */
	@Override
	public org.oep.core.model.PhanQuyen createPhanQuyen(long id) {
		return _phanQuyenLocalService.createPhanQuyen(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _phanQuyenLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the phan quyen with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the phan quyen
	 * @return the phan quyen that was removed
	 * @throws PortalException if a phan quyen with the primary key could not be found
	 */
	@Override
	public org.oep.core.model.PhanQuyen deletePhanQuyen(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _phanQuyenLocalService.deletePhanQuyen(id);
	}

	/**
	 * Deletes the phan quyen from the database. Also notifies the appropriate model listeners.
	 *
	 * @param phanQuyen the phan quyen
	 * @return the phan quyen that was removed
	 */
	@Override
	public org.oep.core.model.PhanQuyen deletePhanQuyen(
		org.oep.core.model.PhanQuyen phanQuyen) {

		return _phanQuyenLocalService.deletePhanQuyen(phanQuyen);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _phanQuyenLocalService.dynamicQuery();
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

		return _phanQuyenLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>org.oep.core.model.impl.PhanQuyenModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _phanQuyenLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>org.oep.core.model.impl.PhanQuyenModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _phanQuyenLocalService.dynamicQuery(
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

		return _phanQuyenLocalService.dynamicQueryCount(dynamicQuery);
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

		return _phanQuyenLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public org.oep.core.model.PhanQuyen fetchPhanQuyen(long id) {
		return _phanQuyenLocalService.fetchPhanQuyen(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _phanQuyenLocalService.getActionableDynamicQuery();
	}

	@Override
	public String getGiaTri(String classname, long classpk) {
		return _phanQuyenLocalService.getGiaTri(classname, classpk);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _phanQuyenLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _phanQuyenLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _phanQuyenLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the phan quyen with the primary key.
	 *
	 * @param id the primary key of the phan quyen
	 * @return the phan quyen
	 * @throws PortalException if a phan quyen with the primary key could not be found
	 */
	@Override
	public org.oep.core.model.PhanQuyen getPhanQuyen(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _phanQuyenLocalService.getPhanQuyen(id);
	}

	/**
	 * Returns a range of all the phan quyens.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>org.oep.core.model.impl.PhanQuyenModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of phan quyens
	 * @param end the upper bound of the range of phan quyens (not inclusive)
	 * @return the range of phan quyens
	 */
	@Override
	public java.util.List<org.oep.core.model.PhanQuyen> getPhanQuyens(
		int start, int end) {

		return _phanQuyenLocalService.getPhanQuyens(start, end);
	}

	/**
	 * Returns the number of phan quyens.
	 *
	 * @return the number of phan quyens
	 */
	@Override
	public int getPhanQuyensCount() {
		return _phanQuyenLocalService.getPhanQuyensCount();
	}

	@Override
	public boolean huyCapQuyen(long phanQuyenId) {
		return _phanQuyenLocalService.huyCapQuyen(phanQuyenId);
	}

	@Override
	public boolean huyCapQuyen(String classname, long classpk) {
		return _phanQuyenLocalService.huyCapQuyen(classname, classpk);
	}

	/**
	 * Updates the phan quyen in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param phanQuyen the phan quyen
	 * @return the phan quyen that was updated
	 */
	@Override
	public org.oep.core.model.PhanQuyen updatePhanQuyen(
		org.oep.core.model.PhanQuyen phanQuyen) {

		return _phanQuyenLocalService.updatePhanQuyen(phanQuyen);
	}

	@Override
	public PhanQuyenLocalService getWrappedService() {
		return _phanQuyenLocalService;
	}

	@Override
	public void setWrappedService(PhanQuyenLocalService phanQuyenLocalService) {
		_phanQuyenLocalService = phanQuyenLocalService;
	}

	private PhanQuyenLocalService _phanQuyenLocalService;

}