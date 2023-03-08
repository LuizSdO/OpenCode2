package br.com.fiap.opencode.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.opencode.model.PublicarPortfolio;

@RestController
public class ControllerPublicarPortfolio {
    @GetMapping("/api/publicarPortfolio")
    public PublicarPortfolio show(){
        return new PublicarPortfolio(001, "User201", 4002, "Projeto.jynb", "senhauser201");
    }
}
