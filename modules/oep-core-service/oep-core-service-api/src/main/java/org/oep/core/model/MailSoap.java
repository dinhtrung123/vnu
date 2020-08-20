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
 * This class is used by SOAP remote services.
 *
 * @author manhlb
 * @generated
 */
@ProviderType
public class MailSoap implements Serializable {

	public static MailSoap toSoapModel(Mail model) {
		MailSoap soapModel = new MailSoap();

		soapModel.setId(model.getId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCode(model.getCode());
		soapModel.setToAddress(model.getToAddress());
		soapModel.setSubject(model.getSubject());
		soapModel.setBody(model.getBody());
		soapModel.setNgayGui(model.getNgayGui());
		soapModel.setTrangThai(model.isTrangThai());

		return soapModel;
	}

	public static MailSoap[] toSoapModels(Mail[] models) {
		MailSoap[] soapModels = new MailSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MailSoap[][] toSoapModels(Mail[][] models) {
		MailSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MailSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MailSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MailSoap[] toSoapModels(List<Mail> models) {
		List<MailSoap> soapModels = new ArrayList<MailSoap>(models.size());

		for (Mail model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MailSoap[soapModels.size()]);
	}

	public MailSoap() {
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

	public String getCode() {
		return _code;
	}

	public void setCode(String code) {
		_code = code;
	}

	public String getToAddress() {
		return _toAddress;
	}

	public void setToAddress(String toAddress) {
		_toAddress = toAddress;
	}

	public String getSubject() {
		return _subject;
	}

	public void setSubject(String subject) {
		_subject = subject;
	}

	public String getBody() {
		return _body;
	}

	public void setBody(String body) {
		_body = body;
	}

	public Date getNgayGui() {
		return _ngayGui;
	}

	public void setNgayGui(Date ngayGui) {
		_ngayGui = ngayGui;
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
	private long _groupId;
	private String _code;
	private String _toAddress;
	private String _subject;
	private String _body;
	private Date _ngayGui;
	private boolean _trangThai;

}