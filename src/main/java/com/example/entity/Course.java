package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Course {

	@Id
	@NotNull
	@Size(min = 5, max = 10, message = "the minimum length should be 5")
	private String name;

	public Course() {
		super();
	}

	public Course(@NotNull @Size(min = 5, max = 10, message = "the minimum length should be 5") String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
