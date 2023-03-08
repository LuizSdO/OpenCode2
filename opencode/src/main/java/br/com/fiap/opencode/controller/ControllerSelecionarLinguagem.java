package br.com.fiap.opencode.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.opencode.model.SelecionarLinguagem;

@RestController
public class ControllerSelecionarLinguagem {
    @GetMapping ("/api/NomeLinguagem")
    public SelecionarLinguagem show(){
        return new SelecionarLinguagem("python");
    }
}
