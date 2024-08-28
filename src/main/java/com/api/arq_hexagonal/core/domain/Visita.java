package com.api.arq_hexagonal.core.domain;

import java.time.LocalDateTime;

public class Visita {
    private Long id;
    private LocalDateTime dataHora;
    private Morador morador;
    private Visitante visitante;

    public Visita() {
    }

    public Visita(Long id, LocalDateTime dataHora, Morador morador, Visitante visitante) {
        this.id = id;
        this.dataHora = dataHora;
        this.morador = morador;
        this.visitante = visitante;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Morador getMorador() {
        return morador;
    }

    public void setMorador(Morador morador) {
        this.morador = morador;
    }

    public Visitante getVisitante() {
        return visitante;
    }

    public void setVisitante(Visitante visitante) {
        this.visitante = visitante;
    }
}
