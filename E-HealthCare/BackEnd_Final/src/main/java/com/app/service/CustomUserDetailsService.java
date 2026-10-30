package com.app.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IAdminRepository;
import com.app.dao.IDoctorRepository;
import com.app.dao.IPatientRepository;
import com.app.entities.Admin;
import com.app.entities.Doctor;
import com.app.entities.Patient;
import com.app.entities.UserEntity;

@Service // or @Component also works!
@Transactional

public class CustomUserDetailsService implements UserDetailsService {
	// dep : user repository : based upon spring data JPA
	@Autowired
	private IDoctorRepository doctorRepo;

	@Autowired
	private IPatientRepository patientRepo;

	@Autowired
	private IAdminRepository adminRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		System.out.println("in load by user nm " + email);
		UserEntity user = adminRepo.findByEmail(email);
		if (user != null) {
			System.out.println("Admin : "+user);
			return new CustomUserDetails(user);
		}
		user= doctorRepo.findByEmail(email);
		if (user != null) {
			System.out.println("Admin : "+user);
			return new CustomUserDetails(user);
		}
		user= patientRepo.findByEmail(email);
		System.out.println("Admin : "+user);
		if (user != null) {
			return new CustomUserDetails(user);
		}
		throw new UsernameNotFoundException("Invalid Email ID ");
	}
}
