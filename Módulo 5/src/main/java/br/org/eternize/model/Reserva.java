package br.org.eternize.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name= "Reserva")
public class Reserva {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id_reserva;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cliente")
	Cliente cliente;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pacote")
	Pacote pacote;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_destino")
	Destino destino;	
	@Column(nullable=false)
	private double valor;
	@Column(nullable = false)
	@DateTimeFormat(iso = ISO.DATE, pattern = "yyyy-MM-dd")
	private Date data_reserva;
	
	public Reserva(Long id, Cliente cliente, Pacote pacote, Destino destino, double valor, Date data_reserva) {
		super();
		this.id_reserva = id;
		this.cliente = cliente;
		this.pacote = pacote;
		this.destino = destino;
		this.valor = destino.getValor()+pacote.getValor();
		this.data_reserva = data_reserva;
	
	}
	 public Reserva() {
		 super();
	 }

	public Long getId_reserva() {
		return id_reserva;
	}

	public void setId_reserva(Long id_reserva) {
		this.id_reserva = id_reserva;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Pacote getPacote() {
		return pacote;
	}

	public void setPacote(Pacote pacote) {
		this.pacote = pacote;
	}

	public Destino getDestino() {
		return destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Date getData_reserva() {
		return data_reserva;
	}

	public void setData_reserva(Date data_reserva) {
		this.data_reserva = data_reserva;
	}
	
}
