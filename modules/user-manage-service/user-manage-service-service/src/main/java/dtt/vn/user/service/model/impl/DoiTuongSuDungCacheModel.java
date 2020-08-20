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

import dtt.vn.user.service.model.DoiTuongSuDung;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing DoiTuongSuDung in entity cache.
 *
 * @author nhanvienDTT
 * @generated
 */
@ProviderType
public class DoiTuongSuDungCacheModel
	implements CacheModel<DoiTuongSuDung>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DoiTuongSuDungCacheModel)) {
			return false;
		}

		DoiTuongSuDungCacheModel doiTuongSuDungCacheModel =
			(DoiTuongSuDungCacheModel)obj;

		if (id == doiTuongSuDungCacheModel.id) {
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
		sb.append(", ma=");
		sb.append(ma);
		sb.append(", ten=");
		sb.append(ten);
		sb.append(", loai=");
		sb.append(loai);
		sb.append(", moTa=");
		sb.append(moTa);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DoiTuongSuDung toEntityModel() {
		DoiTuongSuDungImpl doiTuongSuDungImpl = new DoiTuongSuDungImpl();

		doiTuongSuDungImpl.setId(id);

		if (ma == null) {
			doiTuongSuDungImpl.setMa("");
		}
		else {
			doiTuongSuDungImpl.setMa(ma);
		}

		if (ten == null) {
			doiTuongSuDungImpl.setTen("");
		}
		else {
			doiTuongSuDungImpl.setTen(ten);
		}

		doiTuongSuDungImpl.setLoai(loai);

		if (moTa == null) {
			doiTuongSuDungImpl.setMoTa("");
		}
		else {
			doiTuongSuDungImpl.setMoTa(moTa);
		}

		doiTuongSuDungImpl.resetOriginalValues();

		return doiTuongSuDungImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		ma = objectInput.readUTF();
		ten = objectInput.readUTF();

		loai = objectInput.readInt();
		moTa = objectInput.readUTF();
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

		objectOutput.writeInt(loai);

		if (moTa == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(moTa);
		}
	}

	public long id;
	public String ma;
	public String ten;
	public int loai;
	public String moTa;

}