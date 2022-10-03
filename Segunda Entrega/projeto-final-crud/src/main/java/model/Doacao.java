package model;

public class Doacao {

	private int id;
	private String nome;
	private String email;
	private String quantia;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	@Override
	public String toString() {
		return "Doacao [id=" + id + ", nome=" + nome + ", email=" + email + ", quantia=" + quantia + "]";
	}

}
