package br.com.fiap.opencode.config;

import br.com.fiap.opencode.model.Usuario;
import br.com.fiap.opencode.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DatabaseSeeder implements CommandLineRunner {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public void run(String... args) throws Exception {
        usuarioRepository.saveAll(List.of(
                new Usuario(1L, "Bernardo", "bernardo123", "bernardo@gmail.com"),
                new Usuario(2L, "Flavio", "flavi012", "flavio@gmail.com"),
                new Usuario(3L, "Larissa", "lari24", "lari@gmail.com")
        ));
    }
}
