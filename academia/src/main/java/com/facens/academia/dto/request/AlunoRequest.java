package com.facens.academia.dto.request;


public class AlunoRequest {

    private String nome;
    private String email;
    private Long planoId;

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public Long getPlanoId() {
        return planoId;
    }
}