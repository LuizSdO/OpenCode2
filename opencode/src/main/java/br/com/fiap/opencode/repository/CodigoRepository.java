package br.com.fiap.opencode.repository;

import br.com.fiap.opencode.model.Codigo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodigoRepository extends JpaRepository<Codigo, Long> {
}
