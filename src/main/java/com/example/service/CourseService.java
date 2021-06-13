package com.example.service;

import java.util.Set;

import com.example.entity.Course;

public interface CourseService {

	Course addCourses(Course courseEntity);

	Set<Course> getCourses();

}
