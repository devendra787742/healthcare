package com.app.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "doctors")
public class Doctor extends UserEntity {
	
	private String speciality;
	private String education;
	private double fees;
	//private String imagepath;
	private boolean isWorking;
	private boolean isValidated;

	//dept table's relation
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)  //owning side - Doctor is child of Department
	@JoinColumn(name = "department_id", nullable = false)
	private Department department;
	
//	@JsonIgnore
//	//feedback table's relation
//	@Embedded
//	@ElementCollection
//	@CollectionTable(name = "doctor_feedbacks",joinColumns = @JoinColumn(name="doctor_id"))
//	private List<Feedback> feedbacks = new ArrayList<Feedback>();
	
	@Override
	public String toString() {
		return "Doctor [id= " + getId()+ " name= " + getName()+ " password= " + getPassword() + " gender= " + getGender() + " email= " + getEmail() + " speciality=" + speciality + ", education=" + education + ", fees=" + fees + ", imagepath="
				 + "]";
	}

//	public void setFeedbacks(Feedback feedback) {
//		this.feedbacks.add(feedback);
//	}
}