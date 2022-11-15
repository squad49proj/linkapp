package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	private String nome;
	private String email;
	private String senha;
	private String cpf;
	private String sexo;
	private String tipo;
	private String endereco;
	private String complemento;
	private String cidade;
	private String estado;
	private String cep;
	
	public User() {
		
	}
	
	public User(String nome, String email, String senha, String cpf, String sexo, String tipo, String endereco,
			String complemento, String cidade, String estado, String cep) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.cpf = cpf;
		this.sexo = sexo;
		this.tipo = tipo;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
}
