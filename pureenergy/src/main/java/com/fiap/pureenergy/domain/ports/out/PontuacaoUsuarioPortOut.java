package com.fiap.pureenergy.domain.ports.out;

import com.fiap.pureenergy.adapter.repository.entity.PontuacaoUsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PontuacaoUsuarioPortOut extends JpaRepository<PontuacaoUsuarioEntity, Long> {

}
