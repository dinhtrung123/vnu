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
public class ThamSoSoap implements Serializable {

	public static ThamSoSoap toSoapModel(ThamSo model) {
		ThamSoSoap soapModel = new ThamSoSoap();

		soapModel.setId(model.getId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setClassName(model.getClassName());
		soapModel.setClassPK(model.getClassPK());
		soapModel.setLoaiId(model.getLoaiId());
		soapModel.setMa(model.getMa());
		soapModel.setGiaTri(model.getGiaTri());
		soapModel.setMoTa(model.getMoTa());
		soapModel.setTrangThai(model.isTrangThai());
		soapModel.setQuyenTacDong(model.getQuyenTacDong());

		return soapModel;
	}

	public static ThamSoSoap[] toSoapModels(ThamSo[] models) {
		ThamSoSoap[] soapModels = new ThamSoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ThamSoSoap[][] toSoapModels(ThamSo[][] models) {
		ThamSoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ThamSoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ThamSoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ThamSoSoap[] toSoapModels(List<ThamSo> models) {
		List<ThamSoSoap> soapModels = new ArrayList<ThamSoSoap>(models.size());

		for (ThamSo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ThamSoSoap[soapModels.size()]);
	}

	public ThamSoSoap() {
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

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
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

	public long getLoaiId() {
		return _loaiId;
	}

	public void setLoaiId(long loaiId) {
		_loaiId = loaiId;
	}

	public String getMa() {
		return _ma;
	}

	public void setMa(String ma) {
		_ma = ma;
	}

	public String getGiaTri() {
		return _giaTri;
	}

	public void setGiaTri(String giaTri) {
		_giaTri = giaTri;
	}

	public String getMoTa() {
		return _moTa;
	}

	public void setMoTa(String moTa) {
		_moTa = moTa;
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

	public int getQuyenTacDong() {
		return _quyenTacDong;
	}

	public void setQuyenTacDong(int quyenTacDong) {
		_quyenTacDong = quyenTacDong;
	}

	private long _id;
	private long _groupId;
	private String _className;
	private long _classPK;
	private long _loaiId;
	private String _ma;
	private String _giaTri;
	private String _moTa;
	private boolean _trangThai;
	private int _quyenTacDong;

}