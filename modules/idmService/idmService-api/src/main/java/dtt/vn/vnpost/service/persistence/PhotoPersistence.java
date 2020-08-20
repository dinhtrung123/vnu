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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import dtt.vn.vnpost.exception.NoSuchPhotoException;
import dtt.vn.vnpost.model.Photo;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the photo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PhotoUtil
 * @generated
 */
@ProviderType
public interface PhotoPersistence extends BasePersistence<Photo> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PhotoUtil} to access the photo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, Photo> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the photos where className = &#63; and classPK = &#63; and imageType = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @param imageType the image type
	 * @return the matching photos
	 */
	public java.util.List<Photo> findByClassNameClassPKImageType(
		String className, long classPK, int imageType);

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
	public java.util.List<Photo> findByClassNameClassPKImageType(
		String className, long classPK, int imageType, int start, int end);

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
	public java.util.List<Photo> findByClassNameClassPKImageType(
		String className, long classPK, int imageType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Photo>
			orderByComparator);

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
	public java.util.List<Photo> findByClassNameClassPKImageType(
		String className, long classPK, int imageType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Photo>
			orderByComparator,
		boolean retrieveFromCache);

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
	public Photo findByClassNameClassPKImageType_First(
			String className, long classPK, int imageType,
			com.liferay.portal.kernel.util.OrderByComparator<Photo>
				orderByComparator)
		throws NoSuchPhotoException;

	/**
	 * Returns the first photo in the ordered set where className = &#63; and classPK = &#63; and imageType = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @param imageType the image type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching photo, or <code>null</code> if a matching photo could not be found
	 */
	public Photo fetchByClassNameClassPKImageType_First(
		String className, long classPK, int imageType,
		com.liferay.portal.kernel.util.OrderByComparator<Photo>
			orderByComparator);

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
	public Photo findByClassNameClassPKImageType_Last(
			String className, long classPK, int imageType,
			com.liferay.portal.kernel.util.OrderByComparator<Photo>
				orderByComparator)
		throws NoSuchPhotoException;

	/**
	 * Returns the last photo in the ordered set where className = &#63; and classPK = &#63; and imageType = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @param imageType the image type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching photo, or <code>null</code> if a matching photo could not be found
	 */
	public Photo fetchByClassNameClassPKImageType_Last(
		String className, long classPK, int imageType,
		com.liferay.portal.kernel.util.OrderByComparator<Photo>
			orderByComparator);

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
	public Photo[] findByClassNameClassPKImageType_PrevAndNext(
			long imageId, String className, long classPK, int imageType,
			com.liferay.portal.kernel.util.OrderByComparator<Photo>
				orderByComparator)
		throws NoSuchPhotoException;

	/**
	 * Removes all the photos where className = &#63; and classPK = &#63; and imageType = &#63; from the database.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @param imageType the image type
	 */
	public void removeByClassNameClassPKImageType(
		String className, long classPK, int imageType);

	/**
	 * Returns the number of photos where className = &#63; and classPK = &#63; and imageType = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @param imageType the image type
	 * @return the number of matching photos
	 */
	public int countByClassNameClassPKImageType(
		String className, long classPK, int imageType);

	/**
	 * Returns all the photos where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @return the matching photos
	 */
	public java.util.List<Photo> findByClassNameClassPK(
		String className, long classPK);

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
	public java.util.List<Photo> findByClassNameClassPK(
		String className, long classPK, int start, int end);

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
	public java.util.List<Photo> findByClassNameClassPK(
		String className, long classPK, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Photo>
			orderByComparator);

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
	public java.util.List<Photo> findByClassNameClassPK(
		String className, long classPK, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Photo>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first photo in the ordered set where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching photo
	 * @throws NoSuchPhotoException if a matching photo could not be found
	 */
	public Photo findByClassNameClassPK_First(
			String className, long classPK,
			com.liferay.portal.kernel.util.OrderByComparator<Photo>
				orderByComparator)
		throws NoSuchPhotoException;

	/**
	 * Returns the first photo in the ordered set where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching photo, or <code>null</code> if a matching photo could not be found
	 */
	public Photo fetchByClassNameClassPK_First(
		String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator<Photo>
			orderByComparator);

	/**
	 * Returns the last photo in the ordered set where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching photo
	 * @throws NoSuchPhotoException if a matching photo could not be found
	 */
	public Photo findByClassNameClassPK_Last(
			String className, long classPK,
			com.liferay.portal.kernel.util.OrderByComparator<Photo>
				orderByComparator)
		throws NoSuchPhotoException;

	/**
	 * Returns the last photo in the ordered set where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching photo, or <code>null</code> if a matching photo could not be found
	 */
	public Photo fetchByClassNameClassPK_Last(
		String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator<Photo>
			orderByComparator);

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
	public Photo[] findByClassNameClassPK_PrevAndNext(
			long imageId, String className, long classPK,
			com.liferay.portal.kernel.util.OrderByComparator<Photo>
				orderByComparator)
		throws NoSuchPhotoException;

	/**
	 * Removes all the photos where className = &#63; and classPK = &#63; from the database.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 */
	public void removeByClassNameClassPK(String className, long classPK);

	/**
	 * Returns the number of photos where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @return the number of matching photos
	 */
	public int countByClassNameClassPK(String className, long classPK);

	/**
	 * Returns all the photos where className = &#63;.
	 *
	 * @param className the class name
	 * @return the matching photos
	 */
	public java.util.List<Photo> findByClassName(String className);

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
	public java.util.List<Photo> findByClassName(
		String className, int start, int end);

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
	public java.util.List<Photo> findByClassName(
		String className, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Photo>
			orderByComparator);

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
	public java.util.List<Photo> findByClassName(
		String className, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Photo>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first photo in the ordered set where className = &#63;.
	 *
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching photo
	 * @throws NoSuchPhotoException if a matching photo could not be found
	 */
	public Photo findByClassName_First(
			String className,
			com.liferay.portal.kernel.util.OrderByComparator<Photo>
				orderByComparator)
		throws NoSuchPhotoException;

	/**
	 * Returns the first photo in the ordered set where className = &#63;.
	 *
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching photo, or <code>null</code> if a matching photo could not be found
	 */
	public Photo fetchByClassName_First(
		String className,
		com.liferay.portal.kernel.util.OrderByComparator<Photo>
			orderByComparator);

	/**
	 * Returns the last photo in the ordered set where className = &#63;.
	 *
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching photo
	 * @throws NoSuchPhotoException if a matching photo could not be found
	 */
	public Photo findByClassName_Last(
			String className,
			com.liferay.portal.kernel.util.OrderByComparator<Photo>
				orderByComparator)
		throws NoSuchPhotoException;

	/**
	 * Returns the last photo in the ordered set where className = &#63;.
	 *
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching photo, or <code>null</code> if a matching photo could not be found
	 */
	public Photo fetchByClassName_Last(
		String className,
		com.liferay.portal.kernel.util.OrderByComparator<Photo>
			orderByComparator);

	/**
	 * Returns the photos before and after the current photo in the ordered set where className = &#63;.
	 *
	 * @param imageId the primary key of the current photo
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next photo
	 * @throws NoSuchPhotoException if a photo with the primary key could not be found
	 */
	public Photo[] findByClassName_PrevAndNext(
			long imageId, String className,
			com.liferay.portal.kernel.util.OrderByComparator<Photo>
				orderByComparator)
		throws NoSuchPhotoException;

	/**
	 * Removes all the photos where className = &#63; from the database.
	 *
	 * @param className the class name
	 */
	public void removeByClassName(String className);

	/**
	 * Returns the number of photos where className = &#63;.
	 *
	 * @param className the class name
	 * @return the number of matching photos
	 */
	public int countByClassName(String className);

	/**
	 * Returns all the photos where classPK = &#63;.
	 *
	 * @param classPK the class pk
	 * @return the matching photos
	 */
	public java.util.List<Photo> findByClassPK(long classPK);

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
	public java.util.List<Photo> findByClassPK(
		long classPK, int start, int end);

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
	public java.util.List<Photo> findByClassPK(
		long classPK, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Photo>
			orderByComparator);

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
	public java.util.List<Photo> findByClassPK(
		long classPK, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Photo>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first photo in the ordered set where classPK = &#63;.
	 *
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching photo
	 * @throws NoSuchPhotoException if a matching photo could not be found
	 */
	public Photo findByClassPK_First(
			long classPK,
			com.liferay.portal.kernel.util.OrderByComparator<Photo>
				orderByComparator)
		throws NoSuchPhotoException;

	/**
	 * Returns the first photo in the ordered set where classPK = &#63;.
	 *
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching photo, or <code>null</code> if a matching photo could not be found
	 */
	public Photo fetchByClassPK_First(
		long classPK,
		com.liferay.portal.kernel.util.OrderByComparator<Photo>
			orderByComparator);

	/**
	 * Returns the last photo in the ordered set where classPK = &#63;.
	 *
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching photo
	 * @throws NoSuchPhotoException if a matching photo could not be found
	 */
	public Photo findByClassPK_Last(
			long classPK,
			com.liferay.portal.kernel.util.OrderByComparator<Photo>
				orderByComparator)
		throws NoSuchPhotoException;

	/**
	 * Returns the last photo in the ordered set where classPK = &#63;.
	 *
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching photo, or <code>null</code> if a matching photo could not be found
	 */
	public Photo fetchByClassPK_Last(
		long classPK,
		com.liferay.portal.kernel.util.OrderByComparator<Photo>
			orderByComparator);

	/**
	 * Returns the photos before and after the current photo in the ordered set where classPK = &#63;.
	 *
	 * @param imageId the primary key of the current photo
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next photo
	 * @throws NoSuchPhotoException if a photo with the primary key could not be found
	 */
	public Photo[] findByClassPK_PrevAndNext(
			long imageId, long classPK,
			com.liferay.portal.kernel.util.OrderByComparator<Photo>
				orderByComparator)
		throws NoSuchPhotoException;

	/**
	 * Removes all the photos where classPK = &#63; from the database.
	 *
	 * @param classPK the class pk
	 */
	public void removeByClassPK(long classPK);

	/**
	 * Returns the number of photos where classPK = &#63;.
	 *
	 * @param classPK the class pk
	 * @return the number of matching photos
	 */
	public int countByClassPK(long classPK);

	/**
	 * Returns all the photos where imageType = &#63; and classPK = &#63;.
	 *
	 * @param imageType the image type
	 * @param classPK the class pk
	 * @return the matching photos
	 */
	public java.util.List<Photo> findByImageTypeClassPK(
		int imageType, long classPK);

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
	public java.util.List<Photo> findByImageTypeClassPK(
		int imageType, long classPK, int start, int end);

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
	public java.util.List<Photo> findByImageTypeClassPK(
		int imageType, long classPK, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Photo>
			orderByComparator);

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
	public java.util.List<Photo> findByImageTypeClassPK(
		int imageType, long classPK, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Photo>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first photo in the ordered set where imageType = &#63; and classPK = &#63;.
	 *
	 * @param imageType the image type
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching photo
	 * @throws NoSuchPhotoException if a matching photo could not be found
	 */
	public Photo findByImageTypeClassPK_First(
			int imageType, long classPK,
			com.liferay.portal.kernel.util.OrderByComparator<Photo>
				orderByComparator)
		throws NoSuchPhotoException;

	/**
	 * Returns the first photo in the ordered set where imageType = &#63; and classPK = &#63;.
	 *
	 * @param imageType the image type
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching photo, or <code>null</code> if a matching photo could not be found
	 */
	public Photo fetchByImageTypeClassPK_First(
		int imageType, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator<Photo>
			orderByComparator);

	/**
	 * Returns the last photo in the ordered set where imageType = &#63; and classPK = &#63;.
	 *
	 * @param imageType the image type
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching photo
	 * @throws NoSuchPhotoException if a matching photo could not be found
	 */
	public Photo findByImageTypeClassPK_Last(
			int imageType, long classPK,
			com.liferay.portal.kernel.util.OrderByComparator<Photo>
				orderByComparator)
		throws NoSuchPhotoException;

	/**
	 * Returns the last photo in the ordered set where imageType = &#63; and classPK = &#63;.
	 *
	 * @param imageType the image type
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching photo, or <code>null</code> if a matching photo could not be found
	 */
	public Photo fetchByImageTypeClassPK_Last(
		int imageType, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator<Photo>
			orderByComparator);

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
	public Photo[] findByImageTypeClassPK_PrevAndNext(
			long imageId, int imageType, long classPK,
			com.liferay.portal.kernel.util.OrderByComparator<Photo>
				orderByComparator)
		throws NoSuchPhotoException;

	/**
	 * Removes all the photos where imageType = &#63; and classPK = &#63; from the database.
	 *
	 * @param imageType the image type
	 * @param classPK the class pk
	 */
	public void removeByImageTypeClassPK(int imageType, long classPK);

	/**
	 * Returns the number of photos where imageType = &#63; and classPK = &#63;.
	 *
	 * @param imageType the image type
	 * @param classPK the class pk
	 * @return the number of matching photos
	 */
	public int countByImageTypeClassPK(int imageType, long classPK);

	/**
	 * Caches the photo in the entity cache if it is enabled.
	 *
	 * @param photo the photo
	 */
	public void cacheResult(Photo photo);

	/**
	 * Caches the photos in the entity cache if it is enabled.
	 *
	 * @param photos the photos
	 */
	public void cacheResult(java.util.List<Photo> photos);

	/**
	 * Creates a new photo with the primary key. Does not add the photo to the database.
	 *
	 * @param imageId the primary key for the new photo
	 * @return the new photo
	 */
	public Photo create(long imageId);

	/**
	 * Removes the photo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param imageId the primary key of the photo
	 * @return the photo that was removed
	 * @throws NoSuchPhotoException if a photo with the primary key could not be found
	 */
	public Photo remove(long imageId) throws NoSuchPhotoException;

	public Photo updateImpl(Photo photo);

	/**
	 * Returns the photo with the primary key or throws a <code>NoSuchPhotoException</code> if it could not be found.
	 *
	 * @param imageId the primary key of the photo
	 * @return the photo
	 * @throws NoSuchPhotoException if a photo with the primary key could not be found
	 */
	public Photo findByPrimaryKey(long imageId) throws NoSuchPhotoException;

	/**
	 * Returns the photo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param imageId the primary key of the photo
	 * @return the photo, or <code>null</code> if a photo with the primary key could not be found
	 */
	public Photo fetchByPrimaryKey(long imageId);

	/**
	 * Returns all the photos.
	 *
	 * @return the photos
	 */
	public java.util.List<Photo> findAll();

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
	public java.util.List<Photo> findAll(int start, int end);

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
	public java.util.List<Photo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Photo>
			orderByComparator);

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
	public java.util.List<Photo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Photo>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the photos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of photos.
	 *
	 * @return the number of photos
	 */
	public int countAll();

}