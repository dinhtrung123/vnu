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

import org.oep.core.model.LogSMS;

/**
 * The cache model class for representing LogSMS in entity cache.
 *
 * @author manhlb
 * @generated
 */
@ProviderType
public class LogSMSCacheModel implements CacheModel<LogSMS>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LogSMSCacheModel)) {
			return false;
		}

		LogSMSCacheModel logSMSCacheModel = (LogSMSCacheModel)obj;

		if (id == logSMSCacheModel.id) {
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
		StringBundler sb = new StringBundler(15);

		sb.append("{id=");
		sb.append(id);
		sb.append(", sentDateTime=");
		sb.append(sentDateTime);
		sb.append(", phone=");
		sb.append(phone);
		sb.append(", responseDate=");
		sb.append(responseDate);
		sb.append(", errorCode=");
		sb.append(errorCode);
		sb.append(", errorDetail=");
		sb.append(errorDetail);
		sb.append(", messageId=");
		sb.append(messageId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LogSMS toEntityModel() {
		LogSMSImpl logSMSImpl = new LogSMSImpl();

		logSMSImpl.setId(id);

		if (sentDateTime == Long.MIN_VALUE) {
			logSMSImpl.setSentDateTime(null);
		}
		else {
			logSMSImpl.setSentDateTime(new Date(sentDateTime));
		}

		if (phone == null) {
			logSMSImpl.setPhone("");
		}
		else {
			logSMSImpl.setPhone(phone);
		}

		if (responseDate == Long.MIN_VALUE) {
			logSMSImpl.setResponseDate(null);
		}
		else {
			logSMSImpl.setResponseDate(new Date(responseDate));
		}

		if (errorCode == null) {
			logSMSImpl.setErrorCode("");
		}
		else {
			logSMSImpl.setErrorCode(errorCode);
		}

		if (errorDetail == null) {
			logSMSImpl.setErrorDetail("");
		}
		else {
			logSMSImpl.setErrorDetail(errorDetail);
		}

		logSMSImpl.setMessageId(messageId);

		logSMSImpl.resetOriginalValues();

		return logSMSImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		sentDateTime = objectInput.readLong();
		phone = objectInput.readUTF();
		responseDate = objectInput.readLong();
		errorCode = objectInput.readUTF();
		errorDetail = objectInput.readUTF();

		messageId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);
		objectOutput.writeLong(sentDateTime);

		if (phone == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(phone);
		}

		objectOutput.writeLong(responseDate);

		if (errorCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(errorCode);
		}

		if (errorDetail == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(errorDetail);
		}

		objectOutput.writeLong(messageId);
	}

	public long id;
	public long sentDateTime;
	public String phone;
	public long responseDate;
	public String errorCode;
	public String errorDetail;
	public long messageId;

}