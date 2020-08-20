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

import dtt.vn.vnpost.model.WorkItem;
import dtt.vn.vnpost.service.WorkItemLocalService;
import dtt.vn.vnpost.service.persistence.AccountFinder;
import dtt.vn.vnpost.service.persistence.AccountPersistence;
import dtt.vn.vnpost.service.persistence.DanhMucPersistence;
import dtt.vn.vnpost.service.persistence.NhomPersistence;
import dtt.vn.vnpost.service.persistence.PhotoPersistence;
import dtt.vn.vnpost.service.persistence.WorkItemFinder;
import dtt.vn.vnpost.service.persistence.WorkItemPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the work item local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link dtt.vn.vnpost.service.impl.WorkItemLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see dtt.vn.vnpost.service.impl.WorkItemLocalServiceImpl
 * @generated
 */
@ProviderType
public abstract class WorkItemLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements WorkItemLocalService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>WorkItemLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>dtt.vn.vnpost.service.WorkItemLocalServiceUtil</code>.
	 */

	/**
	 * Adds the work item to the database. Also notifies the appropriate model listeners.
	 *
	 * @param workItem the work item
	 * @return the work item that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public WorkItem addWorkItem(WorkItem workItem) {
		workItem.setNew(true);

		return workItemPersistence.update(workItem);
	}

	/**
	 * Creates a new work item with the primary key. Does not add the work item to the database.
	 *
	 * @param workItemId the primary key for the new work item
	 * @return the new work item
	 */
	@Override
	@Transactional(enabled = false)
	public WorkItem createWorkItem(long workItemId) {
		return workItemPersistence.create(workItemId);
	}

	/**
	 * Deletes the work item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workItemId the primary key of the work item
	 * @return the work item that was removed
	 * @throws PortalException if a work item with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public WorkItem deleteWorkItem(long workItemId) throws PortalException {
		return workItemPersistence.remove(workItemId);
	}

	/**
	 * Deletes the work item from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workItem the work item
	 * @return the work item that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public WorkItem deleteWorkItem(WorkItem workItem) {
		return workItemPersistence.remove(workItem);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			WorkItem.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return workItemPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>dtt.vn.vnpost.model.impl.WorkItemModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return workItemPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>dtt.vn.vnpost.model.impl.WorkItemModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return workItemPersistence.findWithDynamicQuery(
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
		return workItemPersistence.countWithDynamicQuery(dynamicQuery);
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

		return workItemPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public WorkItem fetchWorkItem(long workItemId) {
		return workItemPersistence.fetchByPrimaryKey(workItemId);
	}

	/**
	 * Returns the work item with the primary key.
	 *
	 * @param workItemId the primary key of the work item
	 * @return the work item
	 * @throws PortalException if a work item with the primary key could not be found
	 */
	@Override
	public WorkItem getWorkItem(long workItemId) throws PortalException {
		return workItemPersistence.findByPrimaryKey(workItemId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(workItemLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(WorkItem.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("workItemId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			workItemLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(WorkItem.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("workItemId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(workItemLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(WorkItem.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("workItemId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return workItemLocalService.deleteWorkItem((WorkItem)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return workItemPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the work items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>dtt.vn.vnpost.model.impl.WorkItemModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of work items
	 * @param end the upper bound of the range of work items (not inclusive)
	 * @return the range of work items
	 */
	@Override
	public List<WorkItem> getWorkItems(int start, int end) {
		return workItemPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of work items.
	 *
	 * @return the number of work items
	 */
	@Override
	public int getWorkItemsCount() {
		return workItemPersistence.countAll();
	}

	/**
	 * Updates the work item in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param workItem the work item
	 * @return the work item that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public WorkItem updateWorkItem(WorkItem workItem) {
		return workItemPersistence.update(workItem);
	}

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
	public WorkItemLocalService getWorkItemLocalService() {
		return workItemLocalService;
	}

	/**
	 * Sets the work item local service.
	 *
	 * @param workItemLocalService the work item local service
	 */
	public void setWorkItemLocalService(
		WorkItemLocalService workItemLocalService) {

		this.workItemLocalService = workItemLocalService;
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
			"dtt.vn.vnpost.model.WorkItem", workItemLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"dtt.vn.vnpost.model.WorkItem");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return WorkItemLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return WorkItem.class;
	}

	protected String getModelClassName() {
		return WorkItem.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = workItemPersistence.getDataSource();

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

	@BeanReference(type = PhotoPersistence.class)
	protected PhotoPersistence photoPersistence;

	@BeanReference(type = WorkItemLocalService.class)
	protected WorkItemLocalService workItemLocalService;

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