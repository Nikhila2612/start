package com.automate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.automate.pojo.DepartmentDetails;
import com.automate.repo.Repository;

@Service
public class serviceImpl implements service{

@Autowired
Repository repository;

@Override
public DepartmentDetails getDepartmentById(Integer id) {
	return repository.findById(id).get();
}



@Override
public DepartmentDetails saveDepartment(DepartmentDetails departmentdetails) {
	repository.save(departmentdetails);
	return null;
}
}
