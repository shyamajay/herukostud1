package com.example.dto;

import java.util.Set;

import com.example.entity.Course;
import com.example.entity.Gender;
import com.example.entity.Hobby;
import com.example.entity.Qualification;

public class StudentDto {

	private int id;
	private String firstName;
	private String lastName;
	private String emailId;
	private String mobileNumber;
	private Gender gender;
	private String homeDetails;
	private String city;
	private String pinCode;
	private String state;
	private String country;
	private Set<Hobby> hobbies;
	private Set<Qualification> qualification;
	private Course courses;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmailId() {
		return emailId;
	}

	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Set<Hobby> getHobbies() {
		return hobbies;
	}

	public void setHobbies(Set<Hobby> hobbies) {
		this.hobbies = hobbies;
	}

	public Set<Qualification> getQualification() {
		return qualification;
	}

	public void setQualification(Set<Qualification> qualification) {
		this.qualification = qualification;
	}

	public Course getCourses() {
		return courses;
	}

	public void setCourses(Course courses) {
		this.courses = courses;
	}

	public String getHomeDetails() {
		return homeDetails;
	}

	public void setHomeDetails(String homeDetails) {
		this.homeDetails = homeDetails;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
