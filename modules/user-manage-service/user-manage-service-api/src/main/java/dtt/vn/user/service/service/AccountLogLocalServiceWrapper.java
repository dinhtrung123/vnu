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

package dtt.vn.user.service.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AccountLogLocalService}.
 *
 * @author nhanvienDTT
 * @see AccountLogLocalService
 * @generated
 */
@ProviderType
public class AccountLogLocalServiceWrapper
	implements AccountLogLocalService, ServiceWrapper<AccountLogLocalService> {

	public AccountLogLocalServiceWrapper(
		AccountLogLocalService accountLogLocalService) {

		_accountLogLocalService = accountLogLocalService;
	}

	/**
	 * Adds the account log to the database. Also notifies the appropriate model listeners.
	 *
	 * @param accountLog the account log
	 * @return the account log that was added
	 */
	@Override
	public dtt.vn.user.service.model.AccountLog addAccountLog(
		dtt.vn.user.service.model.AccountLog accountLog) {

		return _accountLogLocalService.addAccountLog(accountLog);
	}

	@Override
	public dtt.vn.user.service.model.AccountLog addAccountLog(
			long accountId, long nguoiSuaId, String tenNguoiSua,
			String emailNguoiSua, java.util.Date ngaySua, long phienBan,
			String json)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _accountLogLocalService.addAccountLog(
			accountId, nguoiSuaId, tenNguoiSua, emailNguoiSua, ngaySua,
			phienBan, json);
	}

	@Override
	public int countByAccount(long accountId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _accountLogLocalService.countByAccount(accountId);
	}

	/**
	 * Creates a new account log with the primary key. Does not add the account log to the database.
	 *
	 * @param id the primary key for the new account log
	 * @return the new account log
	 */
	@Override
	public dtt.vn.user.service.model.AccountLog createAccountLog(long id) {
		return _accountLogLocalService.createAccountLog(id);
	}

	/**
	 * Deletes the account log from the database. Also notifies the appropriate model listeners.
	 *
	 * @param accountLog the account log
	 * @return the account log that was removed
	 */
	@Override
	public dtt.vn.user.service.model.AccountLog deleteAccountLog(
		dtt.vn.user.service.model.AccountLog accountLog) {

		return _accountLogLocalService.deleteAccountLog(accountLog);
	}

	/**
	 * Deletes the account log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the account log
	 * @return the account log that was removed
	 * @throws PortalException if a account log with the primary key could not be found
	 */
	@Override
	public dtt.vn.user.service.model.AccountLog deleteAccountLog(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _accountLogLocalService.deleteAccountLog(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _accountLogLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _accountLogLocalService.dynamicQuery();
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

		return _accountLogLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>dtt.vn.user.service.model.impl.AccountLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _accountLogLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>dtt.vn.user.service.model.impl.AccountLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _accountLogLocalService.dynamicQuery(
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

		return _accountLogLocalService.dynamicQueryCount(dynamicQuery);
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

		return _accountLogLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public dtt.vn.user.service.model.AccountLog fetchAccountLog(long id) {
		return _accountLogLocalService.fetchAccountLog(id);
	}

	/**
	 * Returns the account log with the primary key.
	 *
	 * @param id the primary key of the account log
	 * @return the account log
	 * @throws PortalException if a account log with the primary key could not be found
	 */
	@Override
	public dtt.vn.user.service.model.AccountLog getAccountLog(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _accountLogLocalService.getAccountLog(id);
	}

	/**
	 * Returns a range of all the account logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>dtt.vn.user.service.model.impl.AccountLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of account logs
	 * @param end the upper bound of the range of account logs (not inclusive)
	 * @return the range of account logs
	 */
	@Override
	public java.util.List<dtt.vn.user.service.model.AccountLog> getAccountLogs(
		int start, int end) {

		return _accountLogLocalService.getAccountLogs(start, end);
	}

	/**
	 * Returns the number of account logs.
	 *
	 * @return the number of account logs
	 */
	@Override
	public int getAccountLogsCount() {
		return _accountLogLocalService.getAccountLogsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _accountLogLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<dtt.vn.user.service.model.AccountLog> getByAccount(
			long accountId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _accountLogLocalService.getByAccount(accountId, start, end);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _accountLogLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _accountLogLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _accountLogLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the account log in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param accountLog the account log
	 * @return the account log that was updated
	 */
	@Override
	public dtt.vn.user.service.model.AccountLog updateAccountLog(
		dtt.vn.user.service.model.AccountLog accountLog) {

		return _accountLogLocalService.updateAccountLog(accountLog);
	}

	@Override
	public AccountLogLocalService getWrappedService() {
		return _accountLogLocalService;
	}

	@Override
	public void setWrappedService(
		AccountLogLocalService accountLogLocalService) {

		_accountLogLocalService = accountLogLocalService;
	}

	private AccountLogLocalService _accountLogLocalService;

}