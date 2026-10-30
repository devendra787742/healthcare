package com.app.service;

import java.util.List;

import com.app.dto.RespDepartmentDto;
import com.app.entities.Department;

public interface IDepartmentService {
	
	List<RespDepartmentDto> getAllDepartment();
	
	Department getByDepartment(String deptName);
	
	String deleteDepartmentById(long departmentId);
	
	String addDepartment(Department dept);
}
