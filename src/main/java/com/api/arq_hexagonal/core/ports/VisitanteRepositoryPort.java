package com.api.arq_hexagonal.core.ports;

import com.api.arq_hexagonal.adapter.dtos.VisitanteDTO;
import com.api.arq_hexagonal.core.domain.Visitante;

import java.util.Collection;
import java.util.List;

public interface VisitanteRepositoryPort {
    Visitante createVisitante(Visitante visitante);
    Visitante obtainByRg(String rg);
    Visitante findById(Long id);
    List<Visitante> findAll();
    Visitante updateVisitante(Long id, Visitante visitante);
    void delete(Long id);
}
