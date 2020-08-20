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

package dtt.vn.vnpost.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import dtt.vn.vnpost.exception.NoSuchPhotoException;
import dtt.vn.vnpost.model.Photo;
import dtt.vn.vnpost.model.impl.PhotoImpl;
import dtt.vn.vnpost.model.impl.PhotoModelImpl;
import dtt.vn.vnpost.service.persistence.PhotoPersistence;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the photo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class PhotoPersistenceImpl
	extends BasePersistenceImpl<Photo> implements PhotoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PhotoUtil</code> to access the photo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PhotoImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByClassNameClassPKImageType;
	private FinderPath
		_finderPathWithoutPaginationFindByClassNameClassPKImageType;
	private FinderPath _finderPathCountByClassNameClassPKImageType;

	/**
	 * Returns all the photos where className = &#63; and classPK = &#63; and imageType = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @param imageType the image type
	 * @return the matching photos
	 */
	@Override
	public List<Photo> findByClassNameClassPKImageType(
		String className, long classPK, int imageType) {

		return findByClassNameClassPKImageType(
			className, classPK, imageType, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Photo> findByClassNameClassPKImageType(
		String className, long classPK, int imageType, int start, int end) {

		return findByClassNameClassPKImageType(
			className, classPK, imageType, start, end, null);
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
	@Override
	public List<Photo> findByClassNameClassPKImageType(
		String className, long classPK, int imageType, int start, int end,
		OrderByComparator<Photo> orderByComparator) {

		return findByClassNameClassPKImageType(
			className, classPK, imageType, start, end, orderByComparator, true);
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
	@Override
	public List<Photo> findByClassNameClassPKImageType(
		String className, long classPK, int imageType, int start, int end,
		OrderByComparator<Photo> orderByComparator, boolean retrieveFromCache) {

		className = Objects.toString(className, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath =
				_finderPathWithoutPaginationFindByClassNameClassPKImageType;
			finderArgs = new Object[] {className, classPK, imageType};
		}
		else {
			finderPath =
				_finderPathWithPaginationFindByClassNameClassPKImageType;
			finderArgs = new Object[] {
				className, classPK, imageType, start, end, orderByComparator
			};
		}

		List<Photo> list = null;

		if (retrieveFromCache) {
			list = (List<Photo>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Photo photo : list) {
					if (!className.equals(photo.getClassName()) ||
						(classPK != photo.getClassPK()) ||
						(imageType != photo.getImageType())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_PHOTO_WHERE);

			boolean bindClassName = false;

			if (className.isEmpty()) {
				query.append(
					_FINDER_COLUMN_CLASSNAMECLASSPKIMAGETYPE_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(
					_FINDER_COLUMN_CLASSNAMECLASSPKIMAGETYPE_CLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_CLASSNAMECLASSPKIMAGETYPE_CLASSPK_2);

			query.append(_FINDER_COLUMN_CLASSNAMECLASSPKIMAGETYPE_IMAGETYPE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(PhotoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindClassName) {
					qPos.add(className);
				}

				qPos.add(classPK);

				qPos.add(imageType);

				if (!pagination) {
					list = (List<Photo>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Photo>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Photo findByClassNameClassPKImageType_First(
			String className, long classPK, int imageType,
			OrderByComparator<Photo> orderByComparator)
		throws NoSuchPhotoException {

		Photo photo = fetchByClassNameClassPKImageType_First(
			className, classPK, imageType, orderByComparator);

		if (photo != null) {
			return photo;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("className=");
		msg.append(className);

		msg.append(", classPK=");
		msg.append(classPK);

		msg.append(", imageType=");
		msg.append(imageType);

		msg.append("}");

		throw new NoSuchPhotoException(msg.toString());
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
	@Override
	public Photo fetchByClassNameClassPKImageType_First(
		String className, long classPK, int imageType,
		OrderByComparator<Photo> orderByComparator) {

		List<Photo> list = findByClassNameClassPKImageType(
			className, classPK, imageType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Photo findByClassNameClassPKImageType_Last(
			String className, long classPK, int imageType,
			OrderByComparator<Photo> orderByComparator)
		throws NoSuchPhotoException {

		Photo photo = fetchByClassNameClassPKImageType_Last(
			className, classPK, imageType, orderByComparator);

		if (photo != null) {
			return photo;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("className=");
		msg.append(className);

		msg.append(", classPK=");
		msg.append(classPK);

		msg.append(", imageType=");
		msg.append(imageType);

		msg.append("}");

		throw new NoSuchPhotoException(msg.toString());
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
	@Override
	public Photo fetchByClassNameClassPKImageType_Last(
		String className, long classPK, int imageType,
		OrderByComparator<Photo> orderByComparator) {

		int count = countByClassNameClassPKImageType(
			className, classPK, imageType);

		if (count == 0) {
			return null;
		}

		List<Photo> list = findByClassNameClassPKImageType(
			className, classPK, imageType, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Photo[] findByClassNameClassPKImageType_PrevAndNext(
			long imageId, String className, long classPK, int imageType,
			OrderByComparator<Photo> orderByComparator)
		throws NoSuchPhotoException {

		className = Objects.toString(className, "");

		Photo photo = findByPrimaryKey(imageId);

		Session session = null;

		try {
			session = openSession();

			Photo[] array = new PhotoImpl[3];

			array[0] = getByClassNameClassPKImageType_PrevAndNext(
				session, photo, className, classPK, imageType,
				orderByComparator, true);

			array[1] = photo;

			array[2] = getByClassNameClassPKImageType_PrevAndNext(
				session, photo, className, classPK, imageType,
				orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Photo getByClassNameClassPKImageType_PrevAndNext(
		Session session, Photo photo, String className, long classPK,
		int imageType, OrderByComparator<Photo> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_PHOTO_WHERE);

		boolean bindClassName = false;

		if (className.isEmpty()) {
			query.append(_FINDER_COLUMN_CLASSNAMECLASSPKIMAGETYPE_CLASSNAME_3);
		}
		else {
			bindClassName = true;

			query.append(_FINDER_COLUMN_CLASSNAMECLASSPKIMAGETYPE_CLASSNAME_2);
		}

		query.append(_FINDER_COLUMN_CLASSNAMECLASSPKIMAGETYPE_CLASSPK_2);

		query.append(_FINDER_COLUMN_CLASSNAMECLASSPKIMAGETYPE_IMAGETYPE_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(PhotoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindClassName) {
			qPos.add(className);
		}

		qPos.add(classPK);

		qPos.add(imageType);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(photo)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Photo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the photos where className = &#63; and classPK = &#63; and imageType = &#63; from the database.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @param imageType the image type
	 */
	@Override
	public void removeByClassNameClassPKImageType(
		String className, long classPK, int imageType) {

		for (Photo photo :
				findByClassNameClassPKImageType(
					className, classPK, imageType, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(photo);
		}
	}

	/**
	 * Returns the number of photos where className = &#63; and classPK = &#63; and imageType = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @param imageType the image type
	 * @return the number of matching photos
	 */
	@Override
	public int countByClassNameClassPKImageType(
		String className, long classPK, int imageType) {

		className = Objects.toString(className, "");

		FinderPath finderPath = _finderPathCountByClassNameClassPKImageType;

		Object[] finderArgs = new Object[] {className, classPK, imageType};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_PHOTO_WHERE);

			boolean bindClassName = false;

			if (className.isEmpty()) {
				query.append(
					_FINDER_COLUMN_CLASSNAMECLASSPKIMAGETYPE_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(
					_FINDER_COLUMN_CLASSNAMECLASSPKIMAGETYPE_CLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_CLASSNAMECLASSPKIMAGETYPE_CLASSPK_2);

			query.append(_FINDER_COLUMN_CLASSNAMECLASSPKIMAGETYPE_IMAGETYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindClassName) {
					qPos.add(className);
				}

				qPos.add(classPK);

				qPos.add(imageType);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_CLASSNAMECLASSPKIMAGETYPE_CLASSNAME_2 =
			"photo.className = ? AND ";

	private static final String
		_FINDER_COLUMN_CLASSNAMECLASSPKIMAGETYPE_CLASSNAME_3 =
			"(photo.className IS NULL OR photo.className = '') AND ";

	private static final String
		_FINDER_COLUMN_CLASSNAMECLASSPKIMAGETYPE_CLASSPK_2 =
			"photo.classPK = ? AND ";

	private static final String
		_FINDER_COLUMN_CLASSNAMECLASSPKIMAGETYPE_IMAGETYPE_2 =
			"photo.imageType = ?";

	private FinderPath _finderPathWithPaginationFindByClassNameClassPK;
	private FinderPath _finderPathWithoutPaginationFindByClassNameClassPK;
	private FinderPath _finderPathCountByClassNameClassPK;

	/**
	 * Returns all the photos where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @return the matching photos
	 */
	@Override
	public List<Photo> findByClassNameClassPK(String className, long classPK) {
		return findByClassNameClassPK(
			className, classPK, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Photo> findByClassNameClassPK(
		String className, long classPK, int start, int end) {

		return findByClassNameClassPK(className, classPK, start, end, null);
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
	@Override
	public List<Photo> findByClassNameClassPK(
		String className, long classPK, int start, int end,
		OrderByComparator<Photo> orderByComparator) {

		return findByClassNameClassPK(
			className, classPK, start, end, orderByComparator, true);
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
	@Override
	public List<Photo> findByClassNameClassPK(
		String className, long classPK, int start, int end,
		OrderByComparator<Photo> orderByComparator, boolean retrieveFromCache) {

		className = Objects.toString(className, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByClassNameClassPK;
			finderArgs = new Object[] {className, classPK};
		}
		else {
			finderPath = _finderPathWithPaginationFindByClassNameClassPK;
			finderArgs = new Object[] {
				className, classPK, start, end, orderByComparator
			};
		}

		List<Photo> list = null;

		if (retrieveFromCache) {
			list = (List<Photo>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Photo photo : list) {
					if (!className.equals(photo.getClassName()) ||
						(classPK != photo.getClassPK())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_PHOTO_WHERE);

			boolean bindClassName = false;

			if (className.isEmpty()) {
				query.append(_FINDER_COLUMN_CLASSNAMECLASSPK_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_CLASSNAMECLASSPK_CLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_CLASSNAMECLASSPK_CLASSPK_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(PhotoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindClassName) {
					qPos.add(className);
				}

				qPos.add(classPK);

				if (!pagination) {
					list = (List<Photo>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Photo>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Photo findByClassNameClassPK_First(
			String className, long classPK,
			OrderByComparator<Photo> orderByComparator)
		throws NoSuchPhotoException {

		Photo photo = fetchByClassNameClassPK_First(
			className, classPK, orderByComparator);

		if (photo != null) {
			return photo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("className=");
		msg.append(className);

		msg.append(", classPK=");
		msg.append(classPK);

		msg.append("}");

		throw new NoSuchPhotoException(msg.toString());
	}

	/**
	 * Returns the first photo in the ordered set where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching photo, or <code>null</code> if a matching photo could not be found
	 */
	@Override
	public Photo fetchByClassNameClassPK_First(
		String className, long classPK,
		OrderByComparator<Photo> orderByComparator) {

		List<Photo> list = findByClassNameClassPK(
			className, classPK, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Photo findByClassNameClassPK_Last(
			String className, long classPK,
			OrderByComparator<Photo> orderByComparator)
		throws NoSuchPhotoException {

		Photo photo = fetchByClassNameClassPK_Last(
			className, classPK, orderByComparator);

		if (photo != null) {
			return photo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("className=");
		msg.append(className);

		msg.append(", classPK=");
		msg.append(classPK);

		msg.append("}");

		throw new NoSuchPhotoException(msg.toString());
	}

	/**
	 * Returns the last photo in the ordered set where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching photo, or <code>null</code> if a matching photo could not be found
	 */
	@Override
	public Photo fetchByClassNameClassPK_Last(
		String className, long classPK,
		OrderByComparator<Photo> orderByComparator) {

		int count = countByClassNameClassPK(className, classPK);

		if (count == 0) {
			return null;
		}

		List<Photo> list = findByClassNameClassPK(
			className, classPK, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Photo[] findByClassNameClassPK_PrevAndNext(
			long imageId, String className, long classPK,
			OrderByComparator<Photo> orderByComparator)
		throws NoSuchPhotoException {

		className = Objects.toString(className, "");

		Photo photo = findByPrimaryKey(imageId);

		Session session = null;

		try {
			session = openSession();

			Photo[] array = new PhotoImpl[3];

			array[0] = getByClassNameClassPK_PrevAndNext(
				session, photo, className, classPK, orderByComparator, true);

			array[1] = photo;

			array[2] = getByClassNameClassPK_PrevAndNext(
				session, photo, className, classPK, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Photo getByClassNameClassPK_PrevAndNext(
		Session session, Photo photo, String className, long classPK,
		OrderByComparator<Photo> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_PHOTO_WHERE);

		boolean bindClassName = false;

		if (className.isEmpty()) {
			query.append(_FINDER_COLUMN_CLASSNAMECLASSPK_CLASSNAME_3);
		}
		else {
			bindClassName = true;

			query.append(_FINDER_COLUMN_CLASSNAMECLASSPK_CLASSNAME_2);
		}

		query.append(_FINDER_COLUMN_CLASSNAMECLASSPK_CLASSPK_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(PhotoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindClassName) {
			qPos.add(className);
		}

		qPos.add(classPK);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(photo)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Photo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the photos where className = &#63; and classPK = &#63; from the database.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 */
	@Override
	public void removeByClassNameClassPK(String className, long classPK) {
		for (Photo photo :
				findByClassNameClassPK(
					className, classPK, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(photo);
		}
	}

	/**
	 * Returns the number of photos where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class pk
	 * @return the number of matching photos
	 */
	@Override
	public int countByClassNameClassPK(String className, long classPK) {
		className = Objects.toString(className, "");

		FinderPath finderPath = _finderPathCountByClassNameClassPK;

		Object[] finderArgs = new Object[] {className, classPK};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PHOTO_WHERE);

			boolean bindClassName = false;

			if (className.isEmpty()) {
				query.append(_FINDER_COLUMN_CLASSNAMECLASSPK_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_CLASSNAMECLASSPK_CLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_CLASSNAMECLASSPK_CLASSPK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindClassName) {
					qPos.add(className);
				}

				qPos.add(classPK);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CLASSNAMECLASSPK_CLASSNAME_2 =
		"photo.className = ? AND ";

	private static final String _FINDER_COLUMN_CLASSNAMECLASSPK_CLASSNAME_3 =
		"(photo.className IS NULL OR photo.className = '') AND ";

	private static final String _FINDER_COLUMN_CLASSNAMECLASSPK_CLASSPK_2 =
		"photo.classPK = ?";

	private FinderPath _finderPathWithPaginationFindByClassName;
	private FinderPath _finderPathWithoutPaginationFindByClassName;
	private FinderPath _finderPathCountByClassName;

	/**
	 * Returns all the photos where className = &#63;.
	 *
	 * @param className the class name
	 * @return the matching photos
	 */
	@Override
	public List<Photo> findByClassName(String className) {
		return findByClassName(
			className, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Photo> findByClassName(String className, int start, int end) {
		return findByClassName(className, start, end, null);
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
	@Override
	public List<Photo> findByClassName(
		String className, int start, int end,
		OrderByComparator<Photo> orderByComparator) {

		return findByClassName(className, start, end, orderByComparator, true);
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
	@Override
	public List<Photo> findByClassName(
		String className, int start, int end,
		OrderByComparator<Photo> orderByComparator, boolean retrieveFromCache) {

		className = Objects.toString(className, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByClassName;
			finderArgs = new Object[] {className};
		}
		else {
			finderPath = _finderPathWithPaginationFindByClassName;
			finderArgs = new Object[] {
				className, start, end, orderByComparator
			};
		}

		List<Photo> list = null;

		if (retrieveFromCache) {
			list = (List<Photo>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Photo photo : list) {
					if (!className.equals(photo.getClassName())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_PHOTO_WHERE);

			boolean bindClassName = false;

			if (className.isEmpty()) {
				query.append(_FINDER_COLUMN_CLASSNAME_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_CLASSNAME_CLASSNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(PhotoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindClassName) {
					qPos.add(className);
				}

				if (!pagination) {
					list = (List<Photo>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Photo>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first photo in the ordered set where className = &#63;.
	 *
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching photo
	 * @throws NoSuchPhotoException if a matching photo could not be found
	 */
	@Override
	public Photo findByClassName_First(
			String className, OrderByComparator<Photo> orderByComparator)
		throws NoSuchPhotoException {

		Photo photo = fetchByClassName_First(className, orderByComparator);

		if (photo != null) {
			return photo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("className=");
		msg.append(className);

		msg.append("}");

		throw new NoSuchPhotoException(msg.toString());
	}

	/**
	 * Returns the first photo in the ordered set where className = &#63;.
	 *
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching photo, or <code>null</code> if a matching photo could not be found
	 */
	@Override
	public Photo fetchByClassName_First(
		String className, OrderByComparator<Photo> orderByComparator) {

		List<Photo> list = findByClassName(className, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last photo in the ordered set where className = &#63;.
	 *
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching photo
	 * @throws NoSuchPhotoException if a matching photo could not be found
	 */
	@Override
	public Photo findByClassName_Last(
			String className, OrderByComparator<Photo> orderByComparator)
		throws NoSuchPhotoException {

		Photo photo = fetchByClassName_Last(className, orderByComparator);

		if (photo != null) {
			return photo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("className=");
		msg.append(className);

		msg.append("}");

		throw new NoSuchPhotoException(msg.toString());
	}

	/**
	 * Returns the last photo in the ordered set where className = &#63;.
	 *
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching photo, or <code>null</code> if a matching photo could not be found
	 */
	@Override
	public Photo fetchByClassName_Last(
		String className, OrderByComparator<Photo> orderByComparator) {

		int count = countByClassName(className);

		if (count == 0) {
			return null;
		}

		List<Photo> list = findByClassName(
			className, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Photo[] findByClassName_PrevAndNext(
			long imageId, String className,
			OrderByComparator<Photo> orderByComparator)
		throws NoSuchPhotoException {

		className = Objects.toString(className, "");

		Photo photo = findByPrimaryKey(imageId);

		Session session = null;

		try {
			session = openSession();

			Photo[] array = new PhotoImpl[3];

			array[0] = getByClassName_PrevAndNext(
				session, photo, className, orderByComparator, true);

			array[1] = photo;

			array[2] = getByClassName_PrevAndNext(
				session, photo, className, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Photo getByClassName_PrevAndNext(
		Session session, Photo photo, String className,
		OrderByComparator<Photo> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PHOTO_WHERE);

		boolean bindClassName = false;

		if (className.isEmpty()) {
			query.append(_FINDER_COLUMN_CLASSNAME_CLASSNAME_3);
		}
		else {
			bindClassName = true;

			query.append(_FINDER_COLUMN_CLASSNAME_CLASSNAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(PhotoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindClassName) {
			qPos.add(className);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(photo)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Photo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the photos where className = &#63; from the database.
	 *
	 * @param className the class name
	 */
	@Override
	public void removeByClassName(String className) {
		for (Photo photo :
				findByClassName(
					className, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(photo);
		}
	}

	/**
	 * Returns the number of photos where className = &#63;.
	 *
	 * @param className the class name
	 * @return the number of matching photos
	 */
	@Override
	public int countByClassName(String className) {
		className = Objects.toString(className, "");

		FinderPath finderPath = _finderPathCountByClassName;

		Object[] finderArgs = new Object[] {className};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PHOTO_WHERE);

			boolean bindClassName = false;

			if (className.isEmpty()) {
				query.append(_FINDER_COLUMN_CLASSNAME_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_CLASSNAME_CLASSNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindClassName) {
					qPos.add(className);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CLASSNAME_CLASSNAME_2 =
		"photo.className = ?";

	private static final String _FINDER_COLUMN_CLASSNAME_CLASSNAME_3 =
		"(photo.className IS NULL OR photo.className = '')";

	private FinderPath _finderPathWithPaginationFindByClassPK;
	private FinderPath _finderPathWithoutPaginationFindByClassPK;
	private FinderPath _finderPathCountByClassPK;

	/**
	 * Returns all the photos where classPK = &#63;.
	 *
	 * @param classPK the class pk
	 * @return the matching photos
	 */
	@Override
	public List<Photo> findByClassPK(long classPK) {
		return findByClassPK(
			classPK, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Photo> findByClassPK(long classPK, int start, int end) {
		return findByClassPK(classPK, start, end, null);
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
	@Override
	public List<Photo> findByClassPK(
		long classPK, int start, int end,
		OrderByComparator<Photo> orderByComparator) {

		return findByClassPK(classPK, start, end, orderByComparator, true);
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
	@Override
	public List<Photo> findByClassPK(
		long classPK, int start, int end,
		OrderByComparator<Photo> orderByComparator, boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByClassPK;
			finderArgs = new Object[] {classPK};
		}
		else {
			finderPath = _finderPathWithPaginationFindByClassPK;
			finderArgs = new Object[] {classPK, start, end, orderByComparator};
		}

		List<Photo> list = null;

		if (retrieveFromCache) {
			list = (List<Photo>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Photo photo : list) {
					if ((classPK != photo.getClassPK())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_PHOTO_WHERE);

			query.append(_FINDER_COLUMN_CLASSPK_CLASSPK_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(PhotoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(classPK);

				if (!pagination) {
					list = (List<Photo>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Photo>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first photo in the ordered set where classPK = &#63;.
	 *
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching photo
	 * @throws NoSuchPhotoException if a matching photo could not be found
	 */
	@Override
	public Photo findByClassPK_First(
			long classPK, OrderByComparator<Photo> orderByComparator)
		throws NoSuchPhotoException {

		Photo photo = fetchByClassPK_First(classPK, orderByComparator);

		if (photo != null) {
			return photo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("classPK=");
		msg.append(classPK);

		msg.append("}");

		throw new NoSuchPhotoException(msg.toString());
	}

	/**
	 * Returns the first photo in the ordered set where classPK = &#63;.
	 *
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching photo, or <code>null</code> if a matching photo could not be found
	 */
	@Override
	public Photo fetchByClassPK_First(
		long classPK, OrderByComparator<Photo> orderByComparator) {

		List<Photo> list = findByClassPK(classPK, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last photo in the ordered set where classPK = &#63;.
	 *
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching photo
	 * @throws NoSuchPhotoException if a matching photo could not be found
	 */
	@Override
	public Photo findByClassPK_Last(
			long classPK, OrderByComparator<Photo> orderByComparator)
		throws NoSuchPhotoException {

		Photo photo = fetchByClassPK_Last(classPK, orderByComparator);

		if (photo != null) {
			return photo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("classPK=");
		msg.append(classPK);

		msg.append("}");

		throw new NoSuchPhotoException(msg.toString());
	}

	/**
	 * Returns the last photo in the ordered set where classPK = &#63;.
	 *
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching photo, or <code>null</code> if a matching photo could not be found
	 */
	@Override
	public Photo fetchByClassPK_Last(
		long classPK, OrderByComparator<Photo> orderByComparator) {

		int count = countByClassPK(classPK);

		if (count == 0) {
			return null;
		}

		List<Photo> list = findByClassPK(
			classPK, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Photo[] findByClassPK_PrevAndNext(
			long imageId, long classPK,
			OrderByComparator<Photo> orderByComparator)
		throws NoSuchPhotoException {

		Photo photo = findByPrimaryKey(imageId);

		Session session = null;

		try {
			session = openSession();

			Photo[] array = new PhotoImpl[3];

			array[0] = getByClassPK_PrevAndNext(
				session, photo, classPK, orderByComparator, true);

			array[1] = photo;

			array[2] = getByClassPK_PrevAndNext(
				session, photo, classPK, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Photo getByClassPK_PrevAndNext(
		Session session, Photo photo, long classPK,
		OrderByComparator<Photo> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PHOTO_WHERE);

		query.append(_FINDER_COLUMN_CLASSPK_CLASSPK_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(PhotoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(classPK);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(photo)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Photo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the photos where classPK = &#63; from the database.
	 *
	 * @param classPK the class pk
	 */
	@Override
	public void removeByClassPK(long classPK) {
		for (Photo photo :
				findByClassPK(
					classPK, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(photo);
		}
	}

	/**
	 * Returns the number of photos where classPK = &#63;.
	 *
	 * @param classPK the class pk
	 * @return the number of matching photos
	 */
	@Override
	public int countByClassPK(long classPK) {
		FinderPath finderPath = _finderPathCountByClassPK;

		Object[] finderArgs = new Object[] {classPK};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PHOTO_WHERE);

			query.append(_FINDER_COLUMN_CLASSPK_CLASSPK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(classPK);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CLASSPK_CLASSPK_2 =
		"photo.classPK = ?";

	private FinderPath _finderPathWithPaginationFindByImageTypeClassPK;
	private FinderPath _finderPathWithoutPaginationFindByImageTypeClassPK;
	private FinderPath _finderPathCountByImageTypeClassPK;

	/**
	 * Returns all the photos where imageType = &#63; and classPK = &#63;.
	 *
	 * @param imageType the image type
	 * @param classPK the class pk
	 * @return the matching photos
	 */
	@Override
	public List<Photo> findByImageTypeClassPK(int imageType, long classPK) {
		return findByImageTypeClassPK(
			imageType, classPK, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Photo> findByImageTypeClassPK(
		int imageType, long classPK, int start, int end) {

		return findByImageTypeClassPK(imageType, classPK, start, end, null);
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
	@Override
	public List<Photo> findByImageTypeClassPK(
		int imageType, long classPK, int start, int end,
		OrderByComparator<Photo> orderByComparator) {

		return findByImageTypeClassPK(
			imageType, classPK, start, end, orderByComparator, true);
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
	@Override
	public List<Photo> findByImageTypeClassPK(
		int imageType, long classPK, int start, int end,
		OrderByComparator<Photo> orderByComparator, boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByImageTypeClassPK;
			finderArgs = new Object[] {imageType, classPK};
		}
		else {
			finderPath = _finderPathWithPaginationFindByImageTypeClassPK;
			finderArgs = new Object[] {
				imageType, classPK, start, end, orderByComparator
			};
		}

		List<Photo> list = null;

		if (retrieveFromCache) {
			list = (List<Photo>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Photo photo : list) {
					if ((imageType != photo.getImageType()) ||
						(classPK != photo.getClassPK())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_PHOTO_WHERE);

			query.append(_FINDER_COLUMN_IMAGETYPECLASSPK_IMAGETYPE_2);

			query.append(_FINDER_COLUMN_IMAGETYPECLASSPK_CLASSPK_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(PhotoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(imageType);

				qPos.add(classPK);

				if (!pagination) {
					list = (List<Photo>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Photo>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Photo findByImageTypeClassPK_First(
			int imageType, long classPK,
			OrderByComparator<Photo> orderByComparator)
		throws NoSuchPhotoException {

		Photo photo = fetchByImageTypeClassPK_First(
			imageType, classPK, orderByComparator);

		if (photo != null) {
			return photo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("imageType=");
		msg.append(imageType);

		msg.append(", classPK=");
		msg.append(classPK);

		msg.append("}");

		throw new NoSuchPhotoException(msg.toString());
	}

	/**
	 * Returns the first photo in the ordered set where imageType = &#63; and classPK = &#63;.
	 *
	 * @param imageType the image type
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching photo, or <code>null</code> if a matching photo could not be found
	 */
	@Override
	public Photo fetchByImageTypeClassPK_First(
		int imageType, long classPK,
		OrderByComparator<Photo> orderByComparator) {

		List<Photo> list = findByImageTypeClassPK(
			imageType, classPK, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Photo findByImageTypeClassPK_Last(
			int imageType, long classPK,
			OrderByComparator<Photo> orderByComparator)
		throws NoSuchPhotoException {

		Photo photo = fetchByImageTypeClassPK_Last(
			imageType, classPK, orderByComparator);

		if (photo != null) {
			return photo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("imageType=");
		msg.append(imageType);

		msg.append(", classPK=");
		msg.append(classPK);

		msg.append("}");

		throw new NoSuchPhotoException(msg.toString());
	}

	/**
	 * Returns the last photo in the ordered set where imageType = &#63; and classPK = &#63;.
	 *
	 * @param imageType the image type
	 * @param classPK the class pk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching photo, or <code>null</code> if a matching photo could not be found
	 */
	@Override
	public Photo fetchByImageTypeClassPK_Last(
		int imageType, long classPK,
		OrderByComparator<Photo> orderByComparator) {

		int count = countByImageTypeClassPK(imageType, classPK);

		if (count == 0) {
			return null;
		}

		List<Photo> list = findByImageTypeClassPK(
			imageType, classPK, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Photo[] findByImageTypeClassPK_PrevAndNext(
			long imageId, int imageType, long classPK,
			OrderByComparator<Photo> orderByComparator)
		throws NoSuchPhotoException {

		Photo photo = findByPrimaryKey(imageId);

		Session session = null;

		try {
			session = openSession();

			Photo[] array = new PhotoImpl[3];

			array[0] = getByImageTypeClassPK_PrevAndNext(
				session, photo, imageType, classPK, orderByComparator, true);

			array[1] = photo;

			array[2] = getByImageTypeClassPK_PrevAndNext(
				session, photo, imageType, classPK, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Photo getByImageTypeClassPK_PrevAndNext(
		Session session, Photo photo, int imageType, long classPK,
		OrderByComparator<Photo> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_PHOTO_WHERE);

		query.append(_FINDER_COLUMN_IMAGETYPECLASSPK_IMAGETYPE_2);

		query.append(_FINDER_COLUMN_IMAGETYPECLASSPK_CLASSPK_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(PhotoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(imageType);

		qPos.add(classPK);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(photo)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Photo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the photos where imageType = &#63; and classPK = &#63; from the database.
	 *
	 * @param imageType the image type
	 * @param classPK the class pk
	 */
	@Override
	public void removeByImageTypeClassPK(int imageType, long classPK) {
		for (Photo photo :
				findByImageTypeClassPK(
					imageType, classPK, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(photo);
		}
	}

	/**
	 * Returns the number of photos where imageType = &#63; and classPK = &#63;.
	 *
	 * @param imageType the image type
	 * @param classPK the class pk
	 * @return the number of matching photos
	 */
	@Override
	public int countByImageTypeClassPK(int imageType, long classPK) {
		FinderPath finderPath = _finderPathCountByImageTypeClassPK;

		Object[] finderArgs = new Object[] {imageType, classPK};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PHOTO_WHERE);

			query.append(_FINDER_COLUMN_IMAGETYPECLASSPK_IMAGETYPE_2);

			query.append(_FINDER_COLUMN_IMAGETYPECLASSPK_CLASSPK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(imageType);

				qPos.add(classPK);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_IMAGETYPECLASSPK_IMAGETYPE_2 =
		"photo.imageType = ? AND ";

	private static final String _FINDER_COLUMN_IMAGETYPECLASSPK_CLASSPK_2 =
		"photo.classPK = ?";

	public PhotoPersistenceImpl() {
		setModelClass(Photo.class);
	}

	/**
	 * Caches the photo in the entity cache if it is enabled.
	 *
	 * @param photo the photo
	 */
	@Override
	public void cacheResult(Photo photo) {
		entityCache.putResult(
			PhotoModelImpl.ENTITY_CACHE_ENABLED, PhotoImpl.class,
			photo.getPrimaryKey(), photo);

		photo.resetOriginalValues();
	}

	/**
	 * Caches the photos in the entity cache if it is enabled.
	 *
	 * @param photos the photos
	 */
	@Override
	public void cacheResult(List<Photo> photos) {
		for (Photo photo : photos) {
			if (entityCache.getResult(
					PhotoModelImpl.ENTITY_CACHE_ENABLED, PhotoImpl.class,
					photo.getPrimaryKey()) == null) {

				cacheResult(photo);
			}
			else {
				photo.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all photos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PhotoImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the photo.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Photo photo) {
		entityCache.removeResult(
			PhotoModelImpl.ENTITY_CACHE_ENABLED, PhotoImpl.class,
			photo.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Photo> photos) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Photo photo : photos) {
			entityCache.removeResult(
				PhotoModelImpl.ENTITY_CACHE_ENABLED, PhotoImpl.class,
				photo.getPrimaryKey());
		}
	}

	/**
	 * Creates a new photo with the primary key. Does not add the photo to the database.
	 *
	 * @param imageId the primary key for the new photo
	 * @return the new photo
	 */
	@Override
	public Photo create(long imageId) {
		Photo photo = new PhotoImpl();

		photo.setNew(true);
		photo.setPrimaryKey(imageId);

		return photo;
	}

	/**
	 * Removes the photo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param imageId the primary key of the photo
	 * @return the photo that was removed
	 * @throws NoSuchPhotoException if a photo with the primary key could not be found
	 */
	@Override
	public Photo remove(long imageId) throws NoSuchPhotoException {
		return remove((Serializable)imageId);
	}

	/**
	 * Removes the photo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the photo
	 * @return the photo that was removed
	 * @throws NoSuchPhotoException if a photo with the primary key could not be found
	 */
	@Override
	public Photo remove(Serializable primaryKey) throws NoSuchPhotoException {
		Session session = null;

		try {
			session = openSession();

			Photo photo = (Photo)session.get(PhotoImpl.class, primaryKey);

			if (photo == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPhotoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(photo);
		}
		catch (NoSuchPhotoException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Photo removeImpl(Photo photo) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(photo)) {
				photo = (Photo)session.get(
					PhotoImpl.class, photo.getPrimaryKeyObj());
			}

			if (photo != null) {
				session.delete(photo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (photo != null) {
			clearCache(photo);
		}

		return photo;
	}

	@Override
	public Photo updateImpl(Photo photo) {
		boolean isNew = photo.isNew();

		if (!(photo instanceof PhotoModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(photo.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(photo);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in photo proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Photo implementation " +
					photo.getClass());
		}

		PhotoModelImpl photoModelImpl = (PhotoModelImpl)photo;

		Session session = null;

		try {
			session = openSession();

			if (photo.isNew()) {
				session.save(photo);

				photo.setNew(false);
			}
			else {
				photo = (Photo)session.merge(photo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!PhotoModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {
				photoModelImpl.getClassName(), photoModelImpl.getClassPK(),
				photoModelImpl.getImageType()
			};

			finderCache.removeResult(
				_finderPathCountByClassNameClassPKImageType, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByClassNameClassPKImageType,
				args);

			args = new Object[] {
				photoModelImpl.getClassName(), photoModelImpl.getClassPK()
			};

			finderCache.removeResult(_finderPathCountByClassNameClassPK, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByClassNameClassPK, args);

			args = new Object[] {photoModelImpl.getClassName()};

			finderCache.removeResult(_finderPathCountByClassName, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByClassName, args);

			args = new Object[] {photoModelImpl.getClassPK()};

			finderCache.removeResult(_finderPathCountByClassPK, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByClassPK, args);

			args = new Object[] {
				photoModelImpl.getImageType(), photoModelImpl.getClassPK()
			};

			finderCache.removeResult(_finderPathCountByImageTypeClassPK, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByImageTypeClassPK, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((photoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByClassNameClassPKImageType.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					photoModelImpl.getOriginalClassName(),
					photoModelImpl.getOriginalClassPK(),
					photoModelImpl.getOriginalImageType()
				};

				finderCache.removeResult(
					_finderPathCountByClassNameClassPKImageType, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByClassNameClassPKImageType,
					args);

				args = new Object[] {
					photoModelImpl.getClassName(), photoModelImpl.getClassPK(),
					photoModelImpl.getImageType()
				};

				finderCache.removeResult(
					_finderPathCountByClassNameClassPKImageType, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByClassNameClassPKImageType,
					args);
			}

			if ((photoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByClassNameClassPK.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					photoModelImpl.getOriginalClassName(),
					photoModelImpl.getOriginalClassPK()
				};

				finderCache.removeResult(
					_finderPathCountByClassNameClassPK, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByClassNameClassPK, args);

				args = new Object[] {
					photoModelImpl.getClassName(), photoModelImpl.getClassPK()
				};

				finderCache.removeResult(
					_finderPathCountByClassNameClassPK, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByClassNameClassPK, args);
			}

			if ((photoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByClassName.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					photoModelImpl.getOriginalClassName()
				};

				finderCache.removeResult(_finderPathCountByClassName, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByClassName, args);

				args = new Object[] {photoModelImpl.getClassName()};

				finderCache.removeResult(_finderPathCountByClassName, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByClassName, args);
			}

			if ((photoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByClassPK.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					photoModelImpl.getOriginalClassPK()
				};

				finderCache.removeResult(_finderPathCountByClassPK, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByClassPK, args);

				args = new Object[] {photoModelImpl.getClassPK()};

				finderCache.removeResult(_finderPathCountByClassPK, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByClassPK, args);
			}

			if ((photoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByImageTypeClassPK.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					photoModelImpl.getOriginalImageType(),
					photoModelImpl.getOriginalClassPK()
				};

				finderCache.removeResult(
					_finderPathCountByImageTypeClassPK, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByImageTypeClassPK, args);

				args = new Object[] {
					photoModelImpl.getImageType(), photoModelImpl.getClassPK()
				};

				finderCache.removeResult(
					_finderPathCountByImageTypeClassPK, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByImageTypeClassPK, args);
			}
		}

		entityCache.putResult(
			PhotoModelImpl.ENTITY_CACHE_ENABLED, PhotoImpl.class,
			photo.getPrimaryKey(), photo, false);

		photo.resetOriginalValues();

		return photo;
	}

	/**
	 * Returns the photo with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the photo
	 * @return the photo
	 * @throws NoSuchPhotoException if a photo with the primary key could not be found
	 */
	@Override
	public Photo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPhotoException {

		Photo photo = fetchByPrimaryKey(primaryKey);

		if (photo == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPhotoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return photo;
	}

	/**
	 * Returns the photo with the primary key or throws a <code>NoSuchPhotoException</code> if it could not be found.
	 *
	 * @param imageId the primary key of the photo
	 * @return the photo
	 * @throws NoSuchPhotoException if a photo with the primary key could not be found
	 */
	@Override
	public Photo findByPrimaryKey(long imageId) throws NoSuchPhotoException {
		return findByPrimaryKey((Serializable)imageId);
	}

	/**
	 * Returns the photo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the photo
	 * @return the photo, or <code>null</code> if a photo with the primary key could not be found
	 */
	@Override
	public Photo fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			PhotoModelImpl.ENTITY_CACHE_ENABLED, PhotoImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Photo photo = (Photo)serializable;

		if (photo == null) {
			Session session = null;

			try {
				session = openSession();

				photo = (Photo)session.get(PhotoImpl.class, primaryKey);

				if (photo != null) {
					cacheResult(photo);
				}
				else {
					entityCache.putResult(
						PhotoModelImpl.ENTITY_CACHE_ENABLED, PhotoImpl.class,
						primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					PhotoModelImpl.ENTITY_CACHE_ENABLED, PhotoImpl.class,
					primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return photo;
	}

	/**
	 * Returns the photo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param imageId the primary key of the photo
	 * @return the photo, or <code>null</code> if a photo with the primary key could not be found
	 */
	@Override
	public Photo fetchByPrimaryKey(long imageId) {
		return fetchByPrimaryKey((Serializable)imageId);
	}

	@Override
	public Map<Serializable, Photo> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Photo> map = new HashMap<Serializable, Photo>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Photo photo = fetchByPrimaryKey(primaryKey);

			if (photo != null) {
				map.put(primaryKey, photo);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				PhotoModelImpl.ENTITY_CACHE_ENABLED, PhotoImpl.class,
				primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Photo)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_PHOTO_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(",");
		}

		query.setIndex(query.index() - 1);

		query.append(")");

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (Photo photo : (List<Photo>)q.list()) {
				map.put(photo.getPrimaryKeyObj(), photo);

				cacheResult(photo);

				uncachedPrimaryKeys.remove(photo.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					PhotoModelImpl.ENTITY_CACHE_ENABLED, PhotoImpl.class,
					primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the photos.
	 *
	 * @return the photos
	 */
	@Override
	public List<Photo> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Photo> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Photo> findAll(
		int start, int end, OrderByComparator<Photo> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Photo> findAll(
		int start, int end, OrderByComparator<Photo> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindAll;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Photo> list = null;

		if (retrieveFromCache) {
			list = (List<Photo>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PHOTO);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PHOTO;

				if (pagination) {
					sql = sql.concat(PhotoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Photo>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Photo>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the photos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Photo photo : findAll()) {
			remove(photo);
		}
	}

	/**
	 * Returns the number of photos.
	 *
	 * @return the number of photos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PHOTO);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PhotoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the photo persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			PhotoModelImpl.ENTITY_CACHE_ENABLED,
			PhotoModelImpl.FINDER_CACHE_ENABLED, PhotoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			PhotoModelImpl.ENTITY_CACHE_ENABLED,
			PhotoModelImpl.FINDER_CACHE_ENABLED, PhotoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			PhotoModelImpl.ENTITY_CACHE_ENABLED,
			PhotoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByClassNameClassPKImageType =
			new FinderPath(
				PhotoModelImpl.ENTITY_CACHE_ENABLED,
				PhotoModelImpl.FINDER_CACHE_ENABLED, PhotoImpl.class,
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByClassNameClassPKImageType",
				new String[] {
					String.class.getName(), Long.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				});

		_finderPathWithoutPaginationFindByClassNameClassPKImageType =
			new FinderPath(
				PhotoModelImpl.ENTITY_CACHE_ENABLED,
				PhotoModelImpl.FINDER_CACHE_ENABLED, PhotoImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByClassNameClassPKImageType",
				new String[] {
					String.class.getName(), Long.class.getName(),
					Integer.class.getName()
				},
				PhotoModelImpl.CLASSNAME_COLUMN_BITMASK |
				PhotoModelImpl.CLASSPK_COLUMN_BITMASK |
				PhotoModelImpl.IMAGETYPE_COLUMN_BITMASK);

		_finderPathCountByClassNameClassPKImageType = new FinderPath(
			PhotoModelImpl.ENTITY_CACHE_ENABLED,
			PhotoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByClassNameClassPKImageType",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});

		_finderPathWithPaginationFindByClassNameClassPK = new FinderPath(
			PhotoModelImpl.ENTITY_CACHE_ENABLED,
			PhotoModelImpl.FINDER_CACHE_ENABLED, PhotoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByClassNameClassPK",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByClassNameClassPK = new FinderPath(
			PhotoModelImpl.ENTITY_CACHE_ENABLED,
			PhotoModelImpl.FINDER_CACHE_ENABLED, PhotoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByClassNameClassPK",
			new String[] {String.class.getName(), Long.class.getName()},
			PhotoModelImpl.CLASSNAME_COLUMN_BITMASK |
			PhotoModelImpl.CLASSPK_COLUMN_BITMASK);

		_finderPathCountByClassNameClassPK = new FinderPath(
			PhotoModelImpl.ENTITY_CACHE_ENABLED,
			PhotoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByClassNameClassPK",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByClassName = new FinderPath(
			PhotoModelImpl.ENTITY_CACHE_ENABLED,
			PhotoModelImpl.FINDER_CACHE_ENABLED, PhotoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByClassName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByClassName = new FinderPath(
			PhotoModelImpl.ENTITY_CACHE_ENABLED,
			PhotoModelImpl.FINDER_CACHE_ENABLED, PhotoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByClassName",
			new String[] {String.class.getName()},
			PhotoModelImpl.CLASSNAME_COLUMN_BITMASK);

		_finderPathCountByClassName = new FinderPath(
			PhotoModelImpl.ENTITY_CACHE_ENABLED,
			PhotoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByClassName",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByClassPK = new FinderPath(
			PhotoModelImpl.ENTITY_CACHE_ENABLED,
			PhotoModelImpl.FINDER_CACHE_ENABLED, PhotoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByClassPK",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByClassPK = new FinderPath(
			PhotoModelImpl.ENTITY_CACHE_ENABLED,
			PhotoModelImpl.FINDER_CACHE_ENABLED, PhotoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByClassPK",
			new String[] {Long.class.getName()},
			PhotoModelImpl.CLASSPK_COLUMN_BITMASK);

		_finderPathCountByClassPK = new FinderPath(
			PhotoModelImpl.ENTITY_CACHE_ENABLED,
			PhotoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByClassPK",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByImageTypeClassPK = new FinderPath(
			PhotoModelImpl.ENTITY_CACHE_ENABLED,
			PhotoModelImpl.FINDER_CACHE_ENABLED, PhotoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByImageTypeClassPK",
			new String[] {
				Integer.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByImageTypeClassPK = new FinderPath(
			PhotoModelImpl.ENTITY_CACHE_ENABLED,
			PhotoModelImpl.FINDER_CACHE_ENABLED, PhotoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByImageTypeClassPK",
			new String[] {Integer.class.getName(), Long.class.getName()},
			PhotoModelImpl.IMAGETYPE_COLUMN_BITMASK |
			PhotoModelImpl.CLASSPK_COLUMN_BITMASK);

		_finderPathCountByImageTypeClassPK = new FinderPath(
			PhotoModelImpl.ENTITY_CACHE_ENABLED,
			PhotoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByImageTypeClassPK",
			new String[] {Integer.class.getName(), Long.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(PhotoImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_PHOTO =
		"SELECT photo FROM Photo photo";

	private static final String _SQL_SELECT_PHOTO_WHERE_PKS_IN =
		"SELECT photo FROM Photo photo WHERE imageId IN (";

	private static final String _SQL_SELECT_PHOTO_WHERE =
		"SELECT photo FROM Photo photo WHERE ";

	private static final String _SQL_COUNT_PHOTO =
		"SELECT COUNT(photo) FROM Photo photo";

	private static final String _SQL_COUNT_PHOTO_WHERE =
		"SELECT COUNT(photo) FROM Photo photo WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "photo.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Photo exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Photo exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PhotoPersistenceImpl.class);

}