package br.com.fiap.opencode.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name ="Portfolio")
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idUsuario;
    private String portfolio;
    private String nomePortfolio;


    public Portfolio(Long id, Long idUsuario, String portfolio, String nomePortfolio) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.portfolio = portfolio;
        this.nomePortfolio = nomePortfolio;
    }

    public Portfolio() {
    }

    public String getNomePortfolio() {
        return nomePortfolio;
    }

    public void setNomePortfolio(String nomePortfolio) {
        this.nomePortfolio = nomePortfolio;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getPortfolio() {
        return portfolio;
    }
    public void setPortfolio(String portfolio) {
        this.portfolio = portfolio;
    }

    @Override
    public String toString() {
        return "Portfolio [id=" + id + ", idUsuario=" + idUsuario + ", portfolio=" + portfolio + ", nomePortfolio=" + nomePortfolio +"]";
    }

    public void add(Portfolio portfolio) {
    }
}
