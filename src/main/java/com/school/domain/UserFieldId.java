package com.school.domain;
import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class UserFieldId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long userId;

	private Long fieldId;

	public UserFieldId(Long userId, Long fieldId) {
		super();
		this.userId = userId;
		this.fieldId = fieldId;
	}

	public UserFieldId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getFieldId() {
		return fieldId;
	}

	public void setFieldId(Long fieldId) {
		this.fieldId = fieldId;
	}

}
