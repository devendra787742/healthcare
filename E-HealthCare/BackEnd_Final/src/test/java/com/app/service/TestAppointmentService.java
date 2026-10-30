package com.app.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
//@DataJpaTest - to test only dao layer 
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class TestAppointmentService {
	
	@Autowired
	private IAppointmentService appointmentService;
	
	@Test
	void testGetFutureAppointments() {
		appointmentService.getFuturesAppointments((long)10).forEach((p)->System.out.println(p));
	}
	
	@Test
	void testGetTodayAppointments() {
		appointmentService.getTodaysAppointments(1L).forEach((p)->System.out.println(p));
	}
	
	@Test
	void testGetPendingAppointments() {
		appointmentService.getPendingAppointments((long)5).forEach((p)->System.out.println(p));
	}
	
}
