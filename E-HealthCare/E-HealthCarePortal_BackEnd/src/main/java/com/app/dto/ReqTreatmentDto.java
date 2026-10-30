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
	private long[] labTestNo;
	
	@Override
	public String toString() {
		return "ReqTreatmentDto [symptoms=" + symptoms + ", medicines=" + medicines + ", patient=" + patient
				+ ", doctor=" + doctor + ", labTestNo=" + Arrays.toString(labTestNo) + "]";
	}
	
}
