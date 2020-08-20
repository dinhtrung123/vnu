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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import dtt.vn.vnpost.model.DanhMuc;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the danh muc service. This utility wraps <code>dtt.vn.vnpost.service.persistence.impl.DanhMucPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DanhMucPersistence
 * @generated
 */
@ProviderType
public class DanhMucUtil {

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
	public static void clearCache(DanhMuc danhMuc) {
		getPersistence().clearCache(danhMuc);
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
	public static Map<Serializable, DanhMuc> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DanhMuc> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DanhMuc> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DanhMuc> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DanhMuc> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DanhMuc update(DanhMuc danhMuc) {
		return getPersistence().update(danhMuc);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DanhMuc update(
		DanhMuc danhMuc, ServiceContext serviceContext) {

		return getPersistence().update(danhMuc, serviceContext);
	}

	/**
	 * Returns the danh muc where ma = &#63; or throws a <code>NoSuchDanhMucException</code> if it could not be found.
	 *
	 * @param ma the ma
	 * @return the matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	public static DanhMuc findByM(String ma)
		throws dtt.vn.vnpost.exception.NoSuchDanhMucException {

		return getPersistence().findByM(ma);
	}

	/**
	 * Returns the danh muc where ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ma the ma
	 * @return the matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public static DanhMuc fetchByM(String ma) {
		return getPersistence().fetchByM(ma);
	}

	/**
	 * Returns the danh muc where ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ma the ma
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public static DanhMuc fetchByM(String ma, boolean retrieveFromCache) {
		return getPersistence().fetchByM(ma, retrieveFromCache);
	}

	/**
	 * Removes the danh muc where ma = &#63; from the database.
	 *
	 * @param ma the ma
	 * @return the danh muc that was removed
	 */
	public static DanhMuc removeByM(String ma)
		throws dtt.vn.vnpost.exception.NoSuchDanhMucException {

		return getPersistence().removeByM(ma);
	}

	/**
	 * Returns the number of danh mucs where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the number of matching danh mucs
	 */
	public static int countByM(String ma) {
		return getPersistence().countByM(ma);
	}

	/**
	 * Returns the danh muc where ten = &#63; or throws a <code>NoSuchDanhMucException</code> if it could not be found.
	 *
	 * @param ten the ten
	 * @return the matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	public static DanhMuc findByT(String ten)
		throws dtt.vn.vnpost.exception.NoSuchDanhMucException {

		return getPersistence().findByT(ten);
	}

	/**
	 * Returns the danh muc where ten = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ten the ten
	 * @return the matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public static DanhMuc fetchByT(String ten) {
		return getPersistence().fetchByT(ten);
	}

	/**
	 * Returns the danh muc where ten = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ten the ten
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public static DanhMuc fetchByT(String ten, boolean retrieveFromCache) {
		return getPersistence().fetchByT(ten, retrieveFromCache);
	}

	/**
	 * Removes the danh muc where ten = &#63; from the database.
	 *
	 * @param ten the ten
	 * @return the danh muc that was removed
	 */
	public static DanhMuc removeByT(String ten)
		throws dtt.vn.vnpost.exception.NoSuchDanhMucException {

		return getPersistence().removeByT(ten);
	}

	/**
	 * Returns the number of danh mucs where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the number of matching danh mucs
	 */
	public static int countByT(String ten) {
		return getPersistence().countByT(ten);
	}

	/**
	 * Returns the danh muc where chaId = &#63; and ten = &#63; or throws a <code>NoSuchDanhMucException</code> if it could not be found.
	 *
	 * @param chaId the cha ID
	 * @param ten the ten
	 * @return the matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	public static DanhMuc findByP_T(long chaId, String ten)
		throws dtt.vn.vnpost.exception.NoSuchDanhMucException {

		return getPersistence().findByP_T(chaId, ten);
	}

	/**
	 * Returns the danh muc where chaId = &#63; and ten = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param chaId the cha ID
	 * @param ten the ten
	 * @return the matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public static DanhMuc fetchByP_T(long chaId, String ten) {
		return getPersistence().fetchByP_T(chaId, ten);
	}

	/**
	 * Returns the danh muc where chaId = &#63; and ten = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param chaId the cha ID
	 * @param ten the ten
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public static DanhMuc fetchByP_T(
		long chaId, String ten, boolean retrieveFromCache) {

		return getPersistence().fetchByP_T(chaId, ten, retrieveFromCache);
	}

	/**
	 * Removes the danh muc where chaId = &#63; and ten = &#63; from the database.
	 *
	 * @param chaId the cha ID
	 * @param ten the ten
	 * @return the danh muc that was removed
	 */
	public static DanhMuc removeByP_T(long chaId, String ten)
		throws dtt.vn.vnpost.exception.NoSuchDanhMucException {

		return getPersistence().removeByP_T(chaId, ten);
	}

	/**
	 * Returns the number of danh mucs where chaId = &#63; and ten = &#63;.
	 *
	 * @param chaId the cha ID
	 * @param ten the ten
	 * @return the number of matching danh mucs
	 */
	public static int countByP_T(long chaId, String ten) {
		return getPersistence().countByP_T(chaId, ten);
	}

	/**
	 * Returns all the danh mucs where chaId = &#63; and trangThai = &#63;.
	 *
	 * @param chaId the cha ID
	 * @param trangThai the trang thai
	 * @return the matching danh mucs
	 */
	public static List<DanhMuc> findByCha_TrangThai(
		long chaId, boolean trangThai) {

		return getPersistence().findByCha_TrangThai(chaId, trangThai);
	}

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
	public static List<DanhMuc> findByCha_TrangThai(
		long chaId, boolean trangThai, int start, int end) {

		return getPersistence().findByCha_TrangThai(
			chaId, trangThai, start, end);
	}

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
	public static List<DanhMuc> findByCha_TrangThai(
		long chaId, boolean trangThai, int start, int end,
		OrderByComparator<DanhMuc> orderByComparator) {

		return getPersistence().findByCha_TrangThai(
			chaId, trangThai, start, end, orderByComparator);
	}

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
	public static List<DanhMuc> findByCha_TrangThai(
		long chaId, boolean trangThai, int start, int end,
		OrderByComparator<DanhMuc> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByCha_TrangThai(
			chaId, trangThai, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first danh muc in the ordered set where chaId = &#63; and trangThai = &#63;.
	 *
	 * @param chaId the cha ID
	 * @param trangThai the trang thai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	public static DanhMuc findByCha_TrangThai_First(
			long chaId, boolean trangThai,
			OrderByComparator<DanhMuc> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchDanhMucException {

		return getPersistence().findByCha_TrangThai_First(
			chaId, trangThai, orderByComparator);
	}

	/**
	 * Returns the first danh muc in the ordered set where chaId = &#63; and trangThai = &#63;.
	 *
	 * @param chaId the cha ID
	 * @param trangThai the trang thai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public static DanhMuc fetchByCha_TrangThai_First(
		long chaId, boolean trangThai,
		OrderByComparator<DanhMuc> orderByComparator) {

		return getPersistence().fetchByCha_TrangThai_First(
			chaId, trangThai, orderByComparator);
	}

	/**
	 * Returns the last danh muc in the ordered set where chaId = &#63; and trangThai = &#63;.
	 *
	 * @param chaId the cha ID
	 * @param trangThai the trang thai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	public static DanhMuc findByCha_TrangThai_Last(
			long chaId, boolean trangThai,
			OrderByComparator<DanhMuc> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchDanhMucException {

		return getPersistence().findByCha_TrangThai_Last(
			chaId, trangThai, orderByComparator);
	}

	/**
	 * Returns the last danh muc in the ordered set where chaId = &#63; and trangThai = &#63;.
	 *
	 * @param chaId the cha ID
	 * @param trangThai the trang thai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public static DanhMuc fetchByCha_TrangThai_Last(
		long chaId, boolean trangThai,
		OrderByComparator<DanhMuc> orderByComparator) {

		return getPersistence().fetchByCha_TrangThai_Last(
			chaId, trangThai, orderByComparator);
	}

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
	public static DanhMuc[] findByCha_TrangThai_PrevAndNext(
			long id, long chaId, boolean trangThai,
			OrderByComparator<DanhMuc> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchDanhMucException {

		return getPersistence().findByCha_TrangThai_PrevAndNext(
			id, chaId, trangThai, orderByComparator);
	}

	/**
	 * Removes all the danh mucs where chaId = &#63; and trangThai = &#63; from the database.
	 *
	 * @param chaId the cha ID
	 * @param trangThai the trang thai
	 */
	public static void removeByCha_TrangThai(long chaId, boolean trangThai) {
		getPersistence().removeByCha_TrangThai(chaId, trangThai);
	}

	/**
	 * Returns the number of danh mucs where chaId = &#63; and trangThai = &#63;.
	 *
	 * @param chaId the cha ID
	 * @param trangThai the trang thai
	 * @return the number of matching danh mucs
	 */
	public static int countByCha_TrangThai(long chaId, boolean trangThai) {
		return getPersistence().countByCha_TrangThai(chaId, trangThai);
	}

	/**
	 * Returns all the danh mucs where chaId = &#63;.
	 *
	 * @param chaId the cha ID
	 * @return the matching danh mucs
	 */
	public static List<DanhMuc> findByChaId(long chaId) {
		return getPersistence().findByChaId(chaId);
	}

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
	public static List<DanhMuc> findByChaId(long chaId, int start, int end) {
		return getPersistence().findByChaId(chaId, start, end);
	}

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
	public static List<DanhMuc> findByChaId(
		long chaId, int start, int end,
		OrderByComparator<DanhMuc> orderByComparator) {

		return getPersistence().findByChaId(
			chaId, start, end, orderByComparator);
	}

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
	public static List<DanhMuc> findByChaId(
		long chaId, int start, int end,
		OrderByComparator<DanhMuc> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByChaId(
			chaId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first danh muc in the ordered set where chaId = &#63;.
	 *
	 * @param chaId the cha ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	public static DanhMuc findByChaId_First(
			long chaId, OrderByComparator<DanhMuc> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchDanhMucException {

		return getPersistence().findByChaId_First(chaId, orderByComparator);
	}

	/**
	 * Returns the first danh muc in the ordered set where chaId = &#63;.
	 *
	 * @param chaId the cha ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public static DanhMuc fetchByChaId_First(
		long chaId, OrderByComparator<DanhMuc> orderByComparator) {

		return getPersistence().fetchByChaId_First(chaId, orderByComparator);
	}

	/**
	 * Returns the last danh muc in the ordered set where chaId = &#63;.
	 *
	 * @param chaId the cha ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	public static DanhMuc findByChaId_Last(
			long chaId, OrderByComparator<DanhMuc> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchDanhMucException {

		return getPersistence().findByChaId_Last(chaId, orderByComparator);
	}

	/**
	 * Returns the last danh muc in the ordered set where chaId = &#63;.
	 *
	 * @param chaId the cha ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public static DanhMuc fetchByChaId_Last(
		long chaId, OrderByComparator<DanhMuc> orderByComparator) {

		return getPersistence().fetchByChaId_Last(chaId, orderByComparator);
	}

	/**
	 * Returns the danh mucs before and after the current danh muc in the ordered set where chaId = &#63;.
	 *
	 * @param id the primary key of the current danh muc
	 * @param chaId the cha ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next danh muc
	 * @throws NoSuchDanhMucException if a danh muc with the primary key could not be found
	 */
	public static DanhMuc[] findByChaId_PrevAndNext(
			long id, long chaId, OrderByComparator<DanhMuc> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchDanhMucException {

		return getPersistence().findByChaId_PrevAndNext(
			id, chaId, orderByComparator);
	}

	/**
	 * Removes all the danh mucs where chaId = &#63; from the database.
	 *
	 * @param chaId the cha ID
	 */
	public static void removeByChaId(long chaId) {
		getPersistence().removeByChaId(chaId);
	}

	/**
	 * Returns the number of danh mucs where chaId = &#63;.
	 *
	 * @param chaId the cha ID
	 * @return the number of matching danh mucs
	 */
	public static int countByChaId(long chaId) {
		return getPersistence().countByChaId(chaId);
	}

	/**
	 * Returns all the danh mucs where muc = &#63;.
	 *
	 * @param muc the muc
	 * @return the matching danh mucs
	 */
	public static List<DanhMuc> findByMUC(int muc) {
		return getPersistence().findByMUC(muc);
	}

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
	public static List<DanhMuc> findByMUC(int muc, int start, int end) {
		return getPersistence().findByMUC(muc, start, end);
	}

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
	public static List<DanhMuc> findByMUC(
		int muc, int start, int end,
		OrderByComparator<DanhMuc> orderByComparator) {

		return getPersistence().findByMUC(muc, start, end, orderByComparator);
	}

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
	public static List<DanhMuc> findByMUC(
		int muc, int start, int end,
		OrderByComparator<DanhMuc> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByMUC(
			muc, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first danh muc in the ordered set where muc = &#63;.
	 *
	 * @param muc the muc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	public static DanhMuc findByMUC_First(
			int muc, OrderByComparator<DanhMuc> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchDanhMucException {

		return getPersistence().findByMUC_First(muc, orderByComparator);
	}

	/**
	 * Returns the first danh muc in the ordered set where muc = &#63;.
	 *
	 * @param muc the muc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public static DanhMuc fetchByMUC_First(
		int muc, OrderByComparator<DanhMuc> orderByComparator) {

		return getPersistence().fetchByMUC_First(muc, orderByComparator);
	}

	/**
	 * Returns the last danh muc in the ordered set where muc = &#63;.
	 *
	 * @param muc the muc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	public static DanhMuc findByMUC_Last(
			int muc, OrderByComparator<DanhMuc> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchDanhMucException {

		return getPersistence().findByMUC_Last(muc, orderByComparator);
	}

	/**
	 * Returns the last danh muc in the ordered set where muc = &#63;.
	 *
	 * @param muc the muc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public static DanhMuc fetchByMUC_Last(
		int muc, OrderByComparator<DanhMuc> orderByComparator) {

		return getPersistence().fetchByMUC_Last(muc, orderByComparator);
	}

	/**
	 * Returns the danh mucs before and after the current danh muc in the ordered set where muc = &#63;.
	 *
	 * @param id the primary key of the current danh muc
	 * @param muc the muc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next danh muc
	 * @throws NoSuchDanhMucException if a danh muc with the primary key could not be found
	 */
	public static DanhMuc[] findByMUC_PrevAndNext(
			long id, int muc, OrderByComparator<DanhMuc> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchDanhMucException {

		return getPersistence().findByMUC_PrevAndNext(
			id, muc, orderByComparator);
	}

	/**
	 * Removes all the danh mucs where muc = &#63; from the database.
	 *
	 * @param muc the muc
	 */
	public static void removeByMUC(int muc) {
		getPersistence().removeByMUC(muc);
	}

	/**
	 * Returns the number of danh mucs where muc = &#63;.
	 *
	 * @param muc the muc
	 * @return the number of matching danh mucs
	 */
	public static int countByMUC(int muc) {
		return getPersistence().countByMUC(muc);
	}

	/**
	 * Returns all the danh mucs where nhomId = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @return the matching danh mucs
	 */
	public static List<DanhMuc> findByNhomID(long nhomId) {
		return getPersistence().findByNhomID(nhomId);
	}

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
	public static List<DanhMuc> findByNhomID(long nhomId, int start, int end) {
		return getPersistence().findByNhomID(nhomId, start, end);
	}

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
	public static List<DanhMuc> findByNhomID(
		long nhomId, int start, int end,
		OrderByComparator<DanhMuc> orderByComparator) {

		return getPersistence().findByNhomID(
			nhomId, start, end, orderByComparator);
	}

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
	public static List<DanhMuc> findByNhomID(
		long nhomId, int start, int end,
		OrderByComparator<DanhMuc> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByNhomID(
			nhomId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first danh muc in the ordered set where nhomId = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	public static DanhMuc findByNhomID_First(
			long nhomId, OrderByComparator<DanhMuc> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchDanhMucException {

		return getPersistence().findByNhomID_First(nhomId, orderByComparator);
	}

	/**
	 * Returns the first danh muc in the ordered set where nhomId = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public static DanhMuc fetchByNhomID_First(
		long nhomId, OrderByComparator<DanhMuc> orderByComparator) {

		return getPersistence().fetchByNhomID_First(nhomId, orderByComparator);
	}

	/**
	 * Returns the last danh muc in the ordered set where nhomId = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	public static DanhMuc findByNhomID_Last(
			long nhomId, OrderByComparator<DanhMuc> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchDanhMucException {

		return getPersistence().findByNhomID_Last(nhomId, orderByComparator);
	}

	/**
	 * Returns the last danh muc in the ordered set where nhomId = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public static DanhMuc fetchByNhomID_Last(
		long nhomId, OrderByComparator<DanhMuc> orderByComparator) {

		return getPersistence().fetchByNhomID_Last(nhomId, orderByComparator);
	}

	/**
	 * Returns the danh mucs before and after the current danh muc in the ordered set where nhomId = &#63;.
	 *
	 * @param id the primary key of the current danh muc
	 * @param nhomId the nhom ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next danh muc
	 * @throws NoSuchDanhMucException if a danh muc with the primary key could not be found
	 */
	public static DanhMuc[] findByNhomID_PrevAndNext(
			long id, long nhomId, OrderByComparator<DanhMuc> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchDanhMucException {

		return getPersistence().findByNhomID_PrevAndNext(
			id, nhomId, orderByComparator);
	}

	/**
	 * Removes all the danh mucs where nhomId = &#63; from the database.
	 *
	 * @param nhomId the nhom ID
	 */
	public static void removeByNhomID(long nhomId) {
		getPersistence().removeByNhomID(nhomId);
	}

	/**
	 * Returns the number of danh mucs where nhomId = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @return the number of matching danh mucs
	 */
	public static int countByNhomID(long nhomId) {
		return getPersistence().countByNhomID(nhomId);
	}

	/**
	 * Returns the danh muc where thuTuHienThi = &#63; or throws a <code>NoSuchDanhMucException</code> if it could not be found.
	 *
	 * @param thuTuHienThi the thu tu hien thi
	 * @return the matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	public static DanhMuc findByTT(int thuTuHienThi)
		throws dtt.vn.vnpost.exception.NoSuchDanhMucException {

		return getPersistence().findByTT(thuTuHienThi);
	}

	/**
	 * Returns the danh muc where thuTuHienThi = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param thuTuHienThi the thu tu hien thi
	 * @return the matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public static DanhMuc fetchByTT(int thuTuHienThi) {
		return getPersistence().fetchByTT(thuTuHienThi);
	}

	/**
	 * Returns the danh muc where thuTuHienThi = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param thuTuHienThi the thu tu hien thi
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public static DanhMuc fetchByTT(
		int thuTuHienThi, boolean retrieveFromCache) {

		return getPersistence().fetchByTT(thuTuHienThi, retrieveFromCache);
	}

	/**
	 * Removes the danh muc where thuTuHienThi = &#63; from the database.
	 *
	 * @param thuTuHienThi the thu tu hien thi
	 * @return the danh muc that was removed
	 */
	public static DanhMuc removeByTT(int thuTuHienThi)
		throws dtt.vn.vnpost.exception.NoSuchDanhMucException {

		return getPersistence().removeByTT(thuTuHienThi);
	}

	/**
	 * Returns the number of danh mucs where thuTuHienThi = &#63;.
	 *
	 * @param thuTuHienThi the thu tu hien thi
	 * @return the number of matching danh mucs
	 */
	public static int countByTT(int thuTuHienThi) {
		return getPersistence().countByTT(thuTuHienThi);
	}

	/**
	 * Returns all the danh mucs where nhomId = &#63; and trangThai = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param trangThai the trang thai
	 * @return the matching danh mucs
	 */
	public static List<DanhMuc> findByNhomId_TrangThai(
		long nhomId, boolean trangThai) {

		return getPersistence().findByNhomId_TrangThai(nhomId, trangThai);
	}

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
	public static List<DanhMuc> findByNhomId_TrangThai(
		long nhomId, boolean trangThai, int start, int end) {

		return getPersistence().findByNhomId_TrangThai(
			nhomId, trangThai, start, end);
	}

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
	public static List<DanhMuc> findByNhomId_TrangThai(
		long nhomId, boolean trangThai, int start, int end,
		OrderByComparator<DanhMuc> orderByComparator) {

		return getPersistence().findByNhomId_TrangThai(
			nhomId, trangThai, start, end, orderByComparator);
	}

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
	public static List<DanhMuc> findByNhomId_TrangThai(
		long nhomId, boolean trangThai, int start, int end,
		OrderByComparator<DanhMuc> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByNhomId_TrangThai(
			nhomId, trangThai, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	 * Returns the first danh muc in the ordered set where nhomId = &#63; and trangThai = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param trangThai the trang thai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	public static DanhMuc findByNhomId_TrangThai_First(
			long nhomId, boolean trangThai,
			OrderByComparator<DanhMuc> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchDanhMucException {

		return getPersistence().findByNhomId_TrangThai_First(
			nhomId, trangThai, orderByComparator);
	}

	/**
	 * Returns the first danh muc in the ordered set where nhomId = &#63; and trangThai = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param trangThai the trang thai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public static DanhMuc fetchByNhomId_TrangThai_First(
		long nhomId, boolean trangThai,
		OrderByComparator<DanhMuc> orderByComparator) {

		return getPersistence().fetchByNhomId_TrangThai_First(
			nhomId, trangThai, orderByComparator);
	}

	/**
	 * Returns the last danh muc in the ordered set where nhomId = &#63; and trangThai = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param trangThai the trang thai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	public static DanhMuc findByNhomId_TrangThai_Last(
			long nhomId, boolean trangThai,
			OrderByComparator<DanhMuc> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchDanhMucException {

		return getPersistence().findByNhomId_TrangThai_Last(
			nhomId, trangThai, orderByComparator);
	}

	/**
	 * Returns the last danh muc in the ordered set where nhomId = &#63; and trangThai = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param trangThai the trang thai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public static DanhMuc fetchByNhomId_TrangThai_Last(
		long nhomId, boolean trangThai,
		OrderByComparator<DanhMuc> orderByComparator) {

		return getPersistence().fetchByNhomId_TrangThai_Last(
			nhomId, trangThai, orderByComparator);
	}

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
	public static DanhMuc[] findByNhomId_TrangThai_PrevAndNext(
			long id, long nhomId, boolean trangThai,
			OrderByComparator<DanhMuc> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchDanhMucException {

		return getPersistence().findByNhomId_TrangThai_PrevAndNext(
			id, nhomId, trangThai, orderByComparator);
	}

	/**
	 * Removes all the danh mucs where nhomId = &#63; and trangThai = &#63; from the database.
	 *
	 * @param nhomId the nhom ID
	 * @param trangThai the trang thai
	 */
	public static void removeByNhomId_TrangThai(
		long nhomId, boolean trangThai) {

		getPersistence().removeByNhomId_TrangThai(nhomId, trangThai);
	}

	/**
	 * Returns the number of danh mucs where nhomId = &#63; and trangThai = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param trangThai the trang thai
	 * @return the number of matching danh mucs
	 */
	public static int countByNhomId_TrangThai(long nhomId, boolean trangThai) {
		return getPersistence().countByNhomId_TrangThai(nhomId, trangThai);
	}

	/**
	 * Returns the danh muc where ma = &#63; and trangThai = &#63; or throws a <code>NoSuchDanhMucException</code> if it could not be found.
	 *
	 * @param ma the ma
	 * @param trangThai the trang thai
	 * @return the matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	public static DanhMuc findByMa_TrangThai(String ma, boolean trangThai)
		throws dtt.vn.vnpost.exception.NoSuchDanhMucException {

		return getPersistence().findByMa_TrangThai(ma, trangThai);
	}

	/**
	 * Returns the danh muc where ma = &#63; and trangThai = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ma the ma
	 * @param trangThai the trang thai
	 * @return the matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public static DanhMuc fetchByMa_TrangThai(String ma, boolean trangThai) {
		return getPersistence().fetchByMa_TrangThai(ma, trangThai);
	}

	/**
	 * Returns the danh muc where ma = &#63; and trangThai = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ma the ma
	 * @param trangThai the trang thai
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public static DanhMuc fetchByMa_TrangThai(
		String ma, boolean trangThai, boolean retrieveFromCache) {

		return getPersistence().fetchByMa_TrangThai(
			ma, trangThai, retrieveFromCache);
	}

	/**
	 * Removes the danh muc where ma = &#63; and trangThai = &#63; from the database.
	 *
	 * @param ma the ma
	 * @param trangThai the trang thai
	 * @return the danh muc that was removed
	 */
	public static DanhMuc removeByMa_TrangThai(String ma, boolean trangThai)
		throws dtt.vn.vnpost.exception.NoSuchDanhMucException {

		return getPersistence().removeByMa_TrangThai(ma, trangThai);
	}

	/**
	 * Returns the number of danh mucs where ma = &#63; and trangThai = &#63;.
	 *
	 * @param ma the ma
	 * @param trangThai the trang thai
	 * @return the number of matching danh mucs
	 */
	public static int countByMa_TrangThai(String ma, boolean trangThai) {
		return getPersistence().countByMa_TrangThai(ma, trangThai);
	}

	/**
	 * Returns all the danh mucs where ma = &#63; and muc = &#63;.
	 *
	 * @param ma the ma
	 * @param muc the muc
	 * @return the matching danh mucs
	 */
	public static List<DanhMuc> findByMa_Muc(String ma, int muc) {
		return getPersistence().findByMa_Muc(ma, muc);
	}

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
	public static List<DanhMuc> findByMa_Muc(
		String ma, int muc, int start, int end) {

		return getPersistence().findByMa_Muc(ma, muc, start, end);
	}

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
	public static List<DanhMuc> findByMa_Muc(
		String ma, int muc, int start, int end,
		OrderByComparator<DanhMuc> orderByComparator) {

		return getPersistence().findByMa_Muc(
			ma, muc, start, end, orderByComparator);
	}

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
	public static List<DanhMuc> findByMa_Muc(
		String ma, int muc, int start, int end,
		OrderByComparator<DanhMuc> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByMa_Muc(
			ma, muc, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first danh muc in the ordered set where ma = &#63; and muc = &#63;.
	 *
	 * @param ma the ma
	 * @param muc the muc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	public static DanhMuc findByMa_Muc_First(
			String ma, int muc, OrderByComparator<DanhMuc> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchDanhMucException {

		return getPersistence().findByMa_Muc_First(ma, muc, orderByComparator);
	}

	/**
	 * Returns the first danh muc in the ordered set where ma = &#63; and muc = &#63;.
	 *
	 * @param ma the ma
	 * @param muc the muc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public static DanhMuc fetchByMa_Muc_First(
		String ma, int muc, OrderByComparator<DanhMuc> orderByComparator) {

		return getPersistence().fetchByMa_Muc_First(ma, muc, orderByComparator);
	}

	/**
	 * Returns the last danh muc in the ordered set where ma = &#63; and muc = &#63;.
	 *
	 * @param ma the ma
	 * @param muc the muc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	public static DanhMuc findByMa_Muc_Last(
			String ma, int muc, OrderByComparator<DanhMuc> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchDanhMucException {

		return getPersistence().findByMa_Muc_Last(ma, muc, orderByComparator);
	}

	/**
	 * Returns the last danh muc in the ordered set where ma = &#63; and muc = &#63;.
	 *
	 * @param ma the ma
	 * @param muc the muc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public static DanhMuc fetchByMa_Muc_Last(
		String ma, int muc, OrderByComparator<DanhMuc> orderByComparator) {

		return getPersistence().fetchByMa_Muc_Last(ma, muc, orderByComparator);
	}

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
	public static DanhMuc[] findByMa_Muc_PrevAndNext(
			long id, String ma, int muc,
			OrderByComparator<DanhMuc> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchDanhMucException {

		return getPersistence().findByMa_Muc_PrevAndNext(
			id, ma, muc, orderByComparator);
	}

	/**
	 * Removes all the danh mucs where ma = &#63; and muc = &#63; from the database.
	 *
	 * @param ma the ma
	 * @param muc the muc
	 */
	public static void removeByMa_Muc(String ma, int muc) {
		getPersistence().removeByMa_Muc(ma, muc);
	}

	/**
	 * Returns the number of danh mucs where ma = &#63; and muc = &#63;.
	 *
	 * @param ma the ma
	 * @param muc the muc
	 * @return the number of matching danh mucs
	 */
	public static int countByMa_Muc(String ma, int muc) {
		return getPersistence().countByMa_Muc(ma, muc);
	}

	/**
	 * Returns all the danh mucs where chaId = &#63; and muc = &#63; and trangThai = &#63;.
	 *
	 * @param chaId the cha ID
	 * @param muc the muc
	 * @param trangThai the trang thai
	 * @return the matching danh mucs
	 */
	public static List<DanhMuc> findByChaId_Muc(
		long chaId, int muc, boolean trangThai) {

		return getPersistence().findByChaId_Muc(chaId, muc, trangThai);
	}

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
	public static List<DanhMuc> findByChaId_Muc(
		long chaId, int muc, boolean trangThai, int start, int end) {

		return getPersistence().findByChaId_Muc(
			chaId, muc, trangThai, start, end);
	}

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
	public static List<DanhMuc> findByChaId_Muc(
		long chaId, int muc, boolean trangThai, int start, int end,
		OrderByComparator<DanhMuc> orderByComparator) {

		return getPersistence().findByChaId_Muc(
			chaId, muc, trangThai, start, end, orderByComparator);
	}

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
	public static List<DanhMuc> findByChaId_Muc(
		long chaId, int muc, boolean trangThai, int start, int end,
		OrderByComparator<DanhMuc> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByChaId_Muc(
			chaId, muc, trangThai, start, end, orderByComparator,
			retrieveFromCache);
	}

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
	public static DanhMuc findByChaId_Muc_First(
			long chaId, int muc, boolean trangThai,
			OrderByComparator<DanhMuc> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchDanhMucException {

		return getPersistence().findByChaId_Muc_First(
			chaId, muc, trangThai, orderByComparator);
	}

	/**
	 * Returns the first danh muc in the ordered set where chaId = &#63; and muc = &#63; and trangThai = &#63;.
	 *
	 * @param chaId the cha ID
	 * @param muc the muc
	 * @param trangThai the trang thai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public static DanhMuc fetchByChaId_Muc_First(
		long chaId, int muc, boolean trangThai,
		OrderByComparator<DanhMuc> orderByComparator) {

		return getPersistence().fetchByChaId_Muc_First(
			chaId, muc, trangThai, orderByComparator);
	}

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
	public static DanhMuc findByChaId_Muc_Last(
			long chaId, int muc, boolean trangThai,
			OrderByComparator<DanhMuc> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchDanhMucException {

		return getPersistence().findByChaId_Muc_Last(
			chaId, muc, trangThai, orderByComparator);
	}

	/**
	 * Returns the last danh muc in the ordered set where chaId = &#63; and muc = &#63; and trangThai = &#63;.
	 *
	 * @param chaId the cha ID
	 * @param muc the muc
	 * @param trangThai the trang thai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public static DanhMuc fetchByChaId_Muc_Last(
		long chaId, int muc, boolean trangThai,
		OrderByComparator<DanhMuc> orderByComparator) {

		return getPersistence().fetchByChaId_Muc_Last(
			chaId, muc, trangThai, orderByComparator);
	}

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
	public static DanhMuc[] findByChaId_Muc_PrevAndNext(
			long id, long chaId, int muc, boolean trangThai,
			OrderByComparator<DanhMuc> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchDanhMucException {

		return getPersistence().findByChaId_Muc_PrevAndNext(
			id, chaId, muc, trangThai, orderByComparator);
	}

	/**
	 * Removes all the danh mucs where chaId = &#63; and muc = &#63; and trangThai = &#63; from the database.
	 *
	 * @param chaId the cha ID
	 * @param muc the muc
	 * @param trangThai the trang thai
	 */
	public static void removeByChaId_Muc(
		long chaId, int muc, boolean trangThai) {

		getPersistence().removeByChaId_Muc(chaId, muc, trangThai);
	}

	/**
	 * Returns the number of danh mucs where chaId = &#63; and muc = &#63; and trangThai = &#63;.
	 *
	 * @param chaId the cha ID
	 * @param muc the muc
	 * @param trangThai the trang thai
	 * @return the number of matching danh mucs
	 */
	public static int countByChaId_Muc(long chaId, int muc, boolean trangThai) {
		return getPersistence().countByChaId_Muc(chaId, muc, trangThai);
	}

	/**
	 * Returns all the danh mucs where nhomId = &#63; and muc = &#63; and trangThai = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param trangThai the trang thai
	 * @return the matching danh mucs
	 */
	public static List<DanhMuc> findByNhomId_Muc_TrangThai(
		long nhomId, int muc, boolean trangThai) {

		return getPersistence().findByNhomId_Muc_TrangThai(
			nhomId, muc, trangThai);
	}

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
	public static List<DanhMuc> findByNhomId_Muc_TrangThai(
		long nhomId, int muc, boolean trangThai, int start, int end) {

		return getPersistence().findByNhomId_Muc_TrangThai(
			nhomId, muc, trangThai, start, end);
	}

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
	public static List<DanhMuc> findByNhomId_Muc_TrangThai(
		long nhomId, int muc, boolean trangThai, int start, int end,
		OrderByComparator<DanhMuc> orderByComparator) {

		return getPersistence().findByNhomId_Muc_TrangThai(
			nhomId, muc, trangThai, start, end, orderByComparator);
	}

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
	public static List<DanhMuc> findByNhomId_Muc_TrangThai(
		long nhomId, int muc, boolean trangThai, int start, int end,
		OrderByComparator<DanhMuc> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByNhomId_Muc_TrangThai(
			nhomId, muc, trangThai, start, end, orderByComparator,
			retrieveFromCache);
	}

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
	public static DanhMuc findByNhomId_Muc_TrangThai_First(
			long nhomId, int muc, boolean trangThai,
			OrderByComparator<DanhMuc> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchDanhMucException {

		return getPersistence().findByNhomId_Muc_TrangThai_First(
			nhomId, muc, trangThai, orderByComparator);
	}

	/**
	 * Returns the first danh muc in the ordered set where nhomId = &#63; and muc = &#63; and trangThai = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param trangThai the trang thai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public static DanhMuc fetchByNhomId_Muc_TrangThai_First(
		long nhomId, int muc, boolean trangThai,
		OrderByComparator<DanhMuc> orderByComparator) {

		return getPersistence().fetchByNhomId_Muc_TrangThai_First(
			nhomId, muc, trangThai, orderByComparator);
	}

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
	public static DanhMuc findByNhomId_Muc_TrangThai_Last(
			long nhomId, int muc, boolean trangThai,
			OrderByComparator<DanhMuc> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchDanhMucException {

		return getPersistence().findByNhomId_Muc_TrangThai_Last(
			nhomId, muc, trangThai, orderByComparator);
	}

	/**
	 * Returns the last danh muc in the ordered set where nhomId = &#63; and muc = &#63; and trangThai = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param trangThai the trang thai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public static DanhMuc fetchByNhomId_Muc_TrangThai_Last(
		long nhomId, int muc, boolean trangThai,
		OrderByComparator<DanhMuc> orderByComparator) {

		return getPersistence().fetchByNhomId_Muc_TrangThai_Last(
			nhomId, muc, trangThai, orderByComparator);
	}

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
	public static DanhMuc[] findByNhomId_Muc_TrangThai_PrevAndNext(
			long id, long nhomId, int muc, boolean trangThai,
			OrderByComparator<DanhMuc> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchDanhMucException {

		return getPersistence().findByNhomId_Muc_TrangThai_PrevAndNext(
			id, nhomId, muc, trangThai, orderByComparator);
	}

	/**
	 * Removes all the danh mucs where nhomId = &#63; and muc = &#63; and trangThai = &#63; from the database.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param trangThai the trang thai
	 */
	public static void removeByNhomId_Muc_TrangThai(
		long nhomId, int muc, boolean trangThai) {

		getPersistence().removeByNhomId_Muc_TrangThai(nhomId, muc, trangThai);
	}

	/**
	 * Returns the number of danh mucs where nhomId = &#63; and muc = &#63; and trangThai = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param trangThai the trang thai
	 * @return the number of matching danh mucs
	 */
	public static int countByNhomId_Muc_TrangThai(
		long nhomId, int muc, boolean trangThai) {

		return getPersistence().countByNhomId_Muc_TrangThai(
			nhomId, muc, trangThai);
	}

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
	public static DanhMuc findByNhomId_Muc_Ten_TrangThai(
			long nhomId, int muc, String ten, boolean trangThai)
		throws dtt.vn.vnpost.exception.NoSuchDanhMucException {

		return getPersistence().findByNhomId_Muc_Ten_TrangThai(
			nhomId, muc, ten, trangThai);
	}

	/**
	 * Returns the danh muc where nhomId = &#63; and muc = &#63; and ten = &#63; and trangThai = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param ten the ten
	 * @param trangThai the trang thai
	 * @return the matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public static DanhMuc fetchByNhomId_Muc_Ten_TrangThai(
		long nhomId, int muc, String ten, boolean trangThai) {

		return getPersistence().fetchByNhomId_Muc_Ten_TrangThai(
			nhomId, muc, ten, trangThai);
	}

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
	public static DanhMuc fetchByNhomId_Muc_Ten_TrangThai(
		long nhomId, int muc, String ten, boolean trangThai,
		boolean retrieveFromCache) {

		return getPersistence().fetchByNhomId_Muc_Ten_TrangThai(
			nhomId, muc, ten, trangThai, retrieveFromCache);
	}

	/**
	 * Removes the danh muc where nhomId = &#63; and muc = &#63; and ten = &#63; and trangThai = &#63; from the database.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param ten the ten
	 * @param trangThai the trang thai
	 * @return the danh muc that was removed
	 */
	public static DanhMuc removeByNhomId_Muc_Ten_TrangThai(
			long nhomId, int muc, String ten, boolean trangThai)
		throws dtt.vn.vnpost.exception.NoSuchDanhMucException {

		return getPersistence().removeByNhomId_Muc_Ten_TrangThai(
			nhomId, muc, ten, trangThai);
	}

	/**
	 * Returns the number of danh mucs where nhomId = &#63; and muc = &#63; and ten = &#63; and trangThai = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param ten the ten
	 * @param trangThai the trang thai
	 * @return the number of matching danh mucs
	 */
	public static int countByNhomId_Muc_Ten_TrangThai(
		long nhomId, int muc, String ten, boolean trangThai) {

		return getPersistence().countByNhomId_Muc_Ten_TrangThai(
			nhomId, muc, ten, trangThai);
	}

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
	public static DanhMuc findByNhomId_Muc_Ma_TrangThai(
			long nhomId, int muc, String ma, boolean trangThai)
		throws dtt.vn.vnpost.exception.NoSuchDanhMucException {

		return getPersistence().findByNhomId_Muc_Ma_TrangThai(
			nhomId, muc, ma, trangThai);
	}

	/**
	 * Returns the danh muc where nhomId = &#63; and muc = &#63; and ma = &#63; and trangThai = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param ma the ma
	 * @param trangThai the trang thai
	 * @return the matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public static DanhMuc fetchByNhomId_Muc_Ma_TrangThai(
		long nhomId, int muc, String ma, boolean trangThai) {

		return getPersistence().fetchByNhomId_Muc_Ma_TrangThai(
			nhomId, muc, ma, trangThai);
	}

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
	public static DanhMuc fetchByNhomId_Muc_Ma_TrangThai(
		long nhomId, int muc, String ma, boolean trangThai,
		boolean retrieveFromCache) {

		return getPersistence().fetchByNhomId_Muc_Ma_TrangThai(
			nhomId, muc, ma, trangThai, retrieveFromCache);
	}

	/**
	 * Removes the danh muc where nhomId = &#63; and muc = &#63; and ma = &#63; and trangThai = &#63; from the database.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param ma the ma
	 * @param trangThai the trang thai
	 * @return the danh muc that was removed
	 */
	public static DanhMuc removeByNhomId_Muc_Ma_TrangThai(
			long nhomId, int muc, String ma, boolean trangThai)
		throws dtt.vn.vnpost.exception.NoSuchDanhMucException {

		return getPersistence().removeByNhomId_Muc_Ma_TrangThai(
			nhomId, muc, ma, trangThai);
	}

	/**
	 * Returns the number of danh mucs where nhomId = &#63; and muc = &#63; and ma = &#63; and trangThai = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param ma the ma
	 * @param trangThai the trang thai
	 * @return the number of matching danh mucs
	 */
	public static int countByNhomId_Muc_Ma_TrangThai(
		long nhomId, int muc, String ma, boolean trangThai) {

		return getPersistence().countByNhomId_Muc_Ma_TrangThai(
			nhomId, muc, ma, trangThai);
	}

	/**
	 * Returns all the danh mucs where id = &#63;.
	 *
	 * @param id the ID
	 * @return the matching danh mucs
	 */
	public static List<DanhMuc> findByIds(long id) {
		return getPersistence().findByIds(id);
	}

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
	public static List<DanhMuc> findByIds(long id, int start, int end) {
		return getPersistence().findByIds(id, start, end);
	}

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
	public static List<DanhMuc> findByIds(
		long id, int start, int end,
		OrderByComparator<DanhMuc> orderByComparator) {

		return getPersistence().findByIds(id, start, end, orderByComparator);
	}

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
	public static List<DanhMuc> findByIds(
		long id, int start, int end,
		OrderByComparator<DanhMuc> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByIds(
			id, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first danh muc in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	public static DanhMuc findByIds_First(
			long id, OrderByComparator<DanhMuc> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchDanhMucException {

		return getPersistence().findByIds_First(id, orderByComparator);
	}

	/**
	 * Returns the first danh muc in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public static DanhMuc fetchByIds_First(
		long id, OrderByComparator<DanhMuc> orderByComparator) {

		return getPersistence().fetchByIds_First(id, orderByComparator);
	}

	/**
	 * Returns the last danh muc in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	public static DanhMuc findByIds_Last(
			long id, OrderByComparator<DanhMuc> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchDanhMucException {

		return getPersistence().findByIds_Last(id, orderByComparator);
	}

	/**
	 * Returns the last danh muc in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public static DanhMuc fetchByIds_Last(
		long id, OrderByComparator<DanhMuc> orderByComparator) {

		return getPersistence().fetchByIds_Last(id, orderByComparator);
	}

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
	public static List<DanhMuc> findByIds(long[] ids) {
		return getPersistence().findByIds(ids);
	}

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
	public static List<DanhMuc> findByIds(long[] ids, int start, int end) {
		return getPersistence().findByIds(ids, start, end);
	}

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
	public static List<DanhMuc> findByIds(
		long[] ids, int start, int end,
		OrderByComparator<DanhMuc> orderByComparator) {

		return getPersistence().findByIds(ids, start, end, orderByComparator);
	}

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
	public static List<DanhMuc> findByIds(
		long[] ids, int start, int end,
		OrderByComparator<DanhMuc> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByIds(
			ids, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the danh mucs where id = &#63; from the database.
	 *
	 * @param id the ID
	 */
	public static void removeByIds(long id) {
		getPersistence().removeByIds(id);
	}

	/**
	 * Returns the number of danh mucs where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching danh mucs
	 */
	public static int countByIds(long id) {
		return getPersistence().countByIds(id);
	}

	/**
	 * Returns the number of danh mucs where id = any &#63;.
	 *
	 * @param ids the IDs
	 * @return the number of matching danh mucs
	 */
	public static int countByIds(long[] ids) {
		return getPersistence().countByIds(ids);
	}

	/**
	 * Returns all the danh mucs where nhomId = &#63; and muc = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @return the matching danh mucs
	 */
	public static List<DanhMuc> findByNhomId_Muc(long nhomId, int muc) {
		return getPersistence().findByNhomId_Muc(nhomId, muc);
	}

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
	public static List<DanhMuc> findByNhomId_Muc(
		long nhomId, int muc, int start, int end) {

		return getPersistence().findByNhomId_Muc(nhomId, muc, start, end);
	}

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
	public static List<DanhMuc> findByNhomId_Muc(
		long nhomId, int muc, int start, int end,
		OrderByComparator<DanhMuc> orderByComparator) {

		return getPersistence().findByNhomId_Muc(
			nhomId, muc, start, end, orderByComparator);
	}

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
	public static List<DanhMuc> findByNhomId_Muc(
		long nhomId, int muc, int start, int end,
		OrderByComparator<DanhMuc> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByNhomId_Muc(
			nhomId, muc, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first danh muc in the ordered set where nhomId = &#63; and muc = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	public static DanhMuc findByNhomId_Muc_First(
			long nhomId, int muc, OrderByComparator<DanhMuc> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchDanhMucException {

		return getPersistence().findByNhomId_Muc_First(
			nhomId, muc, orderByComparator);
	}

	/**
	 * Returns the first danh muc in the ordered set where nhomId = &#63; and muc = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public static DanhMuc fetchByNhomId_Muc_First(
		long nhomId, int muc, OrderByComparator<DanhMuc> orderByComparator) {

		return getPersistence().fetchByNhomId_Muc_First(
			nhomId, muc, orderByComparator);
	}

	/**
	 * Returns the last danh muc in the ordered set where nhomId = &#63; and muc = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	public static DanhMuc findByNhomId_Muc_Last(
			long nhomId, int muc, OrderByComparator<DanhMuc> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchDanhMucException {

		return getPersistence().findByNhomId_Muc_Last(
			nhomId, muc, orderByComparator);
	}

	/**
	 * Returns the last danh muc in the ordered set where nhomId = &#63; and muc = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public static DanhMuc fetchByNhomId_Muc_Last(
		long nhomId, int muc, OrderByComparator<DanhMuc> orderByComparator) {

		return getPersistence().fetchByNhomId_Muc_Last(
			nhomId, muc, orderByComparator);
	}

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
	public static DanhMuc[] findByNhomId_Muc_PrevAndNext(
			long id, long nhomId, int muc,
			OrderByComparator<DanhMuc> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchDanhMucException {

		return getPersistence().findByNhomId_Muc_PrevAndNext(
			id, nhomId, muc, orderByComparator);
	}

	/**
	 * Removes all the danh mucs where nhomId = &#63; and muc = &#63; from the database.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 */
	public static void removeByNhomId_Muc(long nhomId, int muc) {
		getPersistence().removeByNhomId_Muc(nhomId, muc);
	}

	/**
	 * Returns the number of danh mucs where nhomId = &#63; and muc = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param muc the muc
	 * @return the number of matching danh mucs
	 */
	public static int countByNhomId_Muc(long nhomId, int muc) {
		return getPersistence().countByNhomId_Muc(nhomId, muc);
	}

	/**
	 * Returns the danh muc where nhomId = &#63; and ma = &#63; or throws a <code>NoSuchDanhMucException</code> if it could not be found.
	 *
	 * @param nhomId the nhom ID
	 * @param ma the ma
	 * @return the matching danh muc
	 * @throws NoSuchDanhMucException if a matching danh muc could not be found
	 */
	public static DanhMuc findByNhomId_Ma(long nhomId, String ma)
		throws dtt.vn.vnpost.exception.NoSuchDanhMucException {

		return getPersistence().findByNhomId_Ma(nhomId, ma);
	}

	/**
	 * Returns the danh muc where nhomId = &#63; and ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nhomId the nhom ID
	 * @param ma the ma
	 * @return the matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public static DanhMuc fetchByNhomId_Ma(long nhomId, String ma) {
		return getPersistence().fetchByNhomId_Ma(nhomId, ma);
	}

	/**
	 * Returns the danh muc where nhomId = &#63; and ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nhomId the nhom ID
	 * @param ma the ma
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching danh muc, or <code>null</code> if a matching danh muc could not be found
	 */
	public static DanhMuc fetchByNhomId_Ma(
		long nhomId, String ma, boolean retrieveFromCache) {

		return getPersistence().fetchByNhomId_Ma(nhomId, ma, retrieveFromCache);
	}

	/**
	 * Removes the danh muc where nhomId = &#63; and ma = &#63; from the database.
	 *
	 * @param nhomId the nhom ID
	 * @param ma the ma
	 * @return the danh muc that was removed
	 */
	public static DanhMuc removeByNhomId_Ma(long nhomId, String ma)
		throws dtt.vn.vnpost.exception.NoSuchDanhMucException {

		return getPersistence().removeByNhomId_Ma(nhomId, ma);
	}

	/**
	 * Returns the number of danh mucs where nhomId = &#63; and ma = &#63;.
	 *
	 * @param nhomId the nhom ID
	 * @param ma the ma
	 * @return the number of matching danh mucs
	 */
	public static int countByNhomId_Ma(long nhomId, String ma) {
		return getPersistence().countByNhomId_Ma(nhomId, ma);
	}

	/**
	 * Caches the danh muc in the entity cache if it is enabled.
	 *
	 * @param danhMuc the danh muc
	 */
	public static void cacheResult(DanhMuc danhMuc) {
		getPersistence().cacheResult(danhMuc);
	}

	/**
	 * Caches the danh mucs in the entity cache if it is enabled.
	 *
	 * @param danhMucs the danh mucs
	 */
	public static void cacheResult(List<DanhMuc> danhMucs) {
		getPersistence().cacheResult(danhMucs);
	}

	/**
	 * Creates a new danh muc with the primary key. Does not add the danh muc to the database.
	 *
	 * @param id the primary key for the new danh muc
	 * @return the new danh muc
	 */
	public static DanhMuc create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the danh muc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the danh muc
	 * @return the danh muc that was removed
	 * @throws NoSuchDanhMucException if a danh muc with the primary key could not be found
	 */
	public static DanhMuc remove(long id)
		throws dtt.vn.vnpost.exception.NoSuchDanhMucException {

		return getPersistence().remove(id);
	}

	public static DanhMuc updateImpl(DanhMuc danhMuc) {
		return getPersistence().updateImpl(danhMuc);
	}

	/**
	 * Returns the danh muc with the primary key or throws a <code>NoSuchDanhMucException</code> if it could not be found.
	 *
	 * @param id the primary key of the danh muc
	 * @return the danh muc
	 * @throws NoSuchDanhMucException if a danh muc with the primary key could not be found
	 */
	public static DanhMuc findByPrimaryKey(long id)
		throws dtt.vn.vnpost.exception.NoSuchDanhMucException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the danh muc with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the danh muc
	 * @return the danh muc, or <code>null</code> if a danh muc with the primary key could not be found
	 */
	public static DanhMuc fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the danh mucs.
	 *
	 * @return the danh mucs
	 */
	public static List<DanhMuc> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<DanhMuc> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<DanhMuc> findAll(
		int start, int end, OrderByComparator<DanhMuc> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<DanhMuc> findAll(
		int start, int end, OrderByComparator<DanhMuc> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the danh mucs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of danh mucs.
	 *
	 * @return the number of danh mucs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static DanhMucPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<DanhMucPersistence, DanhMucPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(DanhMucPersistence.class);

		ServiceTracker<DanhMucPersistence, DanhMucPersistence> serviceTracker =
			new ServiceTracker<DanhMucPersistence, DanhMucPersistence>(
				bundle.getBundleContext(), DanhMucPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}