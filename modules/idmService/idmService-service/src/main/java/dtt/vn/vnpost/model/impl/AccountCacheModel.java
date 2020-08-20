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

package dtt.vn.vnpost.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import dtt.vn.vnpost.model.Account;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Account in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class AccountCacheModel implements CacheModel<Account>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AccountCacheModel)) {
			return false;
		}

		AccountCacheModel accountCacheModel = (AccountCacheModel)obj;

		if (accountId == accountCacheModel.accountId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, accountId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(111);

		sb.append("{accountId=");
		sb.append(accountId);
		sb.append(", accountType=");
		sb.append(accountType);
		sb.append(", accountName=");
		sb.append(accountName);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", fullName=");
		sb.append(fullName);
		sb.append(", birthdate=");
		sb.append(birthdate);
		sb.append(", email=");
		sb.append(email);
		sb.append(", telNo=");
		sb.append(telNo);
		sb.append(", personalId=");
		sb.append(personalId);
		sb.append(", address=");
		sb.append(address);
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", legalDelegate=");
		sb.append(legalDelegate);
		sb.append(", taxCode=");
		sb.append(taxCode);
		sb.append(", insuranceCode=");
		sb.append(insuranceCode);
		sb.append(", nationality=");
		sb.append(nationality);
		sb.append(", ethnicGroup=");
		sb.append(ethnicGroup);
		sb.append(", familyRegNo=");
		sb.append(familyRegNo);
		sb.append(", maritalStatus=");
		sb.append(maritalStatus);
		sb.append(", workingPlace=");
		sb.append(workingPlace);
		sb.append(", nativePlace=");
		sb.append(nativePlace);
		sb.append(", rangeDate=");
		sb.append(rangeDate);
		sb.append(", issuedBy=");
		sb.append(issuedBy);
		sb.append(", fatherName=");
		sb.append(fatherName);
		sb.append(", motherName=");
		sb.append(motherName);
		sb.append(", guardianName=");
		sb.append(guardianName);
		sb.append(", spouseName=");
		sb.append(spouseName);
		sb.append(", headHouseholdName=");
		sb.append(headHouseholdName);
		sb.append(", nation=");
		sb.append(nation);
		sb.append(", representativeNumber=");
		sb.append(representativeNumber);
		sb.append(", representativeName=");
		sb.append(representativeName);
		sb.append(", representativeTelNo=");
		sb.append(representativeTelNo);
		sb.append(", fax=");
		sb.append(fax);
		sb.append(", superiorOrganization=");
		sb.append(superiorOrganization);
		sb.append(", note=");
		sb.append(note);
		sb.append(", idDBXM=");
		sb.append(idDBXM);
		sb.append(", cityCode=");
		sb.append(cityCode);
		sb.append(", districtCode=");
		sb.append(districtCode);
		sb.append(", wardCode=");
		sb.append(wardCode);
		sb.append(", cityCodeXM=");
		sb.append(cityCodeXM);
		sb.append(", districtCodeXM=");
		sb.append(districtCodeXM);
		sb.append(", wardCodeXM=");
		sb.append(wardCodeXM);
		sb.append(", addressXM=");
		sb.append(addressXM);
		sb.append(", attachFile=");
		sb.append(attachFile);
		sb.append(", accountStatus=");
		sb.append(accountStatus);
		sb.append(", processStatus=");
		sb.append(processStatus);
		sb.append(", signImageId=");
		sb.append(signImageId);
		sb.append(", hoSoId=");
		sb.append(hoSoId);
		sb.append(", message=");
		sb.append(message);
		sb.append(", assignUserId=");
		sb.append(assignUserId);
		sb.append(", ipLevel=");
		sb.append(ipLevel);
		sb.append(", reOpen=");
		sb.append(reOpen);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Account toEntityModel() {
		AccountImpl accountImpl = new AccountImpl();

		accountImpl.setAccountId(accountId);
		accountImpl.setAccountType(accountType);

		if (accountName == null) {
			accountImpl.setAccountName("");
		}
		else {
			accountImpl.setAccountName(accountName);
		}

		accountImpl.setCompanyId(companyId);
		accountImpl.setGroupId(groupId);
		accountImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			accountImpl.setCreateDate(null);
		}
		else {
			accountImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			accountImpl.setModifiedDate(null);
		}
		else {
			accountImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (fullName == null) {
			accountImpl.setFullName("");
		}
		else {
			accountImpl.setFullName(fullName);
		}

		if (birthdate == Long.MIN_VALUE) {
			accountImpl.setBirthdate(null);
		}
		else {
			accountImpl.setBirthdate(new Date(birthdate));
		}

		if (email == null) {
			accountImpl.setEmail("");
		}
		else {
			accountImpl.setEmail(email);
		}

		if (telNo == null) {
			accountImpl.setTelNo("");
		}
		else {
			accountImpl.setTelNo(telNo);
		}

		if (personalId == null) {
			accountImpl.setPersonalId("");
		}
		else {
			accountImpl.setPersonalId(personalId);
		}

		if (address == null) {
			accountImpl.setAddress("");
		}
		else {
			accountImpl.setAddress(address);
		}

		accountImpl.setGender(gender);

		if (legalDelegate == null) {
			accountImpl.setLegalDelegate("");
		}
		else {
			accountImpl.setLegalDelegate(legalDelegate);
		}

		if (taxCode == null) {
			accountImpl.setTaxCode("");
		}
		else {
			accountImpl.setTaxCode(taxCode);
		}

		if (insuranceCode == null) {
			accountImpl.setInsuranceCode("");
		}
		else {
			accountImpl.setInsuranceCode(insuranceCode);
		}

		if (nationality == null) {
			accountImpl.setNationality("");
		}
		else {
			accountImpl.setNationality(nationality);
		}

		if (ethnicGroup == null) {
			accountImpl.setEthnicGroup("");
		}
		else {
			accountImpl.setEthnicGroup(ethnicGroup);
		}

		if (familyRegNo == null) {
			accountImpl.setFamilyRegNo("");
		}
		else {
			accountImpl.setFamilyRegNo(familyRegNo);
		}

		accountImpl.setMaritalStatus(maritalStatus);

		if (workingPlace == null) {
			accountImpl.setWorkingPlace("");
		}
		else {
			accountImpl.setWorkingPlace(workingPlace);
		}

		if (nativePlace == null) {
			accountImpl.setNativePlace("");
		}
		else {
			accountImpl.setNativePlace(nativePlace);
		}

		if (rangeDate == Long.MIN_VALUE) {
			accountImpl.setRangeDate(null);
		}
		else {
			accountImpl.setRangeDate(new Date(rangeDate));
		}

		if (issuedBy == null) {
			accountImpl.setIssuedBy("");
		}
		else {
			accountImpl.setIssuedBy(issuedBy);
		}

		if (fatherName == null) {
			accountImpl.setFatherName("");
		}
		else {
			accountImpl.setFatherName(fatherName);
		}

		if (motherName == null) {
			accountImpl.setMotherName("");
		}
		else {
			accountImpl.setMotherName(motherName);
		}

		if (guardianName == null) {
			accountImpl.setGuardianName("");
		}
		else {
			accountImpl.setGuardianName(guardianName);
		}

		if (spouseName == null) {
			accountImpl.setSpouseName("");
		}
		else {
			accountImpl.setSpouseName(spouseName);
		}

		if (headHouseholdName == null) {
			accountImpl.setHeadHouseholdName("");
		}
		else {
			accountImpl.setHeadHouseholdName(headHouseholdName);
		}

		if (nation == null) {
			accountImpl.setNation("");
		}
		else {
			accountImpl.setNation(nation);
		}

		if (representativeNumber == null) {
			accountImpl.setRepresentativeNumber("");
		}
		else {
			accountImpl.setRepresentativeNumber(representativeNumber);
		}

		if (representativeName == null) {
			accountImpl.setRepresentativeName("");
		}
		else {
			accountImpl.setRepresentativeName(representativeName);
		}

		if (representativeTelNo == null) {
			accountImpl.setRepresentativeTelNo("");
		}
		else {
			accountImpl.setRepresentativeTelNo(representativeTelNo);
		}

		if (fax == null) {
			accountImpl.setFax("");
		}
		else {
			accountImpl.setFax(fax);
		}

		if (superiorOrganization == null) {
			accountImpl.setSuperiorOrganization("");
		}
		else {
			accountImpl.setSuperiorOrganization(superiorOrganization);
		}

		if (note == null) {
			accountImpl.setNote("");
		}
		else {
			accountImpl.setNote(note);
		}

		accountImpl.setIdDBXM(idDBXM);

		if (cityCode == null) {
			accountImpl.setCityCode("");
		}
		else {
			accountImpl.setCityCode(cityCode);
		}

		if (districtCode == null) {
			accountImpl.setDistrictCode("");
		}
		else {
			accountImpl.setDistrictCode(districtCode);
		}

		if (wardCode == null) {
			accountImpl.setWardCode("");
		}
		else {
			accountImpl.setWardCode(wardCode);
		}

		if (cityCodeXM == null) {
			accountImpl.setCityCodeXM("");
		}
		else {
			accountImpl.setCityCodeXM(cityCodeXM);
		}

		if (districtCodeXM == null) {
			accountImpl.setDistrictCodeXM("");
		}
		else {
			accountImpl.setDistrictCodeXM(districtCodeXM);
		}

		if (wardCodeXM == null) {
			accountImpl.setWardCodeXM("");
		}
		else {
			accountImpl.setWardCodeXM(wardCodeXM);
		}

		if (addressXM == null) {
			accountImpl.setAddressXM("");
		}
		else {
			accountImpl.setAddressXM(addressXM);
		}

		accountImpl.setAttachFile(attachFile);
		accountImpl.setAccountStatus(accountStatus);
		accountImpl.setProcessStatus(processStatus);
		accountImpl.setSignImageId(signImageId);
		accountImpl.setHoSoId(hoSoId);

		if (message == null) {
			accountImpl.setMessage("");
		}
		else {
			accountImpl.setMessage(message);
		}

		accountImpl.setAssignUserId(assignUserId);
		accountImpl.setIpLevel(ipLevel);
		accountImpl.setReOpen(reOpen);

		accountImpl.resetOriginalValues();

		return accountImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		accountId = objectInput.readLong();

		accountType = objectInput.readInt();
		accountName = objectInput.readUTF();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		fullName = objectInput.readUTF();
		birthdate = objectInput.readLong();
		email = objectInput.readUTF();
		telNo = objectInput.readUTF();
		personalId = objectInput.readUTF();
		address = objectInput.readUTF();

		gender = objectInput.readInt();
		legalDelegate = objectInput.readUTF();
		taxCode = objectInput.readUTF();
		insuranceCode = objectInput.readUTF();
		nationality = objectInput.readUTF();
		ethnicGroup = objectInput.readUTF();
		familyRegNo = objectInput.readUTF();

		maritalStatus = objectInput.readInt();
		workingPlace = objectInput.readUTF();
		nativePlace = objectInput.readUTF();
		rangeDate = objectInput.readLong();
		issuedBy = objectInput.readUTF();
		fatherName = objectInput.readUTF();
		motherName = objectInput.readUTF();
		guardianName = objectInput.readUTF();
		spouseName = objectInput.readUTF();
		headHouseholdName = objectInput.readUTF();
		nation = objectInput.readUTF();
		representativeNumber = objectInput.readUTF();
		representativeName = objectInput.readUTF();
		representativeTelNo = objectInput.readUTF();
		fax = objectInput.readUTF();
		superiorOrganization = objectInput.readUTF();
		note = objectInput.readUTF();

		idDBXM = objectInput.readLong();
		cityCode = objectInput.readUTF();
		districtCode = objectInput.readUTF();
		wardCode = objectInput.readUTF();
		cityCodeXM = objectInput.readUTF();
		districtCodeXM = objectInput.readUTF();
		wardCodeXM = objectInput.readUTF();
		addressXM = objectInput.readUTF();

		attachFile = objectInput.readLong();

		accountStatus = objectInput.readInt();

		processStatus = objectInput.readInt();

		signImageId = objectInput.readLong();

		hoSoId = objectInput.readLong();
		message = objectInput.readUTF();

		assignUserId = objectInput.readLong();

		ipLevel = objectInput.readInt();

		reOpen = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(accountId);

		objectOutput.writeInt(accountType);

		if (accountName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(accountName);
		}

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (fullName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fullName);
		}

		objectOutput.writeLong(birthdate);

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (telNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(telNo);
		}

		if (personalId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(personalId);
		}

		if (address == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address);
		}

		objectOutput.writeInt(gender);

		if (legalDelegate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(legalDelegate);
		}

		if (taxCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(taxCode);
		}

		if (insuranceCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(insuranceCode);
		}

		if (nationality == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nationality);
		}

		if (ethnicGroup == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ethnicGroup);
		}

		if (familyRegNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(familyRegNo);
		}

		objectOutput.writeInt(maritalStatus);

		if (workingPlace == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(workingPlace);
		}

		if (nativePlace == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nativePlace);
		}

		objectOutput.writeLong(rangeDate);

		if (issuedBy == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(issuedBy);
		}

		if (fatherName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fatherName);
		}

		if (motherName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(motherName);
		}

		if (guardianName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(guardianName);
		}

		if (spouseName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(spouseName);
		}

		if (headHouseholdName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(headHouseholdName);
		}

		if (nation == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nation);
		}

		if (representativeNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(representativeNumber);
		}

		if (representativeName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(representativeName);
		}

		if (representativeTelNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(representativeTelNo);
		}

		if (fax == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fax);
		}

		if (superiorOrganization == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(superiorOrganization);
		}

		if (note == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(note);
		}

		objectOutput.writeLong(idDBXM);

		if (cityCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(cityCode);
		}

		if (districtCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(districtCode);
		}

		if (wardCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(wardCode);
		}

		if (cityCodeXM == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(cityCodeXM);
		}

		if (districtCodeXM == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(districtCodeXM);
		}

		if (wardCodeXM == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(wardCodeXM);
		}

		if (addressXM == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(addressXM);
		}

		objectOutput.writeLong(attachFile);

		objectOutput.writeInt(accountStatus);

		objectOutput.writeInt(processStatus);

		objectOutput.writeLong(signImageId);

		objectOutput.writeLong(hoSoId);

		if (message == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(message);
		}

		objectOutput.writeLong(assignUserId);

		objectOutput.writeInt(ipLevel);

		objectOutput.writeBoolean(reOpen);
	}

	public long accountId;
	public int accountType;
	public String accountName;
	public long companyId;
	public long groupId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String fullName;
	public long birthdate;
	public String email;
	public String telNo;
	public String personalId;
	public String address;
	public int gender;
	public String legalDelegate;
	public String taxCode;
	public String insuranceCode;
	public String nationality;
	public String ethnicGroup;
	public String familyRegNo;
	public int maritalStatus;
	public String workingPlace;
	public String nativePlace;
	public long rangeDate;
	public String issuedBy;
	public String fatherName;
	public String motherName;
	public String guardianName;
	public String spouseName;
	public String headHouseholdName;
	public String nation;
	public String representativeNumber;
	public String representativeName;
	public String representativeTelNo;
	public String fax;
	public String superiorOrganization;
	public String note;
	public long idDBXM;
	public String cityCode;
	public String districtCode;
	public String wardCode;
	public String cityCodeXM;
	public String districtCodeXM;
	public String wardCodeXM;
	public String addressXM;
	public long attachFile;
	public int accountStatus;
	public int processStatus;
	public long signImageId;
	public long hoSoId;
	public String message;
	public long assignUserId;
	public int ipLevel;
	public boolean reOpen;

}