package br.com.fiap.locaweb.LocawebEmail.entities;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "CONDICOES")
public class CondicoesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "condicoes_seq")
    @SequenceGenerator(name = "condicoes_seq", sequenceName = "condicoes_seq", allocationSize = 1)
    @Column(name = "ID_CONDICAO", nullable = false, length = 10)
    private Long id;

    @Column(name = "TIPO_CONDICAO", nullable = false, length = 50)
    private String tipoCondicao;

    @Column(name = "VALOR", nullable = false)
    private String valor;

    @ManyToOne
    @JoinColumn(name = "ID_REGRA", nullable = false)
    private RegrasFiltragemEntity regra;

}
