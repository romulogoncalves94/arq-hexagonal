package com.api.arq_hexagonal.adapter.controller;

import com.api.arq_hexagonal.adapter.converters.UsuarioConverter;
import com.api.arq_hexagonal.adapter.dtos.UsuarioDTO;
import com.api.arq_hexagonal.core.ports.UsuarioServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioServicePort usuarioServicePort;
    private final UsuarioConverter usuarioConverter;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioDTO create(@RequestBody UsuarioDTO usuarioDTO) {
        return usuarioConverter.toDto(usuarioServicePort.createUsuario(usuarioConverter.toDomain(usuarioDTO)));
    }

    @PutMapping
    public UsuarioDTO update(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO) {
        return usuarioConverter.toDto(usuarioServicePort.updateUsuario(id, usuarioConverter.toDomain(usuarioDTO)));
    }

    @DeleteMapping
    public void delete(@PathVariable Long id) {
        usuarioServicePort.deleteUsuario(id);
    }
}
