package com.api.arq_hexagonal.adapter.repositories;

import com.api.arq_hexagonal.adapter.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    UsuarioEntity findByEmail(String email);
}
