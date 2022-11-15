package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Doe;

public interface DoeService {
	List<Doe> getAllDoe();
	
	Doe saveDoe(Doe doe);
	
	Doe getDoeById(Long id);
	
	Doe updateDoe(Doe doe);
	
	void deleteDoeById(Long id);
}
