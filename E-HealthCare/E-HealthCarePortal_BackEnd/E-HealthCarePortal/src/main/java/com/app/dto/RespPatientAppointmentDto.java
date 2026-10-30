package com.app.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor

public class RespPatientAppointmentDto {
	private long id;
	private LocalDate date;
	private LocalTime time;
	private boolean online;
	private String status;
	private String doctorName;
}
