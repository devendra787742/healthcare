package com.app.dto;

import java.time.LocalDate;
import java.util.List;

import com.app.entities.LabTest;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor


public class RespTreatmentDto {
	private long id;
	private String symptoms;
	private String medicines;
	private LocalDate treatmentDate;
	private List<LabTest> labTests;
	private String doctorName;
	
}
