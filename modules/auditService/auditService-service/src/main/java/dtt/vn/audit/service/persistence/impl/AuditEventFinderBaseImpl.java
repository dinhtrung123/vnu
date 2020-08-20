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

package dtt.vn.audit.service.persistence.impl;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;

import dtt.vn.audit.model.AuditEvent;
import dtt.vn.audit.service.persistence.AuditEventPersistence;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AuditEventFinderBaseImpl extends BasePersistenceImpl<AuditEvent> {

	public AuditEventFinderBaseImpl() {
		setModelClass(AuditEvent.class);
	}

	/**
	 * Returns the audit event persistence.
	 *
	 * @return the audit event persistence
	 */
	public AuditEventPersistence getAuditEventPersistence() {
		return auditEventPersistence;
	}

	/**
	 * Sets the audit event persistence.
	 *
	 * @param auditEventPersistence the audit event persistence
	 */
	public void setAuditEventPersistence(
		AuditEventPersistence auditEventPersistence) {

		this.auditEventPersistence = auditEventPersistence;
	}

	@BeanReference(type = AuditEventPersistence.class)
	protected AuditEventPersistence auditEventPersistence;

}