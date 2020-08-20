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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link dtt.vn.vnpost.service.http.PhotoServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class PhotoSoap implements Serializable {

	public static PhotoSoap toSoapModel(Photo model) {
		PhotoSoap soapModel = new PhotoSoap();

		soapModel.setImageId(model.getImageId());
		soapModel.setClassName(model.getClassName());
		soapModel.setClassPK(model.getClassPK());
		soapModel.setDescription(model.getDescription());
		soapModel.setThumbnailId(model.getThumbnailId());
		soapModel.setImageType(model.getImageType());
		soapModel.setContentType(model.getContentType());
		soapModel.setApproved(model.isApproved());
		soapModel.setUploadDate(model.getUploadDate());
		soapModel.setMessage(model.getMessage());

		return soapModel;
	}

	public static PhotoSoap[] toSoapModels(Photo[] models) {
		PhotoSoap[] soapModels = new PhotoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PhotoSoap[][] toSoapModels(Photo[][] models) {
		PhotoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PhotoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PhotoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PhotoSoap[] toSoapModels(List<Photo> models) {
		List<PhotoSoap> soapModels = new ArrayList<PhotoSoap>(models.size());

		for (Photo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PhotoSoap[soapModels.size()]);
	}

	public PhotoSoap() {
	}

	public long getPrimaryKey() {
		return _imageId;
	}

	public void setPrimaryKey(long pk) {
		setImageId(pk);
	}

	public long getImageId() {
		return _imageId;
	}

	public void setImageId(long imageId) {
		_imageId = imageId;
	}

	public String getClassName() {
		return _className;
	}

	public void setClassName(String className) {
		_className = className;
	}

	public long getClassPK() {
		return _classPK;
	}

	public void setClassPK(long classPK) {
		_classPK = classPK;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public long getThumbnailId() {
		return _thumbnailId;
	}

	public void setThumbnailId(long thumbnailId) {
		_thumbnailId = thumbnailId;
	}

	public int getImageType() {
		return _imageType;
	}

	public void setImageType(int imageType) {
		_imageType = imageType;
	}

	public String getContentType() {
		return _contentType;
	}

	public void setContentType(String contentType) {
		_contentType = contentType;
	}

	public boolean getApproved() {
		return _approved;
	}

	public boolean isApproved() {
		return _approved;
	}

	public void setApproved(boolean approved) {
		_approved = approved;
	}

	public Date getUploadDate() {
		return _uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		_uploadDate = uploadDate;
	}

	public String getMessage() {
		return _message;
	}

	public void setMessage(String message) {
		_message = message;
	}

	private long _imageId;
	private String _className;
	private long _classPK;
	private String _description;
	private long _thumbnailId;
	private int _imageType;
	private String _contentType;
	private boolean _approved;
	private Date _uploadDate;
	private String _message;

}