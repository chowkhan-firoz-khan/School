package com.school.vo;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.school.domain.Attendance;

import utils.CommonUtils;

public class AttendanceVo 
{
	private String userId;
	
	private Date fromDate;
	
	private Date toDate;
	
	private int actualDays;
	
	private int attendedDays;
	
	private boolean isFailedRecord;
	
	private String error;
	
	public Attendance getEntity()
	{
		return new Attendance(fromDate, toDate, actualDays, attendedDays);
	}
	
	public void populateData(String[] row)
	{
		try
		{
			if(row == null)
			{
				isFailedRecord = true;
				return;
			}
			else
			{
				this.userId = row[0];
				if(StringUtils.isBlank(userId))
				{
					this.error="User id Required";
					this.isFailedRecord=true;
					return;
				}
				this.fromDate = CommonUtils.getDate(row[1]);
				if(fromDate == null)
				{
					this.error="from date is required";
					this.isFailedRecord=true;
					return;
				}
				this.toDate =CommonUtils.getDate(row[2]);
				if(toDate == null)
				{
					this.error="to date is required";
					this.isFailedRecord=true;
					return;
				}
				this.actualDays=Integer.parseInt(row[3]);
				if(actualDays<= 0)
				{
					this.error="actualDays is required";
					this.isFailedRecord=true;
					return;
				}
				this.attendedDays= Integer.parseInt(row[4]);
				if(attendedDays<= 0)
				{
					this.error="attendedDays is required";
					this.isFailedRecord=true;
					return;
				}
				if(actualDays < attendedDays)
				{
					this.error="attendedDays should not greater than actual days";
					this.isFailedRecord=true;
					return;
				}
			
			}
		}
		catch(Exception e)
		{
			this.error= this.userId+"-----"+e.getMessage();
			this.isFailedRecord=true;
			return;
		}
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public boolean isFailedRecord() {
		return isFailedRecord;
	}

	public void setFailedRecord(boolean isFailedRecord) {
		this.isFailedRecord = isFailedRecord;
	}
		
}
