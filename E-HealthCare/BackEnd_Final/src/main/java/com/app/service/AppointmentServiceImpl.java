package com.app.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.*;
import com.app.dto.*;
import com.app.entities.*;
import com.app.exceptions.ResourceNotFoundException;
import com.app.utils.MailService;

@Service
@Transactional
public class AppointmentServiceImpl implements IAppointmentService {

	@Autowired
	private MailService emailService;
	
	
	@Autowired
	private IAppointmentRepository appointmentRepo;

	@Autowired
	private IPatientRepository patientRepo;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private IDoctorRepository doctorRepo;

	@Override
	public List<RespDoctorAppointmentDto> getTodaysAppointments(Long DoctorId) {

		// Doctor doc = doctorRepo.findById(DoctorId).orElseThrow(() -> new
		// RuntimeException("Invalid DoctorId"));
		List<Appointment> appointmentList = appointmentRepo.findTodayAppointments(DoctorId, LocalDate.now(),
				"Confirmed");
		List<RespDoctorAppointmentDto> appointmentDtoList = new ArrayList<RespDoctorAppointmentDto>();
		appointmentList.forEach((app) -> {
			RespDoctorAppointmentDto obj = mapper.map(app, RespDoctorAppointmentDto.class);
			obj.setDoctorId(DoctorId);
			obj.setPatientId(app.getPatient().getId());
			obj.setPatientName(app.getPatient().getName());
			appointmentDtoList.add(obj);
		});
		// return appointmentRepo.findTodayAppointments(DoctorId, LocalDate.now(),
		// "Confirmed");
		return appointmentDtoList;
	}

	@Override
	public List<RespDoctorAppointmentDto> getFuturesAppointments(Long DoctorId) {
		// Doctor doc = doctorRepo.findById(DoctorId).orElseThrow(() -> new
		// RuntimeException("Invalid DoctorId"));
		List<Appointment> appointmentList = appointmentRepo.findFutureAppointments(DoctorId, LocalDate.now(),
				"Confirmed");
		List<RespDoctorAppointmentDto> appointmentDtoList = new ArrayList<RespDoctorAppointmentDto>();
		appointmentList.forEach((app) -> {
			RespDoctorAppointmentDto obj = mapper.map(app, RespDoctorAppointmentDto.class);
			obj.setDoctorId(DoctorId);
			obj.setPatientId(app.getPatient().getId());
			obj.setPatientName(app.getPatient().getName());
			appointmentDtoList.add(obj);
		});

		return appointmentDtoList;

	}

	@Override
	public List<RespDoctorAppointmentDto> getPendingAppointments(Long DoctorId) {
		// TODO Auto-generated method stub
		// Doctor doc = doctorRepo.findById(DoctorId).orElseThrow(() -> new
		// RuntimeException("Invalid DoctorId"));
		List<Appointment> appointmentList = appointmentRepo.findPendingAppointments(DoctorId, LocalDate.now(),
				"Pending");
		List<RespDoctorAppointmentDto> appointmentDtoList = new ArrayList<RespDoctorAppointmentDto>();
		appointmentList.forEach((app) -> {
			RespDoctorAppointmentDto obj = mapper.map(app, RespDoctorAppointmentDto.class);
			obj.setDoctorId(DoctorId);
			obj.setPatientId(app.getPatient().getId());
			obj.setPatientName(app.getPatient().getName());
			appointmentDtoList.add(obj);
		});
		return appointmentDtoList;
	}

	@Override
	public String cancelAppointment(Long appointmentId) {
		Appointment app = appointmentRepo.findById(appointmentId).orElseThrow(()->new ResourceNotFoundException("No such appointment FOUND to confirm"));
		System.out.println(app);
		System.out.println(app.getPatient());
		System.out.println(app.getDoctor());
		String zoom = "https://us02web.zoom.us/j/3105558123?pwd=5dWnIud42CN5hy7au06Vwo5SwHb1xv.1\r\n";
		String mesg = appointmentRepo.acceptByAppointmentId("Cancelled", appointmentId) == 1 ? "Appointment Cancelled"
				: "Appointment Status not updated";
		String email = "\r\n"
				+ "Hello "+app.getPatient().getName()+",\r\n"
				+ "\r\n"
				+ "Thanks for choosing Dr."+app.getDoctor().getName()+". Your appointment has been cancelled for "+app.getTime()+" on "+app.getDate()+".\r\n"
				+ "We regret the inconvenience caused. You may try again later.\r\n"
				+ "\r\n"
				+ "zoom link: " + zoom
				+ "Best Regards,\r\n"
				+ "Dr."+ app.getDoctor().getName()+"\r\n"
				+ "email address:"+ app.getDoctor().getEmail()+"\r\n"
				+ "";
		String paymentRefundEmail = "\r\n"
				+ "Hello "+app.getPatient().getName()+",\r\n"
				+ "\r\n"
				+ "Thanks for choosing Dr."+app.getDoctor().getName()+". Your appointment has been cancelled for "+app.getTime()+" on "+app.getDate()+".\r\n"
				+ "We regret the inconvenience caused. You may try again later.\r\n"
				+ "Your payment amount will be refunded within 4 to 5 business days."
				+ "\r\n"
				+ "Best Regards,\r\n"
				+ "Dr."+ app.getDoctor().getName()+"\r\n"
				+ "email address:"+ app.getDoctor().getEmail()+"\r\n"
				+ "";
		String subject = "E-Healthcare Appointment: Cancellation";
		
		if(app.isPaymentStatus()) { // PAID Appointment
			emailService.sendSimpleEmail(app.getPatient().getEmail(), paymentRefundEmail, subject);
		}else {// UNPAID Appointment
			emailService.sendSimpleEmail(app.getPatient().getEmail(), email, subject);
		}
		
		return mesg;
	}

	@Override
	public String confirmAppointment(Long appointmentId) {
		Appointment app = appointmentRepo.findById(appointmentId).orElseThrow(()->new ResourceNotFoundException("No such appointment FOUND to confirm"));
		System.out.println(app);
		System.out.println(app.getPatient());
		System.out.println(app.getDoctor());
		String mesg = appointmentRepo.acceptByAppointmentId("Confirmed", appointmentId) == 1 ? "Appointment Confirmed"
				: "Appointment Status not updated";
		String email = "\r\n"
				+ "Hello "+app.getPatient().getName()+",\r\n"
				+ "\r\n"
				+ "Thanks for choosing Dr."+app.getDoctor().getName()+". Your appointment is booked for "+app.getTime()+" on "+app.getDate()+".\r\n"
				+ "We are looking forward to seeing you.\r\n"
				+ "\r\n"
				+ "Best Regards,\r\n"
				+ "Dr."+ app.getDoctor().getName()+"\r\n"
				+ "email address:"+ app.getDoctor().getEmail()+"\r\n"
				+ "";
		String subject = "E-Healthcare Appointment: Confirmation";
		
		if(app.isOnline()) { // ONLINE Appointment
			emailService.sendSimpleEmail(app.getPatient().getEmail(), email, subject);
		}else {// OFFLINE Appointment
			emailService.sendSimpleEmail(app.getPatient().getEmail(), email, subject);
		}
		
		return mesg;

	}

	@Override
	public String bookAppointment(BookAppointmentDto bookAppointmentDto) {
		System.out.println("\n" + bookAppointmentDto);
		Appointment appointment = mapper.map(bookAppointmentDto, Appointment.class);
		appointment.setTime(LocalTime.parse(bookAppointmentDto.getAppointmentTime()));
		appointment.setStatus("Pending");
		if(appointment.isOnline()) 
			appointment.setPaymentStatus(true);
		else
			appointment.setPaymentStatus(false);
		appointment.setPatient(patientRepo.findById(bookAppointmentDto.getPatientId())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Patient Id")));
		appointment.setDoctor(doctorRepo.findById(bookAppointmentDto.getDoctorId())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Doctor Id !!")));

		appointmentRepo.save(appointment);

		return "Appointment booked successfully";
	}

	@Override
	public List<RespPatientAppointmentDto> getPatientAppointment(long patientId) {
		List<RespPatientAppointmentDto> appointmentDtoList = new ArrayList<>();
		List<Appointment> appointmentList = appointmentRepo.findByPatient(
				patientRepo.findById(patientId).orElseThrow(() -> new ResourceNotFoundException("Invalid Patient Id")));
		appointmentList.forEach((app) -> {
			RespPatientAppointmentDto appointmentDto = mapper.map(app, RespPatientAppointmentDto.class);
			appointmentDto.setDoctorName(app.getDoctor().getName());
			appointmentDtoList.add(appointmentDto);
		});
		return appointmentDtoList;
	}

	@Override
	public LocalTime[] getAvailableTimings(ReqAvailableTimingForDoctor bookedSlot) {
		LocalTime[] timeArr = appointmentRepo.getBookedTimings(bookedSlot.getDoctorId(),bookedSlot.getDate());
		return timeArr;
	}


}