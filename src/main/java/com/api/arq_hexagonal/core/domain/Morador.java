package com.api.arq_hexagonal.core.domain;

public class Morador {
    private Long id;
    private String nomeMorador;
    private String cpf;
    private String endereco;
    private String celular;

    public Morador() {
    }

    public Morador(Long id, String nomeMorador, String cpf, String endereco, String celular) {
        this.id = id;
        this.nomeMorador = nomeMorador;
        this.cpf = cpf;
        this.endereco = endereco;
        this.celular = celular;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeMorador() {
        return nomeMorador;
    }

    public void setNomeMorador(String nomePessoa) {
        this.nomeMorador = nomePessoa;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
}
