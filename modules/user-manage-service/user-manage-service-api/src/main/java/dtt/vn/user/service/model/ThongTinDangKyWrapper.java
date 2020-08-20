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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link ThongTinDangKy}.
 * </p>
 *
 * @author nhanvienDTT
 * @see ThongTinDangKy
 * @generated
 */
@ProviderType
public class ThongTinDangKyWrapper
	implements ThongTinDangKy, ModelWrapper<ThongTinDangKy> {

	public ThongTinDangKyWrapper(ThongTinDangKy thongTinDangKy) {
		_thongTinDangKy = thongTinDangKy;
	}

	@Override
	public Class<?> getModelClass() {
		return ThongTinDangKy.class;
	}

	@Override
	public String getModelClassName() {
		return ThongTinDangKy.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("userName", getUserName());
		attributes.put("soGiayTo", getSoGiayTo());
		attributes.put("maKichHoat", getMaKichHoat());
		attributes.put("activeType", getActiveType());
		attributes.put("doiTuongSuDungId", getDoiTuongSuDungId());
		attributes.put("noiDung", getNoiDung());
		attributes.put("ngayTao", getNgayTao());

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

		String soGiayTo = (String)attributes.get("soGiayTo");

		if (soGiayTo != null) {
			setSoGiayTo(soGiayTo);
		}

		String maKichHoat = (String)attributes.get("maKichHoat");

		if (maKichHoat != null) {
			setMaKichHoat(maKichHoat);
		}

		String activeType = (String)attributes.get("activeType");

		if (activeType != null) {
			setActiveType(activeType);
		}

		Integer doiTuongSuDungId = (Integer)attributes.get("doiTuongSuDungId");

		if (doiTuongSuDungId != null) {
			setDoiTuongSuDungId(doiTuongSuDungId);
		}

		String noiDung = (String)attributes.get("noiDung");

		if (noiDung != null) {
			setNoiDung(noiDung);
		}

		Date ngayTao = (Date)attributes.get("ngayTao");

		if (ngayTao != null) {
			setNgayTao(ngayTao);
		}
	}

	@Override
	public Object clone() {
		return new ThongTinDangKyWrapper(
			(ThongTinDangKy)_thongTinDangKy.clone());
	}

	@Override
	public int compareTo(
		dtt.vn.user.service.model.ThongTinDangKy thongTinDangKy) {

		return _thongTinDangKy.compareTo(thongTinDangKy);
	}

	/**
	 * Returns the active type of this thong tin dang ky.
	 *
	 * @return the active type of this thong tin dang ky
	 */
	@Override
	public String getActiveType() {
		return _thongTinDangKy.getActiveType();
	}

	/**
	 * Returns the doi tuong su dung ID of this thong tin dang ky.
	 *
	 * @return the doi tuong su dung ID of this thong tin dang ky
	 */
	@Override
	public int getDoiTuongSuDungId() {
		return _thongTinDangKy.getDoiTuongSuDungId();
	}

	/**
	 * Returns the email address of this thong tin dang ky.
	 *
	 * @return the email address of this thong tin dang ky
	 */
	@Override
	public String getEmailAddress() {
		return _thongTinDangKy.getEmailAddress();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _thongTinDangKy.getExpandoBridge();
	}

	/**
	 * Returns the ID of this thong tin dang ky.
	 *
	 * @return the ID of this thong tin dang ky
	 */
	@Override
	public long getId() {
		return _thongTinDangKy.getId();
	}

	/**
	 * Returns the ma kich hoat of this thong tin dang ky.
	 *
	 * @return the ma kich hoat of this thong tin dang ky
	 */
	@Override
	public String getMaKichHoat() {
		return _thongTinDangKy.getMaKichHoat();
	}

	/**
	 * Returns the ngay tao of this thong tin dang ky.
	 *
	 * @return the ngay tao of this thong tin dang ky
	 */
	@Override
	public Date getNgayTao() {
		return _thongTinDangKy.getNgayTao();
	}

	/**
	 * Returns the noi dung of this thong tin dang ky.
	 *
	 * @return the noi dung of this thong tin dang ky
	 */
	@Override
	public String getNoiDung() {
		return _thongTinDangKy.getNoiDung();
	}

	/**
	 * Returns the primary key of this thong tin dang ky.
	 *
	 * @return the primary key of this thong tin dang ky
	 */
	@Override
	public long getPrimaryKey() {
		return _thongTinDangKy.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _thongTinDangKy.getPrimaryKeyObj();
	}

	/**
	 * Returns the so giay to of this thong tin dang ky.
	 *
	 * @return the so giay to of this thong tin dang ky
	 */
	@Override
	public String getSoGiayTo() {
		return _thongTinDangKy.getSoGiayTo();
	}

	/**
	 * Returns the user name of this thong tin dang ky.
	 *
	 * @return the user name of this thong tin dang ky
	 */
	@Override
	public String getUserName() {
		return _thongTinDangKy.getUserName();
	}

	@Override
	public int hashCode() {
		return _thongTinDangKy.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _thongTinDangKy.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _thongTinDangKy.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _thongTinDangKy.isNew();
	}

	@Override
	public void persist() {
		_thongTinDangKy.persist();
	}

	/**
	 * Sets the active type of this thong tin dang ky.
	 *
	 * @param activeType the active type of this thong tin dang ky
	 */
	@Override
	public void setActiveType(String activeType) {
		_thongTinDangKy.setActiveType(activeType);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_thongTinDangKy.setCachedModel(cachedModel);
	}

	/**
	 * Sets the doi tuong su dung ID of this thong tin dang ky.
	 *
	 * @param doiTuongSuDungId the doi tuong su dung ID of this thong tin dang ky
	 */
	@Override
	public void setDoiTuongSuDungId(int doiTuongSuDungId) {
		_thongTinDangKy.setDoiTuongSuDungId(doiTuongSuDungId);
	}

	/**
	 * Sets the email address of this thong tin dang ky.
	 *
	 * @param emailAddress the email address of this thong tin dang ky
	 */
	@Override
	public void setEmailAddress(String emailAddress) {
		_thongTinDangKy.setEmailAddress(emailAddress);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_thongTinDangKy.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_thongTinDangKy.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_thongTinDangKy.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the ID of this thong tin dang ky.
	 *
	 * @param id the ID of this thong tin dang ky
	 */
	@Override
	public void setId(long id) {
		_thongTinDangKy.setId(id);
	}

	/**
	 * Sets the ma kich hoat of this thong tin dang ky.
	 *
	 * @param maKichHoat the ma kich hoat of this thong tin dang ky
	 */
	@Override
	public void setMaKichHoat(String maKichHoat) {
		_thongTinDangKy.setMaKichHoat(maKichHoat);
	}

	@Override
	public void setNew(boolean n) {
		_thongTinDangKy.setNew(n);
	}

	/**
	 * Sets the ngay tao of this thong tin dang ky.
	 *
	 * @param ngayTao the ngay tao of this thong tin dang ky
	 */
	@Override
	public void setNgayTao(Date ngayTao) {
		_thongTinDangKy.setNgayTao(ngayTao);
	}

	/**
	 * Sets the noi dung of this thong tin dang ky.
	 *
	 * @param noiDung the noi dung of this thong tin dang ky
	 */
	@Override
	public void setNoiDung(String noiDung) {
		_thongTinDangKy.setNoiDung(noiDung);
	}

	/**
	 * Sets the primary key of this thong tin dang ky.
	 *
	 * @param primaryKey the primary key of this thong tin dang ky
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_thongTinDangKy.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_thongTinDangKy.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the so giay to of this thong tin dang ky.
	 *
	 * @param soGiayTo the so giay to of this thong tin dang ky
	 */
	@Override
	public void setSoGiayTo(String soGiayTo) {
		_thongTinDangKy.setSoGiayTo(soGiayTo);
	}

	/**
	 * Sets the user name of this thong tin dang ky.
	 *
	 * @param userName the user name of this thong tin dang ky
	 */
	@Override
	public void setUserName(String userName) {
		_thongTinDangKy.setUserName(userName);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<dtt.vn.user.service.model.ThongTinDangKy> toCacheModel() {

		return _thongTinDangKy.toCacheModel();
	}

	@Override
	public dtt.vn.user.service.model.ThongTinDangKy toEscapedModel() {
		return new ThongTinDangKyWrapper(_thongTinDangKy.toEscapedModel());
	}

	@Override
	public String toString() {
		return _thongTinDangKy.toString();
	}

	@Override
	public dtt.vn.user.service.model.ThongTinDangKy toUnescapedModel() {
		return new ThongTinDangKyWrapper(_thongTinDangKy.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _thongTinDangKy.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ThongTinDangKyWrapper)) {
			return false;
		}

		ThongTinDangKyWrapper thongTinDangKyWrapper =
			(ThongTinDangKyWrapper)obj;

		if (Objects.equals(
				_thongTinDangKy, thongTinDangKyWrapper._thongTinDangKy)) {

			return true;
		}

		return false;
	}

	@Override
	public ThongTinDangKy getWrappedModel() {
		return _thongTinDangKy;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _thongTinDangKy.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _thongTinDangKy.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_thongTinDangKy.resetOriginalValues();
	}

	private final ThongTinDangKy _thongTinDangKy;

}