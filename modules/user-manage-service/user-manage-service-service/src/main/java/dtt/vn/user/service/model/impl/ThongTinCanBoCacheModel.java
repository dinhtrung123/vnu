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

import dtt.vn.user.service.model.ThongTinCanBo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ThongTinCanBo in entity cache.
 *
 * @author nhanvienDTT
 * @generated
 */
@ProviderType
public class ThongTinCanBoCacheModel
	implements CacheModel<ThongTinCanBo>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ThongTinCanBoCacheModel)) {
			return false;
		}

		ThongTinCanBoCacheModel thongTinCanBoCacheModel =
			(ThongTinCanBoCacheModel)obj;

		if (id == thongTinCanBoCacheModel.id) {
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
		StringBundler sb = new StringBundler(11);

		sb.append("{id=");
		sb.append(id);
		sb.append(", emailAddress=");
		sb.append(emailAddress);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", nameRole=");
		sb.append(nameRole);
		sb.append(", noiDung=");
		sb.append(noiDung);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ThongTinCanBo toEntityModel() {
		ThongTinCanBoImpl thongTinCanBoImpl = new ThongTinCanBoImpl();

		thongTinCanBoImpl.setId(id);

		if (emailAddress == null) {
			thongTinCanBoImpl.setEmailAddress("");
		}
		else {
			thongTinCanBoImpl.setEmailAddress(emailAddress);
		}

		if (userName == null) {
			thongTinCanBoImpl.setUserName("");
		}
		else {
			thongTinCanBoImpl.setUserName(userName);
		}

		if (nameRole == null) {
			thongTinCanBoImpl.setNameRole("");
		}
		else {
			thongTinCanBoImpl.setNameRole(nameRole);
		}

		if (noiDung == null) {
			thongTinCanBoImpl.setNoiDung("");
		}
		else {
			thongTinCanBoImpl.setNoiDung(noiDung);
		}

		thongTinCanBoImpl.resetOriginalValues();

		return thongTinCanBoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		emailAddress = objectInput.readUTF();
		userName = objectInput.readUTF();
		nameRole = objectInput.readUTF();
		noiDung = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		if (emailAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(emailAddress);
		}

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		if (nameRole == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nameRole);
		}

		if (noiDung == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(noiDung);
		}
	}

	public long id;
	public String emailAddress;
	public String userName;
	public String nameRole;
	public String noiDung;

}