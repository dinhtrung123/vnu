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

import org.oep.core.exception.NoSuchMappingVmapException;
import org.oep.core.model.MappingVmap;
import org.oep.core.model.impl.MappingVmapImpl;
import org.oep.core.model.impl.MappingVmapModelImpl;
import org.oep.core.service.persistence.MappingVmapPersistence;

/**
 * The persistence implementation for the mapping vmap service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author manhlb
 * @generated
 */
@ProviderType
public class MappingVmapPersistenceImpl
	extends BasePersistenceImpl<MappingVmap> implements MappingVmapPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>MappingVmapUtil</code> to access the mapping vmap persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		MappingVmapImpl.class.getName();

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
	 * Returns the mapping vmap where classname = &#63; and classpk = &#63; or throws a <code>NoSuchMappingVmapException</code> if it could not be found.
	 *
	 * @param classname the classname
	 * @param classpk the classpk
	 * @return the matching mapping vmap
	 * @throws NoSuchMappingVmapException if a matching mapping vmap could not be found
	 */
	@Override
	public MappingVmap findByCN_PK(String classname, long classpk)
		throws NoSuchMappingVmapException {

		MappingVmap mappingVmap = fetchByCN_PK(classname, classpk);

		if (mappingVmap == null) {
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

			throw new NoSuchMappingVmapException(msg.toString());
		}

		return mappingVmap;
	}

	/**
	 * Returns the mapping vmap where classname = &#63; and classpk = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param classname the classname
	 * @param classpk the classpk
	 * @return the matching mapping vmap, or <code>null</code> if a matching mapping vmap could not be found
	 */
	@Override
	public MappingVmap fetchByCN_PK(String classname, long classpk) {
		return fetchByCN_PK(classname, classpk, true);
	}

	/**
	 * Returns the mapping vmap where classname = &#63; and classpk = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param classname the classname
	 * @param classpk the classpk
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching mapping vmap, or <code>null</code> if a matching mapping vmap could not be found
	 */
	@Override
	public MappingVmap fetchByCN_PK(
		String classname, long classpk, boolean retrieveFromCache) {

		classname = Objects.toString(classname, "");

		Object[] finderArgs = new Object[] {classname, classpk};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByCN_PK, finderArgs, this);
		}

		if (result instanceof MappingVmap) {
			MappingVmap mappingVmap = (MappingVmap)result;

			if (!Objects.equals(classname, mappingVmap.getClassname()) ||
				(classpk != mappingVmap.getClasspk())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_MAPPINGVMAP_WHERE);

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

				List<MappingVmap> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByCN_PK, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"MappingVmapPersistenceImpl.fetchByCN_PK(String, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					MappingVmap mappingVmap = list.get(0);

					result = mappingVmap;

					cacheResult(mappingVmap);
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
			return (MappingVmap)result;
		}
	}

	/**
	 * Removes the mapping vmap where classname = &#63; and classpk = &#63; from the database.
	 *
	 * @param classname the classname
	 * @param classpk the classpk
	 * @return the mapping vmap that was removed
	 */
	@Override
	public MappingVmap removeByCN_PK(String classname, long classpk)
		throws NoSuchMappingVmapException {

		MappingVmap mappingVmap = findByCN_PK(classname, classpk);

		return remove(mappingVmap);
	}

	/**
	 * Returns the number of mapping vmaps where classname = &#63; and classpk = &#63;.
	 *
	 * @param classname the classname
	 * @param classpk the classpk
	 * @return the number of matching mapping vmaps
	 */
	@Override
	public int countByCN_PK(String classname, long classpk) {
		classname = Objects.toString(classname, "");

		FinderPath finderPath = _finderPathCountByCN_PK;

		Object[] finderArgs = new Object[] {classname, classpk};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MAPPINGVMAP_WHERE);

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
		"mappingVmap.classname = ? AND ";

	private static final String _FINDER_COLUMN_CN_PK_CLASSNAME_3 =
		"(mappingVmap.classname IS NULL OR mappingVmap.classname = '') AND ";

	private static final String _FINDER_COLUMN_CN_PK_CLASSPK_2 =
		"mappingVmap.classpk = ?";

	private FinderPath _finderPathFetchByPK;
	private FinderPath _finderPathCountByPK;

	/**
	 * Returns the mapping vmap where classpk = &#63; or throws a <code>NoSuchMappingVmapException</code> if it could not be found.
	 *
	 * @param classpk the classpk
	 * @return the matching mapping vmap
	 * @throws NoSuchMappingVmapException if a matching mapping vmap could not be found
	 */
	@Override
	public MappingVmap findByPK(long classpk)
		throws NoSuchMappingVmapException {

		MappingVmap mappingVmap = fetchByPK(classpk);

		if (mappingVmap == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("classpk=");
			msg.append(classpk);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchMappingVmapException(msg.toString());
		}

		return mappingVmap;
	}

	/**
	 * Returns the mapping vmap where classpk = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param classpk the classpk
	 * @return the matching mapping vmap, or <code>null</code> if a matching mapping vmap could not be found
	 */
	@Override
	public MappingVmap fetchByPK(long classpk) {
		return fetchByPK(classpk, true);
	}

	/**
	 * Returns the mapping vmap where classpk = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param classpk the classpk
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching mapping vmap, or <code>null</code> if a matching mapping vmap could not be found
	 */
	@Override
	public MappingVmap fetchByPK(long classpk, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] {classpk};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByPK, finderArgs, this);
		}

		if (result instanceof MappingVmap) {
			MappingVmap mappingVmap = (MappingVmap)result;

			if ((classpk != mappingVmap.getClasspk())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_MAPPINGVMAP_WHERE);

			query.append(_FINDER_COLUMN_PK_CLASSPK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(classpk);

				List<MappingVmap> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByPK, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"MappingVmapPersistenceImpl.fetchByPK(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					MappingVmap mappingVmap = list.get(0);

					result = mappingVmap;

					cacheResult(mappingVmap);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(_finderPathFetchByPK, finderArgs);

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
			return (MappingVmap)result;
		}
	}

	/**
	 * Removes the mapping vmap where classpk = &#63; from the database.
	 *
	 * @param classpk the classpk
	 * @return the mapping vmap that was removed
	 */
	@Override
	public MappingVmap removeByPK(long classpk)
		throws NoSuchMappingVmapException {

		MappingVmap mappingVmap = findByPK(classpk);

		return remove(mappingVmap);
	}

	/**
	 * Returns the number of mapping vmaps where classpk = &#63;.
	 *
	 * @param classpk the classpk
	 * @return the number of matching mapping vmaps
	 */
	@Override
	public int countByPK(long classpk) {
		FinderPath finderPath = _finderPathCountByPK;

		Object[] finderArgs = new Object[] {classpk};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MAPPINGVMAP_WHERE);

			query.append(_FINDER_COLUMN_PK_CLASSPK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_PK_CLASSPK_2 =
		"mappingVmap.classpk = ?";

	public MappingVmapPersistenceImpl() {
		setModelClass(MappingVmap.class);
	}

	/**
	 * Caches the mapping vmap in the entity cache if it is enabled.
	 *
	 * @param mappingVmap the mapping vmap
	 */
	@Override
	public void cacheResult(MappingVmap mappingVmap) {
		entityCache.putResult(
			MappingVmapModelImpl.ENTITY_CACHE_ENABLED, MappingVmapImpl.class,
			mappingVmap.getPrimaryKey(), mappingVmap);

		finderCache.putResult(
			_finderPathFetchByCN_PK,
			new Object[] {mappingVmap.getClassname(), mappingVmap.getClasspk()},
			mappingVmap);

		finderCache.putResult(
			_finderPathFetchByPK, new Object[] {mappingVmap.getClasspk()},
			mappingVmap);

		mappingVmap.resetOriginalValues();
	}

	/**
	 * Caches the mapping vmaps in the entity cache if it is enabled.
	 *
	 * @param mappingVmaps the mapping vmaps
	 */
	@Override
	public void cacheResult(List<MappingVmap> mappingVmaps) {
		for (MappingVmap mappingVmap : mappingVmaps) {
			if (entityCache.getResult(
					MappingVmapModelImpl.ENTITY_CACHE_ENABLED,
					MappingVmapImpl.class, mappingVmap.getPrimaryKey()) ==
						null) {

				cacheResult(mappingVmap);
			}
			else {
				mappingVmap.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all mapping vmaps.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MappingVmapImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the mapping vmap.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MappingVmap mappingVmap) {
		entityCache.removeResult(
			MappingVmapModelImpl.ENTITY_CACHE_ENABLED, MappingVmapImpl.class,
			mappingVmap.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((MappingVmapModelImpl)mappingVmap, true);
	}

	@Override
	public void clearCache(List<MappingVmap> mappingVmaps) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MappingVmap mappingVmap : mappingVmaps) {
			entityCache.removeResult(
				MappingVmapModelImpl.ENTITY_CACHE_ENABLED,
				MappingVmapImpl.class, mappingVmap.getPrimaryKey());

			clearUniqueFindersCache((MappingVmapModelImpl)mappingVmap, true);
		}
	}

	protected void cacheUniqueFindersCache(
		MappingVmapModelImpl mappingVmapModelImpl) {

		Object[] args = new Object[] {
			mappingVmapModelImpl.getClassname(),
			mappingVmapModelImpl.getClasspk()
		};

		finderCache.putResult(
			_finderPathCountByCN_PK, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByCN_PK, args, mappingVmapModelImpl, false);

		args = new Object[] {mappingVmapModelImpl.getClasspk()};

		finderCache.putResult(
			_finderPathCountByPK, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByPK, args, mappingVmapModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		MappingVmapModelImpl mappingVmapModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				mappingVmapModelImpl.getClassname(),
				mappingVmapModelImpl.getClasspk()
			};

			finderCache.removeResult(_finderPathCountByCN_PK, args);
			finderCache.removeResult(_finderPathFetchByCN_PK, args);
		}

		if ((mappingVmapModelImpl.getColumnBitmask() &
			 _finderPathFetchByCN_PK.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				mappingVmapModelImpl.getOriginalClassname(),
				mappingVmapModelImpl.getOriginalClasspk()
			};

			finderCache.removeResult(_finderPathCountByCN_PK, args);
			finderCache.removeResult(_finderPathFetchByCN_PK, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {mappingVmapModelImpl.getClasspk()};

			finderCache.removeResult(_finderPathCountByPK, args);
			finderCache.removeResult(_finderPathFetchByPK, args);
		}

		if ((mappingVmapModelImpl.getColumnBitmask() &
			 _finderPathFetchByPK.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				mappingVmapModelImpl.getOriginalClasspk()
			};

			finderCache.removeResult(_finderPathCountByPK, args);
			finderCache.removeResult(_finderPathFetchByPK, args);
		}
	}

	/**
	 * Creates a new mapping vmap with the primary key. Does not add the mapping vmap to the database.
	 *
	 * @param id the primary key for the new mapping vmap
	 * @return the new mapping vmap
	 */
	@Override
	public MappingVmap create(long id) {
		MappingVmap mappingVmap = new MappingVmapImpl();

		mappingVmap.setNew(true);
		mappingVmap.setPrimaryKey(id);

		return mappingVmap;
	}

	/**
	 * Removes the mapping vmap with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the mapping vmap
	 * @return the mapping vmap that was removed
	 * @throws NoSuchMappingVmapException if a mapping vmap with the primary key could not be found
	 */
	@Override
	public MappingVmap remove(long id) throws NoSuchMappingVmapException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the mapping vmap with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the mapping vmap
	 * @return the mapping vmap that was removed
	 * @throws NoSuchMappingVmapException if a mapping vmap with the primary key could not be found
	 */
	@Override
	public MappingVmap remove(Serializable primaryKey)
		throws NoSuchMappingVmapException {

		Session session = null;

		try {
			session = openSession();

			MappingVmap mappingVmap = (MappingVmap)session.get(
				MappingVmapImpl.class, primaryKey);

			if (mappingVmap == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMappingVmapException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(mappingVmap);
		}
		catch (NoSuchMappingVmapException nsee) {
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
	protected MappingVmap removeImpl(MappingVmap mappingVmap) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(mappingVmap)) {
				mappingVmap = (MappingVmap)session.get(
					MappingVmapImpl.class, mappingVmap.getPrimaryKeyObj());
			}

			if (mappingVmap != null) {
				session.delete(mappingVmap);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (mappingVmap != null) {
			clearCache(mappingVmap);
		}

		return mappingVmap;
	}

	@Override
	public MappingVmap updateImpl(MappingVmap mappingVmap) {
		boolean isNew = mappingVmap.isNew();

		if (!(mappingVmap instanceof MappingVmapModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(mappingVmap.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(mappingVmap);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in mappingVmap proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom MappingVmap implementation " +
					mappingVmap.getClass());
		}

		MappingVmapModelImpl mappingVmapModelImpl =
			(MappingVmapModelImpl)mappingVmap;

		Session session = null;

		try {
			session = openSession();

			if (mappingVmap.isNew()) {
				session.save(mappingVmap);

				mappingVmap.setNew(false);
			}
			else {
				mappingVmap = (MappingVmap)session.merge(mappingVmap);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!MappingVmapModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			MappingVmapModelImpl.ENTITY_CACHE_ENABLED, MappingVmapImpl.class,
			mappingVmap.getPrimaryKey(), mappingVmap, false);

		clearUniqueFindersCache(mappingVmapModelImpl, false);
		cacheUniqueFindersCache(mappingVmapModelImpl);

		mappingVmap.resetOriginalValues();

		return mappingVmap;
	}

	/**
	 * Returns the mapping vmap with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the mapping vmap
	 * @return the mapping vmap
	 * @throws NoSuchMappingVmapException if a mapping vmap with the primary key could not be found
	 */
	@Override
	public MappingVmap findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMappingVmapException {

		MappingVmap mappingVmap = fetchByPrimaryKey(primaryKey);

		if (mappingVmap == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMappingVmapException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return mappingVmap;
	}

	/**
	 * Returns the mapping vmap with the primary key or throws a <code>NoSuchMappingVmapException</code> if it could not be found.
	 *
	 * @param id the primary key of the mapping vmap
	 * @return the mapping vmap
	 * @throws NoSuchMappingVmapException if a mapping vmap with the primary key could not be found
	 */
	@Override
	public MappingVmap findByPrimaryKey(long id)
		throws NoSuchMappingVmapException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the mapping vmap with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the mapping vmap
	 * @return the mapping vmap, or <code>null</code> if a mapping vmap with the primary key could not be found
	 */
	@Override
	public MappingVmap fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			MappingVmapModelImpl.ENTITY_CACHE_ENABLED, MappingVmapImpl.class,
			primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		MappingVmap mappingVmap = (MappingVmap)serializable;

		if (mappingVmap == null) {
			Session session = null;

			try {
				session = openSession();

				mappingVmap = (MappingVmap)session.get(
					MappingVmapImpl.class, primaryKey);

				if (mappingVmap != null) {
					cacheResult(mappingVmap);
				}
				else {
					entityCache.putResult(
						MappingVmapModelImpl.ENTITY_CACHE_ENABLED,
						MappingVmapImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					MappingVmapModelImpl.ENTITY_CACHE_ENABLED,
					MappingVmapImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return mappingVmap;
	}

	/**
	 * Returns the mapping vmap with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the mapping vmap
	 * @return the mapping vmap, or <code>null</code> if a mapping vmap with the primary key could not be found
	 */
	@Override
	public MappingVmap fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, MappingVmap> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, MappingVmap> map =
			new HashMap<Serializable, MappingVmap>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			MappingVmap mappingVmap = fetchByPrimaryKey(primaryKey);

			if (mappingVmap != null) {
				map.put(primaryKey, mappingVmap);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				MappingVmapModelImpl.ENTITY_CACHE_ENABLED,
				MappingVmapImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (MappingVmap)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_MAPPINGVMAP_WHERE_PKS_IN);

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

			for (MappingVmap mappingVmap : (List<MappingVmap>)q.list()) {
				map.put(mappingVmap.getPrimaryKeyObj(), mappingVmap);

				cacheResult(mappingVmap);

				uncachedPrimaryKeys.remove(mappingVmap.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					MappingVmapModelImpl.ENTITY_CACHE_ENABLED,
					MappingVmapImpl.class, primaryKey, nullModel);
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
	 * Returns all the mapping vmaps.
	 *
	 * @return the mapping vmaps
	 */
	@Override
	public List<MappingVmap> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the mapping vmaps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MappingVmapModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of mapping vmaps
	 * @param end the upper bound of the range of mapping vmaps (not inclusive)
	 * @return the range of mapping vmaps
	 */
	@Override
	public List<MappingVmap> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the mapping vmaps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MappingVmapModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of mapping vmaps
	 * @param end the upper bound of the range of mapping vmaps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of mapping vmaps
	 */
	@Override
	public List<MappingVmap> findAll(
		int start, int end, OrderByComparator<MappingVmap> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the mapping vmaps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MappingVmapModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of mapping vmaps
	 * @param end the upper bound of the range of mapping vmaps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of mapping vmaps
	 */
	@Override
	public List<MappingVmap> findAll(
		int start, int end, OrderByComparator<MappingVmap> orderByComparator,
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

		List<MappingVmap> list = null;

		if (retrieveFromCache) {
			list = (List<MappingVmap>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_MAPPINGVMAP);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MAPPINGVMAP;

				if (pagination) {
					sql = sql.concat(MappingVmapModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<MappingVmap>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<MappingVmap>)QueryUtil.list(
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
	 * Removes all the mapping vmaps from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (MappingVmap mappingVmap : findAll()) {
			remove(mappingVmap);
		}
	}

	/**
	 * Returns the number of mapping vmaps.
	 *
	 * @return the number of mapping vmaps
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_MAPPINGVMAP);

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
		return MappingVmapModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the mapping vmap persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			MappingVmapModelImpl.ENTITY_CACHE_ENABLED,
			MappingVmapModelImpl.FINDER_CACHE_ENABLED, MappingVmapImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			MappingVmapModelImpl.ENTITY_CACHE_ENABLED,
			MappingVmapModelImpl.FINDER_CACHE_ENABLED, MappingVmapImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			MappingVmapModelImpl.ENTITY_CACHE_ENABLED,
			MappingVmapModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByCN_PK = new FinderPath(
			MappingVmapModelImpl.ENTITY_CACHE_ENABLED,
			MappingVmapModelImpl.FINDER_CACHE_ENABLED, MappingVmapImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCN_PK",
			new String[] {String.class.getName(), Long.class.getName()},
			MappingVmapModelImpl.CLASSNAME_COLUMN_BITMASK |
			MappingVmapModelImpl.CLASSPK_COLUMN_BITMASK);

		_finderPathCountByCN_PK = new FinderPath(
			MappingVmapModelImpl.ENTITY_CACHE_ENABLED,
			MappingVmapModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCN_PK",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathFetchByPK = new FinderPath(
			MappingVmapModelImpl.ENTITY_CACHE_ENABLED,
			MappingVmapModelImpl.FINDER_CACHE_ENABLED, MappingVmapImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByPK",
			new String[] {Long.class.getName()},
			MappingVmapModelImpl.CLASSPK_COLUMN_BITMASK);

		_finderPathCountByPK = new FinderPath(
			MappingVmapModelImpl.ENTITY_CACHE_ENABLED,
			MappingVmapModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPK",
			new String[] {Long.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(MappingVmapImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_MAPPINGVMAP =
		"SELECT mappingVmap FROM MappingVmap mappingVmap";

	private static final String _SQL_SELECT_MAPPINGVMAP_WHERE_PKS_IN =
		"SELECT mappingVmap FROM MappingVmap mappingVmap WHERE id IN (";

	private static final String _SQL_SELECT_MAPPINGVMAP_WHERE =
		"SELECT mappingVmap FROM MappingVmap mappingVmap WHERE ";

	private static final String _SQL_COUNT_MAPPINGVMAP =
		"SELECT COUNT(mappingVmap) FROM MappingVmap mappingVmap";

	private static final String _SQL_COUNT_MAPPINGVMAP_WHERE =
		"SELECT COUNT(mappingVmap) FROM MappingVmap mappingVmap WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "mappingVmap.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No MappingVmap exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No MappingVmap exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		MappingVmapPersistenceImpl.class);

}