package br.com.davi.guiche_api.service;

import br.com.davi.guiche_api.dto.fila.FilaResponseDTO;
import br.com.davi.guiche_api.exception.FilaNaoEncontradaException;
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

    public List<FilaResponseDTO> listarTodos() {
        return filaRepository.findAll()
                .stream()
                .map(fila -> new FilaResponseDTO(
                        fila.getId(),
                        fila.getNome(),
                        fila.getNumero(),
                        fila.isAtivo()
                ))
                .toList();
    }

    public FilaResponseDTO buscarPorId(Long id) {
        Fila fila = filaRepository.findById(id)
                .orElseThrow(() -> new FilaNaoEncontradaException("Fila não encontrada"));
        return new FilaResponseDTO(
                fila.getId(),
                fila.getNome(),
                fila.getNumero(),
                fila.isAtivo()
        );
    }

}