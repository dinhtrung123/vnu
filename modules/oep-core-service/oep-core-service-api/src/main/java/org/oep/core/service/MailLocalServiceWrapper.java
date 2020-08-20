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
 * Provides a wrapper for {@link MailLocalService}.
 *
 * @author manhlb
 * @see MailLocalService
 * @generated
 */
@ProviderType
public class MailLocalServiceWrapper
	implements MailLocalService, ServiceWrapper<MailLocalService> {

	public MailLocalServiceWrapper(MailLocalService mailLocalService) {
		_mailLocalService = mailLocalService;
	}

	/**
	 * Adds the mail to the database. Also notifies the appropriate model listeners.
	 *
	 * @param mail the mail
	 * @return the mail that was added
	 */
	@Override
	public org.oep.core.model.Mail addMail(org.oep.core.model.Mail mail) {
		return _mailLocalService.addMail(mail);
	}

	/**
	 * Creates a new mail with the primary key. Does not add the mail to the database.
	 *
	 * @param id the primary key for the new mail
	 * @return the new mail
	 */
	@Override
	public org.oep.core.model.Mail createMail(long id) {
		return _mailLocalService.createMail(id);
	}

	/**
	 * Deletes the mail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the mail
	 * @return the mail that was removed
	 * @throws PortalException if a mail with the primary key could not be found
	 */
	@Override
	public org.oep.core.model.Mail deleteMail(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mailLocalService.deleteMail(id);
	}

	/**
	 * Deletes the mail from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mail the mail
	 * @return the mail that was removed
	 */
	@Override
	public org.oep.core.model.Mail deleteMail(org.oep.core.model.Mail mail) {
		return _mailLocalService.deleteMail(mail);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mailLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _mailLocalService.dynamicQuery();
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

		return _mailLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>org.oep.core.model.impl.MailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _mailLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>org.oep.core.model.impl.MailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _mailLocalService.dynamicQuery(
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

		return _mailLocalService.dynamicQueryCount(dynamicQuery);
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

		return _mailLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public org.oep.core.model.Mail fetchMail(long id) {
		return _mailLocalService.fetchMail(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _mailLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _mailLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the mail with the primary key.
	 *
	 * @param id the primary key of the mail
	 * @return the mail
	 * @throws PortalException if a mail with the primary key could not be found
	 */
	@Override
	public org.oep.core.model.Mail getMail(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mailLocalService.getMail(id);
	}

	/**
	 * Returns a range of all the mails.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>org.oep.core.model.impl.MailModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of mails
	 * @param end the upper bound of the range of mails (not inclusive)
	 * @return the range of mails
	 */
	@Override
	public java.util.List<org.oep.core.model.Mail> getMails(
		int start, int end) {

		return _mailLocalService.getMails(start, end);
	}

	/**
	 * Returns the number of mails.
	 *
	 * @return the number of mails
	 */
	@Override
	public int getMailsCount() {
		return _mailLocalService.getMailsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _mailLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mailLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public boolean send(
		long groupId, String action, String fromAddress, String toAddress,
		String subject, String body) {

		return _mailLocalService.send(
			groupId, action, fromAddress, toAddress, subject, body);
	}

	@Override
	public boolean send(
		long groupId, String action, String fromAddress, String[] toAddress,
		String subject, String body) {

		return _mailLocalService.send(
			groupId, action, fromAddress, toAddress, subject, body);
	}

	@Override
	public boolean send(String toAddress, String subject, String body) {
		return _mailLocalService.send(toAddress, subject, body);
	}

	@Override
	public boolean send(String[] toAddress, String subject, String body) {
		return _mailLocalService.send(toAddress, subject, body);
	}

	/**
	 * Updates the mail in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param mail the mail
	 * @return the mail that was updated
	 */
	@Override
	public org.oep.core.model.Mail updateMail(org.oep.core.model.Mail mail) {
		return _mailLocalService.updateMail(mail);
	}

	@Override
	public MailLocalService getWrappedService() {
		return _mailLocalService;
	}

	@Override
	public void setWrappedService(MailLocalService mailLocalService) {
		_mailLocalService = mailLocalService;
	}

	private MailLocalService _mailLocalService;

}