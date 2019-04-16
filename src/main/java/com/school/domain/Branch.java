package com.school.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity(name="branch")
@Table(uniqueConstraints= {@UniqueConstraint(columnNames= {"branchCode","account_id"})})
public class Branch extends SchoolEntity
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true,length=10)
	private String branchCode;
	
	private String branchName;
	
	@OneToOne(targetEntity=Address.class,cascade=CascadeType.ALL)
	private Address branchAddress;
	
	@OneToMany(cascade=CascadeType.ALL)
	private Set<ClassTo> classes = new HashSet<>();
	
	@ManyToOne(cascade=CascadeType.ALL,targetEntity=Account.class)
	private Account account;
	
	public Branch() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<ClassTo> getClasses() {
		return classes;
	}

	public void setClasses(Set<ClassTo> classes) {
		this.classes = classes;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
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

	public Address getBranchAddress() {
		return branchAddress;
	}

	public void setBranchAddress(Address branchAddress) {
		this.branchAddress = branchAddress;
	}

	public Branch(String branchCode, String branchName, Address branchAddress, Set<ClassTo> classes,
			Account account) {
		super();
		this.branchCode = branchCode;
		this.branchName = branchName;
		this.branchAddress = branchAddress;
		this.classes = classes;
		this.account = account;
	}
	
	
	
	
	
}
