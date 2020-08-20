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

import org.oep.core.model.PhanQuyen;
import org.oep.core.service.base.PhanQuyenLocalServiceBaseImpl;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;

/**
 * The implementation of the phan quyen local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>org.oep.core.service.PhanQuyenLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author manhlb
 * @see PhanQuyenLocalServiceBaseImpl
 */
public class PhanQuyenLocalServiceImpl extends PhanQuyenLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>org.oep.core.service.PhanQuyenLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>org.oep.core.service.PhanQuyenLocalServiceUtil</code>.
	 */
	
	public PhanQuyen capQuyen(String classname,long classpk,String giatri){
		try{
			PhanQuyen phanQuyen = phanQuyenPersistence.fetchByCN_PK(classname, classpk);
			if(phanQuyen == null){
				long id = CounterLocalServiceUtil.increment(PhanQuyen.class.getName());
				phanQuyen =phanQuyenPersistence.create(id);
			}
			
			phanQuyen.setClassname(classname);
			phanQuyen.setClasspk(classpk);
			phanQuyen.setGiatri(giatri);
			return phanQuyenPersistence.update(phanQuyen);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean  huyCapQuyen(String classname,long classpk){
		try{
			PhanQuyen phanQuyen = phanQuyenPersistence.fetchByCN_PK(classname, classpk);
			if(phanQuyen != null){
				phanQuyenPersistence.remove(phanQuyen.getId());
			}
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean  huyCapQuyen(long phanQuyenId){
		try{
			PhanQuyen phanQuyen = phanQuyenPersistence.fetchByPrimaryKey(phanQuyenId);
			if(phanQuyen != null){
				phanQuyenPersistence.remove(phanQuyen.getId());
			}
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	public String  getGiaTri(String classname,long classpk){
		try{
			PhanQuyen phanQuyen = phanQuyenPersistence.fetchByCN_PK(classname, classpk);
			if(phanQuyen != null){
				return phanQuyen.getGiatri();
			}		
		}catch(Exception e){
			
		}
		return null;
	}
	
	
}






























