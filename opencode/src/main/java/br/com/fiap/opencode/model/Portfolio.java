package br.com.fiap.opencode.model;

import br.com.fiap.opencode.controller.UsuarioController;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import br.com.fiap.opencode.controller.PortfolioController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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

    public EntityModel<Portfolio> toEntityModel() {
        return EntityModel.of(
                this,
                linkTo(methodOn(PortfolioController.class).show(id)).withSelfRel(),
                linkTo(methodOn(PortfolioController.class).delete(id)).withRel("delete"),
                linkTo(methodOn(PortfolioController.class).index(null, Pageable.unpaged())).withRel("all")

        );
    }
}
