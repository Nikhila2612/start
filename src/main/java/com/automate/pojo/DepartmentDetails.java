package com.automate.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="departmentdetails")

public class DepartmentDetails {

	@Id
	
@GeneratedValue(strategy=GenerationType.IDENTITY)
 
	private int id;
	private String name;
	private String emailid;
	private long phoneno;
	
	public DepartmentDetails() {
		super();
	}
	
	public DepartmentDetails(int id, String name, String emailid, long phoneno) {
		super();
		this.id = id;
		this.name = name;
		this.emailid = emailid;
		this.phoneno = phoneno;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public long getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}



}
