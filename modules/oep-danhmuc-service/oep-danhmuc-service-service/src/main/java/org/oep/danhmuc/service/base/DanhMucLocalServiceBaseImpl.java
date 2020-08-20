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

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

import org.oep.danhmuc.model.DanhMuc;
import org.oep.danhmuc.service.DanhMucLocalService;
import org.oep.danhmuc.service.persistence.DanhMucFinder;
import org.oep.danhmuc.service.persistence.DanhMucPersistence;
import org.oep.danhmuc.service.persistence.NhomPersistence;

/**
 * Provides the base implementation for the danh muc local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link org.oep.danhmuc.service.impl.DanhMucLocalServiceImpl}.
 * </p>
 *
 * @author nhanvienDTT
 * @see org.oep.danhmuc.service.impl.DanhMucLocalServiceImpl
 * @generated
 */
@ProviderType
public abstract class DanhMucLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements DanhMucLocalService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>DanhMucLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>org.oep.danhmuc.service.DanhMucLocalServiceUtil</code>.
	 */

	/**
	 * Adds the danh muc to the database. Also notifies the appropriate model listeners.
	 *
	 * @param danhMuc the danh muc
	 * @return the danh muc that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public DanhMuc addDanhMuc(DanhMuc danhMuc) {
		danhMuc.setNew(true);

		return danhMucPersistence.update(danhMuc);
	}

	/**
	 * Creates a new danh muc with the primary key. Does not add the danh muc to the database.
	 *
	 * @param id the primary key for the new danh muc
	 * @return the new danh muc
	 */
	@Override
	@Transactional(enabled = false)
	public DanhMuc createDanhMuc(long id) {
		return danhMucPersistence.create(id);
	}

	/**
	 * Deletes the danh muc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the danh muc
	 * @return the danh muc that was removed
	 * @throws PortalException if a danh muc with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public DanhMuc deleteDanhMuc(long id) throws PortalException {
		return danhMucPersistence.remove(id);
	}

	/**
	 * Deletes the danh muc from the database. Also notifies the appropriate model listeners.
	 *
	 * @param danhMuc the danh muc
	 * @return the danh muc that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public DanhMuc deleteDanhMuc(DanhMuc danhMuc) {
		return danhMucPersistence.remove(danhMuc);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			DanhMuc.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return danhMucPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>org.oep.danhmuc.model.impl.DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return danhMucPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>org.oep.danhmuc.model.impl.DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return danhMucPersistence.findWithDynamicQuery(
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
		return danhMucPersistence.countWithDynamicQuery(dynamicQuery);
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

		return danhMucPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public DanhMuc fetchDanhMuc(long id) {
		return danhMucPersistence.fetchByPrimaryKey(id);
	}

	/**
	 * Returns the danh muc with the primary key.
	 *
	 * @param id the primary key of the danh muc
	 * @return the danh muc
	 * @throws PortalException if a danh muc with the primary key could not be found
	 */
	@Override
	public DanhMuc getDanhMuc(long id) throws PortalException {
		return danhMucPersistence.findByPrimaryKey(id);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(danhMucLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(DanhMuc.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("id");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			danhMucLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(DanhMuc.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("id");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(danhMucLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(DanhMuc.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("id");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return danhMucLocalService.deleteDanhMuc((DanhMuc)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return danhMucPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the danh mucs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>org.oep.danhmuc.model.impl.DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @return the range of danh mucs
	 */
	@Override
	public List<DanhMuc> getDanhMucs(int start, int end) {
		return danhMucPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of danh mucs.
	 *
	 * @return the number of danh mucs
	 */
	@Override
	public int getDanhMucsCount() {
		return danhMucPersistence.countAll();
	}

	/**
	 * Updates the danh muc in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param danhMuc the danh muc
	 * @return the danh muc that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public DanhMuc updateDanhMuc(DanhMuc danhMuc) {
		return danhMucPersistence.update(danhMuc);
	}

	/**
	 * Returns the danh muc local service.
	 *
	 * @return the danh muc local service
	 */
	public DanhMucLocalService getDanhMucLocalService() {
		return danhMucLocalService;
	}

	/**
	 * Sets the danh muc local service.
	 *
	 * @param danhMucLocalService the danh muc local service
	 */
	public void setDanhMucLocalService(
		DanhMucLocalService danhMucLocalService) {

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
			"org.oep.danhmuc.model.DanhMuc", danhMucLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"org.oep.danhmuc.model.DanhMuc");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return DanhMucLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return DanhMuc.class;
	}

	protected String getModelClassName() {
		return DanhMuc.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = danhMucPersistence.getDataSource();

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

	@BeanReference(type = DanhMucLocalService.class)
	protected DanhMucLocalService danhMucLocalService;

	@BeanReference(type = DanhMucPersistence.class)
	protected DanhMucPersistence danhMucPersistence;

	@BeanReference(type = DanhMucFinder.class)
	protected DanhMucFinder danhMucFinder;

	@BeanReference(type = org.oep.danhmuc.service.NhomLocalService.class)
	protected org.oep.danhmuc.service.NhomLocalService nhomLocalService;

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