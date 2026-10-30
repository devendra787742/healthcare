package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ReqTreatmentDto;
import com.app.service.IAppointmentService;
import com.app.service.ILabTestService;
import com.app.service.IPatientService;
import com.app.service.ITreatmentService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/doctor/{doctorId}")
@CrossOrigin(origins = "http://localhost:3000/")
public class DoctorController {
	
	@Autowired
	private IAppointmentService appointmentService;
	
	@Autowired
	private IPatientService patientService;

	@Autowired
	private ITreatmentService treatmentService;
	
	@Autowired
	private ILabTestService labTestService;
	
	@GetMapping("/patientsToday")
	public ResponseEntity<?> showPatientsToday(@PathVariable Long doctorId){
		System.out.println("DoctorID: " + doctorId);
		return ResponseEntity.ok(appointmentService.getTodaysAppointments(doctorId));
	}
	
	@GetMapping("/patientsFuture")
	public ResponseEntity<?> showPatientsFuture(@PathVariable Long doctorId){
		return ResponseEntity.ok(appointmentService.getFuturesAppointments(doctorId));
	}
	
	@GetMapping("/patientsRequest")
	public ResponseEntity<?> showPatientsRequest(@PathVariable Long doctorId){
		return ResponseEntity.ok(appointmentService.getPendingAppointments(doctorId));
	}
	
	@GetMapping("/getPatientDetails/{patientId}")
	public ResponseEntity<?> getPatientDetails(@PathVariable Long doctorId, @PathVariable Long patientId){
		return ResponseEntity.ok(patientService.getPatientDetails(/*doctorId,*/ patientId));
	}
	
//	@ApiOperation(value = "convert appoinment from pending to confirm", notes = "confirm or cancel the appoinment")
//	@ApiResponses(value = {
//	  @ApiResponse(code = 200, message = "appoinment or cancelled accepted"),
//	  @ApiResponse(code = 404, message = "Not found")
//	})

	@Operation(summary = "cancel appointment")
	@PatchMapping("/Appointment/{appointmentId}")
	public ResponseEntity<?> cancelAppointment(@PathVariable Long appointmentId) {
		log.info("Appointment cancelled with appointment id:"+ appointmentId);	
		
		return new ResponseEntity<>(appointmentService.cancelAppointment(appointmentId),HttpStatus.ACCEPTED);
	}
	
	@Operation(summary = "convert appointment from pending to confirm")
	@PatchMapping("/confirmAppointment/{appointmentId}")
	public ResponseEntity<?> confirmAppointment(@PathVariable Long appointmentId) {
		log.info("Appointment confirmed with appointment id:"+ appointmentId);
		return new ResponseEntity<>(appointmentService.confirmAppointment(appointmentId),HttpStatus.ACCEPTED);
	}
	
	@Operation(summary = "adding treatment details to database")
	@PostMapping("/treatmentDetailsEntry")
	public ResponseEntity<?> createTreatmentDetails(@RequestBody @Valid ReqTreatmentDto treatmentDetails) {
		return new ResponseEntity<>(treatmentService.createTreatmentDetails(treatmentDetails),HttpStatus.CREATED);
	} 
	
	@Operation(summary = "adding treatment details to database")
	@GetMapping("/patientHistory/{patientId}")
	public ResponseEntity<?> getPatientHistory(@PathVariable long doctorId, @PathVariable long patientId) {
		return new ResponseEntity<>(treatmentService.getPatientHistory(/*doctorId,*/ patientId),HttpStatus.ACCEPTED);
	}
	
	@Operation(summary = "fetch lab tests")
	@GetMapping("/labTests")
	public ResponseEntity<?> getLabTests() {
		return new ResponseEntity<>(labTestService.getLabTests(),HttpStatus.ACCEPTED);
	} 
}
