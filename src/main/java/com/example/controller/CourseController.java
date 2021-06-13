package com.example.controller;

import java.util.Set;
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

import com.example.dto.CourseDto;
import com.example.entity.Course;
import com.example.service.CourseService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CourseController {

	@Autowired
	ModelMapper modelMapper;
	@Autowired
	CourseService courseService;
	
	@PostMapping("/addcourse")
	public ResponseEntity<Course> addCourse(@Valid@RequestBody CourseDto courseDto) {
		Course courseEntity = convertDtoToEntity(courseDto);
		Course course = courseService.addCourses(courseEntity);
		return new ResponseEntity<Course>(course,HttpStatus.CREATED);
	}
	
	@GetMapping("/getcourses")
	public ResponseEntity<Set<CourseDto>> getCourses(){
		Set<CourseDto>courseDto = courseService.getCourses().stream()
				.map(course->convertEntityToDto(course)).collect(Collectors.toSet());
		return new ResponseEntity<Set<CourseDto>>(courseDto, HttpStatus.OK);
	}
	
	
	public Course convertDtoToEntity(CourseDto courseDto) {
		Course course = modelMapper.map(courseDto, Course.class);
		return course;
	}
	
	public CourseDto convertEntityToDto(Course course) {
		CourseDto courseDto = modelMapper.map(course, CourseDto.class);
		return courseDto;
	}
}
