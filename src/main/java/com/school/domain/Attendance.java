package com.school.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Attendance extends SchoolEntity
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long attendanceId;
	
	@Temporal(TemporalType.DATE)
	private Date fromDate;
	
	@Temporal(TemporalType.DATE)
	private Date toDate;
	
	private int actualDays;
	
	private int attendedDays;
	
	@OneToMany(cascade=CascadeType.ALL)
	private Set<User> users = new HashSet<>();
	
	@OneToMany(cascade=CascadeType.ALL)
	private Set<ClassTo> classes = new HashSet<>();

	public Set<ClassTo> getClasses() {
		return classes;
	}

	public void setClasses(ClassTo classes) {
		this.classes.add(classes);
	}

	public Long getAttendanceId() {
		return attendanceId;
	}

	public void setAttendanceId(Long attendanceId) {
		this.attendanceId = attendanceId;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public int getActualDays() {
		return actualDays;
	}

	public void setActualDays(int actualDays) {
		this.actualDays = actualDays;
	}

	public int getAttendedDays() {
		return attendedDays;
	}

	public void setAttendedDays(int attendedDays) {
		this.attendedDays = attendedDays;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users.add(users);
	}

	public Attendance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Attendance(Date fromDate, Date toDate, int actualDays, int attendedDays) {
		super();
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.actualDays = actualDays;
		this.attendedDays = attendedDays;
	}
	
	
	
}
