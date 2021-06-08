package com.automate.service;

import com.automate.pojo.DepartmentDetails;

public interface service {
	
	public DepartmentDetails getDepartmentById(Integer id);
	 public DepartmentDetails saveDepartment(DepartmentDetails departmentdetails);

}
