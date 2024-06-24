package br.com.cotiinformatica.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.dtos.ContatoRequestDto;
import br.com.cotiinformatica.dtos.ContatoResponseDto;
import br.com.cotiinformatica.entities.Contato;
import br.com.cotiinformatica.repositories.ContatoRepository;

@RestController
@RequestMapping("/api/contatos")
public class ContatoController {

	@PostMapping("criar")
	public ContatoResponseDto post(@RequestBody ContatoRequestDto dto) throws Exception {

		Contato contato = new Contato();
		contato.setNome(dto.getNome());
		contato.setEmail(dto.getEmail());
		contato.setTelefone(dto.getTelefone());

		ContatoRepository contatoRepository = new ContatoRepository();
		contatoRepository.insert(contato);

		ContatoResponseDto response = new ContatoResponseDto();
		response.setId(contato.getIdContato());
		response.setNome(contato.getNome());
		response.setEmail(contato.getEmail());
		response.setTelefone(contato.getTelefone());

		return response;
	}
}
