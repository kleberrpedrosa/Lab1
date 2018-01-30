package br.com.kleberrpedrosa;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="imagem")
public class Imagem implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String tipo;
	
	@ManyToOne
	private Produto produto;
	
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public Produto getProduto() {
		return produto;
	}
	public String getTipo() {
		return tipo;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
		
	
	
}
