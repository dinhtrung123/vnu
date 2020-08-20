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
 * Provides the local service utility for DoiTuongSuDung. This utility wraps
 * <code>dtt.vn.user.service.service.impl.DoiTuongSuDungLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author nhanvienDTT
 * @see DoiTuongSuDungLocalService
 * @generated
 */
@ProviderType
public class DoiTuongSuDungLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>dtt.vn.user.service.service.impl.DoiTuongSuDungLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the doi tuong su dung to the database. Also notifies the appropriate model listeners.
	 *
	 * @param doiTuongSuDung the doi tuong su dung
	 * @return the doi tuong su dung that was added
	 */
	public static dtt.vn.user.service.model.DoiTuongSuDung addDoiTuongSuDung(
		dtt.vn.user.service.model.DoiTuongSuDung doiTuongSuDung) {

		return getService().addDoiTuongSuDung(doiTuongSuDung);
	}

	/**
	 * Creates a new doi tuong su dung with the primary key. Does not add the doi tuong su dung to the database.
	 *
	 * @param id the primary key for the new doi tuong su dung
	 * @return the new doi tuong su dung
	 */
	public static dtt.vn.user.service.model.DoiTuongSuDung createDoiTuongSuDung(
		long id) {

		return getService().createDoiTuongSuDung(id);
	}

	/**
	 * Deletes the doi tuong su dung from the database. Also notifies the appropriate model listeners.
	 *
	 * @param doiTuongSuDung the doi tuong su dung
	 * @return the doi tuong su dung that was removed
	 */
	public static dtt.vn.user.service.model.DoiTuongSuDung deleteDoiTuongSuDung(
		dtt.vn.user.service.model.DoiTuongSuDung doiTuongSuDung) {

		return getService().deleteDoiTuongSuDung(doiTuongSuDung);
	}

	/**
	 * Deletes the doi tuong su dung with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the doi tuong su dung
	 * @return the doi tuong su dung that was removed
	 * @throws PortalException if a doi tuong su dung with the primary key could not be found
	 */
	public static dtt.vn.user.service.model.DoiTuongSuDung deleteDoiTuongSuDung(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteDoiTuongSuDung(id);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>dtt.vn.user.service.model.impl.DoiTuongSuDungModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>dtt.vn.user.service.model.impl.DoiTuongSuDungModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static dtt.vn.user.service.model.DoiTuongSuDung fetchDoiTuongSuDung(
		long id) {

		return getService().fetchDoiTuongSuDung(id);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the doi tuong su dung with the primary key.
	 *
	 * @param id the primary key of the doi tuong su dung
	 * @return the doi tuong su dung
	 * @throws PortalException if a doi tuong su dung with the primary key could not be found
	 */
	public static dtt.vn.user.service.model.DoiTuongSuDung getDoiTuongSuDung(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getDoiTuongSuDung(id);
	}

	public static dtt.vn.user.service.model.DoiTuongSuDung
			getDoiTuongSuDungByMa(String ma)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getDoiTuongSuDungByMa(ma);
	}

	/**
	 * Returns a range of all the doi tuong su dungs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>dtt.vn.user.service.model.impl.DoiTuongSuDungModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of doi tuong su dungs
	 * @param end the upper bound of the range of doi tuong su dungs (not inclusive)
	 * @return the range of doi tuong su dungs
	 */
	public static java.util.List<dtt.vn.user.service.model.DoiTuongSuDung>
		getDoiTuongSuDungs(int start, int end) {

		return getService().getDoiTuongSuDungs(start, end);
	}

	/**
	 * Returns the number of doi tuong su dungs.
	 *
	 * @return the number of doi tuong su dungs
	 */
	public static int getDoiTuongSuDungsCount() {
		return getService().getDoiTuongSuDungsCount();
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
	 * Updates the doi tuong su dung in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param doiTuongSuDung the doi tuong su dung
	 * @return the doi tuong su dung that was updated
	 */
	public static dtt.vn.user.service.model.DoiTuongSuDung updateDoiTuongSuDung(
		dtt.vn.user.service.model.DoiTuongSuDung doiTuongSuDung) {

		return getService().updateDoiTuongSuDung(doiTuongSuDung);
	}

	public static DoiTuongSuDungLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<DoiTuongSuDungLocalService, DoiTuongSuDungLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			DoiTuongSuDungLocalService.class);

		ServiceTracker<DoiTuongSuDungLocalService, DoiTuongSuDungLocalService>
			serviceTracker =
				new ServiceTracker
					<DoiTuongSuDungLocalService, DoiTuongSuDungLocalService>(
						bundle.getBundleContext(),
						DoiTuongSuDungLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}