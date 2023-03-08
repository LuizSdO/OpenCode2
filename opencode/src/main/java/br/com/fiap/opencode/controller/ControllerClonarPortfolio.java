package br.com.fiap.opencode.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.opencode.model.ClonarPortfolio;

@RestController
public class ControllerClonarPortfolio {
    @GetMapping("/api/ClonarPortfolio")
    public ClonarPortfolio show(){
        return new ClonarPortfolio(001, 4005);
    }
}
