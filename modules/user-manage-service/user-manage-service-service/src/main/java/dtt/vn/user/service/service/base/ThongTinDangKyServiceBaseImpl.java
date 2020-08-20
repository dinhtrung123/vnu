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

import dtt.vn.user.service.model.ThongTinDangKy;
import dtt.vn.user.service.service.ThongTinDangKyService;
import dtt.vn.user.service.service.persistence.AccountLogPersistence;
import dtt.vn.user.service.service.persistence.DataImportFinder;
import dtt.vn.user.service.service.persistence.DataImportPersistence;
import dtt.vn.user.service.service.persistence.DoiTuongSuDungPersistence;
import dtt.vn.user.service.service.persistence.ThongTinCanBoPersistence;
import dtt.vn.user.service.service.persistence.ThongTinDangKyFinder;
import dtt.vn.user.service.service.persistence.ThongTinDangKyPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the thong tin dang ky remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link dtt.vn.user.service.service.impl.ThongTinDangKyServiceImpl}.
 * </p>
 *
 * @author nhanvienDTT
 * @see dtt.vn.user.service.service.impl.ThongTinDangKyServiceImpl
 * @generated
 */
public abstract class ThongTinDangKyServiceBaseImpl
	extends BaseServiceImpl
	implements ThongTinDangKyService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>ThongTinDangKyService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>dtt.vn.user.service.service.ThongTinDangKyServiceUtil</code>.
	 */

	/**
	 * Returns the account log local service.
	 *
	 * @return the account log local service
	 */
	public dtt.vn.user.service.service.AccountLogLocalService
		getAccountLogLocalService() {

		return accountLogLocalService;
	}

	/**
	 * Sets the account log local service.
	 *
	 * @param accountLogLocalService the account log local service
	 */
	public void setAccountLogLocalService(
		dtt.vn.user.service.service.AccountLogLocalService
			accountLogLocalService) {

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
	 * Returns the data import remote service.
	 *
	 * @return the data import remote service
	 */
	public dtt.vn.user.service.service.DataImportService
		getDataImportService() {

		return dataImportService;
	}

	/**
	 * Sets the data import remote service.
	 *
	 * @param dataImportService the data import remote service
	 */
	public void setDataImportService(
		dtt.vn.user.service.service.DataImportService dataImportService) {

		this.dataImportService = dataImportService;
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
	 * Returns the doi tuong su dung remote service.
	 *
	 * @return the doi tuong su dung remote service
	 */
	public dtt.vn.user.service.service.DoiTuongSuDungService
		getDoiTuongSuDungService() {

		return doiTuongSuDungService;
	}

	/**
	 * Sets the doi tuong su dung remote service.
	 *
	 * @param doiTuongSuDungService the doi tuong su dung remote service
	 */
	public void setDoiTuongSuDungService(
		dtt.vn.user.service.service.DoiTuongSuDungService
			doiTuongSuDungService) {

		this.doiTuongSuDungService = doiTuongSuDungService;
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
	 * Returns the thong tin can bo remote service.
	 *
	 * @return the thong tin can bo remote service
	 */
	public dtt.vn.user.service.service.ThongTinCanBoService
		getThongTinCanBoService() {

		return thongTinCanBoService;
	}

	/**
	 * Sets the thong tin can bo remote service.
	 *
	 * @param thongTinCanBoService the thong tin can bo remote service
	 */
	public void setThongTinCanBoService(
		dtt.vn.user.service.service.ThongTinCanBoService thongTinCanBoService) {

		this.thongTinCanBoService = thongTinCanBoService;
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
	 * Returns the thong tin dang ky remote service.
	 *
	 * @return the thong tin dang ky remote service
	 */
	public ThongTinDangKyService getThongTinDangKyService() {
		return thongTinDangKyService;
	}

	/**
	 * Sets the thong tin dang ky remote service.
	 *
	 * @param thongTinDangKyService the thong tin dang ky remote service
	 */
	public void setThongTinDangKyService(
		ThongTinDangKyService thongTinDangKyService) {

		this.thongTinDangKyService = thongTinDangKyService;
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
		return ThongTinDangKyService.class.getName();
	}

	protected Class<?> getModelClass() {
		return ThongTinDangKy.class;
	}

	protected String getModelClassName() {
		return ThongTinDangKy.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = thongTinDangKyPersistence.getDataSource();

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

	@BeanReference(
		type = dtt.vn.user.service.service.AccountLogLocalService.class
	)
	protected dtt.vn.user.service.service.AccountLogLocalService
		accountLogLocalService;

	@BeanReference(type = AccountLogPersistence.class)
	protected AccountLogPersistence accountLogPersistence;

	@BeanReference(
		type = dtt.vn.user.service.service.DataImportLocalService.class
	)
	protected dtt.vn.user.service.service.DataImportLocalService
		dataImportLocalService;

	@BeanReference(type = dtt.vn.user.service.service.DataImportService.class)
	protected dtt.vn.user.service.service.DataImportService dataImportService;

	@BeanReference(type = DataImportPersistence.class)
	protected DataImportPersistence dataImportPersistence;

	@BeanReference(type = DataImportFinder.class)
	protected DataImportFinder dataImportFinder;

	@BeanReference(
		type = dtt.vn.user.service.service.DoiTuongSuDungLocalService.class
	)
	protected dtt.vn.user.service.service.DoiTuongSuDungLocalService
		doiTuongSuDungLocalService;

	@BeanReference(
		type = dtt.vn.user.service.service.DoiTuongSuDungService.class
	)
	protected dtt.vn.user.service.service.DoiTuongSuDungService
		doiTuongSuDungService;

	@BeanReference(type = DoiTuongSuDungPersistence.class)
	protected DoiTuongSuDungPersistence doiTuongSuDungPersistence;

	@BeanReference(
		type = dtt.vn.user.service.service.ThongTinCanBoLocalService.class
	)
	protected dtt.vn.user.service.service.ThongTinCanBoLocalService
		thongTinCanBoLocalService;

	@BeanReference(
		type = dtt.vn.user.service.service.ThongTinCanBoService.class
	)
	protected dtt.vn.user.service.service.ThongTinCanBoService
		thongTinCanBoService;

	@BeanReference(type = ThongTinCanBoPersistence.class)
	protected ThongTinCanBoPersistence thongTinCanBoPersistence;

	@BeanReference(
		type = dtt.vn.user.service.service.ThongTinDangKyLocalService.class
	)
	protected dtt.vn.user.service.service.ThongTinDangKyLocalService
		thongTinDangKyLocalService;

	@BeanReference(type = ThongTinDangKyService.class)
	protected ThongTinDangKyService thongTinDangKyService;

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