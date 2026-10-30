package com.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.dao.*;
import com.app.dto.*;
import com.app.entities.*;
import com.app.exceptions.ResourceNotFoundException;

@Service
@Transactional
public class DoctorServiceImpl implements IDoctorService {

	@Autowired
	private IDepartmentRepository DepartmentRepo;
	
	@Autowired
	private IDoctorRepository DoctorRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public List<Doctor> getAllDoctors() {		
		return DoctorRepo.findAll();
	}

	@Override
	public List<Doctor> getDoctorsByDepartment(String deptName) {		
		return DoctorRepo.findByDepartment(deptName);
	}

	@Override
	public String addDoctorToDept(ReqAddDocDto transientDoctor) {
		Department dept = DepartmentRepo.findByDeptName(transientDoctor.getDepartment()).orElseThrow(()->new RuntimeException("Invalid Dept Name"));
		Doctor transientDoc = mapper.map(transientDoctor, Doctor.class);
		transientDoc.setPassword(encoder.encode(transientDoc.getPassword()));
		transientDoc.setDepartment(dept);
		DoctorRepo.save(transientDoc);
		return "Doctor added successfully";
	}

	@Override
	public String deleteDoctorById(long doctorId) {
			DoctorRepo.deleteById(doctorId);
		return "Doctor deleted successfully";
	}

	@Override
	public RespUpDocDto getDoctorById(long doctorId) {
		Doctor doc = DoctorRepo.findById(doctorId).orElseThrow(()-> new RuntimeException("Invalid doctor id!!!!!!!!!"));
		RespUpDocDto tempDocDto = mapper.map(doc, RespUpDocDto.class);
		tempDocDto.setDepartment(doc.getDepartment().getDeptName());
		return tempDocDto;
	}

	@Override
	public String updateDocDetails(ReqAddDocDto transientDoc) {		
		addDoctorToDept(transientDoc);
		return "Doctor updated successfully";
	}

	@Override
	public Boolean updateDoctorWorkStatus(long doctorId) {
		Doctor doctor = DoctorRepo.findById(doctorId).orElseThrow(()-> new RuntimeException("Invalid doctor id!!!!!!!!!"));
		System.out.println(" " + doctor);
		doctor.setWorking(!doctor.isWorking());
		DoctorRepo.save(doctor);
		return doctor.isWorking();
	}

	@Override
	public Boolean updateDoctorValidStatus(long doctorId) {
		Doctor doctor = DoctorRepo.findById(doctorId).orElseThrow(()-> new RuntimeException("Invalid doctor id!!!!!!!!!"));
		System.out.println(" " + doctor);
		doctor.setValidated(!doctor.isValidated());
		DoctorRepo.save(doctor);
		return doctor.isValidated();
	}

	@Override
	public List<RespValidDoctorDto> getDoctorByDepartmentName(long departmentId) {
		List<RespValidDoctorDto> doctorDtoList = new ArrayList<>();
		List<Doctor> doctorList = DoctorRepo.findByDept(departmentId, true, true);
		doctorList.forEach((doc)->{
			RespValidDoctorDto singleDocDto = mapper.map(doc, RespValidDoctorDto.class);
			doctorDtoList.add(singleDocDto);
			System.out.println(singleDocDto + "\n");
		});
		return doctorDtoList;
	}
	
	@Override
	public List<RespValidDoctorDto> getValidDoctorsByDepartment(String deptName) {
		List<RespValidDoctorDto> doctorDtoList = new ArrayList<>();
		long departmentId = DepartmentRepo.findByDeptName(deptName).orElseThrow(()-> new ResourceNotFoundException("No Such Department Found")).getId();
		List<Doctor> doctorList = DoctorRepo.findByDept(departmentId, true, true);
		doctorList.forEach((doc)->{
			RespValidDoctorDto singleDocDto = mapper.map(doc, RespValidDoctorDto.class);
			doctorDtoList.add(singleDocDto);
			System.out.println(singleDocDto + "\n");
		});
		return doctorDtoList;	
	}	
}
