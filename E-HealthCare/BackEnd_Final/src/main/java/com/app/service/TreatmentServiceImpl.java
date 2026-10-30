package com.app.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.*;
import com.app.dto.*;
import com.app.entities.*;
import com.app.exceptions.ResourceNotFoundException;

@Service
@Transactional

public class TreatmentServiceImpl implements ITreatmentService {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private ITreatmentRepository treatmentRepo;

	@Autowired
	private IDoctorRepository doctorRepo;

	@Autowired
	private IPatientRepository patientRepo;

	@Autowired
	private ILabTestRepository labRepo;
	

	@Override
	public String createTreatmentDetails(ReqTreatmentDto transientTreatment) {

		// Treatment treatment =
		Treatment treatment = mapper.map(transientTreatment, Treatment.class);
		treatment.setTreatmentDate(LocalDate.now());
		treatment.setPatient(patientRepo.findById(transientTreatment.getPatient())
				.orElseThrow(() -> new RuntimeException("Invalid Patient Id")));
		treatment.setDoctor(doctorRepo.findById(transientTreatment.getDoctor())
				.orElseThrow(() -> new RuntimeException("Invalid Doctor Id")));
		System.out.println(transientTreatment);
		// transientTreatment.labTests.forEach(lab -> treatment.setLabTests(lab));

		long[] labNos = transientTreatment.getLabTestNo();
		List<LabTest> labList = new ArrayList<LabTest>();
		for (long i : labNos) {
			System.out.println("BEFORE adding lab test to list");
			LabTest temp = labRepo.findById(i).orElseThrow(() -> new RuntimeException("Invalid LabId"));
			System.out.println(i + " ---- " + temp);
			labList.add(temp);
		}
		treatment.setLabTests(labList);

		treatmentRepo.save(treatment);

//		Treatment treatment = treatmentRepo.findById((long)3).orElseThrow(()-> new RuntimeException("Invalid Id"));
//		List<LabTest> labtestlist = new ArrayList<>();
//		labtestlist.add(labRepo.findById((long)5).orElseThrow(()-> new RuntimeException("Invalid Id")));
//		//labtestlist.add(labRepo.findById((long)4).orElseThrow(()-> new RuntimeException("Invalid Id")));
//		//labtestlist.add(labRepo.findById((long)).orElseThrow(()-> new RuntimeException("Invalid Id")));
//		treatment.setLabTests(labtestlist);

		return "Success";
	}

	@Override
	public List<RespTreatmentDto> getPatientHistory(/* long doctorId, */ long patientId) {
		List<RespTreatmentDto> resptreatmentList = new ArrayList<>();
		// we have treatmentlist
		// List<Treatment> treatmentList =
		// treatmentRepo.findByPatient(patientRepo.findById(patientId).orElseThrow(()->
		// new ResourceNotFoundException("Patient not found")));
		List<Treatment> treatmentList = treatmentRepo.getTreatmentList(patientId);
		treatmentList.forEach(treatment -> {
			RespTreatmentDto resp = new RespTreatmentDto();
			resp = mapper.map(treatment, RespTreatmentDto.class);
			resp.setDoctorName(treatment.getDoctor().getName());
			resptreatmentList.add(resp);
		});
		System.out.println("\n " + resptreatmentList);
		return resptreatmentList;
	}

	@Override
	public RespTreatmentDto getLabAndMedicine(long patientId) {
		Treatment treatment = treatmentRepo.getTreatment(patientId);
		RespTreatmentDto resp = mapper.map(treatment, RespTreatmentDto.class);
		return resp;
	}

	@Override
	public List<RespBriefTreatmentDetails> getPartialPatientList(long patientId) {
		List<RespBriefTreatmentDetails> treatment = new ArrayList<>();
		Patient currentPatient = patientRepo.findById(patientId)
				.orElseThrow(() -> new ResourceNotFoundException("Patient with id: " + patientId + " not found"));
		treatmentRepo.findByPatient(currentPatient).forEach(t -> {
			RespBriefTreatmentDetails resp = mapper.map(t, RespBriefTreatmentDetails.class);
			resp.setDoctor(t.getDoctor().getName());
			resp.setDoctorId(t.getDoctor().getId());
			resp.setPatientId(patientId);
			treatment.add(resp);
		});
		Collections.reverse(treatment);
		return treatment;
	}

	@Override
	public RespCompleteTreatmentDetails getCompletePatientDetails(long treatmentId) {
		RespCompleteTreatmentDetails resp = new RespCompleteTreatmentDetails();
		Treatment t = treatmentRepo.findById(treatmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Treatment Details not Found"));
		resp = mapper.map(t, RespCompleteTreatmentDetails.class);
		
		resp.setDoctor(t.getDoctor().getName());
		resp.setPatient(t.getPatient().getName());
		resp.setLabTests(t.getLabTests());

		return resp;
	}

}
