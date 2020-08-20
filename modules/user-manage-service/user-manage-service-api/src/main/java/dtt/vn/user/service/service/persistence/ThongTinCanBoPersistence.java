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

import dtt.vn.user.service.exception.NoSuchThongTinCanBoException;
import dtt.vn.user.service.model.ThongTinCanBo;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the thong tin can bo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nhanvienDTT
 * @see ThongTinCanBoUtil
 * @generated
 */
@ProviderType
public interface ThongTinCanBoPersistence
	extends BasePersistence<ThongTinCanBo> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ThongTinCanBoUtil} to access the thong tin can bo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, ThongTinCanBo> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns the thong tin can bo where emailAddress = &#63; or throws a <code>NoSuchThongTinCanBoException</code> if it could not be found.
	 *
	 * @param emailAddress the email address
	 * @return the matching thong tin can bo
	 * @throws NoSuchThongTinCanBoException if a matching thong tin can bo could not be found
	 */
	public ThongTinCanBo findByemailAddress(String emailAddress)
		throws NoSuchThongTinCanBoException;

	/**
	 * Returns the thong tin can bo where emailAddress = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param emailAddress the email address
	 * @return the matching thong tin can bo, or <code>null</code> if a matching thong tin can bo could not be found
	 */
	public ThongTinCanBo fetchByemailAddress(String emailAddress);

	/**
	 * Returns the thong tin can bo where emailAddress = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param emailAddress the email address
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching thong tin can bo, or <code>null</code> if a matching thong tin can bo could not be found
	 */
	public ThongTinCanBo fetchByemailAddress(
		String emailAddress, boolean retrieveFromCache);

	/**
	 * Removes the thong tin can bo where emailAddress = &#63; from the database.
	 *
	 * @param emailAddress the email address
	 * @return the thong tin can bo that was removed
	 */
	public ThongTinCanBo removeByemailAddress(String emailAddress)
		throws NoSuchThongTinCanBoException;

	/**
	 * Returns the number of thong tin can bos where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @return the number of matching thong tin can bos
	 */
	public int countByemailAddress(String emailAddress);

	/**
	 * Returns the thong tin can bo where userName = &#63; or throws a <code>NoSuchThongTinCanBoException</code> if it could not be found.
	 *
	 * @param userName the user name
	 * @return the matching thong tin can bo
	 * @throws NoSuchThongTinCanBoException if a matching thong tin can bo could not be found
	 */
	public ThongTinCanBo findByuserName(String userName)
		throws NoSuchThongTinCanBoException;

	/**
	 * Returns the thong tin can bo where userName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userName the user name
	 * @return the matching thong tin can bo, or <code>null</code> if a matching thong tin can bo could not be found
	 */
	public ThongTinCanBo fetchByuserName(String userName);

	/**
	 * Returns the thong tin can bo where userName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userName the user name
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching thong tin can bo, or <code>null</code> if a matching thong tin can bo could not be found
	 */
	public ThongTinCanBo fetchByuserName(
		String userName, boolean retrieveFromCache);

	/**
	 * Removes the thong tin can bo where userName = &#63; from the database.
	 *
	 * @param userName the user name
	 * @return the thong tin can bo that was removed
	 */
	public ThongTinCanBo removeByuserName(String userName)
		throws NoSuchThongTinCanBoException;

	/**
	 * Returns the number of thong tin can bos where userName = &#63;.
	 *
	 * @param userName the user name
	 * @return the number of matching thong tin can bos
	 */
	public int countByuserName(String userName);

	/**
	 * Returns all the thong tin can bos where nameRole = &#63;.
	 *
	 * @param nameRole the name role
	 * @return the matching thong tin can bos
	 */
	public java.util.List<ThongTinCanBo> findBynameRole(String nameRole);

	/**
	 * Returns a range of all the thong tin can bos where nameRole = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ThongTinCanBoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nameRole the name role
	 * @param start the lower bound of the range of thong tin can bos
	 * @param end the upper bound of the range of thong tin can bos (not inclusive)
	 * @return the range of matching thong tin can bos
	 */
	public java.util.List<ThongTinCanBo> findBynameRole(
		String nameRole, int start, int end);

	/**
	 * Returns an ordered range of all the thong tin can bos where nameRole = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ThongTinCanBoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nameRole the name role
	 * @param start the lower bound of the range of thong tin can bos
	 * @param end the upper bound of the range of thong tin can bos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching thong tin can bos
	 */
	public java.util.List<ThongTinCanBo> findBynameRole(
		String nameRole, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ThongTinCanBo>
			orderByComparator);

	/**
	 * Returns an ordered range of all the thong tin can bos where nameRole = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ThongTinCanBoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nameRole the name role
	 * @param start the lower bound of the range of thong tin can bos
	 * @param end the upper bound of the range of thong tin can bos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching thong tin can bos
	 */
	public java.util.List<ThongTinCanBo> findBynameRole(
		String nameRole, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ThongTinCanBo>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first thong tin can bo in the ordered set where nameRole = &#63;.
	 *
	 * @param nameRole the name role
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching thong tin can bo
	 * @throws NoSuchThongTinCanBoException if a matching thong tin can bo could not be found
	 */
	public ThongTinCanBo findBynameRole_First(
			String nameRole,
			com.liferay.portal.kernel.util.OrderByComparator<ThongTinCanBo>
				orderByComparator)
		throws NoSuchThongTinCanBoException;

	/**
	 * Returns the first thong tin can bo in the ordered set where nameRole = &#63;.
	 *
	 * @param nameRole the name role
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching thong tin can bo, or <code>null</code> if a matching thong tin can bo could not be found
	 */
	public ThongTinCanBo fetchBynameRole_First(
		String nameRole,
		com.liferay.portal.kernel.util.OrderByComparator<ThongTinCanBo>
			orderByComparator);

	/**
	 * Returns the last thong tin can bo in the ordered set where nameRole = &#63;.
	 *
	 * @param nameRole the name role
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching thong tin can bo
	 * @throws NoSuchThongTinCanBoException if a matching thong tin can bo could not be found
	 */
	public ThongTinCanBo findBynameRole_Last(
			String nameRole,
			com.liferay.portal.kernel.util.OrderByComparator<ThongTinCanBo>
				orderByComparator)
		throws NoSuchThongTinCanBoException;

	/**
	 * Returns the last thong tin can bo in the ordered set where nameRole = &#63;.
	 *
	 * @param nameRole the name role
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching thong tin can bo, or <code>null</code> if a matching thong tin can bo could not be found
	 */
	public ThongTinCanBo fetchBynameRole_Last(
		String nameRole,
		com.liferay.portal.kernel.util.OrderByComparator<ThongTinCanBo>
			orderByComparator);

	/**
	 * Returns the thong tin can bos before and after the current thong tin can bo in the ordered set where nameRole = &#63;.
	 *
	 * @param id the primary key of the current thong tin can bo
	 * @param nameRole the name role
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next thong tin can bo
	 * @throws NoSuchThongTinCanBoException if a thong tin can bo with the primary key could not be found
	 */
	public ThongTinCanBo[] findBynameRole_PrevAndNext(
			long id, String nameRole,
			com.liferay.portal.kernel.util.OrderByComparator<ThongTinCanBo>
				orderByComparator)
		throws NoSuchThongTinCanBoException;

	/**
	 * Removes all the thong tin can bos where nameRole = &#63; from the database.
	 *
	 * @param nameRole the name role
	 */
	public void removeBynameRole(String nameRole);

	/**
	 * Returns the number of thong tin can bos where nameRole = &#63;.
	 *
	 * @param nameRole the name role
	 * @return the number of matching thong tin can bos
	 */
	public int countBynameRole(String nameRole);

	/**
	 * Caches the thong tin can bo in the entity cache if it is enabled.
	 *
	 * @param thongTinCanBo the thong tin can bo
	 */
	public void cacheResult(ThongTinCanBo thongTinCanBo);

	/**
	 * Caches the thong tin can bos in the entity cache if it is enabled.
	 *
	 * @param thongTinCanBos the thong tin can bos
	 */
	public void cacheResult(java.util.List<ThongTinCanBo> thongTinCanBos);

	/**
	 * Creates a new thong tin can bo with the primary key. Does not add the thong tin can bo to the database.
	 *
	 * @param id the primary key for the new thong tin can bo
	 * @return the new thong tin can bo
	 */
	public ThongTinCanBo create(long id);

	/**
	 * Removes the thong tin can bo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the thong tin can bo
	 * @return the thong tin can bo that was removed
	 * @throws NoSuchThongTinCanBoException if a thong tin can bo with the primary key could not be found
	 */
	public ThongTinCanBo remove(long id) throws NoSuchThongTinCanBoException;

	public ThongTinCanBo updateImpl(ThongTinCanBo thongTinCanBo);

	/**
	 * Returns the thong tin can bo with the primary key or throws a <code>NoSuchThongTinCanBoException</code> if it could not be found.
	 *
	 * @param id the primary key of the thong tin can bo
	 * @return the thong tin can bo
	 * @throws NoSuchThongTinCanBoException if a thong tin can bo with the primary key could not be found
	 */
	public ThongTinCanBo findByPrimaryKey(long id)
		throws NoSuchThongTinCanBoException;

	/**
	 * Returns the thong tin can bo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the thong tin can bo
	 * @return the thong tin can bo, or <code>null</code> if a thong tin can bo with the primary key could not be found
	 */
	public ThongTinCanBo fetchByPrimaryKey(long id);

	/**
	 * Returns all the thong tin can bos.
	 *
	 * @return the thong tin can bos
	 */
	public java.util.List<ThongTinCanBo> findAll();

	/**
	 * Returns a range of all the thong tin can bos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ThongTinCanBoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of thong tin can bos
	 * @param end the upper bound of the range of thong tin can bos (not inclusive)
	 * @return the range of thong tin can bos
	 */
	public java.util.List<ThongTinCanBo> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the thong tin can bos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ThongTinCanBoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of thong tin can bos
	 * @param end the upper bound of the range of thong tin can bos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of thong tin can bos
	 */
	public java.util.List<ThongTinCanBo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ThongTinCanBo>
			orderByComparator);

	/**
	 * Returns an ordered range of all the thong tin can bos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ThongTinCanBoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of thong tin can bos
	 * @param end the upper bound of the range of thong tin can bos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of thong tin can bos
	 */
	public java.util.List<ThongTinCanBo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ThongTinCanBo>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the thong tin can bos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of thong tin can bos.
	 *
	 * @return the number of thong tin can bos
	 */
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();

}