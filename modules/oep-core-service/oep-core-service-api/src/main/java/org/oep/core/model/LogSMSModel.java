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
import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the LogSMS service. Represents a row in the &quot;oep_logs_sms&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>org.oep.core.model.impl.LogSMSModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>org.oep.core.model.impl.LogSMSImpl</code>.
 * </p>
 *
 * @author manhlb
 * @see LogSMS
 * @generated
 */
@ProviderType
public interface LogSMSModel extends BaseModel<LogSMS> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a log sms model instance should use the {@link LogSMS} interface instead.
	 */

	/**
	 * Returns the primary key of this log sms.
	 *
	 * @return the primary key of this log sms
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this log sms.
	 *
	 * @param primaryKey the primary key of this log sms
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this log sms.
	 *
	 * @return the ID of this log sms
	 */
	public long getId();

	/**
	 * Sets the ID of this log sms.
	 *
	 * @param id the ID of this log sms
	 */
	public void setId(long id);

	/**
	 * Returns the sent date time of this log sms.
	 *
	 * @return the sent date time of this log sms
	 */
	public Date getSentDateTime();

	/**
	 * Sets the sent date time of this log sms.
	 *
	 * @param sentDateTime the sent date time of this log sms
	 */
	public void setSentDateTime(Date sentDateTime);

	/**
	 * Returns the phone of this log sms.
	 *
	 * @return the phone of this log sms
	 */
	@AutoEscape
	public String getPhone();

	/**
	 * Sets the phone of this log sms.
	 *
	 * @param phone the phone of this log sms
	 */
	public void setPhone(String phone);

	/**
	 * Returns the response date of this log sms.
	 *
	 * @return the response date of this log sms
	 */
	public Date getResponseDate();

	/**
	 * Sets the response date of this log sms.
	 *
	 * @param responseDate the response date of this log sms
	 */
	public void setResponseDate(Date responseDate);

	/**
	 * Returns the error code of this log sms.
	 *
	 * @return the error code of this log sms
	 */
	@AutoEscape
	public String getErrorCode();

	/**
	 * Sets the error code of this log sms.
	 *
	 * @param errorCode the error code of this log sms
	 */
	public void setErrorCode(String errorCode);

	/**
	 * Returns the error detail of this log sms.
	 *
	 * @return the error detail of this log sms
	 */
	@AutoEscape
	public String getErrorDetail();

	/**
	 * Sets the error detail of this log sms.
	 *
	 * @param errorDetail the error detail of this log sms
	 */
	public void setErrorDetail(String errorDetail);

	/**
	 * Returns the message ID of this log sms.
	 *
	 * @return the message ID of this log sms
	 */
	public long getMessageId();

	/**
	 * Sets the message ID of this log sms.
	 *
	 * @param messageId the message ID of this log sms
	 */
	public void setMessageId(long messageId);

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
	public int compareTo(LogSMS logSMS);

	@Override
	public int hashCode();

	@Override
	public CacheModel<LogSMS> toCacheModel();

	@Override
	public LogSMS toEscapedModel();

	@Override
	public LogSMS toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();

}