package br.com.cotiinformatica.entities;

import lombok.Data;

@Data
public class Contato {

	Integer idContato;
	String nome;
	String email;
	String telefone;
}
