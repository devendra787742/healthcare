package com.app.service;

import java.util.List;

import com.app.dto.ReqTreatmentDto;
import com.app.dto.RespBriefTreatmentDetails;
import com.app.dto.RespCompleteTreatmentDetails;
import com.app.dto.RespTreatmentDto;

public interface ITreatmentService {
	String createTreatmentDetails(ReqTreatmentDto treatmentDetails);

	List<RespTreatmentDto> getPatientHistory(long patientId);

	RespTreatmentDto getLabAndMedicine(long patientId);

	List<RespBriefTreatmentDetails> getPartialPatientList(long patientId);

	RespCompleteTreatmentDetails getCompletePatientDetails(long patientId);


}
