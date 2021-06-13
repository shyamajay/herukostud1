package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Qualification;
import com.example.repository.QualificationRepository;

@Service
public class QualificationServiceImpl implements QualificationService {

	@Autowired
	QualificationRepository repos;
	
	public Qualification addQualification(Qualification qualificationEntity) {
		return repos.save(qualificationEntity);
	}
}
