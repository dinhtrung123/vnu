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
 * This class is a wrapper for {@link ThamSo}.
 * </p>
 *
 * @author manhlb
 * @see ThamSo
 * @generated
 */
@ProviderType
public class ThamSoWrapper implements ThamSo, ModelWrapper<ThamSo> {

	public ThamSoWrapper(ThamSo thamSo) {
		_thamSo = thamSo;
	}

	@Override
	public Class<?> getModelClass() {
		return ThamSo.class;
	}

	@Override
	public String getModelClassName() {
		return ThamSo.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("groupId", getGroupId());
		attributes.put("className", getClassName());
		attributes.put("classPK", getClassPK());
		attributes.put("loaiId", getLoaiId());
		attributes.put("ma", getMa());
		attributes.put("giaTri", getGiaTri());
		attributes.put("moTa", getMoTa());
		attributes.put("trangThai", isTrangThai());
		attributes.put("quyenTacDong", getQuyenTacDong());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String className = (String)attributes.get("className");

		if (className != null) {
			setClassName(className);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}

		Long loaiId = (Long)attributes.get("loaiId");

		if (loaiId != null) {
			setLoaiId(loaiId);
		}

		String ma = (String)attributes.get("ma");

		if (ma != null) {
			setMa(ma);
		}

		String giaTri = (String)attributes.get("giaTri");

		if (giaTri != null) {
			setGiaTri(giaTri);
		}

		String moTa = (String)attributes.get("moTa");

		if (moTa != null) {
			setMoTa(moTa);
		}

		Boolean trangThai = (Boolean)attributes.get("trangThai");

		if (trangThai != null) {
			setTrangThai(trangThai);
		}

		Integer quyenTacDong = (Integer)attributes.get("quyenTacDong");

		if (quyenTacDong != null) {
			setQuyenTacDong(quyenTacDong);
		}
	}

	@Override
	public Object clone() {
		return new ThamSoWrapper((ThamSo)_thamSo.clone());
	}

	@Override
	public int compareTo(ThamSo thamSo) {
		return _thamSo.compareTo(thamSo);
	}

	/**
	 * Returns the class name of this tham so.
	 *
	 * @return the class name of this tham so
	 */
	@Override
	public String getClassName() {
		return _thamSo.getClassName();
	}

	/**
	 * Returns the class pk of this tham so.
	 *
	 * @return the class pk of this tham so
	 */
	@Override
	public long getClassPK() {
		return _thamSo.getClassPK();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _thamSo.getExpandoBridge();
	}

	/**
	 * Returns the gia tri of this tham so.
	 *
	 * @return the gia tri of this tham so
	 */
	@Override
	public String getGiaTri() {
		return _thamSo.getGiaTri();
	}

	/**
	 * Returns the group ID of this tham so.
	 *
	 * @return the group ID of this tham so
	 */
	@Override
	public long getGroupId() {
		return _thamSo.getGroupId();
	}

	/**
	 * Returns the ID of this tham so.
	 *
	 * @return the ID of this tham so
	 */
	@Override
	public long getId() {
		return _thamSo.getId();
	}

	/**
	 * Returns the loai ID of this tham so.
	 *
	 * @return the loai ID of this tham so
	 */
	@Override
	public long getLoaiId() {
		return _thamSo.getLoaiId();
	}

	/**
	 * Returns the ma of this tham so.
	 *
	 * @return the ma of this tham so
	 */
	@Override
	public String getMa() {
		return _thamSo.getMa();
	}

	/**
	 * Returns the mo ta of this tham so.
	 *
	 * @return the mo ta of this tham so
	 */
	@Override
	public String getMoTa() {
		return _thamSo.getMoTa();
	}

	/**
	 * Returns the primary key of this tham so.
	 *
	 * @return the primary key of this tham so
	 */
	@Override
	public long getPrimaryKey() {
		return _thamSo.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _thamSo.getPrimaryKeyObj();
	}

	/**
	 * Returns the quyen tac dong of this tham so.
	 *
	 * @return the quyen tac dong of this tham so
	 */
	@Override
	public int getQuyenTacDong() {
		return _thamSo.getQuyenTacDong();
	}

	/**
	 * Returns the trang thai of this tham so.
	 *
	 * @return the trang thai of this tham so
	 */
	@Override
	public boolean getTrangThai() {
		return _thamSo.getTrangThai();
	}

	@Override
	public int hashCode() {
		return _thamSo.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _thamSo.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _thamSo.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _thamSo.isNew();
	}

	/**
	 * Returns <code>true</code> if this tham so is trang thai.
	 *
	 * @return <code>true</code> if this tham so is trang thai; <code>false</code> otherwise
	 */
	@Override
	public boolean isTrangThai() {
		return _thamSo.isTrangThai();
	}

	@Override
	public void persist() {
		_thamSo.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_thamSo.setCachedModel(cachedModel);
	}

	/**
	 * Sets the class name of this tham so.
	 *
	 * @param className the class name of this tham so
	 */
	@Override
	public void setClassName(String className) {
		_thamSo.setClassName(className);
	}

	/**
	 * Sets the class pk of this tham so.
	 *
	 * @param classPK the class pk of this tham so
	 */
	@Override
	public void setClassPK(long classPK) {
		_thamSo.setClassPK(classPK);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_thamSo.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_thamSo.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_thamSo.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the gia tri of this tham so.
	 *
	 * @param giaTri the gia tri of this tham so
	 */
	@Override
	public void setGiaTri(String giaTri) {
		_thamSo.setGiaTri(giaTri);
	}

	/**
	 * Sets the group ID of this tham so.
	 *
	 * @param groupId the group ID of this tham so
	 */
	@Override
	public void setGroupId(long groupId) {
		_thamSo.setGroupId(groupId);
	}

	/**
	 * Sets the ID of this tham so.
	 *
	 * @param id the ID of this tham so
	 */
	@Override
	public void setId(long id) {
		_thamSo.setId(id);
	}

	/**
	 * Sets the loai ID of this tham so.
	 *
	 * @param loaiId the loai ID of this tham so
	 */
	@Override
	public void setLoaiId(long loaiId) {
		_thamSo.setLoaiId(loaiId);
	}

	/**
	 * Sets the ma of this tham so.
	 *
	 * @param ma the ma of this tham so
	 */
	@Override
	public void setMa(String ma) {
		_thamSo.setMa(ma);
	}

	/**
	 * Sets the mo ta of this tham so.
	 *
	 * @param moTa the mo ta of this tham so
	 */
	@Override
	public void setMoTa(String moTa) {
		_thamSo.setMoTa(moTa);
	}

	@Override
	public void setNew(boolean n) {
		_thamSo.setNew(n);
	}

	/**
	 * Sets the primary key of this tham so.
	 *
	 * @param primaryKey the primary key of this tham so
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_thamSo.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_thamSo.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the quyen tac dong of this tham so.
	 *
	 * @param quyenTacDong the quyen tac dong of this tham so
	 */
	@Override
	public void setQuyenTacDong(int quyenTacDong) {
		_thamSo.setQuyenTacDong(quyenTacDong);
	}

	/**
	 * Sets whether this tham so is trang thai.
	 *
	 * @param trangThai the trang thai of this tham so
	 */
	@Override
	public void setTrangThai(boolean trangThai) {
		_thamSo.setTrangThai(trangThai);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<ThamSo> toCacheModel() {
		return _thamSo.toCacheModel();
	}

	@Override
	public ThamSo toEscapedModel() {
		return new ThamSoWrapper(_thamSo.toEscapedModel());
	}

	@Override
	public String toString() {
		return _thamSo.toString();
	}

	@Override
	public ThamSo toUnescapedModel() {
		return new ThamSoWrapper(_thamSo.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _thamSo.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ThamSoWrapper)) {
			return false;
		}

		ThamSoWrapper thamSoWrapper = (ThamSoWrapper)obj;

		if (Objects.equals(_thamSo, thamSoWrapper._thamSo)) {
			return true;
		}

		return false;
	}

	@Override
	public ThamSo getWrappedModel() {
		return _thamSo;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _thamSo.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _thamSo.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_thamSo.resetOriginalValues();
	}

	private final ThamSo _thamSo;

}