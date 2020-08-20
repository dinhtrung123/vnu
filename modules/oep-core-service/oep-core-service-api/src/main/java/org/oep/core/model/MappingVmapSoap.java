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

package org.oep.core.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author manhlb
 * @generated
 */
@ProviderType
public class MappingVmapSoap implements Serializable {

	public static MappingVmapSoap toSoapModel(MappingVmap model) {
		MappingVmapSoap soapModel = new MappingVmapSoap();

		soapModel.setId(model.getId());
		soapModel.setClasspk(model.getClasspk());
		soapModel.setClassname(model.getClassname());
		soapModel.setLatitude(model.getLatitude());
		soapModel.setLongitude(model.getLongitude());
		soapModel.setGhichu(model.getGhichu());

		return soapModel;
	}

	public static MappingVmapSoap[] toSoapModels(MappingVmap[] models) {
		MappingVmapSoap[] soapModels = new MappingVmapSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MappingVmapSoap[][] toSoapModels(MappingVmap[][] models) {
		MappingVmapSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MappingVmapSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MappingVmapSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MappingVmapSoap[] toSoapModels(List<MappingVmap> models) {
		List<MappingVmapSoap> soapModels = new ArrayList<MappingVmapSoap>(
			models.size());

		for (MappingVmap model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MappingVmapSoap[soapModels.size()]);
	}

	public MappingVmapSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public long getClasspk() {
		return _classpk;
	}

	public void setClasspk(long classpk) {
		_classpk = classpk;
	}

	public String getClassname() {
		return _classname;
	}

	public void setClassname(String classname) {
		_classname = classname;
	}

	public String getLatitude() {
		return _latitude;
	}

	public void setLatitude(String latitude) {
		_latitude = latitude;
	}

	public String getLongitude() {
		return _longitude;
	}

	public void setLongitude(String longitude) {
		_longitude = longitude;
	}

	public String getGhichu() {
		return _ghichu;
	}

	public void setGhichu(String ghichu) {
		_ghichu = ghichu;
	}

	private long _id;
	private long _classpk;
	private String _classname;
	private String _latitude;
	private String _longitude;
	private String _ghichu;

}