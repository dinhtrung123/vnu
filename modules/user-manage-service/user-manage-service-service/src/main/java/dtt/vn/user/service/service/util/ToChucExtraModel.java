package dtt.vn.user.service.service.util;

import com.google.gson.Gson;

public class ToChucExtraModel {
	String tenToChucCapTren, fax, noiCapGiayToNDD, diaChiChiTietNoiXacMinh;
	long noiXacMinhId, tinhThanhBuuCucId, quanHuyenBuuCucId, phuongXaBuuCucId, buuCucId;
	public String getTenToChucCapTren() {
		return tenToChucCapTren;
	}
	public void setTenToChucCapTren(String tenToChucCapTren) {
		this.tenToChucCapTren = tenToChucCapTren;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getNoiCapGiayToNDD() {
		return noiCapGiayToNDD;
	}
	public void setNoiCapGiayToNDD(String noiCapGiayToNDD) {
		this.noiCapGiayToNDD = noiCapGiayToNDD;
	}
	public String getDiaChiChiTietNoiXacMinh() {
		return diaChiChiTietNoiXacMinh;
	}
	public void setDiaChiChiTietNoiXacMinh(String diaChiChiTietNoiXacMinh) {
		this.diaChiChiTietNoiXacMinh = diaChiChiTietNoiXacMinh;
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
