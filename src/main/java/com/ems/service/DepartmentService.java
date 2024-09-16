package com.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dao.DepartmentDao;
import com.ems.dto.DepartmentDTO;
import com.ems.entity.Department;
import com.ems.exception.ResourceNotFoundException;
import com.ems.mapper.DepartmentMapper;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentDao departmentDao;

	public DepartmentDTO createDepartment(DepartmentDTO departmentDTO) {
		Department department = DepartmentMapper.mapToDepartment(departmentDTO);
		Department savedDepartment = departmentDao.save(department);
		return DepartmentMapper.mapToDepartmentDTO(savedDepartment);

	}

	public DepartmentDTO getDepartmentById(Long departmentId) {
		Department department = departmentDao.findById(departmentId).orElseThrow(
				() -> new ResourceNotFoundException("Department does not exist with given id: " + departmentId));

		return DepartmentMapper.mapToDepartmentDTO(department);
	}

	public List<DepartmentDTO> getAllDepartments() {
		List<Department> departments = departmentDao.findAll();

		return departments.stream().map(dep -> DepartmentMapper.mapToDepartmentDTO(dep)).toList();
	}

	public DepartmentDTO updateDepartmentById(Long departmentId, DepartmentDTO updatedDepartmentDTO) {
		Department department = departmentDao.findById(departmentId).orElseThrow(
				() -> new ResourceNotFoundException("Department does not exist with given Id: " + departmentId));
		department.setDepartmentName(updatedDepartmentDTO.getDepartmentName());
		department.setDepartmentDescription(updatedDepartmentDTO.getDepartmentDescription());

		Department updatedDepartment = departmentDao.save(department);
		return DepartmentMapper.mapToDepartmentDTO(updatedDepartment);
	}
	
	public void deleteDepartmentById(Long departmentId) {
		Department department=departmentDao.findById(departmentId).orElseThrow(
				() -> new ResourceNotFoundException("Department does not exist with given Id: " + departmentId));
		departmentDao.deleteById(departmentId);
		
	}

}
