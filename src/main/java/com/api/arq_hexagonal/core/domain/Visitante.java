package com.api.arq_hexagonal.core.domain;

public class Visitante {
    private Long id;
    private String rg;
    private String nomeVisitante;

    public Visitante() {
    }

    public Visitante(Long id, String rg, String nomeVisitante) {
        this.id = id;
        this.rg = rg;
        this.nomeVisitante = nomeVisitante;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNomeVisitante() {
        return nomeVisitante;
    }

    public void setNomeVisitante(String nomeVisitante) {
        this.nomeVisitante = nomeVisitante;
    }
}
