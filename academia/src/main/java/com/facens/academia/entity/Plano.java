package com.facens.academia.entity;

import jakarta.persistence.*;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "plano")
public class Plano {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Double valor;

    @OneToMany(mappedBy = "plano")
    private List<Aluno> alunos;

}