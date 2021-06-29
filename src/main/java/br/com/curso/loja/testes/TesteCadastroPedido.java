package br.com.curso.loja.testes;

import java.math.BigDecimal;
import java.util.List;

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
import br.com.curso.loja.vo.RelatorioVendasVO;

public class TesteCadastroPedido {

	public static void main(String[] args) {

		popularBancoDados(); // cadastra o produto/categoria 
		
		//recupera o produto que foi cadastrado 
		EntityManager em = JPAUtil.getEntityManager();
		
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		ClienteDAO clienteDAO = new ClienteDAO(em);

		
		Produto produto1 = produtoDAO.buscarPorId(1l);
		Produto produto2 = produtoDAO.buscarPorId(2l);
		Produto produto3 = produtoDAO.buscarPorId(3l);
		Cliente clienteRecuperado = clienteDAO.buscarPorId(1l);
				

		
		
		em.getTransaction().begin(); 
		
//		Cliente cliente;
		//atribui o produto recuperado a um cliente e monta um pedido para tal 
		Pedido pedido = new Pedido(clienteRecuperado);
		pedido.adicionarItem(new ItemPedido(10, pedido, produto1));
		pedido.adicionarItem(new ItemPedido(40, pedido, produto2));
		
		Pedido pedido2 = new Pedido(clienteRecuperado);
		pedido.adicionarItem(new ItemPedido(1, pedido2, produto3));
		
		
		PedidoDAO pedidoDao = new PedidoDAO(em);
		pedidoDao.cadastrar(pedido);
		
		

		em.getTransaction().commit(); 
		
		BigDecimal totalVendido = pedidoDao.valorTotalVendido();
	
		System.out.println("Valor Total vendido = " +totalVendido);
		

		List<RelatorioVendasVO> relatorio = pedidoDao.relatorioDeVendas();
		relatorio.forEach(System.out::println);
		 
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
		
		
		
		
		Cliente cliente = new Cliente("Mauricio", "233412");

		EntityManager em = JPAUtil.getEntityManager();

		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		CategoriaDAO categoriaDAO = new CategoriaDAO(em);
		ClienteDAO clienteDAO = new ClienteDAO(em);
		
		
		em.getTransaction().begin(); 
		
		//Cadastrar Categorias
		categoriaDAO.cadastrar(celulares);
		categoriaDAO.cadastrar(videoGames);
		categoriaDAO.cadastrar(informatica);
		
	
		//Cadastrar Produtos
		produtoDAO.cadastrar(celular);
		produtoDAO.cadastrar(ps5);
		produtoDAO.cadastrar(macbook);
		
	
		
		clienteDAO.cadastrar(cliente);
		
		em.getTransaction().commit();
		
		em.close();
	}

}
