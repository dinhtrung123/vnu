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

import org.oep.danhmuc.exception.NoSuchDanhMucException;
import org.oep.danhmuc.model.DanhMucSoap;
import org.oep.danhmuc.service.base.DanhMucServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * The implementation of the danh muc remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>org.oep.danhmuc.service.DanhMucService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author nhanvienDTT
 * @see DanhMucServiceBaseImpl
 */
public class DanhMucServiceImpl extends DanhMucServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>org.oep.danhmuc.service.DanhMucServiceUtil</code> to access the danh muc remote service.
	 */
private static Log log = LogFactoryUtil.getLog(DanhMucServiceImpl.class);
private static String a ="";
	
	public DanhMucSoap[] getDanhMuc_By_Nhom_Muc(String maNhom, int level, boolean isActive) {
		try {
			return DanhMucSoap.toSoapModels(danhMucLocalService.getDanhMuc_By_Nhom_Muc(maNhom, level, isActive));
		} catch (SystemException e) {
			log.error(e);
		}
		return null;
	}
	
	public DanhMucSoap getDanhMuc_By_Nhom_Muc_Ten(String maNhom, int level, String ten, boolean isActive){
		try {
			return DanhMucSoap.toSoapModel(danhMucLocalService.getDanhMuc_By_Nhom_Muc_Ten(maNhom, level, ten, isActive));
		} catch (SystemException e) {
			log.error(e);
		} catch(NoSuchDanhMucException e){
			log.error(e);
		}
		return null;
	}
	
	public DanhMucSoap getDanhMuc_By_Nhom_Muc_Ma(String maNhom, int level, String ma, boolean isActive){
		try{
			return DanhMucSoap.toSoapModel(danhMucLocalService.getDanhMuc_By_Nhom_Muc_Ma(maNhom, level, ma, isActive));
		}catch(SystemException e){
			log.error(e);
		}
		return null;
	}

	public DanhMucSoap[] getAll(long nhomId, boolean isActive){
		try {
			return DanhMucSoap.toSoapModels(danhMucLocalService.getAll(nhomId, isActive));
		} catch (Exception e) {
			log.error(e);
		}
		return null;
	}
	
	public DanhMucSoap[] getDanhMuc_By_ChaId(long chaId, boolean isActive){
		try {
			return DanhMucSoap.toSoapModels(danhMucLocalService.getDanhMuc_By_ChaId(chaId, isActive));
		} catch (SystemException e) {
			log.error(e);
		}
		return null;
	}

	public DanhMucSoap getDanhMuc_By_Ma(String ma, boolean isActive) {
		try {
			return DanhMucSoap.toSoapModel(danhMucLocalService.getDanhMuc_By_Ma(ma, isActive));
		} catch (Exception e) {
			log.error(e);
		}
		return null;
	}
	
	public DanhMucSoap[] getDanhMuc_By_Ma_Muc(String ma, int muc){
		try {
			return DanhMucSoap.toSoapModels(danhMucLocalService.getDanhMuc_By_Ma_Muc(ma, muc));
		} catch (SystemException e) {
			log.error(e);
		}
		return null;
	}

	public DanhMucSoap[] getDanhMuc_By_Muc(long chaId, int level,boolean isActive) {
		try {
			return DanhMucSoap.toSoapModels(danhMucLocalService.getDanhMuc_By_Muc(chaId, level, isActive));
		} catch (Exception e) {
			log.error(e);
		}
		return null;
	}
	
	public DanhMucSoap[] timKiem(long chaId, String ten, String groupId, String muc, int start, int end) {
		try {
			return DanhMucSoap.toSoapModels(danhMucLocalService.timKiem(chaId, ten, groupId, muc, start, end));
		} catch (Exception e) {
			log.error(e);
		}
		return null;
	}

	public int countByTimKiem(long chaId, String ten, String groupId, String muc) {
		return danhMucLocalService.countByTimKiem(chaId, ten, groupId, muc);
	}

	public DanhMucSoap getDanhMuc_Con_DauTien(long chaId, OrderByComparator asc){
		try {
			return DanhMucSoap.toSoapModel(danhMucLocalService.getDanhMuc_Con_DauTien(chaId, asc));
		} catch (SystemException e) {
			log.error(e);
		}
		return null;
	}

	public DanhMucSoap getDanhMuc_Con_CuoiCung(long chaId, OrderByComparator asc){
		try {
			return DanhMucSoap.toSoapModel(danhMucLocalService.getDanhMuc_Con_CuoiCung(chaId, asc));
		} catch (SystemException e) {
			log.error(e);
		}
		return null;
	}
	
	public DanhMucSoap[] searchItem(long idCha,String ten, String groupId, String muc, int start, int end){
		try {
			return DanhMucSoap.toSoapModels(danhMucLocalService.searchItem(idCha, ten, groupId, muc,  start, end));
		} catch (Exception e) {
			log.error(e);
		}
		return null;
	}
	
	public DanhMucSoap[] getByP(long chaId){
		try {
			return DanhMucSoap.toSoapModels(danhMucLocalService.getByP(chaId));
		} catch (SystemException e) {
			log.error(e);
		}
		return null;
	}
	
	public DanhMucSoap getByT(String ten){
		try {
			return DanhMucSoap.toSoapModel(danhMucLocalService.getByT(ten));
		} catch (SystemException e) {
			log.error(e);
		}
		return null;
	}
	
	public DanhMucSoap getByP_T(long chaId, String ten){
		try {
			return DanhMucSoap.toSoapModel(danhMucLocalService.getByP_T(chaId, ten));
		} catch (SystemException e) {
			log.error(e);
		}
		return null;
	}
	
	public DanhMucSoap getByM(String ma){
		try {
			return DanhMucSoap.toSoapModel(danhMucLocalService.getByM(ma));
		} catch (SystemException e) {
			log.error(e);
		}
		return null;
	}
	
	public DanhMucSoap getItemWithMaxDisplayIndex(long idCha){
		try {
			return DanhMucSoap.toSoapModel(danhMucLocalService.getItemWithMaxDisplayIndex(idCha));
		} catch (SystemException e) {
			log.error(e);
		}
		return null;
	}
	
	public DanhMucSoap getItemWithMaxDisplayIndexByMuc(int muc){
		try {
			return DanhMucSoap.toSoapModel(danhMucLocalService.getItemWithMaxDisplayIndexByMuc(muc));
		} catch (SystemException e) {
			log.error(e);
		}
		return null;
	}
	
	public DanhMucSoap[] getByMUC(int muc){
		try {
			return DanhMucSoap.toSoapModels(danhMucLocalService.getByMUC(muc));
		} catch (SystemException e) {
			log.error(e);
		}
		return null;
	}
	
	public DanhMucSoap getByTT(int thuTuHienThi) throws SystemException{
		try {
			return DanhMucSoap.toSoapModel(danhMucLocalService.getByTT(thuTuHienThi));
		} catch (SystemException e) {
			log.error(e);
		}
		return null;
	}
}