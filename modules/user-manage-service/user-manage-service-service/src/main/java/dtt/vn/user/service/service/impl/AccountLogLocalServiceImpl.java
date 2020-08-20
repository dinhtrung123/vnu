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

import java.util.Date;
import java.util.List;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

import dtt.vn.user.service.model.AccountLog;
import dtt.vn.user.service.service.base.AccountLogLocalServiceBaseImpl;

/**
 * The implementation of the account log local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>dtt.vn.user.service.service.AccountLogLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author nhanvienDTT
 * @see AccountLogLocalServiceBaseImpl
 */
public class AccountLogLocalServiceImpl extends AccountLogLocalServiceBaseImpl {
	public AccountLog addAccountLog(long accountId, long nguoiSuaId, String tenNguoiSua, String emailNguoiSua, Date ngaySua, long phienBan, String json) throws SystemException {
		long id = CounterLocalServiceUtil.increment(AccountLog.class.getName());
		AccountLog returnValue = accountLogPersistence.create(id);
		returnValue.setAccountId(accountId);
		returnValue.setNguoiSuaId(nguoiSuaId);
		returnValue.setTenNguoiSua(tenNguoiSua);
		returnValue.setEmailNguoiSua(emailNguoiSua);
		returnValue.setNgaySua(ngaySua);
		returnValue.setPhienBan(phienBan);
		returnValue.setJson(json);
		return accountLogPersistence.update(returnValue);		
	}
	
	public int countByAccount(long accountId) throws SystemException{
		return accountLogPersistence.countByAccount(accountId);
	}
	public List<AccountLog> getByAccount(long accountId, int start, int end) throws SystemException{
		return accountLogPersistence.findByAccount(accountId, start, end);
	}
}