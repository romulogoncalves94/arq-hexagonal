package com.api.arq_hexagonal.adapter.repositories;

import com.api.arq_hexagonal.adapter.entities.VisitanteEntity;
import com.api.arq_hexagonal.core.domain.Visitante;
import com.api.arq_hexagonal.core.ports.VisitanteRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class VisitanteRepositoryAdapter implements VisitanteRepositoryPort {

    private final VisitanteRepository visitanteRepository;
    private final ModelMapper modelMapper;

    @Override
    public Visitante createVisitante(Visitante visitante) {
        VisitanteEntity visitanteEntity = visitanteRepository.save(modelMapper.map(visitante, VisitanteEntity.class));
        return modelMapper.map(visitanteEntity, Visitante.class);
    }

    public Visitante obtainByRg(String rg) {
        VisitanteEntity visitanteByRg = visitanteRepository.findByRg(rg);

        if (visitanteByRg == null) {
            return null;
        }

        return modelMapper.map(visitanteByRg, Visitante.class);
    }

    @Override
    public Visitante findById(Long id) {
        Optional<VisitanteEntity> idVisitante = visitanteRepository.findById(id);

        if (idVisitante.isEmpty()) {
            return null;
        }

        return modelMapper.map(idVisitante, Visitante.class);
    }

    @Override
    public List<Visitante> findAll() {
        return visitanteRepository.findAll().stream()
                .map(entity -> modelMapper.map(entity, Visitante.class))
                .toList();
    }

    @Override
    public Visitante updateVisitante(Long id, Visitante visitante) {
        VisitanteEntity visitanteAtualizado = visitanteRepository.findById(id).map(
                visitanteEntity -> {
                    visitanteEntity.setNomeVisitante(visitante.getNomeVisitante());
                    visitanteEntity.setRg(visitante.getRg());
                    return visitanteRepository.save(visitanteEntity);
                }
        ).orElseThrow(() -> new IllegalArgumentException("Visitante não encontrado"));

        return modelMapper.map(visitanteAtualizado, Visitante.class);
    }

    @Override
    public void delete(Long id) {
        visitanteRepository.deleteById(id);
    }
}
