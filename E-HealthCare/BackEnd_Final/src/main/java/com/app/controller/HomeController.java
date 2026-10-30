package com.app.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.dto.LoginDto;
import com.app.dto.RegisterPatientDto;
import com.app.dto.RespLoginDto;
import com.app.jwt_utils.JwtUtils;
import com.app.service.CustomUserDetails;
import com.app.service.IPatientService;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@Slf4j
public class HomeController {
	
	@Value("${file.upload.location}")
	private String folderLocation;
	
	
	@Autowired
	private ObjectMapper mapper;

	@Autowired
	private IPatientService patientService;

	@Autowired
	private JwtUtils utils;

	@Autowired
	private AuthenticationManager manager;

	@PostMapping("/login")
	public ResponseEntity<?> validateUserCreateToken(@RequestBody @Valid LoginDto request) {
		// store incoming user details(not yet validated) into Authentication object
		// Authentication i/f ---> implemented by UserNamePasswordAuthToken
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(request.getEmail(),
				request.getPassword());
		log.info("auth token " + authToken);
		log.info("Logged in user with email :"+ request.getEmail());
		try {
			// authenticate the credentials
			Authentication authenticatedDetails = manager.authenticate(authToken);
			log.info("auth token again " + authenticatedDetails);
			System.out.println("Hello data is here "+authenticatedDetails.toString());			
			// => auth succcess
			return ResponseEntity.status(HttpStatus.CREATED).body(new RespLoginDto(((CustomUserDetails)authenticatedDetails.getPrincipal()).getUser().getId() ,((CustomUserDetails)authenticatedDetails.getPrincipal()).getUser().getName(), authenticatedDetails.getAuthorities().toString() , utils.generateJwtToken(authenticatedDetails)));
		} catch (BadCredentialsException e) { 
			// send back err resp code
			e.printStackTrace();
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
		}
	}
	
	@Operation(summary = "registering the patient")
	@PostMapping("/register")
	public ResponseEntity<?> addPatientDetails(@RequestParam String tPatient, @RequestParam MultipartFile imageFile)
			throws IOException {
		RegisterPatientDto transientPatient = mapper.readValue(tPatient, RegisterPatientDto.class);
		log.info("User registered with email :" + transientPatient.getEmail());
		System.out.println(transientPatient);
		return new ResponseEntity<>(patientService.addPatientDetails(transientPatient, imageFile), HttpStatus.CREATED);
	}

	@GetMapping("/images/{imageFile}")
	public ResponseEntity<InputStreamResource> getImage(@PathVariable String imageFile) throws IOException {
		
		Path path = Paths.get(folderLocation, imageFile);
		InputStreamResource inputStreamResource =
				new InputStreamResource(new FileInputStream(path.toFile()));

		HttpHeaders headers = new HttpHeaders();
		headers.add("content-type", Files.probeContentType(path));
		return ResponseEntity.ok().headers(headers).body(inputStreamResource);
	}
	
}