package br.com.davi.guiche_api.service;

import br.com.davi.guiche_api.model.Fila;

import br.com.davi.guiche_api.repository.FilaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilaService {
    private final FilaRepository filaRepository;

    public FilaService(FilaRepository filaRepository) {
        this.filaRepository = filaRepository;
    }
    public List<Fila> listarTodos(){
        return filaRepository.findAll();
    }
}
