package com.api.arq_hexagonal.core.services;

import com.api.arq_hexagonal.core.domain.Morador;
import com.api.arq_hexagonal.core.ports.MoradorRepositoryPort;
import com.api.arq_hexagonal.core.ports.MoradorServicePort;
import org.modelmapper.ModelMapper;

import java.util.List;

public class MoradorService implements MoradorServicePort {

    private final MoradorRepositoryPort moradorRepositoryPort;
    private final ModelMapper modelMapper;

    public MoradorService(MoradorRepositoryPort moradorRepositoryPort, ModelMapper modelMapper) {
        this.moradorRepositoryPort = moradorRepositoryPort;
        this.modelMapper = modelMapper;
    }

    @Override
    public Morador createMorador(Morador morador) {
        Morador moradorExistente = moradorRepositoryPort.obtainByCpf(morador.getCpf());

        if (moradorExistente != null) {
            throw new IllegalArgumentException("Morador já existe");
        }

        return moradorRepositoryPort.createMorador(morador);
    }

    @Override
    public List<Morador> findAllMoradores() {
        return moradorRepositoryPort.findAll().stream()
                .map(entity -> modelMapper.map(entity, Morador.class))
                .toList();
    }

    @Override
    public Morador updateMorador(Long id, Morador morador) {
       Morador idMorador = moradorRepositoryPort.findById(id);

       if (idMorador == null) {
           throw new IllegalArgumentException("Morador não encontrado");
       }

       return moradorRepositoryPort.updateMorador(id, morador);
    }

    @Override
    public Morador findMoradorById(Long id) {
        return moradorRepositoryPort.findById(id);
    }

    @Override
    public void deleteMorador(Long id) {
        if (moradorRepositoryPort.findById(id) == null) {
            throw new IllegalArgumentException("Morador não encontrado");
        }

        moradorRepositoryPort.delete(id);
    }
}
