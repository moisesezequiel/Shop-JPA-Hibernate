package br.com.curso.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.curso.loja.dao.CategoriaDAO;
import br.com.curso.loja.dao.ProdutoDAO;
import br.com.curso.loja.modelo.Categoria;
import br.com.curso.loja.modelo.Produto;
import br.com.curso.loja.util.JPAUtil;

public class TesteInclusaoProduto {

	public static void main(String[] args) {

		Categoria celulares = new Categoria("CELULARES");
		Produto celular = new Produto("TABLET", "Versão A30 128GB", new BigDecimal("1500"), celulares);
	
		
			
		
		EntityManager em = JPAUtil.getEntityManager();
		//Cria uma Entity pegando as configurações do factory

		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		CategoriaDAO categoriaDAO = new CategoriaDAO(em);
		
		
		em.getTransaction().begin(); //inicia a transação
		
		categoriaDAO.cadastrar(celulares);//salvando primeiro a categoria no banco de dados para não dar erro de transiente quanto tentar persistir o produto 
		produtoDAO.cadastrar(celular);
		
		em.getTransaction().commit();
		
		em.close(); //fecha a Transação
		
		
		
	}

}
