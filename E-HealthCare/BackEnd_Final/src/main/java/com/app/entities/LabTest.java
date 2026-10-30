package com.app.entities;

import javax.persistence.*;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "lab_test")

public class LabTest extends BaseEntity{
	
	@Column(name = "test_name", length = 20)
	private String testName;
	//@Column(nullable = false)
	//private double price;
	
	@Override
	public String toString() {
		return "LabTest [ id="+ getId() +"testName=" + testName + "]";
	}
	
//	@ManyToOne
//	@JoinColumn(name = "treatment_id")
//	private Treatment treatment;
}
