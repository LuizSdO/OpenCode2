package br.com.fiap.opencode.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.opencode.model.AcessarCodigo;

@RestController
public class ContollerAcessarCodigo {
    @GetMapping ("/api/AcessarCodigo")
    public AcessarCodigo show(){
        return new AcessarCodigo(123, 2233);
}
}