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

package dtt.vn.vnpost.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import dtt.vn.vnpost.model.WorkItem;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing WorkItem in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class WorkItemCacheModel
	implements CacheModel<WorkItem>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WorkItemCacheModel)) {
			return false;
		}

		WorkItemCacheModel workItemCacheModel = (WorkItemCacheModel)obj;

		if (workItemId == workItemCacheModel.workItemId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, workItemId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{workItemId=");
		sb.append(workItemId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", title=");
		sb.append(title);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusResponse=");
		sb.append(statusResponse);
		sb.append(", startTime=");
		sb.append(startTime);
		sb.append(", endTime=");
		sb.append(endTime);
		sb.append(", accountId=");
		sb.append(accountId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public WorkItem toEntityModel() {
		WorkItemImpl workItemImpl = new WorkItemImpl();

		workItemImpl.setWorkItemId(workItemId);
		workItemImpl.setGroupId(groupId);
		workItemImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			workItemImpl.setCreateDate(null);
		}
		else {
			workItemImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			workItemImpl.setModifiedDate(null);
		}
		else {
			workItemImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (title == null) {
			workItemImpl.setTitle("");
		}
		else {
			workItemImpl.setTitle(title);
		}

		if (status == null) {
			workItemImpl.setStatus("");
		}
		else {
			workItemImpl.setStatus(status);
		}

		if (statusResponse == null) {
			workItemImpl.setStatusResponse("");
		}
		else {
			workItemImpl.setStatusResponse(statusResponse);
		}

		if (startTime == Long.MIN_VALUE) {
			workItemImpl.setStartTime(null);
		}
		else {
			workItemImpl.setStartTime(new Date(startTime));
		}

		if (endTime == Long.MIN_VALUE) {
			workItemImpl.setEndTime(null);
		}
		else {
			workItemImpl.setEndTime(new Date(endTime));
		}

		workItemImpl.setAccountId(accountId);

		workItemImpl.resetOriginalValues();

		return workItemImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		workItemId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		title = objectInput.readUTF();
		status = objectInput.readUTF();
		statusResponse = objectInput.readUTF();
		startTime = objectInput.readLong();
		endTime = objectInput.readLong();

		accountId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(workItemId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}

		if (statusResponse == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusResponse);
		}

		objectOutput.writeLong(startTime);
		objectOutput.writeLong(endTime);

		objectOutput.writeLong(accountId);
	}

	public long workItemId;
	public long groupId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String title;
	public String status;
	public String statusResponse;
	public long startTime;
	public long endTime;
	public long accountId;

}