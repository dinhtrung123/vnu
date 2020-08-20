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

import org.oep.core.exception.NoSuchTrungTamHanhChinhException;
import org.oep.core.model.TrungTamHanhChinh;

/**
 * The persistence interface for the trung tam hanh chinh service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author manhlb
 * @see TrungTamHanhChinhUtil
 * @generated
 */
@ProviderType
public interface TrungTamHanhChinhPersistence
	extends BasePersistence<TrungTamHanhChinh> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TrungTamHanhChinhUtil} to access the trung tam hanh chinh persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, TrungTamHanhChinh> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns the trung tam hanh chinh where ma = &#63; or throws a <code>NoSuchTrungTamHanhChinhException</code> if it could not be found.
	 *
	 * @param ma the ma
	 * @return the matching trung tam hanh chinh
	 * @throws NoSuchTrungTamHanhChinhException if a matching trung tam hanh chinh could not be found
	 */
	public TrungTamHanhChinh findByMa(String ma)
		throws NoSuchTrungTamHanhChinhException;

	/**
	 * Returns the trung tam hanh chinh where ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ma the ma
	 * @return the matching trung tam hanh chinh, or <code>null</code> if a matching trung tam hanh chinh could not be found
	 */
	public TrungTamHanhChinh fetchByMa(String ma);

	/**
	 * Returns the trung tam hanh chinh where ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ma the ma
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching trung tam hanh chinh, or <code>null</code> if a matching trung tam hanh chinh could not be found
	 */
	public TrungTamHanhChinh fetchByMa(String ma, boolean retrieveFromCache);

	/**
	 * Removes the trung tam hanh chinh where ma = &#63; from the database.
	 *
	 * @param ma the ma
	 * @return the trung tam hanh chinh that was removed
	 */
	public TrungTamHanhChinh removeByMa(String ma)
		throws NoSuchTrungTamHanhChinhException;

	/**
	 * Returns the number of trung tam hanh chinhs where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the number of matching trung tam hanh chinhs
	 */
	public int countByMa(String ma);

	/**
	 * Returns the trung tam hanh chinh where donViId = &#63; or throws a <code>NoSuchTrungTamHanhChinhException</code> if it could not be found.
	 *
	 * @param donViId the don vi ID
	 * @return the matching trung tam hanh chinh
	 * @throws NoSuchTrungTamHanhChinhException if a matching trung tam hanh chinh could not be found
	 */
	public TrungTamHanhChinh findBydonViId(long donViId)
		throws NoSuchTrungTamHanhChinhException;

	/**
	 * Returns the trung tam hanh chinh where donViId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param donViId the don vi ID
	 * @return the matching trung tam hanh chinh, or <code>null</code> if a matching trung tam hanh chinh could not be found
	 */
	public TrungTamHanhChinh fetchBydonViId(long donViId);

	/**
	 * Returns the trung tam hanh chinh where donViId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param donViId the don vi ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching trung tam hanh chinh, or <code>null</code> if a matching trung tam hanh chinh could not be found
	 */
	public TrungTamHanhChinh fetchBydonViId(
		long donViId, boolean retrieveFromCache);

	/**
	 * Removes the trung tam hanh chinh where donViId = &#63; from the database.
	 *
	 * @param donViId the don vi ID
	 * @return the trung tam hanh chinh that was removed
	 */
	public TrungTamHanhChinh removeBydonViId(long donViId)
		throws NoSuchTrungTamHanhChinhException;

	/**
	 * Returns the number of trung tam hanh chinhs where donViId = &#63;.
	 *
	 * @param donViId the don vi ID
	 * @return the number of matching trung tam hanh chinhs
	 */
	public int countBydonViId(long donViId);

	/**
	 * Caches the trung tam hanh chinh in the entity cache if it is enabled.
	 *
	 * @param trungTamHanhChinh the trung tam hanh chinh
	 */
	public void cacheResult(TrungTamHanhChinh trungTamHanhChinh);

	/**
	 * Caches the trung tam hanh chinhs in the entity cache if it is enabled.
	 *
	 * @param trungTamHanhChinhs the trung tam hanh chinhs
	 */
	public void cacheResult(
		java.util.List<TrungTamHanhChinh> trungTamHanhChinhs);

	/**
	 * Creates a new trung tam hanh chinh with the primary key. Does not add the trung tam hanh chinh to the database.
	 *
	 * @param id the primary key for the new trung tam hanh chinh
	 * @return the new trung tam hanh chinh
	 */
	public TrungTamHanhChinh create(long id);

	/**
	 * Removes the trung tam hanh chinh with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the trung tam hanh chinh
	 * @return the trung tam hanh chinh that was removed
	 * @throws NoSuchTrungTamHanhChinhException if a trung tam hanh chinh with the primary key could not be found
	 */
	public TrungTamHanhChinh remove(long id)
		throws NoSuchTrungTamHanhChinhException;

	public TrungTamHanhChinh updateImpl(TrungTamHanhChinh trungTamHanhChinh);

	/**
	 * Returns the trung tam hanh chinh with the primary key or throws a <code>NoSuchTrungTamHanhChinhException</code> if it could not be found.
	 *
	 * @param id the primary key of the trung tam hanh chinh
	 * @return the trung tam hanh chinh
	 * @throws NoSuchTrungTamHanhChinhException if a trung tam hanh chinh with the primary key could not be found
	 */
	public TrungTamHanhChinh findByPrimaryKey(long id)
		throws NoSuchTrungTamHanhChinhException;

	/**
	 * Returns the trung tam hanh chinh with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the trung tam hanh chinh
	 * @return the trung tam hanh chinh, or <code>null</code> if a trung tam hanh chinh with the primary key could not be found
	 */
	public TrungTamHanhChinh fetchByPrimaryKey(long id);

	/**
	 * Returns all the trung tam hanh chinhs.
	 *
	 * @return the trung tam hanh chinhs
	 */
	public java.util.List<TrungTamHanhChinh> findAll();

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
	public java.util.List<TrungTamHanhChinh> findAll(int start, int end);

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
	public java.util.List<TrungTamHanhChinh> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TrungTamHanhChinh>
			orderByComparator);

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
	public java.util.List<TrungTamHanhChinh> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TrungTamHanhChinh>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the trung tam hanh chinhs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of trung tam hanh chinhs.
	 *
	 * @return the number of trung tam hanh chinhs
	 */
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();

}