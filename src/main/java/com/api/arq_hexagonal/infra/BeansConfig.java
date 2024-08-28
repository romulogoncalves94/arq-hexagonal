package com.api.arq_hexagonal.infra;

import com.api.arq_hexagonal.core.ports.*;
import com.api.arq_hexagonal.core.services.*;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public UsuarioServicePort usuarioServicePort(UsuarioRepositoryPort usuarioRepositoryPort) {
        return new UsuarioService(usuarioRepositoryPort);
    }

    @Bean
    public MoradorServicePort moradorServicePort(MoradorRepositoryPort moradorRepositoryPort, ModelMapper modelMapper) {
        return new MoradorService(moradorRepositoryPort, modelMapper);
    }

    @Bean
    public VisitanteServicePort visitanteServicePort(VisitanteRepositoryPort visitanteRepositoryPort, ModelMapper modelMapper) {
        return new VisitanteService(visitanteRepositoryPort, modelMapper);
    }

    @Bean
    public VisitaServicePort visitaServicePort(VisitaRepositoryPort visitaRepositoryPort, VisitanteRepositoryPort visitanteRepositoryPort, MoradorRepositoryPort moradorRepositoryPort, ModelMapper modelMapper) {
        return new VisitaService(visitaRepositoryPort, visitanteRepositoryPort, moradorRepositoryPort, modelMapper);
    }
}
