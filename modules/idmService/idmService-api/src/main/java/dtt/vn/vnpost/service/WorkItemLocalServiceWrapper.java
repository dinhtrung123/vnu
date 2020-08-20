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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link WorkItemLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see WorkItemLocalService
 * @generated
 */
@ProviderType
public class WorkItemLocalServiceWrapper
	implements WorkItemLocalService, ServiceWrapper<WorkItemLocalService> {

	public WorkItemLocalServiceWrapper(
		WorkItemLocalService workItemLocalService) {

		_workItemLocalService = workItemLocalService;
	}

	/**
	 * Adds the work item to the database. Also notifies the appropriate model listeners.
	 *
	 * @param workItem the work item
	 * @return the work item that was added
	 */
	@Override
	public dtt.vn.vnpost.model.WorkItem addWorkItem(
		dtt.vn.vnpost.model.WorkItem workItem) {

		return _workItemLocalService.addWorkItem(workItem);
	}

	@Override
	public dtt.vn.vnpost.model.WorkItem createWorkItem()
		throws com.liferay.portal.kernel.exception.SystemException {

		return _workItemLocalService.createWorkItem();
	}

	/**
	 * Creates a new work item with the primary key. Does not add the work item to the database.
	 *
	 * @param workItemId the primary key for the new work item
	 * @return the new work item
	 */
	@Override
	public dtt.vn.vnpost.model.WorkItem createWorkItem(long workItemId) {
		return _workItemLocalService.createWorkItem(workItemId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workItemLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the work item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workItemId the primary key of the work item
	 * @return the work item that was removed
	 * @throws PortalException if a work item with the primary key could not be found
	 */
	@Override
	public dtt.vn.vnpost.model.WorkItem deleteWorkItem(long workItemId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workItemLocalService.deleteWorkItem(workItemId);
	}

	/**
	 * Deletes the work item from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workItem the work item
	 * @return the work item that was removed
	 */
	@Override
	public dtt.vn.vnpost.model.WorkItem deleteWorkItem(
		dtt.vn.vnpost.model.WorkItem workItem) {

		return _workItemLocalService.deleteWorkItem(workItem);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _workItemLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _workItemLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _workItemLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _workItemLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _workItemLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _workItemLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public dtt.vn.vnpost.model.WorkItem fetchWorkItem(long workItemId) {
		return _workItemLocalService.fetchWorkItem(workItemId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _workItemLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _workItemLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _workItemLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workItemLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List<dtt.vn.vnpost.model.WorkItem> getQuaTrinhXuLy(
			long accountId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _workItemLocalService.getQuaTrinhXuLy(accountId);
	}

	/**
	 * Returns the work item with the primary key.
	 *
	 * @param workItemId the primary key of the work item
	 * @return the work item
	 * @throws PortalException if a work item with the primary key could not be found
	 */
	@Override
	public dtt.vn.vnpost.model.WorkItem getWorkItem(long workItemId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workItemLocalService.getWorkItem(workItemId);
	}

	@Override
	public dtt.vn.vnpost.model.WorkItem getWorkItemByAccountId(long accountId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _workItemLocalService.getWorkItemByAccountId(accountId);
	}

	@Override
	public dtt.vn.vnpost.model.WorkItem getWorkItemByAccountIdLastComplete(
			long accountId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _workItemLocalService.getWorkItemByAccountIdLastComplete(
			accountId);
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
	@Override
	public java.util.List<dtt.vn.vnpost.model.WorkItem> getWorkItems(
		int start, int end) {

		return _workItemLocalService.getWorkItems(start, end);
	}

	/**
	 * Returns the number of work items.
	 *
	 * @return the number of work items
	 */
	@Override
	public int getWorkItemsCount() {
		return _workItemLocalService.getWorkItemsCount();
	}

	/**
	 * Updates the work item in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param workItem the work item
	 * @return the work item that was updated
	 */
	@Override
	public dtt.vn.vnpost.model.WorkItem updateWorkItem(
		dtt.vn.vnpost.model.WorkItem workItem) {

		return _workItemLocalService.updateWorkItem(workItem);
	}

	@Override
	public WorkItemLocalService getWrappedService() {
		return _workItemLocalService;
	}

	@Override
	public void setWrappedService(WorkItemLocalService workItemLocalService) {
		_workItemLocalService = workItemLocalService;
	}

	private WorkItemLocalService _workItemLocalService;

}