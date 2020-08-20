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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

import org.oep.core.exception.NoSuchMappingVmapException;
import org.oep.core.model.MappingVmap;

/**
 * The persistence interface for the mapping vmap service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author manhlb
 * @see MappingVmapUtil
 * @generated
 */
@ProviderType
public interface MappingVmapPersistence extends BasePersistence<MappingVmap> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MappingVmapUtil} to access the mapping vmap persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, MappingVmap> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns the mapping vmap where classname = &#63; and classpk = &#63; or throws a <code>NoSuchMappingVmapException</code> if it could not be found.
	 *
	 * @param classname the classname
	 * @param classpk the classpk
	 * @return the matching mapping vmap
	 * @throws NoSuchMappingVmapException if a matching mapping vmap could not be found
	 */
	public MappingVmap findByCN_PK(String classname, long classpk)
		throws NoSuchMappingVmapException;

	/**
	 * Returns the mapping vmap where classname = &#63; and classpk = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param classname the classname
	 * @param classpk the classpk
	 * @return the matching mapping vmap, or <code>null</code> if a matching mapping vmap could not be found
	 */
	public MappingVmap fetchByCN_PK(String classname, long classpk);

	/**
	 * Returns the mapping vmap where classname = &#63; and classpk = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param classname the classname
	 * @param classpk the classpk
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching mapping vmap, or <code>null</code> if a matching mapping vmap could not be found
	 */
	public MappingVmap fetchByCN_PK(
		String classname, long classpk, boolean retrieveFromCache);

	/**
	 * Removes the mapping vmap where classname = &#63; and classpk = &#63; from the database.
	 *
	 * @param classname the classname
	 * @param classpk the classpk
	 * @return the mapping vmap that was removed
	 */
	public MappingVmap removeByCN_PK(String classname, long classpk)
		throws NoSuchMappingVmapException;

	/**
	 * Returns the number of mapping vmaps where classname = &#63; and classpk = &#63;.
	 *
	 * @param classname the classname
	 * @param classpk the classpk
	 * @return the number of matching mapping vmaps
	 */
	public int countByCN_PK(String classname, long classpk);

	/**
	 * Returns the mapping vmap where classpk = &#63; or throws a <code>NoSuchMappingVmapException</code> if it could not be found.
	 *
	 * @param classpk the classpk
	 * @return the matching mapping vmap
	 * @throws NoSuchMappingVmapException if a matching mapping vmap could not be found
	 */
	public MappingVmap findByPK(long classpk) throws NoSuchMappingVmapException;

	/**
	 * Returns the mapping vmap where classpk = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param classpk the classpk
	 * @return the matching mapping vmap, or <code>null</code> if a matching mapping vmap could not be found
	 */
	public MappingVmap fetchByPK(long classpk);

	/**
	 * Returns the mapping vmap where classpk = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param classpk the classpk
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching mapping vmap, or <code>null</code> if a matching mapping vmap could not be found
	 */
	public MappingVmap fetchByPK(long classpk, boolean retrieveFromCache);

	/**
	 * Removes the mapping vmap where classpk = &#63; from the database.
	 *
	 * @param classpk the classpk
	 * @return the mapping vmap that was removed
	 */
	public MappingVmap removeByPK(long classpk)
		throws NoSuchMappingVmapException;

	/**
	 * Returns the number of mapping vmaps where classpk = &#63;.
	 *
	 * @param classpk the classpk
	 * @return the number of matching mapping vmaps
	 */
	public int countByPK(long classpk);

	/**
	 * Caches the mapping vmap in the entity cache if it is enabled.
	 *
	 * @param mappingVmap the mapping vmap
	 */
	public void cacheResult(MappingVmap mappingVmap);

	/**
	 * Caches the mapping vmaps in the entity cache if it is enabled.
	 *
	 * @param mappingVmaps the mapping vmaps
	 */
	public void cacheResult(java.util.List<MappingVmap> mappingVmaps);

	/**
	 * Creates a new mapping vmap with the primary key. Does not add the mapping vmap to the database.
	 *
	 * @param id the primary key for the new mapping vmap
	 * @return the new mapping vmap
	 */
	public MappingVmap create(long id);

	/**
	 * Removes the mapping vmap with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the mapping vmap
	 * @return the mapping vmap that was removed
	 * @throws NoSuchMappingVmapException if a mapping vmap with the primary key could not be found
	 */
	public MappingVmap remove(long id) throws NoSuchMappingVmapException;

	public MappingVmap updateImpl(MappingVmap mappingVmap);

	/**
	 * Returns the mapping vmap with the primary key or throws a <code>NoSuchMappingVmapException</code> if it could not be found.
	 *
	 * @param id the primary key of the mapping vmap
	 * @return the mapping vmap
	 * @throws NoSuchMappingVmapException if a mapping vmap with the primary key could not be found
	 */
	public MappingVmap findByPrimaryKey(long id)
		throws NoSuchMappingVmapException;

	/**
	 * Returns the mapping vmap with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the mapping vmap
	 * @return the mapping vmap, or <code>null</code> if a mapping vmap with the primary key could not be found
	 */
	public MappingVmap fetchByPrimaryKey(long id);

	/**
	 * Returns all the mapping vmaps.
	 *
	 * @return the mapping vmaps
	 */
	public java.util.List<MappingVmap> findAll();

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
	public java.util.List<MappingVmap> findAll(int start, int end);

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
	public java.util.List<MappingVmap> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MappingVmap>
			orderByComparator);

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
	public java.util.List<MappingVmap> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MappingVmap>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the mapping vmaps from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of mapping vmaps.
	 *
	 * @return the number of mapping vmaps
	 */
	public int countAll();

}