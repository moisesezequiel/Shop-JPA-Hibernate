package br.com.curso.loja.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;

	public Categoria() {

	}

	public Categoria(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
//Enum por default o Hibernate cria a coluna como numerico e salva a posição de cada palavra (0,1,2...)
//necessario no Model declarar o 	@Enumerated(EnumType.STRING) para salvar sim a palavra como coluna 
