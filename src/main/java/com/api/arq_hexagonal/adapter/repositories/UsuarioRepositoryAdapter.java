package com.api.arq_hexagonal.adapter.repositories;

import com.api.arq_hexagonal.adapter.entities.UsuarioEntity;
import com.api.arq_hexagonal.core.domain.Usuario;
import com.api.arq_hexagonal.core.ports.UsuarioRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UsuarioRepositoryAdapter implements UsuarioRepositoryPort {

    private final UsuarioRepository usuarioRepository;
    private final ModelMapper modelMapper;

    @Override
    public Usuario create(Usuario usuario) {
        UsuarioEntity usuarioEntity = usuarioRepository.save(modelMapper.map(usuario, UsuarioEntity.class));
        return modelMapper.map(usuarioEntity, Usuario.class);
    }

    @Override
    public Usuario obtainByEmail(String email) {
        UsuarioEntity usuarioByEmail = usuarioRepository.findByEmail(email);
        if (usuarioByEmail == null) {
            return null;
        }
        return modelMapper.map(usuarioByEmail, Usuario.class);
    }

    @Override
    public Usuario findById(Long id) {
        return usuarioRepository.findById(id)
                .map(usuarioEntity -> modelMapper.map(usuarioEntity, Usuario.class))
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
    }

    @Override
    public Usuario update(Long id, Usuario usuario) {
        UsuarioEntity usuarioAtualizado = usuarioRepository.findById(id).map(
                usuarioEntity -> {
                    usuarioEntity.setNomeUsuario(usuario.getNomeUsuario());
                    usuarioEntity.setEmail(usuario.getEmail());
                    usuarioEntity.setSenha(usuario.getSenha());
                    usuarioEntity.setAdministrador(usuario.getAdministrador());
                    return usuarioRepository.save(modelMapper.map(usuarioEntity, UsuarioEntity.class));
                }
        ).orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        return modelMapper.map(usuarioAtualizado, Usuario.class);
    }

    @Override
    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }
}
