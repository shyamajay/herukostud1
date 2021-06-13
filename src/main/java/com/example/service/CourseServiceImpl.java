package com.example.service;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Course;
import com.example.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseRepository repos;
	
	public Course addCourses(Course courseEntity) {
		return repos.save(courseEntity);
	}
	
	public Set<Course> getCourses(){
		List<Course> list = repos.findAll();
		Set<Course>course = new TreeSet<>();
		for (Course c : list) {
			course.add(c);
		}
		return course;
	}
}
