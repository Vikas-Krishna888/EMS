package com.ems.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.entity.Employee;

public interface EmployeeDao extends JpaRepository<Employee , Long> {
	
}
