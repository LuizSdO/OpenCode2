package br.com.fiap.opencode.repository;

import br.com.fiap.opencode.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
