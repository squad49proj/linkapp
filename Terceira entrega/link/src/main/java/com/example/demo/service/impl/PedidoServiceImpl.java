package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Pedido;
import com.example.demo.repository.PedidoRepository;
import com.example.demo.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService{
	
    private PedidoRepository pedidoRepository;
	
	public PedidoServiceImpl(PedidoRepository pedidoRepository) {
		super();
		this.pedidoRepository = pedidoRepository;
	}

	@Override
	public List<Pedido> getAllPedidos() {
		return pedidoRepository.findAll();
	}

	@Override
	public Pedido savePedido(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}

	@Override
	public Pedido getPedidoById(Long id) {
		return pedidoRepository.findById(id).get();
	}

	@Override
	public Pedido updatePedido(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}

	@Override
	public void deletePedidoById(Long id) {
		pedidoRepository.deleteById(id);	
	}

}
