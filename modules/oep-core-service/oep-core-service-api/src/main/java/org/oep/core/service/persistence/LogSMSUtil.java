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

package org.oep.core.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.oep.core.model.LogSMS;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the log sms service. This utility wraps <code>org.oep.core.service.persistence.impl.LogSMSPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author manhlb
 * @see LogSMSPersistence
 * @generated
 */
@ProviderType
public class LogSMSUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(LogSMS logSMS) {
		getPersistence().clearCache(logSMS);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, LogSMS> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LogSMS> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LogSMS> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LogSMS> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LogSMS> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LogSMS update(LogSMS logSMS) {
		return getPersistence().update(logSMS);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LogSMS update(LogSMS logSMS, ServiceContext serviceContext) {
		return getPersistence().update(logSMS, serviceContext);
	}

	/**
	 * Caches the log sms in the entity cache if it is enabled.
	 *
	 * @param logSMS the log sms
	 */
	public static void cacheResult(LogSMS logSMS) {
		getPersistence().cacheResult(logSMS);
	}

	/**
	 * Caches the log smses in the entity cache if it is enabled.
	 *
	 * @param logSMSs the log smses
	 */
	public static void cacheResult(List<LogSMS> logSMSs) {
		getPersistence().cacheResult(logSMSs);
	}

	/**
	 * Creates a new log sms with the primary key. Does not add the log sms to the database.
	 *
	 * @param id the primary key for the new log sms
	 * @return the new log sms
	 */
	public static LogSMS create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the log sms with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the log sms
	 * @return the log sms that was removed
	 * @throws NoSuchLogSMSException if a log sms with the primary key could not be found
	 */
	public static LogSMS remove(long id)
		throws org.oep.core.exception.NoSuchLogSMSException {

		return getPersistence().remove(id);
	}

	public static LogSMS updateImpl(LogSMS logSMS) {
		return getPersistence().updateImpl(logSMS);
	}

	/**
	 * Returns the log sms with the primary key or throws a <code>NoSuchLogSMSException</code> if it could not be found.
	 *
	 * @param id the primary key of the log sms
	 * @return the log sms
	 * @throws NoSuchLogSMSException if a log sms with the primary key could not be found
	 */
	public static LogSMS findByPrimaryKey(long id)
		throws org.oep.core.exception.NoSuchLogSMSException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the log sms with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the log sms
	 * @return the log sms, or <code>null</code> if a log sms with the primary key could not be found
	 */
	public static LogSMS fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the log smses.
	 *
	 * @return the log smses
	 */
	public static List<LogSMS> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the log smses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LogSMSModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of log smses
	 * @param end the upper bound of the range of log smses (not inclusive)
	 * @return the range of log smses
	 */
	public static List<LogSMS> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the log smses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LogSMSModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of log smses
	 * @param end the upper bound of the range of log smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of log smses
	 */
	public static List<LogSMS> findAll(
		int start, int end, OrderByComparator<LogSMS> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the log smses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LogSMSModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of log smses
	 * @param end the upper bound of the range of log smses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of log smses
	 */
	public static List<LogSMS> findAll(
		int start, int end, OrderByComparator<LogSMS> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the log smses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of log smses.
	 *
	 * @return the number of log smses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static LogSMSPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LogSMSPersistence, LogSMSPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LogSMSPersistence.class);

		ServiceTracker<LogSMSPersistence, LogSMSPersistence> serviceTracker =
			new ServiceTracker<LogSMSPersistence, LogSMSPersistence>(
				bundle.getBundleContext(), LogSMSPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}