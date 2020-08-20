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

package dtt.vn.vnpost.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import dtt.vn.vnpost.model.Nhom;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Nhom in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class NhomCacheModel implements CacheModel<Nhom>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof NhomCacheModel)) {
			return false;
		}

		NhomCacheModel nhomCacheModel = (NhomCacheModel)obj;

		if (id == nhomCacheModel.id) {
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
		StringBundler sb = new StringBundler(9);

		sb.append("{id=");
		sb.append(id);
		sb.append(", ma=");
		sb.append(ma);
		sb.append(", ten=");
		sb.append(ten);
		sb.append(", mota=");
		sb.append(mota);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Nhom toEntityModel() {
		NhomImpl nhomImpl = new NhomImpl();

		nhomImpl.setId(id);

		if (ma == null) {
			nhomImpl.setMa("");
		}
		else {
			nhomImpl.setMa(ma);
		}

		if (ten == null) {
			nhomImpl.setTen("");
		}
		else {
			nhomImpl.setTen(ten);
		}

		if (mota == null) {
			nhomImpl.setMota("");
		}
		else {
			nhomImpl.setMota(mota);
		}

		nhomImpl.resetOriginalValues();

		return nhomImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		ma = objectInput.readUTF();
		ten = objectInput.readUTF();
		mota = objectInput.readUTF();
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

		if (mota == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mota);
		}
	}

	public long id;
	public String ma;
	public String ten;
	public String mota;

}