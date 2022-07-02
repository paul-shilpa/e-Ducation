package com.SPASM.model;

public class RegistrationModel {
private String user;
private String mailId;
private String contactNo;

public String getContactNo() {
	return contactNo;
}
public void setContactNo(String contactNo) {
	this.contactNo = contactNo;
}
public String getUser() {
	return user;
}
public void setUser(String user) {
	this.user = user;
}
public String getMailId() {
	return mailId;
}
public void setMailId(String mailId) {
	this.mailId = mailId;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
private String password;
}
