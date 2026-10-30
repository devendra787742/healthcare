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

	// @JsonProperty(access=Access.READ_ONLY)
	private long id;
//	@NotBlank
//	@Length(min = 3, max = 30)
	private String name;
	@JsonIgnore
//	@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})",message="blank or invalid password")
	private String password;
//	@NotBlank
	private String gender;
//	@NotBlank
//	@Length(min = 5, max = 50)
	private String email;
//	@NotBlank
//	@Length(min = 5, max = 100)
	private String address;
//	@NotBlank
	private BloodGroup bloodGroup;
//	@NotBlank
	private LocalDate dateOfBirth;
//	@NotBlank
	private double weight;
//	@NotBlank
	private double height;
	// private boolean status;
	private MultipartFile imageFile;

}
