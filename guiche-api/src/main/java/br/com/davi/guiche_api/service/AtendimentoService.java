package br.com.davi.guiche_api.service;

import br.com.davi.guiche_api.dto.atendimento.AtendimentoRequestDTO;
import br.com.davi.guiche_api.dto.atendimento.AtendimentoResponseDTO;
import br.com.davi.guiche_api.entity.Atendimento;
import br.com.davi.guiche_api.repository.AtendimentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtendimentoService {

    private final AtendimentoRepository repository;

    public AtendimentoService(AtendimentoRepository repository) {
        this.repository = repository;
    }

    public List<AtendimentoResponseDTO> listarTodos() {

        return repository.findAll().stream().map(this::toResponseDTO).toList();
    }

    public AtendimentoResponseDTO buscarPorId(Long id) {
        Atendimento atendimento = repository.findById(id).orElseThrow(() -> new RuntimeException("Atendimento não encontrado"));
        return toResponseDTO(atendimento);
    }

    public AtendimentoResponseDTO cadastrar(AtendimentoRequestDTO dto) {

        Atendimento atendimento = new Atendimento();

        atendimento.setInicio(dto.inicio());
        atendimento.setFim(dto.fim());
        atendimento.setSenhaId(dto.senhaId());
        atendimento.setTipo(dto.tipo());
        atendimento.setGuiche(dto.guiche());
        atendimento.setAluno(dto.aluno());
        atendimento.setAtendente(dto.atendente());

        Atendimento salvo = repository.save(atendimento);

        return toResponseDTO(salvo);
    }

    private AtendimentoResponseDTO toResponseDTO(Atendimento atendimento) {

        return new AtendimentoResponseDTO(atendimento.getId(), atendimento.getInicio(), atendimento.getFim(), atendimento.getSenhaId(), atendimento.getTipo(), atendimento.getGuiche(), atendimento.getAluno(), atendimento.getAtendente());
    }

    public AtendimentoResponseDTO atualizar(Long id, AtendimentoRequestDTO dto) {

        Atendimento atendimento = repository.findById(id).orElseThrow(() -> new RuntimeException("Atendimento não encontrado"));

        atendimento.setInicio(dto.inicio());
        atendimento.setFim(dto.fim());
        atendimento.setSenhaId(dto.senhaId());
        atendimento.setTipo(dto.tipo());
        atendimento.setGuiche(dto.guiche());
        atendimento.setAluno(dto.aluno());
        atendimento.setAtendente(dto.atendente());

        Atendimento atualizado = repository.save(atendimento);

        return toResponseDTO(atualizado);
    }

    public void deletar(Long id) {
        Atendimento atendimento = repository.findById(id).orElseThrow(() -> new RuntimeException("Atendimento não encontrado"));

        repository.delete(atendimento);
    }
}