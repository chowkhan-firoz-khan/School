package com.school.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserRole {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String label;
	
	@Column(unique=true)
	private String role;

	public UserRole(String label, String role) {
		super();
		this.label = label;
		this.role = role;
	}
	public Long getId() {
		return id;
	}
	@Override
	public boolean equals(Object obj) 
	{
		if(!(obj instanceof UserRole))
		{
			return false;
		}
		UserRole role = (UserRole) obj;
		return this.role.equals(role.getRole());
	}
	 @Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.getRole().hashCode();
	}

	public UserRole() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
