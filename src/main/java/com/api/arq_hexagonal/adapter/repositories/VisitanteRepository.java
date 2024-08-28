package com.api.arq_hexagonal.adapter.repositories;

import com.api.arq_hexagonal.adapter.entities.VisitanteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitanteRepository extends JpaRepository<VisitanteEntity, Long> {
    VisitanteEntity findByRg(String rg);
}
