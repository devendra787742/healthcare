package com.app.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IDoctorRepository;
import com.app.dao.IFeedbackRepository;
import com.app.dao.IPatientRepository;
import com.app.dao.ITreatmentRepository;
import com.app.dto.ReqFeedbackDto;
import com.app.dto.RespFeedbackDto;
import com.app.entities.Doctor;
import com.app.entities.Feedback;
import com.app.entities.Patient;
import com.app.exceptions.ResourceNotFoundException;

@Service
@Transactional
public class FeedbackService implements IFeedbackService{

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private IDoctorRepository doctorRepo;

	@Autowired
	private IPatientRepository patientRepo;

	@Autowired
	private ITreatmentRepository treatmentRepo;
	
	@Autowired
	private IFeedbackRepository feedbackRepo;
	
	@Override
	public RespFeedbackDto doctorsFeedback(long patientId, long doctorId) {
		patientRepo.findById(patientId).orElseThrow(()->new ResourceNotFoundException("PatientId not found"));
		Doctor doctor = doctorRepo.findById(doctorId).orElseThrow(()->new ResourceNotFoundException("DoctorId not found"));
		RespFeedbackDto doctorDto = new RespFeedbackDto();
		doctorDto.setDepartmentName(doctor.getDepartment().getDeptName());
		doctorDto.setDoctorName(doctor.getName());
		return doctorDto;
	}

	@Override
	public String addDoctorsFeedback(ReqFeedbackDto transientFeedback) {
		
		Patient patient = patientRepo.findById(transientFeedback.getPatient()).orElseThrow(()->new ResourceNotFoundException("PatientId not found"));
		Doctor doctor = doctorRepo.findById(transientFeedback.getDoctor()).orElseThrow(()->new ResourceNotFoundException("DoctorId not found"));
		System.out.println(treatmentRepo.findByPatientAndDoctor(patient, doctor).size() );
		if(treatmentRepo.findByPatientAndDoctor(patient, doctor).size() == 0) {
			throw new ResourceNotFoundException("You must visit the doctor inorder to comment.");
		}		
		Feedback feedback = mapper.map(transientFeedback, Feedback.class);
		
		feedback.setPatient(patient);
		feedback.setDoctor(doctor);
		feedbackRepo.save(feedback);
		return "Feedback Added Successfully";
	}
}