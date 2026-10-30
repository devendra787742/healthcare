package com.app.dto;

import java.time.LocalDate;

import org.springframework.web.multipart.MultipartFile;

import com.app.entities.BloodGroup;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

public class UpdatePatientDetailsDto {

	private long id;
	private String name;
	@JsonIgnore
	private String password;
	private String gender;
	private String email;
	private String address;
	private BloodGroup bloodGroup;
	private LocalDate dateOfBirth;
	private double weight;
	private double height;
	private MultipartFile imageFile;
}
