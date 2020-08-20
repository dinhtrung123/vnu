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
 * The base model interface for the Photo service. Represents a row in the &quot;idm_photo&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>dtt.vn.vnpost.model.impl.PhotoModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>dtt.vn.vnpost.model.impl.PhotoImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Photo
 * @generated
 */
@ProviderType
public interface PhotoModel extends BaseModel<Photo> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a photo model instance should use the {@link Photo} interface instead.
	 */

	/**
	 * Returns the primary key of this photo.
	 *
	 * @return the primary key of this photo
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this photo.
	 *
	 * @param primaryKey the primary key of this photo
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the image ID of this photo.
	 *
	 * @return the image ID of this photo
	 */
	public long getImageId();

	/**
	 * Sets the image ID of this photo.
	 *
	 * @param imageId the image ID of this photo
	 */
	public void setImageId(long imageId);

	/**
	 * Returns the class name of this photo.
	 *
	 * @return the class name of this photo
	 */
	@AutoEscape
	public String getClassName();

	/**
	 * Sets the class name of this photo.
	 *
	 * @param className the class name of this photo
	 */
	public void setClassName(String className);

	/**
	 * Returns the class pk of this photo.
	 *
	 * @return the class pk of this photo
	 */
	public long getClassPK();

	/**
	 * Sets the class pk of this photo.
	 *
	 * @param classPK the class pk of this photo
	 */
	public void setClassPK(long classPK);

	/**
	 * Returns the description of this photo.
	 *
	 * @return the description of this photo
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this photo.
	 *
	 * @param description the description of this photo
	 */
	public void setDescription(String description);

	/**
	 * Returns the thumbnail ID of this photo.
	 *
	 * @return the thumbnail ID of this photo
	 */
	public long getThumbnailId();

	/**
	 * Sets the thumbnail ID of this photo.
	 *
	 * @param thumbnailId the thumbnail ID of this photo
	 */
	public void setThumbnailId(long thumbnailId);

	/**
	 * Returns the image type of this photo.
	 *
	 * @return the image type of this photo
	 */
	public int getImageType();

	/**
	 * Sets the image type of this photo.
	 *
	 * @param imageType the image type of this photo
	 */
	public void setImageType(int imageType);

	/**
	 * Returns the content type of this photo.
	 *
	 * @return the content type of this photo
	 */
	@AutoEscape
	public String getContentType();

	/**
	 * Sets the content type of this photo.
	 *
	 * @param contentType the content type of this photo
	 */
	public void setContentType(String contentType);

	/**
	 * Returns the approved of this photo.
	 *
	 * @return the approved of this photo
	 */
	public boolean getApproved();

	/**
	 * Returns <code>true</code> if this photo is approved.
	 *
	 * @return <code>true</code> if this photo is approved; <code>false</code> otherwise
	 */
	public boolean isApproved();

	/**
	 * Sets whether this photo is approved.
	 *
	 * @param approved the approved of this photo
	 */
	public void setApproved(boolean approved);

	/**
	 * Returns the upload date of this photo.
	 *
	 * @return the upload date of this photo
	 */
	public Date getUploadDate();

	/**
	 * Sets the upload date of this photo.
	 *
	 * @param uploadDate the upload date of this photo
	 */
	public void setUploadDate(Date uploadDate);

	/**
	 * Returns the message of this photo.
	 *
	 * @return the message of this photo
	 */
	@AutoEscape
	public String getMessage();

	/**
	 * Sets the message of this photo.
	 *
	 * @param message the message of this photo
	 */
	public void setMessage(String message);

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
	public int compareTo(dtt.vn.vnpost.model.Photo photo);

	@Override
	public int hashCode();

	@Override
	public CacheModel<dtt.vn.vnpost.model.Photo> toCacheModel();

	@Override
	public dtt.vn.vnpost.model.Photo toEscapedModel();

	@Override
	public dtt.vn.vnpost.model.Photo toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();

}