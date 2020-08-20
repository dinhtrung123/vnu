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
 * This class is a wrapper for {@link PhanQuyen}.
 * </p>
 *
 * @author manhlb
 * @see PhanQuyen
 * @generated
 */
@ProviderType
public class PhanQuyenWrapper implements PhanQuyen, ModelWrapper<PhanQuyen> {

	public PhanQuyenWrapper(PhanQuyen phanQuyen) {
		_phanQuyen = phanQuyen;
	}

	@Override
	public Class<?> getModelClass() {
		return PhanQuyen.class;
	}

	@Override
	public String getModelClassName() {
		return PhanQuyen.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("classname", getClassname());
		attributes.put("classpk", getClasspk());
		attributes.put("giatri", getGiatri());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String classname = (String)attributes.get("classname");

		if (classname != null) {
			setClassname(classname);
		}

		Long classpk = (Long)attributes.get("classpk");

		if (classpk != null) {
			setClasspk(classpk);
		}

		String giatri = (String)attributes.get("giatri");

		if (giatri != null) {
			setGiatri(giatri);
		}
	}

	@Override
	public Object clone() {
		return new PhanQuyenWrapper((PhanQuyen)_phanQuyen.clone());
	}

	@Override
	public int compareTo(PhanQuyen phanQuyen) {
		return _phanQuyen.compareTo(phanQuyen);
	}

	/**
	 * Returns the classname of this phan quyen.
	 *
	 * @return the classname of this phan quyen
	 */
	@Override
	public String getClassname() {
		return _phanQuyen.getClassname();
	}

	/**
	 * Returns the classpk of this phan quyen.
	 *
	 * @return the classpk of this phan quyen
	 */
	@Override
	public long getClasspk() {
		return _phanQuyen.getClasspk();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _phanQuyen.getExpandoBridge();
	}

	/**
	 * Returns the giatri of this phan quyen.
	 *
	 * @return the giatri of this phan quyen
	 */
	@Override
	public String getGiatri() {
		return _phanQuyen.getGiatri();
	}

	/**
	 * Returns the ID of this phan quyen.
	 *
	 * @return the ID of this phan quyen
	 */
	@Override
	public long getId() {
		return _phanQuyen.getId();
	}

	/**
	 * Returns the primary key of this phan quyen.
	 *
	 * @return the primary key of this phan quyen
	 */
	@Override
	public long getPrimaryKey() {
		return _phanQuyen.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _phanQuyen.getPrimaryKeyObj();
	}

	@Override
	public int hashCode() {
		return _phanQuyen.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _phanQuyen.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _phanQuyen.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _phanQuyen.isNew();
	}

	@Override
	public void persist() {
		_phanQuyen.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_phanQuyen.setCachedModel(cachedModel);
	}

	/**
	 * Sets the classname of this phan quyen.
	 *
	 * @param classname the classname of this phan quyen
	 */
	@Override
	public void setClassname(String classname) {
		_phanQuyen.setClassname(classname);
	}

	/**
	 * Sets the classpk of this phan quyen.
	 *
	 * @param classpk the classpk of this phan quyen
	 */
	@Override
	public void setClasspk(long classpk) {
		_phanQuyen.setClasspk(classpk);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_phanQuyen.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_phanQuyen.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_phanQuyen.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the giatri of this phan quyen.
	 *
	 * @param giatri the giatri of this phan quyen
	 */
	@Override
	public void setGiatri(String giatri) {
		_phanQuyen.setGiatri(giatri);
	}

	/**
	 * Sets the ID of this phan quyen.
	 *
	 * @param id the ID of this phan quyen
	 */
	@Override
	public void setId(long id) {
		_phanQuyen.setId(id);
	}

	@Override
	public void setNew(boolean n) {
		_phanQuyen.setNew(n);
	}

	/**
	 * Sets the primary key of this phan quyen.
	 *
	 * @param primaryKey the primary key of this phan quyen
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_phanQuyen.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_phanQuyen.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<PhanQuyen>
		toCacheModel() {

		return _phanQuyen.toCacheModel();
	}

	@Override
	public PhanQuyen toEscapedModel() {
		return new PhanQuyenWrapper(_phanQuyen.toEscapedModel());
	}

	@Override
	public String toString() {
		return _phanQuyen.toString();
	}

	@Override
	public PhanQuyen toUnescapedModel() {
		return new PhanQuyenWrapper(_phanQuyen.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _phanQuyen.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PhanQuyenWrapper)) {
			return false;
		}

		PhanQuyenWrapper phanQuyenWrapper = (PhanQuyenWrapper)obj;

		if (Objects.equals(_phanQuyen, phanQuyenWrapper._phanQuyen)) {
			return true;
		}

		return false;
	}

	@Override
	public PhanQuyen getWrappedModel() {
		return _phanQuyen;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _phanQuyen.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _phanQuyen.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_phanQuyen.resetOriginalValues();
	}

	private final PhanQuyen _phanQuyen;

}