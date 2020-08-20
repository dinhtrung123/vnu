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
import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the ThongTinDangKy service. Represents a row in the &quot;ttnd_thongtindangky&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>dtt.vn.user.service.model.impl.ThongTinDangKyModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>dtt.vn.user.service.model.impl.ThongTinDangKyImpl</code>.
 * </p>
 *
 * @author nhanvienDTT
 * @see ThongTinDangKy
 * @generated
 */
@ProviderType
public interface ThongTinDangKyModel extends BaseModel<ThongTinDangKy> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a thong tin dang ky model instance should use the {@link ThongTinDangKy} interface instead.
	 */

	/**
	 * Returns the primary key of this thong tin dang ky.
	 *
	 * @return the primary key of this thong tin dang ky
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this thong tin dang ky.
	 *
	 * @param primaryKey the primary key of this thong tin dang ky
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this thong tin dang ky.
	 *
	 * @return the ID of this thong tin dang ky
	 */
	public long getId();

	/**
	 * Sets the ID of this thong tin dang ky.
	 *
	 * @param id the ID of this thong tin dang ky
	 */
	public void setId(long id);

	/**
	 * Returns the email address of this thong tin dang ky.
	 *
	 * @return the email address of this thong tin dang ky
	 */
	@AutoEscape
	public String getEmailAddress();

	/**
	 * Sets the email address of this thong tin dang ky.
	 *
	 * @param emailAddress the email address of this thong tin dang ky
	 */
	public void setEmailAddress(String emailAddress);

	/**
	 * Returns the user name of this thong tin dang ky.
	 *
	 * @return the user name of this thong tin dang ky
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this thong tin dang ky.
	 *
	 * @param userName the user name of this thong tin dang ky
	 */
	public void setUserName(String userName);

	/**
	 * Returns the so giay to of this thong tin dang ky.
	 *
	 * @return the so giay to of this thong tin dang ky
	 */
	@AutoEscape
	public String getSoGiayTo();

	/**
	 * Sets the so giay to of this thong tin dang ky.
	 *
	 * @param soGiayTo the so giay to of this thong tin dang ky
	 */
	public void setSoGiayTo(String soGiayTo);

	/**
	 * Returns the ma kich hoat of this thong tin dang ky.
	 *
	 * @return the ma kich hoat of this thong tin dang ky
	 */
	@AutoEscape
	public String getMaKichHoat();

	/**
	 * Sets the ma kich hoat of this thong tin dang ky.
	 *
	 * @param maKichHoat the ma kich hoat of this thong tin dang ky
	 */
	public void setMaKichHoat(String maKichHoat);

	/**
	 * Returns the active type of this thong tin dang ky.
	 *
	 * @return the active type of this thong tin dang ky
	 */
	@AutoEscape
	public String getActiveType();

	/**
	 * Sets the active type of this thong tin dang ky.
	 *
	 * @param activeType the active type of this thong tin dang ky
	 */
	public void setActiveType(String activeType);

	/**
	 * Returns the doi tuong su dung ID of this thong tin dang ky.
	 *
	 * @return the doi tuong su dung ID of this thong tin dang ky
	 */
	public int getDoiTuongSuDungId();

	/**
	 * Sets the doi tuong su dung ID of this thong tin dang ky.
	 *
	 * @param doiTuongSuDungId the doi tuong su dung ID of this thong tin dang ky
	 */
	public void setDoiTuongSuDungId(int doiTuongSuDungId);

	/**
	 * Returns the noi dung of this thong tin dang ky.
	 *
	 * @return the noi dung of this thong tin dang ky
	 */
	@AutoEscape
	public String getNoiDung();

	/**
	 * Sets the noi dung of this thong tin dang ky.
	 *
	 * @param noiDung the noi dung of this thong tin dang ky
	 */
	public void setNoiDung(String noiDung);

	/**
	 * Returns the ngay tao of this thong tin dang ky.
	 *
	 * @return the ngay tao of this thong tin dang ky
	 */
	public Date getNgayTao();

	/**
	 * Sets the ngay tao of this thong tin dang ky.
	 *
	 * @param ngayTao the ngay tao of this thong tin dang ky
	 */
	public void setNgayTao(Date ngayTao);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(
		dtt.vn.user.service.model.ThongTinDangKy thongTinDangKy);

	@Override
	public int hashCode();

	@Override
	public CacheModel<dtt.vn.user.service.model.ThongTinDangKy> toCacheModel();

	@Override
	public dtt.vn.user.service.model.ThongTinDangKy toEscapedModel();

	@Override
	public dtt.vn.user.service.model.ThongTinDangKy toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();

}