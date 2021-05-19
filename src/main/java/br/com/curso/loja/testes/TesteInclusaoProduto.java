package br.com.curso.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.curso.loja.dao.ProdutoDAO;
import br.com.curso.loja.modelo.Produto;
import br.com.curso.loja.util.JPAUtil;

public class TesteInclusaoProduto {

	public static void main(String[] args) {

		Produto celular = new Produto();
		celular.setNome("Sansung");
		celular.setDescricao("Vers�o A30 128GB");
		celular.setPreco(new BigDecimal("1500"));
		
		
	
		//cria um factory pegando o valor declarado dentro do XML
		
		EntityManager em = JPAUtil.getEntityManager();
		//Cria uma Entity pegando as configura��es do factory

		ProdutoDAO dao = new ProdutoDAO(em);
		
	
		em.getTransaction().begin(); //inicia a transa��o
		
		dao.cadastrar(celular);
		em.getTransaction().commit();
		
		em.close(); //fecha a Transa��o
		
		
		
	}

}
