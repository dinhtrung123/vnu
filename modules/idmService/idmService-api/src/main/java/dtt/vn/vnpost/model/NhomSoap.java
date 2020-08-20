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
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class NhomSoap implements Serializable {

	public static NhomSoap toSoapModel(Nhom model) {
		NhomSoap soapModel = new NhomSoap();

		soapModel.setId(model.getId());
		soapModel.setMa(model.getMa());
		soapModel.setTen(model.getTen());
		soapModel.setMota(model.getMota());

		return soapModel;
	}

	public static NhomSoap[] toSoapModels(Nhom[] models) {
		NhomSoap[] soapModels = new NhomSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static NhomSoap[][] toSoapModels(Nhom[][] models) {
		NhomSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new NhomSoap[models.length][models[0].length];
		}
		else {
			soapModels = new NhomSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static NhomSoap[] toSoapModels(List<Nhom> models) {
		List<NhomSoap> soapModels = new ArrayList<NhomSoap>(models.size());

		for (Nhom model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new NhomSoap[soapModels.size()]);
	}

	public NhomSoap() {
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

	public String getMa() {
		return _ma;
	}

	public void setMa(String ma) {
		_ma = ma;
	}

	public String getTen() {
		return _ten;
	}

	public void setTen(String ten) {
		_ten = ten;
	}

	public String getMota() {
		return _mota;
	}

	public void setMota(String mota) {
		_mota = mota;
	}

	private long _id;
	private String _ma;
	private String _ten;
	private String _mota;

}