package com.facens.academia.entity;

import jakarta.persistence.*;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;

    @ManyToOne
    @JoinColumn(name = "plano_id")
    private Plano plano;

}