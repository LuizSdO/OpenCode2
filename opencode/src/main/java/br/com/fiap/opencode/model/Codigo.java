package br.com.fiap.opencode.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity

@Data
@NoArgsConstructor

public class Codigo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;

    @ManyToOne
    private Usuario usuario;

    public Codigo(String codigo, Usuario usuario) {
        this.codigo = codigo;
        this.usuario = usuario;
    }
}
