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
public class PhanQuyenSoap implements Serializable {

	public static PhanQuyenSoap toSoapModel(PhanQuyen model) {
		PhanQuyenSoap soapModel = new PhanQuyenSoap();

		soapModel.setId(model.getId());
		soapModel.setClassname(model.getClassname());
		soapModel.setClasspk(model.getClasspk());
		soapModel.setGiatri(model.getGiatri());

		return soapModel;
	}

	public static PhanQuyenSoap[] toSoapModels(PhanQuyen[] models) {
		PhanQuyenSoap[] soapModels = new PhanQuyenSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PhanQuyenSoap[][] toSoapModels(PhanQuyen[][] models) {
		PhanQuyenSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PhanQuyenSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PhanQuyenSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PhanQuyenSoap[] toSoapModels(List<PhanQuyen> models) {
		List<PhanQuyenSoap> soapModels = new ArrayList<PhanQuyenSoap>(
			models.size());

		for (PhanQuyen model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PhanQuyenSoap[soapModels.size()]);
	}

	public PhanQuyenSoap() {
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

	public String getClassname() {
		return _classname;
	}

	public void setClassname(String classname) {
		_classname = classname;
	}

	public long getClasspk() {
		return _classpk;
	}

	public void setClasspk(long classpk) {
		_classpk = classpk;
	}

	public String getGiatri() {
		return _giatri;
	}

	public void setGiatri(String giatri) {
		_giatri = giatri;
	}

	private long _id;
	private String _classname;
	private long _classpk;
	private String _giatri;

}