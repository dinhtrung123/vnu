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

import org.oep.core.model.PhanQuyen;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the phan quyen service. This utility wraps <code>org.oep.core.service.persistence.impl.PhanQuyenPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author manhlb
 * @see PhanQuyenPersistence
 * @generated
 */
@ProviderType
public class PhanQuyenUtil {

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
	public static void clearCache(PhanQuyen phanQuyen) {
		getPersistence().clearCache(phanQuyen);
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
	public static Map<Serializable, PhanQuyen> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PhanQuyen> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PhanQuyen> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PhanQuyen> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PhanQuyen> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PhanQuyen update(PhanQuyen phanQuyen) {
		return getPersistence().update(phanQuyen);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PhanQuyen update(
		PhanQuyen phanQuyen, ServiceContext serviceContext) {

		return getPersistence().update(phanQuyen, serviceContext);
	}

	/**
	 * Returns the phan quyen where classname = &#63; and classpk = &#63; or throws a <code>NoSuchPhanQuyenException</code> if it could not be found.
	 *
	 * @param classname the classname
	 * @param classpk the classpk
	 * @return the matching phan quyen
	 * @throws NoSuchPhanQuyenException if a matching phan quyen could not be found
	 */
	public static PhanQuyen findByCN_PK(String classname, long classpk)
		throws org.oep.core.exception.NoSuchPhanQuyenException {

		return getPersistence().findByCN_PK(classname, classpk);
	}

	/**
	 * Returns the phan quyen where classname = &#63; and classpk = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param classname the classname
	 * @param classpk the classpk
	 * @return the matching phan quyen, or <code>null</code> if a matching phan quyen could not be found
	 */
	public static PhanQuyen fetchByCN_PK(String classname, long classpk) {
		return getPersistence().fetchByCN_PK(classname, classpk);
	}

	/**
	 * Returns the phan quyen where classname = &#63; and classpk = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param classname the classname
	 * @param classpk the classpk
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching phan quyen, or <code>null</code> if a matching phan quyen could not be found
	 */
	public static PhanQuyen fetchByCN_PK(
		String classname, long classpk, boolean retrieveFromCache) {

		return getPersistence().fetchByCN_PK(
			classname, classpk, retrieveFromCache);
	}

	/**
	 * Removes the phan quyen where classname = &#63; and classpk = &#63; from the database.
	 *
	 * @param classname the classname
	 * @param classpk the classpk
	 * @return the phan quyen that was removed
	 */
	public static PhanQuyen removeByCN_PK(String classname, long classpk)
		throws org.oep.core.exception.NoSuchPhanQuyenException {

		return getPersistence().removeByCN_PK(classname, classpk);
	}

	/**
	 * Returns the number of phan quyens where classname = &#63; and classpk = &#63;.
	 *
	 * @param classname the classname
	 * @param classpk the classpk
	 * @return the number of matching phan quyens
	 */
	public static int countByCN_PK(String classname, long classpk) {
		return getPersistence().countByCN_PK(classname, classpk);
	}

	/**
	 * Caches the phan quyen in the entity cache if it is enabled.
	 *
	 * @param phanQuyen the phan quyen
	 */
	public static void cacheResult(PhanQuyen phanQuyen) {
		getPersistence().cacheResult(phanQuyen);
	}

	/**
	 * Caches the phan quyens in the entity cache if it is enabled.
	 *
	 * @param phanQuyens the phan quyens
	 */
	public static void cacheResult(List<PhanQuyen> phanQuyens) {
		getPersistence().cacheResult(phanQuyens);
	}

	/**
	 * Creates a new phan quyen with the primary key. Does not add the phan quyen to the database.
	 *
	 * @param id the primary key for the new phan quyen
	 * @return the new phan quyen
	 */
	public static PhanQuyen create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the phan quyen with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the phan quyen
	 * @return the phan quyen that was removed
	 * @throws NoSuchPhanQuyenException if a phan quyen with the primary key could not be found
	 */
	public static PhanQuyen remove(long id)
		throws org.oep.core.exception.NoSuchPhanQuyenException {

		return getPersistence().remove(id);
	}

	public static PhanQuyen updateImpl(PhanQuyen phanQuyen) {
		return getPersistence().updateImpl(phanQuyen);
	}

	/**
	 * Returns the phan quyen with the primary key or throws a <code>NoSuchPhanQuyenException</code> if it could not be found.
	 *
	 * @param id the primary key of the phan quyen
	 * @return the phan quyen
	 * @throws NoSuchPhanQuyenException if a phan quyen with the primary key could not be found
	 */
	public static PhanQuyen findByPrimaryKey(long id)
		throws org.oep.core.exception.NoSuchPhanQuyenException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the phan quyen with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the phan quyen
	 * @return the phan quyen, or <code>null</code> if a phan quyen with the primary key could not be found
	 */
	public static PhanQuyen fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the phan quyens.
	 *
	 * @return the phan quyens
	 */
	public static List<PhanQuyen> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the phan quyens.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PhanQuyenModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of phan quyens
	 * @param end the upper bound of the range of phan quyens (not inclusive)
	 * @return the range of phan quyens
	 */
	public static List<PhanQuyen> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the phan quyens.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PhanQuyenModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of phan quyens
	 * @param end the upper bound of the range of phan quyens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of phan quyens
	 */
	public static List<PhanQuyen> findAll(
		int start, int end, OrderByComparator<PhanQuyen> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the phan quyens.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PhanQuyenModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of phan quyens
	 * @param end the upper bound of the range of phan quyens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of phan quyens
	 */
	public static List<PhanQuyen> findAll(
		int start, int end, OrderByComparator<PhanQuyen> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the phan quyens from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of phan quyens.
	 *
	 * @return the number of phan quyens
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PhanQuyenPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PhanQuyenPersistence, PhanQuyenPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PhanQuyenPersistence.class);

		ServiceTracker<PhanQuyenPersistence, PhanQuyenPersistence>
			serviceTracker =
				new ServiceTracker<PhanQuyenPersistence, PhanQuyenPersistence>(
					bundle.getBundleContext(), PhanQuyenPersistence.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}