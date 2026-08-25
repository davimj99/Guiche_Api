package br.com.davi.guiche_api.service;

import br.com.davi.guiche_api.dto.guiche.GuicheRequestDTO;
import br.com.davi.guiche_api.dto.guiche.GuicheResponseDTO;
import br.com.davi.guiche_api.exception.GuicheNaoEncontradoException;
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

    public GuicheResponseDTO cadastrar(GuicheRequestDTO dto) {

        Guiche guiche = new Guiche();

        guiche.setNome(dto.getNome());
        guiche.setAtivo(true);

        Guiche salvo = guicheRepository.save(guiche);

        return new GuicheResponseDTO(
                salvo.getId(),
                salvo.getNome(),
                salvo.isAtivo()
        );
    }

    public List<GuicheResponseDTO> listarTodos() {
        return guicheRepository.findAll()
                .stream()
                .map(guiche -> new GuicheResponseDTO(
                        guiche.getId(),
                        guiche.getNome(),
                        guiche.isAtivo()
                ))
                .toList();
    }

    public GuicheResponseDTO buscarPorId(Long id) {

        Guiche guiche = guicheRepository.findById(id)
                .orElseThrow(() -> new GuicheNaoEncontradoException(id));

        return new GuicheResponseDTO(
                guiche.getId(),
                guiche.getNome(),
                guiche.isAtivo()
        );
    }
}