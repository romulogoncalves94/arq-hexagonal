package com.api.arq_hexagonal.core.services;

import com.api.arq_hexagonal.core.domain.Usuario;
import com.api.arq_hexagonal.core.ports.UsuarioRepositoryPort;
import com.api.arq_hexagonal.core.ports.UsuarioServicePort;

public class UsuarioService implements UsuarioServicePort {

    private final UsuarioRepositoryPort usuarioRepositoryPort;

    public UsuarioService(UsuarioRepositoryPort usuarioRepositoryPort) {
        this.usuarioRepositoryPort = usuarioRepositoryPort;
    }

    @Override
    public Usuario createUsuario(Usuario usuario) {
        Usuario usuarioExistente = usuarioRepositoryPort.obtainByEmail(usuario.getEmail());
        if (usuarioExistente != null) {
            throw new IllegalArgumentException("Usuário já existe");
        }
        return usuarioRepositoryPort.create(usuario);
    }

    @Override
    public Usuario updateUsuario(Long id, Usuario usuario) {
        Usuario usuarioExistente = usuarioRepositoryPort.findById(id);

        if (usuarioExistente == null) {
            throw new IllegalArgumentException("Usuário não encontrado");
        }

        return usuarioRepositoryPort.update(id, usuario);
    }

    @Override
    public void deleteUsuario(Long id) {
        if (usuarioRepositoryPort.findById(id) == null) {
            throw new IllegalArgumentException("Usuário não encontrado");
        }
        usuarioRepositoryPort.delete(id);
    }
}
