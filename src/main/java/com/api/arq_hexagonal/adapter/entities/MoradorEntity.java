package com.api.arq_hexagonal.adapter.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_morador")
public class MoradorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeMorador;
    private String cpf;
    private String endereco;
    private String celular;
}
