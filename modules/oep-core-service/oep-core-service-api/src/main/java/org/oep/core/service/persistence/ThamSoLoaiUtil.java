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

import org.oep.core.model.ThamSoLoai;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the tham so loai service. This utility wraps <code>org.oep.core.service.persistence.impl.ThamSoLoaiPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author manhlb
 * @see ThamSoLoaiPersistence
 * @generated
 */
@ProviderType
public class ThamSoLoaiUtil {

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
	public static void clearCache(ThamSoLoai thamSoLoai) {
		getPersistence().clearCache(thamSoLoai);
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
	public static Map<Serializable, ThamSoLoai> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ThamSoLoai> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ThamSoLoai> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ThamSoLoai> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ThamSoLoai> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ThamSoLoai update(ThamSoLoai thamSoLoai) {
		return getPersistence().update(thamSoLoai);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ThamSoLoai update(
		ThamSoLoai thamSoLoai, ServiceContext serviceContext) {

		return getPersistence().update(thamSoLoai, serviceContext);
	}

	/**
	 * Returns all the tham so loais where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the matching tham so loais
	 */
	public static List<ThamSoLoai> findByTen(String ten) {
		return getPersistence().findByTen(ten);
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
	public static List<ThamSoLoai> findByTen(String ten, int start, int end) {
		return getPersistence().findByTen(ten, start, end);
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
	public static List<ThamSoLoai> findByTen(
		String ten, int start, int end,
		OrderByComparator<ThamSoLoai> orderByComparator) {

		return getPersistence().findByTen(ten, start, end, orderByComparator);
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
	public static List<ThamSoLoai> findByTen(
		String ten, int start, int end,
		OrderByComparator<ThamSoLoai> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByTen(
			ten, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first tham so loai in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tham so loai
	 * @throws NoSuchThamSoLoaiException if a matching tham so loai could not be found
	 */
	public static ThamSoLoai findByTen_First(
			String ten, OrderByComparator<ThamSoLoai> orderByComparator)
		throws org.oep.core.exception.NoSuchThamSoLoaiException {

		return getPersistence().findByTen_First(ten, orderByComparator);
	}

	/**
	 * Returns the first tham so loai in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tham so loai, or <code>null</code> if a matching tham so loai could not be found
	 */
	public static ThamSoLoai fetchByTen_First(
		String ten, OrderByComparator<ThamSoLoai> orderByComparator) {

		return getPersistence().fetchByTen_First(ten, orderByComparator);
	}

	/**
	 * Returns the last tham so loai in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tham so loai
	 * @throws NoSuchThamSoLoaiException if a matching tham so loai could not be found
	 */
	public static ThamSoLoai findByTen_Last(
			String ten, OrderByComparator<ThamSoLoai> orderByComparator)
		throws org.oep.core.exception.NoSuchThamSoLoaiException {

		return getPersistence().findByTen_Last(ten, orderByComparator);
	}

	/**
	 * Returns the last tham so loai in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tham so loai, or <code>null</code> if a matching tham so loai could not be found
	 */
	public static ThamSoLoai fetchByTen_Last(
		String ten, OrderByComparator<ThamSoLoai> orderByComparator) {

		return getPersistence().fetchByTen_Last(ten, orderByComparator);
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
	public static ThamSoLoai[] findByTen_PrevAndNext(
			long id, String ten,
			OrderByComparator<ThamSoLoai> orderByComparator)
		throws org.oep.core.exception.NoSuchThamSoLoaiException {

		return getPersistence().findByTen_PrevAndNext(
			id, ten, orderByComparator);
	}

	/**
	 * Removes all the tham so loais where ten = &#63; from the database.
	 *
	 * @param ten the ten
	 */
	public static void removeByTen(String ten) {
		getPersistence().removeByTen(ten);
	}

	/**
	 * Returns the number of tham so loais where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the number of matching tham so loais
	 */
	public static int countByTen(String ten) {
		return getPersistence().countByTen(ten);
	}

	/**
	 * Caches the tham so loai in the entity cache if it is enabled.
	 *
	 * @param thamSoLoai the tham so loai
	 */
	public static void cacheResult(ThamSoLoai thamSoLoai) {
		getPersistence().cacheResult(thamSoLoai);
	}

	/**
	 * Caches the tham so loais in the entity cache if it is enabled.
	 *
	 * @param thamSoLoais the tham so loais
	 */
	public static void cacheResult(List<ThamSoLoai> thamSoLoais) {
		getPersistence().cacheResult(thamSoLoais);
	}

	/**
	 * Creates a new tham so loai with the primary key. Does not add the tham so loai to the database.
	 *
	 * @param id the primary key for the new tham so loai
	 * @return the new tham so loai
	 */
	public static ThamSoLoai create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the tham so loai with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the tham so loai
	 * @return the tham so loai that was removed
	 * @throws NoSuchThamSoLoaiException if a tham so loai with the primary key could not be found
	 */
	public static ThamSoLoai remove(long id)
		throws org.oep.core.exception.NoSuchThamSoLoaiException {

		return getPersistence().remove(id);
	}

	public static ThamSoLoai updateImpl(ThamSoLoai thamSoLoai) {
		return getPersistence().updateImpl(thamSoLoai);
	}

	/**
	 * Returns the tham so loai with the primary key or throws a <code>NoSuchThamSoLoaiException</code> if it could not be found.
	 *
	 * @param id the primary key of the tham so loai
	 * @return the tham so loai
	 * @throws NoSuchThamSoLoaiException if a tham so loai with the primary key could not be found
	 */
	public static ThamSoLoai findByPrimaryKey(long id)
		throws org.oep.core.exception.NoSuchThamSoLoaiException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the tham so loai with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the tham so loai
	 * @return the tham so loai, or <code>null</code> if a tham so loai with the primary key could not be found
	 */
	public static ThamSoLoai fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the tham so loais.
	 *
	 * @return the tham so loais
	 */
	public static List<ThamSoLoai> findAll() {
		return getPersistence().findAll();
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
	public static List<ThamSoLoai> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<ThamSoLoai> findAll(
		int start, int end, OrderByComparator<ThamSoLoai> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<ThamSoLoai> findAll(
		int start, int end, OrderByComparator<ThamSoLoai> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the tham so loais from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of tham so loais.
	 *
	 * @return the number of tham so loais
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static ThamSoLoaiPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ThamSoLoaiPersistence, ThamSoLoaiPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ThamSoLoaiPersistence.class);

		ServiceTracker<ThamSoLoaiPersistence, ThamSoLoaiPersistence>
			serviceTracker =
				new ServiceTracker
					<ThamSoLoaiPersistence, ThamSoLoaiPersistence>(
						bundle.getBundleContext(), ThamSoLoaiPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}