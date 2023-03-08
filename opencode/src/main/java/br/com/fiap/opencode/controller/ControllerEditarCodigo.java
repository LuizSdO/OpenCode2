package br.com.fiap.opencode.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.opencode.model.EditarCodigo;

@RestController
public class ControllerEditarCodigo {
    @GetMapping("/api/editarCodigo")
    public EditarCodigo show(){
        return new EditarCodigo(4000, "codigo01");
    }
    
}
