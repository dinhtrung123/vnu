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

package org.oep.core.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.oep.core.model.TrungTamHanhChinh;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the trung tam hanh chinh service. This utility wraps <code>org.oep.core.service.persistence.impl.TrungTamHanhChinhPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author manhlb
 * @see TrungTamHanhChinhPersistence
 * @generated
 */
@ProviderType
public class TrungTamHanhChinhUtil {

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
	public static void clearCache(TrungTamHanhChinh trungTamHanhChinh) {
		getPersistence().clearCache(trungTamHanhChinh);
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
	public static Map<Serializable, TrungTamHanhChinh> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TrungTamHanhChinh> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TrungTamHanhChinh> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TrungTamHanhChinh> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TrungTamHanhChinh> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TrungTamHanhChinh update(
		TrungTamHanhChinh trungTamHanhChinh) {

		return getPersistence().update(trungTamHanhChinh);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TrungTamHanhChinh update(
		TrungTamHanhChinh trungTamHanhChinh, ServiceContext serviceContext) {

		return getPersistence().update(trungTamHanhChinh, serviceContext);
	}

	/**
	 * Returns the trung tam hanh chinh where ma = &#63; or throws a <code>NoSuchTrungTamHanhChinhException</code> if it could not be found.
	 *
	 * @param ma the ma
	 * @return the matching trung tam hanh chinh
	 * @throws NoSuchTrungTamHanhChinhException if a matching trung tam hanh chinh could not be found
	 */
	public static TrungTamHanhChinh findByMa(String ma)
		throws org.oep.core.exception.NoSuchTrungTamHanhChinhException {

		return getPersistence().findByMa(ma);
	}

	/**
	 * Returns the trung tam hanh chinh where ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ma the ma
	 * @return the matching trung tam hanh chinh, or <code>null</code> if a matching trung tam hanh chinh could not be found
	 */
	public static TrungTamHanhChinh fetchByMa(String ma) {
		return getPersistence().fetchByMa(ma);
	}

	/**
	 * Returns the trung tam hanh chinh where ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ma the ma
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching trung tam hanh chinh, or <code>null</code> if a matching trung tam hanh chinh could not be found
	 */
	public static TrungTamHanhChinh fetchByMa(
		String ma, boolean retrieveFromCache) {

		return getPersistence().fetchByMa(ma, retrieveFromCache);
	}

	/**
	 * Removes the trung tam hanh chinh where ma = &#63; from the database.
	 *
	 * @param ma the ma
	 * @return the trung tam hanh chinh that was removed
	 */
	public static TrungTamHanhChinh removeByMa(String ma)
		throws org.oep.core.exception.NoSuchTrungTamHanhChinhException {

		return getPersistence().removeByMa(ma);
	}

	/**
	 * Returns the number of trung tam hanh chinhs where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the number of matching trung tam hanh chinhs
	 */
	public static int countByMa(String ma) {
		return getPersistence().countByMa(ma);
	}

	/**
	 * Returns the trung tam hanh chinh where donViId = &#63; or throws a <code>NoSuchTrungTamHanhChinhException</code> if it could not be found.
	 *
	 * @param donViId the don vi ID
	 * @return the matching trung tam hanh chinh
	 * @throws NoSuchTrungTamHanhChinhException if a matching trung tam hanh chinh could not be found
	 */
	public static TrungTamHanhChinh findBydonViId(long donViId)
		throws org.oep.core.exception.NoSuchTrungTamHanhChinhException {

		return getPersistence().findBydonViId(donViId);
	}

	/**
	 * Returns the trung tam hanh chinh where donViId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param donViId the don vi ID
	 * @return the matching trung tam hanh chinh, or <code>null</code> if a matching trung tam hanh chinh could not be found
	 */
	public static TrungTamHanhChinh fetchBydonViId(long donViId) {
		return getPersistence().fetchBydonViId(donViId);
	}

	/**
	 * Returns the trung tam hanh chinh where donViId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param donViId the don vi ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching trung tam hanh chinh, or <code>null</code> if a matching trung tam hanh chinh could not be found
	 */
	public static TrungTamHanhChinh fetchBydonViId(
		long donViId, boolean retrieveFromCache) {

		return getPersistence().fetchBydonViId(donViId, retrieveFromCache);
	}

	/**
	 * Removes the trung tam hanh chinh where donViId = &#63; from the database.
	 *
	 * @param donViId the don vi ID
	 * @return the trung tam hanh chinh that was removed
	 */
	public static TrungTamHanhChinh removeBydonViId(long donViId)
		throws org.oep.core.exception.NoSuchTrungTamHanhChinhException {

		return getPersistence().removeBydonViId(donViId);
	}

	/**
	 * Returns the number of trung tam hanh chinhs where donViId = &#63;.
	 *
	 * @param donViId the don vi ID
	 * @return the number of matching trung tam hanh chinhs
	 */
	public static int countBydonViId(long donViId) {
		return getPersistence().countBydonViId(donViId);
	}

	/**
	 * Caches the trung tam hanh chinh in the entity cache if it is enabled.
	 *
	 * @param trungTamHanhChinh the trung tam hanh chinh
	 */
	public static void cacheResult(TrungTamHanhChinh trungTamHanhChinh) {
		getPersistence().cacheResult(trungTamHanhChinh);
	}

	/**
	 * Caches the trung tam hanh chinhs in the entity cache if it is enabled.
	 *
	 * @param trungTamHanhChinhs the trung tam hanh chinhs
	 */
	public static void cacheResult(List<TrungTamHanhChinh> trungTamHanhChinhs) {
		getPersistence().cacheResult(trungTamHanhChinhs);
	}

	/**
	 * Creates a new trung tam hanh chinh with the primary key. Does not add the trung tam hanh chinh to the database.
	 *
	 * @param id the primary key for the new trung tam hanh chinh
	 * @return the new trung tam hanh chinh
	 */
	public static TrungTamHanhChinh create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the trung tam hanh chinh with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the trung tam hanh chinh
	 * @return the trung tam hanh chinh that was removed
	 * @throws NoSuchTrungTamHanhChinhException if a trung tam hanh chinh with the primary key could not be found
	 */
	public static TrungTamHanhChinh remove(long id)
		throws org.oep.core.exception.NoSuchTrungTamHanhChinhException {

		return getPersistence().remove(id);
	}

	public static TrungTamHanhChinh updateImpl(
		TrungTamHanhChinh trungTamHanhChinh) {

		return getPersistence().updateImpl(trungTamHanhChinh);
	}

	/**
	 * Returns the trung tam hanh chinh with the primary key or throws a <code>NoSuchTrungTamHanhChinhException</code> if it could not be found.
	 *
	 * @param id the primary key of the trung tam hanh chinh
	 * @return the trung tam hanh chinh
	 * @throws NoSuchTrungTamHanhChinhException if a trung tam hanh chinh with the primary key could not be found
	 */
	public static TrungTamHanhChinh findByPrimaryKey(long id)
		throws org.oep.core.exception.NoSuchTrungTamHanhChinhException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the trung tam hanh chinh with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the trung tam hanh chinh
	 * @return the trung tam hanh chinh, or <code>null</code> if a trung tam hanh chinh with the primary key could not be found
	 */
	public static TrungTamHanhChinh fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the trung tam hanh chinhs.
	 *
	 * @return the trung tam hanh chinhs
	 */
	public static List<TrungTamHanhChinh> findAll() {
		return getPersistence().findAll();
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
	public static List<TrungTamHanhChinh> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<TrungTamHanhChinh> findAll(
		int start, int end,
		OrderByComparator<TrungTamHanhChinh> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<TrungTamHanhChinh> findAll(
		int start, int end,
		OrderByComparator<TrungTamHanhChinh> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the trung tam hanh chinhs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of trung tam hanh chinhs.
	 *
	 * @return the number of trung tam hanh chinhs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static TrungTamHanhChinhPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<TrungTamHanhChinhPersistence, TrungTamHanhChinhPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			TrungTamHanhChinhPersistence.class);

		ServiceTracker
			<TrungTamHanhChinhPersistence, TrungTamHanhChinhPersistence>
				serviceTracker =
					new ServiceTracker
						<TrungTamHanhChinhPersistence,
						 TrungTamHanhChinhPersistence>(
							 bundle.getBundleContext(),
							 TrungTamHanhChinhPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}