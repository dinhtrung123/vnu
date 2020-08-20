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
 * This class is a wrapper for {@link TrungTamHanhChinh}.
 * </p>
 *
 * @author manhlb
 * @see TrungTamHanhChinh
 * @generated
 */
@ProviderType
public class TrungTamHanhChinhWrapper
	implements TrungTamHanhChinh, ModelWrapper<TrungTamHanhChinh> {

	public TrungTamHanhChinhWrapper(TrungTamHanhChinh trungTamHanhChinh) {
		_trungTamHanhChinh = trungTamHanhChinh;
	}

	@Override
	public Class<?> getModelClass() {
		return TrungTamHanhChinh.class;
	}

	@Override
	public String getModelClassName() {
		return TrungTamHanhChinh.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("ma", getMa());
		attributes.put("ten", getTen());
		attributes.put("donViId", getDonViId());
		attributes.put("donViIds", getDonViIds());
		attributes.put("thongTinLienHe", getThongTinLienHe());
		attributes.put("trangThai", getTrangThai());

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

		Long donViId = (Long)attributes.get("donViId");

		if (donViId != null) {
			setDonViId(donViId);
		}

		String donViIds = (String)attributes.get("donViIds");

		if (donViIds != null) {
			setDonViIds(donViIds);
		}

		String thongTinLienHe = (String)attributes.get("thongTinLienHe");

		if (thongTinLienHe != null) {
			setThongTinLienHe(thongTinLienHe);
		}

		Integer trangThai = (Integer)attributes.get("trangThai");

		if (trangThai != null) {
			setTrangThai(trangThai);
		}
	}

	@Override
	public Object clone() {
		return new TrungTamHanhChinhWrapper(
			(TrungTamHanhChinh)_trungTamHanhChinh.clone());
	}

	@Override
	public int compareTo(TrungTamHanhChinh trungTamHanhChinh) {
		return _trungTamHanhChinh.compareTo(trungTamHanhChinh);
	}

	/**
	 * Returns the don vi ID of this trung tam hanh chinh.
	 *
	 * @return the don vi ID of this trung tam hanh chinh
	 */
	@Override
	public long getDonViId() {
		return _trungTamHanhChinh.getDonViId();
	}

	/**
	 * Returns the don vi IDs of this trung tam hanh chinh.
	 *
	 * @return the don vi IDs of this trung tam hanh chinh
	 */
	@Override
	public String getDonViIds() {
		return _trungTamHanhChinh.getDonViIds();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _trungTamHanhChinh.getExpandoBridge();
	}

	/**
	 * Returns the ID of this trung tam hanh chinh.
	 *
	 * @return the ID of this trung tam hanh chinh
	 */
	@Override
	public long getId() {
		return _trungTamHanhChinh.getId();
	}

	/**
	 * Returns the ma of this trung tam hanh chinh.
	 *
	 * @return the ma of this trung tam hanh chinh
	 */
	@Override
	public String getMa() {
		return _trungTamHanhChinh.getMa();
	}

	/**
	 * Returns the primary key of this trung tam hanh chinh.
	 *
	 * @return the primary key of this trung tam hanh chinh
	 */
	@Override
	public long getPrimaryKey() {
		return _trungTamHanhChinh.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _trungTamHanhChinh.getPrimaryKeyObj();
	}

	/**
	 * Returns the ten of this trung tam hanh chinh.
	 *
	 * @return the ten of this trung tam hanh chinh
	 */
	@Override
	public String getTen() {
		return _trungTamHanhChinh.getTen();
	}

	/**
	 * Returns the thong tin lien he of this trung tam hanh chinh.
	 *
	 * @return the thong tin lien he of this trung tam hanh chinh
	 */
	@Override
	public String getThongTinLienHe() {
		return _trungTamHanhChinh.getThongTinLienHe();
	}

	/**
	 * Returns the trang thai of this trung tam hanh chinh.
	 *
	 * @return the trang thai of this trung tam hanh chinh
	 */
	@Override
	public int getTrangThai() {
		return _trungTamHanhChinh.getTrangThai();
	}

	@Override
	public int hashCode() {
		return _trungTamHanhChinh.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _trungTamHanhChinh.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _trungTamHanhChinh.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _trungTamHanhChinh.isNew();
	}

	@Override
	public void persist() {
		_trungTamHanhChinh.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_trungTamHanhChinh.setCachedModel(cachedModel);
	}

	/**
	 * Sets the don vi ID of this trung tam hanh chinh.
	 *
	 * @param donViId the don vi ID of this trung tam hanh chinh
	 */
	@Override
	public void setDonViId(long donViId) {
		_trungTamHanhChinh.setDonViId(donViId);
	}

	/**
	 * Sets the don vi IDs of this trung tam hanh chinh.
	 *
	 * @param donViIds the don vi IDs of this trung tam hanh chinh
	 */
	@Override
	public void setDonViIds(String donViIds) {
		_trungTamHanhChinh.setDonViIds(donViIds);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_trungTamHanhChinh.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_trungTamHanhChinh.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_trungTamHanhChinh.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the ID of this trung tam hanh chinh.
	 *
	 * @param id the ID of this trung tam hanh chinh
	 */
	@Override
	public void setId(long id) {
		_trungTamHanhChinh.setId(id);
	}

	/**
	 * Sets the ma of this trung tam hanh chinh.
	 *
	 * @param ma the ma of this trung tam hanh chinh
	 */
	@Override
	public void setMa(String ma) {
		_trungTamHanhChinh.setMa(ma);
	}

	@Override
	public void setNew(boolean n) {
		_trungTamHanhChinh.setNew(n);
	}

	/**
	 * Sets the primary key of this trung tam hanh chinh.
	 *
	 * @param primaryKey the primary key of this trung tam hanh chinh
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_trungTamHanhChinh.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_trungTamHanhChinh.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the ten of this trung tam hanh chinh.
	 *
	 * @param ten the ten of this trung tam hanh chinh
	 */
	@Override
	public void setTen(String ten) {
		_trungTamHanhChinh.setTen(ten);
	}

	/**
	 * Sets the thong tin lien he of this trung tam hanh chinh.
	 *
	 * @param thongTinLienHe the thong tin lien he of this trung tam hanh chinh
	 */
	@Override
	public void setThongTinLienHe(String thongTinLienHe) {
		_trungTamHanhChinh.setThongTinLienHe(thongTinLienHe);
	}

	/**
	 * Sets the trang thai of this trung tam hanh chinh.
	 *
	 * @param trangThai the trang thai of this trung tam hanh chinh
	 */
	@Override
	public void setTrangThai(int trangThai) {
		_trungTamHanhChinh.setTrangThai(trangThai);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<TrungTamHanhChinh>
		toCacheModel() {

		return _trungTamHanhChinh.toCacheModel();
	}

	@Override
	public TrungTamHanhChinh toEscapedModel() {
		return new TrungTamHanhChinhWrapper(
			_trungTamHanhChinh.toEscapedModel());
	}

	@Override
	public String toString() {
		return _trungTamHanhChinh.toString();
	}

	@Override
	public TrungTamHanhChinh toUnescapedModel() {
		return new TrungTamHanhChinhWrapper(
			_trungTamHanhChinh.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _trungTamHanhChinh.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TrungTamHanhChinhWrapper)) {
			return false;
		}

		TrungTamHanhChinhWrapper trungTamHanhChinhWrapper =
			(TrungTamHanhChinhWrapper)obj;

		if (Objects.equals(
				_trungTamHanhChinh,
				trungTamHanhChinhWrapper._trungTamHanhChinh)) {

			return true;
		}

		return false;
	}

	@Override
	public TrungTamHanhChinh getWrappedModel() {
		return _trungTamHanhChinh;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _trungTamHanhChinh.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _trungTamHanhChinh.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_trungTamHanhChinh.resetOriginalValues();
	}

	private final TrungTamHanhChinh _trungTamHanhChinh;

}