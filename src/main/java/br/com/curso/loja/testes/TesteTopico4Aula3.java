package br.com.curso.loja.testes;

import javax.persistence.EntityManager;

import br.com.curso.loja.modelo.Categoria;
import br.com.curso.loja.util.JPAUtil;

public class TesteTopico4Aula3 {

	public static void main(String[] args) {

		Categoria celulares = new Categoria("CELULARES");
	
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin(); 
		
		em.persist(celulares);
		celulares.setNome("XPTO");
		

		
		em.flush();
		em.clear();
		
		
		celulares = em.merge(celulares);
		celulares.setNome("Teste merge");
		em.flush();
		
		//5 
		em.remove(celulares);
		em.flush();
		
		
	}
	
	//Ciclos de vida 
	
	/**
	 * 5 Metodo remove()  deleta o entidade com base no id 
	 * não será possivel deletar uma entidade que está detached será necessario ela estar maanged
*/
}
