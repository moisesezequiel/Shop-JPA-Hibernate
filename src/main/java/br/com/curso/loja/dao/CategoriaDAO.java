package br.com.curso.loja.dao;

import javax.persistence.EntityManager;

import br.com.curso.loja.modelo.Categoria;

public class CategoriaDAO {

	private EntityManager em;

	public CategoriaDAO(EntityManager em) {
		this.em = em;
	}


	public void cadastrar(Categoria categoria) {
		this.em.persist(categoria);
	}
	public void atualizar(Categoria categoria) {
		this.em.merge(categoria); //metodo merge serve para voltar a entidade de detached para managed 
	}
	public void deletar(Categoria categoria) {
		categoria = em.merge(categoria);
		this.em.remove(categoria); // trata a entidade voltando ela pra managed e depois deleta 
	}
}
