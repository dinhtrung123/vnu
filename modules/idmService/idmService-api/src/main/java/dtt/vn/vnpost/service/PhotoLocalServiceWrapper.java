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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PhotoLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PhotoLocalService
 * @generated
 */
@ProviderType
public class PhotoLocalServiceWrapper
	implements PhotoLocalService, ServiceWrapper<PhotoLocalService> {

	public PhotoLocalServiceWrapper(PhotoLocalService photoLocalService) {
		_photoLocalService = photoLocalService;
	}

	/**
	 * Adds the photo to the database. Also notifies the appropriate model listeners.
	 *
	 * @param photo the photo
	 * @return the photo that was added
	 */
	@Override
	public dtt.vn.vnpost.model.Photo addPhoto(dtt.vn.vnpost.model.Photo photo) {
		return _photoLocalService.addPhoto(photo);
	}

	@Override
	public dtt.vn.vnpost.model.Photo addPhoto(
			dtt.vn.vnpost.model.Photo photo, long accountId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _photoLocalService.addPhoto(photo, accountId);
	}

	@Override
	public void approve(long imageId) {
		_photoLocalService.approve(imageId);
	}

	/**
	 * Creates a new photo with the primary key. Does not add the photo to the database.
	 *
	 * @param imageId the primary key for the new photo
	 * @return the new photo
	 */
	@Override
	public dtt.vn.vnpost.model.Photo createPhoto(long imageId) {
		return _photoLocalService.createPhoto(imageId);
	}

	@Override
	public long createThumbnail(long imageId)
		throws com.liferay.portal.kernel.exception.ImageResolutionException {

		return _photoLocalService.createThumbnail(imageId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _photoLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the photo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param imageId the primary key of the photo
	 * @return the photo that was removed
	 * @throws PortalException if a photo with the primary key could not be found
	 */
	@Override
	public dtt.vn.vnpost.model.Photo deletePhoto(long imageId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _photoLocalService.deletePhoto(imageId);
	}

	/**
	 * Deletes the photo from the database. Also notifies the appropriate model listeners.
	 *
	 * @param photo the photo
	 * @return the photo that was removed
	 * @throws SystemException
	 */
	@Override
	public dtt.vn.vnpost.model.Photo deletePhoto(
			dtt.vn.vnpost.model.Photo photo)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _photoLocalService.deletePhoto(photo);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _photoLocalService.dynamicQuery();
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

		return _photoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>dtt.vn.vnpost.model.impl.PhotoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _photoLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>dtt.vn.vnpost.model.impl.PhotoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _photoLocalService.dynamicQuery(
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

		return _photoLocalService.dynamicQueryCount(dynamicQuery);
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

		return _photoLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public dtt.vn.vnpost.model.Photo fetchPhoto(long imageId) {
		return _photoLocalService.fetchPhoto(imageId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _photoLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _photoLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _photoLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _photoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the photo with the primary key.
	 *
	 * @param imageId the primary key of the photo
	 * @return the photo
	 * @throws PortalException if a photo with the primary key could not be found
	 */
	@Override
	public dtt.vn.vnpost.model.Photo getPhoto(long imageId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _photoLocalService.getPhoto(imageId);
	}

	@Override
	public java.util.List<dtt.vn.vnpost.model.Photo> getPhotobyClassName(
		String className) {

		return _photoLocalService.getPhotobyClassName(className);
	}

	@Override
	public java.util.List<dtt.vn.vnpost.model.Photo> getPhotoByClassPK(
		String classPK) {

		return _photoLocalService.getPhotoByClassPK(classPK);
	}

	/**
	 * Returns a range of all the photos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>dtt.vn.vnpost.model.impl.PhotoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of photos
	 * @param end the upper bound of the range of photos (not inclusive)
	 * @return the range of photos
	 */
	@Override
	public java.util.List<dtt.vn.vnpost.model.Photo> getPhotos(
		int start, int end) {

		return _photoLocalService.getPhotos(start, end);
	}

	@Override
	public java.util.List<dtt.vn.vnpost.model.Photo> getPhotos(long accpuntId) {
		return _photoLocalService.getPhotos(accpuntId);
	}

	@Override
	public java.util.List<dtt.vn.vnpost.model.Photo> getPhotos(
		long profileId, String className) {

		return _photoLocalService.getPhotos(profileId, className);
	}

	@Override
	public java.util.List<dtt.vn.vnpost.model.Photo>
		getPhotosbyClassname_classPK(String classname, long classpk) {

		return _photoLocalService.getPhotosbyClassname_classPK(
			classname, classpk);
	}

	@Override
	public java.util.List<dtt.vn.vnpost.model.Photo>
		getPhotosbyImageType_classPK(
			int imagetype, long classpk, int start, int end) {

		return _photoLocalService.getPhotosbyImageType_classPK(
			imagetype, classpk, start, end);
	}

	/**
	 * Returns the number of photos.
	 *
	 * @return the number of photos
	 */
	@Override
	public int getPhotosCount() {
		return _photoLocalService.getPhotosCount();
	}

	/**
	 * Updates the photo in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param photo the photo
	 * @return the photo that was updated
	 */
	@Override
	public dtt.vn.vnpost.model.Photo updatePhoto(
		dtt.vn.vnpost.model.Photo photo) {

		return _photoLocalService.updatePhoto(photo);
	}

	@Override
	public dtt.vn.vnpost.model.Photo upload(
			long imageId, long accountId, java.io.File file, String className,
			String description, String message)
		throws com.liferay.portal.kernel.exception.ImageResolutionException {

		return _photoLocalService.upload(
			imageId, accountId, file, className, description, message);
	}

	@Override
	public PhotoLocalService getWrappedService() {
		return _photoLocalService;
	}

	@Override
	public void setWrappedService(PhotoLocalService photoLocalService) {
		_photoLocalService = photoLocalService;
	}

	private PhotoLocalService _photoLocalService;

}