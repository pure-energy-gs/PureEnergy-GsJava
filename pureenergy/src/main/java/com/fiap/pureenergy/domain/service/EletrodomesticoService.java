package com.fiap.pureenergy.domain.service;

import com.fiap.pureenergy.domain.model.EletrodomesticoModel;

import java.util.List;

public interface EletrodomesticoService {

    EletrodomesticoModel cadastrarEletrodomestico(EletrodomesticoModel eletrodomestico);

    List<EletrodomesticoModel> listarEletrodomesticos();

    EletrodomesticoModel atualizarEletrodomestico(String id, EletrodomesticoModel eletrodomestico);

    EletrodomesticoModel deletarEletrodomestico(String id);

    EletrodomesticoModel detalharEletrodomestico(String id);


}
