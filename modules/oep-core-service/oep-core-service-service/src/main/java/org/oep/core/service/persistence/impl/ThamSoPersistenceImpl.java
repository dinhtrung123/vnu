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

import org.oep.core.exception.NoSuchThamSoException;
import org.oep.core.model.ThamSo;
import org.oep.core.model.impl.ThamSoImpl;
import org.oep.core.model.impl.ThamSoModelImpl;
import org.oep.core.service.persistence.ThamSoPersistence;

/**
 * The persistence implementation for the tham so service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author manhlb
 * @generated
 */
@ProviderType
public class ThamSoPersistenceImpl
	extends BasePersistenceImpl<ThamSo> implements ThamSoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ThamSoUtil</code> to access the tham so persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ThamSoImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByG_M;
	private FinderPath _finderPathCountByG_M;

	/**
	 * Returns the tham so where groupId = &#63; and ma = &#63; or throws a <code>NoSuchThamSoException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param ma the ma
	 * @return the matching tham so
	 * @throws NoSuchThamSoException if a matching tham so could not be found
	 */
	@Override
	public ThamSo findByG_M(long groupId, String ma)
		throws NoSuchThamSoException {

		ThamSo thamSo = fetchByG_M(groupId, ma);

		if (thamSo == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", ma=");
			msg.append(ma);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchThamSoException(msg.toString());
		}

		return thamSo;
	}

	/**
	 * Returns the tham so where groupId = &#63; and ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param ma the ma
	 * @return the matching tham so, or <code>null</code> if a matching tham so could not be found
	 */
	@Override
	public ThamSo fetchByG_M(long groupId, String ma) {
		return fetchByG_M(groupId, ma, true);
	}

	/**
	 * Returns the tham so where groupId = &#63; and ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param ma the ma
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching tham so, or <code>null</code> if a matching tham so could not be found
	 */
	@Override
	public ThamSo fetchByG_M(
		long groupId, String ma, boolean retrieveFromCache) {

		ma = Objects.toString(ma, "");

		Object[] finderArgs = new Object[] {groupId, ma};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByG_M, finderArgs, this);
		}

		if (result instanceof ThamSo) {
			ThamSo thamSo = (ThamSo)result;

			if ((groupId != thamSo.getGroupId()) ||
				!Objects.equals(ma, thamSo.getMa())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_THAMSO_WHERE);

			query.append(_FINDER_COLUMN_G_M_GROUPID_2);

			boolean bindMa = false;

			if (ma.isEmpty()) {
				query.append(_FINDER_COLUMN_G_M_MA_3);
			}
			else {
				bindMa = true;

				query.append(_FINDER_COLUMN_G_M_MA_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindMa) {
					qPos.add(ma);
				}

				List<ThamSo> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByG_M, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"ThamSoPersistenceImpl.fetchByG_M(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ThamSo thamSo = list.get(0);

					result = thamSo;

					cacheResult(thamSo);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(_finderPathFetchByG_M, finderArgs);

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
			return (ThamSo)result;
		}
	}

	/**
	 * Removes the tham so where groupId = &#63; and ma = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param ma the ma
	 * @return the tham so that was removed
	 */
	@Override
	public ThamSo removeByG_M(long groupId, String ma)
		throws NoSuchThamSoException {

		ThamSo thamSo = findByG_M(groupId, ma);

		return remove(thamSo);
	}

	/**
	 * Returns the number of tham sos where groupId = &#63; and ma = &#63;.
	 *
	 * @param groupId the group ID
	 * @param ma the ma
	 * @return the number of matching tham sos
	 */
	@Override
	public int countByG_M(long groupId, String ma) {
		ma = Objects.toString(ma, "");

		FinderPath finderPath = _finderPathCountByG_M;

		Object[] finderArgs = new Object[] {groupId, ma};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_THAMSO_WHERE);

			query.append(_FINDER_COLUMN_G_M_GROUPID_2);

			boolean bindMa = false;

			if (ma.isEmpty()) {
				query.append(_FINDER_COLUMN_G_M_MA_3);
			}
			else {
				bindMa = true;

				query.append(_FINDER_COLUMN_G_M_MA_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_G_M_GROUPID_2 =
		"thamSo.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_M_MA_2 = "thamSo.ma = ?";

	private static final String _FINDER_COLUMN_G_M_MA_3 =
		"(thamSo.ma IS NULL OR thamSo.ma = '')";

	private FinderPath _finderPathFetchByM_CL;
	private FinderPath _finderPathCountByM_CL;

	/**
	 * Returns the tham so where ma = &#63; and className = &#63; or throws a <code>NoSuchThamSoException</code> if it could not be found.
	 *
	 * @param ma the ma
	 * @param className the class name
	 * @return the matching tham so
	 * @throws NoSuchThamSoException if a matching tham so could not be found
	 */
	@Override
	public ThamSo findByM_CL(String ma, String className)
		throws NoSuchThamSoException {

		ThamSo thamSo = fetchByM_CL(ma, className);

		if (thamSo == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ma=");
			msg.append(ma);

			msg.append(", className=");
			msg.append(className);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchThamSoException(msg.toString());
		}

		return thamSo;
	}

	/**
	 * Returns the tham so where ma = &#63; and className = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ma the ma
	 * @param className the class name
	 * @return the matching tham so, or <code>null</code> if a matching tham so could not be found
	 */
	@Override
	public ThamSo fetchByM_CL(String ma, String className) {
		return fetchByM_CL(ma, className, true);
	}

	/**
	 * Returns the tham so where ma = &#63; and className = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ma the ma
	 * @param className the class name
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching tham so, or <code>null</code> if a matching tham so could not be found
	 */
	@Override
	public ThamSo fetchByM_CL(
		String ma, String className, boolean retrieveFromCache) {

		ma = Objects.toString(ma, "");
		className = Objects.toString(className, "");

		Object[] finderArgs = new Object[] {ma, className};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByM_CL, finderArgs, this);
		}

		if (result instanceof ThamSo) {
			ThamSo thamSo = (ThamSo)result;

			if (!Objects.equals(ma, thamSo.getMa()) ||
				!Objects.equals(className, thamSo.getClassName())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_THAMSO_WHERE);

			boolean bindMa = false;

			if (ma.isEmpty()) {
				query.append(_FINDER_COLUMN_M_CL_MA_3);
			}
			else {
				bindMa = true;

				query.append(_FINDER_COLUMN_M_CL_MA_2);
			}

			boolean bindClassName = false;

			if (className.isEmpty()) {
				query.append(_FINDER_COLUMN_M_CL_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_M_CL_CLASSNAME_2);
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

				if (bindClassName) {
					qPos.add(className);
				}

				List<ThamSo> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByM_CL, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"ThamSoPersistenceImpl.fetchByM_CL(String, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ThamSo thamSo = list.get(0);

					result = thamSo;

					cacheResult(thamSo);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(_finderPathFetchByM_CL, finderArgs);

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
			return (ThamSo)result;
		}
	}

	/**
	 * Removes the tham so where ma = &#63; and className = &#63; from the database.
	 *
	 * @param ma the ma
	 * @param className the class name
	 * @return the tham so that was removed
	 */
	@Override
	public ThamSo removeByM_CL(String ma, String className)
		throws NoSuchThamSoException {

		ThamSo thamSo = findByM_CL(ma, className);

		return remove(thamSo);
	}

	/**
	 * Returns the number of tham sos where ma = &#63; and className = &#63;.
	 *
	 * @param ma the ma
	 * @param className the class name
	 * @return the number of matching tham sos
	 */
	@Override
	public int countByM_CL(String ma, String className) {
		ma = Objects.toString(ma, "");
		className = Objects.toString(className, "");

		FinderPath finderPath = _finderPathCountByM_CL;

		Object[] finderArgs = new Object[] {ma, className};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_THAMSO_WHERE);

			boolean bindMa = false;

			if (ma.isEmpty()) {
				query.append(_FINDER_COLUMN_M_CL_MA_3);
			}
			else {
				bindMa = true;

				query.append(_FINDER_COLUMN_M_CL_MA_2);
			}

			boolean bindClassName = false;

			if (className.isEmpty()) {
				query.append(_FINDER_COLUMN_M_CL_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_M_CL_CLASSNAME_2);
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

				if (bindClassName) {
					qPos.add(className);
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

	private static final String _FINDER_COLUMN_M_CL_MA_2 = "thamSo.ma = ? AND ";

	private static final String _FINDER_COLUMN_M_CL_MA_3 =
		"(thamSo.ma IS NULL OR thamSo.ma = '') AND ";

	private static final String _FINDER_COLUMN_M_CL_CLASSNAME_2 =
		"thamSo.className = ?";

	private static final String _FINDER_COLUMN_M_CL_CLASSNAME_3 =
		"(thamSo.className IS NULL OR thamSo.className = '')";

	private FinderPath _finderPathFetchByM_CL_PK;
	private FinderPath _finderPathCountByM_CL_PK;

	/**
	 * Returns the tham so where ma = &#63; and className = &#63; and classPK = &#63; or throws a <code>NoSuchThamSoException</code> if it could not be found.
	 *
	 * @param ma the ma
	 * @param className the class name
	 * @param classPK the class pk
	 * @return the matching tham so
	 * @throws NoSuchThamSoException if a matching tham so could not be found
	 */
	@Override
	public ThamSo findByM_CL_PK(String ma, String className, long classPK)
		throws NoSuchThamSoException {

		ThamSo thamSo = fetchByM_CL_PK(ma, className, classPK);

		if (thamSo == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ma=");
			msg.append(ma);

			msg.append(", className=");
			msg.append(className);

			msg.append(", classPK=");
			msg.append(classPK);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchThamSoException(msg.toString());
		}

		return thamSo;
	}

	/**
	 * Returns the tham so where ma = &#63; and className = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ma the ma
	 * @param className the class name
	 * @param classPK the class pk
	 * @return the matching tham so, or <code>null</code> if a matching tham so could not be found
	 */
	@Override
	public ThamSo fetchByM_CL_PK(String ma, String className, long classPK) {
		return fetchByM_CL_PK(ma, className, classPK, true);
	}

	/**
	 * Returns the tham so where ma = &#63; and className = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ma the ma
	 * @param className the class name
	 * @param classPK the class pk
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching tham so, or <code>null</code> if a matching tham so could not be found
	 */
	@Override
	public ThamSo fetchByM_CL_PK(
		String ma, String className, long classPK, boolean retrieveFromCache) {

		ma = Objects.toString(ma, "");
		className = Objects.toString(className, "");

		Object[] finderArgs = new Object[] {ma, className, classPK};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByM_CL_PK, finderArgs, this);
		}

		if (result instanceof ThamSo) {
			ThamSo thamSo = (ThamSo)result;

			if (!Objects.equals(ma, thamSo.getMa()) ||
				!Objects.equals(className, thamSo.getClassName()) ||
				(classPK != thamSo.getClassPK())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_THAMSO_WHERE);

			boolean bindMa = false;

			if (ma.isEmpty()) {
				query.append(_FINDER_COLUMN_M_CL_PK_MA_3);
			}
			else {
				bindMa = true;

				query.append(_FINDER_COLUMN_M_CL_PK_MA_2);
			}

			boolean bindClassName = false;

			if (className.isEmpty()) {
				query.append(_FINDER_COLUMN_M_CL_PK_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_M_CL_PK_CLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_M_CL_PK_CLASSPK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindMa) {
					qPos.add(ma);
				}

				if (bindClassName) {
					qPos.add(className);
				}

				qPos.add(classPK);

				List<ThamSo> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByM_CL_PK, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"ThamSoPersistenceImpl.fetchByM_CL_PK(String, String, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ThamSo thamSo = list.get(0);

					result = thamSo;

					cacheResult(thamSo);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(_finderPathFetchByM_CL_PK, finderArgs);

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
			return (ThamSo)result;
		}
	}

	/**
	 * Removes the tham so where ma = &#63; and className = &#63; and classPK = &#63; from the database.
	 *
	 * @param ma the ma
	 * @param className the class name
	 * @param classPK the class pk
	 * @return the tham so that was removed
	 */
	@Override
	public ThamSo removeByM_CL_PK(String ma, String className, long classPK)
		throws NoSuchThamSoException {

		ThamSo thamSo = findByM_CL_PK(ma, className, classPK);

		return remove(thamSo);
	}

	/**
	 * Returns the number of tham sos where ma = &#63; and className = &#63; and classPK = &#63;.
	 *
	 * @param ma the ma
	 * @param className the class name
	 * @param classPK the class pk
	 * @return the number of matching tham sos
	 */
	@Override
	public int countByM_CL_PK(String ma, String className, long classPK) {
		ma = Objects.toString(ma, "");
		className = Objects.toString(className, "");

		FinderPath finderPath = _finderPathCountByM_CL_PK;

		Object[] finderArgs = new Object[] {ma, className, classPK};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_THAMSO_WHERE);

			boolean bindMa = false;

			if (ma.isEmpty()) {
				query.append(_FINDER_COLUMN_M_CL_PK_MA_3);
			}
			else {
				bindMa = true;

				query.append(_FINDER_COLUMN_M_CL_PK_MA_2);
			}

			boolean bindClassName = false;

			if (className.isEmpty()) {
				query.append(_FINDER_COLUMN_M_CL_PK_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_M_CL_PK_CLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_M_CL_PK_CLASSPK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindMa) {
					qPos.add(ma);
				}

				if (bindClassName) {
					qPos.add(className);
				}

				qPos.add(classPK);

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

	private static final String _FINDER_COLUMN_M_CL_PK_MA_2 =
		"thamSo.ma = ? AND ";

	private static final String _FINDER_COLUMN_M_CL_PK_MA_3 =
		"(thamSo.ma IS NULL OR thamSo.ma = '') AND ";

	private static final String _FINDER_COLUMN_M_CL_PK_CLASSNAME_2 =
		"thamSo.className = ? AND ";

	private static final String _FINDER_COLUMN_M_CL_PK_CLASSNAME_3 =
		"(thamSo.className IS NULL OR thamSo.className = '') AND ";

	private static final String _FINDER_COLUMN_M_CL_PK_CLASSPK_2 =
		"thamSo.classPK = ?";

	private FinderPath _finderPathWithPaginationFindByMa;
	private FinderPath _finderPathWithoutPaginationFindByMa;
	private FinderPath _finderPathCountByMa;

	/**
	 * Returns all the tham sos where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the matching tham sos
	 */
	@Override
	public List<ThamSo> findByMa(String ma) {
		return findByMa(ma, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tham sos where ma = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ThamSoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ma the ma
	 * @param start the lower bound of the range of tham sos
	 * @param end the upper bound of the range of tham sos (not inclusive)
	 * @return the range of matching tham sos
	 */
	@Override
	public List<ThamSo> findByMa(String ma, int start, int end) {
		return findByMa(ma, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tham sos where ma = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ThamSoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ma the ma
	 * @param start the lower bound of the range of tham sos
	 * @param end the upper bound of the range of tham sos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tham sos
	 */
	@Override
	public List<ThamSo> findByMa(
		String ma, int start, int end,
		OrderByComparator<ThamSo> orderByComparator) {

		return findByMa(ma, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tham sos where ma = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ThamSoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ma the ma
	 * @param start the lower bound of the range of tham sos
	 * @param end the upper bound of the range of tham sos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching tham sos
	 */
	@Override
	public List<ThamSo> findByMa(
		String ma, int start, int end,
		OrderByComparator<ThamSo> orderByComparator,
		boolean retrieveFromCache) {

		ma = Objects.toString(ma, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByMa;
			finderArgs = new Object[] {ma};
		}
		else {
			finderPath = _finderPathWithPaginationFindByMa;
			finderArgs = new Object[] {ma, start, end, orderByComparator};
		}

		List<ThamSo> list = null;

		if (retrieveFromCache) {
			list = (List<ThamSo>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ThamSo thamSo : list) {
					if (!ma.equals(thamSo.getMa())) {
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

			query.append(_SQL_SELECT_THAMSO_WHERE);

			boolean bindMa = false;

			if (ma.isEmpty()) {
				query.append(_FINDER_COLUMN_MA_MA_3);
			}
			else {
				bindMa = true;

				query.append(_FINDER_COLUMN_MA_MA_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(ThamSoModelImpl.ORDER_BY_JPQL);
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

				if (!pagination) {
					list = (List<ThamSo>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ThamSo>)QueryUtil.list(
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
	 * Returns the first tham so in the ordered set where ma = &#63;.
	 *
	 * @param ma the ma
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tham so
	 * @throws NoSuchThamSoException if a matching tham so could not be found
	 */
	@Override
	public ThamSo findByMa_First(
			String ma, OrderByComparator<ThamSo> orderByComparator)
		throws NoSuchThamSoException {

		ThamSo thamSo = fetchByMa_First(ma, orderByComparator);

		if (thamSo != null) {
			return thamSo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ma=");
		msg.append(ma);

		msg.append("}");

		throw new NoSuchThamSoException(msg.toString());
	}

	/**
	 * Returns the first tham so in the ordered set where ma = &#63;.
	 *
	 * @param ma the ma
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tham so, or <code>null</code> if a matching tham so could not be found
	 */
	@Override
	public ThamSo fetchByMa_First(
		String ma, OrderByComparator<ThamSo> orderByComparator) {

		List<ThamSo> list = findByMa(ma, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tham so in the ordered set where ma = &#63;.
	 *
	 * @param ma the ma
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tham so
	 * @throws NoSuchThamSoException if a matching tham so could not be found
	 */
	@Override
	public ThamSo findByMa_Last(
			String ma, OrderByComparator<ThamSo> orderByComparator)
		throws NoSuchThamSoException {

		ThamSo thamSo = fetchByMa_Last(ma, orderByComparator);

		if (thamSo != null) {
			return thamSo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ma=");
		msg.append(ma);

		msg.append("}");

		throw new NoSuchThamSoException(msg.toString());
	}

	/**
	 * Returns the last tham so in the ordered set where ma = &#63;.
	 *
	 * @param ma the ma
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tham so, or <code>null</code> if a matching tham so could not be found
	 */
	@Override
	public ThamSo fetchByMa_Last(
		String ma, OrderByComparator<ThamSo> orderByComparator) {

		int count = countByMa(ma);

		if (count == 0) {
			return null;
		}

		List<ThamSo> list = findByMa(ma, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tham sos before and after the current tham so in the ordered set where ma = &#63;.
	 *
	 * @param id the primary key of the current tham so
	 * @param ma the ma
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tham so
	 * @throws NoSuchThamSoException if a tham so with the primary key could not be found
	 */
	@Override
	public ThamSo[] findByMa_PrevAndNext(
			long id, String ma, OrderByComparator<ThamSo> orderByComparator)
		throws NoSuchThamSoException {

		ma = Objects.toString(ma, "");

		ThamSo thamSo = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ThamSo[] array = new ThamSoImpl[3];

			array[0] = getByMa_PrevAndNext(
				session, thamSo, ma, orderByComparator, true);

			array[1] = thamSo;

			array[2] = getByMa_PrevAndNext(
				session, thamSo, ma, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ThamSo getByMa_PrevAndNext(
		Session session, ThamSo thamSo, String ma,
		OrderByComparator<ThamSo> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_THAMSO_WHERE);

		boolean bindMa = false;

		if (ma.isEmpty()) {
			query.append(_FINDER_COLUMN_MA_MA_3);
		}
		else {
			bindMa = true;

			query.append(_FINDER_COLUMN_MA_MA_2);
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
			query.append(ThamSoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindMa) {
			qPos.add(ma);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(thamSo)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<ThamSo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tham sos where ma = &#63; from the database.
	 *
	 * @param ma the ma
	 */
	@Override
	public void removeByMa(String ma) {
		for (ThamSo thamSo :
				findByMa(ma, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(thamSo);
		}
	}

	/**
	 * Returns the number of tham sos where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the number of matching tham sos
	 */
	@Override
	public int countByMa(String ma) {
		ma = Objects.toString(ma, "");

		FinderPath finderPath = _finderPathCountByMa;

		Object[] finderArgs = new Object[] {ma};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_THAMSO_WHERE);

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

	private static final String _FINDER_COLUMN_MA_MA_2 = "thamSo.ma = ?";

	private static final String _FINDER_COLUMN_MA_MA_3 =
		"(thamSo.ma IS NULL OR thamSo.ma = '')";

	private FinderPath _finderPathWithPaginationFindBygiaTri;
	private FinderPath _finderPathWithoutPaginationFindBygiaTri;
	private FinderPath _finderPathCountBygiaTri;

	/**
	 * Returns all the tham sos where giaTri = &#63;.
	 *
	 * @param giaTri the gia tri
	 * @return the matching tham sos
	 */
	@Override
	public List<ThamSo> findBygiaTri(String giaTri) {
		return findBygiaTri(giaTri, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tham sos where giaTri = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ThamSoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param giaTri the gia tri
	 * @param start the lower bound of the range of tham sos
	 * @param end the upper bound of the range of tham sos (not inclusive)
	 * @return the range of matching tham sos
	 */
	@Override
	public List<ThamSo> findBygiaTri(String giaTri, int start, int end) {
		return findBygiaTri(giaTri, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tham sos where giaTri = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ThamSoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param giaTri the gia tri
	 * @param start the lower bound of the range of tham sos
	 * @param end the upper bound of the range of tham sos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tham sos
	 */
	@Override
	public List<ThamSo> findBygiaTri(
		String giaTri, int start, int end,
		OrderByComparator<ThamSo> orderByComparator) {

		return findBygiaTri(giaTri, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tham sos where giaTri = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ThamSoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param giaTri the gia tri
	 * @param start the lower bound of the range of tham sos
	 * @param end the upper bound of the range of tham sos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching tham sos
	 */
	@Override
	public List<ThamSo> findBygiaTri(
		String giaTri, int start, int end,
		OrderByComparator<ThamSo> orderByComparator,
		boolean retrieveFromCache) {

		giaTri = Objects.toString(giaTri, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindBygiaTri;
			finderArgs = new Object[] {giaTri};
		}
		else {
			finderPath = _finderPathWithPaginationFindBygiaTri;
			finderArgs = new Object[] {giaTri, start, end, orderByComparator};
		}

		List<ThamSo> list = null;

		if (retrieveFromCache) {
			list = (List<ThamSo>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ThamSo thamSo : list) {
					if (!giaTri.equals(thamSo.getGiaTri())) {
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

			query.append(_SQL_SELECT_THAMSO_WHERE);

			boolean bindGiaTri = false;

			if (giaTri.isEmpty()) {
				query.append(_FINDER_COLUMN_GIATRI_GIATRI_3);
			}
			else {
				bindGiaTri = true;

				query.append(_FINDER_COLUMN_GIATRI_GIATRI_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(ThamSoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindGiaTri) {
					qPos.add(giaTri);
				}

				if (!pagination) {
					list = (List<ThamSo>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ThamSo>)QueryUtil.list(
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
	 * Returns the first tham so in the ordered set where giaTri = &#63;.
	 *
	 * @param giaTri the gia tri
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tham so
	 * @throws NoSuchThamSoException if a matching tham so could not be found
	 */
	@Override
	public ThamSo findBygiaTri_First(
			String giaTri, OrderByComparator<ThamSo> orderByComparator)
		throws NoSuchThamSoException {

		ThamSo thamSo = fetchBygiaTri_First(giaTri, orderByComparator);

		if (thamSo != null) {
			return thamSo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("giaTri=");
		msg.append(giaTri);

		msg.append("}");

		throw new NoSuchThamSoException(msg.toString());
	}

	/**
	 * Returns the first tham so in the ordered set where giaTri = &#63;.
	 *
	 * @param giaTri the gia tri
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tham so, or <code>null</code> if a matching tham so could not be found
	 */
	@Override
	public ThamSo fetchBygiaTri_First(
		String giaTri, OrderByComparator<ThamSo> orderByComparator) {

		List<ThamSo> list = findBygiaTri(giaTri, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tham so in the ordered set where giaTri = &#63;.
	 *
	 * @param giaTri the gia tri
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tham so
	 * @throws NoSuchThamSoException if a matching tham so could not be found
	 */
	@Override
	public ThamSo findBygiaTri_Last(
			String giaTri, OrderByComparator<ThamSo> orderByComparator)
		throws NoSuchThamSoException {

		ThamSo thamSo = fetchBygiaTri_Last(giaTri, orderByComparator);

		if (thamSo != null) {
			return thamSo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("giaTri=");
		msg.append(giaTri);

		msg.append("}");

		throw new NoSuchThamSoException(msg.toString());
	}

	/**
	 * Returns the last tham so in the ordered set where giaTri = &#63;.
	 *
	 * @param giaTri the gia tri
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tham so, or <code>null</code> if a matching tham so could not be found
	 */
	@Override
	public ThamSo fetchBygiaTri_Last(
		String giaTri, OrderByComparator<ThamSo> orderByComparator) {

		int count = countBygiaTri(giaTri);

		if (count == 0) {
			return null;
		}

		List<ThamSo> list = findBygiaTri(
			giaTri, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tham sos before and after the current tham so in the ordered set where giaTri = &#63;.
	 *
	 * @param id the primary key of the current tham so
	 * @param giaTri the gia tri
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tham so
	 * @throws NoSuchThamSoException if a tham so with the primary key could not be found
	 */
	@Override
	public ThamSo[] findBygiaTri_PrevAndNext(
			long id, String giaTri, OrderByComparator<ThamSo> orderByComparator)
		throws NoSuchThamSoException {

		giaTri = Objects.toString(giaTri, "");

		ThamSo thamSo = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ThamSo[] array = new ThamSoImpl[3];

			array[0] = getBygiaTri_PrevAndNext(
				session, thamSo, giaTri, orderByComparator, true);

			array[1] = thamSo;

			array[2] = getBygiaTri_PrevAndNext(
				session, thamSo, giaTri, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ThamSo getBygiaTri_PrevAndNext(
		Session session, ThamSo thamSo, String giaTri,
		OrderByComparator<ThamSo> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_THAMSO_WHERE);

		boolean bindGiaTri = false;

		if (giaTri.isEmpty()) {
			query.append(_FINDER_COLUMN_GIATRI_GIATRI_3);
		}
		else {
			bindGiaTri = true;

			query.append(_FINDER_COLUMN_GIATRI_GIATRI_2);
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
			query.append(ThamSoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindGiaTri) {
			qPos.add(giaTri);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(thamSo)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<ThamSo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tham sos where giaTri = &#63; from the database.
	 *
	 * @param giaTri the gia tri
	 */
	@Override
	public void removeBygiaTri(String giaTri) {
		for (ThamSo thamSo :
				findBygiaTri(
					giaTri, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(thamSo);
		}
	}

	/**
	 * Returns the number of tham sos where giaTri = &#63;.
	 *
	 * @param giaTri the gia tri
	 * @return the number of matching tham sos
	 */
	@Override
	public int countBygiaTri(String giaTri) {
		giaTri = Objects.toString(giaTri, "");

		FinderPath finderPath = _finderPathCountBygiaTri;

		Object[] finderArgs = new Object[] {giaTri};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_THAMSO_WHERE);

			boolean bindGiaTri = false;

			if (giaTri.isEmpty()) {
				query.append(_FINDER_COLUMN_GIATRI_GIATRI_3);
			}
			else {
				bindGiaTri = true;

				query.append(_FINDER_COLUMN_GIATRI_GIATRI_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindGiaTri) {
					qPos.add(giaTri);
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

	private static final String _FINDER_COLUMN_GIATRI_GIATRI_2 =
		"thamSo.giaTri = ?";

	private static final String _FINDER_COLUMN_GIATRI_GIATRI_3 =
		"(thamSo.giaTri IS NULL OR thamSo.giaTri = '')";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the tham sos where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching tham sos
	 */
	@Override
	public List<ThamSo> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tham sos where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ThamSoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of tham sos
	 * @param end the upper bound of the range of tham sos (not inclusive)
	 * @return the range of matching tham sos
	 */
	@Override
	public List<ThamSo> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tham sos where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ThamSoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of tham sos
	 * @param end the upper bound of the range of tham sos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tham sos
	 */
	@Override
	public List<ThamSo> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ThamSo> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tham sos where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ThamSoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of tham sos
	 * @param end the upper bound of the range of tham sos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching tham sos
	 */
	@Override
	public List<ThamSo> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ThamSo> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByGroupId;
			finderArgs = new Object[] {groupId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByGroupId;
			finderArgs = new Object[] {groupId, start, end, orderByComparator};
		}

		List<ThamSo> list = null;

		if (retrieveFromCache) {
			list = (List<ThamSo>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ThamSo thamSo : list) {
					if ((groupId != thamSo.getGroupId())) {
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

			query.append(_SQL_SELECT_THAMSO_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(ThamSoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<ThamSo>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ThamSo>)QueryUtil.list(
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
	 * Returns the first tham so in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tham so
	 * @throws NoSuchThamSoException if a matching tham so could not be found
	 */
	@Override
	public ThamSo findByGroupId_First(
			long groupId, OrderByComparator<ThamSo> orderByComparator)
		throws NoSuchThamSoException {

		ThamSo thamSo = fetchByGroupId_First(groupId, orderByComparator);

		if (thamSo != null) {
			return thamSo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchThamSoException(msg.toString());
	}

	/**
	 * Returns the first tham so in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tham so, or <code>null</code> if a matching tham so could not be found
	 */
	@Override
	public ThamSo fetchByGroupId_First(
		long groupId, OrderByComparator<ThamSo> orderByComparator) {

		List<ThamSo> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tham so in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tham so
	 * @throws NoSuchThamSoException if a matching tham so could not be found
	 */
	@Override
	public ThamSo findByGroupId_Last(
			long groupId, OrderByComparator<ThamSo> orderByComparator)
		throws NoSuchThamSoException {

		ThamSo thamSo = fetchByGroupId_Last(groupId, orderByComparator);

		if (thamSo != null) {
			return thamSo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchThamSoException(msg.toString());
	}

	/**
	 * Returns the last tham so in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tham so, or <code>null</code> if a matching tham so could not be found
	 */
	@Override
	public ThamSo fetchByGroupId_Last(
		long groupId, OrderByComparator<ThamSo> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<ThamSo> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tham sos before and after the current tham so in the ordered set where groupId = &#63;.
	 *
	 * @param id the primary key of the current tham so
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tham so
	 * @throws NoSuchThamSoException if a tham so with the primary key could not be found
	 */
	@Override
	public ThamSo[] findByGroupId_PrevAndNext(
			long id, long groupId, OrderByComparator<ThamSo> orderByComparator)
		throws NoSuchThamSoException {

		ThamSo thamSo = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ThamSo[] array = new ThamSoImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, thamSo, groupId, orderByComparator, true);

			array[1] = thamSo;

			array[2] = getByGroupId_PrevAndNext(
				session, thamSo, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ThamSo getByGroupId_PrevAndNext(
		Session session, ThamSo thamSo, long groupId,
		OrderByComparator<ThamSo> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_THAMSO_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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
			query.append(ThamSoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(thamSo)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<ThamSo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tham sos where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (ThamSo thamSo :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(thamSo);
		}
	}

	/**
	 * Returns the number of tham sos where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching tham sos
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_THAMSO_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 =
		"thamSo.groupId = ?";

	public ThamSoPersistenceImpl() {
		setModelClass(ThamSo.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("className", "classname");
		dbColumnNames.put("classPK", "classpk");
		dbColumnNames.put("loaiId", "loai_id");
		dbColumnNames.put("giaTri", "giatri");
		dbColumnNames.put("moTa", "mota");
		dbColumnNames.put("trangThai", "trangthai");
		dbColumnNames.put("quyenTacDong", "quyen_tac_dong");

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
	 * Caches the tham so in the entity cache if it is enabled.
	 *
	 * @param thamSo the tham so
	 */
	@Override
	public void cacheResult(ThamSo thamSo) {
		entityCache.putResult(
			ThamSoModelImpl.ENTITY_CACHE_ENABLED, ThamSoImpl.class,
			thamSo.getPrimaryKey(), thamSo);

		finderCache.putResult(
			_finderPathFetchByG_M,
			new Object[] {thamSo.getGroupId(), thamSo.getMa()}, thamSo);

		finderCache.putResult(
			_finderPathFetchByM_CL,
			new Object[] {thamSo.getMa(), thamSo.getClassName()}, thamSo);

		finderCache.putResult(
			_finderPathFetchByM_CL_PK,
			new Object[] {
				thamSo.getMa(), thamSo.getClassName(), thamSo.getClassPK()
			},
			thamSo);

		thamSo.resetOriginalValues();
	}

	/**
	 * Caches the tham sos in the entity cache if it is enabled.
	 *
	 * @param thamSos the tham sos
	 */
	@Override
	public void cacheResult(List<ThamSo> thamSos) {
		for (ThamSo thamSo : thamSos) {
			if (entityCache.getResult(
					ThamSoModelImpl.ENTITY_CACHE_ENABLED, ThamSoImpl.class,
					thamSo.getPrimaryKey()) == null) {

				cacheResult(thamSo);
			}
			else {
				thamSo.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all tham sos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ThamSoImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the tham so.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ThamSo thamSo) {
		entityCache.removeResult(
			ThamSoModelImpl.ENTITY_CACHE_ENABLED, ThamSoImpl.class,
			thamSo.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((ThamSoModelImpl)thamSo, true);
	}

	@Override
	public void clearCache(List<ThamSo> thamSos) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ThamSo thamSo : thamSos) {
			entityCache.removeResult(
				ThamSoModelImpl.ENTITY_CACHE_ENABLED, ThamSoImpl.class,
				thamSo.getPrimaryKey());

			clearUniqueFindersCache((ThamSoModelImpl)thamSo, true);
		}
	}

	protected void cacheUniqueFindersCache(ThamSoModelImpl thamSoModelImpl) {
		Object[] args = new Object[] {
			thamSoModelImpl.getGroupId(), thamSoModelImpl.getMa()
		};

		finderCache.putResult(
			_finderPathCountByG_M, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByG_M, args, thamSoModelImpl, false);

		args = new Object[] {
			thamSoModelImpl.getMa(), thamSoModelImpl.getClassName()
		};

		finderCache.putResult(
			_finderPathCountByM_CL, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByM_CL, args, thamSoModelImpl, false);

		args = new Object[] {
			thamSoModelImpl.getMa(), thamSoModelImpl.getClassName(),
			thamSoModelImpl.getClassPK()
		};

		finderCache.putResult(
			_finderPathCountByM_CL_PK, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByM_CL_PK, args, thamSoModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		ThamSoModelImpl thamSoModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				thamSoModelImpl.getGroupId(), thamSoModelImpl.getMa()
			};

			finderCache.removeResult(_finderPathCountByG_M, args);
			finderCache.removeResult(_finderPathFetchByG_M, args);
		}

		if ((thamSoModelImpl.getColumnBitmask() &
			 _finderPathFetchByG_M.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				thamSoModelImpl.getOriginalGroupId(),
				thamSoModelImpl.getOriginalMa()
			};

			finderCache.removeResult(_finderPathCountByG_M, args);
			finderCache.removeResult(_finderPathFetchByG_M, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				thamSoModelImpl.getMa(), thamSoModelImpl.getClassName()
			};

			finderCache.removeResult(_finderPathCountByM_CL, args);
			finderCache.removeResult(_finderPathFetchByM_CL, args);
		}

		if ((thamSoModelImpl.getColumnBitmask() &
			 _finderPathFetchByM_CL.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				thamSoModelImpl.getOriginalMa(),
				thamSoModelImpl.getOriginalClassName()
			};

			finderCache.removeResult(_finderPathCountByM_CL, args);
			finderCache.removeResult(_finderPathFetchByM_CL, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				thamSoModelImpl.getMa(), thamSoModelImpl.getClassName(),
				thamSoModelImpl.getClassPK()
			};

			finderCache.removeResult(_finderPathCountByM_CL_PK, args);
			finderCache.removeResult(_finderPathFetchByM_CL_PK, args);
		}

		if ((thamSoModelImpl.getColumnBitmask() &
			 _finderPathFetchByM_CL_PK.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				thamSoModelImpl.getOriginalMa(),
				thamSoModelImpl.getOriginalClassName(),
				thamSoModelImpl.getOriginalClassPK()
			};

			finderCache.removeResult(_finderPathCountByM_CL_PK, args);
			finderCache.removeResult(_finderPathFetchByM_CL_PK, args);
		}
	}

	/**
	 * Creates a new tham so with the primary key. Does not add the tham so to the database.
	 *
	 * @param id the primary key for the new tham so
	 * @return the new tham so
	 */
	@Override
	public ThamSo create(long id) {
		ThamSo thamSo = new ThamSoImpl();

		thamSo.setNew(true);
		thamSo.setPrimaryKey(id);

		return thamSo;
	}

	/**
	 * Removes the tham so with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the tham so
	 * @return the tham so that was removed
	 * @throws NoSuchThamSoException if a tham so with the primary key could not be found
	 */
	@Override
	public ThamSo remove(long id) throws NoSuchThamSoException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the tham so with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tham so
	 * @return the tham so that was removed
	 * @throws NoSuchThamSoException if a tham so with the primary key could not be found
	 */
	@Override
	public ThamSo remove(Serializable primaryKey) throws NoSuchThamSoException {
		Session session = null;

		try {
			session = openSession();

			ThamSo thamSo = (ThamSo)session.get(ThamSoImpl.class, primaryKey);

			if (thamSo == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchThamSoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(thamSo);
		}
		catch (NoSuchThamSoException nsee) {
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
	protected ThamSo removeImpl(ThamSo thamSo) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(thamSo)) {
				thamSo = (ThamSo)session.get(
					ThamSoImpl.class, thamSo.getPrimaryKeyObj());
			}

			if (thamSo != null) {
				session.delete(thamSo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (thamSo != null) {
			clearCache(thamSo);
		}

		return thamSo;
	}

	@Override
	public ThamSo updateImpl(ThamSo thamSo) {
		boolean isNew = thamSo.isNew();

		if (!(thamSo instanceof ThamSoModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(thamSo.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(thamSo);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in thamSo proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ThamSo implementation " +
					thamSo.getClass());
		}

		ThamSoModelImpl thamSoModelImpl = (ThamSoModelImpl)thamSo;

		Session session = null;

		try {
			session = openSession();

			if (thamSo.isNew()) {
				session.save(thamSo);

				thamSo.setNew(false);
			}
			else {
				thamSo = (ThamSo)session.merge(thamSo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!ThamSoModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {thamSoModelImpl.getMa()};

			finderCache.removeResult(_finderPathCountByMa, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByMa, args);

			args = new Object[] {thamSoModelImpl.getGiaTri()};

			finderCache.removeResult(_finderPathCountBygiaTri, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindBygiaTri, args);

			args = new Object[] {thamSoModelImpl.getGroupId()};

			finderCache.removeResult(_finderPathCountByGroupId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroupId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((thamSoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByMa.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {thamSoModelImpl.getOriginalMa()};

				finderCache.removeResult(_finderPathCountByMa, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByMa, args);

				args = new Object[] {thamSoModelImpl.getMa()};

				finderCache.removeResult(_finderPathCountByMa, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByMa, args);
			}

			if ((thamSoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindBygiaTri.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					thamSoModelImpl.getOriginalGiaTri()
				};

				finderCache.removeResult(_finderPathCountBygiaTri, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBygiaTri, args);

				args = new Object[] {thamSoModelImpl.getGiaTri()};

				finderCache.removeResult(_finderPathCountBygiaTri, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBygiaTri, args);
			}

			if ((thamSoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroupId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					thamSoModelImpl.getOriginalGroupId()
				};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);

				args = new Object[] {thamSoModelImpl.getGroupId()};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);
			}
		}

		entityCache.putResult(
			ThamSoModelImpl.ENTITY_CACHE_ENABLED, ThamSoImpl.class,
			thamSo.getPrimaryKey(), thamSo, false);

		clearUniqueFindersCache(thamSoModelImpl, false);
		cacheUniqueFindersCache(thamSoModelImpl);

		thamSo.resetOriginalValues();

		return thamSo;
	}

	/**
	 * Returns the tham so with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tham so
	 * @return the tham so
	 * @throws NoSuchThamSoException if a tham so with the primary key could not be found
	 */
	@Override
	public ThamSo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchThamSoException {

		ThamSo thamSo = fetchByPrimaryKey(primaryKey);

		if (thamSo == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchThamSoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return thamSo;
	}

	/**
	 * Returns the tham so with the primary key or throws a <code>NoSuchThamSoException</code> if it could not be found.
	 *
	 * @param id the primary key of the tham so
	 * @return the tham so
	 * @throws NoSuchThamSoException if a tham so with the primary key could not be found
	 */
	@Override
	public ThamSo findByPrimaryKey(long id) throws NoSuchThamSoException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the tham so with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tham so
	 * @return the tham so, or <code>null</code> if a tham so with the primary key could not be found
	 */
	@Override
	public ThamSo fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			ThamSoModelImpl.ENTITY_CACHE_ENABLED, ThamSoImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		ThamSo thamSo = (ThamSo)serializable;

		if (thamSo == null) {
			Session session = null;

			try {
				session = openSession();

				thamSo = (ThamSo)session.get(ThamSoImpl.class, primaryKey);

				if (thamSo != null) {
					cacheResult(thamSo);
				}
				else {
					entityCache.putResult(
						ThamSoModelImpl.ENTITY_CACHE_ENABLED, ThamSoImpl.class,
						primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					ThamSoModelImpl.ENTITY_CACHE_ENABLED, ThamSoImpl.class,
					primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return thamSo;
	}

	/**
	 * Returns the tham so with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the tham so
	 * @return the tham so, or <code>null</code> if a tham so with the primary key could not be found
	 */
	@Override
	public ThamSo fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, ThamSo> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ThamSo> map = new HashMap<Serializable, ThamSo>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ThamSo thamSo = fetchByPrimaryKey(primaryKey);

			if (thamSo != null) {
				map.put(primaryKey, thamSo);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				ThamSoModelImpl.ENTITY_CACHE_ENABLED, ThamSoImpl.class,
				primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (ThamSo)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_THAMSO_WHERE_PKS_IN);

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

			for (ThamSo thamSo : (List<ThamSo>)q.list()) {
				map.put(thamSo.getPrimaryKeyObj(), thamSo);

				cacheResult(thamSo);

				uncachedPrimaryKeys.remove(thamSo.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					ThamSoModelImpl.ENTITY_CACHE_ENABLED, ThamSoImpl.class,
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
	 * Returns all the tham sos.
	 *
	 * @return the tham sos
	 */
	@Override
	public List<ThamSo> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tham sos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ThamSoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tham sos
	 * @param end the upper bound of the range of tham sos (not inclusive)
	 * @return the range of tham sos
	 */
	@Override
	public List<ThamSo> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the tham sos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ThamSoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tham sos
	 * @param end the upper bound of the range of tham sos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tham sos
	 */
	@Override
	public List<ThamSo> findAll(
		int start, int end, OrderByComparator<ThamSo> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tham sos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ThamSoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tham sos
	 * @param end the upper bound of the range of tham sos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of tham sos
	 */
	@Override
	public List<ThamSo> findAll(
		int start, int end, OrderByComparator<ThamSo> orderByComparator,
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

		List<ThamSo> list = null;

		if (retrieveFromCache) {
			list = (List<ThamSo>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_THAMSO);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_THAMSO;

				if (pagination) {
					sql = sql.concat(ThamSoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ThamSo>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ThamSo>)QueryUtil.list(
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
	 * Removes all the tham sos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ThamSo thamSo : findAll()) {
			remove(thamSo);
		}
	}

	/**
	 * Returns the number of tham sos.
	 *
	 * @return the number of tham sos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_THAMSO);

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
		return ThamSoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the tham so persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			ThamSoModelImpl.ENTITY_CACHE_ENABLED,
			ThamSoModelImpl.FINDER_CACHE_ENABLED, ThamSoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			ThamSoModelImpl.ENTITY_CACHE_ENABLED,
			ThamSoModelImpl.FINDER_CACHE_ENABLED, ThamSoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			ThamSoModelImpl.ENTITY_CACHE_ENABLED,
			ThamSoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByG_M = new FinderPath(
			ThamSoModelImpl.ENTITY_CACHE_ENABLED,
			ThamSoModelImpl.FINDER_CACHE_ENABLED, ThamSoImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByG_M",
			new String[] {Long.class.getName(), String.class.getName()},
			ThamSoModelImpl.GROUPID_COLUMN_BITMASK |
			ThamSoModelImpl.MA_COLUMN_BITMASK);

		_finderPathCountByG_M = new FinderPath(
			ThamSoModelImpl.ENTITY_CACHE_ENABLED,
			ThamSoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_M",
			new String[] {Long.class.getName(), String.class.getName()});

		_finderPathFetchByM_CL = new FinderPath(
			ThamSoModelImpl.ENTITY_CACHE_ENABLED,
			ThamSoModelImpl.FINDER_CACHE_ENABLED, ThamSoImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByM_CL",
			new String[] {String.class.getName(), String.class.getName()},
			ThamSoModelImpl.MA_COLUMN_BITMASK |
			ThamSoModelImpl.CLASSNAME_COLUMN_BITMASK);

		_finderPathCountByM_CL = new FinderPath(
			ThamSoModelImpl.ENTITY_CACHE_ENABLED,
			ThamSoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByM_CL",
			new String[] {String.class.getName(), String.class.getName()});

		_finderPathFetchByM_CL_PK = new FinderPath(
			ThamSoModelImpl.ENTITY_CACHE_ENABLED,
			ThamSoModelImpl.FINDER_CACHE_ENABLED, ThamSoImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByM_CL_PK",
			new String[] {
				String.class.getName(), String.class.getName(),
				Long.class.getName()
			},
			ThamSoModelImpl.MA_COLUMN_BITMASK |
			ThamSoModelImpl.CLASSNAME_COLUMN_BITMASK |
			ThamSoModelImpl.CLASSPK_COLUMN_BITMASK);

		_finderPathCountByM_CL_PK = new FinderPath(
			ThamSoModelImpl.ENTITY_CACHE_ENABLED,
			ThamSoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByM_CL_PK",
			new String[] {
				String.class.getName(), String.class.getName(),
				Long.class.getName()
			});

		_finderPathWithPaginationFindByMa = new FinderPath(
			ThamSoModelImpl.ENTITY_CACHE_ENABLED,
			ThamSoModelImpl.FINDER_CACHE_ENABLED, ThamSoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMa",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByMa = new FinderPath(
			ThamSoModelImpl.ENTITY_CACHE_ENABLED,
			ThamSoModelImpl.FINDER_CACHE_ENABLED, ThamSoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMa",
			new String[] {String.class.getName()},
			ThamSoModelImpl.MA_COLUMN_BITMASK);

		_finderPathCountByMa = new FinderPath(
			ThamSoModelImpl.ENTITY_CACHE_ENABLED,
			ThamSoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMa",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindBygiaTri = new FinderPath(
			ThamSoModelImpl.ENTITY_CACHE_ENABLED,
			ThamSoModelImpl.FINDER_CACHE_ENABLED, ThamSoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBygiaTri",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindBygiaTri = new FinderPath(
			ThamSoModelImpl.ENTITY_CACHE_ENABLED,
			ThamSoModelImpl.FINDER_CACHE_ENABLED, ThamSoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBygiaTri",
			new String[] {String.class.getName()},
			ThamSoModelImpl.GIATRI_COLUMN_BITMASK);

		_finderPathCountBygiaTri = new FinderPath(
			ThamSoModelImpl.ENTITY_CACHE_ENABLED,
			ThamSoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBygiaTri",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByGroupId = new FinderPath(
			ThamSoModelImpl.ENTITY_CACHE_ENABLED,
			ThamSoModelImpl.FINDER_CACHE_ENABLED, ThamSoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroupId = new FinderPath(
			ThamSoModelImpl.ENTITY_CACHE_ENABLED,
			ThamSoModelImpl.FINDER_CACHE_ENABLED, ThamSoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] {Long.class.getName()},
			ThamSoModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByGroupId = new FinderPath(
			ThamSoModelImpl.ENTITY_CACHE_ENABLED,
			ThamSoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] {Long.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(ThamSoImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_THAMSO =
		"SELECT thamSo FROM ThamSo thamSo";

	private static final String _SQL_SELECT_THAMSO_WHERE_PKS_IN =
		"SELECT thamSo FROM ThamSo thamSo WHERE id IN (";

	private static final String _SQL_SELECT_THAMSO_WHERE =
		"SELECT thamSo FROM ThamSo thamSo WHERE ";

	private static final String _SQL_COUNT_THAMSO =
		"SELECT COUNT(thamSo) FROM ThamSo thamSo";

	private static final String _SQL_COUNT_THAMSO_WHERE =
		"SELECT COUNT(thamSo) FROM ThamSo thamSo WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "thamSo.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ThamSo exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ThamSo exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ThamSoPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"groupId", "className", "classPK", "loaiId", "giaTri", "moTa",
			"trangThai", "quyenTacDong"
		});

}