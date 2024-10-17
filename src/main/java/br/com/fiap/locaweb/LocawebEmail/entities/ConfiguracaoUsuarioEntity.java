package br.com.fiap.locaweb.LocawebEmail.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "CONFIGURACAO_USUARIO")
public class ConfiguracaoUsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "configuracao_usuario_seq")
    @SequenceGenerator(name = "configuracao_usuario_seq", sequenceName = "configuracao_usuario_seq", allocationSize = 1)
    @Column(name = "ID_CONFIGURACAO", nullable = false, length = 10)
    private Long id;

    @Column(name = "TEMA", length = 50)
    private String tema;

    @Column(name = "COR_PRIMARIA", length = 20)
    private String corPrimaria;

    @Column(name = "COR_SECUNDARIA", length = 20)
    private String corSecundaria;

    @Column(name = "LAYOUT", length = 50)
    private String layout;

    @OneToOne
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    private UsuarioEntity usuario;

    // Getters and Setters
}
