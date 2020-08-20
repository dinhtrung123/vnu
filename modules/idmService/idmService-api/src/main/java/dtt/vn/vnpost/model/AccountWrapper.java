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

package dtt.vn.vnpost.model;

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
 * This class is a wrapper for {@link Account}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Account
 * @generated
 */
@ProviderType
public class AccountWrapper implements Account, ModelWrapper<Account> {

	public AccountWrapper(Account account) {
		_account = account;
	}

	@Override
	public Class<?> getModelClass() {
		return Account.class;
	}

	@Override
	public String getModelClassName() {
		return Account.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("accountId", getAccountId());
		attributes.put("accountType", getAccountType());
		attributes.put("accountName", getAccountName());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("fullName", getFullName());
		attributes.put("birthdate", getBirthdate());
		attributes.put("email", getEmail());
		attributes.put("telNo", getTelNo());
		attributes.put("personalId", getPersonalId());
		attributes.put("address", getAddress());
		attributes.put("gender", getGender());
		attributes.put("legalDelegate", getLegalDelegate());
		attributes.put("taxCode", getTaxCode());
		attributes.put("insuranceCode", getInsuranceCode());
		attributes.put("nationality", getNationality());
		attributes.put("ethnicGroup", getEthnicGroup());
		attributes.put("familyRegNo", getFamilyRegNo());
		attributes.put("maritalStatus", getMaritalStatus());
		attributes.put("workingPlace", getWorkingPlace());
		attributes.put("nativePlace", getNativePlace());
		attributes.put("rangeDate", getRangeDate());
		attributes.put("issuedBy", getIssuedBy());
		attributes.put("fatherName", getFatherName());
		attributes.put("motherName", getMotherName());
		attributes.put("guardianName", getGuardianName());
		attributes.put("spouseName", getSpouseName());
		attributes.put("headHouseholdName", getHeadHouseholdName());
		attributes.put("nation", getNation());
		attributes.put("representativeNumber", getRepresentativeNumber());
		attributes.put("representativeName", getRepresentativeName());
		attributes.put("representativeTelNo", getRepresentativeTelNo());
		attributes.put("fax", getFax());
		attributes.put("superiorOrganization", getSuperiorOrganization());
		attributes.put("note", getNote());
		attributes.put("idDBXM", getIdDBXM());
		attributes.put("cityCode", getCityCode());
		attributes.put("districtCode", getDistrictCode());
		attributes.put("wardCode", getWardCode());
		attributes.put("cityCodeXM", getCityCodeXM());
		attributes.put("districtCodeXM", getDistrictCodeXM());
		attributes.put("wardCodeXM", getWardCodeXM());
		attributes.put("addressXM", getAddressXM());
		attributes.put("attachFile", getAttachFile());
		attributes.put("accountStatus", getAccountStatus());
		attributes.put("processStatus", getProcessStatus());
		attributes.put("signImageId", getSignImageId());
		attributes.put("hoSoId", getHoSoId());
		attributes.put("message", getMessage());
		attributes.put("assignUserId", getAssignUserId());
		attributes.put("ipLevel", getIpLevel());
		attributes.put("reOpen", isReOpen());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long accountId = (Long)attributes.get("accountId");

		if (accountId != null) {
			setAccountId(accountId);
		}

		Integer accountType = (Integer)attributes.get("accountType");

		if (accountType != null) {
			setAccountType(accountType);
		}

		String accountName = (String)attributes.get("accountName");

		if (accountName != null) {
			setAccountName(accountName);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String fullName = (String)attributes.get("fullName");

		if (fullName != null) {
			setFullName(fullName);
		}

		Date birthdate = (Date)attributes.get("birthdate");

		if (birthdate != null) {
			setBirthdate(birthdate);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String telNo = (String)attributes.get("telNo");

		if (telNo != null) {
			setTelNo(telNo);
		}

		String personalId = (String)attributes.get("personalId");

		if (personalId != null) {
			setPersonalId(personalId);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		Integer gender = (Integer)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		String legalDelegate = (String)attributes.get("legalDelegate");

		if (legalDelegate != null) {
			setLegalDelegate(legalDelegate);
		}

		String taxCode = (String)attributes.get("taxCode");

		if (taxCode != null) {
			setTaxCode(taxCode);
		}

		String insuranceCode = (String)attributes.get("insuranceCode");

		if (insuranceCode != null) {
			setInsuranceCode(insuranceCode);
		}

		String nationality = (String)attributes.get("nationality");

		if (nationality != null) {
			setNationality(nationality);
		}

		String ethnicGroup = (String)attributes.get("ethnicGroup");

		if (ethnicGroup != null) {
			setEthnicGroup(ethnicGroup);
		}

		String familyRegNo = (String)attributes.get("familyRegNo");

		if (familyRegNo != null) {
			setFamilyRegNo(familyRegNo);
		}

		Integer maritalStatus = (Integer)attributes.get("maritalStatus");

		if (maritalStatus != null) {
			setMaritalStatus(maritalStatus);
		}

		String workingPlace = (String)attributes.get("workingPlace");

		if (workingPlace != null) {
			setWorkingPlace(workingPlace);
		}

		String nativePlace = (String)attributes.get("nativePlace");

		if (nativePlace != null) {
			setNativePlace(nativePlace);
		}

		Date rangeDate = (Date)attributes.get("rangeDate");

		if (rangeDate != null) {
			setRangeDate(rangeDate);
		}

		String issuedBy = (String)attributes.get("issuedBy");

		if (issuedBy != null) {
			setIssuedBy(issuedBy);
		}

		String fatherName = (String)attributes.get("fatherName");

		if (fatherName != null) {
			setFatherName(fatherName);
		}

		String motherName = (String)attributes.get("motherName");

		if (motherName != null) {
			setMotherName(motherName);
		}

		String guardianName = (String)attributes.get("guardianName");

		if (guardianName != null) {
			setGuardianName(guardianName);
		}

		String spouseName = (String)attributes.get("spouseName");

		if (spouseName != null) {
			setSpouseName(spouseName);
		}

		String headHouseholdName = (String)attributes.get("headHouseholdName");

		if (headHouseholdName != null) {
			setHeadHouseholdName(headHouseholdName);
		}

		String nation = (String)attributes.get("nation");

		if (nation != null) {
			setNation(nation);
		}

		String representativeNumber = (String)attributes.get(
			"representativeNumber");

		if (representativeNumber != null) {
			setRepresentativeNumber(representativeNumber);
		}

		String representativeName = (String)attributes.get(
			"representativeName");

		if (representativeName != null) {
			setRepresentativeName(representativeName);
		}

		String representativeTelNo = (String)attributes.get(
			"representativeTelNo");

		if (representativeTelNo != null) {
			setRepresentativeTelNo(representativeTelNo);
		}

		String fax = (String)attributes.get("fax");

		if (fax != null) {
			setFax(fax);
		}

		String superiorOrganization = (String)attributes.get(
			"superiorOrganization");

		if (superiorOrganization != null) {
			setSuperiorOrganization(superiorOrganization);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}

		Long idDBXM = (Long)attributes.get("idDBXM");

		if (idDBXM != null) {
			setIdDBXM(idDBXM);
		}

		String cityCode = (String)attributes.get("cityCode");

		if (cityCode != null) {
			setCityCode(cityCode);
		}

		String districtCode = (String)attributes.get("districtCode");

		if (districtCode != null) {
			setDistrictCode(districtCode);
		}

		String wardCode = (String)attributes.get("wardCode");

		if (wardCode != null) {
			setWardCode(wardCode);
		}

		String cityCodeXM = (String)attributes.get("cityCodeXM");

		if (cityCodeXM != null) {
			setCityCodeXM(cityCodeXM);
		}

		String districtCodeXM = (String)attributes.get("districtCodeXM");

		if (districtCodeXM != null) {
			setDistrictCodeXM(districtCodeXM);
		}

		String wardCodeXM = (String)attributes.get("wardCodeXM");

		if (wardCodeXM != null) {
			setWardCodeXM(wardCodeXM);
		}

		String addressXM = (String)attributes.get("addressXM");

		if (addressXM != null) {
			setAddressXM(addressXM);
		}

		Long attachFile = (Long)attributes.get("attachFile");

		if (attachFile != null) {
			setAttachFile(attachFile);
		}

		Integer accountStatus = (Integer)attributes.get("accountStatus");

		if (accountStatus != null) {
			setAccountStatus(accountStatus);
		}

		Integer processStatus = (Integer)attributes.get("processStatus");

		if (processStatus != null) {
			setProcessStatus(processStatus);
		}

		Long signImageId = (Long)attributes.get("signImageId");

		if (signImageId != null) {
			setSignImageId(signImageId);
		}

		Long hoSoId = (Long)attributes.get("hoSoId");

		if (hoSoId != null) {
			setHoSoId(hoSoId);
		}

		String message = (String)attributes.get("message");

		if (message != null) {
			setMessage(message);
		}

		Long assignUserId = (Long)attributes.get("assignUserId");

		if (assignUserId != null) {
			setAssignUserId(assignUserId);
		}

		Integer ipLevel = (Integer)attributes.get("ipLevel");

		if (ipLevel != null) {
			setIpLevel(ipLevel);
		}

		Boolean reOpen = (Boolean)attributes.get("reOpen");

		if (reOpen != null) {
			setReOpen(reOpen);
		}
	}

	@Override
	public Object clone() {
		return new AccountWrapper((Account)_account.clone());
	}

	@Override
	public int compareTo(dtt.vn.vnpost.model.Account account) {
		return _account.compareTo(account);
	}

	/**
	 * Returns the account ID of this account.
	 *
	 * @return the account ID of this account
	 */
	@Override
	public long getAccountId() {
		return _account.getAccountId();
	}

	/**
	 * Returns the account name of this account.
	 *
	 * @return the account name of this account
	 */
	@Override
	public String getAccountName() {
		return _account.getAccountName();
	}

	/**
	 * Returns the account status of this account.
	 *
	 * @return the account status of this account
	 */
	@Override
	public int getAccountStatus() {
		return _account.getAccountStatus();
	}

	/**
	 * Returns the account type of this account.
	 *
	 * @return the account type of this account
	 */
	@Override
	public int getAccountType() {
		return _account.getAccountType();
	}

	/**
	 * Returns the address of this account.
	 *
	 * @return the address of this account
	 */
	@Override
	public String getAddress() {
		return _account.getAddress();
	}

	/**
	 * Returns the address xm of this account.
	 *
	 * @return the address xm of this account
	 */
	@Override
	public String getAddressXM() {
		return _account.getAddressXM();
	}

	/**
	 * Returns the assign user ID of this account.
	 *
	 * @return the assign user ID of this account
	 */
	@Override
	public long getAssignUserId() {
		return _account.getAssignUserId();
	}

	/**
	 * Returns the assign user uuid of this account.
	 *
	 * @return the assign user uuid of this account
	 */
	@Override
	public String getAssignUserUuid() {
		return _account.getAssignUserUuid();
	}

	/**
	 * Returns the attach file of this account.
	 *
	 * @return the attach file of this account
	 */
	@Override
	public long getAttachFile() {
		return _account.getAttachFile();
	}

	/**
	 * Returns the birthdate of this account.
	 *
	 * @return the birthdate of this account
	 */
	@Override
	public Date getBirthdate() {
		return _account.getBirthdate();
	}

	/**
	 * Returns the city code of this account.
	 *
	 * @return the city code of this account
	 */
	@Override
	public String getCityCode() {
		return _account.getCityCode();
	}

	/**
	 * Returns the city code xm of this account.
	 *
	 * @return the city code xm of this account
	 */
	@Override
	public String getCityCodeXM() {
		return _account.getCityCodeXM();
	}

	/**
	 * Returns the company ID of this account.
	 *
	 * @return the company ID of this account
	 */
	@Override
	public long getCompanyId() {
		return _account.getCompanyId();
	}

	/**
	 * Returns the create date of this account.
	 *
	 * @return the create date of this account
	 */
	@Override
	public Date getCreateDate() {
		return _account.getCreateDate();
	}

	/**
	 * Returns the district code of this account.
	 *
	 * @return the district code of this account
	 */
	@Override
	public String getDistrictCode() {
		return _account.getDistrictCode();
	}

	/**
	 * Returns the district code xm of this account.
	 *
	 * @return the district code xm of this account
	 */
	@Override
	public String getDistrictCodeXM() {
		return _account.getDistrictCodeXM();
	}

	/**
	 * Returns the email of this account.
	 *
	 * @return the email of this account
	 */
	@Override
	public String getEmail() {
		return _account.getEmail();
	}

	/**
	 * Returns the ethnic group of this account.
	 *
	 * @return the ethnic group of this account
	 */
	@Override
	public String getEthnicGroup() {
		return _account.getEthnicGroup();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _account.getExpandoBridge();
	}

	/**
	 * Returns the family reg no of this account.
	 *
	 * @return the family reg no of this account
	 */
	@Override
	public String getFamilyRegNo() {
		return _account.getFamilyRegNo();
	}

	/**
	 * Returns the father name of this account.
	 *
	 * @return the father name of this account
	 */
	@Override
	public String getFatherName() {
		return _account.getFatherName();
	}

	/**
	 * Returns the fax of this account.
	 *
	 * @return the fax of this account
	 */
	@Override
	public String getFax() {
		return _account.getFax();
	}

	/**
	 * Returns the full name of this account.
	 *
	 * @return the full name of this account
	 */
	@Override
	public String getFullName() {
		return _account.getFullName();
	}

	/**
	 * Returns the gender of this account.
	 *
	 * @return the gender of this account
	 */
	@Override
	public int getGender() {
		return _account.getGender();
	}

	/**
	 * Returns the group ID of this account.
	 *
	 * @return the group ID of this account
	 */
	@Override
	public long getGroupId() {
		return _account.getGroupId();
	}

	/**
	 * Returns the guardian name of this account.
	 *
	 * @return the guardian name of this account
	 */
	@Override
	public String getGuardianName() {
		return _account.getGuardianName();
	}

	/**
	 * Returns the head household name of this account.
	 *
	 * @return the head household name of this account
	 */
	@Override
	public String getHeadHouseholdName() {
		return _account.getHeadHouseholdName();
	}

	/**
	 * Returns the ho so ID of this account.
	 *
	 * @return the ho so ID of this account
	 */
	@Override
	public long getHoSoId() {
		return _account.getHoSoId();
	}

	/**
	 * Returns the id dbxm of this account.
	 *
	 * @return the id dbxm of this account
	 */
	@Override
	public long getIdDBXM() {
		return _account.getIdDBXM();
	}

	/**
	 * Returns the insurance code of this account.
	 *
	 * @return the insurance code of this account
	 */
	@Override
	public String getInsuranceCode() {
		return _account.getInsuranceCode();
	}

	/**
	 * Returns the ip level of this account.
	 *
	 * @return the ip level of this account
	 */
	@Override
	public int getIpLevel() {
		return _account.getIpLevel();
	}

	/**
	 * Returns the issued by of this account.
	 *
	 * @return the issued by of this account
	 */
	@Override
	public String getIssuedBy() {
		return _account.getIssuedBy();
	}

	/**
	 * Returns the legal delegate of this account.
	 *
	 * @return the legal delegate of this account
	 */
	@Override
	public String getLegalDelegate() {
		return _account.getLegalDelegate();
	}

	/**
	 * Returns the marital status of this account.
	 *
	 * @return the marital status of this account
	 */
	@Override
	public int getMaritalStatus() {
		return _account.getMaritalStatus();
	}

	/**
	 * Returns the message of this account.
	 *
	 * @return the message of this account
	 */
	@Override
	public String getMessage() {
		return _account.getMessage();
	}

	/**
	 * Returns the modified date of this account.
	 *
	 * @return the modified date of this account
	 */
	@Override
	public Date getModifiedDate() {
		return _account.getModifiedDate();
	}

	/**
	 * Returns the mother name of this account.
	 *
	 * @return the mother name of this account
	 */
	@Override
	public String getMotherName() {
		return _account.getMotherName();
	}

	/**
	 * Returns the nation of this account.
	 *
	 * @return the nation of this account
	 */
	@Override
	public String getNation() {
		return _account.getNation();
	}

	/**
	 * Returns the nationality of this account.
	 *
	 * @return the nationality of this account
	 */
	@Override
	public String getNationality() {
		return _account.getNationality();
	}

	/**
	 * Returns the native place of this account.
	 *
	 * @return the native place of this account
	 */
	@Override
	public String getNativePlace() {
		return _account.getNativePlace();
	}

	/**
	 * Returns the note of this account.
	 *
	 * @return the note of this account
	 */
	@Override
	public String getNote() {
		return _account.getNote();
	}

	/**
	 * Returns the personal ID of this account.
	 *
	 * @return the personal ID of this account
	 */
	@Override
	public String getPersonalId() {
		return _account.getPersonalId();
	}

	@Override
	public java.util.List<dtt.vn.vnpost.model.Photo> getPhotos() {
		return _account.getPhotos();
	}

	@Override
	public java.util.List<dtt.vn.vnpost.model.Photo> getPhotos(
		String className) {

		return _account.getPhotos(className);
	}

	@Override
	public String getPhotoURL(
		com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay,
		long imageId) {

		return _account.getPhotoURL(themeDisplay, imageId);
	}

	/**
	 * Returns the primary key of this account.
	 *
	 * @return the primary key of this account
	 */
	@Override
	public long getPrimaryKey() {
		return _account.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _account.getPrimaryKeyObj();
	}

	/**
	 * Returns the process status of this account.
	 *
	 * @return the process status of this account
	 */
	@Override
	public int getProcessStatus() {
		return _account.getProcessStatus();
	}

	/**
	 * Returns the range date of this account.
	 *
	 * @return the range date of this account
	 */
	@Override
	public Date getRangeDate() {
		return _account.getRangeDate();
	}

	/**
	 * Returns the re open of this account.
	 *
	 * @return the re open of this account
	 */
	@Override
	public boolean getReOpen() {
		return _account.getReOpen();
	}

	/**
	 * Returns the representative name of this account.
	 *
	 * @return the representative name of this account
	 */
	@Override
	public String getRepresentativeName() {
		return _account.getRepresentativeName();
	}

	/**
	 * Returns the representative number of this account.
	 *
	 * @return the representative number of this account
	 */
	@Override
	public String getRepresentativeNumber() {
		return _account.getRepresentativeNumber();
	}

	/**
	 * Returns the representative tel no of this account.
	 *
	 * @return the representative tel no of this account
	 */
	@Override
	public String getRepresentativeTelNo() {
		return _account.getRepresentativeTelNo();
	}

	/**
	 * Returns the sign image ID of this account.
	 *
	 * @return the sign image ID of this account
	 */
	@Override
	public long getSignImageId() {
		return _account.getSignImageId();
	}

	/**
	 * Returns the spouse name of this account.
	 *
	 * @return the spouse name of this account
	 */
	@Override
	public String getSpouseName() {
		return _account.getSpouseName();
	}

	/**
	 * Returns the superior organization of this account.
	 *
	 * @return the superior organization of this account
	 */
	@Override
	public String getSuperiorOrganization() {
		return _account.getSuperiorOrganization();
	}

	/**
	 * Returns the tax code of this account.
	 *
	 * @return the tax code of this account
	 */
	@Override
	public String getTaxCode() {
		return _account.getTaxCode();
	}

	/**
	 * Returns the tel no of this account.
	 *
	 * @return the tel no of this account
	 */
	@Override
	public String getTelNo() {
		return _account.getTelNo();
	}

	@Override
	public String getThumbnailURL(
		com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay,
		long thumbnailId) {

		return _account.getThumbnailURL(themeDisplay, thumbnailId);
	}

	/**
	 * Returns the user ID of this account.
	 *
	 * @return the user ID of this account
	 */
	@Override
	public long getUserId() {
		return _account.getUserId();
	}

	/**
	 * Returns the user uuid of this account.
	 *
	 * @return the user uuid of this account
	 */
	@Override
	public String getUserUuid() {
		return _account.getUserUuid();
	}

	/**
	 * Returns the ward code of this account.
	 *
	 * @return the ward code of this account
	 */
	@Override
	public String getWardCode() {
		return _account.getWardCode();
	}

	/**
	 * Returns the ward code xm of this account.
	 *
	 * @return the ward code xm of this account
	 */
	@Override
	public String getWardCodeXM() {
		return _account.getWardCodeXM();
	}

	/**
	 * Returns the working place of this account.
	 *
	 * @return the working place of this account
	 */
	@Override
	public String getWorkingPlace() {
		return _account.getWorkingPlace();
	}

	@Override
	public int hashCode() {
		return _account.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _account.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _account.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _account.isNew();
	}

	/**
	 * Returns <code>true</code> if this account is re open.
	 *
	 * @return <code>true</code> if this account is re open; <code>false</code> otherwise
	 */
	@Override
	public boolean isReOpen() {
		return _account.isReOpen();
	}

	@Override
	public void persist() {
		_account.persist();
	}

	/**
	 * Sets the account ID of this account.
	 *
	 * @param accountId the account ID of this account
	 */
	@Override
	public void setAccountId(long accountId) {
		_account.setAccountId(accountId);
	}

	/**
	 * Sets the account name of this account.
	 *
	 * @param accountName the account name of this account
	 */
	@Override
	public void setAccountName(String accountName) {
		_account.setAccountName(accountName);
	}

	/**
	 * Sets the account status of this account.
	 *
	 * @param accountStatus the account status of this account
	 */
	@Override
	public void setAccountStatus(int accountStatus) {
		_account.setAccountStatus(accountStatus);
	}

	/**
	 * Sets the account type of this account.
	 *
	 * @param accountType the account type of this account
	 */
	@Override
	public void setAccountType(int accountType) {
		_account.setAccountType(accountType);
	}

	/**
	 * Sets the address of this account.
	 *
	 * @param address the address of this account
	 */
	@Override
	public void setAddress(String address) {
		_account.setAddress(address);
	}

	/**
	 * Sets the address xm of this account.
	 *
	 * @param addressXM the address xm of this account
	 */
	@Override
	public void setAddressXM(String addressXM) {
		_account.setAddressXM(addressXM);
	}

	/**
	 * Sets the assign user ID of this account.
	 *
	 * @param assignUserId the assign user ID of this account
	 */
	@Override
	public void setAssignUserId(long assignUserId) {
		_account.setAssignUserId(assignUserId);
	}

	/**
	 * Sets the assign user uuid of this account.
	 *
	 * @param assignUserUuid the assign user uuid of this account
	 */
	@Override
	public void setAssignUserUuid(String assignUserUuid) {
		_account.setAssignUserUuid(assignUserUuid);
	}

	/**
	 * Sets the attach file of this account.
	 *
	 * @param attachFile the attach file of this account
	 */
	@Override
	public void setAttachFile(long attachFile) {
		_account.setAttachFile(attachFile);
	}

	/**
	 * Sets the birthdate of this account.
	 *
	 * @param birthdate the birthdate of this account
	 */
	@Override
	public void setBirthdate(Date birthdate) {
		_account.setBirthdate(birthdate);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_account.setCachedModel(cachedModel);
	}

	/**
	 * Sets the city code of this account.
	 *
	 * @param cityCode the city code of this account
	 */
	@Override
	public void setCityCode(String cityCode) {
		_account.setCityCode(cityCode);
	}

	/**
	 * Sets the city code xm of this account.
	 *
	 * @param cityCodeXM the city code xm of this account
	 */
	@Override
	public void setCityCodeXM(String cityCodeXM) {
		_account.setCityCodeXM(cityCodeXM);
	}

	/**
	 * Sets the company ID of this account.
	 *
	 * @param companyId the company ID of this account
	 */
	@Override
	public void setCompanyId(long companyId) {
		_account.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this account.
	 *
	 * @param createDate the create date of this account
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_account.setCreateDate(createDate);
	}

	/**
	 * Sets the district code of this account.
	 *
	 * @param districtCode the district code of this account
	 */
	@Override
	public void setDistrictCode(String districtCode) {
		_account.setDistrictCode(districtCode);
	}

	/**
	 * Sets the district code xm of this account.
	 *
	 * @param districtCodeXM the district code xm of this account
	 */
	@Override
	public void setDistrictCodeXM(String districtCodeXM) {
		_account.setDistrictCodeXM(districtCodeXM);
	}

	/**
	 * Sets the email of this account.
	 *
	 * @param email the email of this account
	 */
	@Override
	public void setEmail(String email) {
		_account.setEmail(email);
	}

	/**
	 * Sets the ethnic group of this account.
	 *
	 * @param ethnicGroup the ethnic group of this account
	 */
	@Override
	public void setEthnicGroup(String ethnicGroup) {
		_account.setEthnicGroup(ethnicGroup);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_account.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_account.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_account.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the family reg no of this account.
	 *
	 * @param familyRegNo the family reg no of this account
	 */
	@Override
	public void setFamilyRegNo(String familyRegNo) {
		_account.setFamilyRegNo(familyRegNo);
	}

	/**
	 * Sets the father name of this account.
	 *
	 * @param fatherName the father name of this account
	 */
	@Override
	public void setFatherName(String fatherName) {
		_account.setFatherName(fatherName);
	}

	/**
	 * Sets the fax of this account.
	 *
	 * @param fax the fax of this account
	 */
	@Override
	public void setFax(String fax) {
		_account.setFax(fax);
	}

	/**
	 * Sets the full name of this account.
	 *
	 * @param fullName the full name of this account
	 */
	@Override
	public void setFullName(String fullName) {
		_account.setFullName(fullName);
	}

	/**
	 * Sets the gender of this account.
	 *
	 * @param gender the gender of this account
	 */
	@Override
	public void setGender(int gender) {
		_account.setGender(gender);
	}

	/**
	 * Sets the group ID of this account.
	 *
	 * @param groupId the group ID of this account
	 */
	@Override
	public void setGroupId(long groupId) {
		_account.setGroupId(groupId);
	}

	/**
	 * Sets the guardian name of this account.
	 *
	 * @param guardianName the guardian name of this account
	 */
	@Override
	public void setGuardianName(String guardianName) {
		_account.setGuardianName(guardianName);
	}

	/**
	 * Sets the head household name of this account.
	 *
	 * @param headHouseholdName the head household name of this account
	 */
	@Override
	public void setHeadHouseholdName(String headHouseholdName) {
		_account.setHeadHouseholdName(headHouseholdName);
	}

	/**
	 * Sets the ho so ID of this account.
	 *
	 * @param hoSoId the ho so ID of this account
	 */
	@Override
	public void setHoSoId(long hoSoId) {
		_account.setHoSoId(hoSoId);
	}

	/**
	 * Sets the id dbxm of this account.
	 *
	 * @param idDBXM the id dbxm of this account
	 */
	@Override
	public void setIdDBXM(long idDBXM) {
		_account.setIdDBXM(idDBXM);
	}

	/**
	 * Sets the insurance code of this account.
	 *
	 * @param insuranceCode the insurance code of this account
	 */
	@Override
	public void setInsuranceCode(String insuranceCode) {
		_account.setInsuranceCode(insuranceCode);
	}

	/**
	 * Sets the ip level of this account.
	 *
	 * @param ipLevel the ip level of this account
	 */
	@Override
	public void setIpLevel(int ipLevel) {
		_account.setIpLevel(ipLevel);
	}

	/**
	 * Sets the issued by of this account.
	 *
	 * @param issuedBy the issued by of this account
	 */
	@Override
	public void setIssuedBy(String issuedBy) {
		_account.setIssuedBy(issuedBy);
	}

	/**
	 * Sets the legal delegate of this account.
	 *
	 * @param legalDelegate the legal delegate of this account
	 */
	@Override
	public void setLegalDelegate(String legalDelegate) {
		_account.setLegalDelegate(legalDelegate);
	}

	/**
	 * Sets the marital status of this account.
	 *
	 * @param maritalStatus the marital status of this account
	 */
	@Override
	public void setMaritalStatus(int maritalStatus) {
		_account.setMaritalStatus(maritalStatus);
	}

	/**
	 * Sets the message of this account.
	 *
	 * @param message the message of this account
	 */
	@Override
	public void setMessage(String message) {
		_account.setMessage(message);
	}

	/**
	 * Sets the modified date of this account.
	 *
	 * @param modifiedDate the modified date of this account
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_account.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the mother name of this account.
	 *
	 * @param motherName the mother name of this account
	 */
	@Override
	public void setMotherName(String motherName) {
		_account.setMotherName(motherName);
	}

	/**
	 * Sets the nation of this account.
	 *
	 * @param nation the nation of this account
	 */
	@Override
	public void setNation(String nation) {
		_account.setNation(nation);
	}

	/**
	 * Sets the nationality of this account.
	 *
	 * @param nationality the nationality of this account
	 */
	@Override
	public void setNationality(String nationality) {
		_account.setNationality(nationality);
	}

	/**
	 * Sets the native place of this account.
	 *
	 * @param nativePlace the native place of this account
	 */
	@Override
	public void setNativePlace(String nativePlace) {
		_account.setNativePlace(nativePlace);
	}

	@Override
	public void setNew(boolean n) {
		_account.setNew(n);
	}

	/**
	 * Sets the note of this account.
	 *
	 * @param note the note of this account
	 */
	@Override
	public void setNote(String note) {
		_account.setNote(note);
	}

	/**
	 * Sets the personal ID of this account.
	 *
	 * @param personalId the personal ID of this account
	 */
	@Override
	public void setPersonalId(String personalId) {
		_account.setPersonalId(personalId);
	}

	/**
	 * Sets the primary key of this account.
	 *
	 * @param primaryKey the primary key of this account
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_account.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_account.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the process status of this account.
	 *
	 * @param processStatus the process status of this account
	 */
	@Override
	public void setProcessStatus(int processStatus) {
		_account.setProcessStatus(processStatus);
	}

	/**
	 * Sets the range date of this account.
	 *
	 * @param rangeDate the range date of this account
	 */
	@Override
	public void setRangeDate(Date rangeDate) {
		_account.setRangeDate(rangeDate);
	}

	/**
	 * Sets whether this account is re open.
	 *
	 * @param reOpen the re open of this account
	 */
	@Override
	public void setReOpen(boolean reOpen) {
		_account.setReOpen(reOpen);
	}

	/**
	 * Sets the representative name of this account.
	 *
	 * @param representativeName the representative name of this account
	 */
	@Override
	public void setRepresentativeName(String representativeName) {
		_account.setRepresentativeName(representativeName);
	}

	/**
	 * Sets the representative number of this account.
	 *
	 * @param representativeNumber the representative number of this account
	 */
	@Override
	public void setRepresentativeNumber(String representativeNumber) {
		_account.setRepresentativeNumber(representativeNumber);
	}

	/**
	 * Sets the representative tel no of this account.
	 *
	 * @param representativeTelNo the representative tel no of this account
	 */
	@Override
	public void setRepresentativeTelNo(String representativeTelNo) {
		_account.setRepresentativeTelNo(representativeTelNo);
	}

	/**
	 * Sets the sign image ID of this account.
	 *
	 * @param signImageId the sign image ID of this account
	 */
	@Override
	public void setSignImageId(long signImageId) {
		_account.setSignImageId(signImageId);
	}

	/**
	 * Sets the spouse name of this account.
	 *
	 * @param spouseName the spouse name of this account
	 */
	@Override
	public void setSpouseName(String spouseName) {
		_account.setSpouseName(spouseName);
	}

	/**
	 * Sets the superior organization of this account.
	 *
	 * @param superiorOrganization the superior organization of this account
	 */
	@Override
	public void setSuperiorOrganization(String superiorOrganization) {
		_account.setSuperiorOrganization(superiorOrganization);
	}

	/**
	 * Sets the tax code of this account.
	 *
	 * @param taxCode the tax code of this account
	 */
	@Override
	public void setTaxCode(String taxCode) {
		_account.setTaxCode(taxCode);
	}

	/**
	 * Sets the tel no of this account.
	 *
	 * @param telNo the tel no of this account
	 */
	@Override
	public void setTelNo(String telNo) {
		_account.setTelNo(telNo);
	}

	/**
	 * Sets the user ID of this account.
	 *
	 * @param userId the user ID of this account
	 */
	@Override
	public void setUserId(long userId) {
		_account.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this account.
	 *
	 * @param userUuid the user uuid of this account
	 */
	@Override
	public void setUserUuid(String userUuid) {
		_account.setUserUuid(userUuid);
	}

	/**
	 * Sets the ward code of this account.
	 *
	 * @param wardCode the ward code of this account
	 */
	@Override
	public void setWardCode(String wardCode) {
		_account.setWardCode(wardCode);
	}

	/**
	 * Sets the ward code xm of this account.
	 *
	 * @param wardCodeXM the ward code xm of this account
	 */
	@Override
	public void setWardCodeXM(String wardCodeXM) {
		_account.setWardCodeXM(wardCodeXM);
	}

	/**
	 * Sets the working place of this account.
	 *
	 * @param workingPlace the working place of this account
	 */
	@Override
	public void setWorkingPlace(String workingPlace) {
		_account.setWorkingPlace(workingPlace);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<dtt.vn.vnpost.model.Account> toCacheModel() {

		return _account.toCacheModel();
	}

	@Override
	public dtt.vn.vnpost.model.Account toEscapedModel() {
		return new AccountWrapper(_account.toEscapedModel());
	}

	@Override
	public String toString() {
		return _account.toString();
	}

	@Override
	public dtt.vn.vnpost.model.Account toUnescapedModel() {
		return new AccountWrapper(_account.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _account.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AccountWrapper)) {
			return false;
		}

		AccountWrapper accountWrapper = (AccountWrapper)obj;

		if (Objects.equals(_account, accountWrapper._account)) {
			return true;
		}

		return false;
	}

	@Override
	public Account getWrappedModel() {
		return _account;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _account.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _account.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_account.resetOriginalValues();
	}

	private final Account _account;

}