package com.fiap.pureenergy.domain.ports.out;

import com.fiap.pureenergy.adapter.repository.entity.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoPortOut extends JpaRepository<EnderecoEntity, Long> {

    public EnderecoEntity findByCep(String cep);
}
