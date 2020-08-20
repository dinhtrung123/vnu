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

package dtt.vn.user.service.model;

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
 * This class is a wrapper for {@link DoiTuongSuDung}.
 * </p>
 *
 * @author nhanvienDTT
 * @see DoiTuongSuDung
 * @generated
 */
@ProviderType
public class DoiTuongSuDungWrapper
	implements DoiTuongSuDung, ModelWrapper<DoiTuongSuDung> {

	public DoiTuongSuDungWrapper(DoiTuongSuDung doiTuongSuDung) {
		_doiTuongSuDung = doiTuongSuDung;
	}

	@Override
	public Class<?> getModelClass() {
		return DoiTuongSuDung.class;
	}

	@Override
	public String getModelClassName() {
		return DoiTuongSuDung.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("ma", getMa());
		attributes.put("ten", getTen());
		attributes.put("loai", getLoai());
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

		Integer loai = (Integer)attributes.get("loai");

		if (loai != null) {
			setLoai(loai);
		}

		String moTa = (String)attributes.get("moTa");

		if (moTa != null) {
			setMoTa(moTa);
		}
	}

	@Override
	public Object clone() {
		return new DoiTuongSuDungWrapper(
			(DoiTuongSuDung)_doiTuongSuDung.clone());
	}

	@Override
	public int compareTo(
		dtt.vn.user.service.model.DoiTuongSuDung doiTuongSuDung) {

		return _doiTuongSuDung.compareTo(doiTuongSuDung);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _doiTuongSuDung.getExpandoBridge();
	}

	/**
	 * Returns the ID of this doi tuong su dung.
	 *
	 * @return the ID of this doi tuong su dung
	 */
	@Override
	public long getId() {
		return _doiTuongSuDung.getId();
	}

	/**
	 * Returns the loai of this doi tuong su dung.
	 *
	 * @return the loai of this doi tuong su dung
	 */
	@Override
	public int getLoai() {
		return _doiTuongSuDung.getLoai();
	}

	/**
	 * Returns the ma of this doi tuong su dung.
	 *
	 * @return the ma of this doi tuong su dung
	 */
	@Override
	public String getMa() {
		return _doiTuongSuDung.getMa();
	}

	/**
	 * Returns the mo ta of this doi tuong su dung.
	 *
	 * @return the mo ta of this doi tuong su dung
	 */
	@Override
	public String getMoTa() {
		return _doiTuongSuDung.getMoTa();
	}

	/**
	 * Returns the primary key of this doi tuong su dung.
	 *
	 * @return the primary key of this doi tuong su dung
	 */
	@Override
	public long getPrimaryKey() {
		return _doiTuongSuDung.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _doiTuongSuDung.getPrimaryKeyObj();
	}

	/**
	 * Returns the ten of this doi tuong su dung.
	 *
	 * @return the ten of this doi tuong su dung
	 */
	@Override
	public String getTen() {
		return _doiTuongSuDung.getTen();
	}

	@Override
	public int hashCode() {
		return _doiTuongSuDung.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _doiTuongSuDung.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _doiTuongSuDung.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _doiTuongSuDung.isNew();
	}

	@Override
	public void persist() {
		_doiTuongSuDung.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_doiTuongSuDung.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_doiTuongSuDung.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_doiTuongSuDung.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_doiTuongSuDung.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the ID of this doi tuong su dung.
	 *
	 * @param id the ID of this doi tuong su dung
	 */
	@Override
	public void setId(long id) {
		_doiTuongSuDung.setId(id);
	}

	/**
	 * Sets the loai of this doi tuong su dung.
	 *
	 * @param loai the loai of this doi tuong su dung
	 */
	@Override
	public void setLoai(int loai) {
		_doiTuongSuDung.setLoai(loai);
	}

	/**
	 * Sets the ma of this doi tuong su dung.
	 *
	 * @param ma the ma of this doi tuong su dung
	 */
	@Override
	public void setMa(String ma) {
		_doiTuongSuDung.setMa(ma);
	}

	/**
	 * Sets the mo ta of this doi tuong su dung.
	 *
	 * @param moTa the mo ta of this doi tuong su dung
	 */
	@Override
	public void setMoTa(String moTa) {
		_doiTuongSuDung.setMoTa(moTa);
	}

	@Override
	public void setNew(boolean n) {
		_doiTuongSuDung.setNew(n);
	}

	/**
	 * Sets the primary key of this doi tuong su dung.
	 *
	 * @param primaryKey the primary key of this doi tuong su dung
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_doiTuongSuDung.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_doiTuongSuDung.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the ten of this doi tuong su dung.
	 *
	 * @param ten the ten of this doi tuong su dung
	 */
	@Override
	public void setTen(String ten) {
		_doiTuongSuDung.setTen(ten);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<dtt.vn.user.service.model.DoiTuongSuDung> toCacheModel() {

		return _doiTuongSuDung.toCacheModel();
	}

	@Override
	public dtt.vn.user.service.model.DoiTuongSuDung toEscapedModel() {
		return new DoiTuongSuDungWrapper(_doiTuongSuDung.toEscapedModel());
	}

	@Override
	public String toString() {
		return _doiTuongSuDung.toString();
	}

	@Override
	public dtt.vn.user.service.model.DoiTuongSuDung toUnescapedModel() {
		return new DoiTuongSuDungWrapper(_doiTuongSuDung.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _doiTuongSuDung.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DoiTuongSuDungWrapper)) {
			return false;
		}

		DoiTuongSuDungWrapper doiTuongSuDungWrapper =
			(DoiTuongSuDungWrapper)obj;

		if (Objects.equals(
				_doiTuongSuDung, doiTuongSuDungWrapper._doiTuongSuDung)) {

			return true;
		}

		return false;
	}

	@Override
	public DoiTuongSuDung getWrappedModel() {
		return _doiTuongSuDung;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _doiTuongSuDung.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _doiTuongSuDung.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_doiTuongSuDung.resetOriginalValues();
	}

	private final DoiTuongSuDung _doiTuongSuDung;

}