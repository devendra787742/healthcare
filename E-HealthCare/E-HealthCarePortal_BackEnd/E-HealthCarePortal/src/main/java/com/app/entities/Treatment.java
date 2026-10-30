package com.app.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import lombok.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "treatment")
public class Treatment extends BaseEntity {

	@Column(nullable = false)
	@Setter
	private String symptoms;
	
	@Setter
	private String medicines;
	
	@Setter
	private LocalDate treatmentDate;
	
	@ManyToMany 
	@JoinTable(name = "treatment_lab", joinColumns = @JoinColumn(name = "treatment_id"), inverseJoinColumns = @JoinColumn(name = "lab_id"))
	private List<LabTest> labTests;
	
	@Setter
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "patient_id", nullable = false)
	private Patient patient;
	
	@Setter
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctor_id", nullable = false)
	private Doctor doctor;
	
	public void setLabTests(List<LabTest> labTest) {
		this.labTests = labTest;		
	}
	@Override
	public String toString() {
		return "Treatment [symptoms=" + symptoms + ", medicines=" + medicines + ", treatmentDate=" + treatmentDate
				+ ", labTests=" + labTests + "]\n";
	}
}
