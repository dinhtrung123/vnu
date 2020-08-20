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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import dtt.vn.user.service.exception.NoSuchDoiTuongSuDungException;
import dtt.vn.user.service.model.DoiTuongSuDung;
import dtt.vn.user.service.model.impl.DoiTuongSuDungImpl;
import dtt.vn.user.service.model.impl.DoiTuongSuDungModelImpl;
import dtt.vn.user.service.service.persistence.DoiTuongSuDungPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;
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
 * The persistence implementation for the doi tuong su dung service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nhanvienDTT
 * @generated
 */
@ProviderType
public class DoiTuongSuDungPersistenceImpl
	extends BasePersistenceImpl<DoiTuongSuDung>
	implements DoiTuongSuDungPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DoiTuongSuDungUtil</code> to access the doi tuong su dung persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DoiTuongSuDungImpl.class.getName();

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
	 * Returns the doi tuong su dung where ma = &#63; or throws a <code>NoSuchDoiTuongSuDungException</code> if it could not be found.
	 *
	 * @param ma the ma
	 * @return the matching doi tuong su dung
	 * @throws NoSuchDoiTuongSuDungException if a matching doi tuong su dung could not be found
	 */
	@Override
	public DoiTuongSuDung findByMa(String ma)
		throws NoSuchDoiTuongSuDungException {

		DoiTuongSuDung doiTuongSuDung = fetchByMa(ma);

		if (doiTuongSuDung == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ma=");
			msg.append(ma);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchDoiTuongSuDungException(msg.toString());
		}

		return doiTuongSuDung;
	}

	/**
	 * Returns the doi tuong su dung where ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ma the ma
	 * @return the matching doi tuong su dung, or <code>null</code> if a matching doi tuong su dung could not be found
	 */
	@Override
	public DoiTuongSuDung fetchByMa(String ma) {
		return fetchByMa(ma, true);
	}

	/**
	 * Returns the doi tuong su dung where ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ma the ma
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching doi tuong su dung, or <code>null</code> if a matching doi tuong su dung could not be found
	 */
	@Override
	public DoiTuongSuDung fetchByMa(String ma, boolean retrieveFromCache) {
		ma = Objects.toString(ma, "");

		Object[] finderArgs = new Object[] {ma};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByMa, finderArgs, this);
		}

		if (result instanceof DoiTuongSuDung) {
			DoiTuongSuDung doiTuongSuDung = (DoiTuongSuDung)result;

			if (!Objects.equals(ma, doiTuongSuDung.getMa())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_DOITUONGSUDUNG_WHERE);

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

				List<DoiTuongSuDung> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByMa, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"DoiTuongSuDungPersistenceImpl.fetchByMa(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DoiTuongSuDung doiTuongSuDung = list.get(0);

					result = doiTuongSuDung;

					cacheResult(doiTuongSuDung);
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
			return (DoiTuongSuDung)result;
		}
	}

	/**
	 * Removes the doi tuong su dung where ma = &#63; from the database.
	 *
	 * @param ma the ma
	 * @return the doi tuong su dung that was removed
	 */
	@Override
	public DoiTuongSuDung removeByMa(String ma)
		throws NoSuchDoiTuongSuDungException {

		DoiTuongSuDung doiTuongSuDung = findByMa(ma);

		return remove(doiTuongSuDung);
	}

	/**
	 * Returns the number of doi tuong su dungs where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the number of matching doi tuong su dungs
	 */
	@Override
	public int countByMa(String ma) {
		ma = Objects.toString(ma, "");

		FinderPath finderPath = _finderPathCountByMa;

		Object[] finderArgs = new Object[] {ma};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DOITUONGSUDUNG_WHERE);

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

	private static final String _FINDER_COLUMN_MA_MA_2 =
		"doiTuongSuDung.ma = ?";

	private static final String _FINDER_COLUMN_MA_MA_3 =
		"(doiTuongSuDung.ma IS NULL OR doiTuongSuDung.ma = '')";

	public DoiTuongSuDungPersistenceImpl() {
		setModelClass(DoiTuongSuDung.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("moTa", "mota");

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
	 * Caches the doi tuong su dung in the entity cache if it is enabled.
	 *
	 * @param doiTuongSuDung the doi tuong su dung
	 */
	@Override
	public void cacheResult(DoiTuongSuDung doiTuongSuDung) {
		entityCache.putResult(
			DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
			DoiTuongSuDungImpl.class, doiTuongSuDung.getPrimaryKey(),
			doiTuongSuDung);

		finderCache.putResult(
			_finderPathFetchByMa, new Object[] {doiTuongSuDung.getMa()},
			doiTuongSuDung);

		doiTuongSuDung.resetOriginalValues();
	}

	/**
	 * Caches the doi tuong su dungs in the entity cache if it is enabled.
	 *
	 * @param doiTuongSuDungs the doi tuong su dungs
	 */
	@Override
	public void cacheResult(List<DoiTuongSuDung> doiTuongSuDungs) {
		for (DoiTuongSuDung doiTuongSuDung : doiTuongSuDungs) {
			if (entityCache.getResult(
					DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
					DoiTuongSuDungImpl.class, doiTuongSuDung.getPrimaryKey()) ==
						null) {

				cacheResult(doiTuongSuDung);
			}
			else {
				doiTuongSuDung.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all doi tuong su dungs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DoiTuongSuDungImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the doi tuong su dung.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DoiTuongSuDung doiTuongSuDung) {
		entityCache.removeResult(
			DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
			DoiTuongSuDungImpl.class, doiTuongSuDung.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((DoiTuongSuDungModelImpl)doiTuongSuDung, true);
	}

	@Override
	public void clearCache(List<DoiTuongSuDung> doiTuongSuDungs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DoiTuongSuDung doiTuongSuDung : doiTuongSuDungs) {
			entityCache.removeResult(
				DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
				DoiTuongSuDungImpl.class, doiTuongSuDung.getPrimaryKey());

			clearUniqueFindersCache(
				(DoiTuongSuDungModelImpl)doiTuongSuDung, true);
		}
	}

	protected void cacheUniqueFindersCache(
		DoiTuongSuDungModelImpl doiTuongSuDungModelImpl) {

		Object[] args = new Object[] {doiTuongSuDungModelImpl.getMa()};

		finderCache.putResult(
			_finderPathCountByMa, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByMa, args, doiTuongSuDungModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		DoiTuongSuDungModelImpl doiTuongSuDungModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {doiTuongSuDungModelImpl.getMa()};

			finderCache.removeResult(_finderPathCountByMa, args);
			finderCache.removeResult(_finderPathFetchByMa, args);
		}

		if ((doiTuongSuDungModelImpl.getColumnBitmask() &
			 _finderPathFetchByMa.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				doiTuongSuDungModelImpl.getOriginalMa()
			};

			finderCache.removeResult(_finderPathCountByMa, args);
			finderCache.removeResult(_finderPathFetchByMa, args);
		}
	}

	/**
	 * Creates a new doi tuong su dung with the primary key. Does not add the doi tuong su dung to the database.
	 *
	 * @param id the primary key for the new doi tuong su dung
	 * @return the new doi tuong su dung
	 */
	@Override
	public DoiTuongSuDung create(long id) {
		DoiTuongSuDung doiTuongSuDung = new DoiTuongSuDungImpl();

		doiTuongSuDung.setNew(true);
		doiTuongSuDung.setPrimaryKey(id);

		return doiTuongSuDung;
	}

	/**
	 * Removes the doi tuong su dung with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the doi tuong su dung
	 * @return the doi tuong su dung that was removed
	 * @throws NoSuchDoiTuongSuDungException if a doi tuong su dung with the primary key could not be found
	 */
	@Override
	public DoiTuongSuDung remove(long id) throws NoSuchDoiTuongSuDungException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the doi tuong su dung with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the doi tuong su dung
	 * @return the doi tuong su dung that was removed
	 * @throws NoSuchDoiTuongSuDungException if a doi tuong su dung with the primary key could not be found
	 */
	@Override
	public DoiTuongSuDung remove(Serializable primaryKey)
		throws NoSuchDoiTuongSuDungException {

		Session session = null;

		try {
			session = openSession();

			DoiTuongSuDung doiTuongSuDung = (DoiTuongSuDung)session.get(
				DoiTuongSuDungImpl.class, primaryKey);

			if (doiTuongSuDung == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDoiTuongSuDungException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(doiTuongSuDung);
		}
		catch (NoSuchDoiTuongSuDungException nsee) {
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
	protected DoiTuongSuDung removeImpl(DoiTuongSuDung doiTuongSuDung) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(doiTuongSuDung)) {
				doiTuongSuDung = (DoiTuongSuDung)session.get(
					DoiTuongSuDungImpl.class,
					doiTuongSuDung.getPrimaryKeyObj());
			}

			if (doiTuongSuDung != null) {
				session.delete(doiTuongSuDung);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (doiTuongSuDung != null) {
			clearCache(doiTuongSuDung);
		}

		return doiTuongSuDung;
	}

	@Override
	public DoiTuongSuDung updateImpl(DoiTuongSuDung doiTuongSuDung) {
		boolean isNew = doiTuongSuDung.isNew();

		if (!(doiTuongSuDung instanceof DoiTuongSuDungModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(doiTuongSuDung.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					doiTuongSuDung);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in doiTuongSuDung proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DoiTuongSuDung implementation " +
					doiTuongSuDung.getClass());
		}

		DoiTuongSuDungModelImpl doiTuongSuDungModelImpl =
			(DoiTuongSuDungModelImpl)doiTuongSuDung;

		Session session = null;

		try {
			session = openSession();

			if (doiTuongSuDung.isNew()) {
				session.save(doiTuongSuDung);

				doiTuongSuDung.setNew(false);
			}
			else {
				doiTuongSuDung = (DoiTuongSuDung)session.merge(doiTuongSuDung);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!DoiTuongSuDungModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
			DoiTuongSuDungImpl.class, doiTuongSuDung.getPrimaryKey(),
			doiTuongSuDung, false);

		clearUniqueFindersCache(doiTuongSuDungModelImpl, false);
		cacheUniqueFindersCache(doiTuongSuDungModelImpl);

		doiTuongSuDung.resetOriginalValues();

		return doiTuongSuDung;
	}

	/**
	 * Returns the doi tuong su dung with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the doi tuong su dung
	 * @return the doi tuong su dung
	 * @throws NoSuchDoiTuongSuDungException if a doi tuong su dung with the primary key could not be found
	 */
	@Override
	public DoiTuongSuDung findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDoiTuongSuDungException {

		DoiTuongSuDung doiTuongSuDung = fetchByPrimaryKey(primaryKey);

		if (doiTuongSuDung == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDoiTuongSuDungException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return doiTuongSuDung;
	}

	/**
	 * Returns the doi tuong su dung with the primary key or throws a <code>NoSuchDoiTuongSuDungException</code> if it could not be found.
	 *
	 * @param id the primary key of the doi tuong su dung
	 * @return the doi tuong su dung
	 * @throws NoSuchDoiTuongSuDungException if a doi tuong su dung with the primary key could not be found
	 */
	@Override
	public DoiTuongSuDung findByPrimaryKey(long id)
		throws NoSuchDoiTuongSuDungException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the doi tuong su dung with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the doi tuong su dung
	 * @return the doi tuong su dung, or <code>null</code> if a doi tuong su dung with the primary key could not be found
	 */
	@Override
	public DoiTuongSuDung fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
			DoiTuongSuDungImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		DoiTuongSuDung doiTuongSuDung = (DoiTuongSuDung)serializable;

		if (doiTuongSuDung == null) {
			Session session = null;

			try {
				session = openSession();

				doiTuongSuDung = (DoiTuongSuDung)session.get(
					DoiTuongSuDungImpl.class, primaryKey);

				if (doiTuongSuDung != null) {
					cacheResult(doiTuongSuDung);
				}
				else {
					entityCache.putResult(
						DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
						DoiTuongSuDungImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
					DoiTuongSuDungImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return doiTuongSuDung;
	}

	/**
	 * Returns the doi tuong su dung with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the doi tuong su dung
	 * @return the doi tuong su dung, or <code>null</code> if a doi tuong su dung with the primary key could not be found
	 */
	@Override
	public DoiTuongSuDung fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, DoiTuongSuDung> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, DoiTuongSuDung> map =
			new HashMap<Serializable, DoiTuongSuDung>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			DoiTuongSuDung doiTuongSuDung = fetchByPrimaryKey(primaryKey);

			if (doiTuongSuDung != null) {
				map.put(primaryKey, doiTuongSuDung);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
				DoiTuongSuDungImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (DoiTuongSuDung)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_DOITUONGSUDUNG_WHERE_PKS_IN);

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

			for (DoiTuongSuDung doiTuongSuDung :
					(List<DoiTuongSuDung>)q.list()) {

				map.put(doiTuongSuDung.getPrimaryKeyObj(), doiTuongSuDung);

				cacheResult(doiTuongSuDung);

				uncachedPrimaryKeys.remove(doiTuongSuDung.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
					DoiTuongSuDungImpl.class, primaryKey, nullModel);
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
	 * Returns all the doi tuong su dungs.
	 *
	 * @return the doi tuong su dungs
	 */
	@Override
	public List<DoiTuongSuDung> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the doi tuong su dungs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DoiTuongSuDungModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of doi tuong su dungs
	 * @param end the upper bound of the range of doi tuong su dungs (not inclusive)
	 * @return the range of doi tuong su dungs
	 */
	@Override
	public List<DoiTuongSuDung> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the doi tuong su dungs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DoiTuongSuDungModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of doi tuong su dungs
	 * @param end the upper bound of the range of doi tuong su dungs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of doi tuong su dungs
	 */
	@Override
	public List<DoiTuongSuDung> findAll(
		int start, int end,
		OrderByComparator<DoiTuongSuDung> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the doi tuong su dungs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DoiTuongSuDungModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of doi tuong su dungs
	 * @param end the upper bound of the range of doi tuong su dungs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of doi tuong su dungs
	 */
	@Override
	public List<DoiTuongSuDung> findAll(
		int start, int end, OrderByComparator<DoiTuongSuDung> orderByComparator,
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

		List<DoiTuongSuDung> list = null;

		if (retrieveFromCache) {
			list = (List<DoiTuongSuDung>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_DOITUONGSUDUNG);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DOITUONGSUDUNG;

				if (pagination) {
					sql = sql.concat(DoiTuongSuDungModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DoiTuongSuDung>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DoiTuongSuDung>)QueryUtil.list(
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
	 * Removes all the doi tuong su dungs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DoiTuongSuDung doiTuongSuDung : findAll()) {
			remove(doiTuongSuDung);
		}
	}

	/**
	 * Returns the number of doi tuong su dungs.
	 *
	 * @return the number of doi tuong su dungs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DOITUONGSUDUNG);

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
		return DoiTuongSuDungModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the doi tuong su dung persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
			DoiTuongSuDungModelImpl.FINDER_CACHE_ENABLED,
			DoiTuongSuDungImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
			DoiTuongSuDungModelImpl.FINDER_CACHE_ENABLED,
			DoiTuongSuDungImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);

		_finderPathCountAll = new FinderPath(
			DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
			DoiTuongSuDungModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByMa = new FinderPath(
			DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
			DoiTuongSuDungModelImpl.FINDER_CACHE_ENABLED,
			DoiTuongSuDungImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByMa",
			new String[] {String.class.getName()},
			DoiTuongSuDungModelImpl.MA_COLUMN_BITMASK);

		_finderPathCountByMa = new FinderPath(
			DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
			DoiTuongSuDungModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMa",
			new String[] {String.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(DoiTuongSuDungImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_DOITUONGSUDUNG =
		"SELECT doiTuongSuDung FROM DoiTuongSuDung doiTuongSuDung";

	private static final String _SQL_SELECT_DOITUONGSUDUNG_WHERE_PKS_IN =
		"SELECT doiTuongSuDung FROM DoiTuongSuDung doiTuongSuDung WHERE id IN (";

	private static final String _SQL_SELECT_DOITUONGSUDUNG_WHERE =
		"SELECT doiTuongSuDung FROM DoiTuongSuDung doiTuongSuDung WHERE ";

	private static final String _SQL_COUNT_DOITUONGSUDUNG =
		"SELECT COUNT(doiTuongSuDung) FROM DoiTuongSuDung doiTuongSuDung";

	private static final String _SQL_COUNT_DOITUONGSUDUNG_WHERE =
		"SELECT COUNT(doiTuongSuDung) FROM DoiTuongSuDung doiTuongSuDung WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "doiTuongSuDung.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DoiTuongSuDung exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DoiTuongSuDung exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DoiTuongSuDungPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"moTa"});

}