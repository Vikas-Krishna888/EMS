package com.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.dto.EmployeeDTO;
import com.ems.service.EmployeeService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// add new employee API
	@PostMapping
	public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
		EmployeeDTO savedEmployee = employeeService.createEmployee(employeeDTO);
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	}

	// get employee details by Id
	@GetMapping("{id}")
	public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") Long employeeId) {
		EmployeeDTO employee = employeeService.getEmployeeById(employeeId);
		return ResponseEntity.ok(employee);
	}

	// get all employee details
	@GetMapping
	public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
		List<EmployeeDTO> employees = employeeService.getAllEmployees();
		return ResponseEntity.ok(employees);
	}

	// update employee by Id API
	@PutMapping("{id}")
	public ResponseEntity<EmployeeDTO> updateEmployeeById(@PathVariable("id") Long employeeId,
			@RequestBody EmployeeDTO employeeDTO) {
		EmployeeDTO updatedEmployee = employeeService.updateEmployeeById(employeeId, employeeDTO);
		return ResponseEntity.ok(updatedEmployee);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") Long employeeId) {
		employeeService.deleteEmployeeById(employeeId);
		return ResponseEntity.ok("Employee deleted successfully");
	}
}
