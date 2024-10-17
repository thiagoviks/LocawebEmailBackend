package br.com.fiap.locaweb.LocawebEmail.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "EMAIL")
public class EmailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "email_seq")
    @SequenceGenerator(name = "email_seq", sequenceName = "email_seq", allocationSize = 1)
    @Column(name = "ID_EMAIL", nullable = false, length = 10)
    private Long id;

    @Column(name = "ASSUNTO", nullable = false)
    private String assunto;

    @Lob
    @Column(name = "CORPO", nullable = false)
    private String corpo;

    @Column(name = "DATA_ENVIO")
    @Temporal(TemporalType.DATE)
    private Date dataEnvio;

    @Column(name = "STATUS", nullable = false, length = 20)
    private String status;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO_ENVIO", nullable = false)
    private UsuarioEntity usuarioEnvio;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO_RECEPCAO")
    private UsuarioEntity usuarioRecepcao;

    @ManyToMany
    @JoinTable(
            name = "EMAIL_PASTA",
            joinColumns = @JoinColumn(name = "ID_EMAIL"),
            inverseJoinColumns = @JoinColumn(name = "ID_PASTA")
    )
    private Set<PastaEntity> pastas;

    @OneToMany(mappedBy = "email")
    private Set<AnexoEntity> anexos;

    // Getters and Setters
}
