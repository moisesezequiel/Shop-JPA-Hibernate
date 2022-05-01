package br.com.curso.loja.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.curso.loja.modelo.Pedido;
import br.com.curso.loja.vo.RelatorioVendasVO;

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
	//Opcional criar um VO ou criar um array de object 
	public List<RelatorioVendasVO> relatorioDeVendas(){
		String jpql = " SELECT new  br.com.curso.loja.vo.RelatorioVendasVO(produto.nome,SUM(item.quantidade),MAX(pedido.data))  "  //select new cria uma instancia da classe desejada e ja pega os valores do retorno no  construtor 
				+ "FROM Pedido pedido 	"																	//MAx = traz os dados mais recentes 
				+ "JOIN pedido.itens item "
				+ "JOIN item.produto produto "
				+ "GROUP BY  produto.nome "
				+ "ORDER BY item.quantidade DESC";
				return em.createQuery(jpql, RelatorioVendasVO.class).getResultList();
	}
	
}
