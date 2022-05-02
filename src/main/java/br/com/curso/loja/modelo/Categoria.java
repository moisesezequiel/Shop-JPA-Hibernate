package br.com.curso.loja.modelo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categoria {


	@EmbeddedId
	private CategoriaID id ;

	public Categoria() {

	}

	public Categoria(String nome) {
		this.id = new CategoriaID(nome , "xpto");
	}

	public String getNome() {
		return this.id.getNome();
	}

	public void setNome(String nome) {
		this.id.setNome(nome);
	}

}
//Enum por default o Hibernate cria a coluna como numerico e salva a posição de cada palavra (0,1,2...)
//necessario no Model declarar o 	@Enumerated(EnumType.STRING) para salvar sim a palavra como coluna 
