package com.automate.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.automate.pojo.DepartmentDetails;

public interface Repository extends JpaRepository<DepartmentDetails ,Integer>{

}
