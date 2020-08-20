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
 * Provides a wrapper for {@link ThongTinDangKyLocalService}.
 *
 * @author nhanvienDTT
 * @see ThongTinDangKyLocalService
 * @generated
 */
@ProviderType
public class ThongTinDangKyLocalServiceWrapper
	implements ThongTinDangKyLocalService,
			   ServiceWrapper<ThongTinDangKyLocalService> {

	public ThongTinDangKyLocalServiceWrapper(
		ThongTinDangKyLocalService thongTinDangKyLocalService) {

		_thongTinDangKyLocalService = thongTinDangKyLocalService;
	}

	@Override
	public dtt.vn.user.service.model.ThongTinDangKy addThongTinDangKy(
			String emailAddress, String userName, String soGiayTo,
			String maKichHoat, int doiTuongSuDungId, String noiDung,
			String activeType, java.util.Date ngayTao)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _thongTinDangKyLocalService.addThongTinDangKy(
			emailAddress, userName, soGiayTo, maKichHoat, doiTuongSuDungId,
			noiDung, activeType, ngayTao);
	}

	/**
	 * Adds the thong tin dang ky to the database. Also notifies the appropriate model listeners.
	 *
	 * @param thongTinDangKy the thong tin dang ky
	 * @return the thong tin dang ky that was added
	 */
	@Override
	public dtt.vn.user.service.model.ThongTinDangKy addThongTinDangKy(
		dtt.vn.user.service.model.ThongTinDangKy thongTinDangKy) {

		return _thongTinDangKyLocalService.addThongTinDangKy(thongTinDangKy);
	}

	@Override
	public int countByEmailOrUsername(
		String keyword, String tungay, String denngay) {

		return _thongTinDangKyLocalService.countByEmailOrUsername(
			keyword, tungay, denngay);
	}

	/**
	 * Creates a new thong tin dang ky with the primary key. Does not add the thong tin dang ky to the database.
	 *
	 * @param id the primary key for the new thong tin dang ky
	 * @return the new thong tin dang ky
	 */
	@Override
	public dtt.vn.user.service.model.ThongTinDangKy createThongTinDangKy(
		long id) {

		return _thongTinDangKyLocalService.createThongTinDangKy(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _thongTinDangKyLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the thong tin dang ky with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the thong tin dang ky
	 * @return the thong tin dang ky that was removed
	 * @throws PortalException if a thong tin dang ky with the primary key could not be found
	 */
	@Override
	public dtt.vn.user.service.model.ThongTinDangKy deleteThongTinDangKy(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _thongTinDangKyLocalService.deleteThongTinDangKy(id);
	}

	/**
	 * Deletes the thong tin dang ky from the database. Also notifies the appropriate model listeners.
	 *
	 * @param thongTinDangKy the thong tin dang ky
	 * @return the thong tin dang ky that was removed
	 */
	@Override
	public dtt.vn.user.service.model.ThongTinDangKy deleteThongTinDangKy(
		dtt.vn.user.service.model.ThongTinDangKy thongTinDangKy) {

		return _thongTinDangKyLocalService.deleteThongTinDangKy(thongTinDangKy);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _thongTinDangKyLocalService.dynamicQuery();
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

		return _thongTinDangKyLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>dtt.vn.user.service.model.impl.ThongTinDangKyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _thongTinDangKyLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>dtt.vn.user.service.model.impl.ThongTinDangKyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _thongTinDangKyLocalService.dynamicQuery(
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

		return _thongTinDangKyLocalService.dynamicQueryCount(dynamicQuery);
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

		return _thongTinDangKyLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public dtt.vn.user.service.model.ThongTinDangKy fetchThongTinDangKy(
		long id) {

		return _thongTinDangKyLocalService.fetchThongTinDangKy(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _thongTinDangKyLocalService.getActionableDynamicQuery();
	}

	@Override
	public dtt.vn.user.service.model.ThongTinDangKy getByActiveType(
			String activeType)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _thongTinDangKyLocalService.getByActiveType(activeType);
	}

	@Override
	public dtt.vn.user.service.model.ThongTinDangKy getByEmailAddress(
			String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _thongTinDangKyLocalService.getByEmailAddress(emailAddress);
	}

	@Override
	public dtt.vn.user.service.model.ThongTinDangKy getByMaKichHoat(
			String maKichHoat)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _thongTinDangKyLocalService.getByMaKichHoat(maKichHoat);
	}

	@Override
	public dtt.vn.user.service.model.ThongTinDangKy getBySoGiayTo(
			String soGiayTo)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _thongTinDangKyLocalService.getBySoGiayTo(soGiayTo);
	}

	@Override
	public dtt.vn.user.service.model.ThongTinDangKy getByUserName(
			String userName)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _thongTinDangKyLocalService.getByUserName(userName);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _thongTinDangKyLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _thongTinDangKyLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _thongTinDangKyLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns a range of all the thong tin dang kies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>dtt.vn.user.service.model.impl.ThongTinDangKyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of thong tin dang kies
	 * @param end the upper bound of the range of thong tin dang kies (not inclusive)
	 * @return the range of thong tin dang kies
	 */
	@Override
	public java.util.List<dtt.vn.user.service.model.ThongTinDangKy>
		getThongTinDangKies(int start, int end) {

		return _thongTinDangKyLocalService.getThongTinDangKies(start, end);
	}

	/**
	 * Returns the number of thong tin dang kies.
	 *
	 * @return the number of thong tin dang kies
	 */
	@Override
	public int getThongTinDangKiesCount() {
		return _thongTinDangKyLocalService.getThongTinDangKiesCount();
	}

	/**
	 * Returns the thong tin dang ky with the primary key.
	 *
	 * @param id the primary key of the thong tin dang ky
	 * @return the thong tin dang ky
	 * @throws PortalException if a thong tin dang ky with the primary key could not be found
	 */
	@Override
	public dtt.vn.user.service.model.ThongTinDangKy getThongTinDangKy(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _thongTinDangKyLocalService.getThongTinDangKy(id);
	}

	@Override
	public boolean isEmailExsist(String emailAddress) {
		return _thongTinDangKyLocalService.isEmailExsist(emailAddress);
	}

	@Override
	public boolean isSoGiayToExsist(String soGiayTo) {
		return _thongTinDangKyLocalService.isSoGiayToExsist(soGiayTo);
	}

	@Override
	public boolean isUserNameExsist(String userName) {
		return _thongTinDangKyLocalService.isUserNameExsist(userName);
	}

	@Override
	public java.util.List<dtt.vn.user.service.model.ThongTinDangKy>
		searchByEmailOrUsername(
			String keyword, String tungay, String denngay, int start, int end) {

		return _thongTinDangKyLocalService.searchByEmailOrUsername(
			keyword, tungay, denngay, start, end);
	}

	/**
	 * Updates the thong tin dang ky in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param thongTinDangKy the thong tin dang ky
	 * @return the thong tin dang ky that was updated
	 */
	@Override
	public dtt.vn.user.service.model.ThongTinDangKy updateThongTinDangKy(
		dtt.vn.user.service.model.ThongTinDangKy thongTinDangKy) {

		return _thongTinDangKyLocalService.updateThongTinDangKy(thongTinDangKy);
	}

	@Override
	public ThongTinDangKyLocalService getWrappedService() {
		return _thongTinDangKyLocalService;
	}

	@Override
	public void setWrappedService(
		ThongTinDangKyLocalService thongTinDangKyLocalService) {

		_thongTinDangKyLocalService = thongTinDangKyLocalService;
	}

	private ThongTinDangKyLocalService _thongTinDangKyLocalService;

}