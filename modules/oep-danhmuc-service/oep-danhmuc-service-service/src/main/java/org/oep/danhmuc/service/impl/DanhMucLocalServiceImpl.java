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

package org.oep.danhmuc.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.oep.danhmuc.exception.NoSuchDanhMucException;
import org.oep.danhmuc.model.DanhMuc;
import org.oep.danhmuc.model.Nhom;
import org.oep.danhmuc.model.impl.DanhMucImpl;
import org.oep.danhmuc.service.DanhMucLocalServiceUtil;
import org.oep.danhmuc.service.base.DanhMucLocalServiceBaseImpl;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * The implementation of the danh muc local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>org.oep.danhmuc.service.DanhMucLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author nhanvienDTT
 * @see DanhMucLocalServiceBaseImpl
 */
public class DanhMucLocalServiceImpl extends DanhMucLocalServiceBaseImpl {

	public DanhMuc themMoiDanhMuc(long nhomId,long chaId,String ma,String maGiaPha, String ten,
			String moTa, boolean trangThai,int muc, int thuTuHienThi)
			throws PortalException, SystemException {
		//long id = CounterLocalServiceUtil.increment(DanhMuc.class.getName());
		
		DanhMuc danhMuc = DanhMucLocalServiceUtil.createDanhMuc(CounterLocalServiceUtil.increment(DanhMuc.class.getName()));

		
		danhMuc.setNhomId(nhomId);
		danhMuc.setChaId(chaId);
		danhMuc.setMa(ma);
		danhMuc.setMaGiaPha(maGiaPha);
		danhMuc.setTen(ten);
		danhMuc.setMoTa(moTa);
		danhMuc.setTrangThai(trangThai);
		danhMuc.setMuc(muc);
		danhMuc.setThuTuHienThi(thuTuHienThi);

		danhMucLocalService.addDanhMuc(danhMuc);

		return null;
	}
	
	
	public DanhMuc xoaDanhMuc(long danhMucId) {

		try {
			DanhMuc danhMuc = danhMucLocalService.fetchDanhMuc(danhMucId);
			danhMucLocalService.deleteDanhMuc(danhMuc);
		} catch (SystemException e) {

		}
		return null;
	}

	

	public DanhMuc suaDanhMuc(long danhMucId,long nhomId,String ma,String name,
			String moTa, boolean trangThai, int thuTuHienThi)
					throws PortalException, SystemException {
		
		DanhMuc danhMuc = danhMucLocalService.fetchDanhMuc(danhMucId);
		danhMuc.setMa(ma);
		danhMuc.setTen(name);
		danhMuc.setMoTa(moTa);
		danhMuc.setNhomId(nhomId);
		danhMuc.setTrangThai(trangThai);
		danhMuc.setThuTuHienThi(thuTuHienThi);
		
		return danhMucLocalService.updateDanhMuc(danhMuc);
	}
	
	

	public List<DanhMuc> getDanhMuc_By_Nhom_Muc(String maNhom, int level, boolean isActive) throws SystemException{
		Nhom nhom = nhomPersistence.fetchByMa(maNhom);
		List<DanhMuc> listDanhMucs = new ArrayList<DanhMuc>();
		if(nhom != null){
			listDanhMucs = danhMucPersistence.findByNhomId_Muc_TrangThai(nhom.getId(), level, isActive);
		}
		return listDanhMucs;
	}
	
	public DanhMuc getDanhMuc_By_Nhom_Muc_Ten(String maNhom, int level, String ten, boolean isActive) throws SystemException, NoSuchDanhMucException{
		Nhom nhom = nhomPersistence.fetchByMa(maNhom);
		if(nhom != null){
			return danhMucPersistence.fetchByNhomId_Muc_Ten_TrangThai(nhom.getId(), level, ten, isActive);
		}
		return null;
	}
	
	public DanhMuc getDanhMuc_By_Nhom_Muc_Ma(String maNhom, int level, String ma, boolean isActive) throws SystemException{
		Nhom nhom = nhomPersistence.fetchByMa(maNhom);
		if(nhom != null){
			return danhMucPersistence.fetchByNhomId_Muc_Ma_TrangThai(nhom.getId(), level, ma, isActive);
		}
		return null;
	}

	/**
	 * This is fucntion get All DanhMuc
	 * 
	 * @param nhomId
	 *            :
	 * @param isActive
	 *            : if true : get Item have got status=1,if false : get All
	 * @return
	 */
	public List<DanhMuc> getAll(long nhomId, boolean isActive) {
		
		try {
			if (isActive) {
				return danhMucPersistence.findByNhomId_TrangThai(nhomId, isActive);
			} else {
				return danhMucPersistence.findByNhomID(nhomId);
			}

		} catch (Exception e) {

		}
		return null;
	}
	
	
	
	public List<DanhMuc> getDanhMuc_By_ChaId(long chaId, boolean isActive)
			throws SystemException {

		try {
			if (isActive) {
				return danhMucPersistence.findByCha_TrangThai(chaId, isActive);
			} else {
				return danhMucPersistence.findByChaId(chaId);
			}

		} catch (Exception e) {

		}
		return null;
	}
	
	public DanhMuc getNextItem(long chaId,DanhMuc item)
			throws SystemException {
		DanhMuc dm=null;
		try {
				List<DanhMuc> lsDanhMuc= danhMucPersistence.findByChaId(chaId);
				for(int i=0;i<lsDanhMuc.size();i++){
					if(lsDanhMuc.get(i).getId()==item.getId()){
						if(i+1<lsDanhMuc.size()){
							return lsDanhMuc.get(i+1);
						}
						else {
							return lsDanhMuc.get(i);
						}
					}
				}

		} catch (Exception e) {

		}
		return null;
	}

	public DanhMuc getDanhMuc_By_Ma(String ma,
			boolean isActive) {
		try {
			if (isActive) {
				return danhMucPersistence.findByMa_TrangThai(ma, isActive);
			} else {
				return danhMucPersistence.findByM(ma);
			}
			
		} catch (Exception e) {
			
		}
		return null;
	}
	
	public List<DanhMuc> getDanhMuc_By_Ma_Muc(String ma, int muc) throws SystemException {
		return danhMucPersistence.findByMa_Muc(ma, muc);
	}
	
//	public List<DanhMuc> getDanhMuc_By_Muc(String ma, int level,
//			boolean isActive) {
//		try {
//			if (isActive) {
//				return danhMucPersistence.findByMa_Muc(ma, level, isActive);
//			} else {
//				return danhMucPersistence.findByMUC(level);
//			}
//
//		} catch (Exception e) {
//
//		}
//		return null;
//	}

	public List<DanhMuc> getDanhMuc_By_Muc(long chaId, int level,
			boolean isActive) {
		try {
			if (isActive) {
				return danhMucPersistence.findByChaId_Muc(chaId, level, isActive);
			} else {
				return danhMucPersistence.findByChaId(level);
			}

		} catch (Exception e) {

		}
		return null;
	}
	
	

	public List<DanhMuc> timKiem(long chaId, String ten,
			String groupId, String muc, int start, int end) {
		return danhMucFinder.searchItem(chaId, ten, groupId, muc, start, end);
	}

	public int countByTimKiem(long chaId, String ten, String groupId, String muc) {
		return danhMucFinder.countItem(chaId, ten, groupId, muc);
	}

	public DanhMuc getDanhMuc_Con_DauTien(long chaId, OrderByComparator asc)
			throws SystemException {
		try {
			danhMucPersistence.findByChaId_First(chaId, asc);
		} catch (Exception e) {
		}
		return danhMucFinder.getDanhMucWithMaxDisplayIndex(chaId);
	}

	public DanhMuc getDanhMuc_Con_CuoiCung(long chaId, OrderByComparator asc)
			throws SystemException {
		try {
			danhMucPersistence.findByChaId_Last(chaId, asc);
		} catch (Exception e) {
		}
		return null;
	}
	
	public List<DanhMuc> searchItem(long idCha,String ten, String groupId, String muc, int start, int end){
		return danhMucFinder.searchItem(idCha, ten, groupId, muc, start, end);
	}
	
	public List<DanhMuc> getByP(long chaId) throws SystemException{
		return danhMucPersistence.findByChaId(chaId);
	}
	
	public DanhMuc getByT(String ten) throws SystemException{
		return danhMucPersistence.fetchByT(ten);
	}
	
	public DanhMuc getByP_T(long chaId, String ten) throws SystemException{
		return danhMucPersistence.fetchByP_T(chaId, ten);
	}
	
	public DanhMuc getByM(String ma) throws SystemException{
		return danhMucPersistence.fetchByM(ma);
	}
	
	public DanhMuc getItemWithMaxDisplayIndex(long idCha) throws SystemException{
		return danhMucFinder.getDanhMucWithMaxDisplayIndex(idCha);
	}
	
	public DanhMuc getItemWithMaxDisplayIndexByMuc(int muc) throws SystemException{
		return danhMucFinder.getItemWithMaxDisplayIndexByMuc(muc);
	}
	public List<DanhMuc> getByMUC(int muc) throws SystemException{
		return danhMucPersistence.findByMUC(muc);
	}
	
	public DanhMuc getByTT(int thuTuHienThi) throws SystemException{
		return danhMucPersistence.fetchByTT(thuTuHienThi);
	}

	public List<DanhMuc> getByIds(long[] ids) throws SystemException{
		if(ids.length > 0){
			return danhMucPersistence.findByIds(ids);
		}
		return new ArrayList<DanhMuc>();
	}
	
	public List<DanhMuc> getAllByIds(long[] ids) throws SystemException{
		Map<Long, DanhMuc> mapDanhMuc = new HashMap<Long, DanhMuc>(); 
		if(ids.length > 0){
			for(DanhMuc danhMuc : danhMucPersistence.findByIds(ids)){
				mapDanhMuc.put(danhMuc.getId(), danhMuc);
			}
		}
		
		List<DanhMuc> listDanhMuc = new ArrayList<DanhMuc>();
		for(long id : ids){
			listDanhMuc.add(mapDanhMuc.get(id));
		}
		
		return listDanhMuc;
	}
	
	public List<DanhMuc> getAllByNhomId(long nhomId) throws SystemException {
		if(nhomId > 0) {
			return danhMucPersistence.findByNhomID(nhomId);
		}
		return new ArrayList<DanhMuc>();
	}
	
	public List<DanhMuc> getAllByNhomIdMuc(long nhomId, int muc) throws SystemException {
		if(nhomId > 0) {
			return danhMucPersistence.findByNhomId_Muc(nhomId, muc);
		}
		return new ArrayList<DanhMuc>();
	}
	
	public DanhMuc getDanhMucByNhomIdMa(long nhomId, String ma) throws SystemException{
		return danhMucPersistence.fetchByNhomId_Ma(nhomId, ma);
	}
}