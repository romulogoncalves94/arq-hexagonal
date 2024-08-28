package com.api.arq_hexagonal.adapter.dtos;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class VisitanteDTO {
    private Long id;
    private String rg;
    private String nomeVisitante;
}
