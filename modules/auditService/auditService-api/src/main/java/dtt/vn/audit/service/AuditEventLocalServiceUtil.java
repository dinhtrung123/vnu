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

package dtt.vn.audit.service;

import aQute.bnd.annotation.ProviderType;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for AuditEvent. This utility wraps
 * <code>dtt.vn.audit.service.impl.AuditEventLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AuditEventLocalService
 * @generated
 */
@ProviderType
public class AuditEventLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>dtt.vn.audit.service.impl.AuditEventLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the audit event to the database. Also notifies the appropriate model listeners.
	 *
	 * @param auditEvent the audit event
	 * @return the audit event that was added
	 */
	public static dtt.vn.audit.model.AuditEvent addAuditEvent(
		dtt.vn.audit.model.AuditEvent auditEvent) {

		return getService().addAuditEvent(auditEvent);
	}

	public static dtt.vn.audit.model.AuditEvent addAuditEvent(
			com.liferay.portal.kernel.audit.AuditMessage auditMessage)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().addAuditEvent(auditMessage);
	}

	public static dtt.vn.audit.model.AuditEvent addAuditEvent(
			long companyId, long userId, String userName, String eventType,
			String className, String classPk, String message, String clientHost,
			String clientIP, String serverName, int serverPort,
			String sessionID, String additionalInfo)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().addAuditEvent(
			companyId, userId, userName, eventType, className, classPk, message,
			clientHost, clientIP, serverName, serverPort, sessionID,
			additionalInfo);
	}

	public static int countcustom(
		String keyword, String tungay, String denngay, String fullname) {

		return getService().countcustom(keyword, tungay, denngay, fullname);
	}

	/**
	 * Creates a new audit event with the primary key. Does not add the audit event to the database.
	 *
	 * @param auditEventId the primary key for the new audit event
	 * @return the new audit event
	 */
	public static dtt.vn.audit.model.AuditEvent createAuditEvent(
		long auditEventId) {

		return getService().createAuditEvent(auditEventId);
	}

	/**
	 * Deletes the audit event from the database. Also notifies the appropriate model listeners.
	 *
	 * @param auditEvent the audit event
	 * @return the audit event that was removed
	 */
	public static dtt.vn.audit.model.AuditEvent deleteAuditEvent(
		dtt.vn.audit.model.AuditEvent auditEvent) {

		return getService().deleteAuditEvent(auditEvent);
	}

	/**
	 * Deletes the audit event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param auditEventId the primary key of the audit event
	 * @return the audit event that was removed
	 * @throws PortalException if a audit event with the primary key could not be found
	 */
	public static dtt.vn.audit.model.AuditEvent deleteAuditEvent(
			long auditEventId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteAuditEvent(auditEventId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>dtt.vn.audit.model.impl.AuditEventModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>dtt.vn.audit.model.impl.AuditEventModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static dtt.vn.audit.model.AuditEvent fetchAuditEvent(
		long auditEventId) {

		return getService().fetchAuditEvent(auditEventId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the audit event with the primary key.
	 *
	 * @param auditEventId the primary key of the audit event
	 * @return the audit event
	 * @throws PortalException if a audit event with the primary key could not be found
	 */
	public static dtt.vn.audit.model.AuditEvent getAuditEvent(long auditEventId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getAuditEvent(auditEventId);
	}

	/**
	 * Returns a range of all the audit events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>dtt.vn.audit.model.impl.AuditEventModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of audit events
	 * @param end the upper bound of the range of audit events (not inclusive)
	 * @return the range of audit events
	 */
	public static java.util.List<dtt.vn.audit.model.AuditEvent> getAuditEvents(
		int start, int end) {

		return getService().getAuditEvents(start, end);
	}

	public static java.util.List<dtt.vn.audit.model.AuditEvent> getAuditEvents(
			long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getAuditEvents(
			companyId, start, end, orderByComparator);
	}

	public static java.util.List<dtt.vn.audit.model.AuditEvent> getAuditEvents(
			long companyId, long userId, String userName,
			java.util.Date createDateGT, java.util.Date createDateLT,
			String eventType, String className, String classPK,
			String clientHost, String clientIP, String serverName,
			int serverPort, String sessionID, boolean andSearch, int start,
			int end,
			com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getAuditEvents(
			companyId, userId, userName, createDateGT, createDateLT, eventType,
			className, classPK, clientHost, clientIP, serverName, serverPort,
			sessionID, andSearch, start, end, orderByComparator);
	}

	/**
	 * Returns the number of audit events.
	 *
	 * @return the number of audit events
	 */
	public static int getAuditEventsCount() {
		return getService().getAuditEventsCount();
	}

	public static int getAuditEventsCount(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getAuditEventsCount(companyId);
	}

	public static int getAuditEventsCount(
			long companyId, long userId, String userName,
			java.util.Date createDateGT, java.util.Date createDateLT,
			String eventType, String className, String classPK,
			String clientHost, String clientIP, String serverName,
			int serverPort, String sessionID, boolean andSearch)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getAuditEventsCount(
			companyId, userId, userName, createDateGT, createDateLT, eventType,
			className, classPK, clientHost, clientIP, serverName, serverPort,
			sessionID, andSearch);
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

	public static Object getReportList(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getReportList(start, end);
	}

	public static java.util.List<dtt.vn.audit.model.AuditEvent> searchcustom(
		String keyword, String tungay, String denngay, int start, int end,
		String fullname) {

		return getService().searchcustom(
			keyword, tungay, denngay, start, end, fullname);
	}

	/**
	 * Updates the audit event in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param auditEvent the audit event
	 * @return the audit event that was updated
	 */
	public static dtt.vn.audit.model.AuditEvent updateAuditEvent(
		dtt.vn.audit.model.AuditEvent auditEvent) {

		return getService().updateAuditEvent(auditEvent);
	}

	public static AuditEventLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<AuditEventLocalService, AuditEventLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AuditEventLocalService.class);

		ServiceTracker<AuditEventLocalService, AuditEventLocalService>
			serviceTracker =
				new ServiceTracker
					<AuditEventLocalService, AuditEventLocalService>(
						bundle.getBundleContext(), AuditEventLocalService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}