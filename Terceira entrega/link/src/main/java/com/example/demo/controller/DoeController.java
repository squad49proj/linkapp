package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.demo.entity.Doe;
import com.example.demo.service.DoeService;



@Controller
public class DoeController {
	
	private DoeService doeService;

	public DoeController(DoeService doeService) {
		super();
		this.doeService = doeService;
	}
	
	@GetMapping("/sobre/new")
	public String createDoeForm(Model model) {
		
		// create student object to hold student form data
		Doe doe = new Doe();
		model.addAttribute("doe", doe);
		return "about";
		
	}
	
	@PostMapping("/doe")
	public String saveDoe(@ModelAttribute("doe") Doe doe) {
		doeService.saveDoe(doe);
		return "redirect:/home";
	}

	
}
