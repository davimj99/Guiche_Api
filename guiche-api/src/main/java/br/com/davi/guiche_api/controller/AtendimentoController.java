package br.com.davi.guiche_api.controller;

import br.com.davi.guiche_api.dto.atendimento.AtendimentoRequestDTO;
import br.com.davi.guiche_api.dto.atendimento.AtendimentoResponseDTO;
import br.com.davi.guiche_api.service.AtendimentoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atendimentos")
public class AtendimentoController {

    private final AtendimentoService service;

    public AtendimentoController(AtendimentoService service) {
        this.service = service;
    }

    @GetMapping
    public List<AtendimentoResponseDTO> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public AtendimentoResponseDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AtendimentoResponseDTO criar(
            @RequestBody AtendimentoRequestDTO dto) {

        return service.criar(dto);
    }
}