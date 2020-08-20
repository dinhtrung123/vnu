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

import org.oep.core.exception.NoSuchPhanQuyenException;
import org.oep.core.model.PhanQuyen;
import org.oep.core.model.impl.PhanQuyenImpl;
import org.oep.core.model.impl.PhanQuyenModelImpl;
import org.oep.core.service.persistence.PhanQuyenPersistence;

/**
 * The persistence implementation for the phan quyen service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author manhlb
 * @generated
 */
@ProviderType
public class PhanQuyenPersistenceImpl
	extends BasePersistenceImpl<PhanQuyen> implements PhanQuyenPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PhanQuyenUtil</code> to access the phan quyen persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PhanQuyenImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByCN_PK;
	private FinderPath _finderPathCountByCN_PK;

	/**
	 * Returns the phan quyen where classname = &#63; and classpk = &#63; or throws a <code>NoSuchPhanQuyenException</code> if it could not be found.
	 *
	 * @param classname the classname
	 * @param classpk the classpk
	 * @return the matching phan quyen
	 * @throws NoSuchPhanQuyenException if a matching phan quyen could not be found
	 */
	@Override
	public PhanQuyen findByCN_PK(String classname, long classpk)
		throws NoSuchPhanQuyenException {

		PhanQuyen phanQuyen = fetchByCN_PK(classname, classpk);

		if (phanQuyen == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("classname=");
			msg.append(classname);

			msg.append(", classpk=");
			msg.append(classpk);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchPhanQuyenException(msg.toString());
		}

		return phanQuyen;
	}

	/**
	 * Returns the phan quyen where classname = &#63; and classpk = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param classname the classname
	 * @param classpk the classpk
	 * @return the matching phan quyen, or <code>null</code> if a matching phan quyen could not be found
	 */
	@Override
	public PhanQuyen fetchByCN_PK(String classname, long classpk) {
		return fetchByCN_PK(classname, classpk, true);
	}

	/**
	 * Returns the phan quyen where classname = &#63; and classpk = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param classname the classname
	 * @param classpk the classpk
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching phan quyen, or <code>null</code> if a matching phan quyen could not be found
	 */
	@Override
	public PhanQuyen fetchByCN_PK(
		String classname, long classpk, boolean retrieveFromCache) {

		classname = Objects.toString(classname, "");

		Object[] finderArgs = new Object[] {classname, classpk};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByCN_PK, finderArgs, this);
		}

		if (result instanceof PhanQuyen) {
			PhanQuyen phanQuyen = (PhanQuyen)result;

			if (!Objects.equals(classname, phanQuyen.getClassname()) ||
				(classpk != phanQuyen.getClasspk())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_PHANQUYEN_WHERE);

			boolean bindClassname = false;

			if (classname.isEmpty()) {
				query.append(_FINDER_COLUMN_CN_PK_CLASSNAME_3);
			}
			else {
				bindClassname = true;

				query.append(_FINDER_COLUMN_CN_PK_CLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_CN_PK_CLASSPK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindClassname) {
					qPos.add(classname);
				}

				qPos.add(classpk);

				List<PhanQuyen> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByCN_PK, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"PhanQuyenPersistenceImpl.fetchByCN_PK(String, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					PhanQuyen phanQuyen = list.get(0);

					result = phanQuyen;

					cacheResult(phanQuyen);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(_finderPathFetchByCN_PK, finderArgs);

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
			return (PhanQuyen)result;
		}
	}

	/**
	 * Removes the phan quyen where classname = &#63; and classpk = &#63; from the database.
	 *
	 * @param classname the classname
	 * @param classpk the classpk
	 * @return the phan quyen that was removed
	 */
	@Override
	public PhanQuyen removeByCN_PK(String classname, long classpk)
		throws NoSuchPhanQuyenException {

		PhanQuyen phanQuyen = findByCN_PK(classname, classpk);

		return remove(phanQuyen);
	}

	/**
	 * Returns the number of phan quyens where classname = &#63; and classpk = &#63;.
	 *
	 * @param classname the classname
	 * @param classpk the classpk
	 * @return the number of matching phan quyens
	 */
	@Override
	public int countByCN_PK(String classname, long classpk) {
		classname = Objects.toString(classname, "");

		FinderPath finderPath = _finderPathCountByCN_PK;

		Object[] finderArgs = new Object[] {classname, classpk};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PHANQUYEN_WHERE);

			boolean bindClassname = false;

			if (classname.isEmpty()) {
				query.append(_FINDER_COLUMN_CN_PK_CLASSNAME_3);
			}
			else {
				bindClassname = true;

				query.append(_FINDER_COLUMN_CN_PK_CLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_CN_PK_CLASSPK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindClassname) {
					qPos.add(classname);
				}

				qPos.add(classpk);

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

	private static final String _FINDER_COLUMN_CN_PK_CLASSNAME_2 =
		"phanQuyen.classname = ? AND ";

	private static final String _FINDER_COLUMN_CN_PK_CLASSNAME_3 =
		"(phanQuyen.classname IS NULL OR phanQuyen.classname = '') AND ";

	private static final String _FINDER_COLUMN_CN_PK_CLASSPK_2 =
		"phanQuyen.classpk = ?";

	public PhanQuyenPersistenceImpl() {
		setModelClass(PhanQuyen.class);
	}

	/**
	 * Caches the phan quyen in the entity cache if it is enabled.
	 *
	 * @param phanQuyen the phan quyen
	 */
	@Override
	public void cacheResult(PhanQuyen phanQuyen) {
		entityCache.putResult(
			PhanQuyenModelImpl.ENTITY_CACHE_ENABLED, PhanQuyenImpl.class,
			phanQuyen.getPrimaryKey(), phanQuyen);

		finderCache.putResult(
			_finderPathFetchByCN_PK,
			new Object[] {phanQuyen.getClassname(), phanQuyen.getClasspk()},
			phanQuyen);

		phanQuyen.resetOriginalValues();
	}

	/**
	 * Caches the phan quyens in the entity cache if it is enabled.
	 *
	 * @param phanQuyens the phan quyens
	 */
	@Override
	public void cacheResult(List<PhanQuyen> phanQuyens) {
		for (PhanQuyen phanQuyen : phanQuyens) {
			if (entityCache.getResult(
					PhanQuyenModelImpl.ENTITY_CACHE_ENABLED,
					PhanQuyenImpl.class, phanQuyen.getPrimaryKey()) == null) {

				cacheResult(phanQuyen);
			}
			else {
				phanQuyen.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all phan quyens.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PhanQuyenImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the phan quyen.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PhanQuyen phanQuyen) {
		entityCache.removeResult(
			PhanQuyenModelImpl.ENTITY_CACHE_ENABLED, PhanQuyenImpl.class,
			phanQuyen.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((PhanQuyenModelImpl)phanQuyen, true);
	}

	@Override
	public void clearCache(List<PhanQuyen> phanQuyens) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PhanQuyen phanQuyen : phanQuyens) {
			entityCache.removeResult(
				PhanQuyenModelImpl.ENTITY_CACHE_ENABLED, PhanQuyenImpl.class,
				phanQuyen.getPrimaryKey());

			clearUniqueFindersCache((PhanQuyenModelImpl)phanQuyen, true);
		}
	}

	protected void cacheUniqueFindersCache(
		PhanQuyenModelImpl phanQuyenModelImpl) {

		Object[] args = new Object[] {
			phanQuyenModelImpl.getClassname(), phanQuyenModelImpl.getClasspk()
		};

		finderCache.putResult(
			_finderPathCountByCN_PK, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByCN_PK, args, phanQuyenModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		PhanQuyenModelImpl phanQuyenModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				phanQuyenModelImpl.getClassname(),
				phanQuyenModelImpl.getClasspk()
			};

			finderCache.removeResult(_finderPathCountByCN_PK, args);
			finderCache.removeResult(_finderPathFetchByCN_PK, args);
		}

		if ((phanQuyenModelImpl.getColumnBitmask() &
			 _finderPathFetchByCN_PK.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				phanQuyenModelImpl.getOriginalClassname(),
				phanQuyenModelImpl.getOriginalClasspk()
			};

			finderCache.removeResult(_finderPathCountByCN_PK, args);
			finderCache.removeResult(_finderPathFetchByCN_PK, args);
		}
	}

	/**
	 * Creates a new phan quyen with the primary key. Does not add the phan quyen to the database.
	 *
	 * @param id the primary key for the new phan quyen
	 * @return the new phan quyen
	 */
	@Override
	public PhanQuyen create(long id) {
		PhanQuyen phanQuyen = new PhanQuyenImpl();

		phanQuyen.setNew(true);
		phanQuyen.setPrimaryKey(id);

		return phanQuyen;
	}

	/**
	 * Removes the phan quyen with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the phan quyen
	 * @return the phan quyen that was removed
	 * @throws NoSuchPhanQuyenException if a phan quyen with the primary key could not be found
	 */
	@Override
	public PhanQuyen remove(long id) throws NoSuchPhanQuyenException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the phan quyen with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the phan quyen
	 * @return the phan quyen that was removed
	 * @throws NoSuchPhanQuyenException if a phan quyen with the primary key could not be found
	 */
	@Override
	public PhanQuyen remove(Serializable primaryKey)
		throws NoSuchPhanQuyenException {

		Session session = null;

		try {
			session = openSession();

			PhanQuyen phanQuyen = (PhanQuyen)session.get(
				PhanQuyenImpl.class, primaryKey);

			if (phanQuyen == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPhanQuyenException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(phanQuyen);
		}
		catch (NoSuchPhanQuyenException nsee) {
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
	protected PhanQuyen removeImpl(PhanQuyen phanQuyen) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(phanQuyen)) {
				phanQuyen = (PhanQuyen)session.get(
					PhanQuyenImpl.class, phanQuyen.getPrimaryKeyObj());
			}

			if (phanQuyen != null) {
				session.delete(phanQuyen);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (phanQuyen != null) {
			clearCache(phanQuyen);
		}

		return phanQuyen;
	}

	@Override
	public PhanQuyen updateImpl(PhanQuyen phanQuyen) {
		boolean isNew = phanQuyen.isNew();

		if (!(phanQuyen instanceof PhanQuyenModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(phanQuyen.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(phanQuyen);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in phanQuyen proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PhanQuyen implementation " +
					phanQuyen.getClass());
		}

		PhanQuyenModelImpl phanQuyenModelImpl = (PhanQuyenModelImpl)phanQuyen;

		Session session = null;

		try {
			session = openSession();

			if (phanQuyen.isNew()) {
				session.save(phanQuyen);

				phanQuyen.setNew(false);
			}
			else {
				phanQuyen = (PhanQuyen)session.merge(phanQuyen);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!PhanQuyenModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			PhanQuyenModelImpl.ENTITY_CACHE_ENABLED, PhanQuyenImpl.class,
			phanQuyen.getPrimaryKey(), phanQuyen, false);

		clearUniqueFindersCache(phanQuyenModelImpl, false);
		cacheUniqueFindersCache(phanQuyenModelImpl);

		phanQuyen.resetOriginalValues();

		return phanQuyen;
	}

	/**
	 * Returns the phan quyen with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the phan quyen
	 * @return the phan quyen
	 * @throws NoSuchPhanQuyenException if a phan quyen with the primary key could not be found
	 */
	@Override
	public PhanQuyen findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPhanQuyenException {

		PhanQuyen phanQuyen = fetchByPrimaryKey(primaryKey);

		if (phanQuyen == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPhanQuyenException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return phanQuyen;
	}

	/**
	 * Returns the phan quyen with the primary key or throws a <code>NoSuchPhanQuyenException</code> if it could not be found.
	 *
	 * @param id the primary key of the phan quyen
	 * @return the phan quyen
	 * @throws NoSuchPhanQuyenException if a phan quyen with the primary key could not be found
	 */
	@Override
	public PhanQuyen findByPrimaryKey(long id) throws NoSuchPhanQuyenException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the phan quyen with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the phan quyen
	 * @return the phan quyen, or <code>null</code> if a phan quyen with the primary key could not be found
	 */
	@Override
	public PhanQuyen fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			PhanQuyenModelImpl.ENTITY_CACHE_ENABLED, PhanQuyenImpl.class,
			primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		PhanQuyen phanQuyen = (PhanQuyen)serializable;

		if (phanQuyen == null) {
			Session session = null;

			try {
				session = openSession();

				phanQuyen = (PhanQuyen)session.get(
					PhanQuyenImpl.class, primaryKey);

				if (phanQuyen != null) {
					cacheResult(phanQuyen);
				}
				else {
					entityCache.putResult(
						PhanQuyenModelImpl.ENTITY_CACHE_ENABLED,
						PhanQuyenImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					PhanQuyenModelImpl.ENTITY_CACHE_ENABLED,
					PhanQuyenImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return phanQuyen;
	}

	/**
	 * Returns the phan quyen with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the phan quyen
	 * @return the phan quyen, or <code>null</code> if a phan quyen with the primary key could not be found
	 */
	@Override
	public PhanQuyen fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, PhanQuyen> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, PhanQuyen> map =
			new HashMap<Serializable, PhanQuyen>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			PhanQuyen phanQuyen = fetchByPrimaryKey(primaryKey);

			if (phanQuyen != null) {
				map.put(primaryKey, phanQuyen);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				PhanQuyenModelImpl.ENTITY_CACHE_ENABLED, PhanQuyenImpl.class,
				primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (PhanQuyen)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_PHANQUYEN_WHERE_PKS_IN);

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

			for (PhanQuyen phanQuyen : (List<PhanQuyen>)q.list()) {
				map.put(phanQuyen.getPrimaryKeyObj(), phanQuyen);

				cacheResult(phanQuyen);

				uncachedPrimaryKeys.remove(phanQuyen.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					PhanQuyenModelImpl.ENTITY_CACHE_ENABLED,
					PhanQuyenImpl.class, primaryKey, nullModel);
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
	 * Returns all the phan quyens.
	 *
	 * @return the phan quyens
	 */
	@Override
	public List<PhanQuyen> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the phan quyens.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PhanQuyenModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of phan quyens
	 * @param end the upper bound of the range of phan quyens (not inclusive)
	 * @return the range of phan quyens
	 */
	@Override
	public List<PhanQuyen> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the phan quyens.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PhanQuyenModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of phan quyens
	 * @param end the upper bound of the range of phan quyens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of phan quyens
	 */
	@Override
	public List<PhanQuyen> findAll(
		int start, int end, OrderByComparator<PhanQuyen> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the phan quyens.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PhanQuyenModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of phan quyens
	 * @param end the upper bound of the range of phan quyens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of phan quyens
	 */
	@Override
	public List<PhanQuyen> findAll(
		int start, int end, OrderByComparator<PhanQuyen> orderByComparator,
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

		List<PhanQuyen> list = null;

		if (retrieveFromCache) {
			list = (List<PhanQuyen>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PHANQUYEN);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PHANQUYEN;

				if (pagination) {
					sql = sql.concat(PhanQuyenModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PhanQuyen>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<PhanQuyen>)QueryUtil.list(
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
	 * Removes all the phan quyens from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PhanQuyen phanQuyen : findAll()) {
			remove(phanQuyen);
		}
	}

	/**
	 * Returns the number of phan quyens.
	 *
	 * @return the number of phan quyens
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PHANQUYEN);

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
		return PhanQuyenModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the phan quyen persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			PhanQuyenModelImpl.ENTITY_CACHE_ENABLED,
			PhanQuyenModelImpl.FINDER_CACHE_ENABLED, PhanQuyenImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			PhanQuyenModelImpl.ENTITY_CACHE_ENABLED,
			PhanQuyenModelImpl.FINDER_CACHE_ENABLED, PhanQuyenImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			PhanQuyenModelImpl.ENTITY_CACHE_ENABLED,
			PhanQuyenModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByCN_PK = new FinderPath(
			PhanQuyenModelImpl.ENTITY_CACHE_ENABLED,
			PhanQuyenModelImpl.FINDER_CACHE_ENABLED, PhanQuyenImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCN_PK",
			new String[] {String.class.getName(), Long.class.getName()},
			PhanQuyenModelImpl.CLASSNAME_COLUMN_BITMASK |
			PhanQuyenModelImpl.CLASSPK_COLUMN_BITMASK);

		_finderPathCountByCN_PK = new FinderPath(
			PhanQuyenModelImpl.ENTITY_CACHE_ENABLED,
			PhanQuyenModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCN_PK",
			new String[] {String.class.getName(), Long.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(PhanQuyenImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_PHANQUYEN =
		"SELECT phanQuyen FROM PhanQuyen phanQuyen";

	private static final String _SQL_SELECT_PHANQUYEN_WHERE_PKS_IN =
		"SELECT phanQuyen FROM PhanQuyen phanQuyen WHERE id IN (";

	private static final String _SQL_SELECT_PHANQUYEN_WHERE =
		"SELECT phanQuyen FROM PhanQuyen phanQuyen WHERE ";

	private static final String _SQL_COUNT_PHANQUYEN =
		"SELECT COUNT(phanQuyen) FROM PhanQuyen phanQuyen";

	private static final String _SQL_COUNT_PHANQUYEN_WHERE =
		"SELECT COUNT(phanQuyen) FROM PhanQuyen phanQuyen WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "phanQuyen.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PhanQuyen exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No PhanQuyen exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PhanQuyenPersistenceImpl.class);

}