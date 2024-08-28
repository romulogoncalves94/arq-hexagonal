package com.api.arq_hexagonal.core.ports;

import com.api.arq_hexagonal.core.domain.Morador;

import java.util.List;

public interface MoradorRepositoryPort {
    Morador createMorador(Morador morador);
    Morador obtainByCpf(String cpf);
    List<Morador> findAll();
    Morador findById(Long id);
    Morador updateMorador(Long id, Morador morador);
    void delete(Long id);
}
