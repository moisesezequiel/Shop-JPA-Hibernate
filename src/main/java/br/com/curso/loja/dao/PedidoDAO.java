package br.com.curso.loja.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.curso.loja.modelo.Pedido;

public class PedidoDAO {

	private EntityManager em;

	public PedidoDAO(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Pedido pedido) {
		this.em.persist(pedido);
	}

	public BigDecimal valorTotalVendido() {
		String jpql = "SELECT SUM(p.valorTotal) FROM Pedido p "; //valor total do metodo Sum(soma) da tabela de pedidos
		return em.createQuery(jpql, BigDecimal.class).getSingleResult();
	}
	
	public List<Object[]> relatorioDeVendas(){
		String jpql = " SELECT produto.nome, SUM(item.quantidade), MAX(pedido.data) FROM Pedido pedido JOIN pedido.itens item JOIN item.produto produto GROUP BY  produto.nome ORDER BY item.quantidade DESC";
				return em.createQuery(jpql, Object[].class).getResultList();
	}
	
}
