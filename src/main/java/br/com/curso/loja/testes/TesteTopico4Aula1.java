package br.com.curso.loja.testes;

import javax.persistence.EntityManager;

import br.com.curso.loja.modelo.Categoria;
import br.com.curso.loja.util.JPAUtil;

public class TesteTopico4Aula1 {

	public static void main(String[] args) {

		Categoria celulares = new Categoria("CELULARES");
	
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin(); 
		
		em.persist(celulares);
		celulares.setNome("CELULARES");
		

		
		em.getTransaction().commit();
		
		em.close();
		
//3
		celulares.setNome("Teste detached");
		
		
	}
	
	//Ciclos de vida 
	
	/** 1 Quando instanciar um novo obj(new) está no estado de transient... ainda não foi persistido
	 * 
	 *  2 ao chamar o metodo persist() o obj estára no ciclo managed que é gerenciavel pela JPA 
	 *  ainda existe o metodo flush() que é para já deixar sincronizado o obj com a JPA
	 *  
	 *  3 Metodo close() e clear() assim que fecha ou limpa finalizando a transação o obj está agora
	 *  no ciclo de Detached  (não irá alterar nada no obj exemplo a acima )
	 * 
	 * 
*/
}
