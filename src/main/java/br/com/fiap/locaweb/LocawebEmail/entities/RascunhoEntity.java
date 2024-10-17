package br.com.fiap.locaweb.LocawebEmail.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "RASCUNHO")
public class RascunhoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rascunho_seq")
    @SequenceGenerator(name = "rascunho_seq", sequenceName = "rascunho_seq", allocationSize = 1)
    @Column(name = "ID_RASCUNHO", nullable = false, length = 10)
    private Long id;

    @Column(name = "ASSUNTO", nullable = false)
    private String assunto;

    @Lob
    @Column(name = "CORPO", nullable = false)
    private String corpo;

    @Column(name = "DATA_CRIACAO")
    @Temporal(TemporalType.DATE)
    private Date dataCriacao;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    private UsuarioEntity usuario;

    // Getters and Setters
}
