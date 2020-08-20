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

package dtt.vn.user.service.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import dtt.vn.user.service.model.ThongTinDangKy;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ThongTinDangKy in entity cache.
 *
 * @author nhanvienDTT
 * @generated
 */
@ProviderType
public class ThongTinDangKyCacheModel
	implements CacheModel<ThongTinDangKy>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ThongTinDangKyCacheModel)) {
			return false;
		}

		ThongTinDangKyCacheModel thongTinDangKyCacheModel =
			(ThongTinDangKyCacheModel)obj;

		if (id == thongTinDangKyCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{id=");
		sb.append(id);
		sb.append(", emailAddress=");
		sb.append(emailAddress);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", soGiayTo=");
		sb.append(soGiayTo);
		sb.append(", maKichHoat=");
		sb.append(maKichHoat);
		sb.append(", activeType=");
		sb.append(activeType);
		sb.append(", doiTuongSuDungId=");
		sb.append(doiTuongSuDungId);
		sb.append(", noiDung=");
		sb.append(noiDung);
		sb.append(", ngayTao=");
		sb.append(ngayTao);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ThongTinDangKy toEntityModel() {
		ThongTinDangKyImpl thongTinDangKyImpl = new ThongTinDangKyImpl();

		thongTinDangKyImpl.setId(id);

		if (emailAddress == null) {
			thongTinDangKyImpl.setEmailAddress("");
		}
		else {
			thongTinDangKyImpl.setEmailAddress(emailAddress);
		}

		if (userName == null) {
			thongTinDangKyImpl.setUserName("");
		}
		else {
			thongTinDangKyImpl.setUserName(userName);
		}

		if (soGiayTo == null) {
			thongTinDangKyImpl.setSoGiayTo("");
		}
		else {
			thongTinDangKyImpl.setSoGiayTo(soGiayTo);
		}

		if (maKichHoat == null) {
			thongTinDangKyImpl.setMaKichHoat("");
		}
		else {
			thongTinDangKyImpl.setMaKichHoat(maKichHoat);
		}

		if (activeType == null) {
			thongTinDangKyImpl.setActiveType("");
		}
		else {
			thongTinDangKyImpl.setActiveType(activeType);
		}

		thongTinDangKyImpl.setDoiTuongSuDungId(doiTuongSuDungId);

		if (noiDung == null) {
			thongTinDangKyImpl.setNoiDung("");
		}
		else {
			thongTinDangKyImpl.setNoiDung(noiDung);
		}

		if (ngayTao == Long.MIN_VALUE) {
			thongTinDangKyImpl.setNgayTao(null);
		}
		else {
			thongTinDangKyImpl.setNgayTao(new Date(ngayTao));
		}

		thongTinDangKyImpl.resetOriginalValues();

		return thongTinDangKyImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		emailAddress = objectInput.readUTF();
		userName = objectInput.readUTF();
		soGiayTo = objectInput.readUTF();
		maKichHoat = objectInput.readUTF();
		activeType = objectInput.readUTF();

		doiTuongSuDungId = objectInput.readInt();
		noiDung = objectInput.readUTF();
		ngayTao = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		if (emailAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(emailAddress);
		}

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		if (soGiayTo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(soGiayTo);
		}

		if (maKichHoat == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(maKichHoat);
		}

		if (activeType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(activeType);
		}

		objectOutput.writeInt(doiTuongSuDungId);

		if (noiDung == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(noiDung);
		}

		objectOutput.writeLong(ngayTao);
	}

	public long id;
	public String emailAddress;
	public String userName;
	public String soGiayTo;
	public String maKichHoat;
	public String activeType;
	public int doiTuongSuDungId;
	public String noiDung;
	public long ngayTao;

}