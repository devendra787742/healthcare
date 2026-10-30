package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ILabTestRepository;
import com.app.entities.LabTest;

@Service
@Transactional
public class LabTestServiceImpl implements ILabTestService{

	@Autowired
	private ILabTestRepository labRepo;
	
	@Override
	public List<LabTest> getLabTests() {
		return labRepo.findAll();
	}
	
}
