package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.LabTest;

@Repository
public interface ILabTestRepository extends JpaRepository<LabTest, Long> {

}
