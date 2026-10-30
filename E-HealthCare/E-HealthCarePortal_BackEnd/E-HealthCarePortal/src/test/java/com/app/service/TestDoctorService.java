package com.app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.dto.ReqAddDocDto;

@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class TestDoctorService {
	
	@Autowired
	IDoctorService docService;
	
	@Test
	void test1() {
		System.out.println("inside test");
		System.out.println(docService.getAllDoctors());
	}

	@Test
	void test2() {
		System.out.println("inside test");
		
		System.out.println(docService.deleteDoctorById(9L));
	}

	@Test
	void test3() {
		System.out.println("inside test");

		ReqAddDocDto a = new ReqAddDocDto(9L, "bhai", "123", "male", "bh@gmail.com", "abc", "itus", 500, "Cardiology",
				true, true);
		System.out.println(docService.addDoctorToDept(a));
	}
	
	@Test
	void test4() {
		System.out.println("inside test");
		
		System.out.println(docService.getValidDoctorsByDepartment("Orthopaedics"));
	}
	
	@Test
	void updateDoctorWorkStatus() {
		Boolean b = docService.updateDoctorWorkStatus(3L);
		assertEquals(false, b);
	}
	

}
