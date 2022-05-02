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

public class TestePerfomaceConsultas {

	public static void main(String[] args) {

		popularBancoDados(); // cadastra o produto/categoria 
		
		//recupera o produto que foi cadastrado 
		EntityManager em = JPAUtil.getEntityManager();
		PedidoDAO pedidoDAO = new PedidoDAO(em);
		Pedido pedido = pedidoDAO.buscarPedidoComCliente(1l);  
		
		em.close();
		System.out.println(pedido.getCliente().getNome() );
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
		
		//Cliente 
		Cliente cliente = new Cliente("Mauricio", "233412");
		
		//Pedido
		Pedido pedido = new Pedido(cliente);
		pedido.adicionarItem(new ItemPedido(2, pedido, macbook));
		
		Pedido pedido2 = new Pedido(cliente);
		pedido2.adicionarItem(new ItemPedido(2, pedido2, macbook));
		
		
		


		EntityManager em = JPAUtil.getEntityManager();

		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		CategoriaDAO categoriaDAO = new CategoriaDAO(em);
		ClienteDAO clienteDAO = new ClienteDAO(em);
		PedidoDAO pedidoDAO = new PedidoDAO(em);
		
		
		em.getTransaction().begin(); 
		
		//Cadastrar Categorias
		categoriaDAO.cadastrar(celulares);
		categoriaDAO.cadastrar(videoGames);
		categoriaDAO.cadastrar(informatica);
		
	
		//Cadastrar Produtos
		produtoDAO.cadastrar(celular);
		produtoDAO.cadastrar(ps5);
		produtoDAO.cadastrar(macbook);
		
	
		//cadastrar Criente
		clienteDAO.cadastrar(cliente);
		
		//Cadastrar Pedido
		pedidoDAO.cadastrar(pedido);
		pedidoDAO.cadastrar(pedido2);

		
		em.getTransaction().commit();
		
		em.close();
	}

}
