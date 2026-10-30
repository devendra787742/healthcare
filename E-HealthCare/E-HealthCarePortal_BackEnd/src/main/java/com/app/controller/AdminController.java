package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.dto.ReqAddDocDto;
import com.app.entities.Department;
import com.app.service.*;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:3000/")
@Slf4j
public class AdminController {
	
	@Autowired
	private IDepartmentService departmentService;
	
	@Autowired
	private IDoctorService doctorService;
	
	@Autowired
	private IPatientService patientService;	
	
	@GetMapping("/departments")
	public ResponseEntity<?> printDepartments() {
		return ResponseEntity.ok(departmentService.getAllDepartment());
	}
	
	@GetMapping("/{deptName}")
	public ResponseEntity<?> getDoctorByDeptName(@PathVariable String deptName){
		doctorService.getDoctorsByDepartment(deptName).forEach(System.out::println);
		return ResponseEntity.ok(doctorService.getDoctorsByDepartment(deptName));
	}
	
	@PostMapping("/Doctor")
	public ResponseEntity<?> addDoctor(@RequestBody @Valid ReqAddDocDto transientDoctor){
		log.info("Doctor added with email :"+ transientDoctor.getEmail());
		return new ResponseEntity<>(doctorService.addDoctorToDept(transientDoctor),HttpStatus.CREATED); 
	}
	
	@DeleteMapping("/Doctor/{doctorId}")
	public ResponseEntity<?> deleteDoctor(@PathVariable long doctorId){
		log.info("Doctor deleted with id:"+ doctorId);
		return ResponseEntity.ok(doctorService.deleteDoctorById(doctorId));
	}
	
	@GetMapping("/Doctor/{doctorId}")
	public ResponseEntity<?> getDoctorById(@PathVariable long doctorId){
		return ResponseEntity.ok(doctorService.getDoctorById(doctorId));
	}
	
	@PutMapping("/Doctor/{doctorId}")
	public ResponseEntity<?> updateDoctor(@RequestBody @Valid ReqAddDocDto transientDoc){
		return  ResponseEntity.ok(doctorService.updateDocDetails(transientDoc));
	}
	
	@PatchMapping("/Doctor/{doctorId}/WorkStatus")
	public ResponseEntity<?> updateDoctorWorkStatus(@PathVariable long doctorId){
		return  ResponseEntity.ok(doctorService.updateDoctorWorkStatus(doctorId));
	}
	
	@PatchMapping("/Doctor/{doctorId}/ValidStatus")
	public ResponseEntity<?> updateDoctorValidStatus(@PathVariable long doctorId){
		return  ResponseEntity.ok(doctorService.updateDoctorValidStatus(doctorId));
	}
	
	@GetMapping("/getAllPatients")
	public ResponseEntity<?> printPatients(){
		return ResponseEntity.ok(patientService.getAllPatients());	
	}
	
	@DeleteMapping("/deletePatient/{patientId}")
	public ResponseEntity<?> deletePatient(@PathVariable long patientId){
		log.info("Patient deleted with id:"+ patientId);
		return ResponseEntity.ok(patientService.deletePatientById(patientId));
	}
	
	@DeleteMapping("/department/{departmentId}")
	public ResponseEntity<?> deleteDepartment(@PathVariable long departmentId){
		log.info("Department deleted with id:"+ departmentId);
		return new ResponseEntity<>(departmentService.deleteDepartmentById(departmentId),HttpStatus.OK);
	}
	
	@PostMapping("/department")
	public ResponseEntity<?> addDepartment(@RequestBody @Valid Department dept){
		log.info("Department added with name:" + dept.getDeptName());
		return new ResponseEntity<>(departmentService.addDepartment(dept), HttpStatus.CREATED);
	}
}