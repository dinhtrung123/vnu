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

package dtt.vn.vnpost.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import dtt.vn.vnpost.exception.NoSuchAccountException;
import dtt.vn.vnpost.model.Account;
import dtt.vn.vnpost.model.impl.AccountImpl;
import dtt.vn.vnpost.model.impl.AccountModelImpl;
import dtt.vn.vnpost.service.persistence.AccountPersistence;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the account service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class AccountPersistenceImpl
	extends BasePersistenceImpl<Account> implements AccountPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AccountUtil</code> to access the account persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AccountImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByaccountType;
	private FinderPath _finderPathWithoutPaginationFindByaccountType;
	private FinderPath _finderPathCountByaccountType;

	/**
	 * Returns all the accounts where accountType = &#63;.
	 *
	 * @param accountType the account type
	 * @return the matching accounts
	 */
	@Override
	public List<Account> findByaccountType(int accountType) {
		return findByaccountType(
			accountType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Account> findByaccountType(
		int accountType, int start, int end) {

		return findByaccountType(accountType, start, end, null);
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
	@Override
	public List<Account> findByaccountType(
		int accountType, int start, int end,
		OrderByComparator<Account> orderByComparator) {

		return findByaccountType(
			accountType, start, end, orderByComparator, true);
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
	@Override
	public List<Account> findByaccountType(
		int accountType, int start, int end,
		OrderByComparator<Account> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByaccountType;
			finderArgs = new Object[] {accountType};
		}
		else {
			finderPath = _finderPathWithPaginationFindByaccountType;
			finderArgs = new Object[] {
				accountType, start, end, orderByComparator
			};
		}

		List<Account> list = null;

		if (retrieveFromCache) {
			list = (List<Account>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Account account : list) {
					if ((accountType != account.getAccountType())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_ACCOUNT_WHERE);

			query.append(_FINDER_COLUMN_ACCOUNTTYPE_ACCOUNTTYPE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(AccountModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(accountType);

				if (!pagination) {
					list = (List<Account>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Account>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first account in the ordered set where accountType = &#63;.
	 *
	 * @param accountType the account type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	@Override
	public Account findByaccountType_First(
			int accountType, OrderByComparator<Account> orderByComparator)
		throws NoSuchAccountException {

		Account account = fetchByaccountType_First(
			accountType, orderByComparator);

		if (account != null) {
			return account;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("accountType=");
		msg.append(accountType);

		msg.append("}");

		throw new NoSuchAccountException(msg.toString());
	}

	/**
	 * Returns the first account in the ordered set where accountType = &#63;.
	 *
	 * @param accountType the account type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account, or <code>null</code> if a matching account could not be found
	 */
	@Override
	public Account fetchByaccountType_First(
		int accountType, OrderByComparator<Account> orderByComparator) {

		List<Account> list = findByaccountType(
			accountType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last account in the ordered set where accountType = &#63;.
	 *
	 * @param accountType the account type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	@Override
	public Account findByaccountType_Last(
			int accountType, OrderByComparator<Account> orderByComparator)
		throws NoSuchAccountException {

		Account account = fetchByaccountType_Last(
			accountType, orderByComparator);

		if (account != null) {
			return account;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("accountType=");
		msg.append(accountType);

		msg.append("}");

		throw new NoSuchAccountException(msg.toString());
	}

	/**
	 * Returns the last account in the ordered set where accountType = &#63;.
	 *
	 * @param accountType the account type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account, or <code>null</code> if a matching account could not be found
	 */
	@Override
	public Account fetchByaccountType_Last(
		int accountType, OrderByComparator<Account> orderByComparator) {

		int count = countByaccountType(accountType);

		if (count == 0) {
			return null;
		}

		List<Account> list = findByaccountType(
			accountType, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Account[] findByaccountType_PrevAndNext(
			long accountId, int accountType,
			OrderByComparator<Account> orderByComparator)
		throws NoSuchAccountException {

		Account account = findByPrimaryKey(accountId);

		Session session = null;

		try {
			session = openSession();

			Account[] array = new AccountImpl[3];

			array[0] = getByaccountType_PrevAndNext(
				session, account, accountType, orderByComparator, true);

			array[1] = account;

			array[2] = getByaccountType_PrevAndNext(
				session, account, accountType, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Account getByaccountType_PrevAndNext(
		Session session, Account account, int accountType,
		OrderByComparator<Account> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ACCOUNT_WHERE);

		query.append(_FINDER_COLUMN_ACCOUNTTYPE_ACCOUNTTYPE_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(AccountModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(accountType);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(account)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Account> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the accounts where accountType = &#63; from the database.
	 *
	 * @param accountType the account type
	 */
	@Override
	public void removeByaccountType(int accountType) {
		for (Account account :
				findByaccountType(
					accountType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(account);
		}
	}

	/**
	 * Returns the number of accounts where accountType = &#63;.
	 *
	 * @param accountType the account type
	 * @return the number of matching accounts
	 */
	@Override
	public int countByaccountType(int accountType) {
		FinderPath finderPath = _finderPathCountByaccountType;

		Object[] finderArgs = new Object[] {accountType};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ACCOUNT_WHERE);

			query.append(_FINDER_COLUMN_ACCOUNTTYPE_ACCOUNTTYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(accountType);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ACCOUNTTYPE_ACCOUNTTYPE_2 =
		"account.accountType = ?";

	private FinderPath _finderPathWithPaginationFindByphone;
	private FinderPath _finderPathWithoutPaginationFindByphone;
	private FinderPath _finderPathCountByphone;

	/**
	 * Returns all the accounts where telNo = &#63;.
	 *
	 * @param telNo the tel no
	 * @return the matching accounts
	 */
	@Override
	public List<Account> findByphone(String telNo) {
		return findByphone(telNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Account> findByphone(String telNo, int start, int end) {
		return findByphone(telNo, start, end, null);
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
	@Override
	public List<Account> findByphone(
		String telNo, int start, int end,
		OrderByComparator<Account> orderByComparator) {

		return findByphone(telNo, start, end, orderByComparator, true);
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
	@Override
	public List<Account> findByphone(
		String telNo, int start, int end,
		OrderByComparator<Account> orderByComparator,
		boolean retrieveFromCache) {

		telNo = Objects.toString(telNo, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByphone;
			finderArgs = new Object[] {telNo};
		}
		else {
			finderPath = _finderPathWithPaginationFindByphone;
			finderArgs = new Object[] {telNo, start, end, orderByComparator};
		}

		List<Account> list = null;

		if (retrieveFromCache) {
			list = (List<Account>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Account account : list) {
					if (!telNo.equals(account.getTelNo())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_ACCOUNT_WHERE);

			boolean bindTelNo = false;

			if (telNo.isEmpty()) {
				query.append(_FINDER_COLUMN_PHONE_TELNO_3);
			}
			else {
				bindTelNo = true;

				query.append(_FINDER_COLUMN_PHONE_TELNO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(AccountModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTelNo) {
					qPos.add(telNo);
				}

				if (!pagination) {
					list = (List<Account>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Account>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first account in the ordered set where telNo = &#63;.
	 *
	 * @param telNo the tel no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	@Override
	public Account findByphone_First(
			String telNo, OrderByComparator<Account> orderByComparator)
		throws NoSuchAccountException {

		Account account = fetchByphone_First(telNo, orderByComparator);

		if (account != null) {
			return account;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("telNo=");
		msg.append(telNo);

		msg.append("}");

		throw new NoSuchAccountException(msg.toString());
	}

	/**
	 * Returns the first account in the ordered set where telNo = &#63;.
	 *
	 * @param telNo the tel no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account, or <code>null</code> if a matching account could not be found
	 */
	@Override
	public Account fetchByphone_First(
		String telNo, OrderByComparator<Account> orderByComparator) {

		List<Account> list = findByphone(telNo, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last account in the ordered set where telNo = &#63;.
	 *
	 * @param telNo the tel no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	@Override
	public Account findByphone_Last(
			String telNo, OrderByComparator<Account> orderByComparator)
		throws NoSuchAccountException {

		Account account = fetchByphone_Last(telNo, orderByComparator);

		if (account != null) {
			return account;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("telNo=");
		msg.append(telNo);

		msg.append("}");

		throw new NoSuchAccountException(msg.toString());
	}

	/**
	 * Returns the last account in the ordered set where telNo = &#63;.
	 *
	 * @param telNo the tel no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account, or <code>null</code> if a matching account could not be found
	 */
	@Override
	public Account fetchByphone_Last(
		String telNo, OrderByComparator<Account> orderByComparator) {

		int count = countByphone(telNo);

		if (count == 0) {
			return null;
		}

		List<Account> list = findByphone(
			telNo, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Account[] findByphone_PrevAndNext(
			long accountId, String telNo,
			OrderByComparator<Account> orderByComparator)
		throws NoSuchAccountException {

		telNo = Objects.toString(telNo, "");

		Account account = findByPrimaryKey(accountId);

		Session session = null;

		try {
			session = openSession();

			Account[] array = new AccountImpl[3];

			array[0] = getByphone_PrevAndNext(
				session, account, telNo, orderByComparator, true);

			array[1] = account;

			array[2] = getByphone_PrevAndNext(
				session, account, telNo, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Account getByphone_PrevAndNext(
		Session session, Account account, String telNo,
		OrderByComparator<Account> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ACCOUNT_WHERE);

		boolean bindTelNo = false;

		if (telNo.isEmpty()) {
			query.append(_FINDER_COLUMN_PHONE_TELNO_3);
		}
		else {
			bindTelNo = true;

			query.append(_FINDER_COLUMN_PHONE_TELNO_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(AccountModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindTelNo) {
			qPos.add(telNo);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(account)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Account> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the accounts where telNo = &#63; from the database.
	 *
	 * @param telNo the tel no
	 */
	@Override
	public void removeByphone(String telNo) {
		for (Account account :
				findByphone(
					telNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(account);
		}
	}

	/**
	 * Returns the number of accounts where telNo = &#63;.
	 *
	 * @param telNo the tel no
	 * @return the number of matching accounts
	 */
	@Override
	public int countByphone(String telNo) {
		telNo = Objects.toString(telNo, "");

		FinderPath finderPath = _finderPathCountByphone;

		Object[] finderArgs = new Object[] {telNo};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ACCOUNT_WHERE);

			boolean bindTelNo = false;

			if (telNo.isEmpty()) {
				query.append(_FINDER_COLUMN_PHONE_TELNO_3);
			}
			else {
				bindTelNo = true;

				query.append(_FINDER_COLUMN_PHONE_TELNO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTelNo) {
					qPos.add(telNo);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_PHONE_TELNO_2 =
		"account.telNo = ?";

	private static final String _FINDER_COLUMN_PHONE_TELNO_3 =
		"(account.telNo IS NULL OR account.telNo = '')";

	private FinderPath _finderPathWithPaginationFindBymst;
	private FinderPath _finderPathWithoutPaginationFindBymst;
	private FinderPath _finderPathCountBymst;

	/**
	 * Returns all the accounts where taxCode = &#63;.
	 *
	 * @param taxCode the tax code
	 * @return the matching accounts
	 */
	@Override
	public List<Account> findBymst(String taxCode) {
		return findBymst(taxCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Account> findBymst(String taxCode, int start, int end) {
		return findBymst(taxCode, start, end, null);
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
	@Override
	public List<Account> findBymst(
		String taxCode, int start, int end,
		OrderByComparator<Account> orderByComparator) {

		return findBymst(taxCode, start, end, orderByComparator, true);
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
	@Override
	public List<Account> findBymst(
		String taxCode, int start, int end,
		OrderByComparator<Account> orderByComparator,
		boolean retrieveFromCache) {

		taxCode = Objects.toString(taxCode, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindBymst;
			finderArgs = new Object[] {taxCode};
		}
		else {
			finderPath = _finderPathWithPaginationFindBymst;
			finderArgs = new Object[] {taxCode, start, end, orderByComparator};
		}

		List<Account> list = null;

		if (retrieveFromCache) {
			list = (List<Account>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Account account : list) {
					if (!taxCode.equals(account.getTaxCode())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_ACCOUNT_WHERE);

			boolean bindTaxCode = false;

			if (taxCode.isEmpty()) {
				query.append(_FINDER_COLUMN_MST_TAXCODE_3);
			}
			else {
				bindTaxCode = true;

				query.append(_FINDER_COLUMN_MST_TAXCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(AccountModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTaxCode) {
					qPos.add(taxCode);
				}

				if (!pagination) {
					list = (List<Account>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Account>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first account in the ordered set where taxCode = &#63;.
	 *
	 * @param taxCode the tax code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	@Override
	public Account findBymst_First(
			String taxCode, OrderByComparator<Account> orderByComparator)
		throws NoSuchAccountException {

		Account account = fetchBymst_First(taxCode, orderByComparator);

		if (account != null) {
			return account;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("taxCode=");
		msg.append(taxCode);

		msg.append("}");

		throw new NoSuchAccountException(msg.toString());
	}

	/**
	 * Returns the first account in the ordered set where taxCode = &#63;.
	 *
	 * @param taxCode the tax code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account, or <code>null</code> if a matching account could not be found
	 */
	@Override
	public Account fetchBymst_First(
		String taxCode, OrderByComparator<Account> orderByComparator) {

		List<Account> list = findBymst(taxCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last account in the ordered set where taxCode = &#63;.
	 *
	 * @param taxCode the tax code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	@Override
	public Account findBymst_Last(
			String taxCode, OrderByComparator<Account> orderByComparator)
		throws NoSuchAccountException {

		Account account = fetchBymst_Last(taxCode, orderByComparator);

		if (account != null) {
			return account;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("taxCode=");
		msg.append(taxCode);

		msg.append("}");

		throw new NoSuchAccountException(msg.toString());
	}

	/**
	 * Returns the last account in the ordered set where taxCode = &#63;.
	 *
	 * @param taxCode the tax code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account, or <code>null</code> if a matching account could not be found
	 */
	@Override
	public Account fetchBymst_Last(
		String taxCode, OrderByComparator<Account> orderByComparator) {

		int count = countBymst(taxCode);

		if (count == 0) {
			return null;
		}

		List<Account> list = findBymst(
			taxCode, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Account[] findBymst_PrevAndNext(
			long accountId, String taxCode,
			OrderByComparator<Account> orderByComparator)
		throws NoSuchAccountException {

		taxCode = Objects.toString(taxCode, "");

		Account account = findByPrimaryKey(accountId);

		Session session = null;

		try {
			session = openSession();

			Account[] array = new AccountImpl[3];

			array[0] = getBymst_PrevAndNext(
				session, account, taxCode, orderByComparator, true);

			array[1] = account;

			array[2] = getBymst_PrevAndNext(
				session, account, taxCode, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Account getBymst_PrevAndNext(
		Session session, Account account, String taxCode,
		OrderByComparator<Account> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ACCOUNT_WHERE);

		boolean bindTaxCode = false;

		if (taxCode.isEmpty()) {
			query.append(_FINDER_COLUMN_MST_TAXCODE_3);
		}
		else {
			bindTaxCode = true;

			query.append(_FINDER_COLUMN_MST_TAXCODE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(AccountModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindTaxCode) {
			qPos.add(taxCode);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(account)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Account> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the accounts where taxCode = &#63; from the database.
	 *
	 * @param taxCode the tax code
	 */
	@Override
	public void removeBymst(String taxCode) {
		for (Account account :
				findBymst(
					taxCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(account);
		}
	}

	/**
	 * Returns the number of accounts where taxCode = &#63;.
	 *
	 * @param taxCode the tax code
	 * @return the number of matching accounts
	 */
	@Override
	public int countBymst(String taxCode) {
		taxCode = Objects.toString(taxCode, "");

		FinderPath finderPath = _finderPathCountBymst;

		Object[] finderArgs = new Object[] {taxCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ACCOUNT_WHERE);

			boolean bindTaxCode = false;

			if (taxCode.isEmpty()) {
				query.append(_FINDER_COLUMN_MST_TAXCODE_3);
			}
			else {
				bindTaxCode = true;

				query.append(_FINDER_COLUMN_MST_TAXCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTaxCode) {
					qPos.add(taxCode);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_MST_TAXCODE_2 =
		"account.taxCode = ?";

	private static final String _FINDER_COLUMN_MST_TAXCODE_3 =
		"(account.taxCode IS NULL OR account.taxCode = '')";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the accounts where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching accounts
	 */
	@Override
	public List<Account> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Account> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
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
	@Override
	public List<Account> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Account> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
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
	@Override
	public List<Account> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Account> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByGroupId;
			finderArgs = new Object[] {groupId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByGroupId;
			finderArgs = new Object[] {groupId, start, end, orderByComparator};
		}

		List<Account> list = null;

		if (retrieveFromCache) {
			list = (List<Account>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Account account : list) {
					if ((groupId != account.getGroupId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_ACCOUNT_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(AccountModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Account>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Account>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first account in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	@Override
	public Account findByGroupId_First(
			long groupId, OrderByComparator<Account> orderByComparator)
		throws NoSuchAccountException {

		Account account = fetchByGroupId_First(groupId, orderByComparator);

		if (account != null) {
			return account;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchAccountException(msg.toString());
	}

	/**
	 * Returns the first account in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account, or <code>null</code> if a matching account could not be found
	 */
	@Override
	public Account fetchByGroupId_First(
		long groupId, OrderByComparator<Account> orderByComparator) {

		List<Account> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last account in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	@Override
	public Account findByGroupId_Last(
			long groupId, OrderByComparator<Account> orderByComparator)
		throws NoSuchAccountException {

		Account account = fetchByGroupId_Last(groupId, orderByComparator);

		if (account != null) {
			return account;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchAccountException(msg.toString());
	}

	/**
	 * Returns the last account in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account, or <code>null</code> if a matching account could not be found
	 */
	@Override
	public Account fetchByGroupId_Last(
		long groupId, OrderByComparator<Account> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Account> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Account[] findByGroupId_PrevAndNext(
			long accountId, long groupId,
			OrderByComparator<Account> orderByComparator)
		throws NoSuchAccountException {

		Account account = findByPrimaryKey(accountId);

		Session session = null;

		try {
			session = openSession();

			Account[] array = new AccountImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, account, groupId, orderByComparator, true);

			array[1] = account;

			array[2] = getByGroupId_PrevAndNext(
				session, account, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Account getByGroupId_PrevAndNext(
		Session session, Account account, long groupId,
		OrderByComparator<Account> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ACCOUNT_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(AccountModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(account)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Account> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the accounts where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (Account account :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(account);
		}
	}

	/**
	 * Returns the number of accounts where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching accounts
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ACCOUNT_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 =
		"account.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByGS;
	private FinderPath _finderPathWithoutPaginationFindByGS;
	private FinderPath _finderPathCountByGS;

	/**
	 * Returns all the accounts where groupId = &#63; and accountStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @return the matching accounts
	 */
	@Override
	public List<Account> findByGS(long groupId, int accountStatus) {
		return findByGS(
			groupId, accountStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Account> findByGS(
		long groupId, int accountStatus, int start, int end) {

		return findByGS(groupId, accountStatus, start, end, null);
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
	@Override
	public List<Account> findByGS(
		long groupId, int accountStatus, int start, int end,
		OrderByComparator<Account> orderByComparator) {

		return findByGS(
			groupId, accountStatus, start, end, orderByComparator, true);
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
	@Override
	public List<Account> findByGS(
		long groupId, int accountStatus, int start, int end,
		OrderByComparator<Account> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByGS;
			finderArgs = new Object[] {groupId, accountStatus};
		}
		else {
			finderPath = _finderPathWithPaginationFindByGS;
			finderArgs = new Object[] {
				groupId, accountStatus, start, end, orderByComparator
			};
		}

		List<Account> list = null;

		if (retrieveFromCache) {
			list = (List<Account>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Account account : list) {
					if ((groupId != account.getGroupId()) ||
						(accountStatus != account.getAccountStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_ACCOUNT_WHERE);

			query.append(_FINDER_COLUMN_GS_GROUPID_2);

			query.append(_FINDER_COLUMN_GS_ACCOUNTSTATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(AccountModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(accountStatus);

				if (!pagination) {
					list = (List<Account>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Account>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Account findByGS_First(
			long groupId, int accountStatus,
			OrderByComparator<Account> orderByComparator)
		throws NoSuchAccountException {

		Account account = fetchByGS_First(
			groupId, accountStatus, orderByComparator);

		if (account != null) {
			return account;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", accountStatus=");
		msg.append(accountStatus);

		msg.append("}");

		throw new NoSuchAccountException(msg.toString());
	}

	/**
	 * Returns the first account in the ordered set where groupId = &#63; and accountStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account, or <code>null</code> if a matching account could not be found
	 */
	@Override
	public Account fetchByGS_First(
		long groupId, int accountStatus,
		OrderByComparator<Account> orderByComparator) {

		List<Account> list = findByGS(
			groupId, accountStatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Account findByGS_Last(
			long groupId, int accountStatus,
			OrderByComparator<Account> orderByComparator)
		throws NoSuchAccountException {

		Account account = fetchByGS_Last(
			groupId, accountStatus, orderByComparator);

		if (account != null) {
			return account;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", accountStatus=");
		msg.append(accountStatus);

		msg.append("}");

		throw new NoSuchAccountException(msg.toString());
	}

	/**
	 * Returns the last account in the ordered set where groupId = &#63; and accountStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account, or <code>null</code> if a matching account could not be found
	 */
	@Override
	public Account fetchByGS_Last(
		long groupId, int accountStatus,
		OrderByComparator<Account> orderByComparator) {

		int count = countByGS(groupId, accountStatus);

		if (count == 0) {
			return null;
		}

		List<Account> list = findByGS(
			groupId, accountStatus, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Account[] findByGS_PrevAndNext(
			long accountId, long groupId, int accountStatus,
			OrderByComparator<Account> orderByComparator)
		throws NoSuchAccountException {

		Account account = findByPrimaryKey(accountId);

		Session session = null;

		try {
			session = openSession();

			Account[] array = new AccountImpl[3];

			array[0] = getByGS_PrevAndNext(
				session, account, groupId, accountStatus, orderByComparator,
				true);

			array[1] = account;

			array[2] = getByGS_PrevAndNext(
				session, account, groupId, accountStatus, orderByComparator,
				false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Account getByGS_PrevAndNext(
		Session session, Account account, long groupId, int accountStatus,
		OrderByComparator<Account> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_ACCOUNT_WHERE);

		query.append(_FINDER_COLUMN_GS_GROUPID_2);

		query.append(_FINDER_COLUMN_GS_ACCOUNTSTATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(AccountModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(accountStatus);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(account)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Account> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the accounts where groupId = &#63; and accountStatus = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 */
	@Override
	public void removeByGS(long groupId, int accountStatus) {
		for (Account account :
				findByGS(
					groupId, accountStatus, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(account);
		}
	}

	/**
	 * Returns the number of accounts where groupId = &#63; and accountStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @return the number of matching accounts
	 */
	@Override
	public int countByGS(long groupId, int accountStatus) {
		FinderPath finderPath = _finderPathCountByGS;

		Object[] finderArgs = new Object[] {groupId, accountStatus};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ACCOUNT_WHERE);

			query.append(_FINDER_COLUMN_GS_GROUPID_2);

			query.append(_FINDER_COLUMN_GS_ACCOUNTSTATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(accountStatus);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GS_GROUPID_2 =
		"account.groupId = ? AND ";

	private static final String _FINDER_COLUMN_GS_ACCOUNTSTATUS_2 =
		"account.accountStatus = ?";

	private FinderPath _finderPathWithPaginationFindByGSC;
	private FinderPath _finderPathWithoutPaginationFindByGSC;
	private FinderPath _finderPathCountByGSC;

	/**
	 * Returns all the accounts where groupId = &#63; and accountStatus = &#63; and cityCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param cityCode the city code
	 * @return the matching accounts
	 */
	@Override
	public List<Account> findByGSC(
		long groupId, int accountStatus, String cityCode) {

		return findByGSC(
			groupId, accountStatus, cityCode, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Account> findByGSC(
		long groupId, int accountStatus, String cityCode, int start, int end) {

		return findByGSC(groupId, accountStatus, cityCode, start, end, null);
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
	@Override
	public List<Account> findByGSC(
		long groupId, int accountStatus, String cityCode, int start, int end,
		OrderByComparator<Account> orderByComparator) {

		return findByGSC(
			groupId, accountStatus, cityCode, start, end, orderByComparator,
			true);
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
	@Override
	public List<Account> findByGSC(
		long groupId, int accountStatus, String cityCode, int start, int end,
		OrderByComparator<Account> orderByComparator,
		boolean retrieveFromCache) {

		cityCode = Objects.toString(cityCode, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByGSC;
			finderArgs = new Object[] {groupId, accountStatus, cityCode};
		}
		else {
			finderPath = _finderPathWithPaginationFindByGSC;
			finderArgs = new Object[] {
				groupId, accountStatus, cityCode, start, end, orderByComparator
			};
		}

		List<Account> list = null;

		if (retrieveFromCache) {
			list = (List<Account>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Account account : list) {
					if ((groupId != account.getGroupId()) ||
						(accountStatus != account.getAccountStatus()) ||
						!cityCode.equals(account.getCityCode())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_ACCOUNT_WHERE);

			query.append(_FINDER_COLUMN_GSC_GROUPID_2);

			query.append(_FINDER_COLUMN_GSC_ACCOUNTSTATUS_2);

			boolean bindCityCode = false;

			if (cityCode.isEmpty()) {
				query.append(_FINDER_COLUMN_GSC_CITYCODE_3);
			}
			else {
				bindCityCode = true;

				query.append(_FINDER_COLUMN_GSC_CITYCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(AccountModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(accountStatus);

				if (bindCityCode) {
					qPos.add(cityCode);
				}

				if (!pagination) {
					list = (List<Account>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Account>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Account findByGSC_First(
			long groupId, int accountStatus, String cityCode,
			OrderByComparator<Account> orderByComparator)
		throws NoSuchAccountException {

		Account account = fetchByGSC_First(
			groupId, accountStatus, cityCode, orderByComparator);

		if (account != null) {
			return account;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", accountStatus=");
		msg.append(accountStatus);

		msg.append(", cityCode=");
		msg.append(cityCode);

		msg.append("}");

		throw new NoSuchAccountException(msg.toString());
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
	@Override
	public Account fetchByGSC_First(
		long groupId, int accountStatus, String cityCode,
		OrderByComparator<Account> orderByComparator) {

		List<Account> list = findByGSC(
			groupId, accountStatus, cityCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Account findByGSC_Last(
			long groupId, int accountStatus, String cityCode,
			OrderByComparator<Account> orderByComparator)
		throws NoSuchAccountException {

		Account account = fetchByGSC_Last(
			groupId, accountStatus, cityCode, orderByComparator);

		if (account != null) {
			return account;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", accountStatus=");
		msg.append(accountStatus);

		msg.append(", cityCode=");
		msg.append(cityCode);

		msg.append("}");

		throw new NoSuchAccountException(msg.toString());
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
	@Override
	public Account fetchByGSC_Last(
		long groupId, int accountStatus, String cityCode,
		OrderByComparator<Account> orderByComparator) {

		int count = countByGSC(groupId, accountStatus, cityCode);

		if (count == 0) {
			return null;
		}

		List<Account> list = findByGSC(
			groupId, accountStatus, cityCode, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Account[] findByGSC_PrevAndNext(
			long accountId, long groupId, int accountStatus, String cityCode,
			OrderByComparator<Account> orderByComparator)
		throws NoSuchAccountException {

		cityCode = Objects.toString(cityCode, "");

		Account account = findByPrimaryKey(accountId);

		Session session = null;

		try {
			session = openSession();

			Account[] array = new AccountImpl[3];

			array[0] = getByGSC_PrevAndNext(
				session, account, groupId, accountStatus, cityCode,
				orderByComparator, true);

			array[1] = account;

			array[2] = getByGSC_PrevAndNext(
				session, account, groupId, accountStatus, cityCode,
				orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Account getByGSC_PrevAndNext(
		Session session, Account account, long groupId, int accountStatus,
		String cityCode, OrderByComparator<Account> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_ACCOUNT_WHERE);

		query.append(_FINDER_COLUMN_GSC_GROUPID_2);

		query.append(_FINDER_COLUMN_GSC_ACCOUNTSTATUS_2);

		boolean bindCityCode = false;

		if (cityCode.isEmpty()) {
			query.append(_FINDER_COLUMN_GSC_CITYCODE_3);
		}
		else {
			bindCityCode = true;

			query.append(_FINDER_COLUMN_GSC_CITYCODE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(AccountModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(accountStatus);

		if (bindCityCode) {
			qPos.add(cityCode);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(account)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Account> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the accounts where groupId = &#63; and accountStatus = &#63; and cityCode = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param cityCode the city code
	 */
	@Override
	public void removeByGSC(long groupId, int accountStatus, String cityCode) {
		for (Account account :
				findByGSC(
					groupId, accountStatus, cityCode, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(account);
		}
	}

	/**
	 * Returns the number of accounts where groupId = &#63; and accountStatus = &#63; and cityCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param cityCode the city code
	 * @return the number of matching accounts
	 */
	@Override
	public int countByGSC(long groupId, int accountStatus, String cityCode) {
		cityCode = Objects.toString(cityCode, "");

		FinderPath finderPath = _finderPathCountByGSC;

		Object[] finderArgs = new Object[] {groupId, accountStatus, cityCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_ACCOUNT_WHERE);

			query.append(_FINDER_COLUMN_GSC_GROUPID_2);

			query.append(_FINDER_COLUMN_GSC_ACCOUNTSTATUS_2);

			boolean bindCityCode = false;

			if (cityCode.isEmpty()) {
				query.append(_FINDER_COLUMN_GSC_CITYCODE_3);
			}
			else {
				bindCityCode = true;

				query.append(_FINDER_COLUMN_GSC_CITYCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(accountStatus);

				if (bindCityCode) {
					qPos.add(cityCode);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GSC_GROUPID_2 =
		"account.groupId = ? AND ";

	private static final String _FINDER_COLUMN_GSC_ACCOUNTSTATUS_2 =
		"account.accountStatus = ? AND ";

	private static final String _FINDER_COLUMN_GSC_CITYCODE_2 =
		"account.cityCode = ?";

	private static final String _FINDER_COLUMN_GSC_CITYCODE_3 =
		"(account.cityCode IS NULL OR account.cityCode = '')";

	private FinderPath _finderPathWithPaginationFindByGSD;
	private FinderPath _finderPathWithoutPaginationFindByGSD;
	private FinderPath _finderPathCountByGSD;

	/**
	 * Returns all the accounts where groupId = &#63; and accountStatus = &#63; and districtCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param districtCode the district code
	 * @return the matching accounts
	 */
	@Override
	public List<Account> findByGSD(
		long groupId, int accountStatus, String districtCode) {

		return findByGSD(
			groupId, accountStatus, districtCode, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Account> findByGSD(
		long groupId, int accountStatus, String districtCode, int start,
		int end) {

		return findByGSD(
			groupId, accountStatus, districtCode, start, end, null);
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
	@Override
	public List<Account> findByGSD(
		long groupId, int accountStatus, String districtCode, int start,
		int end, OrderByComparator<Account> orderByComparator) {

		return findByGSD(
			groupId, accountStatus, districtCode, start, end, orderByComparator,
			true);
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
	@Override
	public List<Account> findByGSD(
		long groupId, int accountStatus, String districtCode, int start,
		int end, OrderByComparator<Account> orderByComparator,
		boolean retrieveFromCache) {

		districtCode = Objects.toString(districtCode, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByGSD;
			finderArgs = new Object[] {groupId, accountStatus, districtCode};
		}
		else {
			finderPath = _finderPathWithPaginationFindByGSD;
			finderArgs = new Object[] {
				groupId, accountStatus, districtCode, start, end,
				orderByComparator
			};
		}

		List<Account> list = null;

		if (retrieveFromCache) {
			list = (List<Account>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Account account : list) {
					if ((groupId != account.getGroupId()) ||
						(accountStatus != account.getAccountStatus()) ||
						!districtCode.equals(account.getDistrictCode())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_ACCOUNT_WHERE);

			query.append(_FINDER_COLUMN_GSD_GROUPID_2);

			query.append(_FINDER_COLUMN_GSD_ACCOUNTSTATUS_2);

			boolean bindDistrictCode = false;

			if (districtCode.isEmpty()) {
				query.append(_FINDER_COLUMN_GSD_DISTRICTCODE_3);
			}
			else {
				bindDistrictCode = true;

				query.append(_FINDER_COLUMN_GSD_DISTRICTCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(AccountModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(accountStatus);

				if (bindDistrictCode) {
					qPos.add(districtCode);
				}

				if (!pagination) {
					list = (List<Account>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Account>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Account findByGSD_First(
			long groupId, int accountStatus, String districtCode,
			OrderByComparator<Account> orderByComparator)
		throws NoSuchAccountException {

		Account account = fetchByGSD_First(
			groupId, accountStatus, districtCode, orderByComparator);

		if (account != null) {
			return account;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", accountStatus=");
		msg.append(accountStatus);

		msg.append(", districtCode=");
		msg.append(districtCode);

		msg.append("}");

		throw new NoSuchAccountException(msg.toString());
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
	@Override
	public Account fetchByGSD_First(
		long groupId, int accountStatus, String districtCode,
		OrderByComparator<Account> orderByComparator) {

		List<Account> list = findByGSD(
			groupId, accountStatus, districtCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Account findByGSD_Last(
			long groupId, int accountStatus, String districtCode,
			OrderByComparator<Account> orderByComparator)
		throws NoSuchAccountException {

		Account account = fetchByGSD_Last(
			groupId, accountStatus, districtCode, orderByComparator);

		if (account != null) {
			return account;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", accountStatus=");
		msg.append(accountStatus);

		msg.append(", districtCode=");
		msg.append(districtCode);

		msg.append("}");

		throw new NoSuchAccountException(msg.toString());
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
	@Override
	public Account fetchByGSD_Last(
		long groupId, int accountStatus, String districtCode,
		OrderByComparator<Account> orderByComparator) {

		int count = countByGSD(groupId, accountStatus, districtCode);

		if (count == 0) {
			return null;
		}

		List<Account> list = findByGSD(
			groupId, accountStatus, districtCode, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Account[] findByGSD_PrevAndNext(
			long accountId, long groupId, int accountStatus,
			String districtCode, OrderByComparator<Account> orderByComparator)
		throws NoSuchAccountException {

		districtCode = Objects.toString(districtCode, "");

		Account account = findByPrimaryKey(accountId);

		Session session = null;

		try {
			session = openSession();

			Account[] array = new AccountImpl[3];

			array[0] = getByGSD_PrevAndNext(
				session, account, groupId, accountStatus, districtCode,
				orderByComparator, true);

			array[1] = account;

			array[2] = getByGSD_PrevAndNext(
				session, account, groupId, accountStatus, districtCode,
				orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Account getByGSD_PrevAndNext(
		Session session, Account account, long groupId, int accountStatus,
		String districtCode, OrderByComparator<Account> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_ACCOUNT_WHERE);

		query.append(_FINDER_COLUMN_GSD_GROUPID_2);

		query.append(_FINDER_COLUMN_GSD_ACCOUNTSTATUS_2);

		boolean bindDistrictCode = false;

		if (districtCode.isEmpty()) {
			query.append(_FINDER_COLUMN_GSD_DISTRICTCODE_3);
		}
		else {
			bindDistrictCode = true;

			query.append(_FINDER_COLUMN_GSD_DISTRICTCODE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(AccountModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(accountStatus);

		if (bindDistrictCode) {
			qPos.add(districtCode);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(account)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Account> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the accounts where groupId = &#63; and accountStatus = &#63; and districtCode = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param districtCode the district code
	 */
	@Override
	public void removeByGSD(
		long groupId, int accountStatus, String districtCode) {

		for (Account account :
				findByGSD(
					groupId, accountStatus, districtCode, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(account);
		}
	}

	/**
	 * Returns the number of accounts where groupId = &#63; and accountStatus = &#63; and districtCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param districtCode the district code
	 * @return the number of matching accounts
	 */
	@Override
	public int countByGSD(
		long groupId, int accountStatus, String districtCode) {

		districtCode = Objects.toString(districtCode, "");

		FinderPath finderPath = _finderPathCountByGSD;

		Object[] finderArgs = new Object[] {
			groupId, accountStatus, districtCode
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_ACCOUNT_WHERE);

			query.append(_FINDER_COLUMN_GSD_GROUPID_2);

			query.append(_FINDER_COLUMN_GSD_ACCOUNTSTATUS_2);

			boolean bindDistrictCode = false;

			if (districtCode.isEmpty()) {
				query.append(_FINDER_COLUMN_GSD_DISTRICTCODE_3);
			}
			else {
				bindDistrictCode = true;

				query.append(_FINDER_COLUMN_GSD_DISTRICTCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(accountStatus);

				if (bindDistrictCode) {
					qPos.add(districtCode);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GSD_GROUPID_2 =
		"account.groupId = ? AND ";

	private static final String _FINDER_COLUMN_GSD_ACCOUNTSTATUS_2 =
		"account.accountStatus = ? AND ";

	private static final String _FINDER_COLUMN_GSD_DISTRICTCODE_2 =
		"account.districtCode = ?";

	private static final String _FINDER_COLUMN_GSD_DISTRICTCODE_3 =
		"(account.districtCode IS NULL OR account.districtCode = '')";

	private FinderPath _finderPathWithPaginationFindByGSW;
	private FinderPath _finderPathWithoutPaginationFindByGSW;
	private FinderPath _finderPathCountByGSW;

	/**
	 * Returns all the accounts where groupId = &#63; and accountStatus = &#63; and wardCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param wardCode the ward code
	 * @return the matching accounts
	 */
	@Override
	public List<Account> findByGSW(
		long groupId, int accountStatus, String wardCode) {

		return findByGSW(
			groupId, accountStatus, wardCode, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Account> findByGSW(
		long groupId, int accountStatus, String wardCode, int start, int end) {

		return findByGSW(groupId, accountStatus, wardCode, start, end, null);
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
	@Override
	public List<Account> findByGSW(
		long groupId, int accountStatus, String wardCode, int start, int end,
		OrderByComparator<Account> orderByComparator) {

		return findByGSW(
			groupId, accountStatus, wardCode, start, end, orderByComparator,
			true);
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
	@Override
	public List<Account> findByGSW(
		long groupId, int accountStatus, String wardCode, int start, int end,
		OrderByComparator<Account> orderByComparator,
		boolean retrieveFromCache) {

		wardCode = Objects.toString(wardCode, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByGSW;
			finderArgs = new Object[] {groupId, accountStatus, wardCode};
		}
		else {
			finderPath = _finderPathWithPaginationFindByGSW;
			finderArgs = new Object[] {
				groupId, accountStatus, wardCode, start, end, orderByComparator
			};
		}

		List<Account> list = null;

		if (retrieveFromCache) {
			list = (List<Account>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Account account : list) {
					if ((groupId != account.getGroupId()) ||
						(accountStatus != account.getAccountStatus()) ||
						!wardCode.equals(account.getWardCode())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_ACCOUNT_WHERE);

			query.append(_FINDER_COLUMN_GSW_GROUPID_2);

			query.append(_FINDER_COLUMN_GSW_ACCOUNTSTATUS_2);

			boolean bindWardCode = false;

			if (wardCode.isEmpty()) {
				query.append(_FINDER_COLUMN_GSW_WARDCODE_3);
			}
			else {
				bindWardCode = true;

				query.append(_FINDER_COLUMN_GSW_WARDCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(AccountModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(accountStatus);

				if (bindWardCode) {
					qPos.add(wardCode);
				}

				if (!pagination) {
					list = (List<Account>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Account>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Account findByGSW_First(
			long groupId, int accountStatus, String wardCode,
			OrderByComparator<Account> orderByComparator)
		throws NoSuchAccountException {

		Account account = fetchByGSW_First(
			groupId, accountStatus, wardCode, orderByComparator);

		if (account != null) {
			return account;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", accountStatus=");
		msg.append(accountStatus);

		msg.append(", wardCode=");
		msg.append(wardCode);

		msg.append("}");

		throw new NoSuchAccountException(msg.toString());
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
	@Override
	public Account fetchByGSW_First(
		long groupId, int accountStatus, String wardCode,
		OrderByComparator<Account> orderByComparator) {

		List<Account> list = findByGSW(
			groupId, accountStatus, wardCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Account findByGSW_Last(
			long groupId, int accountStatus, String wardCode,
			OrderByComparator<Account> orderByComparator)
		throws NoSuchAccountException {

		Account account = fetchByGSW_Last(
			groupId, accountStatus, wardCode, orderByComparator);

		if (account != null) {
			return account;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", accountStatus=");
		msg.append(accountStatus);

		msg.append(", wardCode=");
		msg.append(wardCode);

		msg.append("}");

		throw new NoSuchAccountException(msg.toString());
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
	@Override
	public Account fetchByGSW_Last(
		long groupId, int accountStatus, String wardCode,
		OrderByComparator<Account> orderByComparator) {

		int count = countByGSW(groupId, accountStatus, wardCode);

		if (count == 0) {
			return null;
		}

		List<Account> list = findByGSW(
			groupId, accountStatus, wardCode, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Account[] findByGSW_PrevAndNext(
			long accountId, long groupId, int accountStatus, String wardCode,
			OrderByComparator<Account> orderByComparator)
		throws NoSuchAccountException {

		wardCode = Objects.toString(wardCode, "");

		Account account = findByPrimaryKey(accountId);

		Session session = null;

		try {
			session = openSession();

			Account[] array = new AccountImpl[3];

			array[0] = getByGSW_PrevAndNext(
				session, account, groupId, accountStatus, wardCode,
				orderByComparator, true);

			array[1] = account;

			array[2] = getByGSW_PrevAndNext(
				session, account, groupId, accountStatus, wardCode,
				orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Account getByGSW_PrevAndNext(
		Session session, Account account, long groupId, int accountStatus,
		String wardCode, OrderByComparator<Account> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_ACCOUNT_WHERE);

		query.append(_FINDER_COLUMN_GSW_GROUPID_2);

		query.append(_FINDER_COLUMN_GSW_ACCOUNTSTATUS_2);

		boolean bindWardCode = false;

		if (wardCode.isEmpty()) {
			query.append(_FINDER_COLUMN_GSW_WARDCODE_3);
		}
		else {
			bindWardCode = true;

			query.append(_FINDER_COLUMN_GSW_WARDCODE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(AccountModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(accountStatus);

		if (bindWardCode) {
			qPos.add(wardCode);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(account)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Account> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the accounts where groupId = &#63; and accountStatus = &#63; and wardCode = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param wardCode the ward code
	 */
	@Override
	public void removeByGSW(long groupId, int accountStatus, String wardCode) {
		for (Account account :
				findByGSW(
					groupId, accountStatus, wardCode, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(account);
		}
	}

	/**
	 * Returns the number of accounts where groupId = &#63; and accountStatus = &#63; and wardCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param accountStatus the account status
	 * @param wardCode the ward code
	 * @return the number of matching accounts
	 */
	@Override
	public int countByGSW(long groupId, int accountStatus, String wardCode) {
		wardCode = Objects.toString(wardCode, "");

		FinderPath finderPath = _finderPathCountByGSW;

		Object[] finderArgs = new Object[] {groupId, accountStatus, wardCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_ACCOUNT_WHERE);

			query.append(_FINDER_COLUMN_GSW_GROUPID_2);

			query.append(_FINDER_COLUMN_GSW_ACCOUNTSTATUS_2);

			boolean bindWardCode = false;

			if (wardCode.isEmpty()) {
				query.append(_FINDER_COLUMN_GSW_WARDCODE_3);
			}
			else {
				bindWardCode = true;

				query.append(_FINDER_COLUMN_GSW_WARDCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(accountStatus);

				if (bindWardCode) {
					qPos.add(wardCode);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GSW_GROUPID_2 =
		"account.groupId = ? AND ";

	private static final String _FINDER_COLUMN_GSW_ACCOUNTSTATUS_2 =
		"account.accountStatus = ? AND ";

	private static final String _FINDER_COLUMN_GSW_WARDCODE_2 =
		"account.wardCode = ?";

	private static final String _FINDER_COLUMN_GSW_WARDCODE_3 =
		"(account.wardCode IS NULL OR account.wardCode = '')";

	private FinderPath _finderPathFetchByEmail;
	private FinderPath _finderPathCountByEmail;

	/**
	 * Returns the account where email = &#63; or throws a <code>NoSuchAccountException</code> if it could not be found.
	 *
	 * @param email the email
	 * @return the matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	@Override
	public Account findByEmail(String email) throws NoSuchAccountException {
		Account account = fetchByEmail(email);

		if (account == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("email=");
			msg.append(email);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchAccountException(msg.toString());
		}

		return account;
	}

	/**
	 * Returns the account where email = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param email the email
	 * @return the matching account, or <code>null</code> if a matching account could not be found
	 */
	@Override
	public Account fetchByEmail(String email) {
		return fetchByEmail(email, true);
	}

	/**
	 * Returns the account where email = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param email the email
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching account, or <code>null</code> if a matching account could not be found
	 */
	@Override
	public Account fetchByEmail(String email, boolean retrieveFromCache) {
		email = Objects.toString(email, "");

		Object[] finderArgs = new Object[] {email};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByEmail, finderArgs, this);
		}

		if (result instanceof Account) {
			Account account = (Account)result;

			if (!Objects.equals(email, account.getEmail())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ACCOUNT_WHERE);

			boolean bindEmail = false;

			if (email.isEmpty()) {
				query.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
			}
			else {
				bindEmail = true;

				query.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEmail) {
					qPos.add(email);
				}

				List<Account> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByEmail, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"AccountPersistenceImpl.fetchByEmail(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Account account = list.get(0);

					result = account;

					cacheResult(account);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(_finderPathFetchByEmail, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Account)result;
		}
	}

	/**
	 * Removes the account where email = &#63; from the database.
	 *
	 * @param email the email
	 * @return the account that was removed
	 */
	@Override
	public Account removeByEmail(String email) throws NoSuchAccountException {
		Account account = findByEmail(email);

		return remove(account);
	}

	/**
	 * Returns the number of accounts where email = &#63;.
	 *
	 * @param email the email
	 * @return the number of matching accounts
	 */
	@Override
	public int countByEmail(String email) {
		email = Objects.toString(email, "");

		FinderPath finderPath = _finderPathCountByEmail;

		Object[] finderArgs = new Object[] {email};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ACCOUNT_WHERE);

			boolean bindEmail = false;

			if (email.isEmpty()) {
				query.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
			}
			else {
				bindEmail = true;

				query.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEmail) {
					qPos.add(email);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_EMAIL_EMAIL_2 =
		"account.email = ?";

	private static final String _FINDER_COLUMN_EMAIL_EMAIL_3 =
		"(account.email IS NULL OR account.email = '')";

	private FinderPath _finderPathWithPaginationFindByGN;
	private FinderPath _finderPathWithPaginationCountByGN;

	/**
	 * Returns all the accounts where groupId = &#63; and fullName LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @return the matching accounts
	 */
	@Override
	public List<Account> findByGN(long groupId, String fullName) {
		return findByGN(
			groupId, fullName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Account> findByGN(
		long groupId, String fullName, int start, int end) {

		return findByGN(groupId, fullName, start, end, null);
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
	@Override
	public List<Account> findByGN(
		long groupId, String fullName, int start, int end,
		OrderByComparator<Account> orderByComparator) {

		return findByGN(groupId, fullName, start, end, orderByComparator, true);
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
	@Override
	public List<Account> findByGN(
		long groupId, String fullName, int start, int end,
		OrderByComparator<Account> orderByComparator,
		boolean retrieveFromCache) {

		fullName = Objects.toString(fullName, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByGN;
		finderArgs = new Object[] {
			groupId, fullName, start, end, orderByComparator
		};

		List<Account> list = null;

		if (retrieveFromCache) {
			list = (List<Account>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Account account : list) {
					if ((groupId != account.getGroupId()) ||
						!StringUtil.wildcardMatches(
							account.getFullName(), fullName, '_', '%', '\\',
							true)) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_ACCOUNT_WHERE);

			query.append(_FINDER_COLUMN_GN_GROUPID_2);

			boolean bindFullName = false;

			if (fullName.isEmpty()) {
				query.append(_FINDER_COLUMN_GN_FULLNAME_3);
			}
			else {
				bindFullName = true;

				query.append(_FINDER_COLUMN_GN_FULLNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(AccountModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindFullName) {
					qPos.add(fullName);
				}

				if (!pagination) {
					list = (List<Account>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Account>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Account findByGN_First(
			long groupId, String fullName,
			OrderByComparator<Account> orderByComparator)
		throws NoSuchAccountException {

		Account account = fetchByGN_First(groupId, fullName, orderByComparator);

		if (account != null) {
			return account;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", fullName=");
		msg.append(fullName);

		msg.append("}");

		throw new NoSuchAccountException(msg.toString());
	}

	/**
	 * Returns the first account in the ordered set where groupId = &#63; and fullName LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account, or <code>null</code> if a matching account could not be found
	 */
	@Override
	public Account fetchByGN_First(
		long groupId, String fullName,
		OrderByComparator<Account> orderByComparator) {

		List<Account> list = findByGN(
			groupId, fullName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Account findByGN_Last(
			long groupId, String fullName,
			OrderByComparator<Account> orderByComparator)
		throws NoSuchAccountException {

		Account account = fetchByGN_Last(groupId, fullName, orderByComparator);

		if (account != null) {
			return account;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", fullName=");
		msg.append(fullName);

		msg.append("}");

		throw new NoSuchAccountException(msg.toString());
	}

	/**
	 * Returns the last account in the ordered set where groupId = &#63; and fullName LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account, or <code>null</code> if a matching account could not be found
	 */
	@Override
	public Account fetchByGN_Last(
		long groupId, String fullName,
		OrderByComparator<Account> orderByComparator) {

		int count = countByGN(groupId, fullName);

		if (count == 0) {
			return null;
		}

		List<Account> list = findByGN(
			groupId, fullName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Account[] findByGN_PrevAndNext(
			long accountId, long groupId, String fullName,
			OrderByComparator<Account> orderByComparator)
		throws NoSuchAccountException {

		fullName = Objects.toString(fullName, "");

		Account account = findByPrimaryKey(accountId);

		Session session = null;

		try {
			session = openSession();

			Account[] array = new AccountImpl[3];

			array[0] = getByGN_PrevAndNext(
				session, account, groupId, fullName, orderByComparator, true);

			array[1] = account;

			array[2] = getByGN_PrevAndNext(
				session, account, groupId, fullName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Account getByGN_PrevAndNext(
		Session session, Account account, long groupId, String fullName,
		OrderByComparator<Account> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_ACCOUNT_WHERE);

		query.append(_FINDER_COLUMN_GN_GROUPID_2);

		boolean bindFullName = false;

		if (fullName.isEmpty()) {
			query.append(_FINDER_COLUMN_GN_FULLNAME_3);
		}
		else {
			bindFullName = true;

			query.append(_FINDER_COLUMN_GN_FULLNAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(AccountModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (bindFullName) {
			qPos.add(fullName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(account)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Account> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the accounts where groupId = &#63; and fullName LIKE &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 */
	@Override
	public void removeByGN(long groupId, String fullName) {
		for (Account account :
				findByGN(
					groupId, fullName, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(account);
		}
	}

	/**
	 * Returns the number of accounts where groupId = &#63; and fullName LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @return the number of matching accounts
	 */
	@Override
	public int countByGN(long groupId, String fullName) {
		fullName = Objects.toString(fullName, "");

		FinderPath finderPath = _finderPathWithPaginationCountByGN;

		Object[] finderArgs = new Object[] {groupId, fullName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ACCOUNT_WHERE);

			query.append(_FINDER_COLUMN_GN_GROUPID_2);

			boolean bindFullName = false;

			if (fullName.isEmpty()) {
				query.append(_FINDER_COLUMN_GN_FULLNAME_3);
			}
			else {
				bindFullName = true;

				query.append(_FINDER_COLUMN_GN_FULLNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindFullName) {
					qPos.add(fullName);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GN_GROUPID_2 =
		"account.groupId = ? AND ";

	private static final String _FINDER_COLUMN_GN_FULLNAME_2 =
		"account.fullName LIKE ?";

	private static final String _FINDER_COLUMN_GN_FULLNAME_3 =
		"(account.fullName IS NULL OR account.fullName LIKE '')";

	private FinderPath _finderPathWithPaginationFindByGNS;
	private FinderPath _finderPathWithPaginationCountByGNS;

	/**
	 * Returns all the accounts where groupId = &#63; and fullName LIKE &#63; and accountStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param accountStatus the account status
	 * @return the matching accounts
	 */
	@Override
	public List<Account> findByGNS(
		long groupId, String fullName, int accountStatus) {

		return findByGNS(
			groupId, fullName, accountStatus, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Account> findByGNS(
		long groupId, String fullName, int accountStatus, int start, int end) {

		return findByGNS(groupId, fullName, accountStatus, start, end, null);
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
	@Override
	public List<Account> findByGNS(
		long groupId, String fullName, int accountStatus, int start, int end,
		OrderByComparator<Account> orderByComparator) {

		return findByGNS(
			groupId, fullName, accountStatus, start, end, orderByComparator,
			true);
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
	@Override
	public List<Account> findByGNS(
		long groupId, String fullName, int accountStatus, int start, int end,
		OrderByComparator<Account> orderByComparator,
		boolean retrieveFromCache) {

		fullName = Objects.toString(fullName, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByGNS;
		finderArgs = new Object[] {
			groupId, fullName, accountStatus, start, end, orderByComparator
		};

		List<Account> list = null;

		if (retrieveFromCache) {
			list = (List<Account>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Account account : list) {
					if ((groupId != account.getGroupId()) ||
						!StringUtil.wildcardMatches(
							account.getFullName(), fullName, '_', '%', '\\',
							true) ||
						(accountStatus != account.getAccountStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_ACCOUNT_WHERE);

			query.append(_FINDER_COLUMN_GNS_GROUPID_2);

			boolean bindFullName = false;

			if (fullName.isEmpty()) {
				query.append(_FINDER_COLUMN_GNS_FULLNAME_3);
			}
			else {
				bindFullName = true;

				query.append(_FINDER_COLUMN_GNS_FULLNAME_2);
			}

			query.append(_FINDER_COLUMN_GNS_ACCOUNTSTATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(AccountModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindFullName) {
					qPos.add(fullName);
				}

				qPos.add(accountStatus);

				if (!pagination) {
					list = (List<Account>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Account>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Account findByGNS_First(
			long groupId, String fullName, int accountStatus,
			OrderByComparator<Account> orderByComparator)
		throws NoSuchAccountException {

		Account account = fetchByGNS_First(
			groupId, fullName, accountStatus, orderByComparator);

		if (account != null) {
			return account;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", fullName=");
		msg.append(fullName);

		msg.append(", accountStatus=");
		msg.append(accountStatus);

		msg.append("}");

		throw new NoSuchAccountException(msg.toString());
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
	@Override
	public Account fetchByGNS_First(
		long groupId, String fullName, int accountStatus,
		OrderByComparator<Account> orderByComparator) {

		List<Account> list = findByGNS(
			groupId, fullName, accountStatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Account findByGNS_Last(
			long groupId, String fullName, int accountStatus,
			OrderByComparator<Account> orderByComparator)
		throws NoSuchAccountException {

		Account account = fetchByGNS_Last(
			groupId, fullName, accountStatus, orderByComparator);

		if (account != null) {
			return account;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", fullName=");
		msg.append(fullName);

		msg.append(", accountStatus=");
		msg.append(accountStatus);

		msg.append("}");

		throw new NoSuchAccountException(msg.toString());
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
	@Override
	public Account fetchByGNS_Last(
		long groupId, String fullName, int accountStatus,
		OrderByComparator<Account> orderByComparator) {

		int count = countByGNS(groupId, fullName, accountStatus);

		if (count == 0) {
			return null;
		}

		List<Account> list = findByGNS(
			groupId, fullName, accountStatus, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Account[] findByGNS_PrevAndNext(
			long accountId, long groupId, String fullName, int accountStatus,
			OrderByComparator<Account> orderByComparator)
		throws NoSuchAccountException {

		fullName = Objects.toString(fullName, "");

		Account account = findByPrimaryKey(accountId);

		Session session = null;

		try {
			session = openSession();

			Account[] array = new AccountImpl[3];

			array[0] = getByGNS_PrevAndNext(
				session, account, groupId, fullName, accountStatus,
				orderByComparator, true);

			array[1] = account;

			array[2] = getByGNS_PrevAndNext(
				session, account, groupId, fullName, accountStatus,
				orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Account getByGNS_PrevAndNext(
		Session session, Account account, long groupId, String fullName,
		int accountStatus, OrderByComparator<Account> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_ACCOUNT_WHERE);

		query.append(_FINDER_COLUMN_GNS_GROUPID_2);

		boolean bindFullName = false;

		if (fullName.isEmpty()) {
			query.append(_FINDER_COLUMN_GNS_FULLNAME_3);
		}
		else {
			bindFullName = true;

			query.append(_FINDER_COLUMN_GNS_FULLNAME_2);
		}

		query.append(_FINDER_COLUMN_GNS_ACCOUNTSTATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(AccountModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (bindFullName) {
			qPos.add(fullName);
		}

		qPos.add(accountStatus);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(account)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Account> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the accounts where groupId = &#63; and fullName LIKE &#63; and accountStatus = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param accountStatus the account status
	 */
	@Override
	public void removeByGNS(long groupId, String fullName, int accountStatus) {
		for (Account account :
				findByGNS(
					groupId, fullName, accountStatus, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(account);
		}
	}

	/**
	 * Returns the number of accounts where groupId = &#63; and fullName LIKE &#63; and accountStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param fullName the full name
	 * @param accountStatus the account status
	 * @return the number of matching accounts
	 */
	@Override
	public int countByGNS(long groupId, String fullName, int accountStatus) {
		fullName = Objects.toString(fullName, "");

		FinderPath finderPath = _finderPathWithPaginationCountByGNS;

		Object[] finderArgs = new Object[] {groupId, fullName, accountStatus};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_ACCOUNT_WHERE);

			query.append(_FINDER_COLUMN_GNS_GROUPID_2);

			boolean bindFullName = false;

			if (fullName.isEmpty()) {
				query.append(_FINDER_COLUMN_GNS_FULLNAME_3);
			}
			else {
				bindFullName = true;

				query.append(_FINDER_COLUMN_GNS_FULLNAME_2);
			}

			query.append(_FINDER_COLUMN_GNS_ACCOUNTSTATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindFullName) {
					qPos.add(fullName);
				}

				qPos.add(accountStatus);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GNS_GROUPID_2 =
		"account.groupId = ? AND ";

	private static final String _FINDER_COLUMN_GNS_FULLNAME_2 =
		"account.fullName LIKE ? AND ";

	private static final String _FINDER_COLUMN_GNS_FULLNAME_3 =
		"(account.fullName IS NULL OR account.fullName LIKE '') AND ";

	private static final String _FINDER_COLUMN_GNS_ACCOUNTSTATUS_2 =
		"account.accountStatus = ?";

	private FinderPath _finderPathFetchByPersonalId;
	private FinderPath _finderPathCountByPersonalId;

	/**
	 * Returns the account where personalId = &#63; or throws a <code>NoSuchAccountException</code> if it could not be found.
	 *
	 * @param personalId the personal ID
	 * @return the matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	@Override
	public Account findByPersonalId(String personalId)
		throws NoSuchAccountException {

		Account account = fetchByPersonalId(personalId);

		if (account == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("personalId=");
			msg.append(personalId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchAccountException(msg.toString());
		}

		return account;
	}

	/**
	 * Returns the account where personalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param personalId the personal ID
	 * @return the matching account, or <code>null</code> if a matching account could not be found
	 */
	@Override
	public Account fetchByPersonalId(String personalId) {
		return fetchByPersonalId(personalId, true);
	}

	/**
	 * Returns the account where personalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param personalId the personal ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching account, or <code>null</code> if a matching account could not be found
	 */
	@Override
	public Account fetchByPersonalId(
		String personalId, boolean retrieveFromCache) {

		personalId = Objects.toString(personalId, "");

		Object[] finderArgs = new Object[] {personalId};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByPersonalId, finderArgs, this);
		}

		if (result instanceof Account) {
			Account account = (Account)result;

			if (!Objects.equals(personalId, account.getPersonalId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ACCOUNT_WHERE);

			boolean bindPersonalId = false;

			if (personalId.isEmpty()) {
				query.append(_FINDER_COLUMN_PERSONALID_PERSONALID_3);
			}
			else {
				bindPersonalId = true;

				query.append(_FINDER_COLUMN_PERSONALID_PERSONALID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPersonalId) {
					qPos.add(personalId);
				}

				List<Account> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByPersonalId, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"AccountPersistenceImpl.fetchByPersonalId(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Account account = list.get(0);

					result = account;

					cacheResult(account);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathFetchByPersonalId, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Account)result;
		}
	}

	/**
	 * Removes the account where personalId = &#63; from the database.
	 *
	 * @param personalId the personal ID
	 * @return the account that was removed
	 */
	@Override
	public Account removeByPersonalId(String personalId)
		throws NoSuchAccountException {

		Account account = findByPersonalId(personalId);

		return remove(account);
	}

	/**
	 * Returns the number of accounts where personalId = &#63;.
	 *
	 * @param personalId the personal ID
	 * @return the number of matching accounts
	 */
	@Override
	public int countByPersonalId(String personalId) {
		personalId = Objects.toString(personalId, "");

		FinderPath finderPath = _finderPathCountByPersonalId;

		Object[] finderArgs = new Object[] {personalId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ACCOUNT_WHERE);

			boolean bindPersonalId = false;

			if (personalId.isEmpty()) {
				query.append(_FINDER_COLUMN_PERSONALID_PERSONALID_3);
			}
			else {
				bindPersonalId = true;

				query.append(_FINDER_COLUMN_PERSONALID_PERSONALID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPersonalId) {
					qPos.add(personalId);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_PERSONALID_PERSONALID_2 =
		"account.personalId = ?";

	private static final String _FINDER_COLUMN_PERSONALID_PERSONALID_3 =
		"(account.personalId IS NULL OR account.personalId = '')";

	private FinderPath _finderPathFetchByuserId;
	private FinderPath _finderPathCountByuserId;

	/**
	 * Returns the account where userId = &#63; or throws a <code>NoSuchAccountException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	@Override
	public Account findByuserId(long userId) throws NoSuchAccountException {
		Account account = fetchByuserId(userId);

		if (account == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchAccountException(msg.toString());
		}

		return account;
	}

	/**
	 * Returns the account where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching account, or <code>null</code> if a matching account could not be found
	 */
	@Override
	public Account fetchByuserId(long userId) {
		return fetchByuserId(userId, true);
	}

	/**
	 * Returns the account where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching account, or <code>null</code> if a matching account could not be found
	 */
	@Override
	public Account fetchByuserId(long userId, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] {userId};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByuserId, finderArgs, this);
		}

		if (result instanceof Account) {
			Account account = (Account)result;

			if ((userId != account.getUserId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ACCOUNT_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				List<Account> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByuserId, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"AccountPersistenceImpl.fetchByuserId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Account account = list.get(0);

					result = account;

					cacheResult(account);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(_finderPathFetchByuserId, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Account)result;
		}
	}

	/**
	 * Removes the account where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the account that was removed
	 */
	@Override
	public Account removeByuserId(long userId) throws NoSuchAccountException {
		Account account = findByuserId(userId);

		return remove(account);
	}

	/**
	 * Returns the number of accounts where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching accounts
	 */
	@Override
	public int countByuserId(long userId) {
		FinderPath finderPath = _finderPathCountByuserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ACCOUNT_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USERID_USERID_2 =
		"account.userId = ?";

	private FinderPath _finderPathFetchByaccountName;
	private FinderPath _finderPathCountByaccountName;

	/**
	 * Returns the account where accountName = &#63; or throws a <code>NoSuchAccountException</code> if it could not be found.
	 *
	 * @param accountName the account name
	 * @return the matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	@Override
	public Account findByaccountName(String accountName)
		throws NoSuchAccountException {

		Account account = fetchByaccountName(accountName);

		if (account == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("accountName=");
			msg.append(accountName);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchAccountException(msg.toString());
		}

		return account;
	}

	/**
	 * Returns the account where accountName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param accountName the account name
	 * @return the matching account, or <code>null</code> if a matching account could not be found
	 */
	@Override
	public Account fetchByaccountName(String accountName) {
		return fetchByaccountName(accountName, true);
	}

	/**
	 * Returns the account where accountName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param accountName the account name
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching account, or <code>null</code> if a matching account could not be found
	 */
	@Override
	public Account fetchByaccountName(
		String accountName, boolean retrieveFromCache) {

		accountName = Objects.toString(accountName, "");

		Object[] finderArgs = new Object[] {accountName};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByaccountName, finderArgs, this);
		}

		if (result instanceof Account) {
			Account account = (Account)result;

			if (!Objects.equals(accountName, account.getAccountName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ACCOUNT_WHERE);

			boolean bindAccountName = false;

			if (accountName.isEmpty()) {
				query.append(_FINDER_COLUMN_ACCOUNTNAME_ACCOUNTNAME_3);
			}
			else {
				bindAccountName = true;

				query.append(_FINDER_COLUMN_ACCOUNTNAME_ACCOUNTNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAccountName) {
					qPos.add(accountName);
				}

				List<Account> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByaccountName, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"AccountPersistenceImpl.fetchByaccountName(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Account account = list.get(0);

					result = account;

					cacheResult(account);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathFetchByaccountName, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Account)result;
		}
	}

	/**
	 * Removes the account where accountName = &#63; from the database.
	 *
	 * @param accountName the account name
	 * @return the account that was removed
	 */
	@Override
	public Account removeByaccountName(String accountName)
		throws NoSuchAccountException {

		Account account = findByaccountName(accountName);

		return remove(account);
	}

	/**
	 * Returns the number of accounts where accountName = &#63;.
	 *
	 * @param accountName the account name
	 * @return the number of matching accounts
	 */
	@Override
	public int countByaccountName(String accountName) {
		accountName = Objects.toString(accountName, "");

		FinderPath finderPath = _finderPathCountByaccountName;

		Object[] finderArgs = new Object[] {accountName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ACCOUNT_WHERE);

			boolean bindAccountName = false;

			if (accountName.isEmpty()) {
				query.append(_FINDER_COLUMN_ACCOUNTNAME_ACCOUNTNAME_3);
			}
			else {
				bindAccountName = true;

				query.append(_FINDER_COLUMN_ACCOUNTNAME_ACCOUNTNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAccountName) {
					qPos.add(accountName);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ACCOUNTNAME_ACCOUNTNAME_2 =
		"account.accountName = ?";

	private static final String _FINDER_COLUMN_ACCOUNTNAME_ACCOUNTNAME_3 =
		"(account.accountName IS NULL OR account.accountName = '')";

	private FinderPath _finderPathFetchByHoSoId;
	private FinderPath _finderPathCountByHoSoId;

	/**
	 * Returns the account where hoSoId = &#63; or throws a <code>NoSuchAccountException</code> if it could not be found.
	 *
	 * @param hoSoId the ho so ID
	 * @return the matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	@Override
	public Account findByHoSoId(long hoSoId) throws NoSuchAccountException {
		Account account = fetchByHoSoId(hoSoId);

		if (account == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("hoSoId=");
			msg.append(hoSoId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchAccountException(msg.toString());
		}

		return account;
	}

	/**
	 * Returns the account where hoSoId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param hoSoId the ho so ID
	 * @return the matching account, or <code>null</code> if a matching account could not be found
	 */
	@Override
	public Account fetchByHoSoId(long hoSoId) {
		return fetchByHoSoId(hoSoId, true);
	}

	/**
	 * Returns the account where hoSoId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param hoSoId the ho so ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching account, or <code>null</code> if a matching account could not be found
	 */
	@Override
	public Account fetchByHoSoId(long hoSoId, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] {hoSoId};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByHoSoId, finderArgs, this);
		}

		if (result instanceof Account) {
			Account account = (Account)result;

			if ((hoSoId != account.getHoSoId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ACCOUNT_WHERE);

			query.append(_FINDER_COLUMN_HOSOID_HOSOID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(hoSoId);

				List<Account> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByHoSoId, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"AccountPersistenceImpl.fetchByHoSoId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Account account = list.get(0);

					result = account;

					cacheResult(account);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(_finderPathFetchByHoSoId, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Account)result;
		}
	}

	/**
	 * Removes the account where hoSoId = &#63; from the database.
	 *
	 * @param hoSoId the ho so ID
	 * @return the account that was removed
	 */
	@Override
	public Account removeByHoSoId(long hoSoId) throws NoSuchAccountException {
		Account account = findByHoSoId(hoSoId);

		return remove(account);
	}

	/**
	 * Returns the number of accounts where hoSoId = &#63;.
	 *
	 * @param hoSoId the ho so ID
	 * @return the number of matching accounts
	 */
	@Override
	public int countByHoSoId(long hoSoId) {
		FinderPath finderPath = _finderPathCountByHoSoId;

		Object[] finderArgs = new Object[] {hoSoId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ACCOUNT_WHERE);

			query.append(_FINDER_COLUMN_HOSOID_HOSOID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(hoSoId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_HOSOID_HOSOID_2 =
		"account.hoSoId = ?";

	private FinderPath _finderPathWithPaginationFindByStatus;
	private FinderPath _finderPathWithoutPaginationFindByStatus;
	private FinderPath _finderPathCountByStatus;
	private FinderPath _finderPathWithPaginationCountByStatus;

	/**
	 * Returns all the accounts where accountStatus = &#63;.
	 *
	 * @param accountStatus the account status
	 * @return the matching accounts
	 */
	@Override
	public List<Account> findByStatus(int accountStatus) {
		return findByStatus(
			accountStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Account> findByStatus(int accountStatus, int start, int end) {
		return findByStatus(accountStatus, start, end, null);
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
	@Override
	public List<Account> findByStatus(
		int accountStatus, int start, int end,
		OrderByComparator<Account> orderByComparator) {

		return findByStatus(accountStatus, start, end, orderByComparator, true);
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
	@Override
	public List<Account> findByStatus(
		int accountStatus, int start, int end,
		OrderByComparator<Account> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByStatus;
			finderArgs = new Object[] {accountStatus};
		}
		else {
			finderPath = _finderPathWithPaginationFindByStatus;
			finderArgs = new Object[] {
				accountStatus, start, end, orderByComparator
			};
		}

		List<Account> list = null;

		if (retrieveFromCache) {
			list = (List<Account>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Account account : list) {
					if ((accountStatus != account.getAccountStatus())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_ACCOUNT_WHERE);

			query.append(_FINDER_COLUMN_STATUS_ACCOUNTSTATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(AccountModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(accountStatus);

				if (!pagination) {
					list = (List<Account>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Account>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first account in the ordered set where accountStatus = &#63;.
	 *
	 * @param accountStatus the account status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	@Override
	public Account findByStatus_First(
			int accountStatus, OrderByComparator<Account> orderByComparator)
		throws NoSuchAccountException {

		Account account = fetchByStatus_First(accountStatus, orderByComparator);

		if (account != null) {
			return account;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("accountStatus=");
		msg.append(accountStatus);

		msg.append("}");

		throw new NoSuchAccountException(msg.toString());
	}

	/**
	 * Returns the first account in the ordered set where accountStatus = &#63;.
	 *
	 * @param accountStatus the account status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account, or <code>null</code> if a matching account could not be found
	 */
	@Override
	public Account fetchByStatus_First(
		int accountStatus, OrderByComparator<Account> orderByComparator) {

		List<Account> list = findByStatus(
			accountStatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last account in the ordered set where accountStatus = &#63;.
	 *
	 * @param accountStatus the account status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	@Override
	public Account findByStatus_Last(
			int accountStatus, OrderByComparator<Account> orderByComparator)
		throws NoSuchAccountException {

		Account account = fetchByStatus_Last(accountStatus, orderByComparator);

		if (account != null) {
			return account;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("accountStatus=");
		msg.append(accountStatus);

		msg.append("}");

		throw new NoSuchAccountException(msg.toString());
	}

	/**
	 * Returns the last account in the ordered set where accountStatus = &#63;.
	 *
	 * @param accountStatus the account status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account, or <code>null</code> if a matching account could not be found
	 */
	@Override
	public Account fetchByStatus_Last(
		int accountStatus, OrderByComparator<Account> orderByComparator) {

		int count = countByStatus(accountStatus);

		if (count == 0) {
			return null;
		}

		List<Account> list = findByStatus(
			accountStatus, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Account[] findByStatus_PrevAndNext(
			long accountId, int accountStatus,
			OrderByComparator<Account> orderByComparator)
		throws NoSuchAccountException {

		Account account = findByPrimaryKey(accountId);

		Session session = null;

		try {
			session = openSession();

			Account[] array = new AccountImpl[3];

			array[0] = getByStatus_PrevAndNext(
				session, account, accountStatus, orderByComparator, true);

			array[1] = account;

			array[2] = getByStatus_PrevAndNext(
				session, account, accountStatus, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Account getByStatus_PrevAndNext(
		Session session, Account account, int accountStatus,
		OrderByComparator<Account> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ACCOUNT_WHERE);

		query.append(_FINDER_COLUMN_STATUS_ACCOUNTSTATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(AccountModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(accountStatus);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(account)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Account> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
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
	@Override
	public List<Account> findByStatus(int[] accountStatuses) {
		return findByStatus(
			accountStatuses, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Account> findByStatus(
		int[] accountStatuses, int start, int end) {

		return findByStatus(accountStatuses, start, end, null);
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
	@Override
	public List<Account> findByStatus(
		int[] accountStatuses, int start, int end,
		OrderByComparator<Account> orderByComparator) {

		return findByStatus(
			accountStatuses, start, end, orderByComparator, true);
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
	@Override
	public List<Account> findByStatus(
		int[] accountStatuses, int start, int end,
		OrderByComparator<Account> orderByComparator,
		boolean retrieveFromCache) {

		if (accountStatuses == null) {
			accountStatuses = new int[0];
		}
		else if (accountStatuses.length > 1) {
			accountStatuses = ArrayUtil.unique(accountStatuses);

			Arrays.sort(accountStatuses);
		}

		if (accountStatuses.length == 1) {
			return findByStatus(
				accountStatuses[0], start, end, orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderArgs = new Object[] {StringUtil.merge(accountStatuses)};
		}
		else {
			finderArgs = new Object[] {
				StringUtil.merge(accountStatuses), start, end, orderByComparator
			};
		}

		List<Account> list = null;

		if (retrieveFromCache) {
			list = (List<Account>)finderCache.getResult(
				_finderPathWithPaginationFindByStatus, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Account account : list) {
					if (!ArrayUtil.contains(
							accountStatuses, account.getAccountStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_ACCOUNT_WHERE);

			if (accountStatuses.length > 0) {
				query.append("(");

				query.append(_FINDER_COLUMN_STATUS_ACCOUNTSTATUS_7);

				query.append(StringUtil.merge(accountStatuses));

				query.append(")");

				query.append(")");
			}

			query.setStringAt(
				removeConjunction(query.stringAt(query.index() - 1)),
				query.index() - 1);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(AccountModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Account>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Account>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(
					_finderPathWithPaginationFindByStatus, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathWithPaginationFindByStatus, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the accounts where accountStatus = &#63; from the database.
	 *
	 * @param accountStatus the account status
	 */
	@Override
	public void removeByStatus(int accountStatus) {
		for (Account account :
				findByStatus(
					accountStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(account);
		}
	}

	/**
	 * Returns the number of accounts where accountStatus = &#63;.
	 *
	 * @param accountStatus the account status
	 * @return the number of matching accounts
	 */
	@Override
	public int countByStatus(int accountStatus) {
		FinderPath finderPath = _finderPathCountByStatus;

		Object[] finderArgs = new Object[] {accountStatus};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ACCOUNT_WHERE);

			query.append(_FINDER_COLUMN_STATUS_ACCOUNTSTATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(accountStatus);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of accounts where accountStatus = any &#63;.
	 *
	 * @param accountStatuses the account statuses
	 * @return the number of matching accounts
	 */
	@Override
	public int countByStatus(int[] accountStatuses) {
		if (accountStatuses == null) {
			accountStatuses = new int[0];
		}
		else if (accountStatuses.length > 1) {
			accountStatuses = ArrayUtil.unique(accountStatuses);

			Arrays.sort(accountStatuses);
		}

		Object[] finderArgs = new Object[] {StringUtil.merge(accountStatuses)};

		Long count = (Long)finderCache.getResult(
			_finderPathWithPaginationCountByStatus, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_ACCOUNT_WHERE);

			if (accountStatuses.length > 0) {
				query.append("(");

				query.append(_FINDER_COLUMN_STATUS_ACCOUNTSTATUS_7);

				query.append(StringUtil.merge(accountStatuses));

				query.append(")");

				query.append(")");
			}

			query.setStringAt(
				removeConjunction(query.stringAt(query.index() - 1)),
				query.index() - 1);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathWithPaginationCountByStatus, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathWithPaginationCountByStatus, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_STATUS_ACCOUNTSTATUS_2 =
		"account.accountStatus = ?";

	private static final String _FINDER_COLUMN_STATUS_ACCOUNTSTATUS_7 =
		"account.accountStatus IN (";

	public AccountPersistenceImpl() {
		setModelClass(Account.class);
	}

	/**
	 * Caches the account in the entity cache if it is enabled.
	 *
	 * @param account the account
	 */
	@Override
	public void cacheResult(Account account) {
		entityCache.putResult(
			AccountModelImpl.ENTITY_CACHE_ENABLED, AccountImpl.class,
			account.getPrimaryKey(), account);

		finderCache.putResult(
			_finderPathFetchByEmail, new Object[] {account.getEmail()},
			account);

		finderCache.putResult(
			_finderPathFetchByPersonalId,
			new Object[] {account.getPersonalId()}, account);

		finderCache.putResult(
			_finderPathFetchByuserId, new Object[] {account.getUserId()},
			account);

		finderCache.putResult(
			_finderPathFetchByaccountName,
			new Object[] {account.getAccountName()}, account);

		finderCache.putResult(
			_finderPathFetchByHoSoId, new Object[] {account.getHoSoId()},
			account);

		account.resetOriginalValues();
	}

	/**
	 * Caches the accounts in the entity cache if it is enabled.
	 *
	 * @param accounts the accounts
	 */
	@Override
	public void cacheResult(List<Account> accounts) {
		for (Account account : accounts) {
			if (entityCache.getResult(
					AccountModelImpl.ENTITY_CACHE_ENABLED, AccountImpl.class,
					account.getPrimaryKey()) == null) {

				cacheResult(account);
			}
			else {
				account.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all accounts.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AccountImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the account.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Account account) {
		entityCache.removeResult(
			AccountModelImpl.ENTITY_CACHE_ENABLED, AccountImpl.class,
			account.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((AccountModelImpl)account, true);
	}

	@Override
	public void clearCache(List<Account> accounts) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Account account : accounts) {
			entityCache.removeResult(
				AccountModelImpl.ENTITY_CACHE_ENABLED, AccountImpl.class,
				account.getPrimaryKey());

			clearUniqueFindersCache((AccountModelImpl)account, true);
		}
	}

	protected void cacheUniqueFindersCache(AccountModelImpl accountModelImpl) {
		Object[] args = new Object[] {accountModelImpl.getEmail()};

		finderCache.putResult(
			_finderPathCountByEmail, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByEmail, args, accountModelImpl, false);

		args = new Object[] {accountModelImpl.getPersonalId()};

		finderCache.putResult(
			_finderPathCountByPersonalId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByPersonalId, args, accountModelImpl, false);

		args = new Object[] {accountModelImpl.getUserId()};

		finderCache.putResult(
			_finderPathCountByuserId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByuserId, args, accountModelImpl, false);

		args = new Object[] {accountModelImpl.getAccountName()};

		finderCache.putResult(
			_finderPathCountByaccountName, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByaccountName, args, accountModelImpl, false);

		args = new Object[] {accountModelImpl.getHoSoId()};

		finderCache.putResult(
			_finderPathCountByHoSoId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByHoSoId, args, accountModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		AccountModelImpl accountModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {accountModelImpl.getEmail()};

			finderCache.removeResult(_finderPathCountByEmail, args);
			finderCache.removeResult(_finderPathFetchByEmail, args);
		}

		if ((accountModelImpl.getColumnBitmask() &
			 _finderPathFetchByEmail.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {accountModelImpl.getOriginalEmail()};

			finderCache.removeResult(_finderPathCountByEmail, args);
			finderCache.removeResult(_finderPathFetchByEmail, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {accountModelImpl.getPersonalId()};

			finderCache.removeResult(_finderPathCountByPersonalId, args);
			finderCache.removeResult(_finderPathFetchByPersonalId, args);
		}

		if ((accountModelImpl.getColumnBitmask() &
			 _finderPathFetchByPersonalId.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				accountModelImpl.getOriginalPersonalId()
			};

			finderCache.removeResult(_finderPathCountByPersonalId, args);
			finderCache.removeResult(_finderPathFetchByPersonalId, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {accountModelImpl.getUserId()};

			finderCache.removeResult(_finderPathCountByuserId, args);
			finderCache.removeResult(_finderPathFetchByuserId, args);
		}

		if ((accountModelImpl.getColumnBitmask() &
			 _finderPathFetchByuserId.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {accountModelImpl.getOriginalUserId()};

			finderCache.removeResult(_finderPathCountByuserId, args);
			finderCache.removeResult(_finderPathFetchByuserId, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {accountModelImpl.getAccountName()};

			finderCache.removeResult(_finderPathCountByaccountName, args);
			finderCache.removeResult(_finderPathFetchByaccountName, args);
		}

		if ((accountModelImpl.getColumnBitmask() &
			 _finderPathFetchByaccountName.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				accountModelImpl.getOriginalAccountName()
			};

			finderCache.removeResult(_finderPathCountByaccountName, args);
			finderCache.removeResult(_finderPathFetchByaccountName, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {accountModelImpl.getHoSoId()};

			finderCache.removeResult(_finderPathCountByHoSoId, args);
			finderCache.removeResult(_finderPathFetchByHoSoId, args);
		}

		if ((accountModelImpl.getColumnBitmask() &
			 _finderPathFetchByHoSoId.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {accountModelImpl.getOriginalHoSoId()};

			finderCache.removeResult(_finderPathCountByHoSoId, args);
			finderCache.removeResult(_finderPathFetchByHoSoId, args);
		}
	}

	/**
	 * Creates a new account with the primary key. Does not add the account to the database.
	 *
	 * @param accountId the primary key for the new account
	 * @return the new account
	 */
	@Override
	public Account create(long accountId) {
		Account account = new AccountImpl();

		account.setNew(true);
		account.setPrimaryKey(accountId);

		account.setCompanyId(companyProvider.getCompanyId());

		return account;
	}

	/**
	 * Removes the account with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param accountId the primary key of the account
	 * @return the account that was removed
	 * @throws NoSuchAccountException if a account with the primary key could not be found
	 */
	@Override
	public Account remove(long accountId) throws NoSuchAccountException {
		return remove((Serializable)accountId);
	}

	/**
	 * Removes the account with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the account
	 * @return the account that was removed
	 * @throws NoSuchAccountException if a account with the primary key could not be found
	 */
	@Override
	public Account remove(Serializable primaryKey)
		throws NoSuchAccountException {

		Session session = null;

		try {
			session = openSession();

			Account account = (Account)session.get(
				AccountImpl.class, primaryKey);

			if (account == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAccountException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(account);
		}
		catch (NoSuchAccountException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Account removeImpl(Account account) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(account)) {
				account = (Account)session.get(
					AccountImpl.class, account.getPrimaryKeyObj());
			}

			if (account != null) {
				session.delete(account);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (account != null) {
			clearCache(account);
		}

		return account;
	}

	@Override
	public Account updateImpl(Account account) {
		boolean isNew = account.isNew();

		if (!(account instanceof AccountModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(account.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(account);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in account proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Account implementation " +
					account.getClass());
		}

		AccountModelImpl accountModelImpl = (AccountModelImpl)account;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (account.getCreateDate() == null)) {
			if (serviceContext == null) {
				account.setCreateDate(now);
			}
			else {
				account.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!accountModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				account.setModifiedDate(now);
			}
			else {
				account.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (account.isNew()) {
				session.save(account);

				account.setNew(false);
			}
			else {
				account = (Account)session.merge(account);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!AccountModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {accountModelImpl.getAccountType()};

			finderCache.removeResult(_finderPathCountByaccountType, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByaccountType, args);

			args = new Object[] {accountModelImpl.getTelNo()};

			finderCache.removeResult(_finderPathCountByphone, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByphone, args);

			args = new Object[] {accountModelImpl.getTaxCode()};

			finderCache.removeResult(_finderPathCountBymst, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindBymst, args);

			args = new Object[] {accountModelImpl.getGroupId()};

			finderCache.removeResult(_finderPathCountByGroupId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroupId, args);

			args = new Object[] {
				accountModelImpl.getGroupId(),
				accountModelImpl.getAccountStatus()
			};

			finderCache.removeResult(_finderPathCountByGS, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGS, args);

			args = new Object[] {
				accountModelImpl.getGroupId(),
				accountModelImpl.getAccountStatus(),
				accountModelImpl.getCityCode()
			};

			finderCache.removeResult(_finderPathCountByGSC, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGSC, args);

			args = new Object[] {
				accountModelImpl.getGroupId(),
				accountModelImpl.getAccountStatus(),
				accountModelImpl.getDistrictCode()
			};

			finderCache.removeResult(_finderPathCountByGSD, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGSD, args);

			args = new Object[] {
				accountModelImpl.getGroupId(),
				accountModelImpl.getAccountStatus(),
				accountModelImpl.getWardCode()
			};

			finderCache.removeResult(_finderPathCountByGSW, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGSW, args);

			args = new Object[] {accountModelImpl.getAccountStatus()};

			finderCache.removeResult(_finderPathCountByStatus, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByStatus, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((accountModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByaccountType.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					accountModelImpl.getOriginalAccountType()
				};

				finderCache.removeResult(_finderPathCountByaccountType, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByaccountType, args);

				args = new Object[] {accountModelImpl.getAccountType()};

				finderCache.removeResult(_finderPathCountByaccountType, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByaccountType, args);
			}

			if ((accountModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByphone.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					accountModelImpl.getOriginalTelNo()
				};

				finderCache.removeResult(_finderPathCountByphone, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByphone, args);

				args = new Object[] {accountModelImpl.getTelNo()};

				finderCache.removeResult(_finderPathCountByphone, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByphone, args);
			}

			if ((accountModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindBymst.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					accountModelImpl.getOriginalTaxCode()
				};

				finderCache.removeResult(_finderPathCountBymst, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBymst, args);

				args = new Object[] {accountModelImpl.getTaxCode()};

				finderCache.removeResult(_finderPathCountBymst, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBymst, args);
			}

			if ((accountModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroupId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					accountModelImpl.getOriginalGroupId()
				};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);

				args = new Object[] {accountModelImpl.getGroupId()};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);
			}

			if ((accountModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGS.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					accountModelImpl.getOriginalGroupId(),
					accountModelImpl.getOriginalAccountStatus()
				};

				finderCache.removeResult(_finderPathCountByGS, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGS, args);

				args = new Object[] {
					accountModelImpl.getGroupId(),
					accountModelImpl.getAccountStatus()
				};

				finderCache.removeResult(_finderPathCountByGS, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGS, args);
			}

			if ((accountModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGSC.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					accountModelImpl.getOriginalGroupId(),
					accountModelImpl.getOriginalAccountStatus(),
					accountModelImpl.getOriginalCityCode()
				};

				finderCache.removeResult(_finderPathCountByGSC, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGSC, args);

				args = new Object[] {
					accountModelImpl.getGroupId(),
					accountModelImpl.getAccountStatus(),
					accountModelImpl.getCityCode()
				};

				finderCache.removeResult(_finderPathCountByGSC, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGSC, args);
			}

			if ((accountModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGSD.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					accountModelImpl.getOriginalGroupId(),
					accountModelImpl.getOriginalAccountStatus(),
					accountModelImpl.getOriginalDistrictCode()
				};

				finderCache.removeResult(_finderPathCountByGSD, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGSD, args);

				args = new Object[] {
					accountModelImpl.getGroupId(),
					accountModelImpl.getAccountStatus(),
					accountModelImpl.getDistrictCode()
				};

				finderCache.removeResult(_finderPathCountByGSD, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGSD, args);
			}

			if ((accountModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGSW.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					accountModelImpl.getOriginalGroupId(),
					accountModelImpl.getOriginalAccountStatus(),
					accountModelImpl.getOriginalWardCode()
				};

				finderCache.removeResult(_finderPathCountByGSW, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGSW, args);

				args = new Object[] {
					accountModelImpl.getGroupId(),
					accountModelImpl.getAccountStatus(),
					accountModelImpl.getWardCode()
				};

				finderCache.removeResult(_finderPathCountByGSW, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGSW, args);
			}

			if ((accountModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByStatus.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					accountModelImpl.getOriginalAccountStatus()
				};

				finderCache.removeResult(_finderPathCountByStatus, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByStatus, args);

				args = new Object[] {accountModelImpl.getAccountStatus()};

				finderCache.removeResult(_finderPathCountByStatus, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByStatus, args);
			}
		}

		entityCache.putResult(
			AccountModelImpl.ENTITY_CACHE_ENABLED, AccountImpl.class,
			account.getPrimaryKey(), account, false);

		clearUniqueFindersCache(accountModelImpl, false);
		cacheUniqueFindersCache(accountModelImpl);

		account.resetOriginalValues();

		return account;
	}

	/**
	 * Returns the account with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the account
	 * @return the account
	 * @throws NoSuchAccountException if a account with the primary key could not be found
	 */
	@Override
	public Account findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAccountException {

		Account account = fetchByPrimaryKey(primaryKey);

		if (account == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAccountException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return account;
	}

	/**
	 * Returns the account with the primary key or throws a <code>NoSuchAccountException</code> if it could not be found.
	 *
	 * @param accountId the primary key of the account
	 * @return the account
	 * @throws NoSuchAccountException if a account with the primary key could not be found
	 */
	@Override
	public Account findByPrimaryKey(long accountId)
		throws NoSuchAccountException {

		return findByPrimaryKey((Serializable)accountId);
	}

	/**
	 * Returns the account with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the account
	 * @return the account, or <code>null</code> if a account with the primary key could not be found
	 */
	@Override
	public Account fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			AccountModelImpl.ENTITY_CACHE_ENABLED, AccountImpl.class,
			primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Account account = (Account)serializable;

		if (account == null) {
			Session session = null;

			try {
				session = openSession();

				account = (Account)session.get(AccountImpl.class, primaryKey);

				if (account != null) {
					cacheResult(account);
				}
				else {
					entityCache.putResult(
						AccountModelImpl.ENTITY_CACHE_ENABLED,
						AccountImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					AccountModelImpl.ENTITY_CACHE_ENABLED, AccountImpl.class,
					primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return account;
	}

	/**
	 * Returns the account with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param accountId the primary key of the account
	 * @return the account, or <code>null</code> if a account with the primary key could not be found
	 */
	@Override
	public Account fetchByPrimaryKey(long accountId) {
		return fetchByPrimaryKey((Serializable)accountId);
	}

	@Override
	public Map<Serializable, Account> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Account> map = new HashMap<Serializable, Account>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Account account = fetchByPrimaryKey(primaryKey);

			if (account != null) {
				map.put(primaryKey, account);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				AccountModelImpl.ENTITY_CACHE_ENABLED, AccountImpl.class,
				primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Account)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_ACCOUNT_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(",");
		}

		query.setIndex(query.index() - 1);

		query.append(")");

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (Account account : (List<Account>)q.list()) {
				map.put(account.getPrimaryKeyObj(), account);

				cacheResult(account);

				uncachedPrimaryKeys.remove(account.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					AccountModelImpl.ENTITY_CACHE_ENABLED, AccountImpl.class,
					primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the accounts.
	 *
	 * @return the accounts
	 */
	@Override
	public List<Account> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Account> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Account> findAll(
		int start, int end, OrderByComparator<Account> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Account> findAll(
		int start, int end, OrderByComparator<Account> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindAll;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Account> list = null;

		if (retrieveFromCache) {
			list = (List<Account>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_ACCOUNT);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ACCOUNT;

				if (pagination) {
					sql = sql.concat(AccountModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Account>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Account>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the accounts from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Account account : findAll()) {
			remove(account);
		}
	}

	/**
	 * Returns the number of accounts.
	 *
	 * @return the number of accounts
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ACCOUNT);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AccountModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the account persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			AccountModelImpl.ENTITY_CACHE_ENABLED,
			AccountModelImpl.FINDER_CACHE_ENABLED, AccountImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			AccountModelImpl.ENTITY_CACHE_ENABLED,
			AccountModelImpl.FINDER_CACHE_ENABLED, AccountImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			AccountModelImpl.ENTITY_CACHE_ENABLED,
			AccountModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByaccountType = new FinderPath(
			AccountModelImpl.ENTITY_CACHE_ENABLED,
			AccountModelImpl.FINDER_CACHE_ENABLED, AccountImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByaccountType",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByaccountType = new FinderPath(
			AccountModelImpl.ENTITY_CACHE_ENABLED,
			AccountModelImpl.FINDER_CACHE_ENABLED, AccountImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByaccountType",
			new String[] {Integer.class.getName()},
			AccountModelImpl.ACCOUNTTYPE_COLUMN_BITMASK |
			AccountModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByaccountType = new FinderPath(
			AccountModelImpl.ENTITY_CACHE_ENABLED,
			AccountModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByaccountType",
			new String[] {Integer.class.getName()});

		_finderPathWithPaginationFindByphone = new FinderPath(
			AccountModelImpl.ENTITY_CACHE_ENABLED,
			AccountModelImpl.FINDER_CACHE_ENABLED, AccountImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByphone",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByphone = new FinderPath(
			AccountModelImpl.ENTITY_CACHE_ENABLED,
			AccountModelImpl.FINDER_CACHE_ENABLED, AccountImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByphone",
			new String[] {String.class.getName()},
			AccountModelImpl.TELNO_COLUMN_BITMASK |
			AccountModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByphone = new FinderPath(
			AccountModelImpl.ENTITY_CACHE_ENABLED,
			AccountModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByphone",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindBymst = new FinderPath(
			AccountModelImpl.ENTITY_CACHE_ENABLED,
			AccountModelImpl.FINDER_CACHE_ENABLED, AccountImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBymst",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindBymst = new FinderPath(
			AccountModelImpl.ENTITY_CACHE_ENABLED,
			AccountModelImpl.FINDER_CACHE_ENABLED, AccountImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBymst",
			new String[] {String.class.getName()},
			AccountModelImpl.TAXCODE_COLUMN_BITMASK |
			AccountModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountBymst = new FinderPath(
			AccountModelImpl.ENTITY_CACHE_ENABLED,
			AccountModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBymst",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByGroupId = new FinderPath(
			AccountModelImpl.ENTITY_CACHE_ENABLED,
			AccountModelImpl.FINDER_CACHE_ENABLED, AccountImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroupId = new FinderPath(
			AccountModelImpl.ENTITY_CACHE_ENABLED,
			AccountModelImpl.FINDER_CACHE_ENABLED, AccountImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] {Long.class.getName()},
			AccountModelImpl.GROUPID_COLUMN_BITMASK |
			AccountModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByGroupId = new FinderPath(
			AccountModelImpl.ENTITY_CACHE_ENABLED,
			AccountModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByGS = new FinderPath(
			AccountModelImpl.ENTITY_CACHE_ENABLED,
			AccountModelImpl.FINDER_CACHE_ENABLED, AccountImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGS",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGS = new FinderPath(
			AccountModelImpl.ENTITY_CACHE_ENABLED,
			AccountModelImpl.FINDER_CACHE_ENABLED, AccountImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGS",
			new String[] {Long.class.getName(), Integer.class.getName()},
			AccountModelImpl.GROUPID_COLUMN_BITMASK |
			AccountModelImpl.ACCOUNTSTATUS_COLUMN_BITMASK |
			AccountModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByGS = new FinderPath(
			AccountModelImpl.ENTITY_CACHE_ENABLED,
			AccountModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGS",
			new String[] {Long.class.getName(), Integer.class.getName()});

		_finderPathWithPaginationFindByGSC = new FinderPath(
			AccountModelImpl.ENTITY_CACHE_ENABLED,
			AccountModelImpl.FINDER_CACHE_ENABLED, AccountImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGSC",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGSC = new FinderPath(
			AccountModelImpl.ENTITY_CACHE_ENABLED,
			AccountModelImpl.FINDER_CACHE_ENABLED, AccountImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGSC",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				String.class.getName()
			},
			AccountModelImpl.GROUPID_COLUMN_BITMASK |
			AccountModelImpl.ACCOUNTSTATUS_COLUMN_BITMASK |
			AccountModelImpl.CITYCODE_COLUMN_BITMASK |
			AccountModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByGSC = new FinderPath(
			AccountModelImpl.ENTITY_CACHE_ENABLED,
			AccountModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGSC",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				String.class.getName()
			});

		_finderPathWithPaginationFindByGSD = new FinderPath(
			AccountModelImpl.ENTITY_CACHE_ENABLED,
			AccountModelImpl.FINDER_CACHE_ENABLED, AccountImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGSD",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGSD = new FinderPath(
			AccountModelImpl.ENTITY_CACHE_ENABLED,
			AccountModelImpl.FINDER_CACHE_ENABLED, AccountImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGSD",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				String.class.getName()
			},
			AccountModelImpl.GROUPID_COLUMN_BITMASK |
			AccountModelImpl.ACCOUNTSTATUS_COLUMN_BITMASK |
			AccountModelImpl.DISTRICTCODE_COLUMN_BITMASK |
			AccountModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByGSD = new FinderPath(
			AccountModelImpl.ENTITY_CACHE_ENABLED,
			AccountModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGSD",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				String.class.getName()
			});

		_finderPathWithPaginationFindByGSW = new FinderPath(
			AccountModelImpl.ENTITY_CACHE_ENABLED,
			AccountModelImpl.FINDER_CACHE_ENABLED, AccountImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGSW",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGSW = new FinderPath(
			AccountModelImpl.ENTITY_CACHE_ENABLED,
			AccountModelImpl.FINDER_CACHE_ENABLED, AccountImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGSW",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				String.class.getName()
			},
			AccountModelImpl.GROUPID_COLUMN_BITMASK |
			AccountModelImpl.ACCOUNTSTATUS_COLUMN_BITMASK |
			AccountModelImpl.WARDCODE_COLUMN_BITMASK |
			AccountModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByGSW = new FinderPath(
			AccountModelImpl.ENTITY_CACHE_ENABLED,
			AccountModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGSW",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				String.class.getName()
			});

		_finderPathFetchByEmail = new FinderPath(
			AccountModelImpl.ENTITY_CACHE_ENABLED,
			AccountModelImpl.FINDER_CACHE_ENABLED, AccountImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByEmail",
			new String[] {String.class.getName()},
			AccountModelImpl.EMAIL_COLUMN_BITMASK);

		_finderPathCountByEmail = new FinderPath(
			AccountModelImpl.ENTITY_CACHE_ENABLED,
			AccountModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmail",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByGN = new FinderPath(
			AccountModelImpl.ENTITY_CACHE_ENABLED,
			AccountModelImpl.FINDER_CACHE_ENABLED, AccountImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGN",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithPaginationCountByGN = new FinderPath(
			AccountModelImpl.ENTITY_CACHE_ENABLED,
			AccountModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByGN",
			new String[] {Long.class.getName(), String.class.getName()});

		_finderPathWithPaginationFindByGNS = new FinderPath(
			AccountModelImpl.ENTITY_CACHE_ENABLED,
			AccountModelImpl.FINDER_CACHE_ENABLED, AccountImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGNS",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithPaginationCountByGNS = new FinderPath(
			AccountModelImpl.ENTITY_CACHE_ENABLED,
			AccountModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByGNS",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName()
			});

		_finderPathFetchByPersonalId = new FinderPath(
			AccountModelImpl.ENTITY_CACHE_ENABLED,
			AccountModelImpl.FINDER_CACHE_ENABLED, AccountImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByPersonalId",
			new String[] {String.class.getName()},
			AccountModelImpl.PERSONALID_COLUMN_BITMASK);

		_finderPathCountByPersonalId = new FinderPath(
			AccountModelImpl.ENTITY_CACHE_ENABLED,
			AccountModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPersonalId",
			new String[] {String.class.getName()});

		_finderPathFetchByuserId = new FinderPath(
			AccountModelImpl.ENTITY_CACHE_ENABLED,
			AccountModelImpl.FINDER_CACHE_ENABLED, AccountImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByuserId",
			new String[] {Long.class.getName()},
			AccountModelImpl.USERID_COLUMN_BITMASK);

		_finderPathCountByuserId = new FinderPath(
			AccountModelImpl.ENTITY_CACHE_ENABLED,
			AccountModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByuserId",
			new String[] {Long.class.getName()});

		_finderPathFetchByaccountName = new FinderPath(
			AccountModelImpl.ENTITY_CACHE_ENABLED,
			AccountModelImpl.FINDER_CACHE_ENABLED, AccountImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByaccountName",
			new String[] {String.class.getName()},
			AccountModelImpl.ACCOUNTNAME_COLUMN_BITMASK);

		_finderPathCountByaccountName = new FinderPath(
			AccountModelImpl.ENTITY_CACHE_ENABLED,
			AccountModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByaccountName",
			new String[] {String.class.getName()});

		_finderPathFetchByHoSoId = new FinderPath(
			AccountModelImpl.ENTITY_CACHE_ENABLED,
			AccountModelImpl.FINDER_CACHE_ENABLED, AccountImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByHoSoId",
			new String[] {Long.class.getName()},
			AccountModelImpl.HOSOID_COLUMN_BITMASK);

		_finderPathCountByHoSoId = new FinderPath(
			AccountModelImpl.ENTITY_CACHE_ENABLED,
			AccountModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByHoSoId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByStatus = new FinderPath(
			AccountModelImpl.ENTITY_CACHE_ENABLED,
			AccountModelImpl.FINDER_CACHE_ENABLED, AccountImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByStatus = new FinderPath(
			AccountModelImpl.ENTITY_CACHE_ENABLED,
			AccountModelImpl.FINDER_CACHE_ENABLED, AccountImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] {Integer.class.getName()},
			AccountModelImpl.ACCOUNTSTATUS_COLUMN_BITMASK |
			AccountModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByStatus = new FinderPath(
			AccountModelImpl.ENTITY_CACHE_ENABLED,
			AccountModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] {Integer.class.getName()});

		_finderPathWithPaginationCountByStatus = new FinderPath(
			AccountModelImpl.ENTITY_CACHE_ENABLED,
			AccountModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByStatus",
			new String[] {Integer.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(AccountImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_ACCOUNT =
		"SELECT account FROM Account account";

	private static final String _SQL_SELECT_ACCOUNT_WHERE_PKS_IN =
		"SELECT account FROM Account account WHERE accountId IN (";

	private static final String _SQL_SELECT_ACCOUNT_WHERE =
		"SELECT account FROM Account account WHERE ";

	private static final String _SQL_COUNT_ACCOUNT =
		"SELECT COUNT(account) FROM Account account";

	private static final String _SQL_COUNT_ACCOUNT_WHERE =
		"SELECT COUNT(account) FROM Account account WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "account.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Account exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Account exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AccountPersistenceImpl.class);

}