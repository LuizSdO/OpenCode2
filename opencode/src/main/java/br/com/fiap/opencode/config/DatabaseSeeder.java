package br.com.fiap.opencode.config;

import br.com.fiap.opencode.model.Codigo;
import br.com.fiap.opencode.model.Portfolio;
import br.com.fiap.opencode.model.Usuario;
import br.com.fiap.opencode.repository.CodigoRepository;
import br.com.fiap.opencode.repository.PortfolioRepository;
import br.com.fiap.opencode.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DatabaseSeeder implements CommandLineRunner {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    CodigoRepository codigoRepository;

    @Autowired
    PortfolioRepository portfolioRepository;

    @Override
    public void run(String... args) throws Exception {
        Usuario u1 = new Usuario(1L, "Bernardo", "bernardo123", "bernardo@gmail.com");
        Usuario u2 = new Usuario(2L, "Flavio", "flavi012", "flavio@gmail.com");
        Usuario u3 = new Usuario(3L, "Larissa", "lari24", "lari@gmail.com");
        usuarioRepository.saveAll(List.of(u1, u2, u3));

        codigoRepository.saveAll(List.of(
                Codigo.builder().codigo("seu codigo java").usuario(u1).build(),
                Codigo.builder().codigo("seu codigo python").usuario(u1).build(),
                Codigo.builder().codigo("seu codigo html").usuario(u2).build(),
                Codigo.builder().codigo("seu codigo css").usuario(u2).build(),
                Codigo.builder().codigo("seu codigo React").usuario(u3).build(),
                Codigo.builder().codigo("seu codigo java").usuario(u3).build()
        ));

        portfolioRepository.saveAll(List.of(
                Portfolio.builder().portfolio("Meu portfolio java").usuario(u1).build(),
                Portfolio.builder().portfolio("Meu portfolio python").usuario(u1).build(),
                Portfolio.builder().portfolio("Meu portfolio html").usuario(u2).build(),
                Portfolio.builder().portfolio("Meu portfolio css").usuario(u2).build(),
                Portfolio.builder().portfolio("Meu portfolio react").usuario(u3).build(),
                Portfolio.builder().portfolio("Meu portfolio java").usuario(u3).build()
        ));

    }
}
