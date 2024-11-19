package com.fiap.pureenergy.domain.service;

import com.fiap.pureenergy.adapter.repository.entity.EletrodomesticoEntity;
import com.fiap.pureenergy.adapter.repository.mapper.EletrodomesticoMapper;
import com.fiap.pureenergy.domain.model.EletrodomesticoModel;
import com.fiap.pureenergy.domain.ports.out.EletrodomesticoPortOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EletrodomesticoServiceImpl implements EletrodomesticoService {

    @Autowired
    private EletrodomesticoPortOut eletrodomesticoPortOut;

    @Autowired
    private EletrodomesticoMapper eletrodomesticoMapper;

    @Override
    public EletrodomesticoModel cadastrarEletrodomestico(EletrodomesticoModel eletrodomestico) {
        EletrodomesticoEntity entity = eletrodomesticoMapper.toEntity(eletrodomestico);
        EletrodomesticoEntity savedEntity = eletrodomesticoPortOut.save(entity);
        return eletrodomesticoMapper.toModel(savedEntity);
    }

    @Override
    public List<EletrodomesticoModel> listarEletrodomesticos() {
        return eletrodomesticoPortOut.findAll().stream()
                .map(EletrodomesticoMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public EletrodomesticoModel atualizarEletrodomestico(String id, EletrodomesticoModel eletrodomestico) {
        Optional<EletrodomesticoEntity> optionalEntity = eletrodomesticoPortOut.findById(Long.parseLong(id));
        if (optionalEntity.isPresent()) {
            EletrodomesticoEntity entity = eletrodomesticoMapper.toEntity(eletrodomestico);
            entity.setIdEletrodomestico(optionalEntity.get().getIdEletrodomestico());
            EletrodomesticoEntity updatedEntity = eletrodomesticoPortOut.save(entity);
            return eletrodomesticoMapper.toModel(updatedEntity);
        } else {
            throw new RuntimeException("Eletrodoméstico não encontrado");
        }
    }

    @Override
    public EletrodomesticoModel deletarEletrodomestico(String id) {
        Optional<EletrodomesticoEntity> optionalEntity = eletrodomesticoPortOut.findById(Long.parseLong(id));
        if (optionalEntity.isPresent()) {
            eletrodomesticoPortOut.deleteById(Long.parseLong(id));
            return eletrodomesticoMapper.toModel(optionalEntity.get());
        } else {
            throw new RuntimeException("Eletrodoméstico não encontrado");
        }
    }

    @Override
    public EletrodomesticoModel detalharEletrodomestico(String id) {
        return eletrodomesticoPortOut.findById(Long.parseLong(id))
                .map(EletrodomesticoMapper::toModel)
                .orElseThrow(() -> new RuntimeException("Eletrodoméstico não encontrado"));
    }

}
