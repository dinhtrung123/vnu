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

package dtt.vn.vnpost.service.persistence;

import aQute.bnd.annotation.ProviderType;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public interface AccountFinder {

	public java.util.List<dtt.vn.vnpost.model.Account> searchAccountForAPI(
		String keyword, int tinhtrang, String email, String userName,
		String fullName, String telNo, int start, int end);

	public int countAccountForAPI(
		String keyword, int tinhtrang, String email, String userName,
		String fullName, String telNo);

	public java.util.List<dtt.vn.vnpost.model.Account> searchForDanhSach(
		String keyword, int hinhthucdangky, String sogiayto, String tungay,
		String denngay, String sodienthoai, String tentaikhoan,
		int loaidoituong, String canboxacminh, int tinhtrang, int start,
		int end);

	public int countForDanhSach(
		String keyword, int hinhthucdangky, String sogiayto, String tungay,
		String denngay, String sodienthoai, String tentaikhoan,
		int loaidoituong, String canboxacminh, int tinhtrang);

	public java.util.List<dtt.vn.vnpost.model.Account> getAccountByStatus(
		int accountstatus, int type, String keyword, int status, long userId,
		int start, int end);

	public int getTotalAccountCountByStatus(
		int accountstatus, int type, String keyword, int status, long userId,
		int start, int end);

	public int countForXacMinh(
		String keyword, int tinhtrang, String email, String sogiayto,
		String tungay, String denngay, String sodienthoai, String tentaikhoan,
		int loaidoituong, int hinhthucdangky);

	public java.util.List<dtt.vn.vnpost.model.Account> searchForXacMinh(
		String keyword, int tinhtrang, String email, String sogiayto,
		String tungay, String denngay, String sodienthoai, String tentaikhoan,
		int loaidoituong, int hinhthucdangky, int start, int end);

	public int countForPheDuyet(
		String keyword, int tinhtrang, String email, String sogiayto,
		String tungay, String denngay, String sodienthoai, String tentaikhoan,
		int loaidoituong, int hinhthucdangky);

	public java.util.List<dtt.vn.vnpost.model.Account> searchForPheDuyet(
		String keyword, int tinhtrang, String email, String sogiayto,
		String tungay, String denngay, String sodienthoai, String tentaikhoan,
		int loaidoituong, int hinhthucdangky, int start, int end);

}