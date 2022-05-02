package br.com.curso.loja.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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
	
	
	public List<Produto> buscarPorNome(String nome ) {
		
		String jpql = "SELECT p from Produto p  WHERE p.nome = :nome";
		
		return em.createQuery(jpql, Produto.class)
				.setParameter("nome", nome)
				.getResultList();
		
		// os : dentro da query devera ser o valor do atributo 
		//ou declarar com ? 
		//no metodo setparameter voce declara qual valor será atribuido ao parametro 
		
	}
	
	
	public List<Produto> buscarPorNomeCategoria(String nome) {
		return em.createNamedQuery("Produto.produtosPorCategoria", Produto.class)
				.setParameter(1, nome)
				.getResultList();
	}
	
	//filtra por categoria, so declarar a Orientação ao OBJ que o JPA ja se encarrega de fazer o
	//join na tabela 
	
	public BigDecimal buscarPrecoDoProdutocomNome(String nome ) {
		
		String jpql = "SELECT p.preco from Produto p  WHERE p.nome = :nome";
		
		return em.createQuery(jpql, BigDecimal.class)
				.setParameter("nome", nome)
				.getSingleResult();
		
		//trazendo apenas o preco da entidade e usando getSingleResult para trazer um unico resultado 
	
	}
	
	public List<Produto>buscarPorParametros(String nome, BigDecimal preco, LocalDate dataCadastro){
		String jpql = "SELECT p FROM Produto p WHERE 1=1";
		if (nome !=null && !nome.trim().isEmpty()) {
			 jpql= "AND p.nome = :nome";
		}
		if (preco !=null) {
			jpql= "AND p.preco = :preco";
		}
		if (dataCadastro !=null) {
			jpql= "WHERE p.dataCadastro = :dataCadastro";
		}
		
		TypedQuery<Produto> query = em.createQuery(jpql,Produto.class);
		
		if (nome !=null && !nome.trim().isEmpty()) {
			query.setParameter("nome", query);
		}	
		if (preco !=null) {
			query.setParameter("preco", query);
		}
		if (dataCadastro !=null) {
			query.setParameter("dataCadastro", query);
		}
		
		return query.getResultList();
	}
	
}
