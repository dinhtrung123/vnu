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

import org.oep.core.model.Mail;
import org.oep.core.model.impl.MailImpl;
import org.oep.core.service.ThamSoLocalServiceUtil;
import org.oep.core.service.base.MailLocalServiceBaseImpl;
import org.oep.liferay.mail.MailThread;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;

/**
 * The implementation of the mail local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>org.oep.core.service.MailLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author manhlb
 * @see MailLocalServiceBaseImpl
 */
public class MailLocalServiceImpl extends MailLocalServiceBaseImpl {
	private static Log log = LogFactoryUtil.getLog(MailLocalServiceImpl.class.getName());
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>org.oep.core.service.MailLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>org.oep.core.service.MailLocalServiceUtil</code>.
	 */
private static final String MAIL_SYSTEM="SYSTEM";
	
	public boolean send(long groupId,String action,String fromAddress, String toAddress, String subject, String body) {
		try {
			if(fromAddress == null || fromAddress.trim().length()<=0){
				fromAddress =getFromEmailAddress();
			}
			String[]address = new String[1];
			address[0] =toAddress;
			MailThread mailThread = new MailThread(fromAddress, address, subject, body);
			mailThread.start();
			addHistory(groupId, action, fromAddress, address, subject, body);
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		} 
		return true;
	}
	
	public boolean send(String toAddress, String subject, String body) {
		String fromAddress =getFromEmailAddress();
		String[]address = new String[1];
		address[0] =toAddress;
		
		return send(0l, MAIL_SYSTEM, fromAddress, address, subject, body);
	}
		
	public boolean send(long groupId,String action,String fromAddress, String[] toAddress
			, String subject, String body) {
		try {
			if(fromAddress == null || fromAddress.trim().length()<=0){
				fromAddress =getFromEmailAddress();
			}
			MailThread mailThread = new MailThread(fromAddress, toAddress, subject, body);
			mailThread.start();
			
			addHistory(groupId, action, fromAddress, toAddress, subject, body);
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		} 
		return true;
	}
	
	public boolean send(String[] toAddress, String subject, String body) {
		String fromAddress =getFromEmailAddress();
		return send(0l, MAIL_SYSTEM, fromAddress, toAddress, subject, body);
	}
	
	
	
	
	private boolean addHistory(Long groupId,String action,String fromAddress, String[] toAddress
			, String subject, String body) throws SystemException {
			String to="";
			if(toAddress != null){
				for (String mail : toAddress) {
					to =to+ mail +",";
				}
			}
			//add history
			Mail mail = new MailImpl();
			mail.setId(CounterLocalServiceUtil.increment(Mail.class.getName()));
			mail.setGroupId(groupId);
			mail.setCode(action);			
			mail.setToAddress(to);
			mail.setSubject(subject);
			mail.setBody(body);
			mail.setNgayGui(new Date());
			mail.setTrangThai(true);
			mailLocalService.addMail(mail);
		
		return true;
	}
	
	private String getFromEmailAddress(){
		String fromAddress;
		try {
			fromAddress = ThamSoLocalServiceUtil.getValue("MAIL_DANGKY_FROM",
					PrefsPropsUtil.getString(PropsKeys.ADMIN_EMAIL_FROM_ADDRESS));
			return fromAddress;
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "";
	}
}