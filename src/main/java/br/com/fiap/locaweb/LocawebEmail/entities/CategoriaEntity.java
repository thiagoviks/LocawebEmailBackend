package br.com.fiap.locaweb.LocawebEmail.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "CATEGORIA")
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categoria_seq")
    @SequenceGenerator(name = "categoria_seq", sequenceName = "categoria_seq", allocationSize = 1)
    @Column(name = "ID_CATEGORIA", nullable = false, length = 10)
    private Long id;

    @Column(name = "NOME", nullable = false, length = 100)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    private UsuarioEntity usuario;

    @ManyToMany
    @JoinTable(
            name = "EVENTO_CATEGORIA",
            joinColumns = @JoinColumn(name = "ID_CATEGORIA"),
            inverseJoinColumns = @JoinColumn(name = "ID_EVENTO")
    )
    private Set<EventoEntity> eventos;

}
