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

import org.oep.core.model.MappingVmap;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the mapping vmap service. This utility wraps <code>org.oep.core.service.persistence.impl.MappingVmapPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author manhlb
 * @see MappingVmapPersistence
 * @generated
 */
@ProviderType
public class MappingVmapUtil {

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
	public static void clearCache(MappingVmap mappingVmap) {
		getPersistence().clearCache(mappingVmap);
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
	public static Map<Serializable, MappingVmap> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<MappingVmap> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MappingVmap> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MappingVmap> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<MappingVmap> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static MappingVmap update(MappingVmap mappingVmap) {
		return getPersistence().update(mappingVmap);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static MappingVmap update(
		MappingVmap mappingVmap, ServiceContext serviceContext) {

		return getPersistence().update(mappingVmap, serviceContext);
	}

	/**
	 * Returns the mapping vmap where classname = &#63; and classpk = &#63; or throws a <code>NoSuchMappingVmapException</code> if it could not be found.
	 *
	 * @param classname the classname
	 * @param classpk the classpk
	 * @return the matching mapping vmap
	 * @throws NoSuchMappingVmapException if a matching mapping vmap could not be found
	 */
	public static MappingVmap findByCN_PK(String classname, long classpk)
		throws org.oep.core.exception.NoSuchMappingVmapException {

		return getPersistence().findByCN_PK(classname, classpk);
	}

	/**
	 * Returns the mapping vmap where classname = &#63; and classpk = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param classname the classname
	 * @param classpk the classpk
	 * @return the matching mapping vmap, or <code>null</code> if a matching mapping vmap could not be found
	 */
	public static MappingVmap fetchByCN_PK(String classname, long classpk) {
		return getPersistence().fetchByCN_PK(classname, classpk);
	}

	/**
	 * Returns the mapping vmap where classname = &#63; and classpk = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param classname the classname
	 * @param classpk the classpk
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching mapping vmap, or <code>null</code> if a matching mapping vmap could not be found
	 */
	public static MappingVmap fetchByCN_PK(
		String classname, long classpk, boolean retrieveFromCache) {

		return getPersistence().fetchByCN_PK(
			classname, classpk, retrieveFromCache);
	}

	/**
	 * Removes the mapping vmap where classname = &#63; and classpk = &#63; from the database.
	 *
	 * @param classname the classname
	 * @param classpk the classpk
	 * @return the mapping vmap that was removed
	 */
	public static MappingVmap removeByCN_PK(String classname, long classpk)
		throws org.oep.core.exception.NoSuchMappingVmapException {

		return getPersistence().removeByCN_PK(classname, classpk);
	}

	/**
	 * Returns the number of mapping vmaps where classname = &#63; and classpk = &#63;.
	 *
	 * @param classname the classname
	 * @param classpk the classpk
	 * @return the number of matching mapping vmaps
	 */
	public static int countByCN_PK(String classname, long classpk) {
		return getPersistence().countByCN_PK(classname, classpk);
	}

	/**
	 * Returns the mapping vmap where classpk = &#63; or throws a <code>NoSuchMappingVmapException</code> if it could not be found.
	 *
	 * @param classpk the classpk
	 * @return the matching mapping vmap
	 * @throws NoSuchMappingVmapException if a matching mapping vmap could not be found
	 */
	public static MappingVmap findByPK(long classpk)
		throws org.oep.core.exception.NoSuchMappingVmapException {

		return getPersistence().findByPK(classpk);
	}

	/**
	 * Returns the mapping vmap where classpk = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param classpk the classpk
	 * @return the matching mapping vmap, or <code>null</code> if a matching mapping vmap could not be found
	 */
	public static MappingVmap fetchByPK(long classpk) {
		return getPersistence().fetchByPK(classpk);
	}

	/**
	 * Returns the mapping vmap where classpk = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param classpk the classpk
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching mapping vmap, or <code>null</code> if a matching mapping vmap could not be found
	 */
	public static MappingVmap fetchByPK(
		long classpk, boolean retrieveFromCache) {

		return getPersistence().fetchByPK(classpk, retrieveFromCache);
	}

	/**
	 * Removes the mapping vmap where classpk = &#63; from the database.
	 *
	 * @param classpk the classpk
	 * @return the mapping vmap that was removed
	 */
	public static MappingVmap removeByPK(long classpk)
		throws org.oep.core.exception.NoSuchMappingVmapException {

		return getPersistence().removeByPK(classpk);
	}

	/**
	 * Returns the number of mapping vmaps where classpk = &#63;.
	 *
	 * @param classpk the classpk
	 * @return the number of matching mapping vmaps
	 */
	public static int countByPK(long classpk) {
		return getPersistence().countByPK(classpk);
	}

	/**
	 * Caches the mapping vmap in the entity cache if it is enabled.
	 *
	 * @param mappingVmap the mapping vmap
	 */
	public static void cacheResult(MappingVmap mappingVmap) {
		getPersistence().cacheResult(mappingVmap);
	}

	/**
	 * Caches the mapping vmaps in the entity cache if it is enabled.
	 *
	 * @param mappingVmaps the mapping vmaps
	 */
	public static void cacheResult(List<MappingVmap> mappingVmaps) {
		getPersistence().cacheResult(mappingVmaps);
	}

	/**
	 * Creates a new mapping vmap with the primary key. Does not add the mapping vmap to the database.
	 *
	 * @param id the primary key for the new mapping vmap
	 * @return the new mapping vmap
	 */
	public static MappingVmap create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the mapping vmap with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the mapping vmap
	 * @return the mapping vmap that was removed
	 * @throws NoSuchMappingVmapException if a mapping vmap with the primary key could not be found
	 */
	public static MappingVmap remove(long id)
		throws org.oep.core.exception.NoSuchMappingVmapException {

		return getPersistence().remove(id);
	}

	public static MappingVmap updateImpl(MappingVmap mappingVmap) {
		return getPersistence().updateImpl(mappingVmap);
	}

	/**
	 * Returns the mapping vmap with the primary key or throws a <code>NoSuchMappingVmapException</code> if it could not be found.
	 *
	 * @param id the primary key of the mapping vmap
	 * @return the mapping vmap
	 * @throws NoSuchMappingVmapException if a mapping vmap with the primary key could not be found
	 */
	public static MappingVmap findByPrimaryKey(long id)
		throws org.oep.core.exception.NoSuchMappingVmapException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the mapping vmap with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the mapping vmap
	 * @return the mapping vmap, or <code>null</code> if a mapping vmap with the primary key could not be found
	 */
	public static MappingVmap fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the mapping vmaps.
	 *
	 * @return the mapping vmaps
	 */
	public static List<MappingVmap> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the mapping vmaps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MappingVmapModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of mapping vmaps
	 * @param end the upper bound of the range of mapping vmaps (not inclusive)
	 * @return the range of mapping vmaps
	 */
	public static List<MappingVmap> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the mapping vmaps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MappingVmapModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of mapping vmaps
	 * @param end the upper bound of the range of mapping vmaps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of mapping vmaps
	 */
	public static List<MappingVmap> findAll(
		int start, int end, OrderByComparator<MappingVmap> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the mapping vmaps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MappingVmapModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of mapping vmaps
	 * @param end the upper bound of the range of mapping vmaps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of mapping vmaps
	 */
	public static List<MappingVmap> findAll(
		int start, int end, OrderByComparator<MappingVmap> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the mapping vmaps from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of mapping vmaps.
	 *
	 * @return the number of mapping vmaps
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MappingVmapPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<MappingVmapPersistence, MappingVmapPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(MappingVmapPersistence.class);

		ServiceTracker<MappingVmapPersistence, MappingVmapPersistence>
			serviceTracker =
				new ServiceTracker
					<MappingVmapPersistence, MappingVmapPersistence>(
						bundle.getBundleContext(), MappingVmapPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}