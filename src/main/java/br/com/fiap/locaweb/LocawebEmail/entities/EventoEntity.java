package br.com.fiap.locaweb.LocawebEmail.entities;

import jakarta.persistence.*;

import lombok.Data;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "EVENTO")
public class EventoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "evento_seq")
    @SequenceGenerator(name = "evento_seq", sequenceName = "evento_seq", allocationSize = 1)
    @Column(name = "ID_EVENTO", nullable = false, length = 10)
    private Long id;

    @Column(name = "TITULO", nullable = false)
    private String titulo;

    @Column(name = "DESCRICAO", length = 1000) //no db esta como clob, trocar para string(255)
    private String descricao;


    @Column(name = "DATA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInicio;

    @Column(name = "DATA_FIM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFim;

    @Column(name = "LOCALIZACAO", nullable = false)
    private String localizacao;

    @Column(name = "CRIADO_EM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date criadoEm;

    @Column(name = "ATUALIZADO_EM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date atualizadoEm;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO_CRIADOR", nullable = false)
    private UsuarioEntity usuarioCriador;

    @ManyToMany(mappedBy = "eventos")
    private Set<CategoriaEntity> categorias;

    @ManyToMany(mappedBy = "eventos")
    private Set<RotuloEntity> rotulos;

    @ManyToMany
    @JoinTable(
            name = "EVENTO_ANEXO",
            joinColumns = @JoinColumn(name = "ID_EVENTO"),
            inverseJoinColumns = @JoinColumn(name = "ID_ANEXO")
    )
    private Set<AnexoEntity> anexos;

    // Getters and Setters
}
