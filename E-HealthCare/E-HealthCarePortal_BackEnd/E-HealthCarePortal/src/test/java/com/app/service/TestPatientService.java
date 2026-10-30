package com.app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.app.entities.Patient;

@SpringBootTest
@AutoConfigureTestDatabase(replace = /*AutoConfigureTestDatabase.
*/Replace.NONE)
public class TestPatientService {
	
	@Autowired
	private IPatientService patientService;

	@Test//done testing
	void showAllPatients() {
		List<Patient> ls = patientService.getAllPatients();
		System.out.println("Both are same : ");
		assertEquals("Peyton", ls.get(0).getName());
}
	@Test
	@Rollback(value=false)
	void deletePatientById() {
		String result = patientService.deletePatientById(57L);
		assertEquals("Patient deleted Succesfully!!!!!!!",result);
	}
	
	
 
}
