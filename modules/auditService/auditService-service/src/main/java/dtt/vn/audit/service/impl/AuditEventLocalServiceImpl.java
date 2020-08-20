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

package dtt.vn.audit.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.audit.AuditMessage;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Junction;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

import dtt.vn.audit.model.AuditEvent;
import dtt.vn.audit.service.base.AuditEventLocalServiceBaseImpl;

/**
 * The implementation of the audit event local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>dtt.vn.audit.service.AuditEventLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AuditEventLocalServiceBaseImpl
 */
public class AuditEventLocalServiceImpl extends AuditEventLocalServiceBaseImpl {
	public AuditEvent addAuditEvent(long companyId, long userId, String userName, String eventType, String className,
	        String classPk, String message, String clientHost, String clientIP, String serverName, int serverPort, String sessionID, String additionalInfo) throws SystemException {
	        long auditEventId = counterLocalService.increment(AuditEvent.class.getName());

	        AuditEvent auditEvent = auditEventPersistence.create(auditEventId);

	        auditEvent.setCompanyId(companyId);
	        auditEvent.setUserId(userId);
	        auditEvent.setUserName(userName);
	        auditEvent.setCreateDate(new Date());
	        auditEvent.setEventType(eventType);
	        auditEvent.setClassName(className);
	        auditEvent.setClassPK(classPk);
	        auditEvent.setMessage(message);
	        auditEvent.setClientHost(clientHost);
	        auditEvent.setClientIP(clientIP);
	        auditEvent.setServerName(serverName);
	        auditEvent.setServerPort(serverPort);
	        auditEvent.setSessionID(sessionID);

	        auditEvent.setAdditionalInfo(additionalInfo);

	        auditEvent = updateAuditEvent(auditEvent);
	        //auditEventPersistence.update(auditEvent, false);

	        return auditEvent;

	    }
	    public AuditEvent addAuditEvent(AuditMessage auditMessage)
	    throws SystemException {

	        long auditEventId = counterLocalService.increment();

	        AuditEvent auditEvent = auditEventPersistence.create(auditEventId);

	        auditEvent.setCompanyId(auditMessage.getCompanyId());
	        auditEvent.setUserId(auditMessage.getUserId());
	        auditEvent.setUserName(auditMessage.getUserName());
	        auditEvent.setCreateDate(auditMessage.getTimestamp());
	        auditEvent.setEventType(auditMessage.getEventType());
	        auditEvent.setClassName(auditMessage.getClassName());
	        auditEvent.setClassPK(auditMessage.getClassPK());
	        auditEvent.setMessage(auditMessage.getMessage());
	        auditEvent.setClientHost(auditMessage.getClientHost());
	        auditEvent.setClientIP(auditMessage.getClientIP());
	        auditEvent.setServerName(auditMessage.getServerName());
	        auditEvent.setServerPort(auditMessage.getServerPort());
	        auditEvent.setSessionID(auditMessage.getSessionID());
	        auditEvent.setServerPort(auditMessage.getServerPort());
	        auditEvent.setAdditionalInfo(
	            String.valueOf(auditMessage.getAdditionalInfo()));

	        auditEventPersistence.update(auditEvent);

	        return auditEvent;
	    }

	    public List < AuditEvent > getAuditEvents(
	        long companyId, int start, int end,
	        OrderByComparator orderByComparator)
	    throws SystemException {

	        return auditEventPersistence.findByCompanyId(
	            companyId, start, end, orderByComparator);
	    }

	    public List < AuditEvent > getAuditEvents(
	        long companyId, long userId, String userName, Date createDateGT,
	        Date createDateLT, String eventType, String className,
	        String classPK, String clientHost, String clientIP,
	        String serverName, int serverPort, String sessionID,
	        boolean andSearch, int start, int end,
	        OrderByComparator orderByComparator)
	    throws SystemException {

	        DynamicQuery dynamicQuery = buildDynamicQuery(
	            companyId, userId, userName, createDateGT, createDateLT, eventType,
	            className, classPK, clientHost, clientIP, serverName, serverPort,
	            sessionID, andSearch);

	        return dynamicQuery(dynamicQuery, start, end, orderByComparator);
	    }

	    public int getAuditEventsCount(long companyId) throws SystemException {
	        return auditEventPersistence.countByCompanyId(companyId);
	    }

	    public int getAuditEventsCount(
	        long companyId, long userId, String userName, Date createDateGT,
	        Date createDateLT, String eventType, String className,
	        String classPK, String clientHost, String clientIP,
	        String serverName, int serverPort, String sessionID,
	        boolean andSearch)
	    throws SystemException {

	        DynamicQuery dynamicQuery = buildDynamicQuery(
	            companyId, userId, userName, createDateGT, createDateLT, eventType,
	            className, classPK, clientHost, clientIP, serverName, serverPort,
	            sessionID, andSearch);

	        return (int) dynamicQueryCount(dynamicQuery);
	    }

	    public Object getReportList(final int start, final int end) throws SystemException {
	       return auditEventFinder.getReportList(start, end);
	    }

	    protected DynamicQuery buildDynamicQuery(
	        long companyId, long userId, String userName, Date createDateGT,
	        Date createDateLT, String eventType, String className, String classPK,
	        String clientHost, String clientIP, String serverName, int serverPort,
	        String sessionID, boolean andSearch) {

	        Junction junction = null;

	        if (andSearch) {
	            junction = RestrictionsFactoryUtil.conjunction();
	        } else {
	            junction = RestrictionsFactoryUtil.disjunction();
	        }

	        if (userId > 0) {
	            Property property = PropertyFactoryUtil.forName("userId");

	            junction.add(property.eq(userId));
	        }

	        if (Validator.isNotNull(userName)) {
	            Property property = PropertyFactoryUtil.forName("userName");

	            String value = StringPool.PERCENT + userName + StringPool.PERCENT;

	            junction.add(property.like(value));
	        }

	        if (Validator.isNotNull(eventType)) {
	            Property property = PropertyFactoryUtil.forName("eventType");

	            String value = StringPool.PERCENT + eventType + StringPool.PERCENT;

	            junction.add(property.like(value));
	        }

	        if (Validator.isNotNull(className)) {
	            Property property = PropertyFactoryUtil.forName("className");

	            String value = StringPool.PERCENT + className + StringPool.PERCENT;

	            junction.add(property.like(value));
	        }

	        if (Validator.isNotNull(classPK)) {
	            Property property = PropertyFactoryUtil.forName("classPK");

	            junction.add(property.eq(classPK));
	        }

	        if (Validator.isNotNull(clientHost)) {
	            Property property = PropertyFactoryUtil.forName("clientHost");

	            String value = StringPool.PERCENT + clientHost + StringPool.PERCENT;

	            junction.add(property.like(value));
	        }

	        if (Validator.isNotNull(clientIP)) {
	            Property property = PropertyFactoryUtil.forName("clientIP");

	            String value = StringPool.PERCENT + clientIP + StringPool.PERCENT;

	            junction.add(property.like(value));
	        }

	        if (Validator.isNotNull(serverName)) {
	            Property property = PropertyFactoryUtil.forName("serverName");

	            String value = StringPool.PERCENT + serverName + StringPool.PERCENT;

	            junction.add(property.like(value));
	        }

	        if (serverPort > 0) {
	            Property property = PropertyFactoryUtil.forName("serverPort");

	            junction.add(property.eq(serverPort));
	        }

	        if (Validator.isNotNull(sessionID)) {
	            Property property = PropertyFactoryUtil.forName("sessionID");

	            String value = StringPool.PERCENT + sessionID + StringPool.PERCENT;

	            junction.add(property.like(value));
	        }

	        DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
	            AuditEvent.class, getClassLoader());

	        if (companyId > 0) {
	            Property property = PropertyFactoryUtil.forName("companyId");

	            dynamicQuery.add(property.eq(companyId));
	        }

	        if (createDateGT != null) {
	            Property property = PropertyFactoryUtil.forName("createDate");

	            dynamicQuery.add(property.gt(createDateGT));
	        }

	        if (createDateLT != null) {
	            Property property = PropertyFactoryUtil.forName("createDate");

	            dynamicQuery.add(property.lt(createDateLT));
	        }

	        return dynamicQuery.add(junction);
	    }
	    public List<AuditEvent> searchcustom (String keyword,String tungay,String denngay, int start,int end,String fullname){
	    	try {
				return auditEventFinder.searchcustom(keyword, tungay, denngay, start, end, fullname);
			} catch (Exception e) {
				// TODO: handle exception
				return null;
			}
	    }
	    public int countcustom(String keyword,String tungay,String denngay,String fullname) {
	    	try {
	    		return auditEventFinder.countcustom(keyword, tungay, denngay,fullname);
				
			} catch (Exception e) {
				// TODO: handle exception
			return 0;
			}
	    }
}