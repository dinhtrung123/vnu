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
 * Provides a wrapper for {@link DataImportLocalService}.
 *
 * @author nhanvienDTT
 * @see DataImportLocalService
 * @generated
 */
@ProviderType
public class DataImportLocalServiceWrapper
	implements DataImportLocalService, ServiceWrapper<DataImportLocalService> {

	public DataImportLocalServiceWrapper(
		DataImportLocalService dataImportLocalService) {

		_dataImportLocalService = dataImportLocalService;
	}

	/**
	 * Adds the data import to the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataImport the data import
	 * @return the data import that was added
	 */
	@Override
	public dtt.vn.user.service.model.DataImport addDataImport(
		dtt.vn.user.service.model.DataImport dataImport) {

		return _dataImportLocalService.addDataImport(dataImport);
	}

	@Override
	public int countDataByI(String hasImport) {
		return _dataImportLocalService.countDataByI(hasImport);
	}

	@Override
	public int countForImport(
		int hasImport, String screenName, String lastName, String email,
		String role, String tungay, String denngay) {

		return _dataImportLocalService.countForImport(
			hasImport, screenName, lastName, email, role, tungay, denngay);
	}

	/**
	 * Creates a new data import with the primary key. Does not add the data import to the database.
	 *
	 * @param id the primary key for the new data import
	 * @return the new data import
	 */
	@Override
	public dtt.vn.user.service.model.DataImport createDataImport(long id) {
		return _dataImportLocalService.createDataImport(id);
	}

	/**
	 * Deletes the data import from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataImport the data import
	 * @return the data import that was removed
	 */
	@Override
	public dtt.vn.user.service.model.DataImport deleteDataImport(
		dtt.vn.user.service.model.DataImport dataImport) {

		return _dataImportLocalService.deleteDataImport(dataImport);
	}

	/**
	 * Deletes the data import with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the data import
	 * @return the data import that was removed
	 * @throws PortalException if a data import with the primary key could not be found
	 */
	@Override
	public dtt.vn.user.service.model.DataImport deleteDataImport(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataImportLocalService.deleteDataImport(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataImportLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dataImportLocalService.dynamicQuery();
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

		return _dataImportLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>dtt.vn.user.service.model.impl.DataImportModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _dataImportLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>dtt.vn.user.service.model.impl.DataImportModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _dataImportLocalService.dynamicQuery(
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

		return _dataImportLocalService.dynamicQueryCount(dynamicQuery);
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

		return _dataImportLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public dtt.vn.user.service.model.DataImport fetchDataImport(long id) {
		return _dataImportLocalService.fetchDataImport(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dataImportLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<dtt.vn.user.service.model.DataImport> getData() {
		return _dataImportLocalService.getData();
	}

	@Override
	public java.util.List<dtt.vn.user.service.model.DataImport> getData(
		int start, int end) {

		return _dataImportLocalService.getData(start, end);
	}

	@Override
	public java.util.List<dtt.vn.user.service.model.DataImport> getDataByI(
		String hasImport) {

		return _dataImportLocalService.getDataByI(hasImport);
	}

	@Override
	public java.util.List<dtt.vn.user.service.model.DataImport> getDataByI(
		String hasImport, int start, int end) {

		return _dataImportLocalService.getDataByI(hasImport, start, end);
	}

	/**
	 * Returns the data import with the primary key.
	 *
	 * @param id the primary key of the data import
	 * @return the data import
	 * @throws PortalException if a data import with the primary key could not be found
	 */
	@Override
	public dtt.vn.user.service.model.DataImport getDataImport(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataImportLocalService.getDataImport(id);
	}

	/**
	 * Returns a range of all the data imports.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>dtt.vn.user.service.model.impl.DataImportModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of data imports
	 * @param end the upper bound of the range of data imports (not inclusive)
	 * @return the range of data imports
	 */
	@Override
	public java.util.List<dtt.vn.user.service.model.DataImport> getDataImports(
		int start, int end) {

		return _dataImportLocalService.getDataImports(start, end);
	}

	/**
	 * Returns the number of data imports.
	 *
	 * @return the number of data imports
	 */
	@Override
	public int getDataImportsCount() {
		return _dataImportLocalService.getDataImportsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dataImportLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dataImportLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataImportLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public boolean isemailExists(String emailAddress) {
		return _dataImportLocalService.isemailExists(emailAddress);
	}

	@Override
	public boolean islastNameExists(String lastName) {
		return _dataImportLocalService.islastNameExists(lastName);
	}

	@Override
	public boolean isphoneExists(String phone) {
		return _dataImportLocalService.isphoneExists(phone);
	}

	@Override
	public boolean isscreenNameExists(String screenName) {
		return _dataImportLocalService.isscreenNameExists(screenName);
	}

	@Override
	public java.util.List<dtt.vn.user.service.model.DataImport> searchForImport(
		int hasImport, String screenName, String lastName, String email,
		String role, String tungay, String denngay, int start, int end) {

		return _dataImportLocalService.searchForImport(
			hasImport, screenName, lastName, email, role, tungay, denngay,
			start, end);
	}

	/**
	 * Updates the data import in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param dataImport the data import
	 * @return the data import that was updated
	 */
	@Override
	public dtt.vn.user.service.model.DataImport updateDataImport(
		dtt.vn.user.service.model.DataImport dataImport) {

		return _dataImportLocalService.updateDataImport(dataImport);
	}

	@Override
	public DataImportLocalService getWrappedService() {
		return _dataImportLocalService;
	}

	@Override
	public void setWrappedService(
		DataImportLocalService dataImportLocalService) {

		_dataImportLocalService = dataImportLocalService;
	}

	private DataImportLocalService _dataImportLocalService;

}