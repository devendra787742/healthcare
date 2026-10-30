package com.app.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@ToString
public class RespDoctorAppointmentDto {

	private long id;
	private LocalDate date;
	private LocalTime time; //LocalTime.minusMinutes(long minutesToSubtract) //Duration //TimeStamp - sql
	private boolean online;
	private String status;
	private Long patientId;
	private String patientName;
	private Long doctorId;
	private boolean paymentStatus;
}
