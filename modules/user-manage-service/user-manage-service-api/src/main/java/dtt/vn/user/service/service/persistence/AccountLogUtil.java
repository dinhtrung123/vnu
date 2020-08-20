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

package dtt.vn.user.service.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import dtt.vn.user.service.model.AccountLog;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the account log service. This utility wraps <code>dtt.vn.user.service.service.persistence.impl.AccountLogPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nhanvienDTT
 * @see AccountLogPersistence
 * @generated
 */
@ProviderType
public class AccountLogUtil {

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
	public static void clearCache(AccountLog accountLog) {
		getPersistence().clearCache(accountLog);
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
	public static Map<Serializable, AccountLog> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AccountLog> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AccountLog> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AccountLog> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AccountLog> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AccountLog update(AccountLog accountLog) {
		return getPersistence().update(accountLog);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AccountLog update(
		AccountLog accountLog, ServiceContext serviceContext) {

		return getPersistence().update(accountLog, serviceContext);
	}

	/**
	 * Returns all the account logs where accountId = &#63;.
	 *
	 * @param accountId the account ID
	 * @return the matching account logs
	 */
	public static List<AccountLog> findByAccount(long accountId) {
		return getPersistence().findByAccount(accountId);
	}

	/**
	 * Returns a range of all the account logs where accountId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AccountLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param accountId the account ID
	 * @param start the lower bound of the range of account logs
	 * @param end the upper bound of the range of account logs (not inclusive)
	 * @return the range of matching account logs
	 */
	public static List<AccountLog> findByAccount(
		long accountId, int start, int end) {

		return getPersistence().findByAccount(accountId, start, end);
	}

	/**
	 * Returns an ordered range of all the account logs where accountId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AccountLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param accountId the account ID
	 * @param start the lower bound of the range of account logs
	 * @param end the upper bound of the range of account logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching account logs
	 */
	public static List<AccountLog> findByAccount(
		long accountId, int start, int end,
		OrderByComparator<AccountLog> orderByComparator) {

		return getPersistence().findByAccount(
			accountId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the account logs where accountId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AccountLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param accountId the account ID
	 * @param start the lower bound of the range of account logs
	 * @param end the upper bound of the range of account logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching account logs
	 */
	public static List<AccountLog> findByAccount(
		long accountId, int start, int end,
		OrderByComparator<AccountLog> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByAccount(
			accountId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first account log in the ordered set where accountId = &#63;.
	 *
	 * @param accountId the account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account log
	 * @throws NoSuchAccountLogException if a matching account log could not be found
	 */
	public static AccountLog findByAccount_First(
			long accountId, OrderByComparator<AccountLog> orderByComparator)
		throws dtt.vn.user.service.exception.NoSuchAccountLogException {

		return getPersistence().findByAccount_First(
			accountId, orderByComparator);
	}

	/**
	 * Returns the first account log in the ordered set where accountId = &#63;.
	 *
	 * @param accountId the account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account log, or <code>null</code> if a matching account log could not be found
	 */
	public static AccountLog fetchByAccount_First(
		long accountId, OrderByComparator<AccountLog> orderByComparator) {

		return getPersistence().fetchByAccount_First(
			accountId, orderByComparator);
	}

	/**
	 * Returns the last account log in the ordered set where accountId = &#63;.
	 *
	 * @param accountId the account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account log
	 * @throws NoSuchAccountLogException if a matching account log could not be found
	 */
	public static AccountLog findByAccount_Last(
			long accountId, OrderByComparator<AccountLog> orderByComparator)
		throws dtt.vn.user.service.exception.NoSuchAccountLogException {

		return getPersistence().findByAccount_Last(
			accountId, orderByComparator);
	}

	/**
	 * Returns the last account log in the ordered set where accountId = &#63;.
	 *
	 * @param accountId the account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account log, or <code>null</code> if a matching account log could not be found
	 */
	public static AccountLog fetchByAccount_Last(
		long accountId, OrderByComparator<AccountLog> orderByComparator) {

		return getPersistence().fetchByAccount_Last(
			accountId, orderByComparator);
	}

	/**
	 * Returns the account logs before and after the current account log in the ordered set where accountId = &#63;.
	 *
	 * @param id the primary key of the current account log
	 * @param accountId the account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next account log
	 * @throws NoSuchAccountLogException if a account log with the primary key could not be found
	 */
	public static AccountLog[] findByAccount_PrevAndNext(
			long id, long accountId,
			OrderByComparator<AccountLog> orderByComparator)
		throws dtt.vn.user.service.exception.NoSuchAccountLogException {

		return getPersistence().findByAccount_PrevAndNext(
			id, accountId, orderByComparator);
	}

	/**
	 * Removes all the account logs where accountId = &#63; from the database.
	 *
	 * @param accountId the account ID
	 */
	public static void removeByAccount(long accountId) {
		getPersistence().removeByAccount(accountId);
	}

	/**
	 * Returns the number of account logs where accountId = &#63;.
	 *
	 * @param accountId the account ID
	 * @return the number of matching account logs
	 */
	public static int countByAccount(long accountId) {
		return getPersistence().countByAccount(accountId);
	}

	/**
	 * Caches the account log in the entity cache if it is enabled.
	 *
	 * @param accountLog the account log
	 */
	public static void cacheResult(AccountLog accountLog) {
		getPersistence().cacheResult(accountLog);
	}

	/**
	 * Caches the account logs in the entity cache if it is enabled.
	 *
	 * @param accountLogs the account logs
	 */
	public static void cacheResult(List<AccountLog> accountLogs) {
		getPersistence().cacheResult(accountLogs);
	}

	/**
	 * Creates a new account log with the primary key. Does not add the account log to the database.
	 *
	 * @param id the primary key for the new account log
	 * @return the new account log
	 */
	public static AccountLog create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the account log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the account log
	 * @return the account log that was removed
	 * @throws NoSuchAccountLogException if a account log with the primary key could not be found
	 */
	public static AccountLog remove(long id)
		throws dtt.vn.user.service.exception.NoSuchAccountLogException {

		return getPersistence().remove(id);
	}

	public static AccountLog updateImpl(AccountLog accountLog) {
		return getPersistence().updateImpl(accountLog);
	}

	/**
	 * Returns the account log with the primary key or throws a <code>NoSuchAccountLogException</code> if it could not be found.
	 *
	 * @param id the primary key of the account log
	 * @return the account log
	 * @throws NoSuchAccountLogException if a account log with the primary key could not be found
	 */
	public static AccountLog findByPrimaryKey(long id)
		throws dtt.vn.user.service.exception.NoSuchAccountLogException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the account log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the account log
	 * @return the account log, or <code>null</code> if a account log with the primary key could not be found
	 */
	public static AccountLog fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the account logs.
	 *
	 * @return the account logs
	 */
	public static List<AccountLog> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the account logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AccountLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of account logs
	 * @param end the upper bound of the range of account logs (not inclusive)
	 * @return the range of account logs
	 */
	public static List<AccountLog> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the account logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AccountLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of account logs
	 * @param end the upper bound of the range of account logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of account logs
	 */
	public static List<AccountLog> findAll(
		int start, int end, OrderByComparator<AccountLog> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the account logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AccountLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of account logs
	 * @param end the upper bound of the range of account logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of account logs
	 */
	public static List<AccountLog> findAll(
		int start, int end, OrderByComparator<AccountLog> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the account logs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of account logs.
	 *
	 * @return the number of account logs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static AccountLogPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AccountLogPersistence, AccountLogPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AccountLogPersistence.class);

		ServiceTracker<AccountLogPersistence, AccountLogPersistence>
			serviceTracker =
				new ServiceTracker
					<AccountLogPersistence, AccountLogPersistence>(
						bundle.getBundleContext(), AccountLogPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}