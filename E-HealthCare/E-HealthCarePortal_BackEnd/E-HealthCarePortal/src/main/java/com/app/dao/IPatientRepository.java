package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.entities.Patient;

@Repository
public interface IPatientRepository extends JpaRepository<Patient,Long>{
	
	@Query("Select p from Patient p where p.email=?1 and p.password=?2")
	Patient findByEmailAndPassword(String email, String password); 
	
	@Query("Select p from Patient p where p.email=?1")
	Patient findByEmail(String email); 
	
}
