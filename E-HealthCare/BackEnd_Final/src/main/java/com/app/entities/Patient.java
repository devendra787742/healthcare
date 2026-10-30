package com.app.entities;

import java.time.LocalDate;

import javax.persistence.*;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "patients")
public class Patient extends UserEntity {
	
	@Column(length = 100)
	private String address;	
	@Enumerated(EnumType.STRING)
	private BloodGroup bloodGroup;
	@Column(name = "dob", nullable = false)
	private LocalDate dateOfBirth;
	@Column(nullable = false)
	private double weight;
	@Column(nullable = false)
	private double height;
	//private boolean status;
	
	@Override
	public String toString() {
		return "Patient [id= " + getId()+ " name= " + getName()+ " password= " + getPassword() + " gender= " + getGender() + " email= " + getEmail() +" address=" + address + ", bloodGroup=" + bloodGroup + ", dateOfBirth=" + dateOfBirth + ", weight=" + weight
				+ ", height=" + height + "]";
	}
}
