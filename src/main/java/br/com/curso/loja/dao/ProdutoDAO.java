package br.com.curso.loja.dao;

import javax.persistence.EntityManager;

import br.com.curso.loja.modelo.Produto;

public class ProdutoDAO {

	private EntityManager em;

	public ProdutoDAO(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Produto produto) {
		this.em.persist(produto);
	}
	public void deletar(Produto produto) {
		produto = em.merge(produto);
		this.em.remove(produto);
	}

}
