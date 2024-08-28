package com.api.arq_hexagonal.adapter.controller;

import com.api.arq_hexagonal.adapter.converters.VisitaConverter;
import com.api.arq_hexagonal.adapter.dtos.VisitaDTO;
import com.api.arq_hexagonal.core.ports.VisitaServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/visita")
@RequiredArgsConstructor
public class VisitaController {

    private final VisitaServicePort visitaServicePort;
    private final VisitaConverter visitaConverter;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VisitaDTO create(@RequestBody VisitaDTO visitaDTO) {
        return visitaConverter.toDto(visitaServicePort.createVisita(visitaConverter.toDomain(visitaDTO)));
    }

    @GetMapping
    public List<VisitaDTO> findAll() {
        return visitaServicePort.findAllVisitas().stream()
                .map(visitaConverter::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public VisitaDTO findById(@PathVariable Long id) {
        return visitaConverter.toDto(visitaServicePort.findVisitaById(id));
    }

    @PutMapping("/{id}")
    public VisitaDTO update(@PathVariable Long id, @RequestBody VisitaDTO visitaDTO) {
        return visitaConverter.toDto(visitaServicePort.updateVisita(id, visitaConverter.toDomain(visitaDTO)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        visitaServicePort.deleteVisita(id);
    }
}
