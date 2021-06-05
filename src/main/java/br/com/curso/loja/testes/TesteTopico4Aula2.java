package br.com.curso.loja.testes;

import javax.persistence.EntityManager;

import br.com.curso.loja.modelo.Categoria;
import br.com.curso.loja.util.JPAUtil;

public class TesteTopico4Aula2 {

	public static void main(String[] args) {

		Categoria celulares = new Categoria("CELULARES");
	
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin(); 
		
		em.persist(celulares);
		celulares.setNome("XPTO");
		

		
		em.flush();
		em.clear();
		
		//4
		
		celulares = em.merge(celulares);
		celulares.setNome("Teste merge");
		em.flush();
		
		
	}
	
	//Ciclos de vida 
	
	/**
	 * 4 Metodo merge() ressucida uma entidade que est� no estado Detached e volta para o estado
	 * Managed e dai ser� possivel alterar novamente os atributos do obj (exemplo acima)
	 * 
	 * obs 1 ser� necessario criar um construtor default para evitar exception
	 * obs 2 o metodo merge em si n�o volta o obj para managed, ele s� devolve uma referencia 
	 * ser� necessario criar um obj de retorno ao chamar o metodo
	 * 
*/
}
