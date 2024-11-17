package com.fiap.pureenergy.domain.ports.out;

import com.fiap.pureenergy.adapter.repository.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioPortOut extends JpaRepository<UsuarioEntity, Long> {

    public UsuarioEntity findByEmail(String email);
}
