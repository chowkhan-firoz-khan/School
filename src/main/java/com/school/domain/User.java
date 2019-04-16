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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
public class User extends SchoolEntity
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@Column(unique=true)
	private String userId;
		
	private String password;
	
	private String email;
	
	private String mobile;
	
	@ManyToMany(mappedBy="users")
	private Set<ClassTo> classes = new HashSet<>();
		
	@OneToMany
	private Set<UserFields> userFields = new HashSet<>();
	
	@OneToOne(cascade=CascadeType.ALL,targetEntity=Address.class)
	private Address address;
	
	@OneToMany(cascade=CascadeType.MERGE,targetEntity=UserRole.class)
	private Set<UserRole> userRole = new HashSet<>();
	
	
	 

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getEmail() {
		return email;
	}

	public Set<UserRole> getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole.add(userRole);
	}

	public User(String name, String userId, String password, String email, String mobile, ClassTo classes,
			Set<UserFields> userFields, Address address) {
		super();
		this.name = name;
		this.userId = userId;
		this.password = password;
		this.email = email;
		this.mobile = mobile;
		this.classes.add(classes);
		this.userFields = userFields;
		this.address = address;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Set<UserFields> getUserFields() {
		return userFields;
	}

	public void setUserFields(Set<UserFields> userFields) {
		this.userFields = userFields;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Set<ClassTo> getClasses() {
		return classes;
	}

	public void setClasses(ClassTo classTo) {
		this.classes.add(classTo);
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.userId.hashCode();
	}
	@Override
	public boolean equals(Object user) 
	{
		if(user ==null || !(user instanceof User))
			return false;
		else
		{
			User userObj = (User) user;
			return userObj.userId.equals(this.userId);
		}
	}
		
}
