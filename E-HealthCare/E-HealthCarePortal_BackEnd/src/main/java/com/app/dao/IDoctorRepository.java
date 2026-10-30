package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.entities.Doctor;

@Repository
public interface IDoctorRepository extends JpaRepository<Doctor, Long> {
	
	@Query("select d from Doctor d join fetch d.department dept where dept.deptName = ?1")
	List<Doctor> findByDepartment(String deptName);
	
	@Query("select d from Doctor d join fetch d.department dept where dept.id = ?1 and d.isWorking = ?2 and d.isValidated = ?3")
	List<Doctor> findByDept(long departmentId, boolean isWorking, boolean isValidated);

	@Query("Select d from Doctor d where d.email=?1 and d.password=?2")
	Doctor findByEmailAndPassword(String email, String password);
	
	@Query("Select d from Doctor d where d.email=?1")
	Doctor findByEmail(String email);
}
