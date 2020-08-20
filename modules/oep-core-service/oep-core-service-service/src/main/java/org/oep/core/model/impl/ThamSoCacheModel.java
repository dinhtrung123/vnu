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

import org.oep.core.model.ThamSo;

/**
 * The cache model class for representing ThamSo in entity cache.
 *
 * @author manhlb
 * @generated
 */
@ProviderType
public class ThamSoCacheModel implements CacheModel<ThamSo>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ThamSoCacheModel)) {
			return false;
		}

		ThamSoCacheModel thamSoCacheModel = (ThamSoCacheModel)obj;

		if (id == thamSoCacheModel.id) {
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
		StringBundler sb = new StringBundler(21);

		sb.append("{id=");
		sb.append(id);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", className=");
		sb.append(className);
		sb.append(", classPK=");
		sb.append(classPK);
		sb.append(", loaiId=");
		sb.append(loaiId);
		sb.append(", ma=");
		sb.append(ma);
		sb.append(", giaTri=");
		sb.append(giaTri);
		sb.append(", moTa=");
		sb.append(moTa);
		sb.append(", trangThai=");
		sb.append(trangThai);
		sb.append(", quyenTacDong=");
		sb.append(quyenTacDong);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ThamSo toEntityModel() {
		ThamSoImpl thamSoImpl = new ThamSoImpl();

		thamSoImpl.setId(id);
		thamSoImpl.setGroupId(groupId);

		if (className == null) {
			thamSoImpl.setClassName("");
		}
		else {
			thamSoImpl.setClassName(className);
		}

		thamSoImpl.setClassPK(classPK);
		thamSoImpl.setLoaiId(loaiId);

		if (ma == null) {
			thamSoImpl.setMa("");
		}
		else {
			thamSoImpl.setMa(ma);
		}

		if (giaTri == null) {
			thamSoImpl.setGiaTri("");
		}
		else {
			thamSoImpl.setGiaTri(giaTri);
		}

		if (moTa == null) {
			thamSoImpl.setMoTa("");
		}
		else {
			thamSoImpl.setMoTa(moTa);
		}

		thamSoImpl.setTrangThai(trangThai);
		thamSoImpl.setQuyenTacDong(quyenTacDong);

		thamSoImpl.resetOriginalValues();

		return thamSoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		groupId = objectInput.readLong();
		className = objectInput.readUTF();

		classPK = objectInput.readLong();

		loaiId = objectInput.readLong();
		ma = objectInput.readUTF();
		giaTri = objectInput.readUTF();
		moTa = objectInput.readUTF();

		trangThai = objectInput.readBoolean();

		quyenTacDong = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(groupId);

		if (className == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(className);
		}

		objectOutput.writeLong(classPK);

		objectOutput.writeLong(loaiId);

		if (ma == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ma);
		}

		if (giaTri == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(giaTri);
		}

		if (moTa == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(moTa);
		}

		objectOutput.writeBoolean(trangThai);

		objectOutput.writeInt(quyenTacDong);
	}

	public long id;
	public long groupId;
	public String className;
	public long classPK;
	public long loaiId;
	public String ma;
	public String giaTri;
	public String moTa;
	public boolean trangThai;
	public int quyenTacDong;

}