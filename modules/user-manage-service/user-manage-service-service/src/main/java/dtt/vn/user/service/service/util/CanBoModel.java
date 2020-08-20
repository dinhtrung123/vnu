package dtt.vn.user.service.service.util;

import com.google.gson.Gson;

public class CanBoModel {
String userName, fullName, email, password, nameRules, userRole;

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public String getFullName() {
	return fullName;
}

public void setFullName(String fullName) {
	this.fullName = fullName;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getNameRules() {
	return nameRules;
}

public void setNameRules(String nameRules) {
	this.nameRules = nameRules;
}

public String getUserRole() {
	return userRole;
}

public void setUserRole(String userRole) {
	this.userRole = userRole;
}
public String toString(){
	return new Gson().toJson(this);
}
}
