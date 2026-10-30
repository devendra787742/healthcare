package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "departments")
public class Department extends BaseEntity {
	
	@Column(name = "department_name", length = 20)
	private String deptName;
	
	@Column(name = "description")
	private String deptDesc;
	
	@OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
	//@JoinColumn(name="doctor_id")
	private List<Doctor> doctor = new ArrayList<>();
	
}
