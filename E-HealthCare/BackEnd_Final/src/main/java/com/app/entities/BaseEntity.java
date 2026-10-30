package com.app.entities;

import javax.persistence.*;

import lombok.*;

//Base class for all the entities. No correspoding table for this class. 
//will contain common attributes
@MappedSuperclass
@Getter
@Setter
public class BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
}
