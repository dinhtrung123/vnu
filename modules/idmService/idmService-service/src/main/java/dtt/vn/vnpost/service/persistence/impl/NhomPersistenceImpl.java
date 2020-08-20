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
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import dtt.vn.vnpost.exception.NoSuchNhomException;
import dtt.vn.vnpost.model.Nhom;
import dtt.vn.vnpost.model.impl.NhomImpl;
import dtt.vn.vnpost.model.impl.NhomModelImpl;
import dtt.vn.vnpost.service.persistence.NhomPersistence;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the nhom service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class NhomPersistenceImpl
	extends BasePersistenceImpl<Nhom> implements NhomPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>NhomUtil</code> to access the nhom persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		NhomImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByMa;
	private FinderPath _finderPathCountByMa;

	/**
	 * Returns the nhom where ma = &#63; or throws a <code>NoSuchNhomException</code> if it could not be found.
	 *
	 * @param ma the ma
	 * @return the matching nhom
	 * @throws NoSuchNhomException if a matching nhom could not be found
	 */
	@Override
	public Nhom findByMa(String ma) throws NoSuchNhomException {
		Nhom nhom = fetchByMa(ma);

		if (nhom == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ma=");
			msg.append(ma);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchNhomException(msg.toString());
		}

		return nhom;
	}

	/**
	 * Returns the nhom where ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ma the ma
	 * @return the matching nhom, or <code>null</code> if a matching nhom could not be found
	 */
	@Override
	public Nhom fetchByMa(String ma) {
		return fetchByMa(ma, true);
	}

	/**
	 * Returns the nhom where ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ma the ma
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching nhom, or <code>null</code> if a matching nhom could not be found
	 */
	@Override
	public Nhom fetchByMa(String ma, boolean retrieveFromCache) {
		ma = Objects.toString(ma, "");

		Object[] finderArgs = new Object[] {ma};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByMa, finderArgs, this);
		}

		if (result instanceof Nhom) {
			Nhom nhom = (Nhom)result;

			if (!Objects.equals(ma, nhom.getMa())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_NHOM_WHERE);

			boolean bindMa = false;

			if (ma.isEmpty()) {
				query.append(_FINDER_COLUMN_MA_MA_3);
			}
			else {
				bindMa = true;

				query.append(_FINDER_COLUMN_MA_MA_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindMa) {
					qPos.add(ma);
				}

				List<Nhom> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByMa, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"NhomPersistenceImpl.fetchByMa(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Nhom nhom = list.get(0);

					result = nhom;

					cacheResult(nhom);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(_finderPathFetchByMa, finderArgs);

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
			return (Nhom)result;
		}
	}

	/**
	 * Removes the nhom where ma = &#63; from the database.
	 *
	 * @param ma the ma
	 * @return the nhom that was removed
	 */
	@Override
	public Nhom removeByMa(String ma) throws NoSuchNhomException {
		Nhom nhom = findByMa(ma);

		return remove(nhom);
	}

	/**
	 * Returns the number of nhoms where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the number of matching nhoms
	 */
	@Override
	public int countByMa(String ma) {
		ma = Objects.toString(ma, "");

		FinderPath finderPath = _finderPathCountByMa;

		Object[] finderArgs = new Object[] {ma};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_NHOM_WHERE);

			boolean bindMa = false;

			if (ma.isEmpty()) {
				query.append(_FINDER_COLUMN_MA_MA_3);
			}
			else {
				bindMa = true;

				query.append(_FINDER_COLUMN_MA_MA_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindMa) {
					qPos.add(ma);
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

	private static final String _FINDER_COLUMN_MA_MA_2 = "nhom.ma = ?";

	private static final String _FINDER_COLUMN_MA_MA_3 =
		"(nhom.ma IS NULL OR nhom.ma = '')";

	public NhomPersistenceImpl() {
		setModelClass(Nhom.class);
	}

	/**
	 * Caches the nhom in the entity cache if it is enabled.
	 *
	 * @param nhom the nhom
	 */
	@Override
	public void cacheResult(Nhom nhom) {
		entityCache.putResult(
			NhomModelImpl.ENTITY_CACHE_ENABLED, NhomImpl.class,
			nhom.getPrimaryKey(), nhom);

		finderCache.putResult(
			_finderPathFetchByMa, new Object[] {nhom.getMa()}, nhom);

		nhom.resetOriginalValues();
	}

	/**
	 * Caches the nhoms in the entity cache if it is enabled.
	 *
	 * @param nhoms the nhoms
	 */
	@Override
	public void cacheResult(List<Nhom> nhoms) {
		for (Nhom nhom : nhoms) {
			if (entityCache.getResult(
					NhomModelImpl.ENTITY_CACHE_ENABLED, NhomImpl.class,
					nhom.getPrimaryKey()) == null) {

				cacheResult(nhom);
			}
			else {
				nhom.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all nhoms.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(NhomImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the nhom.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Nhom nhom) {
		entityCache.removeResult(
			NhomModelImpl.ENTITY_CACHE_ENABLED, NhomImpl.class,
			nhom.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((NhomModelImpl)nhom, true);
	}

	@Override
	public void clearCache(List<Nhom> nhoms) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Nhom nhom : nhoms) {
			entityCache.removeResult(
				NhomModelImpl.ENTITY_CACHE_ENABLED, NhomImpl.class,
				nhom.getPrimaryKey());

			clearUniqueFindersCache((NhomModelImpl)nhom, true);
		}
	}

	protected void cacheUniqueFindersCache(NhomModelImpl nhomModelImpl) {
		Object[] args = new Object[] {nhomModelImpl.getMa()};

		finderCache.putResult(
			_finderPathCountByMa, args, Long.valueOf(1), false);
		finderCache.putResult(_finderPathFetchByMa, args, nhomModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		NhomModelImpl nhomModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {nhomModelImpl.getMa()};

			finderCache.removeResult(_finderPathCountByMa, args);
			finderCache.removeResult(_finderPathFetchByMa, args);
		}

		if ((nhomModelImpl.getColumnBitmask() &
			 _finderPathFetchByMa.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {nhomModelImpl.getOriginalMa()};

			finderCache.removeResult(_finderPathCountByMa, args);
			finderCache.removeResult(_finderPathFetchByMa, args);
		}
	}

	/**
	 * Creates a new nhom with the primary key. Does not add the nhom to the database.
	 *
	 * @param id the primary key for the new nhom
	 * @return the new nhom
	 */
	@Override
	public Nhom create(long id) {
		Nhom nhom = new NhomImpl();

		nhom.setNew(true);
		nhom.setPrimaryKey(id);

		return nhom;
	}

	/**
	 * Removes the nhom with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the nhom
	 * @return the nhom that was removed
	 * @throws NoSuchNhomException if a nhom with the primary key could not be found
	 */
	@Override
	public Nhom remove(long id) throws NoSuchNhomException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the nhom with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the nhom
	 * @return the nhom that was removed
	 * @throws NoSuchNhomException if a nhom with the primary key could not be found
	 */
	@Override
	public Nhom remove(Serializable primaryKey) throws NoSuchNhomException {
		Session session = null;

		try {
			session = openSession();

			Nhom nhom = (Nhom)session.get(NhomImpl.class, primaryKey);

			if (nhom == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchNhomException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(nhom);
		}
		catch (NoSuchNhomException nsee) {
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
	protected Nhom removeImpl(Nhom nhom) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(nhom)) {
				nhom = (Nhom)session.get(
					NhomImpl.class, nhom.getPrimaryKeyObj());
			}

			if (nhom != null) {
				session.delete(nhom);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (nhom != null) {
			clearCache(nhom);
		}

		return nhom;
	}

	@Override
	public Nhom updateImpl(Nhom nhom) {
		boolean isNew = nhom.isNew();

		if (!(nhom instanceof NhomModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(nhom.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(nhom);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in nhom proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Nhom implementation " +
					nhom.getClass());
		}

		NhomModelImpl nhomModelImpl = (NhomModelImpl)nhom;

		Session session = null;

		try {
			session = openSession();

			if (nhom.isNew()) {
				session.save(nhom);

				nhom.setNew(false);
			}
			else {
				nhom = (Nhom)session.merge(nhom);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!NhomModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			NhomModelImpl.ENTITY_CACHE_ENABLED, NhomImpl.class,
			nhom.getPrimaryKey(), nhom, false);

		clearUniqueFindersCache(nhomModelImpl, false);
		cacheUniqueFindersCache(nhomModelImpl);

		nhom.resetOriginalValues();

		return nhom;
	}

	/**
	 * Returns the nhom with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the nhom
	 * @return the nhom
	 * @throws NoSuchNhomException if a nhom with the primary key could not be found
	 */
	@Override
	public Nhom findByPrimaryKey(Serializable primaryKey)
		throws NoSuchNhomException {

		Nhom nhom = fetchByPrimaryKey(primaryKey);

		if (nhom == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchNhomException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return nhom;
	}

	/**
	 * Returns the nhom with the primary key or throws a <code>NoSuchNhomException</code> if it could not be found.
	 *
	 * @param id the primary key of the nhom
	 * @return the nhom
	 * @throws NoSuchNhomException if a nhom with the primary key could not be found
	 */
	@Override
	public Nhom findByPrimaryKey(long id) throws NoSuchNhomException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the nhom with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the nhom
	 * @return the nhom, or <code>null</code> if a nhom with the primary key could not be found
	 */
	@Override
	public Nhom fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			NhomModelImpl.ENTITY_CACHE_ENABLED, NhomImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Nhom nhom = (Nhom)serializable;

		if (nhom == null) {
			Session session = null;

			try {
				session = openSession();

				nhom = (Nhom)session.get(NhomImpl.class, primaryKey);

				if (nhom != null) {
					cacheResult(nhom);
				}
				else {
					entityCache.putResult(
						NhomModelImpl.ENTITY_CACHE_ENABLED, NhomImpl.class,
						primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					NhomModelImpl.ENTITY_CACHE_ENABLED, NhomImpl.class,
					primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return nhom;
	}

	/**
	 * Returns the nhom with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the nhom
	 * @return the nhom, or <code>null</code> if a nhom with the primary key could not be found
	 */
	@Override
	public Nhom fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, Nhom> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Nhom> map = new HashMap<Serializable, Nhom>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Nhom nhom = fetchByPrimaryKey(primaryKey);

			if (nhom != null) {
				map.put(primaryKey, nhom);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				NhomModelImpl.ENTITY_CACHE_ENABLED, NhomImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Nhom)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_NHOM_WHERE_PKS_IN);

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

			for (Nhom nhom : (List<Nhom>)q.list()) {
				map.put(nhom.getPrimaryKeyObj(), nhom);

				cacheResult(nhom);

				uncachedPrimaryKeys.remove(nhom.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					NhomModelImpl.ENTITY_CACHE_ENABLED, NhomImpl.class,
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
	 * Returns all the nhoms.
	 *
	 * @return the nhoms
	 */
	@Override
	public List<Nhom> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the nhoms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>NhomModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of nhoms
	 * @param end the upper bound of the range of nhoms (not inclusive)
	 * @return the range of nhoms
	 */
	@Override
	public List<Nhom> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the nhoms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>NhomModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of nhoms
	 * @param end the upper bound of the range of nhoms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of nhoms
	 */
	@Override
	public List<Nhom> findAll(
		int start, int end, OrderByComparator<Nhom> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the nhoms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>NhomModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of nhoms
	 * @param end the upper bound of the range of nhoms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of nhoms
	 */
	@Override
	public List<Nhom> findAll(
		int start, int end, OrderByComparator<Nhom> orderByComparator,
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

		List<Nhom> list = null;

		if (retrieveFromCache) {
			list = (List<Nhom>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_NHOM);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_NHOM;

				if (pagination) {
					sql = sql.concat(NhomModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Nhom>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Nhom>)QueryUtil.list(
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
	 * Removes all the nhoms from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Nhom nhom : findAll()) {
			remove(nhom);
		}
	}

	/**
	 * Returns the number of nhoms.
	 *
	 * @return the number of nhoms
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_NHOM);

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
		return NhomModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the nhom persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			NhomModelImpl.ENTITY_CACHE_ENABLED,
			NhomModelImpl.FINDER_CACHE_ENABLED, NhomImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			NhomModelImpl.ENTITY_CACHE_ENABLED,
			NhomModelImpl.FINDER_CACHE_ENABLED, NhomImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			NhomModelImpl.ENTITY_CACHE_ENABLED,
			NhomModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByMa = new FinderPath(
			NhomModelImpl.ENTITY_CACHE_ENABLED,
			NhomModelImpl.FINDER_CACHE_ENABLED, NhomImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByMa",
			new String[] {String.class.getName()},
			NhomModelImpl.MA_COLUMN_BITMASK);

		_finderPathCountByMa = new FinderPath(
			NhomModelImpl.ENTITY_CACHE_ENABLED,
			NhomModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMa",
			new String[] {String.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(NhomImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_NHOM = "SELECT nhom FROM Nhom nhom";

	private static final String _SQL_SELECT_NHOM_WHERE_PKS_IN =
		"SELECT nhom FROM Nhom nhom WHERE id IN (";

	private static final String _SQL_SELECT_NHOM_WHERE =
		"SELECT nhom FROM Nhom nhom WHERE ";

	private static final String _SQL_COUNT_NHOM =
		"SELECT COUNT(nhom) FROM Nhom nhom";

	private static final String _SQL_COUNT_NHOM_WHERE =
		"SELECT COUNT(nhom) FROM Nhom nhom WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "nhom.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Nhom exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Nhom exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		NhomPersistenceImpl.class);

}