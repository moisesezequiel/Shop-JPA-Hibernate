package br.com.curso.loja.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity // classe produto irá mapear uma tabela no banco de dados
@Table(name = "produtos") // setando o nome semelhante ao da tabela
@NamedQuery(name ="Produto.produtosPorCategoria",query = "SELECT p from Produto p  WHERE p.categoria.nome = :nome") //exemplo de namedQuery
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Id declara o PK do banco e Generated define o tipo de auto // increment se houver
	private Long id;
	private String nome;
	private String descricao; // @Column(name = "desc") exemplo se o nome da variavel for diferente do banco
								// de dados
	private BigDecimal preco;
	private LocalDate dataCadastro = LocalDate.now();

	@ManyToOne
	private Categoria categoria;

	public Produto() {
	}

	public Produto(String nome, String descricao, BigDecimal preco, Categoria categoria) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

}
