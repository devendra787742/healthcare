package com.app.dto;

import java.time.LocalDate;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString

public class BookAppointmentDto {

	private LocalDate date;
	private String appointmentTime; //only start time is to be written 
	private boolean online;
	private long patientId;
	private long doctorId;
}
