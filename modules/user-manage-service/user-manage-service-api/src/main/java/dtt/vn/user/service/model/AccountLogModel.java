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
 * The base model interface for the AccountLog service. Represents a row in the &quot;account_log&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>dtt.vn.user.service.model.impl.AccountLogModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>dtt.vn.user.service.model.impl.AccountLogImpl</code>.
 * </p>
 *
 * @author nhanvienDTT
 * @see AccountLog
 * @generated
 */
@ProviderType
public interface AccountLogModel extends BaseModel<AccountLog> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a account log model instance should use the {@link AccountLog} interface instead.
	 */

	/**
	 * Returns the primary key of this account log.
	 *
	 * @return the primary key of this account log
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this account log.
	 *
	 * @param primaryKey the primary key of this account log
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this account log.
	 *
	 * @return the ID of this account log
	 */
	public long getId();

	/**
	 * Sets the ID of this account log.
	 *
	 * @param id the ID of this account log
	 */
	public void setId(long id);

	/**
	 * Returns the account ID of this account log.
	 *
	 * @return the account ID of this account log
	 */
	public long getAccountId();

	/**
	 * Sets the account ID of this account log.
	 *
	 * @param accountId the account ID of this account log
	 */
	public void setAccountId(long accountId);

	/**
	 * Returns the nguoi sua ID of this account log.
	 *
	 * @return the nguoi sua ID of this account log
	 */
	public long getNguoiSuaId();

	/**
	 * Sets the nguoi sua ID of this account log.
	 *
	 * @param nguoiSuaId the nguoi sua ID of this account log
	 */
	public void setNguoiSuaId(long nguoiSuaId);

	/**
	 * Returns the ten nguoi sua of this account log.
	 *
	 * @return the ten nguoi sua of this account log
	 */
	@AutoEscape
	public String getTenNguoiSua();

	/**
	 * Sets the ten nguoi sua of this account log.
	 *
	 * @param tenNguoiSua the ten nguoi sua of this account log
	 */
	public void setTenNguoiSua(String tenNguoiSua);

	/**
	 * Returns the ngay sua of this account log.
	 *
	 * @return the ngay sua of this account log
	 */
	public Date getNgaySua();

	/**
	 * Sets the ngay sua of this account log.
	 *
	 * @param ngaySua the ngay sua of this account log
	 */
	public void setNgaySua(Date ngaySua);

	/**
	 * Returns the email nguoi sua of this account log.
	 *
	 * @return the email nguoi sua of this account log
	 */
	@AutoEscape
	public String getEmailNguoiSua();

	/**
	 * Sets the email nguoi sua of this account log.
	 *
	 * @param emailNguoiSua the email nguoi sua of this account log
	 */
	public void setEmailNguoiSua(String emailNguoiSua);

	/**
	 * Returns the phien ban of this account log.
	 *
	 * @return the phien ban of this account log
	 */
	public long getPhienBan();

	/**
	 * Sets the phien ban of this account log.
	 *
	 * @param phienBan the phien ban of this account log
	 */
	public void setPhienBan(long phienBan);

	/**
	 * Returns the json of this account log.
	 *
	 * @return the json of this account log
	 */
	@AutoEscape
	public String getJson();

	/**
	 * Sets the json of this account log.
	 *
	 * @param json the json of this account log
	 */
	public void setJson(String json);

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
	public int compareTo(dtt.vn.user.service.model.AccountLog accountLog);

	@Override
	public int hashCode();

	@Override
	public CacheModel<dtt.vn.user.service.model.AccountLog> toCacheModel();

	@Override
	public dtt.vn.user.service.model.AccountLog toEscapedModel();

	@Override
	public dtt.vn.user.service.model.AccountLog toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();

}