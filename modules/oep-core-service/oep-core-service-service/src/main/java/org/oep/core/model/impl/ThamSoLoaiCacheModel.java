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

import org.oep.core.model.ThamSoLoai;

/**
 * The cache model class for representing ThamSoLoai in entity cache.
 *
 * @author manhlb
 * @generated
 */
@ProviderType
public class ThamSoLoaiCacheModel
	implements CacheModel<ThamSoLoai>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ThamSoLoaiCacheModel)) {
			return false;
		}

		ThamSoLoaiCacheModel thamSoLoaiCacheModel = (ThamSoLoaiCacheModel)obj;

		if (id == thamSoLoaiCacheModel.id) {
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
		sb.append(", moTa=");
		sb.append(moTa);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ThamSoLoai toEntityModel() {
		ThamSoLoaiImpl thamSoLoaiImpl = new ThamSoLoaiImpl();

		thamSoLoaiImpl.setId(id);

		if (ma == null) {
			thamSoLoaiImpl.setMa("");
		}
		else {
			thamSoLoaiImpl.setMa(ma);
		}

		if (ten == null) {
			thamSoLoaiImpl.setTen("");
		}
		else {
			thamSoLoaiImpl.setTen(ten);
		}

		if (moTa == null) {
			thamSoLoaiImpl.setMoTa("");
		}
		else {
			thamSoLoaiImpl.setMoTa(moTa);
		}

		thamSoLoaiImpl.resetOriginalValues();

		return thamSoLoaiImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		ma = objectInput.readUTF();
		ten = objectInput.readUTF();
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
	public String moTa;

}