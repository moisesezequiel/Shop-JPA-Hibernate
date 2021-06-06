package br.com.curso.loja.dao;

import java.util.List;

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
	public Produto buscarPorId(Long id) {
		return em.find(Produto.class, id);
	}
	
	public List<Produto> buscarTodos() {
		
		String jpql = "SELECT p from Produto p ";
		
		return em.createQuery(jpql, Produto.class).getResultList();
		
	}
	//buscar Todos , cria um select só que em linguagem Jpql
	//create query apenas monta a query o que dispara-a e pega o resultado é  getResultList
}
