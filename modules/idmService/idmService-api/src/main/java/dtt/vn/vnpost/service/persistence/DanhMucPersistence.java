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

package dtt.vn.vnpost.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import dtt.vn.vnpost.exception.NoSuchDanhMucException;
import dtt.vn.vnpost.model.DanhMuc;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the danh muc service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DanhMucUtil
 * @generated
 */
@ProviderType
public interface DanhMucPersistence extends BasePersistence<DanhMuc> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DanhMucUtil} to access the danh muc persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, DanhMuc> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns the danh muc where ma = &#63; or throws a <code>NoSuchDanhMucException</code> if it could not be found.
	 *
	 * @param ma the ma
	 * @return the matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	public DanhMuc findByM(String ma) throws NoSuchDanhMucException;

	/**
	 * Returns the danh muc where ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ma the ma
	 * @return the matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public DanhMuc fetchByM(String ma);

	/**
	 * Returns the danh muc where ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ma the ma
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public DanhMuc fetchByM(String ma, boolean retrieveFromCache);

	/**
	 * Removes the danh muc where ma = &#63; from the database.
	 *
	 * @param ma the ma
	 * @return the danh muc that was removed
	 */
	public DanhMuc removeByM(String ma) throws NoSuchDanhMucException;

	/**
	 * Returns the number of danh mucs where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the number of matching danh mucs
	 */
	public int countByM(String ma);

	/**
	 * Returns the danh muc where ten = &#63; or throws a <code>NoSuchDanhMucException</code> if it could not be found.
	 *
	 * @param ten the ten
	 * @return the matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	public DanhMuc findByT(String ten) throws NoSuchDanhMucException;

	/**
	 * Returns the danh muc where ten = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ten the ten
	 * @return the matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public DanhMuc fetchByT(String ten);

	/**
	 * Returns the danh muc where ten = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ten the ten
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public DanhMuc fetchByT(String ten, boolean retrieveFromCache);

	/**
	 * Removes the danh muc where ten = &#63; from the database.
	 *
	 * @param ten the ten
	 * @return the danh muc that was removed
	 */
	public DanhMuc removeByT(String ten) throws NoSuchDanhMucException;

	/**
	 * Returns the number of danh mucs where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the number of matching danh mucs
	 */
	public int countByT(String ten);

	/**
	 * Returns the danh muc where chaId = &#63; and ten = &#63; or throws a <code>NoSuchDanhMucException</code> if it could not be found.
	 *
	 * @param chaId the cha ID
	 * @param ten the ten
	 * @return the matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	public DanhMuc findByP_T(long chaId, String ten)
		throws NoSuchDanhMucException;

	/**
	 * Returns the danh muc where chaId = &#63; and ten = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param chaId the cha ID
	 * @param ten the ten
	 * @return the matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public DanhMuc fetchByP_T(long chaId, String ten);

	/**
	 * Returns the danh muc where chaId = &#63; and ten = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param chaId the cha ID
	 * @param ten the ten
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public DanhMuc fetchByP_T(
		long chaId, String ten, boolean retrieveFromCache);

	/**
	 * Removes the danh muc where chaId = &#63; and ten = &#63; from the database.
	 *
	 * @param chaId the cha ID
	 * @param ten the ten
	 * @return the danh muc that was removed
	 */
	public DanhMuc removeByP_T(long chaId, String ten)
		throws NoSuchDanhMucException;

	/**
	 * Returns the number of danh mucs where chaId = &#63; and ten = &#63;.
	 *
	 * @param chaId the cha ID
	 * @param ten the ten
	 * @return the number of matching danh mucs
	 */
	public int countByP_T(long chaId, String ten);

	/**
	 * Returns all the danh mucs where chaId = &#63; and trangThai = &#63;.
	 *
	 * @param chaId the cha ID
	 * @param trangThai the trang thai
	 * @return the matching danh mucs
	 */
	public java.util.List<DanhMuc> findByCha_TrangThai(
		long chaId, boolean trangThai);

	/**
	 * Returns a range of all the danh mucs where chaId = &#63; and trangThai = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param chaId the cha ID
	 * @param trangThai the trang thai
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @return the range of matching danh mucs
	 */
	public java.util.List<DanhMuc> findByCha_TrangThai(
		long chaId, boolean trangThai, int start, int end);

	/**
	 * Returns an ordered range of all the danh mucs where chaId = &#63; and trangThai = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param chaId the cha ID
	 * @param trangThai the trang thai
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching danh mucs
	 */
	public java.util.List<DanhMuc> findByCha_TrangThai(
		long chaId, boolean trangThai, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
			orderByComparator);

	/**
	 * Returns an ordered range of all the danh mucs where chaId = &#63; and trangThai = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param chaId the cha ID
	 * @param trangThai the trang thai
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching danh mucs
	 */
	public java.util.List<DanhMuc> findByCha_TrangThai(
		long chaId, boolean trangThai, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first danh muc in the ordered set where chaId = &#63; and trangThai = &#63;.
	 *
	 * @param chaId the cha ID
	 * @param trangThai the trang thai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	public DanhMuc findByCha_TrangThai_First(
			long chaId, boolean trangThai,
			com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
				orderByComparator)
		throws NoSuchDanhMucException;

	/**
	 * Returns the first danh muc in the ordered set where chaId = &#63; and trangThai = &#63;.
	 *
	 * @param chaId the cha ID
	 * @param trangThai the trang thai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public DanhMuc fetchByCha_TrangThai_First(
		long chaId, boolean trangThai,
		com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
			orderByComparator);

	/**
	 * Returns the last danh muc in the ordered set where chaId = &#63; and trangThai = &#63;.
	 *
	 * @param chaId the cha ID
	 * @param trangThai the trang thai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	public DanhMuc findByCha_TrangThai_Last(
			long chaId, boolean trangThai,
			com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
				orderByComparator)
		throws NoSuchDanhMucException;

	/**
	 * Returns the last danh muc in the ordered set where chaId = &#63; and trangThai = &#63;.
	 *
	 * @param chaId the cha ID
	 * @param trangThai the trang thai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public DanhMuc fetchByCha_TrangThai_Last(
		long chaId, boolean trangThai,
		com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
			orderByComparator);

	/**
	 * Returns the danh mucs before and after the current danh muc in the ordered set where chaId = &#63; and trangThai = &#63;.
	 *
	 * @param id the primary key of the current danh muc
	 * @param chaId the cha ID
	 * @param trangThai the trang thai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next danh muc
	 * @throws NoSuchDanhMucException if a danh muc with the primary key could not be found
	 */
	public DanhMuc[] findByCha_TrangThai_PrevAndNext(
			long id, long chaId, boolean trangThai,
			com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
				orderByComparator)
		throws NoSuchDanhMucException;

	/**
	 * Removes all the danh mucs where chaId = &#63; and trangThai = &#63; from the database.
	 *
	 * @param chaId the cha ID
	 * @param trangThai the trang thai
	 */
	public void removeByCha_TrangThai(long chaId, boolean trangThai);

	/**
	 * Returns the number of danh mucs where chaId = &#63; and trangThai = &#63;.
	 *
	 * @param chaId the cha ID
	 * @param trangThai the trang thai
	 * @return the number of matching danh mucs
	 */
	public int countByCha_TrangThai(long chaId, boolean trangThai);

	/**
	 * Returns all the danh mucs where chaId = &#63;.
	 *
	 * @param chaId the cha ID
	 * @return the matching danh mucs
	 */
	public java.util.List<DanhMuc> findByChaId(long chaId);

	/**
	 * Returns a range of all the danh mucs where chaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param chaId the cha ID
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @return the range of matching danh mucs
	 */
	public java.util.List<DanhMuc> findByChaId(long chaId, int start, int end);

	/**
	 * Returns an ordered range of all the danh mucs where chaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param chaId the cha ID
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching danh mucs
	 */
	public java.util.List<DanhMuc> findByChaId(
		long chaId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
			orderByComparator);

	/**
	 * Returns an ordered range of all the danh mucs where chaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param chaId the cha ID
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching danh mucs
	 */
	public java.util.List<DanhMuc> findByChaId(
		long chaId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first danh muc in the ordered set where chaId = &#63;.
	 *
	 * @param chaId the cha ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	public DanhMuc findByChaId_First(
			long chaId,
			com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
				orderByComparator)
		throws NoSuchDanhMucException;

	/**
	 * Returns the first danh muc in the ordered set where chaId = &#63;.
	 *
	 * @param chaId the cha ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public DanhMuc fetchByChaId_First(
		long chaId,
		com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
			orderByComparator);

	/**
	 * Returns the last danh muc in the ordered set where chaId = &#63;.
	 *
	 * @param chaId the cha ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	public DanhMuc findByChaId_Last(
			long chaId,
			com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
				orderByComparator)
		throws NoSuchDanhMucException;

	/**
	 * Returns the last danh muc in the ordered set where chaId = &#63;.
	 *
	 * @param chaId the cha ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public DanhMuc fetchByChaId_Last(
		long chaId,
		com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
			orderByComparator);

	/**
	 * Returns the danh mucs before and after the current danh muc in the ordered set where chaId = &#63;.
	 *
	 * @param id the primary key of the current danh muc
	 * @param chaId the cha ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next danh muc
	 * @throws NoSuchDanhMucException if a danh muc with the primary key could not be found
	 */
	public DanhMuc[] findByChaId_PrevAndNext(
			long id, long chaId,
			com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
				orderByComparator)
		throws NoSuchDanhMucException;

	/**
	 * Removes all the danh mucs where chaId = &#63; from the database.
	 *
	 * @param chaId the cha ID
	 */
	public void removeByChaId(long chaId);

	/**
	 * Returns the number of danh mucs where chaId = &#63;.
	 *
	 * @param chaId the cha ID
	 * @return the number of matching danh mucs
	 */
	public int countByChaId(long chaId);

	/**
	 * Returns all the danh mucs where muc = &#63;.
	 *
	 * @param muc the muc
	 * @return the matching danh mucs
	 */
	public java.util.List<DanhMuc> findByMUC(int muc);

	/**
	 * Returns a range of all the danh mucs where muc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param muc the muc
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @return the range of matching danh mucs
	 */
	public java.util.List<DanhMuc> findByMUC(int muc, int start, int end);

	/**
	 * Returns an ordered range of all the danh mucs where muc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param muc the muc
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching danh mucs
	 */
	public java.util.List<DanhMuc> findByMUC(
		int muc, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
			orderByComparator);

	/**
	 * Returns an ordered range of all the danh mucs where muc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param muc the muc
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching danh mucs
	 */
	public java.util.List<DanhMuc> findByMUC(
		int muc, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first danh muc in the ordered set where muc = &#63;.
	 *
	 * @param muc the muc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	public DanhMuc findByMUC_First(
			int muc,
			com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
				orderByComparator)
		throws NoSuchDanhMucException;

	/**
	 * Returns the first danh muc in the ordered set where muc = &#63;.
	 *
	 * @param muc the muc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public DanhMuc fetchByMUC_First(
		int muc,
		com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
			orderByComparator);

	/**
	 * Returns the last danh muc in the ordered set where muc = &#63;.
	 *
	 * @param muc the muc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	public DanhMuc findByMUC_Last(
			int muc,
			com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
				orderByComparator)
		throws NoSuchDanhMucException;

	/**
	 * Returns the last danh muc in the ordered set where muc = &#63;.
	 *
	 * @param muc the muc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public DanhMuc fetchByMUC_Last(
		int muc,
		com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
			orderByComparator);

	/**
	 * Returns the danh mucs before and after the current danh muc in the ordered set where muc = &#63;.
	 *
	 * @param id the primary key of the current danh muc
	 * @param muc the muc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next danh muc
	 * @throws NoSuchDanhMucException if a danh muc with the primary key could not be found
	 */
	public DanhMuc[] findByMUC_PrevAndNext(
			long id, int muc,
			com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
				orderByComparator)
		throws NoSuchDanhMucException;

	/**
	 * Removes all the danh mucs where muc = &#63; from the database.
	 *
	 * @param muc the muc
	 */
	public void removeByMUC(int muc);

	/**
	 * Returns the number of danh mucs where muc = &#63;.
	 *
	 * @param muc the muc
	 * @return the number of matching danh mucs
	 */
	public int countByMUC(int muc);

	/**
	 * Returns all the danh mucs where nhomId = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @return the matching danh mucs
	 */
	public java.util.List<DanhMuc> findByNhomID(long nhomId);

	/**
	 * Returns a range of all the danh mucs where nhomId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nhomId the nhom ID
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @return the range of matching danh mucs
	 */
	public java.util.List<DanhMuc> findByNhomID(
		long nhomId, int start, int end);

	/**
	 * Returns an ordered range of all the danh mucs where nhomId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nhomId the nhom ID
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching danh mucs
	 */
	public java.util.List<DanhMuc> findByNhomID(
		long nhomId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
			orderByComparator);

	/**
	 * Returns an ordered range of all the danh mucs where nhomId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nhomId the nhom ID
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching danh mucs
	 */
	public java.util.List<DanhMuc> findByNhomID(
		long nhomId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first danh muc in the ordered set where nhomId = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	public DanhMuc findByNhomID_First(
			long nhomId,
			com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
				orderByComparator)
		throws NoSuchDanhMucException;

	/**
	 * Returns the first danh muc in the ordered set where nhomId = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public DanhMuc fetchByNhomID_First(
		long nhomId,
		com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
			orderByComparator);

	/**
	 * Returns the last danh muc in the ordered set where nhomId = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	public DanhMuc findByNhomID_Last(
			long nhomId,
			com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
				orderByComparator)
		throws NoSuchDanhMucException;

	/**
	 * Returns the last danh muc in the ordered set where nhomId = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public DanhMuc fetchByNhomID_Last(
		long nhomId,
		com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
			orderByComparator);

	/**
	 * Returns the danh mucs before and after the current danh muc in the ordered set where nhomId = &#63;.
	 *
	 * @param id the primary key of the current danh muc
	 * @param nhomId the nhom ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next danh muc
	 * @throws NoSuchDanhMucException if a danh muc with the primary key could not be found
	 */
	public DanhMuc[] findByNhomID_PrevAndNext(
			long id, long nhomId,
			com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
				orderByComparator)
		throws NoSuchDanhMucException;

	/**
	 * Removes all the danh mucs where nhomId = &#63; from the database.
	 *
	 * @param nhomId the nhom ID
	 */
	public void removeByNhomID(long nhomId);

	/**
	 * Returns the number of danh mucs where nhomId = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @return the number of matching danh mucs
	 */
	public int countByNhomID(long nhomId);

	/**
	 * Returns the danh muc where thuTuHienThi = &#63; or throws a <code>NoSuchDanhMucException</code> if it could not be found.
	 *
	 * @param thuTuHienThi the thu tu hien thi
	 * @return the matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	public DanhMuc findByTT(int thuTuHienThi) throws NoSuchDanhMucException;

	/**
	 * Returns the danh muc where thuTuHienThi = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param thuTuHienThi the thu tu hien thi
	 * @return the matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public DanhMuc fetchByTT(int thuTuHienThi);

	/**
	 * Returns the danh muc where thuTuHienThi = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param thuTuHienThi the thu tu hien thi
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public DanhMuc fetchByTT(int thuTuHienThi, boolean retrieveFromCache);

	/**
	 * Removes the danh muc where thuTuHienThi = &#63; from the database.
	 *
	 * @param thuTuHienThi the thu tu hien thi
	 * @return the danh muc that was removed
	 */
	public DanhMuc removeByTT(int thuTuHienThi) throws NoSuchDanhMucException;

	/**
	 * Returns the number of danh mucs where thuTuHienThi = &#63;.
	 *
	 * @param thuTuHienThi the thu tu hien thi
	 * @return the number of matching danh mucs
	 */
	public int countByTT(int thuTuHienThi);

	/**
	 * Returns all the danh mucs where nhomId = &#63; and trangThai = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param trangThai the trang thai
	 * @return the matching danh mucs
	 */
	public java.util.List<DanhMuc> findByNhomId_TrangThai(
		long nhomId, boolean trangThai);

	/**
	 * Returns a range of all the danh mucs where nhomId = &#63; and trangThai = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nhomId the nhom ID
	 * @param trangThai the trang thai
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @return the range of matching danh mucs
	 */
	public java.util.List<DanhMuc> findByNhomId_TrangThai(
		long nhomId, boolean trangThai, int start, int end);

	/**
	 * Returns an ordered range of all the danh mucs where nhomId = &#63; and trangThai = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nhomId the nhom ID
	 * @param trangThai the trang thai
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching danh mucs
	 */
	public java.util.List<DanhMuc> findByNhomId_TrangThai(
		long nhomId, boolean trangThai, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
			orderByComparator);

	/**
	 * Returns an ordered range of all the danh mucs where nhomId = &#63; and trangThai = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nhomId the nhom ID
	 * @param trangThai the trang thai
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching danh mucs
	 */
	public java.util.List<DanhMuc> findByNhomId_TrangThai(
		long nhomId, boolean trangThai, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first danh muc in the ordered set where nhomId = &#63; and trangThai = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param trangThai the trang thai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	public DanhMuc findByNhomId_TrangThai_First(
			long nhomId, boolean trangThai,
			com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
				orderByComparator)
		throws NoSuchDanhMucException;

	/**
	 * Returns the first danh muc in the ordered set where nhomId = &#63; and trangThai = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param trangThai the trang thai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public DanhMuc fetchByNhomId_TrangThai_First(
		long nhomId, boolean trangThai,
		com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
			orderByComparator);

	/**
	 * Returns the last danh muc in the ordered set where nhomId = &#63; and trangThai = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param trangThai the trang thai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	public DanhMuc findByNhomId_TrangThai_Last(
			long nhomId, boolean trangThai,
			com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
				orderByComparator)
		throws NoSuchDanhMucException;

	/**
	 * Returns the last danh muc in the ordered set where nhomId = &#63; and trangThai = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param trangThai the trang thai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public DanhMuc fetchByNhomId_TrangThai_Last(
		long nhomId, boolean trangThai,
		com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
			orderByComparator);

	/**
	 * Returns the danh mucs before and after the current danh muc in the ordered set where nhomId = &#63; and trangThai = &#63;.
	 *
	 * @param id the primary key of the current danh muc
	 * @param nhomId the nhom ID
	 * @param trangThai the trang thai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next danh muc
	 * @throws NoSuchDanhMucException if a danh muc with the primary key could not be found
	 */
	public DanhMuc[] findByNhomId_TrangThai_PrevAndNext(
			long id, long nhomId, boolean trangThai,
			com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
				orderByComparator)
		throws NoSuchDanhMucException;

	/**
	 * Removes all the danh mucs where nhomId = &#63; and trangThai = &#63; from the database.
	 *
	 * @param nhomId the nhom ID
	 * @param trangThai the trang thai
	 */
	public void removeByNhomId_TrangThai(long nhomId, boolean trangThai);

	/**
	 * Returns the number of danh mucs where nhomId = &#63; and trangThai = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param trangThai the trang thai
	 * @return the number of matching danh mucs
	 */
	public int countByNhomId_TrangThai(long nhomId, boolean trangThai);

	/**
	 * Returns the danh muc where ma = &#63; and trangThai = &#63; or throws a <code>NoSuchDanhMucException</code> if it could not be found.
	 *
	 * @param ma the ma
	 * @param trangThai the trang thai
	 * @return the matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	public DanhMuc findByMa_TrangThai(String ma, boolean trangThai)
		throws NoSuchDanhMucException;

	/**
	 * Returns the danh muc where ma = &#63; and trangThai = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ma the ma
	 * @param trangThai the trang thai
	 * @return the matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public DanhMuc fetchByMa_TrangThai(String ma, boolean trangThai);

	/**
	 * Returns the danh muc where ma = &#63; and trangThai = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ma the ma
	 * @param trangThai the trang thai
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public DanhMuc fetchByMa_TrangThai(
		String ma, boolean trangThai, boolean retrieveFromCache);

	/**
	 * Removes the danh muc where ma = &#63; and trangThai = &#63; from the database.
	 *
	 * @param ma the ma
	 * @param trangThai the trang thai
	 * @return the danh muc that was removed
	 */
	public DanhMuc removeByMa_TrangThai(String ma, boolean trangThai)
		throws NoSuchDanhMucException;

	/**
	 * Returns the number of danh mucs where ma = &#63; and trangThai = &#63;.
	 *
	 * @param ma the ma
	 * @param trangThai the trang thai
	 * @return the number of matching danh mucs
	 */
	public int countByMa_TrangThai(String ma, boolean trangThai);

	/**
	 * Returns all the danh mucs where ma = &#63; and muc = &#63;.
	 *
	 * @param ma the ma
	 * @param muc the muc
	 * @return the matching danh mucs
	 */
	public java.util.List<DanhMuc> findByMa_Muc(String ma, int muc);

	/**
	 * Returns a range of all the danh mucs where ma = &#63; and muc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ma the ma
	 * @param muc the muc
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @return the range of matching danh mucs
	 */
	public java.util.List<DanhMuc> findByMa_Muc(
		String ma, int muc, int start, int end);

	/**
	 * Returns an ordered range of all the danh mucs where ma = &#63; and muc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ma the ma
	 * @param muc the muc
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching danh mucs
	 */
	public java.util.List<DanhMuc> findByMa_Muc(
		String ma, int muc, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
			orderByComparator);

	/**
	 * Returns an ordered range of all the danh mucs where ma = &#63; and muc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ma the ma
	 * @param muc the muc
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching danh mucs
	 */
	public java.util.List<DanhMuc> findByMa_Muc(
		String ma, int muc, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first danh muc in the ordered set where ma = &#63; and muc = &#63;.
	 *
	 * @param ma the ma
	 * @param muc the muc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	public DanhMuc findByMa_Muc_First(
			String ma, int muc,
			com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
				orderByComparator)
		throws NoSuchDanhMucException;

	/**
	 * Returns the first danh muc in the ordered set where ma = &#63; and muc = &#63;.
	 *
	 * @param ma the ma
	 * @param muc the muc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public DanhMuc fetchByMa_Muc_First(
		String ma, int muc,
		com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
			orderByComparator);

	/**
	 * Returns the last danh muc in the ordered set where ma = &#63; and muc = &#63;.
	 *
	 * @param ma the ma
	 * @param muc the muc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	public DanhMuc findByMa_Muc_Last(
			String ma, int muc,
			com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
				orderByComparator)
		throws NoSuchDanhMucException;

	/**
	 * Returns the last danh muc in the ordered set where ma = &#63; and muc = &#63;.
	 *
	 * @param ma the ma
	 * @param muc the muc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public DanhMuc fetchByMa_Muc_Last(
		String ma, int muc,
		com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
			orderByComparator);

	/**
	 * Returns the danh mucs before and after the current danh muc in the ordered set where ma = &#63; and muc = &#63;.
	 *
	 * @param id the primary key of the current danh muc
	 * @param ma the ma
	 * @param muc the muc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next danh muc
	 * @throws NoSuchDanhMucException if a danh muc with the primary key could not be found
	 */
	public DanhMuc[] findByMa_Muc_PrevAndNext(
			long id, String ma, int muc,
			com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
				orderByComparator)
		throws NoSuchDanhMucException;

	/**
	 * Removes all the danh mucs where ma = &#63; and muc = &#63; from the database.
	 *
	 * @param ma the ma
	 * @param muc the muc
	 */
	public void removeByMa_Muc(String ma, int muc);

	/**
	 * Returns the number of danh mucs where ma = &#63; and muc = &#63;.
	 *
	 * @param ma the ma
	 * @param muc the muc
	 * @return the number of matching danh mucs
	 */
	public int countByMa_Muc(String ma, int muc);

	/**
	 * Returns all the danh mucs where chaId = &#63; and muc = &#63; and trangThai = &#63;.
	 *
	 * @param chaId the cha ID
	 * @param muc the muc
	 * @param trangThai the trang thai
	 * @return the matching danh mucs
	 */
	public java.util.List<DanhMuc> findByChaId_Muc(
		long chaId, int muc, boolean trangThai);

	/**
	 * Returns a range of all the danh mucs where chaId = &#63; and muc = &#63; and trangThai = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param chaId the cha ID
	 * @param muc the muc
	 * @param trangThai the trang thai
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @return the range of matching danh mucs
	 */
	public java.util.List<DanhMuc> findByChaId_Muc(
		long chaId, int muc, boolean trangThai, int start, int end);

	/**
	 * Returns an ordered range of all the danh mucs where chaId = &#63; and muc = &#63; and trangThai = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param chaId the cha ID
	 * @param muc the muc
	 * @param trangThai the trang thai
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching danh mucs
	 */
	public java.util.List<DanhMuc> findByChaId_Muc(
		long chaId, int muc, boolean trangThai, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
			orderByComparator);

	/**
	 * Returns an ordered range of all the danh mucs where chaId = &#63; and muc = &#63; and trangThai = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param chaId the cha ID
	 * @param muc the muc
	 * @param trangThai the trang thai
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching danh mucs
	 */
	public java.util.List<DanhMuc> findByChaId_Muc(
		long chaId, int muc, boolean trangThai, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first danh muc in the ordered set where chaId = &#63; and muc = &#63; and trangThai = &#63;.
	 *
	 * @param chaId the cha ID
	 * @param muc the muc
	 * @param trangThai the trang thai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	public DanhMuc findByChaId_Muc_First(
			long chaId, int muc, boolean trangThai,
			com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
				orderByComparator)
		throws NoSuchDanhMucException;

	/**
	 * Returns the first danh muc in the ordered set where chaId = &#63; and muc = &#63; and trangThai = &#63;.
	 *
	 * @param chaId the cha ID
	 * @param muc the muc
	 * @param trangThai the trang thai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public DanhMuc fetchByChaId_Muc_First(
		long chaId, int muc, boolean trangThai,
		com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
			orderByComparator);

	/**
	 * Returns the last danh muc in the ordered set where chaId = &#63; and muc = &#63; and trangThai = &#63;.
	 *
	 * @param chaId the cha ID
	 * @param muc the muc
	 * @param trangThai the trang thai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	public DanhMuc findByChaId_Muc_Last(
			long chaId, int muc, boolean trangThai,
			com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
				orderByComparator)
		throws NoSuchDanhMucException;

	/**
	 * Returns the last danh muc in the ordered set where chaId = &#63; and muc = &#63; and trangThai = &#63;.
	 *
	 * @param chaId the cha ID
	 * @param muc the muc
	 * @param trangThai the trang thai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public DanhMuc fetchByChaId_Muc_Last(
		long chaId, int muc, boolean trangThai,
		com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
			orderByComparator);

	/**
	 * Returns the danh mucs before and after the current danh muc in the ordered set where chaId = &#63; and muc = &#63; and trangThai = &#63;.
	 *
	 * @param id the primary key of the current danh muc
	 * @param chaId the cha ID
	 * @param muc the muc
	 * @param trangThai the trang thai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next danh muc
	 * @throws NoSuchDanhMucException if a danh muc with the primary key could not be found
	 */
	public DanhMuc[] findByChaId_Muc_PrevAndNext(
			long id, long chaId, int muc, boolean trangThai,
			com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
				orderByComparator)
		throws NoSuchDanhMucException;

	/**
	 * Removes all the danh mucs where chaId = &#63; and muc = &#63; and trangThai = &#63; from the database.
	 *
	 * @param chaId the cha ID
	 * @param muc the muc
	 * @param trangThai the trang thai
	 */
	public void removeByChaId_Muc(long chaId, int muc, boolean trangThai);

	/**
	 * Returns the number of danh mucs where chaId = &#63; and muc = &#63; and trangThai = &#63;.
	 *
	 * @param chaId the cha ID
	 * @param muc the muc
	 * @param trangThai the trang thai
	 * @return the number of matching danh mucs
	 */
	public int countByChaId_Muc(long chaId, int muc, boolean trangThai);

	/**
	 * Returns all the danh mucs where nhomId = &#63; and muc = &#63; and trangThai = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param trangThai the trang thai
	 * @return the matching danh mucs
	 */
	public java.util.List<DanhMuc> findByNhomId_Muc_TrangThai(
		long nhomId, int muc, boolean trangThai);

	/**
	 * Returns a range of all the danh mucs where nhomId = &#63; and muc = &#63; and trangThai = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param trangThai the trang thai
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @return the range of matching danh mucs
	 */
	public java.util.List<DanhMuc> findByNhomId_Muc_TrangThai(
		long nhomId, int muc, boolean trangThai, int start, int end);

	/**
	 * Returns an ordered range of all the danh mucs where nhomId = &#63; and muc = &#63; and trangThai = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param trangThai the trang thai
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching danh mucs
	 */
	public java.util.List<DanhMuc> findByNhomId_Muc_TrangThai(
		long nhomId, int muc, boolean trangThai, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
			orderByComparator);

	/**
	 * Returns an ordered range of all the danh mucs where nhomId = &#63; and muc = &#63; and trangThai = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param trangThai the trang thai
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching danh mucs
	 */
	public java.util.List<DanhMuc> findByNhomId_Muc_TrangThai(
		long nhomId, int muc, boolean trangThai, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first danh muc in the ordered set where nhomId = &#63; and muc = &#63; and trangThai = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param trangThai the trang thai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	public DanhMuc findByNhomId_Muc_TrangThai_First(
			long nhomId, int muc, boolean trangThai,
			com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
				orderByComparator)
		throws NoSuchDanhMucException;

	/**
	 * Returns the first danh muc in the ordered set where nhomId = &#63; and muc = &#63; and trangThai = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param trangThai the trang thai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public DanhMuc fetchByNhomId_Muc_TrangThai_First(
		long nhomId, int muc, boolean trangThai,
		com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
			orderByComparator);

	/**
	 * Returns the last danh muc in the ordered set where nhomId = &#63; and muc = &#63; and trangThai = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param trangThai the trang thai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	public DanhMuc findByNhomId_Muc_TrangThai_Last(
			long nhomId, int muc, boolean trangThai,
			com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
				orderByComparator)
		throws NoSuchDanhMucException;

	/**
	 * Returns the last danh muc in the ordered set where nhomId = &#63; and muc = &#63; and trangThai = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param trangThai the trang thai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public DanhMuc fetchByNhomId_Muc_TrangThai_Last(
		long nhomId, int muc, boolean trangThai,
		com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
			orderByComparator);

	/**
	 * Returns the danh mucs before and after the current danh muc in the ordered set where nhomId = &#63; and muc = &#63; and trangThai = &#63;.
	 *
	 * @param id the primary key of the current danh muc
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param trangThai the trang thai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next danh muc
	 * @throws NoSuchDanhMucException if a danh muc with the primary key could not be found
	 */
	public DanhMuc[] findByNhomId_Muc_TrangThai_PrevAndNext(
			long id, long nhomId, int muc, boolean trangThai,
			com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
				orderByComparator)
		throws NoSuchDanhMucException;

	/**
	 * Removes all the danh mucs where nhomId = &#63; and muc = &#63; and trangThai = &#63; from the database.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param trangThai the trang thai
	 */
	public void removeByNhomId_Muc_TrangThai(
		long nhomId, int muc, boolean trangThai);

	/**
	 * Returns the number of danh mucs where nhomId = &#63; and muc = &#63; and trangThai = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param trangThai the trang thai
	 * @return the number of matching danh mucs
	 */
	public int countByNhomId_Muc_TrangThai(
		long nhomId, int muc, boolean trangThai);

	/**
	 * Returns the danh muc where nhomId = &#63; and muc = &#63; and ten = &#63; and trangThai = &#63; or throws a <code>NoSuchDanhMucException</code> if it could not be found.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param ten the ten
	 * @param trangThai the trang thai
	 * @return the matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	public DanhMuc findByNhomId_Muc_Ten_TrangThai(
			long nhomId, int muc, String ten, boolean trangThai)
		throws NoSuchDanhMucException;

	/**
	 * Returns the danh muc where nhomId = &#63; and muc = &#63; and ten = &#63; and trangThai = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param ten the ten
	 * @param trangThai the trang thai
	 * @return the matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public DanhMuc fetchByNhomId_Muc_Ten_TrangThai(
		long nhomId, int muc, String ten, boolean trangThai);

	/**
	 * Returns the danh muc where nhomId = &#63; and muc = &#63; and ten = &#63; and trangThai = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param ten the ten
	 * @param trangThai the trang thai
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public DanhMuc fetchByNhomId_Muc_Ten_TrangThai(
		long nhomId, int muc, String ten, boolean trangThai,
		boolean retrieveFromCache);

	/**
	 * Removes the danh muc where nhomId = &#63; and muc = &#63; and ten = &#63; and trangThai = &#63; from the database.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param ten the ten
	 * @param trangThai the trang thai
	 * @return the danh muc that was removed
	 */
	public DanhMuc removeByNhomId_Muc_Ten_TrangThai(
			long nhomId, int muc, String ten, boolean trangThai)
		throws NoSuchDanhMucException;

	/**
	 * Returns the number of danh mucs where nhomId = &#63; and muc = &#63; and ten = &#63; and trangThai = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param ten the ten
	 * @param trangThai the trang thai
	 * @return the number of matching danh mucs
	 */
	public int countByNhomId_Muc_Ten_TrangThai(
		long nhomId, int muc, String ten, boolean trangThai);

	/**
	 * Returns the danh muc where nhomId = &#63; and muc = &#63; and ma = &#63; and trangThai = &#63; or throws a <code>NoSuchDanhMucException</code> if it could not be found.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param ma the ma
	 * @param trangThai the trang thai
	 * @return the matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	public DanhMuc findByNhomId_Muc_Ma_TrangThai(
			long nhomId, int muc, String ma, boolean trangThai)
		throws NoSuchDanhMucException;

	/**
	 * Returns the danh muc where nhomId = &#63; and muc = &#63; and ma = &#63; and trangThai = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param ma the ma
	 * @param trangThai the trang thai
	 * @return the matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public DanhMuc fetchByNhomId_Muc_Ma_TrangThai(
		long nhomId, int muc, String ma, boolean trangThai);

	/**
	 * Returns the danh muc where nhomId = &#63; and muc = &#63; and ma = &#63; and trangThai = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param ma the ma
	 * @param trangThai the trang thai
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public DanhMuc fetchByNhomId_Muc_Ma_TrangThai(
		long nhomId, int muc, String ma, boolean trangThai,
		boolean retrieveFromCache);

	/**
	 * Removes the danh muc where nhomId = &#63; and muc = &#63; and ma = &#63; and trangThai = &#63; from the database.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param ma the ma
	 * @param trangThai the trang thai
	 * @return the danh muc that was removed
	 */
	public DanhMuc removeByNhomId_Muc_Ma_TrangThai(
			long nhomId, int muc, String ma, boolean trangThai)
		throws NoSuchDanhMucException;

	/**
	 * Returns the number of danh mucs where nhomId = &#63; and muc = &#63; and ma = &#63; and trangThai = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param ma the ma
	 * @param trangThai the trang thai
	 * @return the number of matching danh mucs
	 */
	public int countByNhomId_Muc_Ma_TrangThai(
		long nhomId, int muc, String ma, boolean trangThai);

	/**
	 * Returns all the danh mucs where id = &#63;.
	 *
	 * @param id the ID
	 * @return the matching danh mucs
	 */
	public java.util.List<DanhMuc> findByIds(long id);

	/**
	 * Returns a range of all the danh mucs where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @return the range of matching danh mucs
	 */
	public java.util.List<DanhMuc> findByIds(long id, int start, int end);

	/**
	 * Returns an ordered range of all the danh mucs where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching danh mucs
	 */
	public java.util.List<DanhMuc> findByIds(
		long id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
			orderByComparator);

	/**
	 * Returns an ordered range of all the danh mucs where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching danh mucs
	 */
	public java.util.List<DanhMuc> findByIds(
		long id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first danh muc in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	public DanhMuc findByIds_First(
			long id,
			com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
				orderByComparator)
		throws NoSuchDanhMucException;

	/**
	 * Returns the first danh muc in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public DanhMuc fetchByIds_First(
		long id,
		com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
			orderByComparator);

	/**
	 * Returns the last danh muc in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	public DanhMuc findByIds_Last(
			long id,
			com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
				orderByComparator)
		throws NoSuchDanhMucException;

	/**
	 * Returns the last danh muc in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public DanhMuc fetchByIds_Last(
		long id,
		com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
			orderByComparator);

	/**
	 * Returns all the danh mucs where id = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ids the IDs
	 * @return the matching danh mucs
	 */
	public java.util.List<DanhMuc> findByIds(long[] ids);

	/**
	 * Returns a range of all the danh mucs where id = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ids the IDs
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @return the range of matching danh mucs
	 */
	public java.util.List<DanhMuc> findByIds(long[] ids, int start, int end);

	/**
	 * Returns an ordered range of all the danh mucs where id = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ids the IDs
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching danh mucs
	 */
	public java.util.List<DanhMuc> findByIds(
		long[] ids, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
			orderByComparator);

	/**
	 * Returns an ordered range of all the danh mucs where id = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching danh mucs
	 */
	public java.util.List<DanhMuc> findByIds(
		long[] ids, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the danh mucs where id = &#63; from the database.
	 *
	 * @param id the ID
	 */
	public void removeByIds(long id);

	/**
	 * Returns the number of danh mucs where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching danh mucs
	 */
	public int countByIds(long id);

	/**
	 * Returns the number of danh mucs where id = any &#63;.
	 *
	 * @param ids the IDs
	 * @return the number of matching danh mucs
	 */
	public int countByIds(long[] ids);

	/**
	 * Returns all the danh mucs where nhomId = &#63; and muc = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @return the matching danh mucs
	 */
	public java.util.List<DanhMuc> findByNhomId_Muc(long nhomId, int muc);

	/**
	 * Returns a range of all the danh mucs where nhomId = &#63; and muc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @return the range of matching danh mucs
	 */
	public java.util.List<DanhMuc> findByNhomId_Muc(
		long nhomId, int muc, int start, int end);

	/**
	 * Returns an ordered range of all the danh mucs where nhomId = &#63; and muc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching danh mucs
	 */
	public java.util.List<DanhMuc> findByNhomId_Muc(
		long nhomId, int muc, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
			orderByComparator);

	/**
	 * Returns an ordered range of all the danh mucs where nhomId = &#63; and muc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching danh mucs
	 */
	public java.util.List<DanhMuc> findByNhomId_Muc(
		long nhomId, int muc, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first danh muc in the ordered set where nhomId = &#63; and muc = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	public DanhMuc findByNhomId_Muc_First(
			long nhomId, int muc,
			com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
				orderByComparator)
		throws NoSuchDanhMucException;

	/**
	 * Returns the first danh muc in the ordered set where nhomId = &#63; and muc = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public DanhMuc fetchByNhomId_Muc_First(
		long nhomId, int muc,
		com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
			orderByComparator);

	/**
	 * Returns the last danh muc in the ordered set where nhomId = &#63; and muc = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	public DanhMuc findByNhomId_Muc_Last(
			long nhomId, int muc,
			com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
				orderByComparator)
		throws NoSuchDanhMucException;

	/**
	 * Returns the last danh muc in the ordered set where nhomId = &#63; and muc = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public DanhMuc fetchByNhomId_Muc_Last(
		long nhomId, int muc,
		com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
			orderByComparator);

	/**
	 * Returns the danh mucs before and after the current danh muc in the ordered set where nhomId = &#63; and muc = &#63;.
	 *
	 * @param id the primary key of the current danh muc
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next danh muc
	 * @throws NoSuchDanhMucException if a danh muc with the primary key could not be found
	 */
	public DanhMuc[] findByNhomId_Muc_PrevAndNext(
			long id, long nhomId, int muc,
			com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
				orderByComparator)
		throws NoSuchDanhMucException;

	/**
	 * Removes all the danh mucs where nhomId = &#63; and muc = &#63; from the database.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 */
	public void removeByNhomId_Muc(long nhomId, int muc);

	/**
	 * Returns the number of danh mucs where nhomId = &#63; and muc = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @return the number of matching danh mucs
	 */
	public int countByNhomId_Muc(long nhomId, int muc);

	/**
	 * Returns the danh muc where nhomId = &#63; and ma = &#63; or throws a <code>NoSuchDanhMucException</code> if it could not be found.
	 *
	 * @param nhomId the nhom ID
	 * @param ma the ma
	 * @return the matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	public DanhMuc findByNhomId_Ma(long nhomId, String ma)
		throws NoSuchDanhMucException;

	/**
	 * Returns the danh muc where nhomId = &#63; and ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nhomId the nhom ID
	 * @param ma the ma
	 * @return the matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public DanhMuc fetchByNhomId_Ma(long nhomId, String ma);

	/**
	 * Returns the danh muc where nhomId = &#63; and ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nhomId the nhom ID
	 * @param ma the ma
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public DanhMuc fetchByNhomId_Ma(
		long nhomId, String ma, boolean retrieveFromCache);

	/**
	 * Removes the danh muc where nhomId = &#63; and ma = &#63; from the database.
	 *
	 * @param nhomId the nhom ID
	 * @param ma the ma
	 * @return the danh muc that was removed
	 */
	public DanhMuc removeByNhomId_Ma(long nhomId, String ma)
		throws NoSuchDanhMucException;

	/**
	 * Returns the number of danh mucs where nhomId = &#63; and ma = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param ma the ma
	 * @return the number of matching danh mucs
	 */
	public int countByNhomId_Ma(long nhomId, String ma);

	/**
	 * Caches the danh muc in the entity cache if it is enabled.
	 *
	 * @param danhMuc the danh muc
	 */
	public void cacheResult(DanhMuc danhMuc);

	/**
	 * Caches the danh mucs in the entity cache if it is enabled.
	 *
	 * @param danhMucs the danh mucs
	 */
	public void cacheResult(java.util.List<DanhMuc> danhMucs);

	/**
	 * Creates a new danh muc with the primary key. Does not add the danh muc to the database.
	 *
	 * @param id the primary key for the new danh muc
	 * @return the new danh muc
	 */
	public DanhMuc create(long id);

	/**
	 * Removes the danh muc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the danh muc
	 * @return the danh muc that was removed
	 * @throws NoSuchDanhMucException if a danh muc with the primary key could not be found
	 */
	public DanhMuc remove(long id) throws NoSuchDanhMucException;

	public DanhMuc updateImpl(DanhMuc danhMuc);

	/**
	 * Returns the danh muc with the primary key or throws a <code>NoSuchDanhMucException</code> if it could not be found.
	 *
	 * @param id the primary key of the danh muc
	 * @return the danh muc
	 * @throws NoSuchDanhMucException if a danh muc with the primary key could not be found
	 */
	public DanhMuc findByPrimaryKey(long id) throws NoSuchDanhMucException;

	/**
	 * Returns the danh muc with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the danh muc
	 * @return the danh muc, or <code>null</code> if a danh muc with the primary key could not be found
	 */
	public DanhMuc fetchByPrimaryKey(long id);

	/**
	 * Returns all the danh mucs.
	 *
	 * @return the danh mucs
	 */
	public java.util.List<DanhMuc> findAll();

	/**
	 * Returns a range of all the danh mucs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @return the range of danh mucs
	 */
	public java.util.List<DanhMuc> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the danh mucs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of danh mucs
	 */
	public java.util.List<DanhMuc> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
			orderByComparator);

	/**
	 * Returns an ordered range of all the danh mucs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of danh mucs
	 */
	public java.util.List<DanhMuc> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DanhMuc>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the danh mucs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of danh mucs.
	 *
	 * @return the number of danh mucs
	 */
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();

}