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

package dtt.vn.user.service.service.base;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import dtt.vn.user.service.model.AccountLog;
import dtt.vn.user.service.service.AccountLogLocalService;
import dtt.vn.user.service.service.persistence.AccountLogPersistence;
import dtt.vn.user.service.service.persistence.DataImportFinder;
import dtt.vn.user.service.service.persistence.DataImportPersistence;
import dtt.vn.user.service.service.persistence.DoiTuongSuDungPersistence;
import dtt.vn.user.service.service.persistence.ThongTinCanBoPersistence;
import dtt.vn.user.service.service.persistence.ThongTinDangKyFinder;
import dtt.vn.user.service.service.persistence.ThongTinDangKyPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the account log local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link dtt.vn.user.service.service.impl.AccountLogLocalServiceImpl}.
 * </p>
 *
 * @author nhanvienDTT
 * @see dtt.vn.user.service.service.impl.AccountLogLocalServiceImpl
 * @generated
 */
@ProviderType
public abstract class AccountLogLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AccountLogLocalService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>AccountLogLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>dtt.vn.user.service.service.AccountLogLocalServiceUtil</code>.
	 */

	/**
	 * Adds the account log to the database. Also notifies the appropriate model listeners.
	 *
	 * @param accountLog the account log
	 * @return the account log that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public AccountLog addAccountLog(AccountLog accountLog) {
		accountLog.setNew(true);

		return accountLogPersistence.update(accountLog);
	}

	/**
	 * Creates a new account log with the primary key. Does not add the account log to the database.
	 *
	 * @param id the primary key for the new account log
	 * @return the new account log
	 */
	@Override
	@Transactional(enabled = false)
	public AccountLog createAccountLog(long id) {
		return accountLogPersistence.create(id);
	}

	/**
	 * Deletes the account log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the account log
	 * @return the account log that was removed
	 * @throws PortalException if a account log with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public AccountLog deleteAccountLog(long id) throws PortalException {
		return accountLogPersistence.remove(id);
	}

	/**
	 * Deletes the account log from the database. Also notifies the appropriate model listeners.
	 *
	 * @param accountLog the account log
	 * @return the account log that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public AccountLog deleteAccountLog(AccountLog accountLog) {
		return accountLogPersistence.remove(accountLog);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			AccountLog.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return accountLogPersistence.findWithDynamicQuery(dynamicQuery);
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
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return accountLogPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
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
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return accountLogPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return accountLogPersistence.countWithDynamicQuery(dynamicQuery);
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
		DynamicQuery dynamicQuery, Projection projection) {

		return accountLogPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public AccountLog fetchAccountLog(long id) {
		return accountLogPersistence.fetchByPrimaryKey(id);
	}

	/**
	 * Returns the account log with the primary key.
	 *
	 * @param id the primary key of the account log
	 * @return the account log
	 * @throws PortalException if a account log with the primary key could not be found
	 */
	@Override
	public AccountLog getAccountLog(long id) throws PortalException {
		return accountLogPersistence.findByPrimaryKey(id);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(accountLogLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(AccountLog.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("id");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			accountLogLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(AccountLog.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("id");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(accountLogLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(AccountLog.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("id");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return accountLogLocalService.deleteAccountLog(
			(AccountLog)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return accountLogPersistence.findByPrimaryKey(primaryKeyObj);
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
	public List<AccountLog> getAccountLogs(int start, int end) {
		return accountLogPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of account logs.
	 *
	 * @return the number of account logs
	 */
	@Override
	public int getAccountLogsCount() {
		return accountLogPersistence.countAll();
	}

	/**
	 * Updates the account log in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param accountLog the account log
	 * @return the account log that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public AccountLog updateAccountLog(AccountLog accountLog) {
		return accountLogPersistence.update(accountLog);
	}

	/**
	 * Returns the account log local service.
	 *
	 * @return the account log local service
	 */
	public AccountLogLocalService getAccountLogLocalService() {
		return accountLogLocalService;
	}

	/**
	 * Sets the account log local service.
	 *
	 * @param accountLogLocalService the account log local service
	 */
	public void setAccountLogLocalService(
		AccountLogLocalService accountLogLocalService) {

		this.accountLogLocalService = accountLogLocalService;
	}

	/**
	 * Returns the account log persistence.
	 *
	 * @return the account log persistence
	 */
	public AccountLogPersistence getAccountLogPersistence() {
		return accountLogPersistence;
	}

	/**
	 * Sets the account log persistence.
	 *
	 * @param accountLogPersistence the account log persistence
	 */
	public void setAccountLogPersistence(
		AccountLogPersistence accountLogPersistence) {

		this.accountLogPersistence = accountLogPersistence;
	}

	/**
	 * Returns the data import local service.
	 *
	 * @return the data import local service
	 */
	public dtt.vn.user.service.service.DataImportLocalService
		getDataImportLocalService() {

		return dataImportLocalService;
	}

	/**
	 * Sets the data import local service.
	 *
	 * @param dataImportLocalService the data import local service
	 */
	public void setDataImportLocalService(
		dtt.vn.user.service.service.DataImportLocalService
			dataImportLocalService) {

		this.dataImportLocalService = dataImportLocalService;
	}

	/**
	 * Returns the data import persistence.
	 *
	 * @return the data import persistence
	 */
	public DataImportPersistence getDataImportPersistence() {
		return dataImportPersistence;
	}

	/**
	 * Sets the data import persistence.
	 *
	 * @param dataImportPersistence the data import persistence
	 */
	public void setDataImportPersistence(
		DataImportPersistence dataImportPersistence) {

		this.dataImportPersistence = dataImportPersistence;
	}

	/**
	 * Returns the data import finder.
	 *
	 * @return the data import finder
	 */
	public DataImportFinder getDataImportFinder() {
		return dataImportFinder;
	}

	/**
	 * Sets the data import finder.
	 *
	 * @param dataImportFinder the data import finder
	 */
	public void setDataImportFinder(DataImportFinder dataImportFinder) {
		this.dataImportFinder = dataImportFinder;
	}

	/**
	 * Returns the doi tuong su dung local service.
	 *
	 * @return the doi tuong su dung local service
	 */
	public dtt.vn.user.service.service.DoiTuongSuDungLocalService
		getDoiTuongSuDungLocalService() {

		return doiTuongSuDungLocalService;
	}

	/**
	 * Sets the doi tuong su dung local service.
	 *
	 * @param doiTuongSuDungLocalService the doi tuong su dung local service
	 */
	public void setDoiTuongSuDungLocalService(
		dtt.vn.user.service.service.DoiTuongSuDungLocalService
			doiTuongSuDungLocalService) {

		this.doiTuongSuDungLocalService = doiTuongSuDungLocalService;
	}

	/**
	 * Returns the doi tuong su dung persistence.
	 *
	 * @return the doi tuong su dung persistence
	 */
	public DoiTuongSuDungPersistence getDoiTuongSuDungPersistence() {
		return doiTuongSuDungPersistence;
	}

	/**
	 * Sets the doi tuong su dung persistence.
	 *
	 * @param doiTuongSuDungPersistence the doi tuong su dung persistence
	 */
	public void setDoiTuongSuDungPersistence(
		DoiTuongSuDungPersistence doiTuongSuDungPersistence) {

		this.doiTuongSuDungPersistence = doiTuongSuDungPersistence;
	}

	/**
	 * Returns the thong tin can bo local service.
	 *
	 * @return the thong tin can bo local service
	 */
	public dtt.vn.user.service.service.ThongTinCanBoLocalService
		getThongTinCanBoLocalService() {

		return thongTinCanBoLocalService;
	}

	/**
	 * Sets the thong tin can bo local service.
	 *
	 * @param thongTinCanBoLocalService the thong tin can bo local service
	 */
	public void setThongTinCanBoLocalService(
		dtt.vn.user.service.service.ThongTinCanBoLocalService
			thongTinCanBoLocalService) {

		this.thongTinCanBoLocalService = thongTinCanBoLocalService;
	}

	/**
	 * Returns the thong tin can bo persistence.
	 *
	 * @return the thong tin can bo persistence
	 */
	public ThongTinCanBoPersistence getThongTinCanBoPersistence() {
		return thongTinCanBoPersistence;
	}

	/**
	 * Sets the thong tin can bo persistence.
	 *
	 * @param thongTinCanBoPersistence the thong tin can bo persistence
	 */
	public void setThongTinCanBoPersistence(
		ThongTinCanBoPersistence thongTinCanBoPersistence) {

		this.thongTinCanBoPersistence = thongTinCanBoPersistence;
	}

	/**
	 * Returns the thong tin dang ky local service.
	 *
	 * @return the thong tin dang ky local service
	 */
	public dtt.vn.user.service.service.ThongTinDangKyLocalService
		getThongTinDangKyLocalService() {

		return thongTinDangKyLocalService;
	}

	/**
	 * Sets the thong tin dang ky local service.
	 *
	 * @param thongTinDangKyLocalService the thong tin dang ky local service
	 */
	public void setThongTinDangKyLocalService(
		dtt.vn.user.service.service.ThongTinDangKyLocalService
			thongTinDangKyLocalService) {

		this.thongTinDangKyLocalService = thongTinDangKyLocalService;
	}

	/**
	 * Returns the thong tin dang ky persistence.
	 *
	 * @return the thong tin dang ky persistence
	 */
	public ThongTinDangKyPersistence getThongTinDangKyPersistence() {
		return thongTinDangKyPersistence;
	}

	/**
	 * Sets the thong tin dang ky persistence.
	 *
	 * @param thongTinDangKyPersistence the thong tin dang ky persistence
	 */
	public void setThongTinDangKyPersistence(
		ThongTinDangKyPersistence thongTinDangKyPersistence) {

		this.thongTinDangKyPersistence = thongTinDangKyPersistence;
	}

	/**
	 * Returns the thong tin dang ky finder.
	 *
	 * @return the thong tin dang ky finder
	 */
	public ThongTinDangKyFinder getThongTinDangKyFinder() {
		return thongTinDangKyFinder;
	}

	/**
	 * Sets the thong tin dang ky finder.
	 *
	 * @param thongTinDangKyFinder the thong tin dang ky finder
	 */
	public void setThongTinDangKyFinder(
		ThongTinDangKyFinder thongTinDangKyFinder) {

		this.thongTinDangKyFinder = thongTinDangKyFinder;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService
		getCounterLocalService() {

		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService
			counterLocalService) {

		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService
		getClassNameLocalService() {

		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService
			classNameLocalService) {

		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {

		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService
		getResourceLocalService() {

		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService
			resourceLocalService) {

		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService
		getUserLocalService() {

		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {

		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register(
			"dtt.vn.user.service.model.AccountLog", accountLogLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"dtt.vn.user.service.model.AccountLog");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return AccountLogLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return AccountLog.class;
	}

	protected String getModelClassName() {
		return AccountLog.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = accountLogPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = AccountLogLocalService.class)
	protected AccountLogLocalService accountLogLocalService;

	@BeanReference(type = AccountLogPersistence.class)
	protected AccountLogPersistence accountLogPersistence;

	@BeanReference(
		type = dtt.vn.user.service.service.DataImportLocalService.class
	)
	protected dtt.vn.user.service.service.DataImportLocalService
		dataImportLocalService;

	@BeanReference(type = DataImportPersistence.class)
	protected DataImportPersistence dataImportPersistence;

	@BeanReference(type = DataImportFinder.class)
	protected DataImportFinder dataImportFinder;

	@BeanReference(
		type = dtt.vn.user.service.service.DoiTuongSuDungLocalService.class
	)
	protected dtt.vn.user.service.service.DoiTuongSuDungLocalService
		doiTuongSuDungLocalService;

	@BeanReference(type = DoiTuongSuDungPersistence.class)
	protected DoiTuongSuDungPersistence doiTuongSuDungPersistence;

	@BeanReference(
		type = dtt.vn.user.service.service.ThongTinCanBoLocalService.class
	)
	protected dtt.vn.user.service.service.ThongTinCanBoLocalService
		thongTinCanBoLocalService;

	@BeanReference(type = ThongTinCanBoPersistence.class)
	protected ThongTinCanBoPersistence thongTinCanBoPersistence;

	@BeanReference(
		type = dtt.vn.user.service.service.ThongTinDangKyLocalService.class
	)
	protected dtt.vn.user.service.service.ThongTinDangKyLocalService
		thongTinDangKyLocalService;

	@BeanReference(type = ThongTinDangKyPersistence.class)
	protected ThongTinDangKyPersistence thongTinDangKyPersistence;

	@BeanReference(type = ThongTinDangKyFinder.class)
	protected ThongTinDangKyFinder thongTinDangKyFinder;

	@ServiceReference(
		type = com.liferay.counter.kernel.service.CounterLocalService.class
	)
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.ClassNameLocalService.class
	)
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.ResourceLocalService.class
	)
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.UserLocalService.class
	)
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;

	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry
		persistedModelLocalServiceRegistry;

}