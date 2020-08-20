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

package dtt.vn.vnpost.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import dtt.vn.vnpost.model.Account;
import dtt.vn.vnpost.service.AccountService;
import dtt.vn.vnpost.service.persistence.AccountFinder;
import dtt.vn.vnpost.service.persistence.AccountPersistence;
import dtt.vn.vnpost.service.persistence.DanhMucPersistence;
import dtt.vn.vnpost.service.persistence.NhomPersistence;
import dtt.vn.vnpost.service.persistence.PhotoPersistence;
import dtt.vn.vnpost.service.persistence.WorkItemFinder;
import dtt.vn.vnpost.service.persistence.WorkItemPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the account remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link dtt.vn.vnpost.service.impl.AccountServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see dtt.vn.vnpost.service.impl.AccountServiceImpl
 * @generated
 */
public abstract class AccountServiceBaseImpl
	extends BaseServiceImpl implements AccountService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>AccountService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>dtt.vn.vnpost.service.AccountServiceUtil</code>.
	 */

	/**
	 * Returns the account local service.
	 *
	 * @return the account local service
	 */
	public dtt.vn.vnpost.service.AccountLocalService getAccountLocalService() {
		return accountLocalService;
	}

	/**
	 * Sets the account local service.
	 *
	 * @param accountLocalService the account local service
	 */
	public void setAccountLocalService(
		dtt.vn.vnpost.service.AccountLocalService accountLocalService) {

		this.accountLocalService = accountLocalService;
	}

	/**
	 * Returns the account remote service.
	 *
	 * @return the account remote service
	 */
	public AccountService getAccountService() {
		return accountService;
	}

	/**
	 * Sets the account remote service.
	 *
	 * @param accountService the account remote service
	 */
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	/**
	 * Returns the account persistence.
	 *
	 * @return the account persistence
	 */
	public AccountPersistence getAccountPersistence() {
		return accountPersistence;
	}

	/**
	 * Sets the account persistence.
	 *
	 * @param accountPersistence the account persistence
	 */
	public void setAccountPersistence(AccountPersistence accountPersistence) {
		this.accountPersistence = accountPersistence;
	}

	/**
	 * Returns the account finder.
	 *
	 * @return the account finder
	 */
	public AccountFinder getAccountFinder() {
		return accountFinder;
	}

	/**
	 * Sets the account finder.
	 *
	 * @param accountFinder the account finder
	 */
	public void setAccountFinder(AccountFinder accountFinder) {
		this.accountFinder = accountFinder;
	}

	/**
	 * Returns the danh muc local service.
	 *
	 * @return the danh muc local service
	 */
	public dtt.vn.vnpost.service.DanhMucLocalService getDanhMucLocalService() {
		return danhMucLocalService;
	}

	/**
	 * Sets the danh muc local service.
	 *
	 * @param danhMucLocalService the danh muc local service
	 */
	public void setDanhMucLocalService(
		dtt.vn.vnpost.service.DanhMucLocalService danhMucLocalService) {

		this.danhMucLocalService = danhMucLocalService;
	}

	/**
	 * Returns the danh muc persistence.
	 *
	 * @return the danh muc persistence
	 */
	public DanhMucPersistence getDanhMucPersistence() {
		return danhMucPersistence;
	}

	/**
	 * Sets the danh muc persistence.
	 *
	 * @param danhMucPersistence the danh muc persistence
	 */
	public void setDanhMucPersistence(DanhMucPersistence danhMucPersistence) {
		this.danhMucPersistence = danhMucPersistence;
	}

	/**
	 * Returns the nhom local service.
	 *
	 * @return the nhom local service
	 */
	public dtt.vn.vnpost.service.NhomLocalService getNhomLocalService() {
		return nhomLocalService;
	}

	/**
	 * Sets the nhom local service.
	 *
	 * @param nhomLocalService the nhom local service
	 */
	public void setNhomLocalService(
		dtt.vn.vnpost.service.NhomLocalService nhomLocalService) {

		this.nhomLocalService = nhomLocalService;
	}

	/**
	 * Returns the nhom persistence.
	 *
	 * @return the nhom persistence
	 */
	public NhomPersistence getNhomPersistence() {
		return nhomPersistence;
	}

	/**
	 * Sets the nhom persistence.
	 *
	 * @param nhomPersistence the nhom persistence
	 */
	public void setNhomPersistence(NhomPersistence nhomPersistence) {
		this.nhomPersistence = nhomPersistence;
	}

	/**
	 * Returns the photo local service.
	 *
	 * @return the photo local service
	 */
	public dtt.vn.vnpost.service.PhotoLocalService getPhotoLocalService() {
		return photoLocalService;
	}

	/**
	 * Sets the photo local service.
	 *
	 * @param photoLocalService the photo local service
	 */
	public void setPhotoLocalService(
		dtt.vn.vnpost.service.PhotoLocalService photoLocalService) {

		this.photoLocalService = photoLocalService;
	}

	/**
	 * Returns the photo remote service.
	 *
	 * @return the photo remote service
	 */
	public dtt.vn.vnpost.service.PhotoService getPhotoService() {
		return photoService;
	}

	/**
	 * Sets the photo remote service.
	 *
	 * @param photoService the photo remote service
	 */
	public void setPhotoService(
		dtt.vn.vnpost.service.PhotoService photoService) {

		this.photoService = photoService;
	}

	/**
	 * Returns the photo persistence.
	 *
	 * @return the photo persistence
	 */
	public PhotoPersistence getPhotoPersistence() {
		return photoPersistence;
	}

	/**
	 * Sets the photo persistence.
	 *
	 * @param photoPersistence the photo persistence
	 */
	public void setPhotoPersistence(PhotoPersistence photoPersistence) {
		this.photoPersistence = photoPersistence;
	}

	/**
	 * Returns the work item local service.
	 *
	 * @return the work item local service
	 */
	public dtt.vn.vnpost.service.WorkItemLocalService
		getWorkItemLocalService() {

		return workItemLocalService;
	}

	/**
	 * Sets the work item local service.
	 *
	 * @param workItemLocalService the work item local service
	 */
	public void setWorkItemLocalService(
		dtt.vn.vnpost.service.WorkItemLocalService workItemLocalService) {

		this.workItemLocalService = workItemLocalService;
	}

	/**
	 * Returns the work item remote service.
	 *
	 * @return the work item remote service
	 */
	public dtt.vn.vnpost.service.WorkItemService getWorkItemService() {
		return workItemService;
	}

	/**
	 * Sets the work item remote service.
	 *
	 * @param workItemService the work item remote service
	 */
	public void setWorkItemService(
		dtt.vn.vnpost.service.WorkItemService workItemService) {

		this.workItemService = workItemService;
	}

	/**
	 * Returns the work item persistence.
	 *
	 * @return the work item persistence
	 */
	public WorkItemPersistence getWorkItemPersistence() {
		return workItemPersistence;
	}

	/**
	 * Sets the work item persistence.
	 *
	 * @param workItemPersistence the work item persistence
	 */
	public void setWorkItemPersistence(
		WorkItemPersistence workItemPersistence) {

		this.workItemPersistence = workItemPersistence;
	}

	/**
	 * Returns the work item finder.
	 *
	 * @return the work item finder
	 */
	public WorkItemFinder getWorkItemFinder() {
		return workItemFinder;
	}

	/**
	 * Sets the work item finder.
	 *
	 * @param workItemFinder the work item finder
	 */
	public void setWorkItemFinder(WorkItemFinder workItemFinder) {
		this.workItemFinder = workItemFinder;
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
	 * Returns the class name remote service.
	 *
	 * @return the class name remote service
	 */
	public com.liferay.portal.kernel.service.ClassNameService
		getClassNameService() {

		return classNameService;
	}

	/**
	 * Sets the class name remote service.
	 *
	 * @param classNameService the class name remote service
	 */
	public void setClassNameService(
		com.liferay.portal.kernel.service.ClassNameService classNameService) {

		this.classNameService = classNameService;
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
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.kernel.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.kernel.service.UserService userService) {

		this.userService = userService;
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
	}

	public void destroy() {
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return AccountService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Account.class;
	}

	protected String getModelClassName() {
		return Account.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = accountPersistence.getDataSource();

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

	@BeanReference(type = dtt.vn.vnpost.service.AccountLocalService.class)
	protected dtt.vn.vnpost.service.AccountLocalService accountLocalService;

	@BeanReference(type = AccountService.class)
	protected AccountService accountService;

	@BeanReference(type = AccountPersistence.class)
	protected AccountPersistence accountPersistence;

	@BeanReference(type = AccountFinder.class)
	protected AccountFinder accountFinder;

	@BeanReference(type = dtt.vn.vnpost.service.DanhMucLocalService.class)
	protected dtt.vn.vnpost.service.DanhMucLocalService danhMucLocalService;

	@BeanReference(type = DanhMucPersistence.class)
	protected DanhMucPersistence danhMucPersistence;

	@BeanReference(type = dtt.vn.vnpost.service.NhomLocalService.class)
	protected dtt.vn.vnpost.service.NhomLocalService nhomLocalService;

	@BeanReference(type = NhomPersistence.class)
	protected NhomPersistence nhomPersistence;

	@BeanReference(type = dtt.vn.vnpost.service.PhotoLocalService.class)
	protected dtt.vn.vnpost.service.PhotoLocalService photoLocalService;

	@BeanReference(type = dtt.vn.vnpost.service.PhotoService.class)
	protected dtt.vn.vnpost.service.PhotoService photoService;

	@BeanReference(type = PhotoPersistence.class)
	protected PhotoPersistence photoPersistence;

	@BeanReference(type = dtt.vn.vnpost.service.WorkItemLocalService.class)
	protected dtt.vn.vnpost.service.WorkItemLocalService workItemLocalService;

	@BeanReference(type = dtt.vn.vnpost.service.WorkItemService.class)
	protected dtt.vn.vnpost.service.WorkItemService workItemService;

	@BeanReference(type = WorkItemPersistence.class)
	protected WorkItemPersistence workItemPersistence;

	@BeanReference(type = WorkItemFinder.class)
	protected WorkItemFinder workItemFinder;

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

	@ServiceReference(
		type = com.liferay.portal.kernel.service.ClassNameService.class
	)
	protected com.liferay.portal.kernel.service.ClassNameService
		classNameService;

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

	@ServiceReference(
		type = com.liferay.portal.kernel.service.UserService.class
	)
	protected com.liferay.portal.kernel.service.UserService userService;

	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;

}