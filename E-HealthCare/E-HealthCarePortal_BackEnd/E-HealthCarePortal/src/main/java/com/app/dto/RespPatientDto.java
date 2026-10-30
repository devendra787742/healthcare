package com.app.dto;

import java.time.LocalDate;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class RespPatientDto {
	private String name; 
	private String email;
	private String gender;
	private String address;
	private String bloodGroup;
	private LocalDate dateOfBirth;
	private double weight;
	private double height;
}
