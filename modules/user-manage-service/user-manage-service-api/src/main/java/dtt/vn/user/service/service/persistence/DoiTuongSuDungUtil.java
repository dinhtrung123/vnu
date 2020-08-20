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

import dtt.vn.user.service.model.DoiTuongSuDung;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the doi tuong su dung service. This utility wraps <code>dtt.vn.user.service.service.persistence.impl.DoiTuongSuDungPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nhanvienDTT
 * @see DoiTuongSuDungPersistence
 * @generated
 */
@ProviderType
public class DoiTuongSuDungUtil {

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
	public static void clearCache(DoiTuongSuDung doiTuongSuDung) {
		getPersistence().clearCache(doiTuongSuDung);
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
	public static Map<Serializable, DoiTuongSuDung> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DoiTuongSuDung> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DoiTuongSuDung> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DoiTuongSuDung> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DoiTuongSuDung> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DoiTuongSuDung update(DoiTuongSuDung doiTuongSuDung) {
		return getPersistence().update(doiTuongSuDung);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DoiTuongSuDung update(
		DoiTuongSuDung doiTuongSuDung, ServiceContext serviceContext) {

		return getPersistence().update(doiTuongSuDung, serviceContext);
	}

	/**
	 * Returns the doi tuong su dung where ma = &#63; or throws a <code>NoSuchDoiTuongSuDungException</code> if it could not be found.
	 *
	 * @param ma the ma
	 * @return the matching doi tuong su dung
	 * @throws NoSuchDoiTuongSuDungException if a matching doi tuong su dung could not be found
	 */
	public static DoiTuongSuDung findByMa(String ma)
		throws dtt.vn.user.service.exception.NoSuchDoiTuongSuDungException {

		return getPersistence().findByMa(ma);
	}

	/**
	 * Returns the doi tuong su dung where ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ma the ma
	 * @return the matching doi tuong su dung, or <code>null</code> if a matching doi tuong su dung could not be found
	 */
	public static DoiTuongSuDung fetchByMa(String ma) {
		return getPersistence().fetchByMa(ma);
	}

	/**
	 * Returns the doi tuong su dung where ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ma the ma
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching doi tuong su dung, or <code>null</code> if a matching doi tuong su dung could not be found
	 */
	public static DoiTuongSuDung fetchByMa(
		String ma, boolean retrieveFromCache) {

		return getPersistence().fetchByMa(ma, retrieveFromCache);
	}

	/**
	 * Removes the doi tuong su dung where ma = &#63; from the database.
	 *
	 * @param ma the ma
	 * @return the doi tuong su dung that was removed
	 */
	public static DoiTuongSuDung removeByMa(String ma)
		throws dtt.vn.user.service.exception.NoSuchDoiTuongSuDungException {

		return getPersistence().removeByMa(ma);
	}

	/**
	 * Returns the number of doi tuong su dungs where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the number of matching doi tuong su dungs
	 */
	public static int countByMa(String ma) {
		return getPersistence().countByMa(ma);
	}

	/**
	 * Caches the doi tuong su dung in the entity cache if it is enabled.
	 *
	 * @param doiTuongSuDung the doi tuong su dung
	 */
	public static void cacheResult(DoiTuongSuDung doiTuongSuDung) {
		getPersistence().cacheResult(doiTuongSuDung);
	}

	/**
	 * Caches the doi tuong su dungs in the entity cache if it is enabled.
	 *
	 * @param doiTuongSuDungs the doi tuong su dungs
	 */
	public static void cacheResult(List<DoiTuongSuDung> doiTuongSuDungs) {
		getPersistence().cacheResult(doiTuongSuDungs);
	}

	/**
	 * Creates a new doi tuong su dung with the primary key. Does not add the doi tuong su dung to the database.
	 *
	 * @param id the primary key for the new doi tuong su dung
	 * @return the new doi tuong su dung
	 */
	public static DoiTuongSuDung create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the doi tuong su dung with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the doi tuong su dung
	 * @return the doi tuong su dung that was removed
	 * @throws NoSuchDoiTuongSuDungException if a doi tuong su dung with the primary key could not be found
	 */
	public static DoiTuongSuDung remove(long id)
		throws dtt.vn.user.service.exception.NoSuchDoiTuongSuDungException {

		return getPersistence().remove(id);
	}

	public static DoiTuongSuDung updateImpl(DoiTuongSuDung doiTuongSuDung) {
		return getPersistence().updateImpl(doiTuongSuDung);
	}

	/**
	 * Returns the doi tuong su dung with the primary key or throws a <code>NoSuchDoiTuongSuDungException</code> if it could not be found.
	 *
	 * @param id the primary key of the doi tuong su dung
	 * @return the doi tuong su dung
	 * @throws NoSuchDoiTuongSuDungException if a doi tuong su dung with the primary key could not be found
	 */
	public static DoiTuongSuDung findByPrimaryKey(long id)
		throws dtt.vn.user.service.exception.NoSuchDoiTuongSuDungException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the doi tuong su dung with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the doi tuong su dung
	 * @return the doi tuong su dung, or <code>null</code> if a doi tuong su dung with the primary key could not be found
	 */
	public static DoiTuongSuDung fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the doi tuong su dungs.
	 *
	 * @return the doi tuong su dungs
	 */
	public static List<DoiTuongSuDung> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<DoiTuongSuDung> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<DoiTuongSuDung> findAll(
		int start, int end,
		OrderByComparator<DoiTuongSuDung> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<DoiTuongSuDung> findAll(
		int start, int end, OrderByComparator<DoiTuongSuDung> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the doi tuong su dungs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of doi tuong su dungs.
	 *
	 * @return the number of doi tuong su dungs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static DoiTuongSuDungPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<DoiTuongSuDungPersistence, DoiTuongSuDungPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			DoiTuongSuDungPersistence.class);

		ServiceTracker<DoiTuongSuDungPersistence, DoiTuongSuDungPersistence>
			serviceTracker =
				new ServiceTracker
					<DoiTuongSuDungPersistence, DoiTuongSuDungPersistence>(
						bundle.getBundleContext(),
						DoiTuongSuDungPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}