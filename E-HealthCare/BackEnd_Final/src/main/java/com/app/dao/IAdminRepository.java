package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.entities.Admin;
import com.app.entities.Patient;


@Repository
public interface IAdminRepository extends JpaRepository<Admin, Long> {
	
	@Query("Select a from Admin a where a.email=?1 and a.password=?2")
	Admin findByEmailAndPassword(String email, String password);
	
	@Query("Select a from Admin a where a.email=?1")
	Admin findByEmail(String email);

}
