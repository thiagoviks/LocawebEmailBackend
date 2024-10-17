package br.com.fiap.locaweb.LocawebEmail.entities;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ANEXO")
public class AnexoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "anexo_seq")
    @SequenceGenerator(name = "anexo_seq", sequenceName = "anexo_seq", allocationSize = 1)
    @Column(name = "ID_ANEXO", nullable = false, length = 10)
    private Long id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "TIPO", length = 50)
    private String tipo;

    @Column(name = "TAMANHO")
    private Long tamanho;

    @Lob
    @Column(name = "DADOS")
    private byte[] dados;

    @ManyToOne
    @JoinColumn(name = "ID_EMAIL", nullable = false)
    private EmailEntity email;

}
