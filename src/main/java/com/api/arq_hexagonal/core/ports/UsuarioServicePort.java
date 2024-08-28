package com.api.arq_hexagonal.core.ports;

import com.api.arq_hexagonal.core.domain.Usuario;

public interface UsuarioServicePort {
    Usuario createUsuario(Usuario usuario);
    Usuario updateUsuario(Long id, Usuario usuario);
    void deleteUsuario(Long id);
}
