package com.app.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString

public class RespBriefTreatmentDetails {

	private Long id;
	@NotBlank
	private LocalDate treatmentDate;
	@NotBlank	
	private String doctor;
	private long patientId;
	private long doctorId;	
}
