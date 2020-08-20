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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import dtt.vn.vnpost.exception.NoSuchAccountException;
import dtt.vn.vnpost.model.Account;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the account service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AccountUtil
 * @generated
 */
@ProviderType
public interface AccountPersistence extends BasePersistence<Account> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AccountUtil} to access the account persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, Account> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the accounts where accountType = &#63;.
	 *
	 * @param accountType the account type
	 * @return the matching accounts
	 */
	public java.util.List<Account> findByaccountType(int accountType);

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
	public java.util.List<Account> findByaccountType(
		int accountType, int start, int end);

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
	public java.util.List<Account> findByaccountType(
		int accountType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator);

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
	public java.util.List<Account> findByaccountType(
		int accountType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first account in the ordered set where accountType = &#63;.
	 *
	 * @param accountType the account type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	public Account findByaccountType_First(
			int accountType,
			com.liferay.portal.kernel.util.OrderByComparator<Account>
				orderByComparator)
		throws NoSuchAccountException;

	/**
	 * Returns the first account in the ordered set where accountType = &#63;.
	 *
	 * @param accountType the account type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account, or <code>null</code> if a matching account could not be found
	 */
	public Account fetchByaccountType_First(
		int accountType,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator);

	/**
	 * Returns the last account in the ordered set where accountType = &#63;.
	 *
	 * @param accountType the account type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	public Account findByaccountType_Last(
			int accountType,
			com.liferay.portal.kernel.util.OrderByComparator<Account>
				orderByComparator)
		throws NoSuchAccountException;

	/**
	 * Returns the last account in the ordered set where accountType = &#63;.
	 *
	 * @param accountType the account type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account, or <code>null</code> if a matching account could not be found
	 */
	public Account fetchByaccountType_Last(
		int accountType,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator);

	/**
	 * Returns the accounts before and after the current account in the ordered set where accountType = &#63;.
	 *
	 * @param accountId the primary key of the current account
	 * @param accountType the account type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next account
	 * @throws NoSuchAccountException if a account with the primary key could not be found
	 */
	public Account[] findByaccountType_PrevAndNext(
			long accountId, int accountType,
			com.liferay.portal.kernel.util.OrderByComparator<Account>
				orderByComparator)
		throws NoSuchAccountException;

	/**
	 * Removes all the accounts where accountType = &#63; from the database.
	 *
	 * @param accountType the account type
	 */
	public void removeByaccountType(int accountType);

	/**
	 * Returns the number of accounts where accountType = &#63;.
	 *
	 * @param accountType the account type
	 * @return the number of matching accounts
	 */
	public int countByaccountType(int accountType);

	/**
	 * Returns all the accounts where telNo = &#63;.
	 *
	 * @param telNo the tel no
	 * @return the matching accounts
	 */
	public java.util.List<Account> findByphone(String telNo);

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
	public java.util.List<Account> findByphone(
		String telNo, int start, int end);

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
	public java.util.List<Account> findByphone(
		String telNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator);

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
	public java.util.List<Account> findByphone(
		String telNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first account in the ordered set where telNo = &#63;.
	 *
	 * @param telNo the tel no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	public Account findByphone_First(
			String telNo,
			com.liferay.portal.kernel.util.OrderByComparator<Account>
				orderByComparator)
		throws NoSuchAccountException;

	/**
	 * Returns the first account in the ordered set where telNo = &#63;.
	 *
	 * @param telNo the tel no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account, or <code>null</code> if a matching account could not be found
	 */
	public Account fetchByphone_First(
		String telNo,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator);

	/**
	 * Returns the last account in the ordered set where telNo = &#63;.
	 *
	 * @param telNo the tel no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	public Account findByphone_Last(
			String telNo,
			com.liferay.portal.kernel.util.OrderByComparator<Account>
				orderByComparator)
		throws NoSuchAccountException;

	/**
	 * Returns the last account in the ordered set where telNo = &#63;.
	 *
	 * @param telNo the tel no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account, or <code>null</code> if a matching account could not be found
	 */
	public Account fetchByphone_Last(
		String telNo,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator);

	/**
	 * Returns the accounts before and after the current account in the ordered set where telNo = &#63;.
	 *
	 * @param accountId the primary key of the current account
	 * @param telNo the tel no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next account
	 * @throws NoSuchAccountException if a account with the primary key could not be found
	 */
	public Account[] findByphone_PrevAndNext(
			long accountId, String telNo,
			com.liferay.portal.kernel.util.OrderByComparator<Account>
				orderByComparator)
		throws NoSuchAccountException;

	/**
	 * Removes all the accounts where telNo = &#63; from the database.
	 *
	 * @param telNo the tel no
	 */
	public void removeByphone(String telNo);

	/**
	 * Returns the number of accounts where telNo = &#63;.
	 *
	 * @param telNo the tel no
	 * @return the number of matching accounts
	 */
	public int countByphone(String telNo);

	/**
	 * Returns all the accounts where taxCode = &#63;.
	 *
	 * @param taxCode the tax code
	 * @return the matching accounts
	 */
	public java.util.List<Account> findBymst(String taxCode);

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
	public java.util.List<Account> findBymst(
		String taxCode, int start, int end);

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
	public java.util.List<Account> findBymst(
		String taxCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator);

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
	public java.util.List<Account> findBymst(
		String taxCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first account in the ordered set where taxCode = &#63;.
	 *
	 * @param taxCode the tax code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	public Account findBymst_First(
			String taxCode,
			com.liferay.portal.kernel.util.OrderByComparator<Account>
				orderByComparator)
		throws NoSuchAccountException;

	/**
	 * Returns the first account in the ordered set where taxCode = &#63;.
	 *
	 * @param taxCode the tax code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account, or <code>null</code> if a matching account could not be found
	 */
	public Account fetchBymst_First(
		String taxCode,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator);

	/**
	 * Returns the last account in the ordered set where taxCode = &#63;.
	 *
	 * @param taxCode the tax code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	public Account findBymst_Last(
			String taxCode,
			com.liferay.portal.kernel.util.OrderByComparator<Account>
				orderByComparator)
		throws NoSuchAccountException;

	/**
	 * Returns the last account in the ordered set where taxCode = &#63;.
	 *
	 * @param taxCode the tax code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account, or <code>null</code> if a matching account could not be found
	 */
	public Account fetchBymst_Last(
		String taxCode,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator);

	/**
	 * Returns the accounts before and after the current account in the ordered set where taxCode = &#63;.
	 *
	 * @param accountId the primary key of the current account
	 * @param taxCode the tax code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next account
	 * @throws NoSuchAccountException if a account with the primary key could not be found
	 */
	public Account[] findBymst_PrevAndNext(
			long accountId, String taxCode,
			com.liferay.portal.kernel.util.OrderByComparator<Account>
				orderByComparator)
		throws NoSuchAccountException;

	/**
	 * Removes all the accounts where taxCode = &#63; from the database.
	 *
	 * @param taxCode the tax code
	 */
	public void removeBymst(String taxCode);

	/**
	 * Returns the number of accounts where taxCode = &#63;.
	 *
	 * @param taxCode the tax code
	 * @return the number of matching accounts
	 */
	public int countBymst(String taxCode);

	/**
	 * Returns all the accounts where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching accounts
	 */
	public java.util.List<Account> findByGroupId(long groupId);

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
	public java.util.List<Account> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<Account> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator);

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
	public java.util.List<Account> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first account in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	public Account findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Account>
				orderByComparator)
		throws NoSuchAccountException;

	/**
	 * Returns the first account in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account, or <code>null</code> if a matching account could not be found
	 */
	public Account fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator);

	/**
	 * Returns the last account in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	public Account findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Account>
				orderByComparator)
		throws NoSuchAccountException;

	/**
	 * Returns the last account in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account, or <code>null</code> if a matching account could not be found
	 */
	public Account fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator);

	/**
	 * Returns the accounts before and after the current account in the ordered set where groupId = &#63;.
	 *
	 * @param accountId the primary key of the current account
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next account
	 * @throws NoSuchAccountException if a account with the primary key could not be found
	 */
	public Account[] findByGroupId_PrevAndNext(
			long accountId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Account>
				orderByComparator)
		throws NoSuchAccountException;

	/**
	 * Removes all the accounts where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of accounts where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching accounts
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns all the accounts where groupId = &#63; and accountStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @return the matching accounts
	 */
	public java.util.List<Account> findByGS(long groupId, int accountStatus);

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
	public java.util.List<Account> findByGS(
		long groupId, int accountStatus, int start, int end);

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
	public java.util.List<Account> findByGS(
		long groupId, int accountStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator);

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
	public java.util.List<Account> findByGS(
		long groupId, int accountStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first account in the ordered set where groupId = &#63; and accountStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	public Account findByGS_First(
			long groupId, int accountStatus,
			com.liferay.portal.kernel.util.OrderByComparator<Account>
				orderByComparator)
		throws NoSuchAccountException;

	/**
	 * Returns the first account in the ordered set where groupId = &#63; and accountStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account, or <code>null</code> if a matching account could not be found
	 */
	public Account fetchByGS_First(
		long groupId, int accountStatus,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator);

	/**
	 * Returns the last account in the ordered set where groupId = &#63; and accountStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	public Account findByGS_Last(
			long groupId, int accountStatus,
			com.liferay.portal.kernel.util.OrderByComparator<Account>
				orderByComparator)
		throws NoSuchAccountException;

	/**
	 * Returns the last account in the ordered set where groupId = &#63; and accountStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account, or <code>null</code> if a matching account could not be found
	 */
	public Account fetchByGS_Last(
		long groupId, int accountStatus,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator);

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
	public Account[] findByGS_PrevAndNext(
			long accountId, long groupId, int accountStatus,
			com.liferay.portal.kernel.util.OrderByComparator<Account>
				orderByComparator)
		throws NoSuchAccountException;

	/**
	 * Removes all the accounts where groupId = &#63; and accountStatus = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 */
	public void removeByGS(long groupId, int accountStatus);

	/**
	 * Returns the number of accounts where groupId = &#63; and accountStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @return the number of matching accounts
	 */
	public int countByGS(long groupId, int accountStatus);

	/**
	 * Returns all the accounts where groupId = &#63; and accountStatus = &#63; and cityCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param cityCode the city code
	 * @return the matching accounts
	 */
	public java.util.List<Account> findByGSC(
		long groupId, int accountStatus, String cityCode);

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
	public java.util.List<Account> findByGSC(
		long groupId, int accountStatus, String cityCode, int start, int end);

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
	public java.util.List<Account> findByGSC(
		long groupId, int accountStatus, String cityCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator);

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
	public java.util.List<Account> findByGSC(
		long groupId, int accountStatus, String cityCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator,
		boolean retrieveFromCache);

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
	public Account findByGSC_First(
			long groupId, int accountStatus, String cityCode,
			com.liferay.portal.kernel.util.OrderByComparator<Account>
				orderByComparator)
		throws NoSuchAccountException;

	/**
	 * Returns the first account in the ordered set where groupId = &#63; and accountStatus = &#63; and cityCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param cityCode the city code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account, or <code>null</code> if a matching account could not be found
	 */
	public Account fetchByGSC_First(
		long groupId, int accountStatus, String cityCode,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator);

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
	public Account findByGSC_Last(
			long groupId, int accountStatus, String cityCode,
			com.liferay.portal.kernel.util.OrderByComparator<Account>
				orderByComparator)
		throws NoSuchAccountException;

	/**
	 * Returns the last account in the ordered set where groupId = &#63; and accountStatus = &#63; and cityCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param cityCode the city code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account, or <code>null</code> if a matching account could not be found
	 */
	public Account fetchByGSC_Last(
		long groupId, int accountStatus, String cityCode,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator);

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
	public Account[] findByGSC_PrevAndNext(
			long accountId, long groupId, int accountStatus, String cityCode,
			com.liferay.portal.kernel.util.OrderByComparator<Account>
				orderByComparator)
		throws NoSuchAccountException;

	/**
	 * Removes all the accounts where groupId = &#63; and accountStatus = &#63; and cityCode = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param cityCode the city code
	 */
	public void removeByGSC(long groupId, int accountStatus, String cityCode);

	/**
	 * Returns the number of accounts where groupId = &#63; and accountStatus = &#63; and cityCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param cityCode the city code
	 * @return the number of matching accounts
	 */
	public int countByGSC(long groupId, int accountStatus, String cityCode);

	/**
	 * Returns all the accounts where groupId = &#63; and accountStatus = &#63; and districtCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param districtCode the district code
	 * @return the matching accounts
	 */
	public java.util.List<Account> findByGSD(
		long groupId, int accountStatus, String districtCode);

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
	public java.util.List<Account> findByGSD(
		long groupId, int accountStatus, String districtCode, int start,
		int end);

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
	public java.util.List<Account> findByGSD(
		long groupId, int accountStatus, String districtCode, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator);

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
	public java.util.List<Account> findByGSD(
		long groupId, int accountStatus, String districtCode, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator,
		boolean retrieveFromCache);

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
	public Account findByGSD_First(
			long groupId, int accountStatus, String districtCode,
			com.liferay.portal.kernel.util.OrderByComparator<Account>
				orderByComparator)
		throws NoSuchAccountException;

	/**
	 * Returns the first account in the ordered set where groupId = &#63; and accountStatus = &#63; and districtCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param districtCode the district code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account, or <code>null</code> if a matching account could not be found
	 */
	public Account fetchByGSD_First(
		long groupId, int accountStatus, String districtCode,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator);

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
	public Account findByGSD_Last(
			long groupId, int accountStatus, String districtCode,
			com.liferay.portal.kernel.util.OrderByComparator<Account>
				orderByComparator)
		throws NoSuchAccountException;

	/**
	 * Returns the last account in the ordered set where groupId = &#63; and accountStatus = &#63; and districtCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param districtCode the district code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account, or <code>null</code> if a matching account could not be found
	 */
	public Account fetchByGSD_Last(
		long groupId, int accountStatus, String districtCode,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator);

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
	public Account[] findByGSD_PrevAndNext(
			long accountId, long groupId, int accountStatus,
			String districtCode,
			com.liferay.portal.kernel.util.OrderByComparator<Account>
				orderByComparator)
		throws NoSuchAccountException;

	/**
	 * Removes all the accounts where groupId = &#63; and accountStatus = &#63; and districtCode = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param districtCode the district code
	 */
	public void removeByGSD(
		long groupId, int accountStatus, String districtCode);

	/**
	 * Returns the number of accounts where groupId = &#63; and accountStatus = &#63; and districtCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param districtCode the district code
	 * @return the number of matching accounts
	 */
	public int countByGSD(long groupId, int accountStatus, String districtCode);

	/**
	 * Returns all the accounts where groupId = &#63; and accountStatus = &#63; and wardCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param wardCode the ward code
	 * @return the matching accounts
	 */
	public java.util.List<Account> findByGSW(
		long groupId, int accountStatus, String wardCode);

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
	public java.util.List<Account> findByGSW(
		long groupId, int accountStatus, String wardCode, int start, int end);

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
	public java.util.List<Account> findByGSW(
		long groupId, int accountStatus, String wardCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator);

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
	public java.util.List<Account> findByGSW(
		long groupId, int accountStatus, String wardCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator,
		boolean retrieveFromCache);

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
	public Account findByGSW_First(
			long groupId, int accountStatus, String wardCode,
			com.liferay.portal.kernel.util.OrderByComparator<Account>
				orderByComparator)
		throws NoSuchAccountException;

	/**
	 * Returns the first account in the ordered set where groupId = &#63; and accountStatus = &#63; and wardCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param wardCode the ward code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account, or <code>null</code> if a matching account could not be found
	 */
	public Account fetchByGSW_First(
		long groupId, int accountStatus, String wardCode,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator);

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
	public Account findByGSW_Last(
			long groupId, int accountStatus, String wardCode,
			com.liferay.portal.kernel.util.OrderByComparator<Account>
				orderByComparator)
		throws NoSuchAccountException;

	/**
	 * Returns the last account in the ordered set where groupId = &#63; and accountStatus = &#63; and wardCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param wardCode the ward code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account, or <code>null</code> if a matching account could not be found
	 */
	public Account fetchByGSW_Last(
		long groupId, int accountStatus, String wardCode,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator);

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
	public Account[] findByGSW_PrevAndNext(
			long accountId, long groupId, int accountStatus, String wardCode,
			com.liferay.portal.kernel.util.OrderByComparator<Account>
				orderByComparator)
		throws NoSuchAccountException;

	/**
	 * Removes all the accounts where groupId = &#63; and accountStatus = &#63; and wardCode = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param wardCode the ward code
	 */
	public void removeByGSW(long groupId, int accountStatus, String wardCode);

	/**
	 * Returns the number of accounts where groupId = &#63; and accountStatus = &#63; and wardCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param wardCode the ward code
	 * @return the number of matching accounts
	 */
	public int countByGSW(long groupId, int accountStatus, String wardCode);

	/**
	 * Returns the account where email = &#63; or throws a <code>NoSuchAccountException</code> if it could not be found.
	 *
	 * @param email the email
	 * @return the matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	public Account findByEmail(String email) throws NoSuchAccountException;

	/**
	 * Returns the account where email = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param email the email
	 * @return the matching account, or <code>null</code> if a matching account could not be found
	 */
	public Account fetchByEmail(String email);

	/**
	 * Returns the account where email = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param email the email
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching account, or <code>null</code> if a matching account could not be found
	 */
	public Account fetchByEmail(String email, boolean retrieveFromCache);

	/**
	 * Removes the account where email = &#63; from the database.
	 *
	 * @param email the email
	 * @return the account that was removed
	 */
	public Account removeByEmail(String email) throws NoSuchAccountException;

	/**
	 * Returns the number of accounts where email = &#63;.
	 *
	 * @param email the email
	 * @return the number of matching accounts
	 */
	public int countByEmail(String email);

	/**
	 * Returns all the accounts where groupId = &#63; and fullName LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @return the matching accounts
	 */
	public java.util.List<Account> findByGN(long groupId, String fullName);

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
	public java.util.List<Account> findByGN(
		long groupId, String fullName, int start, int end);

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
	public java.util.List<Account> findByGN(
		long groupId, String fullName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator);

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
	public java.util.List<Account> findByGN(
		long groupId, String fullName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first account in the ordered set where groupId = &#63; and fullName LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	public Account findByGN_First(
			long groupId, String fullName,
			com.liferay.portal.kernel.util.OrderByComparator<Account>
				orderByComparator)
		throws NoSuchAccountException;

	/**
	 * Returns the first account in the ordered set where groupId = &#63; and fullName LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account, or <code>null</code> if a matching account could not be found
	 */
	public Account fetchByGN_First(
		long groupId, String fullName,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator);

	/**
	 * Returns the last account in the ordered set where groupId = &#63; and fullName LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	public Account findByGN_Last(
			long groupId, String fullName,
			com.liferay.portal.kernel.util.OrderByComparator<Account>
				orderByComparator)
		throws NoSuchAccountException;

	/**
	 * Returns the last account in the ordered set where groupId = &#63; and fullName LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account, or <code>null</code> if a matching account could not be found
	 */
	public Account fetchByGN_Last(
		long groupId, String fullName,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator);

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
	public Account[] findByGN_PrevAndNext(
			long accountId, long groupId, String fullName,
			com.liferay.portal.kernel.util.OrderByComparator<Account>
				orderByComparator)
		throws NoSuchAccountException;

	/**
	 * Removes all the accounts where groupId = &#63; and fullName LIKE &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 */
	public void removeByGN(long groupId, String fullName);

	/**
	 * Returns the number of accounts where groupId = &#63; and fullName LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @return the number of matching accounts
	 */
	public int countByGN(long groupId, String fullName);

	/**
	 * Returns all the accounts where groupId = &#63; and fullName LIKE &#63; and accountStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param accountStatus the account status
	 * @return the matching accounts
	 */
	public java.util.List<Account> findByGNS(
		long groupId, String fullName, int accountStatus);

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
	public java.util.List<Account> findByGNS(
		long groupId, String fullName, int accountStatus, int start, int end);

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
	public java.util.List<Account> findByGNS(
		long groupId, String fullName, int accountStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator);

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
	public java.util.List<Account> findByGNS(
		long groupId, String fullName, int accountStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator,
		boolean retrieveFromCache);

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
	public Account findByGNS_First(
			long groupId, String fullName, int accountStatus,
			com.liferay.portal.kernel.util.OrderByComparator<Account>
				orderByComparator)
		throws NoSuchAccountException;

	/**
	 * Returns the first account in the ordered set where groupId = &#63; and fullName LIKE &#63; and accountStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param accountStatus the account status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account, or <code>null</code> if a matching account could not be found
	 */
	public Account fetchByGNS_First(
		long groupId, String fullName, int accountStatus,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator);

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
	public Account findByGNS_Last(
			long groupId, String fullName, int accountStatus,
			com.liferay.portal.kernel.util.OrderByComparator<Account>
				orderByComparator)
		throws NoSuchAccountException;

	/**
	 * Returns the last account in the ordered set where groupId = &#63; and fullName LIKE &#63; and accountStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param accountStatus the account status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account, or <code>null</code> if a matching account could not be found
	 */
	public Account fetchByGNS_Last(
		long groupId, String fullName, int accountStatus,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator);

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
	public Account[] findByGNS_PrevAndNext(
			long accountId, long groupId, String fullName, int accountStatus,
			com.liferay.portal.kernel.util.OrderByComparator<Account>
				orderByComparator)
		throws NoSuchAccountException;

	/**
	 * Removes all the accounts where groupId = &#63; and fullName LIKE &#63; and accountStatus = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param accountStatus the account status
	 */
	public void removeByGNS(long groupId, String fullName, int accountStatus);

	/**
	 * Returns the number of accounts where groupId = &#63; and fullName LIKE &#63; and accountStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param accountStatus the account status
	 * @return the number of matching accounts
	 */
	public int countByGNS(long groupId, String fullName, int accountStatus);

	/**
	 * Returns the account where personalId = &#63; or throws a <code>NoSuchAccountException</code> if it could not be found.
	 *
	 * @param personalId the personal ID
	 * @return the matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	public Account findByPersonalId(String personalId)
		throws NoSuchAccountException;

	/**
	 * Returns the account where personalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param personalId the personal ID
	 * @return the matching account, or <code>null</code> if a matching account could not be found
	 */
	public Account fetchByPersonalId(String personalId);

	/**
	 * Returns the account where personalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param personalId the personal ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching account, or <code>null</code> if a matching account could not be found
	 */
	public Account fetchByPersonalId(
		String personalId, boolean retrieveFromCache);

	/**
	 * Removes the account where personalId = &#63; from the database.
	 *
	 * @param personalId the personal ID
	 * @return the account that was removed
	 */
	public Account removeByPersonalId(String personalId)
		throws NoSuchAccountException;

	/**
	 * Returns the number of accounts where personalId = &#63;.
	 *
	 * @param personalId the personal ID
	 * @return the number of matching accounts
	 */
	public int countByPersonalId(String personalId);

	/**
	 * Returns the account where userId = &#63; or throws a <code>NoSuchAccountException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	public Account findByuserId(long userId) throws NoSuchAccountException;

	/**
	 * Returns the account where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching account, or <code>null</code> if a matching account could not be found
	 */
	public Account fetchByuserId(long userId);

	/**
	 * Returns the account where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching account, or <code>null</code> if a matching account could not be found
	 */
	public Account fetchByuserId(long userId, boolean retrieveFromCache);

	/**
	 * Removes the account where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the account that was removed
	 */
	public Account removeByuserId(long userId) throws NoSuchAccountException;

	/**
	 * Returns the number of accounts where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching accounts
	 */
	public int countByuserId(long userId);

	/**
	 * Returns the account where accountName = &#63; or throws a <code>NoSuchAccountException</code> if it could not be found.
	 *
	 * @param accountName the account name
	 * @return the matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	public Account findByaccountName(String accountName)
		throws NoSuchAccountException;

	/**
	 * Returns the account where accountName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param accountName the account name
	 * @return the matching account, or <code>null</code> if a matching account could not be found
	 */
	public Account fetchByaccountName(String accountName);

	/**
	 * Returns the account where accountName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param accountName the account name
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching account, or <code>null</code> if a matching account could not be found
	 */
	public Account fetchByaccountName(
		String accountName, boolean retrieveFromCache);

	/**
	 * Removes the account where accountName = &#63; from the database.
	 *
	 * @param accountName the account name
	 * @return the account that was removed
	 */
	public Account removeByaccountName(String accountName)
		throws NoSuchAccountException;

	/**
	 * Returns the number of accounts where accountName = &#63;.
	 *
	 * @param accountName the account name
	 * @return the number of matching accounts
	 */
	public int countByaccountName(String accountName);

	/**
	 * Returns the account where hoSoId = &#63; or throws a <code>NoSuchAccountException</code> if it could not be found.
	 *
	 * @param hoSoId the ho so ID
	 * @return the matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	public Account findByHoSoId(long hoSoId) throws NoSuchAccountException;

	/**
	 * Returns the account where hoSoId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param hoSoId the ho so ID
	 * @return the matching account, or <code>null</code> if a matching account could not be found
	 */
	public Account fetchByHoSoId(long hoSoId);

	/**
	 * Returns the account where hoSoId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param hoSoId the ho so ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching account, or <code>null</code> if a matching account could not be found
	 */
	public Account fetchByHoSoId(long hoSoId, boolean retrieveFromCache);

	/**
	 * Removes the account where hoSoId = &#63; from the database.
	 *
	 * @param hoSoId the ho so ID
	 * @return the account that was removed
	 */
	public Account removeByHoSoId(long hoSoId) throws NoSuchAccountException;

	/**
	 * Returns the number of accounts where hoSoId = &#63;.
	 *
	 * @param hoSoId the ho so ID
	 * @return the number of matching accounts
	 */
	public int countByHoSoId(long hoSoId);

	/**
	 * Returns all the accounts where accountStatus = &#63;.
	 *
	 * @param accountStatus the account status
	 * @return the matching accounts
	 */
	public java.util.List<Account> findByStatus(int accountStatus);

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
	public java.util.List<Account> findByStatus(
		int accountStatus, int start, int end);

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
	public java.util.List<Account> findByStatus(
		int accountStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator);

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
	public java.util.List<Account> findByStatus(
		int accountStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first account in the ordered set where accountStatus = &#63;.
	 *
	 * @param accountStatus the account status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	public Account findByStatus_First(
			int accountStatus,
			com.liferay.portal.kernel.util.OrderByComparator<Account>
				orderByComparator)
		throws NoSuchAccountException;

	/**
	 * Returns the first account in the ordered set where accountStatus = &#63;.
	 *
	 * @param accountStatus the account status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account, or <code>null</code> if a matching account could not be found
	 */
	public Account fetchByStatus_First(
		int accountStatus,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator);

	/**
	 * Returns the last account in the ordered set where accountStatus = &#63;.
	 *
	 * @param accountStatus the account status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	public Account findByStatus_Last(
			int accountStatus,
			com.liferay.portal.kernel.util.OrderByComparator<Account>
				orderByComparator)
		throws NoSuchAccountException;

	/**
	 * Returns the last account in the ordered set where accountStatus = &#63;.
	 *
	 * @param accountStatus the account status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account, or <code>null</code> if a matching account could not be found
	 */
	public Account fetchByStatus_Last(
		int accountStatus,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator);

	/**
	 * Returns the accounts before and after the current account in the ordered set where accountStatus = &#63;.
	 *
	 * @param accountId the primary key of the current account
	 * @param accountStatus the account status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next account
	 * @throws NoSuchAccountException if a account with the primary key could not be found
	 */
	public Account[] findByStatus_PrevAndNext(
			long accountId, int accountStatus,
			com.liferay.portal.kernel.util.OrderByComparator<Account>
				orderByComparator)
		throws NoSuchAccountException;

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
	public java.util.List<Account> findByStatus(int[] accountStatuses);

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
	public java.util.List<Account> findByStatus(
		int[] accountStatuses, int start, int end);

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
	public java.util.List<Account> findByStatus(
		int[] accountStatuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator);

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
	public java.util.List<Account> findByStatus(
		int[] accountStatuses, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the accounts where accountStatus = &#63; from the database.
	 *
	 * @param accountStatus the account status
	 */
	public void removeByStatus(int accountStatus);

	/**
	 * Returns the number of accounts where accountStatus = &#63;.
	 *
	 * @param accountStatus the account status
	 * @return the number of matching accounts
	 */
	public int countByStatus(int accountStatus);

	/**
	 * Returns the number of accounts where accountStatus = any &#63;.
	 *
	 * @param accountStatuses the account statuses
	 * @return the number of matching accounts
	 */
	public int countByStatus(int[] accountStatuses);

	/**
	 * Caches the account in the entity cache if it is enabled.
	 *
	 * @param account the account
	 */
	public void cacheResult(Account account);

	/**
	 * Caches the accounts in the entity cache if it is enabled.
	 *
	 * @param accounts the accounts
	 */
	public void cacheResult(java.util.List<Account> accounts);

	/**
	 * Creates a new account with the primary key. Does not add the account to the database.
	 *
	 * @param accountId the primary key for the new account
	 * @return the new account
	 */
	public Account create(long accountId);

	/**
	 * Removes the account with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param accountId the primary key of the account
	 * @return the account that was removed
	 * @throws NoSuchAccountException if a account with the primary key could not be found
	 */
	public Account remove(long accountId) throws NoSuchAccountException;

	public Account updateImpl(Account account);

	/**
	 * Returns the account with the primary key or throws a <code>NoSuchAccountException</code> if it could not be found.
	 *
	 * @param accountId the primary key of the account
	 * @return the account
	 * @throws NoSuchAccountException if a account with the primary key could not be found
	 */
	public Account findByPrimaryKey(long accountId)
		throws NoSuchAccountException;

	/**
	 * Returns the account with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param accountId the primary key of the account
	 * @return the account, or <code>null</code> if a account with the primary key could not be found
	 */
	public Account fetchByPrimaryKey(long accountId);

	/**
	 * Returns all the accounts.
	 *
	 * @return the accounts
	 */
	public java.util.List<Account> findAll();

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
	public java.util.List<Account> findAll(int start, int end);

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
	public java.util.List<Account> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator);

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
	public java.util.List<Account> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the accounts from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of accounts.
	 *
	 * @return the number of accounts
	 */
	public int countAll();

}