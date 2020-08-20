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

package org.oep.danhmuc.model;

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
 * This class is a wrapper for {@link DanhMuc}.
 * </p>
 *
 * @author nhanvienDTT
 * @see DanhMuc
 * @generated
 */
@ProviderType
public class DanhMucWrapper implements DanhMuc, ModelWrapper<DanhMuc> {

	public DanhMucWrapper(DanhMuc danhMuc) {
		_danhMuc = danhMuc;
	}

	@Override
	public Class<?> getModelClass() {
		return DanhMuc.class;
	}

	@Override
	public String getModelClassName() {
		return DanhMuc.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("nhomId", getNhomId());
		attributes.put("ma", getMa());
		attributes.put("ten", getTen());
		attributes.put("moTa", getMoTa());
		attributes.put("muc", getMuc());
		attributes.put("chaId", getChaId());
		attributes.put("thuTuHienThi", getThuTuHienThi());
		attributes.put("maGiaPha", getMaGiaPha());
		attributes.put("trangThai", isTrangThai());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long nhomId = (Long)attributes.get("nhomId");

		if (nhomId != null) {
			setNhomId(nhomId);
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

		Integer muc = (Integer)attributes.get("muc");

		if (muc != null) {
			setMuc(muc);
		}

		Long chaId = (Long)attributes.get("chaId");

		if (chaId != null) {
			setChaId(chaId);
		}

		Integer thuTuHienThi = (Integer)attributes.get("thuTuHienThi");

		if (thuTuHienThi != null) {
			setThuTuHienThi(thuTuHienThi);
		}

		String maGiaPha = (String)attributes.get("maGiaPha");

		if (maGiaPha != null) {
			setMaGiaPha(maGiaPha);
		}

		Boolean trangThai = (Boolean)attributes.get("trangThai");

		if (trangThai != null) {
			setTrangThai(trangThai);
		}
	}

	@Override
	public Object clone() {
		return new DanhMucWrapper((DanhMuc)_danhMuc.clone());
	}

	@Override
	public int compareTo(DanhMuc danhMuc) {
		return _danhMuc.compareTo(danhMuc);
	}

	/**
	 * Returns the cha ID of this danh muc.
	 *
	 * @return the cha ID of this danh muc
	 */
	@Override
	public long getChaId() {
		return _danhMuc.getChaId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _danhMuc.getExpandoBridge();
	}

	/**
	 * Returns the ID of this danh muc.
	 *
	 * @return the ID of this danh muc
	 */
	@Override
	public long getId() {
		return _danhMuc.getId();
	}

	/**
	 * Returns the ma of this danh muc.
	 *
	 * @return the ma of this danh muc
	 */
	@Override
	public String getMa() {
		return _danhMuc.getMa();
	}

	/**
	 * Returns the ma gia pha of this danh muc.
	 *
	 * @return the ma gia pha of this danh muc
	 */
	@Override
	public String getMaGiaPha() {
		return _danhMuc.getMaGiaPha();
	}

	/**
	 * Returns the mo ta of this danh muc.
	 *
	 * @return the mo ta of this danh muc
	 */
	@Override
	public String getMoTa() {
		return _danhMuc.getMoTa();
	}

	/**
	 * Returns the muc of this danh muc.
	 *
	 * @return the muc of this danh muc
	 */
	@Override
	public int getMuc() {
		return _danhMuc.getMuc();
	}

	/**
	 * Returns the nhom ID of this danh muc.
	 *
	 * @return the nhom ID of this danh muc
	 */
	@Override
	public long getNhomId() {
		return _danhMuc.getNhomId();
	}

	/**
	 * Returns the primary key of this danh muc.
	 *
	 * @return the primary key of this danh muc
	 */
	@Override
	public long getPrimaryKey() {
		return _danhMuc.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _danhMuc.getPrimaryKeyObj();
	}

	/**
	 * Returns the ten of this danh muc.
	 *
	 * @return the ten of this danh muc
	 */
	@Override
	public String getTen() {
		return _danhMuc.getTen();
	}

	/**
	 * Returns the thu tu hien thi of this danh muc.
	 *
	 * @return the thu tu hien thi of this danh muc
	 */
	@Override
	public int getThuTuHienThi() {
		return _danhMuc.getThuTuHienThi();
	}

	/**
	 * Returns the trang thai of this danh muc.
	 *
	 * @return the trang thai of this danh muc
	 */
	@Override
	public boolean getTrangThai() {
		return _danhMuc.getTrangThai();
	}

	@Override
	public int hashCode() {
		return _danhMuc.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _danhMuc.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _danhMuc.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _danhMuc.isNew();
	}

	/**
	 * Returns <code>true</code> if this danh muc is trang thai.
	 *
	 * @return <code>true</code> if this danh muc is trang thai; <code>false</code> otherwise
	 */
	@Override
	public boolean isTrangThai() {
		return _danhMuc.isTrangThai();
	}

	@Override
	public void persist() {
		_danhMuc.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_danhMuc.setCachedModel(cachedModel);
	}

	/**
	 * Sets the cha ID of this danh muc.
	 *
	 * @param chaId the cha ID of this danh muc
	 */
	@Override
	public void setChaId(long chaId) {
		_danhMuc.setChaId(chaId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_danhMuc.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_danhMuc.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_danhMuc.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the ID of this danh muc.
	 *
	 * @param id the ID of this danh muc
	 */
	@Override
	public void setId(long id) {
		_danhMuc.setId(id);
	}

	/**
	 * Sets the ma of this danh muc.
	 *
	 * @param ma the ma of this danh muc
	 */
	@Override
	public void setMa(String ma) {
		_danhMuc.setMa(ma);
	}

	/**
	 * Sets the ma gia pha of this danh muc.
	 *
	 * @param maGiaPha the ma gia pha of this danh muc
	 */
	@Override
	public void setMaGiaPha(String maGiaPha) {
		_danhMuc.setMaGiaPha(maGiaPha);
	}

	/**
	 * Sets the mo ta of this danh muc.
	 *
	 * @param moTa the mo ta of this danh muc
	 */
	@Override
	public void setMoTa(String moTa) {
		_danhMuc.setMoTa(moTa);
	}

	/**
	 * Sets the muc of this danh muc.
	 *
	 * @param muc the muc of this danh muc
	 */
	@Override
	public void setMuc(int muc) {
		_danhMuc.setMuc(muc);
	}

	@Override
	public void setNew(boolean n) {
		_danhMuc.setNew(n);
	}

	/**
	 * Sets the nhom ID of this danh muc.
	 *
	 * @param nhomId the nhom ID of this danh muc
	 */
	@Override
	public void setNhomId(long nhomId) {
		_danhMuc.setNhomId(nhomId);
	}

	/**
	 * Sets the primary key of this danh muc.
	 *
	 * @param primaryKey the primary key of this danh muc
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_danhMuc.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_danhMuc.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the ten of this danh muc.
	 *
	 * @param ten the ten of this danh muc
	 */
	@Override
	public void setTen(String ten) {
		_danhMuc.setTen(ten);
	}

	/**
	 * Sets the thu tu hien thi of this danh muc.
	 *
	 * @param thuTuHienThi the thu tu hien thi of this danh muc
	 */
	@Override
	public void setThuTuHienThi(int thuTuHienThi) {
		_danhMuc.setThuTuHienThi(thuTuHienThi);
	}

	/**
	 * Sets whether this danh muc is trang thai.
	 *
	 * @param trangThai the trang thai of this danh muc
	 */
	@Override
	public void setTrangThai(boolean trangThai) {
		_danhMuc.setTrangThai(trangThai);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<DanhMuc> toCacheModel() {
		return _danhMuc.toCacheModel();
	}

	@Override
	public DanhMuc toEscapedModel() {
		return new DanhMucWrapper(_danhMuc.toEscapedModel());
	}

	@Override
	public String toString() {
		return _danhMuc.toString();
	}

	@Override
	public DanhMuc toUnescapedModel() {
		return new DanhMucWrapper(_danhMuc.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _danhMuc.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DanhMucWrapper)) {
			return false;
		}

		DanhMucWrapper danhMucWrapper = (DanhMucWrapper)obj;

		if (Objects.equals(_danhMuc, danhMucWrapper._danhMuc)) {
			return true;
		}

		return false;
	}

	@Override
	public DanhMuc getWrappedModel() {
		return _danhMuc;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _danhMuc.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _danhMuc.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_danhMuc.resetOriginalValues();
	}

	private final DanhMuc _danhMuc;

}