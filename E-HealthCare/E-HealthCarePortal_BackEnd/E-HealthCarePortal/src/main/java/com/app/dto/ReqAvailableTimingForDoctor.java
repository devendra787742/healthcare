package com.app.dto;

import java.time.LocalDate;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ReqAvailableTimingForDoctor {
	
 private long doctorId;
 private LocalDate date;
}

