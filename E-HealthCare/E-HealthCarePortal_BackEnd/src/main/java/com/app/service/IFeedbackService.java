package com.app.service;

import com.app.dto.ReqFeedbackDto;
import com.app.dto.RespFeedbackDto;

public interface IFeedbackService {

	RespFeedbackDto doctorsFeedback(long patientId, long doctorId);

	String addDoctorsFeedback(ReqFeedbackDto transientFeedback);

}
