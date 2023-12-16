package br.org.eternize.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name= "Pacote")
public class Pacote {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id_pacote;
	@Column(nullable=false)
	private String nome;
	@Column(nullable=false)
	private double valor;
	
	public Pacote(Long id_pacote, String nome, double valor) {
		super();
		this.id_pacote = id_pacote;
		this.nome = nome;
		this.valor = valor;
	}
	
	 public Pacote() {
		 super();
	 }
	
	public Long getId_pacote() {
		return id_pacote;
	}

	public void setId_pacote(Long id_pacote) {
		this.id_pacote = id_pacote;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	

	
}
