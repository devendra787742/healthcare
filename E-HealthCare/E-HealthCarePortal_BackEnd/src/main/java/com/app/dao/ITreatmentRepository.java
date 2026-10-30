package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.entities.Doctor;
import com.app.entities.Patient;
import com.app.entities.Treatment;

@Repository
public interface ITreatmentRepository extends JpaRepository<Treatment, Long> {
	
	List<Treatment> findByPatient(Patient patient);
	
	List<Treatment> findByPatientAndDoctor(Patient patient, Doctor doctor); 

	@Query("Select t from Treatment t where t.patient.id =?1 order by t.id desc")
	List<Treatment> getTreatmentList(Long patientId);

	@Query(value = "Select * from treatment where patient_id =?1 order by id desc limit 1", nativeQuery=true)
	Treatment getTreatment(long patientId);
	
}
