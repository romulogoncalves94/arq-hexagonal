package com.api.arq_hexagonal.adapter.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_visitante")
public class VisitanteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rg;
    private String nomeVisitante;
}
