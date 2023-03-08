package br.com.fiap.opencode.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.opencode.model.ExcluirCodigo;

@RestController
public class ControllerExcluirCodigo {
    @GetMapping("/api/excluirCodigo")
    public ExcluirCodigo show(){
        return new ExcluirCodigo(001, "senhaExemolo123", 010);
    }
}
