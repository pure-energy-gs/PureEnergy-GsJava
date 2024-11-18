package com.fiap.pureenergy.domain.ports.out;

import com.fiap.pureenergy.adapter.repository.entity.ResidenciaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResidenciaPotOut extends JpaRepository<ResidenciaEntity, Long> {

    public ResidenciaEntity findByIdResidencia(long idResidencia);
}
