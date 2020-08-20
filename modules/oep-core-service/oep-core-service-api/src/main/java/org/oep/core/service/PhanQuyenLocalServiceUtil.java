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
 * Provides the local service utility for PhanQuyen. This utility wraps
 * <code>org.oep.core.service.impl.PhanQuyenLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author manhlb
 * @see PhanQuyenLocalService
 * @generated
 */
@ProviderType
public class PhanQuyenLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>org.oep.core.service.impl.PhanQuyenLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the phan quyen to the database. Also notifies the appropriate model listeners.
	 *
	 * @param phanQuyen the phan quyen
	 * @return the phan quyen that was added
	 */
	public static org.oep.core.model.PhanQuyen addPhanQuyen(
		org.oep.core.model.PhanQuyen phanQuyen) {

		return getService().addPhanQuyen(phanQuyen);
	}

	public static org.oep.core.model.PhanQuyen capQuyen(
		String classname, long classpk, String giatri) {

		return getService().capQuyen(classname, classpk, giatri);
	}

	/**
	 * Creates a new phan quyen with the primary key. Does not add the phan quyen to the database.
	 *
	 * @param id the primary key for the new phan quyen
	 * @return the new phan quyen
	 */
	public static org.oep.core.model.PhanQuyen createPhanQuyen(long id) {
		return getService().createPhanQuyen(id);
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
	 * Deletes the phan quyen with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the phan quyen
	 * @return the phan quyen that was removed
	 * @throws PortalException if a phan quyen with the primary key could not be found
	 */
	public static org.oep.core.model.PhanQuyen deletePhanQuyen(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePhanQuyen(id);
	}

	/**
	 * Deletes the phan quyen from the database. Also notifies the appropriate model listeners.
	 *
	 * @param phanQuyen the phan quyen
	 * @return the phan quyen that was removed
	 */
	public static org.oep.core.model.PhanQuyen deletePhanQuyen(
		org.oep.core.model.PhanQuyen phanQuyen) {

		return getService().deletePhanQuyen(phanQuyen);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>org.oep.core.model.impl.PhanQuyenModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>org.oep.core.model.impl.PhanQuyenModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static org.oep.core.model.PhanQuyen fetchPhanQuyen(long id) {
		return getService().fetchPhanQuyen(id);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static String getGiaTri(String classname, long classpk) {
		return getService().getGiaTri(classname, classpk);
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
	 * Returns the phan quyen with the primary key.
	 *
	 * @param id the primary key of the phan quyen
	 * @return the phan quyen
	 * @throws PortalException if a phan quyen with the primary key could not be found
	 */
	public static org.oep.core.model.PhanQuyen getPhanQuyen(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPhanQuyen(id);
	}

	/**
	 * Returns a range of all the phan quyens.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>org.oep.core.model.impl.PhanQuyenModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of phan quyens
	 * @param end the upper bound of the range of phan quyens (not inclusive)
	 * @return the range of phan quyens
	 */
	public static java.util.List<org.oep.core.model.PhanQuyen> getPhanQuyens(
		int start, int end) {

		return getService().getPhanQuyens(start, end);
	}

	/**
	 * Returns the number of phan quyens.
	 *
	 * @return the number of phan quyens
	 */
	public static int getPhanQuyensCount() {
		return getService().getPhanQuyensCount();
	}

	public static boolean huyCapQuyen(long phanQuyenId) {
		return getService().huyCapQuyen(phanQuyenId);
	}

	public static boolean huyCapQuyen(String classname, long classpk) {
		return getService().huyCapQuyen(classname, classpk);
	}

	/**
	 * Updates the phan quyen in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param phanQuyen the phan quyen
	 * @return the phan quyen that was updated
	 */
	public static org.oep.core.model.PhanQuyen updatePhanQuyen(
		org.oep.core.model.PhanQuyen phanQuyen) {

		return getService().updatePhanQuyen(phanQuyen);
	}

	public static PhanQuyenLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PhanQuyenLocalService, PhanQuyenLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PhanQuyenLocalService.class);

		ServiceTracker<PhanQuyenLocalService, PhanQuyenLocalService>
			serviceTracker =
				new ServiceTracker
					<PhanQuyenLocalService, PhanQuyenLocalService>(
						bundle.getBundleContext(), PhanQuyenLocalService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}