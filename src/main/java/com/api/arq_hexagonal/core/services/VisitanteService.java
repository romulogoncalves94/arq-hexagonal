package com.api.arq_hexagonal.core.services;

import com.api.arq_hexagonal.core.domain.Visitante;
import com.api.arq_hexagonal.core.ports.VisitanteRepositoryPort;
import com.api.arq_hexagonal.core.ports.VisitanteServicePort;
import org.modelmapper.ModelMapper;

import java.util.List;

public class VisitanteService implements VisitanteServicePort {
    private final ModelMapper modelMapper;

    private final VisitanteRepositoryPort visitanteRepositoryPort;

    public VisitanteService(VisitanteRepositoryPort visitanteRepositoryPort, ModelMapper modelMapper) {
        this.visitanteRepositoryPort = visitanteRepositoryPort;
        this.modelMapper = modelMapper;
    }

    @Override
    public Visitante createVisitante(Visitante visitante) {
        Visitante visitanteExistente = visitanteRepositoryPort.obtainByRg(visitante.getRg());

        if (visitanteExistente != null) {
            throw new IllegalArgumentException("Visitante já existe");
        }

        return visitanteRepositoryPort.createVisitante(visitante);
    }

    @Override
    public List<Visitante> findAllVisitantes() {
        return visitanteRepositoryPort.findAll().stream()
                .map(entity -> modelMapper.map(entity, Visitante.class))
                .toList();
    }

    @Override
    public Visitante findVisitanteById(Long id) {
        return visitanteRepositoryPort.findById(id);
    }

    @Override
    public Visitante updateMorador(Long id, Visitante visitante) {
        Visitante idVisitante = visitanteRepositoryPort.findById(id);

        if (idVisitante == null) {
            throw new IllegalArgumentException("Visitante não encontrado");
        }

        return visitanteRepositoryPort.updateVisitante(id, visitante);
    }

    @Override
    public void deleteVisitante(Long id) {
        visitanteRepositoryPort.delete(id);
    }
}
