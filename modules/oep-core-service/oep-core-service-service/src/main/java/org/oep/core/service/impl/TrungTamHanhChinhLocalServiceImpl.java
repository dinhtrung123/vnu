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

import org.oep.core.model.TrungTamHanhChinh;
import org.oep.core.service.base.TrungTamHanhChinhLocalServiceBaseImpl;
import org.oep.core.service.util.DataConvertUtil;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the trung tam hanh chinh local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>org.oep.core.service.TrungTamHanhChinhLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author manhlb
 * @see TrungTamHanhChinhLocalServiceBaseImpl
 */
public class TrungTamHanhChinhLocalServiceImpl
	extends TrungTamHanhChinhLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>org.oep.core.service.TrungTamHanhChinhLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>org.oep.core.service.TrungTamHanhChinhLocalServiceUtil</code>.
	 */
	
	
	public void addOrUpdate(long id, long coQuanQuanLyId,String ten, String ma, 
			String donVi_Ids,  int trangThai, String thongTinLienHe) throws SystemException{
			TrungTamHanhChinh tthc = null;
			if(id > 0){
				tthc = trungTamHanhChinhPersistence.fetchByPrimaryKey(id);
			}else{
				tthc = trungTamHanhChinhPersistence.create(CounterLocalServiceUtil.increment(TrungTamHanhChinh.class.getName()));
			}
			if(tthc != null){
				tthc.setTen(ten);
				tthc.setMa(ma);
				tthc.setDonViId(coQuanQuanLyId);
				tthc.setDonViIds(donVi_Ids);
				tthc.setTrangThai(trangThai);
				tthc.setThongTinLienHe(thongTinLienHe);
				trungTamHanhChinhPersistence.update(tthc);
			}
	}
	
	public TrungTamHanhChinh getByMa(String ma) throws SystemException{
		return trungTamHanhChinhPersistence.fetchByMa(ma);
	}
	public TrungTamHanhChinh getByCoQuanQuanLyId(long coQuanQuanLyId){
		try{
			return trungTamHanhChinhPersistence.fetchBydonViId(coQuanQuanLyId);
		}catch(Exception e){
			
		}
		return null;
		
	}
	
	public TrungTamHanhChinh findByDonViXuLyId(long donvixulyId){
		try{
			List<TrungTamHanhChinh> tthcList = trungTamHanhChinhPersistence.findAll();
			if(tthcList != null){
				for (TrungTamHanhChinh tthc : tthcList) {
					try{
						String dvids = tthc.getDonViIds();
						if(dvids != null && dvids.trim().length()>0){
							if(dvids.indexOf(",")==-1){
								if(Long.valueOf(dvids).longValue() == donvixulyId){
									return tthc;
								}
							}else{
								long[] donviIds =DataConvertUtil.convertToLongArray(tthc.getDonViIds(), ",");
								if(donviIds != null && donviIds.length>0){
									for (long donviId : donviIds) {
										if(donviId == donvixulyId){
											return tthc;
										}
									}
								}
							}
						}
					
					}catch(Exception e){}
				}
			}
		}catch(Exception e){
			
		}
		return null;
	}
	
	
	public long[] getDonViXuLyIds(long trungTamHanhChinhId){
		try{
			TrungTamHanhChinh tthc = trungTamHanhChinhPersistence.fetchByPrimaryKey(trungTamHanhChinhId);
			if(tthc != null && tthc.getDonViIds()!= null){
				long[] donviIds =DataConvertUtil.convertToLongArray(tthc.getDonViIds(), ",");
				return donviIds;
				
			}
		}catch(Exception e){}
		
		return null;
	}
	
	public List<TrungTamHanhChinh> searchByTen_Ma_CQQL(String ten_ma,long coQuanQuanLyId,  int trangThai, int start, int end){
		return trungTamHanhChinhFinder.searchTTHC(ten_ma, coQuanQuanLyId, trangThai, start, end);
	}
	
	public int countTTHC(String ten_ma,long coQuanQuanLyId,  int trangThai){
		return trungTamHanhChinhFinder.countTTHC(ten_ma, coQuanQuanLyId, trangThai);
	}
	
}































