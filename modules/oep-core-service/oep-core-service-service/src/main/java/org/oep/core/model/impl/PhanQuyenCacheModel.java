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

import org.oep.core.model.PhanQuyen;

/**
 * The cache model class for representing PhanQuyen in entity cache.
 *
 * @author manhlb
 * @generated
 */
@ProviderType
public class PhanQuyenCacheModel
	implements CacheModel<PhanQuyen>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PhanQuyenCacheModel)) {
			return false;
		}

		PhanQuyenCacheModel phanQuyenCacheModel = (PhanQuyenCacheModel)obj;

		if (id == phanQuyenCacheModel.id) {
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
		sb.append(", classname=");
		sb.append(classname);
		sb.append(", classpk=");
		sb.append(classpk);
		sb.append(", giatri=");
		sb.append(giatri);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PhanQuyen toEntityModel() {
		PhanQuyenImpl phanQuyenImpl = new PhanQuyenImpl();

		phanQuyenImpl.setId(id);

		if (classname == null) {
			phanQuyenImpl.setClassname("");
		}
		else {
			phanQuyenImpl.setClassname(classname);
		}

		phanQuyenImpl.setClasspk(classpk);

		if (giatri == null) {
			phanQuyenImpl.setGiatri("");
		}
		else {
			phanQuyenImpl.setGiatri(giatri);
		}

		phanQuyenImpl.resetOriginalValues();

		return phanQuyenImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		classname = objectInput.readUTF();

		classpk = objectInput.readLong();
		giatri = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		if (classname == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(classname);
		}

		objectOutput.writeLong(classpk);

		if (giatri == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(giatri);
		}
	}

	public long id;
	public String classname;
	public long classpk;
	public String giatri;

}