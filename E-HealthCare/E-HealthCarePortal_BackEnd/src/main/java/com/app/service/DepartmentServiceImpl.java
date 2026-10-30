package com.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IDepartmentRepository;
import com.app.dto.RespDepartmentDto;
import com.app.entities.Department;

@Service
@Transactional
public class DepartmentServiceImpl implements IDepartmentService {

	@Autowired
	private IDepartmentRepository departmentRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public List<RespDepartmentDto> getAllDepartment() {
		List<Department> deptList = departmentRepo.findAll();
		List<RespDepartmentDto> deptDtoList = new ArrayList<RespDepartmentDto>();
		deptList.forEach((dept)->deptDtoList.add(mapper.map(dept,RespDepartmentDto.class)));
		return deptDtoList;
	}

	@Override
	public Department getByDepartment(String deptName) {		
		return departmentRepo.findByDeptName(deptName).orElseThrow(()->new RuntimeException("Invalid Dept Name"));
	}

	@Override
	public String deleteDepartmentById(long departmentId) {
		departmentRepo.deleteById(departmentId);
		return "Department deleted successfully !!";
	}

	@Override
	public String addDepartment(Department dept) {
		departmentRepo.save(dept);
		return "Department added successfully!!!!";
	}
	

}
