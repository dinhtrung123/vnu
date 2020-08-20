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

import dtt.vn.vnpost.model.Photo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Photo in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class PhotoCacheModel implements CacheModel<Photo>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PhotoCacheModel)) {
			return false;
		}

		PhotoCacheModel photoCacheModel = (PhotoCacheModel)obj;

		if (imageId == photoCacheModel.imageId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, imageId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{imageId=");
		sb.append(imageId);
		sb.append(", className=");
		sb.append(className);
		sb.append(", classPK=");
		sb.append(classPK);
		sb.append(", description=");
		sb.append(description);
		sb.append(", thumbnailId=");
		sb.append(thumbnailId);
		sb.append(", imageType=");
		sb.append(imageType);
		sb.append(", contentType=");
		sb.append(contentType);
		sb.append(", approved=");
		sb.append(approved);
		sb.append(", uploadDate=");
		sb.append(uploadDate);
		sb.append(", message=");
		sb.append(message);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Photo toEntityModel() {
		PhotoImpl photoImpl = new PhotoImpl();

		photoImpl.setImageId(imageId);

		if (className == null) {
			photoImpl.setClassName("");
		}
		else {
			photoImpl.setClassName(className);
		}

		photoImpl.setClassPK(classPK);

		if (description == null) {
			photoImpl.setDescription("");
		}
		else {
			photoImpl.setDescription(description);
		}

		photoImpl.setThumbnailId(thumbnailId);
		photoImpl.setImageType(imageType);

		if (contentType == null) {
			photoImpl.setContentType("");
		}
		else {
			photoImpl.setContentType(contentType);
		}

		photoImpl.setApproved(approved);

		if (uploadDate == Long.MIN_VALUE) {
			photoImpl.setUploadDate(null);
		}
		else {
			photoImpl.setUploadDate(new Date(uploadDate));
		}

		if (message == null) {
			photoImpl.setMessage("");
		}
		else {
			photoImpl.setMessage(message);
		}

		photoImpl.resetOriginalValues();

		return photoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		imageId = objectInput.readLong();
		className = objectInput.readUTF();

		classPK = objectInput.readLong();
		description = objectInput.readUTF();

		thumbnailId = objectInput.readLong();

		imageType = objectInput.readInt();
		contentType = objectInput.readUTF();

		approved = objectInput.readBoolean();
		uploadDate = objectInput.readLong();
		message = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(imageId);

		if (className == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(className);
		}

		objectOutput.writeLong(classPK);

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(thumbnailId);

		objectOutput.writeInt(imageType);

		if (contentType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(contentType);
		}

		objectOutput.writeBoolean(approved);
		objectOutput.writeLong(uploadDate);

		if (message == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(message);
		}
	}

	public long imageId;
	public String className;
	public long classPK;
	public String description;
	public long thumbnailId;
	public int imageType;
	public String contentType;
	public boolean approved;
	public long uploadDate;
	public String message;

}