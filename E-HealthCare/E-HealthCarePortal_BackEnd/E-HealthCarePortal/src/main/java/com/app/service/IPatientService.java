package com.app.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.app.dto.*;
import com.app.entities.*;

public interface IPatientService {

	List<Patient> getAllPatients();

	String deletePatientById(long patientId);

	Patient getPatientDetails(Long patientId);

	String addPatientDetails(RegisterPatientDto registerPatientDto, MultipartFile file);
	
	List<RespTreatmentDto> getTreatmentPatientDetails(long patientId);

	String updatePatientDetails(UpdatePatientDetailsDto registerPatientDto, MultipartFile file);

	byte[] restoreImage(long empId) throws IOException;

}
