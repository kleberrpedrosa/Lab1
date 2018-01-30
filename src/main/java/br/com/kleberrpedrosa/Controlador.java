package br.com.kleberrpedrosa;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="Controlador")
@SessionScoped
public class Controlador implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Produto> consulta;
	
	public List<Produto> getConsulta() {
		this.consulta = Repositorio.consultar();
		return consulta;
	}

	public void setConsulta(List<Produto> consulta) {
		this.consulta = consulta;
	}

	private Produto produto;
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public void carregarProduto(){
		Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
	    String produtoid = params.get("produtoid");
	    
	    Produto p = Repositorio.recuperar(new Long(produtoid));
	    this.setProduto(p);
	    
	    try{
	    	FacesContext.getCurrentInstance().getExternalContext().dispatch("/produto.xhtml");
	    } catch (Exception e){}
	    
	}
	
	public void adicionarProduto(){

	    Produto p = new Produto();
	    this.setProduto(p);
		
		try{
	    	FacesContext.getCurrentInstance().getExternalContext().dispatch("/produto.xhtml");
	    } catch (Exception e){
	    	String s = e.getMessage();
	    }
		
	}
	
	public void adicionarImagem(){
		Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
	    String imagemnome = params.get("frmProduto:imagemnome");
	    String imagemtipo = params.get("frmProduto:imagemtipo");
	    
	    Imagem i = new Imagem();
	    i.setNome(imagemnome);
	    i.setTipo(imagemtipo);
	    
	    atualizarModelo();
	    this.getProduto().adicionarImagem(i);		
	}
	
	public void salvar(){
		atualizarModelo();
		Repositorio.salvar(this.getProduto());
		this.setConsole("Salvo com sucesso.");
		
		try{
	    	FacesContext.getCurrentInstance().getExternalContext().dispatch("/index.xhtml");
	    } catch (Exception e){
	    	String s = e.getMessage();
	    }
		
	}
	
	public void atualizarModelo(){
		Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
	    this.getProduto().setNome(params.get("frmProduto:nome"));
	    this.getProduto().setDescricao(params.get("frmProduto:descricao"));
	}
	
	//TESTES
	//=============================================================================
	private String console;
	
	public String getConsole() {
		return console;
	}

	public void setConsole(String console) {
		this.console = console;
	}

	public void executarTeste(){
		
		Produto p = Repositorio.recuperar(2L);
		this.setConsole(p.getDescricao());
		
		//TESTE 1: LISTAGEM DE PRODUTOS
		//RESULTADO: OK
		//List<Produto> consulta = Repositorio.consultar();
		
		//StringBuilder prmpt = new StringBuilder("");
		
		//for (Produto p : consulta){
		//	prmpt.append("\n" + p.getId().toString() + " " + p.getNome()  + " " + p.getDescricao());
		//}
		
		//this.setConsole(prmpt.toString());
		
		
	}

}