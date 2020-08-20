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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import dtt.vn.user.service.exception.NoSuchAccountLogException;
import dtt.vn.user.service.model.AccountLog;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the account log service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nhanvienDTT
 * @see AccountLogUtil
 * @generated
 */
@ProviderType
public interface AccountLogPersistence extends BasePersistence<AccountLog> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AccountLogUtil} to access the account log persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, AccountLog> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the account logs where accountId = &#63;.
	 *
	 * @param accountId the account ID
	 * @return the matching account logs
	 */
	public java.util.List<AccountLog> findByAccount(long accountId);

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
	public java.util.List<AccountLog> findByAccount(
		long accountId, int start, int end);

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
	public java.util.List<AccountLog> findByAccount(
		long accountId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AccountLog>
			orderByComparator);

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
	public java.util.List<AccountLog> findByAccount(
		long accountId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AccountLog>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first account log in the ordered set where accountId = &#63;.
	 *
	 * @param accountId the account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account log
	 * @throws NoSuchAccountLogException if a matching account log could not be found
	 */
	public AccountLog findByAccount_First(
			long accountId,
			com.liferay.portal.kernel.util.OrderByComparator<AccountLog>
				orderByComparator)
		throws NoSuchAccountLogException;

	/**
	 * Returns the first account log in the ordered set where accountId = &#63;.
	 *
	 * @param accountId the account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account log, or <code>null</code> if a matching account log could not be found
	 */
	public AccountLog fetchByAccount_First(
		long accountId,
		com.liferay.portal.kernel.util.OrderByComparator<AccountLog>
			orderByComparator);

	/**
	 * Returns the last account log in the ordered set where accountId = &#63;.
	 *
	 * @param accountId the account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account log
	 * @throws NoSuchAccountLogException if a matching account log could not be found
	 */
	public AccountLog findByAccount_Last(
			long accountId,
			com.liferay.portal.kernel.util.OrderByComparator<AccountLog>
				orderByComparator)
		throws NoSuchAccountLogException;

	/**
	 * Returns the last account log in the ordered set where accountId = &#63;.
	 *
	 * @param accountId the account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account log, or <code>null</code> if a matching account log could not be found
	 */
	public AccountLog fetchByAccount_Last(
		long accountId,
		com.liferay.portal.kernel.util.OrderByComparator<AccountLog>
			orderByComparator);

	/**
	 * Returns the account logs before and after the current account log in the ordered set where accountId = &#63;.
	 *
	 * @param id the primary key of the current account log
	 * @param accountId the account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next account log
	 * @throws NoSuchAccountLogException if a account log with the primary key could not be found
	 */
	public AccountLog[] findByAccount_PrevAndNext(
			long id, long accountId,
			com.liferay.portal.kernel.util.OrderByComparator<AccountLog>
				orderByComparator)
		throws NoSuchAccountLogException;

	/**
	 * Removes all the account logs where accountId = &#63; from the database.
	 *
	 * @param accountId the account ID
	 */
	public void removeByAccount(long accountId);

	/**
	 * Returns the number of account logs where accountId = &#63;.
	 *
	 * @param accountId the account ID
	 * @return the number of matching account logs
	 */
	public int countByAccount(long accountId);

	/**
	 * Caches the account log in the entity cache if it is enabled.
	 *
	 * @param accountLog the account log
	 */
	public void cacheResult(AccountLog accountLog);

	/**
	 * Caches the account logs in the entity cache if it is enabled.
	 *
	 * @param accountLogs the account logs
	 */
	public void cacheResult(java.util.List<AccountLog> accountLogs);

	/**
	 * Creates a new account log with the primary key. Does not add the account log to the database.
	 *
	 * @param id the primary key for the new account log
	 * @return the new account log
	 */
	public AccountLog create(long id);

	/**
	 * Removes the account log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the account log
	 * @return the account log that was removed
	 * @throws NoSuchAccountLogException if a account log with the primary key could not be found
	 */
	public AccountLog remove(long id) throws NoSuchAccountLogException;

	public AccountLog updateImpl(AccountLog accountLog);

	/**
	 * Returns the account log with the primary key or throws a <code>NoSuchAccountLogException</code> if it could not be found.
	 *
	 * @param id the primary key of the account log
	 * @return the account log
	 * @throws NoSuchAccountLogException if a account log with the primary key could not be found
	 */
	public AccountLog findByPrimaryKey(long id)
		throws NoSuchAccountLogException;

	/**
	 * Returns the account log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the account log
	 * @return the account log, or <code>null</code> if a account log with the primary key could not be found
	 */
	public AccountLog fetchByPrimaryKey(long id);

	/**
	 * Returns all the account logs.
	 *
	 * @return the account logs
	 */
	public java.util.List<AccountLog> findAll();

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
	public java.util.List<AccountLog> findAll(int start, int end);

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
	public java.util.List<AccountLog> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AccountLog>
			orderByComparator);

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
	public java.util.List<AccountLog> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AccountLog>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the account logs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of account logs.
	 *
	 * @return the number of account logs
	 */
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();

}