package br.com.curso.loja.modelo;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public enum Categoria {

	CELULARES,
	INFORMATICA,
	LIVROS;

}
//Enum por default o Hibernate cria a coluna como numerico e salva a posição de cada palavra (0,1,2...)
//necessario no Model declarar o 	@Enumerated(EnumType.STRING) para salvar sim a palavra como coluna 
