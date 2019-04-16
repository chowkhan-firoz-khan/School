package com.school.domain;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class SchoolEntity
{
	@Temporal(TemporalType.TIMESTAMP)	
	@Column(name="created_on")
	private Date createdOn;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_on")
	private Date updatedOn;
	
	@Column(name="created_by")
	private Long createdBy;
	
	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Long getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	@Column(name="updated_by")
	private Long modifiedBy;
	
	@PrePersist
	public void track()
	{
		this.createdBy=Long.valueOf(1);
		this.modifiedBy=Long.valueOf(1);
		this.createdOn=new Date();
		this.updatedOn=new Date();
	}
	
	@PreUpdate
	public void trackUpdate()
	{
		this.modifiedBy=Long.valueOf(1);
		this.updatedOn= new Date();
	}
	
	
}
