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
public class TrungTamHanhChinhSoap implements Serializable {

	public static TrungTamHanhChinhSoap toSoapModel(TrungTamHanhChinh model) {
		TrungTamHanhChinhSoap soapModel = new TrungTamHanhChinhSoap();

		soapModel.setId(model.getId());
		soapModel.setMa(model.getMa());
		soapModel.setTen(model.getTen());
		soapModel.setDonViId(model.getDonViId());
		soapModel.setDonViIds(model.getDonViIds());
		soapModel.setThongTinLienHe(model.getThongTinLienHe());
		soapModel.setTrangThai(model.getTrangThai());

		return soapModel;
	}

	public static TrungTamHanhChinhSoap[] toSoapModels(
		TrungTamHanhChinh[] models) {

		TrungTamHanhChinhSoap[] soapModels =
			new TrungTamHanhChinhSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TrungTamHanhChinhSoap[][] toSoapModels(
		TrungTamHanhChinh[][] models) {

		TrungTamHanhChinhSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new TrungTamHanhChinhSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TrungTamHanhChinhSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TrungTamHanhChinhSoap[] toSoapModels(
		List<TrungTamHanhChinh> models) {

		List<TrungTamHanhChinhSoap> soapModels =
			new ArrayList<TrungTamHanhChinhSoap>(models.size());

		for (TrungTamHanhChinh model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TrungTamHanhChinhSoap[soapModels.size()]);
	}

	public TrungTamHanhChinhSoap() {
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

	public long getDonViId() {
		return _donViId;
	}

	public void setDonViId(long donViId) {
		_donViId = donViId;
	}

	public String getDonViIds() {
		return _donViIds;
	}

	public void setDonViIds(String donViIds) {
		_donViIds = donViIds;
	}

	public String getThongTinLienHe() {
		return _thongTinLienHe;
	}

	public void setThongTinLienHe(String thongTinLienHe) {
		_thongTinLienHe = thongTinLienHe;
	}

	public int getTrangThai() {
		return _trangThai;
	}

	public void setTrangThai(int trangThai) {
		_trangThai = trangThai;
	}

	private long _id;
	private String _ma;
	private String _ten;
	private long _donViId;
	private String _donViIds;
	private String _thongTinLienHe;
	private int _trangThai;

}