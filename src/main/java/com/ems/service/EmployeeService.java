package com.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dao.EmployeeDao;
import com.ems.dto.EmployeeDTO;
import com.ems.entity.Employee;
import com.ems.exception.ResourceNotFoundException;
import com.ems.mapper.EmployeeMapper;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
		Employee employee= EmployeeMapper.mapToEmployee(employeeDTO);
		Employee savedEmployee=employeeDao.save(employee);
		return EmployeeMapper.mapToEmployeeDTO(savedEmployee);
	}
	
	public EmployeeDTO getEmployeeById(Long employeeId) {
		Employee employee=employeeDao.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee does not exist with given Id: "+employeeId));
		return EmployeeMapper.mapToEmployeeDTO(employee);
	}
	
	public List<EmployeeDTO> getAllEmployees(){
		List<Employee> employees= employeeDao.findAll();
		return employees.stream().map(emp->EmployeeMapper.mapToEmployeeDTO(emp)).toList();
				
	}
	
	public EmployeeDTO updateEmployeeById(Long employeeId,EmployeeDTO updatedEmployeeDTO) {
		Employee employee=employeeDao.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee does not exist with given Id: "+employeeId));
		employee.setFirstName(updatedEmployeeDTO.getFirstName());
		employee.setLastName(updatedEmployeeDTO.getLastName());
		employee.setEmail(updatedEmployeeDTO.getEmail());
		Employee updatedEmployee=employeeDao.save(employee);
		return EmployeeMapper.mapToEmployeeDTO(updatedEmployee);
	}
	
	public void deleteEmployeeById(Long employeeId) {
		Employee employee=employeeDao.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee does not exist with given Id: "+employeeId));
		employeeDao.deleteById(employeeId);
	}
}
