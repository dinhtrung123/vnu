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
 * This class is a wrapper for {@link Photo}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Photo
 * @generated
 */
@ProviderType
public class PhotoWrapper implements Photo, ModelWrapper<Photo> {

	public PhotoWrapper(Photo photo) {
		_photo = photo;
	}

	@Override
	public Class<?> getModelClass() {
		return Photo.class;
	}

	@Override
	public String getModelClassName() {
		return Photo.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("imageId", getImageId());
		attributes.put("className", getClassName());
		attributes.put("classPK", getClassPK());
		attributes.put("description", getDescription());
		attributes.put("thumbnailId", getThumbnailId());
		attributes.put("imageType", getImageType());
		attributes.put("contentType", getContentType());
		attributes.put("approved", isApproved());
		attributes.put("uploadDate", getUploadDate());
		attributes.put("message", getMessage());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long imageId = (Long)attributes.get("imageId");

		if (imageId != null) {
			setImageId(imageId);
		}

		String className = (String)attributes.get("className");

		if (className != null) {
			setClassName(className);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long thumbnailId = (Long)attributes.get("thumbnailId");

		if (thumbnailId != null) {
			setThumbnailId(thumbnailId);
		}

		Integer imageType = (Integer)attributes.get("imageType");

		if (imageType != null) {
			setImageType(imageType);
		}

		String contentType = (String)attributes.get("contentType");

		if (contentType != null) {
			setContentType(contentType);
		}

		Boolean approved = (Boolean)attributes.get("approved");

		if (approved != null) {
			setApproved(approved);
		}

		Date uploadDate = (Date)attributes.get("uploadDate");

		if (uploadDate != null) {
			setUploadDate(uploadDate);
		}

		String message = (String)attributes.get("message");

		if (message != null) {
			setMessage(message);
		}
	}

	@Override
	public Object clone() {
		return new PhotoWrapper((Photo)_photo.clone());
	}

	@Override
	public int compareTo(dtt.vn.vnpost.model.Photo photo) {
		return _photo.compareTo(photo);
	}

	/**
	 * Returns the approved of this photo.
	 *
	 * @return the approved of this photo
	 */
	@Override
	public boolean getApproved() {
		return _photo.getApproved();
	}

	/**
	 * Returns the class name of this photo.
	 *
	 * @return the class name of this photo
	 */
	@Override
	public String getClassName() {
		return _photo.getClassName();
	}

	/**
	 * Returns the class pk of this photo.
	 *
	 * @return the class pk of this photo
	 */
	@Override
	public long getClassPK() {
		return _photo.getClassPK();
	}

	/**
	 * Returns the content type of this photo.
	 *
	 * @return the content type of this photo
	 */
	@Override
	public String getContentType() {
		return _photo.getContentType();
	}

	/**
	 * Returns the description of this photo.
	 *
	 * @return the description of this photo
	 */
	@Override
	public String getDescription() {
		return _photo.getDescription();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _photo.getExpandoBridge();
	}

	/**
	 * Returns the image ID of this photo.
	 *
	 * @return the image ID of this photo
	 */
	@Override
	public long getImageId() {
		return _photo.getImageId();
	}

	/**
	 * Returns the image type of this photo.
	 *
	 * @return the image type of this photo
	 */
	@Override
	public int getImageType() {
		return _photo.getImageType();
	}

	/**
	 * Returns the message of this photo.
	 *
	 * @return the message of this photo
	 */
	@Override
	public String getMessage() {
		return _photo.getMessage();
	}

	/**
	 * Returns the primary key of this photo.
	 *
	 * @return the primary key of this photo
	 */
	@Override
	public long getPrimaryKey() {
		return _photo.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _photo.getPrimaryKeyObj();
	}

	/**
	 * Returns the thumbnail ID of this photo.
	 *
	 * @return the thumbnail ID of this photo
	 */
	@Override
	public long getThumbnailId() {
		return _photo.getThumbnailId();
	}

	/**
	 * Returns the upload date of this photo.
	 *
	 * @return the upload date of this photo
	 */
	@Override
	public Date getUploadDate() {
		return _photo.getUploadDate();
	}

	@Override
	public int hashCode() {
		return _photo.hashCode();
	}

	/**
	 * Returns <code>true</code> if this photo is approved.
	 *
	 * @return <code>true</code> if this photo is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return _photo.isApproved();
	}

	@Override
	public boolean isCachedModel() {
		return _photo.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _photo.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _photo.isNew();
	}

	@Override
	public void persist() {
		_photo.persist();
	}

	/**
	 * Sets whether this photo is approved.
	 *
	 * @param approved the approved of this photo
	 */
	@Override
	public void setApproved(boolean approved) {
		_photo.setApproved(approved);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_photo.setCachedModel(cachedModel);
	}

	/**
	 * Sets the class name of this photo.
	 *
	 * @param className the class name of this photo
	 */
	@Override
	public void setClassName(String className) {
		_photo.setClassName(className);
	}

	/**
	 * Sets the class pk of this photo.
	 *
	 * @param classPK the class pk of this photo
	 */
	@Override
	public void setClassPK(long classPK) {
		_photo.setClassPK(classPK);
	}

	/**
	 * Sets the content type of this photo.
	 *
	 * @param contentType the content type of this photo
	 */
	@Override
	public void setContentType(String contentType) {
		_photo.setContentType(contentType);
	}

	/**
	 * Sets the description of this photo.
	 *
	 * @param description the description of this photo
	 */
	@Override
	public void setDescription(String description) {
		_photo.setDescription(description);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_photo.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_photo.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_photo.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the image ID of this photo.
	 *
	 * @param imageId the image ID of this photo
	 */
	@Override
	public void setImageId(long imageId) {
		_photo.setImageId(imageId);
	}

	/**
	 * Sets the image type of this photo.
	 *
	 * @param imageType the image type of this photo
	 */
	@Override
	public void setImageType(int imageType) {
		_photo.setImageType(imageType);
	}

	/**
	 * Sets the message of this photo.
	 *
	 * @param message the message of this photo
	 */
	@Override
	public void setMessage(String message) {
		_photo.setMessage(message);
	}

	@Override
	public void setNew(boolean n) {
		_photo.setNew(n);
	}

	/**
	 * Sets the primary key of this photo.
	 *
	 * @param primaryKey the primary key of this photo
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_photo.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_photo.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the thumbnail ID of this photo.
	 *
	 * @param thumbnailId the thumbnail ID of this photo
	 */
	@Override
	public void setThumbnailId(long thumbnailId) {
		_photo.setThumbnailId(thumbnailId);
	}

	/**
	 * Sets the upload date of this photo.
	 *
	 * @param uploadDate the upload date of this photo
	 */
	@Override
	public void setUploadDate(Date uploadDate) {
		_photo.setUploadDate(uploadDate);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<dtt.vn.vnpost.model.Photo>
		toCacheModel() {

		return _photo.toCacheModel();
	}

	@Override
	public dtt.vn.vnpost.model.Photo toEscapedModel() {
		return new PhotoWrapper(_photo.toEscapedModel());
	}

	@Override
	public String toString() {
		return _photo.toString();
	}

	@Override
	public dtt.vn.vnpost.model.Photo toUnescapedModel() {
		return new PhotoWrapper(_photo.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _photo.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PhotoWrapper)) {
			return false;
		}

		PhotoWrapper photoWrapper = (PhotoWrapper)obj;

		if (Objects.equals(_photo, photoWrapper._photo)) {
			return true;
		}

		return false;
	}

	@Override
	public Photo getWrappedModel() {
		return _photo;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _photo.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _photo.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_photo.resetOriginalValues();
	}

	private final Photo _photo;

}