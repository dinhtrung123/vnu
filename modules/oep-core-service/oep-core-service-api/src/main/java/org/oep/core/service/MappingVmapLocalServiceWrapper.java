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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MappingVmapLocalService}.
 *
 * @author manhlb
 * @see MappingVmapLocalService
 * @generated
 */
@ProviderType
public class MappingVmapLocalServiceWrapper
	implements MappingVmapLocalService,
			   ServiceWrapper<MappingVmapLocalService> {

	public MappingVmapLocalServiceWrapper(
		MappingVmapLocalService mappingVmapLocalService) {

		_mappingVmapLocalService = mappingVmapLocalService;
	}

	@Override
	public org.oep.core.model.MappingVmap addMapping(
		String classname, long classpk, String latitude, String longitude,
		String ghichu) {

		return _mappingVmapLocalService.addMapping(
			classname, classpk, latitude, longitude, ghichu);
	}

	/**
	 * Adds the mapping vmap to the database. Also notifies the appropriate model listeners.
	 *
	 * @param mappingVmap the mapping vmap
	 * @return the mapping vmap that was added
	 */
	@Override
	public org.oep.core.model.MappingVmap addMappingVmap(
		org.oep.core.model.MappingVmap mappingVmap) {

		return _mappingVmapLocalService.addMappingVmap(mappingVmap);
	}

	/**
	 * Creates a new mapping vmap with the primary key. Does not add the mapping vmap to the database.
	 *
	 * @param id the primary key for the new mapping vmap
	 * @return the new mapping vmap
	 */
	@Override
	public org.oep.core.model.MappingVmap createMappingVmap(long id) {
		return _mappingVmapLocalService.createMappingVmap(id);
	}

	/**
	 * Deletes the mapping vmap with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the mapping vmap
	 * @return the mapping vmap that was removed
	 * @throws PortalException if a mapping vmap with the primary key could not be found
	 */
	@Override
	public org.oep.core.model.MappingVmap deleteMappingVmap(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mappingVmapLocalService.deleteMappingVmap(id);
	}

	/**
	 * Deletes the mapping vmap from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mappingVmap the mapping vmap
	 * @return the mapping vmap that was removed
	 */
	@Override
	public org.oep.core.model.MappingVmap deleteMappingVmap(
		org.oep.core.model.MappingVmap mappingVmap) {

		return _mappingVmapLocalService.deleteMappingVmap(mappingVmap);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mappingVmapLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _mappingVmapLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _mappingVmapLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _mappingVmapLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _mappingVmapLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _mappingVmapLocalService.dynamicQueryCount(dynamicQuery);
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
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _mappingVmapLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public org.oep.core.model.MappingVmap fetchMappingVmap(long id) {
		return _mappingVmapLocalService.fetchMappingVmap(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _mappingVmapLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _mappingVmapLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the mapping vmap with the primary key.
	 *
	 * @param id the primary key of the mapping vmap
	 * @return the mapping vmap
	 * @throws PortalException if a mapping vmap with the primary key could not be found
	 */
	@Override
	public org.oep.core.model.MappingVmap getMappingVmap(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mappingVmapLocalService.getMappingVmap(id);
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
	@Override
	public java.util.List<org.oep.core.model.MappingVmap> getMappingVmaps(
		int start, int end) {

		return _mappingVmapLocalService.getMappingVmaps(start, end);
	}

	/**
	 * Returns the number of mapping vmaps.
	 *
	 * @return the number of mapping vmaps
	 */
	@Override
	public int getMappingVmapsCount() {
		return _mappingVmapLocalService.getMappingVmapsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _mappingVmapLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mappingVmapLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public org.oep.core.model.MappingVmap getToaDo(
		String classname, long classpk) {

		return _mappingVmapLocalService.getToaDo(classname, classpk);
	}

	@Override
	public org.oep.core.model.MappingVmap getToaDoByClassPK(long classpk) {
		return _mappingVmapLocalService.getToaDoByClassPK(classpk);
	}

	/**
	 * Updates the mapping vmap in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param mappingVmap the mapping vmap
	 * @return the mapping vmap that was updated
	 */
	@Override
	public org.oep.core.model.MappingVmap updateMappingVmap(
		org.oep.core.model.MappingVmap mappingVmap) {

		return _mappingVmapLocalService.updateMappingVmap(mappingVmap);
	}

	@Override
	public org.oep.core.model.MappingVmap updateToaDo(
		String classname, long classpk, String latitude, String longitude,
		String ghichu) {

		return _mappingVmapLocalService.updateToaDo(
			classname, classpk, latitude, longitude, ghichu);
	}

	@Override
	public MappingVmapLocalService getWrappedService() {
		return _mappingVmapLocalService;
	}

	@Override
	public void setWrappedService(
		MappingVmapLocalService mappingVmapLocalService) {

		_mappingVmapLocalService = mappingVmapLocalService;
	}

	private MappingVmapLocalService _mappingVmapLocalService;

}