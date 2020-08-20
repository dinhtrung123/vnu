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
import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Account service. Represents a row in the &quot;idm_Account&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>dtt.vn.vnpost.model.impl.AccountModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>dtt.vn.vnpost.model.impl.AccountImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Account
 * @generated
 */
@ProviderType
public interface AccountModel extends BaseModel<Account>, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a account model instance should use the {@link Account} interface instead.
	 */

	/**
	 * Returns the primary key of this account.
	 *
	 * @return the primary key of this account
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this account.
	 *
	 * @param primaryKey the primary key of this account
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the account ID of this account.
	 *
	 * @return the account ID of this account
	 */
	public long getAccountId();

	/**
	 * Sets the account ID of this account.
	 *
	 * @param accountId the account ID of this account
	 */
	public void setAccountId(long accountId);

	/**
	 * Returns the account type of this account.
	 *
	 * @return the account type of this account
	 */
	public int getAccountType();

	/**
	 * Sets the account type of this account.
	 *
	 * @param accountType the account type of this account
	 */
	public void setAccountType(int accountType);

	/**
	 * Returns the account name of this account.
	 *
	 * @return the account name of this account
	 */
	@AutoEscape
	public String getAccountName();

	/**
	 * Sets the account name of this account.
	 *
	 * @param accountName the account name of this account
	 */
	public void setAccountName(String accountName);

	/**
	 * Returns the company ID of this account.
	 *
	 * @return the company ID of this account
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this account.
	 *
	 * @param companyId the company ID of this account
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this account.
	 *
	 * @return the group ID of this account
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this account.
	 *
	 * @param groupId the group ID of this account
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the user ID of this account.
	 *
	 * @return the user ID of this account
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this account.
	 *
	 * @param userId the user ID of this account
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this account.
	 *
	 * @return the user uuid of this account
	 */
	public String getUserUuid();

	/**
	 * Sets the user uuid of this account.
	 *
	 * @param userUuid the user uuid of this account
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the create date of this account.
	 *
	 * @return the create date of this account
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this account.
	 *
	 * @param createDate the create date of this account
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this account.
	 *
	 * @return the modified date of this account
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this account.
	 *
	 * @param modifiedDate the modified date of this account
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the full name of this account.
	 *
	 * @return the full name of this account
	 */
	@AutoEscape
	public String getFullName();

	/**
	 * Sets the full name of this account.
	 *
	 * @param fullName the full name of this account
	 */
	public void setFullName(String fullName);

	/**
	 * Returns the birthdate of this account.
	 *
	 * @return the birthdate of this account
	 */
	public Date getBirthdate();

	/**
	 * Sets the birthdate of this account.
	 *
	 * @param birthdate the birthdate of this account
	 */
	public void setBirthdate(Date birthdate);

	/**
	 * Returns the email of this account.
	 *
	 * @return the email of this account
	 */
	@AutoEscape
	public String getEmail();

	/**
	 * Sets the email of this account.
	 *
	 * @param email the email of this account
	 */
	public void setEmail(String email);

	/**
	 * Returns the tel no of this account.
	 *
	 * @return the tel no of this account
	 */
	@AutoEscape
	public String getTelNo();

	/**
	 * Sets the tel no of this account.
	 *
	 * @param telNo the tel no of this account
	 */
	public void setTelNo(String telNo);

	/**
	 * Returns the personal ID of this account.
	 *
	 * @return the personal ID of this account
	 */
	@AutoEscape
	public String getPersonalId();

	/**
	 * Sets the personal ID of this account.
	 *
	 * @param personalId the personal ID of this account
	 */
	public void setPersonalId(String personalId);

	/**
	 * Returns the address of this account.
	 *
	 * @return the address of this account
	 */
	@AutoEscape
	public String getAddress();

	/**
	 * Sets the address of this account.
	 *
	 * @param address the address of this account
	 */
	public void setAddress(String address);

	/**
	 * Returns the gender of this account.
	 *
	 * @return the gender of this account
	 */
	public int getGender();

	/**
	 * Sets the gender of this account.
	 *
	 * @param gender the gender of this account
	 */
	public void setGender(int gender);

	/**
	 * Returns the legal delegate of this account.
	 *
	 * @return the legal delegate of this account
	 */
	@AutoEscape
	public String getLegalDelegate();

	/**
	 * Sets the legal delegate of this account.
	 *
	 * @param legalDelegate the legal delegate of this account
	 */
	public void setLegalDelegate(String legalDelegate);

	/**
	 * Returns the tax code of this account.
	 *
	 * @return the tax code of this account
	 */
	@AutoEscape
	public String getTaxCode();

	/**
	 * Sets the tax code of this account.
	 *
	 * @param taxCode the tax code of this account
	 */
	public void setTaxCode(String taxCode);

	/**
	 * Returns the insurance code of this account.
	 *
	 * @return the insurance code of this account
	 */
	@AutoEscape
	public String getInsuranceCode();

	/**
	 * Sets the insurance code of this account.
	 *
	 * @param insuranceCode the insurance code of this account
	 */
	public void setInsuranceCode(String insuranceCode);

	/**
	 * Returns the nationality of this account.
	 *
	 * @return the nationality of this account
	 */
	@AutoEscape
	public String getNationality();

	/**
	 * Sets the nationality of this account.
	 *
	 * @param nationality the nationality of this account
	 */
	public void setNationality(String nationality);

	/**
	 * Returns the ethnic group of this account.
	 *
	 * @return the ethnic group of this account
	 */
	@AutoEscape
	public String getEthnicGroup();

	/**
	 * Sets the ethnic group of this account.
	 *
	 * @param ethnicGroup the ethnic group of this account
	 */
	public void setEthnicGroup(String ethnicGroup);

	/**
	 * Returns the family reg no of this account.
	 *
	 * @return the family reg no of this account
	 */
	@AutoEscape
	public String getFamilyRegNo();

	/**
	 * Sets the family reg no of this account.
	 *
	 * @param familyRegNo the family reg no of this account
	 */
	public void setFamilyRegNo(String familyRegNo);

	/**
	 * Returns the marital status of this account.
	 *
	 * @return the marital status of this account
	 */
	public int getMaritalStatus();

	/**
	 * Sets the marital status of this account.
	 *
	 * @param maritalStatus the marital status of this account
	 */
	public void setMaritalStatus(int maritalStatus);

	/**
	 * Returns the working place of this account.
	 *
	 * @return the working place of this account
	 */
	@AutoEscape
	public String getWorkingPlace();

	/**
	 * Sets the working place of this account.
	 *
	 * @param workingPlace the working place of this account
	 */
	public void setWorkingPlace(String workingPlace);

	/**
	 * Returns the native place of this account.
	 *
	 * @return the native place of this account
	 */
	@AutoEscape
	public String getNativePlace();

	/**
	 * Sets the native place of this account.
	 *
	 * @param nativePlace the native place of this account
	 */
	public void setNativePlace(String nativePlace);

	/**
	 * Returns the range date of this account.
	 *
	 * @return the range date of this account
	 */
	public Date getRangeDate();

	/**
	 * Sets the range date of this account.
	 *
	 * @param rangeDate the range date of this account
	 */
	public void setRangeDate(Date rangeDate);

	/**
	 * Returns the issued by of this account.
	 *
	 * @return the issued by of this account
	 */
	@AutoEscape
	public String getIssuedBy();

	/**
	 * Sets the issued by of this account.
	 *
	 * @param issuedBy the issued by of this account
	 */
	public void setIssuedBy(String issuedBy);

	/**
	 * Returns the father name of this account.
	 *
	 * @return the father name of this account
	 */
	@AutoEscape
	public String getFatherName();

	/**
	 * Sets the father name of this account.
	 *
	 * @param fatherName the father name of this account
	 */
	public void setFatherName(String fatherName);

	/**
	 * Returns the mother name of this account.
	 *
	 * @return the mother name of this account
	 */
	@AutoEscape
	public String getMotherName();

	/**
	 * Sets the mother name of this account.
	 *
	 * @param motherName the mother name of this account
	 */
	public void setMotherName(String motherName);

	/**
	 * Returns the guardian name of this account.
	 *
	 * @return the guardian name of this account
	 */
	@AutoEscape
	public String getGuardianName();

	/**
	 * Sets the guardian name of this account.
	 *
	 * @param guardianName the guardian name of this account
	 */
	public void setGuardianName(String guardianName);

	/**
	 * Returns the spouse name of this account.
	 *
	 * @return the spouse name of this account
	 */
	@AutoEscape
	public String getSpouseName();

	/**
	 * Sets the spouse name of this account.
	 *
	 * @param spouseName the spouse name of this account
	 */
	public void setSpouseName(String spouseName);

	/**
	 * Returns the head household name of this account.
	 *
	 * @return the head household name of this account
	 */
	@AutoEscape
	public String getHeadHouseholdName();

	/**
	 * Sets the head household name of this account.
	 *
	 * @param headHouseholdName the head household name of this account
	 */
	public void setHeadHouseholdName(String headHouseholdName);

	/**
	 * Returns the nation of this account.
	 *
	 * @return the nation of this account
	 */
	@AutoEscape
	public String getNation();

	/**
	 * Sets the nation of this account.
	 *
	 * @param nation the nation of this account
	 */
	public void setNation(String nation);

	/**
	 * Returns the representative number of this account.
	 *
	 * @return the representative number of this account
	 */
	@AutoEscape
	public String getRepresentativeNumber();

	/**
	 * Sets the representative number of this account.
	 *
	 * @param representativeNumber the representative number of this account
	 */
	public void setRepresentativeNumber(String representativeNumber);

	/**
	 * Returns the representative name of this account.
	 *
	 * @return the representative name of this account
	 */
	@AutoEscape
	public String getRepresentativeName();

	/**
	 * Sets the representative name of this account.
	 *
	 * @param representativeName the representative name of this account
	 */
	public void setRepresentativeName(String representativeName);

	/**
	 * Returns the representative tel no of this account.
	 *
	 * @return the representative tel no of this account
	 */
	@AutoEscape
	public String getRepresentativeTelNo();

	/**
	 * Sets the representative tel no of this account.
	 *
	 * @param representativeTelNo the representative tel no of this account
	 */
	public void setRepresentativeTelNo(String representativeTelNo);

	/**
	 * Returns the fax of this account.
	 *
	 * @return the fax of this account
	 */
	@AutoEscape
	public String getFax();

	/**
	 * Sets the fax of this account.
	 *
	 * @param fax the fax of this account
	 */
	public void setFax(String fax);

	/**
	 * Returns the superior organization of this account.
	 *
	 * @return the superior organization of this account
	 */
	@AutoEscape
	public String getSuperiorOrganization();

	/**
	 * Sets the superior organization of this account.
	 *
	 * @param superiorOrganization the superior organization of this account
	 */
	public void setSuperiorOrganization(String superiorOrganization);

	/**
	 * Returns the note of this account.
	 *
	 * @return the note of this account
	 */
	@AutoEscape
	public String getNote();

	/**
	 * Sets the note of this account.
	 *
	 * @param note the note of this account
	 */
	public void setNote(String note);

	/**
	 * Returns the id dbxm of this account.
	 *
	 * @return the id dbxm of this account
	 */
	public long getIdDBXM();

	/**
	 * Sets the id dbxm of this account.
	 *
	 * @param idDBXM the id dbxm of this account
	 */
	public void setIdDBXM(long idDBXM);

	/**
	 * Returns the city code of this account.
	 *
	 * @return the city code of this account
	 */
	@AutoEscape
	public String getCityCode();

	/**
	 * Sets the city code of this account.
	 *
	 * @param cityCode the city code of this account
	 */
	public void setCityCode(String cityCode);

	/**
	 * Returns the district code of this account.
	 *
	 * @return the district code of this account
	 */
	@AutoEscape
	public String getDistrictCode();

	/**
	 * Sets the district code of this account.
	 *
	 * @param districtCode the district code of this account
	 */
	public void setDistrictCode(String districtCode);

	/**
	 * Returns the ward code of this account.
	 *
	 * @return the ward code of this account
	 */
	@AutoEscape
	public String getWardCode();

	/**
	 * Sets the ward code of this account.
	 *
	 * @param wardCode the ward code of this account
	 */
	public void setWardCode(String wardCode);

	/**
	 * Returns the city code xm of this account.
	 *
	 * @return the city code xm of this account
	 */
	@AutoEscape
	public String getCityCodeXM();

	/**
	 * Sets the city code xm of this account.
	 *
	 * @param cityCodeXM the city code xm of this account
	 */
	public void setCityCodeXM(String cityCodeXM);

	/**
	 * Returns the district code xm of this account.
	 *
	 * @return the district code xm of this account
	 */
	@AutoEscape
	public String getDistrictCodeXM();

	/**
	 * Sets the district code xm of this account.
	 *
	 * @param districtCodeXM the district code xm of this account
	 */
	public void setDistrictCodeXM(String districtCodeXM);

	/**
	 * Returns the ward code xm of this account.
	 *
	 * @return the ward code xm of this account
	 */
	@AutoEscape
	public String getWardCodeXM();

	/**
	 * Sets the ward code xm of this account.
	 *
	 * @param wardCodeXM the ward code xm of this account
	 */
	public void setWardCodeXM(String wardCodeXM);

	/**
	 * Returns the address xm of this account.
	 *
	 * @return the address xm of this account
	 */
	@AutoEscape
	public String getAddressXM();

	/**
	 * Sets the address xm of this account.
	 *
	 * @param addressXM the address xm of this account
	 */
	public void setAddressXM(String addressXM);

	/**
	 * Returns the attach file of this account.
	 *
	 * @return the attach file of this account
	 */
	public long getAttachFile();

	/**
	 * Sets the attach file of this account.
	 *
	 * @param attachFile the attach file of this account
	 */
	public void setAttachFile(long attachFile);

	/**
	 * Returns the account status of this account.
	 *
	 * @return the account status of this account
	 */
	public int getAccountStatus();

	/**
	 * Sets the account status of this account.
	 *
	 * @param accountStatus the account status of this account
	 */
	public void setAccountStatus(int accountStatus);

	/**
	 * Returns the process status of this account.
	 *
	 * @return the process status of this account
	 */
	public int getProcessStatus();

	/**
	 * Sets the process status of this account.
	 *
	 * @param processStatus the process status of this account
	 */
	public void setProcessStatus(int processStatus);

	/**
	 * Returns the sign image ID of this account.
	 *
	 * @return the sign image ID of this account
	 */
	public long getSignImageId();

	/**
	 * Sets the sign image ID of this account.
	 *
	 * @param signImageId the sign image ID of this account
	 */
	public void setSignImageId(long signImageId);

	/**
	 * Returns the ho so ID of this account.
	 *
	 * @return the ho so ID of this account
	 */
	public long getHoSoId();

	/**
	 * Sets the ho so ID of this account.
	 *
	 * @param hoSoId the ho so ID of this account
	 */
	public void setHoSoId(long hoSoId);

	/**
	 * Returns the message of this account.
	 *
	 * @return the message of this account
	 */
	@AutoEscape
	public String getMessage();

	/**
	 * Sets the message of this account.
	 *
	 * @param message the message of this account
	 */
	public void setMessage(String message);

	/**
	 * Returns the assign user ID of this account.
	 *
	 * @return the assign user ID of this account
	 */
	public long getAssignUserId();

	/**
	 * Sets the assign user ID of this account.
	 *
	 * @param assignUserId the assign user ID of this account
	 */
	public void setAssignUserId(long assignUserId);

	/**
	 * Returns the assign user uuid of this account.
	 *
	 * @return the assign user uuid of this account
	 */
	public String getAssignUserUuid();

	/**
	 * Sets the assign user uuid of this account.
	 *
	 * @param assignUserUuid the assign user uuid of this account
	 */
	public void setAssignUserUuid(String assignUserUuid);

	/**
	 * Returns the ip level of this account.
	 *
	 * @return the ip level of this account
	 */
	public int getIpLevel();

	/**
	 * Sets the ip level of this account.
	 *
	 * @param ipLevel the ip level of this account
	 */
	public void setIpLevel(int ipLevel);

	/**
	 * Returns the re open of this account.
	 *
	 * @return the re open of this account
	 */
	public boolean getReOpen();

	/**
	 * Returns <code>true</code> if this account is re open.
	 *
	 * @return <code>true</code> if this account is re open; <code>false</code> otherwise
	 */
	public boolean isReOpen();

	/**
	 * Sets whether this account is re open.
	 *
	 * @param reOpen the re open of this account
	 */
	public void setReOpen(boolean reOpen);

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
	public int compareTo(dtt.vn.vnpost.model.Account account);

	@Override
	public int hashCode();

	@Override
	public CacheModel<dtt.vn.vnpost.model.Account> toCacheModel();

	@Override
	public dtt.vn.vnpost.model.Account toEscapedModel();

	@Override
	public dtt.vn.vnpost.model.Account toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();

}