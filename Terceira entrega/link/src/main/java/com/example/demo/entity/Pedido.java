package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	private String nome;
	private String relato;
	private String equipamento;
	private String cpf;
	
	public Pedido() {
		
	}

	public Pedido(String nome, String relato, String equipamento, String cpf) {
		super();
		this.nome = nome;
		this.relato = relato;
		this.equipamento = equipamento;
		this.cpf = cpf;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRelato() {
		return relato;
	}

	public void setRelato(String relato) {
		this.relato = relato;
	}

	public String getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(String equipamento) {
		this.equipamento = equipamento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}
