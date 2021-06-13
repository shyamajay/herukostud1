package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Hobby;
import com.example.repository.HobbyRepository;

@Service
public class HoobyServiceImpl implements HobbyService {

	@Autowired
	HobbyRepository repos;
	public Hobby addHobby(Hobby hobbyEntity) {
		return repos.save(hobbyEntity);
	}
}
