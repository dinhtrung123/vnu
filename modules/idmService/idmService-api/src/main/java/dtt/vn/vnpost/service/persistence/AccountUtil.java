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

package dtt.vn.vnpost.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import dtt.vn.vnpost.model.Account;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the account service. This utility wraps <code>dtt.vn.vnpost.service.persistence.impl.AccountPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AccountPersistence
 * @generated
 */
@ProviderType
public class AccountUtil {

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
	public static void clearCache(Account account) {
		getPersistence().clearCache(account);
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
	public static Map<Serializable, Account> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Account> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Account> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Account> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Account> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Account update(Account account) {
		return getPersistence().update(account);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Account update(
		Account account, ServiceContext serviceContext) {

		return getPersistence().update(account, serviceContext);
	}

	/**
	 * Returns all the accounts where accountType = &#63;.
	 *
	 * @param accountType the account type
	 * @return the matching accounts
	 */
	public static List<Account> findByaccountType(int accountType) {
		return getPersistence().findByaccountType(accountType);
	}

	/**
	 * Returns a range of all the accounts where accountType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AccountModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param accountType the account type
	 * @param start the lower bound of the range of accounts
	 * @param end the upper bound of the range of accounts (not inclusive)
	 * @return the range of matching accounts
	 */
	public static List<Account> findByaccountType(
		int accountType, int start, int end) {

		return getPersistence().findByaccountType(accountType, start, end);
	}

	/**
	 * Returns an ordered range of all the accounts where accountType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AccountModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param accountType the account type
	 * @param start the lower bound of the range of accounts
	 * @param end the upper bound of the range of accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching accounts
	 */
	public static List<Account> findByaccountType(
		int accountType, int start, int end,
		OrderByComparator<Account> orderByComparator) {

		return getPersistence().findByaccountType(
			accountType, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the accounts where accountType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AccountModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param accountType the account type
	 * @param start the lower bound of the range of accounts
	 * @param end the upper bound of the range of accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching accounts
	 */
	public static List<Account> findByaccountType(
		int accountType, int start, int end,
		OrderByComparator<Account> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByaccountType(
			accountType, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first account in the ordered set where accountType = &#63;.
	 *
	 * @param accountType the account type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	public static Account findByaccountType_First(
			int accountType, OrderByComparator<Account> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchAccountException {

		return getPersistence().findByaccountType_First(
			accountType, orderByComparator);
	}

	/**
	 * Returns the first account in the ordered set where accountType = &#63;.
	 *
	 * @param accountType the account type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account, or <code>null</code> if a matching account could not be found
	 */
	public static Account fetchByaccountType_First(
		int accountType, OrderByComparator<Account> orderByComparator) {

		return getPersistence().fetchByaccountType_First(
			accountType, orderByComparator);
	}

	/**
	 * Returns the last account in the ordered set where accountType = &#63;.
	 *
	 * @param accountType the account type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	public static Account findByaccountType_Last(
			int accountType, OrderByComparator<Account> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchAccountException {

		return getPersistence().findByaccountType_Last(
			accountType, orderByComparator);
	}

	/**
	 * Returns the last account in the ordered set where accountType = &#63;.
	 *
	 * @param accountType the account type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account, or <code>null</code> if a matching account could not be found
	 */
	public static Account fetchByaccountType_Last(
		int accountType, OrderByComparator<Account> orderByComparator) {

		return getPersistence().fetchByaccountType_Last(
			accountType, orderByComparator);
	}

	/**
	 * Returns the accounts before and after the current account in the ordered set where accountType = &#63;.
	 *
	 * @param accountId the primary key of the current account
	 * @param accountType the account type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next account
	 * @throws NoSuchAccountException if a account with the primary key could not be found
	 */
	public static Account[] findByaccountType_PrevAndNext(
			long accountId, int accountType,
			OrderByComparator<Account> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchAccountException {

		return getPersistence().findByaccountType_PrevAndNext(
			accountId, accountType, orderByComparator);
	}

	/**
	 * Removes all the accounts where accountType = &#63; from the database.
	 *
	 * @param accountType the account type
	 */
	public static void removeByaccountType(int accountType) {
		getPersistence().removeByaccountType(accountType);
	}

	/**
	 * Returns the number of accounts where accountType = &#63;.
	 *
	 * @param accountType the account type
	 * @return the number of matching accounts
	 */
	public static int countByaccountType(int accountType) {
		return getPersistence().countByaccountType(accountType);
	}

	/**
	 * Returns all the accounts where telNo = &#63;.
	 *
	 * @param telNo the tel no
	 * @return the matching accounts
	 */
	public static List<Account> findByphone(String telNo) {
		return getPersistence().findByphone(telNo);
	}

	/**
	 * Returns a range of all the accounts where telNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AccountModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param telNo the tel no
	 * @param start the lower bound of the range of accounts
	 * @param end the upper bound of the range of accounts (not inclusive)
	 * @return the range of matching accounts
	 */
	public static List<Account> findByphone(String telNo, int start, int end) {
		return getPersistence().findByphone(telNo, start, end);
	}

	/**
	 * Returns an ordered range of all the accounts where telNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AccountModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param telNo the tel no
	 * @param start the lower bound of the range of accounts
	 * @param end the upper bound of the range of accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching accounts
	 */
	public static List<Account> findByphone(
		String telNo, int start, int end,
		OrderByComparator<Account> orderByComparator) {

		return getPersistence().findByphone(
			telNo, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the accounts where telNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AccountModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param telNo the tel no
	 * @param start the lower bound of the range of accounts
	 * @param end the upper bound of the range of accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching accounts
	 */
	public static List<Account> findByphone(
		String telNo, int start, int end,
		OrderByComparator<Account> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByphone(
			telNo, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first account in the ordered set where telNo = &#63;.
	 *
	 * @param telNo the tel no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	public static Account findByphone_First(
			String telNo, OrderByComparator<Account> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchAccountException {

		return getPersistence().findByphone_First(telNo, orderByComparator);
	}

	/**
	 * Returns the first account in the ordered set where telNo = &#63;.
	 *
	 * @param telNo the tel no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account, or <code>null</code> if a matching account could not be found
	 */
	public static Account fetchByphone_First(
		String telNo, OrderByComparator<Account> orderByComparator) {

		return getPersistence().fetchByphone_First(telNo, orderByComparator);
	}

	/**
	 * Returns the last account in the ordered set where telNo = &#63;.
	 *
	 * @param telNo the tel no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	public static Account findByphone_Last(
			String telNo, OrderByComparator<Account> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchAccountException {

		return getPersistence().findByphone_Last(telNo, orderByComparator);
	}

	/**
	 * Returns the last account in the ordered set where telNo = &#63;.
	 *
	 * @param telNo the tel no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account, or <code>null</code> if a matching account could not be found
	 */
	public static Account fetchByphone_Last(
		String telNo, OrderByComparator<Account> orderByComparator) {

		return getPersistence().fetchByphone_Last(telNo, orderByComparator);
	}

	/**
	 * Returns the accounts before and after the current account in the ordered set where telNo = &#63;.
	 *
	 * @param accountId the primary key of the current account
	 * @param telNo the tel no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next account
	 * @throws NoSuchAccountException if a account with the primary key could not be found
	 */
	public static Account[] findByphone_PrevAndNext(
			long accountId, String telNo,
			OrderByComparator<Account> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchAccountException {

		return getPersistence().findByphone_PrevAndNext(
			accountId, telNo, orderByComparator);
	}

	/**
	 * Removes all the accounts where telNo = &#63; from the database.
	 *
	 * @param telNo the tel no
	 */
	public static void removeByphone(String telNo) {
		getPersistence().removeByphone(telNo);
	}

	/**
	 * Returns the number of accounts where telNo = &#63;.
	 *
	 * @param telNo the tel no
	 * @return the number of matching accounts
	 */
	public static int countByphone(String telNo) {
		return getPersistence().countByphone(telNo);
	}

	/**
	 * Returns all the accounts where taxCode = &#63;.
	 *
	 * @param taxCode the tax code
	 * @return the matching accounts
	 */
	public static List<Account> findBymst(String taxCode) {
		return getPersistence().findBymst(taxCode);
	}

	/**
	 * Returns a range of all the accounts where taxCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AccountModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param taxCode the tax code
	 * @param start the lower bound of the range of accounts
	 * @param end the upper bound of the range of accounts (not inclusive)
	 * @return the range of matching accounts
	 */
	public static List<Account> findBymst(String taxCode, int start, int end) {
		return getPersistence().findBymst(taxCode, start, end);
	}

	/**
	 * Returns an ordered range of all the accounts where taxCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AccountModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param taxCode the tax code
	 * @param start the lower bound of the range of accounts
	 * @param end the upper bound of the range of accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching accounts
	 */
	public static List<Account> findBymst(
		String taxCode, int start, int end,
		OrderByComparator<Account> orderByComparator) {

		return getPersistence().findBymst(
			taxCode, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the accounts where taxCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AccountModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param taxCode the tax code
	 * @param start the lower bound of the range of accounts
	 * @param end the upper bound of the range of accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching accounts
	 */
	public static List<Account> findBymst(
		String taxCode, int start, int end,
		OrderByComparator<Account> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findBymst(
			taxCode, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first account in the ordered set where taxCode = &#63;.
	 *
	 * @param taxCode the tax code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	public static Account findBymst_First(
			String taxCode, OrderByComparator<Account> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchAccountException {

		return getPersistence().findBymst_First(taxCode, orderByComparator);
	}

	/**
	 * Returns the first account in the ordered set where taxCode = &#63;.
	 *
	 * @param taxCode the tax code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account, or <code>null</code> if a matching account could not be found
	 */
	public static Account fetchBymst_First(
		String taxCode, OrderByComparator<Account> orderByComparator) {

		return getPersistence().fetchBymst_First(taxCode, orderByComparator);
	}

	/**
	 * Returns the last account in the ordered set where taxCode = &#63;.
	 *
	 * @param taxCode the tax code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	public static Account findBymst_Last(
			String taxCode, OrderByComparator<Account> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchAccountException {

		return getPersistence().findBymst_Last(taxCode, orderByComparator);
	}

	/**
	 * Returns the last account in the ordered set where taxCode = &#63;.
	 *
	 * @param taxCode the tax code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account, or <code>null</code> if a matching account could not be found
	 */
	public static Account fetchBymst_Last(
		String taxCode, OrderByComparator<Account> orderByComparator) {

		return getPersistence().fetchBymst_Last(taxCode, orderByComparator);
	}

	/**
	 * Returns the accounts before and after the current account in the ordered set where taxCode = &#63;.
	 *
	 * @param accountId the primary key of the current account
	 * @param taxCode the tax code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next account
	 * @throws NoSuchAccountException if a account with the primary key could not be found
	 */
	public static Account[] findBymst_PrevAndNext(
			long accountId, String taxCode,
			OrderByComparator<Account> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchAccountException {

		return getPersistence().findBymst_PrevAndNext(
			accountId, taxCode, orderByComparator);
	}

	/**
	 * Removes all the accounts where taxCode = &#63; from the database.
	 *
	 * @param taxCode the tax code
	 */
	public static void removeBymst(String taxCode) {
		getPersistence().removeBymst(taxCode);
	}

	/**
	 * Returns the number of accounts where taxCode = &#63;.
	 *
	 * @param taxCode the tax code
	 * @return the number of matching accounts
	 */
	public static int countBymst(String taxCode) {
		return getPersistence().countBymst(taxCode);
	}

	/**
	 * Returns all the accounts where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching accounts
	 */
	public static List<Account> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the accounts where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AccountModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of accounts
	 * @param end the upper bound of the range of accounts (not inclusive)
	 * @return the range of matching accounts
	 */
	public static List<Account> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the accounts where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AccountModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of accounts
	 * @param end the upper bound of the range of accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching accounts
	 */
	public static List<Account> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Account> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the accounts where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AccountModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of accounts
	 * @param end the upper bound of the range of accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching accounts
	 */
	public static List<Account> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Account> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first account in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	public static Account findByGroupId_First(
			long groupId, OrderByComparator<Account> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchAccountException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first account in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account, or <code>null</code> if a matching account could not be found
	 */
	public static Account fetchByGroupId_First(
		long groupId, OrderByComparator<Account> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last account in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	public static Account findByGroupId_Last(
			long groupId, OrderByComparator<Account> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchAccountException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last account in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account, or <code>null</code> if a matching account could not be found
	 */
	public static Account fetchByGroupId_Last(
		long groupId, OrderByComparator<Account> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the accounts before and after the current account in the ordered set where groupId = &#63;.
	 *
	 * @param accountId the primary key of the current account
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next account
	 * @throws NoSuchAccountException if a account with the primary key could not be found
	 */
	public static Account[] findByGroupId_PrevAndNext(
			long accountId, long groupId,
			OrderByComparator<Account> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchAccountException {

		return getPersistence().findByGroupId_PrevAndNext(
			accountId, groupId, orderByComparator);
	}

	/**
	 * Removes all the accounts where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of accounts where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching accounts
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the accounts where groupId = &#63; and accountStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @return the matching accounts
	 */
	public static List<Account> findByGS(long groupId, int accountStatus) {
		return getPersistence().findByGS(groupId, accountStatus);
	}

	/**
	 * Returns a range of all the accounts where groupId = &#63; and accountStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AccountModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param start the lower bound of the range of accounts
	 * @param end the upper bound of the range of accounts (not inclusive)
	 * @return the range of matching accounts
	 */
	public static List<Account> findByGS(
		long groupId, int accountStatus, int start, int end) {

		return getPersistence().findByGS(groupId, accountStatus, start, end);
	}

	/**
	 * Returns an ordered range of all the accounts where groupId = &#63; and accountStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AccountModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param start the lower bound of the range of accounts
	 * @param end the upper bound of the range of accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching accounts
	 */
	public static List<Account> findByGS(
		long groupId, int accountStatus, int start, int end,
		OrderByComparator<Account> orderByComparator) {

		return getPersistence().findByGS(
			groupId, accountStatus, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the accounts where groupId = &#63; and accountStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AccountModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param start the lower bound of the range of accounts
	 * @param end the upper bound of the range of accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching accounts
	 */
	public static List<Account> findByGS(
		long groupId, int accountStatus, int start, int end,
		OrderByComparator<Account> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByGS(
			groupId, accountStatus, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	 * Returns the first account in the ordered set where groupId = &#63; and accountStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	public static Account findByGS_First(
			long groupId, int accountStatus,
			OrderByComparator<Account> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchAccountException {

		return getPersistence().findByGS_First(
			groupId, accountStatus, orderByComparator);
	}

	/**
	 * Returns the first account in the ordered set where groupId = &#63; and accountStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account, or <code>null</code> if a matching account could not be found
	 */
	public static Account fetchByGS_First(
		long groupId, int accountStatus,
		OrderByComparator<Account> orderByComparator) {

		return getPersistence().fetchByGS_First(
			groupId, accountStatus, orderByComparator);
	}

	/**
	 * Returns the last account in the ordered set where groupId = &#63; and accountStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	public static Account findByGS_Last(
			long groupId, int accountStatus,
			OrderByComparator<Account> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchAccountException {

		return getPersistence().findByGS_Last(
			groupId, accountStatus, orderByComparator);
	}

	/**
	 * Returns the last account in the ordered set where groupId = &#63; and accountStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account, or <code>null</code> if a matching account could not be found
	 */
	public static Account fetchByGS_Last(
		long groupId, int accountStatus,
		OrderByComparator<Account> orderByComparator) {

		return getPersistence().fetchByGS_Last(
			groupId, accountStatus, orderByComparator);
	}

	/**
	 * Returns the accounts before and after the current account in the ordered set where groupId = &#63; and accountStatus = &#63;.
	 *
	 * @param accountId the primary key of the current account
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next account
	 * @throws NoSuchAccountException if a account with the primary key could not be found
	 */
	public static Account[] findByGS_PrevAndNext(
			long accountId, long groupId, int accountStatus,
			OrderByComparator<Account> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchAccountException {

		return getPersistence().findByGS_PrevAndNext(
			accountId, groupId, accountStatus, orderByComparator);
	}

	/**
	 * Removes all the accounts where groupId = &#63; and accountStatus = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 */
	public static void removeByGS(long groupId, int accountStatus) {
		getPersistence().removeByGS(groupId, accountStatus);
	}

	/**
	 * Returns the number of accounts where groupId = &#63; and accountStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @return the number of matching accounts
	 */
	public static int countByGS(long groupId, int accountStatus) {
		return getPersistence().countByGS(groupId, accountStatus);
	}

	/**
	 * Returns all the accounts where groupId = &#63; and accountStatus = &#63; and cityCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param cityCode the city code
	 * @return the matching accounts
	 */
	public static List<Account> findByGSC(
		long groupId, int accountStatus, String cityCode) {

		return getPersistence().findByGSC(groupId, accountStatus, cityCode);
	}

	/**
	 * Returns a range of all the accounts where groupId = &#63; and accountStatus = &#63; and cityCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AccountModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param cityCode the city code
	 * @param start the lower bound of the range of accounts
	 * @param end the upper bound of the range of accounts (not inclusive)
	 * @return the range of matching accounts
	 */
	public static List<Account> findByGSC(
		long groupId, int accountStatus, String cityCode, int start, int end) {

		return getPersistence().findByGSC(
			groupId, accountStatus, cityCode, start, end);
	}

	/**
	 * Returns an ordered range of all the accounts where groupId = &#63; and accountStatus = &#63; and cityCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AccountModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param cityCode the city code
	 * @param start the lower bound of the range of accounts
	 * @param end the upper bound of the range of accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching accounts
	 */
	public static List<Account> findByGSC(
		long groupId, int accountStatus, String cityCode, int start, int end,
		OrderByComparator<Account> orderByComparator) {

		return getPersistence().findByGSC(
			groupId, accountStatus, cityCode, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the accounts where groupId = &#63; and accountStatus = &#63; and cityCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AccountModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param cityCode the city code
	 * @param start the lower bound of the range of accounts
	 * @param end the upper bound of the range of accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching accounts
	 */
	public static List<Account> findByGSC(
		long groupId, int accountStatus, String cityCode, int start, int end,
		OrderByComparator<Account> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByGSC(
			groupId, accountStatus, cityCode, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	 * Returns the first account in the ordered set where groupId = &#63; and accountStatus = &#63; and cityCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param cityCode the city code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	public static Account findByGSC_First(
			long groupId, int accountStatus, String cityCode,
			OrderByComparator<Account> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchAccountException {

		return getPersistence().findByGSC_First(
			groupId, accountStatus, cityCode, orderByComparator);
	}

	/**
	 * Returns the first account in the ordered set where groupId = &#63; and accountStatus = &#63; and cityCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param cityCode the city code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account, or <code>null</code> if a matching account could not be found
	 */
	public static Account fetchByGSC_First(
		long groupId, int accountStatus, String cityCode,
		OrderByComparator<Account> orderByComparator) {

		return getPersistence().fetchByGSC_First(
			groupId, accountStatus, cityCode, orderByComparator);
	}

	/**
	 * Returns the last account in the ordered set where groupId = &#63; and accountStatus = &#63; and cityCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param cityCode the city code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	public static Account findByGSC_Last(
			long groupId, int accountStatus, String cityCode,
			OrderByComparator<Account> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchAccountException {

		return getPersistence().findByGSC_Last(
			groupId, accountStatus, cityCode, orderByComparator);
	}

	/**
	 * Returns the last account in the ordered set where groupId = &#63; and accountStatus = &#63; and cityCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param cityCode the city code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account, or <code>null</code> if a matching account could not be found
	 */
	public static Account fetchByGSC_Last(
		long groupId, int accountStatus, String cityCode,
		OrderByComparator<Account> orderByComparator) {

		return getPersistence().fetchByGSC_Last(
			groupId, accountStatus, cityCode, orderByComparator);
	}

	/**
	 * Returns the accounts before and after the current account in the ordered set where groupId = &#63; and accountStatus = &#63; and cityCode = &#63;.
	 *
	 * @param accountId the primary key of the current account
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param cityCode the city code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next account
	 * @throws NoSuchAccountException if a account with the primary key could not be found
	 */
	public static Account[] findByGSC_PrevAndNext(
			long accountId, long groupId, int accountStatus, String cityCode,
			OrderByComparator<Account> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchAccountException {

		return getPersistence().findByGSC_PrevAndNext(
			accountId, groupId, accountStatus, cityCode, orderByComparator);
	}

	/**
	 * Removes all the accounts where groupId = &#63; and accountStatus = &#63; and cityCode = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param cityCode the city code
	 */
	public static void removeByGSC(
		long groupId, int accountStatus, String cityCode) {

		getPersistence().removeByGSC(groupId, accountStatus, cityCode);
	}

	/**
	 * Returns the number of accounts where groupId = &#63; and accountStatus = &#63; and cityCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param cityCode the city code
	 * @return the number of matching accounts
	 */
	public static int countByGSC(
		long groupId, int accountStatus, String cityCode) {

		return getPersistence().countByGSC(groupId, accountStatus, cityCode);
	}

	/**
	 * Returns all the accounts where groupId = &#63; and accountStatus = &#63; and districtCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param districtCode the district code
	 * @return the matching accounts
	 */
	public static List<Account> findByGSD(
		long groupId, int accountStatus, String districtCode) {

		return getPersistence().findByGSD(groupId, accountStatus, districtCode);
	}

	/**
	 * Returns a range of all the accounts where groupId = &#63; and accountStatus = &#63; and districtCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AccountModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param districtCode the district code
	 * @param start the lower bound of the range of accounts
	 * @param end the upper bound of the range of accounts (not inclusive)
	 * @return the range of matching accounts
	 */
	public static List<Account> findByGSD(
		long groupId, int accountStatus, String districtCode, int start,
		int end) {

		return getPersistence().findByGSD(
			groupId, accountStatus, districtCode, start, end);
	}

	/**
	 * Returns an ordered range of all the accounts where groupId = &#63; and accountStatus = &#63; and districtCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AccountModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param districtCode the district code
	 * @param start the lower bound of the range of accounts
	 * @param end the upper bound of the range of accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching accounts
	 */
	public static List<Account> findByGSD(
		long groupId, int accountStatus, String districtCode, int start,
		int end, OrderByComparator<Account> orderByComparator) {

		return getPersistence().findByGSD(
			groupId, accountStatus, districtCode, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the accounts where groupId = &#63; and accountStatus = &#63; and districtCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AccountModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param districtCode the district code
	 * @param start the lower bound of the range of accounts
	 * @param end the upper bound of the range of accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching accounts
	 */
	public static List<Account> findByGSD(
		long groupId, int accountStatus, String districtCode, int start,
		int end, OrderByComparator<Account> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByGSD(
			groupId, accountStatus, districtCode, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	 * Returns the first account in the ordered set where groupId = &#63; and accountStatus = &#63; and districtCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param districtCode the district code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	public static Account findByGSD_First(
			long groupId, int accountStatus, String districtCode,
			OrderByComparator<Account> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchAccountException {

		return getPersistence().findByGSD_First(
			groupId, accountStatus, districtCode, orderByComparator);
	}

	/**
	 * Returns the first account in the ordered set where groupId = &#63; and accountStatus = &#63; and districtCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param districtCode the district code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account, or <code>null</code> if a matching account could not be found
	 */
	public static Account fetchByGSD_First(
		long groupId, int accountStatus, String districtCode,
		OrderByComparator<Account> orderByComparator) {

		return getPersistence().fetchByGSD_First(
			groupId, accountStatus, districtCode, orderByComparator);
	}

	/**
	 * Returns the last account in the ordered set where groupId = &#63; and accountStatus = &#63; and districtCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param districtCode the district code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	public static Account findByGSD_Last(
			long groupId, int accountStatus, String districtCode,
			OrderByComparator<Account> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchAccountException {

		return getPersistence().findByGSD_Last(
			groupId, accountStatus, districtCode, orderByComparator);
	}

	/**
	 * Returns the last account in the ordered set where groupId = &#63; and accountStatus = &#63; and districtCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param districtCode the district code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account, or <code>null</code> if a matching account could not be found
	 */
	public static Account fetchByGSD_Last(
		long groupId, int accountStatus, String districtCode,
		OrderByComparator<Account> orderByComparator) {

		return getPersistence().fetchByGSD_Last(
			groupId, accountStatus, districtCode, orderByComparator);
	}

	/**
	 * Returns the accounts before and after the current account in the ordered set where groupId = &#63; and accountStatus = &#63; and districtCode = &#63;.
	 *
	 * @param accountId the primary key of the current account
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param districtCode the district code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next account
	 * @throws NoSuchAccountException if a account with the primary key could not be found
	 */
	public static Account[] findByGSD_PrevAndNext(
			long accountId, long groupId, int accountStatus,
			String districtCode, OrderByComparator<Account> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchAccountException {

		return getPersistence().findByGSD_PrevAndNext(
			accountId, groupId, accountStatus, districtCode, orderByComparator);
	}

	/**
	 * Removes all the accounts where groupId = &#63; and accountStatus = &#63; and districtCode = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param districtCode the district code
	 */
	public static void removeByGSD(
		long groupId, int accountStatus, String districtCode) {

		getPersistence().removeByGSD(groupId, accountStatus, districtCode);
	}

	/**
	 * Returns the number of accounts where groupId = &#63; and accountStatus = &#63; and districtCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param districtCode the district code
	 * @return the number of matching accounts
	 */
	public static int countByGSD(
		long groupId, int accountStatus, String districtCode) {

		return getPersistence().countByGSD(
			groupId, accountStatus, districtCode);
	}

	/**
	 * Returns all the accounts where groupId = &#63; and accountStatus = &#63; and wardCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param wardCode the ward code
	 * @return the matching accounts
	 */
	public static List<Account> findByGSW(
		long groupId, int accountStatus, String wardCode) {

		return getPersistence().findByGSW(groupId, accountStatus, wardCode);
	}

	/**
	 * Returns a range of all the accounts where groupId = &#63; and accountStatus = &#63; and wardCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AccountModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param wardCode the ward code
	 * @param start the lower bound of the range of accounts
	 * @param end the upper bound of the range of accounts (not inclusive)
	 * @return the range of matching accounts
	 */
	public static List<Account> findByGSW(
		long groupId, int accountStatus, String wardCode, int start, int end) {

		return getPersistence().findByGSW(
			groupId, accountStatus, wardCode, start, end);
	}

	/**
	 * Returns an ordered range of all the accounts where groupId = &#63; and accountStatus = &#63; and wardCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AccountModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param wardCode the ward code
	 * @param start the lower bound of the range of accounts
	 * @param end the upper bound of the range of accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching accounts
	 */
	public static List<Account> findByGSW(
		long groupId, int accountStatus, String wardCode, int start, int end,
		OrderByComparator<Account> orderByComparator) {

		return getPersistence().findByGSW(
			groupId, accountStatus, wardCode, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the accounts where groupId = &#63; and accountStatus = &#63; and wardCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AccountModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param wardCode the ward code
	 * @param start the lower bound of the range of accounts
	 * @param end the upper bound of the range of accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching accounts
	 */
	public static List<Account> findByGSW(
		long groupId, int accountStatus, String wardCode, int start, int end,
		OrderByComparator<Account> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByGSW(
			groupId, accountStatus, wardCode, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	 * Returns the first account in the ordered set where groupId = &#63; and accountStatus = &#63; and wardCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param wardCode the ward code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	public static Account findByGSW_First(
			long groupId, int accountStatus, String wardCode,
			OrderByComparator<Account> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchAccountException {

		return getPersistence().findByGSW_First(
			groupId, accountStatus, wardCode, orderByComparator);
	}

	/**
	 * Returns the first account in the ordered set where groupId = &#63; and accountStatus = &#63; and wardCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param wardCode the ward code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account, or <code>null</code> if a matching account could not be found
	 */
	public static Account fetchByGSW_First(
		long groupId, int accountStatus, String wardCode,
		OrderByComparator<Account> orderByComparator) {

		return getPersistence().fetchByGSW_First(
			groupId, accountStatus, wardCode, orderByComparator);
	}

	/**
	 * Returns the last account in the ordered set where groupId = &#63; and accountStatus = &#63; and wardCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param wardCode the ward code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	public static Account findByGSW_Last(
			long groupId, int accountStatus, String wardCode,
			OrderByComparator<Account> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchAccountException {

		return getPersistence().findByGSW_Last(
			groupId, accountStatus, wardCode, orderByComparator);
	}

	/**
	 * Returns the last account in the ordered set where groupId = &#63; and accountStatus = &#63; and wardCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param wardCode the ward code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account, or <code>null</code> if a matching account could not be found
	 */
	public static Account fetchByGSW_Last(
		long groupId, int accountStatus, String wardCode,
		OrderByComparator<Account> orderByComparator) {

		return getPersistence().fetchByGSW_Last(
			groupId, accountStatus, wardCode, orderByComparator);
	}

	/**
	 * Returns the accounts before and after the current account in the ordered set where groupId = &#63; and accountStatus = &#63; and wardCode = &#63;.
	 *
	 * @param accountId the primary key of the current account
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param wardCode the ward code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next account
	 * @throws NoSuchAccountException if a account with the primary key could not be found
	 */
	public static Account[] findByGSW_PrevAndNext(
			long accountId, long groupId, int accountStatus, String wardCode,
			OrderByComparator<Account> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchAccountException {

		return getPersistence().findByGSW_PrevAndNext(
			accountId, groupId, accountStatus, wardCode, orderByComparator);
	}

	/**
	 * Removes all the accounts where groupId = &#63; and accountStatus = &#63; and wardCode = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param wardCode the ward code
	 */
	public static void removeByGSW(
		long groupId, int accountStatus, String wardCode) {

		getPersistence().removeByGSW(groupId, accountStatus, wardCode);
	}

	/**
	 * Returns the number of accounts where groupId = &#63; and accountStatus = &#63; and wardCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param wardCode the ward code
	 * @return the number of matching accounts
	 */
	public static int countByGSW(
		long groupId, int accountStatus, String wardCode) {

		return getPersistence().countByGSW(groupId, accountStatus, wardCode);
	}

	/**
	 * Returns the account where email = &#63; or throws a <code>NoSuchAccountException</code> if it could not be found.
	 *
	 * @param email the email
	 * @return the matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	public static Account findByEmail(String email)
		throws dtt.vn.vnpost.exception.NoSuchAccountException {

		return getPersistence().findByEmail(email);
	}

	/**
	 * Returns the account where email = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param email the email
	 * @return the matching account, or <code>null</code> if a matching account could not be found
	 */
	public static Account fetchByEmail(String email) {
		return getPersistence().fetchByEmail(email);
	}

	/**
	 * Returns the account where email = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param email the email
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching account, or <code>null</code> if a matching account could not be found
	 */
	public static Account fetchByEmail(
		String email, boolean retrieveFromCache) {

		return getPersistence().fetchByEmail(email, retrieveFromCache);
	}

	/**
	 * Removes the account where email = &#63; from the database.
	 *
	 * @param email the email
	 * @return the account that was removed
	 */
	public static Account removeByEmail(String email)
		throws dtt.vn.vnpost.exception.NoSuchAccountException {

		return getPersistence().removeByEmail(email);
	}

	/**
	 * Returns the number of accounts where email = &#63;.
	 *
	 * @param email the email
	 * @return the number of matching accounts
	 */
	public static int countByEmail(String email) {
		return getPersistence().countByEmail(email);
	}

	/**
	 * Returns all the accounts where groupId = &#63; and fullName LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @return the matching accounts
	 */
	public static List<Account> findByGN(long groupId, String fullName) {
		return getPersistence().findByGN(groupId, fullName);
	}

	/**
	 * Returns a range of all the accounts where groupId = &#63; and fullName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AccountModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param start the lower bound of the range of accounts
	 * @param end the upper bound of the range of accounts (not inclusive)
	 * @return the range of matching accounts
	 */
	public static List<Account> findByGN(
		long groupId, String fullName, int start, int end) {

		return getPersistence().findByGN(groupId, fullName, start, end);
	}

	/**
	 * Returns an ordered range of all the accounts where groupId = &#63; and fullName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AccountModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param start the lower bound of the range of accounts
	 * @param end the upper bound of the range of accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching accounts
	 */
	public static List<Account> findByGN(
		long groupId, String fullName, int start, int end,
		OrderByComparator<Account> orderByComparator) {

		return getPersistence().findByGN(
			groupId, fullName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the accounts where groupId = &#63; and fullName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AccountModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param start the lower bound of the range of accounts
	 * @param end the upper bound of the range of accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching accounts
	 */
	public static List<Account> findByGN(
		long groupId, String fullName, int start, int end,
		OrderByComparator<Account> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByGN(
			groupId, fullName, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	 * Returns the first account in the ordered set where groupId = &#63; and fullName LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	public static Account findByGN_First(
			long groupId, String fullName,
			OrderByComparator<Account> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchAccountException {

		return getPersistence().findByGN_First(
			groupId, fullName, orderByComparator);
	}

	/**
	 * Returns the first account in the ordered set where groupId = &#63; and fullName LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account, or <code>null</code> if a matching account could not be found
	 */
	public static Account fetchByGN_First(
		long groupId, String fullName,
		OrderByComparator<Account> orderByComparator) {

		return getPersistence().fetchByGN_First(
			groupId, fullName, orderByComparator);
	}

	/**
	 * Returns the last account in the ordered set where groupId = &#63; and fullName LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	public static Account findByGN_Last(
			long groupId, String fullName,
			OrderByComparator<Account> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchAccountException {

		return getPersistence().findByGN_Last(
			groupId, fullName, orderByComparator);
	}

	/**
	 * Returns the last account in the ordered set where groupId = &#63; and fullName LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account, or <code>null</code> if a matching account could not be found
	 */
	public static Account fetchByGN_Last(
		long groupId, String fullName,
		OrderByComparator<Account> orderByComparator) {

		return getPersistence().fetchByGN_Last(
			groupId, fullName, orderByComparator);
	}

	/**
	 * Returns the accounts before and after the current account in the ordered set where groupId = &#63; and fullName LIKE &#63;.
	 *
	 * @param accountId the primary key of the current account
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next account
	 * @throws NoSuchAccountException if a account with the primary key could not be found
	 */
	public static Account[] findByGN_PrevAndNext(
			long accountId, long groupId, String fullName,
			OrderByComparator<Account> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchAccountException {

		return getPersistence().findByGN_PrevAndNext(
			accountId, groupId, fullName, orderByComparator);
	}

	/**
	 * Removes all the accounts where groupId = &#63; and fullName LIKE &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 */
	public static void removeByGN(long groupId, String fullName) {
		getPersistence().removeByGN(groupId, fullName);
	}

	/**
	 * Returns the number of accounts where groupId = &#63; and fullName LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @return the number of matching accounts
	 */
	public static int countByGN(long groupId, String fullName) {
		return getPersistence().countByGN(groupId, fullName);
	}

	/**
	 * Returns all the accounts where groupId = &#63; and fullName LIKE &#63; and accountStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param accountStatus the account status
	 * @return the matching accounts
	 */
	public static List<Account> findByGNS(
		long groupId, String fullName, int accountStatus) {

		return getPersistence().findByGNS(groupId, fullName, accountStatus);
	}

	/**
	 * Returns a range of all the accounts where groupId = &#63; and fullName LIKE &#63; and accountStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AccountModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param accountStatus the account status
	 * @param start the lower bound of the range of accounts
	 * @param end the upper bound of the range of accounts (not inclusive)
	 * @return the range of matching accounts
	 */
	public static List<Account> findByGNS(
		long groupId, String fullName, int accountStatus, int start, int end) {

		return getPersistence().findByGNS(
			groupId, fullName, accountStatus, start, end);
	}

	/**
	 * Returns an ordered range of all the accounts where groupId = &#63; and fullName LIKE &#63; and accountStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AccountModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param accountStatus the account status
	 * @param start the lower bound of the range of accounts
	 * @param end the upper bound of the range of accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching accounts
	 */
	public static List<Account> findByGNS(
		long groupId, String fullName, int accountStatus, int start, int end,
		OrderByComparator<Account> orderByComparator) {

		return getPersistence().findByGNS(
			groupId, fullName, accountStatus, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the accounts where groupId = &#63; and fullName LIKE &#63; and accountStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AccountModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param accountStatus the account status
	 * @param start the lower bound of the range of accounts
	 * @param end the upper bound of the range of accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching accounts
	 */
	public static List<Account> findByGNS(
		long groupId, String fullName, int accountStatus, int start, int end,
		OrderByComparator<Account> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByGNS(
			groupId, fullName, accountStatus, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	 * Returns the first account in the ordered set where groupId = &#63; and fullName LIKE &#63; and accountStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param accountStatus the account status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	public static Account findByGNS_First(
			long groupId, String fullName, int accountStatus,
			OrderByComparator<Account> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchAccountException {

		return getPersistence().findByGNS_First(
			groupId, fullName, accountStatus, orderByComparator);
	}

	/**
	 * Returns the first account in the ordered set where groupId = &#63; and fullName LIKE &#63; and accountStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param accountStatus the account status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account, or <code>null</code> if a matching account could not be found
	 */
	public static Account fetchByGNS_First(
		long groupId, String fullName, int accountStatus,
		OrderByComparator<Account> orderByComparator) {

		return getPersistence().fetchByGNS_First(
			groupId, fullName, accountStatus, orderByComparator);
	}

	/**
	 * Returns the last account in the ordered set where groupId = &#63; and fullName LIKE &#63; and accountStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param accountStatus the account status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	public static Account findByGNS_Last(
			long groupId, String fullName, int accountStatus,
			OrderByComparator<Account> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchAccountException {

		return getPersistence().findByGNS_Last(
			groupId, fullName, accountStatus, orderByComparator);
	}

	/**
	 * Returns the last account in the ordered set where groupId = &#63; and fullName LIKE &#63; and accountStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param accountStatus the account status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account, or <code>null</code> if a matching account could not be found
	 */
	public static Account fetchByGNS_Last(
		long groupId, String fullName, int accountStatus,
		OrderByComparator<Account> orderByComparator) {

		return getPersistence().fetchByGNS_Last(
			groupId, fullName, accountStatus, orderByComparator);
	}

	/**
	 * Returns the accounts before and after the current account in the ordered set where groupId = &#63; and fullName LIKE &#63; and accountStatus = &#63;.
	 *
	 * @param accountId the primary key of the current account
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param accountStatus the account status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next account
	 * @throws NoSuchAccountException if a account with the primary key could not be found
	 */
	public static Account[] findByGNS_PrevAndNext(
			long accountId, long groupId, String fullName, int accountStatus,
			OrderByComparator<Account> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchAccountException {

		return getPersistence().findByGNS_PrevAndNext(
			accountId, groupId, fullName, accountStatus, orderByComparator);
	}

	/**
	 * Removes all the accounts where groupId = &#63; and fullName LIKE &#63; and accountStatus = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param accountStatus the account status
	 */
	public static void removeByGNS(
		long groupId, String fullName, int accountStatus) {

		getPersistence().removeByGNS(groupId, fullName, accountStatus);
	}

	/**
	 * Returns the number of accounts where groupId = &#63; and fullName LIKE &#63; and accountStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param accountStatus the account status
	 * @return the number of matching accounts
	 */
	public static int countByGNS(
		long groupId, String fullName, int accountStatus) {

		return getPersistence().countByGNS(groupId, fullName, accountStatus);
	}

	/**
	 * Returns the account where personalId = &#63; or throws a <code>NoSuchAccountException</code> if it could not be found.
	 *
	 * @param personalId the personal ID
	 * @return the matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	public static Account findByPersonalId(String personalId)
		throws dtt.vn.vnpost.exception.NoSuchAccountException {

		return getPersistence().findByPersonalId(personalId);
	}

	/**
	 * Returns the account where personalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param personalId the personal ID
	 * @return the matching account, or <code>null</code> if a matching account could not be found
	 */
	public static Account fetchByPersonalId(String personalId) {
		return getPersistence().fetchByPersonalId(personalId);
	}

	/**
	 * Returns the account where personalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param personalId the personal ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching account, or <code>null</code> if a matching account could not be found
	 */
	public static Account fetchByPersonalId(
		String personalId, boolean retrieveFromCache) {

		return getPersistence().fetchByPersonalId(
			personalId, retrieveFromCache);
	}

	/**
	 * Removes the account where personalId = &#63; from the database.
	 *
	 * @param personalId the personal ID
	 * @return the account that was removed
	 */
	public static Account removeByPersonalId(String personalId)
		throws dtt.vn.vnpost.exception.NoSuchAccountException {

		return getPersistence().removeByPersonalId(personalId);
	}

	/**
	 * Returns the number of accounts where personalId = &#63;.
	 *
	 * @param personalId the personal ID
	 * @return the number of matching accounts
	 */
	public static int countByPersonalId(String personalId) {
		return getPersistence().countByPersonalId(personalId);
	}

	/**
	 * Returns the account where userId = &#63; or throws a <code>NoSuchAccountException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	public static Account findByuserId(long userId)
		throws dtt.vn.vnpost.exception.NoSuchAccountException {

		return getPersistence().findByuserId(userId);
	}

	/**
	 * Returns the account where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching account, or <code>null</code> if a matching account could not be found
	 */
	public static Account fetchByuserId(long userId) {
		return getPersistence().fetchByuserId(userId);
	}

	/**
	 * Returns the account where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching account, or <code>null</code> if a matching account could not be found
	 */
	public static Account fetchByuserId(
		long userId, boolean retrieveFromCache) {

		return getPersistence().fetchByuserId(userId, retrieveFromCache);
	}

	/**
	 * Removes the account where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the account that was removed
	 */
	public static Account removeByuserId(long userId)
		throws dtt.vn.vnpost.exception.NoSuchAccountException {

		return getPersistence().removeByuserId(userId);
	}

	/**
	 * Returns the number of accounts where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching accounts
	 */
	public static int countByuserId(long userId) {
		return getPersistence().countByuserId(userId);
	}

	/**
	 * Returns the account where accountName = &#63; or throws a <code>NoSuchAccountException</code> if it could not be found.
	 *
	 * @param accountName the account name
	 * @return the matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	public static Account findByaccountName(String accountName)
		throws dtt.vn.vnpost.exception.NoSuchAccountException {

		return getPersistence().findByaccountName(accountName);
	}

	/**
	 * Returns the account where accountName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param accountName the account name
	 * @return the matching account, or <code>null</code> if a matching account could not be found
	 */
	public static Account fetchByaccountName(String accountName) {
		return getPersistence().fetchByaccountName(accountName);
	}

	/**
	 * Returns the account where accountName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param accountName the account name
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching account, or <code>null</code> if a matching account could not be found
	 */
	public static Account fetchByaccountName(
		String accountName, boolean retrieveFromCache) {

		return getPersistence().fetchByaccountName(
			accountName, retrieveFromCache);
	}

	/**
	 * Removes the account where accountName = &#63; from the database.
	 *
	 * @param accountName the account name
	 * @return the account that was removed
	 */
	public static Account removeByaccountName(String accountName)
		throws dtt.vn.vnpost.exception.NoSuchAccountException {

		return getPersistence().removeByaccountName(accountName);
	}

	/**
	 * Returns the number of accounts where accountName = &#63;.
	 *
	 * @param accountName the account name
	 * @return the number of matching accounts
	 */
	public static int countByaccountName(String accountName) {
		return getPersistence().countByaccountName(accountName);
	}

	/**
	 * Returns the account where hoSoId = &#63; or throws a <code>NoSuchAccountException</code> if it could not be found.
	 *
	 * @param hoSoId the ho so ID
	 * @return the matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	public static Account findByHoSoId(long hoSoId)
		throws dtt.vn.vnpost.exception.NoSuchAccountException {

		return getPersistence().findByHoSoId(hoSoId);
	}

	/**
	 * Returns the account where hoSoId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param hoSoId the ho so ID
	 * @return the matching account, or <code>null</code> if a matching account could not be found
	 */
	public static Account fetchByHoSoId(long hoSoId) {
		return getPersistence().fetchByHoSoId(hoSoId);
	}

	/**
	 * Returns the account where hoSoId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param hoSoId the ho so ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching account, or <code>null</code> if a matching account could not be found
	 */
	public static Account fetchByHoSoId(
		long hoSoId, boolean retrieveFromCache) {

		return getPersistence().fetchByHoSoId(hoSoId, retrieveFromCache);
	}

	/**
	 * Removes the account where hoSoId = &#63; from the database.
	 *
	 * @param hoSoId the ho so ID
	 * @return the account that was removed
	 */
	public static Account removeByHoSoId(long hoSoId)
		throws dtt.vn.vnpost.exception.NoSuchAccountException {

		return getPersistence().removeByHoSoId(hoSoId);
	}

	/**
	 * Returns the number of accounts where hoSoId = &#63;.
	 *
	 * @param hoSoId the ho so ID
	 * @return the number of matching accounts
	 */
	public static int countByHoSoId(long hoSoId) {
		return getPersistence().countByHoSoId(hoSoId);
	}

	/**
	 * Returns all the accounts where accountStatus = &#63;.
	 *
	 * @param accountStatus the account status
	 * @return the matching accounts
	 */
	public static List<Account> findByStatus(int accountStatus) {
		return getPersistence().findByStatus(accountStatus);
	}

	/**
	 * Returns a range of all the accounts where accountStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AccountModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param accountStatus the account status
	 * @param start the lower bound of the range of accounts
	 * @param end the upper bound of the range of accounts (not inclusive)
	 * @return the range of matching accounts
	 */
	public static List<Account> findByStatus(
		int accountStatus, int start, int end) {

		return getPersistence().findByStatus(accountStatus, start, end);
	}

	/**
	 * Returns an ordered range of all the accounts where accountStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AccountModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param accountStatus the account status
	 * @param start the lower bound of the range of accounts
	 * @param end the upper bound of the range of accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching accounts
	 */
	public static List<Account> findByStatus(
		int accountStatus, int start, int end,
		OrderByComparator<Account> orderByComparator) {

		return getPersistence().findByStatus(
			accountStatus, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the accounts where accountStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AccountModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param accountStatus the account status
	 * @param start the lower bound of the range of accounts
	 * @param end the upper bound of the range of accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching accounts
	 */
	public static List<Account> findByStatus(
		int accountStatus, int start, int end,
		OrderByComparator<Account> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByStatus(
			accountStatus, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first account in the ordered set where accountStatus = &#63;.
	 *
	 * @param accountStatus the account status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	public static Account findByStatus_First(
			int accountStatus, OrderByComparator<Account> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchAccountException {

		return getPersistence().findByStatus_First(
			accountStatus, orderByComparator);
	}

	/**
	 * Returns the first account in the ordered set where accountStatus = &#63;.
	 *
	 * @param accountStatus the account status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account, or <code>null</code> if a matching account could not be found
	 */
	public static Account fetchByStatus_First(
		int accountStatus, OrderByComparator<Account> orderByComparator) {

		return getPersistence().fetchByStatus_First(
			accountStatus, orderByComparator);
	}

	/**
	 * Returns the last account in the ordered set where accountStatus = &#63;.
	 *
	 * @param accountStatus the account status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	public static Account findByStatus_Last(
			int accountStatus, OrderByComparator<Account> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchAccountException {

		return getPersistence().findByStatus_Last(
			accountStatus, orderByComparator);
	}

	/**
	 * Returns the last account in the ordered set where accountStatus = &#63;.
	 *
	 * @param accountStatus the account status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account, or <code>null</code> if a matching account could not be found
	 */
	public static Account fetchByStatus_Last(
		int accountStatus, OrderByComparator<Account> orderByComparator) {

		return getPersistence().fetchByStatus_Last(
			accountStatus, orderByComparator);
	}

	/**
	 * Returns the accounts before and after the current account in the ordered set where accountStatus = &#63;.
	 *
	 * @param accountId the primary key of the current account
	 * @param accountStatus the account status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next account
	 * @throws NoSuchAccountException if a account with the primary key could not be found
	 */
	public static Account[] findByStatus_PrevAndNext(
			long accountId, int accountStatus,
			OrderByComparator<Account> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchAccountException {

		return getPersistence().findByStatus_PrevAndNext(
			accountId, accountStatus, orderByComparator);
	}

	/**
	 * Returns all the accounts where accountStatus = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AccountModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param accountStatuses the account statuses
	 * @return the matching accounts
	 */
	public static List<Account> findByStatus(int[] accountStatuses) {
		return getPersistence().findByStatus(accountStatuses);
	}

	/**
	 * Returns a range of all the accounts where accountStatus = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AccountModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param accountStatuses the account statuses
	 * @param start the lower bound of the range of accounts
	 * @param end the upper bound of the range of accounts (not inclusive)
	 * @return the range of matching accounts
	 */
	public static List<Account> findByStatus(
		int[] accountStatuses, int start, int end) {

		return getPersistence().findByStatus(accountStatuses, start, end);
	}

	/**
	 * Returns an ordered range of all the accounts where accountStatus = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AccountModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param accountStatuses the account statuses
	 * @param start the lower bound of the range of accounts
	 * @param end the upper bound of the range of accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching accounts
	 */
	public static List<Account> findByStatus(
		int[] accountStatuses, int start, int end,
		OrderByComparator<Account> orderByComparator) {

		return getPersistence().findByStatus(
			accountStatuses, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the accounts where accountStatus = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AccountModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param accountStatus the account status
	 * @param start the lower bound of the range of accounts
	 * @param end the upper bound of the range of accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching accounts
	 */
	public static List<Account> findByStatus(
		int[] accountStatuses, int start, int end,
		OrderByComparator<Account> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByStatus(
			accountStatuses, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the accounts where accountStatus = &#63; from the database.
	 *
	 * @param accountStatus the account status
	 */
	public static void removeByStatus(int accountStatus) {
		getPersistence().removeByStatus(accountStatus);
	}

	/**
	 * Returns the number of accounts where accountStatus = &#63;.
	 *
	 * @param accountStatus the account status
	 * @return the number of matching accounts
	 */
	public static int countByStatus(int accountStatus) {
		return getPersistence().countByStatus(accountStatus);
	}

	/**
	 * Returns the number of accounts where accountStatus = any &#63;.
	 *
	 * @param accountStatuses the account statuses
	 * @return the number of matching accounts
	 */
	public static int countByStatus(int[] accountStatuses) {
		return getPersistence().countByStatus(accountStatuses);
	}

	/**
	 * Caches the account in the entity cache if it is enabled.
	 *
	 * @param account the account
	 */
	public static void cacheResult(Account account) {
		getPersistence().cacheResult(account);
	}

	/**
	 * Caches the accounts in the entity cache if it is enabled.
	 *
	 * @param accounts the accounts
	 */
	public static void cacheResult(List<Account> accounts) {
		getPersistence().cacheResult(accounts);
	}

	/**
	 * Creates a new account with the primary key. Does not add the account to the database.
	 *
	 * @param accountId the primary key for the new account
	 * @return the new account
	 */
	public static Account create(long accountId) {
		return getPersistence().create(accountId);
	}

	/**
	 * Removes the account with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param accountId the primary key of the account
	 * @return the account that was removed
	 * @throws NoSuchAccountException if a account with the primary key could not be found
	 */
	public static Account remove(long accountId)
		throws dtt.vn.vnpost.exception.NoSuchAccountException {

		return getPersistence().remove(accountId);
	}

	public static Account updateImpl(Account account) {
		return getPersistence().updateImpl(account);
	}

	/**
	 * Returns the account with the primary key or throws a <code>NoSuchAccountException</code> if it could not be found.
	 *
	 * @param accountId the primary key of the account
	 * @return the account
	 * @throws NoSuchAccountException if a account with the primary key could not be found
	 */
	public static Account findByPrimaryKey(long accountId)
		throws dtt.vn.vnpost.exception.NoSuchAccountException {

		return getPersistence().findByPrimaryKey(accountId);
	}

	/**
	 * Returns the account with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param accountId the primary key of the account
	 * @return the account, or <code>null</code> if a account with the primary key could not be found
	 */
	public static Account fetchByPrimaryKey(long accountId) {
		return getPersistence().fetchByPrimaryKey(accountId);
	}

	/**
	 * Returns all the accounts.
	 *
	 * @return the accounts
	 */
	public static List<Account> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the accounts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AccountModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of accounts
	 * @param end the upper bound of the range of accounts (not inclusive)
	 * @return the range of accounts
	 */
	public static List<Account> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the accounts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AccountModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of accounts
	 * @param end the upper bound of the range of accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of accounts
	 */
	public static List<Account> findAll(
		int start, int end, OrderByComparator<Account> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the accounts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AccountModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of accounts
	 * @param end the upper bound of the range of accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of accounts
	 */
	public static List<Account> findAll(
		int start, int end, OrderByComparator<Account> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the accounts from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of accounts.
	 *
	 * @return the number of accounts
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AccountPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AccountPersistence, AccountPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AccountPersistence.class);

		ServiceTracker<AccountPersistence, AccountPersistence> serviceTracker =
			new ServiceTracker<AccountPersistence, AccountPersistence>(
				bundle.getBundleContext(), AccountPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}