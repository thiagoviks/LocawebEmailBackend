package br.com.fiap.locaweb.LocawebEmail.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ACOES")
public class AcoesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "acoes_seq")
    @SequenceGenerator(name = "acoes_seq", sequenceName = "acoes_seq", allocationSize = 1)
    @Column(name = "ID_ACAO", nullable = false, length = 10)
    private Long id;

    @Column(name = "TIPO_ACAO", nullable = false, length = 50)
    private String tipoAcao;

    @Column(name = "DETALHES")
    private String detalhes;

    @ManyToOne
    @JoinColumn(name = "ID_REGRA", nullable = false)
    private RegrasFiltragemEntity regra;
}
