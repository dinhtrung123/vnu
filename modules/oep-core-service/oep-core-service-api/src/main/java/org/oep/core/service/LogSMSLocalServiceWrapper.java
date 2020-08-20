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
 * Provides a wrapper for {@link LogSMSLocalService}.
 *
 * @author manhlb
 * @see LogSMSLocalService
 * @generated
 */
@ProviderType
public class LogSMSLocalServiceWrapper
	implements LogSMSLocalService, ServiceWrapper<LogSMSLocalService> {

	public LogSMSLocalServiceWrapper(LogSMSLocalService logSMSLocalService) {
		_logSMSLocalService = logSMSLocalService;
	}

	/**
	 * Adds the log sms to the database. Also notifies the appropriate model listeners.
	 *
	 * @param logSMS the log sms
	 * @return the log sms that was added
	 */
	@Override
	public org.oep.core.model.LogSMS addLogSMS(
		org.oep.core.model.LogSMS logSMS) {

		return _logSMSLocalService.addLogSMS(logSMS);
	}

	@Override
	public int countByPhone(String keyword, String tungay, String denngay) {
		return _logSMSLocalService.countByPhone(keyword, tungay, denngay);
	}

	@Override
	public int coutnAll() throws Exception {
		return _logSMSLocalService.coutnAll();
	}

	/**
	 * Creates a new log sms with the primary key. Does not add the log sms to the database.
	 *
	 * @param id the primary key for the new log sms
	 * @return the new log sms
	 */
	@Override
	public org.oep.core.model.LogSMS createLogSMS(long id) {
		return _logSMSLocalService.createLogSMS(id);
	}

	/**
	 * Deletes the log sms from the database. Also notifies the appropriate model listeners.
	 *
	 * @param logSMS the log sms
	 * @return the log sms that was removed
	 */
	@Override
	public org.oep.core.model.LogSMS deleteLogSMS(
		org.oep.core.model.LogSMS logSMS) {

		return _logSMSLocalService.deleteLogSMS(logSMS);
	}

	/**
	 * Deletes the log sms with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the log sms
	 * @return the log sms that was removed
	 * @throws PortalException if a log sms with the primary key could not be found
	 */
	@Override
	public org.oep.core.model.LogSMS deleteLogSMS(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _logSMSLocalService.deleteLogSMS(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _logSMSLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _logSMSLocalService.dynamicQuery();
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

		return _logSMSLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>org.oep.core.model.impl.LogSMSModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _logSMSLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>org.oep.core.model.impl.LogSMSModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _logSMSLocalService.dynamicQuery(
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

		return _logSMSLocalService.dynamicQueryCount(dynamicQuery);
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

		return _logSMSLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public org.oep.core.model.LogSMS fetchLogSMS(long id) {
		return _logSMSLocalService.fetchLogSMS(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _logSMSLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<org.oep.core.model.LogSMS> getAll(int start, int end)
		throws Exception {

		return _logSMSLocalService.getAll(start, end);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _logSMSLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the log sms with the primary key.
	 *
	 * @param id the primary key of the log sms
	 * @return the log sms
	 * @throws PortalException if a log sms with the primary key could not be found
	 */
	@Override
	public org.oep.core.model.LogSMS getLogSMS(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _logSMSLocalService.getLogSMS(id);
	}

	/**
	 * Returns a range of all the log smses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>org.oep.core.model.impl.LogSMSModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of log smses
	 * @param end the upper bound of the range of log smses (not inclusive)
	 * @return the range of log smses
	 */
	@Override
	public java.util.List<org.oep.core.model.LogSMS> getLogSMSs(
		int start, int end) {

		return _logSMSLocalService.getLogSMSs(start, end);
	}

	/**
	 * Returns the number of log smses.
	 *
	 * @return the number of log smses
	 */
	@Override
	public int getLogSMSsCount() {
		return _logSMSLocalService.getLogSMSsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _logSMSLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _logSMSLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List<org.oep.core.model.LogSMS> searchByPhone(
		String keyword, String tungay, String denngay, int start, int end) {

		return _logSMSLocalService.searchByPhone(
			keyword, tungay, denngay, start, end);
	}

	/**
	 * Updates the log sms in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param logSMS the log sms
	 * @return the log sms that was updated
	 */
	@Override
	public org.oep.core.model.LogSMS updateLogSMS(
		org.oep.core.model.LogSMS logSMS) {

		return _logSMSLocalService.updateLogSMS(logSMS);
	}

	@Override
	public LogSMSLocalService getWrappedService() {
		return _logSMSLocalService;
	}

	@Override
	public void setWrappedService(LogSMSLocalService logSMSLocalService) {
		_logSMSLocalService = logSMSLocalService;
	}

	private LogSMSLocalService _logSMSLocalService;

}