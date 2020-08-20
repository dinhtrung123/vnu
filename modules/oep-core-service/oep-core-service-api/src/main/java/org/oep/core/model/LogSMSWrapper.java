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
 * This class is a wrapper for {@link LogSMS}.
 * </p>
 *
 * @author manhlb
 * @see LogSMS
 * @generated
 */
@ProviderType
public class LogSMSWrapper implements LogSMS, ModelWrapper<LogSMS> {

	public LogSMSWrapper(LogSMS logSMS) {
		_logSMS = logSMS;
	}

	@Override
	public Class<?> getModelClass() {
		return LogSMS.class;
	}

	@Override
	public String getModelClassName() {
		return LogSMS.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("sentDateTime", getSentDateTime());
		attributes.put("phone", getPhone());
		attributes.put("responseDate", getResponseDate());
		attributes.put("errorCode", getErrorCode());
		attributes.put("errorDetail", getErrorDetail());
		attributes.put("messageId", getMessageId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Date sentDateTime = (Date)attributes.get("sentDateTime");

		if (sentDateTime != null) {
			setSentDateTime(sentDateTime);
		}

		String phone = (String)attributes.get("phone");

		if (phone != null) {
			setPhone(phone);
		}

		Date responseDate = (Date)attributes.get("responseDate");

		if (responseDate != null) {
			setResponseDate(responseDate);
		}

		String errorCode = (String)attributes.get("errorCode");

		if (errorCode != null) {
			setErrorCode(errorCode);
		}

		String errorDetail = (String)attributes.get("errorDetail");

		if (errorDetail != null) {
			setErrorDetail(errorDetail);
		}

		Long messageId = (Long)attributes.get("messageId");

		if (messageId != null) {
			setMessageId(messageId);
		}
	}

	@Override
	public Object clone() {
		return new LogSMSWrapper((LogSMS)_logSMS.clone());
	}

	@Override
	public int compareTo(LogSMS logSMS) {
		return _logSMS.compareTo(logSMS);
	}

	/**
	 * Returns the error code of this log sms.
	 *
	 * @return the error code of this log sms
	 */
	@Override
	public String getErrorCode() {
		return _logSMS.getErrorCode();
	}

	/**
	 * Returns the error detail of this log sms.
	 *
	 * @return the error detail of this log sms
	 */
	@Override
	public String getErrorDetail() {
		return _logSMS.getErrorDetail();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _logSMS.getExpandoBridge();
	}

	/**
	 * Returns the ID of this log sms.
	 *
	 * @return the ID of this log sms
	 */
	@Override
	public long getId() {
		return _logSMS.getId();
	}

	/**
	 * Returns the message ID of this log sms.
	 *
	 * @return the message ID of this log sms
	 */
	@Override
	public long getMessageId() {
		return _logSMS.getMessageId();
	}

	/**
	 * Returns the phone of this log sms.
	 *
	 * @return the phone of this log sms
	 */
	@Override
	public String getPhone() {
		return _logSMS.getPhone();
	}

	/**
	 * Returns the primary key of this log sms.
	 *
	 * @return the primary key of this log sms
	 */
	@Override
	public long getPrimaryKey() {
		return _logSMS.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _logSMS.getPrimaryKeyObj();
	}

	/**
	 * Returns the response date of this log sms.
	 *
	 * @return the response date of this log sms
	 */
	@Override
	public Date getResponseDate() {
		return _logSMS.getResponseDate();
	}

	/**
	 * Returns the sent date time of this log sms.
	 *
	 * @return the sent date time of this log sms
	 */
	@Override
	public Date getSentDateTime() {
		return _logSMS.getSentDateTime();
	}

	@Override
	public int hashCode() {
		return _logSMS.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _logSMS.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _logSMS.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _logSMS.isNew();
	}

	@Override
	public void persist() {
		_logSMS.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_logSMS.setCachedModel(cachedModel);
	}

	/**
	 * Sets the error code of this log sms.
	 *
	 * @param errorCode the error code of this log sms
	 */
	@Override
	public void setErrorCode(String errorCode) {
		_logSMS.setErrorCode(errorCode);
	}

	/**
	 * Sets the error detail of this log sms.
	 *
	 * @param errorDetail the error detail of this log sms
	 */
	@Override
	public void setErrorDetail(String errorDetail) {
		_logSMS.setErrorDetail(errorDetail);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_logSMS.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_logSMS.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_logSMS.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the ID of this log sms.
	 *
	 * @param id the ID of this log sms
	 */
	@Override
	public void setId(long id) {
		_logSMS.setId(id);
	}

	/**
	 * Sets the message ID of this log sms.
	 *
	 * @param messageId the message ID of this log sms
	 */
	@Override
	public void setMessageId(long messageId) {
		_logSMS.setMessageId(messageId);
	}

	@Override
	public void setNew(boolean n) {
		_logSMS.setNew(n);
	}

	/**
	 * Sets the phone of this log sms.
	 *
	 * @param phone the phone of this log sms
	 */
	@Override
	public void setPhone(String phone) {
		_logSMS.setPhone(phone);
	}

	/**
	 * Sets the primary key of this log sms.
	 *
	 * @param primaryKey the primary key of this log sms
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_logSMS.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_logSMS.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the response date of this log sms.
	 *
	 * @param responseDate the response date of this log sms
	 */
	@Override
	public void setResponseDate(Date responseDate) {
		_logSMS.setResponseDate(responseDate);
	}

	/**
	 * Sets the sent date time of this log sms.
	 *
	 * @param sentDateTime the sent date time of this log sms
	 */
	@Override
	public void setSentDateTime(Date sentDateTime) {
		_logSMS.setSentDateTime(sentDateTime);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<LogSMS> toCacheModel() {
		return _logSMS.toCacheModel();
	}

	@Override
	public LogSMS toEscapedModel() {
		return new LogSMSWrapper(_logSMS.toEscapedModel());
	}

	@Override
	public String toString() {
		return _logSMS.toString();
	}

	@Override
	public LogSMS toUnescapedModel() {
		return new LogSMSWrapper(_logSMS.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _logSMS.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LogSMSWrapper)) {
			return false;
		}

		LogSMSWrapper logSMSWrapper = (LogSMSWrapper)obj;

		if (Objects.equals(_logSMS, logSMSWrapper._logSMS)) {
			return true;
		}

		return false;
	}

	@Override
	public LogSMS getWrappedModel() {
		return _logSMS;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _logSMS.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _logSMS.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_logSMS.resetOriginalValues();
	}

	private final LogSMS _logSMS;

}