package com.fiap.pureenergy.domain.service;

import com.fiap.pureenergy.adapter.repository.entity.ConsumoMensalEntity;
import com.fiap.pureenergy.adapter.repository.mapper.ConsumoMensalMapper;
import com.fiap.pureenergy.domain.exception.ComodoNotFoundException;
import com.fiap.pureenergy.domain.model.ConsumoMensalModel;
import com.fiap.pureenergy.domain.ports.out.ConsumoMensalPortOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ConsumoMensalServiceImpl implements ConsumoMensalService {

    @Autowired
    private ConsumoMensalPortOut consumoMensalPortOut;

    @Autowired
    private ConsumoMensalMapper consumoMensalMapper;

    @Override
    public ConsumoMensalModel cadastrarConsumoMensal(ConsumoMensalModel consumoMensal) {
        ConsumoMensalEntity entity = consumoMensalMapper.toEntity(consumoMensal);
        ConsumoMensalEntity savedEntity = consumoMensalPortOut.save(entity);
        return consumoMensalMapper.toModel(savedEntity);
    }

    @Override
    public List<ConsumoMensalModel> listarConsumoMensal() {
        return consumoMensalPortOut.findAll().stream()
                .map(ConsumoMensalMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public ConsumoMensalModel atualizarConsumoMensal(String id, ConsumoMensalModel consumoMensal) {
        Optional<ConsumoMensalEntity> optionalEntity = consumoMensalPortOut.findById(Long.parseLong(id));
        if (optionalEntity.isPresent()) {
            ConsumoMensalEntity entity = consumoMensalMapper.toEntity(consumoMensal);
            entity.setIdConsumoMensal(optionalEntity.get().getIdConsumoMensal());
            ConsumoMensalEntity updatedEntity = consumoMensalPortOut.save(entity);
            return consumoMensalMapper.toModel(updatedEntity);
        } else {
            throw new RuntimeException("Consumo Mensal não encontrado");
        }
    }

    @Override
    public ConsumoMensalModel deletarConsumoMensal(String id) {
        Optional<ConsumoMensalEntity> optionalEntity = consumoMensalPortOut.findById(Long.parseLong(id));
        if (optionalEntity.isPresent()) {
            consumoMensalPortOut.deleteById(Long.parseLong(id));
            return consumoMensalMapper.toModel(optionalEntity.get());
        } else {
            throw new RuntimeException("Consumo Mensal não encontrado");
        }
    }

    @Override
    public ConsumoMensalModel detalharConsumoMensal(String id) {
        return consumoMensalPortOut.findById(Long.parseLong(id))
                .map(ConsumoMensalMapper::toModel)
                .orElseThrow(ComodoNotFoundException::new);
    }

}
