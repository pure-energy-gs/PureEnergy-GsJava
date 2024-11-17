package com.fiap.pureenergy.adapter.repository.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "T_PE_RESIDENCIAS")
@Data
public class ResidenciaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_residencia")
    private Long idResidencia;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private UsuarioEntity usuario;

    @Column(name = "tipo_residencia", nullable = false)
    private String tipoResidencia;

    @Column(name = "quantidade_pessoas", nullable = false)
    private Integer quantidadePessoas;

}
