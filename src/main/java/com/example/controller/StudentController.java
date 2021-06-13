package com.example.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.StudentDto;
import com.example.entity.Student;
import com.example.exception.CourseNotFoundException;
import com.example.exception.CourseServiceException;
import com.example.service.StudentService;

/**
 * @author M1064333
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

	private StudentService studentService;
	private ModelMapper modelMapper;
	
	@Autowired
	public StudentController(StudentService studentService,ModelMapper modelMapper) {
		this.studentService = studentService;
		this.modelMapper = modelMapper;
	}
	
	@PostMapping("/student")
	public ResponseEntity<Student>addStudent(@Valid@RequestBody StudentDto student) throws CourseNotFoundException{
		Student convertedDto = convertToEntity(student);
		Student s;
		try {
			s = studentService.addStudent(convertedDto);
		} catch (CourseServiceException e) {
			throw new CourseNotFoundException(e.getMessage());
		}
		return new ResponseEntity<Student>(s,HttpStatus.CREATED);
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<StudentDto>>allStudent(){
		List<StudentDto> students = studentService.allStudents().stream()
				.map(student->convertToDto(student)).collect(Collectors.toList());
		return new ResponseEntity<List<StudentDto>>(students,HttpStatus.OK);
	}


	private StudentDto convertToDto(Student student) {
		StudentDto studentDto = modelMapper.map(student, StudentDto.class);
		return studentDto;
	}

	private Student convertToEntity(StudentDto studentDto) {
		Student student = modelMapper.map(studentDto, Student.class);
		return student;
	}
}
