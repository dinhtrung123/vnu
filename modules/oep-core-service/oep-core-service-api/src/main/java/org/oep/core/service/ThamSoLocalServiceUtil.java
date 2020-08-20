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

package org.oep.core.service;

import aQute.bnd.annotation.ProviderType;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for ThamSo. This utility wraps
 * <code>org.oep.core.service.impl.ThamSoLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author manhlb
 * @see ThamSoLocalService
 * @generated
 */
@ProviderType
public class ThamSoLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>org.oep.core.service.impl.ThamSoLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static org.oep.core.model.ThamSo addThamSo(
			Long groupId, Long loaiThamSoId, String ma, String giaTri,
			String moTa, boolean statusActive, int quyen)
		throws Exception {

		return getService().addThamSo(
			groupId, loaiThamSoId, ma, giaTri, moTa, statusActive, quyen);
	}

	/**
	 * Adds the tham so to the database. Also notifies the appropriate model listeners.
	 *
	 * @param thamSo the tham so
	 * @return the tham so that was added
	 */
	public static org.oep.core.model.ThamSo addThamSo(
		org.oep.core.model.ThamSo thamSo) {

		return getService().addThamSo(thamSo);
	}

	/**
	 * count match tham so by to chuc id - loai tham so id - ma
	 *
	 * Version: OEP 1.1
	 *
	 * History:
	 *   DATE        AUTHOR      DESCRIPTION
	 *  -------------------------------------------------
	 *  01-April-2015  trungdv    Create new
	 *
	 * @param groupId						groupId
	 loaiThamSoId				loai tham so id
	 ma							ma
	 * @return: int							number of match data
	 * @throws SystemException
	 */
	public static int countByL_M(long groupId, long loaiThamSoId, String ma) {
		return getService().countByL_M(groupId, loaiThamSoId, ma);
	}

	/**
	 * Creates a new tham so with the primary key. Does not add the tham so to the database.
	 *
	 * @param id the primary key for the new tham so
	 * @return the new tham so
	 */
	public static org.oep.core.model.ThamSo createThamSo(long id) {
		return getService().createThamSo(id);
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

	/**
	 * Deletes the tham so with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the tham so
	 * @return the tham so that was removed
	 * @throws PortalException if a tham so with the primary key could not be found
	 */
	public static org.oep.core.model.ThamSo deleteThamSo(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteThamSo(id);
	}

	/**
	 * Deletes the tham so from the database. Also notifies the appropriate model listeners.
	 *
	 * @param thamSo the tham so
	 * @return the tham so that was removed
	 */
	public static org.oep.core.model.ThamSo deleteThamSo(
		org.oep.core.model.ThamSo thamSo) {

		return getService().deleteThamSo(thamSo);
	}

	public static org.oep.core.model.ThamSo deleteThamSolong(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return getService().deleteThamSolong(id);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>org.oep.core.model.impl.ThamSoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>org.oep.core.model.impl.ThamSoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static org.oep.core.model.ThamSo fetchThamSo(long id) {
		return getService().fetchThamSo(id);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List<org.oep.core.model.ThamSo> getAll()
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getAll();
	}

	public static java.util.List<org.oep.core.model.ThamSo> getByMa(String ma)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getByMa(ma);
	}

	public static java.util.List<org.oep.core.model.ThamSo> getByValue(
			String value)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getByValue(value);
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
	 * Returns the tham so with the primary key.
	 *
	 * @param id the primary key of the tham so
	 * @return the tham so
	 * @throws PortalException if a tham so with the primary key could not be found
	 */
	public static org.oep.core.model.ThamSo getThamSo(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getThamSo(id);
	}

	/**
	 * Returns a range of all the tham sos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>org.oep.core.model.impl.ThamSoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tham sos
	 * @param end the upper bound of the range of tham sos (not inclusive)
	 * @return the range of tham sos
	 */
	public static java.util.List<org.oep.core.model.ThamSo> getThamSos(
		int start, int end) {

		return getService().getThamSos(start, end);
	}

	/**
	 * Returns the number of tham sos.
	 *
	 * @return the number of tham sos
	 */
	public static int getThamSosCount() {
		return getService().getThamSosCount();
	}

	public static org.oep.core.model.ThamSo getValue(long groupId, String ma) {
		return getService().getValue(groupId, ma);
	}

	public static String getValue(
		long groupId, String ma, String defaultValue) {

		return getService().getValue(groupId, ma, defaultValue);
	}

	public static org.oep.core.model.ThamSo getValue(
		String className, long classPK, String ma) {

		return getService().getValue(className, classPK, ma);
	}

	public static String getValue(
		String className, long classPK, String ma, String defaultValue) {

		return getService().getValue(className, classPK, ma, defaultValue);
	}

	public static String getValue(String ma, String defaultValue) {
		return getService().getValue(ma, defaultValue);
	}

	public static String getValue(
		String ma, String className, long classPK, String defaultValue) {

		return getService().getValue(ma, className, classPK, defaultValue);
	}

	public static String getValue(
		String ma, String className, String defaultValue) {

		return getService().getValue(ma, className, defaultValue);
	}

	/**
	 * get gia tri tham so by ma
	 *
	 * Version: OEP 1.1
	 *
	 * History:
	 *   DATE        AUTHOR      DESCRIPTION
	 *  -------------------------------------------------
	 *  01-April-2015  trungdv    Create new
	 *
	 * @param context					service context
	 mas						finding mas
	 * @return: Map<String, String>		mapping ma - gia tri
	 * @throws SystemException
	 */
	public static java.util.Map<String, String> getValues(
		long groupId, java.util.List<String> mas) {

		return getService().getValues(groupId, mas);
	}

	public static org.oep.core.model.ThamSo save(
		Long groupId, String className, long classPK, String ma, String giaTri,
		String moTa, long loaiThamSoId) {

		return getService().save(
			groupId, className, classPK, ma, giaTri, moTa, loaiThamSoId);
	}

	public static java.util.List<org.oep.core.model.ThamSo> searchByL_M(
		long groupId, long loaiId, String ma, int start, int end) {

		return getService().searchByL_M(groupId, loaiId, ma, start, end);
	}

	/**
	 * handle change status tham so
	 *
	 * Version: OEP 1.1
	 *
	 * History:
	 *   DATE        AUTHOR      DESCRIPTION
	 *  -------------------------------------------------
	 *  01-April-2015  trungdv    Create
	 *
	 * @param context						service context
	 id							id
	 * @return:
	 * @throws SystemException
	 * @throws PortalException
	 * @throws IllegalAccessException
	 */
	public static org.oep.core.model.ThamSo thayDoiTrangThaiThamSo(long id)
		throws Exception {

		return getService().thayDoiTrangThaiThamSo(id);
	}

	/**
	 * handle update tham so
	 *
	 * Version: OEP 1.1
	 *
	 * History:
	 *   DATE        AUTHOR      DESCRIPTION
	 *  -------------------------------------------------
	 *  01-April-2015  trungdv    Create new
	 *
	 * @param context						service context
	 loaiThamSoId					loai tham so
	 ma							ma
	 giaTri						gia tri
	 moTo							mo ta
	 * @return:
	 * @throws SystemException
	 * @throws PortalException
	 * @throws Exception
	 */
	public static org.oep.core.model.ThamSo updateThamSo(
			long id, long loaiThamSoId, String ma, String giaTri, String moTa,
			boolean status)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().updateThamSo(
			id, loaiThamSoId, ma, giaTri, moTa, status);
	}

	/**
	 * Updates the tham so in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param thamSo the tham so
	 * @return the tham so that was updated
	 */
	public static org.oep.core.model.ThamSo updateThamSo(
		org.oep.core.model.ThamSo thamSo) {

		return getService().updateThamSo(thamSo);
	}

	public static ThamSoLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ThamSoLocalService, ThamSoLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ThamSoLocalService.class);

		ServiceTracker<ThamSoLocalService, ThamSoLocalService> serviceTracker =
			new ServiceTracker<ThamSoLocalService, ThamSoLocalService>(
				bundle.getBundleContext(), ThamSoLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}