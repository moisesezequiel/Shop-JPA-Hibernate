package br.com.curso.loja.modelo;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // classe produto irá mapear uma tabela no banco de dados
@Table(name = "produtos") // setando o nome semelhante ao da tabela
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Id declara o PK do banco e Generated define o tipo de auto increment se houver
	private Long id;
	private String nome;
	private String descricao; // @Column(name = "desc") exemplo se o nome da variavel for diferente do banco de dados
	private BigDecimal preco;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
