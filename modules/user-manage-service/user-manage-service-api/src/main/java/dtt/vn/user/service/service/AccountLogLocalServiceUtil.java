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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for AccountLog. This utility wraps
 * <code>dtt.vn.user.service.service.impl.AccountLogLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author nhanvienDTT
 * @see AccountLogLocalService
 * @generated
 */
@ProviderType
public class AccountLogLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>dtt.vn.user.service.service.impl.AccountLogLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the account log to the database. Also notifies the appropriate model listeners.
	 *
	 * @param accountLog the account log
	 * @return the account log that was added
	 */
	public static dtt.vn.user.service.model.AccountLog addAccountLog(
		dtt.vn.user.service.model.AccountLog accountLog) {

		return getService().addAccountLog(accountLog);
	}

	public static dtt.vn.user.service.model.AccountLog addAccountLog(
			long accountId, long nguoiSuaId, String tenNguoiSua,
			String emailNguoiSua, java.util.Date ngaySua, long phienBan,
			String json)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().addAccountLog(
			accountId, nguoiSuaId, tenNguoiSua, emailNguoiSua, ngaySua,
			phienBan, json);
	}

	public static int countByAccount(long accountId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().countByAccount(accountId);
	}

	/**
	 * Creates a new account log with the primary key. Does not add the account log to the database.
	 *
	 * @param id the primary key for the new account log
	 * @return the new account log
	 */
	public static dtt.vn.user.service.model.AccountLog createAccountLog(
		long id) {

		return getService().createAccountLog(id);
	}

	/**
	 * Deletes the account log from the database. Also notifies the appropriate model listeners.
	 *
	 * @param accountLog the account log
	 * @return the account log that was removed
	 */
	public static dtt.vn.user.service.model.AccountLog deleteAccountLog(
		dtt.vn.user.service.model.AccountLog accountLog) {

		return getService().deleteAccountLog(accountLog);
	}

	/**
	 * Deletes the account log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the account log
	 * @return the account log that was removed
	 * @throws PortalException if a account log with the primary key could not be found
	 */
	public static dtt.vn.user.service.model.AccountLog deleteAccountLog(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteAccountLog(id);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>dtt.vn.user.service.model.impl.AccountLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>dtt.vn.user.service.model.impl.AccountLogModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static dtt.vn.user.service.model.AccountLog fetchAccountLog(
		long id) {

		return getService().fetchAccountLog(id);
	}

	/**
	 * Returns the account log with the primary key.
	 *
	 * @param id the primary key of the account log
	 * @return the account log
	 * @throws PortalException if a account log with the primary key could not be found
	 */
	public static dtt.vn.user.service.model.AccountLog getAccountLog(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getAccountLog(id);
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
	public static java.util.List<dtt.vn.user.service.model.AccountLog>
		getAccountLogs(int start, int end) {

		return getService().getAccountLogs(start, end);
	}

	/**
	 * Returns the number of account logs.
	 *
	 * @return the number of account logs
	 */
	public static int getAccountLogsCount() {
		return getService().getAccountLogsCount();
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List<dtt.vn.user.service.model.AccountLog>
			getByAccount(long accountId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getByAccount(accountId, start, end);
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

	/**
	 * Updates the account log in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param accountLog the account log
	 * @return the account log that was updated
	 */
	public static dtt.vn.user.service.model.AccountLog updateAccountLog(
		dtt.vn.user.service.model.AccountLog accountLog) {

		return getService().updateAccountLog(accountLog);
	}

	public static AccountLogLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<AccountLogLocalService, AccountLogLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AccountLogLocalService.class);

		ServiceTracker<AccountLogLocalService, AccountLogLocalService>
			serviceTracker =
				new ServiceTracker
					<AccountLogLocalService, AccountLogLocalService>(
						bundle.getBundleContext(), AccountLogLocalService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}