package br.com.fiap.opencode.controller;


import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

@RestController
public class CodigoController {

	Logger log = LoggerFactory.getLogger(CodigoController.class);
	private List<Codigo> codigos = new ArrayList<>();

	@GetMapping("/api/codigo")
	public List<Codigo> index() {
		return codigos;
	}

	@PostMapping("/api/codigo")
	public ResponseEntity<Codigo> create(@RequestBody Codigo codigo) {
		log.info("cadastrando codigo: " + codigo);
		codigo.setId(codigos.size() + 1l);
		codigos.add(codigo);
		return ResponseEntity.status(HttpStatus.CREATED).body(codigo);
	}

	@GetMapping("api/codigo/{id}")
	public ResponseEntity<Codigo> show(@PathVariable Long id) {
		log.info("Buscar codigo " + id);
		var codigoEncontrada = codigos.stream().filter(d -> d.getId().equals(id)).findFirst();
		if (codigoEncontrada.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok(codigoEncontrada.get());
	}

	@DeleteMapping("/api/codigo/{id}")
	public ResponseEntity<Codigo> delete(@PathVariable Long id) {
		var codigoEncontrada = codigos.stream().filter(d -> d.getId().equals(id)).findFirst();
		if (codigoEncontrada.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		codigos.remove(codigoEncontrada.get());
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/api/codigo/{id}")
	public ResponseEntity<Codigo> update(@PathVariable Long id, @RequestBody Codigo codigo) {
		var codigoEncontrada = codigos.stream().filter(d -> d.getId().equals(id)).findFirst();
		if (codigoEncontrada.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		codigos.remove(codigoEncontrada.get());
		codigo.setId(id);
		codigos.add(codigo);
		return ResponseEntity.ok(codigo);
	}
}