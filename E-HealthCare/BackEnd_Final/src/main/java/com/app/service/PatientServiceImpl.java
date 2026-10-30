package com.app.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.dao.*;
import com.app.dto.*;
import com.app.entities.*;
import com.app.exceptions.ResourceNotFoundException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class PatientServiceImpl implements IPatientService {

	@Value("${file.upload.location}")
	private String folderLocation;

	@Autowired
	private IPatientRepository patientRepo;

	@Autowired
	private ITreatmentService treatmentService;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private PasswordEncoder encoder;

//	private Patient ;

	@Override
	public List<Patient> getAllPatients() {
		return patientRepo.findAll();
	}

	@PostConstruct
	public void anyInit() {
		// chk if folder exists --if not create one !
		// java.io.File => represents abstract path to a file /folder
		File folder = new File(folderLocation);
		if (!folder.exists()) {
			folder.mkdirs();
		}
		else {
			log.info("folder already exists");
		}
		
	}

	@Override
	public String deletePatientById(long patientId) {
		// TODO Auto-generated method stub
		patientRepo.deleteById(patientId);
		return "Patient deleted Succesfully!!!!!!!";
	}

	public Patient getPatientDetails(/* Long doctorId, */ Long patientId) {
		return patientRepo.findById(patientId).orElseThrow(() -> new RuntimeException("Invalid Dept Name"));
	}

//	@Override
//	public String addPatientDetails(RegisterPatientDto transientPatient) {
//		Patient patient = mapper.map(transientPatient, Patient.class);
//		patient.setPassword(encoder.encode(transientPatient.getPassword()));
//		patientRepo.save(patient);
//		return "Patient Registered Successfully.";
//	}
	
	@Override
	public String addPatientDetails(RegisterPatientDto transientPatient, MultipartFile file) {
		Patient patient = mapper.map(transientPatient, Patient.class);
		try {
			if (file.isEmpty()) {
				System.out.println("File is empty!!");
			} else {
				patient.setImagePath(file.getOriginalFilename());
				String path = folderLocation + File.separator + file.getOriginalFilename();
				Files.copy(file.getInputStream(), Paths.get(path), StandardCopyOption.REPLACE_EXISTING);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		patient.setPassword(encoder.encode(transientPatient.getPassword()));
		patientRepo.save(patient);
		return "Patient Registered Successfully.";
	}


	@Override
	public List<RespTreatmentDto> getTreatmentPatientDetails(long patientId) {
		return treatmentService.getPatientHistory(patientId);
	}

//	@Override
//	public String updatePatientDetails(RegisterPatientDto transientPatient) {
//		return addPatientDetails(transientPatient);
//	}

//	@Override
//	public String saveImage(RegisterPatientDto registerPatientDto) throws IOException {
//		Patient patient = mapper.map(registerPatientDto, Patient.class);
////		Patient patient = patientRepo.findById(patientId)
////				.orElseThrow(() -> new ResourceNotFoundException("Invalid Patient ID : Can't save image !!!!!!!"));
//		String path = folderLocation + File.separator + registerPatientDto.getImageFile().getOriginalFilename();
//		patient.setImagePath(path);// update query upon commit
//		Files.copy(registerPatientDto.getImageFile().getInputStream(), Paths.get(path),
//				StandardCopyOption.REPLACE_EXISTING);
//
//		patientRepo.save(patient);
//		return "Image Saved Successfully";
//	}

	@Override
	public String updatePatientDetails(UpdatePatientDetailsDto registerPatientDto, MultipartFile file) {
		// TODO Auto-generated method stub
//		return addPatientDetails(registerPatientDto, file);
		Patient patient = mapper.map(registerPatientDto, Patient.class);
		Patient existingdata =patientRepo.findById(registerPatientDto.getId()).orElseThrow(()->new ResourceNotFoundException("Patient not found"));
		try {
			if (file.isEmpty()) {
				System.out.println("File is empty!!");
			} else {
				patient.setImagePath(file.getOriginalFilename());
				String path = folderLocation + File.separator + file.getOriginalFilename();
				Files.copy(file.getInputStream(), Paths.get(path), StandardCopyOption.REPLACE_EXISTING);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		patient.setPassword(existingdata.getPassword());
		patientRepo.save(patient);
		return "Patient Registered Successfully.";
	}
	
	
	// ---Sending image to react 
	// method for restoring an image
		@Override
		public byte[] restoreImage(long patientId) throws IOException {
		
	Patient tempPatient = patientRepo.findById(patientId).orElseThrow(()-> new ResourceNotFoundException("Paitent not found for "+patientId));
			
			// =>valid emp id ,get image path from db
			String path =folderLocation + File.separator +tempPatient.getImagePath();// OR in case of img stored in DB : emp.getImage() ---> byte[]
			System.out.println(path);
			// java.nio.file.Files : public byte[] readAllBytes(Path path) throws IOExc
			if (path != null)
				return Files.readAllBytes(Paths.get(path));
			// => image is not yet assigned --throw exc to alert front end
			throw new ResourceNotFoundException("Image not  yet assigned , for emp " + tempPatient.getName());
		}

}
