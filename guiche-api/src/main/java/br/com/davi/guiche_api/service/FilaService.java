package br.com.davi.guiche_api.service;

import br.com.davi.guiche_api.dto.fila.FilaRequestDTO;
import br.com.davi.guiche_api.dto.fila.FilaResponseDTO;
//import br.com.davi.guiche_api.entity.Fila;
import br.com.davi.guiche_api.entity.FilaSpring;
import br.com.davi.guiche_api.exception.FilaNaoEncontradaException;
import br.com.davi.guiche_api.repository.FilaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilaService {

    private final FilaRepository repository;

    public FilaService(FilaRepository repository) {
        this.repository = repository;
    }

    public List<FilaResponseDTO> listarTodos() {
        return repository.findAll().stream().map(this::toResponseDTO).toList();
    }

    public FilaResponseDTO criar(FilaRequestDTO dto) {
        FilaSpring fila = new FilaSpring();
        fila.setTipo(dto.tipo());
        fila.setNumero(dto.numero());
        fila.setAtivo(dto.ativo());
        fila.setPrefixo(dto.prefixo());

        FilaSpring salva = repository.save(fila);
        return toResponseDTO(salva);
    }

    public FilaResponseDTO buscarPorId(Long id) {
        FilaSpring fila = repository.findById(id).orElseThrow(() -> new FilaNaoEncontradaException(id));
        return toResponseDTO(fila);
    }

    public FilaResponseDTO atualizar(Long id, FilaRequestDTO dto) {
        FilaSpring fila = repository.findById(id).orElseThrow(() -> new FilaNaoEncontradaException(id));
        fila.setTipo(dto.tipo());
        fila.setNumero(dto.numero());
        fila.setAtivo(dto.ativo());
        fila.setPrefixo(dto.prefixo());

        FilaSpring atualizada = repository.save(fila);

        return toResponseDTO(atualizada);
    }

    public void deletar(Long id) {
        FilaSpring fila = repository.findById(id).orElseThrow(() -> new FilaNaoEncontradaException(id));
        repository.delete(fila);
    }

    private FilaResponseDTO toResponseDTO(FilaSpring fila) {
        return new FilaResponseDTO(
                fila.getId(),
                fila.getTipo(),
                fila.getNumero(),
                fila.getPrefixo(),
                fila.isAtivo()
        );
    }
}