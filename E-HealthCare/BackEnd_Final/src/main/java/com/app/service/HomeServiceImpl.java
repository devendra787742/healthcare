package com.app.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IAdminRepository;
import com.app.dao.IDoctorRepository;
import com.app.dao.IPatientRepository;
import com.app.dto.LoginDto;
import com.app.dto.RespLoginDto;
import com.app.entities.Admin;
import com.app.entities.Doctor;
import com.app.entities.Patient;
import com.app.exceptions.ResourceNotFoundException;

@Service
@Transactional
public class HomeServiceImpl implements IHomeService {

	@Autowired
	private IAdminRepository adminRepo;
	
	@Autowired
	private IDoctorRepository doctorRepo;
	
	@Autowired
	private IPatientRepository patientRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public RespLoginDto loginUser(LoginDto credentials) {
		RespLoginDto validatedUser;
		Object user;
		user = adminRepo.findByEmailAndPassword(credentials.getEmail(), credentials.getPassword());
		
		if(user == null) {
			user = doctorRepo.findByEmailAndPassword(credentials.getEmail(), credentials.getPassword());
			if(user == null)
				user = patientRepo.findByEmailAndPassword(credentials.getEmail(), credentials.getPassword());
		}
		if(user instanceof Admin) {
			validatedUser = mapper.map(user,RespLoginDto.class);
			validatedUser.setUserType("Admin");
		}
		else if(user instanceof Doctor) {
			validatedUser = mapper.map(user,RespLoginDto.class);
			validatedUser.setUserType("Doctor");
		}
		else if(user instanceof Patient) {
			validatedUser = mapper.map(user,RespLoginDto.class);
			validatedUser.setUserType("Patient");
		}
		else
			throw new ResourceNotFoundException("Wrong Credentials");
		return validatedUser;
	}
	
}
