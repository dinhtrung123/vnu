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

import org.oep.core.model.TrungTamHanhChinh;

/**
 * The cache model class for representing TrungTamHanhChinh in entity cache.
 *
 * @author manhlb
 * @generated
 */
@ProviderType
public class TrungTamHanhChinhCacheModel
	implements CacheModel<TrungTamHanhChinh>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TrungTamHanhChinhCacheModel)) {
			return false;
		}

		TrungTamHanhChinhCacheModel trungTamHanhChinhCacheModel =
			(TrungTamHanhChinhCacheModel)obj;

		if (id == trungTamHanhChinhCacheModel.id) {
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
		sb.append(", ma=");
		sb.append(ma);
		sb.append(", ten=");
		sb.append(ten);
		sb.append(", donViId=");
		sb.append(donViId);
		sb.append(", donViIds=");
		sb.append(donViIds);
		sb.append(", thongTinLienHe=");
		sb.append(thongTinLienHe);
		sb.append(", trangThai=");
		sb.append(trangThai);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TrungTamHanhChinh toEntityModel() {
		TrungTamHanhChinhImpl trungTamHanhChinhImpl =
			new TrungTamHanhChinhImpl();

		trungTamHanhChinhImpl.setId(id);

		if (ma == null) {
			trungTamHanhChinhImpl.setMa("");
		}
		else {
			trungTamHanhChinhImpl.setMa(ma);
		}

		if (ten == null) {
			trungTamHanhChinhImpl.setTen("");
		}
		else {
			trungTamHanhChinhImpl.setTen(ten);
		}

		trungTamHanhChinhImpl.setDonViId(donViId);

		if (donViIds == null) {
			trungTamHanhChinhImpl.setDonViIds("");
		}
		else {
			trungTamHanhChinhImpl.setDonViIds(donViIds);
		}

		if (thongTinLienHe == null) {
			trungTamHanhChinhImpl.setThongTinLienHe("");
		}
		else {
			trungTamHanhChinhImpl.setThongTinLienHe(thongTinLienHe);
		}

		trungTamHanhChinhImpl.setTrangThai(trangThai);

		trungTamHanhChinhImpl.resetOriginalValues();

		return trungTamHanhChinhImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		ma = objectInput.readUTF();
		ten = objectInput.readUTF();

		donViId = objectInput.readLong();
		donViIds = objectInput.readUTF();
		thongTinLienHe = objectInput.readUTF();

		trangThai = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		if (ma == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ma);
		}

		if (ten == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ten);
		}

		objectOutput.writeLong(donViId);

		if (donViIds == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(donViIds);
		}

		if (thongTinLienHe == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(thongTinLienHe);
		}

		objectOutput.writeInt(trangThai);
	}

	public long id;
	public String ma;
	public String ten;
	public long donViId;
	public String donViIds;
	public String thongTinLienHe;
	public int trangThai;

}