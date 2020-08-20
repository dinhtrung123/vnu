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

package dtt.vn.user.service.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import dtt.vn.user.service.exception.NoSuchDataImportException;
import dtt.vn.user.service.model.DataImport;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the data import service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nhanvienDTT
 * @see DataImportUtil
 * @generated
 */
@ProviderType
public interface DataImportPersistence extends BasePersistence<DataImport> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DataImportUtil} to access the data import persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, DataImport> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the data imports where hasImport = &#63;.
	 *
	 * @param hasImport the has import
	 * @return the matching data imports
	 */
	public java.util.List<DataImport> findByI(String hasImport);

	/**
	 * Returns a range of all the data imports where hasImport = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataImportModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param hasImport the has import
	 * @param start the lower bound of the range of data imports
	 * @param end the upper bound of the range of data imports (not inclusive)
	 * @return the range of matching data imports
	 */
	public java.util.List<DataImport> findByI(
		String hasImport, int start, int end);

	/**
	 * Returns an ordered range of all the data imports where hasImport = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataImportModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param hasImport the has import
	 * @param start the lower bound of the range of data imports
	 * @param end the upper bound of the range of data imports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data imports
	 */
	public java.util.List<DataImport> findByI(
		String hasImport, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataImport>
			orderByComparator);

	/**
	 * Returns an ordered range of all the data imports where hasImport = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataImportModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param hasImport the has import
	 * @param start the lower bound of the range of data imports
	 * @param end the upper bound of the range of data imports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching data imports
	 */
	public java.util.List<DataImport> findByI(
		String hasImport, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataImport>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first data import in the ordered set where hasImport = &#63;.
	 *
	 * @param hasImport the has import
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data import
	 * @throws NoSuchDataImportException if a matching data import could not be found
	 */
	public DataImport findByI_First(
			String hasImport,
			com.liferay.portal.kernel.util.OrderByComparator<DataImport>
				orderByComparator)
		throws NoSuchDataImportException;

	/**
	 * Returns the first data import in the ordered set where hasImport = &#63;.
	 *
	 * @param hasImport the has import
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data import, or <code>null</code> if a matching data import could not be found
	 */
	public DataImport fetchByI_First(
		String hasImport,
		com.liferay.portal.kernel.util.OrderByComparator<DataImport>
			orderByComparator);

	/**
	 * Returns the last data import in the ordered set where hasImport = &#63;.
	 *
	 * @param hasImport the has import
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data import
	 * @throws NoSuchDataImportException if a matching data import could not be found
	 */
	public DataImport findByI_Last(
			String hasImport,
			com.liferay.portal.kernel.util.OrderByComparator<DataImport>
				orderByComparator)
		throws NoSuchDataImportException;

	/**
	 * Returns the last data import in the ordered set where hasImport = &#63;.
	 *
	 * @param hasImport the has import
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data import, or <code>null</code> if a matching data import could not be found
	 */
	public DataImport fetchByI_Last(
		String hasImport,
		com.liferay.portal.kernel.util.OrderByComparator<DataImport>
			orderByComparator);

	/**
	 * Returns the data imports before and after the current data import in the ordered set where hasImport = &#63;.
	 *
	 * @param id the primary key of the current data import
	 * @param hasImport the has import
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data import
	 * @throws NoSuchDataImportException if a data import with the primary key could not be found
	 */
	public DataImport[] findByI_PrevAndNext(
			long id, String hasImport,
			com.liferay.portal.kernel.util.OrderByComparator<DataImport>
				orderByComparator)
		throws NoSuchDataImportException;

	/**
	 * Removes all the data imports where hasImport = &#63; from the database.
	 *
	 * @param hasImport the has import
	 */
	public void removeByI(String hasImport);

	/**
	 * Returns the number of data imports where hasImport = &#63;.
	 *
	 * @param hasImport the has import
	 * @return the number of matching data imports
	 */
	public int countByI(String hasImport);

	/**
	 * Returns all the data imports where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @return the matching data imports
	 */
	public java.util.List<DataImport> findByScreenName(String screenName);

	/**
	 * Returns a range of all the data imports where screenName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataImportModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param screenName the screen name
	 * @param start the lower bound of the range of data imports
	 * @param end the upper bound of the range of data imports (not inclusive)
	 * @return the range of matching data imports
	 */
	public java.util.List<DataImport> findByScreenName(
		String screenName, int start, int end);

	/**
	 * Returns an ordered range of all the data imports where screenName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataImportModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param screenName the screen name
	 * @param start the lower bound of the range of data imports
	 * @param end the upper bound of the range of data imports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data imports
	 */
	public java.util.List<DataImport> findByScreenName(
		String screenName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataImport>
			orderByComparator);

	/**
	 * Returns an ordered range of all the data imports where screenName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataImportModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param screenName the screen name
	 * @param start the lower bound of the range of data imports
	 * @param end the upper bound of the range of data imports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching data imports
	 */
	public java.util.List<DataImport> findByScreenName(
		String screenName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataImport>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first data import in the ordered set where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data import
	 * @throws NoSuchDataImportException if a matching data import could not be found
	 */
	public DataImport findByScreenName_First(
			String screenName,
			com.liferay.portal.kernel.util.OrderByComparator<DataImport>
				orderByComparator)
		throws NoSuchDataImportException;

	/**
	 * Returns the first data import in the ordered set where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data import, or <code>null</code> if a matching data import could not be found
	 */
	public DataImport fetchByScreenName_First(
		String screenName,
		com.liferay.portal.kernel.util.OrderByComparator<DataImport>
			orderByComparator);

	/**
	 * Returns the last data import in the ordered set where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data import
	 * @throws NoSuchDataImportException if a matching data import could not be found
	 */
	public DataImport findByScreenName_Last(
			String screenName,
			com.liferay.portal.kernel.util.OrderByComparator<DataImport>
				orderByComparator)
		throws NoSuchDataImportException;

	/**
	 * Returns the last data import in the ordered set where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data import, or <code>null</code> if a matching data import could not be found
	 */
	public DataImport fetchByScreenName_Last(
		String screenName,
		com.liferay.portal.kernel.util.OrderByComparator<DataImport>
			orderByComparator);

	/**
	 * Returns the data imports before and after the current data import in the ordered set where screenName = &#63;.
	 *
	 * @param id the primary key of the current data import
	 * @param screenName the screen name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data import
	 * @throws NoSuchDataImportException if a data import with the primary key could not be found
	 */
	public DataImport[] findByScreenName_PrevAndNext(
			long id, String screenName,
			com.liferay.portal.kernel.util.OrderByComparator<DataImport>
				orderByComparator)
		throws NoSuchDataImportException;

	/**
	 * Removes all the data imports where screenName = &#63; from the database.
	 *
	 * @param screenName the screen name
	 */
	public void removeByScreenName(String screenName);

	/**
	 * Returns the number of data imports where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @return the number of matching data imports
	 */
	public int countByScreenName(String screenName);

	/**
	 * Returns all the data imports where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @return the matching data imports
	 */
	public java.util.List<DataImport> findByLastName(String lastName);

	/**
	 * Returns a range of all the data imports where lastName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataImportModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lastName the last name
	 * @param start the lower bound of the range of data imports
	 * @param end the upper bound of the range of data imports (not inclusive)
	 * @return the range of matching data imports
	 */
	public java.util.List<DataImport> findByLastName(
		String lastName, int start, int end);

	/**
	 * Returns an ordered range of all the data imports where lastName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataImportModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lastName the last name
	 * @param start the lower bound of the range of data imports
	 * @param end the upper bound of the range of data imports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data imports
	 */
	public java.util.List<DataImport> findByLastName(
		String lastName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataImport>
			orderByComparator);

	/**
	 * Returns an ordered range of all the data imports where lastName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataImportModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lastName the last name
	 * @param start the lower bound of the range of data imports
	 * @param end the upper bound of the range of data imports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching data imports
	 */
	public java.util.List<DataImport> findByLastName(
		String lastName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataImport>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first data import in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data import
	 * @throws NoSuchDataImportException if a matching data import could not be found
	 */
	public DataImport findByLastName_First(
			String lastName,
			com.liferay.portal.kernel.util.OrderByComparator<DataImport>
				orderByComparator)
		throws NoSuchDataImportException;

	/**
	 * Returns the first data import in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data import, or <code>null</code> if a matching data import could not be found
	 */
	public DataImport fetchByLastName_First(
		String lastName,
		com.liferay.portal.kernel.util.OrderByComparator<DataImport>
			orderByComparator);

	/**
	 * Returns the last data import in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data import
	 * @throws NoSuchDataImportException if a matching data import could not be found
	 */
	public DataImport findByLastName_Last(
			String lastName,
			com.liferay.portal.kernel.util.OrderByComparator<DataImport>
				orderByComparator)
		throws NoSuchDataImportException;

	/**
	 * Returns the last data import in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data import, or <code>null</code> if a matching data import could not be found
	 */
	public DataImport fetchByLastName_Last(
		String lastName,
		com.liferay.portal.kernel.util.OrderByComparator<DataImport>
			orderByComparator);

	/**
	 * Returns the data imports before and after the current data import in the ordered set where lastName = &#63;.
	 *
	 * @param id the primary key of the current data import
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data import
	 * @throws NoSuchDataImportException if a data import with the primary key could not be found
	 */
	public DataImport[] findByLastName_PrevAndNext(
			long id, String lastName,
			com.liferay.portal.kernel.util.OrderByComparator<DataImport>
				orderByComparator)
		throws NoSuchDataImportException;

	/**
	 * Removes all the data imports where lastName = &#63; from the database.
	 *
	 * @param lastName the last name
	 */
	public void removeByLastName(String lastName);

	/**
	 * Returns the number of data imports where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @return the number of matching data imports
	 */
	public int countByLastName(String lastName);

	/**
	 * Returns all the data imports where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @return the matching data imports
	 */
	public java.util.List<DataImport> findByEmailAddress(String emailAddress);

	/**
	 * Returns a range of all the data imports where emailAddress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataImportModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param emailAddress the email address
	 * @param start the lower bound of the range of data imports
	 * @param end the upper bound of the range of data imports (not inclusive)
	 * @return the range of matching data imports
	 */
	public java.util.List<DataImport> findByEmailAddress(
		String emailAddress, int start, int end);

	/**
	 * Returns an ordered range of all the data imports where emailAddress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataImportModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param emailAddress the email address
	 * @param start the lower bound of the range of data imports
	 * @param end the upper bound of the range of data imports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data imports
	 */
	public java.util.List<DataImport> findByEmailAddress(
		String emailAddress, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataImport>
			orderByComparator);

	/**
	 * Returns an ordered range of all the data imports where emailAddress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataImportModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param emailAddress the email address
	 * @param start the lower bound of the range of data imports
	 * @param end the upper bound of the range of data imports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching data imports
	 */
	public java.util.List<DataImport> findByEmailAddress(
		String emailAddress, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataImport>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first data import in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data import
	 * @throws NoSuchDataImportException if a matching data import could not be found
	 */
	public DataImport findByEmailAddress_First(
			String emailAddress,
			com.liferay.portal.kernel.util.OrderByComparator<DataImport>
				orderByComparator)
		throws NoSuchDataImportException;

	/**
	 * Returns the first data import in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data import, or <code>null</code> if a matching data import could not be found
	 */
	public DataImport fetchByEmailAddress_First(
		String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator<DataImport>
			orderByComparator);

	/**
	 * Returns the last data import in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data import
	 * @throws NoSuchDataImportException if a matching data import could not be found
	 */
	public DataImport findByEmailAddress_Last(
			String emailAddress,
			com.liferay.portal.kernel.util.OrderByComparator<DataImport>
				orderByComparator)
		throws NoSuchDataImportException;

	/**
	 * Returns the last data import in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data import, or <code>null</code> if a matching data import could not be found
	 */
	public DataImport fetchByEmailAddress_Last(
		String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator<DataImport>
			orderByComparator);

	/**
	 * Returns the data imports before and after the current data import in the ordered set where emailAddress = &#63;.
	 *
	 * @param id the primary key of the current data import
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data import
	 * @throws NoSuchDataImportException if a data import with the primary key could not be found
	 */
	public DataImport[] findByEmailAddress_PrevAndNext(
			long id, String emailAddress,
			com.liferay.portal.kernel.util.OrderByComparator<DataImport>
				orderByComparator)
		throws NoSuchDataImportException;

	/**
	 * Removes all the data imports where emailAddress = &#63; from the database.
	 *
	 * @param emailAddress the email address
	 */
	public void removeByEmailAddress(String emailAddress);

	/**
	 * Returns the number of data imports where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @return the number of matching data imports
	 */
	public int countByEmailAddress(String emailAddress);

	/**
	 * Returns all the data imports where phone = &#63;.
	 *
	 * @param phone the phone
	 * @return the matching data imports
	 */
	public java.util.List<DataImport> findByPhone(String phone);

	/**
	 * Returns a range of all the data imports where phone = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataImportModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param phone the phone
	 * @param start the lower bound of the range of data imports
	 * @param end the upper bound of the range of data imports (not inclusive)
	 * @return the range of matching data imports
	 */
	public java.util.List<DataImport> findByPhone(
		String phone, int start, int end);

	/**
	 * Returns an ordered range of all the data imports where phone = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataImportModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param phone the phone
	 * @param start the lower bound of the range of data imports
	 * @param end the upper bound of the range of data imports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data imports
	 */
	public java.util.List<DataImport> findByPhone(
		String phone, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataImport>
			orderByComparator);

	/**
	 * Returns an ordered range of all the data imports where phone = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataImportModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param phone the phone
	 * @param start the lower bound of the range of data imports
	 * @param end the upper bound of the range of data imports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching data imports
	 */
	public java.util.List<DataImport> findByPhone(
		String phone, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataImport>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first data import in the ordered set where phone = &#63;.
	 *
	 * @param phone the phone
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data import
	 * @throws NoSuchDataImportException if a matching data import could not be found
	 */
	public DataImport findByPhone_First(
			String phone,
			com.liferay.portal.kernel.util.OrderByComparator<DataImport>
				orderByComparator)
		throws NoSuchDataImportException;

	/**
	 * Returns the first data import in the ordered set where phone = &#63;.
	 *
	 * @param phone the phone
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data import, or <code>null</code> if a matching data import could not be found
	 */
	public DataImport fetchByPhone_First(
		String phone,
		com.liferay.portal.kernel.util.OrderByComparator<DataImport>
			orderByComparator);

	/**
	 * Returns the last data import in the ordered set where phone = &#63;.
	 *
	 * @param phone the phone
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data import
	 * @throws NoSuchDataImportException if a matching data import could not be found
	 */
	public DataImport findByPhone_Last(
			String phone,
			com.liferay.portal.kernel.util.OrderByComparator<DataImport>
				orderByComparator)
		throws NoSuchDataImportException;

	/**
	 * Returns the last data import in the ordered set where phone = &#63;.
	 *
	 * @param phone the phone
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data import, or <code>null</code> if a matching data import could not be found
	 */
	public DataImport fetchByPhone_Last(
		String phone,
		com.liferay.portal.kernel.util.OrderByComparator<DataImport>
			orderByComparator);

	/**
	 * Returns the data imports before and after the current data import in the ordered set where phone = &#63;.
	 *
	 * @param id the primary key of the current data import
	 * @param phone the phone
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data import
	 * @throws NoSuchDataImportException if a data import with the primary key could not be found
	 */
	public DataImport[] findByPhone_PrevAndNext(
			long id, String phone,
			com.liferay.portal.kernel.util.OrderByComparator<DataImport>
				orderByComparator)
		throws NoSuchDataImportException;

	/**
	 * Removes all the data imports where phone = &#63; from the database.
	 *
	 * @param phone the phone
	 */
	public void removeByPhone(String phone);

	/**
	 * Returns the number of data imports where phone = &#63;.
	 *
	 * @param phone the phone
	 * @return the number of matching data imports
	 */
	public int countByPhone(String phone);

	/**
	 * Caches the data import in the entity cache if it is enabled.
	 *
	 * @param dataImport the data import
	 */
	public void cacheResult(DataImport dataImport);

	/**
	 * Caches the data imports in the entity cache if it is enabled.
	 *
	 * @param dataImports the data imports
	 */
	public void cacheResult(java.util.List<DataImport> dataImports);

	/**
	 * Creates a new data import with the primary key. Does not add the data import to the database.
	 *
	 * @param id the primary key for the new data import
	 * @return the new data import
	 */
	public DataImport create(long id);

	/**
	 * Removes the data import with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the data import
	 * @return the data import that was removed
	 * @throws NoSuchDataImportException if a data import with the primary key could not be found
	 */
	public DataImport remove(long id) throws NoSuchDataImportException;

	public DataImport updateImpl(DataImport dataImport);

	/**
	 * Returns the data import with the primary key or throws a <code>NoSuchDataImportException</code> if it could not be found.
	 *
	 * @param id the primary key of the data import
	 * @return the data import
	 * @throws NoSuchDataImportException if a data import with the primary key could not be found
	 */
	public DataImport findByPrimaryKey(long id)
		throws NoSuchDataImportException;

	/**
	 * Returns the data import with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the data import
	 * @return the data import, or <code>null</code> if a data import with the primary key could not be found
	 */
	public DataImport fetchByPrimaryKey(long id);

	/**
	 * Returns all the data imports.
	 *
	 * @return the data imports
	 */
	public java.util.List<DataImport> findAll();

	/**
	 * Returns a range of all the data imports.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataImportModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of data imports
	 * @param end the upper bound of the range of data imports (not inclusive)
	 * @return the range of data imports
	 */
	public java.util.List<DataImport> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the data imports.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataImportModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of data imports
	 * @param end the upper bound of the range of data imports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of data imports
	 */
	public java.util.List<DataImport> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataImport>
			orderByComparator);

	/**
	 * Returns an ordered range of all the data imports.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DataImportModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of data imports
	 * @param end the upper bound of the range of data imports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of data imports
	 */
	public java.util.List<DataImport> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataImport>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the data imports from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of data imports.
	 *
	 * @return the number of data imports
	 */
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();

}