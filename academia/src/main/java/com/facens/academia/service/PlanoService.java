package com.facens.academia.service;

import com.facens.academia.dto.request.PlanoRequest;
import com.facens.academia.entity.Plano;
import com.facens.academia.repository.PlanoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import lombok.Data;

@Service
public class PlanoService {

    private final PlanoRepository repository;

    public PlanoService(PlanoRepository repository) {
        this.repository = repository;
    }

    public Plano cadastrar(PlanoRequest request) {
        Plano plano = new Plano();
        plano.setNome(request.getNome());
        plano.setValor(request.getValor());

        return repository.save(plano);
    }

    public List<Plano> listar() {
        return repository.findAll();
    }
}