package dtt.vn.user.service.service.util;

import com.google.gson.Gson;

public class ToChucModel {
String ParentUnitCode, ParentUnitName, UnitCode, UnitName, Address ;

public String getParentUnitCode() {
	return ParentUnitCode;
}

public void setParentUnitCode(String parentUnitCode) {
	ParentUnitCode = parentUnitCode;
}

public String getParentUnitName() {
	return ParentUnitName;
}

public void setParentUnitName(String parentUnitName) {
	ParentUnitName = parentUnitName;
}

public String getUnitCode() {
	return UnitCode;
}

public void setUnitCode(String unitCode) {
	UnitCode = unitCode;
}

public String getUnitName() {
	return UnitName;
}

public void setUnitName(String unitName) {
	UnitName = unitName;
}

public String getAddress() {
	return Address;
}

public void setAddress(String address) {
	Address = address;
}

public String toString(){
	return new Gson().toJson(this);
}
}
