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

package org.oep.core.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.oep.core.model.Mail;

/**
 * The cache model class for representing Mail in entity cache.
 *
 * @author manhlb
 * @generated
 */
@ProviderType
public class MailCacheModel implements CacheModel<Mail>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MailCacheModel)) {
			return false;
		}

		MailCacheModel mailCacheModel = (MailCacheModel)obj;

		if (id == mailCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{id=");
		sb.append(id);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", code=");
		sb.append(code);
		sb.append(", toAddress=");
		sb.append(toAddress);
		sb.append(", subject=");
		sb.append(subject);
		sb.append(", body=");
		sb.append(body);
		sb.append(", ngayGui=");
		sb.append(ngayGui);
		sb.append(", trangThai=");
		sb.append(trangThai);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Mail toEntityModel() {
		MailImpl mailImpl = new MailImpl();

		mailImpl.setId(id);
		mailImpl.setGroupId(groupId);

		if (code == null) {
			mailImpl.setCode("");
		}
		else {
			mailImpl.setCode(code);
		}

		if (toAddress == null) {
			mailImpl.setToAddress("");
		}
		else {
			mailImpl.setToAddress(toAddress);
		}

		if (subject == null) {
			mailImpl.setSubject("");
		}
		else {
			mailImpl.setSubject(subject);
		}

		if (body == null) {
			mailImpl.setBody("");
		}
		else {
			mailImpl.setBody(body);
		}

		if (ngayGui == Long.MIN_VALUE) {
			mailImpl.setNgayGui(null);
		}
		else {
			mailImpl.setNgayGui(new Date(ngayGui));
		}

		mailImpl.setTrangThai(trangThai);

		mailImpl.resetOriginalValues();

		return mailImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		groupId = objectInput.readLong();
		code = objectInput.readUTF();
		toAddress = objectInput.readUTF();
		subject = objectInput.readUTF();
		body = objectInput.readUTF();
		ngayGui = objectInput.readLong();

		trangThai = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(groupId);

		if (code == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(code);
		}

		if (toAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(toAddress);
		}

		if (subject == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(subject);
		}

		if (body == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(body);
		}

		objectOutput.writeLong(ngayGui);

		objectOutput.writeBoolean(trangThai);
	}

	public long id;
	public long groupId;
	public String code;
	public String toAddress;
	public String subject;
	public String body;
	public long ngayGui;
	public boolean trangThai;

}