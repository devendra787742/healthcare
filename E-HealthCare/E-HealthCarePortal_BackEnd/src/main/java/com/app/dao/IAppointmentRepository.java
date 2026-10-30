package com.app.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.entities.Appointment;
import com.app.entities.Patient;

@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment, Long> {

	@Query("select a from Appointment a join a.patient join a.doctor where a.doctor.id = ?1 and a.date = ?2 and a.status = ?3")
	List<Appointment> findTodayAppointments(Long doctorId, LocalDate date, String status);

	@Query("select a from Appointment a join a.patient join a.doctor where a.doctor.id = ?1 and a.date > ?2 and a.status = ?3")
	List<Appointment> findFutureAppointments(Long doctorId, LocalDate date, String status);

	@Query("select a from Appointment a join a.patient join a.doctor where a.doctor.id = ?1 and a.date >= ?2 and a.status = ?3")
	List<Appointment> findPendingAppointments(Long doctorId, LocalDate date, String status);

	@Modifying
	@Query("update Appointment a set a.status =?1 where a.id=?2")
	int cancelByAppointmentId(String status, Long appointmentId);

	@Modifying
	@Query("update Appointment a set a.status =?1 where a.id=?2")
	int acceptByAppointmentId(String string, Long appointmentId);

	List<Appointment> findByPatient(Patient patient);

	@Query("select time from Appointment a where a.doctor.id=?1 and a.date = ?2 and (a.status ='Confirmed' or a.status='Attended')")
	LocalTime[] getBookedTimings(long doctorId, LocalDate date);

	@Query("select a from Appointment a where a.id=?1")
	Optional<Appointment> findById(Long id);

}
