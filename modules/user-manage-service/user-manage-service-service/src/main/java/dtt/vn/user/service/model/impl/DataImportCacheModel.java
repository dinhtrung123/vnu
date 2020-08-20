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

package dtt.vn.user.service.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import dtt.vn.user.service.model.DataImport;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DataImport in entity cache.
 *
 * @author nhanvienDTT
 * @generated
 */
@ProviderType
public class DataImportCacheModel
	implements CacheModel<DataImport>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DataImportCacheModel)) {
			return false;
		}

		DataImportCacheModel dataImportCacheModel = (DataImportCacheModel)obj;

		if (id == dataImportCacheModel.id) {
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
		StringBundler sb = new StringBundler(27);

		sb.append("{id=");
		sb.append(id);
		sb.append(", screenName=");
		sb.append(screenName);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", unit=");
		sb.append(unit);
		sb.append(", emailAddress=");
		sb.append(emailAddress);
		sb.append(", phone=");
		sb.append(phone);
		sb.append(", jobTitle=");
		sb.append(jobTitle);
		sb.append(", nameRole=");
		sb.append(nameRole);
		sb.append(", numberId=");
		sb.append(numberId);
		sb.append(", hasImport=");
		sb.append(hasImport);
		sb.append(", errorMsg=");
		sb.append(errorMsg);
		sb.append(", insertDate=");
		sb.append(insertDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DataImport toEntityModel() {
		DataImportImpl dataImportImpl = new DataImportImpl();

		dataImportImpl.setId(id);

		if (screenName == null) {
			dataImportImpl.setScreenName("");
		}
		else {
			dataImportImpl.setScreenName(screenName);
		}

		if (firstName == null) {
			dataImportImpl.setFirstName("");
		}
		else {
			dataImportImpl.setFirstName(firstName);
		}

		if (lastName == null) {
			dataImportImpl.setLastName("");
		}
		else {
			dataImportImpl.setLastName(lastName);
		}

		if (unit == null) {
			dataImportImpl.setUnit("");
		}
		else {
			dataImportImpl.setUnit(unit);
		}

		if (emailAddress == null) {
			dataImportImpl.setEmailAddress("");
		}
		else {
			dataImportImpl.setEmailAddress(emailAddress);
		}

		if (phone == null) {
			dataImportImpl.setPhone("");
		}
		else {
			dataImportImpl.setPhone(phone);
		}

		if (jobTitle == null) {
			dataImportImpl.setJobTitle("");
		}
		else {
			dataImportImpl.setJobTitle(jobTitle);
		}

		if (nameRole == null) {
			dataImportImpl.setNameRole("");
		}
		else {
			dataImportImpl.setNameRole(nameRole);
		}

		if (numberId == null) {
			dataImportImpl.setNumberId("");
		}
		else {
			dataImportImpl.setNumberId(numberId);
		}

		if (hasImport == null) {
			dataImportImpl.setHasImport("");
		}
		else {
			dataImportImpl.setHasImport(hasImport);
		}

		if (errorMsg == null) {
			dataImportImpl.setErrorMsg("");
		}
		else {
			dataImportImpl.setErrorMsg(errorMsg);
		}

		if (insertDate == Long.MIN_VALUE) {
			dataImportImpl.setInsertDate(null);
		}
		else {
			dataImportImpl.setInsertDate(new Date(insertDate));
		}

		dataImportImpl.resetOriginalValues();

		return dataImportImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		screenName = objectInput.readUTF();
		firstName = objectInput.readUTF();
		lastName = objectInput.readUTF();
		unit = objectInput.readUTF();
		emailAddress = objectInput.readUTF();
		phone = objectInput.readUTF();
		jobTitle = objectInput.readUTF();
		nameRole = objectInput.readUTF();
		numberId = objectInput.readUTF();
		hasImport = objectInput.readUTF();
		errorMsg = objectInput.readUTF();
		insertDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		if (screenName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(screenName);
		}

		if (firstName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (lastName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		if (unit == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(unit);
		}

		if (emailAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(emailAddress);
		}

		if (phone == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(phone);
		}

		if (jobTitle == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(jobTitle);
		}

		if (nameRole == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nameRole);
		}

		if (numberId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(numberId);
		}

		if (hasImport == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(hasImport);
		}

		if (errorMsg == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(errorMsg);
		}

		objectOutput.writeLong(insertDate);
	}

	public long id;
	public String screenName;
	public String firstName;
	public String lastName;
	public String unit;
	public String emailAddress;
	public String phone;
	public String jobTitle;
	public String nameRole;
	public String numberId;
	public String hasImport;
	public String errorMsg;
	public long insertDate;

}