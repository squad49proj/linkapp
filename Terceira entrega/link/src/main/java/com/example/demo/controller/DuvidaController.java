package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.demo.entity.Duvida;
import com.example.demo.service.DuvidaService;

@Controller
public class DuvidaController {

	private DuvidaService duvidaService;
	
	public DuvidaController(DuvidaService duvidaService) {
		super ();
		this.duvidaService = duvidaService;
	}
	
	@GetMapping("/contato/new")
	public String createDuvidaForm(Model model) {
		
		Duvida duvida = new Duvida();
		model.addAttribute("duvida", duvida);
		return "contact";
	}
	
	@PostMapping("/duvida")
	public String saveDuvida(@ModelAttribute("duvida") Duvida duvida) {
		duvidaService.saveDuvida(duvida);
		return "redirect:/home";
	}
	

}

