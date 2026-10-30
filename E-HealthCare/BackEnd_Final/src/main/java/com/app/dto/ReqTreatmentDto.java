package com.app.dto;

import java.util.Arrays;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
//@ToString

public class ReqTreatmentDto {

	@NotBlank
	@Length(min = 3, max = 255)
	private String symptoms;
	@NotBlank
	@Length(min = 3, max = 255)
	private String medicines;
	private long patient;
	private long doctor;
	//public List<LabTest> labTests;
	//private LabTest[] labTest;  --> tried and succeeded but chose efficient path
	private long[] labTestNo;
	//private LocalDate treatmentDate;
	
	@Override
	public String toString() {
		return "ReqTreatmentDto [symptoms=" + symptoms + ", medicines=" + medicines + ", patient=" + patient
				+ ", doctor=" + doctor + ", labTestNo=" + Arrays.toString(labTestNo) + "]";
	}
	
//	@OneToMany
//	@JoinColumn(name = "treatment_id")
//	public List<LabTest> labTests;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "patient_id", nullable = false)
//	private Patient patient;
//	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "doctor_id", nullable = false)
//	private Doctor doctor;
}
