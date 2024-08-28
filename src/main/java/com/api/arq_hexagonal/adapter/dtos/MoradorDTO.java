package com.api.arq_hexagonal.adapter.dtos;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MoradorDTO {
    private Long id;
    private String nomeMorador;
    private String cpf;
    private String endereco;
    private String celular;
}
