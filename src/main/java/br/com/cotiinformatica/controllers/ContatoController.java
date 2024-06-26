package br.com.cotiinformatica.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public ContatoResponseDto post(@RequestBody ContatoRequestDto request) throws Exception {

		Contato contato = modelMapper.map(request, Contato.class);
		contatoRepository.insert(contato);
		return modelMapper.map(contato, ContatoResponseDto.class);
	}

	@PutMapping("{id}")
	public ContatoResponseDto put(@PathVariable Integer id, @RequestBody ContatoRequestDto request) throws Exception {

		Contato contato = modelMapper.map(request, Contato.class);
		contato.setIdContato(id);
		contatoRepository.update(contato);
		return modelMapper.map(contato, ContatoResponseDto.class);
	}

	@DeleteMapping("{id}")
	public ContatoResponseDto delete(@PathVariable Integer id) throws Exception {

		Contato contato = contatoRepository.findById(id);
		contatoRepository.delete(id);
		return modelMapper.map(contato, ContatoResponseDto.class);
	}

	@GetMapping("{id}")
	public ContatoResponseDto getById(@PathVariable Integer id) throws Exception {

		Contato contato = contatoRepository.findById(id);
		return modelMapper.map(contato, ContatoResponseDto.class);
	}

	@GetMapping
	public List<ContatoResponseDto> getAll() throws Exception {

		List<Contato> contatos = contatoRepository.findAll();
		return contatos.stream().map(contato -> modelMapper.map(contato, ContatoResponseDto.class))
				.collect(Collectors.toList());
	}
}
