package com.ems.mapper;

import com.ems.dto.EmployeeDTO;
import com.ems.entity.Employee;

public class EmployeeMapper {
	
	public static EmployeeDTO mapToEmployeeDTO(Employee employee) {
		return new EmployeeDTO(employee.getId(),employee.getFirstName(),employee.getLastName(),employee.getEmail(),employee.getDepartment().getId());
	}
	
	public static Employee mapToEmployee(EmployeeDTO employeeDTO) {
		Employee employee=new Employee();
		employee.setId(employeeDTO.getId());
		employee.setFirstName(employeeDTO.getFirstName());
		employee.setLastName(employeeDTO.getLastName());
		employee.setEmail(employeeDTO.getEmail());
		
		return employee ;
	}
}
