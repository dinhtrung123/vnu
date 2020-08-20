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

package dtt.vn.vnpost.service;

import aQute.bnd.annotation.ProviderType;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for DanhMuc. This utility wraps
 * <code>dtt.vn.vnpost.service.impl.DanhMucLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see DanhMucLocalService
 * @generated
 */
@ProviderType
public class DanhMucLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>dtt.vn.vnpost.service.impl.DanhMucLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the danh muc to the database. Also notifies the appropriate model listeners.
	 *
	 * @param danhMuc the danh muc
	 * @return the danh muc that was added
	 */
	public static dtt.vn.vnpost.model.DanhMuc addDanhMuc(
		dtt.vn.vnpost.model.DanhMuc danhMuc) {

		return getService().addDanhMuc(danhMuc);
	}

	/**
	 * Creates a new danh muc with the primary key. Does not add the danh muc to the database.
	 *
	 * @param id the primary key for the new danh muc
	 * @return the new danh muc
	 */
	public static dtt.vn.vnpost.model.DanhMuc createDanhMuc(long id) {
		return getService().createDanhMuc(id);
	}

	/**
	 * Deletes the danh muc from the database. Also notifies the appropriate model listeners.
	 *
	 * @param danhMuc the danh muc
	 * @return the danh muc that was removed
	 */
	public static dtt.vn.vnpost.model.DanhMuc deleteDanhMuc(
		dtt.vn.vnpost.model.DanhMuc danhMuc) {

		return getService().deleteDanhMuc(danhMuc);
	}

	/**
	 * Deletes the danh muc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the danh muc
	 * @return the danh muc that was removed
	 * @throws PortalException if a danh muc with the primary key could not be found
	 */
	public static dtt.vn.vnpost.model.DanhMuc deleteDanhMuc(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteDanhMuc(id);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>dtt.vn.vnpost.model.impl.DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>dtt.vn.vnpost.model.impl.DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static dtt.vn.vnpost.model.DanhMuc fetchDanhMuc(long id) {
		return getService().fetchDanhMuc(id);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * This is fucntion get All DanhMuc
	 *
	 * @param nhomId
	 :
	 * @param isActive
	 : if true : get Item have got status=1,if false : get All
	 * @return
	 */
	public static java.util.List<dtt.vn.vnpost.model.DanhMuc> getAll(
		long nhomId, boolean isActive) {

		return getService().getAll(nhomId, isActive);
	}

	public static java.util.List<dtt.vn.vnpost.model.DanhMuc> getAllByIds(
			long[] ids)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getAllByIds(ids);
	}

	public static java.util.List<dtt.vn.vnpost.model.DanhMuc> getAllByNhomId(
			long nhomId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getAllByNhomId(nhomId);
	}

	public static java.util.List<dtt.vn.vnpost.model.DanhMuc> getAllByNhomIdMuc(
			long nhomId, int muc)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getAllByNhomIdMuc(nhomId, muc);
	}

	public static java.util.List<dtt.vn.vnpost.model.DanhMuc> getByIds(
			long[] ids)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getByIds(ids);
	}

	public static dtt.vn.vnpost.model.DanhMuc getByM(String ma)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getByM(ma);
	}

	public static java.util.List<dtt.vn.vnpost.model.DanhMuc> getByMUC(int muc)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getByMUC(muc);
	}

	public static java.util.List<dtt.vn.vnpost.model.DanhMuc> getByP(long chaId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getByP(chaId);
	}

	public static dtt.vn.vnpost.model.DanhMuc getByP_T(long chaId, String ten)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getByP_T(chaId, ten);
	}

	public static dtt.vn.vnpost.model.DanhMuc getByT(String ten)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getByT(ten);
	}

	public static dtt.vn.vnpost.model.DanhMuc getByTT(int thuTuHienThi)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getByTT(thuTuHienThi);
	}

	/**
	 * Returns the danh muc with the primary key.
	 *
	 * @param id the primary key of the danh muc
	 * @return the danh muc
	 * @throws PortalException if a danh muc with the primary key could not be found
	 */
	public static dtt.vn.vnpost.model.DanhMuc getDanhMuc(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getDanhMuc(id);
	}

	public static java.util.List<dtt.vn.vnpost.model.DanhMuc>
			getDanhMuc_By_ChaId(long chaId, boolean isActive)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getDanhMuc_By_ChaId(chaId, isActive);
	}

	public static dtt.vn.vnpost.model.DanhMuc getDanhMuc_By_Ma(
		String ma, boolean isActive) {

		return getService().getDanhMuc_By_Ma(ma, isActive);
	}

	public static java.util.List<dtt.vn.vnpost.model.DanhMuc>
			getDanhMuc_By_Ma_Muc(String ma, int muc)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getDanhMuc_By_Ma_Muc(ma, muc);
	}

	public static java.util.List<dtt.vn.vnpost.model.DanhMuc> getDanhMuc_By_Muc(
		long chaId, int level, boolean isActive) {

		return getService().getDanhMuc_By_Muc(chaId, level, isActive);
	}

	public static java.util.List<dtt.vn.vnpost.model.DanhMuc>
			getDanhMuc_By_Nhom_Muc(String maNhom, int level, boolean isActive)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getDanhMuc_By_Nhom_Muc(maNhom, level, isActive);
	}

	public static dtt.vn.vnpost.model.DanhMuc getDanhMuc_By_Nhom_Muc_Ma(
			String maNhom, int level, String ma, boolean isActive)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getDanhMuc_By_Nhom_Muc_Ma(
			maNhom, level, ma, isActive);
	}

	public static dtt.vn.vnpost.model.DanhMuc getDanhMuc_By_Nhom_Muc_Ten(
			String maNhom, int level, String ten, boolean isActive)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getDanhMuc_By_Nhom_Muc_Ten(
			maNhom, level, ten, isActive);
	}

	public static dtt.vn.vnpost.model.DanhMuc getDanhMuc_Con_CuoiCung(
			long chaId, com.liferay.portal.kernel.util.OrderByComparator asc)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getDanhMuc_Con_CuoiCung(chaId, asc);
	}

	public static dtt.vn.vnpost.model.DanhMuc getDanhMucByNhomIdMa(
			long nhomId, String ma)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getDanhMucByNhomIdMa(nhomId, ma);
	}

	/**
	 * Returns a range of all the danh mucs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>dtt.vn.vnpost.model.impl.DanhMucModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of danh mucs
	 * @param end the upper bound of the range of danh mucs (not inclusive)
	 * @return the range of danh mucs
	 */
	public static java.util.List<dtt.vn.vnpost.model.DanhMuc> getDanhMucs(
		int start, int end) {

		return getService().getDanhMucs(start, end);
	}

	/**
	 * Returns the number of danh mucs.
	 *
	 * @return the number of danh mucs
	 */
	public static int getDanhMucsCount() {
		return getService().getDanhMucsCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	public static dtt.vn.vnpost.model.DanhMuc getNextItem(
			long chaId, dtt.vn.vnpost.model.DanhMuc item)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getNextItem(chaId, item);
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

	public static dtt.vn.vnpost.model.DanhMuc suaDanhMuc(
			long danhMucId, long nhomId, String ma, String name, String moTa,
			boolean trangThai, int thuTuHienThi)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return getService().suaDanhMuc(
			danhMucId, nhomId, ma, name, moTa, trangThai, thuTuHienThi);
	}

	public static dtt.vn.vnpost.model.DanhMuc themMoiDanhMuc(
			long nhomId, long chaId, String ma, String maGiaPha, String ten,
			String moTa, boolean trangThai, int muc, int thuTuHienThi)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return getService().themMoiDanhMuc(
			nhomId, chaId, ma, maGiaPha, ten, moTa, trangThai, muc,
			thuTuHienThi);
	}

	/**
	 * Updates the danh muc in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param danhMuc the danh muc
	 * @return the danh muc that was updated
	 */
	public static dtt.vn.vnpost.model.DanhMuc updateDanhMuc(
		dtt.vn.vnpost.model.DanhMuc danhMuc) {

		return getService().updateDanhMuc(danhMuc);
	}

	public static dtt.vn.vnpost.model.DanhMuc xoaDanhMuc(long danhMucId) {
		return getService().xoaDanhMuc(danhMucId);
	}

	public static DanhMucLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<DanhMucLocalService, DanhMucLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(DanhMucLocalService.class);

		ServiceTracker<DanhMucLocalService, DanhMucLocalService>
			serviceTracker =
				new ServiceTracker<DanhMucLocalService, DanhMucLocalService>(
					bundle.getBundleContext(), DanhMucLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}