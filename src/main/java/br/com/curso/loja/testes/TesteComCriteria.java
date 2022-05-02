package br.com.curso.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.curso.loja.dao.CategoriaDAO;
import br.com.curso.loja.dao.ClienteDAO;
import br.com.curso.loja.dao.PedidoDAO;
import br.com.curso.loja.dao.ProdutoDAO;
import br.com.curso.loja.modelo.Categoria;
import br.com.curso.loja.modelo.Cliente;
import br.com.curso.loja.modelo.ItemPedido;
import br.com.curso.loja.modelo.Pedido;
import br.com.curso.loja.modelo.Produto;
import br.com.curso.loja.util.JPAUtil;

public class TesteComCriteria {

	public static void main(String[] args) {

		popularBancoDados(); // cadastra o produto/categoria 
		
		//recupera o produto que foi cadastrado 
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtodao = new ProdutoDAO(em);
		produtodao.buscarPorParametrosComCriteria("PS5", null, null);
	}

	private static void popularBancoDados() {
		
		//Categorias
		Categoria celulares = new Categoria("CELULARES");
		Categoria videoGames = new Categoria("VIDEOGAMES");
		Categoria informatica= new Categoria("INFORMATICA");

		//Produtos
		Produto celular = new Produto("TABLET", "Versão A30 128GB", new BigDecimal("800"), celulares);
		Produto ps5 = new Produto("PS5", "PS5 SLIN", new BigDecimal("2000"), videoGames);
		Produto macbook = new Produto("MACBOOK", "MAC I7 16GB DE MEMORIA", new BigDecimal("3000"), informatica);
		

		EntityManager em = JPAUtil.getEntityManager();

		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		CategoriaDAO categoriaDAO = new CategoriaDAO(em);
	
		
		em.getTransaction().begin(); 
		
		//Cadastrar Categorias
		categoriaDAO.cadastrar(celulares);
		categoriaDAO.cadastrar(videoGames);
		categoriaDAO.cadastrar(informatica);
		
	
		//Cadastrar Produtos
		produtoDAO.cadastrar(celular);
		produtoDAO.cadastrar(ps5);
		produtoDAO.cadastrar(macbook);
		
	
		em.getTransaction().commit();
		
		em.close();
	}

}
