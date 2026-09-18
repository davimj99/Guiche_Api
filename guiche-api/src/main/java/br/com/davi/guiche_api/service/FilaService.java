package br.com.davi.guiche_api.service;

import br.com.davi.guiche_api.dto.fila.FilaRequestDTO;
import br.com.davi.guiche_api.dto.fila.FilaResponseDTO;
import br.com.davi.guiche_api.entity.Fila;
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
        Fila fila = new Fila();

        fila.setNome(dto.nome());
        fila.setNumero(dto.numero());
        fila.setAtivo(dto.ativo());
        fila.setPrefixo(dto.prefixo());

        Fila salva = repository.save(fila);
        return toResponseDTO(salva);
    }

    public FilaResponseDTO buscarPorId(Long id) {
        Fila fila = repository.findById(id).orElseThrow(() -> new RuntimeException("Fila não encontrada"));
        return toResponseDTO(fila);
    }

    public FilaResponseDTO atualizar(Long id, FilaRequestDTO dto) {
        Fila fila = repository.findById(id).orElseThrow(() -> new RuntimeException("Fila não encontrada"));

        fila.setNome(dto.nome());
        fila.setNumero(dto.numero());
        fila.setAtivo(dto.ativo());
        fila.setPrefixo(dto.prefixo());

        Fila atualizada = repository.save(fila);
        return toResponseDTO(atualizada);
    }

    public void deletar(Long id) {
        Fila fila = repository.findById(id).orElseThrow(() -> new RuntimeException("Fila não encontrada"));
        repository.delete(fila);
    }

    private FilaResponseDTO toResponseDTO(Fila fila) {
        return new FilaResponseDTO(
                fila.getId(),
                fila.getNome(),
                fila.getNumero(),
                fila.getPrefixo(),
                fila.isAtivo()
        );
    }
}