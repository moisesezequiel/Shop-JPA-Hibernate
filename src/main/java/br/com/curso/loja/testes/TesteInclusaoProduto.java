package br.com.curso.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.curso.loja.modelo.Produto;

public class TesteInclusaoProduto {

	public static void main(String[] args) {

		Produto celular = new Produto();
		celular.setNome("Sansung");
		celular.setDescricao("Versão A30 128GB");
		celular.setPreco(new BigDecimal("1500"));
		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("loja");
		//cria um factory pegando o valor declarado dentro do XML
		
		EntityManager em = factory.createEntityManager();
		//Cria uma Entity pegando as configurações do factory

		
		em.getTransaction().begin(); //inicia a transação
		
		em.persist(celular);   //persiste(adiciona ) objeto que foi criado no banco de dados
		em.getTransaction().commit();
		
		em.close(); //fecha a Transação
		
		
		
	}

}
