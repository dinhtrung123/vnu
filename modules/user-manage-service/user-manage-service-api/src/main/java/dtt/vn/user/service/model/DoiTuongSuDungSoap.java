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

package dtt.vn.user.service.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link dtt.vn.user.service.service.http.DoiTuongSuDungServiceSoap}.
 *
 * @author nhanvienDTT
 * @generated
 */
@ProviderType
public class DoiTuongSuDungSoap implements Serializable {

	public static DoiTuongSuDungSoap toSoapModel(DoiTuongSuDung model) {
		DoiTuongSuDungSoap soapModel = new DoiTuongSuDungSoap();

		soapModel.setId(model.getId());
		soapModel.setMa(model.getMa());
		soapModel.setTen(model.getTen());
		soapModel.setLoai(model.getLoai());
		soapModel.setMoTa(model.getMoTa());

		return soapModel;
	}

	public static DoiTuongSuDungSoap[] toSoapModels(DoiTuongSuDung[] models) {
		DoiTuongSuDungSoap[] soapModels = new DoiTuongSuDungSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DoiTuongSuDungSoap[][] toSoapModels(
		DoiTuongSuDung[][] models) {

		DoiTuongSuDungSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new DoiTuongSuDungSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DoiTuongSuDungSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DoiTuongSuDungSoap[] toSoapModels(
		List<DoiTuongSuDung> models) {

		List<DoiTuongSuDungSoap> soapModels = new ArrayList<DoiTuongSuDungSoap>(
			models.size());

		for (DoiTuongSuDung model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DoiTuongSuDungSoap[soapModels.size()]);
	}

	public DoiTuongSuDungSoap() {
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

	public int getLoai() {
		return _loai;
	}

	public void setLoai(int loai) {
		_loai = loai;
	}

	public String getMoTa() {
		return _moTa;
	}

	public void setMoTa(String moTa) {
		_moTa = moTa;
	}

	private long _id;
	private String _ma;
	private String _ten;
	private int _loai;
	private String _moTa;

}