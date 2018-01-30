package br.com.kleberrpedrosa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="produto")
public class Produto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator( name = "PRODUTOID", sequenceName = "PRODUTOSEQ", allocationSize = 1 )
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "PRODUTOID" )
	private Long id;
	private String nome;
	private String descricao;
	
	@OneToMany(mappedBy="produto", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Imagem> imagens = new ArrayList<Imagem>();
	
	/* definir produto pai */
	
	public void adicionarImagem(Imagem i){
		i.setProduto(this);
		this.imagens.add(i);
	}
	
	public String getDescricao() {
		return descricao;
	}
	public Long getId() {
		return id;
	}
	public List<Imagem> getImagens() {
		return imagens;
	}
	public String getNome() {
		return nome;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setImagens(List<Imagem> imagens) {
		this.imagens = imagens;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
