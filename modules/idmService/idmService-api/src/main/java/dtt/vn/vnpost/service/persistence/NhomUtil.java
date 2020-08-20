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

package dtt.vn.vnpost.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import dtt.vn.vnpost.model.Nhom;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the nhom service. This utility wraps <code>dtt.vn.vnpost.service.persistence.impl.NhomPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NhomPersistence
 * @generated
 */
@ProviderType
public class NhomUtil {

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
	public static void clearCache(Nhom nhom) {
		getPersistence().clearCache(nhom);
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
	public static Map<Serializable, Nhom> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Nhom> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Nhom> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Nhom> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Nhom> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Nhom update(Nhom nhom) {
		return getPersistence().update(nhom);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Nhom update(Nhom nhom, ServiceContext serviceContext) {
		return getPersistence().update(nhom, serviceContext);
	}

	/**
	 * Returns the nhom where ma = &#63; or throws a <code>NoSuchNhomException</code> if it could not be found.
	 *
	 * @param ma the ma
	 * @return the matching nhom
	 * @throws NoSuchNhomException if a matching nhom could not be found
	 */
	public static Nhom findByMa(String ma)
		throws dtt.vn.vnpost.exception.NoSuchNhomException {

		return getPersistence().findByMa(ma);
	}

	/**
	 * Returns the nhom where ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ma the ma
	 * @return the matching nhom, or <code>null</code> if a matching nhom could not be found
	 */
	public static Nhom fetchByMa(String ma) {
		return getPersistence().fetchByMa(ma);
	}

	/**
	 * Returns the nhom where ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ma the ma
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching nhom, or <code>null</code> if a matching nhom could not be found
	 */
	public static Nhom fetchByMa(String ma, boolean retrieveFromCache) {
		return getPersistence().fetchByMa(ma, retrieveFromCache);
	}

	/**
	 * Removes the nhom where ma = &#63; from the database.
	 *
	 * @param ma the ma
	 * @return the nhom that was removed
	 */
	public static Nhom removeByMa(String ma)
		throws dtt.vn.vnpost.exception.NoSuchNhomException {

		return getPersistence().removeByMa(ma);
	}

	/**
	 * Returns the number of nhoms where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the number of matching nhoms
	 */
	public static int countByMa(String ma) {
		return getPersistence().countByMa(ma);
	}

	/**
	 * Caches the nhom in the entity cache if it is enabled.
	 *
	 * @param nhom the nhom
	 */
	public static void cacheResult(Nhom nhom) {
		getPersistence().cacheResult(nhom);
	}

	/**
	 * Caches the nhoms in the entity cache if it is enabled.
	 *
	 * @param nhoms the nhoms
	 */
	public static void cacheResult(List<Nhom> nhoms) {
		getPersistence().cacheResult(nhoms);
	}

	/**
	 * Creates a new nhom with the primary key. Does not add the nhom to the database.
	 *
	 * @param id the primary key for the new nhom
	 * @return the new nhom
	 */
	public static Nhom create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the nhom with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the nhom
	 * @return the nhom that was removed
	 * @throws NoSuchNhomException if a nhom with the primary key could not be found
	 */
	public static Nhom remove(long id)
		throws dtt.vn.vnpost.exception.NoSuchNhomException {

		return getPersistence().remove(id);
	}

	public static Nhom updateImpl(Nhom nhom) {
		return getPersistence().updateImpl(nhom);
	}

	/**
	 * Returns the nhom with the primary key or throws a <code>NoSuchNhomException</code> if it could not be found.
	 *
	 * @param id the primary key of the nhom
	 * @return the nhom
	 * @throws NoSuchNhomException if a nhom with the primary key could not be found
	 */
	public static Nhom findByPrimaryKey(long id)
		throws dtt.vn.vnpost.exception.NoSuchNhomException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the nhom with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the nhom
	 * @return the nhom, or <code>null</code> if a nhom with the primary key could not be found
	 */
	public static Nhom fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the nhoms.
	 *
	 * @return the nhoms
	 */
	public static List<Nhom> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the nhoms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>NhomModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of nhoms
	 * @param end the upper bound of the range of nhoms (not inclusive)
	 * @return the range of nhoms
	 */
	public static List<Nhom> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the nhoms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>NhomModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of nhoms
	 * @param end the upper bound of the range of nhoms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of nhoms
	 */
	public static List<Nhom> findAll(
		int start, int end, OrderByComparator<Nhom> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the nhoms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>NhomModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of nhoms
	 * @param end the upper bound of the range of nhoms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of nhoms
	 */
	public static List<Nhom> findAll(
		int start, int end, OrderByComparator<Nhom> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the nhoms from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of nhoms.
	 *
	 * @return the number of nhoms
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static NhomPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<NhomPersistence, NhomPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(NhomPersistence.class);

		ServiceTracker<NhomPersistence, NhomPersistence> serviceTracker =
			new ServiceTracker<NhomPersistence, NhomPersistence>(
				bundle.getBundleContext(), NhomPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}