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

import com.example.dto.HobbyDto;
import com.example.entity.Hobby;
import com.example.service.HobbyService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class HobbyController {
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	HobbyService hobbyService;
	
	@PostMapping("/addhobbies")
	public ResponseEntity<Hobby> addHooby(@Valid@RequestBody HobbyDto hobbyDto) {
		Hobby hobbyEntity = convertDtoToEntity(hobbyDto);
		Hobby course = hobbyService.addHobby(hobbyEntity);
		return new ResponseEntity<Hobby>(course,HttpStatus.CREATED);
	}
	
	public Hobby convertDtoToEntity(HobbyDto hobbyDto) {
		Hobby hobby = modelMapper.map(hobbyDto, Hobby.class);
		return hobby;
	}
	
	public HobbyDto convertEntityToDto(Hobby hobby) {
		HobbyDto hobbyDto = modelMapper.map(hobby, HobbyDto.class);
		return hobbyDto;
	}

}
