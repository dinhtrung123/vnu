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
 * This class is a wrapper for {@link ThamSoLoai}.
 * </p>
 *
 * @author manhlb
 * @see ThamSoLoai
 * @generated
 */
@ProviderType
public class ThamSoLoaiWrapper implements ThamSoLoai, ModelWrapper<ThamSoLoai> {

	public ThamSoLoaiWrapper(ThamSoLoai thamSoLoai) {
		_thamSoLoai = thamSoLoai;
	}

	@Override
	public Class<?> getModelClass() {
		return ThamSoLoai.class;
	}

	@Override
	public String getModelClassName() {
		return ThamSoLoai.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("ma", getMa());
		attributes.put("ten", getTen());
		attributes.put("moTa", getMoTa());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String ma = (String)attributes.get("ma");

		if (ma != null) {
			setMa(ma);
		}

		String ten = (String)attributes.get("ten");

		if (ten != null) {
			setTen(ten);
		}

		String moTa = (String)attributes.get("moTa");

		if (moTa != null) {
			setMoTa(moTa);
		}
	}

	@Override
	public Object clone() {
		return new ThamSoLoaiWrapper((ThamSoLoai)_thamSoLoai.clone());
	}

	@Override
	public int compareTo(ThamSoLoai thamSoLoai) {
		return _thamSoLoai.compareTo(thamSoLoai);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _thamSoLoai.getExpandoBridge();
	}

	/**
	 * Returns the ID of this tham so loai.
	 *
	 * @return the ID of this tham so loai
	 */
	@Override
	public long getId() {
		return _thamSoLoai.getId();
	}

	/**
	 * Returns the ma of this tham so loai.
	 *
	 * @return the ma of this tham so loai
	 */
	@Override
	public String getMa() {
		return _thamSoLoai.getMa();
	}

	/**
	 * Returns the mo ta of this tham so loai.
	 *
	 * @return the mo ta of this tham so loai
	 */
	@Override
	public String getMoTa() {
		return _thamSoLoai.getMoTa();
	}

	/**
	 * Returns the primary key of this tham so loai.
	 *
	 * @return the primary key of this tham so loai
	 */
	@Override
	public long getPrimaryKey() {
		return _thamSoLoai.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _thamSoLoai.getPrimaryKeyObj();
	}

	/**
	 * Returns the ten of this tham so loai.
	 *
	 * @return the ten of this tham so loai
	 */
	@Override
	public String getTen() {
		return _thamSoLoai.getTen();
	}

	@Override
	public int hashCode() {
		return _thamSoLoai.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _thamSoLoai.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _thamSoLoai.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _thamSoLoai.isNew();
	}

	@Override
	public void persist() {
		_thamSoLoai.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_thamSoLoai.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_thamSoLoai.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_thamSoLoai.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_thamSoLoai.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the ID of this tham so loai.
	 *
	 * @param id the ID of this tham so loai
	 */
	@Override
	public void setId(long id) {
		_thamSoLoai.setId(id);
	}

	/**
	 * Sets the ma of this tham so loai.
	 *
	 * @param ma the ma of this tham so loai
	 */
	@Override
	public void setMa(String ma) {
		_thamSoLoai.setMa(ma);
	}

	/**
	 * Sets the mo ta of this tham so loai.
	 *
	 * @param moTa the mo ta of this tham so loai
	 */
	@Override
	public void setMoTa(String moTa) {
		_thamSoLoai.setMoTa(moTa);
	}

	@Override
	public void setNew(boolean n) {
		_thamSoLoai.setNew(n);
	}

	/**
	 * Sets the primary key of this tham so loai.
	 *
	 * @param primaryKey the primary key of this tham so loai
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_thamSoLoai.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_thamSoLoai.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the ten of this tham so loai.
	 *
	 * @param ten the ten of this tham so loai
	 */
	@Override
	public void setTen(String ten) {
		_thamSoLoai.setTen(ten);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<ThamSoLoai>
		toCacheModel() {

		return _thamSoLoai.toCacheModel();
	}

	@Override
	public ThamSoLoai toEscapedModel() {
		return new ThamSoLoaiWrapper(_thamSoLoai.toEscapedModel());
	}

	@Override
	public String toString() {
		return _thamSoLoai.toString();
	}

	@Override
	public ThamSoLoai toUnescapedModel() {
		return new ThamSoLoaiWrapper(_thamSoLoai.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _thamSoLoai.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ThamSoLoaiWrapper)) {
			return false;
		}

		ThamSoLoaiWrapper thamSoLoaiWrapper = (ThamSoLoaiWrapper)obj;

		if (Objects.equals(_thamSoLoai, thamSoLoaiWrapper._thamSoLoai)) {
			return true;
		}

		return false;
	}

	@Override
	public ThamSoLoai getWrappedModel() {
		return _thamSoLoai;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _thamSoLoai.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _thamSoLoai.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_thamSoLoai.resetOriginalValues();
	}

	private final ThamSoLoai _thamSoLoai;

}