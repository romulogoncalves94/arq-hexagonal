package com.api.arq_hexagonal.core.ports;

import com.api.arq_hexagonal.core.domain.Usuario;

public interface UsuarioRepositoryPort {
    Usuario create(Usuario usuario);
    Usuario obtainByEmail(String email);
    Usuario findById(Long id);
    Usuario update(Long id, Usuario usuario);
    void delete(Long id);
}
