package com.api.arq_hexagonal.core.ports;

import com.api.arq_hexagonal.core.domain.Visitante;

import java.util.List;

public interface VisitanteServicePort {
    Visitante createVisitante(Visitante visitante);
    List<Visitante> findAllVisitantes();
    Visitante findVisitanteById(Long id);
    Visitante updateMorador(Long id, Visitante visitante);
    void deleteVisitante(Long id);
}
