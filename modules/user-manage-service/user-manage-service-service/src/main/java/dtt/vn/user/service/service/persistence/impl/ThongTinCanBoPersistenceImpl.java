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

import dtt.vn.user.service.exception.NoSuchThongTinCanBoException;
import dtt.vn.user.service.model.ThongTinCanBo;
import dtt.vn.user.service.model.impl.ThongTinCanBoImpl;
import dtt.vn.user.service.model.impl.ThongTinCanBoModelImpl;
import dtt.vn.user.service.service.persistence.ThongTinCanBoPersistence;

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
 * The persistence implementation for the thong tin can bo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nhanvienDTT
 * @generated
 */
@ProviderType
public class ThongTinCanBoPersistenceImpl
	extends BasePersistenceImpl<ThongTinCanBo>
	implements ThongTinCanBoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ThongTinCanBoUtil</code> to access the thong tin can bo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ThongTinCanBoImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByemailAddress;
	private FinderPath _finderPathCountByemailAddress;

	/**
	 * Returns the thong tin can bo where emailAddress = &#63; or throws a <code>NoSuchThongTinCanBoException</code> if it could not be found.
	 *
	 * @param emailAddress the email address
	 * @return the matching thong tin can bo
	 * @throws NoSuchThongTinCanBoException if a matching thong tin can bo could not be found
	 */
	@Override
	public ThongTinCanBo findByemailAddress(String emailAddress)
		throws NoSuchThongTinCanBoException {

		ThongTinCanBo thongTinCanBo = fetchByemailAddress(emailAddress);

		if (thongTinCanBo == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("emailAddress=");
			msg.append(emailAddress);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchThongTinCanBoException(msg.toString());
		}

		return thongTinCanBo;
	}

	/**
	 * Returns the thong tin can bo where emailAddress = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param emailAddress the email address
	 * @return the matching thong tin can bo, or <code>null</code> if a matching thong tin can bo could not be found
	 */
	@Override
	public ThongTinCanBo fetchByemailAddress(String emailAddress) {
		return fetchByemailAddress(emailAddress, true);
	}

	/**
	 * Returns the thong tin can bo where emailAddress = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param emailAddress the email address
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching thong tin can bo, or <code>null</code> if a matching thong tin can bo could not be found
	 */
	@Override
	public ThongTinCanBo fetchByemailAddress(
		String emailAddress, boolean retrieveFromCache) {

		emailAddress = Objects.toString(emailAddress, "");

		Object[] finderArgs = new Object[] {emailAddress};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByemailAddress, finderArgs, this);
		}

		if (result instanceof ThongTinCanBo) {
			ThongTinCanBo thongTinCanBo = (ThongTinCanBo)result;

			if (!Objects.equals(
					emailAddress, thongTinCanBo.getEmailAddress())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_THONGTINCANBO_WHERE);

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

				List<ThongTinCanBo> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByemailAddress, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"ThongTinCanBoPersistenceImpl.fetchByemailAddress(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ThongTinCanBo thongTinCanBo = list.get(0);

					result = thongTinCanBo;

					cacheResult(thongTinCanBo);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathFetchByemailAddress, finderArgs);

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
			return (ThongTinCanBo)result;
		}
	}

	/**
	 * Removes the thong tin can bo where emailAddress = &#63; from the database.
	 *
	 * @param emailAddress the email address
	 * @return the thong tin can bo that was removed
	 */
	@Override
	public ThongTinCanBo removeByemailAddress(String emailAddress)
		throws NoSuchThongTinCanBoException {

		ThongTinCanBo thongTinCanBo = findByemailAddress(emailAddress);

		return remove(thongTinCanBo);
	}

	/**
	 * Returns the number of thong tin can bos where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @return the number of matching thong tin can bos
	 */
	@Override
	public int countByemailAddress(String emailAddress) {
		emailAddress = Objects.toString(emailAddress, "");

		FinderPath finderPath = _finderPathCountByemailAddress;

		Object[] finderArgs = new Object[] {emailAddress};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_THONGTINCANBO_WHERE);

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
		"thongTinCanBo.emailAddress = ?";

	private static final String _FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_3 =
		"(thongTinCanBo.emailAddress IS NULL OR thongTinCanBo.emailAddress = '')";

	private FinderPath _finderPathFetchByuserName;
	private FinderPath _finderPathCountByuserName;

	/**
	 * Returns the thong tin can bo where userName = &#63; or throws a <code>NoSuchThongTinCanBoException</code> if it could not be found.
	 *
	 * @param userName the user name
	 * @return the matching thong tin can bo
	 * @throws NoSuchThongTinCanBoException if a matching thong tin can bo could not be found
	 */
	@Override
	public ThongTinCanBo findByuserName(String userName)
		throws NoSuchThongTinCanBoException {

		ThongTinCanBo thongTinCanBo = fetchByuserName(userName);

		if (thongTinCanBo == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userName=");
			msg.append(userName);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchThongTinCanBoException(msg.toString());
		}

		return thongTinCanBo;
	}

	/**
	 * Returns the thong tin can bo where userName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userName the user name
	 * @return the matching thong tin can bo, or <code>null</code> if a matching thong tin can bo could not be found
	 */
	@Override
	public ThongTinCanBo fetchByuserName(String userName) {
		return fetchByuserName(userName, true);
	}

	/**
	 * Returns the thong tin can bo where userName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userName the user name
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching thong tin can bo, or <code>null</code> if a matching thong tin can bo could not be found
	 */
	@Override
	public ThongTinCanBo fetchByuserName(
		String userName, boolean retrieveFromCache) {

		userName = Objects.toString(userName, "");

		Object[] finderArgs = new Object[] {userName};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByuserName, finderArgs, this);
		}

		if (result instanceof ThongTinCanBo) {
			ThongTinCanBo thongTinCanBo = (ThongTinCanBo)result;

			if (!Objects.equals(userName, thongTinCanBo.getUserName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_THONGTINCANBO_WHERE);

			boolean bindUserName = false;

			if (userName.isEmpty()) {
				query.append(_FINDER_COLUMN_USERNAME_USERNAME_3);
			}
			else {
				bindUserName = true;

				query.append(_FINDER_COLUMN_USERNAME_USERNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUserName) {
					qPos.add(userName);
				}

				List<ThongTinCanBo> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByuserName, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"ThongTinCanBoPersistenceImpl.fetchByuserName(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ThongTinCanBo thongTinCanBo = list.get(0);

					result = thongTinCanBo;

					cacheResult(thongTinCanBo);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathFetchByuserName, finderArgs);

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
			return (ThongTinCanBo)result;
		}
	}

	/**
	 * Removes the thong tin can bo where userName = &#63; from the database.
	 *
	 * @param userName the user name
	 * @return the thong tin can bo that was removed
	 */
	@Override
	public ThongTinCanBo removeByuserName(String userName)
		throws NoSuchThongTinCanBoException {

		ThongTinCanBo thongTinCanBo = findByuserName(userName);

		return remove(thongTinCanBo);
	}

	/**
	 * Returns the number of thong tin can bos where userName = &#63;.
	 *
	 * @param userName the user name
	 * @return the number of matching thong tin can bos
	 */
	@Override
	public int countByuserName(String userName) {
		userName = Objects.toString(userName, "");

		FinderPath finderPath = _finderPathCountByuserName;

		Object[] finderArgs = new Object[] {userName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_THONGTINCANBO_WHERE);

			boolean bindUserName = false;

			if (userName.isEmpty()) {
				query.append(_FINDER_COLUMN_USERNAME_USERNAME_3);
			}
			else {
				bindUserName = true;

				query.append(_FINDER_COLUMN_USERNAME_USERNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUserName) {
					qPos.add(userName);
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

	private static final String _FINDER_COLUMN_USERNAME_USERNAME_2 =
		"thongTinCanBo.userName = ?";

	private static final String _FINDER_COLUMN_USERNAME_USERNAME_3 =
		"(thongTinCanBo.userName IS NULL OR thongTinCanBo.userName = '')";

	private FinderPath _finderPathWithPaginationFindBynameRole;
	private FinderPath _finderPathWithoutPaginationFindBynameRole;
	private FinderPath _finderPathCountBynameRole;

	/**
	 * Returns all the thong tin can bos where nameRole = &#63;.
	 *
	 * @param nameRole the name role
	 * @return the matching thong tin can bos
	 */
	@Override
	public List<ThongTinCanBo> findBynameRole(String nameRole) {
		return findBynameRole(
			nameRole, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the thong tin can bos where nameRole = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ThongTinCanBoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nameRole the name role
	 * @param start the lower bound of the range of thong tin can bos
	 * @param end the upper bound of the range of thong tin can bos (not inclusive)
	 * @return the range of matching thong tin can bos
	 */
	@Override
	public List<ThongTinCanBo> findBynameRole(
		String nameRole, int start, int end) {

		return findBynameRole(nameRole, start, end, null);
	}

	/**
	 * Returns an ordered range of all the thong tin can bos where nameRole = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ThongTinCanBoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nameRole the name role
	 * @param start the lower bound of the range of thong tin can bos
	 * @param end the upper bound of the range of thong tin can bos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching thong tin can bos
	 */
	@Override
	public List<ThongTinCanBo> findBynameRole(
		String nameRole, int start, int end,
		OrderByComparator<ThongTinCanBo> orderByComparator) {

		return findBynameRole(nameRole, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the thong tin can bos where nameRole = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ThongTinCanBoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nameRole the name role
	 * @param start the lower bound of the range of thong tin can bos
	 * @param end the upper bound of the range of thong tin can bos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching thong tin can bos
	 */
	@Override
	public List<ThongTinCanBo> findBynameRole(
		String nameRole, int start, int end,
		OrderByComparator<ThongTinCanBo> orderByComparator,
		boolean retrieveFromCache) {

		nameRole = Objects.toString(nameRole, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindBynameRole;
			finderArgs = new Object[] {nameRole};
		}
		else {
			finderPath = _finderPathWithPaginationFindBynameRole;
			finderArgs = new Object[] {nameRole, start, end, orderByComparator};
		}

		List<ThongTinCanBo> list = null;

		if (retrieveFromCache) {
			list = (List<ThongTinCanBo>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ThongTinCanBo thongTinCanBo : list) {
					if (!nameRole.equals(thongTinCanBo.getNameRole())) {
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

			query.append(_SQL_SELECT_THONGTINCANBO_WHERE);

			boolean bindNameRole = false;

			if (nameRole.isEmpty()) {
				query.append(_FINDER_COLUMN_NAMEROLE_NAMEROLE_3);
			}
			else {
				bindNameRole = true;

				query.append(_FINDER_COLUMN_NAMEROLE_NAMEROLE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(ThongTinCanBoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindNameRole) {
					qPos.add(nameRole);
				}

				if (!pagination) {
					list = (List<ThongTinCanBo>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ThongTinCanBo>)QueryUtil.list(
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
	 * Returns the first thong tin can bo in the ordered set where nameRole = &#63;.
	 *
	 * @param nameRole the name role
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching thong tin can bo
	 * @throws NoSuchThongTinCanBoException if a matching thong tin can bo could not be found
	 */
	@Override
	public ThongTinCanBo findBynameRole_First(
			String nameRole, OrderByComparator<ThongTinCanBo> orderByComparator)
		throws NoSuchThongTinCanBoException {

		ThongTinCanBo thongTinCanBo = fetchBynameRole_First(
			nameRole, orderByComparator);

		if (thongTinCanBo != null) {
			return thongTinCanBo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nameRole=");
		msg.append(nameRole);

		msg.append("}");

		throw new NoSuchThongTinCanBoException(msg.toString());
	}

	/**
	 * Returns the first thong tin can bo in the ordered set where nameRole = &#63;.
	 *
	 * @param nameRole the name role
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching thong tin can bo, or <code>null</code> if a matching thong tin can bo could not be found
	 */
	@Override
	public ThongTinCanBo fetchBynameRole_First(
		String nameRole, OrderByComparator<ThongTinCanBo> orderByComparator) {

		List<ThongTinCanBo> list = findBynameRole(
			nameRole, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last thong tin can bo in the ordered set where nameRole = &#63;.
	 *
	 * @param nameRole the name role
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching thong tin can bo
	 * @throws NoSuchThongTinCanBoException if a matching thong tin can bo could not be found
	 */
	@Override
	public ThongTinCanBo findBynameRole_Last(
			String nameRole, OrderByComparator<ThongTinCanBo> orderByComparator)
		throws NoSuchThongTinCanBoException {

		ThongTinCanBo thongTinCanBo = fetchBynameRole_Last(
			nameRole, orderByComparator);

		if (thongTinCanBo != null) {
			return thongTinCanBo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nameRole=");
		msg.append(nameRole);

		msg.append("}");

		throw new NoSuchThongTinCanBoException(msg.toString());
	}

	/**
	 * Returns the last thong tin can bo in the ordered set where nameRole = &#63;.
	 *
	 * @param nameRole the name role
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching thong tin can bo, or <code>null</code> if a matching thong tin can bo could not be found
	 */
	@Override
	public ThongTinCanBo fetchBynameRole_Last(
		String nameRole, OrderByComparator<ThongTinCanBo> orderByComparator) {

		int count = countBynameRole(nameRole);

		if (count == 0) {
			return null;
		}

		List<ThongTinCanBo> list = findBynameRole(
			nameRole, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the thong tin can bos before and after the current thong tin can bo in the ordered set where nameRole = &#63;.
	 *
	 * @param id the primary key of the current thong tin can bo
	 * @param nameRole the name role
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next thong tin can bo
	 * @throws NoSuchThongTinCanBoException if a thong tin can bo with the primary key could not be found
	 */
	@Override
	public ThongTinCanBo[] findBynameRole_PrevAndNext(
			long id, String nameRole,
			OrderByComparator<ThongTinCanBo> orderByComparator)
		throws NoSuchThongTinCanBoException {

		nameRole = Objects.toString(nameRole, "");

		ThongTinCanBo thongTinCanBo = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ThongTinCanBo[] array = new ThongTinCanBoImpl[3];

			array[0] = getBynameRole_PrevAndNext(
				session, thongTinCanBo, nameRole, orderByComparator, true);

			array[1] = thongTinCanBo;

			array[2] = getBynameRole_PrevAndNext(
				session, thongTinCanBo, nameRole, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ThongTinCanBo getBynameRole_PrevAndNext(
		Session session, ThongTinCanBo thongTinCanBo, String nameRole,
		OrderByComparator<ThongTinCanBo> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_THONGTINCANBO_WHERE);

		boolean bindNameRole = false;

		if (nameRole.isEmpty()) {
			query.append(_FINDER_COLUMN_NAMEROLE_NAMEROLE_3);
		}
		else {
			bindNameRole = true;

			query.append(_FINDER_COLUMN_NAMEROLE_NAMEROLE_2);
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
			query.append(ThongTinCanBoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindNameRole) {
			qPos.add(nameRole);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						thongTinCanBo)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<ThongTinCanBo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the thong tin can bos where nameRole = &#63; from the database.
	 *
	 * @param nameRole the name role
	 */
	@Override
	public void removeBynameRole(String nameRole) {
		for (ThongTinCanBo thongTinCanBo :
				findBynameRole(
					nameRole, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(thongTinCanBo);
		}
	}

	/**
	 * Returns the number of thong tin can bos where nameRole = &#63;.
	 *
	 * @param nameRole the name role
	 * @return the number of matching thong tin can bos
	 */
	@Override
	public int countBynameRole(String nameRole) {
		nameRole = Objects.toString(nameRole, "");

		FinderPath finderPath = _finderPathCountBynameRole;

		Object[] finderArgs = new Object[] {nameRole};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_THONGTINCANBO_WHERE);

			boolean bindNameRole = false;

			if (nameRole.isEmpty()) {
				query.append(_FINDER_COLUMN_NAMEROLE_NAMEROLE_3);
			}
			else {
				bindNameRole = true;

				query.append(_FINDER_COLUMN_NAMEROLE_NAMEROLE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindNameRole) {
					qPos.add(nameRole);
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

	private static final String _FINDER_COLUMN_NAMEROLE_NAMEROLE_2 =
		"thongTinCanBo.nameRole = ?";

	private static final String _FINDER_COLUMN_NAMEROLE_NAMEROLE_3 =
		"(thongTinCanBo.nameRole IS NULL OR thongTinCanBo.nameRole = '')";

	public ThongTinCanBoPersistenceImpl() {
		setModelClass(ThongTinCanBo.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("emailAddress", "email_address");
		dbColumnNames.put("userName", "username");
		dbColumnNames.put("nameRole", "namerole");
		dbColumnNames.put("noiDung", "noidung");

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
	 * Caches the thong tin can bo in the entity cache if it is enabled.
	 *
	 * @param thongTinCanBo the thong tin can bo
	 */
	@Override
	public void cacheResult(ThongTinCanBo thongTinCanBo) {
		entityCache.putResult(
			ThongTinCanBoModelImpl.ENTITY_CACHE_ENABLED,
			ThongTinCanBoImpl.class, thongTinCanBo.getPrimaryKey(),
			thongTinCanBo);

		finderCache.putResult(
			_finderPathFetchByemailAddress,
			new Object[] {thongTinCanBo.getEmailAddress()}, thongTinCanBo);

		finderCache.putResult(
			_finderPathFetchByuserName,
			new Object[] {thongTinCanBo.getUserName()}, thongTinCanBo);

		thongTinCanBo.resetOriginalValues();
	}

	/**
	 * Caches the thong tin can bos in the entity cache if it is enabled.
	 *
	 * @param thongTinCanBos the thong tin can bos
	 */
	@Override
	public void cacheResult(List<ThongTinCanBo> thongTinCanBos) {
		for (ThongTinCanBo thongTinCanBo : thongTinCanBos) {
			if (entityCache.getResult(
					ThongTinCanBoModelImpl.ENTITY_CACHE_ENABLED,
					ThongTinCanBoImpl.class, thongTinCanBo.getPrimaryKey()) ==
						null) {

				cacheResult(thongTinCanBo);
			}
			else {
				thongTinCanBo.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all thong tin can bos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ThongTinCanBoImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the thong tin can bo.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ThongTinCanBo thongTinCanBo) {
		entityCache.removeResult(
			ThongTinCanBoModelImpl.ENTITY_CACHE_ENABLED,
			ThongTinCanBoImpl.class, thongTinCanBo.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((ThongTinCanBoModelImpl)thongTinCanBo, true);
	}

	@Override
	public void clearCache(List<ThongTinCanBo> thongTinCanBos) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ThongTinCanBo thongTinCanBo : thongTinCanBos) {
			entityCache.removeResult(
				ThongTinCanBoModelImpl.ENTITY_CACHE_ENABLED,
				ThongTinCanBoImpl.class, thongTinCanBo.getPrimaryKey());

			clearUniqueFindersCache(
				(ThongTinCanBoModelImpl)thongTinCanBo, true);
		}
	}

	protected void cacheUniqueFindersCache(
		ThongTinCanBoModelImpl thongTinCanBoModelImpl) {

		Object[] args = new Object[] {thongTinCanBoModelImpl.getEmailAddress()};

		finderCache.putResult(
			_finderPathCountByemailAddress, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByemailAddress, args, thongTinCanBoModelImpl,
			false);

		args = new Object[] {thongTinCanBoModelImpl.getUserName()};

		finderCache.putResult(
			_finderPathCountByuserName, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByuserName, args, thongTinCanBoModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		ThongTinCanBoModelImpl thongTinCanBoModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				thongTinCanBoModelImpl.getEmailAddress()
			};

			finderCache.removeResult(_finderPathCountByemailAddress, args);
			finderCache.removeResult(_finderPathFetchByemailAddress, args);
		}

		if ((thongTinCanBoModelImpl.getColumnBitmask() &
			 _finderPathFetchByemailAddress.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				thongTinCanBoModelImpl.getOriginalEmailAddress()
			};

			finderCache.removeResult(_finderPathCountByemailAddress, args);
			finderCache.removeResult(_finderPathFetchByemailAddress, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {thongTinCanBoModelImpl.getUserName()};

			finderCache.removeResult(_finderPathCountByuserName, args);
			finderCache.removeResult(_finderPathFetchByuserName, args);
		}

		if ((thongTinCanBoModelImpl.getColumnBitmask() &
			 _finderPathFetchByuserName.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				thongTinCanBoModelImpl.getOriginalUserName()
			};

			finderCache.removeResult(_finderPathCountByuserName, args);
			finderCache.removeResult(_finderPathFetchByuserName, args);
		}
	}

	/**
	 * Creates a new thong tin can bo with the primary key. Does not add the thong tin can bo to the database.
	 *
	 * @param id the primary key for the new thong tin can bo
	 * @return the new thong tin can bo
	 */
	@Override
	public ThongTinCanBo create(long id) {
		ThongTinCanBo thongTinCanBo = new ThongTinCanBoImpl();

		thongTinCanBo.setNew(true);
		thongTinCanBo.setPrimaryKey(id);

		return thongTinCanBo;
	}

	/**
	 * Removes the thong tin can bo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the thong tin can bo
	 * @return the thong tin can bo that was removed
	 * @throws NoSuchThongTinCanBoException if a thong tin can bo with the primary key could not be found
	 */
	@Override
	public ThongTinCanBo remove(long id) throws NoSuchThongTinCanBoException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the thong tin can bo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the thong tin can bo
	 * @return the thong tin can bo that was removed
	 * @throws NoSuchThongTinCanBoException if a thong tin can bo with the primary key could not be found
	 */
	@Override
	public ThongTinCanBo remove(Serializable primaryKey)
		throws NoSuchThongTinCanBoException {

		Session session = null;

		try {
			session = openSession();

			ThongTinCanBo thongTinCanBo = (ThongTinCanBo)session.get(
				ThongTinCanBoImpl.class, primaryKey);

			if (thongTinCanBo == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchThongTinCanBoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(thongTinCanBo);
		}
		catch (NoSuchThongTinCanBoException nsee) {
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
	protected ThongTinCanBo removeImpl(ThongTinCanBo thongTinCanBo) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(thongTinCanBo)) {
				thongTinCanBo = (ThongTinCanBo)session.get(
					ThongTinCanBoImpl.class, thongTinCanBo.getPrimaryKeyObj());
			}

			if (thongTinCanBo != null) {
				session.delete(thongTinCanBo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (thongTinCanBo != null) {
			clearCache(thongTinCanBo);
		}

		return thongTinCanBo;
	}

	@Override
	public ThongTinCanBo updateImpl(ThongTinCanBo thongTinCanBo) {
		boolean isNew = thongTinCanBo.isNew();

		if (!(thongTinCanBo instanceof ThongTinCanBoModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(thongTinCanBo.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					thongTinCanBo);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in thongTinCanBo proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ThongTinCanBo implementation " +
					thongTinCanBo.getClass());
		}

		ThongTinCanBoModelImpl thongTinCanBoModelImpl =
			(ThongTinCanBoModelImpl)thongTinCanBo;

		Session session = null;

		try {
			session = openSession();

			if (thongTinCanBo.isNew()) {
				session.save(thongTinCanBo);

				thongTinCanBo.setNew(false);
			}
			else {
				thongTinCanBo = (ThongTinCanBo)session.merge(thongTinCanBo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!ThongTinCanBoModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {thongTinCanBoModelImpl.getNameRole()};

			finderCache.removeResult(_finderPathCountBynameRole, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindBynameRole, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((thongTinCanBoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindBynameRole.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					thongTinCanBoModelImpl.getOriginalNameRole()
				};

				finderCache.removeResult(_finderPathCountBynameRole, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBynameRole, args);

				args = new Object[] {thongTinCanBoModelImpl.getNameRole()};

				finderCache.removeResult(_finderPathCountBynameRole, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBynameRole, args);
			}
		}

		entityCache.putResult(
			ThongTinCanBoModelImpl.ENTITY_CACHE_ENABLED,
			ThongTinCanBoImpl.class, thongTinCanBo.getPrimaryKey(),
			thongTinCanBo, false);

		clearUniqueFindersCache(thongTinCanBoModelImpl, false);
		cacheUniqueFindersCache(thongTinCanBoModelImpl);

		thongTinCanBo.resetOriginalValues();

		return thongTinCanBo;
	}

	/**
	 * Returns the thong tin can bo with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the thong tin can bo
	 * @return the thong tin can bo
	 * @throws NoSuchThongTinCanBoException if a thong tin can bo with the primary key could not be found
	 */
	@Override
	public ThongTinCanBo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchThongTinCanBoException {

		ThongTinCanBo thongTinCanBo = fetchByPrimaryKey(primaryKey);

		if (thongTinCanBo == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchThongTinCanBoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return thongTinCanBo;
	}

	/**
	 * Returns the thong tin can bo with the primary key or throws a <code>NoSuchThongTinCanBoException</code> if it could not be found.
	 *
	 * @param id the primary key of the thong tin can bo
	 * @return the thong tin can bo
	 * @throws NoSuchThongTinCanBoException if a thong tin can bo with the primary key could not be found
	 */
	@Override
	public ThongTinCanBo findByPrimaryKey(long id)
		throws NoSuchThongTinCanBoException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the thong tin can bo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the thong tin can bo
	 * @return the thong tin can bo, or <code>null</code> if a thong tin can bo with the primary key could not be found
	 */
	@Override
	public ThongTinCanBo fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			ThongTinCanBoModelImpl.ENTITY_CACHE_ENABLED,
			ThongTinCanBoImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		ThongTinCanBo thongTinCanBo = (ThongTinCanBo)serializable;

		if (thongTinCanBo == null) {
			Session session = null;

			try {
				session = openSession();

				thongTinCanBo = (ThongTinCanBo)session.get(
					ThongTinCanBoImpl.class, primaryKey);

				if (thongTinCanBo != null) {
					cacheResult(thongTinCanBo);
				}
				else {
					entityCache.putResult(
						ThongTinCanBoModelImpl.ENTITY_CACHE_ENABLED,
						ThongTinCanBoImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					ThongTinCanBoModelImpl.ENTITY_CACHE_ENABLED,
					ThongTinCanBoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return thongTinCanBo;
	}

	/**
	 * Returns the thong tin can bo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the thong tin can bo
	 * @return the thong tin can bo, or <code>null</code> if a thong tin can bo with the primary key could not be found
	 */
	@Override
	public ThongTinCanBo fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, ThongTinCanBo> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ThongTinCanBo> map =
			new HashMap<Serializable, ThongTinCanBo>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ThongTinCanBo thongTinCanBo = fetchByPrimaryKey(primaryKey);

			if (thongTinCanBo != null) {
				map.put(primaryKey, thongTinCanBo);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				ThongTinCanBoModelImpl.ENTITY_CACHE_ENABLED,
				ThongTinCanBoImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (ThongTinCanBo)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_THONGTINCANBO_WHERE_PKS_IN);

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

			for (ThongTinCanBo thongTinCanBo : (List<ThongTinCanBo>)q.list()) {
				map.put(thongTinCanBo.getPrimaryKeyObj(), thongTinCanBo);

				cacheResult(thongTinCanBo);

				uncachedPrimaryKeys.remove(thongTinCanBo.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					ThongTinCanBoModelImpl.ENTITY_CACHE_ENABLED,
					ThongTinCanBoImpl.class, primaryKey, nullModel);
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
	 * Returns all the thong tin can bos.
	 *
	 * @return the thong tin can bos
	 */
	@Override
	public List<ThongTinCanBo> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the thong tin can bos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ThongTinCanBoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of thong tin can bos
	 * @param end the upper bound of the range of thong tin can bos (not inclusive)
	 * @return the range of thong tin can bos
	 */
	@Override
	public List<ThongTinCanBo> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the thong tin can bos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ThongTinCanBoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of thong tin can bos
	 * @param end the upper bound of the range of thong tin can bos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of thong tin can bos
	 */
	@Override
	public List<ThongTinCanBo> findAll(
		int start, int end,
		OrderByComparator<ThongTinCanBo> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the thong tin can bos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ThongTinCanBoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of thong tin can bos
	 * @param end the upper bound of the range of thong tin can bos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of thong tin can bos
	 */
	@Override
	public List<ThongTinCanBo> findAll(
		int start, int end, OrderByComparator<ThongTinCanBo> orderByComparator,
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

		List<ThongTinCanBo> list = null;

		if (retrieveFromCache) {
			list = (List<ThongTinCanBo>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_THONGTINCANBO);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_THONGTINCANBO;

				if (pagination) {
					sql = sql.concat(ThongTinCanBoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ThongTinCanBo>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ThongTinCanBo>)QueryUtil.list(
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
	 * Removes all the thong tin can bos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ThongTinCanBo thongTinCanBo : findAll()) {
			remove(thongTinCanBo);
		}
	}

	/**
	 * Returns the number of thong tin can bos.
	 *
	 * @return the number of thong tin can bos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_THONGTINCANBO);

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
		return ThongTinCanBoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the thong tin can bo persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			ThongTinCanBoModelImpl.ENTITY_CACHE_ENABLED,
			ThongTinCanBoModelImpl.FINDER_CACHE_ENABLED,
			ThongTinCanBoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			ThongTinCanBoModelImpl.ENTITY_CACHE_ENABLED,
			ThongTinCanBoModelImpl.FINDER_CACHE_ENABLED,
			ThongTinCanBoImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);

		_finderPathCountAll = new FinderPath(
			ThongTinCanBoModelImpl.ENTITY_CACHE_ENABLED,
			ThongTinCanBoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByemailAddress = new FinderPath(
			ThongTinCanBoModelImpl.ENTITY_CACHE_ENABLED,
			ThongTinCanBoModelImpl.FINDER_CACHE_ENABLED,
			ThongTinCanBoImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByemailAddress", new String[] {String.class.getName()},
			ThongTinCanBoModelImpl.EMAILADDRESS_COLUMN_BITMASK);

		_finderPathCountByemailAddress = new FinderPath(
			ThongTinCanBoModelImpl.ENTITY_CACHE_ENABLED,
			ThongTinCanBoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByemailAddress",
			new String[] {String.class.getName()});

		_finderPathFetchByuserName = new FinderPath(
			ThongTinCanBoModelImpl.ENTITY_CACHE_ENABLED,
			ThongTinCanBoModelImpl.FINDER_CACHE_ENABLED,
			ThongTinCanBoImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByuserName", new String[] {String.class.getName()},
			ThongTinCanBoModelImpl.USERNAME_COLUMN_BITMASK);

		_finderPathCountByuserName = new FinderPath(
			ThongTinCanBoModelImpl.ENTITY_CACHE_ENABLED,
			ThongTinCanBoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByuserName",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindBynameRole = new FinderPath(
			ThongTinCanBoModelImpl.ENTITY_CACHE_ENABLED,
			ThongTinCanBoModelImpl.FINDER_CACHE_ENABLED,
			ThongTinCanBoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBynameRole",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindBynameRole = new FinderPath(
			ThongTinCanBoModelImpl.ENTITY_CACHE_ENABLED,
			ThongTinCanBoModelImpl.FINDER_CACHE_ENABLED,
			ThongTinCanBoImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBynameRole", new String[] {String.class.getName()},
			ThongTinCanBoModelImpl.NAMEROLE_COLUMN_BITMASK);

		_finderPathCountBynameRole = new FinderPath(
			ThongTinCanBoModelImpl.ENTITY_CACHE_ENABLED,
			ThongTinCanBoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBynameRole",
			new String[] {String.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(ThongTinCanBoImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_THONGTINCANBO =
		"SELECT thongTinCanBo FROM ThongTinCanBo thongTinCanBo";

	private static final String _SQL_SELECT_THONGTINCANBO_WHERE_PKS_IN =
		"SELECT thongTinCanBo FROM ThongTinCanBo thongTinCanBo WHERE id IN (";

	private static final String _SQL_SELECT_THONGTINCANBO_WHERE =
		"SELECT thongTinCanBo FROM ThongTinCanBo thongTinCanBo WHERE ";

	private static final String _SQL_COUNT_THONGTINCANBO =
		"SELECT COUNT(thongTinCanBo) FROM ThongTinCanBo thongTinCanBo";

	private static final String _SQL_COUNT_THONGTINCANBO_WHERE =
		"SELECT COUNT(thongTinCanBo) FROM ThongTinCanBo thongTinCanBo WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "thongTinCanBo.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ThongTinCanBo exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ThongTinCanBo exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ThongTinCanBoPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"emailAddress", "userName", "nameRole", "noiDung"});

}