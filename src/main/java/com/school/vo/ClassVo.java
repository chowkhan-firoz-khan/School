package com.school.vo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.school.domain.Branch;
import com.school.domain.ClassTo;

public class ClassVo 
{
	private String classCode;

	private String sectionCode;
	
	private Branch branch;
	
	private Long branchId;
	
	public Long getBranchId() {
		return branchId;
	}

	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	private List<String> validationErrors =new ArrayList<>();

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public String getSectionCode() {
		return sectionCode;
	}

	public void setSectionCode(String sectionCode) {
		this.sectionCode = sectionCode;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public List<String> getValidationErrors() {
		return validationErrors;
	}

	public void setValidationErrors(String validationErrors) {
		this.validationErrors.add(validationErrors);
	}
	
	public void performValidation() 
	{
		if(StringUtils.isEmpty(classCode))
		{
			this.validationErrors.add("Class Code Is Required");
		}
		if(StringUtils.isEmpty(sectionCode))
		{
			this.validationErrors.add("Section Code is Required");
		}
		if(this.branch == null)
		{
			this.validationErrors.add("Branch is Required");
		}
	}
	
	public ClassTo getEntity()
	{
		ClassTo classTo= new ClassTo(classCode,sectionCode,null,branch);
		
		return classTo;
	}
	
	
	
	
	
}
