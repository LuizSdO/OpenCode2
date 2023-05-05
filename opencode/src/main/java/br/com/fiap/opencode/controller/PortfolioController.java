package br.com.fiap.opencode.controller;

import br.com.fiap.opencode.model.Codigo;
import br.com.fiap.opencode.model.Portfolio;
import br.com.fiap.opencode.repository.PortfolioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;

import java.util.ArrayList;
import java.util.List;
@RestController
public class PortfolioController {
        Logger log = LoggerFactory.getLogger(br.com.fiap.opencode.controller.PortfolioController.class);
        @Autowired
        PortfolioRepository repository;
        @Autowired
        PagedResourcesAssembler<Object> assembler;

        @GetMapping("/api/portfolio")
        public PagedModel<EntityModel<Object>> index(@RequestParam(required = false) String busca, @PageableDefault(size = 5) Pageable pageable){
            Page<Portfolio> portfolios = repository.findAll(pageable);
            return assembler.toModel(portfolios.map(Portfolio::toEntityModel));
        }

    @PostMapping("/api/portfolio")
    public ResponseEntity<Portfolio> create(@RequestBody Portfolio portfolio) {
        log.info("cadastrando portfolio: " + portfolio);
        repository.save(portfolio);
        portfolio.setUsuario(repository.findById(portfolio.getUsuario().getId()).get().getUsuario());
        return ResponseEntity
                .created(portfolio.toEntityModel().getRequiredLink("self").toUri())
                .body(portfolio.toEntityModel().getContent());
    }

    @GetMapping("api/portfolio/{id}")
    public EntityModel<Portfolio> show(@PathVariable Long id) {
        log.info("Buscar portfolio " + id);
        var portfolio = repository.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Portfolio não Encontrado"));
        return portfolio.toEntityModel();
    }

    @DeleteMapping("/api/portfolio/{id}")
    public ResponseEntity<Portfolio> delete(@PathVariable Long id) {
        var portfolioEncontrada = repository.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Portfolio não Encontrado"));
        repository.delete(portfolioEncontrada);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/api/portfolio/{id}")
    public EntityModel<Portfolio> update(@PathVariable Long id, @RequestBody Portfolio portfolio) {
        var portfolioEncontrada = repository.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Portfolio não Encontrado"));
        portfolio.setId(id);
        repository.save(portfolioEncontrada);
        return portfolio.toEntityModel();
    }

    }
