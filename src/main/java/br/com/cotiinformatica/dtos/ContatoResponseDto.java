package br.com.cotiinformatica.dtos;

import lombok.Data;

@Data
public class ContatoResponseDto {

	Integer id;
	String nome;
	String email;
	String telefone;
}
