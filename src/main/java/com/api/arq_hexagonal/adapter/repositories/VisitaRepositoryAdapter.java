package com.api.arq_hexagonal.adapter.repositories;

import com.api.arq_hexagonal.adapter.entities.*;
import com.api.arq_hexagonal.core.domain.Visita;
import com.api.arq_hexagonal.core.ports.VisitaRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class VisitaRepositoryAdapter implements VisitaRepositoryPort {

    private final VisitaRepository visitaRepository;
    private final ModelMapper modelMapper;

    @Override
    public Visita createVisita(Visita visita) {
        VisitaEntity visitaEntity = visitaRepository.save(modelMapper.map(visita, VisitaEntity.class));
        return modelMapper.map(visitaEntity, Visita.class);
    }

    @Override
    public List<Visita> findAll() {
        return visitaRepository.findAll().stream()
                .map(entity -> modelMapper.map(entity, Visita.class))
                .toList();
    }

    @Override
    public void delete(Long id) {
        visitaRepository.deleteById(id);
    }

    @Override
    public Visita updateVisita(Long id, Visita visita) {
        VisitaEntity visitaAtualizada = visitaRepository.findById(id).map(
                visitaEntity -> {
                    visitaEntity.setDataHora(visita.getDataHora());
                    visitaEntity.setMorador(modelMapper.map(visita.getMorador(), MoradorEntity.class));
                    visitaEntity.setVisitante(modelMapper.map(visita.getVisitante(), VisitanteEntity.class));
                    return visitaRepository.save(visitaEntity);
                }).orElseThrow(() -> new IllegalArgumentException("Visita não encontrada"));

        return modelMapper.map(visitaAtualizada, Visita.class);
    }

    @Override
    public Visita findById(Long id) {
        return visitaRepository.findById(id)
                .map(visitaEntity -> modelMapper.map(visitaEntity, Visita.class))
                .orElseThrow(() -> new IllegalArgumentException("Visita não encontrada"));
    }
}
