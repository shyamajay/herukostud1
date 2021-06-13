package com.example.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Student {
	@Id
	@NotNull
	private int id;
	@NotNull
	@Size(min = 1, max = 50, message = "maximum only 50 words allowed")
	private String firstName;
	@Size(min = 1, max = 50, message = "maximum only 50 words allowed")
	private String lastName;
	private String emailId;
	@Size(max = 10, message = "maximum only 10 words allowed")
	private String mobileNumber;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	private String homeDetails;
	@NotNull
	@Size(min = 1, max = 50, message = "maximum only 50 words allowed")
	private String city;
	@NotNull
	@Size(max = 6, message = "maximum only 50 words allowed")
	private String pinCode;
	@NotNull
	@Size(min = 1, max = 50, message = "maximum only 50 words allowed")
	private String state;
	private String country;

	@ManyToMany(cascade = CascadeType.ALL)
	@JsonIgnoreProperties("students")
	private Set<Hobby> hobbies;

	@ManyToMany(cascade = CascadeType.ALL)
	@JsonIgnoreProperties("student")
	private Set<Qualification> qualification;

	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnoreProperties("student")
	private Course courses;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(@NotNull int id,
			@NotNull @Size(min = 1, max = 50, message = "maximum only 50 words allowed") String firstName,
			@Size(min = 1, max = 50, message = "maximum only 50 words allowed") String lastName, String emailId,
			@Size(max = 10, message = "maximum only 10 words allowed") String mobileNumber, Gender gender,
			String homeDetails,
			@NotNull @Size(min = 1, max = 50, message = "maximum only 50 words allowed") String city,
			@NotNull @Size(max = 6, message = "maximum only 50 words allowed") String pinCode,
			@NotNull @Size(min = 1, max = 50, message = "maximum only 50 words allowed") String state, String country,
			Set<Hobby> hobbies, Set<Qualification> qualification, Course courses) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.mobileNumber = mobileNumber;
		this.gender = gender;
		this.homeDetails = homeDetails;
		this.city = city;
		this.pinCode = pinCode;
		this.state = state;
		this.country = country;
		this.hobbies = hobbies;
		this.qualification = qualification;
		this.courses = courses;
	}

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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
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
