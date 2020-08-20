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
 * Provides a wrapper for {@link AccountLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AccountLocalService
 * @generated
 */
@ProviderType
public class AccountLocalServiceWrapper
	implements AccountLocalService, ServiceWrapper<AccountLocalService> {

	public AccountLocalServiceWrapper(AccountLocalService accountLocalService) {
		_accountLocalService = accountLocalService;
	}

	/**
	 * Adds the account to the database. Also notifies the appropriate model listeners.
	 *
	 * @param account the account
	 * @return the account that was added
	 * @throws SystemException
	 */
	@Override
	public dtt.vn.vnpost.model.Account addAccount(
			dtt.vn.vnpost.model.Account account)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _accountLocalService.addAccount(account);
	}

	@Override
	public int countAccountForAPI(
		String keyword, int tinhtrang, String email, String userName,
		String fullName, String telNo) {

		return _accountLocalService.countAccountForAPI(
			keyword, tinhtrang, email, userName, fullName, telNo);
	}

	@Override
	public int countForDanhSach(
		String keyword, int hinhthucdangky, String sogiayto, String tungay,
		String denngay, String sodienthoai, String tentaikhoan,
		int loaidoituong, String canboxacminh, int tinhtrang) {

		return _accountLocalService.countForDanhSach(
			keyword, hinhthucdangky, sogiayto, tungay, denngay, sodienthoai,
			tentaikhoan, loaidoituong, canboxacminh, tinhtrang);
	}

	@Override
	public int countForPheDuyet(
		String keyword, int tinhtrang, String email, String sogiayto,
		String tungay, String denngay, String sodienthoai, String tentaikhoan,
		int loaidoituong, int hinhthucdangky) {

		return _accountLocalService.countForPheDuyet(
			keyword, tinhtrang, email, sogiayto, tungay, denngay, sodienthoai,
			tentaikhoan, loaidoituong, hinhthucdangky);
	}

	@Override
	public int countForXacMinh(
		String keyword, int tinhtrang, String email, String sogiayto,
		String tungay, String denngay, String sodienthoai, String tentaikhoan,
		int loaidoituong, int hinhthucdangky) {

		return _accountLocalService.countForXacMinh(
			keyword, tinhtrang, email, sogiayto, tungay, denngay, sodienthoai,
			tentaikhoan, loaidoituong, hinhthucdangky);
	}

	/**
	 * Creates a new account with the primary key. Does not add the account to the database.
	 *
	 * @param accountId the primary key for the new account
	 * @return the new account
	 */
	@Override
	public dtt.vn.vnpost.model.Account createAccount(long accountId) {
		return _accountLocalService.createAccount(accountId);
	}

	/**
	 * Deletes the account from the database. Also notifies the appropriate model listeners.
	 *
	 * @param account the account
	 * @return the account that was removed
	 */
	@Override
	public dtt.vn.vnpost.model.Account deleteAccount(
		dtt.vn.vnpost.model.Account account) {

		return _accountLocalService.deleteAccount(account);
	}

	/**
	 * Deletes the account with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param accountId the primary key of the account
	 * @return the account that was removed
	 * @throws PortalException if a account with the primary key could not be found
	 */
	@Override
	public dtt.vn.vnpost.model.Account deleteAccount(long accountId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _accountLocalService.deleteAccount(accountId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _accountLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _accountLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _accountLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>dtt.vn.vnpost.model.impl.AccountModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _accountLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>dtt.vn.vnpost.model.impl.AccountModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _accountLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _accountLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _accountLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public dtt.vn.vnpost.model.Account fetchAccount(long accountId) {
		return _accountLocalService.fetchAccount(accountId);
	}

	/**
	 * Returns the account with the primary key.
	 *
	 * @param accountId the primary key of the account
	 * @return the account
	 * @throws PortalException if a account with the primary key could not be found
	 */
	@Override
	public dtt.vn.vnpost.model.Account getAccount(long accountId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _accountLocalService.getAccount(accountId);
	}

	@Override
	public dtt.vn.vnpost.model.Account getAccountByAccountName(
			String accountName)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _accountLocalService.getAccountByAccountName(accountName);
	}

	@Override
	public dtt.vn.vnpost.model.Account getAccountByEmail(String email)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _accountLocalService.getAccountByEmail(email);
	}

	@Override
	public dtt.vn.vnpost.model.Account getAccountByHSId(long hoSoId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _accountLocalService.getAccountByHSId(hoSoId);
	}

	@Override
	public java.util.List<dtt.vn.vnpost.model.Account> getAccountByStatus(
		int acst, int type, String keyword, int status, long userId, int start,
		int end) {

		return _accountLocalService.getAccountByStatus(
			acst, type, keyword, status, userId, start, end);
	}

	@Override
	public dtt.vn.vnpost.model.Account getAccountByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _accountLocalService.getAccountByUserId(userId);
	}

	/**
	 * Returns a range of all the accounts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>dtt.vn.vnpost.model.impl.AccountModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of accounts
	 * @param end the upper bound of the range of accounts (not inclusive)
	 * @return the range of accounts
	 */
	@Override
	public java.util.List<dtt.vn.vnpost.model.Account> getAccounts(
		int start, int end) {

		return _accountLocalService.getAccounts(start, end);
	}

	/**
	 * Returns the number of accounts.
	 *
	 * @return the number of accounts
	 */
	@Override
	public int getAccountsCount() {
		return _accountLocalService.getAccountsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _accountLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _accountLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _accountLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _accountLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public int getTotalAccountCountByStatus(
		int acst, int type, String keyword, int status, long userId, int start,
		int end) {

		return _accountLocalService.getTotalAccountCountByStatus(
			acst, type, keyword, status, userId, start, end);
	}

	@Override
	public boolean isAccountNameExists(String accountName) {
		return _accountLocalService.isAccountNameExists(accountName);
	}

	@Override
	public boolean isEmailExists(long accountId, String emailAddress) {
		return _accountLocalService.isEmailExists(accountId, emailAddress);
	}

	@Override
	public boolean isEmailExists(String emailAddress) {
		return _accountLocalService.isEmailExists(emailAddress);
	}

	@Override
	public boolean ismstExists(String mst) {
		return _accountLocalService.ismstExists(mst);
	}

	@Override
	public boolean ispersonalIdExists(long accountId, String personalId) {
		return _accountLocalService.ispersonalIdExists(accountId, personalId);
	}

	@Override
	public boolean ispersonalIdExists(String personalId) {
		return _accountLocalService.ispersonalIdExists(personalId);
	}

	@Override
	public boolean isphoneExists(String phone) {
		return _accountLocalService.isphoneExists(phone);
	}

	@Override
	public java.util.List<dtt.vn.vnpost.model.Account> searchAccountForAPI(
		String keyword, int tinhtrang, String email, String userName,
		String fullName, String telNo, int start, int end) {

		return _accountLocalService.searchAccountForAPI(
			keyword, tinhtrang, email, userName, fullName, telNo, start, end);
	}

	@Override
	public java.util.List<dtt.vn.vnpost.model.Account> searchForDanhSach(
		String keyword, int hinhthucdangky, String sogiayto, String tungay,
		String denngay, String sodienthoai, String tentaikhoan,
		int loaidoituong, String canboxacminh, int tinhtrang, int start,
		int end) {

		return _accountLocalService.searchForDanhSach(
			keyword, hinhthucdangky, sogiayto, tungay, denngay, sodienthoai,
			tentaikhoan, loaidoituong, canboxacminh, tinhtrang, start, end);
	}

	@Override
	public java.util.List<dtt.vn.vnpost.model.Account> searchForPheDuyet(
		String keyword, int tinhtrang, String email, String sogiayto,
		String tungay, String denngay, String sodienthoai, String tentaikhoan,
		int loaidoituong, int hinhthucdangky, int start, int end) {

		return _accountLocalService.searchForPheDuyet(
			keyword, tinhtrang, email, sogiayto, tungay, denngay, sodienthoai,
			tentaikhoan, loaidoituong, hinhthucdangky, start, end);
	}

	@Override
	public java.util.List<dtt.vn.vnpost.model.Account> searchForXacMinh(
		String keyword, int tinhtrang, String email, String sogiayto,
		String tungay, String denngay, String sodienthoai, String tentaikhoan,
		int loaidoituong, int hinhthucdangky, int start, int end) {

		return _accountLocalService.searchForXacMinh(
			keyword, tinhtrang, email, sogiayto, tungay, denngay, sodienthoai,
			tentaikhoan, loaidoituong, hinhthucdangky, start, end);
	}

	@Override
	public dtt.vn.vnpost.model.Account themMoi(
		long companyId, long groupId, long userId, java.util.Date createDate,
		java.util.Date modifiedDate, String message, int accountStatus,
		int processStatus, int accountType, String accountName,
		String legalDelegate, String fullName, int gender,
		java.util.Date birthdate, String address, String email,
		String personalId, String telNo, String tinhId, String huyenId,
		String xaId, int ipLevel, String taxCode) {

		return _accountLocalService.themMoi(
			companyId, groupId, userId, createDate, modifiedDate, message,
			accountStatus, processStatus, accountType, accountName,
			legalDelegate, fullName, gender, birthdate, address, email,
			personalId, telNo, tinhId, huyenId, xaId, ipLevel, taxCode);
	}

	/**
	 * Updates the account in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param account the account
	 * @return the account that was updated
	 */
	@Override
	public dtt.vn.vnpost.model.Account updateAccount(
		dtt.vn.vnpost.model.Account account) {

		return _accountLocalService.updateAccount(account);
	}

	@Override
	public AccountLocalService getWrappedService() {
		return _accountLocalService;
	}

	@Override
	public void setWrappedService(AccountLocalService accountLocalService) {
		_accountLocalService = accountLocalService;
	}

	private AccountLocalService _accountLocalService;

}