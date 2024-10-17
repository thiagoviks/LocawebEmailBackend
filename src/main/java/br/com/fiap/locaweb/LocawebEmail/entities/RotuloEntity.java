package br.com.fiap.locaweb.LocawebEmail.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "ROTULO")
public class RotuloEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rotulo_seq")
    @SequenceGenerator(name = "rotulo_seq", sequenceName = "rotulo_seq", allocationSize = 1)
    @Column(name = "ID_ROTULO", nullable = false, length = 10)
    private Long id;

    @Column(name = "NOME", nullable = false, length = 100)
    private String nome;

    @Column(name = "COR", length = 20)
    private String cor;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    private UsuarioEntity usuario;

    @ManyToMany
    @JoinTable(
            name = "EVENTO_ROTULO",
            joinColumns = @JoinColumn(name = "ID_ROTULO"),
            inverseJoinColumns = @JoinColumn(name = "ID_EVENTO")
    )
    private Set<EventoEntity> eventos;

}
