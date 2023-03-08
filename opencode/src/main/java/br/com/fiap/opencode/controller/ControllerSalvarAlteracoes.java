package br.com.fiap.opencode.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.opencode.model.SalvarAlteracoes;

@RestController
public class ControllerSalvarAlteracoes {
    @GetMapping("/api/SalvarAlteracoes")
    public SalvarAlteracoes show(){
        return new SalvarAlteracoes(1002, "codigoexemplo", 4008);
    }
}
