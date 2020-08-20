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
 * Provides the local service utility for Photo. This utility wraps
 * <code>dtt.vn.vnpost.service.impl.PhotoLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see PhotoLocalService
 * @generated
 */
@ProviderType
public class PhotoLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>dtt.vn.vnpost.service.impl.PhotoLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the photo to the database. Also notifies the appropriate model listeners.
	 *
	 * @param photo the photo
	 * @return the photo that was added
	 */
	public static dtt.vn.vnpost.model.Photo addPhoto(
		dtt.vn.vnpost.model.Photo photo) {

		return getService().addPhoto(photo);
	}

	public static dtt.vn.vnpost.model.Photo addPhoto(
			dtt.vn.vnpost.model.Photo photo, long accountId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().addPhoto(photo, accountId);
	}

	public static void approve(long imageId) {
		getService().approve(imageId);
	}

	/**
	 * Creates a new photo with the primary key. Does not add the photo to the database.
	 *
	 * @param imageId the primary key for the new photo
	 * @return the new photo
	 */
	public static dtt.vn.vnpost.model.Photo createPhoto(long imageId) {
		return getService().createPhoto(imageId);
	}

	public static long createThumbnail(long imageId)
		throws com.liferay.portal.kernel.exception.ImageResolutionException {

		return getService().createThumbnail(imageId);
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
	 * Deletes the photo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param imageId the primary key of the photo
	 * @return the photo that was removed
	 * @throws PortalException if a photo with the primary key could not be found
	 */
	public static dtt.vn.vnpost.model.Photo deletePhoto(long imageId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePhoto(imageId);
	}

	/**
	 * Deletes the photo from the database. Also notifies the appropriate model listeners.
	 *
	 * @param photo the photo
	 * @return the photo that was removed
	 * @throws SystemException
	 */
	public static dtt.vn.vnpost.model.Photo deletePhoto(
			dtt.vn.vnpost.model.Photo photo)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().deletePhoto(photo);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>dtt.vn.vnpost.model.impl.PhotoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>dtt.vn.vnpost.model.impl.PhotoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static dtt.vn.vnpost.model.Photo fetchPhoto(long imageId) {
		return getService().fetchPhoto(imageId);
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
	 * Returns the photo with the primary key.
	 *
	 * @param imageId the primary key of the photo
	 * @return the photo
	 * @throws PortalException if a photo with the primary key could not be found
	 */
	public static dtt.vn.vnpost.model.Photo getPhoto(long imageId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPhoto(imageId);
	}

	public static java.util.List<dtt.vn.vnpost.model.Photo> getPhotobyClassName(
		String className) {

		return getService().getPhotobyClassName(className);
	}

	public static java.util.List<dtt.vn.vnpost.model.Photo> getPhotoByClassPK(
		String classPK) {

		return getService().getPhotoByClassPK(classPK);
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
	public static java.util.List<dtt.vn.vnpost.model.Photo> getPhotos(
		int start, int end) {

		return getService().getPhotos(start, end);
	}

	public static java.util.List<dtt.vn.vnpost.model.Photo> getPhotos(
		long accpuntId) {

		return getService().getPhotos(accpuntId);
	}

	public static java.util.List<dtt.vn.vnpost.model.Photo> getPhotos(
		long profileId, String className) {

		return getService().getPhotos(profileId, className);
	}

	public static java.util.List<dtt.vn.vnpost.model.Photo>
		getPhotosbyClassname_classPK(String classname, long classpk) {

		return getService().getPhotosbyClassname_classPK(classname, classpk);
	}

	public static java.util.List<dtt.vn.vnpost.model.Photo>
		getPhotosbyImageType_classPK(
			int imagetype, long classpk, int start, int end) {

		return getService().getPhotosbyImageType_classPK(
			imagetype, classpk, start, end);
	}

	/**
	 * Returns the number of photos.
	 *
	 * @return the number of photos
	 */
	public static int getPhotosCount() {
		return getService().getPhotosCount();
	}

	/**
	 * Updates the photo in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param photo the photo
	 * @return the photo that was updated
	 */
	public static dtt.vn.vnpost.model.Photo updatePhoto(
		dtt.vn.vnpost.model.Photo photo) {

		return getService().updatePhoto(photo);
	}

	public static dtt.vn.vnpost.model.Photo upload(
			long imageId, long accountId, java.io.File file, String className,
			String description, String message)
		throws com.liferay.portal.kernel.exception.ImageResolutionException {

		return getService().upload(
			imageId, accountId, file, className, description, message);
	}

	public static PhotoLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PhotoLocalService, PhotoLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PhotoLocalService.class);

		ServiceTracker<PhotoLocalService, PhotoLocalService> serviceTracker =
			new ServiceTracker<PhotoLocalService, PhotoLocalService>(
				bundle.getBundleContext(), PhotoLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}