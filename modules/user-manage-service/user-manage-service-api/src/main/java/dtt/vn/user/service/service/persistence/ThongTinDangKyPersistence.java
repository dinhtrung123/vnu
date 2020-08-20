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

package dtt.vn.user.service.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import dtt.vn.user.service.exception.NoSuchThongTinDangKyException;
import dtt.vn.user.service.model.ThongTinDangKy;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the thong tin dang ky service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nhanvienDTT
 * @see ThongTinDangKyUtil
 * @generated
 */
@ProviderType
public interface ThongTinDangKyPersistence
	extends BasePersistence<ThongTinDangKy> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ThongTinDangKyUtil} to access the thong tin dang ky persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, ThongTinDangKy> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns the thong tin dang ky where maKichHoat = &#63; or throws a <code>NoSuchThongTinDangKyException</code> if it could not be found.
	 *
	 * @param maKichHoat the ma kich hoat
	 * @return the matching thong tin dang ky
	 * @throws NoSuchThongTinDangKyException if a matching thong tin dang ky could not be found
	 */
	public ThongTinDangKy findByMaKichHoat(String maKichHoat)
		throws NoSuchThongTinDangKyException;

	/**
	 * Returns the thong tin dang ky where maKichHoat = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param maKichHoat the ma kich hoat
	 * @return the matching thong tin dang ky, or <code>null</code> if a matching thong tin dang ky could not be found
	 */
	public ThongTinDangKy fetchByMaKichHoat(String maKichHoat);

	/**
	 * Returns the thong tin dang ky where maKichHoat = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param maKichHoat the ma kich hoat
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching thong tin dang ky, or <code>null</code> if a matching thong tin dang ky could not be found
	 */
	public ThongTinDangKy fetchByMaKichHoat(
		String maKichHoat, boolean retrieveFromCache);

	/**
	 * Removes the thong tin dang ky where maKichHoat = &#63; from the database.
	 *
	 * @param maKichHoat the ma kich hoat
	 * @return the thong tin dang ky that was removed
	 */
	public ThongTinDangKy removeByMaKichHoat(String maKichHoat)
		throws NoSuchThongTinDangKyException;

	/**
	 * Returns the number of thong tin dang kies where maKichHoat = &#63;.
	 *
	 * @param maKichHoat the ma kich hoat
	 * @return the number of matching thong tin dang kies
	 */
	public int countByMaKichHoat(String maKichHoat);

	/**
	 * Returns the thong tin dang ky where emailAddress = &#63; or throws a <code>NoSuchThongTinDangKyException</code> if it could not be found.
	 *
	 * @param emailAddress the email address
	 * @return the matching thong tin dang ky
	 * @throws NoSuchThongTinDangKyException if a matching thong tin dang ky could not be found
	 */
	public ThongTinDangKy findByemailAddress(String emailAddress)
		throws NoSuchThongTinDangKyException;

	/**
	 * Returns the thong tin dang ky where emailAddress = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param emailAddress the email address
	 * @return the matching thong tin dang ky, or <code>null</code> if a matching thong tin dang ky could not be found
	 */
	public ThongTinDangKy fetchByemailAddress(String emailAddress);

	/**
	 * Returns the thong tin dang ky where emailAddress = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param emailAddress the email address
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching thong tin dang ky, or <code>null</code> if a matching thong tin dang ky could not be found
	 */
	public ThongTinDangKy fetchByemailAddress(
		String emailAddress, boolean retrieveFromCache);

	/**
	 * Removes the thong tin dang ky where emailAddress = &#63; from the database.
	 *
	 * @param emailAddress the email address
	 * @return the thong tin dang ky that was removed
	 */
	public ThongTinDangKy removeByemailAddress(String emailAddress)
		throws NoSuchThongTinDangKyException;

	/**
	 * Returns the number of thong tin dang kies where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @return the number of matching thong tin dang kies
	 */
	public int countByemailAddress(String emailAddress);

	/**
	 * Returns the thong tin dang ky where userName = &#63; or throws a <code>NoSuchThongTinDangKyException</code> if it could not be found.
	 *
	 * @param userName the user name
	 * @return the matching thong tin dang ky
	 * @throws NoSuchThongTinDangKyException if a matching thong tin dang ky could not be found
	 */
	public ThongTinDangKy findByuserName(String userName)
		throws NoSuchThongTinDangKyException;

	/**
	 * Returns the thong tin dang ky where userName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userName the user name
	 * @return the matching thong tin dang ky, or <code>null</code> if a matching thong tin dang ky could not be found
	 */
	public ThongTinDangKy fetchByuserName(String userName);

	/**
	 * Returns the thong tin dang ky where userName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userName the user name
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching thong tin dang ky, or <code>null</code> if a matching thong tin dang ky could not be found
	 */
	public ThongTinDangKy fetchByuserName(
		String userName, boolean retrieveFromCache);

	/**
	 * Removes the thong tin dang ky where userName = &#63; from the database.
	 *
	 * @param userName the user name
	 * @return the thong tin dang ky that was removed
	 */
	public ThongTinDangKy removeByuserName(String userName)
		throws NoSuchThongTinDangKyException;

	/**
	 * Returns the number of thong tin dang kies where userName = &#63;.
	 *
	 * @param userName the user name
	 * @return the number of matching thong tin dang kies
	 */
	public int countByuserName(String userName);

	/**
	 * Returns the thong tin dang ky where soGiayTo = &#63; or throws a <code>NoSuchThongTinDangKyException</code> if it could not be found.
	 *
	 * @param soGiayTo the so giay to
	 * @return the matching thong tin dang ky
	 * @throws NoSuchThongTinDangKyException if a matching thong tin dang ky could not be found
	 */
	public ThongTinDangKy findBysoGiayTo(String soGiayTo)
		throws NoSuchThongTinDangKyException;

	/**
	 * Returns the thong tin dang ky where soGiayTo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param soGiayTo the so giay to
	 * @return the matching thong tin dang ky, or <code>null</code> if a matching thong tin dang ky could not be found
	 */
	public ThongTinDangKy fetchBysoGiayTo(String soGiayTo);

	/**
	 * Returns the thong tin dang ky where soGiayTo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param soGiayTo the so giay to
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching thong tin dang ky, or <code>null</code> if a matching thong tin dang ky could not be found
	 */
	public ThongTinDangKy fetchBysoGiayTo(
		String soGiayTo, boolean retrieveFromCache);

	/**
	 * Removes the thong tin dang ky where soGiayTo = &#63; from the database.
	 *
	 * @param soGiayTo the so giay to
	 * @return the thong tin dang ky that was removed
	 */
	public ThongTinDangKy removeBysoGiayTo(String soGiayTo)
		throws NoSuchThongTinDangKyException;

	/**
	 * Returns the number of thong tin dang kies where soGiayTo = &#63;.
	 *
	 * @param soGiayTo the so giay to
	 * @return the number of matching thong tin dang kies
	 */
	public int countBysoGiayTo(String soGiayTo);

	/**
	 * Returns the thong tin dang ky where activeType = &#63; or throws a <code>NoSuchThongTinDangKyException</code> if it could not be found.
	 *
	 * @param activeType the active type
	 * @return the matching thong tin dang ky
	 * @throws NoSuchThongTinDangKyException if a matching thong tin dang ky could not be found
	 */
	public ThongTinDangKy findByactiveType(String activeType)
		throws NoSuchThongTinDangKyException;

	/**
	 * Returns the thong tin dang ky where activeType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param activeType the active type
	 * @return the matching thong tin dang ky, or <code>null</code> if a matching thong tin dang ky could not be found
	 */
	public ThongTinDangKy fetchByactiveType(String activeType);

	/**
	 * Returns the thong tin dang ky where activeType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param activeType the active type
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching thong tin dang ky, or <code>null</code> if a matching thong tin dang ky could not be found
	 */
	public ThongTinDangKy fetchByactiveType(
		String activeType, boolean retrieveFromCache);

	/**
	 * Removes the thong tin dang ky where activeType = &#63; from the database.
	 *
	 * @param activeType the active type
	 * @return the thong tin dang ky that was removed
	 */
	public ThongTinDangKy removeByactiveType(String activeType)
		throws NoSuchThongTinDangKyException;

	/**
	 * Returns the number of thong tin dang kies where activeType = &#63;.
	 *
	 * @param activeType the active type
	 * @return the number of matching thong tin dang kies
	 */
	public int countByactiveType(String activeType);

	/**
	 * Caches the thong tin dang ky in the entity cache if it is enabled.
	 *
	 * @param thongTinDangKy the thong tin dang ky
	 */
	public void cacheResult(ThongTinDangKy thongTinDangKy);

	/**
	 * Caches the thong tin dang kies in the entity cache if it is enabled.
	 *
	 * @param thongTinDangKies the thong tin dang kies
	 */
	public void cacheResult(java.util.List<ThongTinDangKy> thongTinDangKies);

	/**
	 * Creates a new thong tin dang ky with the primary key. Does not add the thong tin dang ky to the database.
	 *
	 * @param id the primary key for the new thong tin dang ky
	 * @return the new thong tin dang ky
	 */
	public ThongTinDangKy create(long id);

	/**
	 * Removes the thong tin dang ky with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the thong tin dang ky
	 * @return the thong tin dang ky that was removed
	 * @throws NoSuchThongTinDangKyException if a thong tin dang ky with the primary key could not be found
	 */
	public ThongTinDangKy remove(long id) throws NoSuchThongTinDangKyException;

	public ThongTinDangKy updateImpl(ThongTinDangKy thongTinDangKy);

	/**
	 * Returns the thong tin dang ky with the primary key or throws a <code>NoSuchThongTinDangKyException</code> if it could not be found.
	 *
	 * @param id the primary key of the thong tin dang ky
	 * @return the thong tin dang ky
	 * @throws NoSuchThongTinDangKyException if a thong tin dang ky with the primary key could not be found
	 */
	public ThongTinDangKy findByPrimaryKey(long id)
		throws NoSuchThongTinDangKyException;

	/**
	 * Returns the thong tin dang ky with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the thong tin dang ky
	 * @return the thong tin dang ky, or <code>null</code> if a thong tin dang ky with the primary key could not be found
	 */
	public ThongTinDangKy fetchByPrimaryKey(long id);

	/**
	 * Returns all the thong tin dang kies.
	 *
	 * @return the thong tin dang kies
	 */
	public java.util.List<ThongTinDangKy> findAll();

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
	public java.util.List<ThongTinDangKy> findAll(int start, int end);

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
	public java.util.List<ThongTinDangKy> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ThongTinDangKy>
			orderByComparator);

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
	public java.util.List<ThongTinDangKy> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ThongTinDangKy>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the thong tin dang kies from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of thong tin dang kies.
	 *
	 * @return the number of thong tin dang kies
	 */
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();

}