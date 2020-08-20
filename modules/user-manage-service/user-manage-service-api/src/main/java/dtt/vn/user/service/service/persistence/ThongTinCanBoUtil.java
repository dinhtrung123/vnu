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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import dtt.vn.user.service.model.ThongTinCanBo;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the thong tin can bo service. This utility wraps <code>dtt.vn.user.service.service.persistence.impl.ThongTinCanBoPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nhanvienDTT
 * @see ThongTinCanBoPersistence
 * @generated
 */
@ProviderType
public class ThongTinCanBoUtil {

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
	public static void clearCache(ThongTinCanBo thongTinCanBo) {
		getPersistence().clearCache(thongTinCanBo);
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
	public static Map<Serializable, ThongTinCanBo> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ThongTinCanBo> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ThongTinCanBo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ThongTinCanBo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ThongTinCanBo> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ThongTinCanBo update(ThongTinCanBo thongTinCanBo) {
		return getPersistence().update(thongTinCanBo);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ThongTinCanBo update(
		ThongTinCanBo thongTinCanBo, ServiceContext serviceContext) {

		return getPersistence().update(thongTinCanBo, serviceContext);
	}

	/**
	 * Returns the thong tin can bo where emailAddress = &#63; or throws a <code>NoSuchThongTinCanBoException</code> if it could not be found.
	 *
	 * @param emailAddress the email address
	 * @return the matching thong tin can bo
	 * @throws NoSuchThongTinCanBoException if a matching thong tin can bo could not be found
	 */
	public static ThongTinCanBo findByemailAddress(String emailAddress)
		throws dtt.vn.user.service.exception.NoSuchThongTinCanBoException {

		return getPersistence().findByemailAddress(emailAddress);
	}

	/**
	 * Returns the thong tin can bo where emailAddress = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param emailAddress the email address
	 * @return the matching thong tin can bo, or <code>null</code> if a matching thong tin can bo could not be found
	 */
	public static ThongTinCanBo fetchByemailAddress(String emailAddress) {
		return getPersistence().fetchByemailAddress(emailAddress);
	}

	/**
	 * Returns the thong tin can bo where emailAddress = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param emailAddress the email address
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching thong tin can bo, or <code>null</code> if a matching thong tin can bo could not be found
	 */
	public static ThongTinCanBo fetchByemailAddress(
		String emailAddress, boolean retrieveFromCache) {

		return getPersistence().fetchByemailAddress(
			emailAddress, retrieveFromCache);
	}

	/**
	 * Removes the thong tin can bo where emailAddress = &#63; from the database.
	 *
	 * @param emailAddress the email address
	 * @return the thong tin can bo that was removed
	 */
	public static ThongTinCanBo removeByemailAddress(String emailAddress)
		throws dtt.vn.user.service.exception.NoSuchThongTinCanBoException {

		return getPersistence().removeByemailAddress(emailAddress);
	}

	/**
	 * Returns the number of thong tin can bos where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @return the number of matching thong tin can bos
	 */
	public static int countByemailAddress(String emailAddress) {
		return getPersistence().countByemailAddress(emailAddress);
	}

	/**
	 * Returns the thong tin can bo where userName = &#63; or throws a <code>NoSuchThongTinCanBoException</code> if it could not be found.
	 *
	 * @param userName the user name
	 * @return the matching thong tin can bo
	 * @throws NoSuchThongTinCanBoException if a matching thong tin can bo could not be found
	 */
	public static ThongTinCanBo findByuserName(String userName)
		throws dtt.vn.user.service.exception.NoSuchThongTinCanBoException {

		return getPersistence().findByuserName(userName);
	}

	/**
	 * Returns the thong tin can bo where userName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userName the user name
	 * @return the matching thong tin can bo, or <code>null</code> if a matching thong tin can bo could not be found
	 */
	public static ThongTinCanBo fetchByuserName(String userName) {
		return getPersistence().fetchByuserName(userName);
	}

	/**
	 * Returns the thong tin can bo where userName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userName the user name
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching thong tin can bo, or <code>null</code> if a matching thong tin can bo could not be found
	 */
	public static ThongTinCanBo fetchByuserName(
		String userName, boolean retrieveFromCache) {

		return getPersistence().fetchByuserName(userName, retrieveFromCache);
	}

	/**
	 * Removes the thong tin can bo where userName = &#63; from the database.
	 *
	 * @param userName the user name
	 * @return the thong tin can bo that was removed
	 */
	public static ThongTinCanBo removeByuserName(String userName)
		throws dtt.vn.user.service.exception.NoSuchThongTinCanBoException {

		return getPersistence().removeByuserName(userName);
	}

	/**
	 * Returns the number of thong tin can bos where userName = &#63;.
	 *
	 * @param userName the user name
	 * @return the number of matching thong tin can bos
	 */
	public static int countByuserName(String userName) {
		return getPersistence().countByuserName(userName);
	}

	/**
	 * Returns all the thong tin can bos where nameRole = &#63;.
	 *
	 * @param nameRole the name role
	 * @return the matching thong tin can bos
	 */
	public static List<ThongTinCanBo> findBynameRole(String nameRole) {
		return getPersistence().findBynameRole(nameRole);
	}

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
	public static List<ThongTinCanBo> findBynameRole(
		String nameRole, int start, int end) {

		return getPersistence().findBynameRole(nameRole, start, end);
	}

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
	public static List<ThongTinCanBo> findBynameRole(
		String nameRole, int start, int end,
		OrderByComparator<ThongTinCanBo> orderByComparator) {

		return getPersistence().findBynameRole(
			nameRole, start, end, orderByComparator);
	}

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
	public static List<ThongTinCanBo> findBynameRole(
		String nameRole, int start, int end,
		OrderByComparator<ThongTinCanBo> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findBynameRole(
			nameRole, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first thong tin can bo in the ordered set where nameRole = &#63;.
	 *
	 * @param nameRole the name role
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching thong tin can bo
	 * @throws NoSuchThongTinCanBoException if a matching thong tin can bo could not be found
	 */
	public static ThongTinCanBo findBynameRole_First(
			String nameRole, OrderByComparator<ThongTinCanBo> orderByComparator)
		throws dtt.vn.user.service.exception.NoSuchThongTinCanBoException {

		return getPersistence().findBynameRole_First(
			nameRole, orderByComparator);
	}

	/**
	 * Returns the first thong tin can bo in the ordered set where nameRole = &#63;.
	 *
	 * @param nameRole the name role
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching thong tin can bo, or <code>null</code> if a matching thong tin can bo could not be found
	 */
	public static ThongTinCanBo fetchBynameRole_First(
		String nameRole, OrderByComparator<ThongTinCanBo> orderByComparator) {

		return getPersistence().fetchBynameRole_First(
			nameRole, orderByComparator);
	}

	/**
	 * Returns the last thong tin can bo in the ordered set where nameRole = &#63;.
	 *
	 * @param nameRole the name role
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching thong tin can bo
	 * @throws NoSuchThongTinCanBoException if a matching thong tin can bo could not be found
	 */
	public static ThongTinCanBo findBynameRole_Last(
			String nameRole, OrderByComparator<ThongTinCanBo> orderByComparator)
		throws dtt.vn.user.service.exception.NoSuchThongTinCanBoException {

		return getPersistence().findBynameRole_Last(
			nameRole, orderByComparator);
	}

	/**
	 * Returns the last thong tin can bo in the ordered set where nameRole = &#63;.
	 *
	 * @param nameRole the name role
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching thong tin can bo, or <code>null</code> if a matching thong tin can bo could not be found
	 */
	public static ThongTinCanBo fetchBynameRole_Last(
		String nameRole, OrderByComparator<ThongTinCanBo> orderByComparator) {

		return getPersistence().fetchBynameRole_Last(
			nameRole, orderByComparator);
	}

	/**
	 * Returns the thong tin can bos before and after the current thong tin can bo in the ordered set where nameRole = &#63;.
	 *
	 * @param id the primary key of the current thong tin can bo
	 * @param nameRole the name role
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next thong tin can bo
	 * @throws NoSuchThongTinCanBoException if a thong tin can bo with the primary key could not be found
	 */
	public static ThongTinCanBo[] findBynameRole_PrevAndNext(
			long id, String nameRole,
			OrderByComparator<ThongTinCanBo> orderByComparator)
		throws dtt.vn.user.service.exception.NoSuchThongTinCanBoException {

		return getPersistence().findBynameRole_PrevAndNext(
			id, nameRole, orderByComparator);
	}

	/**
	 * Removes all the thong tin can bos where nameRole = &#63; from the database.
	 *
	 * @param nameRole the name role
	 */
	public static void removeBynameRole(String nameRole) {
		getPersistence().removeBynameRole(nameRole);
	}

	/**
	 * Returns the number of thong tin can bos where nameRole = &#63;.
	 *
	 * @param nameRole the name role
	 * @return the number of matching thong tin can bos
	 */
	public static int countBynameRole(String nameRole) {
		return getPersistence().countBynameRole(nameRole);
	}

	/**
	 * Caches the thong tin can bo in the entity cache if it is enabled.
	 *
	 * @param thongTinCanBo the thong tin can bo
	 */
	public static void cacheResult(ThongTinCanBo thongTinCanBo) {
		getPersistence().cacheResult(thongTinCanBo);
	}

	/**
	 * Caches the thong tin can bos in the entity cache if it is enabled.
	 *
	 * @param thongTinCanBos the thong tin can bos
	 */
	public static void cacheResult(List<ThongTinCanBo> thongTinCanBos) {
		getPersistence().cacheResult(thongTinCanBos);
	}

	/**
	 * Creates a new thong tin can bo with the primary key. Does not add the thong tin can bo to the database.
	 *
	 * @param id the primary key for the new thong tin can bo
	 * @return the new thong tin can bo
	 */
	public static ThongTinCanBo create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the thong tin can bo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the thong tin can bo
	 * @return the thong tin can bo that was removed
	 * @throws NoSuchThongTinCanBoException if a thong tin can bo with the primary key could not be found
	 */
	public static ThongTinCanBo remove(long id)
		throws dtt.vn.user.service.exception.NoSuchThongTinCanBoException {

		return getPersistence().remove(id);
	}

	public static ThongTinCanBo updateImpl(ThongTinCanBo thongTinCanBo) {
		return getPersistence().updateImpl(thongTinCanBo);
	}

	/**
	 * Returns the thong tin can bo with the primary key or throws a <code>NoSuchThongTinCanBoException</code> if it could not be found.
	 *
	 * @param id the primary key of the thong tin can bo
	 * @return the thong tin can bo
	 * @throws NoSuchThongTinCanBoException if a thong tin can bo with the primary key could not be found
	 */
	public static ThongTinCanBo findByPrimaryKey(long id)
		throws dtt.vn.user.service.exception.NoSuchThongTinCanBoException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the thong tin can bo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the thong tin can bo
	 * @return the thong tin can bo, or <code>null</code> if a thong tin can bo with the primary key could not be found
	 */
	public static ThongTinCanBo fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the thong tin can bos.
	 *
	 * @return the thong tin can bos
	 */
	public static List<ThongTinCanBo> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<ThongTinCanBo> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<ThongTinCanBo> findAll(
		int start, int end,
		OrderByComparator<ThongTinCanBo> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<ThongTinCanBo> findAll(
		int start, int end, OrderByComparator<ThongTinCanBo> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the thong tin can bos from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of thong tin can bos.
	 *
	 * @return the number of thong tin can bos
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static ThongTinCanBoPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ThongTinCanBoPersistence, ThongTinCanBoPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ThongTinCanBoPersistence.class);

		ServiceTracker<ThongTinCanBoPersistence, ThongTinCanBoPersistence>
			serviceTracker =
				new ServiceTracker
					<ThongTinCanBoPersistence, ThongTinCanBoPersistence>(
						bundle.getBundleContext(),
						ThongTinCanBoPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}