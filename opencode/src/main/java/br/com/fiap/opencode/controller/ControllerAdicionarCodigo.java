package br.com.fiap.opencode.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.opencode.model.AdicionarCodigo;

@RestController
public class ControllerAdicionarCodigo {
    @GetMapping("/api/addCodigo")
    public AdicionarCodigo show(){
        return new AdicionarCodigo(001, "arquivoCodigo.py");
    }
}
