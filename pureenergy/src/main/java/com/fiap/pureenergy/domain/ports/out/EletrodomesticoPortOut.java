package com.fiap.pureenergy.domain.ports.out;

import com.fiap.pureenergy.adapter.repository.entity.EletrodomesticoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EletrodomesticoPortOut extends JpaRepository<EletrodomesticoEntity, Long> {
}
