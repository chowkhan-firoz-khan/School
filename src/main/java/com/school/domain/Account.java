package com.school.domain;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Account extends SchoolEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique=true,length=10)
	private String accountName;

	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

	@OneToOne(cascade = CascadeType.ALL)
	private PointOfContact pointOfContact;

	private boolean isActive;
	
	@OneToMany(cascade=CascadeType.ALL,targetEntity=Branch.class)
	private Set<Branch> branches = new HashSet<>();

	public Set<Branch> getBranches() {
		return branches;
	}

	public void setBranches(Set<Branch> branches) {
		this.branches = branches;
	}

	@OneToMany(cascade=CascadeType.ALL)
	private Set<AccountFields> accountFields = new HashSet<>();
	
	public Set<AccountFields> getAccountFields() {
		return accountFields;
	}

	public void setAccountFields(AccountFields accountFields) {
		this.accountFields.add(accountFields);
	}

	public Long getId() {
		return id;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public PointOfContact getPointOfContact() {
		return pointOfContact;
	}

	public void setPointOfContact(PointOfContact pointOfContact) {
		this.pointOfContact = pointOfContact;
	}

	public boolean getActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public void setAccountFields(Set<AccountFields> accountFields) {
		this.accountFields = accountFields;
	}

	

}
