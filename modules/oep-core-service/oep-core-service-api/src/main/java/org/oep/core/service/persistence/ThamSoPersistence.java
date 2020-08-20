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

import org.oep.core.exception.NoSuchThamSoException;
import org.oep.core.model.ThamSo;

/**
 * The persistence interface for the tham so service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author manhlb
 * @see ThamSoUtil
 * @generated
 */
@ProviderType
public interface ThamSoPersistence extends BasePersistence<ThamSo> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ThamSoUtil} to access the tham so persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, ThamSo> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns the tham so where groupId = &#63; and ma = &#63; or throws a <code>NoSuchThamSoException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param ma the ma
	 * @return the matching tham so
	 * @throws NoSuchThamSoException if a matching tham so could not be found
	 */
	public ThamSo findByG_M(long groupId, String ma)
		throws NoSuchThamSoException;

	/**
	 * Returns the tham so where groupId = &#63; and ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param ma the ma
	 * @return the matching tham so, or <code>null</code> if a matching tham so could not be found
	 */
	public ThamSo fetchByG_M(long groupId, String ma);

	/**
	 * Returns the tham so where groupId = &#63; and ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param ma the ma
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching tham so, or <code>null</code> if a matching tham so could not be found
	 */
	public ThamSo fetchByG_M(
		long groupId, String ma, boolean retrieveFromCache);

	/**
	 * Removes the tham so where groupId = &#63; and ma = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param ma the ma
	 * @return the tham so that was removed
	 */
	public ThamSo removeByG_M(long groupId, String ma)
		throws NoSuchThamSoException;

	/**
	 * Returns the number of tham sos where groupId = &#63; and ma = &#63;.
	 *
	 * @param groupId the group ID
	 * @param ma the ma
	 * @return the number of matching tham sos
	 */
	public int countByG_M(long groupId, String ma);

	/**
	 * Returns the tham so where ma = &#63; and className = &#63; or throws a <code>NoSuchThamSoException</code> if it could not be found.
	 *
	 * @param ma the ma
	 * @param className the class name
	 * @return the matching tham so
	 * @throws NoSuchThamSoException if a matching tham so could not be found
	 */
	public ThamSo findByM_CL(String ma, String className)
		throws NoSuchThamSoException;

	/**
	 * Returns the tham so where ma = &#63; and className = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ma the ma
	 * @param className the class name
	 * @return the matching tham so, or <code>null</code> if a matching tham so could not be found
	 */
	public ThamSo fetchByM_CL(String ma, String className);

	/**
	 * Returns the tham so where ma = &#63; and className = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ma the ma
	 * @param className the class name
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching tham so, or <code>null</code> if a matching tham so could not be found
	 */
	public ThamSo fetchByM_CL(
		String ma, String className, boolean retrieveFromCache);

	/**
	 * Removes the tham so where ma = &#63; and className = &#63; from the database.
	 *
	 * @param ma the ma
	 * @param className the class name
	 * @return the tham so that was removed
	 */
	public ThamSo removeByM_CL(String ma, String className)
		throws NoSuchThamSoException;

	/**
	 * Returns the number of tham sos where ma = &#63; and className = &#63;.
	 *
	 * @param ma the ma
	 * @param className the class name
	 * @return the number of matching tham sos
	 */
	public int countByM_CL(String ma, String className);

	/**
	 * Returns the tham so where ma = &#63; and className = &#63; and classPK = &#63; or throws a <code>NoSuchThamSoException</code> if it could not be found.
	 *
	 * @param ma the ma
	 * @param className the class name
	 * @param classPK the class pk
	 * @return the matching tham so
	 * @throws NoSuchThamSoException if a matching tham so could not be found
	 */
	public ThamSo findByM_CL_PK(String ma, String className, long classPK)
		throws NoSuchThamSoException;

	/**
	 * Returns the tham so where ma = &#63; and className = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ma the ma
	 * @param className the class name
	 * @param classPK the class pk
	 * @return the matching tham so, or <code>null</code> if a matching tham so could not be found
	 */
	public ThamSo fetchByM_CL_PK(String ma, String className, long classPK);

	/**
	 * Returns the tham so where ma = &#63; and className = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ma the ma
	 * @param className the class name
	 * @param classPK the class pk
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching tham so, or <code>null</code> if a matching tham so could not be found
	 */
	public ThamSo fetchByM_CL_PK(
		String ma, String className, long classPK, boolean retrieveFromCache);

	/**
	 * Removes the tham so where ma = &#63; and className = &#63; and classPK = &#63; from the database.
	 *
	 * @param ma the ma
	 * @param className the class name
	 * @param classPK the class pk
	 * @return the tham so that was removed
	 */
	public ThamSo removeByM_CL_PK(String ma, String className, long classPK)
		throws NoSuchThamSoException;

	/**
	 * Returns the number of tham sos where ma = &#63; and className = &#63; and classPK = &#63;.
	 *
	 * @param ma the ma
	 * @param className the class name
	 * @param classPK the class pk
	 * @return the number of matching tham sos
	 */
	public int countByM_CL_PK(String ma, String className, long classPK);

	/**
	 * Returns all the tham sos where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the matching tham sos
	 */
	public java.util.List<ThamSo> findByMa(String ma);

	/**
	 * Returns a range of all the tham sos where ma = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ThamSoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ma the ma
	 * @param start the lower bound of the range of tham sos
	 * @param end the upper bound of the range of tham sos (not inclusive)
	 * @return the range of matching tham sos
	 */
	public java.util.List<ThamSo> findByMa(String ma, int start, int end);

	/**
	 * Returns an ordered range of all the tham sos where ma = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ThamSoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ma the ma
	 * @param start the lower bound of the range of tham sos
	 * @param end the upper bound of the range of tham sos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tham sos
	 */
	public java.util.List<ThamSo> findByMa(
		String ma, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ThamSo>
			orderByComparator);

	/**
	 * Returns an ordered range of all the tham sos where ma = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ThamSoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ma the ma
	 * @param start the lower bound of the range of tham sos
	 * @param end the upper bound of the range of tham sos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching tham sos
	 */
	public java.util.List<ThamSo> findByMa(
		String ma, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ThamSo>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first tham so in the ordered set where ma = &#63;.
	 *
	 * @param ma the ma
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tham so
	 * @throws NoSuchThamSoException if a matching tham so could not be found
	 */
	public ThamSo findByMa_First(
			String ma,
			com.liferay.portal.kernel.util.OrderByComparator<ThamSo>
				orderByComparator)
		throws NoSuchThamSoException;

	/**
	 * Returns the first tham so in the ordered set where ma = &#63;.
	 *
	 * @param ma the ma
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tham so, or <code>null</code> if a matching tham so could not be found
	 */
	public ThamSo fetchByMa_First(
		String ma,
		com.liferay.portal.kernel.util.OrderByComparator<ThamSo>
			orderByComparator);

	/**
	 * Returns the last tham so in the ordered set where ma = &#63;.
	 *
	 * @param ma the ma
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tham so
	 * @throws NoSuchThamSoException if a matching tham so could not be found
	 */
	public ThamSo findByMa_Last(
			String ma,
			com.liferay.portal.kernel.util.OrderByComparator<ThamSo>
				orderByComparator)
		throws NoSuchThamSoException;

	/**
	 * Returns the last tham so in the ordered set where ma = &#63;.
	 *
	 * @param ma the ma
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tham so, or <code>null</code> if a matching tham so could not be found
	 */
	public ThamSo fetchByMa_Last(
		String ma,
		com.liferay.portal.kernel.util.OrderByComparator<ThamSo>
			orderByComparator);

	/**
	 * Returns the tham sos before and after the current tham so in the ordered set where ma = &#63;.
	 *
	 * @param id the primary key of the current tham so
	 * @param ma the ma
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tham so
	 * @throws NoSuchThamSoException if a tham so with the primary key could not be found
	 */
	public ThamSo[] findByMa_PrevAndNext(
			long id, String ma,
			com.liferay.portal.kernel.util.OrderByComparator<ThamSo>
				orderByComparator)
		throws NoSuchThamSoException;

	/**
	 * Removes all the tham sos where ma = &#63; from the database.
	 *
	 * @param ma the ma
	 */
	public void removeByMa(String ma);

	/**
	 * Returns the number of tham sos where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the number of matching tham sos
	 */
	public int countByMa(String ma);

	/**
	 * Returns all the tham sos where giaTri = &#63;.
	 *
	 * @param giaTri the gia tri
	 * @return the matching tham sos
	 */
	public java.util.List<ThamSo> findBygiaTri(String giaTri);

	/**
	 * Returns a range of all the tham sos where giaTri = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ThamSoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param giaTri the gia tri
	 * @param start the lower bound of the range of tham sos
	 * @param end the upper bound of the range of tham sos (not inclusive)
	 * @return the range of matching tham sos
	 */
	public java.util.List<ThamSo> findBygiaTri(
		String giaTri, int start, int end);

	/**
	 * Returns an ordered range of all the tham sos where giaTri = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ThamSoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param giaTri the gia tri
	 * @param start the lower bound of the range of tham sos
	 * @param end the upper bound of the range of tham sos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tham sos
	 */
	public java.util.List<ThamSo> findBygiaTri(
		String giaTri, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ThamSo>
			orderByComparator);

	/**
	 * Returns an ordered range of all the tham sos where giaTri = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ThamSoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param giaTri the gia tri
	 * @param start the lower bound of the range of tham sos
	 * @param end the upper bound of the range of tham sos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching tham sos
	 */
	public java.util.List<ThamSo> findBygiaTri(
		String giaTri, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ThamSo>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first tham so in the ordered set where giaTri = &#63;.
	 *
	 * @param giaTri the gia tri
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tham so
	 * @throws NoSuchThamSoException if a matching tham so could not be found
	 */
	public ThamSo findBygiaTri_First(
			String giaTri,
			com.liferay.portal.kernel.util.OrderByComparator<ThamSo>
				orderByComparator)
		throws NoSuchThamSoException;

	/**
	 * Returns the first tham so in the ordered set where giaTri = &#63;.
	 *
	 * @param giaTri the gia tri
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tham so, or <code>null</code> if a matching tham so could not be found
	 */
	public ThamSo fetchBygiaTri_First(
		String giaTri,
		com.liferay.portal.kernel.util.OrderByComparator<ThamSo>
			orderByComparator);

	/**
	 * Returns the last tham so in the ordered set where giaTri = &#63;.
	 *
	 * @param giaTri the gia tri
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tham so
	 * @throws NoSuchThamSoException if a matching tham so could not be found
	 */
	public ThamSo findBygiaTri_Last(
			String giaTri,
			com.liferay.portal.kernel.util.OrderByComparator<ThamSo>
				orderByComparator)
		throws NoSuchThamSoException;

	/**
	 * Returns the last tham so in the ordered set where giaTri = &#63;.
	 *
	 * @param giaTri the gia tri
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tham so, or <code>null</code> if a matching tham so could not be found
	 */
	public ThamSo fetchBygiaTri_Last(
		String giaTri,
		com.liferay.portal.kernel.util.OrderByComparator<ThamSo>
			orderByComparator);

	/**
	 * Returns the tham sos before and after the current tham so in the ordered set where giaTri = &#63;.
	 *
	 * @param id the primary key of the current tham so
	 * @param giaTri the gia tri
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tham so
	 * @throws NoSuchThamSoException if a tham so with the primary key could not be found
	 */
	public ThamSo[] findBygiaTri_PrevAndNext(
			long id, String giaTri,
			com.liferay.portal.kernel.util.OrderByComparator<ThamSo>
				orderByComparator)
		throws NoSuchThamSoException;

	/**
	 * Removes all the tham sos where giaTri = &#63; from the database.
	 *
	 * @param giaTri the gia tri
	 */
	public void removeBygiaTri(String giaTri);

	/**
	 * Returns the number of tham sos where giaTri = &#63;.
	 *
	 * @param giaTri the gia tri
	 * @return the number of matching tham sos
	 */
	public int countBygiaTri(String giaTri);

	/**
	 * Returns all the tham sos where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching tham sos
	 */
	public java.util.List<ThamSo> findByGroupId(long groupId);

	/**
	 * Returns a range of all the tham sos where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ThamSoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of tham sos
	 * @param end the upper bound of the range of tham sos (not inclusive)
	 * @return the range of matching tham sos
	 */
	public java.util.List<ThamSo> findByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the tham sos where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ThamSoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of tham sos
	 * @param end the upper bound of the range of tham sos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tham sos
	 */
	public java.util.List<ThamSo> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ThamSo>
			orderByComparator);

	/**
	 * Returns an ordered range of all the tham sos where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ThamSoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of tham sos
	 * @param end the upper bound of the range of tham sos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching tham sos
	 */
	public java.util.List<ThamSo> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ThamSo>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first tham so in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tham so
	 * @throws NoSuchThamSoException if a matching tham so could not be found
	 */
	public ThamSo findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<ThamSo>
				orderByComparator)
		throws NoSuchThamSoException;

	/**
	 * Returns the first tham so in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tham so, or <code>null</code> if a matching tham so could not be found
	 */
	public ThamSo fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<ThamSo>
			orderByComparator);

	/**
	 * Returns the last tham so in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tham so
	 * @throws NoSuchThamSoException if a matching tham so could not be found
	 */
	public ThamSo findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<ThamSo>
				orderByComparator)
		throws NoSuchThamSoException;

	/**
	 * Returns the last tham so in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tham so, or <code>null</code> if a matching tham so could not be found
	 */
	public ThamSo fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<ThamSo>
			orderByComparator);

	/**
	 * Returns the tham sos before and after the current tham so in the ordered set where groupId = &#63;.
	 *
	 * @param id the primary key of the current tham so
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tham so
	 * @throws NoSuchThamSoException if a tham so with the primary key could not be found
	 */
	public ThamSo[] findByGroupId_PrevAndNext(
			long id, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<ThamSo>
				orderByComparator)
		throws NoSuchThamSoException;

	/**
	 * Removes all the tham sos where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of tham sos where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching tham sos
	 */
	public int countByGroupId(long groupId);

	/**
	 * Caches the tham so in the entity cache if it is enabled.
	 *
	 * @param thamSo the tham so
	 */
	public void cacheResult(ThamSo thamSo);

	/**
	 * Caches the tham sos in the entity cache if it is enabled.
	 *
	 * @param thamSos the tham sos
	 */
	public void cacheResult(java.util.List<ThamSo> thamSos);

	/**
	 * Creates a new tham so with the primary key. Does not add the tham so to the database.
	 *
	 * @param id the primary key for the new tham so
	 * @return the new tham so
	 */
	public ThamSo create(long id);

	/**
	 * Removes the tham so with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the tham so
	 * @return the tham so that was removed
	 * @throws NoSuchThamSoException if a tham so with the primary key could not be found
	 */
	public ThamSo remove(long id) throws NoSuchThamSoException;

	public ThamSo updateImpl(ThamSo thamSo);

	/**
	 * Returns the tham so with the primary key or throws a <code>NoSuchThamSoException</code> if it could not be found.
	 *
	 * @param id the primary key of the tham so
	 * @return the tham so
	 * @throws NoSuchThamSoException if a tham so with the primary key could not be found
	 */
	public ThamSo findByPrimaryKey(long id) throws NoSuchThamSoException;

	/**
	 * Returns the tham so with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the tham so
	 * @return the tham so, or <code>null</code> if a tham so with the primary key could not be found
	 */
	public ThamSo fetchByPrimaryKey(long id);

	/**
	 * Returns all the tham sos.
	 *
	 * @return the tham sos
	 */
	public java.util.List<ThamSo> findAll();

	/**
	 * Returns a range of all the tham sos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ThamSoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tham sos
	 * @param end the upper bound of the range of tham sos (not inclusive)
	 * @return the range of tham sos
	 */
	public java.util.List<ThamSo> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the tham sos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ThamSoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tham sos
	 * @param end the upper bound of the range of tham sos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tham sos
	 */
	public java.util.List<ThamSo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ThamSo>
			orderByComparator);

	/**
	 * Returns an ordered range of all the tham sos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ThamSoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tham sos
	 * @param end the upper bound of the range of tham sos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of tham sos
	 */
	public java.util.List<ThamSo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ThamSo>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the tham sos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of tham sos.
	 *
	 * @return the number of tham sos
	 */
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();

}