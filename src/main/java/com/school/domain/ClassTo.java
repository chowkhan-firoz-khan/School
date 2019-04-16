package com.school.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity(name="class")
@Table(name="Class",uniqueConstraints= {@UniqueConstraint(columnNames= {"classCode","sectionCode","branch_id"})})
public class ClassTo extends SchoolEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=5)
	private String classCode;

	@Column(length=2)
	private String sectionCode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToMany(targetEntity=User.class,cascade=CascadeType.ALL)
	private Set<User> users = new HashSet<>();

	@ManyToOne(cascade = CascadeType.ALL)
	private Branch branch;

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

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public ClassTo(String classCode, String sectionCode, Set<User> users, Branch branch) {
		super();
		this.classCode = classCode;
		this.sectionCode = sectionCode;
		this.users = users;
		this.branch = branch;
	}

	public ClassTo() {
	
	}
	
}
