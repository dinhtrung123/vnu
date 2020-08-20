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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link dtt.vn.user.service.service.http.ThongTinDangKyServiceSoap}.
 *
 * @author nhanvienDTT
 * @generated
 */
@ProviderType
public class ThongTinDangKySoap implements Serializable {

	public static ThongTinDangKySoap toSoapModel(ThongTinDangKy model) {
		ThongTinDangKySoap soapModel = new ThongTinDangKySoap();

		soapModel.setId(model.getId());
		soapModel.setEmailAddress(model.getEmailAddress());
		soapModel.setUserName(model.getUserName());
		soapModel.setSoGiayTo(model.getSoGiayTo());
		soapModel.setMaKichHoat(model.getMaKichHoat());
		soapModel.setActiveType(model.getActiveType());
		soapModel.setDoiTuongSuDungId(model.getDoiTuongSuDungId());
		soapModel.setNoiDung(model.getNoiDung());
		soapModel.setNgayTao(model.getNgayTao());

		return soapModel;
	}

	public static ThongTinDangKySoap[] toSoapModels(ThongTinDangKy[] models) {
		ThongTinDangKySoap[] soapModels = new ThongTinDangKySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ThongTinDangKySoap[][] toSoapModels(
		ThongTinDangKy[][] models) {

		ThongTinDangKySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new ThongTinDangKySoap[models.length][models[0].length];
		}
		else {
			soapModels = new ThongTinDangKySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ThongTinDangKySoap[] toSoapModels(
		List<ThongTinDangKy> models) {

		List<ThongTinDangKySoap> soapModels = new ArrayList<ThongTinDangKySoap>(
			models.size());

		for (ThongTinDangKy model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ThongTinDangKySoap[soapModels.size()]);
	}

	public ThongTinDangKySoap() {
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

	public String getEmailAddress() {
		return _emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public String getSoGiayTo() {
		return _soGiayTo;
	}

	public void setSoGiayTo(String soGiayTo) {
		_soGiayTo = soGiayTo;
	}

	public String getMaKichHoat() {
		return _maKichHoat;
	}

	public void setMaKichHoat(String maKichHoat) {
		_maKichHoat = maKichHoat;
	}

	public String getActiveType() {
		return _activeType;
	}

	public void setActiveType(String activeType) {
		_activeType = activeType;
	}

	public int getDoiTuongSuDungId() {
		return _doiTuongSuDungId;
	}

	public void setDoiTuongSuDungId(int doiTuongSuDungId) {
		_doiTuongSuDungId = doiTuongSuDungId;
	}

	public String getNoiDung() {
		return _noiDung;
	}

	public void setNoiDung(String noiDung) {
		_noiDung = noiDung;
	}

	public Date getNgayTao() {
		return _ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		_ngayTao = ngayTao;
	}

	private long _id;
	private String _emailAddress;
	private String _userName;
	private String _soGiayTo;
	private String _maKichHoat;
	private String _activeType;
	private int _doiTuongSuDungId;
	private String _noiDung;
	private Date _ngayTao;

}