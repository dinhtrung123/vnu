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
public class DanhMucSoap implements Serializable {

	public static DanhMucSoap toSoapModel(DanhMuc model) {
		DanhMucSoap soapModel = new DanhMucSoap();

		soapModel.setId(model.getId());
		soapModel.setNhomId(model.getNhomId());
		soapModel.setMa(model.getMa());
		soapModel.setTen(model.getTen());
		soapModel.setMoTa(model.getMoTa());
		soapModel.setMuc(model.getMuc());
		soapModel.setChaId(model.getChaId());
		soapModel.setThuTuHienThi(model.getThuTuHienThi());
		soapModel.setMaGiaPha(model.getMaGiaPha());
		soapModel.setTrangThai(model.isTrangThai());

		return soapModel;
	}

	public static DanhMucSoap[] toSoapModels(DanhMuc[] models) {
		DanhMucSoap[] soapModels = new DanhMucSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DanhMucSoap[][] toSoapModels(DanhMuc[][] models) {
		DanhMucSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DanhMucSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DanhMucSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DanhMucSoap[] toSoapModels(List<DanhMuc> models) {
		List<DanhMucSoap> soapModels = new ArrayList<DanhMucSoap>(
			models.size());

		for (DanhMuc model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DanhMucSoap[soapModels.size()]);
	}

	public DanhMucSoap() {
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

	public long getNhomId() {
		return _nhomId;
	}

	public void setNhomId(long nhomId) {
		_nhomId = nhomId;
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

	public String getMoTa() {
		return _moTa;
	}

	public void setMoTa(String moTa) {
		_moTa = moTa;
	}

	public int getMuc() {
		return _muc;
	}

	public void setMuc(int muc) {
		_muc = muc;
	}

	public long getChaId() {
		return _chaId;
	}

	public void setChaId(long chaId) {
		_chaId = chaId;
	}

	public int getThuTuHienThi() {
		return _thuTuHienThi;
	}

	public void setThuTuHienThi(int thuTuHienThi) {
		_thuTuHienThi = thuTuHienThi;
	}

	public String getMaGiaPha() {
		return _maGiaPha;
	}

	public void setMaGiaPha(String maGiaPha) {
		_maGiaPha = maGiaPha;
	}

	public boolean getTrangThai() {
		return _trangThai;
	}

	public boolean isTrangThai() {
		return _trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		_trangThai = trangThai;
	}

	private long _id;
	private long _nhomId;
	private String _ma;
	private String _ten;
	private String _moTa;
	private int _muc;
	private long _chaId;
	private int _thuTuHienThi;
	private String _maGiaPha;
	private boolean _trangThai;

}