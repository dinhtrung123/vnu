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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import dtt.vn.user.service.model.ThongTinDangKy;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the thong tin dang ky service. This utility wraps <code>dtt.vn.user.service.service.persistence.impl.ThongTinDangKyPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nhanvienDTT
 * @see ThongTinDangKyPersistence
 * @generated
 */
@ProviderType
public class ThongTinDangKyUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(ThongTinDangKy thongTinDangKy) {
		getPersistence().clearCache(thongTinDangKy);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, ThongTinDangKy> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ThongTinDangKy> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ThongTinDangKy> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ThongTinDangKy> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ThongTinDangKy> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ThongTinDangKy update(ThongTinDangKy thongTinDangKy) {
		return getPersistence().update(thongTinDangKy);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ThongTinDangKy update(
		ThongTinDangKy thongTinDangKy, ServiceContext serviceContext) {

		return getPersistence().update(thongTinDangKy, serviceContext);
	}

	/**
	 * Returns the thong tin dang ky where maKichHoat = &#63; or throws a <code>NoSuchThongTinDangKyException</code> if it could not be found.
	 *
	 * @param maKichHoat the ma kich hoat
	 * @return the matching thong tin dang ky
	 * @throws NoSuchThongTinDangKyException if a matching thong tin dang ky could not be found
	 */
	public static ThongTinDangKy findByMaKichHoat(String maKichHoat)
		throws dtt.vn.user.service.exception.NoSuchThongTinDangKyException {

		return getPersistence().findByMaKichHoat(maKichHoat);
	}

	/**
	 * Returns the thong tin dang ky where maKichHoat = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param maKichHoat the ma kich hoat
	 * @return the matching thong tin dang ky, or <code>null</code> if a matching thong tin dang ky could not be found
	 */
	public static ThongTinDangKy fetchByMaKichHoat(String maKichHoat) {
		return getPersistence().fetchByMaKichHoat(maKichHoat);
	}

	/**
	 * Returns the thong tin dang ky where maKichHoat = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param maKichHoat the ma kich hoat
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching thong tin dang ky, or <code>null</code> if a matching thong tin dang ky could not be found
	 */
	public static ThongTinDangKy fetchByMaKichHoat(
		String maKichHoat, boolean retrieveFromCache) {

		return getPersistence().fetchByMaKichHoat(
			maKichHoat, retrieveFromCache);
	}

	/**
	 * Removes the thong tin dang ky where maKichHoat = &#63; from the database.
	 *
	 * @param maKichHoat the ma kich hoat
	 * @return the thong tin dang ky that was removed
	 */
	public static ThongTinDangKy removeByMaKichHoat(String maKichHoat)
		throws dtt.vn.user.service.exception.NoSuchThongTinDangKyException {

		return getPersistence().removeByMaKichHoat(maKichHoat);
	}

	/**
	 * Returns the number of thong tin dang kies where maKichHoat = &#63;.
	 *
	 * @param maKichHoat the ma kich hoat
	 * @return the number of matching thong tin dang kies
	 */
	public static int countByMaKichHoat(String maKichHoat) {
		return getPersistence().countByMaKichHoat(maKichHoat);
	}

	/**
	 * Returns the thong tin dang ky where emailAddress = &#63; or throws a <code>NoSuchThongTinDangKyException</code> if it could not be found.
	 *
	 * @param emailAddress the email address
	 * @return the matching thong tin dang ky
	 * @throws NoSuchThongTinDangKyException if a matching thong tin dang ky could not be found
	 */
	public static ThongTinDangKy findByemailAddress(String emailAddress)
		throws dtt.vn.user.service.exception.NoSuchThongTinDangKyException {

		return getPersistence().findByemailAddress(emailAddress);
	}

	/**
	 * Returns the thong tin dang ky where emailAddress = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param emailAddress the email address
	 * @return the matching thong tin dang ky, or <code>null</code> if a matching thong tin dang ky could not be found
	 */
	public static ThongTinDangKy fetchByemailAddress(String emailAddress) {
		return getPersistence().fetchByemailAddress(emailAddress);
	}

	/**
	 * Returns the thong tin dang ky where emailAddress = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param emailAddress the email address
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching thong tin dang ky, or <code>null</code> if a matching thong tin dang ky could not be found
	 */
	public static ThongTinDangKy fetchByemailAddress(
		String emailAddress, boolean retrieveFromCache) {

		return getPersistence().fetchByemailAddress(
			emailAddress, retrieveFromCache);
	}

	/**
	 * Removes the thong tin dang ky where emailAddress = &#63; from the database.
	 *
	 * @param emailAddress the email address
	 * @return the thong tin dang ky that was removed
	 */
	public static ThongTinDangKy removeByemailAddress(String emailAddress)
		throws dtt.vn.user.service.exception.NoSuchThongTinDangKyException {

		return getPersistence().removeByemailAddress(emailAddress);
	}

	/**
	 * Returns the number of thong tin dang kies where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @return the number of matching thong tin dang kies
	 */
	public static int countByemailAddress(String emailAddress) {
		return getPersistence().countByemailAddress(emailAddress);
	}

	/**
	 * Returns the thong tin dang ky where userName = &#63; or throws a <code>NoSuchThongTinDangKyException</code> if it could not be found.
	 *
	 * @param userName the user name
	 * @return the matching thong tin dang ky
	 * @throws NoSuchThongTinDangKyException if a matching thong tin dang ky could not be found
	 */
	public static ThongTinDangKy findByuserName(String userName)
		throws dtt.vn.user.service.exception.NoSuchThongTinDangKyException {

		return getPersistence().findByuserName(userName);
	}

	/**
	 * Returns the thong tin dang ky where userName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userName the user name
	 * @return the matching thong tin dang ky, or <code>null</code> if a matching thong tin dang ky could not be found
	 */
	public static ThongTinDangKy fetchByuserName(String userName) {
		return getPersistence().fetchByuserName(userName);
	}

	/**
	 * Returns the thong tin dang ky where userName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userName the user name
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching thong tin dang ky, or <code>null</code> if a matching thong tin dang ky could not be found
	 */
	public static ThongTinDangKy fetchByuserName(
		String userName, boolean retrieveFromCache) {

		return getPersistence().fetchByuserName(userName, retrieveFromCache);
	}

	/**
	 * Removes the thong tin dang ky where userName = &#63; from the database.
	 *
	 * @param userName the user name
	 * @return the thong tin dang ky that was removed
	 */
	public static ThongTinDangKy removeByuserName(String userName)
		throws dtt.vn.user.service.exception.NoSuchThongTinDangKyException {

		return getPersistence().removeByuserName(userName);
	}

	/**
	 * Returns the number of thong tin dang kies where userName = &#63;.
	 *
	 * @param userName the user name
	 * @return the number of matching thong tin dang kies
	 */
	public static int countByuserName(String userName) {
		return getPersistence().countByuserName(userName);
	}

	/**
	 * Returns the thong tin dang ky where soGiayTo = &#63; or throws a <code>NoSuchThongTinDangKyException</code> if it could not be found.
	 *
	 * @param soGiayTo the so giay to
	 * @return the matching thong tin dang ky
	 * @throws NoSuchThongTinDangKyException if a matching thong tin dang ky could not be found
	 */
	public static ThongTinDangKy findBysoGiayTo(String soGiayTo)
		throws dtt.vn.user.service.exception.NoSuchThongTinDangKyException {

		return getPersistence().findBysoGiayTo(soGiayTo);
	}

	/**
	 * Returns the thong tin dang ky where soGiayTo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param soGiayTo the so giay to
	 * @return the matching thong tin dang ky, or <code>null</code> if a matching thong tin dang ky could not be found
	 */
	public static ThongTinDangKy fetchBysoGiayTo(String soGiayTo) {
		return getPersistence().fetchBysoGiayTo(soGiayTo);
	}

	/**
	 * Returns the thong tin dang ky where soGiayTo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param soGiayTo the so giay to
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching thong tin dang ky, or <code>null</code> if a matching thong tin dang ky could not be found
	 */
	public static ThongTinDangKy fetchBysoGiayTo(
		String soGiayTo, boolean retrieveFromCache) {

		return getPersistence().fetchBysoGiayTo(soGiayTo, retrieveFromCache);
	}

	/**
	 * Removes the thong tin dang ky where soGiayTo = &#63; from the database.
	 *
	 * @param soGiayTo the so giay to
	 * @return the thong tin dang ky that was removed
	 */
	public static ThongTinDangKy removeBysoGiayTo(String soGiayTo)
		throws dtt.vn.user.service.exception.NoSuchThongTinDangKyException {

		return getPersistence().removeBysoGiayTo(soGiayTo);
	}

	/**
	 * Returns the number of thong tin dang kies where soGiayTo = &#63;.
	 *
	 * @param soGiayTo the so giay to
	 * @return the number of matching thong tin dang kies
	 */
	public static int countBysoGiayTo(String soGiayTo) {
		return getPersistence().countBysoGiayTo(soGiayTo);
	}

	/**
	 * Returns the thong tin dang ky where activeType = &#63; or throws a <code>NoSuchThongTinDangKyException</code> if it could not be found.
	 *
	 * @param activeType the active type
	 * @return the matching thong tin dang ky
	 * @throws NoSuchThongTinDangKyException if a matching thong tin dang ky could not be found
	 */
	public static ThongTinDangKy findByactiveType(String activeType)
		throws dtt.vn.user.service.exception.NoSuchThongTinDangKyException {

		return getPersistence().findByactiveType(activeType);
	}

	/**
	 * Returns the thong tin dang ky where activeType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param activeType the active type
	 * @return the matching thong tin dang ky, or <code>null</code> if a matching thong tin dang ky could not be found
	 */
	public static ThongTinDangKy fetchByactiveType(String activeType) {
		return getPersistence().fetchByactiveType(activeType);
	}

	/**
	 * Returns the thong tin dang ky where activeType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param activeType the active type
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching thong tin dang ky, or <code>null</code> if a matching thong tin dang ky could not be found
	 */
	public static ThongTinDangKy fetchByactiveType(
		String activeType, boolean retrieveFromCache) {

		return getPersistence().fetchByactiveType(
			activeType, retrieveFromCache);
	}

	/**
	 * Removes the thong tin dang ky where activeType = &#63; from the database.
	 *
	 * @param activeType the active type
	 * @return the thong tin dang ky that was removed
	 */
	public static ThongTinDangKy removeByactiveType(String activeType)
		throws dtt.vn.user.service.exception.NoSuchThongTinDangKyException {

		return getPersistence().removeByactiveType(activeType);
	}

	/**
	 * Returns the number of thong tin dang kies where activeType = &#63;.
	 *
	 * @param activeType the active type
	 * @return the number of matching thong tin dang kies
	 */
	public static int countByactiveType(String activeType) {
		return getPersistence().countByactiveType(activeType);
	}

	/**
	 * Caches the thong tin dang ky in the entity cache if it is enabled.
	 *
	 * @param thongTinDangKy the thong tin dang ky
	 */
	public static void cacheResult(ThongTinDangKy thongTinDangKy) {
		getPersistence().cacheResult(thongTinDangKy);
	}

	/**
	 * Caches the thong tin dang kies in the entity cache if it is enabled.
	 *
	 * @param thongTinDangKies the thong tin dang kies
	 */
	public static void cacheResult(List<ThongTinDangKy> thongTinDangKies) {
		getPersistence().cacheResult(thongTinDangKies);
	}

	/**
	 * Creates a new thong tin dang ky with the primary key. Does not add the thong tin dang ky to the database.
	 *
	 * @param id the primary key for the new thong tin dang ky
	 * @return the new thong tin dang ky
	 */
	public static ThongTinDangKy create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the thong tin dang ky with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the thong tin dang ky
	 * @return the thong tin dang ky that was removed
	 * @throws NoSuchThongTinDangKyException if a thong tin dang ky with the primary key could not be found
	 */
	public static ThongTinDangKy remove(long id)
		throws dtt.vn.user.service.exception.NoSuchThongTinDangKyException {

		return getPersistence().remove(id);
	}

	public static ThongTinDangKy updateImpl(ThongTinDangKy thongTinDangKy) {
		return getPersistence().updateImpl(thongTinDangKy);
	}

	/**
	 * Returns the thong tin dang ky with the primary key or throws a <code>NoSuchThongTinDangKyException</code> if it could not be found.
	 *
	 * @param id the primary key of the thong tin dang ky
	 * @return the thong tin dang ky
	 * @throws NoSuchThongTinDangKyException if a thong tin dang ky with the primary key could not be found
	 */
	public static ThongTinDangKy findByPrimaryKey(long id)
		throws dtt.vn.user.service.exception.NoSuchThongTinDangKyException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the thong tin dang ky with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the thong tin dang ky
	 * @return the thong tin dang ky, or <code>null</code> if a thong tin dang ky with the primary key could not be found
	 */
	public static ThongTinDangKy fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the thong tin dang kies.
	 *
	 * @return the thong tin dang kies
	 */
	public static List<ThongTinDangKy> findAll() {
		return getPersistence().findAll();
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
	public static List<ThongTinDangKy> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<ThongTinDangKy> findAll(
		int start, int end,
		OrderByComparator<ThongTinDangKy> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<ThongTinDangKy> findAll(
		int start, int end, OrderByComparator<ThongTinDangKy> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the thong tin dang kies from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of thong tin dang kies.
	 *
	 * @return the number of thong tin dang kies
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static ThongTinDangKyPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ThongTinDangKyPersistence, ThongTinDangKyPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ThongTinDangKyPersistence.class);

		ServiceTracker<ThongTinDangKyPersistence, ThongTinDangKyPersistence>
			serviceTracker =
				new ServiceTracker
					<ThongTinDangKyPersistence, ThongTinDangKyPersistence>(
						bundle.getBundleContext(),
						ThongTinDangKyPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}