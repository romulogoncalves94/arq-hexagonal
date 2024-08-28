package com.api.arq_hexagonal.adapter.controller;

import com.api.arq_hexagonal.adapter.converters.VisitanteConverter;
import com.api.arq_hexagonal.adapter.dtos.VisitanteDTO;
import com.api.arq_hexagonal.core.ports.VisitanteServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/visitantes")
@RequiredArgsConstructor
public class VisitanteController {

    private final VisitanteServicePort visitanteServicePort;
    private final VisitanteConverter visitanteConverter;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VisitanteDTO create(@RequestBody VisitanteDTO visitanteDTO) {
        return visitanteConverter.toDto(visitanteServicePort.createVisitante(visitanteConverter.toDomain(visitanteDTO)));
    }

    @GetMapping
    public List<VisitanteDTO> findAll() {
        return visitanteServicePort.findAllVisitantes().stream()
                .map(visitanteConverter::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public VisitanteDTO findById(@PathVariable Long id) {
        return visitanteConverter.toDto(visitanteServicePort.findVisitanteById(id));
    }

    @PutMapping("/{id}")
    public VisitanteDTO update(@PathVariable Long id, @RequestBody VisitanteDTO VisitanteDTO) {
        return visitanteConverter.toDto(visitanteServicePort.updateMorador(id, visitanteConverter.toDomain(VisitanteDTO)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        visitanteServicePort.deleteVisitante(id);
    }
}
