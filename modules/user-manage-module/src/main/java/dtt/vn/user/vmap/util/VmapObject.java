package dtt.vn.user.vmap.util;

import com.google.gson.Gson;

public class VmapObject {
	String coordinates = "";
	String label ="";
	String region ="";
	String county ="";
	String locality ="";
	String country ="";
	String vnpost=null;
	public String getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getVnpost() {
		return vnpost;
	}
	public void setVnpost(String vnpost) {
		this.vnpost = vnpost;
	}
	public String toString(){
		return new Gson().toJson(this);
	}
}
