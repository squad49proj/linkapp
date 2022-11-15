package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Duvida;
import com.example.demo.repository.DuvidaRepository;
import com.example.demo.service.DuvidaService;


@Service
public class DuvidaServiceImpl implements DuvidaService {

	
    private DuvidaRepository duvidaRepository;
	
	public DuvidaServiceImpl(DuvidaRepository duvidaRepository) {
		super();
		this.duvidaRepository = duvidaRepository;
	}

	@Override
	public List<Duvida> getAllDuvida() {
		return duvidaRepository.findAll();
	}

	@Override
	public Duvida saveDuvida(Duvida duvida) {
		return duvidaRepository.save(duvida);
	}

	@Override
	public Duvida getDuvidaById(Long id) {
		return duvidaRepository.findById(id).get();
	}

	@Override
	public Duvida updateDuvida(Duvida duvida) {
		return duvidaRepository.save(duvida);
	}

	@Override
	public void deleteDuvidaById(Long id) {
		duvidaRepository.deleteById(id);	
	}

}

