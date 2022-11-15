package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@Controller
public class UserController {
	
	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	// handler method to handle list students and return mode and view
	@GetMapping("/users")
	public String listUsers(Model model) {
		model.addAttribute("users", userService.getAllUsers());
		return "users";
	}
	
	@GetMapping("/users/new")
	public String createUserForm(Model model) {
		
		// create student object to hold student form data
		User user = new User();
		model.addAttribute("user", user);
		return "usuario_cad";	
	}
	
	@PostMapping("/users")
	public String saveUser(@ModelAttribute("user") User user) {
		userService.saveUser(user);
		return "redirect:/home";
	}
	
	@GetMapping("/users/edit/{id}")
	public String editUserForm(@PathVariable Long id, Model model) {
		model.addAttribute("user", userService.getUserById(id));
		return "edit_user";
	}

	@PostMapping("/users/{id}")
	public String updateUser(@PathVariable Long id,
			@ModelAttribute("user") User user,
			Model model) {
		
		// get student from database by id
		User existingUser = userService.getUserById(id);
		existingUser.setId(id);
		existingUser.setNome(user.getNome());
		existingUser.setEmail(user.getEmail());
		existingUser.setSenha(user.getSenha());
		existingUser.setCpf(user.getCpf());
		existingUser.setCep(user.getCep());
		existingUser.setCidade(user.getCidade());
		existingUser.setEndereco(user.getEndereco());
		existingUser.setComplemento(user.getComplemento());
		existingUser.setEstado(user.getEstado());
		existingUser.setSexo(user.getSexo());
		existingUser.setTipo(user.getTipo());
		
		// save updated student object
		userService.updateUser(existingUser);
		return "redirect:/users";		
	}
	
	// handler method to handle delete student request
	
	@GetMapping("/users/{id}")
	public String deleteUser(@PathVariable Long id) {
		userService.deleteUserById(id);
		return "redirect:/users";
	}

}
