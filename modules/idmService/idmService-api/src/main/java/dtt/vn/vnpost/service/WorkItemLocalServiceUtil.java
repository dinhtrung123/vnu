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

package dtt.vn.vnpost.service;

import aQute.bnd.annotation.ProviderType;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for WorkItem. This utility wraps
 * <code>dtt.vn.vnpost.service.impl.WorkItemLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see WorkItemLocalService
 * @generated
 */
@ProviderType
public class WorkItemLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>dtt.vn.vnpost.service.impl.WorkItemLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the work item to the database. Also notifies the appropriate model listeners.
	 *
	 * @param workItem the work item
	 * @return the work item that was added
	 */
	public static dtt.vn.vnpost.model.WorkItem addWorkItem(
		dtt.vn.vnpost.model.WorkItem workItem) {

		return getService().addWorkItem(workItem);
	}

	public static dtt.vn.vnpost.model.WorkItem createWorkItem()
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().createWorkItem();
	}

	/**
	 * Creates a new work item with the primary key. Does not add the work item to the database.
	 *
	 * @param workItemId the primary key for the new work item
	 * @return the new work item
	 */
	public static dtt.vn.vnpost.model.WorkItem createWorkItem(long workItemId) {
		return getService().createWorkItem(workItemId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the work item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workItemId the primary key of the work item
	 * @return the work item that was removed
	 * @throws PortalException if a work item with the primary key could not be found
	 */
	public static dtt.vn.vnpost.model.WorkItem deleteWorkItem(long workItemId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteWorkItem(workItemId);
	}

	/**
	 * Deletes the work item from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workItem the work item
	 * @return the work item that was removed
	 */
	public static dtt.vn.vnpost.model.WorkItem deleteWorkItem(
		dtt.vn.vnpost.model.WorkItem workItem) {

		return getService().deleteWorkItem(workItem);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>dtt.vn.vnpost.model.impl.WorkItemModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>dtt.vn.vnpost.model.impl.WorkItemModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static dtt.vn.vnpost.model.WorkItem fetchWorkItem(long workItemId) {
		return getService().fetchWorkItem(workItemId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static java.util.List<dtt.vn.vnpost.model.WorkItem> getQuaTrinhXuLy(
			long accountId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getQuaTrinhXuLy(accountId);
	}

	/**
	 * Returns the work item with the primary key.
	 *
	 * @param workItemId the primary key of the work item
	 * @return the work item
	 * @throws PortalException if a work item with the primary key could not be found
	 */
	public static dtt.vn.vnpost.model.WorkItem getWorkItem(long workItemId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getWorkItem(workItemId);
	}

	public static dtt.vn.vnpost.model.WorkItem getWorkItemByAccountId(
			long accountId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getWorkItemByAccountId(accountId);
	}

	public static dtt.vn.vnpost.model.WorkItem
			getWorkItemByAccountIdLastComplete(long accountId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getWorkItemByAccountIdLastComplete(accountId);
	}

	/**
	 * Returns a range of all the work items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>dtt.vn.vnpost.model.impl.WorkItemModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of work items
	 * @param end the upper bound of the range of work items (not inclusive)
	 * @return the range of work items
	 */
	public static java.util.List<dtt.vn.vnpost.model.WorkItem> getWorkItems(
		int start, int end) {

		return getService().getWorkItems(start, end);
	}

	/**
	 * Returns the number of work items.
	 *
	 * @return the number of work items
	 */
	public static int getWorkItemsCount() {
		return getService().getWorkItemsCount();
	}

	/**
	 * Updates the work item in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param workItem the work item
	 * @return the work item that was updated
	 */
	public static dtt.vn.vnpost.model.WorkItem updateWorkItem(
		dtt.vn.vnpost.model.WorkItem workItem) {

		return getService().updateWorkItem(workItem);
	}

	public static WorkItemLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<WorkItemLocalService, WorkItemLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(WorkItemLocalService.class);

		ServiceTracker<WorkItemLocalService, WorkItemLocalService>
			serviceTracker =
				new ServiceTracker<WorkItemLocalService, WorkItemLocalService>(
					bundle.getBundleContext(), WorkItemLocalService.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}