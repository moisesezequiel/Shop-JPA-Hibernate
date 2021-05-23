package br.com.curso.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.curso.loja.dao.ProdutoDAO;
import br.com.curso.loja.modelo.Categoria;
import br.com.curso.loja.modelo.Produto;
import br.com.curso.loja.util.JPAUtil;

public class TesteInclusaoProduto {

	public static void main(String[] args) {

		Produto celular = new Produto("Sansung", "Versão A30 128GB", new BigDecimal("1500"), Categoria.CELULARES);
	
		
		//cria um factory pegando o valor declarado dentro do XML
		
		EntityManager em = JPAUtil.getEntityManager();
		//Cria uma Entity pegando as configurações do factory

		ProdutoDAO dao = new ProdutoDAO(em);
		
	
		em.getTransaction().begin(); //inicia a transação
		
		dao.cadastrar(celular);
		em.getTransaction().commit();
		
		em.close(); //fecha a Transação
		
		
		
	}

}
