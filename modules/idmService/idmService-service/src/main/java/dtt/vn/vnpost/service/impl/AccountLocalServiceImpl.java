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

package dtt.vn.vnpost.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;

import dtt.vn.vnpost.model.Account;
import dtt.vn.vnpost.service.account.Constantes;
import dtt.vn.vnpost.service.base.AccountLocalServiceBaseImpl;

/**
 * The implementation of the account local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>dtt.vn.vnpost.service.AccountLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AccountLocalServiceBaseImpl
 */
public class AccountLocalServiceImpl extends AccountLocalServiceBaseImpl {
	public Account themMoi(long companyId, long groupId, long userId, Date createDate, Date modifiedDate,
			String message, int accountStatus, int processStatus, int accountType, String accountName,
			String legalDelegate ,String fullName, int gender, Date birthdate, String address, String email, String personalId,
			String telNo, String tinhId, String huyenId, String xaId, int ipLevel, String taxCode
			) {
		Account account = accountPersistence.create(counterLocalService.increment());
		account.setCompanyId(companyId);
		account.setGroupId(groupId);
		account.setUserId(userId);
		account.setCreateDate(createDate);
		account.setModifiedDate(modifiedDate);
		account.setMessage(message);
		account.setAccountStatus(accountStatus);
		account.setProcessStatus(processStatus);
		account.setAccountType(accountType);
		account.setAccountName(accountName);
		account.setLegalDelegate(legalDelegate);
		account.setGender(gender);
		account.setBirthdate(birthdate);
		account.setAddress(address);
		account.setPersonalId(personalId);
		account.setEmail(email);
		account.setTelNo(telNo);
		account.setCityCode(tinhId);
		account.setDistrictCode(huyenId);
		account.setWardCode(xaId);
		account.setIpLevel(ipLevel);
		account.setTaxCode(taxCode);
		account.setFullName(fullName);

		accountPersistence.update(account);
		return account;

	}
	
	public Account getAccountByUserId(long userId) throws SystemException {
		return accountPersistence.fetchByuserId(userId);
	}
	
	public Account getAccountByAccountName(String accountName) throws SystemException {
		return accountPersistence.fetchByaccountName(accountName);
	}
	
	public Account getAccountByEmail(String email) throws SystemException {
		return accountPersistence.fetchByEmail(email);
	}
	
	public Account addAccount(Account account) throws SystemException {
		long accountId = CounterLocalServiceUtil.increment(Account.class.getName());
		account.setAccountId(accountId);
		account.setIpLevel(Constantes.Level.NEW);
		account = super.addAccount(account);
		return account;
	}

	public Account getAccountByHSId(long hoSoId) throws SystemException {
		return accountPersistence.fetchByHoSoId(hoSoId);
	}

	public boolean isEmailExists(String emailAddress) {
		boolean exists = false;

		try {
			Account account = accountPersistence.fetchByEmail(emailAddress);

			exists = Validator.isNotNull(account);
		} catch (SystemException e) {
			e.printStackTrace();
		}

		return exists;
	}
	public boolean isphoneExists(String phone) {
		boolean exists = false;

		try {
			List<Account> account = accountPersistence.findByphone(phone);
			if(account == null || account.size() == 0) {
				return true;
			}
		} catch (SystemException e) {
			e.printStackTrace();
		}

		return exists;
	}
	public boolean ismstExists(String mst) {
		boolean exists = false;

		try {
			List<Account> account = accountPersistence.findBymst(mst);
			if(account == null || account.size() == 0) {
				return true;
			}
		} catch (SystemException e) {
			e.printStackTrace();
		}

		return exists;
	}
	public boolean isEmailExists(long accountId, String emailAddress) {
		boolean exists = false;
		Account account = null;
		try {
			if (accountId > 0) {
				account = accountPersistence.fetchByPrimaryKey(accountId);
				if (emailAddress.equalsIgnoreCase(account.getEmail())) {
					exists = false;
				} else {
					account = accountPersistence.fetchByEmail(emailAddress);
					if (account == null) {
						exists = false;
					} else {
						if (Validator.isNotNull(account) && account.getAccountId() != accountId) {
							exists = true;
						}
					}
				}
			} else {

				account = accountPersistence.fetchByEmail(emailAddress);
				exists = Validator.isNotNull(account);
			}

		} catch (SystemException e) {
			e.printStackTrace();
		}

		return exists;
	}

	public boolean ispersonalIdExists(String personalId) {
		boolean exists = false;

		try {
			Account account = accountPersistence.fetchByPersonalId(personalId);

			exists = Validator.isNotNull(account);
		} catch (SystemException e) {
			e.printStackTrace();
		}

		return exists;
	}

	public boolean isAccountNameExists(String accountName) {
		boolean exists = false;

		try {
			Account account = accountPersistence.fetchByaccountName(accountName);

			exists = Validator.isNotNull(account);
		} catch (SystemException e) {
			e.printStackTrace();
		}

		return exists;
	}

	public boolean ispersonalIdExists(long accountId, String personalId) {
		boolean exists = false;
		Account account = null;

		try {
			if (accountId > 0) {
				account = accountPersistence.fetchByPrimaryKey(accountId);
				if (personalId.equalsIgnoreCase(account.getPersonalId())) {
					exists = false;
				} else {
					account = accountPersistence.fetchByPersonalId(personalId);
					if (account == null) {
						exists = false;
					} else {
						if (Validator.isNotNull(account) && account.getAccountId() != accountId) {
							exists = true;
						}
					}
				}
			} else {

				account = accountPersistence.fetchByPersonalId(personalId);
				exists = Validator.isNotNull(account);
			}

		} catch (SystemException e) {
			e.printStackTrace();
		}

		return exists;
	}

	public List<Account> getAccountByStatus(int acst, int type, String keyword, int status, long userId, int start,
			int end) {
		return accountFinder.getAccountByStatus(acst, type, keyword, status, userId, start, end);
	}

	public int getTotalAccountCountByStatus(int acst, int type, String keyword, int status, long userId, int start,
			int end) {
		return accountFinder.getTotalAccountCountByStatus(acst, type, keyword, status, userId, start, end);
	}
	public List<Account> searchForDanhSach(String keyword,int hinhthucdangky,String sogiayto,String tungay,String denngay,String sodienthoai,String tentaikhoan,int loaidoituong,String canboxacminh,int tinhtrang,
			int start, int end) {
		return accountFinder.searchForDanhSach( keyword, hinhthucdangky, sogiayto, tungay, denngay, sodienthoai, tentaikhoan, loaidoituong, canboxacminh, tinhtrang,
				 start,  end);
	}
	public int countForDanhSach(String keyword,int hinhthucdangky,String sogiayto,String tungay,String denngay,String sodienthoai,String tentaikhoan,int loaidoituong,String canboxacminh,int tinhtrang) {
		return accountFinder.countForDanhSach( keyword, hinhthucdangky, sogiayto, tungay, denngay, sodienthoai, tentaikhoan, loaidoituong, canboxacminh, tinhtrang);
	}
	
	public int countAccountForAPI (String keyword,int tinhtrang,String email, String userName, String fullName, String telNo){
		return accountFinder.countAccountForAPI(keyword,tinhtrang,email, userName, fullName, telNo);
		
	}
	public List<Account> searchAccountForAPI (String keyword,int tinhtrang,String email, String userName, String fullName, String telNo, int start, int end){
		return accountFinder.searchAccountForAPI(keyword,tinhtrang,email, userName, fullName, telNo, start, end);
		
	}
	public int countForXacMinh(String keyword, int tinhtrang, String email,
			String sogiayto, String tungay,String denngay, String sodienthoai,
			String tentaikhoan, int loaidoituong, int hinhthucdangky){
		return accountFinder.countForXacMinh(keyword, tinhtrang, email, sogiayto, tungay, denngay, sodienthoai, tentaikhoan, loaidoituong, hinhthucdangky);
	}
	public List<Account> searchForXacMinh(String keyword, int tinhtrang, String email,
			String sogiayto, String tungay,String denngay, String sodienthoai,
			String tentaikhoan, int loaidoituong, int hinhthucdangky, int start, int end){
		return accountFinder.searchForXacMinh(keyword, tinhtrang, email, sogiayto, tungay, denngay, sodienthoai, tentaikhoan, loaidoituong, hinhthucdangky, start, end);
	}
	public int countForPheDuyet(String keyword, int tinhtrang, String email,
			String sogiayto, String tungay,String denngay, String sodienthoai,
			String tentaikhoan, int loaidoituong, int hinhthucdangky){
		return accountFinder.countForPheDuyet(keyword, tinhtrang, email, sogiayto, tungay, denngay, sodienthoai, tentaikhoan, loaidoituong, hinhthucdangky);
	}
	public List<Account> searchForPheDuyet(String keyword, int tinhtrang, String email,
			String sogiayto, String tungay,String denngay, String sodienthoai,
			String tentaikhoan, int loaidoituong, int hinhthucdangky, int start, int end){
		return accountFinder.searchForPheDuyet(keyword, tinhtrang, email, sogiayto, tungay, denngay, sodienthoai, tentaikhoan, loaidoituong, hinhthucdangky, start, end);
	}
}