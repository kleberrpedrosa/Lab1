package br.com.kleberrpedrosa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Repositorio {

	private static EntityManager em = null;
	private static EntityManager eManager(){

		if(em == null){
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit_app");
			em = factory.createEntityManager();
		}
		
		return em;
	}
	
	public static void salvarProdutoTeste(){
		
		Produto p = new Produto();
		p.setDescricao("Este foi mais um teste bem sucedido");
		p.setNome("Framboesa");
		
		Imagem img1 = new Imagem();
		img1.setNome("Imagem 1");
		img1.setTipo("PNG");
		p.adicionarImagem(img1);
		
		Imagem img2 = new Imagem();
		img2.setNome("Imagem 2");
		img2.setTipo("JPG");
		p.adicionarImagem(img2);
		
		Imagem img3 = new Imagem();
		img3.setNome("Imagem 3");
		img3.setTipo("BMP");
		p.adicionarImagem(img3);
		
		Imagem img4 = new Imagem();
		img4.setNome("Imagem 4");
		img4.setTipo("BMP");
		p.adicionarImagem(img4);
		
	    salvar(p);

	    System.out.println("ID: " + p.getId());

	    em.close();
	}
	
	public static void salvar(Produto p){
		if (p.getId() == null){
		    eManager().getTransaction().begin();        
		    eManager().persist(p);
		    eManager().getTransaction().commit();    
		} else {
		    eManager().getTransaction().begin();        
		    eManager().merge(p);
		    eManager().getTransaction().commit();    
		}
	}
	
	public static List<Produto> consultar(){
		try{
			Query consulta = eManager().createQuery("select p from Produto p");
			return (List<Produto>) consulta.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public static Produto recuperar(Long id){
		try{
			Query consulta = eManager().createQuery("select p from Produto p where id=:id");
			consulta.setParameter("id", id);
			return (Produto) consulta.getSingleResult();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
