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

package org.oep.core.service.impl;

import java.util.List;

import org.oep.core.model.LogSMS;
import org.oep.core.service.base.LogSMSLocalServiceBaseImpl;

/**
 * The implementation of the log sms local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>org.oep.core.service.LogSMSLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author manhlb
 * @see LogSMSLocalServiceBaseImpl
 */
public class LogSMSLocalServiceImpl extends LogSMSLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use
	 * <code>org.oep.core.service.LogSMSLocalService</code> via injection or a
	 * <code>org.osgi.util.tracker.ServiceTracker</code> or use
	 * <code>org.oep.core.service.LogSMSLocalServiceUtil</code>.
	 */

	public List<LogSMS> searchByPhone(String keyword, String tungay, String denngay, int start, int end) {
		try {
			return logSMSFinder.searchByPhone(keyword, tungay, denngay, start, end);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	public int countByPhone(String keyword, String tungay, String denngay) {
		try {
			return logSMSFinder.countByPhone(keyword, tungay, denngay);
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}
	
	public List<LogSMS> getAll(int start, int end) throws Exception{
		return logSMSPersistence.findAll(start, end);
	}
	
	public int coutnAll() throws Exception {
		return logSMSPersistence.countAll();
	}
}