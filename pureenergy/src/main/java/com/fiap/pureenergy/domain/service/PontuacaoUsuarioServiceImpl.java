package com.fiap.pureenergy.domain.service;

import com.fiap.pureenergy.adapter.repository.mapper.PontuacaoUsuarioMapper;
import com.fiap.pureenergy.domain.exception.PontuacaoUsuarioNotFoundException;
import com.fiap.pureenergy.domain.model.PontuacaoUsuarioModel;
import com.fiap.pureenergy.domain.ports.out.PontuacaoUsuarioPortOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PontuacaoUsuarioServiceImpl implements PontuacaoUsuarioService {

    @Autowired
    private PontuacaoUsuarioPortOut pontuacaoUsuarioPortOut;


    @Override
    public List<PontuacaoUsuarioModel> listarConsumoMensal() {
        return pontuacaoUsuarioPortOut.findAll().stream()
                .map(PontuacaoUsuarioMapper::toModel)
                .collect(Collectors.toList());
    }


    @Override
    public PontuacaoUsuarioModel detalharConsumoMensal(String id) {
        return pontuacaoUsuarioPortOut.findById(Long.parseLong(id))
                .map(PontuacaoUsuarioMapper::toModel)
                .orElseThrow(PontuacaoUsuarioNotFoundException::new);
    }

}
