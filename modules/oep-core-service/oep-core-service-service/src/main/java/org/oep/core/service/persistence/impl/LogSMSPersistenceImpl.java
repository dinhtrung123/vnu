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

package org.oep.core.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.oep.core.exception.NoSuchLogSMSException;
import org.oep.core.model.LogSMS;
import org.oep.core.model.impl.LogSMSImpl;
import org.oep.core.model.impl.LogSMSModelImpl;
import org.oep.core.service.persistence.LogSMSPersistence;

/**
 * The persistence implementation for the log sms service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author manhlb
 * @generated
 */
@ProviderType
public class LogSMSPersistenceImpl
	extends BasePersistenceImpl<LogSMS> implements LogSMSPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LogSMSUtil</code> to access the log sms persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LogSMSImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public LogSMSPersistenceImpl() {
		setModelClass(LogSMS.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("sentDateTime", "sent_date_time");
		dbColumnNames.put("responseDate", "response_date");
		dbColumnNames.put("errorCode", "error_code");
		dbColumnNames.put("errorDetail", "error_detail");
		dbColumnNames.put("messageId", "message_id");

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
	 * Caches the log sms in the entity cache if it is enabled.
	 *
	 * @param logSMS the log sms
	 */
	@Override
	public void cacheResult(LogSMS logSMS) {
		entityCache.putResult(
			LogSMSModelImpl.ENTITY_CACHE_ENABLED, LogSMSImpl.class,
			logSMS.getPrimaryKey(), logSMS);

		logSMS.resetOriginalValues();
	}

	/**
	 * Caches the log smses in the entity cache if it is enabled.
	 *
	 * @param logSMSs the log smses
	 */
	@Override
	public void cacheResult(List<LogSMS> logSMSs) {
		for (LogSMS logSMS : logSMSs) {
			if (entityCache.getResult(
					LogSMSModelImpl.ENTITY_CACHE_ENABLED, LogSMSImpl.class,
					logSMS.getPrimaryKey()) == null) {

				cacheResult(logSMS);
			}
			else {
				logSMS.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all log smses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LogSMSImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the log sms.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LogSMS logSMS) {
		entityCache.removeResult(
			LogSMSModelImpl.ENTITY_CACHE_ENABLED, LogSMSImpl.class,
			logSMS.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LogSMS> logSMSs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LogSMS logSMS : logSMSs) {
			entityCache.removeResult(
				LogSMSModelImpl.ENTITY_CACHE_ENABLED, LogSMSImpl.class,
				logSMS.getPrimaryKey());
		}
	}

	/**
	 * Creates a new log sms with the primary key. Does not add the log sms to the database.
	 *
	 * @param id the primary key for the new log sms
	 * @return the new log sms
	 */
	@Override
	public LogSMS create(long id) {
		LogSMS logSMS = new LogSMSImpl();

		logSMS.setNew(true);
		logSMS.setPrimaryKey(id);

		return logSMS;
	}

	/**
	 * Removes the log sms with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the log sms
	 * @return the log sms that was removed
	 * @throws NoSuchLogSMSException if a log sms with the primary key could not be found
	 */
	@Override
	public LogSMS remove(long id) throws NoSuchLogSMSException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the log sms with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the log sms
	 * @return the log sms that was removed
	 * @throws NoSuchLogSMSException if a log sms with the primary key could not be found
	 */
	@Override
	public LogSMS remove(Serializable primaryKey) throws NoSuchLogSMSException {
		Session session = null;

		try {
			session = openSession();

			LogSMS logSMS = (LogSMS)session.get(LogSMSImpl.class, primaryKey);

			if (logSMS == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLogSMSException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(logSMS);
		}
		catch (NoSuchLogSMSException nsee) {
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
	protected LogSMS removeImpl(LogSMS logSMS) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(logSMS)) {
				logSMS = (LogSMS)session.get(
					LogSMSImpl.class, logSMS.getPrimaryKeyObj());
			}

			if (logSMS != null) {
				session.delete(logSMS);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (logSMS != null) {
			clearCache(logSMS);
		}

		return logSMS;
	}

	@Override
	public LogSMS updateImpl(LogSMS logSMS) {
		boolean isNew = logSMS.isNew();

		Session session = null;

		try {
			session = openSession();

			if (logSMS.isNew()) {
				session.save(logSMS);

				logSMS.setNew(false);
			}
			else {
				logSMS = (LogSMS)session.merge(logSMS);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			LogSMSModelImpl.ENTITY_CACHE_ENABLED, LogSMSImpl.class,
			logSMS.getPrimaryKey(), logSMS, false);

		logSMS.resetOriginalValues();

		return logSMS;
	}

	/**
	 * Returns the log sms with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the log sms
	 * @return the log sms
	 * @throws NoSuchLogSMSException if a log sms with the primary key could not be found
	 */
	@Override
	public LogSMS findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLogSMSException {

		LogSMS logSMS = fetchByPrimaryKey(primaryKey);

		if (logSMS == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLogSMSException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return logSMS;
	}

	/**
	 * Returns the log sms with the primary key or throws a <code>NoSuchLogSMSException</code> if it could not be found.
	 *
	 * @param id the primary key of the log sms
	 * @return the log sms
	 * @throws NoSuchLogSMSException if a log sms with the primary key could not be found
	 */
	@Override
	public LogSMS findByPrimaryKey(long id) throws NoSuchLogSMSException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the log sms with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the log sms
	 * @return the log sms, or <code>null</code> if a log sms with the primary key could not be found
	 */
	@Override
	public LogSMS fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			LogSMSModelImpl.ENTITY_CACHE_ENABLED, LogSMSImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		LogSMS logSMS = (LogSMS)serializable;

		if (logSMS == null) {
			Session session = null;

			try {
				session = openSession();

				logSMS = (LogSMS)session.get(LogSMSImpl.class, primaryKey);

				if (logSMS != null) {
					cacheResult(logSMS);
				}
				else {
					entityCache.putResult(
						LogSMSModelImpl.ENTITY_CACHE_ENABLED, LogSMSImpl.class,
						primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					LogSMSModelImpl.ENTITY_CACHE_ENABLED, LogSMSImpl.class,
					primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return logSMS;
	}

	/**
	 * Returns the log sms with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the log sms
	 * @return the log sms, or <code>null</code> if a log sms with the primary key could not be found
	 */
	@Override
	public LogSMS fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, LogSMS> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, LogSMS> map = new HashMap<Serializable, LogSMS>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			LogSMS logSMS = fetchByPrimaryKey(primaryKey);

			if (logSMS != null) {
				map.put(primaryKey, logSMS);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				LogSMSModelImpl.ENTITY_CACHE_ENABLED, LogSMSImpl.class,
				primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (LogSMS)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_LOGSMS_WHERE_PKS_IN);

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

			for (LogSMS logSMS : (List<LogSMS>)q.list()) {
				map.put(logSMS.getPrimaryKeyObj(), logSMS);

				cacheResult(logSMS);

				uncachedPrimaryKeys.remove(logSMS.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					LogSMSModelImpl.ENTITY_CACHE_ENABLED, LogSMSImpl.class,
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
	 * Returns all the log smses.
	 *
	 * @return the log smses
	 */
	@Override
	public List<LogSMS> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<LogSMS> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<LogSMS> findAll(
		int start, int end, OrderByComparator<LogSMS> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<LogSMS> findAll(
		int start, int end, OrderByComparator<LogSMS> orderByComparator,
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

		List<LogSMS> list = null;

		if (retrieveFromCache) {
			list = (List<LogSMS>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LOGSMS);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LOGSMS;

				if (pagination) {
					sql = sql.concat(LogSMSModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LogSMS>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<LogSMS>)QueryUtil.list(
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
	 * Removes all the log smses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LogSMS logSMS : findAll()) {
			remove(logSMS);
		}
	}

	/**
	 * Returns the number of log smses.
	 *
	 * @return the number of log smses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LOGSMS);

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
		return LogSMSModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the log sms persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			LogSMSModelImpl.ENTITY_CACHE_ENABLED,
			LogSMSModelImpl.FINDER_CACHE_ENABLED, LogSMSImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			LogSMSModelImpl.ENTITY_CACHE_ENABLED,
			LogSMSModelImpl.FINDER_CACHE_ENABLED, LogSMSImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			LogSMSModelImpl.ENTITY_CACHE_ENABLED,
			LogSMSModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	public void destroy() {
		entityCache.removeCache(LogSMSImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_LOGSMS =
		"SELECT logSMS FROM LogSMS logSMS";

	private static final String _SQL_SELECT_LOGSMS_WHERE_PKS_IN =
		"SELECT logSMS FROM LogSMS logSMS WHERE id IN (";

	private static final String _SQL_COUNT_LOGSMS =
		"SELECT COUNT(logSMS) FROM LogSMS logSMS";

	private static final String _ORDER_BY_ENTITY_ALIAS = "logSMS.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No LogSMS exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		LogSMSPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"sentDateTime", "responseDate", "errorCode", "errorDetail",
			"messageId"
		});

}