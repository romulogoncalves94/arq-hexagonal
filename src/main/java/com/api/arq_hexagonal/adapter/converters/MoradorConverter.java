package com.api.arq_hexagonal.adapter.converters;

import com.api.arq_hexagonal.adapter.dtos.MoradorDTO;
import com.api.arq_hexagonal.core.domain.*;
import org.springframework.stereotype.Component;

@Component
public class MoradorConverter {

    public Morador toDomain(MoradorDTO dto) {
        return new Morador(
                dto.getId(),
                dto.getNomeMorador(),
                dto.getCpf(),
                dto.getEndereco(),
                dto.getCelular());
    }

    public MoradorDTO toDto(Morador domain) {
        return new MoradorDTO(
                domain.getId(),
                domain.getNomeMorador(),
                domain.getCpf(),
                domain.getEndereco(),
                domain.getCelular());
    }
}
