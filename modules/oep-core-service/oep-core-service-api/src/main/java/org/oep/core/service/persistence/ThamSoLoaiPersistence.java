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

import org.oep.core.exception.NoSuchThamSoLoaiException;
import org.oep.core.model.ThamSoLoai;

/**
 * The persistence interface for the tham so loai service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author manhlb
 * @see ThamSoLoaiUtil
 * @generated
 */
@ProviderType
public interface ThamSoLoaiPersistence extends BasePersistence<ThamSoLoai> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ThamSoLoaiUtil} to access the tham so loai persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, ThamSoLoai> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the tham so loais where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the matching tham so loais
	 */
	public java.util.List<ThamSoLoai> findByTen(String ten);

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
	public java.util.List<ThamSoLoai> findByTen(String ten, int start, int end);

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
	public java.util.List<ThamSoLoai> findByTen(
		String ten, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ThamSoLoai>
			orderByComparator);

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
	public java.util.List<ThamSoLoai> findByTen(
		String ten, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ThamSoLoai>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first tham so loai in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tham so loai
	 * @throws NoSuchThamSoLoaiException if a matching tham so loai could not be found
	 */
	public ThamSoLoai findByTen_First(
			String ten,
			com.liferay.portal.kernel.util.OrderByComparator<ThamSoLoai>
				orderByComparator)
		throws NoSuchThamSoLoaiException;

	/**
	 * Returns the first tham so loai in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tham so loai, or <code>null</code> if a matching tham so loai could not be found
	 */
	public ThamSoLoai fetchByTen_First(
		String ten,
		com.liferay.portal.kernel.util.OrderByComparator<ThamSoLoai>
			orderByComparator);

	/**
	 * Returns the last tham so loai in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tham so loai
	 * @throws NoSuchThamSoLoaiException if a matching tham so loai could not be found
	 */
	public ThamSoLoai findByTen_Last(
			String ten,
			com.liferay.portal.kernel.util.OrderByComparator<ThamSoLoai>
				orderByComparator)
		throws NoSuchThamSoLoaiException;

	/**
	 * Returns the last tham so loai in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tham so loai, or <code>null</code> if a matching tham so loai could not be found
	 */
	public ThamSoLoai fetchByTen_Last(
		String ten,
		com.liferay.portal.kernel.util.OrderByComparator<ThamSoLoai>
			orderByComparator);

	/**
	 * Returns the tham so loais before and after the current tham so loai in the ordered set where ten = &#63;.
	 *
	 * @param id the primary key of the current tham so loai
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tham so loai
	 * @throws NoSuchThamSoLoaiException if a tham so loai with the primary key could not be found
	 */
	public ThamSoLoai[] findByTen_PrevAndNext(
			long id, String ten,
			com.liferay.portal.kernel.util.OrderByComparator<ThamSoLoai>
				orderByComparator)
		throws NoSuchThamSoLoaiException;

	/**
	 * Removes all the tham so loais where ten = &#63; from the database.
	 *
	 * @param ten the ten
	 */
	public void removeByTen(String ten);

	/**
	 * Returns the number of tham so loais where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the number of matching tham so loais
	 */
	public int countByTen(String ten);

	/**
	 * Caches the tham so loai in the entity cache if it is enabled.
	 *
	 * @param thamSoLoai the tham so loai
	 */
	public void cacheResult(ThamSoLoai thamSoLoai);

	/**
	 * Caches the tham so loais in the entity cache if it is enabled.
	 *
	 * @param thamSoLoais the tham so loais
	 */
	public void cacheResult(java.util.List<ThamSoLoai> thamSoLoais);

	/**
	 * Creates a new tham so loai with the primary key. Does not add the tham so loai to the database.
	 *
	 * @param id the primary key for the new tham so loai
	 * @return the new tham so loai
	 */
	public ThamSoLoai create(long id);

	/**
	 * Removes the tham so loai with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the tham so loai
	 * @return the tham so loai that was removed
	 * @throws NoSuchThamSoLoaiException if a tham so loai with the primary key could not be found
	 */
	public ThamSoLoai remove(long id) throws NoSuchThamSoLoaiException;

	public ThamSoLoai updateImpl(ThamSoLoai thamSoLoai);

	/**
	 * Returns the tham so loai with the primary key or throws a <code>NoSuchThamSoLoaiException</code> if it could not be found.
	 *
	 * @param id the primary key of the tham so loai
	 * @return the tham so loai
	 * @throws NoSuchThamSoLoaiException if a tham so loai with the primary key could not be found
	 */
	public ThamSoLoai findByPrimaryKey(long id)
		throws NoSuchThamSoLoaiException;

	/**
	 * Returns the tham so loai with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the tham so loai
	 * @return the tham so loai, or <code>null</code> if a tham so loai with the primary key could not be found
	 */
	public ThamSoLoai fetchByPrimaryKey(long id);

	/**
	 * Returns all the tham so loais.
	 *
	 * @return the tham so loais
	 */
	public java.util.List<ThamSoLoai> findAll();

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
	public java.util.List<ThamSoLoai> findAll(int start, int end);

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
	public java.util.List<ThamSoLoai> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ThamSoLoai>
			orderByComparator);

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
	public java.util.List<ThamSoLoai> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ThamSoLoai>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the tham so loais from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of tham so loais.
	 *
	 * @return the number of tham so loais
	 */
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();

}