package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Qualification;

@Repository
public interface QualificationRepository extends JpaRepository<Qualification, String> {

	Qualification findByName(String qualification);

}
