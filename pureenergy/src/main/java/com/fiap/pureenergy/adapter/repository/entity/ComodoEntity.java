package com.fiap.pureenergy.adapter.repository.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "T_PE_COMODOS")
@Data
public class ComodoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comodo")
    private Long idComodo;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private UsuarioEntity usuario;

    @Column(name = "nome_comodo", nullable = false)
    private String nomeComodo;

    @Column(name = "descricao")
    private String descricao;

    @OneToMany(mappedBy = "comodo", cascade = CascadeType.ALL)
    private List<EletrodomesticoEntity> eletrodomesticoEntities;
}
