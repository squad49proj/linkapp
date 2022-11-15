package com.example.demo.service;

import java.util.List;



import com.example.demo.entity.Duvida;

public interface DuvidaService {

	List<Duvida> getAllDuvida();
	
    Duvida saveDuvida(Duvida duvida);
	
	Duvida getDuvidaById(Long id);
	
	Duvida updateDuvida(Duvida duvida);
	
	void deleteDuvidaById(Long id);
}

