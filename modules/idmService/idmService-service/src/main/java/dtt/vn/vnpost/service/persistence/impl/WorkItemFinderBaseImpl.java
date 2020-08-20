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

package dtt.vn.vnpost.service.persistence.impl;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;

import dtt.vn.vnpost.model.WorkItem;
import dtt.vn.vnpost.service.persistence.WorkItemPersistence;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class WorkItemFinderBaseImpl extends BasePersistenceImpl<WorkItem> {

	public WorkItemFinderBaseImpl() {
		setModelClass(WorkItem.class);
	}

	/**
	 * Returns the work item persistence.
	 *
	 * @return the work item persistence
	 */
	public WorkItemPersistence getWorkItemPersistence() {
		return workItemPersistence;
	}

	/**
	 * Sets the work item persistence.
	 *
	 * @param workItemPersistence the work item persistence
	 */
	public void setWorkItemPersistence(
		WorkItemPersistence workItemPersistence) {

		this.workItemPersistence = workItemPersistence;
	}

	@BeanReference(type = WorkItemPersistence.class)
	protected WorkItemPersistence workItemPersistence;

}