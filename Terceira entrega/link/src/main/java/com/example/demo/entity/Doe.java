package com.example.demo.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "doe")
public class Doe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nome;
	private String email;
	private String quantia;
		
	public Doe() {
	}

	public Doe(long id, String nome, String email, String quantia) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.quantia = quantia;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public String getQuantia() {
		return quantia;
	}

	public void setQuantia(String quantia) {
		this.quantia = quantia;
	}
	
	
	
	
}
