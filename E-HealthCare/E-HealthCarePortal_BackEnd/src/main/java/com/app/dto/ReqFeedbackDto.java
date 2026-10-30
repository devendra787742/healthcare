package com.app.dto;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor

public class ReqFeedbackDto {
	
	@Length(min = 3, max = 255)
	private String comments;
	private double rating;
	private long patient;
	private long doctor;
	
}
