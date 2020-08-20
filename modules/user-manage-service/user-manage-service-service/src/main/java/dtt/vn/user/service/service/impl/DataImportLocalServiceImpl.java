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

package dtt.vn.user.service.service.impl;

import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

import dtt.vn.user.service.model.DataImport;
import dtt.vn.user.service.service.base.DataImportLocalServiceBaseImpl;
import dtt.vn.vnpost.model.Account;

/**
 * The implementation of the data import local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>dtt.vn.user.service.service.DataImportLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author nhanvienDTT
 * @see DataImportLocalServiceBaseImpl
 */
public class DataImportLocalServiceImpl extends DataImportLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>dtt.vn.user.service.service.DataImportLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>dtt.vn.user.service.service.DataImportLocalServiceUtil</code>.
	 */
	
	public List<DataImport> getData(){
		return dataImportPersistence.findAll();
	}
	
	public List<DataImport> getData(int start, int end){
		return dataImportPersistence.findAll(start, end);
	}
	
	public List<DataImport> getDataByI(String hasImport) {
		return dataImportPersistence.findByI(hasImport);
	}
	
	public List<DataImport> getDataByI(String hasImport, int start, int end) {
		return dataImportPersistence.findByI(hasImport, start, end);
	}
	public int countDataByI(String hasImport) {
		return dataImportPersistence.countByI(hasImport);
	}
	public List<DataImport> searchForImport(int hasImport,String screenName,String lastName, String email, String role, String tungay, String denngay, int start, int end){
		return dataImportFinder.searchForImport(hasImport, screenName, lastName, email, role, tungay, denngay, start, end);
	}
	public int countForImport(int hasImport,String screenName,String lastName, String email, String role, String tungay, String denngay) {
		return dataImportFinder.countForImport(hasImport, screenName, lastName, email, role, tungay, denngay);
	}
	public boolean isscreenNameExists(String screenName) {
		boolean exists = false;
		try {
			List<DataImport> dataImport = dataImportPersistence.findByScreenName(screenName);
			if(dataImport == null || dataImport.size() == 0) {
				return true;
			}
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return exists;
	}
	public boolean islastNameExists(String lastName) {
		boolean exists = false;
		try {
			List<DataImport> dataImport = dataImportPersistence.findByLastName(lastName);
			if(dataImport == null || dataImport.size() == 0) {
				return true;
			}
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return exists;
	}
	public boolean isemailExists(String emailAddress) {
		boolean exists = false;
		try {
			List<DataImport> dataImport = dataImportPersistence.findByEmailAddress(emailAddress);
			if(dataImport == null || dataImport.size() == 0) {
				return true;
			}
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return exists;
	}
	public boolean isphoneExists(String phone) {
		boolean exists = false;
		try {
			List<DataImport> dataImport = dataImportPersistence.findByPhone(phone);
			if(dataImport == null || dataImport.size() == 0) {
				return true;
			}
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return exists;
	}
}