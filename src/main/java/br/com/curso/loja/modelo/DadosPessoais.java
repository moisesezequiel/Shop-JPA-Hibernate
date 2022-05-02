package br.com.curso.loja.modelo;

import javax.persistence.Embeddable;

@Embeddable
public class DadosPessoais {

	 //classe pode ser embutida dentro de uma entidade  
	private String nome;
	private String cpf;
	
	

	public DadosPessoais() {
	}

	public DadosPessoais(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

}
