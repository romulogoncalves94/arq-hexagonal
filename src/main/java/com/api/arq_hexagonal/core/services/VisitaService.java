package com.api.arq_hexagonal.core.services;

import com.api.arq_hexagonal.core.domain.*;
import com.api.arq_hexagonal.core.ports.*;
import org.modelmapper.ModelMapper;

import java.util.List;

public class VisitaService implements VisitaServicePort {

    private final VisitaRepositoryPort visitaRepositoryPort;
    private final VisitanteRepositoryPort visitanteRepositoryPort;
    private final MoradorRepositoryPort moradorRepositoryPort;
    private final ModelMapper modelMapper;

    public VisitaService(VisitaRepositoryPort visitaRepositoryPort, VisitanteRepositoryPort visitanteRepositoryPort, MoradorRepositoryPort moradorRepositoryPort, ModelMapper modelMapper) {
        this.visitaRepositoryPort = visitaRepositoryPort;
        this.visitanteRepositoryPort = visitanteRepositoryPort;
        this.moradorRepositoryPort = moradorRepositoryPort;
        this.modelMapper = modelMapper;
    }


    @Override
    public Visita createVisita(Visita visita) {
        //Adicionar lógica para quando existir uma visita com o mesmo horário, o mesmo visitante e mesmo morador interromper e dar uma mensagem
        Visitante visitante = visitanteRepositoryPort.findById(visita.getVisitante().getId());
        Morador morador = moradorRepositoryPort.findById(visita.getMorador().getId());

        if (visitante == null || morador == null) {
            throw new IllegalArgumentException("Visitante ou morador não encontrado");
        }

        visita.setVisitante(visitante);
        visita.setMorador(morador);
        return visitaRepositoryPort.createVisita(visita);
    }

    @Override
    public List<Visita> findAllVisitas() {
        return visitaRepositoryPort.findAll().stream()
                .map(entity -> modelMapper.map(entity, Visita.class))
                .toList();
    }

    @Override
    public Visita findVisitaById(Long id) {
        return visitaRepositoryPort.findById(id);
    }

    @Override
    public void deleteVisita(Long id) {
        visitaRepositoryPort.delete(id);
    }

    @Override
    public Visita updateVisita(Long id, Visita visita) {
        Visita idVisita = visitaRepositoryPort.findById(id);

        if (idVisita == null) {
            throw new IllegalArgumentException("Visita não encontrada");
        }

        return visitaRepositoryPort.updateVisita(id, visita);
    }
}
