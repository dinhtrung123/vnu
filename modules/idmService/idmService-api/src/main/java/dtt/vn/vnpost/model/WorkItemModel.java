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

package dtt.vn.vnpost.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the WorkItem service. Represents a row in the &quot;idm_workitem&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>dtt.vn.vnpost.model.impl.WorkItemModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>dtt.vn.vnpost.model.impl.WorkItemImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WorkItem
 * @generated
 */
@ProviderType
public interface WorkItemModel extends BaseModel<WorkItem> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a work item model instance should use the {@link WorkItem} interface instead.
	 */

	/**
	 * Returns the primary key of this work item.
	 *
	 * @return the primary key of this work item
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this work item.
	 *
	 * @param primaryKey the primary key of this work item
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the work item ID of this work item.
	 *
	 * @return the work item ID of this work item
	 */
	public long getWorkItemId();

	/**
	 * Sets the work item ID of this work item.
	 *
	 * @param workItemId the work item ID of this work item
	 */
	public void setWorkItemId(long workItemId);

	/**
	 * Returns the group ID of this work item.
	 *
	 * @return the group ID of this work item
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this work item.
	 *
	 * @param groupId the group ID of this work item
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the user ID of this work item.
	 *
	 * @return the user ID of this work item
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this work item.
	 *
	 * @param userId the user ID of this work item
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this work item.
	 *
	 * @return the user uuid of this work item
	 */
	public String getUserUuid();

	/**
	 * Sets the user uuid of this work item.
	 *
	 * @param userUuid the user uuid of this work item
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the create date of this work item.
	 *
	 * @return the create date of this work item
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this work item.
	 *
	 * @param createDate the create date of this work item
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this work item.
	 *
	 * @return the modified date of this work item
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this work item.
	 *
	 * @param modifiedDate the modified date of this work item
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the title of this work item.
	 *
	 * @return the title of this work item
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this work item.
	 *
	 * @param title the title of this work item
	 */
	public void setTitle(String title);

	/**
	 * Returns the status of this work item.
	 *
	 * @return the status of this work item
	 */
	@AutoEscape
	public String getStatus();

	/**
	 * Sets the status of this work item.
	 *
	 * @param status the status of this work item
	 */
	public void setStatus(String status);

	/**
	 * Returns the status response of this work item.
	 *
	 * @return the status response of this work item
	 */
	@AutoEscape
	public String getStatusResponse();

	/**
	 * Sets the status response of this work item.
	 *
	 * @param statusResponse the status response of this work item
	 */
	public void setStatusResponse(String statusResponse);

	/**
	 * Returns the start time of this work item.
	 *
	 * @return the start time of this work item
	 */
	public Date getStartTime();

	/**
	 * Sets the start time of this work item.
	 *
	 * @param startTime the start time of this work item
	 */
	public void setStartTime(Date startTime);

	/**
	 * Returns the end time of this work item.
	 *
	 * @return the end time of this work item
	 */
	public Date getEndTime();

	/**
	 * Sets the end time of this work item.
	 *
	 * @param endTime the end time of this work item
	 */
	public void setEndTime(Date endTime);

	/**
	 * Returns the account ID of this work item.
	 *
	 * @return the account ID of this work item
	 */
	public long getAccountId();

	/**
	 * Sets the account ID of this work item.
	 *
	 * @param accountId the account ID of this work item
	 */
	public void setAccountId(long accountId);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(dtt.vn.vnpost.model.WorkItem workItem);

	@Override
	public int hashCode();

	@Override
	public CacheModel<dtt.vn.vnpost.model.WorkItem> toCacheModel();

	@Override
	public dtt.vn.vnpost.model.WorkItem toEscapedModel();

	@Override
	public dtt.vn.vnpost.model.WorkItem toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();

}