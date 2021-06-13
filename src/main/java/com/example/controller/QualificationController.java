package com.example.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.QualificationDto;
import com.example.entity.Qualification;
import com.example.service.QualificationService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class QualificationController {
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	QualificationService qualificationService;
	
	@PostMapping("/addqualification")
	public ResponseEntity<Qualification> addHooby(@Valid@RequestBody QualificationDto QualificationDto) {
		Qualification QualificationEntity = convertDtoToEntity(QualificationDto);
		Qualification course = qualificationService.addQualification(QualificationEntity);
		return new ResponseEntity<Qualification>(course,HttpStatus.CREATED);
	}
	
	
	public Qualification convertDtoToEntity(QualificationDto qualificationDto) {
		Qualification qualification = modelMapper.map(qualificationDto,Qualification.class);
		return qualification;
	}
	
	public QualificationDto convertEntityToDto(Qualification qualification) {
		QualificationDto qualificationDto = modelMapper.map(qualification, QualificationDto.class);
		return qualificationDto;
	}

}
