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

import dtt.vn.vnpost.model.WorkItem;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the work item service. This utility wraps <code>dtt.vn.vnpost.service.persistence.impl.WorkItemPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WorkItemPersistence
 * @generated
 */
@ProviderType
public class WorkItemUtil {

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
	public static void clearCache(WorkItem workItem) {
		getPersistence().clearCache(workItem);
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
	public static Map<Serializable, WorkItem> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<WorkItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<WorkItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<WorkItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<WorkItem> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static WorkItem update(WorkItem workItem) {
		return getPersistence().update(workItem);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static WorkItem update(
		WorkItem workItem, ServiceContext serviceContext) {

		return getPersistence().update(workItem, serviceContext);
	}

	/**
	 * Returns all the work items where title LIKE &#63;.
	 *
	 * @param title the title
	 * @return the matching work items
	 */
	public static List<WorkItem> findByTitle(String title) {
		return getPersistence().findByTitle(title);
	}

	/**
	 * Returns a range of all the work items where title LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>WorkItemModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of work items
	 * @param end the upper bound of the range of work items (not inclusive)
	 * @return the range of matching work items
	 */
	public static List<WorkItem> findByTitle(String title, int start, int end) {
		return getPersistence().findByTitle(title, start, end);
	}

	/**
	 * Returns an ordered range of all the work items where title LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>WorkItemModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of work items
	 * @param end the upper bound of the range of work items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work items
	 */
	public static List<WorkItem> findByTitle(
		String title, int start, int end,
		OrderByComparator<WorkItem> orderByComparator) {

		return getPersistence().findByTitle(
			title, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the work items where title LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>WorkItemModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of work items
	 * @param end the upper bound of the range of work items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching work items
	 */
	public static List<WorkItem> findByTitle(
		String title, int start, int end,
		OrderByComparator<WorkItem> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByTitle(
			title, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first work item in the ordered set where title LIKE &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work item
	 * @throws NoSuchWorkItemException if a matching work item could not be found
	 */
	public static WorkItem findByTitle_First(
			String title, OrderByComparator<WorkItem> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchWorkItemException {

		return getPersistence().findByTitle_First(title, orderByComparator);
	}

	/**
	 * Returns the first work item in the ordered set where title LIKE &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work item, or <code>null</code> if a matching work item could not be found
	 */
	public static WorkItem fetchByTitle_First(
		String title, OrderByComparator<WorkItem> orderByComparator) {

		return getPersistence().fetchByTitle_First(title, orderByComparator);
	}

	/**
	 * Returns the last work item in the ordered set where title LIKE &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work item
	 * @throws NoSuchWorkItemException if a matching work item could not be found
	 */
	public static WorkItem findByTitle_Last(
			String title, OrderByComparator<WorkItem> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchWorkItemException {

		return getPersistence().findByTitle_Last(title, orderByComparator);
	}

	/**
	 * Returns the last work item in the ordered set where title LIKE &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work item, or <code>null</code> if a matching work item could not be found
	 */
	public static WorkItem fetchByTitle_Last(
		String title, OrderByComparator<WorkItem> orderByComparator) {

		return getPersistence().fetchByTitle_Last(title, orderByComparator);
	}

	/**
	 * Returns the work items before and after the current work item in the ordered set where title LIKE &#63;.
	 *
	 * @param workItemId the primary key of the current work item
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work item
	 * @throws NoSuchWorkItemException if a work item with the primary key could not be found
	 */
	public static WorkItem[] findByTitle_PrevAndNext(
			long workItemId, String title,
			OrderByComparator<WorkItem> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchWorkItemException {

		return getPersistence().findByTitle_PrevAndNext(
			workItemId, title, orderByComparator);
	}

	/**
	 * Removes all the work items where title LIKE &#63; from the database.
	 *
	 * @param title the title
	 */
	public static void removeByTitle(String title) {
		getPersistence().removeByTitle(title);
	}

	/**
	 * Returns the number of work items where title LIKE &#63;.
	 *
	 * @param title the title
	 * @return the number of matching work items
	 */
	public static int countByTitle(String title) {
		return getPersistence().countByTitle(title);
	}

	/**
	 * Returns all the work items where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching work items
	 */
	public static List<WorkItem> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

	/**
	 * Returns a range of all the work items where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>WorkItemModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of work items
	 * @param end the upper bound of the range of work items (not inclusive)
	 * @return the range of matching work items
	 */
	public static List<WorkItem> findByUserId(long userId, int start, int end) {
		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the work items where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>WorkItemModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of work items
	 * @param end the upper bound of the range of work items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work items
	 */
	public static List<WorkItem> findByUserId(
		long userId, int start, int end,
		OrderByComparator<WorkItem> orderByComparator) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the work items where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>WorkItemModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of work items
	 * @param end the upper bound of the range of work items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching work items
	 */
	public static List<WorkItem> findByUserId(
		long userId, int start, int end,
		OrderByComparator<WorkItem> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first work item in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work item
	 * @throws NoSuchWorkItemException if a matching work item could not be found
	 */
	public static WorkItem findByUserId_First(
			long userId, OrderByComparator<WorkItem> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchWorkItemException {

		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first work item in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work item, or <code>null</code> if a matching work item could not be found
	 */
	public static WorkItem fetchByUserId_First(
		long userId, OrderByComparator<WorkItem> orderByComparator) {

		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last work item in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work item
	 * @throws NoSuchWorkItemException if a matching work item could not be found
	 */
	public static WorkItem findByUserId_Last(
			long userId, OrderByComparator<WorkItem> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchWorkItemException {

		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last work item in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work item, or <code>null</code> if a matching work item could not be found
	 */
	public static WorkItem fetchByUserId_Last(
		long userId, OrderByComparator<WorkItem> orderByComparator) {

		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the work items before and after the current work item in the ordered set where userId = &#63;.
	 *
	 * @param workItemId the primary key of the current work item
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work item
	 * @throws NoSuchWorkItemException if a work item with the primary key could not be found
	 */
	public static WorkItem[] findByUserId_PrevAndNext(
			long workItemId, long userId,
			OrderByComparator<WorkItem> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchWorkItemException {

		return getPersistence().findByUserId_PrevAndNext(
			workItemId, userId, orderByComparator);
	}

	/**
	 * Removes all the work items where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	 * Returns the number of work items where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching work items
	 */
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	 * Returns all the work items where accountId = &#63;.
	 *
	 * @param accountId the account ID
	 * @return the matching work items
	 */
	public static List<WorkItem> findByQuaTrinhXuLy(long accountId) {
		return getPersistence().findByQuaTrinhXuLy(accountId);
	}

	/**
	 * Returns a range of all the work items where accountId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>WorkItemModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param accountId the account ID
	 * @param start the lower bound of the range of work items
	 * @param end the upper bound of the range of work items (not inclusive)
	 * @return the range of matching work items
	 */
	public static List<WorkItem> findByQuaTrinhXuLy(
		long accountId, int start, int end) {

		return getPersistence().findByQuaTrinhXuLy(accountId, start, end);
	}

	/**
	 * Returns an ordered range of all the work items where accountId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>WorkItemModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param accountId the account ID
	 * @param start the lower bound of the range of work items
	 * @param end the upper bound of the range of work items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work items
	 */
	public static List<WorkItem> findByQuaTrinhXuLy(
		long accountId, int start, int end,
		OrderByComparator<WorkItem> orderByComparator) {

		return getPersistence().findByQuaTrinhXuLy(
			accountId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the work items where accountId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>WorkItemModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param accountId the account ID
	 * @param start the lower bound of the range of work items
	 * @param end the upper bound of the range of work items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching work items
	 */
	public static List<WorkItem> findByQuaTrinhXuLy(
		long accountId, int start, int end,
		OrderByComparator<WorkItem> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByQuaTrinhXuLy(
			accountId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first work item in the ordered set where accountId = &#63;.
	 *
	 * @param accountId the account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work item
	 * @throws NoSuchWorkItemException if a matching work item could not be found
	 */
	public static WorkItem findByQuaTrinhXuLy_First(
			long accountId, OrderByComparator<WorkItem> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchWorkItemException {

		return getPersistence().findByQuaTrinhXuLy_First(
			accountId, orderByComparator);
	}

	/**
	 * Returns the first work item in the ordered set where accountId = &#63;.
	 *
	 * @param accountId the account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work item, or <code>null</code> if a matching work item could not be found
	 */
	public static WorkItem fetchByQuaTrinhXuLy_First(
		long accountId, OrderByComparator<WorkItem> orderByComparator) {

		return getPersistence().fetchByQuaTrinhXuLy_First(
			accountId, orderByComparator);
	}

	/**
	 * Returns the last work item in the ordered set where accountId = &#63;.
	 *
	 * @param accountId the account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work item
	 * @throws NoSuchWorkItemException if a matching work item could not be found
	 */
	public static WorkItem findByQuaTrinhXuLy_Last(
			long accountId, OrderByComparator<WorkItem> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchWorkItemException {

		return getPersistence().findByQuaTrinhXuLy_Last(
			accountId, orderByComparator);
	}

	/**
	 * Returns the last work item in the ordered set where accountId = &#63;.
	 *
	 * @param accountId the account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work item, or <code>null</code> if a matching work item could not be found
	 */
	public static WorkItem fetchByQuaTrinhXuLy_Last(
		long accountId, OrderByComparator<WorkItem> orderByComparator) {

		return getPersistence().fetchByQuaTrinhXuLy_Last(
			accountId, orderByComparator);
	}

	/**
	 * Returns the work items before and after the current work item in the ordered set where accountId = &#63;.
	 *
	 * @param workItemId the primary key of the current work item
	 * @param accountId the account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work item
	 * @throws NoSuchWorkItemException if a work item with the primary key could not be found
	 */
	public static WorkItem[] findByQuaTrinhXuLy_PrevAndNext(
			long workItemId, long accountId,
			OrderByComparator<WorkItem> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchWorkItemException {

		return getPersistence().findByQuaTrinhXuLy_PrevAndNext(
			workItemId, accountId, orderByComparator);
	}

	/**
	 * Removes all the work items where accountId = &#63; from the database.
	 *
	 * @param accountId the account ID
	 */
	public static void removeByQuaTrinhXuLy(long accountId) {
		getPersistence().removeByQuaTrinhXuLy(accountId);
	}

	/**
	 * Returns the number of work items where accountId = &#63;.
	 *
	 * @param accountId the account ID
	 * @return the number of matching work items
	 */
	public static int countByQuaTrinhXuLy(long accountId) {
		return getPersistence().countByQuaTrinhXuLy(accountId);
	}

	/**
	 * Caches the work item in the entity cache if it is enabled.
	 *
	 * @param workItem the work item
	 */
	public static void cacheResult(WorkItem workItem) {
		getPersistence().cacheResult(workItem);
	}

	/**
	 * Caches the work items in the entity cache if it is enabled.
	 *
	 * @param workItems the work items
	 */
	public static void cacheResult(List<WorkItem> workItems) {
		getPersistence().cacheResult(workItems);
	}

	/**
	 * Creates a new work item with the primary key. Does not add the work item to the database.
	 *
	 * @param workItemId the primary key for the new work item
	 * @return the new work item
	 */
	public static WorkItem create(long workItemId) {
		return getPersistence().create(workItemId);
	}

	/**
	 * Removes the work item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workItemId the primary key of the work item
	 * @return the work item that was removed
	 * @throws NoSuchWorkItemException if a work item with the primary key could not be found
	 */
	public static WorkItem remove(long workItemId)
		throws dtt.vn.vnpost.exception.NoSuchWorkItemException {

		return getPersistence().remove(workItemId);
	}

	public static WorkItem updateImpl(WorkItem workItem) {
		return getPersistence().updateImpl(workItem);
	}

	/**
	 * Returns the work item with the primary key or throws a <code>NoSuchWorkItemException</code> if it could not be found.
	 *
	 * @param workItemId the primary key of the work item
	 * @return the work item
	 * @throws NoSuchWorkItemException if a work item with the primary key could not be found
	 */
	public static WorkItem findByPrimaryKey(long workItemId)
		throws dtt.vn.vnpost.exception.NoSuchWorkItemException {

		return getPersistence().findByPrimaryKey(workItemId);
	}

	/**
	 * Returns the work item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param workItemId the primary key of the work item
	 * @return the work item, or <code>null</code> if a work item with the primary key could not be found
	 */
	public static WorkItem fetchByPrimaryKey(long workItemId) {
		return getPersistence().fetchByPrimaryKey(workItemId);
	}

	/**
	 * Returns all the work items.
	 *
	 * @return the work items
	 */
	public static List<WorkItem> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the work items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>WorkItemModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of work items
	 * @param end the upper bound of the range of work items (not inclusive)
	 * @return the range of work items
	 */
	public static List<WorkItem> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the work items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>WorkItemModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of work items
	 * @param end the upper bound of the range of work items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of work items
	 */
	public static List<WorkItem> findAll(
		int start, int end, OrderByComparator<WorkItem> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the work items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>WorkItemModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of work items
	 * @param end the upper bound of the range of work items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of work items
	 */
	public static List<WorkItem> findAll(
		int start, int end, OrderByComparator<WorkItem> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the work items from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of work items.
	 *
	 * @return the number of work items
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static WorkItemPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<WorkItemPersistence, WorkItemPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(WorkItemPersistence.class);

		ServiceTracker<WorkItemPersistence, WorkItemPersistence>
			serviceTracker =
				new ServiceTracker<WorkItemPersistence, WorkItemPersistence>(
					bundle.getBundleContext(), WorkItemPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}