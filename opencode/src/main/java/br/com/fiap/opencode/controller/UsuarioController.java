package br.com.fiap.opencode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springdoc.core.annotations.ParameterObject;
import br.com.fiap.opencode.model.Credencial;
import br.com.fiap.opencode.model.Token;
import br.com.fiap.opencode.model.Usuario;
import br.com.fiap.opencode.repository.UsuarioRepository;
import br.com.fiap.opencode.service.TokenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
public class UsuarioController {

    @Autowired
    UsuarioRepository repository;

    @Autowired
    AuthenticationManager manager;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    TokenService tokenService;

    @PostMapping("/api/registrar")
    @Operation(
            summary = "Registrar usuario",
            description = "Registra um novo usuario"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "O usuario foi cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro ao cadastrar usuario")
    }
    )
    public ResponseEntity<Usuario> registrar(@RequestBody @Valid Usuario usuario){
        usuario.setSenha(encoder.encode(usuario.getSenha()));
        repository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @PostMapping("/api/login")
    public ResponseEntity<Token> login(@RequestBody Credencial credencial){
        manager.authenticate(credencial.toAuthentication());
        var token = tokenService.generateToken(credencial);
        return ResponseEntity.ok(token);
    }

}
