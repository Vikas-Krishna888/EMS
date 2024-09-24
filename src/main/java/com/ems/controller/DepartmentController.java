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

import com.ems.dto.DepartmentDTO;
import com.ems.service.DepartmentService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;

	@PostMapping
	public ResponseEntity<DepartmentDTO> createDepartment(@RequestBody DepartmentDTO departmentDTO) {
		DepartmentDTO department = departmentService.createDepartment(departmentDTO);
		return new ResponseEntity<>(department, HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable("id") Long departmentId) {
		DepartmentDTO department = departmentService.getDepartmentById(departmentId);
		return ResponseEntity.ok(department);

	}
	
	@GetMapping
	public ResponseEntity<List<DepartmentDTO>> getDepartmentById(){
		List<DepartmentDTO> departments=departmentService.getAllDepartments();
		return ResponseEntity.ok(departments);

	}
	
	@PutMapping("{id}")
	public ResponseEntity<DepartmentDTO> updateDepartmentById(@PathVariable("id") Long departmentId, @RequestBody DepartmentDTO departmentDTO) {
		DepartmentDTO department = departmentService.updateDepartmentById(departmentId, departmentDTO);
		return ResponseEntity.ok(department);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteDepartmentById(@PathVariable("id") Long departmentId ){
		departmentService.deleteDepartmentById(departmentId);
		return ResponseEntity.ok("Department deleted successfully");
	}
	
	
}
