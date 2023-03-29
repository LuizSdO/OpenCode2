package br.com.fiap.opencode.controller;

import br.com.fiap.opencode.model.Portfolio;
import br.com.fiap.opencode.repository.PortfolioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
@RestController
public class PortfolioController {
        Logger log = LoggerFactory.getLogger(br.com.fiap.opencode.controller.PortfolioController.class);
        @Autowired
        PortfolioRepository repository;

        @GetMapping("/api/portfolio")
        public List<Portfolio> index() {
            return repository.findAll();
        }

    @PostMapping("/api/portfolio")
    public ResponseEntity<Portfolio> create(@RequestBody Portfolio portfolio) {
        log.info("cadastrando portfolio: " + portfolio);
        repository.save(portfolio);
        return ResponseEntity.status(HttpStatus.CREATED).body(portfolio);
    }

    @GetMapping("api/portfolio/{id}")
    public ResponseEntity<Portfolio> show(@PathVariable Long id) {
        log.info("Buscar portfolio " + id);
        var portfolioEncontrada = repository.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Portfolio não Encontrado"));
        return ResponseEntity.ok(portfolioEncontrada);
    }

    @DeleteMapping("/api/portfolio/{id}")
    public ResponseEntity<Portfolio> delete(@PathVariable Long id) {
        var portfolioEncontrada = repository.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Portfolio não Encontrado"));
        repository.delete(portfolioEncontrada);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/api/portfolio/{id}")
    public ResponseEntity<Portfolio> update(@PathVariable Long id, @RequestBody Portfolio portfolio) {
        var portfolioEncontrada = repository.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Portfolio não Encontrado"));
        portfolio.setId(id);
        repository.save(portfolioEncontrada);
        return ResponseEntity.ok(portfolio);
    }

    }
