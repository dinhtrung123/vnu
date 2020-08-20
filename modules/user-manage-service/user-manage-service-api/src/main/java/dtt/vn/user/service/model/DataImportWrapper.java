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
 * This class is a wrapper for {@link DataImport}.
 * </p>
 *
 * @author nhanvienDTT
 * @see DataImport
 * @generated
 */
@ProviderType
public class DataImportWrapper implements DataImport, ModelWrapper<DataImport> {

	public DataImportWrapper(DataImport dataImport) {
		_dataImport = dataImport;
	}

	@Override
	public Class<?> getModelClass() {
		return DataImport.class;
	}

	@Override
	public String getModelClassName() {
		return DataImport.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("screenName", getScreenName());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("unit", getUnit());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("phone", getPhone());
		attributes.put("jobTitle", getJobTitle());
		attributes.put("nameRole", getNameRole());
		attributes.put("numberId", getNumberId());
		attributes.put("hasImport", getHasImport());
		attributes.put("errorMsg", getErrorMsg());
		attributes.put("insertDate", getInsertDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String screenName = (String)attributes.get("screenName");

		if (screenName != null) {
			setScreenName(screenName);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String unit = (String)attributes.get("unit");

		if (unit != null) {
			setUnit(unit);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		String phone = (String)attributes.get("phone");

		if (phone != null) {
			setPhone(phone);
		}

		String jobTitle = (String)attributes.get("jobTitle");

		if (jobTitle != null) {
			setJobTitle(jobTitle);
		}

		String nameRole = (String)attributes.get("nameRole");

		if (nameRole != null) {
			setNameRole(nameRole);
		}

		String numberId = (String)attributes.get("numberId");

		if (numberId != null) {
			setNumberId(numberId);
		}

		String hasImport = (String)attributes.get("hasImport");

		if (hasImport != null) {
			setHasImport(hasImport);
		}

		String errorMsg = (String)attributes.get("errorMsg");

		if (errorMsg != null) {
			setErrorMsg(errorMsg);
		}

		Date insertDate = (Date)attributes.get("insertDate");

		if (insertDate != null) {
			setInsertDate(insertDate);
		}
	}

	@Override
	public Object clone() {
		return new DataImportWrapper((DataImport)_dataImport.clone());
	}

	@Override
	public int compareTo(dtt.vn.user.service.model.DataImport dataImport) {
		return _dataImport.compareTo(dataImport);
	}

	/**
	 * Returns the email address of this data import.
	 *
	 * @return the email address of this data import
	 */
	@Override
	public String getEmailAddress() {
		return _dataImport.getEmailAddress();
	}

	/**
	 * Returns the error msg of this data import.
	 *
	 * @return the error msg of this data import
	 */
	@Override
	public String getErrorMsg() {
		return _dataImport.getErrorMsg();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _dataImport.getExpandoBridge();
	}

	/**
	 * Returns the first name of this data import.
	 *
	 * @return the first name of this data import
	 */
	@Override
	public String getFirstName() {
		return _dataImport.getFirstName();
	}

	/**
	 * Returns the has import of this data import.
	 *
	 * @return the has import of this data import
	 */
	@Override
	public String getHasImport() {
		return _dataImport.getHasImport();
	}

	/**
	 * Returns the ID of this data import.
	 *
	 * @return the ID of this data import
	 */
	@Override
	public long getId() {
		return _dataImport.getId();
	}

	/**
	 * Returns the insert date of this data import.
	 *
	 * @return the insert date of this data import
	 */
	@Override
	public Date getInsertDate() {
		return _dataImport.getInsertDate();
	}

	/**
	 * Returns the job title of this data import.
	 *
	 * @return the job title of this data import
	 */
	@Override
	public String getJobTitle() {
		return _dataImport.getJobTitle();
	}

	/**
	 * Returns the last name of this data import.
	 *
	 * @return the last name of this data import
	 */
	@Override
	public String getLastName() {
		return _dataImport.getLastName();
	}

	/**
	 * Returns the name role of this data import.
	 *
	 * @return the name role of this data import
	 */
	@Override
	public String getNameRole() {
		return _dataImport.getNameRole();
	}

	/**
	 * Returns the number ID of this data import.
	 *
	 * @return the number ID of this data import
	 */
	@Override
	public String getNumberId() {
		return _dataImport.getNumberId();
	}

	/**
	 * Returns the phone of this data import.
	 *
	 * @return the phone of this data import
	 */
	@Override
	public String getPhone() {
		return _dataImport.getPhone();
	}

	/**
	 * Returns the primary key of this data import.
	 *
	 * @return the primary key of this data import
	 */
	@Override
	public long getPrimaryKey() {
		return _dataImport.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _dataImport.getPrimaryKeyObj();
	}

	/**
	 * Returns the screen name of this data import.
	 *
	 * @return the screen name of this data import
	 */
	@Override
	public String getScreenName() {
		return _dataImport.getScreenName();
	}

	/**
	 * Returns the unit of this data import.
	 *
	 * @return the unit of this data import
	 */
	@Override
	public String getUnit() {
		return _dataImport.getUnit();
	}

	@Override
	public int hashCode() {
		return _dataImport.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _dataImport.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _dataImport.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _dataImport.isNew();
	}

	@Override
	public void persist() {
		_dataImport.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_dataImport.setCachedModel(cachedModel);
	}

	/**
	 * Sets the email address of this data import.
	 *
	 * @param emailAddress the email address of this data import
	 */
	@Override
	public void setEmailAddress(String emailAddress) {
		_dataImport.setEmailAddress(emailAddress);
	}

	/**
	 * Sets the error msg of this data import.
	 *
	 * @param errorMsg the error msg of this data import
	 */
	@Override
	public void setErrorMsg(String errorMsg) {
		_dataImport.setErrorMsg(errorMsg);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_dataImport.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_dataImport.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_dataImport.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the first name of this data import.
	 *
	 * @param firstName the first name of this data import
	 */
	@Override
	public void setFirstName(String firstName) {
		_dataImport.setFirstName(firstName);
	}

	/**
	 * Sets the has import of this data import.
	 *
	 * @param hasImport the has import of this data import
	 */
	@Override
	public void setHasImport(String hasImport) {
		_dataImport.setHasImport(hasImport);
	}

	/**
	 * Sets the ID of this data import.
	 *
	 * @param id the ID of this data import
	 */
	@Override
	public void setId(long id) {
		_dataImport.setId(id);
	}

	/**
	 * Sets the insert date of this data import.
	 *
	 * @param insertDate the insert date of this data import
	 */
	@Override
	public void setInsertDate(Date insertDate) {
		_dataImport.setInsertDate(insertDate);
	}

	/**
	 * Sets the job title of this data import.
	 *
	 * @param jobTitle the job title of this data import
	 */
	@Override
	public void setJobTitle(String jobTitle) {
		_dataImport.setJobTitle(jobTitle);
	}

	/**
	 * Sets the last name of this data import.
	 *
	 * @param lastName the last name of this data import
	 */
	@Override
	public void setLastName(String lastName) {
		_dataImport.setLastName(lastName);
	}

	/**
	 * Sets the name role of this data import.
	 *
	 * @param nameRole the name role of this data import
	 */
	@Override
	public void setNameRole(String nameRole) {
		_dataImport.setNameRole(nameRole);
	}

	@Override
	public void setNew(boolean n) {
		_dataImport.setNew(n);
	}

	/**
	 * Sets the number ID of this data import.
	 *
	 * @param numberId the number ID of this data import
	 */
	@Override
	public void setNumberId(String numberId) {
		_dataImport.setNumberId(numberId);
	}

	/**
	 * Sets the phone of this data import.
	 *
	 * @param phone the phone of this data import
	 */
	@Override
	public void setPhone(String phone) {
		_dataImport.setPhone(phone);
	}

	/**
	 * Sets the primary key of this data import.
	 *
	 * @param primaryKey the primary key of this data import
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_dataImport.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_dataImport.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the screen name of this data import.
	 *
	 * @param screenName the screen name of this data import
	 */
	@Override
	public void setScreenName(String screenName) {
		_dataImport.setScreenName(screenName);
	}

	/**
	 * Sets the unit of this data import.
	 *
	 * @param unit the unit of this data import
	 */
	@Override
	public void setUnit(String unit) {
		_dataImport.setUnit(unit);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<dtt.vn.user.service.model.DataImport> toCacheModel() {

		return _dataImport.toCacheModel();
	}

	@Override
	public dtt.vn.user.service.model.DataImport toEscapedModel() {
		return new DataImportWrapper(_dataImport.toEscapedModel());
	}

	@Override
	public String toString() {
		return _dataImport.toString();
	}

	@Override
	public dtt.vn.user.service.model.DataImport toUnescapedModel() {
		return new DataImportWrapper(_dataImport.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _dataImport.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DataImportWrapper)) {
			return false;
		}

		DataImportWrapper dataImportWrapper = (DataImportWrapper)obj;

		if (Objects.equals(_dataImport, dataImportWrapper._dataImport)) {
			return true;
		}

		return false;
	}

	@Override
	public DataImport getWrappedModel() {
		return _dataImport;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _dataImport.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _dataImport.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_dataImport.resetOriginalValues();
	}

	private final DataImport _dataImport;

}