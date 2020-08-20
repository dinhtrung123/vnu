package dtt.vn.xacminh.business;

import com.google.gson.Gson;
import com.liferay.portal.kernel.util.GroupSubscriptionCheckSubscriptionSender;

public class MessageObject {
	private String id ="";
	private String[] thuoctinh = null;
	private String[] attrkey =null;
	private String tengt ="";
	private String loaigt ="";
	private String coquan ="";
	private String hieuluc ="";
	private String urlfile ="";
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getTengt() {
		return tengt;
	}
	public void setTengt(String tengt) {
		this.tengt = tengt;
	}
	public String getLoaigt() {
		return loaigt;
	}
	public void setLoaigt(String loaigt) {
		this.loaigt = loaigt;
	}
	public String getCoquan() {
		return coquan;
	}
	public void setCoquan(String coquan) {
		this.coquan = coquan;
	}
	public String getHieuluc() {
		return hieuluc;
	}
	public void setHieuluc(String hieuluc) {
		this.hieuluc = hieuluc;
	}
	public String getUrlfile() {
		return urlfile;
	}
	public void setUrlfile(String urlfile) {
		this.urlfile = urlfile;
	}
	
	
	public String toString(){
		return new Gson().toJson(this);
	}
	
}
