package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
		
		@GetMapping("/home")
		public String home() {
			return "index";
		}
		
		@GetMapping("/")
		public String starter() {
			return "index";
		}
		
		@GetMapping("/contato")
	    public String promocoes() {
	    	return "contact";
		}
		/*
		@GetMapping("/sobre")
	    public String destino() {
	    	return "about";
		}
		*/
		@GetMapping("/login")
	    public String login() {
	    	return "login";
		}

}
