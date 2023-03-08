package br.com.fiap.opencode.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.opencode.model.CadastroUsuario;

@RestController
public class ControllerCadastroUsusario {
    @GetMapping("/api/cadastrousuario")
    public CadastroUsuario show(){
        return new CadastroUsuario("emailexemplo@gmail.com", "123456", "João Carlos");
    }

}
