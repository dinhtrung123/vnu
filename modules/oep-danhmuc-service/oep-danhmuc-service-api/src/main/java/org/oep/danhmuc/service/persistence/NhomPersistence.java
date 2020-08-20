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

package org.oep.danhmuc.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

import org.oep.danhmuc.exception.NoSuchNhomException;
import org.oep.danhmuc.model.Nhom;

/**
 * The persistence interface for the nhom service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nhanvienDTT
 * @see NhomUtil
 * @generated
 */
@ProviderType
public interface NhomPersistence extends BasePersistence<Nhom> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link NhomUtil} to access the nhom persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, Nhom> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns the nhom where ma = &#63; or throws a <code>NoSuchNhomException</code> if it could not be found.
	 *
	 * @param ma the ma
	 * @return the matching nhom
	 * @throws NoSuchNhomException if a matching nhom could not be found
	 */
	public Nhom findByMa(String ma) throws NoSuchNhomException;

	/**
	 * Returns the nhom where ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ma the ma
	 * @return the matching nhom, or <code>null</code> if a matching nhom could not be found
	 */
	public Nhom fetchByMa(String ma);

	/**
	 * Returns the nhom where ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ma the ma
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching nhom, or <code>null</code> if a matching nhom could not be found
	 */
	public Nhom fetchByMa(String ma, boolean retrieveFromCache);

	/**
	 * Removes the nhom where ma = &#63; from the database.
	 *
	 * @param ma the ma
	 * @return the nhom that was removed
	 */
	public Nhom removeByMa(String ma) throws NoSuchNhomException;

	/**
	 * Returns the number of nhoms where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the number of matching nhoms
	 */
	public int countByMa(String ma);

	/**
	 * Caches the nhom in the entity cache if it is enabled.
	 *
	 * @param nhom the nhom
	 */
	public void cacheResult(Nhom nhom);

	/**
	 * Caches the nhoms in the entity cache if it is enabled.
	 *
	 * @param nhoms the nhoms
	 */
	public void cacheResult(java.util.List<Nhom> nhoms);

	/**
	 * Creates a new nhom with the primary key. Does not add the nhom to the database.
	 *
	 * @param id the primary key for the new nhom
	 * @return the new nhom
	 */
	public Nhom create(long id);

	/**
	 * Removes the nhom with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the nhom
	 * @return the nhom that was removed
	 * @throws NoSuchNhomException if a nhom with the primary key could not be found
	 */
	public Nhom remove(long id) throws NoSuchNhomException;

	public Nhom updateImpl(Nhom nhom);

	/**
	 * Returns the nhom with the primary key or throws a <code>NoSuchNhomException</code> if it could not be found.
	 *
	 * @param id the primary key of the nhom
	 * @return the nhom
	 * @throws NoSuchNhomException if a nhom with the primary key could not be found
	 */
	public Nhom findByPrimaryKey(long id) throws NoSuchNhomException;

	/**
	 * Returns the nhom with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the nhom
	 * @return the nhom, or <code>null</code> if a nhom with the primary key could not be found
	 */
	public Nhom fetchByPrimaryKey(long id);

	/**
	 * Returns all the nhoms.
	 *
	 * @return the nhoms
	 */
	public java.util.List<Nhom> findAll();

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
	public java.util.List<Nhom> findAll(int start, int end);

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
	public java.util.List<Nhom> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Nhom>
			orderByComparator);

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
	public java.util.List<Nhom> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Nhom>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the nhoms from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of nhoms.
	 *
	 * @return the number of nhoms
	 */
	public int countAll();

}