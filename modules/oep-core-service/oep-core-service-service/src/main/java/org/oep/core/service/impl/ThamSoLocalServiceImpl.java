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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.oep.core.model.ThamSo;
import org.oep.core.model.impl.ThamSoImpl;
import org.oep.core.service.base.ThamSoLocalServiceBaseImpl;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the tham so local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>org.oep.core.service.ThamSoLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author manhlb
 * @see ThamSoLocalServiceBaseImpl
 */
public class ThamSoLocalServiceImpl extends ThamSoLocalServiceBaseImpl {
	private static Map<String, String> tMap = null;
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>org.oep.core.service.ThamSoLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>org.oep.core.service.ThamSoLocalServiceUtil</code>.
	 */
	private Map<String, String> getMap(){
		if(tMap == null){
			try {
				tMap = new HashMap<String, String>();
				List<ThamSo> tList = thamSoPersistence.findAll();
				if(tList != null){
					for (ThamSo thamSo : tList) {
						
						tMap.put(thamSo.getMa(), thamSo.getGiaTri());
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
			}
		}
		return tMap;
	}
	
		public ThamSo getValue(long groupId, String ma) {
		
			try {
				return thamSoPersistence.fetchByG_M(groupId, ma);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				return null;
			}
		}
		
		public ThamSo getValue(String className,long classPK, String ma) {
			
			try {
				return thamSoPersistence.fetchByM_CL_PK(ma, className, classPK);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				return null;
			}
		}
		
		public List<ThamSo> searchByL_M(long groupId,long loaiId,String ma,int start,int end){
			return thamSoFinder.searchByL_M(groupId,loaiId, ma, start, end);
		}
		
		/** 
		 * count match tham so by to chuc id - loai tham so id - ma
		 * 
		 * Version: OEP 1.1
		 *  
		 * History: 
		 *   DATE        AUTHOR      DESCRIPTION 
		 *  ------------------------------------------------- 
		 *  01-April-2015  trungdv    Create new
		 * @param
		 * 	groupId						groupId
		 * 	loaiThamSoId				loai tham so id
		 * 	ma							ma
		 * @return:
		 * 	int							number of match data
		 * @throws SystemException
		 */
		public int countByL_M(long groupId,long loaiThamSoId, String ma) {
			return thamSoFinder.countByL_M(groupId,loaiThamSoId, ma);
		}
		
		
	
		public ThamSo addThamSo(Long groupId, Long loaiThamSoId, String ma, String giaTri,String moTa,boolean statusActive,int quyen) throws Exception {
			
				long id = CounterLocalServiceUtil.increment(ThamSo.class.getName());
				ThamSo thamSo = new ThamSoImpl();
				thamSo.setId(id);
				thamSo.setGroupId(groupId);
				thamSo.setLoaiId(loaiThamSoId);
				thamSo.setMa(ma);
				thamSo.setGiaTri(giaTri);
				thamSo.setMoTa(moTa);
				thamSo.setTrangThai(statusActive);
				thamSo.setQuyenTacDong(quyen);
				tMap = null;
				return thamSoLocalService.addThamSo(thamSo);
			
		}
		

		public ThamSo save(Long groupId, String className,long classPK, String ma, String giaTri,String moTa,long loaiThamSoId ){
			try{
				ThamSo thamSo =thamSoPersistence.fetchByM_CL_PK(ma, className, classPK);
				if(thamSo == null){
					long id = CounterLocalServiceUtil.increment(ThamSo.class.getName());
					thamSo = thamSoPersistence.create(id);
					thamSo.setGroupId(groupId);
					thamSo.setMa(ma);
					thamSo.setGiaTri(giaTri);
					thamSo.setMoTa(moTa);
					thamSo.setTrangThai(true);
					thamSo.setQuyenTacDong(1);
					thamSo.setClassName(className);
					thamSo.setClassPK(classPK);
					thamSo.setLoaiId(loaiThamSoId);
					tMap = null;
					return thamSoLocalService.addThamSo(thamSo);
				}else{
					thamSo.setGroupId(groupId);
					thamSo.setMa(ma);
					thamSo.setGiaTri(giaTri);
					thamSo.setMoTa(moTa);
					thamSo.setTrangThai(true);
					thamSo.setQuyenTacDong(1);
					thamSo.setClassName(className);
					thamSo.setClassPK(classPK);
					thamSo.setLoaiId(loaiThamSoId);
					return thamSoLocalService.updateThamSo(thamSo);
				}
				
			}catch(Exception e){
				return null;
			}
			
		}
		
		
		/** 
		 * handle update tham so
		 * 
		 * Version: OEP 1.1
		 *  
		 * History: 
		 *   DATE        AUTHOR      DESCRIPTION 
		 *  ------------------------------------------------- 
		 *  01-April-2015  trungdv    Create new
		 * @param
		 * context						service context
		 * loaiThamSoId					loai tham so
		 * ma							ma
		 * giaTri						gia tri
		 * moTo							mo ta
		 * @return:
		 * @throws SystemException
		 * @throws PortalException 
		 * @throws Exception 
		 */
		public ThamSo updateThamSo(long id,long loaiThamSoId, String ma, String giaTri, String moTa, boolean status) throws SystemException{
			
				ThamSo thamso =thamSoPersistence.fetchByPrimaryKey(id);
				thamso.setMa(ma);
				thamso.setGiaTri(giaTri);
				thamso.setMoTa(moTa);
				thamso.setTrangThai(status);
				thamso.setLoaiId(loaiThamSoId);
				tMap = null;
				return thamSoPersistence.update(thamso);
				
		}
		
		
		public ThamSo deleteThamSolong(long id) throws PortalException, SystemException  {
			tMap = null;
			return thamSoLocalService.deleteThamSo(id);
		}
		
		/** 
		 * handle change status tham so
		 * 
		 * Version: OEP 1.1
		 *  
		 * History: 
		 *   DATE        AUTHOR      DESCRIPTION 
		 *  ------------------------------------------------- 
		 *  01-April-2015  trungdv    Create 
		 * @param
		 * context						service context
		 * id							id
		 * @return:
		 * @throws SystemException
		 * @throws PortalException 
		 * @throws IllegalAccessException 
		 */
		public ThamSo thayDoiTrangThaiThamSo(long id) throws Exception  {
			ThamSo thamso = thamSoPersistence.fetchByPrimaryKey(id);
			thamso.setTrangThai(!thamso.getTrangThai());
			return thamSoPersistence.update(thamso);
		}
		
		public String getValue(long groupId, String ma, String defaultValue) {
			
			
			try {
				String value = getMap().get(ma);
				if (value != null) {
					return value;
				} 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
			}
			return defaultValue;
			
		}
		
		public String getValue(String ma, String defaultValue) {
	
			try {
				String value = getMap().get(ma);
				if (value != null) {
					return value;
				} 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
			}
			return defaultValue;
	
			
			
		}
		
		public String getValue(String className,long classPK,String ma, String defaultValue) {
			
			try {
				ThamSo thamSo= thamSoPersistence.fetchByM_CL_PK(ma, className, classPK);
				if(thamSo != null){
					return thamSo.getGiaTri();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
			}
			return defaultValue;
			
		}
		public List<ThamSo> getByMa(String ma) throws SystemException{
			return thamSoPersistence.findByMa(ma);
		}
		
		public List<ThamSo> getByValue(String value) throws SystemException {
			return thamSoPersistence.findBygiaTri(value);
		}
		
		/** 
		 * get gia tri tham so by ma
		 * 
		 * Version: OEP 1.1
		 *  
		 * History: 
		 *   DATE        AUTHOR      DESCRIPTION 
		 *  ------------------------------------------------- 
		 *  01-April-2015  trungdv    Create new
		 * @param
		 * 	context					service context
		 * 	mas						finding mas
		 * @return:
		 * 	Map<String, String>		mapping ma - gia tri
		 * @throws SystemException
		 */
		public Map<String, String> getValues(long groupId, List<String> mas){
			Map<String, String> returnValues = new HashMap<String, String>();
			if (mas != null && mas.size() > 0) {
				for(String ma : mas) {
					returnValues.put(ma, getValue(groupId, ma, null));
				}
			}
			return returnValues;
		}
	
		public List<ThamSo> getAll() throws SystemException {
			return thamSoPersistence.findAll();
		}
		
		public String getValue(String ma, String className, String defaultValue) {			
			try {
				ThamSo thamso = thamSoPersistence.fetchByM_CL(ma, className);
				if (thamso != null) {
					return thamso.getGiaTri();
				} 
			} catch (SystemException e) {
				
			}
			return defaultValue;
			
		}
	
		public String getValue(String ma, String className, long classPK, String defaultValue) {			
			try {
				ThamSo thamso = thamSoPersistence.fetchByM_CL_PK(ma, className, classPK);
				if (thamso != null) {
					return thamso.getGiaTri();
				} 
			} catch (SystemException e) {
				
			}
			return defaultValue;			
		}
}