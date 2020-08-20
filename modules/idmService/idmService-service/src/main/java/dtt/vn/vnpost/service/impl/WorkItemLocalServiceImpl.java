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

package dtt.vn.vnpost.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;

import dtt.vn.vnpost.model.WorkItem;
import dtt.vn.vnpost.service.base.WorkItemLocalServiceBaseImpl;

/**
 * The implementation of the work item local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>dtt.vn.vnpost.service.WorkItemLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WorkItemLocalServiceBaseImpl
 */
public class WorkItemLocalServiceImpl extends WorkItemLocalServiceBaseImpl {

	public WorkItem createWorkItem() throws SystemException{
	    long workItemId = super.counterLocalService.increment();
	    return super.workItemLocalService.createWorkItem(workItemId);
		}
	public WorkItem getWorkItemByAccountId(long accountId) throws SystemException{
	 return workItemFinder.getWorkItemByAccountId(accountId);
		}
 
	public WorkItem getWorkItemByAccountIdLastComplete(long accountId) throws SystemException{
	 return  workItemFinder.getWorkItemByAccountIdLastComplete(accountId);
		}
	public List<WorkItem> getQuaTrinhXuLy(long accountId) throws SystemException{
	 return workItemPersistence.findByQuaTrinhXuLy(accountId);
		}
}