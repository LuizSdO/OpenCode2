package br.com.fiap.opencode.model;

import br.com.fiap.opencode.controller.CodigoController;
import br.com.fiap.opencode.controller.UsuarioController;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.metamodel.mapping.EntityValuedModelPart;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import br.com.fiap.opencode.controller.CodigoController;
import br.com.fiap.opencode.controller.PortfolioController;

@Entity
@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor

public class Codigo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    private String codigo;
    @JsonProperty(access = Access.WRITE_ONLY)
    @Min(value=0, message = "O codigo não pode estar em branco")
    @ManyToOne
    private Usuario usuario;

    public Codigo(String codigo, Usuario usuario) {
        this.codigo = codigo;
        this.usuario = usuario;
    }

    public EntityModel<Codigo> toEntityModel() {
        return EntityModel.of(
                this,
                linkTo(methodOn(CodigoController.class).show(id)).withSelfRel(),
                linkTo(methodOn(CodigoController.class).delete(id)).withRel("delete"),
                linkTo(methodOn(CodigoController.class).index(null, Pageable.unpaged())).withRel("all")

        );
    }
}
