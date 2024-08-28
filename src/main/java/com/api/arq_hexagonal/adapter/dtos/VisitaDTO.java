package com.api.arq_hexagonal.adapter.dtos;

import lombok.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class VisitaDTO {
    private Long id;
    private LocalDateTime dataHora;
    private MoradorDTO morador;
    private VisitanteDTO visitante;
}
