package com.app.controller;

import java.io.IOException;
import java.util.Map;

import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.app.dto.*;
import com.app.service.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/patient/{patientId}")
@CrossOrigin(origins = "http://localhost:3000/")
@SecurityRequirement(name = "app-security")   //add to controller whichever u want to secure

public class PatientController {
	
	@Autowired
	private ObjectMapper mapper;

	@Autowired
	private IDoctorService doctorService;

	@Autowired
	private IPatientService patientService;

	@Autowired
	private IAppointmentService appointmentService;

	@Autowired
	private ITreatmentService treatmentService;
	
	@Autowired
	private IFeedbackService feedbackService;
	
	@Autowired
	private IDepartmentService departmentService;

	@Operation(summary = "get Patient Appointment list")
	@GetMapping("/appointment")
	public ResponseEntity<?> getPatientAppointment(@PathVariable long patientId) {
		return new ResponseEntity<>(appointmentService.getPatientAppointment(patientId), HttpStatus.ACCEPTED);
	}
	
	@Operation(summary = "get Doctor by Department Name")
	@GetMapping("/{deptName}")
	public ResponseEntity<?> getDoctorByDeptName(@PathVariable String deptName){
		doctorService.getDoctorsByDepartment(deptName).forEach(System.out::println);
		return ResponseEntity.ok(doctorService.getValidDoctorsByDepartment(deptName));
	}
	
	@Operation(summary = "get DoctorDetails by Doctor ID")
	@GetMapping("/doctors/{doctorId}")
	public ResponseEntity<?> getDoctorById(@PathVariable long doctorId){
		return ResponseEntity.ok(doctorService.getDoctorById(doctorId));
	}
	
	@Operation(summary = "Appointment booking")
	@PostMapping("/appointment")
	public ResponseEntity<?> bookAppointment(@RequestBody @Valid BookAppointmentDto bookAppointmentDto) {
		System.out.println(bookAppointmentDto);
		log.info("Appointment booked with with patient id:"+ bookAppointmentDto.getPatientId());

		return new ResponseEntity<>(appointmentService.bookAppointment(bookAppointmentDto), HttpStatus.CREATED);
	}
	
	@Operation(summary = "appointment: cancel chosen appointment")
	@PatchMapping("/appointment/{appointmentId}")
	public ResponseEntity<?> cancelAppointment(@PathVariable long appointmentId) {
		log.info("Appointment cancelled with with appointment id:"+ appointmentId);

		return ResponseEntity.ok(appointmentService.cancelAppointment(appointmentId));
	}
	
	@Operation(summary = "Getting all departments for booking appointment")
	@GetMapping("/getAllDepartments")
	public ResponseEntity<?> getAllDepartments(){
		return ResponseEntity.ok(departmentService.getAllDepartment());
	}

	@Operation(summary = "PARTIAL patient treatment details")
	@GetMapping("/briefTreatmentList")
	public ResponseEntity<?> briefPatientList(@PathVariable long patientId) {
		return new ResponseEntity<>(treatmentService.getPartialPatientList(patientId), HttpStatus.ACCEPTED);
	}

	@Operation(summary = "get COMPLETE patient treatment details")
	@GetMapping("/treatmentDetails/{treatmentId}")
	public ResponseEntity<?> getPatientDetails(@PathVariable long treatmentId) {
		return new ResponseEntity<>(treatmentService.getCompletePatientDetails(treatmentId), HttpStatus.ACCEPTED);
	}

	@Operation(summary = "get patient details")
	@GetMapping("/patientDetails")
	public ResponseEntity<?> getPatientDetails(@PathVariable Long patientId) {
		return ResponseEntity.ok(patientService.getPatientDetails(patientId));
	}

	@Operation(summary = "update patient details")
	@PatchMapping("/patientDetails")
	public ResponseEntity<?> updatePatientDetails(@RequestParam String tPatient, @RequestParam MultipartFile imageFile)
			throws IOException {
		UpdatePatientDetailsDto transientPatient = mapper.readValue(tPatient, UpdatePatientDetailsDto.class);
		log.info("User registered with email :" + transientPatient.getEmail());
		System.out.println(transientPatient);
		return ResponseEntity.ok(patientService.updatePatientDetails(transientPatient, imageFile));
	}

	@Operation(summary = "doctor feedbacks")
	@GetMapping("/feedback/{doctorId}")
	public ResponseEntity<?> doctorsFeedback(@PathVariable long patientId, @PathVariable long doctorId) {
		return ResponseEntity.ok(feedbackService.doctorsFeedback(patientId, doctorId));
	}
	
	@Operation(summary = "doctor feedbacks")
	@PostMapping("/feedback")
	public ResponseEntity<?> doctorsFeedback(@RequestBody @Valid ReqFeedbackDto transientFeedback) {
		return new ResponseEntity<>(feedbackService.addDoctorsFeedback(transientFeedback), HttpStatus.CREATED);
	}

	@Operation(summary = "getting available timings for selected doctors")
	@PostMapping("/doctor-timing")
	public ResponseEntity<?> getAvailableTimings(@RequestBody @Valid ReqAvailableTimingForDoctor bookedSlot ) {
		return new ResponseEntity<>(appointmentService.getAvailableTimings(bookedSlot), HttpStatus.CREATED);
	}

	@Operation(summary = "Payment by Razor Pay")
	@PostMapping("/create_order")
	public String createOrder(@RequestBody Map<String, Object> data) throws RazorpayException {
		log.info("Order fun executed"+data.toString());
		int amount = Integer.parseInt(data.get("amount").toString());
		amount = amount*100;
		log.info("amount is = "+amount);
		var client = new RazorpayClient("rzp_test_VtAhpPLSMgpfZO", "Xy9l12sdntY3vay3isx6Q3A0");
		JSONObject options = new JSONObject();
		options.put("amount", amount);
		options.put("currency", "INR");
		options.put("receipt", "txn_123456");
		Order order = client.orders.create(options);
		return order.toString();
	}
		
}