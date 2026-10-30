package com.app.service;

import java.time.LocalTime;
import java.util.List;

import com.app.dto.*;

public interface IAppointmentService {

	List<RespDoctorAppointmentDto> getTodaysAppointments(Long DoctorId);

	List<RespDoctorAppointmentDto> getFuturesAppointments(Long DoctorId);

	List<RespDoctorAppointmentDto> getPendingAppointments(Long DoctorId);

	String cancelAppointment(Long appointmentId);

	String confirmAppointment(Long appointmentId);

	String bookAppointment(BookAppointmentDto bookAppointmentDto);

	List<RespPatientAppointmentDto> getPatientAppointment(long patientId);

	LocalTime[] getAvailableTimings(ReqAvailableTimingForDoctor bookedSlot);

}
