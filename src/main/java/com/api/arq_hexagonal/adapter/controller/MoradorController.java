package com.api.arq_hexagonal.adapter.controller;

import com.api.arq_hexagonal.adapter.converters.MoradorConverter;
import com.api.arq_hexagonal.adapter.dtos.MoradorDTO;
import com.api.arq_hexagonal.core.domain.Morador;
import com.api.arq_hexagonal.core.ports.MoradorServicePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/moradores")
@RequiredArgsConstructor
@Tag(name = "Moradores", description = "Operações sobre moradores")
public class MoradorController {

    private final MoradorServicePort moradorServicePort;
    private final MoradorConverter moradorConverter;

    @Operation(summary = "Cria um novo morador", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Morador criado com sucesso"),
            @ApiResponse(responseCode = "201", description = "Morador criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Parâmetros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MoradorDTO create(@RequestBody MoradorDTO moradorDTO) {
        return moradorConverter.toDto(moradorServicePort.createMorador(moradorConverter.toDomain(moradorDTO)));
    }

    @GetMapping
    public List<MoradorDTO> findAll() {
        return moradorServicePort.findAllMoradores().stream()
                .map(moradorConverter::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public MoradorDTO findById(@PathVariable Long id) {
        return moradorConverter.toDto(moradorServicePort.findMoradorById(id));
    }

    @PutMapping("/{id}")
    public MoradorDTO update(@PathVariable Long id, @RequestBody MoradorDTO moradorDTO) {
        return moradorConverter.toDto(moradorServicePort.updateMorador(id, moradorConverter.toDomain(moradorDTO)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        moradorServicePort.deleteMorador(id);
    }
}
