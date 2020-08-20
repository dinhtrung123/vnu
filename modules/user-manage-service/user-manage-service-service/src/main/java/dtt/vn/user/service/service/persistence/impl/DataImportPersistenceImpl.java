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

import dtt.vn.user.service.exception.NoSuchDataImportException;
import dtt.vn.user.service.model.DataImport;
import dtt.vn.user.service.model.impl.DataImportImpl;
import dtt.vn.user.service.model.impl.DataImportModelImpl;
import dtt.vn.user.service.service.persistence.DataImportPersistence;

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
 * The persistence implementation for the data import service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nhanvienDTT
 * @generated
 */
@ProviderType
public class DataImportPersistenceImpl
	extends BasePersistenceImpl<DataImport> implements DataImportPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DataImportUtil</code> to access the data import persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DataImportImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByI;
	private FinderPath _finderPathWithoutPaginationFindByI;
	private FinderPath _finderPathCountByI;

	/**
	 * Returns all the data imports where hasImport = &#63;.
	 *
	 * @param hasImport the has import
	 * @return the matching data imports
	 */
	@Override
	public List<DataImport> findByI(String hasImport) {
		return findByI(hasImport, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data imports where hasImport = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataImportModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param hasImport the has import
	 * @param start the lower bound of the range of data imports
	 * @param end the upper bound of the range of data imports (not inclusive)
	 * @return the range of matching data imports
	 */
	@Override
	public List<DataImport> findByI(String hasImport, int start, int end) {
		return findByI(hasImport, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data imports where hasImport = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataImportModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param hasImport the has import
	 * @param start the lower bound of the range of data imports
	 * @param end the upper bound of the range of data imports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data imports
	 */
	@Override
	public List<DataImport> findByI(
		String hasImport, int start, int end,
		OrderByComparator<DataImport> orderByComparator) {

		return findByI(hasImport, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data imports where hasImport = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataImportModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param hasImport the has import
	 * @param start the lower bound of the range of data imports
	 * @param end the upper bound of the range of data imports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching data imports
	 */
	@Override
	public List<DataImport> findByI(
		String hasImport, int start, int end,
		OrderByComparator<DataImport> orderByComparator,
		boolean retrieveFromCache) {

		hasImport = Objects.toString(hasImport, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByI;
			finderArgs = new Object[] {hasImport};
		}
		else {
			finderPath = _finderPathWithPaginationFindByI;
			finderArgs = new Object[] {
				hasImport, start, end, orderByComparator
			};
		}

		List<DataImport> list = null;

		if (retrieveFromCache) {
			list = (List<DataImport>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DataImport dataImport : list) {
					if (!hasImport.equals(dataImport.getHasImport())) {
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

			query.append(_SQL_SELECT_DATAIMPORT_WHERE);

			boolean bindHasImport = false;

			if (hasImport.isEmpty()) {
				query.append(_FINDER_COLUMN_I_HASIMPORT_3);
			}
			else {
				bindHasImport = true;

				query.append(_FINDER_COLUMN_I_HASIMPORT_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(DataImportModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindHasImport) {
					qPos.add(hasImport);
				}

				if (!pagination) {
					list = (List<DataImport>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DataImport>)QueryUtil.list(
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
	 * Returns the first data import in the ordered set where hasImport = &#63;.
	 *
	 * @param hasImport the has import
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data import
	 * @throws NoSuchDataImportException if a matching data import could not be found
	 */
	@Override
	public DataImport findByI_First(
			String hasImport, OrderByComparator<DataImport> orderByComparator)
		throws NoSuchDataImportException {

		DataImport dataImport = fetchByI_First(hasImport, orderByComparator);

		if (dataImport != null) {
			return dataImport;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("hasImport=");
		msg.append(hasImport);

		msg.append("}");

		throw new NoSuchDataImportException(msg.toString());
	}

	/**
	 * Returns the first data import in the ordered set where hasImport = &#63;.
	 *
	 * @param hasImport the has import
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data import, or <code>null</code> if a matching data import could not be found
	 */
	@Override
	public DataImport fetchByI_First(
		String hasImport, OrderByComparator<DataImport> orderByComparator) {

		List<DataImport> list = findByI(hasImport, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data import in the ordered set where hasImport = &#63;.
	 *
	 * @param hasImport the has import
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data import
	 * @throws NoSuchDataImportException if a matching data import could not be found
	 */
	@Override
	public DataImport findByI_Last(
			String hasImport, OrderByComparator<DataImport> orderByComparator)
		throws NoSuchDataImportException {

		DataImport dataImport = fetchByI_Last(hasImport, orderByComparator);

		if (dataImport != null) {
			return dataImport;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("hasImport=");
		msg.append(hasImport);

		msg.append("}");

		throw new NoSuchDataImportException(msg.toString());
	}

	/**
	 * Returns the last data import in the ordered set where hasImport = &#63;.
	 *
	 * @param hasImport the has import
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data import, or <code>null</code> if a matching data import could not be found
	 */
	@Override
	public DataImport fetchByI_Last(
		String hasImport, OrderByComparator<DataImport> orderByComparator) {

		int count = countByI(hasImport);

		if (count == 0) {
			return null;
		}

		List<DataImport> list = findByI(
			hasImport, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the data imports before and after the current data import in the ordered set where hasImport = &#63;.
	 *
	 * @param id the primary key of the current data import
	 * @param hasImport the has import
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data import
	 * @throws NoSuchDataImportException if a data import with the primary key could not be found
	 */
	@Override
	public DataImport[] findByI_PrevAndNext(
			long id, String hasImport,
			OrderByComparator<DataImport> orderByComparator)
		throws NoSuchDataImportException {

		hasImport = Objects.toString(hasImport, "");

		DataImport dataImport = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			DataImport[] array = new DataImportImpl[3];

			array[0] = getByI_PrevAndNext(
				session, dataImport, hasImport, orderByComparator, true);

			array[1] = dataImport;

			array[2] = getByI_PrevAndNext(
				session, dataImport, hasImport, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DataImport getByI_PrevAndNext(
		Session session, DataImport dataImport, String hasImport,
		OrderByComparator<DataImport> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DATAIMPORT_WHERE);

		boolean bindHasImport = false;

		if (hasImport.isEmpty()) {
			query.append(_FINDER_COLUMN_I_HASIMPORT_3);
		}
		else {
			bindHasImport = true;

			query.append(_FINDER_COLUMN_I_HASIMPORT_2);
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
			query.append(DataImportModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindHasImport) {
			qPos.add(hasImport);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(dataImport)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<DataImport> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the data imports where hasImport = &#63; from the database.
	 *
	 * @param hasImport the has import
	 */
	@Override
	public void removeByI(String hasImport) {
		for (DataImport dataImport :
				findByI(
					hasImport, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dataImport);
		}
	}

	/**
	 * Returns the number of data imports where hasImport = &#63;.
	 *
	 * @param hasImport the has import
	 * @return the number of matching data imports
	 */
	@Override
	public int countByI(String hasImport) {
		hasImport = Objects.toString(hasImport, "");

		FinderPath finderPath = _finderPathCountByI;

		Object[] finderArgs = new Object[] {hasImport};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DATAIMPORT_WHERE);

			boolean bindHasImport = false;

			if (hasImport.isEmpty()) {
				query.append(_FINDER_COLUMN_I_HASIMPORT_3);
			}
			else {
				bindHasImport = true;

				query.append(_FINDER_COLUMN_I_HASIMPORT_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindHasImport) {
					qPos.add(hasImport);
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

	private static final String _FINDER_COLUMN_I_HASIMPORT_2 =
		"dataImport.hasImport = ?";

	private static final String _FINDER_COLUMN_I_HASIMPORT_3 =
		"(dataImport.hasImport IS NULL OR dataImport.hasImport = '')";

	private FinderPath _finderPathWithPaginationFindByScreenName;
	private FinderPath _finderPathWithoutPaginationFindByScreenName;
	private FinderPath _finderPathCountByScreenName;

	/**
	 * Returns all the data imports where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @return the matching data imports
	 */
	@Override
	public List<DataImport> findByScreenName(String screenName) {
		return findByScreenName(
			screenName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data imports where screenName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataImportModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param screenName the screen name
	 * @param start the lower bound of the range of data imports
	 * @param end the upper bound of the range of data imports (not inclusive)
	 * @return the range of matching data imports
	 */
	@Override
	public List<DataImport> findByScreenName(
		String screenName, int start, int end) {

		return findByScreenName(screenName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data imports where screenName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataImportModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param screenName the screen name
	 * @param start the lower bound of the range of data imports
	 * @param end the upper bound of the range of data imports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data imports
	 */
	@Override
	public List<DataImport> findByScreenName(
		String screenName, int start, int end,
		OrderByComparator<DataImport> orderByComparator) {

		return findByScreenName(
			screenName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data imports where screenName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataImportModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param screenName the screen name
	 * @param start the lower bound of the range of data imports
	 * @param end the upper bound of the range of data imports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching data imports
	 */
	@Override
	public List<DataImport> findByScreenName(
		String screenName, int start, int end,
		OrderByComparator<DataImport> orderByComparator,
		boolean retrieveFromCache) {

		screenName = Objects.toString(screenName, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByScreenName;
			finderArgs = new Object[] {screenName};
		}
		else {
			finderPath = _finderPathWithPaginationFindByScreenName;
			finderArgs = new Object[] {
				screenName, start, end, orderByComparator
			};
		}

		List<DataImport> list = null;

		if (retrieveFromCache) {
			list = (List<DataImport>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DataImport dataImport : list) {
					if (!screenName.equals(dataImport.getScreenName())) {
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

			query.append(_SQL_SELECT_DATAIMPORT_WHERE);

			boolean bindScreenName = false;

			if (screenName.isEmpty()) {
				query.append(_FINDER_COLUMN_SCREENNAME_SCREENNAME_3);
			}
			else {
				bindScreenName = true;

				query.append(_FINDER_COLUMN_SCREENNAME_SCREENNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(DataImportModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindScreenName) {
					qPos.add(screenName);
				}

				if (!pagination) {
					list = (List<DataImport>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DataImport>)QueryUtil.list(
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
	 * Returns the first data import in the ordered set where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data import
	 * @throws NoSuchDataImportException if a matching data import could not be found
	 */
	@Override
	public DataImport findByScreenName_First(
			String screenName, OrderByComparator<DataImport> orderByComparator)
		throws NoSuchDataImportException {

		DataImport dataImport = fetchByScreenName_First(
			screenName, orderByComparator);

		if (dataImport != null) {
			return dataImport;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("screenName=");
		msg.append(screenName);

		msg.append("}");

		throw new NoSuchDataImportException(msg.toString());
	}

	/**
	 * Returns the first data import in the ordered set where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data import, or <code>null</code> if a matching data import could not be found
	 */
	@Override
	public DataImport fetchByScreenName_First(
		String screenName, OrderByComparator<DataImport> orderByComparator) {

		List<DataImport> list = findByScreenName(
			screenName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data import in the ordered set where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data import
	 * @throws NoSuchDataImportException if a matching data import could not be found
	 */
	@Override
	public DataImport findByScreenName_Last(
			String screenName, OrderByComparator<DataImport> orderByComparator)
		throws NoSuchDataImportException {

		DataImport dataImport = fetchByScreenName_Last(
			screenName, orderByComparator);

		if (dataImport != null) {
			return dataImport;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("screenName=");
		msg.append(screenName);

		msg.append("}");

		throw new NoSuchDataImportException(msg.toString());
	}

	/**
	 * Returns the last data import in the ordered set where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data import, or <code>null</code> if a matching data import could not be found
	 */
	@Override
	public DataImport fetchByScreenName_Last(
		String screenName, OrderByComparator<DataImport> orderByComparator) {

		int count = countByScreenName(screenName);

		if (count == 0) {
			return null;
		}

		List<DataImport> list = findByScreenName(
			screenName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the data imports before and after the current data import in the ordered set where screenName = &#63;.
	 *
	 * @param id the primary key of the current data import
	 * @param screenName the screen name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data import
	 * @throws NoSuchDataImportException if a data import with the primary key could not be found
	 */
	@Override
	public DataImport[] findByScreenName_PrevAndNext(
			long id, String screenName,
			OrderByComparator<DataImport> orderByComparator)
		throws NoSuchDataImportException {

		screenName = Objects.toString(screenName, "");

		DataImport dataImport = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			DataImport[] array = new DataImportImpl[3];

			array[0] = getByScreenName_PrevAndNext(
				session, dataImport, screenName, orderByComparator, true);

			array[1] = dataImport;

			array[2] = getByScreenName_PrevAndNext(
				session, dataImport, screenName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DataImport getByScreenName_PrevAndNext(
		Session session, DataImport dataImport, String screenName,
		OrderByComparator<DataImport> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DATAIMPORT_WHERE);

		boolean bindScreenName = false;

		if (screenName.isEmpty()) {
			query.append(_FINDER_COLUMN_SCREENNAME_SCREENNAME_3);
		}
		else {
			bindScreenName = true;

			query.append(_FINDER_COLUMN_SCREENNAME_SCREENNAME_2);
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
			query.append(DataImportModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindScreenName) {
			qPos.add(screenName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(dataImport)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<DataImport> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the data imports where screenName = &#63; from the database.
	 *
	 * @param screenName the screen name
	 */
	@Override
	public void removeByScreenName(String screenName) {
		for (DataImport dataImport :
				findByScreenName(
					screenName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dataImport);
		}
	}

	/**
	 * Returns the number of data imports where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @return the number of matching data imports
	 */
	@Override
	public int countByScreenName(String screenName) {
		screenName = Objects.toString(screenName, "");

		FinderPath finderPath = _finderPathCountByScreenName;

		Object[] finderArgs = new Object[] {screenName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DATAIMPORT_WHERE);

			boolean bindScreenName = false;

			if (screenName.isEmpty()) {
				query.append(_FINDER_COLUMN_SCREENNAME_SCREENNAME_3);
			}
			else {
				bindScreenName = true;

				query.append(_FINDER_COLUMN_SCREENNAME_SCREENNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindScreenName) {
					qPos.add(screenName);
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

	private static final String _FINDER_COLUMN_SCREENNAME_SCREENNAME_2 =
		"dataImport.screenName = ?";

	private static final String _FINDER_COLUMN_SCREENNAME_SCREENNAME_3 =
		"(dataImport.screenName IS NULL OR dataImport.screenName = '')";

	private FinderPath _finderPathWithPaginationFindByLastName;
	private FinderPath _finderPathWithoutPaginationFindByLastName;
	private FinderPath _finderPathCountByLastName;

	/**
	 * Returns all the data imports where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @return the matching data imports
	 */
	@Override
	public List<DataImport> findByLastName(String lastName) {
		return findByLastName(
			lastName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data imports where lastName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataImportModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lastName the last name
	 * @param start the lower bound of the range of data imports
	 * @param end the upper bound of the range of data imports (not inclusive)
	 * @return the range of matching data imports
	 */
	@Override
	public List<DataImport> findByLastName(
		String lastName, int start, int end) {

		return findByLastName(lastName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data imports where lastName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataImportModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lastName the last name
	 * @param start the lower bound of the range of data imports
	 * @param end the upper bound of the range of data imports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data imports
	 */
	@Override
	public List<DataImport> findByLastName(
		String lastName, int start, int end,
		OrderByComparator<DataImport> orderByComparator) {

		return findByLastName(lastName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data imports where lastName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataImportModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lastName the last name
	 * @param start the lower bound of the range of data imports
	 * @param end the upper bound of the range of data imports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching data imports
	 */
	@Override
	public List<DataImport> findByLastName(
		String lastName, int start, int end,
		OrderByComparator<DataImport> orderByComparator,
		boolean retrieveFromCache) {

		lastName = Objects.toString(lastName, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByLastName;
			finderArgs = new Object[] {lastName};
		}
		else {
			finderPath = _finderPathWithPaginationFindByLastName;
			finderArgs = new Object[] {lastName, start, end, orderByComparator};
		}

		List<DataImport> list = null;

		if (retrieveFromCache) {
			list = (List<DataImport>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DataImport dataImport : list) {
					if (!lastName.equals(dataImport.getLastName())) {
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

			query.append(_SQL_SELECT_DATAIMPORT_WHERE);

			boolean bindLastName = false;

			if (lastName.isEmpty()) {
				query.append(_FINDER_COLUMN_LASTNAME_LASTNAME_3);
			}
			else {
				bindLastName = true;

				query.append(_FINDER_COLUMN_LASTNAME_LASTNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(DataImportModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLastName) {
					qPos.add(lastName);
				}

				if (!pagination) {
					list = (List<DataImport>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DataImport>)QueryUtil.list(
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
	 * Returns the first data import in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data import
	 * @throws NoSuchDataImportException if a matching data import could not be found
	 */
	@Override
	public DataImport findByLastName_First(
			String lastName, OrderByComparator<DataImport> orderByComparator)
		throws NoSuchDataImportException {

		DataImport dataImport = fetchByLastName_First(
			lastName, orderByComparator);

		if (dataImport != null) {
			return dataImport;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("lastName=");
		msg.append(lastName);

		msg.append("}");

		throw new NoSuchDataImportException(msg.toString());
	}

	/**
	 * Returns the first data import in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data import, or <code>null</code> if a matching data import could not be found
	 */
	@Override
	public DataImport fetchByLastName_First(
		String lastName, OrderByComparator<DataImport> orderByComparator) {

		List<DataImport> list = findByLastName(
			lastName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data import in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data import
	 * @throws NoSuchDataImportException if a matching data import could not be found
	 */
	@Override
	public DataImport findByLastName_Last(
			String lastName, OrderByComparator<DataImport> orderByComparator)
		throws NoSuchDataImportException {

		DataImport dataImport = fetchByLastName_Last(
			lastName, orderByComparator);

		if (dataImport != null) {
			return dataImport;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("lastName=");
		msg.append(lastName);

		msg.append("}");

		throw new NoSuchDataImportException(msg.toString());
	}

	/**
	 * Returns the last data import in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data import, or <code>null</code> if a matching data import could not be found
	 */
	@Override
	public DataImport fetchByLastName_Last(
		String lastName, OrderByComparator<DataImport> orderByComparator) {

		int count = countByLastName(lastName);

		if (count == 0) {
			return null;
		}

		List<DataImport> list = findByLastName(
			lastName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the data imports before and after the current data import in the ordered set where lastName = &#63;.
	 *
	 * @param id the primary key of the current data import
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data import
	 * @throws NoSuchDataImportException if a data import with the primary key could not be found
	 */
	@Override
	public DataImport[] findByLastName_PrevAndNext(
			long id, String lastName,
			OrderByComparator<DataImport> orderByComparator)
		throws NoSuchDataImportException {

		lastName = Objects.toString(lastName, "");

		DataImport dataImport = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			DataImport[] array = new DataImportImpl[3];

			array[0] = getByLastName_PrevAndNext(
				session, dataImport, lastName, orderByComparator, true);

			array[1] = dataImport;

			array[2] = getByLastName_PrevAndNext(
				session, dataImport, lastName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DataImport getByLastName_PrevAndNext(
		Session session, DataImport dataImport, String lastName,
		OrderByComparator<DataImport> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DATAIMPORT_WHERE);

		boolean bindLastName = false;

		if (lastName.isEmpty()) {
			query.append(_FINDER_COLUMN_LASTNAME_LASTNAME_3);
		}
		else {
			bindLastName = true;

			query.append(_FINDER_COLUMN_LASTNAME_LASTNAME_2);
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
			query.append(DataImportModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindLastName) {
			qPos.add(lastName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(dataImport)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<DataImport> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the data imports where lastName = &#63; from the database.
	 *
	 * @param lastName the last name
	 */
	@Override
	public void removeByLastName(String lastName) {
		for (DataImport dataImport :
				findByLastName(
					lastName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dataImport);
		}
	}

	/**
	 * Returns the number of data imports where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @return the number of matching data imports
	 */
	@Override
	public int countByLastName(String lastName) {
		lastName = Objects.toString(lastName, "");

		FinderPath finderPath = _finderPathCountByLastName;

		Object[] finderArgs = new Object[] {lastName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DATAIMPORT_WHERE);

			boolean bindLastName = false;

			if (lastName.isEmpty()) {
				query.append(_FINDER_COLUMN_LASTNAME_LASTNAME_3);
			}
			else {
				bindLastName = true;

				query.append(_FINDER_COLUMN_LASTNAME_LASTNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLastName) {
					qPos.add(lastName);
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

	private static final String _FINDER_COLUMN_LASTNAME_LASTNAME_2 =
		"dataImport.lastName = ?";

	private static final String _FINDER_COLUMN_LASTNAME_LASTNAME_3 =
		"(dataImport.lastName IS NULL OR dataImport.lastName = '')";

	private FinderPath _finderPathWithPaginationFindByEmailAddress;
	private FinderPath _finderPathWithoutPaginationFindByEmailAddress;
	private FinderPath _finderPathCountByEmailAddress;

	/**
	 * Returns all the data imports where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @return the matching data imports
	 */
	@Override
	public List<DataImport> findByEmailAddress(String emailAddress) {
		return findByEmailAddress(
			emailAddress, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data imports where emailAddress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataImportModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param emailAddress the email address
	 * @param start the lower bound of the range of data imports
	 * @param end the upper bound of the range of data imports (not inclusive)
	 * @return the range of matching data imports
	 */
	@Override
	public List<DataImport> findByEmailAddress(
		String emailAddress, int start, int end) {

		return findByEmailAddress(emailAddress, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data imports where emailAddress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataImportModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param emailAddress the email address
	 * @param start the lower bound of the range of data imports
	 * @param end the upper bound of the range of data imports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data imports
	 */
	@Override
	public List<DataImport> findByEmailAddress(
		String emailAddress, int start, int end,
		OrderByComparator<DataImport> orderByComparator) {

		return findByEmailAddress(
			emailAddress, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data imports where emailAddress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataImportModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param emailAddress the email address
	 * @param start the lower bound of the range of data imports
	 * @param end the upper bound of the range of data imports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching data imports
	 */
	@Override
	public List<DataImport> findByEmailAddress(
		String emailAddress, int start, int end,
		OrderByComparator<DataImport> orderByComparator,
		boolean retrieveFromCache) {

		emailAddress = Objects.toString(emailAddress, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByEmailAddress;
			finderArgs = new Object[] {emailAddress};
		}
		else {
			finderPath = _finderPathWithPaginationFindByEmailAddress;
			finderArgs = new Object[] {
				emailAddress, start, end, orderByComparator
			};
		}

		List<DataImport> list = null;

		if (retrieveFromCache) {
			list = (List<DataImport>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DataImport dataImport : list) {
					if (!emailAddress.equals(dataImport.getEmailAddress())) {
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

			query.append(_SQL_SELECT_DATAIMPORT_WHERE);

			boolean bindEmailAddress = false;

			if (emailAddress.isEmpty()) {
				query.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_3);
			}
			else {
				bindEmailAddress = true;

				query.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(DataImportModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEmailAddress) {
					qPos.add(emailAddress);
				}

				if (!pagination) {
					list = (List<DataImport>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DataImport>)QueryUtil.list(
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
	 * Returns the first data import in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data import
	 * @throws NoSuchDataImportException if a matching data import could not be found
	 */
	@Override
	public DataImport findByEmailAddress_First(
			String emailAddress,
			OrderByComparator<DataImport> orderByComparator)
		throws NoSuchDataImportException {

		DataImport dataImport = fetchByEmailAddress_First(
			emailAddress, orderByComparator);

		if (dataImport != null) {
			return dataImport;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("emailAddress=");
		msg.append(emailAddress);

		msg.append("}");

		throw new NoSuchDataImportException(msg.toString());
	}

	/**
	 * Returns the first data import in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data import, or <code>null</code> if a matching data import could not be found
	 */
	@Override
	public DataImport fetchByEmailAddress_First(
		String emailAddress, OrderByComparator<DataImport> orderByComparator) {

		List<DataImport> list = findByEmailAddress(
			emailAddress, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data import in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data import
	 * @throws NoSuchDataImportException if a matching data import could not be found
	 */
	@Override
	public DataImport findByEmailAddress_Last(
			String emailAddress,
			OrderByComparator<DataImport> orderByComparator)
		throws NoSuchDataImportException {

		DataImport dataImport = fetchByEmailAddress_Last(
			emailAddress, orderByComparator);

		if (dataImport != null) {
			return dataImport;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("emailAddress=");
		msg.append(emailAddress);

		msg.append("}");

		throw new NoSuchDataImportException(msg.toString());
	}

	/**
	 * Returns the last data import in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data import, or <code>null</code> if a matching data import could not be found
	 */
	@Override
	public DataImport fetchByEmailAddress_Last(
		String emailAddress, OrderByComparator<DataImport> orderByComparator) {

		int count = countByEmailAddress(emailAddress);

		if (count == 0) {
			return null;
		}

		List<DataImport> list = findByEmailAddress(
			emailAddress, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the data imports before and after the current data import in the ordered set where emailAddress = &#63;.
	 *
	 * @param id the primary key of the current data import
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data import
	 * @throws NoSuchDataImportException if a data import with the primary key could not be found
	 */
	@Override
	public DataImport[] findByEmailAddress_PrevAndNext(
			long id, String emailAddress,
			OrderByComparator<DataImport> orderByComparator)
		throws NoSuchDataImportException {

		emailAddress = Objects.toString(emailAddress, "");

		DataImport dataImport = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			DataImport[] array = new DataImportImpl[3];

			array[0] = getByEmailAddress_PrevAndNext(
				session, dataImport, emailAddress, orderByComparator, true);

			array[1] = dataImport;

			array[2] = getByEmailAddress_PrevAndNext(
				session, dataImport, emailAddress, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DataImport getByEmailAddress_PrevAndNext(
		Session session, DataImport dataImport, String emailAddress,
		OrderByComparator<DataImport> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DATAIMPORT_WHERE);

		boolean bindEmailAddress = false;

		if (emailAddress.isEmpty()) {
			query.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_3);
		}
		else {
			bindEmailAddress = true;

			query.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_2);
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
			query.append(DataImportModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindEmailAddress) {
			qPos.add(emailAddress);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(dataImport)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<DataImport> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the data imports where emailAddress = &#63; from the database.
	 *
	 * @param emailAddress the email address
	 */
	@Override
	public void removeByEmailAddress(String emailAddress) {
		for (DataImport dataImport :
				findByEmailAddress(
					emailAddress, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dataImport);
		}
	}

	/**
	 * Returns the number of data imports where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @return the number of matching data imports
	 */
	@Override
	public int countByEmailAddress(String emailAddress) {
		emailAddress = Objects.toString(emailAddress, "");

		FinderPath finderPath = _finderPathCountByEmailAddress;

		Object[] finderArgs = new Object[] {emailAddress};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DATAIMPORT_WHERE);

			boolean bindEmailAddress = false;

			if (emailAddress.isEmpty()) {
				query.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_3);
			}
			else {
				bindEmailAddress = true;

				query.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEmailAddress) {
					qPos.add(emailAddress);
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

	private static final String _FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_2 =
		"dataImport.emailAddress = ?";

	private static final String _FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_3 =
		"(dataImport.emailAddress IS NULL OR dataImport.emailAddress = '')";

	private FinderPath _finderPathWithPaginationFindByPhone;
	private FinderPath _finderPathWithoutPaginationFindByPhone;
	private FinderPath _finderPathCountByPhone;

	/**
	 * Returns all the data imports where phone = &#63;.
	 *
	 * @param phone the phone
	 * @return the matching data imports
	 */
	@Override
	public List<DataImport> findByPhone(String phone) {
		return findByPhone(phone, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data imports where phone = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataImportModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param phone the phone
	 * @param start the lower bound of the range of data imports
	 * @param end the upper bound of the range of data imports (not inclusive)
	 * @return the range of matching data imports
	 */
	@Override
	public List<DataImport> findByPhone(String phone, int start, int end) {
		return findByPhone(phone, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data imports where phone = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataImportModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param phone the phone
	 * @param start the lower bound of the range of data imports
	 * @param end the upper bound of the range of data imports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data imports
	 */
	@Override
	public List<DataImport> findByPhone(
		String phone, int start, int end,
		OrderByComparator<DataImport> orderByComparator) {

		return findByPhone(phone, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data imports where phone = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataImportModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param phone the phone
	 * @param start the lower bound of the range of data imports
	 * @param end the upper bound of the range of data imports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching data imports
	 */
	@Override
	public List<DataImport> findByPhone(
		String phone, int start, int end,
		OrderByComparator<DataImport> orderByComparator,
		boolean retrieveFromCache) {

		phone = Objects.toString(phone, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByPhone;
			finderArgs = new Object[] {phone};
		}
		else {
			finderPath = _finderPathWithPaginationFindByPhone;
			finderArgs = new Object[] {phone, start, end, orderByComparator};
		}

		List<DataImport> list = null;

		if (retrieveFromCache) {
			list = (List<DataImport>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DataImport dataImport : list) {
					if (!phone.equals(dataImport.getPhone())) {
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

			query.append(_SQL_SELECT_DATAIMPORT_WHERE);

			boolean bindPhone = false;

			if (phone.isEmpty()) {
				query.append(_FINDER_COLUMN_PHONE_PHONE_3);
			}
			else {
				bindPhone = true;

				query.append(_FINDER_COLUMN_PHONE_PHONE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(DataImportModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPhone) {
					qPos.add(phone);
				}

				if (!pagination) {
					list = (List<DataImport>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DataImport>)QueryUtil.list(
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
	 * Returns the first data import in the ordered set where phone = &#63;.
	 *
	 * @param phone the phone
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data import
	 * @throws NoSuchDataImportException if a matching data import could not be found
	 */
	@Override
	public DataImport findByPhone_First(
			String phone, OrderByComparator<DataImport> orderByComparator)
		throws NoSuchDataImportException {

		DataImport dataImport = fetchByPhone_First(phone, orderByComparator);

		if (dataImport != null) {
			return dataImport;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("phone=");
		msg.append(phone);

		msg.append("}");

		throw new NoSuchDataImportException(msg.toString());
	}

	/**
	 * Returns the first data import in the ordered set where phone = &#63;.
	 *
	 * @param phone the phone
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data import, or <code>null</code> if a matching data import could not be found
	 */
	@Override
	public DataImport fetchByPhone_First(
		String phone, OrderByComparator<DataImport> orderByComparator) {

		List<DataImport> list = findByPhone(phone, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data import in the ordered set where phone = &#63;.
	 *
	 * @param phone the phone
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data import
	 * @throws NoSuchDataImportException if a matching data import could not be found
	 */
	@Override
	public DataImport findByPhone_Last(
			String phone, OrderByComparator<DataImport> orderByComparator)
		throws NoSuchDataImportException {

		DataImport dataImport = fetchByPhone_Last(phone, orderByComparator);

		if (dataImport != null) {
			return dataImport;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("phone=");
		msg.append(phone);

		msg.append("}");

		throw new NoSuchDataImportException(msg.toString());
	}

	/**
	 * Returns the last data import in the ordered set where phone = &#63;.
	 *
	 * @param phone the phone
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data import, or <code>null</code> if a matching data import could not be found
	 */
	@Override
	public DataImport fetchByPhone_Last(
		String phone, OrderByComparator<DataImport> orderByComparator) {

		int count = countByPhone(phone);

		if (count == 0) {
			return null;
		}

		List<DataImport> list = findByPhone(
			phone, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the data imports before and after the current data import in the ordered set where phone = &#63;.
	 *
	 * @param id the primary key of the current data import
	 * @param phone the phone
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data import
	 * @throws NoSuchDataImportException if a data import with the primary key could not be found
	 */
	@Override
	public DataImport[] findByPhone_PrevAndNext(
			long id, String phone,
			OrderByComparator<DataImport> orderByComparator)
		throws NoSuchDataImportException {

		phone = Objects.toString(phone, "");

		DataImport dataImport = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			DataImport[] array = new DataImportImpl[3];

			array[0] = getByPhone_PrevAndNext(
				session, dataImport, phone, orderByComparator, true);

			array[1] = dataImport;

			array[2] = getByPhone_PrevAndNext(
				session, dataImport, phone, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DataImport getByPhone_PrevAndNext(
		Session session, DataImport dataImport, String phone,
		OrderByComparator<DataImport> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DATAIMPORT_WHERE);

		boolean bindPhone = false;

		if (phone.isEmpty()) {
			query.append(_FINDER_COLUMN_PHONE_PHONE_3);
		}
		else {
			bindPhone = true;

			query.append(_FINDER_COLUMN_PHONE_PHONE_2);
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
			query.append(DataImportModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindPhone) {
			qPos.add(phone);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(dataImport)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<DataImport> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the data imports where phone = &#63; from the database.
	 *
	 * @param phone the phone
	 */
	@Override
	public void removeByPhone(String phone) {
		for (DataImport dataImport :
				findByPhone(
					phone, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dataImport);
		}
	}

	/**
	 * Returns the number of data imports where phone = &#63;.
	 *
	 * @param phone the phone
	 * @return the number of matching data imports
	 */
	@Override
	public int countByPhone(String phone) {
		phone = Objects.toString(phone, "");

		FinderPath finderPath = _finderPathCountByPhone;

		Object[] finderArgs = new Object[] {phone};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DATAIMPORT_WHERE);

			boolean bindPhone = false;

			if (phone.isEmpty()) {
				query.append(_FINDER_COLUMN_PHONE_PHONE_3);
			}
			else {
				bindPhone = true;

				query.append(_FINDER_COLUMN_PHONE_PHONE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPhone) {
					qPos.add(phone);
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

	private static final String _FINDER_COLUMN_PHONE_PHONE_2 =
		"dataImport.phone = ?";

	private static final String _FINDER_COLUMN_PHONE_PHONE_3 =
		"(dataImport.phone IS NULL OR dataImport.phone = '')";

	public DataImportPersistenceImpl() {
		setModelClass(DataImport.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("screenName", "screen_name");
		dbColumnNames.put("firstName", "first_name");
		dbColumnNames.put("lastName", "last_name");
		dbColumnNames.put("emailAddress", "email_address");
		dbColumnNames.put("jobTitle", "job_title");
		dbColumnNames.put("nameRole", "role_name");
		dbColumnNames.put("numberId", "number_id");
		dbColumnNames.put("hasImport", "has_import");
		dbColumnNames.put("errorMsg", "error_message");
		dbColumnNames.put("insertDate", "insert_date");

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
	 * Caches the data import in the entity cache if it is enabled.
	 *
	 * @param dataImport the data import
	 */
	@Override
	public void cacheResult(DataImport dataImport) {
		entityCache.putResult(
			DataImportModelImpl.ENTITY_CACHE_ENABLED, DataImportImpl.class,
			dataImport.getPrimaryKey(), dataImport);

		dataImport.resetOriginalValues();
	}

	/**
	 * Caches the data imports in the entity cache if it is enabled.
	 *
	 * @param dataImports the data imports
	 */
	@Override
	public void cacheResult(List<DataImport> dataImports) {
		for (DataImport dataImport : dataImports) {
			if (entityCache.getResult(
					DataImportModelImpl.ENTITY_CACHE_ENABLED,
					DataImportImpl.class, dataImport.getPrimaryKey()) == null) {

				cacheResult(dataImport);
			}
			else {
				dataImport.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all data imports.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DataImportImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the data import.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DataImport dataImport) {
		entityCache.removeResult(
			DataImportModelImpl.ENTITY_CACHE_ENABLED, DataImportImpl.class,
			dataImport.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<DataImport> dataImports) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DataImport dataImport : dataImports) {
			entityCache.removeResult(
				DataImportModelImpl.ENTITY_CACHE_ENABLED, DataImportImpl.class,
				dataImport.getPrimaryKey());
		}
	}

	/**
	 * Creates a new data import with the primary key. Does not add the data import to the database.
	 *
	 * @param id the primary key for the new data import
	 * @return the new data import
	 */
	@Override
	public DataImport create(long id) {
		DataImport dataImport = new DataImportImpl();

		dataImport.setNew(true);
		dataImport.setPrimaryKey(id);

		return dataImport;
	}

	/**
	 * Removes the data import with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the data import
	 * @return the data import that was removed
	 * @throws NoSuchDataImportException if a data import with the primary key could not be found
	 */
	@Override
	public DataImport remove(long id) throws NoSuchDataImportException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the data import with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the data import
	 * @return the data import that was removed
	 * @throws NoSuchDataImportException if a data import with the primary key could not be found
	 */
	@Override
	public DataImport remove(Serializable primaryKey)
		throws NoSuchDataImportException {

		Session session = null;

		try {
			session = openSession();

			DataImport dataImport = (DataImport)session.get(
				DataImportImpl.class, primaryKey);

			if (dataImport == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDataImportException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dataImport);
		}
		catch (NoSuchDataImportException nsee) {
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
	protected DataImport removeImpl(DataImport dataImport) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dataImport)) {
				dataImport = (DataImport)session.get(
					DataImportImpl.class, dataImport.getPrimaryKeyObj());
			}

			if (dataImport != null) {
				session.delete(dataImport);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (dataImport != null) {
			clearCache(dataImport);
		}

		return dataImport;
	}

	@Override
	public DataImport updateImpl(DataImport dataImport) {
		boolean isNew = dataImport.isNew();

		if (!(dataImport instanceof DataImportModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(dataImport.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(dataImport);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in dataImport proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DataImport implementation " +
					dataImport.getClass());
		}

		DataImportModelImpl dataImportModelImpl =
			(DataImportModelImpl)dataImport;

		Session session = null;

		try {
			session = openSession();

			if (dataImport.isNew()) {
				session.save(dataImport);

				dataImport.setNew(false);
			}
			else {
				dataImport = (DataImport)session.merge(dataImport);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!DataImportModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {dataImportModelImpl.getHasImport()};

			finderCache.removeResult(_finderPathCountByI, args);
			finderCache.removeResult(_finderPathWithoutPaginationFindByI, args);

			args = new Object[] {dataImportModelImpl.getScreenName()};

			finderCache.removeResult(_finderPathCountByScreenName, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByScreenName, args);

			args = new Object[] {dataImportModelImpl.getLastName()};

			finderCache.removeResult(_finderPathCountByLastName, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByLastName, args);

			args = new Object[] {dataImportModelImpl.getEmailAddress()};

			finderCache.removeResult(_finderPathCountByEmailAddress, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByEmailAddress, args);

			args = new Object[] {dataImportModelImpl.getPhone()};

			finderCache.removeResult(_finderPathCountByPhone, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByPhone, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((dataImportModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByI.getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					dataImportModelImpl.getOriginalHasImport()
				};

				finderCache.removeResult(_finderPathCountByI, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByI, args);

				args = new Object[] {dataImportModelImpl.getHasImport()};

				finderCache.removeResult(_finderPathCountByI, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByI, args);
			}

			if ((dataImportModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByScreenName.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					dataImportModelImpl.getOriginalScreenName()
				};

				finderCache.removeResult(_finderPathCountByScreenName, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByScreenName, args);

				args = new Object[] {dataImportModelImpl.getScreenName()};

				finderCache.removeResult(_finderPathCountByScreenName, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByScreenName, args);
			}

			if ((dataImportModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByLastName.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					dataImportModelImpl.getOriginalLastName()
				};

				finderCache.removeResult(_finderPathCountByLastName, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByLastName, args);

				args = new Object[] {dataImportModelImpl.getLastName()};

				finderCache.removeResult(_finderPathCountByLastName, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByLastName, args);
			}

			if ((dataImportModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByEmailAddress.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					dataImportModelImpl.getOriginalEmailAddress()
				};

				finderCache.removeResult(_finderPathCountByEmailAddress, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByEmailAddress, args);

				args = new Object[] {dataImportModelImpl.getEmailAddress()};

				finderCache.removeResult(_finderPathCountByEmailAddress, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByEmailAddress, args);
			}

			if ((dataImportModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByPhone.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					dataImportModelImpl.getOriginalPhone()
				};

				finderCache.removeResult(_finderPathCountByPhone, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByPhone, args);

				args = new Object[] {dataImportModelImpl.getPhone()};

				finderCache.removeResult(_finderPathCountByPhone, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByPhone, args);
			}
		}

		entityCache.putResult(
			DataImportModelImpl.ENTITY_CACHE_ENABLED, DataImportImpl.class,
			dataImport.getPrimaryKey(), dataImport, false);

		dataImport.resetOriginalValues();

		return dataImport;
	}

	/**
	 * Returns the data import with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the data import
	 * @return the data import
	 * @throws NoSuchDataImportException if a data import with the primary key could not be found
	 */
	@Override
	public DataImport findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDataImportException {

		DataImport dataImport = fetchByPrimaryKey(primaryKey);

		if (dataImport == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDataImportException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dataImport;
	}

	/**
	 * Returns the data import with the primary key or throws a <code>NoSuchDataImportException</code> if it could not be found.
	 *
	 * @param id the primary key of the data import
	 * @return the data import
	 * @throws NoSuchDataImportException if a data import with the primary key could not be found
	 */
	@Override
	public DataImport findByPrimaryKey(long id)
		throws NoSuchDataImportException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the data import with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the data import
	 * @return the data import, or <code>null</code> if a data import with the primary key could not be found
	 */
	@Override
	public DataImport fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			DataImportModelImpl.ENTITY_CACHE_ENABLED, DataImportImpl.class,
			primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		DataImport dataImport = (DataImport)serializable;

		if (dataImport == null) {
			Session session = null;

			try {
				session = openSession();

				dataImport = (DataImport)session.get(
					DataImportImpl.class, primaryKey);

				if (dataImport != null) {
					cacheResult(dataImport);
				}
				else {
					entityCache.putResult(
						DataImportModelImpl.ENTITY_CACHE_ENABLED,
						DataImportImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					DataImportModelImpl.ENTITY_CACHE_ENABLED,
					DataImportImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return dataImport;
	}

	/**
	 * Returns the data import with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the data import
	 * @return the data import, or <code>null</code> if a data import with the primary key could not be found
	 */
	@Override
	public DataImport fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, DataImport> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, DataImport> map =
			new HashMap<Serializable, DataImport>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			DataImport dataImport = fetchByPrimaryKey(primaryKey);

			if (dataImport != null) {
				map.put(primaryKey, dataImport);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				DataImportModelImpl.ENTITY_CACHE_ENABLED, DataImportImpl.class,
				primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (DataImport)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_DATAIMPORT_WHERE_PKS_IN);

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

			for (DataImport dataImport : (List<DataImport>)q.list()) {
				map.put(dataImport.getPrimaryKeyObj(), dataImport);

				cacheResult(dataImport);

				uncachedPrimaryKeys.remove(dataImport.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					DataImportModelImpl.ENTITY_CACHE_ENABLED,
					DataImportImpl.class, primaryKey, nullModel);
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
	 * Returns all the data imports.
	 *
	 * @return the data imports
	 */
	@Override
	public List<DataImport> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data imports.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataImportModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of data imports
	 * @param end the upper bound of the range of data imports (not inclusive)
	 * @return the range of data imports
	 */
	@Override
	public List<DataImport> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the data imports.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataImportModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of data imports
	 * @param end the upper bound of the range of data imports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of data imports
	 */
	@Override
	public List<DataImport> findAll(
		int start, int end, OrderByComparator<DataImport> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data imports.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataImportModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of data imports
	 * @param end the upper bound of the range of data imports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of data imports
	 */
	@Override
	public List<DataImport> findAll(
		int start, int end, OrderByComparator<DataImport> orderByComparator,
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

		List<DataImport> list = null;

		if (retrieveFromCache) {
			list = (List<DataImport>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_DATAIMPORT);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DATAIMPORT;

				if (pagination) {
					sql = sql.concat(DataImportModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DataImport>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DataImport>)QueryUtil.list(
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
	 * Removes all the data imports from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DataImport dataImport : findAll()) {
			remove(dataImport);
		}
	}

	/**
	 * Returns the number of data imports.
	 *
	 * @return the number of data imports
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DATAIMPORT);

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
		return DataImportModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the data import persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			DataImportModelImpl.ENTITY_CACHE_ENABLED,
			DataImportModelImpl.FINDER_CACHE_ENABLED, DataImportImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			DataImportModelImpl.ENTITY_CACHE_ENABLED,
			DataImportModelImpl.FINDER_CACHE_ENABLED, DataImportImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			DataImportModelImpl.ENTITY_CACHE_ENABLED,
			DataImportModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByI = new FinderPath(
			DataImportModelImpl.ENTITY_CACHE_ENABLED,
			DataImportModelImpl.FINDER_CACHE_ENABLED, DataImportImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByI",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByI = new FinderPath(
			DataImportModelImpl.ENTITY_CACHE_ENABLED,
			DataImportModelImpl.FINDER_CACHE_ENABLED, DataImportImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByI",
			new String[] {String.class.getName()},
			DataImportModelImpl.HASIMPORT_COLUMN_BITMASK);

		_finderPathCountByI = new FinderPath(
			DataImportModelImpl.ENTITY_CACHE_ENABLED,
			DataImportModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByI",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByScreenName = new FinderPath(
			DataImportModelImpl.ENTITY_CACHE_ENABLED,
			DataImportModelImpl.FINDER_CACHE_ENABLED, DataImportImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByScreenName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByScreenName = new FinderPath(
			DataImportModelImpl.ENTITY_CACHE_ENABLED,
			DataImportModelImpl.FINDER_CACHE_ENABLED, DataImportImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByScreenName",
			new String[] {String.class.getName()},
			DataImportModelImpl.SCREENNAME_COLUMN_BITMASK);

		_finderPathCountByScreenName = new FinderPath(
			DataImportModelImpl.ENTITY_CACHE_ENABLED,
			DataImportModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByScreenName",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByLastName = new FinderPath(
			DataImportModelImpl.ENTITY_CACHE_ENABLED,
			DataImportModelImpl.FINDER_CACHE_ENABLED, DataImportImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLastName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByLastName = new FinderPath(
			DataImportModelImpl.ENTITY_CACHE_ENABLED,
			DataImportModelImpl.FINDER_CACHE_ENABLED, DataImportImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLastName",
			new String[] {String.class.getName()},
			DataImportModelImpl.LASTNAME_COLUMN_BITMASK);

		_finderPathCountByLastName = new FinderPath(
			DataImportModelImpl.ENTITY_CACHE_ENABLED,
			DataImportModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLastName",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByEmailAddress = new FinderPath(
			DataImportModelImpl.ENTITY_CACHE_ENABLED,
			DataImportModelImpl.FINDER_CACHE_ENABLED, DataImportImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEmailAddress",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByEmailAddress = new FinderPath(
			DataImportModelImpl.ENTITY_CACHE_ENABLED,
			DataImportModelImpl.FINDER_CACHE_ENABLED, DataImportImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEmailAddress",
			new String[] {String.class.getName()},
			DataImportModelImpl.EMAILADDRESS_COLUMN_BITMASK);

		_finderPathCountByEmailAddress = new FinderPath(
			DataImportModelImpl.ENTITY_CACHE_ENABLED,
			DataImportModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmailAddress",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByPhone = new FinderPath(
			DataImportModelImpl.ENTITY_CACHE_ENABLED,
			DataImportModelImpl.FINDER_CACHE_ENABLED, DataImportImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPhone",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByPhone = new FinderPath(
			DataImportModelImpl.ENTITY_CACHE_ENABLED,
			DataImportModelImpl.FINDER_CACHE_ENABLED, DataImportImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPhone",
			new String[] {String.class.getName()},
			DataImportModelImpl.PHONE_COLUMN_BITMASK);

		_finderPathCountByPhone = new FinderPath(
			DataImportModelImpl.ENTITY_CACHE_ENABLED,
			DataImportModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPhone",
			new String[] {String.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(DataImportImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_DATAIMPORT =
		"SELECT dataImport FROM DataImport dataImport";

	private static final String _SQL_SELECT_DATAIMPORT_WHERE_PKS_IN =
		"SELECT dataImport FROM DataImport dataImport WHERE id IN (";

	private static final String _SQL_SELECT_DATAIMPORT_WHERE =
		"SELECT dataImport FROM DataImport dataImport WHERE ";

	private static final String _SQL_COUNT_DATAIMPORT =
		"SELECT COUNT(dataImport) FROM DataImport dataImport";

	private static final String _SQL_COUNT_DATAIMPORT_WHERE =
		"SELECT COUNT(dataImport) FROM DataImport dataImport WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "dataImport.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DataImport exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DataImport exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DataImportPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"screenName", "firstName", "lastName", "emailAddress", "jobTitle",
			"nameRole", "numberId", "hasImport", "errorMsg", "insertDate"
		});

}