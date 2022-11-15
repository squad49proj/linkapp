package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Pedido;
import com.example.demo.service.PedidoService;


@Controller
public class PedidoController {
	
	private PedidoService pedidoService;

	public PedidoController(PedidoService pedidoService) {
		super();
		this.pedidoService = pedidoService;
	}
	
	// handler method to handle list students and return mode and view
	@GetMapping("/pedidos")
	public String listPedidos(Model model) {
		model.addAttribute("pedidos", pedidoService.getAllPedidos());
		return "pedidos";
	}
	
	@GetMapping("/pedidos/new")
	public String createPedidoForm(Model model) {
		
		// create student object to hold student form data
		Pedido pedido = new Pedido();
		model.addAttribute("pedido", pedido);
		return "create_pedido";
		
	}
	
	@PostMapping("/pedidos")
	public String savePedido(@ModelAttribute("pedido") Pedido pedido) {
		pedidoService.savePedido(pedido);
		return "redirect:/pedidos";
	}
	
	@GetMapping("/pedidos/edit/{id}")
	public String editPedidoForm(@PathVariable Long id, Model model) {
		model.addAttribute("pedido", pedidoService.getPedidoById(id));
		return "update_pedido";
	}

	@PostMapping("/pedidos/{id}")
	public String updatePedido(@PathVariable Long id,
			@ModelAttribute("pedido") Pedido pedido, Model model) {
		
		// get student from database by id
		Pedido existingPedido = pedidoService.getPedidoById(id);
		existingPedido.setId(id);
		existingPedido.setNome(pedido.getNome());
		existingPedido.setCpf(pedido.getCpf());
		existingPedido.setEquipamento(pedido.getEquipamento());
		existingPedido.setRelato(pedido.getRelato());
		
		// save updated student object
		pedidoService.updatePedido(existingPedido);
		return "redirect:/pedidos";		
	}
	
	// handler method to handle delete student request
	
	@GetMapping("/pedidos/{id}")
	public String deletePedido(@PathVariable Long id) {
		pedidoService.deletePedidoById(id);
		return "redirect:/pedidos";
	}

}
