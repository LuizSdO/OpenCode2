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

import br.com.fiap.opencode.model.PaginaInicial;

@RestController
public class ControllerPaginaInicial {

	Logger log = LoggerFactory.getLogger(ControllerPaginaInicial.class);
	private List<PaginaInicial> paginainicials = new ArrayList<>();

	@GetMapping("/api/paginainicial")
	public List<PaginaInicial> index() {
		return paginainicials;
	}

	@PostMapping("/api/paginainicial")
	public ResponseEntity<PaginaInicial> create(@RequestBody PaginaInicial paginainicial) {
		log.info("cadastrando paginainicial: " + paginainicial);
		paginainicial.setId(paginainicials.size() + 1l);
		paginainicials.add(paginainicial);
		return ResponseEntity.status(HttpStatus.CREATED).body(paginainicial);
	}

	@GetMapping("api/paginainicial/{id}")
	public ResponseEntity<PaginaInicial> show(@PathVariable Long id) {
		log.info("Buscar paginainicial " + id);
		var paginainicialEncontrada = paginainicials.stream().filter(d -> d.getId().equals(id)).findFirst();
		if (paginainicialEncontrada.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok(paginainicialEncontrada.get());
	}

	@DeleteMapping("/api/paginainicial/{id}")
	public ResponseEntity<PaginaInicial> delete(@PathVariable Long id) {
		var paginainicialEncontrada = paginainicials.stream().filter(d -> d.getId().equals(id)).findFirst();
		if (paginainicialEncontrada.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		paginainicials.remove(paginainicialEncontrada.get());
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/api/paginainicial/{id}")
	public ResponseEntity<PaginaInicial> update(@PathVariable Long id, @RequestBody PaginaInicial paginainicial) {
		var paginainicialEncontrada = paginainicials.stream().filter(d -> d.getId().equals(id)).findFirst();
		if (paginainicialEncontrada.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		paginainicials.remove(paginainicialEncontrada.get());
		paginainicial.setId(id);
		paginainicials.add(paginainicial);
		return ResponseEntity.ok(paginainicial);
	}
}