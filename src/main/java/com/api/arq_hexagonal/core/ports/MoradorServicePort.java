package com.api.arq_hexagonal.core.ports;

import com.api.arq_hexagonal.core.domain.Morador;

import java.util.List;

public interface MoradorServicePort {
    Morador createMorador(Morador morador);
    List<Morador> findAllMoradores();
    Morador updateMorador(Long id, Morador morador);
    Morador findMoradorById(Long id);
    void deleteMorador(Long id);
}
