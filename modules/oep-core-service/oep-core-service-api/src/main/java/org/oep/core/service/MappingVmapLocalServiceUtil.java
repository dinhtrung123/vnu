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
 * Provides the local service utility for MappingVmap. This utility wraps
 * <code>org.oep.core.service.impl.MappingVmapLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author manhlb
 * @see MappingVmapLocalService
 * @generated
 */
@ProviderType
public class MappingVmapLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>org.oep.core.service.impl.MappingVmapLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static org.oep.core.model.MappingVmap addMapping(
		String classname, long classpk, String latitude, String longitude,
		String ghichu) {

		return getService().addMapping(
			classname, classpk, latitude, longitude, ghichu);
	}

	/**
	 * Adds the mapping vmap to the database. Also notifies the appropriate model listeners.
	 *
	 * @param mappingVmap the mapping vmap
	 * @return the mapping vmap that was added
	 */
	public static org.oep.core.model.MappingVmap addMappingVmap(
		org.oep.core.model.MappingVmap mappingVmap) {

		return getService().addMappingVmap(mappingVmap);
	}

	/**
	 * Creates a new mapping vmap with the primary key. Does not add the mapping vmap to the database.
	 *
	 * @param id the primary key for the new mapping vmap
	 * @return the new mapping vmap
	 */
	public static org.oep.core.model.MappingVmap createMappingVmap(long id) {
		return getService().createMappingVmap(id);
	}

	/**
	 * Deletes the mapping vmap with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the mapping vmap
	 * @return the mapping vmap that was removed
	 * @throws PortalException if a mapping vmap with the primary key could not be found
	 */
	public static org.oep.core.model.MappingVmap deleteMappingVmap(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteMappingVmap(id);
	}

	/**
	 * Deletes the mapping vmap from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mappingVmap the mapping vmap
	 * @return the mapping vmap that was removed
	 */
	public static org.oep.core.model.MappingVmap deleteMappingVmap(
		org.oep.core.model.MappingVmap mappingVmap) {

		return getService().deleteMappingVmap(mappingVmap);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>org.oep.core.model.impl.MappingVmapModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>org.oep.core.model.impl.MappingVmapModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static org.oep.core.model.MappingVmap fetchMappingVmap(long id) {
		return getService().fetchMappingVmap(id);
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
	 * Returns the mapping vmap with the primary key.
	 *
	 * @param id the primary key of the mapping vmap
	 * @return the mapping vmap
	 * @throws PortalException if a mapping vmap with the primary key could not be found
	 */
	public static org.oep.core.model.MappingVmap getMappingVmap(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getMappingVmap(id);
	}

	/**
	 * Returns a range of all the mapping vmaps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>org.oep.core.model.impl.MappingVmapModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of mapping vmaps
	 * @param end the upper bound of the range of mapping vmaps (not inclusive)
	 * @return the range of mapping vmaps
	 */
	public static java.util.List<org.oep.core.model.MappingVmap>
		getMappingVmaps(int start, int end) {

		return getService().getMappingVmaps(start, end);
	}

	/**
	 * Returns the number of mapping vmaps.
	 *
	 * @return the number of mapping vmaps
	 */
	public static int getMappingVmapsCount() {
		return getService().getMappingVmapsCount();
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

	public static org.oep.core.model.MappingVmap getToaDo(
		String classname, long classpk) {

		return getService().getToaDo(classname, classpk);
	}

	public static org.oep.core.model.MappingVmap getToaDoByClassPK(
		long classpk) {

		return getService().getToaDoByClassPK(classpk);
	}

	/**
	 * Updates the mapping vmap in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param mappingVmap the mapping vmap
	 * @return the mapping vmap that was updated
	 */
	public static org.oep.core.model.MappingVmap updateMappingVmap(
		org.oep.core.model.MappingVmap mappingVmap) {

		return getService().updateMappingVmap(mappingVmap);
	}

	public static org.oep.core.model.MappingVmap updateToaDo(
		String classname, long classpk, String latitude, String longitude,
		String ghichu) {

		return getService().updateToaDo(
			classname, classpk, latitude, longitude, ghichu);
	}

	public static MappingVmapLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<MappingVmapLocalService, MappingVmapLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(MappingVmapLocalService.class);

		ServiceTracker<MappingVmapLocalService, MappingVmapLocalService>
			serviceTracker =
				new ServiceTracker
					<MappingVmapLocalService, MappingVmapLocalService>(
						bundle.getBundleContext(),
						MappingVmapLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}