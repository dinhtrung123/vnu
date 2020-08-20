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

package org.oep.danhmuc.service.base;

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

import javax.sql.DataSource;

import org.oep.danhmuc.model.Nhom;
import org.oep.danhmuc.service.NhomService;
import org.oep.danhmuc.service.persistence.DanhMucFinder;
import org.oep.danhmuc.service.persistence.DanhMucPersistence;
import org.oep.danhmuc.service.persistence.NhomPersistence;

/**
 * Provides the base implementation for the nhom remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link org.oep.danhmuc.service.impl.NhomServiceImpl}.
 * </p>
 *
 * @author nhanvienDTT
 * @see org.oep.danhmuc.service.impl.NhomServiceImpl
 * @generated
 */
public abstract class NhomServiceBaseImpl
	extends BaseServiceImpl implements NhomService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>NhomService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>org.oep.danhmuc.service.NhomServiceUtil</code>.
	 */

	/**
	 * Returns the danh muc local service.
	 *
	 * @return the danh muc local service
	 */
	public org.oep.danhmuc.service.DanhMucLocalService
		getDanhMucLocalService() {

		return danhMucLocalService;
	}

	/**
	 * Sets the danh muc local service.
	 *
	 * @param danhMucLocalService the danh muc local service
	 */
	public void setDanhMucLocalService(
		org.oep.danhmuc.service.DanhMucLocalService danhMucLocalService) {

		this.danhMucLocalService = danhMucLocalService;
	}

	/**
	 * Returns the danh muc remote service.
	 *
	 * @return the danh muc remote service
	 */
	public org.oep.danhmuc.service.DanhMucService getDanhMucService() {
		return danhMucService;
	}

	/**
	 * Sets the danh muc remote service.
	 *
	 * @param danhMucService the danh muc remote service
	 */
	public void setDanhMucService(
		org.oep.danhmuc.service.DanhMucService danhMucService) {

		this.danhMucService = danhMucService;
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
	 * Returns the danh muc finder.
	 *
	 * @return the danh muc finder
	 */
	public DanhMucFinder getDanhMucFinder() {
		return danhMucFinder;
	}

	/**
	 * Sets the danh muc finder.
	 *
	 * @param danhMucFinder the danh muc finder
	 */
	public void setDanhMucFinder(DanhMucFinder danhMucFinder) {
		this.danhMucFinder = danhMucFinder;
	}

	/**
	 * Returns the nhom local service.
	 *
	 * @return the nhom local service
	 */
	public org.oep.danhmuc.service.NhomLocalService getNhomLocalService() {
		return nhomLocalService;
	}

	/**
	 * Sets the nhom local service.
	 *
	 * @param nhomLocalService the nhom local service
	 */
	public void setNhomLocalService(
		org.oep.danhmuc.service.NhomLocalService nhomLocalService) {

		this.nhomLocalService = nhomLocalService;
	}

	/**
	 * Returns the nhom remote service.
	 *
	 * @return the nhom remote service
	 */
	public NhomService getNhomService() {
		return nhomService;
	}

	/**
	 * Sets the nhom remote service.
	 *
	 * @param nhomService the nhom remote service
	 */
	public void setNhomService(NhomService nhomService) {
		this.nhomService = nhomService;
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
		return NhomService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Nhom.class;
	}

	protected String getModelClassName() {
		return Nhom.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = nhomPersistence.getDataSource();

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

	@BeanReference(type = org.oep.danhmuc.service.DanhMucLocalService.class)
	protected org.oep.danhmuc.service.DanhMucLocalService danhMucLocalService;

	@BeanReference(type = org.oep.danhmuc.service.DanhMucService.class)
	protected org.oep.danhmuc.service.DanhMucService danhMucService;

	@BeanReference(type = DanhMucPersistence.class)
	protected DanhMucPersistence danhMucPersistence;

	@BeanReference(type = DanhMucFinder.class)
	protected DanhMucFinder danhMucFinder;

	@BeanReference(type = org.oep.danhmuc.service.NhomLocalService.class)
	protected org.oep.danhmuc.service.NhomLocalService nhomLocalService;

	@BeanReference(type = NhomService.class)
	protected NhomService nhomService;

	@BeanReference(type = NhomPersistence.class)
	protected NhomPersistence nhomPersistence;

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