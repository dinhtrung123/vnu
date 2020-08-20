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

package org.oep.danhmuc.service.persistence.impl;

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
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.oep.danhmuc.exception.NoSuchDanhMucException;
import org.oep.danhmuc.model.DanhMuc;
import org.oep.danhmuc.model.impl.DanhMucImpl;
import org.oep.danhmuc.model.impl.DanhMucModelImpl;
import org.oep.danhmuc.service.persistence.DanhMucPersistence;

/**
 * The persistence implementation for the danh muc service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nhanvienDTT
 * @generated
 */
@ProviderType
public class DanhMucPersistenceImpl
	extends BasePersistenceImpl<DanhMuc> implements DanhMucPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DanhMucUtil</code> to access the danh muc persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DanhMucImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByM;
	private FinderPath _finderPathCountByM;

	/**
	 * Returns the danh muc where ma = &#63; or throws a <code>NoSuchDanhMucException</code> if it could not be found.
	 *
	 * @param ma the ma
	 * @return the matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc findByM(String ma) throws NoSuchDanhMucException {
		DanhMuc danhMuc = fetchByM(ma);

		if (danhMuc == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ma=");
			msg.append(ma);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchDanhMucException(msg.toString());
		}

		return danhMuc;
	}

	/**
	 * Returns the danh muc where ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ma the ma
	 * @return the matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc fetchByM(String ma) {
		return fetchByM(ma, true);
	}

	/**
	 * Returns the danh muc where ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ma the ma
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc fetchByM(String ma, boolean retrieveFromCache) {
		ma = Objects.toString(ma, "");

		Object[] finderArgs = new Object[] {ma};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByM, finderArgs, this);
		}

		if (result instanceof DanhMuc) {
			DanhMuc danhMuc = (DanhMuc)result;

			if (!Objects.equals(ma, danhMuc.getMa())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_DANHMUC_WHERE);

			boolean bindMa = false;

			if (ma.isEmpty()) {
				query.append(_FINDER_COLUMN_M_MA_3);
			}
			else {
				bindMa = true;

				query.append(_FINDER_COLUMN_M_MA_2);
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

				List<DanhMuc> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByM, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"DanhMucPersistenceImpl.fetchByM(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DanhMuc danhMuc = list.get(0);

					result = danhMuc;

					cacheResult(danhMuc);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(_finderPathFetchByM, finderArgs);

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
			return (DanhMuc)result;
		}
	}

	/**
	 * Removes the danh muc where ma = &#63; from the database.
	 *
	 * @param ma the ma
	 * @return the danh muc that was removed
	 */
	@Override
	public DanhMuc removeByM(String ma) throws NoSuchDanhMucException {
		DanhMuc danhMuc = findByM(ma);

		return remove(danhMuc);
	}

	/**
	 * Returns the number of danh mucs where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the number of matching danh mucs
	 */
	@Override
	public int countByM(String ma) {
		ma = Objects.toString(ma, "");

		FinderPath finderPath = _finderPathCountByM;

		Object[] finderArgs = new Object[] {ma};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DANHMUC_WHERE);

			boolean bindMa = false;

			if (ma.isEmpty()) {
				query.append(_FINDER_COLUMN_M_MA_3);
			}
			else {
				bindMa = true;

				query.append(_FINDER_COLUMN_M_MA_2);
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

	private static final String _FINDER_COLUMN_M_MA_2 = "danhMuc.ma = ?";

	private static final String _FINDER_COLUMN_M_MA_3 =
		"(danhMuc.ma IS NULL OR danhMuc.ma = '')";

	private FinderPath _finderPathFetchByT;
	private FinderPath _finderPathCountByT;

	/**
	 * Returns the danh muc where ten = &#63; or throws a <code>NoSuchDanhMucException</code> if it could not be found.
	 *
	 * @param ten the ten
	 * @return the matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc findByT(String ten) throws NoSuchDanhMucException {
		DanhMuc danhMuc = fetchByT(ten);

		if (danhMuc == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ten=");
			msg.append(ten);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchDanhMucException(msg.toString());
		}

		return danhMuc;
	}

	/**
	 * Returns the danh muc where ten = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ten the ten
	 * @return the matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc fetchByT(String ten) {
		return fetchByT(ten, true);
	}

	/**
	 * Returns the danh muc where ten = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ten the ten
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc fetchByT(String ten, boolean retrieveFromCache) {
		ten = Objects.toString(ten, "");

		Object[] finderArgs = new Object[] {ten};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByT, finderArgs, this);
		}

		if (result instanceof DanhMuc) {
			DanhMuc danhMuc = (DanhMuc)result;

			if (!Objects.equals(ten, danhMuc.getTen())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_DANHMUC_WHERE);

			boolean bindTen = false;

			if (ten.isEmpty()) {
				query.append(_FINDER_COLUMN_T_TEN_3);
			}
			else {
				bindTen = true;

				query.append(_FINDER_COLUMN_T_TEN_2);
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

				List<DanhMuc> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByT, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"DanhMucPersistenceImpl.fetchByT(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DanhMuc danhMuc = list.get(0);

					result = danhMuc;

					cacheResult(danhMuc);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(_finderPathFetchByT, finderArgs);

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
			return (DanhMuc)result;
		}
	}

	/**
	 * Removes the danh muc where ten = &#63; from the database.
	 *
	 * @param ten the ten
	 * @return the danh muc that was removed
	 */
	@Override
	public DanhMuc removeByT(String ten) throws NoSuchDanhMucException {
		DanhMuc danhMuc = findByT(ten);

		return remove(danhMuc);
	}

	/**
	 * Returns the number of danh mucs where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the number of matching danh mucs
	 */
	@Override
	public int countByT(String ten) {
		ten = Objects.toString(ten, "");

		FinderPath finderPath = _finderPathCountByT;

		Object[] finderArgs = new Object[] {ten};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DANHMUC_WHERE);

			boolean bindTen = false;

			if (ten.isEmpty()) {
				query.append(_FINDER_COLUMN_T_TEN_3);
			}
			else {
				bindTen = true;

				query.append(_FINDER_COLUMN_T_TEN_2);
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

	private static final String _FINDER_COLUMN_T_TEN_2 = "danhMuc.ten = ?";

	private static final String _FINDER_COLUMN_T_TEN_3 =
		"(danhMuc.ten IS NULL OR danhMuc.ten = '')";

	private FinderPath _finderPathFetchByP_T;
	private FinderPath _finderPathCountByP_T;

	/**
	 * Returns the danh muc where chaId = &#63; and ten = &#63; or throws a <code>NoSuchDanhMucException</code> if it could not be found.
	 *
	 * @param chaId the cha ID
	 * @param ten the ten
	 * @return the matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc findByP_T(long chaId, String ten)
		throws NoSuchDanhMucException {

		DanhMuc danhMuc = fetchByP_T(chaId, ten);

		if (danhMuc == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("chaId=");
			msg.append(chaId);

			msg.append(", ten=");
			msg.append(ten);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchDanhMucException(msg.toString());
		}

		return danhMuc;
	}

	/**
	 * Returns the danh muc where chaId = &#63; and ten = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param chaId the cha ID
	 * @param ten the ten
	 * @return the matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc fetchByP_T(long chaId, String ten) {
		return fetchByP_T(chaId, ten, true);
	}

	/**
	 * Returns the danh muc where chaId = &#63; and ten = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param chaId the cha ID
	 * @param ten the ten
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc fetchByP_T(
		long chaId, String ten, boolean retrieveFromCache) {

		ten = Objects.toString(ten, "");

		Object[] finderArgs = new Object[] {chaId, ten};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByP_T, finderArgs, this);
		}

		if (result instanceof DanhMuc) {
			DanhMuc danhMuc = (DanhMuc)result;

			if ((chaId != danhMuc.getChaId()) ||
				!Objects.equals(ten, danhMuc.getTen())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_DANHMUC_WHERE);

			query.append(_FINDER_COLUMN_P_T_CHAID_2);

			boolean bindTen = false;

			if (ten.isEmpty()) {
				query.append(_FINDER_COLUMN_P_T_TEN_3);
			}
			else {
				bindTen = true;

				query.append(_FINDER_COLUMN_P_T_TEN_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(chaId);

				if (bindTen) {
					qPos.add(ten);
				}

				List<DanhMuc> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByP_T, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"DanhMucPersistenceImpl.fetchByP_T(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DanhMuc danhMuc = list.get(0);

					result = danhMuc;

					cacheResult(danhMuc);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(_finderPathFetchByP_T, finderArgs);

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
			return (DanhMuc)result;
		}
	}

	/**
	 * Removes the danh muc where chaId = &#63; and ten = &#63; from the database.
	 *
	 * @param chaId the cha ID
	 * @param ten the ten
	 * @return the danh muc that was removed
	 */
	@Override
	public DanhMuc removeByP_T(long chaId, String ten)
		throws NoSuchDanhMucException {

		DanhMuc danhMuc = findByP_T(chaId, ten);

		return remove(danhMuc);
	}

	/**
	 * Returns the number of danh mucs where chaId = &#63; and ten = &#63;.
	 *
	 * @param chaId the cha ID
	 * @param ten the ten
	 * @return the number of matching danh mucs
	 */
	@Override
	public int countByP_T(long chaId, String ten) {
		ten = Objects.toString(ten, "");

		FinderPath finderPath = _finderPathCountByP_T;

		Object[] finderArgs = new Object[] {chaId, ten};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DANHMUC_WHERE);

			query.append(_FINDER_COLUMN_P_T_CHAID_2);

			boolean bindTen = false;

			if (ten.isEmpty()) {
				query.append(_FINDER_COLUMN_P_T_TEN_3);
			}
			else {
				bindTen = true;

				query.append(_FINDER_COLUMN_P_T_TEN_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(chaId);

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

	private static final String _FINDER_COLUMN_P_T_CHAID_2 =
		"danhMuc.chaId = ? AND ";

	private static final String _FINDER_COLUMN_P_T_TEN_2 = "danhMuc.ten = ?";

	private static final String _FINDER_COLUMN_P_T_TEN_3 =
		"(danhMuc.ten IS NULL OR danhMuc.ten = '')";

	private FinderPath _finderPathWithPaginationFindByCha_TrangThai;
	private FinderPath _finderPathWithoutPaginationFindByCha_TrangThai;
	private FinderPath _finderPathCountByCha_TrangThai;

	/**
	 * Returns all the danh mucs where chaId = &#63; and trangThai = &#63;.
	 *
	 * @param chaId the cha ID
	 * @param trangThai the trang thai
	 * @return the matching danh mucs
	 */
	@Override
	public List<DanhMuc> findByCha_TrangThai(long chaId, boolean trangThai) {
		return findByCha_TrangThai(
			chaId, trangThai, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the danh mucs where chaId = &#63; and trangThai = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param chaId the cha ID
	 * @param trangThai the trang thai
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @return the range of matching danh mucs
	 */
	@Override
	public List<DanhMuc> findByCha_TrangThai(
		long chaId, boolean trangThai, int start, int end) {

		return findByCha_TrangThai(chaId, trangThai, start, end, null);
	}

	/**
	 * Returns an ordered range of all the danh mucs where chaId = &#63; and trangThai = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param chaId the cha ID
	 * @param trangThai the trang thai
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching danh mucs
	 */
	@Override
	public List<DanhMuc> findByCha_TrangThai(
		long chaId, boolean trangThai, int start, int end,
		OrderByComparator<DanhMuc> orderByComparator) {

		return findByCha_TrangThai(
			chaId, trangThai, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the danh mucs where chaId = &#63; and trangThai = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param chaId the cha ID
	 * @param trangThai the trang thai
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching danh mucs
	 */
	@Override
	public List<DanhMuc> findByCha_TrangThai(
		long chaId, boolean trangThai, int start, int end,
		OrderByComparator<DanhMuc> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByCha_TrangThai;
			finderArgs = new Object[] {chaId, trangThai};
		}
		else {
			finderPath = _finderPathWithPaginationFindByCha_TrangThai;
			finderArgs = new Object[] {
				chaId, trangThai, start, end, orderByComparator
			};
		}

		List<DanhMuc> list = null;

		if (retrieveFromCache) {
			list = (List<DanhMuc>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DanhMuc danhMuc : list) {
					if ((chaId != danhMuc.getChaId()) ||
						(trangThai != danhMuc.isTrangThai())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_DANHMUC_WHERE);

			query.append(_FINDER_COLUMN_CHA_TRANGTHAI_CHAID_2);

			query.append(_FINDER_COLUMN_CHA_TRANGTHAI_TRANGTHAI_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(DanhMucModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(chaId);

				qPos.add(trangThai);

				if (!pagination) {
					list = (List<DanhMuc>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DanhMuc>)QueryUtil.list(
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
	 * Returns the first danh muc in the ordered set where chaId = &#63; and trangThai = &#63;.
	 *
	 * @param chaId the cha ID
	 * @param trangThai the trang thai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc findByCha_TrangThai_First(
			long chaId, boolean trangThai,
			OrderByComparator<DanhMuc> orderByComparator)
		throws NoSuchDanhMucException {

		DanhMuc danhMuc = fetchByCha_TrangThai_First(
			chaId, trangThai, orderByComparator);

		if (danhMuc != null) {
			return danhMuc;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("chaId=");
		msg.append(chaId);

		msg.append(", trangThai=");
		msg.append(trangThai);

		msg.append("}");

		throw new NoSuchDanhMucException(msg.toString());
	}

	/**
	 * Returns the first danh muc in the ordered set where chaId = &#63; and trangThai = &#63;.
	 *
	 * @param chaId the cha ID
	 * @param trangThai the trang thai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc fetchByCha_TrangThai_First(
		long chaId, boolean trangThai,
		OrderByComparator<DanhMuc> orderByComparator) {

		List<DanhMuc> list = findByCha_TrangThai(
			chaId, trangThai, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last danh muc in the ordered set where chaId = &#63; and trangThai = &#63;.
	 *
	 * @param chaId the cha ID
	 * @param trangThai the trang thai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc findByCha_TrangThai_Last(
			long chaId, boolean trangThai,
			OrderByComparator<DanhMuc> orderByComparator)
		throws NoSuchDanhMucException {

		DanhMuc danhMuc = fetchByCha_TrangThai_Last(
			chaId, trangThai, orderByComparator);

		if (danhMuc != null) {
			return danhMuc;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("chaId=");
		msg.append(chaId);

		msg.append(", trangThai=");
		msg.append(trangThai);

		msg.append("}");

		throw new NoSuchDanhMucException(msg.toString());
	}

	/**
	 * Returns the last danh muc in the ordered set where chaId = &#63; and trangThai = &#63;.
	 *
	 * @param chaId the cha ID
	 * @param trangThai the trang thai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc fetchByCha_TrangThai_Last(
		long chaId, boolean trangThai,
		OrderByComparator<DanhMuc> orderByComparator) {

		int count = countByCha_TrangThai(chaId, trangThai);

		if (count == 0) {
			return null;
		}

		List<DanhMuc> list = findByCha_TrangThai(
			chaId, trangThai, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the danh mucs before and after the current danh muc in the ordered set where chaId = &#63; and trangThai = &#63;.
	 *
	 * @param id the primary key of the current danh muc
	 * @param chaId the cha ID
	 * @param trangThai the trang thai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next danh muc
	 * @throws NoSuchDanhMucException if a danh muc with the primary key could not be found
	 */
	@Override
	public DanhMuc[] findByCha_TrangThai_PrevAndNext(
			long id, long chaId, boolean trangThai,
			OrderByComparator<DanhMuc> orderByComparator)
		throws NoSuchDanhMucException {

		DanhMuc danhMuc = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			DanhMuc[] array = new DanhMucImpl[3];

			array[0] = getByCha_TrangThai_PrevAndNext(
				session, danhMuc, chaId, trangThai, orderByComparator, true);

			array[1] = danhMuc;

			array[2] = getByCha_TrangThai_PrevAndNext(
				session, danhMuc, chaId, trangThai, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DanhMuc getByCha_TrangThai_PrevAndNext(
		Session session, DanhMuc danhMuc, long chaId, boolean trangThai,
		OrderByComparator<DanhMuc> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_DANHMUC_WHERE);

		query.append(_FINDER_COLUMN_CHA_TRANGTHAI_CHAID_2);

		query.append(_FINDER_COLUMN_CHA_TRANGTHAI_TRANGTHAI_2);

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
			query.append(DanhMucModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(chaId);

		qPos.add(trangThai);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(danhMuc)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<DanhMuc> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the danh mucs where chaId = &#63; and trangThai = &#63; from the database.
	 *
	 * @param chaId the cha ID
	 * @param trangThai the trang thai
	 */
	@Override
	public void removeByCha_TrangThai(long chaId, boolean trangThai) {
		for (DanhMuc danhMuc :
				findByCha_TrangThai(
					chaId, trangThai, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(danhMuc);
		}
	}

	/**
	 * Returns the number of danh mucs where chaId = &#63; and trangThai = &#63;.
	 *
	 * @param chaId the cha ID
	 * @param trangThai the trang thai
	 * @return the number of matching danh mucs
	 */
	@Override
	public int countByCha_TrangThai(long chaId, boolean trangThai) {
		FinderPath finderPath = _finderPathCountByCha_TrangThai;

		Object[] finderArgs = new Object[] {chaId, trangThai};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DANHMUC_WHERE);

			query.append(_FINDER_COLUMN_CHA_TRANGTHAI_CHAID_2);

			query.append(_FINDER_COLUMN_CHA_TRANGTHAI_TRANGTHAI_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(chaId);

				qPos.add(trangThai);

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

	private static final String _FINDER_COLUMN_CHA_TRANGTHAI_CHAID_2 =
		"danhMuc.chaId = ? AND ";

	private static final String _FINDER_COLUMN_CHA_TRANGTHAI_TRANGTHAI_2 =
		"danhMuc.trangThai = ?";

	private FinderPath _finderPathWithPaginationFindByChaId;
	private FinderPath _finderPathWithoutPaginationFindByChaId;
	private FinderPath _finderPathCountByChaId;

	/**
	 * Returns all the danh mucs where chaId = &#63;.
	 *
	 * @param chaId the cha ID
	 * @return the matching danh mucs
	 */
	@Override
	public List<DanhMuc> findByChaId(long chaId) {
		return findByChaId(chaId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the danh mucs where chaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param chaId the cha ID
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @return the range of matching danh mucs
	 */
	@Override
	public List<DanhMuc> findByChaId(long chaId, int start, int end) {
		return findByChaId(chaId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the danh mucs where chaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param chaId the cha ID
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching danh mucs
	 */
	@Override
	public List<DanhMuc> findByChaId(
		long chaId, int start, int end,
		OrderByComparator<DanhMuc> orderByComparator) {

		return findByChaId(chaId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the danh mucs where chaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param chaId the cha ID
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching danh mucs
	 */
	@Override
	public List<DanhMuc> findByChaId(
		long chaId, int start, int end,
		OrderByComparator<DanhMuc> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByChaId;
			finderArgs = new Object[] {chaId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByChaId;
			finderArgs = new Object[] {chaId, start, end, orderByComparator};
		}

		List<DanhMuc> list = null;

		if (retrieveFromCache) {
			list = (List<DanhMuc>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DanhMuc danhMuc : list) {
					if ((chaId != danhMuc.getChaId())) {
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

			query.append(_SQL_SELECT_DANHMUC_WHERE);

			query.append(_FINDER_COLUMN_CHAID_CHAID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(DanhMucModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(chaId);

				if (!pagination) {
					list = (List<DanhMuc>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DanhMuc>)QueryUtil.list(
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
	 * Returns the first danh muc in the ordered set where chaId = &#63;.
	 *
	 * @param chaId the cha ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc findByChaId_First(
			long chaId, OrderByComparator<DanhMuc> orderByComparator)
		throws NoSuchDanhMucException {

		DanhMuc danhMuc = fetchByChaId_First(chaId, orderByComparator);

		if (danhMuc != null) {
			return danhMuc;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("chaId=");
		msg.append(chaId);

		msg.append("}");

		throw new NoSuchDanhMucException(msg.toString());
	}

	/**
	 * Returns the first danh muc in the ordered set where chaId = &#63;.
	 *
	 * @param chaId the cha ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc fetchByChaId_First(
		long chaId, OrderByComparator<DanhMuc> orderByComparator) {

		List<DanhMuc> list = findByChaId(chaId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last danh muc in the ordered set where chaId = &#63;.
	 *
	 * @param chaId the cha ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc findByChaId_Last(
			long chaId, OrderByComparator<DanhMuc> orderByComparator)
		throws NoSuchDanhMucException {

		DanhMuc danhMuc = fetchByChaId_Last(chaId, orderByComparator);

		if (danhMuc != null) {
			return danhMuc;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("chaId=");
		msg.append(chaId);

		msg.append("}");

		throw new NoSuchDanhMucException(msg.toString());
	}

	/**
	 * Returns the last danh muc in the ordered set where chaId = &#63;.
	 *
	 * @param chaId the cha ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc fetchByChaId_Last(
		long chaId, OrderByComparator<DanhMuc> orderByComparator) {

		int count = countByChaId(chaId);

		if (count == 0) {
			return null;
		}

		List<DanhMuc> list = findByChaId(
			chaId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the danh mucs before and after the current danh muc in the ordered set where chaId = &#63;.
	 *
	 * @param id the primary key of the current danh muc
	 * @param chaId the cha ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next danh muc
	 * @throws NoSuchDanhMucException if a danh muc with the primary key could not be found
	 */
	@Override
	public DanhMuc[] findByChaId_PrevAndNext(
			long id, long chaId, OrderByComparator<DanhMuc> orderByComparator)
		throws NoSuchDanhMucException {

		DanhMuc danhMuc = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			DanhMuc[] array = new DanhMucImpl[3];

			array[0] = getByChaId_PrevAndNext(
				session, danhMuc, chaId, orderByComparator, true);

			array[1] = danhMuc;

			array[2] = getByChaId_PrevAndNext(
				session, danhMuc, chaId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DanhMuc getByChaId_PrevAndNext(
		Session session, DanhMuc danhMuc, long chaId,
		OrderByComparator<DanhMuc> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DANHMUC_WHERE);

		query.append(_FINDER_COLUMN_CHAID_CHAID_2);

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
			query.append(DanhMucModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(chaId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(danhMuc)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<DanhMuc> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the danh mucs where chaId = &#63; from the database.
	 *
	 * @param chaId the cha ID
	 */
	@Override
	public void removeByChaId(long chaId) {
		for (DanhMuc danhMuc :
				findByChaId(
					chaId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(danhMuc);
		}
	}

	/**
	 * Returns the number of danh mucs where chaId = &#63;.
	 *
	 * @param chaId the cha ID
	 * @return the number of matching danh mucs
	 */
	@Override
	public int countByChaId(long chaId) {
		FinderPath finderPath = _finderPathCountByChaId;

		Object[] finderArgs = new Object[] {chaId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DANHMUC_WHERE);

			query.append(_FINDER_COLUMN_CHAID_CHAID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(chaId);

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

	private static final String _FINDER_COLUMN_CHAID_CHAID_2 =
		"danhMuc.chaId = ?";

	private FinderPath _finderPathWithPaginationFindByMUC;
	private FinderPath _finderPathWithoutPaginationFindByMUC;
	private FinderPath _finderPathCountByMUC;

	/**
	 * Returns all the danh mucs where muc = &#63;.
	 *
	 * @param muc the muc
	 * @return the matching danh mucs
	 */
	@Override
	public List<DanhMuc> findByMUC(int muc) {
		return findByMUC(muc, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the danh mucs where muc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param muc the muc
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @return the range of matching danh mucs
	 */
	@Override
	public List<DanhMuc> findByMUC(int muc, int start, int end) {
		return findByMUC(muc, start, end, null);
	}

	/**
	 * Returns an ordered range of all the danh mucs where muc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param muc the muc
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching danh mucs
	 */
	@Override
	public List<DanhMuc> findByMUC(
		int muc, int start, int end,
		OrderByComparator<DanhMuc> orderByComparator) {

		return findByMUC(muc, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the danh mucs where muc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param muc the muc
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching danh mucs
	 */
	@Override
	public List<DanhMuc> findByMUC(
		int muc, int start, int end,
		OrderByComparator<DanhMuc> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByMUC;
			finderArgs = new Object[] {muc};
		}
		else {
			finderPath = _finderPathWithPaginationFindByMUC;
			finderArgs = new Object[] {muc, start, end, orderByComparator};
		}

		List<DanhMuc> list = null;

		if (retrieveFromCache) {
			list = (List<DanhMuc>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DanhMuc danhMuc : list) {
					if ((muc != danhMuc.getMuc())) {
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

			query.append(_SQL_SELECT_DANHMUC_WHERE);

			query.append(_FINDER_COLUMN_MUC_MUC_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(DanhMucModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(muc);

				if (!pagination) {
					list = (List<DanhMuc>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DanhMuc>)QueryUtil.list(
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
	 * Returns the first danh muc in the ordered set where muc = &#63;.
	 *
	 * @param muc the muc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc findByMUC_First(
			int muc, OrderByComparator<DanhMuc> orderByComparator)
		throws NoSuchDanhMucException {

		DanhMuc danhMuc = fetchByMUC_First(muc, orderByComparator);

		if (danhMuc != null) {
			return danhMuc;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("muc=");
		msg.append(muc);

		msg.append("}");

		throw new NoSuchDanhMucException(msg.toString());
	}

	/**
	 * Returns the first danh muc in the ordered set where muc = &#63;.
	 *
	 * @param muc the muc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc fetchByMUC_First(
		int muc, OrderByComparator<DanhMuc> orderByComparator) {

		List<DanhMuc> list = findByMUC(muc, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last danh muc in the ordered set where muc = &#63;.
	 *
	 * @param muc the muc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc findByMUC_Last(
			int muc, OrderByComparator<DanhMuc> orderByComparator)
		throws NoSuchDanhMucException {

		DanhMuc danhMuc = fetchByMUC_Last(muc, orderByComparator);

		if (danhMuc != null) {
			return danhMuc;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("muc=");
		msg.append(muc);

		msg.append("}");

		throw new NoSuchDanhMucException(msg.toString());
	}

	/**
	 * Returns the last danh muc in the ordered set where muc = &#63;.
	 *
	 * @param muc the muc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc fetchByMUC_Last(
		int muc, OrderByComparator<DanhMuc> orderByComparator) {

		int count = countByMUC(muc);

		if (count == 0) {
			return null;
		}

		List<DanhMuc> list = findByMUC(
			muc, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the danh mucs before and after the current danh muc in the ordered set where muc = &#63;.
	 *
	 * @param id the primary key of the current danh muc
	 * @param muc the muc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next danh muc
	 * @throws NoSuchDanhMucException if a danh muc with the primary key could not be found
	 */
	@Override
	public DanhMuc[] findByMUC_PrevAndNext(
			long id, int muc, OrderByComparator<DanhMuc> orderByComparator)
		throws NoSuchDanhMucException {

		DanhMuc danhMuc = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			DanhMuc[] array = new DanhMucImpl[3];

			array[0] = getByMUC_PrevAndNext(
				session, danhMuc, muc, orderByComparator, true);

			array[1] = danhMuc;

			array[2] = getByMUC_PrevAndNext(
				session, danhMuc, muc, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DanhMuc getByMUC_PrevAndNext(
		Session session, DanhMuc danhMuc, int muc,
		OrderByComparator<DanhMuc> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DANHMUC_WHERE);

		query.append(_FINDER_COLUMN_MUC_MUC_2);

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
			query.append(DanhMucModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(muc);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(danhMuc)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<DanhMuc> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the danh mucs where muc = &#63; from the database.
	 *
	 * @param muc the muc
	 */
	@Override
	public void removeByMUC(int muc) {
		for (DanhMuc danhMuc :
				findByMUC(muc, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(danhMuc);
		}
	}

	/**
	 * Returns the number of danh mucs where muc = &#63;.
	 *
	 * @param muc the muc
	 * @return the number of matching danh mucs
	 */
	@Override
	public int countByMUC(int muc) {
		FinderPath finderPath = _finderPathCountByMUC;

		Object[] finderArgs = new Object[] {muc};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DANHMUC_WHERE);

			query.append(_FINDER_COLUMN_MUC_MUC_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(muc);

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

	private static final String _FINDER_COLUMN_MUC_MUC_2 = "danhMuc.muc = ?";

	private FinderPath _finderPathWithPaginationFindByNhomID;
	private FinderPath _finderPathWithoutPaginationFindByNhomID;
	private FinderPath _finderPathCountByNhomID;

	/**
	 * Returns all the danh mucs where nhomId = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @return the matching danh mucs
	 */
	@Override
	public List<DanhMuc> findByNhomID(long nhomId) {
		return findByNhomID(nhomId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the danh mucs where nhomId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nhomId the nhom ID
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @return the range of matching danh mucs
	 */
	@Override
	public List<DanhMuc> findByNhomID(long nhomId, int start, int end) {
		return findByNhomID(nhomId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the danh mucs where nhomId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nhomId the nhom ID
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching danh mucs
	 */
	@Override
	public List<DanhMuc> findByNhomID(
		long nhomId, int start, int end,
		OrderByComparator<DanhMuc> orderByComparator) {

		return findByNhomID(nhomId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the danh mucs where nhomId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nhomId the nhom ID
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching danh mucs
	 */
	@Override
	public List<DanhMuc> findByNhomID(
		long nhomId, int start, int end,
		OrderByComparator<DanhMuc> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByNhomID;
			finderArgs = new Object[] {nhomId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByNhomID;
			finderArgs = new Object[] {nhomId, start, end, orderByComparator};
		}

		List<DanhMuc> list = null;

		if (retrieveFromCache) {
			list = (List<DanhMuc>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DanhMuc danhMuc : list) {
					if ((nhomId != danhMuc.getNhomId())) {
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

			query.append(_SQL_SELECT_DANHMUC_WHERE);

			query.append(_FINDER_COLUMN_NHOMID_NHOMID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(DanhMucModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(nhomId);

				if (!pagination) {
					list = (List<DanhMuc>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DanhMuc>)QueryUtil.list(
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
	 * Returns the first danh muc in the ordered set where nhomId = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc findByNhomID_First(
			long nhomId, OrderByComparator<DanhMuc> orderByComparator)
		throws NoSuchDanhMucException {

		DanhMuc danhMuc = fetchByNhomID_First(nhomId, orderByComparator);

		if (danhMuc != null) {
			return danhMuc;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nhomId=");
		msg.append(nhomId);

		msg.append("}");

		throw new NoSuchDanhMucException(msg.toString());
	}

	/**
	 * Returns the first danh muc in the ordered set where nhomId = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc fetchByNhomID_First(
		long nhomId, OrderByComparator<DanhMuc> orderByComparator) {

		List<DanhMuc> list = findByNhomID(nhomId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last danh muc in the ordered set where nhomId = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc findByNhomID_Last(
			long nhomId, OrderByComparator<DanhMuc> orderByComparator)
		throws NoSuchDanhMucException {

		DanhMuc danhMuc = fetchByNhomID_Last(nhomId, orderByComparator);

		if (danhMuc != null) {
			return danhMuc;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nhomId=");
		msg.append(nhomId);

		msg.append("}");

		throw new NoSuchDanhMucException(msg.toString());
	}

	/**
	 * Returns the last danh muc in the ordered set where nhomId = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc fetchByNhomID_Last(
		long nhomId, OrderByComparator<DanhMuc> orderByComparator) {

		int count = countByNhomID(nhomId);

		if (count == 0) {
			return null;
		}

		List<DanhMuc> list = findByNhomID(
			nhomId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the danh mucs before and after the current danh muc in the ordered set where nhomId = &#63;.
	 *
	 * @param id the primary key of the current danh muc
	 * @param nhomId the nhom ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next danh muc
	 * @throws NoSuchDanhMucException if a danh muc with the primary key could not be found
	 */
	@Override
	public DanhMuc[] findByNhomID_PrevAndNext(
			long id, long nhomId, OrderByComparator<DanhMuc> orderByComparator)
		throws NoSuchDanhMucException {

		DanhMuc danhMuc = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			DanhMuc[] array = new DanhMucImpl[3];

			array[0] = getByNhomID_PrevAndNext(
				session, danhMuc, nhomId, orderByComparator, true);

			array[1] = danhMuc;

			array[2] = getByNhomID_PrevAndNext(
				session, danhMuc, nhomId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DanhMuc getByNhomID_PrevAndNext(
		Session session, DanhMuc danhMuc, long nhomId,
		OrderByComparator<DanhMuc> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DANHMUC_WHERE);

		query.append(_FINDER_COLUMN_NHOMID_NHOMID_2);

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
			query.append(DanhMucModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(nhomId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(danhMuc)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<DanhMuc> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the danh mucs where nhomId = &#63; from the database.
	 *
	 * @param nhomId the nhom ID
	 */
	@Override
	public void removeByNhomID(long nhomId) {
		for (DanhMuc danhMuc :
				findByNhomID(
					nhomId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(danhMuc);
		}
	}

	/**
	 * Returns the number of danh mucs where nhomId = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @return the number of matching danh mucs
	 */
	@Override
	public int countByNhomID(long nhomId) {
		FinderPath finderPath = _finderPathCountByNhomID;

		Object[] finderArgs = new Object[] {nhomId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DANHMUC_WHERE);

			query.append(_FINDER_COLUMN_NHOMID_NHOMID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(nhomId);

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

	private static final String _FINDER_COLUMN_NHOMID_NHOMID_2 =
		"danhMuc.nhomId = ?";

	private FinderPath _finderPathFetchByTT;
	private FinderPath _finderPathCountByTT;

	/**
	 * Returns the danh muc where thuTuHienThi = &#63; or throws a <code>NoSuchDanhMucException</code> if it could not be found.
	 *
	 * @param thuTuHienThi the thu tu hien thi
	 * @return the matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc findByTT(int thuTuHienThi) throws NoSuchDanhMucException {
		DanhMuc danhMuc = fetchByTT(thuTuHienThi);

		if (danhMuc == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("thuTuHienThi=");
			msg.append(thuTuHienThi);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchDanhMucException(msg.toString());
		}

		return danhMuc;
	}

	/**
	 * Returns the danh muc where thuTuHienThi = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param thuTuHienThi the thu tu hien thi
	 * @return the matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc fetchByTT(int thuTuHienThi) {
		return fetchByTT(thuTuHienThi, true);
	}

	/**
	 * Returns the danh muc where thuTuHienThi = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param thuTuHienThi the thu tu hien thi
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc fetchByTT(int thuTuHienThi, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] {thuTuHienThi};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByTT, finderArgs, this);
		}

		if (result instanceof DanhMuc) {
			DanhMuc danhMuc = (DanhMuc)result;

			if ((thuTuHienThi != danhMuc.getThuTuHienThi())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_DANHMUC_WHERE);

			query.append(_FINDER_COLUMN_TT_THUTUHIENTHI_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(thuTuHienThi);

				List<DanhMuc> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByTT, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"DanhMucPersistenceImpl.fetchByTT(int, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DanhMuc danhMuc = list.get(0);

					result = danhMuc;

					cacheResult(danhMuc);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(_finderPathFetchByTT, finderArgs);

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
			return (DanhMuc)result;
		}
	}

	/**
	 * Removes the danh muc where thuTuHienThi = &#63; from the database.
	 *
	 * @param thuTuHienThi the thu tu hien thi
	 * @return the danh muc that was removed
	 */
	@Override
	public DanhMuc removeByTT(int thuTuHienThi) throws NoSuchDanhMucException {
		DanhMuc danhMuc = findByTT(thuTuHienThi);

		return remove(danhMuc);
	}

	/**
	 * Returns the number of danh mucs where thuTuHienThi = &#63;.
	 *
	 * @param thuTuHienThi the thu tu hien thi
	 * @return the number of matching danh mucs
	 */
	@Override
	public int countByTT(int thuTuHienThi) {
		FinderPath finderPath = _finderPathCountByTT;

		Object[] finderArgs = new Object[] {thuTuHienThi};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DANHMUC_WHERE);

			query.append(_FINDER_COLUMN_TT_THUTUHIENTHI_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(thuTuHienThi);

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

	private static final String _FINDER_COLUMN_TT_THUTUHIENTHI_2 =
		"danhMuc.thuTuHienThi = ?";

	private FinderPath _finderPathWithPaginationFindByNhomId_TrangThai;
	private FinderPath _finderPathWithoutPaginationFindByNhomId_TrangThai;
	private FinderPath _finderPathCountByNhomId_TrangThai;

	/**
	 * Returns all the danh mucs where nhomId = &#63; and trangThai = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param trangThai the trang thai
	 * @return the matching danh mucs
	 */
	@Override
	public List<DanhMuc> findByNhomId_TrangThai(
		long nhomId, boolean trangThai) {

		return findByNhomId_TrangThai(
			nhomId, trangThai, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the danh mucs where nhomId = &#63; and trangThai = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nhomId the nhom ID
	 * @param trangThai the trang thai
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @return the range of matching danh mucs
	 */
	@Override
	public List<DanhMuc> findByNhomId_TrangThai(
		long nhomId, boolean trangThai, int start, int end) {

		return findByNhomId_TrangThai(nhomId, trangThai, start, end, null);
	}

	/**
	 * Returns an ordered range of all the danh mucs where nhomId = &#63; and trangThai = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nhomId the nhom ID
	 * @param trangThai the trang thai
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching danh mucs
	 */
	@Override
	public List<DanhMuc> findByNhomId_TrangThai(
		long nhomId, boolean trangThai, int start, int end,
		OrderByComparator<DanhMuc> orderByComparator) {

		return findByNhomId_TrangThai(
			nhomId, trangThai, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the danh mucs where nhomId = &#63; and trangThai = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nhomId the nhom ID
	 * @param trangThai the trang thai
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching danh mucs
	 */
	@Override
	public List<DanhMuc> findByNhomId_TrangThai(
		long nhomId, boolean trangThai, int start, int end,
		OrderByComparator<DanhMuc> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByNhomId_TrangThai;
			finderArgs = new Object[] {nhomId, trangThai};
		}
		else {
			finderPath = _finderPathWithPaginationFindByNhomId_TrangThai;
			finderArgs = new Object[] {
				nhomId, trangThai, start, end, orderByComparator
			};
		}

		List<DanhMuc> list = null;

		if (retrieveFromCache) {
			list = (List<DanhMuc>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DanhMuc danhMuc : list) {
					if ((nhomId != danhMuc.getNhomId()) ||
						(trangThai != danhMuc.isTrangThai())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_DANHMUC_WHERE);

			query.append(_FINDER_COLUMN_NHOMID_TRANGTHAI_NHOMID_2);

			query.append(_FINDER_COLUMN_NHOMID_TRANGTHAI_TRANGTHAI_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(DanhMucModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(nhomId);

				qPos.add(trangThai);

				if (!pagination) {
					list = (List<DanhMuc>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DanhMuc>)QueryUtil.list(
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
	 * Returns the first danh muc in the ordered set where nhomId = &#63; and trangThai = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param trangThai the trang thai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc findByNhomId_TrangThai_First(
			long nhomId, boolean trangThai,
			OrderByComparator<DanhMuc> orderByComparator)
		throws NoSuchDanhMucException {

		DanhMuc danhMuc = fetchByNhomId_TrangThai_First(
			nhomId, trangThai, orderByComparator);

		if (danhMuc != null) {
			return danhMuc;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nhomId=");
		msg.append(nhomId);

		msg.append(", trangThai=");
		msg.append(trangThai);

		msg.append("}");

		throw new NoSuchDanhMucException(msg.toString());
	}

	/**
	 * Returns the first danh muc in the ordered set where nhomId = &#63; and trangThai = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param trangThai the trang thai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc fetchByNhomId_TrangThai_First(
		long nhomId, boolean trangThai,
		OrderByComparator<DanhMuc> orderByComparator) {

		List<DanhMuc> list = findByNhomId_TrangThai(
			nhomId, trangThai, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last danh muc in the ordered set where nhomId = &#63; and trangThai = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param trangThai the trang thai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc findByNhomId_TrangThai_Last(
			long nhomId, boolean trangThai,
			OrderByComparator<DanhMuc> orderByComparator)
		throws NoSuchDanhMucException {

		DanhMuc danhMuc = fetchByNhomId_TrangThai_Last(
			nhomId, trangThai, orderByComparator);

		if (danhMuc != null) {
			return danhMuc;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nhomId=");
		msg.append(nhomId);

		msg.append(", trangThai=");
		msg.append(trangThai);

		msg.append("}");

		throw new NoSuchDanhMucException(msg.toString());
	}

	/**
	 * Returns the last danh muc in the ordered set where nhomId = &#63; and trangThai = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param trangThai the trang thai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc fetchByNhomId_TrangThai_Last(
		long nhomId, boolean trangThai,
		OrderByComparator<DanhMuc> orderByComparator) {

		int count = countByNhomId_TrangThai(nhomId, trangThai);

		if (count == 0) {
			return null;
		}

		List<DanhMuc> list = findByNhomId_TrangThai(
			nhomId, trangThai, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the danh mucs before and after the current danh muc in the ordered set where nhomId = &#63; and trangThai = &#63;.
	 *
	 * @param id the primary key of the current danh muc
	 * @param nhomId the nhom ID
	 * @param trangThai the trang thai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next danh muc
	 * @throws NoSuchDanhMucException if a danh muc with the primary key could not be found
	 */
	@Override
	public DanhMuc[] findByNhomId_TrangThai_PrevAndNext(
			long id, long nhomId, boolean trangThai,
			OrderByComparator<DanhMuc> orderByComparator)
		throws NoSuchDanhMucException {

		DanhMuc danhMuc = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			DanhMuc[] array = new DanhMucImpl[3];

			array[0] = getByNhomId_TrangThai_PrevAndNext(
				session, danhMuc, nhomId, trangThai, orderByComparator, true);

			array[1] = danhMuc;

			array[2] = getByNhomId_TrangThai_PrevAndNext(
				session, danhMuc, nhomId, trangThai, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DanhMuc getByNhomId_TrangThai_PrevAndNext(
		Session session, DanhMuc danhMuc, long nhomId, boolean trangThai,
		OrderByComparator<DanhMuc> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_DANHMUC_WHERE);

		query.append(_FINDER_COLUMN_NHOMID_TRANGTHAI_NHOMID_2);

		query.append(_FINDER_COLUMN_NHOMID_TRANGTHAI_TRANGTHAI_2);

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
			query.append(DanhMucModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(nhomId);

		qPos.add(trangThai);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(danhMuc)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<DanhMuc> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the danh mucs where nhomId = &#63; and trangThai = &#63; from the database.
	 *
	 * @param nhomId the nhom ID
	 * @param trangThai the trang thai
	 */
	@Override
	public void removeByNhomId_TrangThai(long nhomId, boolean trangThai) {
		for (DanhMuc danhMuc :
				findByNhomId_TrangThai(
					nhomId, trangThai, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(danhMuc);
		}
	}

	/**
	 * Returns the number of danh mucs where nhomId = &#63; and trangThai = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param trangThai the trang thai
	 * @return the number of matching danh mucs
	 */
	@Override
	public int countByNhomId_TrangThai(long nhomId, boolean trangThai) {
		FinderPath finderPath = _finderPathCountByNhomId_TrangThai;

		Object[] finderArgs = new Object[] {nhomId, trangThai};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DANHMUC_WHERE);

			query.append(_FINDER_COLUMN_NHOMID_TRANGTHAI_NHOMID_2);

			query.append(_FINDER_COLUMN_NHOMID_TRANGTHAI_TRANGTHAI_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(nhomId);

				qPos.add(trangThai);

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

	private static final String _FINDER_COLUMN_NHOMID_TRANGTHAI_NHOMID_2 =
		"danhMuc.nhomId = ? AND ";

	private static final String _FINDER_COLUMN_NHOMID_TRANGTHAI_TRANGTHAI_2 =
		"danhMuc.trangThai = ?";

	private FinderPath _finderPathFetchByMa_TrangThai;
	private FinderPath _finderPathCountByMa_TrangThai;

	/**
	 * Returns the danh muc where ma = &#63; and trangThai = &#63; or throws a <code>NoSuchDanhMucException</code> if it could not be found.
	 *
	 * @param ma the ma
	 * @param trangThai the trang thai
	 * @return the matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc findByMa_TrangThai(String ma, boolean trangThai)
		throws NoSuchDanhMucException {

		DanhMuc danhMuc = fetchByMa_TrangThai(ma, trangThai);

		if (danhMuc == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ma=");
			msg.append(ma);

			msg.append(", trangThai=");
			msg.append(trangThai);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchDanhMucException(msg.toString());
		}

		return danhMuc;
	}

	/**
	 * Returns the danh muc where ma = &#63; and trangThai = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ma the ma
	 * @param trangThai the trang thai
	 * @return the matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc fetchByMa_TrangThai(String ma, boolean trangThai) {
		return fetchByMa_TrangThai(ma, trangThai, true);
	}

	/**
	 * Returns the danh muc where ma = &#63; and trangThai = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ma the ma
	 * @param trangThai the trang thai
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc fetchByMa_TrangThai(
		String ma, boolean trangThai, boolean retrieveFromCache) {

		ma = Objects.toString(ma, "");

		Object[] finderArgs = new Object[] {ma, trangThai};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByMa_TrangThai, finderArgs, this);
		}

		if (result instanceof DanhMuc) {
			DanhMuc danhMuc = (DanhMuc)result;

			if (!Objects.equals(ma, danhMuc.getMa()) ||
				(trangThai != danhMuc.isTrangThai())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_DANHMUC_WHERE);

			boolean bindMa = false;

			if (ma.isEmpty()) {
				query.append(_FINDER_COLUMN_MA_TRANGTHAI_MA_3);
			}
			else {
				bindMa = true;

				query.append(_FINDER_COLUMN_MA_TRANGTHAI_MA_2);
			}

			query.append(_FINDER_COLUMN_MA_TRANGTHAI_TRANGTHAI_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindMa) {
					qPos.add(ma);
				}

				qPos.add(trangThai);

				List<DanhMuc> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByMa_TrangThai, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"DanhMucPersistenceImpl.fetchByMa_TrangThai(String, boolean, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DanhMuc danhMuc = list.get(0);

					result = danhMuc;

					cacheResult(danhMuc);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathFetchByMa_TrangThai, finderArgs);

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
			return (DanhMuc)result;
		}
	}

	/**
	 * Removes the danh muc where ma = &#63; and trangThai = &#63; from the database.
	 *
	 * @param ma the ma
	 * @param trangThai the trang thai
	 * @return the danh muc that was removed
	 */
	@Override
	public DanhMuc removeByMa_TrangThai(String ma, boolean trangThai)
		throws NoSuchDanhMucException {

		DanhMuc danhMuc = findByMa_TrangThai(ma, trangThai);

		return remove(danhMuc);
	}

	/**
	 * Returns the number of danh mucs where ma = &#63; and trangThai = &#63;.
	 *
	 * @param ma the ma
	 * @param trangThai the trang thai
	 * @return the number of matching danh mucs
	 */
	@Override
	public int countByMa_TrangThai(String ma, boolean trangThai) {
		ma = Objects.toString(ma, "");

		FinderPath finderPath = _finderPathCountByMa_TrangThai;

		Object[] finderArgs = new Object[] {ma, trangThai};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DANHMUC_WHERE);

			boolean bindMa = false;

			if (ma.isEmpty()) {
				query.append(_FINDER_COLUMN_MA_TRANGTHAI_MA_3);
			}
			else {
				bindMa = true;

				query.append(_FINDER_COLUMN_MA_TRANGTHAI_MA_2);
			}

			query.append(_FINDER_COLUMN_MA_TRANGTHAI_TRANGTHAI_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindMa) {
					qPos.add(ma);
				}

				qPos.add(trangThai);

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

	private static final String _FINDER_COLUMN_MA_TRANGTHAI_MA_2 =
		"danhMuc.ma = ? AND ";

	private static final String _FINDER_COLUMN_MA_TRANGTHAI_MA_3 =
		"(danhMuc.ma IS NULL OR danhMuc.ma = '') AND ";

	private static final String _FINDER_COLUMN_MA_TRANGTHAI_TRANGTHAI_2 =
		"danhMuc.trangThai = ?";

	private FinderPath _finderPathWithPaginationFindByMa_Muc;
	private FinderPath _finderPathWithoutPaginationFindByMa_Muc;
	private FinderPath _finderPathCountByMa_Muc;

	/**
	 * Returns all the danh mucs where ma = &#63; and muc = &#63;.
	 *
	 * @param ma the ma
	 * @param muc the muc
	 * @return the matching danh mucs
	 */
	@Override
	public List<DanhMuc> findByMa_Muc(String ma, int muc) {
		return findByMa_Muc(
			ma, muc, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the danh mucs where ma = &#63; and muc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ma the ma
	 * @param muc the muc
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @return the range of matching danh mucs
	 */
	@Override
	public List<DanhMuc> findByMa_Muc(String ma, int muc, int start, int end) {
		return findByMa_Muc(ma, muc, start, end, null);
	}

	/**
	 * Returns an ordered range of all the danh mucs where ma = &#63; and muc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ma the ma
	 * @param muc the muc
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching danh mucs
	 */
	@Override
	public List<DanhMuc> findByMa_Muc(
		String ma, int muc, int start, int end,
		OrderByComparator<DanhMuc> orderByComparator) {

		return findByMa_Muc(ma, muc, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the danh mucs where ma = &#63; and muc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ma the ma
	 * @param muc the muc
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching danh mucs
	 */
	@Override
	public List<DanhMuc> findByMa_Muc(
		String ma, int muc, int start, int end,
		OrderByComparator<DanhMuc> orderByComparator,
		boolean retrieveFromCache) {

		ma = Objects.toString(ma, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByMa_Muc;
			finderArgs = new Object[] {ma, muc};
		}
		else {
			finderPath = _finderPathWithPaginationFindByMa_Muc;
			finderArgs = new Object[] {ma, muc, start, end, orderByComparator};
		}

		List<DanhMuc> list = null;

		if (retrieveFromCache) {
			list = (List<DanhMuc>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DanhMuc danhMuc : list) {
					if (!ma.equals(danhMuc.getMa()) ||
						(muc != danhMuc.getMuc())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_DANHMUC_WHERE);

			boolean bindMa = false;

			if (ma.isEmpty()) {
				query.append(_FINDER_COLUMN_MA_MUC_MA_3);
			}
			else {
				bindMa = true;

				query.append(_FINDER_COLUMN_MA_MUC_MA_2);
			}

			query.append(_FINDER_COLUMN_MA_MUC_MUC_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(DanhMucModelImpl.ORDER_BY_JPQL);
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

				qPos.add(muc);

				if (!pagination) {
					list = (List<DanhMuc>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DanhMuc>)QueryUtil.list(
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
	 * Returns the first danh muc in the ordered set where ma = &#63; and muc = &#63;.
	 *
	 * @param ma the ma
	 * @param muc the muc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc findByMa_Muc_First(
			String ma, int muc, OrderByComparator<DanhMuc> orderByComparator)
		throws NoSuchDanhMucException {

		DanhMuc danhMuc = fetchByMa_Muc_First(ma, muc, orderByComparator);

		if (danhMuc != null) {
			return danhMuc;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ma=");
		msg.append(ma);

		msg.append(", muc=");
		msg.append(muc);

		msg.append("}");

		throw new NoSuchDanhMucException(msg.toString());
	}

	/**
	 * Returns the first danh muc in the ordered set where ma = &#63; and muc = &#63;.
	 *
	 * @param ma the ma
	 * @param muc the muc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc fetchByMa_Muc_First(
		String ma, int muc, OrderByComparator<DanhMuc> orderByComparator) {

		List<DanhMuc> list = findByMa_Muc(ma, muc, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last danh muc in the ordered set where ma = &#63; and muc = &#63;.
	 *
	 * @param ma the ma
	 * @param muc the muc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc findByMa_Muc_Last(
			String ma, int muc, OrderByComparator<DanhMuc> orderByComparator)
		throws NoSuchDanhMucException {

		DanhMuc danhMuc = fetchByMa_Muc_Last(ma, muc, orderByComparator);

		if (danhMuc != null) {
			return danhMuc;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ma=");
		msg.append(ma);

		msg.append(", muc=");
		msg.append(muc);

		msg.append("}");

		throw new NoSuchDanhMucException(msg.toString());
	}

	/**
	 * Returns the last danh muc in the ordered set where ma = &#63; and muc = &#63;.
	 *
	 * @param ma the ma
	 * @param muc the muc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc fetchByMa_Muc_Last(
		String ma, int muc, OrderByComparator<DanhMuc> orderByComparator) {

		int count = countByMa_Muc(ma, muc);

		if (count == 0) {
			return null;
		}

		List<DanhMuc> list = findByMa_Muc(
			ma, muc, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the danh mucs before and after the current danh muc in the ordered set where ma = &#63; and muc = &#63;.
	 *
	 * @param id the primary key of the current danh muc
	 * @param ma the ma
	 * @param muc the muc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next danh muc
	 * @throws NoSuchDanhMucException if a danh muc with the primary key could not be found
	 */
	@Override
	public DanhMuc[] findByMa_Muc_PrevAndNext(
			long id, String ma, int muc,
			OrderByComparator<DanhMuc> orderByComparator)
		throws NoSuchDanhMucException {

		ma = Objects.toString(ma, "");

		DanhMuc danhMuc = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			DanhMuc[] array = new DanhMucImpl[3];

			array[0] = getByMa_Muc_PrevAndNext(
				session, danhMuc, ma, muc, orderByComparator, true);

			array[1] = danhMuc;

			array[2] = getByMa_Muc_PrevAndNext(
				session, danhMuc, ma, muc, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DanhMuc getByMa_Muc_PrevAndNext(
		Session session, DanhMuc danhMuc, String ma, int muc,
		OrderByComparator<DanhMuc> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_DANHMUC_WHERE);

		boolean bindMa = false;

		if (ma.isEmpty()) {
			query.append(_FINDER_COLUMN_MA_MUC_MA_3);
		}
		else {
			bindMa = true;

			query.append(_FINDER_COLUMN_MA_MUC_MA_2);
		}

		query.append(_FINDER_COLUMN_MA_MUC_MUC_2);

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
			query.append(DanhMucModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindMa) {
			qPos.add(ma);
		}

		qPos.add(muc);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(danhMuc)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<DanhMuc> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the danh mucs where ma = &#63; and muc = &#63; from the database.
	 *
	 * @param ma the ma
	 * @param muc the muc
	 */
	@Override
	public void removeByMa_Muc(String ma, int muc) {
		for (DanhMuc danhMuc :
				findByMa_Muc(
					ma, muc, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(danhMuc);
		}
	}

	/**
	 * Returns the number of danh mucs where ma = &#63; and muc = &#63;.
	 *
	 * @param ma the ma
	 * @param muc the muc
	 * @return the number of matching danh mucs
	 */
	@Override
	public int countByMa_Muc(String ma, int muc) {
		ma = Objects.toString(ma, "");

		FinderPath finderPath = _finderPathCountByMa_Muc;

		Object[] finderArgs = new Object[] {ma, muc};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DANHMUC_WHERE);

			boolean bindMa = false;

			if (ma.isEmpty()) {
				query.append(_FINDER_COLUMN_MA_MUC_MA_3);
			}
			else {
				bindMa = true;

				query.append(_FINDER_COLUMN_MA_MUC_MA_2);
			}

			query.append(_FINDER_COLUMN_MA_MUC_MUC_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindMa) {
					qPos.add(ma);
				}

				qPos.add(muc);

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

	private static final String _FINDER_COLUMN_MA_MUC_MA_2 =
		"danhMuc.ma = ? AND ";

	private static final String _FINDER_COLUMN_MA_MUC_MA_3 =
		"(danhMuc.ma IS NULL OR danhMuc.ma = '') AND ";

	private static final String _FINDER_COLUMN_MA_MUC_MUC_2 = "danhMuc.muc = ?";

	private FinderPath _finderPathWithPaginationFindByChaId_Muc;
	private FinderPath _finderPathWithoutPaginationFindByChaId_Muc;
	private FinderPath _finderPathCountByChaId_Muc;

	/**
	 * Returns all the danh mucs where chaId = &#63; and muc = &#63; and trangThai = &#63;.
	 *
	 * @param chaId the cha ID
	 * @param muc the muc
	 * @param trangThai the trang thai
	 * @return the matching danh mucs
	 */
	@Override
	public List<DanhMuc> findByChaId_Muc(
		long chaId, int muc, boolean trangThai) {

		return findByChaId_Muc(
			chaId, muc, trangThai, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the danh mucs where chaId = &#63; and muc = &#63; and trangThai = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param chaId the cha ID
	 * @param muc the muc
	 * @param trangThai the trang thai
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @return the range of matching danh mucs
	 */
	@Override
	public List<DanhMuc> findByChaId_Muc(
		long chaId, int muc, boolean trangThai, int start, int end) {

		return findByChaId_Muc(chaId, muc, trangThai, start, end, null);
	}

	/**
	 * Returns an ordered range of all the danh mucs where chaId = &#63; and muc = &#63; and trangThai = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param chaId the cha ID
	 * @param muc the muc
	 * @param trangThai the trang thai
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching danh mucs
	 */
	@Override
	public List<DanhMuc> findByChaId_Muc(
		long chaId, int muc, boolean trangThai, int start, int end,
		OrderByComparator<DanhMuc> orderByComparator) {

		return findByChaId_Muc(
			chaId, muc, trangThai, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the danh mucs where chaId = &#63; and muc = &#63; and trangThai = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param chaId the cha ID
	 * @param muc the muc
	 * @param trangThai the trang thai
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching danh mucs
	 */
	@Override
	public List<DanhMuc> findByChaId_Muc(
		long chaId, int muc, boolean trangThai, int start, int end,
		OrderByComparator<DanhMuc> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByChaId_Muc;
			finderArgs = new Object[] {chaId, muc, trangThai};
		}
		else {
			finderPath = _finderPathWithPaginationFindByChaId_Muc;
			finderArgs = new Object[] {
				chaId, muc, trangThai, start, end, orderByComparator
			};
		}

		List<DanhMuc> list = null;

		if (retrieveFromCache) {
			list = (List<DanhMuc>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DanhMuc danhMuc : list) {
					if ((chaId != danhMuc.getChaId()) ||
						(muc != danhMuc.getMuc()) ||
						(trangThai != danhMuc.isTrangThai())) {

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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_DANHMUC_WHERE);

			query.append(_FINDER_COLUMN_CHAID_MUC_CHAID_2);

			query.append(_FINDER_COLUMN_CHAID_MUC_MUC_2);

			query.append(_FINDER_COLUMN_CHAID_MUC_TRANGTHAI_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(DanhMucModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(chaId);

				qPos.add(muc);

				qPos.add(trangThai);

				if (!pagination) {
					list = (List<DanhMuc>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DanhMuc>)QueryUtil.list(
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
	 * Returns the first danh muc in the ordered set where chaId = &#63; and muc = &#63; and trangThai = &#63;.
	 *
	 * @param chaId the cha ID
	 * @param muc the muc
	 * @param trangThai the trang thai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc findByChaId_Muc_First(
			long chaId, int muc, boolean trangThai,
			OrderByComparator<DanhMuc> orderByComparator)
		throws NoSuchDanhMucException {

		DanhMuc danhMuc = fetchByChaId_Muc_First(
			chaId, muc, trangThai, orderByComparator);

		if (danhMuc != null) {
			return danhMuc;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("chaId=");
		msg.append(chaId);

		msg.append(", muc=");
		msg.append(muc);

		msg.append(", trangThai=");
		msg.append(trangThai);

		msg.append("}");

		throw new NoSuchDanhMucException(msg.toString());
	}

	/**
	 * Returns the first danh muc in the ordered set where chaId = &#63; and muc = &#63; and trangThai = &#63;.
	 *
	 * @param chaId the cha ID
	 * @param muc the muc
	 * @param trangThai the trang thai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc fetchByChaId_Muc_First(
		long chaId, int muc, boolean trangThai,
		OrderByComparator<DanhMuc> orderByComparator) {

		List<DanhMuc> list = findByChaId_Muc(
			chaId, muc, trangThai, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last danh muc in the ordered set where chaId = &#63; and muc = &#63; and trangThai = &#63;.
	 *
	 * @param chaId the cha ID
	 * @param muc the muc
	 * @param trangThai the trang thai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc findByChaId_Muc_Last(
			long chaId, int muc, boolean trangThai,
			OrderByComparator<DanhMuc> orderByComparator)
		throws NoSuchDanhMucException {

		DanhMuc danhMuc = fetchByChaId_Muc_Last(
			chaId, muc, trangThai, orderByComparator);

		if (danhMuc != null) {
			return danhMuc;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("chaId=");
		msg.append(chaId);

		msg.append(", muc=");
		msg.append(muc);

		msg.append(", trangThai=");
		msg.append(trangThai);

		msg.append("}");

		throw new NoSuchDanhMucException(msg.toString());
	}

	/**
	 * Returns the last danh muc in the ordered set where chaId = &#63; and muc = &#63; and trangThai = &#63;.
	 *
	 * @param chaId the cha ID
	 * @param muc the muc
	 * @param trangThai the trang thai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc fetchByChaId_Muc_Last(
		long chaId, int muc, boolean trangThai,
		OrderByComparator<DanhMuc> orderByComparator) {

		int count = countByChaId_Muc(chaId, muc, trangThai);

		if (count == 0) {
			return null;
		}

		List<DanhMuc> list = findByChaId_Muc(
			chaId, muc, trangThai, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the danh mucs before and after the current danh muc in the ordered set where chaId = &#63; and muc = &#63; and trangThai = &#63;.
	 *
	 * @param id the primary key of the current danh muc
	 * @param chaId the cha ID
	 * @param muc the muc
	 * @param trangThai the trang thai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next danh muc
	 * @throws NoSuchDanhMucException if a danh muc with the primary key could not be found
	 */
	@Override
	public DanhMuc[] findByChaId_Muc_PrevAndNext(
			long id, long chaId, int muc, boolean trangThai,
			OrderByComparator<DanhMuc> orderByComparator)
		throws NoSuchDanhMucException {

		DanhMuc danhMuc = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			DanhMuc[] array = new DanhMucImpl[3];

			array[0] = getByChaId_Muc_PrevAndNext(
				session, danhMuc, chaId, muc, trangThai, orderByComparator,
				true);

			array[1] = danhMuc;

			array[2] = getByChaId_Muc_PrevAndNext(
				session, danhMuc, chaId, muc, trangThai, orderByComparator,
				false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DanhMuc getByChaId_Muc_PrevAndNext(
		Session session, DanhMuc danhMuc, long chaId, int muc,
		boolean trangThai, OrderByComparator<DanhMuc> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_DANHMUC_WHERE);

		query.append(_FINDER_COLUMN_CHAID_MUC_CHAID_2);

		query.append(_FINDER_COLUMN_CHAID_MUC_MUC_2);

		query.append(_FINDER_COLUMN_CHAID_MUC_TRANGTHAI_2);

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
			query.append(DanhMucModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(chaId);

		qPos.add(muc);

		qPos.add(trangThai);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(danhMuc)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<DanhMuc> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the danh mucs where chaId = &#63; and muc = &#63; and trangThai = &#63; from the database.
	 *
	 * @param chaId the cha ID
	 * @param muc the muc
	 * @param trangThai the trang thai
	 */
	@Override
	public void removeByChaId_Muc(long chaId, int muc, boolean trangThai) {
		for (DanhMuc danhMuc :
				findByChaId_Muc(
					chaId, muc, trangThai, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(danhMuc);
		}
	}

	/**
	 * Returns the number of danh mucs where chaId = &#63; and muc = &#63; and trangThai = &#63;.
	 *
	 * @param chaId the cha ID
	 * @param muc the muc
	 * @param trangThai the trang thai
	 * @return the number of matching danh mucs
	 */
	@Override
	public int countByChaId_Muc(long chaId, int muc, boolean trangThai) {
		FinderPath finderPath = _finderPathCountByChaId_Muc;

		Object[] finderArgs = new Object[] {chaId, muc, trangThai};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_DANHMUC_WHERE);

			query.append(_FINDER_COLUMN_CHAID_MUC_CHAID_2);

			query.append(_FINDER_COLUMN_CHAID_MUC_MUC_2);

			query.append(_FINDER_COLUMN_CHAID_MUC_TRANGTHAI_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(chaId);

				qPos.add(muc);

				qPos.add(trangThai);

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

	private static final String _FINDER_COLUMN_CHAID_MUC_CHAID_2 =
		"danhMuc.chaId = ? AND ";

	private static final String _FINDER_COLUMN_CHAID_MUC_MUC_2 =
		"danhMuc.muc = ? AND ";

	private static final String _FINDER_COLUMN_CHAID_MUC_TRANGTHAI_2 =
		"danhMuc.trangThai = ?";

	private FinderPath _finderPathWithPaginationFindByNhomId_Muc_TrangThai;
	private FinderPath _finderPathWithoutPaginationFindByNhomId_Muc_TrangThai;
	private FinderPath _finderPathCountByNhomId_Muc_TrangThai;

	/**
	 * Returns all the danh mucs where nhomId = &#63; and muc = &#63; and trangThai = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param trangThai the trang thai
	 * @return the matching danh mucs
	 */
	@Override
	public List<DanhMuc> findByNhomId_Muc_TrangThai(
		long nhomId, int muc, boolean trangThai) {

		return findByNhomId_Muc_TrangThai(
			nhomId, muc, trangThai, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the danh mucs where nhomId = &#63; and muc = &#63; and trangThai = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param trangThai the trang thai
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @return the range of matching danh mucs
	 */
	@Override
	public List<DanhMuc> findByNhomId_Muc_TrangThai(
		long nhomId, int muc, boolean trangThai, int start, int end) {

		return findByNhomId_Muc_TrangThai(
			nhomId, muc, trangThai, start, end, null);
	}

	/**
	 * Returns an ordered range of all the danh mucs where nhomId = &#63; and muc = &#63; and trangThai = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param trangThai the trang thai
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching danh mucs
	 */
	@Override
	public List<DanhMuc> findByNhomId_Muc_TrangThai(
		long nhomId, int muc, boolean trangThai, int start, int end,
		OrderByComparator<DanhMuc> orderByComparator) {

		return findByNhomId_Muc_TrangThai(
			nhomId, muc, trangThai, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the danh mucs where nhomId = &#63; and muc = &#63; and trangThai = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param trangThai the trang thai
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching danh mucs
	 */
	@Override
	public List<DanhMuc> findByNhomId_Muc_TrangThai(
		long nhomId, int muc, boolean trangThai, int start, int end,
		OrderByComparator<DanhMuc> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByNhomId_Muc_TrangThai;
			finderArgs = new Object[] {nhomId, muc, trangThai};
		}
		else {
			finderPath = _finderPathWithPaginationFindByNhomId_Muc_TrangThai;
			finderArgs = new Object[] {
				nhomId, muc, trangThai, start, end, orderByComparator
			};
		}

		List<DanhMuc> list = null;

		if (retrieveFromCache) {
			list = (List<DanhMuc>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DanhMuc danhMuc : list) {
					if ((nhomId != danhMuc.getNhomId()) ||
						(muc != danhMuc.getMuc()) ||
						(trangThai != danhMuc.isTrangThai())) {

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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_DANHMUC_WHERE);

			query.append(_FINDER_COLUMN_NHOMID_MUC_TRANGTHAI_NHOMID_2);

			query.append(_FINDER_COLUMN_NHOMID_MUC_TRANGTHAI_MUC_2);

			query.append(_FINDER_COLUMN_NHOMID_MUC_TRANGTHAI_TRANGTHAI_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(DanhMucModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(nhomId);

				qPos.add(muc);

				qPos.add(trangThai);

				if (!pagination) {
					list = (List<DanhMuc>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DanhMuc>)QueryUtil.list(
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
	 * Returns the first danh muc in the ordered set where nhomId = &#63; and muc = &#63; and trangThai = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param trangThai the trang thai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc findByNhomId_Muc_TrangThai_First(
			long nhomId, int muc, boolean trangThai,
			OrderByComparator<DanhMuc> orderByComparator)
		throws NoSuchDanhMucException {

		DanhMuc danhMuc = fetchByNhomId_Muc_TrangThai_First(
			nhomId, muc, trangThai, orderByComparator);

		if (danhMuc != null) {
			return danhMuc;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nhomId=");
		msg.append(nhomId);

		msg.append(", muc=");
		msg.append(muc);

		msg.append(", trangThai=");
		msg.append(trangThai);

		msg.append("}");

		throw new NoSuchDanhMucException(msg.toString());
	}

	/**
	 * Returns the first danh muc in the ordered set where nhomId = &#63; and muc = &#63; and trangThai = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param trangThai the trang thai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc fetchByNhomId_Muc_TrangThai_First(
		long nhomId, int muc, boolean trangThai,
		OrderByComparator<DanhMuc> orderByComparator) {

		List<DanhMuc> list = findByNhomId_Muc_TrangThai(
			nhomId, muc, trangThai, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last danh muc in the ordered set where nhomId = &#63; and muc = &#63; and trangThai = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param trangThai the trang thai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc findByNhomId_Muc_TrangThai_Last(
			long nhomId, int muc, boolean trangThai,
			OrderByComparator<DanhMuc> orderByComparator)
		throws NoSuchDanhMucException {

		DanhMuc danhMuc = fetchByNhomId_Muc_TrangThai_Last(
			nhomId, muc, trangThai, orderByComparator);

		if (danhMuc != null) {
			return danhMuc;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nhomId=");
		msg.append(nhomId);

		msg.append(", muc=");
		msg.append(muc);

		msg.append(", trangThai=");
		msg.append(trangThai);

		msg.append("}");

		throw new NoSuchDanhMucException(msg.toString());
	}

	/**
	 * Returns the last danh muc in the ordered set where nhomId = &#63; and muc = &#63; and trangThai = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param trangThai the trang thai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc fetchByNhomId_Muc_TrangThai_Last(
		long nhomId, int muc, boolean trangThai,
		OrderByComparator<DanhMuc> orderByComparator) {

		int count = countByNhomId_Muc_TrangThai(nhomId, muc, trangThai);

		if (count == 0) {
			return null;
		}

		List<DanhMuc> list = findByNhomId_Muc_TrangThai(
			nhomId, muc, trangThai, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the danh mucs before and after the current danh muc in the ordered set where nhomId = &#63; and muc = &#63; and trangThai = &#63;.
	 *
	 * @param id the primary key of the current danh muc
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param trangThai the trang thai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next danh muc
	 * @throws NoSuchDanhMucException if a danh muc with the primary key could not be found
	 */
	@Override
	public DanhMuc[] findByNhomId_Muc_TrangThai_PrevAndNext(
			long id, long nhomId, int muc, boolean trangThai,
			OrderByComparator<DanhMuc> orderByComparator)
		throws NoSuchDanhMucException {

		DanhMuc danhMuc = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			DanhMuc[] array = new DanhMucImpl[3];

			array[0] = getByNhomId_Muc_TrangThai_PrevAndNext(
				session, danhMuc, nhomId, muc, trangThai, orderByComparator,
				true);

			array[1] = danhMuc;

			array[2] = getByNhomId_Muc_TrangThai_PrevAndNext(
				session, danhMuc, nhomId, muc, trangThai, orderByComparator,
				false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DanhMuc getByNhomId_Muc_TrangThai_PrevAndNext(
		Session session, DanhMuc danhMuc, long nhomId, int muc,
		boolean trangThai, OrderByComparator<DanhMuc> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_DANHMUC_WHERE);

		query.append(_FINDER_COLUMN_NHOMID_MUC_TRANGTHAI_NHOMID_2);

		query.append(_FINDER_COLUMN_NHOMID_MUC_TRANGTHAI_MUC_2);

		query.append(_FINDER_COLUMN_NHOMID_MUC_TRANGTHAI_TRANGTHAI_2);

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
			query.append(DanhMucModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(nhomId);

		qPos.add(muc);

		qPos.add(trangThai);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(danhMuc)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<DanhMuc> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the danh mucs where nhomId = &#63; and muc = &#63; and trangThai = &#63; from the database.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param trangThai the trang thai
	 */
	@Override
	public void removeByNhomId_Muc_TrangThai(
		long nhomId, int muc, boolean trangThai) {

		for (DanhMuc danhMuc :
				findByNhomId_Muc_TrangThai(
					nhomId, muc, trangThai, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(danhMuc);
		}
	}

	/**
	 * Returns the number of danh mucs where nhomId = &#63; and muc = &#63; and trangThai = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param trangThai the trang thai
	 * @return the number of matching danh mucs
	 */
	@Override
	public int countByNhomId_Muc_TrangThai(
		long nhomId, int muc, boolean trangThai) {

		FinderPath finderPath = _finderPathCountByNhomId_Muc_TrangThai;

		Object[] finderArgs = new Object[] {nhomId, muc, trangThai};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_DANHMUC_WHERE);

			query.append(_FINDER_COLUMN_NHOMID_MUC_TRANGTHAI_NHOMID_2);

			query.append(_FINDER_COLUMN_NHOMID_MUC_TRANGTHAI_MUC_2);

			query.append(_FINDER_COLUMN_NHOMID_MUC_TRANGTHAI_TRANGTHAI_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(nhomId);

				qPos.add(muc);

				qPos.add(trangThai);

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

	private static final String _FINDER_COLUMN_NHOMID_MUC_TRANGTHAI_NHOMID_2 =
		"danhMuc.nhomId = ? AND ";

	private static final String _FINDER_COLUMN_NHOMID_MUC_TRANGTHAI_MUC_2 =
		"danhMuc.muc = ? AND ";

	private static final String
		_FINDER_COLUMN_NHOMID_MUC_TRANGTHAI_TRANGTHAI_2 =
			"danhMuc.trangThai = ?";

	private FinderPath _finderPathFetchByNhomId_Muc_Ten_TrangThai;
	private FinderPath _finderPathCountByNhomId_Muc_Ten_TrangThai;

	/**
	 * Returns the danh muc where nhomId = &#63; and muc = &#63; and ten = &#63; and trangThai = &#63; or throws a <code>NoSuchDanhMucException</code> if it could not be found.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param ten the ten
	 * @param trangThai the trang thai
	 * @return the matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc findByNhomId_Muc_Ten_TrangThai(
			long nhomId, int muc, String ten, boolean trangThai)
		throws NoSuchDanhMucException {

		DanhMuc danhMuc = fetchByNhomId_Muc_Ten_TrangThai(
			nhomId, muc, ten, trangThai);

		if (danhMuc == null) {
			StringBundler msg = new StringBundler(10);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("nhomId=");
			msg.append(nhomId);

			msg.append(", muc=");
			msg.append(muc);

			msg.append(", ten=");
			msg.append(ten);

			msg.append(", trangThai=");
			msg.append(trangThai);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchDanhMucException(msg.toString());
		}

		return danhMuc;
	}

	/**
	 * Returns the danh muc where nhomId = &#63; and muc = &#63; and ten = &#63; and trangThai = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param ten the ten
	 * @param trangThai the trang thai
	 * @return the matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc fetchByNhomId_Muc_Ten_TrangThai(
		long nhomId, int muc, String ten, boolean trangThai) {

		return fetchByNhomId_Muc_Ten_TrangThai(
			nhomId, muc, ten, trangThai, true);
	}

	/**
	 * Returns the danh muc where nhomId = &#63; and muc = &#63; and ten = &#63; and trangThai = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param ten the ten
	 * @param trangThai the trang thai
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc fetchByNhomId_Muc_Ten_TrangThai(
		long nhomId, int muc, String ten, boolean trangThai,
		boolean retrieveFromCache) {

		ten = Objects.toString(ten, "");

		Object[] finderArgs = new Object[] {nhomId, muc, ten, trangThai};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByNhomId_Muc_Ten_TrangThai, finderArgs, this);
		}

		if (result instanceof DanhMuc) {
			DanhMuc danhMuc = (DanhMuc)result;

			if ((nhomId != danhMuc.getNhomId()) || (muc != danhMuc.getMuc()) ||
				!Objects.equals(ten, danhMuc.getTen()) ||
				(trangThai != danhMuc.isTrangThai())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(6);

			query.append(_SQL_SELECT_DANHMUC_WHERE);

			query.append(_FINDER_COLUMN_NHOMID_MUC_TEN_TRANGTHAI_NHOMID_2);

			query.append(_FINDER_COLUMN_NHOMID_MUC_TEN_TRANGTHAI_MUC_2);

			boolean bindTen = false;

			if (ten.isEmpty()) {
				query.append(_FINDER_COLUMN_NHOMID_MUC_TEN_TRANGTHAI_TEN_3);
			}
			else {
				bindTen = true;

				query.append(_FINDER_COLUMN_NHOMID_MUC_TEN_TRANGTHAI_TEN_2);
			}

			query.append(_FINDER_COLUMN_NHOMID_MUC_TEN_TRANGTHAI_TRANGTHAI_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(nhomId);

				qPos.add(muc);

				if (bindTen) {
					qPos.add(ten);
				}

				qPos.add(trangThai);

				List<DanhMuc> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByNhomId_Muc_Ten_TrangThai, finderArgs,
						list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"DanhMucPersistenceImpl.fetchByNhomId_Muc_Ten_TrangThai(long, int, String, boolean, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DanhMuc danhMuc = list.get(0);

					result = danhMuc;

					cacheResult(danhMuc);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathFetchByNhomId_Muc_Ten_TrangThai, finderArgs);

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
			return (DanhMuc)result;
		}
	}

	/**
	 * Removes the danh muc where nhomId = &#63; and muc = &#63; and ten = &#63; and trangThai = &#63; from the database.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param ten the ten
	 * @param trangThai the trang thai
	 * @return the danh muc that was removed
	 */
	@Override
	public DanhMuc removeByNhomId_Muc_Ten_TrangThai(
			long nhomId, int muc, String ten, boolean trangThai)
		throws NoSuchDanhMucException {

		DanhMuc danhMuc = findByNhomId_Muc_Ten_TrangThai(
			nhomId, muc, ten, trangThai);

		return remove(danhMuc);
	}

	/**
	 * Returns the number of danh mucs where nhomId = &#63; and muc = &#63; and ten = &#63; and trangThai = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param ten the ten
	 * @param trangThai the trang thai
	 * @return the number of matching danh mucs
	 */
	@Override
	public int countByNhomId_Muc_Ten_TrangThai(
		long nhomId, int muc, String ten, boolean trangThai) {

		ten = Objects.toString(ten, "");

		FinderPath finderPath = _finderPathCountByNhomId_Muc_Ten_TrangThai;

		Object[] finderArgs = new Object[] {nhomId, muc, ten, trangThai};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_DANHMUC_WHERE);

			query.append(_FINDER_COLUMN_NHOMID_MUC_TEN_TRANGTHAI_NHOMID_2);

			query.append(_FINDER_COLUMN_NHOMID_MUC_TEN_TRANGTHAI_MUC_2);

			boolean bindTen = false;

			if (ten.isEmpty()) {
				query.append(_FINDER_COLUMN_NHOMID_MUC_TEN_TRANGTHAI_TEN_3);
			}
			else {
				bindTen = true;

				query.append(_FINDER_COLUMN_NHOMID_MUC_TEN_TRANGTHAI_TEN_2);
			}

			query.append(_FINDER_COLUMN_NHOMID_MUC_TEN_TRANGTHAI_TRANGTHAI_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(nhomId);

				qPos.add(muc);

				if (bindTen) {
					qPos.add(ten);
				}

				qPos.add(trangThai);

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

	private static final String
		_FINDER_COLUMN_NHOMID_MUC_TEN_TRANGTHAI_NHOMID_2 =
			"danhMuc.nhomId = ? AND ";

	private static final String _FINDER_COLUMN_NHOMID_MUC_TEN_TRANGTHAI_MUC_2 =
		"danhMuc.muc = ? AND ";

	private static final String _FINDER_COLUMN_NHOMID_MUC_TEN_TRANGTHAI_TEN_2 =
		"danhMuc.ten = ? AND ";

	private static final String _FINDER_COLUMN_NHOMID_MUC_TEN_TRANGTHAI_TEN_3 =
		"(danhMuc.ten IS NULL OR danhMuc.ten = '') AND ";

	private static final String
		_FINDER_COLUMN_NHOMID_MUC_TEN_TRANGTHAI_TRANGTHAI_2 =
			"danhMuc.trangThai = ?";

	private FinderPath _finderPathFetchByNhomId_Muc_Ma_TrangThai;
	private FinderPath _finderPathCountByNhomId_Muc_Ma_TrangThai;

	/**
	 * Returns the danh muc where nhomId = &#63; and muc = &#63; and ma = &#63; and trangThai = &#63; or throws a <code>NoSuchDanhMucException</code> if it could not be found.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param ma the ma
	 * @param trangThai the trang thai
	 * @return the matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc findByNhomId_Muc_Ma_TrangThai(
			long nhomId, int muc, String ma, boolean trangThai)
		throws NoSuchDanhMucException {

		DanhMuc danhMuc = fetchByNhomId_Muc_Ma_TrangThai(
			nhomId, muc, ma, trangThai);

		if (danhMuc == null) {
			StringBundler msg = new StringBundler(10);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("nhomId=");
			msg.append(nhomId);

			msg.append(", muc=");
			msg.append(muc);

			msg.append(", ma=");
			msg.append(ma);

			msg.append(", trangThai=");
			msg.append(trangThai);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchDanhMucException(msg.toString());
		}

		return danhMuc;
	}

	/**
	 * Returns the danh muc where nhomId = &#63; and muc = &#63; and ma = &#63; and trangThai = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param ma the ma
	 * @param trangThai the trang thai
	 * @return the matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc fetchByNhomId_Muc_Ma_TrangThai(
		long nhomId, int muc, String ma, boolean trangThai) {

		return fetchByNhomId_Muc_Ma_TrangThai(nhomId, muc, ma, trangThai, true);
	}

	/**
	 * Returns the danh muc where nhomId = &#63; and muc = &#63; and ma = &#63; and trangThai = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param ma the ma
	 * @param trangThai the trang thai
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc fetchByNhomId_Muc_Ma_TrangThai(
		long nhomId, int muc, String ma, boolean trangThai,
		boolean retrieveFromCache) {

		ma = Objects.toString(ma, "");

		Object[] finderArgs = new Object[] {nhomId, muc, ma, trangThai};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByNhomId_Muc_Ma_TrangThai, finderArgs, this);
		}

		if (result instanceof DanhMuc) {
			DanhMuc danhMuc = (DanhMuc)result;

			if ((nhomId != danhMuc.getNhomId()) || (muc != danhMuc.getMuc()) ||
				!Objects.equals(ma, danhMuc.getMa()) ||
				(trangThai != danhMuc.isTrangThai())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(6);

			query.append(_SQL_SELECT_DANHMUC_WHERE);

			query.append(_FINDER_COLUMN_NHOMID_MUC_MA_TRANGTHAI_NHOMID_2);

			query.append(_FINDER_COLUMN_NHOMID_MUC_MA_TRANGTHAI_MUC_2);

			boolean bindMa = false;

			if (ma.isEmpty()) {
				query.append(_FINDER_COLUMN_NHOMID_MUC_MA_TRANGTHAI_MA_3);
			}
			else {
				bindMa = true;

				query.append(_FINDER_COLUMN_NHOMID_MUC_MA_TRANGTHAI_MA_2);
			}

			query.append(_FINDER_COLUMN_NHOMID_MUC_MA_TRANGTHAI_TRANGTHAI_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(nhomId);

				qPos.add(muc);

				if (bindMa) {
					qPos.add(ma);
				}

				qPos.add(trangThai);

				List<DanhMuc> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByNhomId_Muc_Ma_TrangThai, finderArgs,
						list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"DanhMucPersistenceImpl.fetchByNhomId_Muc_Ma_TrangThai(long, int, String, boolean, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DanhMuc danhMuc = list.get(0);

					result = danhMuc;

					cacheResult(danhMuc);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathFetchByNhomId_Muc_Ma_TrangThai, finderArgs);

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
			return (DanhMuc)result;
		}
	}

	/**
	 * Removes the danh muc where nhomId = &#63; and muc = &#63; and ma = &#63; and trangThai = &#63; from the database.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param ma the ma
	 * @param trangThai the trang thai
	 * @return the danh muc that was removed
	 */
	@Override
	public DanhMuc removeByNhomId_Muc_Ma_TrangThai(
			long nhomId, int muc, String ma, boolean trangThai)
		throws NoSuchDanhMucException {

		DanhMuc danhMuc = findByNhomId_Muc_Ma_TrangThai(
			nhomId, muc, ma, trangThai);

		return remove(danhMuc);
	}

	/**
	 * Returns the number of danh mucs where nhomId = &#63; and muc = &#63; and ma = &#63; and trangThai = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param ma the ma
	 * @param trangThai the trang thai
	 * @return the number of matching danh mucs
	 */
	@Override
	public int countByNhomId_Muc_Ma_TrangThai(
		long nhomId, int muc, String ma, boolean trangThai) {

		ma = Objects.toString(ma, "");

		FinderPath finderPath = _finderPathCountByNhomId_Muc_Ma_TrangThai;

		Object[] finderArgs = new Object[] {nhomId, muc, ma, trangThai};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_DANHMUC_WHERE);

			query.append(_FINDER_COLUMN_NHOMID_MUC_MA_TRANGTHAI_NHOMID_2);

			query.append(_FINDER_COLUMN_NHOMID_MUC_MA_TRANGTHAI_MUC_2);

			boolean bindMa = false;

			if (ma.isEmpty()) {
				query.append(_FINDER_COLUMN_NHOMID_MUC_MA_TRANGTHAI_MA_3);
			}
			else {
				bindMa = true;

				query.append(_FINDER_COLUMN_NHOMID_MUC_MA_TRANGTHAI_MA_2);
			}

			query.append(_FINDER_COLUMN_NHOMID_MUC_MA_TRANGTHAI_TRANGTHAI_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(nhomId);

				qPos.add(muc);

				if (bindMa) {
					qPos.add(ma);
				}

				qPos.add(trangThai);

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

	private static final String
		_FINDER_COLUMN_NHOMID_MUC_MA_TRANGTHAI_NHOMID_2 =
			"danhMuc.nhomId = ? AND ";

	private static final String _FINDER_COLUMN_NHOMID_MUC_MA_TRANGTHAI_MUC_2 =
		"danhMuc.muc = ? AND ";

	private static final String _FINDER_COLUMN_NHOMID_MUC_MA_TRANGTHAI_MA_2 =
		"danhMuc.ma = ? AND ";

	private static final String _FINDER_COLUMN_NHOMID_MUC_MA_TRANGTHAI_MA_3 =
		"(danhMuc.ma IS NULL OR danhMuc.ma = '') AND ";

	private static final String
		_FINDER_COLUMN_NHOMID_MUC_MA_TRANGTHAI_TRANGTHAI_2 =
			"danhMuc.trangThai = ?";

	private FinderPath _finderPathWithPaginationFindByIds;
	private FinderPath _finderPathWithoutPaginationFindByIds;
	private FinderPath _finderPathCountByIds;
	private FinderPath _finderPathWithPaginationCountByIds;

	/**
	 * Returns all the danh mucs where id = &#63;.
	 *
	 * @param id the ID
	 * @return the matching danh mucs
	 */
	@Override
	public List<DanhMuc> findByIds(long id) {
		return findByIds(id, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the danh mucs where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @return the range of matching danh mucs
	 */
	@Override
	public List<DanhMuc> findByIds(long id, int start, int end) {
		return findByIds(id, start, end, null);
	}

	/**
	 * Returns an ordered range of all the danh mucs where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching danh mucs
	 */
	@Override
	public List<DanhMuc> findByIds(
		long id, int start, int end,
		OrderByComparator<DanhMuc> orderByComparator) {

		return findByIds(id, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the danh mucs where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching danh mucs
	 */
	@Override
	public List<DanhMuc> findByIds(
		long id, int start, int end,
		OrderByComparator<DanhMuc> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByIds;
			finderArgs = new Object[] {id};
		}
		else {
			finderPath = _finderPathWithPaginationFindByIds;
			finderArgs = new Object[] {id, start, end, orderByComparator};
		}

		List<DanhMuc> list = null;

		if (retrieveFromCache) {
			list = (List<DanhMuc>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DanhMuc danhMuc : list) {
					if ((id != danhMuc.getId())) {
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

			query.append(_SQL_SELECT_DANHMUC_WHERE);

			query.append(_FINDER_COLUMN_IDS_ID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(DanhMucModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id);

				if (!pagination) {
					list = (List<DanhMuc>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DanhMuc>)QueryUtil.list(
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
	 * Returns the first danh muc in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc findByIds_First(
			long id, OrderByComparator<DanhMuc> orderByComparator)
		throws NoSuchDanhMucException {

		DanhMuc danhMuc = fetchByIds_First(id, orderByComparator);

		if (danhMuc != null) {
			return danhMuc;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id=");
		msg.append(id);

		msg.append("}");

		throw new NoSuchDanhMucException(msg.toString());
	}

	/**
	 * Returns the first danh muc in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc fetchByIds_First(
		long id, OrderByComparator<DanhMuc> orderByComparator) {

		List<DanhMuc> list = findByIds(id, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last danh muc in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc findByIds_Last(
			long id, OrderByComparator<DanhMuc> orderByComparator)
		throws NoSuchDanhMucException {

		DanhMuc danhMuc = fetchByIds_Last(id, orderByComparator);

		if (danhMuc != null) {
			return danhMuc;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id=");
		msg.append(id);

		msg.append("}");

		throw new NoSuchDanhMucException(msg.toString());
	}

	/**
	 * Returns the last danh muc in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc fetchByIds_Last(
		long id, OrderByComparator<DanhMuc> orderByComparator) {

		int count = countByIds(id);

		if (count == 0) {
			return null;
		}

		List<DanhMuc> list = findByIds(id, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns all the danh mucs where id = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ids the IDs
	 * @return the matching danh mucs
	 */
	@Override
	public List<DanhMuc> findByIds(long[] ids) {
		return findByIds(ids, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the danh mucs where id = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ids the IDs
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @return the range of matching danh mucs
	 */
	@Override
	public List<DanhMuc> findByIds(long[] ids, int start, int end) {
		return findByIds(ids, start, end, null);
	}

	/**
	 * Returns an ordered range of all the danh mucs where id = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ids the IDs
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching danh mucs
	 */
	@Override
	public List<DanhMuc> findByIds(
		long[] ids, int start, int end,
		OrderByComparator<DanhMuc> orderByComparator) {

		return findByIds(ids, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the danh mucs where id = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching danh mucs
	 */
	@Override
	public List<DanhMuc> findByIds(
		long[] ids, int start, int end,
		OrderByComparator<DanhMuc> orderByComparator,
		boolean retrieveFromCache) {

		if (ids == null) {
			ids = new long[0];
		}
		else if (ids.length > 1) {
			ids = ArrayUtil.unique(ids);

			Arrays.sort(ids);
		}

		if (ids.length == 1) {
			return findByIds(ids[0], start, end, orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderArgs = new Object[] {StringUtil.merge(ids)};
		}
		else {
			finderArgs = new Object[] {
				StringUtil.merge(ids), start, end, orderByComparator
			};
		}

		List<DanhMuc> list = null;

		if (retrieveFromCache) {
			list = (List<DanhMuc>)finderCache.getResult(
				_finderPathWithPaginationFindByIds, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DanhMuc danhMuc : list) {
					if (!ArrayUtil.contains(ids, danhMuc.getId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_DANHMUC_WHERE);

			if (ids.length > 0) {
				query.append("(");

				query.append(_FINDER_COLUMN_IDS_ID_7);

				query.append(StringUtil.merge(ids));

				query.append(")");

				query.append(")");
			}

			query.setStringAt(
				removeConjunction(query.stringAt(query.index() - 1)),
				query.index() - 1);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(DanhMucModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DanhMuc>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DanhMuc>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(
					_finderPathWithPaginationFindByIds, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathWithPaginationFindByIds, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the danh mucs where id = &#63; from the database.
	 *
	 * @param id the ID
	 */
	@Override
	public void removeByIds(long id) {
		for (DanhMuc danhMuc :
				findByIds(id, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(danhMuc);
		}
	}

	/**
	 * Returns the number of danh mucs where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching danh mucs
	 */
	@Override
	public int countByIds(long id) {
		FinderPath finderPath = _finderPathCountByIds;

		Object[] finderArgs = new Object[] {id};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DANHMUC_WHERE);

			query.append(_FINDER_COLUMN_IDS_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id);

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

	/**
	 * Returns the number of danh mucs where id = any &#63;.
	 *
	 * @param ids the IDs
	 * @return the number of matching danh mucs
	 */
	@Override
	public int countByIds(long[] ids) {
		if (ids == null) {
			ids = new long[0];
		}
		else if (ids.length > 1) {
			ids = ArrayUtil.unique(ids);

			Arrays.sort(ids);
		}

		Object[] finderArgs = new Object[] {StringUtil.merge(ids)};

		Long count = (Long)finderCache.getResult(
			_finderPathWithPaginationCountByIds, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_DANHMUC_WHERE);

			if (ids.length > 0) {
				query.append("(");

				query.append(_FINDER_COLUMN_IDS_ID_7);

				query.append(StringUtil.merge(ids));

				query.append(")");

				query.append(")");
			}

			query.setStringAt(
				removeConjunction(query.stringAt(query.index() - 1)),
				query.index() - 1);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathWithPaginationCountByIds, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathWithPaginationCountByIds, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_IDS_ID_2 = "danhMuc.id = ?";

	private static final String _FINDER_COLUMN_IDS_ID_7 = "danhMuc.id IN (";

	private FinderPath _finderPathWithPaginationFindByNhomId_Muc;
	private FinderPath _finderPathWithoutPaginationFindByNhomId_Muc;
	private FinderPath _finderPathCountByNhomId_Muc;

	/**
	 * Returns all the danh mucs where nhomId = &#63; and muc = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @return the matching danh mucs
	 */
	@Override
	public List<DanhMuc> findByNhomId_Muc(long nhomId, int muc) {
		return findByNhomId_Muc(
			nhomId, muc, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the danh mucs where nhomId = &#63; and muc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @return the range of matching danh mucs
	 */
	@Override
	public List<DanhMuc> findByNhomId_Muc(
		long nhomId, int muc, int start, int end) {

		return findByNhomId_Muc(nhomId, muc, start, end, null);
	}

	/**
	 * Returns an ordered range of all the danh mucs where nhomId = &#63; and muc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching danh mucs
	 */
	@Override
	public List<DanhMuc> findByNhomId_Muc(
		long nhomId, int muc, int start, int end,
		OrderByComparator<DanhMuc> orderByComparator) {

		return findByNhomId_Muc(
			nhomId, muc, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the danh mucs where nhomId = &#63; and muc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching danh mucs
	 */
	@Override
	public List<DanhMuc> findByNhomId_Muc(
		long nhomId, int muc, int start, int end,
		OrderByComparator<DanhMuc> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByNhomId_Muc;
			finderArgs = new Object[] {nhomId, muc};
		}
		else {
			finderPath = _finderPathWithPaginationFindByNhomId_Muc;
			finderArgs = new Object[] {
				nhomId, muc, start, end, orderByComparator
			};
		}

		List<DanhMuc> list = null;

		if (retrieveFromCache) {
			list = (List<DanhMuc>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DanhMuc danhMuc : list) {
					if ((nhomId != danhMuc.getNhomId()) ||
						(muc != danhMuc.getMuc())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_DANHMUC_WHERE);

			query.append(_FINDER_COLUMN_NHOMID_MUC_NHOMID_2);

			query.append(_FINDER_COLUMN_NHOMID_MUC_MUC_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(DanhMucModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(nhomId);

				qPos.add(muc);

				if (!pagination) {
					list = (List<DanhMuc>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DanhMuc>)QueryUtil.list(
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
	 * Returns the first danh muc in the ordered set where nhomId = &#63; and muc = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc findByNhomId_Muc_First(
			long nhomId, int muc, OrderByComparator<DanhMuc> orderByComparator)
		throws NoSuchDanhMucException {

		DanhMuc danhMuc = fetchByNhomId_Muc_First(
			nhomId, muc, orderByComparator);

		if (danhMuc != null) {
			return danhMuc;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nhomId=");
		msg.append(nhomId);

		msg.append(", muc=");
		msg.append(muc);

		msg.append("}");

		throw new NoSuchDanhMucException(msg.toString());
	}

	/**
	 * Returns the first danh muc in the ordered set where nhomId = &#63; and muc = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc fetchByNhomId_Muc_First(
		long nhomId, int muc, OrderByComparator<DanhMuc> orderByComparator) {

		List<DanhMuc> list = findByNhomId_Muc(
			nhomId, muc, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last danh muc in the ordered set where nhomId = &#63; and muc = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc findByNhomId_Muc_Last(
			long nhomId, int muc, OrderByComparator<DanhMuc> orderByComparator)
		throws NoSuchDanhMucException {

		DanhMuc danhMuc = fetchByNhomId_Muc_Last(
			nhomId, muc, orderByComparator);

		if (danhMuc != null) {
			return danhMuc;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nhomId=");
		msg.append(nhomId);

		msg.append(", muc=");
		msg.append(muc);

		msg.append("}");

		throw new NoSuchDanhMucException(msg.toString());
	}

	/**
	 * Returns the last danh muc in the ordered set where nhomId = &#63; and muc = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc fetchByNhomId_Muc_Last(
		long nhomId, int muc, OrderByComparator<DanhMuc> orderByComparator) {

		int count = countByNhomId_Muc(nhomId, muc);

		if (count == 0) {
			return null;
		}

		List<DanhMuc> list = findByNhomId_Muc(
			nhomId, muc, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the danh mucs before and after the current danh muc in the ordered set where nhomId = &#63; and muc = &#63;.
	 *
	 * @param id the primary key of the current danh muc
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next danh muc
	 * @throws NoSuchDanhMucException if a danh muc with the primary key could not be found
	 */
	@Override
	public DanhMuc[] findByNhomId_Muc_PrevAndNext(
			long id, long nhomId, int muc,
			OrderByComparator<DanhMuc> orderByComparator)
		throws NoSuchDanhMucException {

		DanhMuc danhMuc = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			DanhMuc[] array = new DanhMucImpl[3];

			array[0] = getByNhomId_Muc_PrevAndNext(
				session, danhMuc, nhomId, muc, orderByComparator, true);

			array[1] = danhMuc;

			array[2] = getByNhomId_Muc_PrevAndNext(
				session, danhMuc, nhomId, muc, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DanhMuc getByNhomId_Muc_PrevAndNext(
		Session session, DanhMuc danhMuc, long nhomId, int muc,
		OrderByComparator<DanhMuc> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_DANHMUC_WHERE);

		query.append(_FINDER_COLUMN_NHOMID_MUC_NHOMID_2);

		query.append(_FINDER_COLUMN_NHOMID_MUC_MUC_2);

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
			query.append(DanhMucModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(nhomId);

		qPos.add(muc);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(danhMuc)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<DanhMuc> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the danh mucs where nhomId = &#63; and muc = &#63; from the database.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 */
	@Override
	public void removeByNhomId_Muc(long nhomId, int muc) {
		for (DanhMuc danhMuc :
				findByNhomId_Muc(
					nhomId, muc, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(danhMuc);
		}
	}

	/**
	 * Returns the number of danh mucs where nhomId = &#63; and muc = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @return the number of matching danh mucs
	 */
	@Override
	public int countByNhomId_Muc(long nhomId, int muc) {
		FinderPath finderPath = _finderPathCountByNhomId_Muc;

		Object[] finderArgs = new Object[] {nhomId, muc};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DANHMUC_WHERE);

			query.append(_FINDER_COLUMN_NHOMID_MUC_NHOMID_2);

			query.append(_FINDER_COLUMN_NHOMID_MUC_MUC_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(nhomId);

				qPos.add(muc);

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

	private static final String _FINDER_COLUMN_NHOMID_MUC_NHOMID_2 =
		"danhMuc.nhomId = ? AND ";

	private static final String _FINDER_COLUMN_NHOMID_MUC_MUC_2 =
		"danhMuc.muc = ?";

	private FinderPath _finderPathFetchByNhomId_Ma;
	private FinderPath _finderPathCountByNhomId_Ma;

	/**
	 * Returns the danh muc where nhomId = &#63; and ma = &#63; or throws a <code>NoSuchDanhMucException</code> if it could not be found.
	 *
	 * @param nhomId the nhom ID
	 * @param ma the ma
	 * @return the matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc findByNhomId_Ma(long nhomId, String ma)
		throws NoSuchDanhMucException {

		DanhMuc danhMuc = fetchByNhomId_Ma(nhomId, ma);

		if (danhMuc == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("nhomId=");
			msg.append(nhomId);

			msg.append(", ma=");
			msg.append(ma);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchDanhMucException(msg.toString());
		}

		return danhMuc;
	}

	/**
	 * Returns the danh muc where nhomId = &#63; and ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nhomId the nhom ID
	 * @param ma the ma
	 * @return the matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc fetchByNhomId_Ma(long nhomId, String ma) {
		return fetchByNhomId_Ma(nhomId, ma, true);
	}

	/**
	 * Returns the danh muc where nhomId = &#63; and ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nhomId the nhom ID
	 * @param ma the ma
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	@Override
	public DanhMuc fetchByNhomId_Ma(
		long nhomId, String ma, boolean retrieveFromCache) {

		ma = Objects.toString(ma, "");

		Object[] finderArgs = new Object[] {nhomId, ma};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByNhomId_Ma, finderArgs, this);
		}

		if (result instanceof DanhMuc) {
			DanhMuc danhMuc = (DanhMuc)result;

			if ((nhomId != danhMuc.getNhomId()) ||
				!Objects.equals(ma, danhMuc.getMa())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_DANHMUC_WHERE);

			query.append(_FINDER_COLUMN_NHOMID_MA_NHOMID_2);

			boolean bindMa = false;

			if (ma.isEmpty()) {
				query.append(_FINDER_COLUMN_NHOMID_MA_MA_3);
			}
			else {
				bindMa = true;

				query.append(_FINDER_COLUMN_NHOMID_MA_MA_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(nhomId);

				if (bindMa) {
					qPos.add(ma);
				}

				List<DanhMuc> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByNhomId_Ma, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"DanhMucPersistenceImpl.fetchByNhomId_Ma(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DanhMuc danhMuc = list.get(0);

					result = danhMuc;

					cacheResult(danhMuc);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathFetchByNhomId_Ma, finderArgs);

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
			return (DanhMuc)result;
		}
	}

	/**
	 * Removes the danh muc where nhomId = &#63; and ma = &#63; from the database.
	 *
	 * @param nhomId the nhom ID
	 * @param ma the ma
	 * @return the danh muc that was removed
	 */
	@Override
	public DanhMuc removeByNhomId_Ma(long nhomId, String ma)
		throws NoSuchDanhMucException {

		DanhMuc danhMuc = findByNhomId_Ma(nhomId, ma);

		return remove(danhMuc);
	}

	/**
	 * Returns the number of danh mucs where nhomId = &#63; and ma = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param ma the ma
	 * @return the number of matching danh mucs
	 */
	@Override
	public int countByNhomId_Ma(long nhomId, String ma) {
		ma = Objects.toString(ma, "");

		FinderPath finderPath = _finderPathCountByNhomId_Ma;

		Object[] finderArgs = new Object[] {nhomId, ma};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DANHMUC_WHERE);

			query.append(_FINDER_COLUMN_NHOMID_MA_NHOMID_2);

			boolean bindMa = false;

			if (ma.isEmpty()) {
				query.append(_FINDER_COLUMN_NHOMID_MA_MA_3);
			}
			else {
				bindMa = true;

				query.append(_FINDER_COLUMN_NHOMID_MA_MA_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(nhomId);

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

	private static final String _FINDER_COLUMN_NHOMID_MA_NHOMID_2 =
		"danhMuc.nhomId = ? AND ";

	private static final String _FINDER_COLUMN_NHOMID_MA_MA_2 =
		"danhMuc.ma = ?";

	private static final String _FINDER_COLUMN_NHOMID_MA_MA_3 =
		"(danhMuc.ma IS NULL OR danhMuc.ma = '')";

	public DanhMucPersistenceImpl() {
		setModelClass(DanhMuc.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("nhomId", "nhom_id");
		dbColumnNames.put("ten", "TEN");
		dbColumnNames.put("moTa", "mota");
		dbColumnNames.put("chaId", "cha_id");
		dbColumnNames.put("thuTuHienThi", "thutu_hienthi");
		dbColumnNames.put("maGiaPha", "ma_giapha");
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
	 * Caches the danh muc in the entity cache if it is enabled.
	 *
	 * @param danhMuc the danh muc
	 */
	@Override
	public void cacheResult(DanhMuc danhMuc) {
		entityCache.putResult(
			DanhMucModelImpl.ENTITY_CACHE_ENABLED, DanhMucImpl.class,
			danhMuc.getPrimaryKey(), danhMuc);

		finderCache.putResult(
			_finderPathFetchByM, new Object[] {danhMuc.getMa()}, danhMuc);

		finderCache.putResult(
			_finderPathFetchByT, new Object[] {danhMuc.getTen()}, danhMuc);

		finderCache.putResult(
			_finderPathFetchByP_T,
			new Object[] {danhMuc.getChaId(), danhMuc.getTen()}, danhMuc);

		finderCache.putResult(
			_finderPathFetchByTT, new Object[] {danhMuc.getThuTuHienThi()},
			danhMuc);

		finderCache.putResult(
			_finderPathFetchByMa_TrangThai,
			new Object[] {danhMuc.getMa(), danhMuc.isTrangThai()}, danhMuc);

		finderCache.putResult(
			_finderPathFetchByNhomId_Muc_Ten_TrangThai,
			new Object[] {
				danhMuc.getNhomId(), danhMuc.getMuc(), danhMuc.getTen(),
				danhMuc.isTrangThai()
			},
			danhMuc);

		finderCache.putResult(
			_finderPathFetchByNhomId_Muc_Ma_TrangThai,
			new Object[] {
				danhMuc.getNhomId(), danhMuc.getMuc(), danhMuc.getMa(),
				danhMuc.isTrangThai()
			},
			danhMuc);

		finderCache.putResult(
			_finderPathFetchByNhomId_Ma,
			new Object[] {danhMuc.getNhomId(), danhMuc.getMa()}, danhMuc);

		danhMuc.resetOriginalValues();
	}

	/**
	 * Caches the danh mucs in the entity cache if it is enabled.
	 *
	 * @param danhMucs the danh mucs
	 */
	@Override
	public void cacheResult(List<DanhMuc> danhMucs) {
		for (DanhMuc danhMuc : danhMucs) {
			if (entityCache.getResult(
					DanhMucModelImpl.ENTITY_CACHE_ENABLED, DanhMucImpl.class,
					danhMuc.getPrimaryKey()) == null) {

				cacheResult(danhMuc);
			}
			else {
				danhMuc.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all danh mucs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DanhMucImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the danh muc.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DanhMuc danhMuc) {
		entityCache.removeResult(
			DanhMucModelImpl.ENTITY_CACHE_ENABLED, DanhMucImpl.class,
			danhMuc.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((DanhMucModelImpl)danhMuc, true);
	}

	@Override
	public void clearCache(List<DanhMuc> danhMucs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DanhMuc danhMuc : danhMucs) {
			entityCache.removeResult(
				DanhMucModelImpl.ENTITY_CACHE_ENABLED, DanhMucImpl.class,
				danhMuc.getPrimaryKey());

			clearUniqueFindersCache((DanhMucModelImpl)danhMuc, true);
		}
	}

	protected void cacheUniqueFindersCache(DanhMucModelImpl danhMucModelImpl) {
		Object[] args = new Object[] {danhMucModelImpl.getMa()};

		finderCache.putResult(
			_finderPathCountByM, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByM, args, danhMucModelImpl, false);

		args = new Object[] {danhMucModelImpl.getTen()};

		finderCache.putResult(
			_finderPathCountByT, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByT, args, danhMucModelImpl, false);

		args = new Object[] {
			danhMucModelImpl.getChaId(), danhMucModelImpl.getTen()
		};

		finderCache.putResult(
			_finderPathCountByP_T, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByP_T, args, danhMucModelImpl, false);

		args = new Object[] {danhMucModelImpl.getThuTuHienThi()};

		finderCache.putResult(
			_finderPathCountByTT, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByTT, args, danhMucModelImpl, false);

		args = new Object[] {
			danhMucModelImpl.getMa(), danhMucModelImpl.isTrangThai()
		};

		finderCache.putResult(
			_finderPathCountByMa_TrangThai, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByMa_TrangThai, args, danhMucModelImpl, false);

		args = new Object[] {
			danhMucModelImpl.getNhomId(), danhMucModelImpl.getMuc(),
			danhMucModelImpl.getTen(), danhMucModelImpl.isTrangThai()
		};

		finderCache.putResult(
			_finderPathCountByNhomId_Muc_Ten_TrangThai, args, Long.valueOf(1),
			false);
		finderCache.putResult(
			_finderPathFetchByNhomId_Muc_Ten_TrangThai, args, danhMucModelImpl,
			false);

		args = new Object[] {
			danhMucModelImpl.getNhomId(), danhMucModelImpl.getMuc(),
			danhMucModelImpl.getMa(), danhMucModelImpl.isTrangThai()
		};

		finderCache.putResult(
			_finderPathCountByNhomId_Muc_Ma_TrangThai, args, Long.valueOf(1),
			false);
		finderCache.putResult(
			_finderPathFetchByNhomId_Muc_Ma_TrangThai, args, danhMucModelImpl,
			false);

		args = new Object[] {
			danhMucModelImpl.getNhomId(), danhMucModelImpl.getMa()
		};

		finderCache.putResult(
			_finderPathCountByNhomId_Ma, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByNhomId_Ma, args, danhMucModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		DanhMucModelImpl danhMucModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {danhMucModelImpl.getMa()};

			finderCache.removeResult(_finderPathCountByM, args);
			finderCache.removeResult(_finderPathFetchByM, args);
		}

		if ((danhMucModelImpl.getColumnBitmask() &
			 _finderPathFetchByM.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {danhMucModelImpl.getOriginalMa()};

			finderCache.removeResult(_finderPathCountByM, args);
			finderCache.removeResult(_finderPathFetchByM, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {danhMucModelImpl.getTen()};

			finderCache.removeResult(_finderPathCountByT, args);
			finderCache.removeResult(_finderPathFetchByT, args);
		}

		if ((danhMucModelImpl.getColumnBitmask() &
			 _finderPathFetchByT.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {danhMucModelImpl.getOriginalTen()};

			finderCache.removeResult(_finderPathCountByT, args);
			finderCache.removeResult(_finderPathFetchByT, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				danhMucModelImpl.getChaId(), danhMucModelImpl.getTen()
			};

			finderCache.removeResult(_finderPathCountByP_T, args);
			finderCache.removeResult(_finderPathFetchByP_T, args);
		}

		if ((danhMucModelImpl.getColumnBitmask() &
			 _finderPathFetchByP_T.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				danhMucModelImpl.getOriginalChaId(),
				danhMucModelImpl.getOriginalTen()
			};

			finderCache.removeResult(_finderPathCountByP_T, args);
			finderCache.removeResult(_finderPathFetchByP_T, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {danhMucModelImpl.getThuTuHienThi()};

			finderCache.removeResult(_finderPathCountByTT, args);
			finderCache.removeResult(_finderPathFetchByTT, args);
		}

		if ((danhMucModelImpl.getColumnBitmask() &
			 _finderPathFetchByTT.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				danhMucModelImpl.getOriginalThuTuHienThi()
			};

			finderCache.removeResult(_finderPathCountByTT, args);
			finderCache.removeResult(_finderPathFetchByTT, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				danhMucModelImpl.getMa(), danhMucModelImpl.isTrangThai()
			};

			finderCache.removeResult(_finderPathCountByMa_TrangThai, args);
			finderCache.removeResult(_finderPathFetchByMa_TrangThai, args);
		}

		if ((danhMucModelImpl.getColumnBitmask() &
			 _finderPathFetchByMa_TrangThai.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				danhMucModelImpl.getOriginalMa(),
				danhMucModelImpl.getOriginalTrangThai()
			};

			finderCache.removeResult(_finderPathCountByMa_TrangThai, args);
			finderCache.removeResult(_finderPathFetchByMa_TrangThai, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				danhMucModelImpl.getNhomId(), danhMucModelImpl.getMuc(),
				danhMucModelImpl.getTen(), danhMucModelImpl.isTrangThai()
			};

			finderCache.removeResult(
				_finderPathCountByNhomId_Muc_Ten_TrangThai, args);
			finderCache.removeResult(
				_finderPathFetchByNhomId_Muc_Ten_TrangThai, args);
		}

		if ((danhMucModelImpl.getColumnBitmask() &
			 _finderPathFetchByNhomId_Muc_Ten_TrangThai.getColumnBitmask()) !=
				 0) {

			Object[] args = new Object[] {
				danhMucModelImpl.getOriginalNhomId(),
				danhMucModelImpl.getOriginalMuc(),
				danhMucModelImpl.getOriginalTen(),
				danhMucModelImpl.getOriginalTrangThai()
			};

			finderCache.removeResult(
				_finderPathCountByNhomId_Muc_Ten_TrangThai, args);
			finderCache.removeResult(
				_finderPathFetchByNhomId_Muc_Ten_TrangThai, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				danhMucModelImpl.getNhomId(), danhMucModelImpl.getMuc(),
				danhMucModelImpl.getMa(), danhMucModelImpl.isTrangThai()
			};

			finderCache.removeResult(
				_finderPathCountByNhomId_Muc_Ma_TrangThai, args);
			finderCache.removeResult(
				_finderPathFetchByNhomId_Muc_Ma_TrangThai, args);
		}

		if ((danhMucModelImpl.getColumnBitmask() &
			 _finderPathFetchByNhomId_Muc_Ma_TrangThai.getColumnBitmask()) !=
				 0) {

			Object[] args = new Object[] {
				danhMucModelImpl.getOriginalNhomId(),
				danhMucModelImpl.getOriginalMuc(),
				danhMucModelImpl.getOriginalMa(),
				danhMucModelImpl.getOriginalTrangThai()
			};

			finderCache.removeResult(
				_finderPathCountByNhomId_Muc_Ma_TrangThai, args);
			finderCache.removeResult(
				_finderPathFetchByNhomId_Muc_Ma_TrangThai, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				danhMucModelImpl.getNhomId(), danhMucModelImpl.getMa()
			};

			finderCache.removeResult(_finderPathCountByNhomId_Ma, args);
			finderCache.removeResult(_finderPathFetchByNhomId_Ma, args);
		}

		if ((danhMucModelImpl.getColumnBitmask() &
			 _finderPathFetchByNhomId_Ma.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				danhMucModelImpl.getOriginalNhomId(),
				danhMucModelImpl.getOriginalMa()
			};

			finderCache.removeResult(_finderPathCountByNhomId_Ma, args);
			finderCache.removeResult(_finderPathFetchByNhomId_Ma, args);
		}
	}

	/**
	 * Creates a new danh muc with the primary key. Does not add the danh muc to the database.
	 *
	 * @param id the primary key for the new danh muc
	 * @return the new danh muc
	 */
	@Override
	public DanhMuc create(long id) {
		DanhMuc danhMuc = new DanhMucImpl();

		danhMuc.setNew(true);
		danhMuc.setPrimaryKey(id);

		return danhMuc;
	}

	/**
	 * Removes the danh muc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the danh muc
	 * @return the danh muc that was removed
	 * @throws NoSuchDanhMucException if a danh muc with the primary key could not be found
	 */
	@Override
	public DanhMuc remove(long id) throws NoSuchDanhMucException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the danh muc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the danh muc
	 * @return the danh muc that was removed
	 * @throws NoSuchDanhMucException if a danh muc with the primary key could not be found
	 */
	@Override
	public DanhMuc remove(Serializable primaryKey)
		throws NoSuchDanhMucException {

		Session session = null;

		try {
			session = openSession();

			DanhMuc danhMuc = (DanhMuc)session.get(
				DanhMucImpl.class, primaryKey);

			if (danhMuc == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDanhMucException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(danhMuc);
		}
		catch (NoSuchDanhMucException nsee) {
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
	protected DanhMuc removeImpl(DanhMuc danhMuc) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(danhMuc)) {
				danhMuc = (DanhMuc)session.get(
					DanhMucImpl.class, danhMuc.getPrimaryKeyObj());
			}

			if (danhMuc != null) {
				session.delete(danhMuc);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (danhMuc != null) {
			clearCache(danhMuc);
		}

		return danhMuc;
	}

	@Override
	public DanhMuc updateImpl(DanhMuc danhMuc) {
		boolean isNew = danhMuc.isNew();

		if (!(danhMuc instanceof DanhMucModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(danhMuc.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(danhMuc);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in danhMuc proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DanhMuc implementation " +
					danhMuc.getClass());
		}

		DanhMucModelImpl danhMucModelImpl = (DanhMucModelImpl)danhMuc;

		Session session = null;

		try {
			session = openSession();

			if (danhMuc.isNew()) {
				session.save(danhMuc);

				danhMuc.setNew(false);
			}
			else {
				danhMuc = (DanhMuc)session.merge(danhMuc);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!DanhMucModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {
				danhMucModelImpl.getChaId(), danhMucModelImpl.isTrangThai()
			};

			finderCache.removeResult(_finderPathCountByCha_TrangThai, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByCha_TrangThai, args);

			args = new Object[] {danhMucModelImpl.getChaId()};

			finderCache.removeResult(_finderPathCountByChaId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByChaId, args);

			args = new Object[] {danhMucModelImpl.getMuc()};

			finderCache.removeResult(_finderPathCountByMUC, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByMUC, args);

			args = new Object[] {danhMucModelImpl.getNhomId()};

			finderCache.removeResult(_finderPathCountByNhomID, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByNhomID, args);

			args = new Object[] {
				danhMucModelImpl.getNhomId(), danhMucModelImpl.isTrangThai()
			};

			finderCache.removeResult(_finderPathCountByNhomId_TrangThai, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByNhomId_TrangThai, args);

			args = new Object[] {
				danhMucModelImpl.getMa(), danhMucModelImpl.getMuc()
			};

			finderCache.removeResult(_finderPathCountByMa_Muc, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByMa_Muc, args);

			args = new Object[] {
				danhMucModelImpl.getChaId(), danhMucModelImpl.getMuc(),
				danhMucModelImpl.isTrangThai()
			};

			finderCache.removeResult(_finderPathCountByChaId_Muc, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByChaId_Muc, args);

			args = new Object[] {
				danhMucModelImpl.getNhomId(), danhMucModelImpl.getMuc(),
				danhMucModelImpl.isTrangThai()
			};

			finderCache.removeResult(
				_finderPathCountByNhomId_Muc_TrangThai, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByNhomId_Muc_TrangThai, args);

			args = new Object[] {danhMucModelImpl.getId()};

			finderCache.removeResult(_finderPathCountByIds, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByIds, args);

			args = new Object[] {
				danhMucModelImpl.getNhomId(), danhMucModelImpl.getMuc()
			};

			finderCache.removeResult(_finderPathCountByNhomId_Muc, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByNhomId_Muc, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((danhMucModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByCha_TrangThai.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					danhMucModelImpl.getOriginalChaId(),
					danhMucModelImpl.getOriginalTrangThai()
				};

				finderCache.removeResult(_finderPathCountByCha_TrangThai, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCha_TrangThai, args);

				args = new Object[] {
					danhMucModelImpl.getChaId(), danhMucModelImpl.isTrangThai()
				};

				finderCache.removeResult(_finderPathCountByCha_TrangThai, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCha_TrangThai, args);
			}

			if ((danhMucModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByChaId.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					danhMucModelImpl.getOriginalChaId()
				};

				finderCache.removeResult(_finderPathCountByChaId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByChaId, args);

				args = new Object[] {danhMucModelImpl.getChaId()};

				finderCache.removeResult(_finderPathCountByChaId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByChaId, args);
			}

			if ((danhMucModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByMUC.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					danhMucModelImpl.getOriginalMuc()
				};

				finderCache.removeResult(_finderPathCountByMUC, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByMUC, args);

				args = new Object[] {danhMucModelImpl.getMuc()};

				finderCache.removeResult(_finderPathCountByMUC, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByMUC, args);
			}

			if ((danhMucModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByNhomID.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					danhMucModelImpl.getOriginalNhomId()
				};

				finderCache.removeResult(_finderPathCountByNhomID, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByNhomID, args);

				args = new Object[] {danhMucModelImpl.getNhomId()};

				finderCache.removeResult(_finderPathCountByNhomID, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByNhomID, args);
			}

			if ((danhMucModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByNhomId_TrangThai.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					danhMucModelImpl.getOriginalNhomId(),
					danhMucModelImpl.getOriginalTrangThai()
				};

				finderCache.removeResult(
					_finderPathCountByNhomId_TrangThai, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByNhomId_TrangThai, args);

				args = new Object[] {
					danhMucModelImpl.getNhomId(), danhMucModelImpl.isTrangThai()
				};

				finderCache.removeResult(
					_finderPathCountByNhomId_TrangThai, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByNhomId_TrangThai, args);
			}

			if ((danhMucModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByMa_Muc.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					danhMucModelImpl.getOriginalMa(),
					danhMucModelImpl.getOriginalMuc()
				};

				finderCache.removeResult(_finderPathCountByMa_Muc, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByMa_Muc, args);

				args = new Object[] {
					danhMucModelImpl.getMa(), danhMucModelImpl.getMuc()
				};

				finderCache.removeResult(_finderPathCountByMa_Muc, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByMa_Muc, args);
			}

			if ((danhMucModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByChaId_Muc.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					danhMucModelImpl.getOriginalChaId(),
					danhMucModelImpl.getOriginalMuc(),
					danhMucModelImpl.getOriginalTrangThai()
				};

				finderCache.removeResult(_finderPathCountByChaId_Muc, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByChaId_Muc, args);

				args = new Object[] {
					danhMucModelImpl.getChaId(), danhMucModelImpl.getMuc(),
					danhMucModelImpl.isTrangThai()
				};

				finderCache.removeResult(_finderPathCountByChaId_Muc, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByChaId_Muc, args);
			}

			if ((danhMucModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByNhomId_Muc_TrangThai.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					danhMucModelImpl.getOriginalNhomId(),
					danhMucModelImpl.getOriginalMuc(),
					danhMucModelImpl.getOriginalTrangThai()
				};

				finderCache.removeResult(
					_finderPathCountByNhomId_Muc_TrangThai, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByNhomId_Muc_TrangThai,
					args);

				args = new Object[] {
					danhMucModelImpl.getNhomId(), danhMucModelImpl.getMuc(),
					danhMucModelImpl.isTrangThai()
				};

				finderCache.removeResult(
					_finderPathCountByNhomId_Muc_TrangThai, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByNhomId_Muc_TrangThai,
					args);
			}

			if ((danhMucModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByIds.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {danhMucModelImpl.getOriginalId()};

				finderCache.removeResult(_finderPathCountByIds, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByIds, args);

				args = new Object[] {danhMucModelImpl.getId()};

				finderCache.removeResult(_finderPathCountByIds, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByIds, args);
			}

			if ((danhMucModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByNhomId_Muc.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					danhMucModelImpl.getOriginalNhomId(),
					danhMucModelImpl.getOriginalMuc()
				};

				finderCache.removeResult(_finderPathCountByNhomId_Muc, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByNhomId_Muc, args);

				args = new Object[] {
					danhMucModelImpl.getNhomId(), danhMucModelImpl.getMuc()
				};

				finderCache.removeResult(_finderPathCountByNhomId_Muc, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByNhomId_Muc, args);
			}
		}

		entityCache.putResult(
			DanhMucModelImpl.ENTITY_CACHE_ENABLED, DanhMucImpl.class,
			danhMuc.getPrimaryKey(), danhMuc, false);

		clearUniqueFindersCache(danhMucModelImpl, false);
		cacheUniqueFindersCache(danhMucModelImpl);

		danhMuc.resetOriginalValues();

		return danhMuc;
	}

	/**
	 * Returns the danh muc with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the danh muc
	 * @return the danh muc
	 * @throws NoSuchDanhMucException if a danh muc with the primary key could not be found
	 */
	@Override
	public DanhMuc findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDanhMucException {

		DanhMuc danhMuc = fetchByPrimaryKey(primaryKey);

		if (danhMuc == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDanhMucException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return danhMuc;
	}

	/**
	 * Returns the danh muc with the primary key or throws a <code>NoSuchDanhMucException</code> if it could not be found.
	 *
	 * @param id the primary key of the danh muc
	 * @return the danh muc
	 * @throws NoSuchDanhMucException if a danh muc with the primary key could not be found
	 */
	@Override
	public DanhMuc findByPrimaryKey(long id) throws NoSuchDanhMucException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the danh muc with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the danh muc
	 * @return the danh muc, or <code>null</code> if a danh muc with the primary key could not be found
	 */
	@Override
	public DanhMuc fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			DanhMucModelImpl.ENTITY_CACHE_ENABLED, DanhMucImpl.class,
			primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		DanhMuc danhMuc = (DanhMuc)serializable;

		if (danhMuc == null) {
			Session session = null;

			try {
				session = openSession();

				danhMuc = (DanhMuc)session.get(DanhMucImpl.class, primaryKey);

				if (danhMuc != null) {
					cacheResult(danhMuc);
				}
				else {
					entityCache.putResult(
						DanhMucModelImpl.ENTITY_CACHE_ENABLED,
						DanhMucImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					DanhMucModelImpl.ENTITY_CACHE_ENABLED, DanhMucImpl.class,
					primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return danhMuc;
	}

	/**
	 * Returns the danh muc with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the danh muc
	 * @return the danh muc, or <code>null</code> if a danh muc with the primary key could not be found
	 */
	@Override
	public DanhMuc fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, DanhMuc> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, DanhMuc> map = new HashMap<Serializable, DanhMuc>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			DanhMuc danhMuc = fetchByPrimaryKey(primaryKey);

			if (danhMuc != null) {
				map.put(primaryKey, danhMuc);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				DanhMucModelImpl.ENTITY_CACHE_ENABLED, DanhMucImpl.class,
				primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (DanhMuc)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_DANHMUC_WHERE_PKS_IN);

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

			for (DanhMuc danhMuc : (List<DanhMuc>)q.list()) {
				map.put(danhMuc.getPrimaryKeyObj(), danhMuc);

				cacheResult(danhMuc);

				uncachedPrimaryKeys.remove(danhMuc.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					DanhMucModelImpl.ENTITY_CACHE_ENABLED, DanhMucImpl.class,
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
	 * Returns all the danh mucs.
	 *
	 * @return the danh mucs
	 */
	@Override
	public List<DanhMuc> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the danh mucs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @return the range of danh mucs
	 */
	@Override
	public List<DanhMuc> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the danh mucs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of danh mucs
	 */
	@Override
	public List<DanhMuc> findAll(
		int start, int end, OrderByComparator<DanhMuc> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the danh mucs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of danh mucs
	 */
	@Override
	public List<DanhMuc> findAll(
		int start, int end, OrderByComparator<DanhMuc> orderByComparator,
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

		List<DanhMuc> list = null;

		if (retrieveFromCache) {
			list = (List<DanhMuc>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_DANHMUC);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DANHMUC;

				if (pagination) {
					sql = sql.concat(DanhMucModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DanhMuc>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DanhMuc>)QueryUtil.list(
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
	 * Removes all the danh mucs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DanhMuc danhMuc : findAll()) {
			remove(danhMuc);
		}
	}

	/**
	 * Returns the number of danh mucs.
	 *
	 * @return the number of danh mucs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DANHMUC);

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
		return DanhMucModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the danh muc persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			DanhMucModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucModelImpl.FINDER_CACHE_ENABLED, DanhMucImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			DanhMucModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucModelImpl.FINDER_CACHE_ENABLED, DanhMucImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			DanhMucModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByM = new FinderPath(
			DanhMucModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucModelImpl.FINDER_CACHE_ENABLED, DanhMucImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByM",
			new String[] {String.class.getName()},
			DanhMucModelImpl.MA_COLUMN_BITMASK);

		_finderPathCountByM = new FinderPath(
			DanhMucModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByM",
			new String[] {String.class.getName()});

		_finderPathFetchByT = new FinderPath(
			DanhMucModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucModelImpl.FINDER_CACHE_ENABLED, DanhMucImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByT",
			new String[] {String.class.getName()},
			DanhMucModelImpl.TEN_COLUMN_BITMASK);

		_finderPathCountByT = new FinderPath(
			DanhMucModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByT",
			new String[] {String.class.getName()});

		_finderPathFetchByP_T = new FinderPath(
			DanhMucModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucModelImpl.FINDER_CACHE_ENABLED, DanhMucImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByP_T",
			new String[] {Long.class.getName(), String.class.getName()},
			DanhMucModelImpl.CHAID_COLUMN_BITMASK |
			DanhMucModelImpl.TEN_COLUMN_BITMASK);

		_finderPathCountByP_T = new FinderPath(
			DanhMucModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByP_T",
			new String[] {Long.class.getName(), String.class.getName()});

		_finderPathWithPaginationFindByCha_TrangThai = new FinderPath(
			DanhMucModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucModelImpl.FINDER_CACHE_ENABLED, DanhMucImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCha_TrangThai",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByCha_TrangThai = new FinderPath(
			DanhMucModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucModelImpl.FINDER_CACHE_ENABLED, DanhMucImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCha_TrangThai",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			DanhMucModelImpl.CHAID_COLUMN_BITMASK |
			DanhMucModelImpl.TRANGTHAI_COLUMN_BITMASK |
			DanhMucModelImpl.THUTUHIENTHI_COLUMN_BITMASK |
			DanhMucModelImpl.TEN_COLUMN_BITMASK);

		_finderPathCountByCha_TrangThai = new FinderPath(
			DanhMucModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCha_TrangThai",
			new String[] {Long.class.getName(), Boolean.class.getName()});

		_finderPathWithPaginationFindByChaId = new FinderPath(
			DanhMucModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucModelImpl.FINDER_CACHE_ENABLED, DanhMucImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByChaId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByChaId = new FinderPath(
			DanhMucModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucModelImpl.FINDER_CACHE_ENABLED, DanhMucImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByChaId",
			new String[] {Long.class.getName()},
			DanhMucModelImpl.CHAID_COLUMN_BITMASK |
			DanhMucModelImpl.THUTUHIENTHI_COLUMN_BITMASK |
			DanhMucModelImpl.TEN_COLUMN_BITMASK);

		_finderPathCountByChaId = new FinderPath(
			DanhMucModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByChaId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByMUC = new FinderPath(
			DanhMucModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucModelImpl.FINDER_CACHE_ENABLED, DanhMucImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMUC",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByMUC = new FinderPath(
			DanhMucModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucModelImpl.FINDER_CACHE_ENABLED, DanhMucImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMUC",
			new String[] {Integer.class.getName()},
			DanhMucModelImpl.MUC_COLUMN_BITMASK |
			DanhMucModelImpl.THUTUHIENTHI_COLUMN_BITMASK |
			DanhMucModelImpl.TEN_COLUMN_BITMASK);

		_finderPathCountByMUC = new FinderPath(
			DanhMucModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMUC",
			new String[] {Integer.class.getName()});

		_finderPathWithPaginationFindByNhomID = new FinderPath(
			DanhMucModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucModelImpl.FINDER_CACHE_ENABLED, DanhMucImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByNhomID",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByNhomID = new FinderPath(
			DanhMucModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucModelImpl.FINDER_CACHE_ENABLED, DanhMucImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByNhomID",
			new String[] {Long.class.getName()},
			DanhMucModelImpl.NHOMID_COLUMN_BITMASK |
			DanhMucModelImpl.THUTUHIENTHI_COLUMN_BITMASK |
			DanhMucModelImpl.TEN_COLUMN_BITMASK);

		_finderPathCountByNhomID = new FinderPath(
			DanhMucModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNhomID",
			new String[] {Long.class.getName()});

		_finderPathFetchByTT = new FinderPath(
			DanhMucModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucModelImpl.FINDER_CACHE_ENABLED, DanhMucImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByTT",
			new String[] {Integer.class.getName()},
			DanhMucModelImpl.THUTUHIENTHI_COLUMN_BITMASK);

		_finderPathCountByTT = new FinderPath(
			DanhMucModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTT",
			new String[] {Integer.class.getName()});

		_finderPathWithPaginationFindByNhomId_TrangThai = new FinderPath(
			DanhMucModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucModelImpl.FINDER_CACHE_ENABLED, DanhMucImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByNhomId_TrangThai",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByNhomId_TrangThai = new FinderPath(
			DanhMucModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucModelImpl.FINDER_CACHE_ENABLED, DanhMucImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByNhomId_TrangThai",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			DanhMucModelImpl.NHOMID_COLUMN_BITMASK |
			DanhMucModelImpl.TRANGTHAI_COLUMN_BITMASK |
			DanhMucModelImpl.THUTUHIENTHI_COLUMN_BITMASK |
			DanhMucModelImpl.TEN_COLUMN_BITMASK);

		_finderPathCountByNhomId_TrangThai = new FinderPath(
			DanhMucModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByNhomId_TrangThai",
			new String[] {Long.class.getName(), Boolean.class.getName()});

		_finderPathFetchByMa_TrangThai = new FinderPath(
			DanhMucModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucModelImpl.FINDER_CACHE_ENABLED, DanhMucImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByMa_TrangThai",
			new String[] {String.class.getName(), Boolean.class.getName()},
			DanhMucModelImpl.MA_COLUMN_BITMASK |
			DanhMucModelImpl.TRANGTHAI_COLUMN_BITMASK);

		_finderPathCountByMa_TrangThai = new FinderPath(
			DanhMucModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMa_TrangThai",
			new String[] {String.class.getName(), Boolean.class.getName()});

		_finderPathWithPaginationFindByMa_Muc = new FinderPath(
			DanhMucModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucModelImpl.FINDER_CACHE_ENABLED, DanhMucImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMa_Muc",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByMa_Muc = new FinderPath(
			DanhMucModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucModelImpl.FINDER_CACHE_ENABLED, DanhMucImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMa_Muc",
			new String[] {String.class.getName(), Integer.class.getName()},
			DanhMucModelImpl.MA_COLUMN_BITMASK |
			DanhMucModelImpl.MUC_COLUMN_BITMASK |
			DanhMucModelImpl.THUTUHIENTHI_COLUMN_BITMASK |
			DanhMucModelImpl.TEN_COLUMN_BITMASK);

		_finderPathCountByMa_Muc = new FinderPath(
			DanhMucModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMa_Muc",
			new String[] {String.class.getName(), Integer.class.getName()});

		_finderPathWithPaginationFindByChaId_Muc = new FinderPath(
			DanhMucModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucModelImpl.FINDER_CACHE_ENABLED, DanhMucImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByChaId_Muc",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByChaId_Muc = new FinderPath(
			DanhMucModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucModelImpl.FINDER_CACHE_ENABLED, DanhMucImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByChaId_Muc",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Boolean.class.getName()
			},
			DanhMucModelImpl.CHAID_COLUMN_BITMASK |
			DanhMucModelImpl.MUC_COLUMN_BITMASK |
			DanhMucModelImpl.TRANGTHAI_COLUMN_BITMASK |
			DanhMucModelImpl.THUTUHIENTHI_COLUMN_BITMASK |
			DanhMucModelImpl.TEN_COLUMN_BITMASK);

		_finderPathCountByChaId_Muc = new FinderPath(
			DanhMucModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByChaId_Muc",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Boolean.class.getName()
			});

		_finderPathWithPaginationFindByNhomId_Muc_TrangThai = new FinderPath(
			DanhMucModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucModelImpl.FINDER_CACHE_ENABLED, DanhMucImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByNhomId_Muc_TrangThai",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByNhomId_Muc_TrangThai = new FinderPath(
			DanhMucModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucModelImpl.FINDER_CACHE_ENABLED, DanhMucImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByNhomId_Muc_TrangThai",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Boolean.class.getName()
			},
			DanhMucModelImpl.NHOMID_COLUMN_BITMASK |
			DanhMucModelImpl.MUC_COLUMN_BITMASK |
			DanhMucModelImpl.TRANGTHAI_COLUMN_BITMASK |
			DanhMucModelImpl.THUTUHIENTHI_COLUMN_BITMASK |
			DanhMucModelImpl.TEN_COLUMN_BITMASK);

		_finderPathCountByNhomId_Muc_TrangThai = new FinderPath(
			DanhMucModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByNhomId_Muc_TrangThai",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Boolean.class.getName()
			});

		_finderPathFetchByNhomId_Muc_Ten_TrangThai = new FinderPath(
			DanhMucModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucModelImpl.FINDER_CACHE_ENABLED, DanhMucImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByNhomId_Muc_Ten_TrangThai",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				String.class.getName(), Boolean.class.getName()
			},
			DanhMucModelImpl.NHOMID_COLUMN_BITMASK |
			DanhMucModelImpl.MUC_COLUMN_BITMASK |
			DanhMucModelImpl.TEN_COLUMN_BITMASK |
			DanhMucModelImpl.TRANGTHAI_COLUMN_BITMASK);

		_finderPathCountByNhomId_Muc_Ten_TrangThai = new FinderPath(
			DanhMucModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByNhomId_Muc_Ten_TrangThai",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				String.class.getName(), Boolean.class.getName()
			});

		_finderPathFetchByNhomId_Muc_Ma_TrangThai = new FinderPath(
			DanhMucModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucModelImpl.FINDER_CACHE_ENABLED, DanhMucImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByNhomId_Muc_Ma_TrangThai",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				String.class.getName(), Boolean.class.getName()
			},
			DanhMucModelImpl.NHOMID_COLUMN_BITMASK |
			DanhMucModelImpl.MUC_COLUMN_BITMASK |
			DanhMucModelImpl.MA_COLUMN_BITMASK |
			DanhMucModelImpl.TRANGTHAI_COLUMN_BITMASK);

		_finderPathCountByNhomId_Muc_Ma_TrangThai = new FinderPath(
			DanhMucModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByNhomId_Muc_Ma_TrangThai",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				String.class.getName(), Boolean.class.getName()
			});

		_finderPathWithPaginationFindByIds = new FinderPath(
			DanhMucModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucModelImpl.FINDER_CACHE_ENABLED, DanhMucImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByIds",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByIds = new FinderPath(
			DanhMucModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucModelImpl.FINDER_CACHE_ENABLED, DanhMucImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByIds",
			new String[] {Long.class.getName()},
			DanhMucModelImpl.ID_COLUMN_BITMASK |
			DanhMucModelImpl.THUTUHIENTHI_COLUMN_BITMASK |
			DanhMucModelImpl.TEN_COLUMN_BITMASK);

		_finderPathCountByIds = new FinderPath(
			DanhMucModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIds",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationCountByIds = new FinderPath(
			DanhMucModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByIds",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByNhomId_Muc = new FinderPath(
			DanhMucModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucModelImpl.FINDER_CACHE_ENABLED, DanhMucImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByNhomId_Muc",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByNhomId_Muc = new FinderPath(
			DanhMucModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucModelImpl.FINDER_CACHE_ENABLED, DanhMucImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByNhomId_Muc",
			new String[] {Long.class.getName(), Integer.class.getName()},
			DanhMucModelImpl.NHOMID_COLUMN_BITMASK |
			DanhMucModelImpl.MUC_COLUMN_BITMASK |
			DanhMucModelImpl.THUTUHIENTHI_COLUMN_BITMASK |
			DanhMucModelImpl.TEN_COLUMN_BITMASK);

		_finderPathCountByNhomId_Muc = new FinderPath(
			DanhMucModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNhomId_Muc",
			new String[] {Long.class.getName(), Integer.class.getName()});

		_finderPathFetchByNhomId_Ma = new FinderPath(
			DanhMucModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucModelImpl.FINDER_CACHE_ENABLED, DanhMucImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByNhomId_Ma",
			new String[] {Long.class.getName(), String.class.getName()},
			DanhMucModelImpl.NHOMID_COLUMN_BITMASK |
			DanhMucModelImpl.MA_COLUMN_BITMASK);

		_finderPathCountByNhomId_Ma = new FinderPath(
			DanhMucModelImpl.ENTITY_CACHE_ENABLED,
			DanhMucModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNhomId_Ma",
			new String[] {Long.class.getName(), String.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(DanhMucImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_DANHMUC =
		"SELECT danhMuc FROM DanhMuc danhMuc";

	private static final String _SQL_SELECT_DANHMUC_WHERE_PKS_IN =
		"SELECT danhMuc FROM DanhMuc danhMuc WHERE id IN (";

	private static final String _SQL_SELECT_DANHMUC_WHERE =
		"SELECT danhMuc FROM DanhMuc danhMuc WHERE ";

	private static final String _SQL_COUNT_DANHMUC =
		"SELECT COUNT(danhMuc) FROM DanhMuc danhMuc";

	private static final String _SQL_COUNT_DANHMUC_WHERE =
		"SELECT COUNT(danhMuc) FROM DanhMuc danhMuc WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "danhMuc.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DanhMuc exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DanhMuc exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DanhMucPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"nhomId", "ten", "moTa", "chaId", "thuTuHienThi", "maGiaPha",
			"trangThai"
		});

}