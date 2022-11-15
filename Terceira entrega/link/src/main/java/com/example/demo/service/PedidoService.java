package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Pedido;

public interface PedidoService {
	List<Pedido> getAllPedidos();
	
	Pedido savePedido(Pedido pedido);
	
	Pedido getPedidoById(Long id);
	
	Pedido updatePedido(Pedido pedido);
	
	void deletePedidoById(Long id);
}
