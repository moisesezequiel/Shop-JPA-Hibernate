package br.com.curso.loja.dao;

import java.math.BigDecimal;

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
	
}
