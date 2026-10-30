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
	private boolean isWorking;
	private boolean isValidated;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)  //owning side - Doctor is child of Department
	@JoinColumn(name = "department_id", nullable = false)
	private Department department;
	@Override
	public String toString() {
		return "Doctor [id= " + getId()+ " name= " + getName()+ " password= " + getPassword() + " gender= " + getGender() + " email= " + getEmail() + " speciality=" + speciality + ", education=" + education + ", fees=" + fees + ", imagepath="
				 + "]";
	}
}