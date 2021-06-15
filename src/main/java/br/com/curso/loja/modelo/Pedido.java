package br.com.curso.loja.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "valor_total")
	private BigDecimal valorTotal;
	
	private LocalDate data = LocalDate.now();

	@ManyToOne
	private Cliente cliente;
	                                                            //cascade é para dizer que tudo que fizer com um pedido faça tbm com o item pedido  
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL) //adiconar no toMany o mappedBy para a JPA mapear dos 2 lados o mesmo relacionamento 
	private List<ItemPedido> itens = new ArrayList<>();

	public Pedido() {
		
	}
	
	public void adicionarItem(ItemPedido item) {//metodo para adicionar um item a lista 
		item.setPedido(this);
		this.itens.add(item); 
	}

	public Pedido(Cliente cliente) {
		this.cliente = cliente;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
