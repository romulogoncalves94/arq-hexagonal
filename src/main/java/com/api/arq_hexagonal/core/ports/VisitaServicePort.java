package com.api.arq_hexagonal.core.ports;

import com.api.arq_hexagonal.core.domain.Visita;

import java.util.Collection;
import java.util.List;

public interface VisitaServicePort {
    Visita createVisita(Visita domain);
    List<Visita> findAllVisitas();
    Visita findVisitaById(Long id);
    void deleteVisita(Long id);
    Visita updateVisita(Long id, Visita visita);
}
