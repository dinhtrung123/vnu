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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.oep.core.model.ThamSo;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the tham so service. This utility wraps <code>org.oep.core.service.persistence.impl.ThamSoPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author manhlb
 * @see ThamSoPersistence
 * @generated
 */
@ProviderType
public class ThamSoUtil {

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
	public static void clearCache(ThamSo thamSo) {
		getPersistence().clearCache(thamSo);
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
	public static Map<Serializable, ThamSo> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ThamSo> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ThamSo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ThamSo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ThamSo> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ThamSo update(ThamSo thamSo) {
		return getPersistence().update(thamSo);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ThamSo update(ThamSo thamSo, ServiceContext serviceContext) {
		return getPersistence().update(thamSo, serviceContext);
	}

	/**
	 * Returns the tham so where groupId = &#63; and ma = &#63; or throws a <code>NoSuchThamSoException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param ma the ma
	 * @return the matching tham so
	 * @throws NoSuchThamSoException if a matching tham so could not be found
	 */
	public static ThamSo findByG_M(long groupId, String ma)
		throws org.oep.core.exception.NoSuchThamSoException {

		return getPersistence().findByG_M(groupId, ma);
	}

	/**
	 * Returns the tham so where groupId = &#63; and ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param ma the ma
	 * @return the matching tham so, or <code>null</code> if a matching tham so could not be found
	 */
	public static ThamSo fetchByG_M(long groupId, String ma) {
		return getPersistence().fetchByG_M(groupId, ma);
	}

	/**
	 * Returns the tham so where groupId = &#63; and ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param ma the ma
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching tham so, or <code>null</code> if a matching tham so could not be found
	 */
	public static ThamSo fetchByG_M(
		long groupId, String ma, boolean retrieveFromCache) {

		return getPersistence().fetchByG_M(groupId, ma, retrieveFromCache);
	}

	/**
	 * Removes the tham so where groupId = &#63; and ma = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param ma the ma
	 * @return the tham so that was removed
	 */
	public static ThamSo removeByG_M(long groupId, String ma)
		throws org.oep.core.exception.NoSuchThamSoException {

		return getPersistence().removeByG_M(groupId, ma);
	}

	/**
	 * Returns the number of tham sos where groupId = &#63; and ma = &#63;.
	 *
	 * @param groupId the group ID
	 * @param ma the ma
	 * @return the number of matching tham sos
	 */
	public static int countByG_M(long groupId, String ma) {
		return getPersistence().countByG_M(groupId, ma);
	}

	/**
	 * Returns the tham so where ma = &#63; and className = &#63; or throws a <code>NoSuchThamSoException</code> if it could not be found.
	 *
	 * @param ma the ma
	 * @param className the class name
	 * @return the matching tham so
	 * @throws NoSuchThamSoException if a matching tham so could not be found
	 */
	public static ThamSo findByM_CL(String ma, String className)
		throws org.oep.core.exception.NoSuchThamSoException {

		return getPersistence().findByM_CL(ma, className);
	}

	/**
	 * Returns the tham so where ma = &#63; and className = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ma the ma
	 * @param className the class name
	 * @return the matching tham so, or <code>null</code> if a matching tham so could not be found
	 */
	public static ThamSo fetchByM_CL(String ma, String className) {
		return getPersistence().fetchByM_CL(ma, className);
	}

	/**
	 * Returns the tham so where ma = &#63; and className = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ma the ma
	 * @param className the class name
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching tham so, or <code>null</code> if a matching tham so could not be found
	 */
	public static ThamSo fetchByM_CL(
		String ma, String className, boolean retrieveFromCache) {

		return getPersistence().fetchByM_CL(ma, className, retrieveFromCache);
	}

	/**
	 * Removes the tham so where ma = &#63; and className = &#63; from the database.
	 *
	 * @param ma the ma
	 * @param className the class name
	 * @return the tham so that was removed
	 */
	public static ThamSo removeByM_CL(String ma, String className)
		throws org.oep.core.exception.NoSuchThamSoException {

		return getPersistence().removeByM_CL(ma, className);
	}

	/**
	 * Returns the number of tham sos where ma = &#63; and className = &#63;.
	 *
	 * @param ma the ma
	 * @param className the class name
	 * @return the number of matching tham sos
	 */
	public static int countByM_CL(String ma, String className) {
		return getPersistence().countByM_CL(ma, className);
	}

	/**
	 * Returns the tham so where ma = &#63; and className = &#63; and classPK = &#63; or throws a <code>NoSuchThamSoException</code> if it could not be found.
	 *
	 * @param ma the ma
	 * @param className the class name
	 * @param classPK the class pk
	 * @return the matching tham so
	 * @throws NoSuchThamSoException if a matching tham so could not be found
	 */
	public static ThamSo findByM_CL_PK(
			String ma, String className, long classPK)
		throws org.oep.core.exception.NoSuchThamSoException {

		return getPersistence().findByM_CL_PK(ma, className, classPK);
	}

	/**
	 * Returns the tham so where ma = &#63; and className = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ma the ma
	 * @param className the class name
	 * @param classPK the class pk
	 * @return the matching tham so, or <code>null</code> if a matching tham so could not be found
	 */
	public static ThamSo fetchByM_CL_PK(
		String ma, String className, long classPK) {

		return getPersistence().fetchByM_CL_PK(ma, className, classPK);
	}

	/**
	 * Returns the tham so where ma = &#63; and className = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ma the ma
	 * @param className the class name
	 * @param classPK the class pk
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching tham so, or <code>null</code> if a matching tham so could not be found
	 */
	public static ThamSo fetchByM_CL_PK(
		String ma, String className, long classPK, boolean retrieveFromCache) {

		return getPersistence().fetchByM_CL_PK(
			ma, className, classPK, retrieveFromCache);
	}

	/**
	 * Removes the tham so where ma = &#63; and className = &#63; and classPK = &#63; from the database.
	 *
	 * @param ma the ma
	 * @param className the class name
	 * @param classPK the class pk
	 * @return the tham so that was removed
	 */
	public static ThamSo removeByM_CL_PK(
			String ma, String className, long classPK)
		throws org.oep.core.exception.NoSuchThamSoException {

		return getPersistence().removeByM_CL_PK(ma, className, classPK);
	}

	/**
	 * Returns the number of tham sos where ma = &#63; and className = &#63; and classPK = &#63;.
	 *
	 * @param ma the ma
	 * @param className the class name
	 * @param classPK the class pk
	 * @return the number of matching tham sos
	 */
	public static int countByM_CL_PK(
		String ma, String className, long classPK) {

		return getPersistence().countByM_CL_PK(ma, className, classPK);
	}

	/**
	 * Returns all the tham sos where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the matching tham sos
	 */
	public static List<ThamSo> findByMa(String ma) {
		return getPersistence().findByMa(ma);
	}

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
	public static List<ThamSo> findByMa(String ma, int start, int end) {
		return getPersistence().findByMa(ma, start, end);
	}

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
	public static List<ThamSo> findByMa(
		String ma, int start, int end,
		OrderByComparator<ThamSo> orderByComparator) {

		return getPersistence().findByMa(ma, start, end, orderByComparator);
	}

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
	public static List<ThamSo> findByMa(
		String ma, int start, int end,
		OrderByComparator<ThamSo> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByMa(
			ma, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first tham so in the ordered set where ma = &#63;.
	 *
	 * @param ma the ma
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tham so
	 * @throws NoSuchThamSoException if a matching tham so could not be found
	 */
	public static ThamSo findByMa_First(
			String ma, OrderByComparator<ThamSo> orderByComparator)
		throws org.oep.core.exception.NoSuchThamSoException {

		return getPersistence().findByMa_First(ma, orderByComparator);
	}

	/**
	 * Returns the first tham so in the ordered set where ma = &#63;.
	 *
	 * @param ma the ma
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tham so, or <code>null</code> if a matching tham so could not be found
	 */
	public static ThamSo fetchByMa_First(
		String ma, OrderByComparator<ThamSo> orderByComparator) {

		return getPersistence().fetchByMa_First(ma, orderByComparator);
	}

	/**
	 * Returns the last tham so in the ordered set where ma = &#63;.
	 *
	 * @param ma the ma
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tham so
	 * @throws NoSuchThamSoException if a matching tham so could not be found
	 */
	public static ThamSo findByMa_Last(
			String ma, OrderByComparator<ThamSo> orderByComparator)
		throws org.oep.core.exception.NoSuchThamSoException {

		return getPersistence().findByMa_Last(ma, orderByComparator);
	}

	/**
	 * Returns the last tham so in the ordered set where ma = &#63;.
	 *
	 * @param ma the ma
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tham so, or <code>null</code> if a matching tham so could not be found
	 */
	public static ThamSo fetchByMa_Last(
		String ma, OrderByComparator<ThamSo> orderByComparator) {

		return getPersistence().fetchByMa_Last(ma, orderByComparator);
	}

	/**
	 * Returns the tham sos before and after the current tham so in the ordered set where ma = &#63;.
	 *
	 * @param id the primary key of the current tham so
	 * @param ma the ma
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tham so
	 * @throws NoSuchThamSoException if a tham so with the primary key could not be found
	 */
	public static ThamSo[] findByMa_PrevAndNext(
			long id, String ma, OrderByComparator<ThamSo> orderByComparator)
		throws org.oep.core.exception.NoSuchThamSoException {

		return getPersistence().findByMa_PrevAndNext(id, ma, orderByComparator);
	}

	/**
	 * Removes all the tham sos where ma = &#63; from the database.
	 *
	 * @param ma the ma
	 */
	public static void removeByMa(String ma) {
		getPersistence().removeByMa(ma);
	}

	/**
	 * Returns the number of tham sos where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the number of matching tham sos
	 */
	public static int countByMa(String ma) {
		return getPersistence().countByMa(ma);
	}

	/**
	 * Returns all the tham sos where giaTri = &#63;.
	 *
	 * @param giaTri the gia tri
	 * @return the matching tham sos
	 */
	public static List<ThamSo> findBygiaTri(String giaTri) {
		return getPersistence().findBygiaTri(giaTri);
	}

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
	public static List<ThamSo> findBygiaTri(String giaTri, int start, int end) {
		return getPersistence().findBygiaTri(giaTri, start, end);
	}

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
	public static List<ThamSo> findBygiaTri(
		String giaTri, int start, int end,
		OrderByComparator<ThamSo> orderByComparator) {

		return getPersistence().findBygiaTri(
			giaTri, start, end, orderByComparator);
	}

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
	public static List<ThamSo> findBygiaTri(
		String giaTri, int start, int end,
		OrderByComparator<ThamSo> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findBygiaTri(
			giaTri, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first tham so in the ordered set where giaTri = &#63;.
	 *
	 * @param giaTri the gia tri
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tham so
	 * @throws NoSuchThamSoException if a matching tham so could not be found
	 */
	public static ThamSo findBygiaTri_First(
			String giaTri, OrderByComparator<ThamSo> orderByComparator)
		throws org.oep.core.exception.NoSuchThamSoException {

		return getPersistence().findBygiaTri_First(giaTri, orderByComparator);
	}

	/**
	 * Returns the first tham so in the ordered set where giaTri = &#63;.
	 *
	 * @param giaTri the gia tri
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tham so, or <code>null</code> if a matching tham so could not be found
	 */
	public static ThamSo fetchBygiaTri_First(
		String giaTri, OrderByComparator<ThamSo> orderByComparator) {

		return getPersistence().fetchBygiaTri_First(giaTri, orderByComparator);
	}

	/**
	 * Returns the last tham so in the ordered set where giaTri = &#63;.
	 *
	 * @param giaTri the gia tri
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tham so
	 * @throws NoSuchThamSoException if a matching tham so could not be found
	 */
	public static ThamSo findBygiaTri_Last(
			String giaTri, OrderByComparator<ThamSo> orderByComparator)
		throws org.oep.core.exception.NoSuchThamSoException {

		return getPersistence().findBygiaTri_Last(giaTri, orderByComparator);
	}

	/**
	 * Returns the last tham so in the ordered set where giaTri = &#63;.
	 *
	 * @param giaTri the gia tri
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tham so, or <code>null</code> if a matching tham so could not be found
	 */
	public static ThamSo fetchBygiaTri_Last(
		String giaTri, OrderByComparator<ThamSo> orderByComparator) {

		return getPersistence().fetchBygiaTri_Last(giaTri, orderByComparator);
	}

	/**
	 * Returns the tham sos before and after the current tham so in the ordered set where giaTri = &#63;.
	 *
	 * @param id the primary key of the current tham so
	 * @param giaTri the gia tri
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tham so
	 * @throws NoSuchThamSoException if a tham so with the primary key could not be found
	 */
	public static ThamSo[] findBygiaTri_PrevAndNext(
			long id, String giaTri, OrderByComparator<ThamSo> orderByComparator)
		throws org.oep.core.exception.NoSuchThamSoException {

		return getPersistence().findBygiaTri_PrevAndNext(
			id, giaTri, orderByComparator);
	}

	/**
	 * Removes all the tham sos where giaTri = &#63; from the database.
	 *
	 * @param giaTri the gia tri
	 */
	public static void removeBygiaTri(String giaTri) {
		getPersistence().removeBygiaTri(giaTri);
	}

	/**
	 * Returns the number of tham sos where giaTri = &#63;.
	 *
	 * @param giaTri the gia tri
	 * @return the number of matching tham sos
	 */
	public static int countBygiaTri(String giaTri) {
		return getPersistence().countBygiaTri(giaTri);
	}

	/**
	 * Returns all the tham sos where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching tham sos
	 */
	public static List<ThamSo> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

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
	public static List<ThamSo> findByGroupId(long groupId, int start, int end) {
		return getPersistence().findByGroupId(groupId, start, end);
	}

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
	public static List<ThamSo> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ThamSo> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

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
	public static List<ThamSo> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ThamSo> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first tham so in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tham so
	 * @throws NoSuchThamSoException if a matching tham so could not be found
	 */
	public static ThamSo findByGroupId_First(
			long groupId, OrderByComparator<ThamSo> orderByComparator)
		throws org.oep.core.exception.NoSuchThamSoException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first tham so in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tham so, or <code>null</code> if a matching tham so could not be found
	 */
	public static ThamSo fetchByGroupId_First(
		long groupId, OrderByComparator<ThamSo> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last tham so in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tham so
	 * @throws NoSuchThamSoException if a matching tham so could not be found
	 */
	public static ThamSo findByGroupId_Last(
			long groupId, OrderByComparator<ThamSo> orderByComparator)
		throws org.oep.core.exception.NoSuchThamSoException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last tham so in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tham so, or <code>null</code> if a matching tham so could not be found
	 */
	public static ThamSo fetchByGroupId_Last(
		long groupId, OrderByComparator<ThamSo> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the tham sos before and after the current tham so in the ordered set where groupId = &#63;.
	 *
	 * @param id the primary key of the current tham so
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tham so
	 * @throws NoSuchThamSoException if a tham so with the primary key could not be found
	 */
	public static ThamSo[] findByGroupId_PrevAndNext(
			long id, long groupId, OrderByComparator<ThamSo> orderByComparator)
		throws org.oep.core.exception.NoSuchThamSoException {

		return getPersistence().findByGroupId_PrevAndNext(
			id, groupId, orderByComparator);
	}

	/**
	 * Removes all the tham sos where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of tham sos where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching tham sos
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Caches the tham so in the entity cache if it is enabled.
	 *
	 * @param thamSo the tham so
	 */
	public static void cacheResult(ThamSo thamSo) {
		getPersistence().cacheResult(thamSo);
	}

	/**
	 * Caches the tham sos in the entity cache if it is enabled.
	 *
	 * @param thamSos the tham sos
	 */
	public static void cacheResult(List<ThamSo> thamSos) {
		getPersistence().cacheResult(thamSos);
	}

	/**
	 * Creates a new tham so with the primary key. Does not add the tham so to the database.
	 *
	 * @param id the primary key for the new tham so
	 * @return the new tham so
	 */
	public static ThamSo create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the tham so with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the tham so
	 * @return the tham so that was removed
	 * @throws NoSuchThamSoException if a tham so with the primary key could not be found
	 */
	public static ThamSo remove(long id)
		throws org.oep.core.exception.NoSuchThamSoException {

		return getPersistence().remove(id);
	}

	public static ThamSo updateImpl(ThamSo thamSo) {
		return getPersistence().updateImpl(thamSo);
	}

	/**
	 * Returns the tham so with the primary key or throws a <code>NoSuchThamSoException</code> if it could not be found.
	 *
	 * @param id the primary key of the tham so
	 * @return the tham so
	 * @throws NoSuchThamSoException if a tham so with the primary key could not be found
	 */
	public static ThamSo findByPrimaryKey(long id)
		throws org.oep.core.exception.NoSuchThamSoException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the tham so with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the tham so
	 * @return the tham so, or <code>null</code> if a tham so with the primary key could not be found
	 */
	public static ThamSo fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the tham sos.
	 *
	 * @return the tham sos
	 */
	public static List<ThamSo> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<ThamSo> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<ThamSo> findAll(
		int start, int end, OrderByComparator<ThamSo> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<ThamSo> findAll(
		int start, int end, OrderByComparator<ThamSo> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the tham sos from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of tham sos.
	 *
	 * @return the number of tham sos
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static ThamSoPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ThamSoPersistence, ThamSoPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ThamSoPersistence.class);

		ServiceTracker<ThamSoPersistence, ThamSoPersistence> serviceTracker =
			new ServiceTracker<ThamSoPersistence, ThamSoPersistence>(
				bundle.getBundleContext(), ThamSoPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}