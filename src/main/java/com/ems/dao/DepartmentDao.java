package com.ems.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.entity.Department;

public interface DepartmentDao extends JpaRepository<Department, Long> {

}
