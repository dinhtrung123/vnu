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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

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

import org.oep.core.exception.NoSuchTrungTamHanhChinhException;
import org.oep.core.model.TrungTamHanhChinh;
import org.oep.core.model.impl.TrungTamHanhChinhImpl;
import org.oep.core.model.impl.TrungTamHanhChinhModelImpl;
import org.oep.core.service.persistence.TrungTamHanhChinhPersistence;

/**
 * The persistence implementation for the trung tam hanh chinh service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author manhlb
 * @generated
 */
@ProviderType
public class TrungTamHanhChinhPersistenceImpl
	extends BasePersistenceImpl<TrungTamHanhChinh>
	implements TrungTamHanhChinhPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TrungTamHanhChinhUtil</code> to access the trung tam hanh chinh persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TrungTamHanhChinhImpl.class.getName();

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
	 * Returns the trung tam hanh chinh where ma = &#63; or throws a <code>NoSuchTrungTamHanhChinhException</code> if it could not be found.
	 *
	 * @param ma the ma
	 * @return the matching trung tam hanh chinh
	 * @throws NoSuchTrungTamHanhChinhException if a matching trung tam hanh chinh could not be found
	 */
	@Override
	public TrungTamHanhChinh findByMa(String ma)
		throws NoSuchTrungTamHanhChinhException {

		TrungTamHanhChinh trungTamHanhChinh = fetchByMa(ma);

		if (trungTamHanhChinh == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ma=");
			msg.append(ma);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchTrungTamHanhChinhException(msg.toString());
		}

		return trungTamHanhChinh;
	}

	/**
	 * Returns the trung tam hanh chinh where ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ma the ma
	 * @return the matching trung tam hanh chinh, or <code>null</code> if a matching trung tam hanh chinh could not be found
	 */
	@Override
	public TrungTamHanhChinh fetchByMa(String ma) {
		return fetchByMa(ma, true);
	}

	/**
	 * Returns the trung tam hanh chinh where ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ma the ma
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching trung tam hanh chinh, or <code>null</code> if a matching trung tam hanh chinh could not be found
	 */
	@Override
	public TrungTamHanhChinh fetchByMa(String ma, boolean retrieveFromCache) {
		ma = Objects.toString(ma, "");

		Object[] finderArgs = new Object[] {ma};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByMa, finderArgs, this);
		}

		if (result instanceof TrungTamHanhChinh) {
			TrungTamHanhChinh trungTamHanhChinh = (TrungTamHanhChinh)result;

			if (!Objects.equals(ma, trungTamHanhChinh.getMa())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_TRUNGTAMHANHCHINH_WHERE);

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

				List<TrungTamHanhChinh> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByMa, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"TrungTamHanhChinhPersistenceImpl.fetchByMa(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					TrungTamHanhChinh trungTamHanhChinh = list.get(0);

					result = trungTamHanhChinh;

					cacheResult(trungTamHanhChinh);
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
			return (TrungTamHanhChinh)result;
		}
	}

	/**
	 * Removes the trung tam hanh chinh where ma = &#63; from the database.
	 *
	 * @param ma the ma
	 * @return the trung tam hanh chinh that was removed
	 */
	@Override
	public TrungTamHanhChinh removeByMa(String ma)
		throws NoSuchTrungTamHanhChinhException {

		TrungTamHanhChinh trungTamHanhChinh = findByMa(ma);

		return remove(trungTamHanhChinh);
	}

	/**
	 * Returns the number of trung tam hanh chinhs where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the number of matching trung tam hanh chinhs
	 */
	@Override
	public int countByMa(String ma) {
		ma = Objects.toString(ma, "");

		FinderPath finderPath = _finderPathCountByMa;

		Object[] finderArgs = new Object[] {ma};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TRUNGTAMHANHCHINH_WHERE);

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
		"trungTamHanhChinh.ma = ?";

	private static final String _FINDER_COLUMN_MA_MA_3 =
		"(trungTamHanhChinh.ma IS NULL OR trungTamHanhChinh.ma = '')";

	private FinderPath _finderPathFetchBydonViId;
	private FinderPath _finderPathCountBydonViId;

	/**
	 * Returns the trung tam hanh chinh where donViId = &#63; or throws a <code>NoSuchTrungTamHanhChinhException</code> if it could not be found.
	 *
	 * @param donViId the don vi ID
	 * @return the matching trung tam hanh chinh
	 * @throws NoSuchTrungTamHanhChinhException if a matching trung tam hanh chinh could not be found
	 */
	@Override
	public TrungTamHanhChinh findBydonViId(long donViId)
		throws NoSuchTrungTamHanhChinhException {

		TrungTamHanhChinh trungTamHanhChinh = fetchBydonViId(donViId);

		if (trungTamHanhChinh == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("donViId=");
			msg.append(donViId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchTrungTamHanhChinhException(msg.toString());
		}

		return trungTamHanhChinh;
	}

	/**
	 * Returns the trung tam hanh chinh where donViId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param donViId the don vi ID
	 * @return the matching trung tam hanh chinh, or <code>null</code> if a matching trung tam hanh chinh could not be found
	 */
	@Override
	public TrungTamHanhChinh fetchBydonViId(long donViId) {
		return fetchBydonViId(donViId, true);
	}

	/**
	 * Returns the trung tam hanh chinh where donViId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param donViId the don vi ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching trung tam hanh chinh, or <code>null</code> if a matching trung tam hanh chinh could not be found
	 */
	@Override
	public TrungTamHanhChinh fetchBydonViId(
		long donViId, boolean retrieveFromCache) {

		Object[] finderArgs = new Object[] {donViId};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchBydonViId, finderArgs, this);
		}

		if (result instanceof TrungTamHanhChinh) {
			TrungTamHanhChinh trungTamHanhChinh = (TrungTamHanhChinh)result;

			if ((donViId != trungTamHanhChinh.getDonViId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_TRUNGTAMHANHCHINH_WHERE);

			query.append(_FINDER_COLUMN_DONVIID_DONVIID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(donViId);

				List<TrungTamHanhChinh> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchBydonViId, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"TrungTamHanhChinhPersistenceImpl.fetchBydonViId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					TrungTamHanhChinh trungTamHanhChinh = list.get(0);

					result = trungTamHanhChinh;

					cacheResult(trungTamHanhChinh);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(_finderPathFetchBydonViId, finderArgs);

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
			return (TrungTamHanhChinh)result;
		}
	}

	/**
	 * Removes the trung tam hanh chinh where donViId = &#63; from the database.
	 *
	 * @param donViId the don vi ID
	 * @return the trung tam hanh chinh that was removed
	 */
	@Override
	public TrungTamHanhChinh removeBydonViId(long donViId)
		throws NoSuchTrungTamHanhChinhException {

		TrungTamHanhChinh trungTamHanhChinh = findBydonViId(donViId);

		return remove(trungTamHanhChinh);
	}

	/**
	 * Returns the number of trung tam hanh chinhs where donViId = &#63;.
	 *
	 * @param donViId the don vi ID
	 * @return the number of matching trung tam hanh chinhs
	 */
	@Override
	public int countBydonViId(long donViId) {
		FinderPath finderPath = _finderPathCountBydonViId;

		Object[] finderArgs = new Object[] {donViId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TRUNGTAMHANHCHINH_WHERE);

			query.append(_FINDER_COLUMN_DONVIID_DONVIID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(donViId);

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

	private static final String _FINDER_COLUMN_DONVIID_DONVIID_2 =
		"trungTamHanhChinh.donViId = ?";

	public TrungTamHanhChinhPersistenceImpl() {
		setModelClass(TrungTamHanhChinh.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("donViId", "donvi_id");
		dbColumnNames.put("donViIds", "donvi_ids");
		dbColumnNames.put("thongTinLienHe", "thongtin_lienhe");
		dbColumnNames.put("trangThai", "trangthai");

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
	 * Caches the trung tam hanh chinh in the entity cache if it is enabled.
	 *
	 * @param trungTamHanhChinh the trung tam hanh chinh
	 */
	@Override
	public void cacheResult(TrungTamHanhChinh trungTamHanhChinh) {
		entityCache.putResult(
			TrungTamHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			TrungTamHanhChinhImpl.class, trungTamHanhChinh.getPrimaryKey(),
			trungTamHanhChinh);

		finderCache.putResult(
			_finderPathFetchByMa, new Object[] {trungTamHanhChinh.getMa()},
			trungTamHanhChinh);

		finderCache.putResult(
			_finderPathFetchBydonViId,
			new Object[] {trungTamHanhChinh.getDonViId()}, trungTamHanhChinh);

		trungTamHanhChinh.resetOriginalValues();
	}

	/**
	 * Caches the trung tam hanh chinhs in the entity cache if it is enabled.
	 *
	 * @param trungTamHanhChinhs the trung tam hanh chinhs
	 */
	@Override
	public void cacheResult(List<TrungTamHanhChinh> trungTamHanhChinhs) {
		for (TrungTamHanhChinh trungTamHanhChinh : trungTamHanhChinhs) {
			if (entityCache.getResult(
					TrungTamHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
					TrungTamHanhChinhImpl.class,
					trungTamHanhChinh.getPrimaryKey()) == null) {

				cacheResult(trungTamHanhChinh);
			}
			else {
				trungTamHanhChinh.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all trung tam hanh chinhs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TrungTamHanhChinhImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the trung tam hanh chinh.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TrungTamHanhChinh trungTamHanhChinh) {
		entityCache.removeResult(
			TrungTamHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			TrungTamHanhChinhImpl.class, trungTamHanhChinh.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(
			(TrungTamHanhChinhModelImpl)trungTamHanhChinh, true);
	}

	@Override
	public void clearCache(List<TrungTamHanhChinh> trungTamHanhChinhs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TrungTamHanhChinh trungTamHanhChinh : trungTamHanhChinhs) {
			entityCache.removeResult(
				TrungTamHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
				TrungTamHanhChinhImpl.class, trungTamHanhChinh.getPrimaryKey());

			clearUniqueFindersCache(
				(TrungTamHanhChinhModelImpl)trungTamHanhChinh, true);
		}
	}

	protected void cacheUniqueFindersCache(
		TrungTamHanhChinhModelImpl trungTamHanhChinhModelImpl) {

		Object[] args = new Object[] {trungTamHanhChinhModelImpl.getMa()};

		finderCache.putResult(
			_finderPathCountByMa, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByMa, args, trungTamHanhChinhModelImpl, false);

		args = new Object[] {trungTamHanhChinhModelImpl.getDonViId()};

		finderCache.putResult(
			_finderPathCountBydonViId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchBydonViId, args, trungTamHanhChinhModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		TrungTamHanhChinhModelImpl trungTamHanhChinhModelImpl,
		boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {trungTamHanhChinhModelImpl.getMa()};

			finderCache.removeResult(_finderPathCountByMa, args);
			finderCache.removeResult(_finderPathFetchByMa, args);
		}

		if ((trungTamHanhChinhModelImpl.getColumnBitmask() &
			 _finderPathFetchByMa.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				trungTamHanhChinhModelImpl.getOriginalMa()
			};

			finderCache.removeResult(_finderPathCountByMa, args);
			finderCache.removeResult(_finderPathFetchByMa, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				trungTamHanhChinhModelImpl.getDonViId()
			};

			finderCache.removeResult(_finderPathCountBydonViId, args);
			finderCache.removeResult(_finderPathFetchBydonViId, args);
		}

		if ((trungTamHanhChinhModelImpl.getColumnBitmask() &
			 _finderPathFetchBydonViId.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				trungTamHanhChinhModelImpl.getOriginalDonViId()
			};

			finderCache.removeResult(_finderPathCountBydonViId, args);
			finderCache.removeResult(_finderPathFetchBydonViId, args);
		}
	}

	/**
	 * Creates a new trung tam hanh chinh with the primary key. Does not add the trung tam hanh chinh to the database.
	 *
	 * @param id the primary key for the new trung tam hanh chinh
	 * @return the new trung tam hanh chinh
	 */
	@Override
	public TrungTamHanhChinh create(long id) {
		TrungTamHanhChinh trungTamHanhChinh = new TrungTamHanhChinhImpl();

		trungTamHanhChinh.setNew(true);
		trungTamHanhChinh.setPrimaryKey(id);

		return trungTamHanhChinh;
	}

	/**
	 * Removes the trung tam hanh chinh with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the trung tam hanh chinh
	 * @return the trung tam hanh chinh that was removed
	 * @throws NoSuchTrungTamHanhChinhException if a trung tam hanh chinh with the primary key could not be found
	 */
	@Override
	public TrungTamHanhChinh remove(long id)
		throws NoSuchTrungTamHanhChinhException {

		return remove((Serializable)id);
	}

	/**
	 * Removes the trung tam hanh chinh with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the trung tam hanh chinh
	 * @return the trung tam hanh chinh that was removed
	 * @throws NoSuchTrungTamHanhChinhException if a trung tam hanh chinh with the primary key could not be found
	 */
	@Override
	public TrungTamHanhChinh remove(Serializable primaryKey)
		throws NoSuchTrungTamHanhChinhException {

		Session session = null;

		try {
			session = openSession();

			TrungTamHanhChinh trungTamHanhChinh =
				(TrungTamHanhChinh)session.get(
					TrungTamHanhChinhImpl.class, primaryKey);

			if (trungTamHanhChinh == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTrungTamHanhChinhException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(trungTamHanhChinh);
		}
		catch (NoSuchTrungTamHanhChinhException nsee) {
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
	protected TrungTamHanhChinh removeImpl(
		TrungTamHanhChinh trungTamHanhChinh) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(trungTamHanhChinh)) {
				trungTamHanhChinh = (TrungTamHanhChinh)session.get(
					TrungTamHanhChinhImpl.class,
					trungTamHanhChinh.getPrimaryKeyObj());
			}

			if (trungTamHanhChinh != null) {
				session.delete(trungTamHanhChinh);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (trungTamHanhChinh != null) {
			clearCache(trungTamHanhChinh);
		}

		return trungTamHanhChinh;
	}

	@Override
	public TrungTamHanhChinh updateImpl(TrungTamHanhChinh trungTamHanhChinh) {
		boolean isNew = trungTamHanhChinh.isNew();

		if (!(trungTamHanhChinh instanceof TrungTamHanhChinhModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(trungTamHanhChinh.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					trungTamHanhChinh);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in trungTamHanhChinh proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TrungTamHanhChinh implementation " +
					trungTamHanhChinh.getClass());
		}

		TrungTamHanhChinhModelImpl trungTamHanhChinhModelImpl =
			(TrungTamHanhChinhModelImpl)trungTamHanhChinh;

		Session session = null;

		try {
			session = openSession();

			if (trungTamHanhChinh.isNew()) {
				session.save(trungTamHanhChinh);

				trungTamHanhChinh.setNew(false);
			}
			else {
				trungTamHanhChinh = (TrungTamHanhChinh)session.merge(
					trungTamHanhChinh);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!TrungTamHanhChinhModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			TrungTamHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			TrungTamHanhChinhImpl.class, trungTamHanhChinh.getPrimaryKey(),
			trungTamHanhChinh, false);

		clearUniqueFindersCache(trungTamHanhChinhModelImpl, false);
		cacheUniqueFindersCache(trungTamHanhChinhModelImpl);

		trungTamHanhChinh.resetOriginalValues();

		return trungTamHanhChinh;
	}

	/**
	 * Returns the trung tam hanh chinh with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the trung tam hanh chinh
	 * @return the trung tam hanh chinh
	 * @throws NoSuchTrungTamHanhChinhException if a trung tam hanh chinh with the primary key could not be found
	 */
	@Override
	public TrungTamHanhChinh findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTrungTamHanhChinhException {

		TrungTamHanhChinh trungTamHanhChinh = fetchByPrimaryKey(primaryKey);

		if (trungTamHanhChinh == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTrungTamHanhChinhException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return trungTamHanhChinh;
	}

	/**
	 * Returns the trung tam hanh chinh with the primary key or throws a <code>NoSuchTrungTamHanhChinhException</code> if it could not be found.
	 *
	 * @param id the primary key of the trung tam hanh chinh
	 * @return the trung tam hanh chinh
	 * @throws NoSuchTrungTamHanhChinhException if a trung tam hanh chinh with the primary key could not be found
	 */
	@Override
	public TrungTamHanhChinh findByPrimaryKey(long id)
		throws NoSuchTrungTamHanhChinhException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the trung tam hanh chinh with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the trung tam hanh chinh
	 * @return the trung tam hanh chinh, or <code>null</code> if a trung tam hanh chinh with the primary key could not be found
	 */
	@Override
	public TrungTamHanhChinh fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			TrungTamHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			TrungTamHanhChinhImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		TrungTamHanhChinh trungTamHanhChinh = (TrungTamHanhChinh)serializable;

		if (trungTamHanhChinh == null) {
			Session session = null;

			try {
				session = openSession();

				trungTamHanhChinh = (TrungTamHanhChinh)session.get(
					TrungTamHanhChinhImpl.class, primaryKey);

				if (trungTamHanhChinh != null) {
					cacheResult(trungTamHanhChinh);
				}
				else {
					entityCache.putResult(
						TrungTamHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
						TrungTamHanhChinhImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					TrungTamHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
					TrungTamHanhChinhImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return trungTamHanhChinh;
	}

	/**
	 * Returns the trung tam hanh chinh with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the trung tam hanh chinh
	 * @return the trung tam hanh chinh, or <code>null</code> if a trung tam hanh chinh with the primary key could not be found
	 */
	@Override
	public TrungTamHanhChinh fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, TrungTamHanhChinh> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, TrungTamHanhChinh> map =
			new HashMap<Serializable, TrungTamHanhChinh>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			TrungTamHanhChinh trungTamHanhChinh = fetchByPrimaryKey(primaryKey);

			if (trungTamHanhChinh != null) {
				map.put(primaryKey, trungTamHanhChinh);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				TrungTamHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
				TrungTamHanhChinhImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (TrungTamHanhChinh)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_TRUNGTAMHANHCHINH_WHERE_PKS_IN);

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

			for (TrungTamHanhChinh trungTamHanhChinh :
					(List<TrungTamHanhChinh>)q.list()) {

				map.put(
					trungTamHanhChinh.getPrimaryKeyObj(), trungTamHanhChinh);

				cacheResult(trungTamHanhChinh);

				uncachedPrimaryKeys.remove(
					trungTamHanhChinh.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					TrungTamHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
					TrungTamHanhChinhImpl.class, primaryKey, nullModel);
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
	 * Returns all the trung tam hanh chinhs.
	 *
	 * @return the trung tam hanh chinhs
	 */
	@Override
	public List<TrungTamHanhChinh> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the trung tam hanh chinhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TrungTamHanhChinhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of trung tam hanh chinhs
	 * @param end the upper bound of the range of trung tam hanh chinhs (not inclusive)
	 * @return the range of trung tam hanh chinhs
	 */
	@Override
	public List<TrungTamHanhChinh> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the trung tam hanh chinhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TrungTamHanhChinhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of trung tam hanh chinhs
	 * @param end the upper bound of the range of trung tam hanh chinhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of trung tam hanh chinhs
	 */
	@Override
	public List<TrungTamHanhChinh> findAll(
		int start, int end,
		OrderByComparator<TrungTamHanhChinh> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the trung tam hanh chinhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TrungTamHanhChinhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of trung tam hanh chinhs
	 * @param end the upper bound of the range of trung tam hanh chinhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of trung tam hanh chinhs
	 */
	@Override
	public List<TrungTamHanhChinh> findAll(
		int start, int end,
		OrderByComparator<TrungTamHanhChinh> orderByComparator,
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

		List<TrungTamHanhChinh> list = null;

		if (retrieveFromCache) {
			list = (List<TrungTamHanhChinh>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TRUNGTAMHANHCHINH);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TRUNGTAMHANHCHINH;

				if (pagination) {
					sql = sql.concat(TrungTamHanhChinhModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TrungTamHanhChinh>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TrungTamHanhChinh>)QueryUtil.list(
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
	 * Removes all the trung tam hanh chinhs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TrungTamHanhChinh trungTamHanhChinh : findAll()) {
			remove(trungTamHanhChinh);
		}
	}

	/**
	 * Returns the number of trung tam hanh chinhs.
	 *
	 * @return the number of trung tam hanh chinhs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TRUNGTAMHANHCHINH);

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
		return TrungTamHanhChinhModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the trung tam hanh chinh persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			TrungTamHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			TrungTamHanhChinhModelImpl.FINDER_CACHE_ENABLED,
			TrungTamHanhChinhImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			TrungTamHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			TrungTamHanhChinhModelImpl.FINDER_CACHE_ENABLED,
			TrungTamHanhChinhImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			TrungTamHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			TrungTamHanhChinhModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByMa = new FinderPath(
			TrungTamHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			TrungTamHanhChinhModelImpl.FINDER_CACHE_ENABLED,
			TrungTamHanhChinhImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByMa",
			new String[] {String.class.getName()},
			TrungTamHanhChinhModelImpl.MA_COLUMN_BITMASK);

		_finderPathCountByMa = new FinderPath(
			TrungTamHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			TrungTamHanhChinhModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMa",
			new String[] {String.class.getName()});

		_finderPathFetchBydonViId = new FinderPath(
			TrungTamHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			TrungTamHanhChinhModelImpl.FINDER_CACHE_ENABLED,
			TrungTamHanhChinhImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchBydonViId", new String[] {Long.class.getName()},
			TrungTamHanhChinhModelImpl.DONVIID_COLUMN_BITMASK);

		_finderPathCountBydonViId = new FinderPath(
			TrungTamHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			TrungTamHanhChinhModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBydonViId",
			new String[] {Long.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(TrungTamHanhChinhImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_TRUNGTAMHANHCHINH =
		"SELECT trungTamHanhChinh FROM TrungTamHanhChinh trungTamHanhChinh";

	private static final String _SQL_SELECT_TRUNGTAMHANHCHINH_WHERE_PKS_IN =
		"SELECT trungTamHanhChinh FROM TrungTamHanhChinh trungTamHanhChinh WHERE id IN (";

	private static final String _SQL_SELECT_TRUNGTAMHANHCHINH_WHERE =
		"SELECT trungTamHanhChinh FROM TrungTamHanhChinh trungTamHanhChinh WHERE ";

	private static final String _SQL_COUNT_TRUNGTAMHANHCHINH =
		"SELECT COUNT(trungTamHanhChinh) FROM TrungTamHanhChinh trungTamHanhChinh";

	private static final String _SQL_COUNT_TRUNGTAMHANHCHINH_WHERE =
		"SELECT COUNT(trungTamHanhChinh) FROM TrungTamHanhChinh trungTamHanhChinh WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "trungTamHanhChinh.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TrungTamHanhChinh exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TrungTamHanhChinh exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TrungTamHanhChinhPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"donViId", "donViIds", "thongTinLienHe", "trangThai"});

}