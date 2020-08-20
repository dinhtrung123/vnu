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

package dtt.vn.vnpost.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import dtt.vn.vnpost.model.Photo;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the photo service. This utility wraps <code>dtt.vn.vnpost.service.persistence.impl.PhotoPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PhotoPersistence
 * @generated
 */
@ProviderType
public class PhotoUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Photo photo) {
		getPersistence().clearCache(photo);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Photo> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Photo> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Photo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Photo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Photo> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Photo update(Photo photo) {
		return getPersistence().update(photo);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Photo update(Photo photo, ServiceContext serviceContext) {
		return getPersistence().update(photo, serviceContext);
	}

	/**
	 * Returns all the photos where className = &#63; and classPK = &#63; and imageType = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @param imageType the image type
	 * @return the matching photos
	 */
	public static List<Photo> findByClassNameClassPKImageType(
		String className, long classPK, int imageType) {

		return getPersistence().findByClassNameClassPKImageType(
			className, classPK, imageType);
	}

	/**
	 * Returns a range of all the photos where className = &#63; and classPK = &#63; and imageType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PhotoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @param imageType the image type
	 * @param start the lower bound of the range of photos
	 * @param end the upper bound of the range of photos (not inclusive)
	 * @return the range of matching photos
	 */
	public static List<Photo> findByClassNameClassPKImageType(
		String className, long classPK, int imageType, int start, int end) {

		return getPersistence().findByClassNameClassPKImageType(
			className, classPK, imageType, start, end);
	}

	/**
	 * Returns an ordered range of all the photos where className = &#63; and classPK = &#63; and imageType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PhotoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @param imageType the image type
	 * @param start the lower bound of the range of photos
	 * @param end the upper bound of the range of photos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching photos
	 */
	public static List<Photo> findByClassNameClassPKImageType(
		String className, long classPK, int imageType, int start, int end,
		OrderByComparator<Photo> orderByComparator) {

		return getPersistence().findByClassNameClassPKImageType(
			className, classPK, imageType, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the photos where className = &#63; and classPK = &#63; and imageType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PhotoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @param imageType the image type
	 * @param start the lower bound of the range of photos
	 * @param end the upper bound of the range of photos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching photos
	 */
	public static List<Photo> findByClassNameClassPKImageType(
		String className, long classPK, int imageType, int start, int end,
		OrderByComparator<Photo> orderByComparator, boolean retrieveFromCache) {

		return getPersistence().findByClassNameClassPKImageType(
			className, classPK, imageType, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	 * Returns the first photo in the ordered set where className = &#63; and classPK = &#63; and imageType = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @param imageType the image type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching photo
	 * @throws NoSuchPhotoException if a matching photo could not be found
	 */
	public static Photo findByClassNameClassPKImageType_First(
			String className, long classPK, int imageType,
			OrderByComparator<Photo> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchPhotoException {

		return getPersistence().findByClassNameClassPKImageType_First(
			className, classPK, imageType, orderByComparator);
	}

	/**
	 * Returns the first photo in the ordered set where className = &#63; and classPK = &#63; and imageType = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @param imageType the image type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching photo, or <code>null</code> if a matching photo could not be found
	 */
	public static Photo fetchByClassNameClassPKImageType_First(
		String className, long classPK, int imageType,
		OrderByComparator<Photo> orderByComparator) {

		return getPersistence().fetchByClassNameClassPKImageType_First(
			className, classPK, imageType, orderByComparator);
	}

	/**
	 * Returns the last photo in the ordered set where className = &#63; and classPK = &#63; and imageType = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @param imageType the image type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching photo
	 * @throws NoSuchPhotoException if a matching photo could not be found
	 */
	public static Photo findByClassNameClassPKImageType_Last(
			String className, long classPK, int imageType,
			OrderByComparator<Photo> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchPhotoException {

		return getPersistence().findByClassNameClassPKImageType_Last(
			className, classPK, imageType, orderByComparator);
	}

	/**
	 * Returns the last photo in the ordered set where className = &#63; and classPK = &#63; and imageType = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @param imageType the image type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching photo, or <code>null</code> if a matching photo could not be found
	 */
	public static Photo fetchByClassNameClassPKImageType_Last(
		String className, long classPK, int imageType,
		OrderByComparator<Photo> orderByComparator) {

		return getPersistence().fetchByClassNameClassPKImageType_Last(
			className, classPK, imageType, orderByComparator);
	}

	/**
	 * Returns the photos before and after the current photo in the ordered set where className = &#63; and classPK = &#63; and imageType = &#63;.
	 *
	 * @param imageId the primary key of the current photo
	 * @param className the class name
	 * @param classPK the class pk
	 * @param imageType the image type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next photo
	 * @throws NoSuchPhotoException if a photo with the primary key could not be found
	 */
	public static Photo[] findByClassNameClassPKImageType_PrevAndNext(
			long imageId, String className, long classPK, int imageType,
			OrderByComparator<Photo> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchPhotoException {

		return getPersistence().findByClassNameClassPKImageType_PrevAndNext(
			imageId, className, classPK, imageType, orderByComparator);
	}

	/**
	 * Removes all the photos where className = &#63; and classPK = &#63; and imageType = &#63; from the database.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @param imageType the image type
	 */
	public static void removeByClassNameClassPKImageType(
		String className, long classPK, int imageType) {

		getPersistence().removeByClassNameClassPKImageType(
			className, classPK, imageType);
	}

	/**
	 * Returns the number of photos where className = &#63; and classPK = &#63; and imageType = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @param imageType the image type
	 * @return the number of matching photos
	 */
	public static int countByClassNameClassPKImageType(
		String className, long classPK, int imageType) {

		return getPersistence().countByClassNameClassPKImageType(
			className, classPK, imageType);
	}

	/**
	 * Returns all the photos where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @return the matching photos
	 */
	public static List<Photo> findByClassNameClassPK(
		String className, long classPK) {

		return getPersistence().findByClassNameClassPK(className, classPK);
	}

	/**
	 * Returns a range of all the photos where className = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PhotoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @param start the lower bound of the range of photos
	 * @param end the upper bound of the range of photos (not inclusive)
	 * @return the range of matching photos
	 */
	public static List<Photo> findByClassNameClassPK(
		String className, long classPK, int start, int end) {

		return getPersistence().findByClassNameClassPK(
			className, classPK, start, end);
	}

	/**
	 * Returns an ordered range of all the photos where className = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PhotoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @param start the lower bound of the range of photos
	 * @param end the upper bound of the range of photos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching photos
	 */
	public static List<Photo> findByClassNameClassPK(
		String className, long classPK, int start, int end,
		OrderByComparator<Photo> orderByComparator) {

		return getPersistence().findByClassNameClassPK(
			className, classPK, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the photos where className = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PhotoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @param start the lower bound of the range of photos
	 * @param end the upper bound of the range of photos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching photos
	 */
	public static List<Photo> findByClassNameClassPK(
		String className, long classPK, int start, int end,
		OrderByComparator<Photo> orderByComparator, boolean retrieveFromCache) {

		return getPersistence().findByClassNameClassPK(
			className, classPK, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	 * Returns the first photo in the ordered set where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching photo
	 * @throws NoSuchPhotoException if a matching photo could not be found
	 */
	public static Photo findByClassNameClassPK_First(
			String className, long classPK,
			OrderByComparator<Photo> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchPhotoException {

		return getPersistence().findByClassNameClassPK_First(
			className, classPK, orderByComparator);
	}

	/**
	 * Returns the first photo in the ordered set where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching photo, or <code>null</code> if a matching photo could not be found
	 */
	public static Photo fetchByClassNameClassPK_First(
		String className, long classPK,
		OrderByComparator<Photo> orderByComparator) {

		return getPersistence().fetchByClassNameClassPK_First(
			className, classPK, orderByComparator);
	}

	/**
	 * Returns the last photo in the ordered set where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching photo
	 * @throws NoSuchPhotoException if a matching photo could not be found
	 */
	public static Photo findByClassNameClassPK_Last(
			String className, long classPK,
			OrderByComparator<Photo> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchPhotoException {

		return getPersistence().findByClassNameClassPK_Last(
			className, classPK, orderByComparator);
	}

	/**
	 * Returns the last photo in the ordered set where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching photo, or <code>null</code> if a matching photo could not be found
	 */
	public static Photo fetchByClassNameClassPK_Last(
		String className, long classPK,
		OrderByComparator<Photo> orderByComparator) {

		return getPersistence().fetchByClassNameClassPK_Last(
			className, classPK, orderByComparator);
	}

	/**
	 * Returns the photos before and after the current photo in the ordered set where className = &#63; and classPK = &#63;.
	 *
	 * @param imageId the primary key of the current photo
	 * @param className the class name
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next photo
	 * @throws NoSuchPhotoException if a photo with the primary key could not be found
	 */
	public static Photo[] findByClassNameClassPK_PrevAndNext(
			long imageId, String className, long classPK,
			OrderByComparator<Photo> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchPhotoException {

		return getPersistence().findByClassNameClassPK_PrevAndNext(
			imageId, className, classPK, orderByComparator);
	}

	/**
	 * Removes all the photos where className = &#63; and classPK = &#63; from the database.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 */
	public static void removeByClassNameClassPK(
		String className, long classPK) {

		getPersistence().removeByClassNameClassPK(className, classPK);
	}

	/**
	 * Returns the number of photos where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @return the number of matching photos
	 */
	public static int countByClassNameClassPK(String className, long classPK) {
		return getPersistence().countByClassNameClassPK(className, classPK);
	}

	/**
	 * Returns all the photos where className = &#63;.
	 *
	 * @param className the class name
	 * @return the matching photos
	 */
	public static List<Photo> findByClassName(String className) {
		return getPersistence().findByClassName(className);
	}

	/**
	 * Returns a range of all the photos where className = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PhotoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param className the class name
	 * @param start the lower bound of the range of photos
	 * @param end the upper bound of the range of photos (not inclusive)
	 * @return the range of matching photos
	 */
	public static List<Photo> findByClassName(
		String className, int start, int end) {

		return getPersistence().findByClassName(className, start, end);
	}

	/**
	 * Returns an ordered range of all the photos where className = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PhotoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param className the class name
	 * @param start the lower bound of the range of photos
	 * @param end the upper bound of the range of photos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching photos
	 */
	public static List<Photo> findByClassName(
		String className, int start, int end,
		OrderByComparator<Photo> orderByComparator) {

		return getPersistence().findByClassName(
			className, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the photos where className = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PhotoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param className the class name
	 * @param start the lower bound of the range of photos
	 * @param end the upper bound of the range of photos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching photos
	 */
	public static List<Photo> findByClassName(
		String className, int start, int end,
		OrderByComparator<Photo> orderByComparator, boolean retrieveFromCache) {

		return getPersistence().findByClassName(
			className, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first photo in the ordered set where className = &#63;.
	 *
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching photo
	 * @throws NoSuchPhotoException if a matching photo could not be found
	 */
	public static Photo findByClassName_First(
			String className, OrderByComparator<Photo> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchPhotoException {

		return getPersistence().findByClassName_First(
			className, orderByComparator);
	}

	/**
	 * Returns the first photo in the ordered set where className = &#63;.
	 *
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching photo, or <code>null</code> if a matching photo could not be found
	 */
	public static Photo fetchByClassName_First(
		String className, OrderByComparator<Photo> orderByComparator) {

		return getPersistence().fetchByClassName_First(
			className, orderByComparator);
	}

	/**
	 * Returns the last photo in the ordered set where className = &#63;.
	 *
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching photo
	 * @throws NoSuchPhotoException if a matching photo could not be found
	 */
	public static Photo findByClassName_Last(
			String className, OrderByComparator<Photo> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchPhotoException {

		return getPersistence().findByClassName_Last(
			className, orderByComparator);
	}

	/**
	 * Returns the last photo in the ordered set where className = &#63;.
	 *
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching photo, or <code>null</code> if a matching photo could not be found
	 */
	public static Photo fetchByClassName_Last(
		String className, OrderByComparator<Photo> orderByComparator) {

		return getPersistence().fetchByClassName_Last(
			className, orderByComparator);
	}

	/**
	 * Returns the photos before and after the current photo in the ordered set where className = &#63;.
	 *
	 * @param imageId the primary key of the current photo
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next photo
	 * @throws NoSuchPhotoException if a photo with the primary key could not be found
	 */
	public static Photo[] findByClassName_PrevAndNext(
			long imageId, String className,
			OrderByComparator<Photo> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchPhotoException {

		return getPersistence().findByClassName_PrevAndNext(
			imageId, className, orderByComparator);
	}

	/**
	 * Removes all the photos where className = &#63; from the database.
	 *
	 * @param className the class name
	 */
	public static void removeByClassName(String className) {
		getPersistence().removeByClassName(className);
	}

	/**
	 * Returns the number of photos where className = &#63;.
	 *
	 * @param className the class name
	 * @return the number of matching photos
	 */
	public static int countByClassName(String className) {
		return getPersistence().countByClassName(className);
	}

	/**
	 * Returns all the photos where classPK = &#63;.
	 *
	 * @param classPK the class pk
	 * @return the matching photos
	 */
	public static List<Photo> findByClassPK(long classPK) {
		return getPersistence().findByClassPK(classPK);
	}

	/**
	 * Returns a range of all the photos where classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PhotoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param classPK the class pk
	 * @param start the lower bound of the range of photos
	 * @param end the upper bound of the range of photos (not inclusive)
	 * @return the range of matching photos
	 */
	public static List<Photo> findByClassPK(long classPK, int start, int end) {
		return getPersistence().findByClassPK(classPK, start, end);
	}

	/**
	 * Returns an ordered range of all the photos where classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PhotoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param classPK the class pk
	 * @param start the lower bound of the range of photos
	 * @param end the upper bound of the range of photos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching photos
	 */
	public static List<Photo> findByClassPK(
		long classPK, int start, int end,
		OrderByComparator<Photo> orderByComparator) {

		return getPersistence().findByClassPK(
			classPK, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the photos where classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PhotoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param classPK the class pk
	 * @param start the lower bound of the range of photos
	 * @param end the upper bound of the range of photos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching photos
	 */
	public static List<Photo> findByClassPK(
		long classPK, int start, int end,
		OrderByComparator<Photo> orderByComparator, boolean retrieveFromCache) {

		return getPersistence().findByClassPK(
			classPK, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first photo in the ordered set where classPK = &#63;.
	 *
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching photo
	 * @throws NoSuchPhotoException if a matching photo could not be found
	 */
	public static Photo findByClassPK_First(
			long classPK, OrderByComparator<Photo> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchPhotoException {

		return getPersistence().findByClassPK_First(classPK, orderByComparator);
	}

	/**
	 * Returns the first photo in the ordered set where classPK = &#63;.
	 *
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching photo, or <code>null</code> if a matching photo could not be found
	 */
	public static Photo fetchByClassPK_First(
		long classPK, OrderByComparator<Photo> orderByComparator) {

		return getPersistence().fetchByClassPK_First(
			classPK, orderByComparator);
	}

	/**
	 * Returns the last photo in the ordered set where classPK = &#63;.
	 *
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching photo
	 * @throws NoSuchPhotoException if a matching photo could not be found
	 */
	public static Photo findByClassPK_Last(
			long classPK, OrderByComparator<Photo> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchPhotoException {

		return getPersistence().findByClassPK_Last(classPK, orderByComparator);
	}

	/**
	 * Returns the last photo in the ordered set where classPK = &#63;.
	 *
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching photo, or <code>null</code> if a matching photo could not be found
	 */
	public static Photo fetchByClassPK_Last(
		long classPK, OrderByComparator<Photo> orderByComparator) {

		return getPersistence().fetchByClassPK_Last(classPK, orderByComparator);
	}

	/**
	 * Returns the photos before and after the current photo in the ordered set where classPK = &#63;.
	 *
	 * @param imageId the primary key of the current photo
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next photo
	 * @throws NoSuchPhotoException if a photo with the primary key could not be found
	 */
	public static Photo[] findByClassPK_PrevAndNext(
			long imageId, long classPK,
			OrderByComparator<Photo> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchPhotoException {

		return getPersistence().findByClassPK_PrevAndNext(
			imageId, classPK, orderByComparator);
	}

	/**
	 * Removes all the photos where classPK = &#63; from the database.
	 *
	 * @param classPK the class pk
	 */
	public static void removeByClassPK(long classPK) {
		getPersistence().removeByClassPK(classPK);
	}

	/**
	 * Returns the number of photos where classPK = &#63;.
	 *
	 * @param classPK the class pk
	 * @return the number of matching photos
	 */
	public static int countByClassPK(long classPK) {
		return getPersistence().countByClassPK(classPK);
	}

	/**
	 * Returns all the photos where imageType = &#63; and classPK = &#63;.
	 *
	 * @param imageType the image type
	 * @param classPK the class pk
	 * @return the matching photos
	 */
	public static List<Photo> findByImageTypeClassPK(
		int imageType, long classPK) {

		return getPersistence().findByImageTypeClassPK(imageType, classPK);
	}

	/**
	 * Returns a range of all the photos where imageType = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PhotoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param imageType the image type
	 * @param classPK the class pk
	 * @param start the lower bound of the range of photos
	 * @param end the upper bound of the range of photos (not inclusive)
	 * @return the range of matching photos
	 */
	public static List<Photo> findByImageTypeClassPK(
		int imageType, long classPK, int start, int end) {

		return getPersistence().findByImageTypeClassPK(
			imageType, classPK, start, end);
	}

	/**
	 * Returns an ordered range of all the photos where imageType = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PhotoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param imageType the image type
	 * @param classPK the class pk
	 * @param start the lower bound of the range of photos
	 * @param end the upper bound of the range of photos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching photos
	 */
	public static List<Photo> findByImageTypeClassPK(
		int imageType, long classPK, int start, int end,
		OrderByComparator<Photo> orderByComparator) {

		return getPersistence().findByImageTypeClassPK(
			imageType, classPK, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the photos where imageType = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PhotoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param imageType the image type
	 * @param classPK the class pk
	 * @param start the lower bound of the range of photos
	 * @param end the upper bound of the range of photos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching photos
	 */
	public static List<Photo> findByImageTypeClassPK(
		int imageType, long classPK, int start, int end,
		OrderByComparator<Photo> orderByComparator, boolean retrieveFromCache) {

		return getPersistence().findByImageTypeClassPK(
			imageType, classPK, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	 * Returns the first photo in the ordered set where imageType = &#63; and classPK = &#63;.
	 *
	 * @param imageType the image type
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching photo
	 * @throws NoSuchPhotoException if a matching photo could not be found
	 */
	public static Photo findByImageTypeClassPK_First(
			int imageType, long classPK,
			OrderByComparator<Photo> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchPhotoException {

		return getPersistence().findByImageTypeClassPK_First(
			imageType, classPK, orderByComparator);
	}

	/**
	 * Returns the first photo in the ordered set where imageType = &#63; and classPK = &#63;.
	 *
	 * @param imageType the image type
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching photo, or <code>null</code> if a matching photo could not be found
	 */
	public static Photo fetchByImageTypeClassPK_First(
		int imageType, long classPK,
		OrderByComparator<Photo> orderByComparator) {

		return getPersistence().fetchByImageTypeClassPK_First(
			imageType, classPK, orderByComparator);
	}

	/**
	 * Returns the last photo in the ordered set where imageType = &#63; and classPK = &#63;.
	 *
	 * @param imageType the image type
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching photo
	 * @throws NoSuchPhotoException if a matching photo could not be found
	 */
	public static Photo findByImageTypeClassPK_Last(
			int imageType, long classPK,
			OrderByComparator<Photo> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchPhotoException {

		return getPersistence().findByImageTypeClassPK_Last(
			imageType, classPK, orderByComparator);
	}

	/**
	 * Returns the last photo in the ordered set where imageType = &#63; and classPK = &#63;.
	 *
	 * @param imageType the image type
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching photo, or <code>null</code> if a matching photo could not be found
	 */
	public static Photo fetchByImageTypeClassPK_Last(
		int imageType, long classPK,
		OrderByComparator<Photo> orderByComparator) {

		return getPersistence().fetchByImageTypeClassPK_Last(
			imageType, classPK, orderByComparator);
	}

	/**
	 * Returns the photos before and after the current photo in the ordered set where imageType = &#63; and classPK = &#63;.
	 *
	 * @param imageId the primary key of the current photo
	 * @param imageType the image type
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next photo
	 * @throws NoSuchPhotoException if a photo with the primary key could not be found
	 */
	public static Photo[] findByImageTypeClassPK_PrevAndNext(
			long imageId, int imageType, long classPK,
			OrderByComparator<Photo> orderByComparator)
		throws dtt.vn.vnpost.exception.NoSuchPhotoException {

		return getPersistence().findByImageTypeClassPK_PrevAndNext(
			imageId, imageType, classPK, orderByComparator);
	}

	/**
	 * Removes all the photos where imageType = &#63; and classPK = &#63; from the database.
	 *
	 * @param imageType the image type
	 * @param classPK the class pk
	 */
	public static void removeByImageTypeClassPK(int imageType, long classPK) {
		getPersistence().removeByImageTypeClassPK(imageType, classPK);
	}

	/**
	 * Returns the number of photos where imageType = &#63; and classPK = &#63;.
	 *
	 * @param imageType the image type
	 * @param classPK the class pk
	 * @return the number of matching photos
	 */
	public static int countByImageTypeClassPK(int imageType, long classPK) {
		return getPersistence().countByImageTypeClassPK(imageType, classPK);
	}

	/**
	 * Caches the photo in the entity cache if it is enabled.
	 *
	 * @param photo the photo
	 */
	public static void cacheResult(Photo photo) {
		getPersistence().cacheResult(photo);
	}

	/**
	 * Caches the photos in the entity cache if it is enabled.
	 *
	 * @param photos the photos
	 */
	public static void cacheResult(List<Photo> photos) {
		getPersistence().cacheResult(photos);
	}

	/**
	 * Creates a new photo with the primary key. Does not add the photo to the database.
	 *
	 * @param imageId the primary key for the new photo
	 * @return the new photo
	 */
	public static Photo create(long imageId) {
		return getPersistence().create(imageId);
	}

	/**
	 * Removes the photo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param imageId the primary key of the photo
	 * @return the photo that was removed
	 * @throws NoSuchPhotoException if a photo with the primary key could not be found
	 */
	public static Photo remove(long imageId)
		throws dtt.vn.vnpost.exception.NoSuchPhotoException {

		return getPersistence().remove(imageId);
	}

	public static Photo updateImpl(Photo photo) {
		return getPersistence().updateImpl(photo);
	}

	/**
	 * Returns the photo with the primary key or throws a <code>NoSuchPhotoException</code> if it could not be found.
	 *
	 * @param imageId the primary key of the photo
	 * @return the photo
	 * @throws NoSuchPhotoException if a photo with the primary key could not be found
	 */
	public static Photo findByPrimaryKey(long imageId)
		throws dtt.vn.vnpost.exception.NoSuchPhotoException {

		return getPersistence().findByPrimaryKey(imageId);
	}

	/**
	 * Returns the photo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param imageId the primary key of the photo
	 * @return the photo, or <code>null</code> if a photo with the primary key could not be found
	 */
	public static Photo fetchByPrimaryKey(long imageId) {
		return getPersistence().fetchByPrimaryKey(imageId);
	}

	/**
	 * Returns all the photos.
	 *
	 * @return the photos
	 */
	public static List<Photo> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the photos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PhotoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of photos
	 * @param end the upper bound of the range of photos (not inclusive)
	 * @return the range of photos
	 */
	public static List<Photo> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the photos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PhotoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of photos
	 * @param end the upper bound of the range of photos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of photos
	 */
	public static List<Photo> findAll(
		int start, int end, OrderByComparator<Photo> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the photos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PhotoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of photos
	 * @param end the upper bound of the range of photos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of photos
	 */
	public static List<Photo> findAll(
		int start, int end, OrderByComparator<Photo> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the photos from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of photos.
	 *
	 * @return the number of photos
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PhotoPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PhotoPersistence, PhotoPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PhotoPersistence.class);

		ServiceTracker<PhotoPersistence, PhotoPersistence> serviceTracker =
			new ServiceTracker<PhotoPersistence, PhotoPersistence>(
				bundle.getBundleContext(), PhotoPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}