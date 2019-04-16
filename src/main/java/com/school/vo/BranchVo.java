package com.school.vo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.school.domain.Account;
import com.school.domain.Address;
import com.school.domain.Branch;

public class BranchVo 
{
	private Long accountId;
	
	private String action;
	
	private String method;
	
	private String branchCode;
	
	private String branchName;
	
	private String addLine1;
	
	private String aaddLine2;
	
	private String city;
	
	private String state;
	
	private String country;
	
	private Account account;
	
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	private List<String> validationErrors = new ArrayList<>();

	public Long getAccountId() {
		return accountId;
	}

	public List<String> getValidationErrors() {
		return validationErrors;
	}

	public void setValidationErrors(List<String> validationErrors) {
		this.validationErrors = validationErrors;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getAddLine1() {
		return addLine1;
	}

	public void setAddLine1(String addLine1) {
		this.addLine1 = addLine1;
	}

	public String getAaddLine2() {
		return aaddLine2;
	}

	public void setAaddLine2(String aaddLine2) {
		this.aaddLine2 = aaddLine2;
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
	
	public List<String> performValidation()
	{
		if(StringUtils.isEmpty(branchCode))
		{
			this.validationErrors.add("branch code is required");
		}
		if(StringUtils.isEmpty(this.branchName))
		{
			this.validationErrors.add("branch name is required");
		}
		if(StringUtils.isEmpty(this.addLine1))
		{
			this.validationErrors.add("Address Line is required");
		}
		return validationErrors;
	}
	
	public Branch getBranchEntity()
	{
		Address address = new Address(addLine1, aaddLine2, city, state, country);
		Branch branch = new Branch(branchCode, branchName, address, null, account);
		return branch;
	}
	
}
