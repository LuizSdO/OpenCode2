package br.com.fiap.opencode.controller;

import br.com.fiap.opencode.model.Usuario;
import br.com.fiap.opencode.repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public class UsuarioController {
    Logger log = LoggerFactory.getLogger(UsuarioController.class);
    @Autowired
    UsuarioRepository repository;

    @GetMapping("/api/usuario")
    public List<Usuario> index() {
        return repository.findAll();
    }

    @PostMapping("/api/usuario")
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) {
        log.info("cadastrando usuario: " + usuario);
        repository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @GetMapping("api/usuario/{id}")
    public ResponseEntity<Usuario> show(@PathVariable Long id) {
        log.info("Buscar usuario " + id);
        var usuarioEncontrada = repository.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario não Encontrado"));
        return ResponseEntity.ok(usuarioEncontrada);
    }

    @DeleteMapping("/api/usuario/{id}")
    public ResponseEntity<Usuario> delete(@PathVariable Long id) {
        var usuarioEncontrada = repository.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario não Encontrado"));
        repository.delete(usuarioEncontrada);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/api/usuario/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario usuario) {
        var usuarioEncontrada = repository.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario não Encontrado"));
        usuario.setId(id);
        repository.save(usuarioEncontrada);
        return ResponseEntity.ok(usuario);
    }
}
