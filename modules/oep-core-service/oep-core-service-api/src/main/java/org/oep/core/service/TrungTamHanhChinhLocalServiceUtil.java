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
 * Provides the local service utility for TrungTamHanhChinh. This utility wraps
 * <code>org.oep.core.service.impl.TrungTamHanhChinhLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author manhlb
 * @see TrungTamHanhChinhLocalService
 * @generated
 */
@ProviderType
public class TrungTamHanhChinhLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>org.oep.core.service.impl.TrungTamHanhChinhLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static void addOrUpdate(
			long id, long coQuanQuanLyId, String ten, String ma,
			String donVi_Ids, int trangThai, String thongTinLienHe)
		throws com.liferay.portal.kernel.exception.SystemException {

		getService().addOrUpdate(
			id, coQuanQuanLyId, ten, ma, donVi_Ids, trangThai, thongTinLienHe);
	}

	/**
	 * Adds the trung tam hanh chinh to the database. Also notifies the appropriate model listeners.
	 *
	 * @param trungTamHanhChinh the trung tam hanh chinh
	 * @return the trung tam hanh chinh that was added
	 */
	public static org.oep.core.model.TrungTamHanhChinh addTrungTamHanhChinh(
		org.oep.core.model.TrungTamHanhChinh trungTamHanhChinh) {

		return getService().addTrungTamHanhChinh(trungTamHanhChinh);
	}

	public static int countTTHC(
		String ten_ma, long coQuanQuanLyId, int trangThai) {

		return getService().countTTHC(ten_ma, coQuanQuanLyId, trangThai);
	}

	/**
	 * Creates a new trung tam hanh chinh with the primary key. Does not add the trung tam hanh chinh to the database.
	 *
	 * @param id the primary key for the new trung tam hanh chinh
	 * @return the new trung tam hanh chinh
	 */
	public static org.oep.core.model.TrungTamHanhChinh createTrungTamHanhChinh(
		long id) {

		return getService().createTrungTamHanhChinh(id);
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
	 * Deletes the trung tam hanh chinh with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the trung tam hanh chinh
	 * @return the trung tam hanh chinh that was removed
	 * @throws PortalException if a trung tam hanh chinh with the primary key could not be found
	 */
	public static org.oep.core.model.TrungTamHanhChinh deleteTrungTamHanhChinh(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteTrungTamHanhChinh(id);
	}

	/**
	 * Deletes the trung tam hanh chinh from the database. Also notifies the appropriate model listeners.
	 *
	 * @param trungTamHanhChinh the trung tam hanh chinh
	 * @return the trung tam hanh chinh that was removed
	 */
	public static org.oep.core.model.TrungTamHanhChinh deleteTrungTamHanhChinh(
		org.oep.core.model.TrungTamHanhChinh trungTamHanhChinh) {

		return getService().deleteTrungTamHanhChinh(trungTamHanhChinh);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>org.oep.core.model.impl.TrungTamHanhChinhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>org.oep.core.model.impl.TrungTamHanhChinhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static org.oep.core.model.TrungTamHanhChinh fetchTrungTamHanhChinh(
		long id) {

		return getService().fetchTrungTamHanhChinh(id);
	}

	public static org.oep.core.model.TrungTamHanhChinh findByDonViXuLyId(
		long donvixulyId) {

		return getService().findByDonViXuLyId(donvixulyId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static org.oep.core.model.TrungTamHanhChinh getByCoQuanQuanLyId(
		long coQuanQuanLyId) {

		return getService().getByCoQuanQuanLyId(coQuanQuanLyId);
	}

	public static org.oep.core.model.TrungTamHanhChinh getByMa(String ma)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getByMa(ma);
	}

	public static long[] getDonViXuLyIds(long trungTamHanhChinhId) {
		return getService().getDonViXuLyIds(trungTamHanhChinhId);
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
	 * Returns the trung tam hanh chinh with the primary key.
	 *
	 * @param id the primary key of the trung tam hanh chinh
	 * @return the trung tam hanh chinh
	 * @throws PortalException if a trung tam hanh chinh with the primary key could not be found
	 */
	public static org.oep.core.model.TrungTamHanhChinh getTrungTamHanhChinh(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getTrungTamHanhChinh(id);
	}

	/**
	 * Returns a range of all the trung tam hanh chinhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>org.oep.core.model.impl.TrungTamHanhChinhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of trung tam hanh chinhs
	 * @param end the upper bound of the range of trung tam hanh chinhs (not inclusive)
	 * @return the range of trung tam hanh chinhs
	 */
	public static java.util.List<org.oep.core.model.TrungTamHanhChinh>
		getTrungTamHanhChinhs(int start, int end) {

		return getService().getTrungTamHanhChinhs(start, end);
	}

	/**
	 * Returns the number of trung tam hanh chinhs.
	 *
	 * @return the number of trung tam hanh chinhs
	 */
	public static int getTrungTamHanhChinhsCount() {
		return getService().getTrungTamHanhChinhsCount();
	}

	public static java.util.List<org.oep.core.model.TrungTamHanhChinh>
		searchByTen_Ma_CQQL(
			String ten_ma, long coQuanQuanLyId, int trangThai, int start,
			int end) {

		return getService().searchByTen_Ma_CQQL(
			ten_ma, coQuanQuanLyId, trangThai, start, end);
	}

	/**
	 * Updates the trung tam hanh chinh in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param trungTamHanhChinh the trung tam hanh chinh
	 * @return the trung tam hanh chinh that was updated
	 */
	public static org.oep.core.model.TrungTamHanhChinh updateTrungTamHanhChinh(
		org.oep.core.model.TrungTamHanhChinh trungTamHanhChinh) {

		return getService().updateTrungTamHanhChinh(trungTamHanhChinh);
	}

	public static TrungTamHanhChinhLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<TrungTamHanhChinhLocalService, TrungTamHanhChinhLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			TrungTamHanhChinhLocalService.class);

		ServiceTracker
			<TrungTamHanhChinhLocalService, TrungTamHanhChinhLocalService>
				serviceTracker =
					new ServiceTracker
						<TrungTamHanhChinhLocalService,
						 TrungTamHanhChinhLocalService>(
							 bundle.getBundleContext(),
							 TrungTamHanhChinhLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}