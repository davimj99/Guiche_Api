package br.com.davi.guiche_api.service;

import br.com.davi.guiche_api.dto.fila.FilaRequestDTO;
import br.com.davi.guiche_api.dto.fila.FilaResponseDTO;
import br.com.davi.guiche_api.exception.FilaNaoEncontradaException;
import br.com.davi.guiche_api.entity.Fila;
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
                        fila.getPrefixo(),
                        fila.isAtivo()

                ))
                .toList();
    }

    public FilaResponseDTO buscarPorId(Long id) {
        Fila fila = filaRepository.findById(id)
                .orElseThrow(() ->
                        new FilaNaoEncontradaException("Fila não encontrada")
                );
        return new FilaResponseDTO(
                fila.getId(),
                fila.getNome(),
                fila.getNumero(),
                fila.getPrefixo(),
                fila.isAtivo()

        );
    }

    public FilaResponseDTO criar(FilaRequestDTO dto) {
        Fila fila = new Fila();
        fila.setNome(dto.nome());
        fila.setNumero(dto.numero());
        fila.setAtivo(dto.ativo());
        fila.setPrefixo(dto.prefixo());
        Fila filaSalva = filaRepository.save(fila);

        return new FilaResponseDTO(
                filaSalva.getId(),
                filaSalva.getNome(),
                filaSalva.getNumero(),
                filaSalva.getPrefixo(),
                filaSalva.isAtivo()

        );
    }
    public void deletar(Long id) {
        if (!filaRepository.existsById(id)) {
            throw new FilaNaoEncontradaException(id);
        }
        filaRepository.deleteById(id);
    }
}