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

package dtt.vn.user.service.service.persistence.impl;

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
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import dtt.vn.user.service.exception.NoSuchAccountLogException;
import dtt.vn.user.service.model.AccountLog;
import dtt.vn.user.service.model.impl.AccountLogImpl;
import dtt.vn.user.service.model.impl.AccountLogModelImpl;
import dtt.vn.user.service.service.persistence.AccountLogPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the account log service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nhanvienDTT
 * @generated
 */
@ProviderType
public class AccountLogPersistenceImpl
	extends BasePersistenceImpl<AccountLog> implements AccountLogPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AccountLogUtil</code> to access the account log persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AccountLogImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByAccount;
	private FinderPath _finderPathWithoutPaginationFindByAccount;
	private FinderPath _finderPathCountByAccount;

	/**
	 * Returns all the account logs where accountId = &#63;.
	 *
	 * @param accountId the account ID
	 * @return the matching account logs
	 */
	@Override
	public List<AccountLog> findByAccount(long accountId) {
		return findByAccount(
			accountId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AccountLog> findByAccount(long accountId, int start, int end) {
		return findByAccount(accountId, start, end, null);
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
	@Override
	public List<AccountLog> findByAccount(
		long accountId, int start, int end,
		OrderByComparator<AccountLog> orderByComparator) {

		return findByAccount(accountId, start, end, orderByComparator, true);
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
	@Override
	public List<AccountLog> findByAccount(
		long accountId, int start, int end,
		OrderByComparator<AccountLog> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByAccount;
			finderArgs = new Object[] {accountId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByAccount;
			finderArgs = new Object[] {
				accountId, start, end, orderByComparator
			};
		}

		List<AccountLog> list = null;

		if (retrieveFromCache) {
			list = (List<AccountLog>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AccountLog accountLog : list) {
					if ((accountId != accountLog.getAccountId())) {
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

			query.append(_SQL_SELECT_ACCOUNTLOG_WHERE);

			query.append(_FINDER_COLUMN_ACCOUNT_ACCOUNTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(AccountLogModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(accountId);

				if (!pagination) {
					list = (List<AccountLog>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AccountLog>)QueryUtil.list(
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
	 * Returns the first account log in the ordered set where accountId = &#63;.
	 *
	 * @param accountId the account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account log
	 * @throws NoSuchAccountLogException if a matching account log could not be found
	 */
	@Override
	public AccountLog findByAccount_First(
			long accountId, OrderByComparator<AccountLog> orderByComparator)
		throws NoSuchAccountLogException {

		AccountLog accountLog = fetchByAccount_First(
			accountId, orderByComparator);

		if (accountLog != null) {
			return accountLog;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("accountId=");
		msg.append(accountId);

		msg.append("}");

		throw new NoSuchAccountLogException(msg.toString());
	}

	/**
	 * Returns the first account log in the ordered set where accountId = &#63;.
	 *
	 * @param accountId the account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account log, or <code>null</code> if a matching account log could not be found
	 */
	@Override
	public AccountLog fetchByAccount_First(
		long accountId, OrderByComparator<AccountLog> orderByComparator) {

		List<AccountLog> list = findByAccount(
			accountId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last account log in the ordered set where accountId = &#63;.
	 *
	 * @param accountId the account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account log
	 * @throws NoSuchAccountLogException if a matching account log could not be found
	 */
	@Override
	public AccountLog findByAccount_Last(
			long accountId, OrderByComparator<AccountLog> orderByComparator)
		throws NoSuchAccountLogException {

		AccountLog accountLog = fetchByAccount_Last(
			accountId, orderByComparator);

		if (accountLog != null) {
			return accountLog;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("accountId=");
		msg.append(accountId);

		msg.append("}");

		throw new NoSuchAccountLogException(msg.toString());
	}

	/**
	 * Returns the last account log in the ordered set where accountId = &#63;.
	 *
	 * @param accountId the account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account log, or <code>null</code> if a matching account log could not be found
	 */
	@Override
	public AccountLog fetchByAccount_Last(
		long accountId, OrderByComparator<AccountLog> orderByComparator) {

		int count = countByAccount(accountId);

		if (count == 0) {
			return null;
		}

		List<AccountLog> list = findByAccount(
			accountId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AccountLog[] findByAccount_PrevAndNext(
			long id, long accountId,
			OrderByComparator<AccountLog> orderByComparator)
		throws NoSuchAccountLogException {

		AccountLog accountLog = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			AccountLog[] array = new AccountLogImpl[3];

			array[0] = getByAccount_PrevAndNext(
				session, accountLog, accountId, orderByComparator, true);

			array[1] = accountLog;

			array[2] = getByAccount_PrevAndNext(
				session, accountLog, accountId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AccountLog getByAccount_PrevAndNext(
		Session session, AccountLog accountLog, long accountId,
		OrderByComparator<AccountLog> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ACCOUNTLOG_WHERE);

		query.append(_FINDER_COLUMN_ACCOUNT_ACCOUNTID_2);

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
			query.append(AccountLogModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(accountId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(accountLog)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<AccountLog> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the account logs where accountId = &#63; from the database.
	 *
	 * @param accountId the account ID
	 */
	@Override
	public void removeByAccount(long accountId) {
		for (AccountLog accountLog :
				findByAccount(
					accountId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(accountLog);
		}
	}

	/**
	 * Returns the number of account logs where accountId = &#63;.
	 *
	 * @param accountId the account ID
	 * @return the number of matching account logs
	 */
	@Override
	public int countByAccount(long accountId) {
		FinderPath finderPath = _finderPathCountByAccount;

		Object[] finderArgs = new Object[] {accountId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ACCOUNTLOG_WHERE);

			query.append(_FINDER_COLUMN_ACCOUNT_ACCOUNTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(accountId);

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

	private static final String _FINDER_COLUMN_ACCOUNT_ACCOUNTID_2 =
		"accountLog.accountId = ?";

	public AccountLogPersistenceImpl() {
		setModelClass(AccountLog.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("accountId", "account_id");
		dbColumnNames.put("nguoiSuaId", "nguoisua_id");
		dbColumnNames.put("tenNguoiSua", "ten_nguoisua");
		dbColumnNames.put("ngaySua", "ngaysua");
		dbColumnNames.put("emailNguoiSua", "email_nguoisua");
		dbColumnNames.put("phienBan", "phienban");

		try {
			Field field = BasePersistenceImpl.class.getDeclaredField(
				"_dbColumnNames");

			field.setAccessible(true);

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the account log in the entity cache if it is enabled.
	 *
	 * @param accountLog the account log
	 */
	@Override
	public void cacheResult(AccountLog accountLog) {
		entityCache.putResult(
			AccountLogModelImpl.ENTITY_CACHE_ENABLED, AccountLogImpl.class,
			accountLog.getPrimaryKey(), accountLog);

		accountLog.resetOriginalValues();
	}

	/**
	 * Caches the account logs in the entity cache if it is enabled.
	 *
	 * @param accountLogs the account logs
	 */
	@Override
	public void cacheResult(List<AccountLog> accountLogs) {
		for (AccountLog accountLog : accountLogs) {
			if (entityCache.getResult(
					AccountLogModelImpl.ENTITY_CACHE_ENABLED,
					AccountLogImpl.class, accountLog.getPrimaryKey()) == null) {

				cacheResult(accountLog);
			}
			else {
				accountLog.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all account logs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AccountLogImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the account log.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AccountLog accountLog) {
		entityCache.removeResult(
			AccountLogModelImpl.ENTITY_CACHE_ENABLED, AccountLogImpl.class,
			accountLog.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AccountLog> accountLogs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AccountLog accountLog : accountLogs) {
			entityCache.removeResult(
				AccountLogModelImpl.ENTITY_CACHE_ENABLED, AccountLogImpl.class,
				accountLog.getPrimaryKey());
		}
	}

	/**
	 * Creates a new account log with the primary key. Does not add the account log to the database.
	 *
	 * @param id the primary key for the new account log
	 * @return the new account log
	 */
	@Override
	public AccountLog create(long id) {
		AccountLog accountLog = new AccountLogImpl();

		accountLog.setNew(true);
		accountLog.setPrimaryKey(id);

		return accountLog;
	}

	/**
	 * Removes the account log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the account log
	 * @return the account log that was removed
	 * @throws NoSuchAccountLogException if a account log with the primary key could not be found
	 */
	@Override
	public AccountLog remove(long id) throws NoSuchAccountLogException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the account log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the account log
	 * @return the account log that was removed
	 * @throws NoSuchAccountLogException if a account log with the primary key could not be found
	 */
	@Override
	public AccountLog remove(Serializable primaryKey)
		throws NoSuchAccountLogException {

		Session session = null;

		try {
			session = openSession();

			AccountLog accountLog = (AccountLog)session.get(
				AccountLogImpl.class, primaryKey);

			if (accountLog == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAccountLogException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(accountLog);
		}
		catch (NoSuchAccountLogException nsee) {
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
	protected AccountLog removeImpl(AccountLog accountLog) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(accountLog)) {
				accountLog = (AccountLog)session.get(
					AccountLogImpl.class, accountLog.getPrimaryKeyObj());
			}

			if (accountLog != null) {
				session.delete(accountLog);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (accountLog != null) {
			clearCache(accountLog);
		}

		return accountLog;
	}

	@Override
	public AccountLog updateImpl(AccountLog accountLog) {
		boolean isNew = accountLog.isNew();

		if (!(accountLog instanceof AccountLogModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(accountLog.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(accountLog);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in accountLog proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AccountLog implementation " +
					accountLog.getClass());
		}

		AccountLogModelImpl accountLogModelImpl =
			(AccountLogModelImpl)accountLog;

		Session session = null;

		try {
			session = openSession();

			if (accountLog.isNew()) {
				session.save(accountLog);

				accountLog.setNew(false);
			}
			else {
				accountLog = (AccountLog)session.merge(accountLog);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!AccountLogModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {accountLogModelImpl.getAccountId()};

			finderCache.removeResult(_finderPathCountByAccount, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByAccount, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((accountLogModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByAccount.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					accountLogModelImpl.getOriginalAccountId()
				};

				finderCache.removeResult(_finderPathCountByAccount, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByAccount, args);

				args = new Object[] {accountLogModelImpl.getAccountId()};

				finderCache.removeResult(_finderPathCountByAccount, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByAccount, args);
			}
		}

		entityCache.putResult(
			AccountLogModelImpl.ENTITY_CACHE_ENABLED, AccountLogImpl.class,
			accountLog.getPrimaryKey(), accountLog, false);

		accountLog.resetOriginalValues();

		return accountLog;
	}

	/**
	 * Returns the account log with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the account log
	 * @return the account log
	 * @throws NoSuchAccountLogException if a account log with the primary key could not be found
	 */
	@Override
	public AccountLog findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAccountLogException {

		AccountLog accountLog = fetchByPrimaryKey(primaryKey);

		if (accountLog == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAccountLogException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return accountLog;
	}

	/**
	 * Returns the account log with the primary key or throws a <code>NoSuchAccountLogException</code> if it could not be found.
	 *
	 * @param id the primary key of the account log
	 * @return the account log
	 * @throws NoSuchAccountLogException if a account log with the primary key could not be found
	 */
	@Override
	public AccountLog findByPrimaryKey(long id)
		throws NoSuchAccountLogException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the account log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the account log
	 * @return the account log, or <code>null</code> if a account log with the primary key could not be found
	 */
	@Override
	public AccountLog fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			AccountLogModelImpl.ENTITY_CACHE_ENABLED, AccountLogImpl.class,
			primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		AccountLog accountLog = (AccountLog)serializable;

		if (accountLog == null) {
			Session session = null;

			try {
				session = openSession();

				accountLog = (AccountLog)session.get(
					AccountLogImpl.class, primaryKey);

				if (accountLog != null) {
					cacheResult(accountLog);
				}
				else {
					entityCache.putResult(
						AccountLogModelImpl.ENTITY_CACHE_ENABLED,
						AccountLogImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					AccountLogModelImpl.ENTITY_CACHE_ENABLED,
					AccountLogImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return accountLog;
	}

	/**
	 * Returns the account log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the account log
	 * @return the account log, or <code>null</code> if a account log with the primary key could not be found
	 */
	@Override
	public AccountLog fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, AccountLog> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, AccountLog> map =
			new HashMap<Serializable, AccountLog>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			AccountLog accountLog = fetchByPrimaryKey(primaryKey);

			if (accountLog != null) {
				map.put(primaryKey, accountLog);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				AccountLogModelImpl.ENTITY_CACHE_ENABLED, AccountLogImpl.class,
				primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (AccountLog)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_ACCOUNTLOG_WHERE_PKS_IN);

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

			for (AccountLog accountLog : (List<AccountLog>)q.list()) {
				map.put(accountLog.getPrimaryKeyObj(), accountLog);

				cacheResult(accountLog);

				uncachedPrimaryKeys.remove(accountLog.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					AccountLogModelImpl.ENTITY_CACHE_ENABLED,
					AccountLogImpl.class, primaryKey, nullModel);
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
	 * Returns all the account logs.
	 *
	 * @return the account logs
	 */
	@Override
	public List<AccountLog> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AccountLog> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<AccountLog> findAll(
		int start, int end, OrderByComparator<AccountLog> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<AccountLog> findAll(
		int start, int end, OrderByComparator<AccountLog> orderByComparator,
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

		List<AccountLog> list = null;

		if (retrieveFromCache) {
			list = (List<AccountLog>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_ACCOUNTLOG);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ACCOUNTLOG;

				if (pagination) {
					sql = sql.concat(AccountLogModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AccountLog>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AccountLog>)QueryUtil.list(
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
	 * Removes all the account logs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AccountLog accountLog : findAll()) {
			remove(accountLog);
		}
	}

	/**
	 * Returns the number of account logs.
	 *
	 * @return the number of account logs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ACCOUNTLOG);

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
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AccountLogModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the account log persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			AccountLogModelImpl.ENTITY_CACHE_ENABLED,
			AccountLogModelImpl.FINDER_CACHE_ENABLED, AccountLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			AccountLogModelImpl.ENTITY_CACHE_ENABLED,
			AccountLogModelImpl.FINDER_CACHE_ENABLED, AccountLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			AccountLogModelImpl.ENTITY_CACHE_ENABLED,
			AccountLogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByAccount = new FinderPath(
			AccountLogModelImpl.ENTITY_CACHE_ENABLED,
			AccountLogModelImpl.FINDER_CACHE_ENABLED, AccountLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAccount",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByAccount = new FinderPath(
			AccountLogModelImpl.ENTITY_CACHE_ENABLED,
			AccountLogModelImpl.FINDER_CACHE_ENABLED, AccountLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAccount",
			new String[] {Long.class.getName()},
			AccountLogModelImpl.ACCOUNTID_COLUMN_BITMASK |
			AccountLogModelImpl.PHIENBAN_COLUMN_BITMASK);

		_finderPathCountByAccount = new FinderPath(
			AccountLogModelImpl.ENTITY_CACHE_ENABLED,
			AccountLogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAccount",
			new String[] {Long.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(AccountLogImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_ACCOUNTLOG =
		"SELECT accountLog FROM AccountLog accountLog";

	private static final String _SQL_SELECT_ACCOUNTLOG_WHERE_PKS_IN =
		"SELECT accountLog FROM AccountLog accountLog WHERE id IN (";

	private static final String _SQL_SELECT_ACCOUNTLOG_WHERE =
		"SELECT accountLog FROM AccountLog accountLog WHERE ";

	private static final String _SQL_COUNT_ACCOUNTLOG =
		"SELECT COUNT(accountLog) FROM AccountLog accountLog";

	private static final String _SQL_COUNT_ACCOUNTLOG_WHERE =
		"SELECT COUNT(accountLog) FROM AccountLog accountLog WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "accountLog.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AccountLog exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No AccountLog exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AccountLogPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"accountId", "nguoiSuaId", "tenNguoiSua", "ngaySua",
			"emailNguoiSua", "phienBan"
		});

}