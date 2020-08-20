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
 * This class is used by SOAP remote services.
 *
 * @author nhanvienDTT
 * @generated
 */
@ProviderType
public class AccountLogSoap implements Serializable {

	public static AccountLogSoap toSoapModel(AccountLog model) {
		AccountLogSoap soapModel = new AccountLogSoap();

		soapModel.setId(model.getId());
		soapModel.setAccountId(model.getAccountId());
		soapModel.setNguoiSuaId(model.getNguoiSuaId());
		soapModel.setTenNguoiSua(model.getTenNguoiSua());
		soapModel.setNgaySua(model.getNgaySua());
		soapModel.setEmailNguoiSua(model.getEmailNguoiSua());
		soapModel.setPhienBan(model.getPhienBan());
		soapModel.setJson(model.getJson());

		return soapModel;
	}

	public static AccountLogSoap[] toSoapModels(AccountLog[] models) {
		AccountLogSoap[] soapModels = new AccountLogSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AccountLogSoap[][] toSoapModels(AccountLog[][] models) {
		AccountLogSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AccountLogSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AccountLogSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AccountLogSoap[] toSoapModels(List<AccountLog> models) {
		List<AccountLogSoap> soapModels = new ArrayList<AccountLogSoap>(
			models.size());

		for (AccountLog model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AccountLogSoap[soapModels.size()]);
	}

	public AccountLogSoap() {
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

	public long getAccountId() {
		return _accountId;
	}

	public void setAccountId(long accountId) {
		_accountId = accountId;
	}

	public long getNguoiSuaId() {
		return _nguoiSuaId;
	}

	public void setNguoiSuaId(long nguoiSuaId) {
		_nguoiSuaId = nguoiSuaId;
	}

	public String getTenNguoiSua() {
		return _tenNguoiSua;
	}

	public void setTenNguoiSua(String tenNguoiSua) {
		_tenNguoiSua = tenNguoiSua;
	}

	public Date getNgaySua() {
		return _ngaySua;
	}

	public void setNgaySua(Date ngaySua) {
		_ngaySua = ngaySua;
	}

	public String getEmailNguoiSua() {
		return _emailNguoiSua;
	}

	public void setEmailNguoiSua(String emailNguoiSua) {
		_emailNguoiSua = emailNguoiSua;
	}

	public long getPhienBan() {
		return _phienBan;
	}

	public void setPhienBan(long phienBan) {
		_phienBan = phienBan;
	}

	public String getJson() {
		return _json;
	}

	public void setJson(String json) {
		_json = json;
	}

	private long _id;
	private long _accountId;
	private long _nguoiSuaId;
	private String _tenNguoiSua;
	private Date _ngaySua;
	private String _emailNguoiSua;
	private long _phienBan;
	private String _json;

}