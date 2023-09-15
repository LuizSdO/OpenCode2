package br.com.fiap.opencode.controller;


import java.util.List;

import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import br.com.fiap.opencode.model.Codigo;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/codigo")
@SecurityRequirement(name = "bearer-key")
@Tag(name = "Codigo", description = "Código do usuário")


public class CodigoController {

	Logger log = LoggerFactory.getLogger(CodigoController.class);
	@Autowired
	CodigoRepository repository;

	@Autowired
	PagedResourcesAssembler<Object> assembler;

	@GetMapping
	@Operation(
			summary = "Listar codigos",
			description = "Retorna todos os codigos"
	)
	public PagedModel<EntityModel<Object>> index(@RequestParam(required = false) String busca, @PageableDefault(size = 5) Pageable pageable){
		Page<Codigo> codigos = repository.findAll(pageable);
		log.info("Buscando contas no BD");
		return assembler.toModel(codigos.map(Codigo::toEntityModel));
	}


	@PostMapping("/api/codigo")

	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Acesso ao codigo com sucesso"),
			@ApiResponse(responseCode = "400", description = "Erro ao acessar o codigo do portfolio")
	}
	)
	public ResponseEntity<Codigo> create(@RequestBody @Valid @ParameterObject Codigo codigo) {
		log.info("postando codigo " + codigo);
		repository.save(codigo);
		return ResponseEntity.status(HttpStatus.CREATED).body(codigo);
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