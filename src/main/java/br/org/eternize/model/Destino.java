package br.org.eternize.model;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "Destino")
public class Destino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_destino;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private double valor;
    @Column(columnDefinition = "longblob")
	private byte[] imagem;

    public Destino(Long id_destino, String nome, double valor) {
        super();
        this.id_destino = id_destino;
        this.nome = nome;
        this.valor = valor;
    }

    public Destino() {
    	super();
    }

    public Long getId_destino() {
        return id_destino;
    }

    public void setId_destino(Long id_destino) {
        this.id_destino = id_destino;
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
    public byte[] getImagem() {
		return imagem;
	}
	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	@Override
	public String toString() {
		return "Destino [id_destino=" + id_destino + ", nome=" + nome + ", valor=" + valor + ", imagem="
				+ Arrays.toString(imagem) + "]";
	}


    
    
}
