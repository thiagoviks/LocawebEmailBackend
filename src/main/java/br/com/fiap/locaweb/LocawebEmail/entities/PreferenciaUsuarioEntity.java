package br.com.fiap.locaweb.LocawebEmail.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "PREFERENCIA_USUARIO")
public class PreferenciaUsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "preferencia_usuario_seq")
    @SequenceGenerator(name = "preferencia_usuario_seq", sequenceName = "preferencia_usuario_seq", allocationSize = 1)
    @Column(name = "ID_PREFERENCIA", nullable = false, length = 10)
    private Long id;

    @Column(name = "CHAVE", nullable = false, length = 50)
    private String chave;

    @Column(name = "VALOR", nullable = false)
    private String valor;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    private UsuarioEntity usuario;

}
