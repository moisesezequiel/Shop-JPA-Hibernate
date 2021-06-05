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
	
	/** 1 Quando instanciar um novo obj(new) est� no estado de transient... ainda n�o foi persistido
	 * 
	 *  2 ao chamar o metodo persist() o obj est�ra no ciclo managed que � gerenciavel pela JPA 
	 *  ainda existe o metodo flush() que � para j� deixar sincronizado o obj com a JPA
	 *  
	 *  3 Metodo close() e clear() assim que fecha ou limpa finalizando a transa��o o obj est� agora
	 *  no ciclo de Detached  (n�o ir� alterar nada no obj exemplo a acima )
	 * 
	 * 
*/
}
