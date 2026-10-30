package com.app.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.app.dto.*;
import com.app.entities.*;

public interface IPatientService {

	List<Patient> getAllPatients();

	String deletePatientById(long patientId);

	//RespPAtientDto to be used instead of PAtinet pojo
	Patient getPatientDetails(/*Long doctorId,*/ Long patientId);

	String addPatientDetails(RegisterPatientDto registerPatientDto, MultipartFile file);
//	String addPatientDetails(RegisterPatientDto registerPatientDto);
	
	List<RespTreatmentDto> getTreatmentPatientDetails(long patientId);

	String updatePatientDetails(UpdatePatientDetailsDto registerPatientDto, MultipartFile file);
//	String updatePatientDetails(RegisterPatientDto registerPatientDto);

//	String saveImage(long patientId, MultipartFile imgFile) throws IOException;
//	String saveImage(RegisterPatientDto registerPatientDto) throws IOException;

	byte[] restoreImage(long empId) throws IOException;

}
