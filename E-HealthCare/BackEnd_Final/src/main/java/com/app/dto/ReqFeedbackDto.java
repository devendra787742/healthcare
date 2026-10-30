package com.app.dto;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor

public class ReqFeedbackDto {
	
//	@NotBlank
	@Length(min = 3, max = 255)
	private String comments;
	
//	@NotBlank
	private double rating;
	
	private long patient;

	private long doctor;
	
}
