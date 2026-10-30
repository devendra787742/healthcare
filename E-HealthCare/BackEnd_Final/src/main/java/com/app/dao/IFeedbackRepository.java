package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Feedback;

@Repository
public interface IFeedbackRepository extends JpaRepository<Feedback, Long> {
	
}
