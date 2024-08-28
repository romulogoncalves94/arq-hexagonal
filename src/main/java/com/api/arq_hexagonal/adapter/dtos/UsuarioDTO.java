package com.api.arq_hexagonal.adapter.dtos;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UsuarioDTO {
    private Long id;
    private String nomeUsuario;
    private String email;
    private String senha;
    private Boolean administrador;
}
