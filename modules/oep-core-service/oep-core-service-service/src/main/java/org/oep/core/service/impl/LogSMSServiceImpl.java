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

import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import org.oep.core.model.LogSMS;
import org.oep.core.service.LogSMSLocalServiceUtil;
import org.oep.core.service.base.LogSMSServiceBaseImpl;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.security.access.control.AccessControlled;

/**
 * The implementation of the log sms remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>org.oep.core.service.LogSMSService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author manhlb
 * @see LogSMSServiceBaseImpl
 */
public class LogSMSServiceImpl extends LogSMSServiceBaseImpl {

	@AccessControlled(guestAccessEnabled=true)
	public boolean addSMSLog(String error_code, String phone,String error_detail, String messageId){
		boolean result = false;
		try {
			LogSMS lSms = LogSMSLocalServiceUtil.createLogSMS(CounterLocalServiceUtil.increment());
			long logId = lSms.getId();
			
//			Document doc = Jsoup.parse(output.replace("<?xml version=\"1.0\" encoding=\"utf-8\"?>", ""), "", Parser.xmlParser());
//			String errorcode = doc.select("error_code").first() == null ? "" : doc.select("error_code").first().text();
//			String error_detail = doc.select("error_detail").first() == null ? "" : doc.select("error_detail").first().text();
//			String messageId = doc.select("messageId").first() == null ? "" : doc.select("messageId").first().text();
//			String response_date = doc.select("response_date").first() == null ? "" : doc.select("response_date").first().text();
//			
			//System.out.println(" error_code= " + errorcode + " error_detail= " + error_detail +  " messageId= " + messageId );
			//LogSMS logSMS = LogSMSLocalServiceUtil.fetchLogSMS(logId);
			lSms.setErrorCode(error_code);
			lSms.setErrorDetail(error_detail);
			lSms.setResponseDate(new Date());
			lSms.setPhone(phone);
			lSms.setSentDateTime(new Date());
			lSms.setMessageId((messageId==null || messageId.equals(""))?-1:Long.parseLong(messageId));			
			LogSMSLocalServiceUtil.updateLogSMS(lSms);
			result = true;
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
}