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

package dtt.vn.user.service.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DoiTuongSuDungLocalService}.
 *
 * @author nhanvienDTT
 * @see DoiTuongSuDungLocalService
 * @generated
 */
@ProviderType
public class DoiTuongSuDungLocalServiceWrapper
	implements DoiTuongSuDungLocalService,
			   ServiceWrapper<DoiTuongSuDungLocalService> {

	public DoiTuongSuDungLocalServiceWrapper(
		DoiTuongSuDungLocalService doiTuongSuDungLocalService) {

		_doiTuongSuDungLocalService = doiTuongSuDungLocalService;
	}

	/**
	 * Adds the doi tuong su dung to the database. Also notifies the appropriate model listeners.
	 *
	 * @param doiTuongSuDung the doi tuong su dung
	 * @return the doi tuong su dung that was added
	 */
	@Override
	public dtt.vn.user.service.model.DoiTuongSuDung addDoiTuongSuDung(
		dtt.vn.user.service.model.DoiTuongSuDung doiTuongSuDung) {

		return _doiTuongSuDungLocalService.addDoiTuongSuDung(doiTuongSuDung);
	}

	/**
	 * Creates a new doi tuong su dung with the primary key. Does not add the doi tuong su dung to the database.
	 *
	 * @param id the primary key for the new doi tuong su dung
	 * @return the new doi tuong su dung
	 */
	@Override
	public dtt.vn.user.service.model.DoiTuongSuDung createDoiTuongSuDung(
		long id) {

		return _doiTuongSuDungLocalService.createDoiTuongSuDung(id);
	}

	/**
	 * Deletes the doi tuong su dung from the database. Also notifies the appropriate model listeners.
	 *
	 * @param doiTuongSuDung the doi tuong su dung
	 * @return the doi tuong su dung that was removed
	 */
	@Override
	public dtt.vn.user.service.model.DoiTuongSuDung deleteDoiTuongSuDung(
		dtt.vn.user.service.model.DoiTuongSuDung doiTuongSuDung) {

		return _doiTuongSuDungLocalService.deleteDoiTuongSuDung(doiTuongSuDung);
	}

	/**
	 * Deletes the doi tuong su dung with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the doi tuong su dung
	 * @return the doi tuong su dung that was removed
	 * @throws PortalException if a doi tuong su dung with the primary key could not be found
	 */
	@Override
	public dtt.vn.user.service.model.DoiTuongSuDung deleteDoiTuongSuDung(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _doiTuongSuDungLocalService.deleteDoiTuongSuDung(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _doiTuongSuDungLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _doiTuongSuDungLocalService.dynamicQuery();
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

		return _doiTuongSuDungLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>dtt.vn.user.service.model.impl.DoiTuongSuDungModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _doiTuongSuDungLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>dtt.vn.user.service.model.impl.DoiTuongSuDungModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _doiTuongSuDungLocalService.dynamicQuery(
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

		return _doiTuongSuDungLocalService.dynamicQueryCount(dynamicQuery);
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

		return _doiTuongSuDungLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public dtt.vn.user.service.model.DoiTuongSuDung fetchDoiTuongSuDung(
		long id) {

		return _doiTuongSuDungLocalService.fetchDoiTuongSuDung(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _doiTuongSuDungLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the doi tuong su dung with the primary key.
	 *
	 * @param id the primary key of the doi tuong su dung
	 * @return the doi tuong su dung
	 * @throws PortalException if a doi tuong su dung with the primary key could not be found
	 */
	@Override
	public dtt.vn.user.service.model.DoiTuongSuDung getDoiTuongSuDung(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _doiTuongSuDungLocalService.getDoiTuongSuDung(id);
	}

	@Override
	public dtt.vn.user.service.model.DoiTuongSuDung getDoiTuongSuDungByMa(
			String ma)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _doiTuongSuDungLocalService.getDoiTuongSuDungByMa(ma);
	}

	/**
	 * Returns a range of all the doi tuong su dungs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>dtt.vn.user.service.model.impl.DoiTuongSuDungModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of doi tuong su dungs
	 * @param end the upper bound of the range of doi tuong su dungs (not inclusive)
	 * @return the range of doi tuong su dungs
	 */
	@Override
	public java.util.List<dtt.vn.user.service.model.DoiTuongSuDung>
		getDoiTuongSuDungs(int start, int end) {

		return _doiTuongSuDungLocalService.getDoiTuongSuDungs(start, end);
	}

	/**
	 * Returns the number of doi tuong su dungs.
	 *
	 * @return the number of doi tuong su dungs
	 */
	@Override
	public int getDoiTuongSuDungsCount() {
		return _doiTuongSuDungLocalService.getDoiTuongSuDungsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _doiTuongSuDungLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _doiTuongSuDungLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _doiTuongSuDungLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the doi tuong su dung in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param doiTuongSuDung the doi tuong su dung
	 * @return the doi tuong su dung that was updated
	 */
	@Override
	public dtt.vn.user.service.model.DoiTuongSuDung updateDoiTuongSuDung(
		dtt.vn.user.service.model.DoiTuongSuDung doiTuongSuDung) {

		return _doiTuongSuDungLocalService.updateDoiTuongSuDung(doiTuongSuDung);
	}

	@Override
	public DoiTuongSuDungLocalService getWrappedService() {
		return _doiTuongSuDungLocalService;
	}

	@Override
	public void setWrappedService(
		DoiTuongSuDungLocalService doiTuongSuDungLocalService) {

		_doiTuongSuDungLocalService = doiTuongSuDungLocalService;
	}

	private DoiTuongSuDungLocalService _doiTuongSuDungLocalService;

}