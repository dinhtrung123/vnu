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

package org.oep.core.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link MappingVmap}.
 * </p>
 *
 * @author manhlb
 * @see MappingVmap
 * @generated
 */
@ProviderType
public class MappingVmapWrapper
	implements MappingVmap, ModelWrapper<MappingVmap> {

	public MappingVmapWrapper(MappingVmap mappingVmap) {
		_mappingVmap = mappingVmap;
	}

	@Override
	public Class<?> getModelClass() {
		return MappingVmap.class;
	}

	@Override
	public String getModelClassName() {
		return MappingVmap.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("classpk", getClasspk());
		attributes.put("classname", getClassname());
		attributes.put("latitude", getLatitude());
		attributes.put("longitude", getLongitude());
		attributes.put("ghichu", getGhichu());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long classpk = (Long)attributes.get("classpk");

		if (classpk != null) {
			setClasspk(classpk);
		}

		String classname = (String)attributes.get("classname");

		if (classname != null) {
			setClassname(classname);
		}

		String latitude = (String)attributes.get("latitude");

		if (latitude != null) {
			setLatitude(latitude);
		}

		String longitude = (String)attributes.get("longitude");

		if (longitude != null) {
			setLongitude(longitude);
		}

		String ghichu = (String)attributes.get("ghichu");

		if (ghichu != null) {
			setGhichu(ghichu);
		}
	}

	@Override
	public Object clone() {
		return new MappingVmapWrapper((MappingVmap)_mappingVmap.clone());
	}

	@Override
	public int compareTo(MappingVmap mappingVmap) {
		return _mappingVmap.compareTo(mappingVmap);
	}

	/**
	 * Returns the classname of this mapping vmap.
	 *
	 * @return the classname of this mapping vmap
	 */
	@Override
	public String getClassname() {
		return _mappingVmap.getClassname();
	}

	/**
	 * Returns the classpk of this mapping vmap.
	 *
	 * @return the classpk of this mapping vmap
	 */
	@Override
	public long getClasspk() {
		return _mappingVmap.getClasspk();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _mappingVmap.getExpandoBridge();
	}

	/**
	 * Returns the ghichu of this mapping vmap.
	 *
	 * @return the ghichu of this mapping vmap
	 */
	@Override
	public String getGhichu() {
		return _mappingVmap.getGhichu();
	}

	/**
	 * Returns the ID of this mapping vmap.
	 *
	 * @return the ID of this mapping vmap
	 */
	@Override
	public long getId() {
		return _mappingVmap.getId();
	}

	/**
	 * Returns the latitude of this mapping vmap.
	 *
	 * @return the latitude of this mapping vmap
	 */
	@Override
	public String getLatitude() {
		return _mappingVmap.getLatitude();
	}

	/**
	 * Returns the longitude of this mapping vmap.
	 *
	 * @return the longitude of this mapping vmap
	 */
	@Override
	public String getLongitude() {
		return _mappingVmap.getLongitude();
	}

	/**
	 * Returns the primary key of this mapping vmap.
	 *
	 * @return the primary key of this mapping vmap
	 */
	@Override
	public long getPrimaryKey() {
		return _mappingVmap.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _mappingVmap.getPrimaryKeyObj();
	}

	@Override
	public int hashCode() {
		return _mappingVmap.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _mappingVmap.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _mappingVmap.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _mappingVmap.isNew();
	}

	@Override
	public void persist() {
		_mappingVmap.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_mappingVmap.setCachedModel(cachedModel);
	}

	/**
	 * Sets the classname of this mapping vmap.
	 *
	 * @param classname the classname of this mapping vmap
	 */
	@Override
	public void setClassname(String classname) {
		_mappingVmap.setClassname(classname);
	}

	/**
	 * Sets the classpk of this mapping vmap.
	 *
	 * @param classpk the classpk of this mapping vmap
	 */
	@Override
	public void setClasspk(long classpk) {
		_mappingVmap.setClasspk(classpk);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_mappingVmap.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_mappingVmap.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_mappingVmap.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the ghichu of this mapping vmap.
	 *
	 * @param ghichu the ghichu of this mapping vmap
	 */
	@Override
	public void setGhichu(String ghichu) {
		_mappingVmap.setGhichu(ghichu);
	}

	/**
	 * Sets the ID of this mapping vmap.
	 *
	 * @param id the ID of this mapping vmap
	 */
	@Override
	public void setId(long id) {
		_mappingVmap.setId(id);
	}

	/**
	 * Sets the latitude of this mapping vmap.
	 *
	 * @param latitude the latitude of this mapping vmap
	 */
	@Override
	public void setLatitude(String latitude) {
		_mappingVmap.setLatitude(latitude);
	}

	/**
	 * Sets the longitude of this mapping vmap.
	 *
	 * @param longitude the longitude of this mapping vmap
	 */
	@Override
	public void setLongitude(String longitude) {
		_mappingVmap.setLongitude(longitude);
	}

	@Override
	public void setNew(boolean n) {
		_mappingVmap.setNew(n);
	}

	/**
	 * Sets the primary key of this mapping vmap.
	 *
	 * @param primaryKey the primary key of this mapping vmap
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_mappingVmap.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_mappingVmap.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<MappingVmap>
		toCacheModel() {

		return _mappingVmap.toCacheModel();
	}

	@Override
	public MappingVmap toEscapedModel() {
		return new MappingVmapWrapper(_mappingVmap.toEscapedModel());
	}

	@Override
	public String toString() {
		return _mappingVmap.toString();
	}

	@Override
	public MappingVmap toUnescapedModel() {
		return new MappingVmapWrapper(_mappingVmap.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _mappingVmap.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MappingVmapWrapper)) {
			return false;
		}

		MappingVmapWrapper mappingVmapWrapper = (MappingVmapWrapper)obj;

		if (Objects.equals(_mappingVmap, mappingVmapWrapper._mappingVmap)) {
			return true;
		}

		return false;
	}

	@Override
	public MappingVmap getWrappedModel() {
		return _mappingVmap;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _mappingVmap.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _mappingVmap.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_mappingVmap.resetOriginalValues();
	}

	private final MappingVmap _mappingVmap;

}