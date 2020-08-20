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

import dtt.vn.vnpost.exception.NoSuchWorkItemException;
import dtt.vn.vnpost.model.WorkItem;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the work item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WorkItemUtil
 * @generated
 */
@ProviderType
public interface WorkItemPersistence extends BasePersistence<WorkItem> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WorkItemUtil} to access the work item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, WorkItem> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the work items where title LIKE &#63;.
	 *
	 * @param title the title
	 * @return the matching work items
	 */
	public java.util.List<WorkItem> findByTitle(String title);

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
	public java.util.List<WorkItem> findByTitle(
		String title, int start, int end);

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
	public java.util.List<WorkItem> findByTitle(
		String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkItem>
			orderByComparator);

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
	public java.util.List<WorkItem> findByTitle(
		String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkItem>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first work item in the ordered set where title LIKE &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work item
	 * @throws NoSuchWorkItemException if a matching work item could not be found
	 */
	public WorkItem findByTitle_First(
			String title,
			com.liferay.portal.kernel.util.OrderByComparator<WorkItem>
				orderByComparator)
		throws NoSuchWorkItemException;

	/**
	 * Returns the first work item in the ordered set where title LIKE &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work item, or <code>null</code> if a matching work item could not be found
	 */
	public WorkItem fetchByTitle_First(
		String title,
		com.liferay.portal.kernel.util.OrderByComparator<WorkItem>
			orderByComparator);

	/**
	 * Returns the last work item in the ordered set where title LIKE &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work item
	 * @throws NoSuchWorkItemException if a matching work item could not be found
	 */
	public WorkItem findByTitle_Last(
			String title,
			com.liferay.portal.kernel.util.OrderByComparator<WorkItem>
				orderByComparator)
		throws NoSuchWorkItemException;

	/**
	 * Returns the last work item in the ordered set where title LIKE &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work item, or <code>null</code> if a matching work item could not be found
	 */
	public WorkItem fetchByTitle_Last(
		String title,
		com.liferay.portal.kernel.util.OrderByComparator<WorkItem>
			orderByComparator);

	/**
	 * Returns the work items before and after the current work item in the ordered set where title LIKE &#63;.
	 *
	 * @param workItemId the primary key of the current work item
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work item
	 * @throws NoSuchWorkItemException if a work item with the primary key could not be found
	 */
	public WorkItem[] findByTitle_PrevAndNext(
			long workItemId, String title,
			com.liferay.portal.kernel.util.OrderByComparator<WorkItem>
				orderByComparator)
		throws NoSuchWorkItemException;

	/**
	 * Removes all the work items where title LIKE &#63; from the database.
	 *
	 * @param title the title
	 */
	public void removeByTitle(String title);

	/**
	 * Returns the number of work items where title LIKE &#63;.
	 *
	 * @param title the title
	 * @return the number of matching work items
	 */
	public int countByTitle(String title);

	/**
	 * Returns all the work items where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching work items
	 */
	public java.util.List<WorkItem> findByUserId(long userId);

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
	public java.util.List<WorkItem> findByUserId(
		long userId, int start, int end);

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
	public java.util.List<WorkItem> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkItem>
			orderByComparator);

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
	public java.util.List<WorkItem> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkItem>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first work item in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work item
	 * @throws NoSuchWorkItemException if a matching work item could not be found
	 */
	public WorkItem findByUserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<WorkItem>
				orderByComparator)
		throws NoSuchWorkItemException;

	/**
	 * Returns the first work item in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work item, or <code>null</code> if a matching work item could not be found
	 */
	public WorkItem fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<WorkItem>
			orderByComparator);

	/**
	 * Returns the last work item in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work item
	 * @throws NoSuchWorkItemException if a matching work item could not be found
	 */
	public WorkItem findByUserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<WorkItem>
				orderByComparator)
		throws NoSuchWorkItemException;

	/**
	 * Returns the last work item in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work item, or <code>null</code> if a matching work item could not be found
	 */
	public WorkItem fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<WorkItem>
			orderByComparator);

	/**
	 * Returns the work items before and after the current work item in the ordered set where userId = &#63;.
	 *
	 * @param workItemId the primary key of the current work item
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work item
	 * @throws NoSuchWorkItemException if a work item with the primary key could not be found
	 */
	public WorkItem[] findByUserId_PrevAndNext(
			long workItemId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<WorkItem>
				orderByComparator)
		throws NoSuchWorkItemException;

	/**
	 * Removes all the work items where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByUserId(long userId);

	/**
	 * Returns the number of work items where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching work items
	 */
	public int countByUserId(long userId);

	/**
	 * Returns all the work items where accountId = &#63;.
	 *
	 * @param accountId the account ID
	 * @return the matching work items
	 */
	public java.util.List<WorkItem> findByQuaTrinhXuLy(long accountId);

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
	public java.util.List<WorkItem> findByQuaTrinhXuLy(
		long accountId, int start, int end);

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
	public java.util.List<WorkItem> findByQuaTrinhXuLy(
		long accountId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkItem>
			orderByComparator);

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
	public java.util.List<WorkItem> findByQuaTrinhXuLy(
		long accountId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkItem>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first work item in the ordered set where accountId = &#63;.
	 *
	 * @param accountId the account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work item
	 * @throws NoSuchWorkItemException if a matching work item could not be found
	 */
	public WorkItem findByQuaTrinhXuLy_First(
			long accountId,
			com.liferay.portal.kernel.util.OrderByComparator<WorkItem>
				orderByComparator)
		throws NoSuchWorkItemException;

	/**
	 * Returns the first work item in the ordered set where accountId = &#63;.
	 *
	 * @param accountId the account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work item, or <code>null</code> if a matching work item could not be found
	 */
	public WorkItem fetchByQuaTrinhXuLy_First(
		long accountId,
		com.liferay.portal.kernel.util.OrderByComparator<WorkItem>
			orderByComparator);

	/**
	 * Returns the last work item in the ordered set where accountId = &#63;.
	 *
	 * @param accountId the account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work item
	 * @throws NoSuchWorkItemException if a matching work item could not be found
	 */
	public WorkItem findByQuaTrinhXuLy_Last(
			long accountId,
			com.liferay.portal.kernel.util.OrderByComparator<WorkItem>
				orderByComparator)
		throws NoSuchWorkItemException;

	/**
	 * Returns the last work item in the ordered set where accountId = &#63;.
	 *
	 * @param accountId the account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work item, or <code>null</code> if a matching work item could not be found
	 */
	public WorkItem fetchByQuaTrinhXuLy_Last(
		long accountId,
		com.liferay.portal.kernel.util.OrderByComparator<WorkItem>
			orderByComparator);

	/**
	 * Returns the work items before and after the current work item in the ordered set where accountId = &#63;.
	 *
	 * @param workItemId the primary key of the current work item
	 * @param accountId the account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work item
	 * @throws NoSuchWorkItemException if a work item with the primary key could not be found
	 */
	public WorkItem[] findByQuaTrinhXuLy_PrevAndNext(
			long workItemId, long accountId,
			com.liferay.portal.kernel.util.OrderByComparator<WorkItem>
				orderByComparator)
		throws NoSuchWorkItemException;

	/**
	 * Removes all the work items where accountId = &#63; from the database.
	 *
	 * @param accountId the account ID
	 */
	public void removeByQuaTrinhXuLy(long accountId);

	/**
	 * Returns the number of work items where accountId = &#63;.
	 *
	 * @param accountId the account ID
	 * @return the number of matching work items
	 */
	public int countByQuaTrinhXuLy(long accountId);

	/**
	 * Caches the work item in the entity cache if it is enabled.
	 *
	 * @param workItem the work item
	 */
	public void cacheResult(WorkItem workItem);

	/**
	 * Caches the work items in the entity cache if it is enabled.
	 *
	 * @param workItems the work items
	 */
	public void cacheResult(java.util.List<WorkItem> workItems);

	/**
	 * Creates a new work item with the primary key. Does not add the work item to the database.
	 *
	 * @param workItemId the primary key for the new work item
	 * @return the new work item
	 */
	public WorkItem create(long workItemId);

	/**
	 * Removes the work item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workItemId the primary key of the work item
	 * @return the work item that was removed
	 * @throws NoSuchWorkItemException if a work item with the primary key could not be found
	 */
	public WorkItem remove(long workItemId) throws NoSuchWorkItemException;

	public WorkItem updateImpl(WorkItem workItem);

	/**
	 * Returns the work item with the primary key or throws a <code>NoSuchWorkItemException</code> if it could not be found.
	 *
	 * @param workItemId the primary key of the work item
	 * @return the work item
	 * @throws NoSuchWorkItemException if a work item with the primary key could not be found
	 */
	public WorkItem findByPrimaryKey(long workItemId)
		throws NoSuchWorkItemException;

	/**
	 * Returns the work item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param workItemId the primary key of the work item
	 * @return the work item, or <code>null</code> if a work item with the primary key could not be found
	 */
	public WorkItem fetchByPrimaryKey(long workItemId);

	/**
	 * Returns all the work items.
	 *
	 * @return the work items
	 */
	public java.util.List<WorkItem> findAll();

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
	public java.util.List<WorkItem> findAll(int start, int end);

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
	public java.util.List<WorkItem> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkItem>
			orderByComparator);

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
	public java.util.List<WorkItem> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkItem>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the work items from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of work items.
	 *
	 * @return the number of work items
	 */
	public int countAll();

}