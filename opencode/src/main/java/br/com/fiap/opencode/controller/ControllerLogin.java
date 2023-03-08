package br.com.fiap.opencode.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.opencode.model.LoginUsuario;

@RestController
public class ControllerLogin {
    @GetMapping("/api/login")
    public LoginUsuario show(){
        return new LoginUsuario("emailexemplo@gmail.com", "123456");
    }

}
