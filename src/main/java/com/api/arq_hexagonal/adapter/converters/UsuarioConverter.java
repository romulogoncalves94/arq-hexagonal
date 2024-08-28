package com.api.arq_hexagonal.adapter.converters;

import com.api.arq_hexagonal.adapter.dtos.UsuarioDTO;
import com.api.arq_hexagonal.core.domain.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioConverter {

    public Usuario toDomain(UsuarioDTO dto) {
        return new Usuario(
                dto.getId(),
                dto.getEmail(),
                dto.getSenha(),
                dto.getAdministrador(),
                dto.getNomeUsuario());
    }

    public UsuarioDTO toDto(Usuario domain) {
        return new UsuarioDTO(
                domain.getId(),
                domain.getNomeUsuario(),
                domain.getEmail(),
                domain.getSenha(),
                domain.getAdministrador());
    }
}
