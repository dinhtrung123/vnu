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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link dtt.vn.vnpost.service.http.AccountServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class AccountSoap implements Serializable {

	public static AccountSoap toSoapModel(Account model) {
		AccountSoap soapModel = new AccountSoap();

		soapModel.setAccountId(model.getAccountId());
		soapModel.setAccountType(model.getAccountType());
		soapModel.setAccountName(model.getAccountName());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setFullName(model.getFullName());
		soapModel.setBirthdate(model.getBirthdate());
		soapModel.setEmail(model.getEmail());
		soapModel.setTelNo(model.getTelNo());
		soapModel.setPersonalId(model.getPersonalId());
		soapModel.setAddress(model.getAddress());
		soapModel.setGender(model.getGender());
		soapModel.setLegalDelegate(model.getLegalDelegate());
		soapModel.setTaxCode(model.getTaxCode());
		soapModel.setInsuranceCode(model.getInsuranceCode());
		soapModel.setNationality(model.getNationality());
		soapModel.setEthnicGroup(model.getEthnicGroup());
		soapModel.setFamilyRegNo(model.getFamilyRegNo());
		soapModel.setMaritalStatus(model.getMaritalStatus());
		soapModel.setWorkingPlace(model.getWorkingPlace());
		soapModel.setNativePlace(model.getNativePlace());
		soapModel.setRangeDate(model.getRangeDate());
		soapModel.setIssuedBy(model.getIssuedBy());
		soapModel.setFatherName(model.getFatherName());
		soapModel.setMotherName(model.getMotherName());
		soapModel.setGuardianName(model.getGuardianName());
		soapModel.setSpouseName(model.getSpouseName());
		soapModel.setHeadHouseholdName(model.getHeadHouseholdName());
		soapModel.setNation(model.getNation());
		soapModel.setRepresentativeNumber(model.getRepresentativeNumber());
		soapModel.setRepresentativeName(model.getRepresentativeName());
		soapModel.setRepresentativeTelNo(model.getRepresentativeTelNo());
		soapModel.setFax(model.getFax());
		soapModel.setSuperiorOrganization(model.getSuperiorOrganization());
		soapModel.setNote(model.getNote());
		soapModel.setIdDBXM(model.getIdDBXM());
		soapModel.setCityCode(model.getCityCode());
		soapModel.setDistrictCode(model.getDistrictCode());
		soapModel.setWardCode(model.getWardCode());
		soapModel.setCityCodeXM(model.getCityCodeXM());
		soapModel.setDistrictCodeXM(model.getDistrictCodeXM());
		soapModel.setWardCodeXM(model.getWardCodeXM());
		soapModel.setAddressXM(model.getAddressXM());
		soapModel.setAttachFile(model.getAttachFile());
		soapModel.setAccountStatus(model.getAccountStatus());
		soapModel.setProcessStatus(model.getProcessStatus());
		soapModel.setSignImageId(model.getSignImageId());
		soapModel.setHoSoId(model.getHoSoId());
		soapModel.setMessage(model.getMessage());
		soapModel.setAssignUserId(model.getAssignUserId());
		soapModel.setIpLevel(model.getIpLevel());
		soapModel.setReOpen(model.isReOpen());

		return soapModel;
	}

	public static AccountSoap[] toSoapModels(Account[] models) {
		AccountSoap[] soapModels = new AccountSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AccountSoap[][] toSoapModels(Account[][] models) {
		AccountSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AccountSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AccountSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AccountSoap[] toSoapModels(List<Account> models) {
		List<AccountSoap> soapModels = new ArrayList<AccountSoap>(
			models.size());

		for (Account model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AccountSoap[soapModels.size()]);
	}

	public AccountSoap() {
	}

	public long getPrimaryKey() {
		return _accountId;
	}

	public void setPrimaryKey(long pk) {
		setAccountId(pk);
	}

	public long getAccountId() {
		return _accountId;
	}

	public void setAccountId(long accountId) {
		_accountId = accountId;
	}

	public int getAccountType() {
		return _accountType;
	}

	public void setAccountType(int accountType) {
		_accountType = accountType;
	}

	public String getAccountName() {
		return _accountName;
	}

	public void setAccountName(String accountName) {
		_accountName = accountName;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getFullName() {
		return _fullName;
	}

	public void setFullName(String fullName) {
		_fullName = fullName;
	}

	public Date getBirthdate() {
		return _birthdate;
	}

	public void setBirthdate(Date birthdate) {
		_birthdate = birthdate;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getTelNo() {
		return _telNo;
	}

	public void setTelNo(String telNo) {
		_telNo = telNo;
	}

	public String getPersonalId() {
		return _personalId;
	}

	public void setPersonalId(String personalId) {
		_personalId = personalId;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	public int getGender() {
		return _gender;
	}

	public void setGender(int gender) {
		_gender = gender;
	}

	public String getLegalDelegate() {
		return _legalDelegate;
	}

	public void setLegalDelegate(String legalDelegate) {
		_legalDelegate = legalDelegate;
	}

	public String getTaxCode() {
		return _taxCode;
	}

	public void setTaxCode(String taxCode) {
		_taxCode = taxCode;
	}

	public String getInsuranceCode() {
		return _insuranceCode;
	}

	public void setInsuranceCode(String insuranceCode) {
		_insuranceCode = insuranceCode;
	}

	public String getNationality() {
		return _nationality;
	}

	public void setNationality(String nationality) {
		_nationality = nationality;
	}

	public String getEthnicGroup() {
		return _ethnicGroup;
	}

	public void setEthnicGroup(String ethnicGroup) {
		_ethnicGroup = ethnicGroup;
	}

	public String getFamilyRegNo() {
		return _familyRegNo;
	}

	public void setFamilyRegNo(String familyRegNo) {
		_familyRegNo = familyRegNo;
	}

	public int getMaritalStatus() {
		return _maritalStatus;
	}

	public void setMaritalStatus(int maritalStatus) {
		_maritalStatus = maritalStatus;
	}

	public String getWorkingPlace() {
		return _workingPlace;
	}

	public void setWorkingPlace(String workingPlace) {
		_workingPlace = workingPlace;
	}

	public String getNativePlace() {
		return _nativePlace;
	}

	public void setNativePlace(String nativePlace) {
		_nativePlace = nativePlace;
	}

	public Date getRangeDate() {
		return _rangeDate;
	}

	public void setRangeDate(Date rangeDate) {
		_rangeDate = rangeDate;
	}

	public String getIssuedBy() {
		return _issuedBy;
	}

	public void setIssuedBy(String issuedBy) {
		_issuedBy = issuedBy;
	}

	public String getFatherName() {
		return _fatherName;
	}

	public void setFatherName(String fatherName) {
		_fatherName = fatherName;
	}

	public String getMotherName() {
		return _motherName;
	}

	public void setMotherName(String motherName) {
		_motherName = motherName;
	}

	public String getGuardianName() {
		return _guardianName;
	}

	public void setGuardianName(String guardianName) {
		_guardianName = guardianName;
	}

	public String getSpouseName() {
		return _spouseName;
	}

	public void setSpouseName(String spouseName) {
		_spouseName = spouseName;
	}

	public String getHeadHouseholdName() {
		return _headHouseholdName;
	}

	public void setHeadHouseholdName(String headHouseholdName) {
		_headHouseholdName = headHouseholdName;
	}

	public String getNation() {
		return _nation;
	}

	public void setNation(String nation) {
		_nation = nation;
	}

	public String getRepresentativeNumber() {
		return _representativeNumber;
	}

	public void setRepresentativeNumber(String representativeNumber) {
		_representativeNumber = representativeNumber;
	}

	public String getRepresentativeName() {
		return _representativeName;
	}

	public void setRepresentativeName(String representativeName) {
		_representativeName = representativeName;
	}

	public String getRepresentativeTelNo() {
		return _representativeTelNo;
	}

	public void setRepresentativeTelNo(String representativeTelNo) {
		_representativeTelNo = representativeTelNo;
	}

	public String getFax() {
		return _fax;
	}

	public void setFax(String fax) {
		_fax = fax;
	}

	public String getSuperiorOrganization() {
		return _superiorOrganization;
	}

	public void setSuperiorOrganization(String superiorOrganization) {
		_superiorOrganization = superiorOrganization;
	}

	public String getNote() {
		return _note;
	}

	public void setNote(String note) {
		_note = note;
	}

	public long getIdDBXM() {
		return _idDBXM;
	}

	public void setIdDBXM(long idDBXM) {
		_idDBXM = idDBXM;
	}

	public String getCityCode() {
		return _cityCode;
	}

	public void setCityCode(String cityCode) {
		_cityCode = cityCode;
	}

	public String getDistrictCode() {
		return _districtCode;
	}

	public void setDistrictCode(String districtCode) {
		_districtCode = districtCode;
	}

	public String getWardCode() {
		return _wardCode;
	}

	public void setWardCode(String wardCode) {
		_wardCode = wardCode;
	}

	public String getCityCodeXM() {
		return _cityCodeXM;
	}

	public void setCityCodeXM(String cityCodeXM) {
		_cityCodeXM = cityCodeXM;
	}

	public String getDistrictCodeXM() {
		return _districtCodeXM;
	}

	public void setDistrictCodeXM(String districtCodeXM) {
		_districtCodeXM = districtCodeXM;
	}

	public String getWardCodeXM() {
		return _wardCodeXM;
	}

	public void setWardCodeXM(String wardCodeXM) {
		_wardCodeXM = wardCodeXM;
	}

	public String getAddressXM() {
		return _addressXM;
	}

	public void setAddressXM(String addressXM) {
		_addressXM = addressXM;
	}

	public long getAttachFile() {
		return _attachFile;
	}

	public void setAttachFile(long attachFile) {
		_attachFile = attachFile;
	}

	public int getAccountStatus() {
		return _accountStatus;
	}

	public void setAccountStatus(int accountStatus) {
		_accountStatus = accountStatus;
	}

	public int getProcessStatus() {
		return _processStatus;
	}

	public void setProcessStatus(int processStatus) {
		_processStatus = processStatus;
	}

	public long getSignImageId() {
		return _signImageId;
	}

	public void setSignImageId(long signImageId) {
		_signImageId = signImageId;
	}

	public long getHoSoId() {
		return _hoSoId;
	}

	public void setHoSoId(long hoSoId) {
		_hoSoId = hoSoId;
	}

	public String getMessage() {
		return _message;
	}

	public void setMessage(String message) {
		_message = message;
	}

	public long getAssignUserId() {
		return _assignUserId;
	}

	public void setAssignUserId(long assignUserId) {
		_assignUserId = assignUserId;
	}

	public int getIpLevel() {
		return _ipLevel;
	}

	public void setIpLevel(int ipLevel) {
		_ipLevel = ipLevel;
	}

	public boolean getReOpen() {
		return _reOpen;
	}

	public boolean isReOpen() {
		return _reOpen;
	}

	public void setReOpen(boolean reOpen) {
		_reOpen = reOpen;
	}

	private long _accountId;
	private int _accountType;
	private String _accountName;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _fullName;
	private Date _birthdate;
	private String _email;
	private String _telNo;
	private String _personalId;
	private String _address;
	private int _gender;
	private String _legalDelegate;
	private String _taxCode;
	private String _insuranceCode;
	private String _nationality;
	private String _ethnicGroup;
	private String _familyRegNo;
	private int _maritalStatus;
	private String _workingPlace;
	private String _nativePlace;
	private Date _rangeDate;
	private String _issuedBy;
	private String _fatherName;
	private String _motherName;
	private String _guardianName;
	private String _spouseName;
	private String _headHouseholdName;
	private String _nation;
	private String _representativeNumber;
	private String _representativeName;
	private String _representativeTelNo;
	private String _fax;
	private String _superiorOrganization;
	private String _note;
	private long _idDBXM;
	private String _cityCode;
	private String _districtCode;
	private String _wardCode;
	private String _cityCodeXM;
	private String _districtCodeXM;
	private String _wardCodeXM;
	private String _addressXM;
	private long _attachFile;
	private int _accountStatus;
	private int _processStatus;
	private long _signImageId;
	private long _hoSoId;
	private String _message;
	private long _assignUserId;
	private int _ipLevel;
	private boolean _reOpen;

}