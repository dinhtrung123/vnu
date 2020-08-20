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

package org.oep.danhmuc.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.oep.danhmuc.model.DanhMuc;

/**
 * The cache model class for representing DanhMuc in entity cache.
 *
 * @author nhanvienDTT
 * @generated
 */
@ProviderType
public class DanhMucCacheModel implements CacheModel<DanhMuc>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DanhMucCacheModel)) {
			return false;
		}

		DanhMucCacheModel danhMucCacheModel = (DanhMucCacheModel)obj;

		if (id == danhMucCacheModel.id) {
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
		sb.append(", nhomId=");
		sb.append(nhomId);
		sb.append(", ma=");
		sb.append(ma);
		sb.append(", ten=");
		sb.append(ten);
		sb.append(", moTa=");
		sb.append(moTa);
		sb.append(", muc=");
		sb.append(muc);
		sb.append(", chaId=");
		sb.append(chaId);
		sb.append(", thuTuHienThi=");
		sb.append(thuTuHienThi);
		sb.append(", maGiaPha=");
		sb.append(maGiaPha);
		sb.append(", trangThai=");
		sb.append(trangThai);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DanhMuc toEntityModel() {
		DanhMucImpl danhMucImpl = new DanhMucImpl();

		danhMucImpl.setId(id);
		danhMucImpl.setNhomId(nhomId);

		if (ma == null) {
			danhMucImpl.setMa("");
		}
		else {
			danhMucImpl.setMa(ma);
		}

		if (ten == null) {
			danhMucImpl.setTen("");
		}
		else {
			danhMucImpl.setTen(ten);
		}

		if (moTa == null) {
			danhMucImpl.setMoTa("");
		}
		else {
			danhMucImpl.setMoTa(moTa);
		}

		danhMucImpl.setMuc(muc);
		danhMucImpl.setChaId(chaId);
		danhMucImpl.setThuTuHienThi(thuTuHienThi);

		if (maGiaPha == null) {
			danhMucImpl.setMaGiaPha("");
		}
		else {
			danhMucImpl.setMaGiaPha(maGiaPha);
		}

		danhMucImpl.setTrangThai(trangThai);

		danhMucImpl.resetOriginalValues();

		return danhMucImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		nhomId = objectInput.readLong();
		ma = objectInput.readUTF();
		ten = objectInput.readUTF();
		moTa = objectInput.readUTF();

		muc = objectInput.readInt();

		chaId = objectInput.readLong();

		thuTuHienThi = objectInput.readInt();
		maGiaPha = objectInput.readUTF();

		trangThai = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(nhomId);

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

		if (moTa == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(moTa);
		}

		objectOutput.writeInt(muc);

		objectOutput.writeLong(chaId);

		objectOutput.writeInt(thuTuHienThi);

		if (maGiaPha == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(maGiaPha);
		}

		objectOutput.writeBoolean(trangThai);
	}

	public long id;
	public long nhomId;
	public String ma;
	public String ten;
	public String moTa;
	public int muc;
	public long chaId;
	public int thuTuHienThi;
	public String maGiaPha;
	public boolean trangThai;

}