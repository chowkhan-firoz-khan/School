package com.school.domain;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EntityField extends SchoolEntity
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String label;
	
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Enumerated(EnumType.STRING)
	private EntityFieldType fieldType;

	public Long getId() {
		return id;
	}

	public EntityField() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EntityField(Long id, String label, String name, EntityFieldType fieldType) {
		super();
		this.id = id;
		this.label = label;
		this.name = name;
		this.fieldType = fieldType;
	}

	public EntityField(String label, String name, EntityFieldType fieldType) {
		super();
		this.label = label;
		this.name = name;
		this.fieldType = fieldType;
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

	public EntityFieldType getFieldType() {
		return fieldType;
	}

	public void setFieldType(EntityFieldType fieldType) {
		this.fieldType = fieldType;
	}
	
	
}
