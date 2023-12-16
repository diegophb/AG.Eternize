package br.org.eternize.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name= "cliente")
public class Cliente {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    
	private Long id_cliente;
	@Column(nullable=false)
	private String nome;
	@Column(nullable=false)
	private String telefone;
	@Column(nullable=false)
	private String email;
	
	
	
	public Cliente(Long id_cliente, String nome, String telefone, String email) {
		super();
		this.id_cliente = id_cliente;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
	}
	
	 public Cliente() {
		 super();
	 }

	public Long getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Cliente [id_cliente=" + id_cliente + ", nome=" + nome + ", telefone=" + telefone + ", email=" + email
				+ "]";
	}
	
		
}
