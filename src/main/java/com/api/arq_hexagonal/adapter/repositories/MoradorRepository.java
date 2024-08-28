package com.api.arq_hexagonal.adapter.repositories;

import com.api.arq_hexagonal.adapter.entities.MoradorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoradorRepository extends JpaRepository<MoradorEntity, Long> {

    MoradorEntity findByCpf(String cpf);
}
