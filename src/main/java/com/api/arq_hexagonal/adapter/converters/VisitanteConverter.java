package com.api.arq_hexagonal.adapter.converters;

import com.api.arq_hexagonal.adapter.dtos.VisitanteDTO;
import com.api.arq_hexagonal.core.domain.Visitante;
import org.springframework.stereotype.Component;

@Component
public class VisitanteConverter {

    public Visitante toDomain(VisitanteDTO dto) {
        return new Visitante(
                dto.getId(),
                dto.getRg(),
                dto.getNomeVisitante());
    }

    public VisitanteDTO toDto(Visitante domain) {
        return new VisitanteDTO(
                domain.getId(),
                domain.getRg(),
                domain.getNomeVisitante());
    }
}
