package com.fiap.pureenergy.adapter.repository.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "T_PE_ELETRODOMESTICOS")
@Data
public class EletrodomesticoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_eletrodomestico")
    private Long idEletrodomestico;

    @ManyToOne
    @JoinColumn(name = "id_comodo", nullable = false)
    private ComodoEntity comodo;

    @Column(name = "nome_eletrodomestico", nullable = false)
    private String nomeEletrodomestico;

    @Column(name = "potencia_watts", nullable = false)
    private Double potenciaWatts;

    @Column(name = "horas_uso_dia", nullable = false)
    private Double horasUsoDia;

    @Column(name = "descricao")
    private String descricao;
}

