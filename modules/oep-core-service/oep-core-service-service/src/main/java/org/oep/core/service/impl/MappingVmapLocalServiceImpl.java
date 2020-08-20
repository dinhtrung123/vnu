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

import org.oep.core.model.MappingVmap;
import org.oep.core.service.base.MappingVmapLocalServiceBaseImpl;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
/**
 * The implementation of the mapping vmap local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>org.oep.core.service.MappingVmapLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author manhlb
 * @see MappingVmapLocalServiceBaseImpl
 */
public class MappingVmapLocalServiceImpl
	extends MappingVmapLocalServiceBaseImpl {
	
	private static Log log = LogFactoryUtil.getLog(MappingVmapLocalServiceImpl.class.getName());

	public MappingVmap addMapping(String classname, long classpk,String latitude, String longitude, String ghichu){
		try {
			MappingVmap vmap = mappingVmapPersistence.fetchByCN_PK(classname, classpk);
			if(vmap==null){
				long id = CounterLocalServiceUtil.increment(MappingVmap.class.getName());
				vmap =mappingVmapPersistence.create(id);
			}
			vmap.setClassname(classname);
			vmap.setClasspk(classpk);
			vmap.setLatitude(latitude);
			vmap.setLongitude(longitude);
			vmap.setGhichu(ghichu);
			return mappingVmapPersistence.update(vmap);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
		
	}
	public MappingVmap getToaDo (String classname, long classpk){
		return mappingVmapPersistence.fetchByCN_PK(classname, classpk);
	}
	
	public MappingVmap updateToaDo (String classname, long classpk, String latitude, String longitude, String ghichu){
		try {
			MappingVmap mapping = mappingVmapPersistence.fetchByCN_PK(classname, classpk);
			if(mapping != null){
				mapping.setLatitude(latitude);
				mapping.setLongitude(longitude);
				mapping.setClasspk(classpk);
				mapping.setGhichu(ghichu);
				return mappingVmapPersistence.update(mapping);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
		return null;
		
	}
	public MappingVmap getToaDoByClassPK (long classpk){
		return mappingVmapPersistence.fetchByPK(classpk);
	}
}





