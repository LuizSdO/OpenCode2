package br.com.fiap.opencode.repository;

import br.com.fiap.opencode.model.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {

}
