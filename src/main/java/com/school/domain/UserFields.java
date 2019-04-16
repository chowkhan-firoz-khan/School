package com.school.domain;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;


@Entity
//https://stackoverflow.com/questions/32625410/hibernate-foreign-key-with-a-part-of-composite-primary-key
public class UserFields extends SchoolEntity 
{
	@EmbeddedId
	private UserFieldId userFieldId;
	
	@MapsId("accountId")
	@ManyToOne(optional=false)
	@JoinColumns(value= {@JoinColumn(name="userId",referencedColumnName="id")})
	User user;
	
	public UserFieldId getUserFieldId() {
		return userFieldId;
	}

	public void setUserFieldId(UserFieldId userFieldId) {
		this.userFieldId = userFieldId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public EntityField getField() {
		return field;
	}

	public void setField(EntityField field) {
		this.field = field;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@MapsId("fieldId")
	@ManyToOne(optional=false)
	@JoinColumns(value= {@JoinColumn(name="fieldId",referencedColumnName="id")})
	EntityField field;
	
	private String value;
	
	
		
}
