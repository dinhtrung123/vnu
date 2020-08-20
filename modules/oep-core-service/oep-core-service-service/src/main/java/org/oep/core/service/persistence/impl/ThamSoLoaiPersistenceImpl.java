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

import org.oep.core.exception.NoSuchThamSoLoaiException;
import org.oep.core.model.ThamSoLoai;
import org.oep.core.model.impl.ThamSoLoaiImpl;
import org.oep.core.model.impl.ThamSoLoaiModelImpl;
import org.oep.core.service.persistence.ThamSoLoaiPersistence;

/**
 * The persistence implementation for the tham so loai service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author manhlb
 * @generated
 */
@ProviderType
public class ThamSoLoaiPersistenceImpl
	extends BasePersistenceImpl<ThamSoLoai> implements ThamSoLoaiPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ThamSoLoaiUtil</code> to access the tham so loai persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ThamSoLoaiImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByTen;
	private FinderPath _finderPathWithoutPaginationFindByTen;
	private FinderPath _finderPathCountByTen;

	/**
	 * Returns all the tham so loais where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the matching tham so loais
	 */
	@Override
	public List<ThamSoLoai> findByTen(String ten) {
		return findByTen(ten, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tham so loais where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ThamSoLoaiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ten the ten
	 * @param start the lower bound of the range of tham so loais
	 * @param end the upper bound of the range of tham so loais (not inclusive)
	 * @return the range of matching tham so loais
	 */
	@Override
	public List<ThamSoLoai> findByTen(String ten, int start, int end) {
		return findByTen(ten, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tham so loais where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ThamSoLoaiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ten the ten
	 * @param start the lower bound of the range of tham so loais
	 * @param end the upper bound of the range of tham so loais (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tham so loais
	 */
	@Override
	public List<ThamSoLoai> findByTen(
		String ten, int start, int end,
		OrderByComparator<ThamSoLoai> orderByComparator) {

		return findByTen(ten, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tham so loais where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ThamSoLoaiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ten the ten
	 * @param start the lower bound of the range of tham so loais
	 * @param end the upper bound of the range of tham so loais (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching tham so loais
	 */
	@Override
	public List<ThamSoLoai> findByTen(
		String ten, int start, int end,
		OrderByComparator<ThamSoLoai> orderByComparator,
		boolean retrieveFromCache) {

		ten = Objects.toString(ten, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByTen;
			finderArgs = new Object[] {ten};
		}
		else {
			finderPath = _finderPathWithPaginationFindByTen;
			finderArgs = new Object[] {ten, start, end, orderByComparator};
		}

		List<ThamSoLoai> list = null;

		if (retrieveFromCache) {
			list = (List<ThamSoLoai>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ThamSoLoai thamSoLoai : list) {
					if (!ten.equals(thamSoLoai.getTen())) {
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

			query.append(_SQL_SELECT_THAMSOLOAI_WHERE);

			boolean bindTen = false;

			if (ten.isEmpty()) {
				query.append(_FINDER_COLUMN_TEN_TEN_3);
			}
			else {
				bindTen = true;

				query.append(_FINDER_COLUMN_TEN_TEN_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(ThamSoLoaiModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTen) {
					qPos.add(ten);
				}

				if (!pagination) {
					list = (List<ThamSoLoai>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ThamSoLoai>)QueryUtil.list(
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
	 * Returns the first tham so loai in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tham so loai
	 * @throws NoSuchThamSoLoaiException if a matching tham so loai could not be found
	 */
	@Override
	public ThamSoLoai findByTen_First(
			String ten, OrderByComparator<ThamSoLoai> orderByComparator)
		throws NoSuchThamSoLoaiException {

		ThamSoLoai thamSoLoai = fetchByTen_First(ten, orderByComparator);

		if (thamSoLoai != null) {
			return thamSoLoai;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ten=");
		msg.append(ten);

		msg.append("}");

		throw new NoSuchThamSoLoaiException(msg.toString());
	}

	/**
	 * Returns the first tham so loai in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tham so loai, or <code>null</code> if a matching tham so loai could not be found
	 */
	@Override
	public ThamSoLoai fetchByTen_First(
		String ten, OrderByComparator<ThamSoLoai> orderByComparator) {

		List<ThamSoLoai> list = findByTen(ten, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tham so loai in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tham so loai
	 * @throws NoSuchThamSoLoaiException if a matching tham so loai could not be found
	 */
	@Override
	public ThamSoLoai findByTen_Last(
			String ten, OrderByComparator<ThamSoLoai> orderByComparator)
		throws NoSuchThamSoLoaiException {

		ThamSoLoai thamSoLoai = fetchByTen_Last(ten, orderByComparator);

		if (thamSoLoai != null) {
			return thamSoLoai;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ten=");
		msg.append(ten);

		msg.append("}");

		throw new NoSuchThamSoLoaiException(msg.toString());
	}

	/**
	 * Returns the last tham so loai in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tham so loai, or <code>null</code> if a matching tham so loai could not be found
	 */
	@Override
	public ThamSoLoai fetchByTen_Last(
		String ten, OrderByComparator<ThamSoLoai> orderByComparator) {

		int count = countByTen(ten);

		if (count == 0) {
			return null;
		}

		List<ThamSoLoai> list = findByTen(
			ten, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tham so loais before and after the current tham so loai in the ordered set where ten = &#63;.
	 *
	 * @param id the primary key of the current tham so loai
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tham so loai
	 * @throws NoSuchThamSoLoaiException if a tham so loai with the primary key could not be found
	 */
	@Override
	public ThamSoLoai[] findByTen_PrevAndNext(
			long id, String ten,
			OrderByComparator<ThamSoLoai> orderByComparator)
		throws NoSuchThamSoLoaiException {

		ten = Objects.toString(ten, "");

		ThamSoLoai thamSoLoai = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ThamSoLoai[] array = new ThamSoLoaiImpl[3];

			array[0] = getByTen_PrevAndNext(
				session, thamSoLoai, ten, orderByComparator, true);

			array[1] = thamSoLoai;

			array[2] = getByTen_PrevAndNext(
				session, thamSoLoai, ten, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ThamSoLoai getByTen_PrevAndNext(
		Session session, ThamSoLoai thamSoLoai, String ten,
		OrderByComparator<ThamSoLoai> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_THAMSOLOAI_WHERE);

		boolean bindTen = false;

		if (ten.isEmpty()) {
			query.append(_FINDER_COLUMN_TEN_TEN_3);
		}
		else {
			bindTen = true;

			query.append(_FINDER_COLUMN_TEN_TEN_2);
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
			query.append(ThamSoLoaiModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindTen) {
			qPos.add(ten);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(thamSoLoai)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<ThamSoLoai> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tham so loais where ten = &#63; from the database.
	 *
	 * @param ten the ten
	 */
	@Override
	public void removeByTen(String ten) {
		for (ThamSoLoai thamSoLoai :
				findByTen(ten, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(thamSoLoai);
		}
	}

	/**
	 * Returns the number of tham so loais where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the number of matching tham so loais
	 */
	@Override
	public int countByTen(String ten) {
		ten = Objects.toString(ten, "");

		FinderPath finderPath = _finderPathCountByTen;

		Object[] finderArgs = new Object[] {ten};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_THAMSOLOAI_WHERE);

			boolean bindTen = false;

			if (ten.isEmpty()) {
				query.append(_FINDER_COLUMN_TEN_TEN_3);
			}
			else {
				bindTen = true;

				query.append(_FINDER_COLUMN_TEN_TEN_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTen) {
					qPos.add(ten);
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

	private static final String _FINDER_COLUMN_TEN_TEN_2 = "thamSoLoai.ten = ?";

	private static final String _FINDER_COLUMN_TEN_TEN_3 =
		"(thamSoLoai.ten IS NULL OR thamSoLoai.ten = '')";

	public ThamSoLoaiPersistenceImpl() {
		setModelClass(ThamSoLoai.class);

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
	 * Caches the tham so loai in the entity cache if it is enabled.
	 *
	 * @param thamSoLoai the tham so loai
	 */
	@Override
	public void cacheResult(ThamSoLoai thamSoLoai) {
		entityCache.putResult(
			ThamSoLoaiModelImpl.ENTITY_CACHE_ENABLED, ThamSoLoaiImpl.class,
			thamSoLoai.getPrimaryKey(), thamSoLoai);

		thamSoLoai.resetOriginalValues();
	}

	/**
	 * Caches the tham so loais in the entity cache if it is enabled.
	 *
	 * @param thamSoLoais the tham so loais
	 */
	@Override
	public void cacheResult(List<ThamSoLoai> thamSoLoais) {
		for (ThamSoLoai thamSoLoai : thamSoLoais) {
			if (entityCache.getResult(
					ThamSoLoaiModelImpl.ENTITY_CACHE_ENABLED,
					ThamSoLoaiImpl.class, thamSoLoai.getPrimaryKey()) == null) {

				cacheResult(thamSoLoai);
			}
			else {
				thamSoLoai.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all tham so loais.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ThamSoLoaiImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the tham so loai.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ThamSoLoai thamSoLoai) {
		entityCache.removeResult(
			ThamSoLoaiModelImpl.ENTITY_CACHE_ENABLED, ThamSoLoaiImpl.class,
			thamSoLoai.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ThamSoLoai> thamSoLoais) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ThamSoLoai thamSoLoai : thamSoLoais) {
			entityCache.removeResult(
				ThamSoLoaiModelImpl.ENTITY_CACHE_ENABLED, ThamSoLoaiImpl.class,
				thamSoLoai.getPrimaryKey());
		}
	}

	/**
	 * Creates a new tham so loai with the primary key. Does not add the tham so loai to the database.
	 *
	 * @param id the primary key for the new tham so loai
	 * @return the new tham so loai
	 */
	@Override
	public ThamSoLoai create(long id) {
		ThamSoLoai thamSoLoai = new ThamSoLoaiImpl();

		thamSoLoai.setNew(true);
		thamSoLoai.setPrimaryKey(id);

		return thamSoLoai;
	}

	/**
	 * Removes the tham so loai with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the tham so loai
	 * @return the tham so loai that was removed
	 * @throws NoSuchThamSoLoaiException if a tham so loai with the primary key could not be found
	 */
	@Override
	public ThamSoLoai remove(long id) throws NoSuchThamSoLoaiException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the tham so loai with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tham so loai
	 * @return the tham so loai that was removed
	 * @throws NoSuchThamSoLoaiException if a tham so loai with the primary key could not be found
	 */
	@Override
	public ThamSoLoai remove(Serializable primaryKey)
		throws NoSuchThamSoLoaiException {

		Session session = null;

		try {
			session = openSession();

			ThamSoLoai thamSoLoai = (ThamSoLoai)session.get(
				ThamSoLoaiImpl.class, primaryKey);

			if (thamSoLoai == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchThamSoLoaiException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(thamSoLoai);
		}
		catch (NoSuchThamSoLoaiException nsee) {
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
	protected ThamSoLoai removeImpl(ThamSoLoai thamSoLoai) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(thamSoLoai)) {
				thamSoLoai = (ThamSoLoai)session.get(
					ThamSoLoaiImpl.class, thamSoLoai.getPrimaryKeyObj());
			}

			if (thamSoLoai != null) {
				session.delete(thamSoLoai);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (thamSoLoai != null) {
			clearCache(thamSoLoai);
		}

		return thamSoLoai;
	}

	@Override
	public ThamSoLoai updateImpl(ThamSoLoai thamSoLoai) {
		boolean isNew = thamSoLoai.isNew();

		if (!(thamSoLoai instanceof ThamSoLoaiModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(thamSoLoai.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(thamSoLoai);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in thamSoLoai proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ThamSoLoai implementation " +
					thamSoLoai.getClass());
		}

		ThamSoLoaiModelImpl thamSoLoaiModelImpl =
			(ThamSoLoaiModelImpl)thamSoLoai;

		Session session = null;

		try {
			session = openSession();

			if (thamSoLoai.isNew()) {
				session.save(thamSoLoai);

				thamSoLoai.setNew(false);
			}
			else {
				thamSoLoai = (ThamSoLoai)session.merge(thamSoLoai);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!ThamSoLoaiModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {thamSoLoaiModelImpl.getTen()};

			finderCache.removeResult(_finderPathCountByTen, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByTen, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((thamSoLoaiModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByTen.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					thamSoLoaiModelImpl.getOriginalTen()
				};

				finderCache.removeResult(_finderPathCountByTen, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTen, args);

				args = new Object[] {thamSoLoaiModelImpl.getTen()};

				finderCache.removeResult(_finderPathCountByTen, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTen, args);
			}
		}

		entityCache.putResult(
			ThamSoLoaiModelImpl.ENTITY_CACHE_ENABLED, ThamSoLoaiImpl.class,
			thamSoLoai.getPrimaryKey(), thamSoLoai, false);

		thamSoLoai.resetOriginalValues();

		return thamSoLoai;
	}

	/**
	 * Returns the tham so loai with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tham so loai
	 * @return the tham so loai
	 * @throws NoSuchThamSoLoaiException if a tham so loai with the primary key could not be found
	 */
	@Override
	public ThamSoLoai findByPrimaryKey(Serializable primaryKey)
		throws NoSuchThamSoLoaiException {

		ThamSoLoai thamSoLoai = fetchByPrimaryKey(primaryKey);

		if (thamSoLoai == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchThamSoLoaiException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return thamSoLoai;
	}

	/**
	 * Returns the tham so loai with the primary key or throws a <code>NoSuchThamSoLoaiException</code> if it could not be found.
	 *
	 * @param id the primary key of the tham so loai
	 * @return the tham so loai
	 * @throws NoSuchThamSoLoaiException if a tham so loai with the primary key could not be found
	 */
	@Override
	public ThamSoLoai findByPrimaryKey(long id)
		throws NoSuchThamSoLoaiException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the tham so loai with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tham so loai
	 * @return the tham so loai, or <code>null</code> if a tham so loai with the primary key could not be found
	 */
	@Override
	public ThamSoLoai fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			ThamSoLoaiModelImpl.ENTITY_CACHE_ENABLED, ThamSoLoaiImpl.class,
			primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		ThamSoLoai thamSoLoai = (ThamSoLoai)serializable;

		if (thamSoLoai == null) {
			Session session = null;

			try {
				session = openSession();

				thamSoLoai = (ThamSoLoai)session.get(
					ThamSoLoaiImpl.class, primaryKey);

				if (thamSoLoai != null) {
					cacheResult(thamSoLoai);
				}
				else {
					entityCache.putResult(
						ThamSoLoaiModelImpl.ENTITY_CACHE_ENABLED,
						ThamSoLoaiImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					ThamSoLoaiModelImpl.ENTITY_CACHE_ENABLED,
					ThamSoLoaiImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return thamSoLoai;
	}

	/**
	 * Returns the tham so loai with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the tham so loai
	 * @return the tham so loai, or <code>null</code> if a tham so loai with the primary key could not be found
	 */
	@Override
	public ThamSoLoai fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, ThamSoLoai> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ThamSoLoai> map =
			new HashMap<Serializable, ThamSoLoai>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ThamSoLoai thamSoLoai = fetchByPrimaryKey(primaryKey);

			if (thamSoLoai != null) {
				map.put(primaryKey, thamSoLoai);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				ThamSoLoaiModelImpl.ENTITY_CACHE_ENABLED, ThamSoLoaiImpl.class,
				primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (ThamSoLoai)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_THAMSOLOAI_WHERE_PKS_IN);

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

			for (ThamSoLoai thamSoLoai : (List<ThamSoLoai>)q.list()) {
				map.put(thamSoLoai.getPrimaryKeyObj(), thamSoLoai);

				cacheResult(thamSoLoai);

				uncachedPrimaryKeys.remove(thamSoLoai.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					ThamSoLoaiModelImpl.ENTITY_CACHE_ENABLED,
					ThamSoLoaiImpl.class, primaryKey, nullModel);
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
	 * Returns all the tham so loais.
	 *
	 * @return the tham so loais
	 */
	@Override
	public List<ThamSoLoai> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tham so loais.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ThamSoLoaiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tham so loais
	 * @param end the upper bound of the range of tham so loais (not inclusive)
	 * @return the range of tham so loais
	 */
	@Override
	public List<ThamSoLoai> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the tham so loais.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ThamSoLoaiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tham so loais
	 * @param end the upper bound of the range of tham so loais (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tham so loais
	 */
	@Override
	public List<ThamSoLoai> findAll(
		int start, int end, OrderByComparator<ThamSoLoai> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tham so loais.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ThamSoLoaiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tham so loais
	 * @param end the upper bound of the range of tham so loais (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of tham so loais
	 */
	@Override
	public List<ThamSoLoai> findAll(
		int start, int end, OrderByComparator<ThamSoLoai> orderByComparator,
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

		List<ThamSoLoai> list = null;

		if (retrieveFromCache) {
			list = (List<ThamSoLoai>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_THAMSOLOAI);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_THAMSOLOAI;

				if (pagination) {
					sql = sql.concat(ThamSoLoaiModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ThamSoLoai>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ThamSoLoai>)QueryUtil.list(
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
	 * Removes all the tham so loais from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ThamSoLoai thamSoLoai : findAll()) {
			remove(thamSoLoai);
		}
	}

	/**
	 * Returns the number of tham so loais.
	 *
	 * @return the number of tham so loais
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_THAMSOLOAI);

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
		return ThamSoLoaiModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the tham so loai persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			ThamSoLoaiModelImpl.ENTITY_CACHE_ENABLED,
			ThamSoLoaiModelImpl.FINDER_CACHE_ENABLED, ThamSoLoaiImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			ThamSoLoaiModelImpl.ENTITY_CACHE_ENABLED,
			ThamSoLoaiModelImpl.FINDER_CACHE_ENABLED, ThamSoLoaiImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			ThamSoLoaiModelImpl.ENTITY_CACHE_ENABLED,
			ThamSoLoaiModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByTen = new FinderPath(
			ThamSoLoaiModelImpl.ENTITY_CACHE_ENABLED,
			ThamSoLoaiModelImpl.FINDER_CACHE_ENABLED, ThamSoLoaiImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTen",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByTen = new FinderPath(
			ThamSoLoaiModelImpl.ENTITY_CACHE_ENABLED,
			ThamSoLoaiModelImpl.FINDER_CACHE_ENABLED, ThamSoLoaiImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTen",
			new String[] {String.class.getName()},
			ThamSoLoaiModelImpl.TEN_COLUMN_BITMASK);

		_finderPathCountByTen = new FinderPath(
			ThamSoLoaiModelImpl.ENTITY_CACHE_ENABLED,
			ThamSoLoaiModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTen",
			new String[] {String.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(ThamSoLoaiImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_THAMSOLOAI =
		"SELECT thamSoLoai FROM ThamSoLoai thamSoLoai";

	private static final String _SQL_SELECT_THAMSOLOAI_WHERE_PKS_IN =
		"SELECT thamSoLoai FROM ThamSoLoai thamSoLoai WHERE id IN (";

	private static final String _SQL_SELECT_THAMSOLOAI_WHERE =
		"SELECT thamSoLoai FROM ThamSoLoai thamSoLoai WHERE ";

	private static final String _SQL_COUNT_THAMSOLOAI =
		"SELECT COUNT(thamSoLoai) FROM ThamSoLoai thamSoLoai";

	private static final String _SQL_COUNT_THAMSOLOAI_WHERE =
		"SELECT COUNT(thamSoLoai) FROM ThamSoLoai thamSoLoai WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "thamSoLoai.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ThamSoLoai exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ThamSoLoai exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ThamSoLoaiPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"moTa"});

}