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

import dtt.vn.user.service.model.AccountLog;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AccountLog in entity cache.
 *
 * @author nhanvienDTT
 * @generated
 */
@ProviderType
public class AccountLogCacheModel
	implements CacheModel<AccountLog>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AccountLogCacheModel)) {
			return false;
		}

		AccountLogCacheModel accountLogCacheModel = (AccountLogCacheModel)obj;

		if (id == accountLogCacheModel.id) {
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
		sb.append(", accountId=");
		sb.append(accountId);
		sb.append(", nguoiSuaId=");
		sb.append(nguoiSuaId);
		sb.append(", tenNguoiSua=");
		sb.append(tenNguoiSua);
		sb.append(", ngaySua=");
		sb.append(ngaySua);
		sb.append(", emailNguoiSua=");
		sb.append(emailNguoiSua);
		sb.append(", phienBan=");
		sb.append(phienBan);
		sb.append(", json=");
		sb.append(json);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AccountLog toEntityModel() {
		AccountLogImpl accountLogImpl = new AccountLogImpl();

		accountLogImpl.setId(id);
		accountLogImpl.setAccountId(accountId);
		accountLogImpl.setNguoiSuaId(nguoiSuaId);

		if (tenNguoiSua == null) {
			accountLogImpl.setTenNguoiSua("");
		}
		else {
			accountLogImpl.setTenNguoiSua(tenNguoiSua);
		}

		if (ngaySua == Long.MIN_VALUE) {
			accountLogImpl.setNgaySua(null);
		}
		else {
			accountLogImpl.setNgaySua(new Date(ngaySua));
		}

		if (emailNguoiSua == null) {
			accountLogImpl.setEmailNguoiSua("");
		}
		else {
			accountLogImpl.setEmailNguoiSua(emailNguoiSua);
		}

		accountLogImpl.setPhienBan(phienBan);

		if (json == null) {
			accountLogImpl.setJson("");
		}
		else {
			accountLogImpl.setJson(json);
		}

		accountLogImpl.resetOriginalValues();

		return accountLogImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		accountId = objectInput.readLong();

		nguoiSuaId = objectInput.readLong();
		tenNguoiSua = objectInput.readUTF();
		ngaySua = objectInput.readLong();
		emailNguoiSua = objectInput.readUTF();

		phienBan = objectInput.readLong();
		json = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(accountId);

		objectOutput.writeLong(nguoiSuaId);

		if (tenNguoiSua == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tenNguoiSua);
		}

		objectOutput.writeLong(ngaySua);

		if (emailNguoiSua == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(emailNguoiSua);
		}

		objectOutput.writeLong(phienBan);

		if (json == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(json);
		}
	}

	public long id;
	public long accountId;
	public long nguoiSuaId;
	public String tenNguoiSua;
	public long ngaySua;
	public String emailNguoiSua;
	public long phienBan;
	public String json;

}