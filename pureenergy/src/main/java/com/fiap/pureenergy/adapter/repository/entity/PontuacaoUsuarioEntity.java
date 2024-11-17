package com.fiap.pureenergy.adapter.repository.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "T_PE_PONTUACAO_USUARIO")
@Data
public class PontuacaoUsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pontuacao")
    private Long idPontuacao;

    @OneToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private UsuarioEntity usuario;

    @Column(name = "pontos_totais", nullable = false)
    private Integer pontosTotais = 0;

    @Column(name = "data_atualizacao", nullable = false)
    private LocalDate dataAtualizacao = LocalDate.now();

}