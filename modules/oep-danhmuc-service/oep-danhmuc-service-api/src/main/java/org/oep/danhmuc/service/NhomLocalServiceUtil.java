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

package org.oep.danhmuc.service;

import aQute.bnd.annotation.ProviderType;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Nhom. This utility wraps
 * <code>org.oep.danhmuc.service.impl.NhomLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author nhanvienDTT
 * @see NhomLocalService
 * @generated
 */
@ProviderType
public class NhomLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>org.oep.danhmuc.service.impl.NhomLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the nhom to the database. Also notifies the appropriate model listeners.
	 *
	 * @param nhom the nhom
	 * @return the nhom that was added
	 */
	public static org.oep.danhmuc.model.Nhom addNhom(
		org.oep.danhmuc.model.Nhom nhom) {

		return getService().addNhom(nhom);
	}

	/**
	 * Creates a new nhom with the primary key. Does not add the nhom to the database.
	 *
	 * @param id the primary key for the new nhom
	 * @return the new nhom
	 */
	public static org.oep.danhmuc.model.Nhom createNhom(long id) {
		return getService().createNhom(id);
	}

	/**
	 * Deletes the nhom with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the nhom
	 * @return the nhom that was removed
	 * @throws PortalException if a nhom with the primary key could not be found
	 */
	public static org.oep.danhmuc.model.Nhom deleteNhom(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteNhom(id);
	}

	/**
	 * Deletes the nhom from the database. Also notifies the appropriate model listeners.
	 *
	 * @param nhom the nhom
	 * @return the nhom that was removed
	 */
	public static org.oep.danhmuc.model.Nhom deleteNhom(
		org.oep.danhmuc.model.Nhom nhom) {

		return getService().deleteNhom(nhom);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>org.oep.danhmuc.model.impl.NhomModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>org.oep.danhmuc.model.impl.NhomModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static org.oep.danhmuc.model.Nhom fetchNhom(long id) {
		return getService().fetchNhom(id);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the nhom with the primary key.
	 *
	 * @param id the primary key of the nhom
	 * @return the nhom
	 * @throws PortalException if a nhom with the primary key could not be found
	 */
	public static org.oep.danhmuc.model.Nhom getNhom(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getNhom(id);
	}

	public static org.oep.danhmuc.model.Nhom getNhomByMa(String maNhom)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getNhomByMa(maNhom);
	}

	/**
	 * Returns a range of all the nhoms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>org.oep.danhmuc.model.impl.NhomModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of nhoms
	 * @param end the upper bound of the range of nhoms (not inclusive)
	 * @return the range of nhoms
	 */
	public static java.util.List<org.oep.danhmuc.model.Nhom> getNhoms(
		int start, int end) {

		return getService().getNhoms(start, end);
	}

	/**
	 * Returns the number of nhoms.
	 *
	 * @return the number of nhoms
	 */
	public static int getNhomsCount() {
		return getService().getNhomsCount();
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
	 * Updates the nhom in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param nhom the nhom
	 * @return the nhom that was updated
	 */
	public static org.oep.danhmuc.model.Nhom updateNhom(
		org.oep.danhmuc.model.Nhom nhom) {

		return getService().updateNhom(nhom);
	}

	public static NhomLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<NhomLocalService, NhomLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(NhomLocalService.class);

		ServiceTracker<NhomLocalService, NhomLocalService> serviceTracker =
			new ServiceTracker<NhomLocalService, NhomLocalService>(
				bundle.getBundleContext(), NhomLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}