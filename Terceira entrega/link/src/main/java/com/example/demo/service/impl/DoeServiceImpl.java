package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Doe;
import com.example.demo.repository.DoeRepository;
import com.example.demo.service.DoeService;


@Service
public class DoeServiceImpl implements DoeService{
	
    private DoeRepository doeRepository;
	
	public DoeServiceImpl(DoeRepository doeRepository) {
		super();
		this.doeRepository = doeRepository;
	}

	@Override
	public List<Doe> getAllDoe() {
		return doeRepository.findAll();
	}

	@Override
	public Doe saveDoe(Doe doe) {
		return doeRepository.save(doe);
	}

	@Override
	public Doe getDoeById(Long id) {
		return doeRepository.findById(id).get();
	}

	@Override
	public Doe updateDoe(Doe doe) {
		return doeRepository.save(doe);
	}

	@Override
	public void deleteDoeById(Long id) {
		doeRepository.deleteById(id);	
	}

}
