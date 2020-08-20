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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Mail}.
 * </p>
 *
 * @author manhlb
 * @see Mail
 * @generated
 */
@ProviderType
public class MailWrapper implements Mail, ModelWrapper<Mail> {

	public MailWrapper(Mail mail) {
		_mail = mail;
	}

	@Override
	public Class<?> getModelClass() {
		return Mail.class;
	}

	@Override
	public String getModelClassName() {
		return Mail.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("groupId", getGroupId());
		attributes.put("code", getCode());
		attributes.put("toAddress", getToAddress());
		attributes.put("subject", getSubject());
		attributes.put("body", getBody());
		attributes.put("ngayGui", getNgayGui());
		attributes.put("trangThai", isTrangThai());

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

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String toAddress = (String)attributes.get("toAddress");

		if (toAddress != null) {
			setToAddress(toAddress);
		}

		String subject = (String)attributes.get("subject");

		if (subject != null) {
			setSubject(subject);
		}

		String body = (String)attributes.get("body");

		if (body != null) {
			setBody(body);
		}

		Date ngayGui = (Date)attributes.get("ngayGui");

		if (ngayGui != null) {
			setNgayGui(ngayGui);
		}

		Boolean trangThai = (Boolean)attributes.get("trangThai");

		if (trangThai != null) {
			setTrangThai(trangThai);
		}
	}

	@Override
	public Object clone() {
		return new MailWrapper((Mail)_mail.clone());
	}

	@Override
	public int compareTo(Mail mail) {
		return _mail.compareTo(mail);
	}

	/**
	 * Returns the body of this mail.
	 *
	 * @return the body of this mail
	 */
	@Override
	public String getBody() {
		return _mail.getBody();
	}

	/**
	 * Returns the code of this mail.
	 *
	 * @return the code of this mail
	 */
	@Override
	public String getCode() {
		return _mail.getCode();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _mail.getExpandoBridge();
	}

	/**
	 * Returns the group ID of this mail.
	 *
	 * @return the group ID of this mail
	 */
	@Override
	public long getGroupId() {
		return _mail.getGroupId();
	}

	/**
	 * Returns the ID of this mail.
	 *
	 * @return the ID of this mail
	 */
	@Override
	public long getId() {
		return _mail.getId();
	}

	/**
	 * Returns the ngay gui of this mail.
	 *
	 * @return the ngay gui of this mail
	 */
	@Override
	public Date getNgayGui() {
		return _mail.getNgayGui();
	}

	/**
	 * Returns the primary key of this mail.
	 *
	 * @return the primary key of this mail
	 */
	@Override
	public long getPrimaryKey() {
		return _mail.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _mail.getPrimaryKeyObj();
	}

	/**
	 * Returns the subject of this mail.
	 *
	 * @return the subject of this mail
	 */
	@Override
	public String getSubject() {
		return _mail.getSubject();
	}

	/**
	 * Returns the to address of this mail.
	 *
	 * @return the to address of this mail
	 */
	@Override
	public String getToAddress() {
		return _mail.getToAddress();
	}

	/**
	 * Returns the trang thai of this mail.
	 *
	 * @return the trang thai of this mail
	 */
	@Override
	public boolean getTrangThai() {
		return _mail.getTrangThai();
	}

	@Override
	public int hashCode() {
		return _mail.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _mail.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _mail.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _mail.isNew();
	}

	/**
	 * Returns <code>true</code> if this mail is trang thai.
	 *
	 * @return <code>true</code> if this mail is trang thai; <code>false</code> otherwise
	 */
	@Override
	public boolean isTrangThai() {
		return _mail.isTrangThai();
	}

	@Override
	public void persist() {
		_mail.persist();
	}

	/**
	 * Sets the body of this mail.
	 *
	 * @param body the body of this mail
	 */
	@Override
	public void setBody(String body) {
		_mail.setBody(body);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_mail.setCachedModel(cachedModel);
	}

	/**
	 * Sets the code of this mail.
	 *
	 * @param code the code of this mail
	 */
	@Override
	public void setCode(String code) {
		_mail.setCode(code);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_mail.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_mail.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_mail.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the group ID of this mail.
	 *
	 * @param groupId the group ID of this mail
	 */
	@Override
	public void setGroupId(long groupId) {
		_mail.setGroupId(groupId);
	}

	/**
	 * Sets the ID of this mail.
	 *
	 * @param id the ID of this mail
	 */
	@Override
	public void setId(long id) {
		_mail.setId(id);
	}

	@Override
	public void setNew(boolean n) {
		_mail.setNew(n);
	}

	/**
	 * Sets the ngay gui of this mail.
	 *
	 * @param ngayGui the ngay gui of this mail
	 */
	@Override
	public void setNgayGui(Date ngayGui) {
		_mail.setNgayGui(ngayGui);
	}

	/**
	 * Sets the primary key of this mail.
	 *
	 * @param primaryKey the primary key of this mail
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_mail.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_mail.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the subject of this mail.
	 *
	 * @param subject the subject of this mail
	 */
	@Override
	public void setSubject(String subject) {
		_mail.setSubject(subject);
	}

	/**
	 * Sets the to address of this mail.
	 *
	 * @param toAddress the to address of this mail
	 */
	@Override
	public void setToAddress(String toAddress) {
		_mail.setToAddress(toAddress);
	}

	/**
	 * Sets whether this mail is trang thai.
	 *
	 * @param trangThai the trang thai of this mail
	 */
	@Override
	public void setTrangThai(boolean trangThai) {
		_mail.setTrangThai(trangThai);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Mail> toCacheModel() {
		return _mail.toCacheModel();
	}

	@Override
	public Mail toEscapedModel() {
		return new MailWrapper(_mail.toEscapedModel());
	}

	@Override
	public String toString() {
		return _mail.toString();
	}

	@Override
	public Mail toUnescapedModel() {
		return new MailWrapper(_mail.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _mail.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MailWrapper)) {
			return false;
		}

		MailWrapper mailWrapper = (MailWrapper)obj;

		if (Objects.equals(_mail, mailWrapper._mail)) {
			return true;
		}

		return false;
	}

	@Override
	public Mail getWrappedModel() {
		return _mail;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _mail.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _mail.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_mail.resetOriginalValues();
	}

	private final Mail _mail;

}