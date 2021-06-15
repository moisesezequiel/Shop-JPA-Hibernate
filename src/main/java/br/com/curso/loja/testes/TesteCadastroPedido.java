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

public class TesteCadastroPedido {

	public static void main(String[] args) {

		popularBancoDados(); // cadastra o produto/categoria 
		
		//recupera o produto que foi cadastrado 
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		Produto produtoRecuperado = produtoDAO.buscarPorId(1l);
		
		ClienteDAO clienteDAO = new ClienteDAO(em);
		Cliente clienteRecuperado = clienteDAO.buscarPorId(1l);
				

		
		
		em.getTransaction().begin(); 
		
//		Cliente cliente;
		//atribui o produto recuperado a um cliente e monta um pedido para tal 
		Pedido pedido = new Pedido(clienteRecuperado);
		pedido.adicionarItem(new ItemPedido(10, pedido, produtoRecuperado));
		
		
		PedidoDAO pedidoDao = new PedidoDAO(em);
		pedidoDao.cadastrar(pedido);
		
		
		em.getTransaction().commit	(); 
	}

	private static void popularBancoDados() {
		Categoria celulares = new Categoria("CELULARES");
		Produto celular = new Produto("TABLET", "Versão A30 128GB", new BigDecimal("1500"), celulares);
		Cliente cliente = new Cliente("Mauricio", "233412");

		EntityManager em = JPAUtil.getEntityManager();

		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		CategoriaDAO categoriaDAO = new CategoriaDAO(em);
		ClienteDAO clienteDAO = new ClienteDAO(em);
		
		
		em.getTransaction().begin(); 
		
		categoriaDAO.cadastrar(celulares);
		produtoDAO.cadastrar(celular);
		clienteDAO.cadastrar(cliente);
		
		em.getTransaction().commit();
		
		em.close();
	}

}
