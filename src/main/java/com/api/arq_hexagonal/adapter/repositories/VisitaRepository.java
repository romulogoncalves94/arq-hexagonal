package com.api.arq_hexagonal.adapter.repositories;

import com.api.arq_hexagonal.adapter.entities.VisitaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitaRepository extends JpaRepository<VisitaEntity, Long> {
}
