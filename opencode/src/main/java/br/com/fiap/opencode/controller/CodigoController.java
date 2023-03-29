package br.com.fiap.opencode.controller;


import java.util.ArrayList;
import java.util.List;

import br.com.fiap.opencode.repository.CodigoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.opencode.model.Codigo;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class CodigoController {

	Logger log = LoggerFactory.getLogger(CodigoController.class);
	@Autowired
	CodigoRepository repository;

	@GetMapping("/api/codigo")
	public List<Codigo> index() {
		return repository.findAll();
	}

	@PostMapping("/api/codigo")
	public ResponseEntity<Codigo> create(@RequestBody Codigo codigo) {
		log.info("cadastrando codigo: " + codigo);
		repository.save(codigo);
		return ResponseEntity.status(HttpStatus.CREATED).body(codigo);
	}

	@GetMapping("api/codigo/{id}")
	public ResponseEntity<Codigo> show(@PathVariable Long id) {
		log.info("Buscar codigo " + id);
		var codigoEncontrada = repository.findById(id)
				.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Código não Encontrado"));
		return ResponseEntity.ok(codigoEncontrada);
	}

	@DeleteMapping("/api/codigo/{id}")
	public ResponseEntity<Codigo> delete(@PathVariable Long id) {
		var codigoEncontrada = repository.findById(id)
				.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Código não Encontrado"));
		repository.delete(codigoEncontrada);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/api/codigo/{id}")
	public ResponseEntity<Codigo> update(@PathVariable Long id, @RequestBody Codigo codigo) {
		var codigoEncontrada = repository.findById(id)
				.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Código não Encontrado"));
		codigo.setId(id);
		repository.save(codigoEncontrada);
		return ResponseEntity.ok(codigo);
	}
}