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
 * This class is a wrapper for {@link AccountLog}.
 * </p>
 *
 * @author nhanvienDTT
 * @see AccountLog
 * @generated
 */
@ProviderType
public class AccountLogWrapper implements AccountLog, ModelWrapper<AccountLog> {

	public AccountLogWrapper(AccountLog accountLog) {
		_accountLog = accountLog;
	}

	@Override
	public Class<?> getModelClass() {
		return AccountLog.class;
	}

	@Override
	public String getModelClassName() {
		return AccountLog.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("accountId", getAccountId());
		attributes.put("nguoiSuaId", getNguoiSuaId());
		attributes.put("tenNguoiSua", getTenNguoiSua());
		attributes.put("ngaySua", getNgaySua());
		attributes.put("emailNguoiSua", getEmailNguoiSua());
		attributes.put("phienBan", getPhienBan());
		attributes.put("json", getJson());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long accountId = (Long)attributes.get("accountId");

		if (accountId != null) {
			setAccountId(accountId);
		}

		Long nguoiSuaId = (Long)attributes.get("nguoiSuaId");

		if (nguoiSuaId != null) {
			setNguoiSuaId(nguoiSuaId);
		}

		String tenNguoiSua = (String)attributes.get("tenNguoiSua");

		if (tenNguoiSua != null) {
			setTenNguoiSua(tenNguoiSua);
		}

		Date ngaySua = (Date)attributes.get("ngaySua");

		if (ngaySua != null) {
			setNgaySua(ngaySua);
		}

		String emailNguoiSua = (String)attributes.get("emailNguoiSua");

		if (emailNguoiSua != null) {
			setEmailNguoiSua(emailNguoiSua);
		}

		Long phienBan = (Long)attributes.get("phienBan");

		if (phienBan != null) {
			setPhienBan(phienBan);
		}

		String json = (String)attributes.get("json");

		if (json != null) {
			setJson(json);
		}
	}

	@Override
	public Object clone() {
		return new AccountLogWrapper((AccountLog)_accountLog.clone());
	}

	@Override
	public int compareTo(dtt.vn.user.service.model.AccountLog accountLog) {
		return _accountLog.compareTo(accountLog);
	}

	/**
	 * Returns the account ID of this account log.
	 *
	 * @return the account ID of this account log
	 */
	@Override
	public long getAccountId() {
		return _accountLog.getAccountId();
	}

	/**
	 * Returns the email nguoi sua of this account log.
	 *
	 * @return the email nguoi sua of this account log
	 */
	@Override
	public String getEmailNguoiSua() {
		return _accountLog.getEmailNguoiSua();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _accountLog.getExpandoBridge();
	}

	/**
	 * Returns the ID of this account log.
	 *
	 * @return the ID of this account log
	 */
	@Override
	public long getId() {
		return _accountLog.getId();
	}

	/**
	 * Returns the json of this account log.
	 *
	 * @return the json of this account log
	 */
	@Override
	public String getJson() {
		return _accountLog.getJson();
	}

	/**
	 * Returns the ngay sua of this account log.
	 *
	 * @return the ngay sua of this account log
	 */
	@Override
	public Date getNgaySua() {
		return _accountLog.getNgaySua();
	}

	/**
	 * Returns the nguoi sua ID of this account log.
	 *
	 * @return the nguoi sua ID of this account log
	 */
	@Override
	public long getNguoiSuaId() {
		return _accountLog.getNguoiSuaId();
	}

	/**
	 * Returns the phien ban of this account log.
	 *
	 * @return the phien ban of this account log
	 */
	@Override
	public long getPhienBan() {
		return _accountLog.getPhienBan();
	}

	/**
	 * Returns the primary key of this account log.
	 *
	 * @return the primary key of this account log
	 */
	@Override
	public long getPrimaryKey() {
		return _accountLog.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _accountLog.getPrimaryKeyObj();
	}

	/**
	 * Returns the ten nguoi sua of this account log.
	 *
	 * @return the ten nguoi sua of this account log
	 */
	@Override
	public String getTenNguoiSua() {
		return _accountLog.getTenNguoiSua();
	}

	@Override
	public int hashCode() {
		return _accountLog.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _accountLog.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _accountLog.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _accountLog.isNew();
	}

	@Override
	public void persist() {
		_accountLog.persist();
	}

	/**
	 * Sets the account ID of this account log.
	 *
	 * @param accountId the account ID of this account log
	 */
	@Override
	public void setAccountId(long accountId) {
		_accountLog.setAccountId(accountId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_accountLog.setCachedModel(cachedModel);
	}

	/**
	 * Sets the email nguoi sua of this account log.
	 *
	 * @param emailNguoiSua the email nguoi sua of this account log
	 */
	@Override
	public void setEmailNguoiSua(String emailNguoiSua) {
		_accountLog.setEmailNguoiSua(emailNguoiSua);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_accountLog.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_accountLog.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_accountLog.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the ID of this account log.
	 *
	 * @param id the ID of this account log
	 */
	@Override
	public void setId(long id) {
		_accountLog.setId(id);
	}

	/**
	 * Sets the json of this account log.
	 *
	 * @param json the json of this account log
	 */
	@Override
	public void setJson(String json) {
		_accountLog.setJson(json);
	}

	@Override
	public void setNew(boolean n) {
		_accountLog.setNew(n);
	}

	/**
	 * Sets the ngay sua of this account log.
	 *
	 * @param ngaySua the ngay sua of this account log
	 */
	@Override
	public void setNgaySua(Date ngaySua) {
		_accountLog.setNgaySua(ngaySua);
	}

	/**
	 * Sets the nguoi sua ID of this account log.
	 *
	 * @param nguoiSuaId the nguoi sua ID of this account log
	 */
	@Override
	public void setNguoiSuaId(long nguoiSuaId) {
		_accountLog.setNguoiSuaId(nguoiSuaId);
	}

	/**
	 * Sets the phien ban of this account log.
	 *
	 * @param phienBan the phien ban of this account log
	 */
	@Override
	public void setPhienBan(long phienBan) {
		_accountLog.setPhienBan(phienBan);
	}

	/**
	 * Sets the primary key of this account log.
	 *
	 * @param primaryKey the primary key of this account log
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_accountLog.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_accountLog.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the ten nguoi sua of this account log.
	 *
	 * @param tenNguoiSua the ten nguoi sua of this account log
	 */
	@Override
	public void setTenNguoiSua(String tenNguoiSua) {
		_accountLog.setTenNguoiSua(tenNguoiSua);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<dtt.vn.user.service.model.AccountLog> toCacheModel() {

		return _accountLog.toCacheModel();
	}

	@Override
	public dtt.vn.user.service.model.AccountLog toEscapedModel() {
		return new AccountLogWrapper(_accountLog.toEscapedModel());
	}

	@Override
	public String toString() {
		return _accountLog.toString();
	}

	@Override
	public dtt.vn.user.service.model.AccountLog toUnescapedModel() {
		return new AccountLogWrapper(_accountLog.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _accountLog.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AccountLogWrapper)) {
			return false;
		}

		AccountLogWrapper accountLogWrapper = (AccountLogWrapper)obj;

		if (Objects.equals(_accountLog, accountLogWrapper._accountLog)) {
			return true;
		}

		return false;
	}

	@Override
	public AccountLog getWrappedModel() {
		return _accountLog;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _accountLog.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _accountLog.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_accountLog.resetOriginalValues();
	}

	private final AccountLog _accountLog;

}