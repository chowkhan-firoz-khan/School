package com.school.domain;
import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class AccountFieldId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long accountId;

	private Long fieldId;

	public AccountFieldId(Long accountId, Long fieldId) {
		super();
		this.accountId = accountId;
		this.fieldId = fieldId;
	}

	public AccountFieldId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Long getFieldId() {
		return fieldId;
	}

	public void setFieldId(Long fieldId) {
		this.fieldId = fieldId;
	}

}
