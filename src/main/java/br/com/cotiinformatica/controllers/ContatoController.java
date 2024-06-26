package br.com.cotiinformatica.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	ContatoRepository contatoRepository;
	
	@PostMapping
	public ContatoResponseDto post(@RequestBody ContatoRequestDto dto) throws Exception {

		Contato contato = modelMapper.map(dto, Contato.class);
		contatoRepository.insert(contato);
		return modelMapper.map(contato, ContatoResponseDto.class);
	}
}
