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

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;

import java.util.Date;
import java.util.List;

import dtt.vn.user.service.model.ThongTinDangKy;
import dtt.vn.user.service.service.ThongTinDangKyLocalServiceUtil;
import dtt.vn.user.service.service.base.ThongTinDangKyLocalServiceBaseImpl;
import dtt.vn.user.service.service.persistence.ThongTinDangKyPersistence;

/**
 * The implementation of the thong tin dang ky local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>dtt.vn.user.service.service.ThongTinDangKyLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author nhanvienDTT
 * @see ThongTinDangKyLocalServiceBaseImpl
 */
public class ThongTinDangKyLocalServiceImpl
	extends ThongTinDangKyLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>dtt.vn.user.service.service.ThongTinDangKyLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>dtt.vn.user.service.service.ThongTinDangKyLocalServiceUtil</code>.
	 */
	public ThongTinDangKy addThongTinDangKy(String emailAddress,String userName,String soGiayTo, String maKichHoat, int doiTuongSuDungId, String noiDung,String activeType, Date ngayTao) throws SystemException{
		ThongTinDangKy model = thongTinDangKyPersistence.create(CounterLocalServiceUtil.increment(ThongTinDangKy.class.getName()));
		model.setDoiTuongSuDungId(doiTuongSuDungId);
		model.setEmailAddress(emailAddress);
		model.setUserName(userName);
		model.setSoGiayTo(soGiayTo);
		model.setMaKichHoat(maKichHoat);
		model.setActiveType(activeType);
		model.setNoiDung(noiDung);
		model.setNgayTao(ngayTao);
		
		return thongTinDangKyPersistence.update(model);
	}
	
	public ThongTinDangKy getByMaKichHoat(String maKichHoat) throws SystemException{
		return thongTinDangKyPersistence.fetchByMaKichHoat(maKichHoat);
	}
	
	public ThongTinDangKy getByEmailAddress(String emailAddress) throws SystemException{
		return thongTinDangKyPersistence.fetchByemailAddress(emailAddress);
	}
	public ThongTinDangKy getByUserName(String userName) throws SystemException{
		return thongTinDangKyPersistence.fetchByuserName(userName);
	}
	public ThongTinDangKy getBySoGiayTo(String soGiayTo) throws SystemException{
		return thongTinDangKyPersistence.fetchBysoGiayTo(soGiayTo);
	}
	public ThongTinDangKy getByActiveType(String activeType) throws SystemException{
		return thongTinDangKyPersistence.fetchByactiveType(activeType);
	}
	
	public boolean isEmailExsist(String emailAddress){
		boolean result = false;
		try {
			ThongTinDangKy ttdk = ThongTinDangKyLocalServiceUtil.getByEmailAddress(emailAddress);
			result = Validator.isNotNull(ttdk);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}
	public boolean isUserNameExsist(String userName){
		boolean result = false;
		try {
			ThongTinDangKy ttdk = ThongTinDangKyLocalServiceUtil.getByUserName(userName);
			result = Validator.isNotNull(ttdk);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}
	public boolean isSoGiayToExsist(String soGiayTo){
		boolean result = false;
		try {
			ThongTinDangKy ttdk = ThongTinDangKyLocalServiceUtil.getBySoGiayTo(soGiayTo);
			result = Validator.isNotNull(ttdk);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}
	public List<ThongTinDangKy> searchByEmailOrUsername (String keyword,String tungay,String denngay, int start,int end){
		try {
			return thongTinDangKyFinder.searchByEmailOrUsername(keyword,tungay,denngay, start, end);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	public int countByEmailOrUsername (String keyword,String tungay,String denngay){
		try {
			return thongTinDangKyFinder.countByEmailOrUsername(keyword,tungay,denngay);
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}
}