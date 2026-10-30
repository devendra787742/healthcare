package com.app.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor

public class RespUpDocDto {
	
	private String name;
	private String password;
	private String gender;
	private String email;
	
	private String speciality;
	private String education;
	private double fees;
	private String department;   //fetches details of all entries...........wrong way implementation
	private boolean isWorking;
	private boolean isValidated;
	
}
