package com.api.arq_hexagonal.adapter.repositories;

import com.api.arq_hexagonal.adapter.entities.MoradorEntity;
import com.api.arq_hexagonal.core.domain.Morador;
import com.api.arq_hexagonal.core.ports.MoradorRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MoradorRepositoryAdapter implements MoradorRepositoryPort {

    private final MoradorRepository moradorRepository;
    private final ModelMapper modelMapper;

    @Override
    public Morador createMorador(Morador morador) {
        MoradorEntity moradorEntity = moradorRepository.save(modelMapper.map(morador, MoradorEntity.class));
        return modelMapper.map(moradorEntity, Morador.class);
    }

    @Override
    public Morador obtainByCpf(String cpf) {
        MoradorEntity moradorByCpf = moradorRepository.findByCpf(cpf);

        if (moradorByCpf == null) {
            return null;
        }

        return modelMapper.map(moradorByCpf, Morador.class);
    }

    @Override
    public List<Morador> findAll() {
        return moradorRepository.findAll().stream()
                .map(entity -> modelMapper.map(entity, Morador.class))
                .toList();
    }

    @Override
    public Morador findById(Long id) {
        return moradorRepository.findById(id)
                .map(moradorEntity -> modelMapper.map(moradorEntity, Morador.class))
                .orElseThrow(() -> new IllegalArgumentException("Morador não encontrado"));
    }

    @Override
    public Morador updateMorador(Long id, Morador morador) {
        MoradorEntity moradorAtualizado = moradorRepository.findById(id).map(
                moradorEntity -> {
                    moradorEntity.setNomeMorador(morador.getNomeMorador());
                    moradorEntity.setCpf(morador.getCpf());
                    moradorEntity.setEndereco(morador.getEndereco());
                    moradorEntity.setCelular(morador.getCelular());
                    return moradorRepository.save(moradorEntity);
                }).orElseThrow(() -> new IllegalArgumentException("Morador não encontrado"));

        return modelMapper.map(moradorAtualizado, Morador.class);
    }

    @Override
    public void delete(Long id) {
        moradorRepository.deleteById(id);
    }
}
