package com.fiap.pureenergy.domain.ports.out;

import com.fiap.pureenergy.adapter.repository.entity.ConsumoMensalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsumoMensalPortOut extends JpaRepository<ConsumoMensalEntity, Long> {

}
