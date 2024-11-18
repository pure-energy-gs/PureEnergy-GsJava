package com.fiap.pureenergy.domain.ports.out;

import com.fiap.pureenergy.adapter.repository.entity.ComodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComodoPortOut extends JpaRepository<ComodoEntity, Long> {

    public ComodoEntity findByIdComodo(long idComodo);
}
