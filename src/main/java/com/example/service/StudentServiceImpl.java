package com.example.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Course;
import com.example.entity.Hobby;
import com.example.entity.Qualification;
import com.example.entity.Student;
import com.example.exception.CourseServiceException;
import com.example.repository.CourseRepository;
import com.example.repository.HobbyRepository;
import com.example.repository.QualificationRepository;
import com.example.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository repos;
	@Autowired
	QualificationRepository repos1;
	@Autowired
	CourseRepository repos2;
	@Autowired
	HobbyRepository repos3;

	public Student addStudent(Student student) throws CourseServiceException {
		Course course = student.getCourses();

		Course c = repos2.findByName(course.getName());

		Set<Qualification> list = new HashSet<>();

		Set<Qualification> qualification = student.getQualification();

		qualification = addQualification(list, qualification);

		Set<Hobby> hlist = new HashSet<>();

		Set<Hobby> hobbies = student.getHobbies();

		hobbies = addHobbies(hobbies, hlist);

		if (c != null && hobbies.isEmpty() != true && hlist.isEmpty() != true) {
			student.setCourses(c);
			student.setQualification(list);
			student.setHobbies(hlist);
			return repos.save(student);

		}

		else {
			System.out.println(c);
			System.out.println(hobbies.isEmpty());
			System.out.println(hlist.isEmpty());
			throw new CourseServiceException("Value passed is null");
		}

	}

	private Set<Hobby> addHobbies(Set<Hobby> hobbies, Set<Hobby> hlist) {
		for (Hobby hobbie2 : hobbies) {
			String hName = hobbie2.getName();
			Hobby h = repos3.findByName(hName);
			hlist.add(h);
		}
		return hlist;
	}

	private Set<Qualification> addQualification(Set<Qualification> list, Set<Qualification> qualification) {
		for (Qualification Qualification2 : qualification) {
			String qName = Qualification2.getName();
			Qualification qual = repos1.findByName(qName);
			list.add(qual);
		}
		return list;
	}

	public List<Student> allStudents() {
		return repos.findAll();
	}
}
