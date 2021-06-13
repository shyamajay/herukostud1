package com.example.service;

import java.util.List;

import com.example.entity.Student;
import com.example.exception.CourseServiceException;

public interface StudentService {

	Student addStudent(Student student) throws CourseServiceException;

	List<Student> allStudents();

}
