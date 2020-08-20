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
 * This class is a wrapper for {@link ThongTinCanBo}.
 * </p>
 *
 * @author nhanvienDTT
 * @see ThongTinCanBo
 * @generated
 */
@ProviderType
public class ThongTinCanBoWrapper
	implements ThongTinCanBo, ModelWrapper<ThongTinCanBo> {

	public ThongTinCanBoWrapper(ThongTinCanBo thongTinCanBo) {
		_thongTinCanBo = thongTinCanBo;
	}

	@Override
	public Class<?> getModelClass() {
		return ThongTinCanBo.class;
	}

	@Override
	public String getModelClassName() {
		return ThongTinCanBo.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("userName", getUserName());
		attributes.put("nameRole", getNameRole());
		attributes.put("noiDung", getNoiDung());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		String nameRole = (String)attributes.get("nameRole");

		if (nameRole != null) {
			setNameRole(nameRole);
		}

		String noiDung = (String)attributes.get("noiDung");

		if (noiDung != null) {
			setNoiDung(noiDung);
		}
	}

	@Override
	public Object clone() {
		return new ThongTinCanBoWrapper((ThongTinCanBo)_thongTinCanBo.clone());
	}

	@Override
	public int compareTo(
		dtt.vn.user.service.model.ThongTinCanBo thongTinCanBo) {

		return _thongTinCanBo.compareTo(thongTinCanBo);
	}

	/**
	 * Returns the email address of this thong tin can bo.
	 *
	 * @return the email address of this thong tin can bo
	 */
	@Override
	public String getEmailAddress() {
		return _thongTinCanBo.getEmailAddress();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _thongTinCanBo.getExpandoBridge();
	}

	/**
	 * Returns the ID of this thong tin can bo.
	 *
	 * @return the ID of this thong tin can bo
	 */
	@Override
	public long getId() {
		return _thongTinCanBo.getId();
	}

	/**
	 * Returns the name role of this thong tin can bo.
	 *
	 * @return the name role of this thong tin can bo
	 */
	@Override
	public String getNameRole() {
		return _thongTinCanBo.getNameRole();
	}

	/**
	 * Returns the noi dung of this thong tin can bo.
	 *
	 * @return the noi dung of this thong tin can bo
	 */
	@Override
	public String getNoiDung() {
		return _thongTinCanBo.getNoiDung();
	}

	/**
	 * Returns the primary key of this thong tin can bo.
	 *
	 * @return the primary key of this thong tin can bo
	 */
	@Override
	public long getPrimaryKey() {
		return _thongTinCanBo.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _thongTinCanBo.getPrimaryKeyObj();
	}

	/**
	 * Returns the user name of this thong tin can bo.
	 *
	 * @return the user name of this thong tin can bo
	 */
	@Override
	public String getUserName() {
		return _thongTinCanBo.getUserName();
	}

	@Override
	public int hashCode() {
		return _thongTinCanBo.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _thongTinCanBo.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _thongTinCanBo.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _thongTinCanBo.isNew();
	}

	@Override
	public void persist() {
		_thongTinCanBo.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_thongTinCanBo.setCachedModel(cachedModel);
	}

	/**
	 * Sets the email address of this thong tin can bo.
	 *
	 * @param emailAddress the email address of this thong tin can bo
	 */
	@Override
	public void setEmailAddress(String emailAddress) {
		_thongTinCanBo.setEmailAddress(emailAddress);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_thongTinCanBo.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_thongTinCanBo.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_thongTinCanBo.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the ID of this thong tin can bo.
	 *
	 * @param id the ID of this thong tin can bo
	 */
	@Override
	public void setId(long id) {
		_thongTinCanBo.setId(id);
	}

	/**
	 * Sets the name role of this thong tin can bo.
	 *
	 * @param nameRole the name role of this thong tin can bo
	 */
	@Override
	public void setNameRole(String nameRole) {
		_thongTinCanBo.setNameRole(nameRole);
	}

	@Override
	public void setNew(boolean n) {
		_thongTinCanBo.setNew(n);
	}

	/**
	 * Sets the noi dung of this thong tin can bo.
	 *
	 * @param noiDung the noi dung of this thong tin can bo
	 */
	@Override
	public void setNoiDung(String noiDung) {
		_thongTinCanBo.setNoiDung(noiDung);
	}

	/**
	 * Sets the primary key of this thong tin can bo.
	 *
	 * @param primaryKey the primary key of this thong tin can bo
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_thongTinCanBo.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_thongTinCanBo.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the user name of this thong tin can bo.
	 *
	 * @param userName the user name of this thong tin can bo
	 */
	@Override
	public void setUserName(String userName) {
		_thongTinCanBo.setUserName(userName);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<dtt.vn.user.service.model.ThongTinCanBo> toCacheModel() {

		return _thongTinCanBo.toCacheModel();
	}

	@Override
	public dtt.vn.user.service.model.ThongTinCanBo toEscapedModel() {
		return new ThongTinCanBoWrapper(_thongTinCanBo.toEscapedModel());
	}

	@Override
	public String toString() {
		return _thongTinCanBo.toString();
	}

	@Override
	public dtt.vn.user.service.model.ThongTinCanBo toUnescapedModel() {
		return new ThongTinCanBoWrapper(_thongTinCanBo.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _thongTinCanBo.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ThongTinCanBoWrapper)) {
			return false;
		}

		ThongTinCanBoWrapper thongTinCanBoWrapper = (ThongTinCanBoWrapper)obj;

		if (Objects.equals(
				_thongTinCanBo, thongTinCanBoWrapper._thongTinCanBo)) {

			return true;
		}

		return false;
	}

	@Override
	public ThongTinCanBo getWrappedModel() {
		return _thongTinCanBo;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _thongTinCanBo.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _thongTinCanBo.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_thongTinCanBo.resetOriginalValues();
	}

	private final ThongTinCanBo _thongTinCanBo;

}