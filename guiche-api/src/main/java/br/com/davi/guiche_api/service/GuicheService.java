package br.com.davi.guiche_api.service;

import br.com.davi.guiche_api.model.Guiche;
import br.com.davi.guiche_api.repository.GuicheRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuicheService {

    private final GuicheRepository guicheRepository;

    public GuicheService(GuicheRepository guicheRepository) {
        this.guicheRepository = guicheRepository;
    }

    public List<Guiche> listarTodos() {
        return guicheRepository.findAll();
    }
}