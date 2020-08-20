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

package dtt.vn.vnpost.model;

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
 * This class is a wrapper for {@link Nhom}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Nhom
 * @generated
 */
@ProviderType
public class NhomWrapper implements Nhom, ModelWrapper<Nhom> {

	public NhomWrapper(Nhom nhom) {
		_nhom = nhom;
	}

	@Override
	public Class<?> getModelClass() {
		return Nhom.class;
	}

	@Override
	public String getModelClassName() {
		return Nhom.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("ma", getMa());
		attributes.put("ten", getTen());
		attributes.put("mota", getMota());

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

		String mota = (String)attributes.get("mota");

		if (mota != null) {
			setMota(mota);
		}
	}

	@Override
	public Object clone() {
		return new NhomWrapper((Nhom)_nhom.clone());
	}

	@Override
	public int compareTo(dtt.vn.vnpost.model.Nhom nhom) {
		return _nhom.compareTo(nhom);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _nhom.getExpandoBridge();
	}

	/**
	 * Returns the ID of this nhom.
	 *
	 * @return the ID of this nhom
	 */
	@Override
	public long getId() {
		return _nhom.getId();
	}

	/**
	 * Returns the ma of this nhom.
	 *
	 * @return the ma of this nhom
	 */
	@Override
	public String getMa() {
		return _nhom.getMa();
	}

	/**
	 * Returns the mota of this nhom.
	 *
	 * @return the mota of this nhom
	 */
	@Override
	public String getMota() {
		return _nhom.getMota();
	}

	/**
	 * Returns the primary key of this nhom.
	 *
	 * @return the primary key of this nhom
	 */
	@Override
	public long getPrimaryKey() {
		return _nhom.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _nhom.getPrimaryKeyObj();
	}

	/**
	 * Returns the ten of this nhom.
	 *
	 * @return the ten of this nhom
	 */
	@Override
	public String getTen() {
		return _nhom.getTen();
	}

	@Override
	public int hashCode() {
		return _nhom.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _nhom.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _nhom.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _nhom.isNew();
	}

	@Override
	public void persist() {
		_nhom.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_nhom.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_nhom.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_nhom.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_nhom.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the ID of this nhom.
	 *
	 * @param id the ID of this nhom
	 */
	@Override
	public void setId(long id) {
		_nhom.setId(id);
	}

	/**
	 * Sets the ma of this nhom.
	 *
	 * @param ma the ma of this nhom
	 */
	@Override
	public void setMa(String ma) {
		_nhom.setMa(ma);
	}

	/**
	 * Sets the mota of this nhom.
	 *
	 * @param mota the mota of this nhom
	 */
	@Override
	public void setMota(String mota) {
		_nhom.setMota(mota);
	}

	@Override
	public void setNew(boolean n) {
		_nhom.setNew(n);
	}

	/**
	 * Sets the primary key of this nhom.
	 *
	 * @param primaryKey the primary key of this nhom
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_nhom.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_nhom.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the ten of this nhom.
	 *
	 * @param ten the ten of this nhom
	 */
	@Override
	public void setTen(String ten) {
		_nhom.setTen(ten);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<dtt.vn.vnpost.model.Nhom>
		toCacheModel() {

		return _nhom.toCacheModel();
	}

	@Override
	public dtt.vn.vnpost.model.Nhom toEscapedModel() {
		return new NhomWrapper(_nhom.toEscapedModel());
	}

	@Override
	public String toString() {
		return _nhom.toString();
	}

	@Override
	public dtt.vn.vnpost.model.Nhom toUnescapedModel() {
		return new NhomWrapper(_nhom.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _nhom.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof NhomWrapper)) {
			return false;
		}

		NhomWrapper nhomWrapper = (NhomWrapper)obj;

		if (Objects.equals(_nhom, nhomWrapper._nhom)) {
			return true;
		}

		return false;
	}

	@Override
	public Nhom getWrappedModel() {
		return _nhom;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _nhom.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _nhom.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_nhom.resetOriginalValues();
	}

	private final Nhom _nhom;

}