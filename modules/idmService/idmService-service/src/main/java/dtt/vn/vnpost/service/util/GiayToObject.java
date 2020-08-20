package dtt.vn.vnpost.service.util;

import com.google.gson.Gson;

public class GiayToObject {
	private String id ="";
	private String accountId ="";
	private String[] thuoctinh = null;
	private String[] attrkey =null;
	private String magt ="";
	private String giaytoId ="";
	private String base64 ="";
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getAccountId() {
		return accountId;
	}



	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}



	public String[] getThuoctinh() {
		return thuoctinh;
	}



	public void setThuoctinh(String[] thuoctinh) {
		this.thuoctinh = thuoctinh;
	}



	public String[] getAttrkey() {
		return attrkey;
	}



	public void setAttrkey(String[] attrkey) {
		this.attrkey = attrkey;
	}



	public String getMagt() {
		return magt;
	}



	public void setMagt(String magt) {
		this.magt = magt;
	}



	public String getGiaytoId() {
		return giaytoId;
	}



	public void setGiaytoId(String giaytoId) {
		this.giaytoId = giaytoId;
	}



	public String getBase64() {
		return base64;
	}



	public void setBase64(String base64) {
		this.base64 = base64;
	}



	
	
	
	public String toString(){
		return new Gson().toJson(this);
	}
	
}
