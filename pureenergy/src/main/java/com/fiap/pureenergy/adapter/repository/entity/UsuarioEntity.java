package com.fiap.pureenergy.adapter.repository.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "T_PE_USUARIOS")
@Data
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "senha", nullable = false)
    private String senha;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<EnderecoEntity> enderecoEntities;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<ResidenciaEntity> residenciaEntities;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<ComodoEntity> comodoEntities;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<ConsumoMensalEntity> consumosMensais;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private PontuacaoUsuarioEntity pontuacaoUsuarioEntity;

}
