package dtt.vn.user.service.service.util;

import com.google.gson.Gson;

public class CongDanExtraModel {
	String noiCapCMND, diaChiChiTietKhaiSinh, soSoHoKhau, hoTenChuSoHoKhau, diaChiChiTietThuongTru,
			hoTenCha, hoTenMe, hoTenNguoiGiamHo, hoTenVoChong, diaChiChiTietNoiXacMinh;
	long quoctichId, quocGiaKhaiSinhId, thanhPhoKhaiSinhId, quanHuyenKhaiSinhId, phuongXaKhaiSinhId,
			quocGiaThuongTruId, tinhThanhThuongTruId, quanHuyenThuongTruId, phuongXaThuongTruId,
			noiXacMinhId, tinhThanhBuuCucId, quanHuyenBuuCucId, phuongXaBuuCucId, buuCucId;
	public String getNoiCapCMND() {
		return noiCapCMND;
	}
	public void setNoiCapCMND(String noiCapCMND) {
		this.noiCapCMND = noiCapCMND;
	}
	public String getDiaChiChiTietKhaiSinh() {
		return diaChiChiTietKhaiSinh;
	}
	public void setDiaChiChiTietKhaiSinh(String diaChiChiTietKhaiSinh) {
		this.diaChiChiTietKhaiSinh = diaChiChiTietKhaiSinh;
	}
	public String getSoSoHoKhau() {
		return soSoHoKhau;
	}
	public void setSoSoHoKhau(String soSoHoKhau) {
		this.soSoHoKhau = soSoHoKhau;
	}
	public String getHoTenChuSoHoKhau() {
		return hoTenChuSoHoKhau;
	}
	public void setHoTenChuSoHoKhau(String hoTenChuSoHoKhau) {
		this.hoTenChuSoHoKhau = hoTenChuSoHoKhau;
	}
	public String getDiaChiChiTietThuongTru() {
		return diaChiChiTietThuongTru;
	}
	public void setDiaChiChiTietThuongTru(String diaChiChiTietThuongTru) {
		this.diaChiChiTietThuongTru = diaChiChiTietThuongTru;
	}
	public String getHoTenCha() {
		return hoTenCha;
	}
	public void setHoTenCha(String hoTenCha) {
		this.hoTenCha = hoTenCha;
	}
	public String getHoTenMe() {
		return hoTenMe;
	}
	public void setHoTenMe(String hoTenMe) {
		this.hoTenMe = hoTenMe;
	}
	public String getHoTenNguoiGiamHo() {
		return hoTenNguoiGiamHo;
	}
	public void setHoTenNguoiGiamHo(String hoTenNguoiGiamHo) {
		this.hoTenNguoiGiamHo = hoTenNguoiGiamHo;
	}
	public String getHoTenVoChong() {
		return hoTenVoChong;
	}
	public void setHoTenVoChong(String hoTenVoChong) {
		this.hoTenVoChong = hoTenVoChong;
	}
	public String getDiaChiChiTietNoiXacMinh() {
		return diaChiChiTietNoiXacMinh;
	}
	public void setDiaChiChiTietNoiXacMinh(String diaChiChiTietNoiXacMinh) {
		this.diaChiChiTietNoiXacMinh = diaChiChiTietNoiXacMinh;
	}
	public long getQuoctichId() {
		return quoctichId;
	}
	public void setQuoctichId(long quoctichId) {
		this.quoctichId = quoctichId;
	}
	public long getQuocGiaKhaiSinhId() {
		return quocGiaKhaiSinhId;
	}
	public void setQuocGiaKhaiSinhId(long quocGiaKhaiSinhId) {
		this.quocGiaKhaiSinhId = quocGiaKhaiSinhId;
	}
	public long getThanhPhoKhaiSinhId() {
		return thanhPhoKhaiSinhId;
	}
	public void setThanhPhoKhaiSinhId(long thanhPhoKhaiSinhId) {
		this.thanhPhoKhaiSinhId = thanhPhoKhaiSinhId;
	}
	public long getQuanHuyenKhaiSinhId() {
		return quanHuyenKhaiSinhId;
	}
	public void setQuanHuyenKhaiSinhId(long quanHuyenKhaiSinhId) {
		this.quanHuyenKhaiSinhId = quanHuyenKhaiSinhId;
	}
	public long getPhuongXaKhaiSinhId() {
		return phuongXaKhaiSinhId;
	}
	public void setPhuongXaKhaiSinhId(long phuongXaKhaiSinhId) {
		this.phuongXaKhaiSinhId = phuongXaKhaiSinhId;
	}
	public long getQuocGiaThuongTruId() {
		return quocGiaThuongTruId;
	}
	public void setQuocGiaThuongTruId(long quocGiaThuongTruId) {
		this.quocGiaThuongTruId = quocGiaThuongTruId;
	}
	public long getTinhThanhThuongTruId() {
		return tinhThanhThuongTruId;
	}
	public void setTinhThanhThuongTruId(long tinhThanhThuongTruId) {
		this.tinhThanhThuongTruId = tinhThanhThuongTruId;
	}
	public long getQuanHuyenThuongTruId() {
		return quanHuyenThuongTruId;
	}
	public void setQuanHuyenThuongTruId(long quanHuyenThuongTruId) {
		this.quanHuyenThuongTruId = quanHuyenThuongTruId;
	}
	public long getPhuongXaThuongTruId() {
		return phuongXaThuongTruId;
	}
	public void setPhuongXaThuongTruId(long phuongXaThuongTruId) {
		this.phuongXaThuongTruId = phuongXaThuongTruId;
	}
	public long getNoiXacMinhId() {
		return noiXacMinhId;
	}
	public void setNoiXacMinhId(long noiXacMinhId) {
		this.noiXacMinhId = noiXacMinhId;
	}
	public long getTinhThanhBuuCucId() {
		return tinhThanhBuuCucId;
	}
	public void setTinhThanhBuuCucId(long tinhThanhBuuCucId) {
		this.tinhThanhBuuCucId = tinhThanhBuuCucId;
	}
	public long getQuanHuyenBuuCucId() {
		return quanHuyenBuuCucId;
	}
	public void setQuanHuyenBuuCucId(long quanHuyenBuuCucId) {
		this.quanHuyenBuuCucId = quanHuyenBuuCucId;
	}
	public long getPhuongXaBuuCucId() {
		return phuongXaBuuCucId;
	}
	public void setPhuongXaBuuCucId(long phuongXaBuuCucId) {
		this.phuongXaBuuCucId = phuongXaBuuCucId;
	}
	public long getBuuCucId() {
		return buuCucId;
	}
	public void setBuuCucId(long buuCucId) {
		this.buuCucId = buuCucId;
	}
	public String toString(){
		return new Gson().toJson(this);
	}
}
