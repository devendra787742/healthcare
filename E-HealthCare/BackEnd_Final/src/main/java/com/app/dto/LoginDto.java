package com.app.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class LoginDto {
	@NotBlank(message = "Email can't be blank or null")
	@Email(message = "Invalid email")
	private String email;
	@NotBlank(message = "password can't be blank or null")
	private String password;
}
