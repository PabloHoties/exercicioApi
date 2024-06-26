package br.com.cotiinformatica.dtos;

import lombok.Data;

@Data
public class ContatoResponseDto {

	Integer idContato;
	String nome;
	String email;
	String telefone;
}
