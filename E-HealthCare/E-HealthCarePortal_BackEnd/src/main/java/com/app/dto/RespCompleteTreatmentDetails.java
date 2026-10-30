package com.app.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.app.entities.LabTest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString


public class RespCompleteTreatmentDetails {

	private Long id;
	@NotBlank
	@Length(min = 3, max = 255)
	private String symptoms;
	@NotBlank
	@Length(min = 3, max = 255)
	private String medicines;
	@NotBlank
	private LocalDate treatmentDate;
	private List<LabTest> labTests;
	private String patient;
	private String doctor;
}
