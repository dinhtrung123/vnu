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

package dtt.vn.vnpost.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AccountService}.
 *
 * @author Brian Wing Shun Chan
 * @see AccountService
 * @generated
 */
@ProviderType
public class AccountServiceWrapper
	implements AccountService, ServiceWrapper<AccountService> {

	public AccountServiceWrapper(AccountService accountService) {
		_accountService = accountService;
	}

	@Override
	public dtt.vn.vnpost.model.AccountSoap getAccountByIds(long accountId) {
		return _accountService.getAccountByIds(accountId);
	}

	@Override
	public String getDiaChiChiTiet(long accountId) {
		return _accountService.getDiaChiChiTiet(accountId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _accountService.getOSGiServiceIdentifier();
	}

	@Override
	public dtt.vn.vnpost.model.PhotoSoap[] getThuocTinhXacMinhs(
		String classPK) {

		return _accountService.getThuocTinhXacMinhs(classPK);
	}

	@Override
	public dtt.vn.vnpost.model.AccountSoap[] getTotalAccountByStatus(
		int accountStatus, int accountType, int start, int end) {

		return _accountService.getTotalAccountByStatus(
			accountStatus, accountType, start, end);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject PheDuyetTaiKhoan(
		long accountId, int method, String yKienCanBoPheDuyet) {

		return _accountService.PheDuyetTaiKhoan(
			accountId, method, yKienCanBoPheDuyet);
	}

	@Override
	public dtt.vn.vnpost.model.AccountSoap[] searchAccountByKeyWord(
		String keyword, int tinhtrang, String email, String userName,
		String fullName, String telNo) {

		return _accountService.searchAccountByKeyWord(
			keyword, tinhtrang, email, userName, fullName, telNo);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject UploadFiles(
		String mangGiayTo) {

		return _accountService.UploadFiles(mangGiayTo);
	}

	@Override
	public boolean XacMinhTaiKhoan(
		long accountId, int XacMinhType, String yKienCanBo) {

		return _accountService.XacMinhTaiKhoan(
			accountId, XacMinhType, yKienCanBo);
	}

	@Override
	public AccountService getWrappedService() {
		return _accountService;
	}

	@Override
	public void setWrappedService(AccountService accountService) {
		_accountService = accountService;
	}

	private AccountService _accountService;

}