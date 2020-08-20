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

import dtt.vn.user.service.exception.NoSuchThongTinDangKyException;
import dtt.vn.user.service.model.ThongTinDangKy;
import dtt.vn.user.service.model.impl.ThongTinDangKyImpl;
import dtt.vn.user.service.model.impl.ThongTinDangKyModelImpl;
import dtt.vn.user.service.service.persistence.ThongTinDangKyPersistence;

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
 * The persistence implementation for the thong tin dang ky service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nhanvienDTT
 * @generated
 */
@ProviderType
public class ThongTinDangKyPersistenceImpl
	extends BasePersistenceImpl<ThongTinDangKy>
	implements ThongTinDangKyPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ThongTinDangKyUtil</code> to access the thong tin dang ky persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ThongTinDangKyImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByMaKichHoat;
	private FinderPath _finderPathCountByMaKichHoat;

	/**
	 * Returns the thong tin dang ky where maKichHoat = &#63; or throws a <code>NoSuchThongTinDangKyException</code> if it could not be found.
	 *
	 * @param maKichHoat the ma kich hoat
	 * @return the matching thong tin dang ky
	 * @throws NoSuchThongTinDangKyException if a matching thong tin dang ky could not be found
	 */
	@Override
	public ThongTinDangKy findByMaKichHoat(String maKichHoat)
		throws NoSuchThongTinDangKyException {

		ThongTinDangKy thongTinDangKy = fetchByMaKichHoat(maKichHoat);

		if (thongTinDangKy == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("maKichHoat=");
			msg.append(maKichHoat);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchThongTinDangKyException(msg.toString());
		}

		return thongTinDangKy;
	}

	/**
	 * Returns the thong tin dang ky where maKichHoat = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param maKichHoat the ma kich hoat
	 * @return the matching thong tin dang ky, or <code>null</code> if a matching thong tin dang ky could not be found
	 */
	@Override
	public ThongTinDangKy fetchByMaKichHoat(String maKichHoat) {
		return fetchByMaKichHoat(maKichHoat, true);
	}

	/**
	 * Returns the thong tin dang ky where maKichHoat = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param maKichHoat the ma kich hoat
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching thong tin dang ky, or <code>null</code> if a matching thong tin dang ky could not be found
	 */
	@Override
	public ThongTinDangKy fetchByMaKichHoat(
		String maKichHoat, boolean retrieveFromCache) {

		maKichHoat = Objects.toString(maKichHoat, "");

		Object[] finderArgs = new Object[] {maKichHoat};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByMaKichHoat, finderArgs, this);
		}

		if (result instanceof ThongTinDangKy) {
			ThongTinDangKy thongTinDangKy = (ThongTinDangKy)result;

			if (!Objects.equals(maKichHoat, thongTinDangKy.getMaKichHoat())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_THONGTINDANGKY_WHERE);

			boolean bindMaKichHoat = false;

			if (maKichHoat.isEmpty()) {
				query.append(_FINDER_COLUMN_MAKICHHOAT_MAKICHHOAT_3);
			}
			else {
				bindMaKichHoat = true;

				query.append(_FINDER_COLUMN_MAKICHHOAT_MAKICHHOAT_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindMaKichHoat) {
					qPos.add(maKichHoat);
				}

				List<ThongTinDangKy> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByMaKichHoat, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"ThongTinDangKyPersistenceImpl.fetchByMaKichHoat(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ThongTinDangKy thongTinDangKy = list.get(0);

					result = thongTinDangKy;

					cacheResult(thongTinDangKy);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathFetchByMaKichHoat, finderArgs);

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
			return (ThongTinDangKy)result;
		}
	}

	/**
	 * Removes the thong tin dang ky where maKichHoat = &#63; from the database.
	 *
	 * @param maKichHoat the ma kich hoat
	 * @return the thong tin dang ky that was removed
	 */
	@Override
	public ThongTinDangKy removeByMaKichHoat(String maKichHoat)
		throws NoSuchThongTinDangKyException {

		ThongTinDangKy thongTinDangKy = findByMaKichHoat(maKichHoat);

		return remove(thongTinDangKy);
	}

	/**
	 * Returns the number of thong tin dang kies where maKichHoat = &#63;.
	 *
	 * @param maKichHoat the ma kich hoat
	 * @return the number of matching thong tin dang kies
	 */
	@Override
	public int countByMaKichHoat(String maKichHoat) {
		maKichHoat = Objects.toString(maKichHoat, "");

		FinderPath finderPath = _finderPathCountByMaKichHoat;

		Object[] finderArgs = new Object[] {maKichHoat};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_THONGTINDANGKY_WHERE);

			boolean bindMaKichHoat = false;

			if (maKichHoat.isEmpty()) {
				query.append(_FINDER_COLUMN_MAKICHHOAT_MAKICHHOAT_3);
			}
			else {
				bindMaKichHoat = true;

				query.append(_FINDER_COLUMN_MAKICHHOAT_MAKICHHOAT_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindMaKichHoat) {
					qPos.add(maKichHoat);
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

	private static final String _FINDER_COLUMN_MAKICHHOAT_MAKICHHOAT_2 =
		"thongTinDangKy.maKichHoat = ?";

	private static final String _FINDER_COLUMN_MAKICHHOAT_MAKICHHOAT_3 =
		"(thongTinDangKy.maKichHoat IS NULL OR thongTinDangKy.maKichHoat = '')";

	private FinderPath _finderPathFetchByemailAddress;
	private FinderPath _finderPathCountByemailAddress;

	/**
	 * Returns the thong tin dang ky where emailAddress = &#63; or throws a <code>NoSuchThongTinDangKyException</code> if it could not be found.
	 *
	 * @param emailAddress the email address
	 * @return the matching thong tin dang ky
	 * @throws NoSuchThongTinDangKyException if a matching thong tin dang ky could not be found
	 */
	@Override
	public ThongTinDangKy findByemailAddress(String emailAddress)
		throws NoSuchThongTinDangKyException {

		ThongTinDangKy thongTinDangKy = fetchByemailAddress(emailAddress);

		if (thongTinDangKy == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("emailAddress=");
			msg.append(emailAddress);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchThongTinDangKyException(msg.toString());
		}

		return thongTinDangKy;
	}

	/**
	 * Returns the thong tin dang ky where emailAddress = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param emailAddress the email address
	 * @return the matching thong tin dang ky, or <code>null</code> if a matching thong tin dang ky could not be found
	 */
	@Override
	public ThongTinDangKy fetchByemailAddress(String emailAddress) {
		return fetchByemailAddress(emailAddress, true);
	}

	/**
	 * Returns the thong tin dang ky where emailAddress = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param emailAddress the email address
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching thong tin dang ky, or <code>null</code> if a matching thong tin dang ky could not be found
	 */
	@Override
	public ThongTinDangKy fetchByemailAddress(
		String emailAddress, boolean retrieveFromCache) {

		emailAddress = Objects.toString(emailAddress, "");

		Object[] finderArgs = new Object[] {emailAddress};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByemailAddress, finderArgs, this);
		}

		if (result instanceof ThongTinDangKy) {
			ThongTinDangKy thongTinDangKy = (ThongTinDangKy)result;

			if (!Objects.equals(
					emailAddress, thongTinDangKy.getEmailAddress())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_THONGTINDANGKY_WHERE);

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

				List<ThongTinDangKy> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByemailAddress, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"ThongTinDangKyPersistenceImpl.fetchByemailAddress(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ThongTinDangKy thongTinDangKy = list.get(0);

					result = thongTinDangKy;

					cacheResult(thongTinDangKy);
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
			return (ThongTinDangKy)result;
		}
	}

	/**
	 * Removes the thong tin dang ky where emailAddress = &#63; from the database.
	 *
	 * @param emailAddress the email address
	 * @return the thong tin dang ky that was removed
	 */
	@Override
	public ThongTinDangKy removeByemailAddress(String emailAddress)
		throws NoSuchThongTinDangKyException {

		ThongTinDangKy thongTinDangKy = findByemailAddress(emailAddress);

		return remove(thongTinDangKy);
	}

	/**
	 * Returns the number of thong tin dang kies where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @return the number of matching thong tin dang kies
	 */
	@Override
	public int countByemailAddress(String emailAddress) {
		emailAddress = Objects.toString(emailAddress, "");

		FinderPath finderPath = _finderPathCountByemailAddress;

		Object[] finderArgs = new Object[] {emailAddress};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_THONGTINDANGKY_WHERE);

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
		"thongTinDangKy.emailAddress = ?";

	private static final String _FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_3 =
		"(thongTinDangKy.emailAddress IS NULL OR thongTinDangKy.emailAddress = '')";

	private FinderPath _finderPathFetchByuserName;
	private FinderPath _finderPathCountByuserName;

	/**
	 * Returns the thong tin dang ky where userName = &#63; or throws a <code>NoSuchThongTinDangKyException</code> if it could not be found.
	 *
	 * @param userName the user name
	 * @return the matching thong tin dang ky
	 * @throws NoSuchThongTinDangKyException if a matching thong tin dang ky could not be found
	 */
	@Override
	public ThongTinDangKy findByuserName(String userName)
		throws NoSuchThongTinDangKyException {

		ThongTinDangKy thongTinDangKy = fetchByuserName(userName);

		if (thongTinDangKy == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userName=");
			msg.append(userName);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchThongTinDangKyException(msg.toString());
		}

		return thongTinDangKy;
	}

	/**
	 * Returns the thong tin dang ky where userName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userName the user name
	 * @return the matching thong tin dang ky, or <code>null</code> if a matching thong tin dang ky could not be found
	 */
	@Override
	public ThongTinDangKy fetchByuserName(String userName) {
		return fetchByuserName(userName, true);
	}

	/**
	 * Returns the thong tin dang ky where userName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userName the user name
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching thong tin dang ky, or <code>null</code> if a matching thong tin dang ky could not be found
	 */
	@Override
	public ThongTinDangKy fetchByuserName(
		String userName, boolean retrieveFromCache) {

		userName = Objects.toString(userName, "");

		Object[] finderArgs = new Object[] {userName};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByuserName, finderArgs, this);
		}

		if (result instanceof ThongTinDangKy) {
			ThongTinDangKy thongTinDangKy = (ThongTinDangKy)result;

			if (!Objects.equals(userName, thongTinDangKy.getUserName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_THONGTINDANGKY_WHERE);

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

				List<ThongTinDangKy> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByuserName, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"ThongTinDangKyPersistenceImpl.fetchByuserName(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ThongTinDangKy thongTinDangKy = list.get(0);

					result = thongTinDangKy;

					cacheResult(thongTinDangKy);
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
			return (ThongTinDangKy)result;
		}
	}

	/**
	 * Removes the thong tin dang ky where userName = &#63; from the database.
	 *
	 * @param userName the user name
	 * @return the thong tin dang ky that was removed
	 */
	@Override
	public ThongTinDangKy removeByuserName(String userName)
		throws NoSuchThongTinDangKyException {

		ThongTinDangKy thongTinDangKy = findByuserName(userName);

		return remove(thongTinDangKy);
	}

	/**
	 * Returns the number of thong tin dang kies where userName = &#63;.
	 *
	 * @param userName the user name
	 * @return the number of matching thong tin dang kies
	 */
	@Override
	public int countByuserName(String userName) {
		userName = Objects.toString(userName, "");

		FinderPath finderPath = _finderPathCountByuserName;

		Object[] finderArgs = new Object[] {userName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_THONGTINDANGKY_WHERE);

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
		"thongTinDangKy.userName = ?";

	private static final String _FINDER_COLUMN_USERNAME_USERNAME_3 =
		"(thongTinDangKy.userName IS NULL OR thongTinDangKy.userName = '')";

	private FinderPath _finderPathFetchBysoGiayTo;
	private FinderPath _finderPathCountBysoGiayTo;

	/**
	 * Returns the thong tin dang ky where soGiayTo = &#63; or throws a <code>NoSuchThongTinDangKyException</code> if it could not be found.
	 *
	 * @param soGiayTo the so giay to
	 * @return the matching thong tin dang ky
	 * @throws NoSuchThongTinDangKyException if a matching thong tin dang ky could not be found
	 */
	@Override
	public ThongTinDangKy findBysoGiayTo(String soGiayTo)
		throws NoSuchThongTinDangKyException {

		ThongTinDangKy thongTinDangKy = fetchBysoGiayTo(soGiayTo);

		if (thongTinDangKy == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("soGiayTo=");
			msg.append(soGiayTo);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchThongTinDangKyException(msg.toString());
		}

		return thongTinDangKy;
	}

	/**
	 * Returns the thong tin dang ky where soGiayTo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param soGiayTo the so giay to
	 * @return the matching thong tin dang ky, or <code>null</code> if a matching thong tin dang ky could not be found
	 */
	@Override
	public ThongTinDangKy fetchBysoGiayTo(String soGiayTo) {
		return fetchBysoGiayTo(soGiayTo, true);
	}

	/**
	 * Returns the thong tin dang ky where soGiayTo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param soGiayTo the so giay to
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching thong tin dang ky, or <code>null</code> if a matching thong tin dang ky could not be found
	 */
	@Override
	public ThongTinDangKy fetchBysoGiayTo(
		String soGiayTo, boolean retrieveFromCache) {

		soGiayTo = Objects.toString(soGiayTo, "");

		Object[] finderArgs = new Object[] {soGiayTo};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchBysoGiayTo, finderArgs, this);
		}

		if (result instanceof ThongTinDangKy) {
			ThongTinDangKy thongTinDangKy = (ThongTinDangKy)result;

			if (!Objects.equals(soGiayTo, thongTinDangKy.getSoGiayTo())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_THONGTINDANGKY_WHERE);

			boolean bindSoGiayTo = false;

			if (soGiayTo.isEmpty()) {
				query.append(_FINDER_COLUMN_SOGIAYTO_SOGIAYTO_3);
			}
			else {
				bindSoGiayTo = true;

				query.append(_FINDER_COLUMN_SOGIAYTO_SOGIAYTO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindSoGiayTo) {
					qPos.add(soGiayTo);
				}

				List<ThongTinDangKy> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchBysoGiayTo, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"ThongTinDangKyPersistenceImpl.fetchBysoGiayTo(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ThongTinDangKy thongTinDangKy = list.get(0);

					result = thongTinDangKy;

					cacheResult(thongTinDangKy);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathFetchBysoGiayTo, finderArgs);

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
			return (ThongTinDangKy)result;
		}
	}

	/**
	 * Removes the thong tin dang ky where soGiayTo = &#63; from the database.
	 *
	 * @param soGiayTo the so giay to
	 * @return the thong tin dang ky that was removed
	 */
	@Override
	public ThongTinDangKy removeBysoGiayTo(String soGiayTo)
		throws NoSuchThongTinDangKyException {

		ThongTinDangKy thongTinDangKy = findBysoGiayTo(soGiayTo);

		return remove(thongTinDangKy);
	}

	/**
	 * Returns the number of thong tin dang kies where soGiayTo = &#63;.
	 *
	 * @param soGiayTo the so giay to
	 * @return the number of matching thong tin dang kies
	 */
	@Override
	public int countBysoGiayTo(String soGiayTo) {
		soGiayTo = Objects.toString(soGiayTo, "");

		FinderPath finderPath = _finderPathCountBysoGiayTo;

		Object[] finderArgs = new Object[] {soGiayTo};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_THONGTINDANGKY_WHERE);

			boolean bindSoGiayTo = false;

			if (soGiayTo.isEmpty()) {
				query.append(_FINDER_COLUMN_SOGIAYTO_SOGIAYTO_3);
			}
			else {
				bindSoGiayTo = true;

				query.append(_FINDER_COLUMN_SOGIAYTO_SOGIAYTO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindSoGiayTo) {
					qPos.add(soGiayTo);
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

	private static final String _FINDER_COLUMN_SOGIAYTO_SOGIAYTO_2 =
		"thongTinDangKy.soGiayTo = ?";

	private static final String _FINDER_COLUMN_SOGIAYTO_SOGIAYTO_3 =
		"(thongTinDangKy.soGiayTo IS NULL OR thongTinDangKy.soGiayTo = '')";

	private FinderPath _finderPathFetchByactiveType;
	private FinderPath _finderPathCountByactiveType;

	/**
	 * Returns the thong tin dang ky where activeType = &#63; or throws a <code>NoSuchThongTinDangKyException</code> if it could not be found.
	 *
	 * @param activeType the active type
	 * @return the matching thong tin dang ky
	 * @throws NoSuchThongTinDangKyException if a matching thong tin dang ky could not be found
	 */
	@Override
	public ThongTinDangKy findByactiveType(String activeType)
		throws NoSuchThongTinDangKyException {

		ThongTinDangKy thongTinDangKy = fetchByactiveType(activeType);

		if (thongTinDangKy == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("activeType=");
			msg.append(activeType);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchThongTinDangKyException(msg.toString());
		}

		return thongTinDangKy;
	}

	/**
	 * Returns the thong tin dang ky where activeType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param activeType the active type
	 * @return the matching thong tin dang ky, or <code>null</code> if a matching thong tin dang ky could not be found
	 */
	@Override
	public ThongTinDangKy fetchByactiveType(String activeType) {
		return fetchByactiveType(activeType, true);
	}

	/**
	 * Returns the thong tin dang ky where activeType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param activeType the active type
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching thong tin dang ky, or <code>null</code> if a matching thong tin dang ky could not be found
	 */
	@Override
	public ThongTinDangKy fetchByactiveType(
		String activeType, boolean retrieveFromCache) {

		activeType = Objects.toString(activeType, "");

		Object[] finderArgs = new Object[] {activeType};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByactiveType, finderArgs, this);
		}

		if (result instanceof ThongTinDangKy) {
			ThongTinDangKy thongTinDangKy = (ThongTinDangKy)result;

			if (!Objects.equals(activeType, thongTinDangKy.getActiveType())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_THONGTINDANGKY_WHERE);

			boolean bindActiveType = false;

			if (activeType.isEmpty()) {
				query.append(_FINDER_COLUMN_ACTIVETYPE_ACTIVETYPE_3);
			}
			else {
				bindActiveType = true;

				query.append(_FINDER_COLUMN_ACTIVETYPE_ACTIVETYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindActiveType) {
					qPos.add(activeType);
				}

				List<ThongTinDangKy> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByactiveType, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"ThongTinDangKyPersistenceImpl.fetchByactiveType(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ThongTinDangKy thongTinDangKy = list.get(0);

					result = thongTinDangKy;

					cacheResult(thongTinDangKy);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathFetchByactiveType, finderArgs);

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
			return (ThongTinDangKy)result;
		}
	}

	/**
	 * Removes the thong tin dang ky where activeType = &#63; from the database.
	 *
	 * @param activeType the active type
	 * @return the thong tin dang ky that was removed
	 */
	@Override
	public ThongTinDangKy removeByactiveType(String activeType)
		throws NoSuchThongTinDangKyException {

		ThongTinDangKy thongTinDangKy = findByactiveType(activeType);

		return remove(thongTinDangKy);
	}

	/**
	 * Returns the number of thong tin dang kies where activeType = &#63;.
	 *
	 * @param activeType the active type
	 * @return the number of matching thong tin dang kies
	 */
	@Override
	public int countByactiveType(String activeType) {
		activeType = Objects.toString(activeType, "");

		FinderPath finderPath = _finderPathCountByactiveType;

		Object[] finderArgs = new Object[] {activeType};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_THONGTINDANGKY_WHERE);

			boolean bindActiveType = false;

			if (activeType.isEmpty()) {
				query.append(_FINDER_COLUMN_ACTIVETYPE_ACTIVETYPE_3);
			}
			else {
				bindActiveType = true;

				query.append(_FINDER_COLUMN_ACTIVETYPE_ACTIVETYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindActiveType) {
					qPos.add(activeType);
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

	private static final String _FINDER_COLUMN_ACTIVETYPE_ACTIVETYPE_2 =
		"thongTinDangKy.activeType = ?";

	private static final String _FINDER_COLUMN_ACTIVETYPE_ACTIVETYPE_3 =
		"(thongTinDangKy.activeType IS NULL OR thongTinDangKy.activeType = '')";

	public ThongTinDangKyPersistenceImpl() {
		setModelClass(ThongTinDangKy.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("emailAddress", "email_address");
		dbColumnNames.put("userName", "username");
		dbColumnNames.put("soGiayTo", "sogiayto");
		dbColumnNames.put("maKichHoat", "makichhoat");
		dbColumnNames.put("activeType", "activetype");
		dbColumnNames.put("doiTuongSuDungId", "doituongsudung_id");
		dbColumnNames.put("noiDung", "noidung");
		dbColumnNames.put("ngayTao", "ngaytao");

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
	 * Caches the thong tin dang ky in the entity cache if it is enabled.
	 *
	 * @param thongTinDangKy the thong tin dang ky
	 */
	@Override
	public void cacheResult(ThongTinDangKy thongTinDangKy) {
		entityCache.putResult(
			ThongTinDangKyModelImpl.ENTITY_CACHE_ENABLED,
			ThongTinDangKyImpl.class, thongTinDangKy.getPrimaryKey(),
			thongTinDangKy);

		finderCache.putResult(
			_finderPathFetchByMaKichHoat,
			new Object[] {thongTinDangKy.getMaKichHoat()}, thongTinDangKy);

		finderCache.putResult(
			_finderPathFetchByemailAddress,
			new Object[] {thongTinDangKy.getEmailAddress()}, thongTinDangKy);

		finderCache.putResult(
			_finderPathFetchByuserName,
			new Object[] {thongTinDangKy.getUserName()}, thongTinDangKy);

		finderCache.putResult(
			_finderPathFetchBysoGiayTo,
			new Object[] {thongTinDangKy.getSoGiayTo()}, thongTinDangKy);

		finderCache.putResult(
			_finderPathFetchByactiveType,
			new Object[] {thongTinDangKy.getActiveType()}, thongTinDangKy);

		thongTinDangKy.resetOriginalValues();
	}

	/**
	 * Caches the thong tin dang kies in the entity cache if it is enabled.
	 *
	 * @param thongTinDangKies the thong tin dang kies
	 */
	@Override
	public void cacheResult(List<ThongTinDangKy> thongTinDangKies) {
		for (ThongTinDangKy thongTinDangKy : thongTinDangKies) {
			if (entityCache.getResult(
					ThongTinDangKyModelImpl.ENTITY_CACHE_ENABLED,
					ThongTinDangKyImpl.class, thongTinDangKy.getPrimaryKey()) ==
						null) {

				cacheResult(thongTinDangKy);
			}
			else {
				thongTinDangKy.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all thong tin dang kies.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ThongTinDangKyImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the thong tin dang ky.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ThongTinDangKy thongTinDangKy) {
		entityCache.removeResult(
			ThongTinDangKyModelImpl.ENTITY_CACHE_ENABLED,
			ThongTinDangKyImpl.class, thongTinDangKy.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((ThongTinDangKyModelImpl)thongTinDangKy, true);
	}

	@Override
	public void clearCache(List<ThongTinDangKy> thongTinDangKies) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ThongTinDangKy thongTinDangKy : thongTinDangKies) {
			entityCache.removeResult(
				ThongTinDangKyModelImpl.ENTITY_CACHE_ENABLED,
				ThongTinDangKyImpl.class, thongTinDangKy.getPrimaryKey());

			clearUniqueFindersCache(
				(ThongTinDangKyModelImpl)thongTinDangKy, true);
		}
	}

	protected void cacheUniqueFindersCache(
		ThongTinDangKyModelImpl thongTinDangKyModelImpl) {

		Object[] args = new Object[] {thongTinDangKyModelImpl.getMaKichHoat()};

		finderCache.putResult(
			_finderPathCountByMaKichHoat, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByMaKichHoat, args, thongTinDangKyModelImpl, false);

		args = new Object[] {thongTinDangKyModelImpl.getEmailAddress()};

		finderCache.putResult(
			_finderPathCountByemailAddress, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByemailAddress, args, thongTinDangKyModelImpl,
			false);

		args = new Object[] {thongTinDangKyModelImpl.getUserName()};

		finderCache.putResult(
			_finderPathCountByuserName, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByuserName, args, thongTinDangKyModelImpl, false);

		args = new Object[] {thongTinDangKyModelImpl.getSoGiayTo()};

		finderCache.putResult(
			_finderPathCountBysoGiayTo, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchBysoGiayTo, args, thongTinDangKyModelImpl, false);

		args = new Object[] {thongTinDangKyModelImpl.getActiveType()};

		finderCache.putResult(
			_finderPathCountByactiveType, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByactiveType, args, thongTinDangKyModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		ThongTinDangKyModelImpl thongTinDangKyModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				thongTinDangKyModelImpl.getMaKichHoat()
			};

			finderCache.removeResult(_finderPathCountByMaKichHoat, args);
			finderCache.removeResult(_finderPathFetchByMaKichHoat, args);
		}

		if ((thongTinDangKyModelImpl.getColumnBitmask() &
			 _finderPathFetchByMaKichHoat.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				thongTinDangKyModelImpl.getOriginalMaKichHoat()
			};

			finderCache.removeResult(_finderPathCountByMaKichHoat, args);
			finderCache.removeResult(_finderPathFetchByMaKichHoat, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				thongTinDangKyModelImpl.getEmailAddress()
			};

			finderCache.removeResult(_finderPathCountByemailAddress, args);
			finderCache.removeResult(_finderPathFetchByemailAddress, args);
		}

		if ((thongTinDangKyModelImpl.getColumnBitmask() &
			 _finderPathFetchByemailAddress.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				thongTinDangKyModelImpl.getOriginalEmailAddress()
			};

			finderCache.removeResult(_finderPathCountByemailAddress, args);
			finderCache.removeResult(_finderPathFetchByemailAddress, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				thongTinDangKyModelImpl.getUserName()
			};

			finderCache.removeResult(_finderPathCountByuserName, args);
			finderCache.removeResult(_finderPathFetchByuserName, args);
		}

		if ((thongTinDangKyModelImpl.getColumnBitmask() &
			 _finderPathFetchByuserName.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				thongTinDangKyModelImpl.getOriginalUserName()
			};

			finderCache.removeResult(_finderPathCountByuserName, args);
			finderCache.removeResult(_finderPathFetchByuserName, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				thongTinDangKyModelImpl.getSoGiayTo()
			};

			finderCache.removeResult(_finderPathCountBysoGiayTo, args);
			finderCache.removeResult(_finderPathFetchBysoGiayTo, args);
		}

		if ((thongTinDangKyModelImpl.getColumnBitmask() &
			 _finderPathFetchBysoGiayTo.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				thongTinDangKyModelImpl.getOriginalSoGiayTo()
			};

			finderCache.removeResult(_finderPathCountBysoGiayTo, args);
			finderCache.removeResult(_finderPathFetchBysoGiayTo, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				thongTinDangKyModelImpl.getActiveType()
			};

			finderCache.removeResult(_finderPathCountByactiveType, args);
			finderCache.removeResult(_finderPathFetchByactiveType, args);
		}

		if ((thongTinDangKyModelImpl.getColumnBitmask() &
			 _finderPathFetchByactiveType.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				thongTinDangKyModelImpl.getOriginalActiveType()
			};

			finderCache.removeResult(_finderPathCountByactiveType, args);
			finderCache.removeResult(_finderPathFetchByactiveType, args);
		}
	}

	/**
	 * Creates a new thong tin dang ky with the primary key. Does not add the thong tin dang ky to the database.
	 *
	 * @param id the primary key for the new thong tin dang ky
	 * @return the new thong tin dang ky
	 */
	@Override
	public ThongTinDangKy create(long id) {
		ThongTinDangKy thongTinDangKy = new ThongTinDangKyImpl();

		thongTinDangKy.setNew(true);
		thongTinDangKy.setPrimaryKey(id);

		return thongTinDangKy;
	}

	/**
	 * Removes the thong tin dang ky with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the thong tin dang ky
	 * @return the thong tin dang ky that was removed
	 * @throws NoSuchThongTinDangKyException if a thong tin dang ky with the primary key could not be found
	 */
	@Override
	public ThongTinDangKy remove(long id) throws NoSuchThongTinDangKyException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the thong tin dang ky with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the thong tin dang ky
	 * @return the thong tin dang ky that was removed
	 * @throws NoSuchThongTinDangKyException if a thong tin dang ky with the primary key could not be found
	 */
	@Override
	public ThongTinDangKy remove(Serializable primaryKey)
		throws NoSuchThongTinDangKyException {

		Session session = null;

		try {
			session = openSession();

			ThongTinDangKy thongTinDangKy = (ThongTinDangKy)session.get(
				ThongTinDangKyImpl.class, primaryKey);

			if (thongTinDangKy == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchThongTinDangKyException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(thongTinDangKy);
		}
		catch (NoSuchThongTinDangKyException nsee) {
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
	protected ThongTinDangKy removeImpl(ThongTinDangKy thongTinDangKy) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(thongTinDangKy)) {
				thongTinDangKy = (ThongTinDangKy)session.get(
					ThongTinDangKyImpl.class,
					thongTinDangKy.getPrimaryKeyObj());
			}

			if (thongTinDangKy != null) {
				session.delete(thongTinDangKy);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (thongTinDangKy != null) {
			clearCache(thongTinDangKy);
		}

		return thongTinDangKy;
	}

	@Override
	public ThongTinDangKy updateImpl(ThongTinDangKy thongTinDangKy) {
		boolean isNew = thongTinDangKy.isNew();

		if (!(thongTinDangKy instanceof ThongTinDangKyModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(thongTinDangKy.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					thongTinDangKy);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in thongTinDangKy proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ThongTinDangKy implementation " +
					thongTinDangKy.getClass());
		}

		ThongTinDangKyModelImpl thongTinDangKyModelImpl =
			(ThongTinDangKyModelImpl)thongTinDangKy;

		Session session = null;

		try {
			session = openSession();

			if (thongTinDangKy.isNew()) {
				session.save(thongTinDangKy);

				thongTinDangKy.setNew(false);
			}
			else {
				thongTinDangKy = (ThongTinDangKy)session.merge(thongTinDangKy);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!ThongTinDangKyModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			ThongTinDangKyModelImpl.ENTITY_CACHE_ENABLED,
			ThongTinDangKyImpl.class, thongTinDangKy.getPrimaryKey(),
			thongTinDangKy, false);

		clearUniqueFindersCache(thongTinDangKyModelImpl, false);
		cacheUniqueFindersCache(thongTinDangKyModelImpl);

		thongTinDangKy.resetOriginalValues();

		return thongTinDangKy;
	}

	/**
	 * Returns the thong tin dang ky with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the thong tin dang ky
	 * @return the thong tin dang ky
	 * @throws NoSuchThongTinDangKyException if a thong tin dang ky with the primary key could not be found
	 */
	@Override
	public ThongTinDangKy findByPrimaryKey(Serializable primaryKey)
		throws NoSuchThongTinDangKyException {

		ThongTinDangKy thongTinDangKy = fetchByPrimaryKey(primaryKey);

		if (thongTinDangKy == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchThongTinDangKyException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return thongTinDangKy;
	}

	/**
	 * Returns the thong tin dang ky with the primary key or throws a <code>NoSuchThongTinDangKyException</code> if it could not be found.
	 *
	 * @param id the primary key of the thong tin dang ky
	 * @return the thong tin dang ky
	 * @throws NoSuchThongTinDangKyException if a thong tin dang ky with the primary key could not be found
	 */
	@Override
	public ThongTinDangKy findByPrimaryKey(long id)
		throws NoSuchThongTinDangKyException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the thong tin dang ky with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the thong tin dang ky
	 * @return the thong tin dang ky, or <code>null</code> if a thong tin dang ky with the primary key could not be found
	 */
	@Override
	public ThongTinDangKy fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			ThongTinDangKyModelImpl.ENTITY_CACHE_ENABLED,
			ThongTinDangKyImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		ThongTinDangKy thongTinDangKy = (ThongTinDangKy)serializable;

		if (thongTinDangKy == null) {
			Session session = null;

			try {
				session = openSession();

				thongTinDangKy = (ThongTinDangKy)session.get(
					ThongTinDangKyImpl.class, primaryKey);

				if (thongTinDangKy != null) {
					cacheResult(thongTinDangKy);
				}
				else {
					entityCache.putResult(
						ThongTinDangKyModelImpl.ENTITY_CACHE_ENABLED,
						ThongTinDangKyImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					ThongTinDangKyModelImpl.ENTITY_CACHE_ENABLED,
					ThongTinDangKyImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return thongTinDangKy;
	}

	/**
	 * Returns the thong tin dang ky with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the thong tin dang ky
	 * @return the thong tin dang ky, or <code>null</code> if a thong tin dang ky with the primary key could not be found
	 */
	@Override
	public ThongTinDangKy fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, ThongTinDangKy> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ThongTinDangKy> map =
			new HashMap<Serializable, ThongTinDangKy>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ThongTinDangKy thongTinDangKy = fetchByPrimaryKey(primaryKey);

			if (thongTinDangKy != null) {
				map.put(primaryKey, thongTinDangKy);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				ThongTinDangKyModelImpl.ENTITY_CACHE_ENABLED,
				ThongTinDangKyImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (ThongTinDangKy)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_THONGTINDANGKY_WHERE_PKS_IN);

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

			for (ThongTinDangKy thongTinDangKy :
					(List<ThongTinDangKy>)q.list()) {

				map.put(thongTinDangKy.getPrimaryKeyObj(), thongTinDangKy);

				cacheResult(thongTinDangKy);

				uncachedPrimaryKeys.remove(thongTinDangKy.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					ThongTinDangKyModelImpl.ENTITY_CACHE_ENABLED,
					ThongTinDangKyImpl.class, primaryKey, nullModel);
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
	 * Returns all the thong tin dang kies.
	 *
	 * @return the thong tin dang kies
	 */
	@Override
	public List<ThongTinDangKy> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the thong tin dang kies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ThongTinDangKyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of thong tin dang kies
	 * @param end the upper bound of the range of thong tin dang kies (not inclusive)
	 * @return the range of thong tin dang kies
	 */
	@Override
	public List<ThongTinDangKy> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the thong tin dang kies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ThongTinDangKyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of thong tin dang kies
	 * @param end the upper bound of the range of thong tin dang kies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of thong tin dang kies
	 */
	@Override
	public List<ThongTinDangKy> findAll(
		int start, int end,
		OrderByComparator<ThongTinDangKy> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the thong tin dang kies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ThongTinDangKyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of thong tin dang kies
	 * @param end the upper bound of the range of thong tin dang kies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of thong tin dang kies
	 */
	@Override
	public List<ThongTinDangKy> findAll(
		int start, int end, OrderByComparator<ThongTinDangKy> orderByComparator,
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

		List<ThongTinDangKy> list = null;

		if (retrieveFromCache) {
			list = (List<ThongTinDangKy>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_THONGTINDANGKY);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_THONGTINDANGKY;

				if (pagination) {
					sql = sql.concat(ThongTinDangKyModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ThongTinDangKy>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ThongTinDangKy>)QueryUtil.list(
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
	 * Removes all the thong tin dang kies from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ThongTinDangKy thongTinDangKy : findAll()) {
			remove(thongTinDangKy);
		}
	}

	/**
	 * Returns the number of thong tin dang kies.
	 *
	 * @return the number of thong tin dang kies
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_THONGTINDANGKY);

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
		return ThongTinDangKyModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the thong tin dang ky persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			ThongTinDangKyModelImpl.ENTITY_CACHE_ENABLED,
			ThongTinDangKyModelImpl.FINDER_CACHE_ENABLED,
			ThongTinDangKyImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			ThongTinDangKyModelImpl.ENTITY_CACHE_ENABLED,
			ThongTinDangKyModelImpl.FINDER_CACHE_ENABLED,
			ThongTinDangKyImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);

		_finderPathCountAll = new FinderPath(
			ThongTinDangKyModelImpl.ENTITY_CACHE_ENABLED,
			ThongTinDangKyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByMaKichHoat = new FinderPath(
			ThongTinDangKyModelImpl.ENTITY_CACHE_ENABLED,
			ThongTinDangKyModelImpl.FINDER_CACHE_ENABLED,
			ThongTinDangKyImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByMaKichHoat", new String[] {String.class.getName()},
			ThongTinDangKyModelImpl.MAKICHHOAT_COLUMN_BITMASK);

		_finderPathCountByMaKichHoat = new FinderPath(
			ThongTinDangKyModelImpl.ENTITY_CACHE_ENABLED,
			ThongTinDangKyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMaKichHoat",
			new String[] {String.class.getName()});

		_finderPathFetchByemailAddress = new FinderPath(
			ThongTinDangKyModelImpl.ENTITY_CACHE_ENABLED,
			ThongTinDangKyModelImpl.FINDER_CACHE_ENABLED,
			ThongTinDangKyImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByemailAddress", new String[] {String.class.getName()},
			ThongTinDangKyModelImpl.EMAILADDRESS_COLUMN_BITMASK);

		_finderPathCountByemailAddress = new FinderPath(
			ThongTinDangKyModelImpl.ENTITY_CACHE_ENABLED,
			ThongTinDangKyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByemailAddress",
			new String[] {String.class.getName()});

		_finderPathFetchByuserName = new FinderPath(
			ThongTinDangKyModelImpl.ENTITY_CACHE_ENABLED,
			ThongTinDangKyModelImpl.FINDER_CACHE_ENABLED,
			ThongTinDangKyImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByuserName", new String[] {String.class.getName()},
			ThongTinDangKyModelImpl.USERNAME_COLUMN_BITMASK);

		_finderPathCountByuserName = new FinderPath(
			ThongTinDangKyModelImpl.ENTITY_CACHE_ENABLED,
			ThongTinDangKyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByuserName",
			new String[] {String.class.getName()});

		_finderPathFetchBysoGiayTo = new FinderPath(
			ThongTinDangKyModelImpl.ENTITY_CACHE_ENABLED,
			ThongTinDangKyModelImpl.FINDER_CACHE_ENABLED,
			ThongTinDangKyImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchBysoGiayTo", new String[] {String.class.getName()},
			ThongTinDangKyModelImpl.SOGIAYTO_COLUMN_BITMASK);

		_finderPathCountBysoGiayTo = new FinderPath(
			ThongTinDangKyModelImpl.ENTITY_CACHE_ENABLED,
			ThongTinDangKyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBysoGiayTo",
			new String[] {String.class.getName()});

		_finderPathFetchByactiveType = new FinderPath(
			ThongTinDangKyModelImpl.ENTITY_CACHE_ENABLED,
			ThongTinDangKyModelImpl.FINDER_CACHE_ENABLED,
			ThongTinDangKyImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByactiveType", new String[] {String.class.getName()},
			ThongTinDangKyModelImpl.ACTIVETYPE_COLUMN_BITMASK);

		_finderPathCountByactiveType = new FinderPath(
			ThongTinDangKyModelImpl.ENTITY_CACHE_ENABLED,
			ThongTinDangKyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByactiveType",
			new String[] {String.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(ThongTinDangKyImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_THONGTINDANGKY =
		"SELECT thongTinDangKy FROM ThongTinDangKy thongTinDangKy";

	private static final String _SQL_SELECT_THONGTINDANGKY_WHERE_PKS_IN =
		"SELECT thongTinDangKy FROM ThongTinDangKy thongTinDangKy WHERE id IN (";

	private static final String _SQL_SELECT_THONGTINDANGKY_WHERE =
		"SELECT thongTinDangKy FROM ThongTinDangKy thongTinDangKy WHERE ";

	private static final String _SQL_COUNT_THONGTINDANGKY =
		"SELECT COUNT(thongTinDangKy) FROM ThongTinDangKy thongTinDangKy";

	private static final String _SQL_COUNT_THONGTINDANGKY_WHERE =
		"SELECT COUNT(thongTinDangKy) FROM ThongTinDangKy thongTinDangKy WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "thongTinDangKy.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ThongTinDangKy exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ThongTinDangKy exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ThongTinDangKyPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"emailAddress", "userName", "soGiayTo", "maKichHoat", "activeType",
			"doiTuongSuDungId", "noiDung", "ngayTao"
		});

}