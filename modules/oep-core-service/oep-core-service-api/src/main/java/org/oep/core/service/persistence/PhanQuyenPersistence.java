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

import org.oep.core.exception.NoSuchPhanQuyenException;
import org.oep.core.model.PhanQuyen;

/**
 * The persistence interface for the phan quyen service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author manhlb
 * @see PhanQuyenUtil
 * @generated
 */
@ProviderType
public interface PhanQuyenPersistence extends BasePersistence<PhanQuyen> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PhanQuyenUtil} to access the phan quyen persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, PhanQuyen> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns the phan quyen where classname = &#63; and classpk = &#63; or throws a <code>NoSuchPhanQuyenException</code> if it could not be found.
	 *
	 * @param classname the classname
	 * @param classpk the classpk
	 * @return the matching phan quyen
	 * @throws NoSuchPhanQuyenException if a matching phan quyen could not be found
	 */
	public PhanQuyen findByCN_PK(String classname, long classpk)
		throws NoSuchPhanQuyenException;

	/**
	 * Returns the phan quyen where classname = &#63; and classpk = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param classname the classname
	 * @param classpk the classpk
	 * @return the matching phan quyen, or <code>null</code> if a matching phan quyen could not be found
	 */
	public PhanQuyen fetchByCN_PK(String classname, long classpk);

	/**
	 * Returns the phan quyen where classname = &#63; and classpk = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param classname the classname
	 * @param classpk the classpk
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching phan quyen, or <code>null</code> if a matching phan quyen could not be found
	 */
	public PhanQuyen fetchByCN_PK(
		String classname, long classpk, boolean retrieveFromCache);

	/**
	 * Removes the phan quyen where classname = &#63; and classpk = &#63; from the database.
	 *
	 * @param classname the classname
	 * @param classpk the classpk
	 * @return the phan quyen that was removed
	 */
	public PhanQuyen removeByCN_PK(String classname, long classpk)
		throws NoSuchPhanQuyenException;

	/**
	 * Returns the number of phan quyens where classname = &#63; and classpk = &#63;.
	 *
	 * @param classname the classname
	 * @param classpk the classpk
	 * @return the number of matching phan quyens
	 */
	public int countByCN_PK(String classname, long classpk);

	/**
	 * Caches the phan quyen in the entity cache if it is enabled.
	 *
	 * @param phanQuyen the phan quyen
	 */
	public void cacheResult(PhanQuyen phanQuyen);

	/**
	 * Caches the phan quyens in the entity cache if it is enabled.
	 *
	 * @param phanQuyens the phan quyens
	 */
	public void cacheResult(java.util.List<PhanQuyen> phanQuyens);

	/**
	 * Creates a new phan quyen with the primary key. Does not add the phan quyen to the database.
	 *
	 * @param id the primary key for the new phan quyen
	 * @return the new phan quyen
	 */
	public PhanQuyen create(long id);

	/**
	 * Removes the phan quyen with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the phan quyen
	 * @return the phan quyen that was removed
	 * @throws NoSuchPhanQuyenException if a phan quyen with the primary key could not be found
	 */
	public PhanQuyen remove(long id) throws NoSuchPhanQuyenException;

	public PhanQuyen updateImpl(PhanQuyen phanQuyen);

	/**
	 * Returns the phan quyen with the primary key or throws a <code>NoSuchPhanQuyenException</code> if it could not be found.
	 *
	 * @param id the primary key of the phan quyen
	 * @return the phan quyen
	 * @throws NoSuchPhanQuyenException if a phan quyen with the primary key could not be found
	 */
	public PhanQuyen findByPrimaryKey(long id) throws NoSuchPhanQuyenException;

	/**
	 * Returns the phan quyen with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the phan quyen
	 * @return the phan quyen, or <code>null</code> if a phan quyen with the primary key could not be found
	 */
	public PhanQuyen fetchByPrimaryKey(long id);

	/**
	 * Returns all the phan quyens.
	 *
	 * @return the phan quyens
	 */
	public java.util.List<PhanQuyen> findAll();

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
	public java.util.List<PhanQuyen> findAll(int start, int end);

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
	public java.util.List<PhanQuyen> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PhanQuyen>
			orderByComparator);

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
	public java.util.List<PhanQuyen> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PhanQuyen>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the phan quyens from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of phan quyens.
	 *
	 * @return the number of phan quyens
	 */
	public int countAll();

}