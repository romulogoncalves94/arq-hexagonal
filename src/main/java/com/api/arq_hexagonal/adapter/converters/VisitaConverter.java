package com.api.arq_hexagonal.adapter.converters;

import com.api.arq_hexagonal.adapter.dtos.*;
import com.api.arq_hexagonal.core.domain.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class VisitaConverter {

    private final ModelMapper modelMapper;

    public VisitaConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Visita toDomain(VisitaDTO dto) {
        return new Visita(
                dto.getId(),
                dto.getDataHora(),
                new Morador(
                        dto.getMorador().getId(),
                        dto.getMorador().getNomeMorador(),
                        dto.getMorador().getCpf(),
                        dto.getMorador().getEndereco(),
                        dto.getMorador().getCelular()),
                new Visitante(
                        dto.getVisitante().getId(),
                        dto.getVisitante().getRg(),
                        dto.getVisitante().getNomeVisitante())
        );
    }

    public VisitaDTO toDto(Visita domain) {
        return new VisitaDTO(
                domain.getId(),
                domain.getDataHora(),
                modelMapper.map(domain.getMorador(), MoradorDTO.class),
                modelMapper.map(domain.getVisitante(), VisitanteDTO.class)
        );
    }
}
