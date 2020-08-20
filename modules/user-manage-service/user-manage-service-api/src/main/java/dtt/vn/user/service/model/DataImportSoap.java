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
 * This class is used by SOAP remote services, specifically {@link dtt.vn.user.service.service.http.DataImportServiceSoap}.
 *
 * @author nhanvienDTT
 * @generated
 */
@ProviderType
public class DataImportSoap implements Serializable {

	public static DataImportSoap toSoapModel(DataImport model) {
		DataImportSoap soapModel = new DataImportSoap();

		soapModel.setId(model.getId());
		soapModel.setScreenName(model.getScreenName());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setLastName(model.getLastName());
		soapModel.setUnit(model.getUnit());
		soapModel.setEmailAddress(model.getEmailAddress());
		soapModel.setPhone(model.getPhone());
		soapModel.setJobTitle(model.getJobTitle());
		soapModel.setNameRole(model.getNameRole());
		soapModel.setNumberId(model.getNumberId());
		soapModel.setHasImport(model.getHasImport());
		soapModel.setErrorMsg(model.getErrorMsg());
		soapModel.setInsertDate(model.getInsertDate());

		return soapModel;
	}

	public static DataImportSoap[] toSoapModels(DataImport[] models) {
		DataImportSoap[] soapModels = new DataImportSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DataImportSoap[][] toSoapModels(DataImport[][] models) {
		DataImportSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DataImportSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DataImportSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DataImportSoap[] toSoapModels(List<DataImport> models) {
		List<DataImportSoap> soapModels = new ArrayList<DataImportSoap>(
			models.size());

		for (DataImport model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DataImportSoap[soapModels.size()]);
	}

	public DataImportSoap() {
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

	public String getScreenName() {
		return _screenName;
	}

	public void setScreenName(String screenName) {
		_screenName = screenName;
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public String getUnit() {
		return _unit;
	}

	public void setUnit(String unit) {
		_unit = unit;
	}

	public String getEmailAddress() {
		return _emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	public String getPhone() {
		return _phone;
	}

	public void setPhone(String phone) {
		_phone = phone;
	}

	public String getJobTitle() {
		return _jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		_jobTitle = jobTitle;
	}

	public String getNameRole() {
		return _nameRole;
	}

	public void setNameRole(String nameRole) {
		_nameRole = nameRole;
	}

	public String getNumberId() {
		return _numberId;
	}

	public void setNumberId(String numberId) {
		_numberId = numberId;
	}

	public String getHasImport() {
		return _hasImport;
	}

	public void setHasImport(String hasImport) {
		_hasImport = hasImport;
	}

	public String getErrorMsg() {
		return _errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		_errorMsg = errorMsg;
	}

	public Date getInsertDate() {
		return _insertDate;
	}

	public void setInsertDate(Date insertDate) {
		_insertDate = insertDate;
	}

	private long _id;
	private String _screenName;
	private String _firstName;
	private String _lastName;
	private String _unit;
	private String _emailAddress;
	private String _phone;
	private String _jobTitle;
	private String _nameRole;
	private String _numberId;
	private String _hasImport;
	private String _errorMsg;
	private Date _insertDate;

}