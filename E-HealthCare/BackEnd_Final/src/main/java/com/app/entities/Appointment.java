package com.app.entities;

import java.time.LocalDate;
import java.time.LocalTime;


import javax.persistence.*;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "appointments")
public class Appointment extends BaseEntity {

	private LocalDate date;
	private LocalTime time; //LocalTime.minusMinutes(long minutesToSubtract) //Duration //TimeStamp - sql
	private boolean online;
	private String status;
	private boolean paymentStatus; 
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "patient_id", nullable = false)
	private Patient patient;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctor_id", nullable = false)
	private Doctor doctor;
	
	
	@Override
	public String toString() {
		return "Appointment [id= " + getId() + " date=" + date + ", time=" + time + ", online=" + online + "]";
	}
}
