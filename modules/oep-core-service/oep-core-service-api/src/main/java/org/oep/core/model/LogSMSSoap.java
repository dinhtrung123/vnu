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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.oep.core.service.http.LogSMSServiceSoap}.
 *
 * @author manhlb
 * @generated
 */
@ProviderType
public class LogSMSSoap implements Serializable {

	public static LogSMSSoap toSoapModel(LogSMS model) {
		LogSMSSoap soapModel = new LogSMSSoap();

		soapModel.setId(model.getId());
		soapModel.setSentDateTime(model.getSentDateTime());
		soapModel.setPhone(model.getPhone());
		soapModel.setResponseDate(model.getResponseDate());
		soapModel.setErrorCode(model.getErrorCode());
		soapModel.setErrorDetail(model.getErrorDetail());
		soapModel.setMessageId(model.getMessageId());

		return soapModel;
	}

	public static LogSMSSoap[] toSoapModels(LogSMS[] models) {
		LogSMSSoap[] soapModels = new LogSMSSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LogSMSSoap[][] toSoapModels(LogSMS[][] models) {
		LogSMSSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LogSMSSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LogSMSSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LogSMSSoap[] toSoapModels(List<LogSMS> models) {
		List<LogSMSSoap> soapModels = new ArrayList<LogSMSSoap>(models.size());

		for (LogSMS model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LogSMSSoap[soapModels.size()]);
	}

	public LogSMSSoap() {
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

	public Date getSentDateTime() {
		return _sentDateTime;
	}

	public void setSentDateTime(Date sentDateTime) {
		_sentDateTime = sentDateTime;
	}

	public String getPhone() {
		return _phone;
	}

	public void setPhone(String phone) {
		_phone = phone;
	}

	public Date getResponseDate() {
		return _responseDate;
	}

	public void setResponseDate(Date responseDate) {
		_responseDate = responseDate;
	}

	public String getErrorCode() {
		return _errorCode;
	}

	public void setErrorCode(String errorCode) {
		_errorCode = errorCode;
	}

	public String getErrorDetail() {
		return _errorDetail;
	}

	public void setErrorDetail(String errorDetail) {
		_errorDetail = errorDetail;
	}

	public long getMessageId() {
		return _messageId;
	}

	public void setMessageId(long messageId) {
		_messageId = messageId;
	}

	private long _id;
	private Date _sentDateTime;
	private String _phone;
	private Date _responseDate;
	private String _errorCode;
	private String _errorDetail;
	private long _messageId;

}