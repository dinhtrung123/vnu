package dtt.vn.user.model;

public class DangKyToChucModel {
	String email, userName, password, tenToChuc, taxCode, nguoiDaiDien, dienThoaiNDD, soCMND_NDD, diaChiChiTiet , daYeuTo;
	long tinhId, quanHuyenId, phuongXaId;
	
	public String getDaYeuTo(){
		return daYeuTo;
	}
	
	public void setDaYeuto(String daYeuTo){
		this.daYeuTo = daYeuTo;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTenToChuc() {
		return tenToChuc;
	}
	public void setTenToChuc(String tenToChuc) {
		this.tenToChuc = tenToChuc;
	}
	public String getTaxCode() {
		return taxCode;
	}
	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}
	public String getNguoiDaiDien() {
		return nguoiDaiDien;
	}
	public void setNguoiDaiDien(String nguoiDaiDien) {
		this.nguoiDaiDien = nguoiDaiDien;
	}
	public String getDienThoaiNDD() {
		return dienThoaiNDD;
	}
	public void setDienThoaiNDD(String dienThoaiNDD) {
		this.dienThoaiNDD = dienThoaiNDD;
	}
	public String getSoCMND_NDD() {
		return soCMND_NDD;
	}
	public void setSoCMND_NDD(String soCMND_NDD) {
		this.soCMND_NDD = soCMND_NDD;
	}
	public String getDiaChiChiTiet() {
		return diaChiChiTiet;
	}
	public void setDiaChiChiTiet(String diaChiChiTiet) {
		this.diaChiChiTiet = diaChiChiTiet;
	}
	public long getTinhId() {
		return tinhId;
	}
	public void setTinhId(long tinhId) {
		this.tinhId = tinhId;
	}
	public long getQuanHuyenId() {
		return quanHuyenId;
	}
	public void setQuanHuyenId(long quanHuyenId) {
		this.quanHuyenId = quanHuyenId;
	}
	public long getPhuongXaId() {
		return phuongXaId;
	}
	public void setPhuongXaId(long phuongXaId) {
		this.phuongXaId = phuongXaId;
	}
}
