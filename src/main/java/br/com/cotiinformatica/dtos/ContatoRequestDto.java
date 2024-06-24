package br.com.cotiinformatica.dtos;

import lombok.Data;

@Data
public class ContatoRequestDto {

	String nome;
	String email;
	String telefone;
}
