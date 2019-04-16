package com.school.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.util.StringUtils;

import com.school.domain.EntityField;
import com.school.domain.EntityFieldType;

public class EntityFieldVo {

	private Long id;

	private String label;

	private String name;
	
	private String action;
	
	private String method;
	
	private List<String> validations;
	
	private EntityFieldType[] fieldTypes;
	
	public EntityFieldType[] getFieldTypes() {
		return EntityFieldType.values();
	}

	public void setFieldTypes(EntityFieldType[] fieldTypes) {
		this.fieldTypes = fieldTypes;
	}

	public List<String> getValidations() {
	
		return validations == null ? Collections.emptyList() :validations;
	}

	public void setValidations(List<String> validations) {
		this.validations = validations;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EntityFieldType getFieldType() {
		return fieldType;
	}

	public void setFieldType(EntityFieldType fieldType) {
		this.fieldType = fieldType;
	}

	private EntityFieldType fieldType;
	
	public EntityField toEntity()
	{
		EntityField field = new EntityField(this.id,this.label, this.name, this.fieldType);
		return field;
	}
	
	public void fromEntity(EntityField field)
	{
		this.label=field.getLabel();
		this.name=field.getName();
		this.fieldType =field.getFieldType();
		this.id= field.getId();
	}
	
	public void performValidations()
	{
		List<String> validations = new ArrayList<String>();
		if(StringUtils.isEmpty(name))
		{
			validations.add("Field Name is Required");
		}
		if(this.fieldType ==null)
		{
			validations.add("Field Type is Required");
		}
		this.validations=validations;
	}
	


}
