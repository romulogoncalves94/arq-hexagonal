package com.api.arq_hexagonal.adapter.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_visita")
public class VisitaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataHora;
    @ManyToOne
    @JoinColumn(name = "id_morador")
    private MoradorEntity morador;
    @OneToOne
    @JoinColumn(name = "id_visitante")
    private VisitanteEntity visitante;
}
