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
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link WorkItem}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WorkItem
 * @generated
 */
@ProviderType
public class WorkItemWrapper implements WorkItem, ModelWrapper<WorkItem> {

	public WorkItemWrapper(WorkItem workItem) {
		_workItem = workItem;
	}

	@Override
	public Class<?> getModelClass() {
		return WorkItem.class;
	}

	@Override
	public String getModelClassName() {
		return WorkItem.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("workItemId", getWorkItemId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("title", getTitle());
		attributes.put("status", getStatus());
		attributes.put("statusResponse", getStatusResponse());
		attributes.put("startTime", getStartTime());
		attributes.put("endTime", getEndTime());
		attributes.put("accountId", getAccountId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long workItemId = (Long)attributes.get("workItemId");

		if (workItemId != null) {
			setWorkItemId(workItemId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String statusResponse = (String)attributes.get("statusResponse");

		if (statusResponse != null) {
			setStatusResponse(statusResponse);
		}

		Date startTime = (Date)attributes.get("startTime");

		if (startTime != null) {
			setStartTime(startTime);
		}

		Date endTime = (Date)attributes.get("endTime");

		if (endTime != null) {
			setEndTime(endTime);
		}

		Long accountId = (Long)attributes.get("accountId");

		if (accountId != null) {
			setAccountId(accountId);
		}
	}

	@Override
	public Object clone() {
		return new WorkItemWrapper((WorkItem)_workItem.clone());
	}

	@Override
	public int compareTo(dtt.vn.vnpost.model.WorkItem workItem) {
		return _workItem.compareTo(workItem);
	}

	/**
	 * Returns the account ID of this work item.
	 *
	 * @return the account ID of this work item
	 */
	@Override
	public long getAccountId() {
		return _workItem.getAccountId();
	}

	/**
	 * Returns the create date of this work item.
	 *
	 * @return the create date of this work item
	 */
	@Override
	public Date getCreateDate() {
		return _workItem.getCreateDate();
	}

	/**
	 * Returns the end time of this work item.
	 *
	 * @return the end time of this work item
	 */
	@Override
	public Date getEndTime() {
		return _workItem.getEndTime();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _workItem.getExpandoBridge();
	}

	/**
	 * Returns the group ID of this work item.
	 *
	 * @return the group ID of this work item
	 */
	@Override
	public long getGroupId() {
		return _workItem.getGroupId();
	}

	/**
	 * Returns the modified date of this work item.
	 *
	 * @return the modified date of this work item
	 */
	@Override
	public Date getModifiedDate() {
		return _workItem.getModifiedDate();
	}

	/**
	 * Returns the primary key of this work item.
	 *
	 * @return the primary key of this work item
	 */
	@Override
	public long getPrimaryKey() {
		return _workItem.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _workItem.getPrimaryKeyObj();
	}

	/**
	 * Returns the start time of this work item.
	 *
	 * @return the start time of this work item
	 */
	@Override
	public Date getStartTime() {
		return _workItem.getStartTime();
	}

	/**
	 * Returns the status of this work item.
	 *
	 * @return the status of this work item
	 */
	@Override
	public String getStatus() {
		return _workItem.getStatus();
	}

	/**
	 * Returns the status response of this work item.
	 *
	 * @return the status response of this work item
	 */
	@Override
	public String getStatusResponse() {
		return _workItem.getStatusResponse();
	}

	/**
	 * Returns the title of this work item.
	 *
	 * @return the title of this work item
	 */
	@Override
	public String getTitle() {
		return _workItem.getTitle();
	}

	/**
	 * Returns the user ID of this work item.
	 *
	 * @return the user ID of this work item
	 */
	@Override
	public long getUserId() {
		return _workItem.getUserId();
	}

	/**
	 * Returns the user uuid of this work item.
	 *
	 * @return the user uuid of this work item
	 */
	@Override
	public String getUserUuid() {
		return _workItem.getUserUuid();
	}

	/**
	 * Returns the work item ID of this work item.
	 *
	 * @return the work item ID of this work item
	 */
	@Override
	public long getWorkItemId() {
		return _workItem.getWorkItemId();
	}

	@Override
	public int hashCode() {
		return _workItem.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _workItem.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _workItem.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _workItem.isNew();
	}

	@Override
	public void persist() {
		_workItem.persist();
	}

	/**
	 * Sets the account ID of this work item.
	 *
	 * @param accountId the account ID of this work item
	 */
	@Override
	public void setAccountId(long accountId) {
		_workItem.setAccountId(accountId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_workItem.setCachedModel(cachedModel);
	}

	/**
	 * Sets the create date of this work item.
	 *
	 * @param createDate the create date of this work item
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_workItem.setCreateDate(createDate);
	}

	/**
	 * Sets the end time of this work item.
	 *
	 * @param endTime the end time of this work item
	 */
	@Override
	public void setEndTime(Date endTime) {
		_workItem.setEndTime(endTime);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_workItem.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_workItem.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_workItem.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the group ID of this work item.
	 *
	 * @param groupId the group ID of this work item
	 */
	@Override
	public void setGroupId(long groupId) {
		_workItem.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this work item.
	 *
	 * @param modifiedDate the modified date of this work item
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_workItem.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_workItem.setNew(n);
	}

	/**
	 * Sets the primary key of this work item.
	 *
	 * @param primaryKey the primary key of this work item
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_workItem.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_workItem.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the start time of this work item.
	 *
	 * @param startTime the start time of this work item
	 */
	@Override
	public void setStartTime(Date startTime) {
		_workItem.setStartTime(startTime);
	}

	/**
	 * Sets the status of this work item.
	 *
	 * @param status the status of this work item
	 */
	@Override
	public void setStatus(String status) {
		_workItem.setStatus(status);
	}

	/**
	 * Sets the status response of this work item.
	 *
	 * @param statusResponse the status response of this work item
	 */
	@Override
	public void setStatusResponse(String statusResponse) {
		_workItem.setStatusResponse(statusResponse);
	}

	/**
	 * Sets the title of this work item.
	 *
	 * @param title the title of this work item
	 */
	@Override
	public void setTitle(String title) {
		_workItem.setTitle(title);
	}

	/**
	 * Sets the user ID of this work item.
	 *
	 * @param userId the user ID of this work item
	 */
	@Override
	public void setUserId(long userId) {
		_workItem.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this work item.
	 *
	 * @param userUuid the user uuid of this work item
	 */
	@Override
	public void setUserUuid(String userUuid) {
		_workItem.setUserUuid(userUuid);
	}

	/**
	 * Sets the work item ID of this work item.
	 *
	 * @param workItemId the work item ID of this work item
	 */
	@Override
	public void setWorkItemId(long workItemId) {
		_workItem.setWorkItemId(workItemId);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<dtt.vn.vnpost.model.WorkItem> toCacheModel() {

		return _workItem.toCacheModel();
	}

	@Override
	public dtt.vn.vnpost.model.WorkItem toEscapedModel() {
		return new WorkItemWrapper(_workItem.toEscapedModel());
	}

	@Override
	public String toString() {
		return _workItem.toString();
	}

	@Override
	public dtt.vn.vnpost.model.WorkItem toUnescapedModel() {
		return new WorkItemWrapper(_workItem.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _workItem.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WorkItemWrapper)) {
			return false;
		}

		WorkItemWrapper workItemWrapper = (WorkItemWrapper)obj;

		if (Objects.equals(_workItem, workItemWrapper._workItem)) {
			return true;
		}

		return false;
	}

	@Override
	public WorkItem getWrappedModel() {
		return _workItem;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _workItem.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _workItem.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_workItem.resetOriginalValues();
	}

	private final WorkItem _workItem;

}