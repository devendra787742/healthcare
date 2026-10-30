package com.app.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.*;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "bills")
public class Bill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long billNumber; //if possible AlphaNumeric
	private LocalDate date;
	private LocalTime time;
	private double amount; //(doctor fees) - medicines not included

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "patient_id", nullable = false)
	private Patient patient;
	
//	private long appointmentId;

	@Override
	public String toString() {
		return "Bill [billNumber=" + billNumber + ", date=" + date + ", time=" + time + ", amount=" + amount + "]";
	}
	
}
