package br.com.fiap.locaweb.LocawebEmail.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "USUARIO")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_seq")
    @SequenceGenerator(name = "usuario_seq", sequenceName = "usuario_seq", allocationSize = 1)
    @Column(name = "ID_USUARIO", nullable = false, length = 10)
    private Long id;

    @Column(name = "NOME", nullable = false, length = 100)
    private String nome;

    @Column(name = "EMAIL", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "SENHA", nullable = false)
    private String senha;

    @Column(name = "DATA_CADASTRO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataCadastro;

    @OneToMany(mappedBy = "usuarioEnvio")
    private Set<EmailEntity> emailsEnviados;

    @OneToMany(mappedBy = "usuarioRecepcao")
    private Set<EmailEntity> emailsRecebidos;

    @OneToMany(mappedBy = "usuario")
    private Set<ContatoEntity> contatos;

    @OneToMany(mappedBy = "usuario")
    private Set<PastaEntity> pastas;

    @OneToMany(mappedBy = "usuario")
    private Set<RascunhoEntity> rascunhos;

    @OneToMany(mappedBy = "usuario")
    private Set<RegrasFiltragemEntity> regrasFiltragem;

    @OneToMany(mappedBy = "usuario")
    private Set<CategoriaEntity> categorias;

    @OneToMany(mappedBy = "usuario")
    private Set<RotuloEntity> rotulos;

    @OneToMany(mappedBy = "usuario")
    private Set<PreferenciaUsuarioEntity> preferencias;

    @OneToOne(mappedBy = "usuario")
    private ConfiguracaoUsuarioEntity configuracao;

}
