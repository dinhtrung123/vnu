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
 * Provides a wrapper for {@link ThongTinCanBoLocalService}.
 *
 * @author nhanvienDTT
 * @see ThongTinCanBoLocalService
 * @generated
 */
@ProviderType
public class ThongTinCanBoLocalServiceWrapper
	implements ThongTinCanBoLocalService,
			   ServiceWrapper<ThongTinCanBoLocalService> {

	public ThongTinCanBoLocalServiceWrapper(
		ThongTinCanBoLocalService thongTinCanBoLocalService) {

		_thongTinCanBoLocalService = thongTinCanBoLocalService;
	}

	@Override
	public dtt.vn.user.service.model.ThongTinCanBo addThongTinCanBo(
		String emailAddress, String userName, String nameRole, String noiDung) {

		return _thongTinCanBoLocalService.addThongTinCanBo(
			emailAddress, userName, nameRole, noiDung);
	}

	/**
	 * Adds the thong tin can bo to the database. Also notifies the appropriate model listeners.
	 *
	 * @param thongTinCanBo the thong tin can bo
	 * @return the thong tin can bo that was added
	 */
	@Override
	public dtt.vn.user.service.model.ThongTinCanBo addThongTinCanBo(
		dtt.vn.user.service.model.ThongTinCanBo thongTinCanBo) {

		return _thongTinCanBoLocalService.addThongTinCanBo(thongTinCanBo);
	}

	/**
	 * Creates a new thong tin can bo with the primary key. Does not add the thong tin can bo to the database.
	 *
	 * @param id the primary key for the new thong tin can bo
	 * @return the new thong tin can bo
	 */
	@Override
	public dtt.vn.user.service.model.ThongTinCanBo createThongTinCanBo(
		long id) {

		return _thongTinCanBoLocalService.createThongTinCanBo(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _thongTinCanBoLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the thong tin can bo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the thong tin can bo
	 * @return the thong tin can bo that was removed
	 * @throws PortalException if a thong tin can bo with the primary key could not be found
	 */
	@Override
	public dtt.vn.user.service.model.ThongTinCanBo deleteThongTinCanBo(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _thongTinCanBoLocalService.deleteThongTinCanBo(id);
	}

	/**
	 * Deletes the thong tin can bo from the database. Also notifies the appropriate model listeners.
	 *
	 * @param thongTinCanBo the thong tin can bo
	 * @return the thong tin can bo that was removed
	 */
	@Override
	public dtt.vn.user.service.model.ThongTinCanBo deleteThongTinCanBo(
		dtt.vn.user.service.model.ThongTinCanBo thongTinCanBo) {

		return _thongTinCanBoLocalService.deleteThongTinCanBo(thongTinCanBo);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _thongTinCanBoLocalService.dynamicQuery();
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

		return _thongTinCanBoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>dtt.vn.user.service.model.impl.ThongTinCanBoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _thongTinCanBoLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>dtt.vn.user.service.model.impl.ThongTinCanBoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _thongTinCanBoLocalService.dynamicQuery(
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

		return _thongTinCanBoLocalService.dynamicQueryCount(dynamicQuery);
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

		return _thongTinCanBoLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public dtt.vn.user.service.model.ThongTinCanBo fetchThongTinCanBo(long id) {
		return _thongTinCanBoLocalService.fetchThongTinCanBo(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _thongTinCanBoLocalService.getActionableDynamicQuery();
	}

	@Override
	public dtt.vn.user.service.model.ThongTinCanBo getByEmail(
		String emailAddress) {

		return _thongTinCanBoLocalService.getByEmail(emailAddress);
	}

	@Override
	public java.util.List<dtt.vn.user.service.model.ThongTinCanBo>
		getByRoleName(String nameRole) {

		return _thongTinCanBoLocalService.getByRoleName(nameRole);
	}

	@Override
	public dtt.vn.user.service.model.ThongTinCanBo getByUserName(
		String userName) {

		return _thongTinCanBoLocalService.getByUserName(userName);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _thongTinCanBoLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _thongTinCanBoLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _thongTinCanBoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the thong tin can bo with the primary key.
	 *
	 * @param id the primary key of the thong tin can bo
	 * @return the thong tin can bo
	 * @throws PortalException if a thong tin can bo with the primary key could not be found
	 */
	@Override
	public dtt.vn.user.service.model.ThongTinCanBo getThongTinCanBo(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _thongTinCanBoLocalService.getThongTinCanBo(id);
	}

	/**
	 * Returns a range of all the thong tin can bos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>dtt.vn.user.service.model.impl.ThongTinCanBoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of thong tin can bos
	 * @param end the upper bound of the range of thong tin can bos (not inclusive)
	 * @return the range of thong tin can bos
	 */
	@Override
	public java.util.List<dtt.vn.user.service.model.ThongTinCanBo>
		getThongTinCanBos(int start, int end) {

		return _thongTinCanBoLocalService.getThongTinCanBos(start, end);
	}

	/**
	 * Returns the number of thong tin can bos.
	 *
	 * @return the number of thong tin can bos
	 */
	@Override
	public int getThongTinCanBosCount() {
		return _thongTinCanBoLocalService.getThongTinCanBosCount();
	}

	/**
	 * Updates the thong tin can bo in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param thongTinCanBo the thong tin can bo
	 * @return the thong tin can bo that was updated
	 */
	@Override
	public dtt.vn.user.service.model.ThongTinCanBo updateThongTinCanBo(
		dtt.vn.user.service.model.ThongTinCanBo thongTinCanBo) {

		return _thongTinCanBoLocalService.updateThongTinCanBo(thongTinCanBo);
	}

	@Override
	public ThongTinCanBoLocalService getWrappedService() {
		return _thongTinCanBoLocalService;
	}

	@Override
	public void setWrappedService(
		ThongTinCanBoLocalService thongTinCanBoLocalService) {

		_thongTinCanBoLocalService = thongTinCanBoLocalService;
	}

	private ThongTinCanBoLocalService _thongTinCanBoLocalService;

}