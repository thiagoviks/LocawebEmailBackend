package br.com.fiap.locaweb.LocawebEmail.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "PASTA")
public class PastaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pasta_seq")
    @SequenceGenerator(name = "pasta_seq", sequenceName = "pasta_seq", allocationSize = 1)
    @Column(name = "ID_PASTA", nullable = false, length = 10)
    private Long id;

    @Column(name = "NOME", nullable = false, length = 100)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    private UsuarioEntity usuario;

    @ManyToMany(mappedBy = "pastas")
    private Set<EmailEntity> emails;

}
