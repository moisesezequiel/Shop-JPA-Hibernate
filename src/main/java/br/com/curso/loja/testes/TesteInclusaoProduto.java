package br.com.curso.loja.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.curso.loja.dao.CategoriaDAO;
import br.com.curso.loja.dao.ProdutoDAO;
import br.com.curso.loja.modelo.Categoria;
import br.com.curso.loja.modelo.Produto;
import br.com.curso.loja.util.JPAUtil;

public class TesteInclusaoProduto {

	public static void main(String[] args) {

		cadastrarProduto();
		
		EntityManager em = JPAUtil.getEntityManager();

		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		 
//find Id
//	   Produto  p =	produtoDAO.buscarPorId(1L); 
//	   System.out.println(p.getNome());
	 
	   
//find All
//	   List<Produto> todos = produtoDAO.buscarTodos();
//	   todos.forEach(p2 -> System.out.println(p2.getNome()));
	   
	   
//find por nome
//	   List<Produto> todos = produtoDAO.buscarPorNome("TABLET");
//	   todos.forEach(p2 -> System.out.println(p2.getDescricao()));
	   
	   
//find por nome
	   List<Produto> todos = produtoDAO.buscarPorNomeCategoria("CELULARES");
	   todos.forEach(p2 -> System.out.println(p2.getNome()));
		
		
		
		
	}

	private static void cadastrarProduto() {
		Categoria celulares = new Categoria("CELULARES");
		Produto celular = new Produto("TABLET", "Versão A30 128GB", new BigDecimal("1500"), celulares);
		
		EntityManager em = JPAUtil.getEntityManager();

		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		CategoriaDAO categoriaDAO = new CategoriaDAO(em);
		
		
		em.getTransaction().begin(); 
		
		categoriaDAO.cadastrar(celulares);
		produtoDAO.cadastrar(celular);
		
		em.getTransaction().commit();
		
		em.close();
	}

}
