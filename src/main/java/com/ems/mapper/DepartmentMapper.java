package com.ems.mapper;

import com.ems.dto.DepartmentDTO;
import com.ems.entity.Department;

public class DepartmentMapper {
	public static DepartmentDTO mapToDepartmentDTO(Department department) {
		return new DepartmentDTO(department.getId(),department.getDepartmentName(),department.getDepartmentDescription());
	}
	
	public static Department mapToDepartment(DepartmentDTO departmentDTO) {
		return new Department(departmentDTO.getId(),departmentDTO.getDepartmentName(),departmentDTO.getDepartmentDescription());
	}
}
