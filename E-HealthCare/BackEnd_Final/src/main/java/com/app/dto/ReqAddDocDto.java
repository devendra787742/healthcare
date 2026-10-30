package com.app.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.*;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class ReqAddDocDto {
	private Long id;
	@NotBlank
	@Length(min = 3, max = 30)
	private String name;
	//@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})",message="blank or invalid password")
	private String password;
	private String gender;
	@NotBlank
	@Length(min = 5, max = 50)
	private String email;
	
	private String speciality;
	private String education;
	@Min(value = 500)
	@Max(value = 1500)
	private double fees;
	private String department;
	private boolean isWorking;
	private boolean isValidated;
	
}
