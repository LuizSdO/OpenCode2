package br.com.fiap.opencode.controller;


import java.util.List;

import br.com.fiap.opencode.model.Usuario;
import br.com.fiap.opencode.repository.CodigoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;

import br.com.fiap.opencode.model.Codigo;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class CodigoController {

	Logger log = LoggerFactory.getLogger(CodigoController.class);
	@Autowired
	CodigoRepository repository;

	@Autowired
	PagedResourcesAssembler<Object> assembler;

	@GetMapping("/api/codigo")
	public PagedModel<EntityModel<Object>> index(@RequestParam(required = false) String busca, @PageableDefault(size = 5) Pageable pageable){
		Page<Codigo> codigos = repository.findAll(pageable);
		return assembler.toModel(codigos.map(Codigo::toEntityModel));
	}


	@PostMapping("/api/codigo")
	public ResponseEntity<Codigo> create(@RequestBody Codigo codigo) {
		log.info("cadastrando codigo: " + codigo);
		repository.save(codigo);
		codigo.setUsuario(repository.findById(codigo.getUsuario().getId()).get().getUsuario());
		return ResponseEntity
				.created(codigo.toEntityModel().getRequiredLink("self").toUri())
				.body(codigo.toEntityModel().getContent());
	}

	@GetMapping("api/codigo/{id}")
	public EntityModel<Codigo> show(@PathVariable Long id) {
		log.info("Buscar codigo " + id);
		var codigo = repository.findById(id)
				.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Código não Encontrado"));
		return codigo.toEntityModel();
	}

	@DeleteMapping("/api/codigo/{id}")
	public ResponseEntity<Codigo> delete(@PathVariable Long id) {
		var codigoEncontrada = repository.findById(id)
				.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Código não Encontrado"));
		repository.delete(codigoEncontrada);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/api/codigo/{id}")
	public EntityModel<Codigo> update(@PathVariable Long id, @RequestBody Codigo codigo) {
		var codigoEncontrada = repository.findById(id)
				.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Código não Encontrado"));
		codigo.setId(id);
		repository.save(codigoEncontrada);
		return codigo.toEntityModel();
	}
}