package com.api.arq_hexagonal.core.ports;

import com.api.arq_hexagonal.core.domain.Visita;

import java.util.List;

public interface VisitaRepositoryPort {
    Visita findById(Long id);
    Visita createVisita(Visita visita);
    List<Visita> findAll();
    void delete(Long id);
    Visita updateVisita(Long id, Visita visita);
}
