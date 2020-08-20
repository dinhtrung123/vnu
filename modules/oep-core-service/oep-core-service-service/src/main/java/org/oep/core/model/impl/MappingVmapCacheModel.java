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

import org.oep.core.model.MappingVmap;

/**
 * The cache model class for representing MappingVmap in entity cache.
 *
 * @author manhlb
 * @generated
 */
@ProviderType
public class MappingVmapCacheModel
	implements CacheModel<MappingVmap>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MappingVmapCacheModel)) {
			return false;
		}

		MappingVmapCacheModel mappingVmapCacheModel =
			(MappingVmapCacheModel)obj;

		if (id == mappingVmapCacheModel.id) {
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
		StringBundler sb = new StringBundler(13);

		sb.append("{id=");
		sb.append(id);
		sb.append(", classpk=");
		sb.append(classpk);
		sb.append(", classname=");
		sb.append(classname);
		sb.append(", latitude=");
		sb.append(latitude);
		sb.append(", longitude=");
		sb.append(longitude);
		sb.append(", ghichu=");
		sb.append(ghichu);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MappingVmap toEntityModel() {
		MappingVmapImpl mappingVmapImpl = new MappingVmapImpl();

		mappingVmapImpl.setId(id);
		mappingVmapImpl.setClasspk(classpk);

		if (classname == null) {
			mappingVmapImpl.setClassname("");
		}
		else {
			mappingVmapImpl.setClassname(classname);
		}

		if (latitude == null) {
			mappingVmapImpl.setLatitude("");
		}
		else {
			mappingVmapImpl.setLatitude(latitude);
		}

		if (longitude == null) {
			mappingVmapImpl.setLongitude("");
		}
		else {
			mappingVmapImpl.setLongitude(longitude);
		}

		if (ghichu == null) {
			mappingVmapImpl.setGhichu("");
		}
		else {
			mappingVmapImpl.setGhichu(ghichu);
		}

		mappingVmapImpl.resetOriginalValues();

		return mappingVmapImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		classpk = objectInput.readLong();
		classname = objectInput.readUTF();
		latitude = objectInput.readUTF();
		longitude = objectInput.readUTF();
		ghichu = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(classpk);

		if (classname == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(classname);
		}

		if (latitude == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(latitude);
		}

		if (longitude == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(longitude);
		}

		if (ghichu == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ghichu);
		}
	}

	public long id;
	public long classpk;
	public String classname;
	public String latitude;
	public String longitude;
	public String ghichu;

}