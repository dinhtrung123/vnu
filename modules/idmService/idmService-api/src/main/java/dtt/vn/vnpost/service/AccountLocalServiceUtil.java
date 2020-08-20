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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Account. This utility wraps
 * <code>dtt.vn.vnpost.service.impl.AccountLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AccountLocalService
 * @generated
 */
@ProviderType
public class AccountLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>dtt.vn.vnpost.service.impl.AccountLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the account to the database. Also notifies the appropriate model listeners.
	 *
	 * @param account the account
	 * @return the account that was added
	 * @throws SystemException
	 */
	public static dtt.vn.vnpost.model.Account addAccount(
			dtt.vn.vnpost.model.Account account)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().addAccount(account);
	}

	public static int countAccountForAPI(
		String keyword, int tinhtrang, String email, String userName,
		String fullName, String telNo) {

		return getService().countAccountForAPI(
			keyword, tinhtrang, email, userName, fullName, telNo);
	}

	public static int countForDanhSach(
		String keyword, int hinhthucdangky, String sogiayto, String tungay,
		String denngay, String sodienthoai, String tentaikhoan,
		int loaidoituong, String canboxacminh, int tinhtrang) {

		return getService().countForDanhSach(
			keyword, hinhthucdangky, sogiayto, tungay, denngay, sodienthoai,
			tentaikhoan, loaidoituong, canboxacminh, tinhtrang);
	}

	public static int countForPheDuyet(
		String keyword, int tinhtrang, String email, String sogiayto,
		String tungay, String denngay, String sodienthoai, String tentaikhoan,
		int loaidoituong, int hinhthucdangky) {

		return getService().countForPheDuyet(
			keyword, tinhtrang, email, sogiayto, tungay, denngay, sodienthoai,
			tentaikhoan, loaidoituong, hinhthucdangky);
	}

	public static int countForXacMinh(
		String keyword, int tinhtrang, String email, String sogiayto,
		String tungay, String denngay, String sodienthoai, String tentaikhoan,
		int loaidoituong, int hinhthucdangky) {

		return getService().countForXacMinh(
			keyword, tinhtrang, email, sogiayto, tungay, denngay, sodienthoai,
			tentaikhoan, loaidoituong, hinhthucdangky);
	}

	/**
	 * Creates a new account with the primary key. Does not add the account to the database.
	 *
	 * @param accountId the primary key for the new account
	 * @return the new account
	 */
	public static dtt.vn.vnpost.model.Account createAccount(long accountId) {
		return getService().createAccount(accountId);
	}

	/**
	 * Deletes the account from the database. Also notifies the appropriate model listeners.
	 *
	 * @param account the account
	 * @return the account that was removed
	 */
	public static dtt.vn.vnpost.model.Account deleteAccount(
		dtt.vn.vnpost.model.Account account) {

		return getService().deleteAccount(account);
	}

	/**
	 * Deletes the account with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param accountId the primary key of the account
	 * @return the account that was removed
	 * @throws PortalException if a account with the primary key could not be found
	 */
	public static dtt.vn.vnpost.model.Account deleteAccount(long accountId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteAccount(accountId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static dtt.vn.vnpost.model.Account fetchAccount(long accountId) {
		return getService().fetchAccount(accountId);
	}

	/**
	 * Returns the account with the primary key.
	 *
	 * @param accountId the primary key of the account
	 * @return the account
	 * @throws PortalException if a account with the primary key could not be found
	 */
	public static dtt.vn.vnpost.model.Account getAccount(long accountId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getAccount(accountId);
	}

	public static dtt.vn.vnpost.model.Account getAccountByAccountName(
			String accountName)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getAccountByAccountName(accountName);
	}

	public static dtt.vn.vnpost.model.Account getAccountByEmail(String email)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getAccountByEmail(email);
	}

	public static dtt.vn.vnpost.model.Account getAccountByHSId(long hoSoId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getAccountByHSId(hoSoId);
	}

	public static java.util.List<dtt.vn.vnpost.model.Account>
		getAccountByStatus(
			int acst, int type, String keyword, int status, long userId,
			int start, int end) {

		return getService().getAccountByStatus(
			acst, type, keyword, status, userId, start, end);
	}

	public static dtt.vn.vnpost.model.Account getAccountByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getAccountByUserId(userId);
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
	public static java.util.List<dtt.vn.vnpost.model.Account> getAccounts(
		int start, int end) {

		return getService().getAccounts(start, end);
	}

	/**
	 * Returns the number of accounts.
	 *
	 * @return the number of accounts
	 */
	public static int getAccountsCount() {
		return getService().getAccountsCount();
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static int getTotalAccountCountByStatus(
		int acst, int type, String keyword, int status, long userId, int start,
		int end) {

		return getService().getTotalAccountCountByStatus(
			acst, type, keyword, status, userId, start, end);
	}

	public static boolean isAccountNameExists(String accountName) {
		return getService().isAccountNameExists(accountName);
	}

	public static boolean isEmailExists(long accountId, String emailAddress) {
		return getService().isEmailExists(accountId, emailAddress);
	}

	public static boolean isEmailExists(String emailAddress) {
		return getService().isEmailExists(emailAddress);
	}

	public static boolean ismstExists(String mst) {
		return getService().ismstExists(mst);
	}

	public static boolean ispersonalIdExists(
		long accountId, String personalId) {

		return getService().ispersonalIdExists(accountId, personalId);
	}

	public static boolean ispersonalIdExists(String personalId) {
		return getService().ispersonalIdExists(personalId);
	}

	public static boolean isphoneExists(String phone) {
		return getService().isphoneExists(phone);
	}

	public static java.util.List<dtt.vn.vnpost.model.Account>
		searchAccountForAPI(
			String keyword, int tinhtrang, String email, String userName,
			String fullName, String telNo, int start, int end) {

		return getService().searchAccountForAPI(
			keyword, tinhtrang, email, userName, fullName, telNo, start, end);
	}

	public static java.util.List<dtt.vn.vnpost.model.Account> searchForDanhSach(
		String keyword, int hinhthucdangky, String sogiayto, String tungay,
		String denngay, String sodienthoai, String tentaikhoan,
		int loaidoituong, String canboxacminh, int tinhtrang, int start,
		int end) {

		return getService().searchForDanhSach(
			keyword, hinhthucdangky, sogiayto, tungay, denngay, sodienthoai,
			tentaikhoan, loaidoituong, canboxacminh, tinhtrang, start, end);
	}

	public static java.util.List<dtt.vn.vnpost.model.Account> searchForPheDuyet(
		String keyword, int tinhtrang, String email, String sogiayto,
		String tungay, String denngay, String sodienthoai, String tentaikhoan,
		int loaidoituong, int hinhthucdangky, int start, int end) {

		return getService().searchForPheDuyet(
			keyword, tinhtrang, email, sogiayto, tungay, denngay, sodienthoai,
			tentaikhoan, loaidoituong, hinhthucdangky, start, end);
	}

	public static java.util.List<dtt.vn.vnpost.model.Account> searchForXacMinh(
		String keyword, int tinhtrang, String email, String sogiayto,
		String tungay, String denngay, String sodienthoai, String tentaikhoan,
		int loaidoituong, int hinhthucdangky, int start, int end) {

		return getService().searchForXacMinh(
			keyword, tinhtrang, email, sogiayto, tungay, denngay, sodienthoai,
			tentaikhoan, loaidoituong, hinhthucdangky, start, end);
	}

	public static dtt.vn.vnpost.model.Account themMoi(
		long companyId, long groupId, long userId, java.util.Date createDate,
		java.util.Date modifiedDate, String message, int accountStatus,
		int processStatus, int accountType, String accountName,
		String legalDelegate, String fullName, int gender,
		java.util.Date birthdate, String address, String email,
		String personalId, String telNo, String tinhId, String huyenId,
		String xaId, int ipLevel, String taxCode) {

		return getService().themMoi(
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
	public static dtt.vn.vnpost.model.Account updateAccount(
		dtt.vn.vnpost.model.Account account) {

		return getService().updateAccount(account);
	}

	public static AccountLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AccountLocalService, AccountLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AccountLocalService.class);

		ServiceTracker<AccountLocalService, AccountLocalService>
			serviceTracker =
				new ServiceTracker<AccountLocalService, AccountLocalService>(
					bundle.getBundleContext(), AccountLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}