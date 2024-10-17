package br.com.fiap.locaweb.LocawebEmail.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "REGRAS_FILTRAGEM")
public class RegrasFiltragemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "regras_filtragem_seq")
    @SequenceGenerator(name = "regras_filtragem_seq", sequenceName = "regras_filtragem_seq", allocationSize = 1)
    @Column(name = "ID_REGRA", nullable = false, length = 10)
    private Long id;

    @Column(name = "NOME", nullable = false, length = 100)
    private String nome;

    @Column(name = "CONDICAO", nullable = false)
    private String condicao;

    @Column(name = "ACAO", nullable = false, length = 50)
    private String acao;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    private UsuarioEntity usuario;

    @OneToMany(mappedBy = "regra")
    private Set<CondicoesEntity> condicoes;

    @OneToMany(mappedBy = "regra")
    private Set<AcoesEntity> acoes;

}
