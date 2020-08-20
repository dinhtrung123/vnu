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

package org.oep.core.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

import org.oep.core.exception.NoSuchMailException;
import org.oep.core.model.Mail;

/**
 * The persistence interface for the mail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author manhlb
 * @see MailUtil
 * @generated
 */
@ProviderType
public interface MailPersistence extends BasePersistence<Mail> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MailUtil} to access the mail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, Mail> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Caches the mail in the entity cache if it is enabled.
	 *
	 * @param mail the mail
	 */
	public void cacheResult(Mail mail);

	/**
	 * Caches the mails in the entity cache if it is enabled.
	 *
	 * @param mails the mails
	 */
	public void cacheResult(java.util.List<Mail> mails);

	/**
	 * Creates a new mail with the primary key. Does not add the mail to the database.
	 *
	 * @param id the primary key for the new mail
	 * @return the new mail
	 */
	public Mail create(long id);

	/**
	 * Removes the mail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the mail
	 * @return the mail that was removed
	 * @throws NoSuchMailException if a mail with the primary key could not be found
	 */
	public Mail remove(long id) throws NoSuchMailException;

	public Mail updateImpl(Mail mail);

	/**
	 * Returns the mail with the primary key or throws a <code>NoSuchMailException</code> if it could not be found.
	 *
	 * @param id the primary key of the mail
	 * @return the mail
	 * @throws NoSuchMailException if a mail with the primary key could not be found
	 */
	public Mail findByPrimaryKey(long id) throws NoSuchMailException;

	/**
	 * Returns the mail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the mail
	 * @return the mail, or <code>null</code> if a mail with the primary key could not be found
	 */
	public Mail fetchByPrimaryKey(long id);

	/**
	 * Returns all the mails.
	 *
	 * @return the mails
	 */
	public java.util.List<Mail> findAll();

	/**
	 * Returns a range of all the mails.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of mails
	 * @param end the upper bound of the range of mails (not inclusive)
	 * @return the range of mails
	 */
	public java.util.List<Mail> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the mails.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of mails
	 * @param end the upper bound of the range of mails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of mails
	 */
	public java.util.List<Mail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Mail>
			orderByComparator);

	/**
	 * Returns an ordered range of all the mails.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of mails
	 * @param end the upper bound of the range of mails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of mails
	 */
	public java.util.List<Mail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Mail>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the mails from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of mails.
	 *
	 * @return the number of mails
	 */
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();

}