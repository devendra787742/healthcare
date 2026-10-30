package com.app.service;

import java.util.List;

import com.app.dto.*;

import com.app.entities.Doctor;

public interface IDoctorService {
	
 	List<Doctor> getAllDoctors();

 	List<Doctor> getDoctorsByDepartment(String deptName);
	
 	String addDoctorToDept(ReqAddDocDto transientDoctor);
	
 	String deleteDoctorById(long doctorId);
	
 	RespUpDocDto getDoctorById(long doctorId);
	
 	String updateDocDetails(ReqAddDocDto transientDoc);

	Boolean updateDoctorWorkStatus(long doctorId);

	Boolean updateDoctorValidStatus(long doctorId);

	List<RespValidDoctorDto> getDoctorByDepartmentName(long patientId);

	List<RespValidDoctorDto> getValidDoctorsByDepartment(String deptName);

}
