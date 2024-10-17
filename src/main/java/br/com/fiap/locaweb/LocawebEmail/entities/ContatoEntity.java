package br.com.fiap.locaweb.LocawebEmail.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "CONTATO")
public class ContatoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contato_seq")
    @SequenceGenerator(name = "contato_seq", sequenceName = "contato_seq", allocationSize = 1)
    @Column(name = "ID_CONTATO", nullable = false, length = 10)
    private Long id;

    @Column(name = "NOME", nullable = false, length = 100)
    private String nome;

    @Column(name = "EMAIL", nullable = false, unique = true, length = 100)
    private String email;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    private UsuarioEntity usuario;

}
