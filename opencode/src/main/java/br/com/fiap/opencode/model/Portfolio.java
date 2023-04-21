package br.com.fiap.opencode.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity(name ="Portfolio")
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String portfolio;
    private String nomePortfolio;

    @ManyToOne
    private Usuario usuario;


    public Portfolio(String portfolio, String nomePortfolio) {
        this.portfolio = portfolio;
        this.nomePortfolio = nomePortfolio;
    }
}
