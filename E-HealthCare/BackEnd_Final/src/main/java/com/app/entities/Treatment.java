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
	@Getter @Setter
	private String symptoms;
	
	@Getter @Setter
	private String medicines;
	
	@Getter @Setter
	private LocalDate treatmentDate;
	
	//@ManyToMany//(fetch = FetchType.EAGER)// mandatory , o.w MappingExc
	//annotation below : optional BUT reco for customizing names of the link table n it's cols
	
	@ManyToMany 
	@JoinTable(name = "treatment_lab", joinColumns = @JoinColumn(name = "treatment_id"), inverseJoinColumns = @JoinColumn(name = "lab_id"))
	private List<LabTest> labTests;
	
	@Getter @Setter
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "patient_id", nullable = false)
	private Patient patient;
	
	@Getter @Setter
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
	
	//private Department dept;
}
