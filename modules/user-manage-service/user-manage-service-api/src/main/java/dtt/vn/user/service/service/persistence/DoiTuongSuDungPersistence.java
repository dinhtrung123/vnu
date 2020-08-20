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

package dtt.vn.user.service.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import dtt.vn.user.service.exception.NoSuchDoiTuongSuDungException;
import dtt.vn.user.service.model.DoiTuongSuDung;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the doi tuong su dung service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nhanvienDTT
 * @see DoiTuongSuDungUtil
 * @generated
 */
@ProviderType
public interface DoiTuongSuDungPersistence
	extends BasePersistence<DoiTuongSuDung> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DoiTuongSuDungUtil} to access the doi tuong su dung persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, DoiTuongSuDung> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns the doi tuong su dung where ma = &#63; or throws a <code>NoSuchDoiTuongSuDungException</code> if it could not be found.
	 *
	 * @param ma the ma
	 * @return the matching doi tuong su dung
	 * @throws NoSuchDoiTuongSuDungException if a matching doi tuong su dung could not be found
	 */
	public DoiTuongSuDung findByMa(String ma)
		throws NoSuchDoiTuongSuDungException;

	/**
	 * Returns the doi tuong su dung where ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ma the ma
	 * @return the matching doi tuong su dung, or <code>null</code> if a matching doi tuong su dung could not be found
	 */
	public DoiTuongSuDung fetchByMa(String ma);

	/**
	 * Returns the doi tuong su dung where ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ma the ma
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching doi tuong su dung, or <code>null</code> if a matching doi tuong su dung could not be found
	 */
	public DoiTuongSuDung fetchByMa(String ma, boolean retrieveFromCache);

	/**
	 * Removes the doi tuong su dung where ma = &#63; from the database.
	 *
	 * @param ma the ma
	 * @return the doi tuong su dung that was removed
	 */
	public DoiTuongSuDung removeByMa(String ma)
		throws NoSuchDoiTuongSuDungException;

	/**
	 * Returns the number of doi tuong su dungs where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the number of matching doi tuong su dungs
	 */
	public int countByMa(String ma);

	/**
	 * Caches the doi tuong su dung in the entity cache if it is enabled.
	 *
	 * @param doiTuongSuDung the doi tuong su dung
	 */
	public void cacheResult(DoiTuongSuDung doiTuongSuDung);

	/**
	 * Caches the doi tuong su dungs in the entity cache if it is enabled.
	 *
	 * @param doiTuongSuDungs the doi tuong su dungs
	 */
	public void cacheResult(java.util.List<DoiTuongSuDung> doiTuongSuDungs);

	/**
	 * Creates a new doi tuong su dung with the primary key. Does not add the doi tuong su dung to the database.
	 *
	 * @param id the primary key for the new doi tuong su dung
	 * @return the new doi tuong su dung
	 */
	public DoiTuongSuDung create(long id);

	/**
	 * Removes the doi tuong su dung with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the doi tuong su dung
	 * @return the doi tuong su dung that was removed
	 * @throws NoSuchDoiTuongSuDungException if a doi tuong su dung with the primary key could not be found
	 */
	public DoiTuongSuDung remove(long id) throws NoSuchDoiTuongSuDungException;

	public DoiTuongSuDung updateImpl(DoiTuongSuDung doiTuongSuDung);

	/**
	 * Returns the doi tuong su dung with the primary key or throws a <code>NoSuchDoiTuongSuDungException</code> if it could not be found.
	 *
	 * @param id the primary key of the doi tuong su dung
	 * @return the doi tuong su dung
	 * @throws NoSuchDoiTuongSuDungException if a doi tuong su dung with the primary key could not be found
	 */
	public DoiTuongSuDung findByPrimaryKey(long id)
		throws NoSuchDoiTuongSuDungException;

	/**
	 * Returns the doi tuong su dung with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the doi tuong su dung
	 * @return the doi tuong su dung, or <code>null</code> if a doi tuong su dung with the primary key could not be found
	 */
	public DoiTuongSuDung fetchByPrimaryKey(long id);

	/**
	 * Returns all the doi tuong su dungs.
	 *
	 * @return the doi tuong su dungs
	 */
	public java.util.List<DoiTuongSuDung> findAll();

	/**
	 * Returns a range of all the doi tuong su dungs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DoiTuongSuDungModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of doi tuong su dungs
	 * @param end the upper bound of the range of doi tuong su dungs (not inclusive)
	 * @return the range of doi tuong su dungs
	 */
	public java.util.List<DoiTuongSuDung> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the doi tuong su dungs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DoiTuongSuDungModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of doi tuong su dungs
	 * @param end the upper bound of the range of doi tuong su dungs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of doi tuong su dungs
	 */
	public java.util.List<DoiTuongSuDung> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DoiTuongSuDung>
			orderByComparator);

	/**
	 * Returns an ordered range of all the doi tuong su dungs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DoiTuongSuDungModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of doi tuong su dungs
	 * @param end the upper bound of the range of doi tuong su dungs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of doi tuong su dungs
	 */
	public java.util.List<DoiTuongSuDung> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DoiTuongSuDung>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the doi tuong su dungs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of doi tuong su dungs.
	 *
	 * @return the number of doi tuong su dungs
	 */
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();

}