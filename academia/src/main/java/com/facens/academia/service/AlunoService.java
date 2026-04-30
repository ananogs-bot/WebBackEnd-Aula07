package com.facens.academia.service;

import com.facens.academia.dto.request.AlunoRequest;
import com.facens.academia.entity.Aluno;
import com.facens.academia.entity.Plano;
import com.facens.academia.exception.RegraNegocioException;
import com.facens.academia.exception.RecursoNaoEncontradoException;
import com.facens.academia.repository.AlunoRepository;
import com.facens.academia.repository.PlanoRepository;
import org.springframework.stereotype.Service;
import lombok.Data;

import java.util.List;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final PlanoRepository planoRepository;

    public AlunoService(AlunoRepository alunoRepository, PlanoRepository planoRepository) {
        this.alunoRepository = alunoRepository;
        this.planoRepository = planoRepository;
    }

    public Aluno cadastrar(AlunoRequest request) {

        // 🔥 validar email duplicado
        alunoRepository.findByEmail(request.getEmail())
                .ifPresent(a -> {
                    throw new RegraNegocioException("Email já cadastrado");
                });

        
        Plano plano = planoRepository.findById(request.getPlanoId())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Plano não encontrado"));

        Aluno aluno = new Aluno();
        aluno.setNome(request.getNome());
        aluno.setEmail(request.getEmail());
        aluno.setPlano(plano);

        return alunoRepository.save(aluno);
    }

    public List<Aluno> listar() {
        return alunoRepository.findAll();
    }
}