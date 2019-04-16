package com.school.vo;

import org.springframework.util.StringUtils;

import com.school.domain.Address;
import com.school.domain.ClassTo;
import com.school.domain.User;

public class UserVo
{
    private String userCode;
   
	private String name;

	private String email;

	private String mobile;

	private String role;

	private String addressLine1;

	private String addressLine2;

	private String city;

	private String state;

	private String country;

	boolean failedRecord;
	
	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	private ClassTo classTo;

	public ClassTo getClassTo() {
		return classTo;
	}

	public void setClassTo(ClassTo classTo) {
		this.classTo = classTo;
	}

	public boolean isFailedRecord() {
		return failedRecord;
	}

	public void setFailedRecord(boolean failedRecord) {
		this.failedRecord = failedRecord;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void readRecord(String[] record) {
		if (record.length < 10) {
			this.failedRecord = true;
			return;
		}
		this.userCode=record[0];
		this.name = record[1];
		this.email = record[2];
		this.mobile = record[3];
		this.addressLine1 = record[4];
		this.addressLine2 = record[5];
		this.city = record[6];
		this.state = record[7];
		this.country = record[8];
		this.role = record[9];
		if (StringUtils.isEmpty(name) || StringUtils.isEmpty(email) || StringUtils.isEmpty(mobile)
				|| StringUtils.isEmpty(addressLine1) || StringUtils.isEmpty(role)) {
			this.failedRecord=true;
			return;
		}
	}
	public User getNewEntity()
	{
		Address address = new Address(null,addressLine1,addressLine2,city,state,country);
		User user = new User(name, null, "admin", this.email, this.mobile, this.classTo,null, address);
		return user;
	}
	

}
