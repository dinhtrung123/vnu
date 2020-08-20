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
 * This class is used by SOAP remote services, specifically {@link dtt.vn.user.service.service.http.ThongTinCanBoServiceSoap}.
 *
 * @author nhanvienDTT
 * @generated
 */
@ProviderType
public class ThongTinCanBoSoap implements Serializable {

	public static ThongTinCanBoSoap toSoapModel(ThongTinCanBo model) {
		ThongTinCanBoSoap soapModel = new ThongTinCanBoSoap();

		soapModel.setId(model.getId());
		soapModel.setEmailAddress(model.getEmailAddress());
		soapModel.setUserName(model.getUserName());
		soapModel.setNameRole(model.getNameRole());
		soapModel.setNoiDung(model.getNoiDung());

		return soapModel;
	}

	public static ThongTinCanBoSoap[] toSoapModels(ThongTinCanBo[] models) {
		ThongTinCanBoSoap[] soapModels = new ThongTinCanBoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ThongTinCanBoSoap[][] toSoapModels(ThongTinCanBo[][] models) {
		ThongTinCanBoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ThongTinCanBoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ThongTinCanBoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ThongTinCanBoSoap[] toSoapModels(List<ThongTinCanBo> models) {
		List<ThongTinCanBoSoap> soapModels = new ArrayList<ThongTinCanBoSoap>(
			models.size());

		for (ThongTinCanBo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ThongTinCanBoSoap[soapModels.size()]);
	}

	public ThongTinCanBoSoap() {
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

	public String getNameRole() {
		return _nameRole;
	}

	public void setNameRole(String nameRole) {
		_nameRole = nameRole;
	}

	public String getNoiDung() {
		return _noiDung;
	}

	public void setNoiDung(String noiDung) {
		_noiDung = noiDung;
	}

	private long _id;
	private String _emailAddress;
	private String _userName;
	private String _nameRole;
	private String _noiDung;

}