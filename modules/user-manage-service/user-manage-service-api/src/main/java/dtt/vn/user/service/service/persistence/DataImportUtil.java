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

import dtt.vn.user.service.model.DataImport;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the data import service. This utility wraps <code>dtt.vn.user.service.service.persistence.impl.DataImportPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nhanvienDTT
 * @see DataImportPersistence
 * @generated
 */
@ProviderType
public class DataImportUtil {

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
	public static void clearCache(DataImport dataImport) {
		getPersistence().clearCache(dataImport);
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
	public static Map<Serializable, DataImport> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DataImport> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DataImport> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DataImport> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DataImport> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DataImport update(DataImport dataImport) {
		return getPersistence().update(dataImport);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DataImport update(
		DataImport dataImport, ServiceContext serviceContext) {

		return getPersistence().update(dataImport, serviceContext);
	}

	/**
	 * Returns all the data imports where hasImport = &#63;.
	 *
	 * @param hasImport the has import
	 * @return the matching data imports
	 */
	public static List<DataImport> findByI(String hasImport) {
		return getPersistence().findByI(hasImport);
	}

	/**
	 * Returns a range of all the data imports where hasImport = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataImportModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param hasImport the has import
	 * @param start the lower bound of the range of data imports
	 * @param end the upper bound of the range of data imports (not inclusive)
	 * @return the range of matching data imports
	 */
	public static List<DataImport> findByI(
		String hasImport, int start, int end) {

		return getPersistence().findByI(hasImport, start, end);
	}

	/**
	 * Returns an ordered range of all the data imports where hasImport = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataImportModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param hasImport the has import
	 * @param start the lower bound of the range of data imports
	 * @param end the upper bound of the range of data imports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data imports
	 */
	public static List<DataImport> findByI(
		String hasImport, int start, int end,
		OrderByComparator<DataImport> orderByComparator) {

		return getPersistence().findByI(
			hasImport, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data imports where hasImport = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataImportModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param hasImport the has import
	 * @param start the lower bound of the range of data imports
	 * @param end the upper bound of the range of data imports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching data imports
	 */
	public static List<DataImport> findByI(
		String hasImport, int start, int end,
		OrderByComparator<DataImport> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByI(
			hasImport, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first data import in the ordered set where hasImport = &#63;.
	 *
	 * @param hasImport the has import
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data import
	 * @throws NoSuchDataImportException if a matching data import could not be found
	 */
	public static DataImport findByI_First(
			String hasImport, OrderByComparator<DataImport> orderByComparator)
		throws dtt.vn.user.service.exception.NoSuchDataImportException {

		return getPersistence().findByI_First(hasImport, orderByComparator);
	}

	/**
	 * Returns the first data import in the ordered set where hasImport = &#63;.
	 *
	 * @param hasImport the has import
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data import, or <code>null</code> if a matching data import could not be found
	 */
	public static DataImport fetchByI_First(
		String hasImport, OrderByComparator<DataImport> orderByComparator) {

		return getPersistence().fetchByI_First(hasImport, orderByComparator);
	}

	/**
	 * Returns the last data import in the ordered set where hasImport = &#63;.
	 *
	 * @param hasImport the has import
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data import
	 * @throws NoSuchDataImportException if a matching data import could not be found
	 */
	public static DataImport findByI_Last(
			String hasImport, OrderByComparator<DataImport> orderByComparator)
		throws dtt.vn.user.service.exception.NoSuchDataImportException {

		return getPersistence().findByI_Last(hasImport, orderByComparator);
	}

	/**
	 * Returns the last data import in the ordered set where hasImport = &#63;.
	 *
	 * @param hasImport the has import
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data import, or <code>null</code> if a matching data import could not be found
	 */
	public static DataImport fetchByI_Last(
		String hasImport, OrderByComparator<DataImport> orderByComparator) {

		return getPersistence().fetchByI_Last(hasImport, orderByComparator);
	}

	/**
	 * Returns the data imports before and after the current data import in the ordered set where hasImport = &#63;.
	 *
	 * @param id the primary key of the current data import
	 * @param hasImport the has import
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data import
	 * @throws NoSuchDataImportException if a data import with the primary key could not be found
	 */
	public static DataImport[] findByI_PrevAndNext(
			long id, String hasImport,
			OrderByComparator<DataImport> orderByComparator)
		throws dtt.vn.user.service.exception.NoSuchDataImportException {

		return getPersistence().findByI_PrevAndNext(
			id, hasImport, orderByComparator);
	}

	/**
	 * Removes all the data imports where hasImport = &#63; from the database.
	 *
	 * @param hasImport the has import
	 */
	public static void removeByI(String hasImport) {
		getPersistence().removeByI(hasImport);
	}

	/**
	 * Returns the number of data imports where hasImport = &#63;.
	 *
	 * @param hasImport the has import
	 * @return the number of matching data imports
	 */
	public static int countByI(String hasImport) {
		return getPersistence().countByI(hasImport);
	}

	/**
	 * Returns all the data imports where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @return the matching data imports
	 */
	public static List<DataImport> findByScreenName(String screenName) {
		return getPersistence().findByScreenName(screenName);
	}

	/**
	 * Returns a range of all the data imports where screenName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataImportModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param screenName the screen name
	 * @param start the lower bound of the range of data imports
	 * @param end the upper bound of the range of data imports (not inclusive)
	 * @return the range of matching data imports
	 */
	public static List<DataImport> findByScreenName(
		String screenName, int start, int end) {

		return getPersistence().findByScreenName(screenName, start, end);
	}

	/**
	 * Returns an ordered range of all the data imports where screenName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataImportModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param screenName the screen name
	 * @param start the lower bound of the range of data imports
	 * @param end the upper bound of the range of data imports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data imports
	 */
	public static List<DataImport> findByScreenName(
		String screenName, int start, int end,
		OrderByComparator<DataImport> orderByComparator) {

		return getPersistence().findByScreenName(
			screenName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data imports where screenName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataImportModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param screenName the screen name
	 * @param start the lower bound of the range of data imports
	 * @param end the upper bound of the range of data imports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching data imports
	 */
	public static List<DataImport> findByScreenName(
		String screenName, int start, int end,
		OrderByComparator<DataImport> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByScreenName(
			screenName, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first data import in the ordered set where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data import
	 * @throws NoSuchDataImportException if a matching data import could not be found
	 */
	public static DataImport findByScreenName_First(
			String screenName, OrderByComparator<DataImport> orderByComparator)
		throws dtt.vn.user.service.exception.NoSuchDataImportException {

		return getPersistence().findByScreenName_First(
			screenName, orderByComparator);
	}

	/**
	 * Returns the first data import in the ordered set where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data import, or <code>null</code> if a matching data import could not be found
	 */
	public static DataImport fetchByScreenName_First(
		String screenName, OrderByComparator<DataImport> orderByComparator) {

		return getPersistence().fetchByScreenName_First(
			screenName, orderByComparator);
	}

	/**
	 * Returns the last data import in the ordered set where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data import
	 * @throws NoSuchDataImportException if a matching data import could not be found
	 */
	public static DataImport findByScreenName_Last(
			String screenName, OrderByComparator<DataImport> orderByComparator)
		throws dtt.vn.user.service.exception.NoSuchDataImportException {

		return getPersistence().findByScreenName_Last(
			screenName, orderByComparator);
	}

	/**
	 * Returns the last data import in the ordered set where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data import, or <code>null</code> if a matching data import could not be found
	 */
	public static DataImport fetchByScreenName_Last(
		String screenName, OrderByComparator<DataImport> orderByComparator) {

		return getPersistence().fetchByScreenName_Last(
			screenName, orderByComparator);
	}

	/**
	 * Returns the data imports before and after the current data import in the ordered set where screenName = &#63;.
	 *
	 * @param id the primary key of the current data import
	 * @param screenName the screen name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data import
	 * @throws NoSuchDataImportException if a data import with the primary key could not be found
	 */
	public static DataImport[] findByScreenName_PrevAndNext(
			long id, String screenName,
			OrderByComparator<DataImport> orderByComparator)
		throws dtt.vn.user.service.exception.NoSuchDataImportException {

		return getPersistence().findByScreenName_PrevAndNext(
			id, screenName, orderByComparator);
	}

	/**
	 * Removes all the data imports where screenName = &#63; from the database.
	 *
	 * @param screenName the screen name
	 */
	public static void removeByScreenName(String screenName) {
		getPersistence().removeByScreenName(screenName);
	}

	/**
	 * Returns the number of data imports where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @return the number of matching data imports
	 */
	public static int countByScreenName(String screenName) {
		return getPersistence().countByScreenName(screenName);
	}

	/**
	 * Returns all the data imports where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @return the matching data imports
	 */
	public static List<DataImport> findByLastName(String lastName) {
		return getPersistence().findByLastName(lastName);
	}

	/**
	 * Returns a range of all the data imports where lastName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataImportModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lastName the last name
	 * @param start the lower bound of the range of data imports
	 * @param end the upper bound of the range of data imports (not inclusive)
	 * @return the range of matching data imports
	 */
	public static List<DataImport> findByLastName(
		String lastName, int start, int end) {

		return getPersistence().findByLastName(lastName, start, end);
	}

	/**
	 * Returns an ordered range of all the data imports where lastName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataImportModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lastName the last name
	 * @param start the lower bound of the range of data imports
	 * @param end the upper bound of the range of data imports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data imports
	 */
	public static List<DataImport> findByLastName(
		String lastName, int start, int end,
		OrderByComparator<DataImport> orderByComparator) {

		return getPersistence().findByLastName(
			lastName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data imports where lastName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataImportModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lastName the last name
	 * @param start the lower bound of the range of data imports
	 * @param end the upper bound of the range of data imports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching data imports
	 */
	public static List<DataImport> findByLastName(
		String lastName, int start, int end,
		OrderByComparator<DataImport> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByLastName(
			lastName, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first data import in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data import
	 * @throws NoSuchDataImportException if a matching data import could not be found
	 */
	public static DataImport findByLastName_First(
			String lastName, OrderByComparator<DataImport> orderByComparator)
		throws dtt.vn.user.service.exception.NoSuchDataImportException {

		return getPersistence().findByLastName_First(
			lastName, orderByComparator);
	}

	/**
	 * Returns the first data import in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data import, or <code>null</code> if a matching data import could not be found
	 */
	public static DataImport fetchByLastName_First(
		String lastName, OrderByComparator<DataImport> orderByComparator) {

		return getPersistence().fetchByLastName_First(
			lastName, orderByComparator);
	}

	/**
	 * Returns the last data import in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data import
	 * @throws NoSuchDataImportException if a matching data import could not be found
	 */
	public static DataImport findByLastName_Last(
			String lastName, OrderByComparator<DataImport> orderByComparator)
		throws dtt.vn.user.service.exception.NoSuchDataImportException {

		return getPersistence().findByLastName_Last(
			lastName, orderByComparator);
	}

	/**
	 * Returns the last data import in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data import, or <code>null</code> if a matching data import could not be found
	 */
	public static DataImport fetchByLastName_Last(
		String lastName, OrderByComparator<DataImport> orderByComparator) {

		return getPersistence().fetchByLastName_Last(
			lastName, orderByComparator);
	}

	/**
	 * Returns the data imports before and after the current data import in the ordered set where lastName = &#63;.
	 *
	 * @param id the primary key of the current data import
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data import
	 * @throws NoSuchDataImportException if a data import with the primary key could not be found
	 */
	public static DataImport[] findByLastName_PrevAndNext(
			long id, String lastName,
			OrderByComparator<DataImport> orderByComparator)
		throws dtt.vn.user.service.exception.NoSuchDataImportException {

		return getPersistence().findByLastName_PrevAndNext(
			id, lastName, orderByComparator);
	}

	/**
	 * Removes all the data imports where lastName = &#63; from the database.
	 *
	 * @param lastName the last name
	 */
	public static void removeByLastName(String lastName) {
		getPersistence().removeByLastName(lastName);
	}

	/**
	 * Returns the number of data imports where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @return the number of matching data imports
	 */
	public static int countByLastName(String lastName) {
		return getPersistence().countByLastName(lastName);
	}

	/**
	 * Returns all the data imports where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @return the matching data imports
	 */
	public static List<DataImport> findByEmailAddress(String emailAddress) {
		return getPersistence().findByEmailAddress(emailAddress);
	}

	/**
	 * Returns a range of all the data imports where emailAddress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataImportModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param emailAddress the email address
	 * @param start the lower bound of the range of data imports
	 * @param end the upper bound of the range of data imports (not inclusive)
	 * @return the range of matching data imports
	 */
	public static List<DataImport> findByEmailAddress(
		String emailAddress, int start, int end) {

		return getPersistence().findByEmailAddress(emailAddress, start, end);
	}

	/**
	 * Returns an ordered range of all the data imports where emailAddress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataImportModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param emailAddress the email address
	 * @param start the lower bound of the range of data imports
	 * @param end the upper bound of the range of data imports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data imports
	 */
	public static List<DataImport> findByEmailAddress(
		String emailAddress, int start, int end,
		OrderByComparator<DataImport> orderByComparator) {

		return getPersistence().findByEmailAddress(
			emailAddress, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data imports where emailAddress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataImportModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param emailAddress the email address
	 * @param start the lower bound of the range of data imports
	 * @param end the upper bound of the range of data imports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching data imports
	 */
	public static List<DataImport> findByEmailAddress(
		String emailAddress, int start, int end,
		OrderByComparator<DataImport> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByEmailAddress(
			emailAddress, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first data import in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data import
	 * @throws NoSuchDataImportException if a matching data import could not be found
	 */
	public static DataImport findByEmailAddress_First(
			String emailAddress,
			OrderByComparator<DataImport> orderByComparator)
		throws dtt.vn.user.service.exception.NoSuchDataImportException {

		return getPersistence().findByEmailAddress_First(
			emailAddress, orderByComparator);
	}

	/**
	 * Returns the first data import in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data import, or <code>null</code> if a matching data import could not be found
	 */
	public static DataImport fetchByEmailAddress_First(
		String emailAddress, OrderByComparator<DataImport> orderByComparator) {

		return getPersistence().fetchByEmailAddress_First(
			emailAddress, orderByComparator);
	}

	/**
	 * Returns the last data import in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data import
	 * @throws NoSuchDataImportException if a matching data import could not be found
	 */
	public static DataImport findByEmailAddress_Last(
			String emailAddress,
			OrderByComparator<DataImport> orderByComparator)
		throws dtt.vn.user.service.exception.NoSuchDataImportException {

		return getPersistence().findByEmailAddress_Last(
			emailAddress, orderByComparator);
	}

	/**
	 * Returns the last data import in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data import, or <code>null</code> if a matching data import could not be found
	 */
	public static DataImport fetchByEmailAddress_Last(
		String emailAddress, OrderByComparator<DataImport> orderByComparator) {

		return getPersistence().fetchByEmailAddress_Last(
			emailAddress, orderByComparator);
	}

	/**
	 * Returns the data imports before and after the current data import in the ordered set where emailAddress = &#63;.
	 *
	 * @param id the primary key of the current data import
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data import
	 * @throws NoSuchDataImportException if a data import with the primary key could not be found
	 */
	public static DataImport[] findByEmailAddress_PrevAndNext(
			long id, String emailAddress,
			OrderByComparator<DataImport> orderByComparator)
		throws dtt.vn.user.service.exception.NoSuchDataImportException {

		return getPersistence().findByEmailAddress_PrevAndNext(
			id, emailAddress, orderByComparator);
	}

	/**
	 * Removes all the data imports where emailAddress = &#63; from the database.
	 *
	 * @param emailAddress the email address
	 */
	public static void removeByEmailAddress(String emailAddress) {
		getPersistence().removeByEmailAddress(emailAddress);
	}

	/**
	 * Returns the number of data imports where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @return the number of matching data imports
	 */
	public static int countByEmailAddress(String emailAddress) {
		return getPersistence().countByEmailAddress(emailAddress);
	}

	/**
	 * Returns all the data imports where phone = &#63;.
	 *
	 * @param phone the phone
	 * @return the matching data imports
	 */
	public static List<DataImport> findByPhone(String phone) {
		return getPersistence().findByPhone(phone);
	}

	/**
	 * Returns a range of all the data imports where phone = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataImportModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param phone the phone
	 * @param start the lower bound of the range of data imports
	 * @param end the upper bound of the range of data imports (not inclusive)
	 * @return the range of matching data imports
	 */
	public static List<DataImport> findByPhone(
		String phone, int start, int end) {

		return getPersistence().findByPhone(phone, start, end);
	}

	/**
	 * Returns an ordered range of all the data imports where phone = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataImportModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param phone the phone
	 * @param start the lower bound of the range of data imports
	 * @param end the upper bound of the range of data imports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data imports
	 */
	public static List<DataImport> findByPhone(
		String phone, int start, int end,
		OrderByComparator<DataImport> orderByComparator) {

		return getPersistence().findByPhone(
			phone, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data imports where phone = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataImportModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param phone the phone
	 * @param start the lower bound of the range of data imports
	 * @param end the upper bound of the range of data imports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching data imports
	 */
	public static List<DataImport> findByPhone(
		String phone, int start, int end,
		OrderByComparator<DataImport> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByPhone(
			phone, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first data import in the ordered set where phone = &#63;.
	 *
	 * @param phone the phone
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data import
	 * @throws NoSuchDataImportException if a matching data import could not be found
	 */
	public static DataImport findByPhone_First(
			String phone, OrderByComparator<DataImport> orderByComparator)
		throws dtt.vn.user.service.exception.NoSuchDataImportException {

		return getPersistence().findByPhone_First(phone, orderByComparator);
	}

	/**
	 * Returns the first data import in the ordered set where phone = &#63;.
	 *
	 * @param phone the phone
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data import, or <code>null</code> if a matching data import could not be found
	 */
	public static DataImport fetchByPhone_First(
		String phone, OrderByComparator<DataImport> orderByComparator) {

		return getPersistence().fetchByPhone_First(phone, orderByComparator);
	}

	/**
	 * Returns the last data import in the ordered set where phone = &#63;.
	 *
	 * @param phone the phone
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data import
	 * @throws NoSuchDataImportException if a matching data import could not be found
	 */
	public static DataImport findByPhone_Last(
			String phone, OrderByComparator<DataImport> orderByComparator)
		throws dtt.vn.user.service.exception.NoSuchDataImportException {

		return getPersistence().findByPhone_Last(phone, orderByComparator);
	}

	/**
	 * Returns the last data import in the ordered set where phone = &#63;.
	 *
	 * @param phone the phone
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data import, or <code>null</code> if a matching data import could not be found
	 */
	public static DataImport fetchByPhone_Last(
		String phone, OrderByComparator<DataImport> orderByComparator) {

		return getPersistence().fetchByPhone_Last(phone, orderByComparator);
	}

	/**
	 * Returns the data imports before and after the current data import in the ordered set where phone = &#63;.
	 *
	 * @param id the primary key of the current data import
	 * @param phone the phone
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data import
	 * @throws NoSuchDataImportException if a data import with the primary key could not be found
	 */
	public static DataImport[] findByPhone_PrevAndNext(
			long id, String phone,
			OrderByComparator<DataImport> orderByComparator)
		throws dtt.vn.user.service.exception.NoSuchDataImportException {

		return getPersistence().findByPhone_PrevAndNext(
			id, phone, orderByComparator);
	}

	/**
	 * Removes all the data imports where phone = &#63; from the database.
	 *
	 * @param phone the phone
	 */
	public static void removeByPhone(String phone) {
		getPersistence().removeByPhone(phone);
	}

	/**
	 * Returns the number of data imports where phone = &#63;.
	 *
	 * @param phone the phone
	 * @return the number of matching data imports
	 */
	public static int countByPhone(String phone) {
		return getPersistence().countByPhone(phone);
	}

	/**
	 * Caches the data import in the entity cache if it is enabled.
	 *
	 * @param dataImport the data import
	 */
	public static void cacheResult(DataImport dataImport) {
		getPersistence().cacheResult(dataImport);
	}

	/**
	 * Caches the data imports in the entity cache if it is enabled.
	 *
	 * @param dataImports the data imports
	 */
	public static void cacheResult(List<DataImport> dataImports) {
		getPersistence().cacheResult(dataImports);
	}

	/**
	 * Creates a new data import with the primary key. Does not add the data import to the database.
	 *
	 * @param id the primary key for the new data import
	 * @return the new data import
	 */
	public static DataImport create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the data import with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the data import
	 * @return the data import that was removed
	 * @throws NoSuchDataImportException if a data import with the primary key could not be found
	 */
	public static DataImport remove(long id)
		throws dtt.vn.user.service.exception.NoSuchDataImportException {

		return getPersistence().remove(id);
	}

	public static DataImport updateImpl(DataImport dataImport) {
		return getPersistence().updateImpl(dataImport);
	}

	/**
	 * Returns the data import with the primary key or throws a <code>NoSuchDataImportException</code> if it could not be found.
	 *
	 * @param id the primary key of the data import
	 * @return the data import
	 * @throws NoSuchDataImportException if a data import with the primary key could not be found
	 */
	public static DataImport findByPrimaryKey(long id)
		throws dtt.vn.user.service.exception.NoSuchDataImportException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the data import with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the data import
	 * @return the data import, or <code>null</code> if a data import with the primary key could not be found
	 */
	public static DataImport fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the data imports.
	 *
	 * @return the data imports
	 */
	public static List<DataImport> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the data imports.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataImportModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of data imports
	 * @param end the upper bound of the range of data imports (not inclusive)
	 * @return the range of data imports
	 */
	public static List<DataImport> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the data imports.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataImportModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of data imports
	 * @param end the upper bound of the range of data imports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of data imports
	 */
	public static List<DataImport> findAll(
		int start, int end, OrderByComparator<DataImport> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data imports.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataImportModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of data imports
	 * @param end the upper bound of the range of data imports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of data imports
	 */
	public static List<DataImport> findAll(
		int start, int end, OrderByComparator<DataImport> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the data imports from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of data imports.
	 *
	 * @return the number of data imports
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static DataImportPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<DataImportPersistence, DataImportPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(DataImportPersistence.class);

		ServiceTracker<DataImportPersistence, DataImportPersistence>
			serviceTracker =
				new ServiceTracker
					<DataImportPersistence, DataImportPersistence>(
						bundle.getBundleContext(), DataImportPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}