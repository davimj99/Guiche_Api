package br.com.davi.guiche_api.controller;

import br.com.davi.guiche_api.dto.atendimento.AtendimentoRequestDTO;
import br.com.davi.guiche_api.dto.atendimento.AtendimentoResponseDTO;
import br.com.davi.guiche_api.service.AtendimentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "ATENDIMENTO")
@RequestMapping("/atendimentos")
public class AtendimentoController {

    private final AtendimentoService atendimentoService;

    public AtendimentoController(AtendimentoService atendimentoService) {
        this.atendimentoService = atendimentoService;
    }

    @Operation(summary = "Listar atendimentos",
            description = "Retorna todos os atendimentos registrados no sistema.")
    @GetMapping
    public List<AtendimentoResponseDTO> listarTodos() {
        return atendimentoService.listarTodos();
    }

    @Operation(summary = "Buscar atendimento",
            description = "Busca um atendimento específico pelo seu ID.")
    @GetMapping("/{id}")
    public AtendimentoResponseDTO buscarPorId(@PathVariable Long id) {
        return atendimentoService.buscarPorId(id);
    }

    @Operation(summary = "Cadastrar atendimento",
            description = "Cadastra um novo atendimento no sistema.")
    @PostMapping
    public AtendimentoResponseDTO cadastrar(
            @RequestBody AtendimentoRequestDTO dto
    ) {
        return atendimentoService.cadastrar(dto);
    }

    @Operation(summary = "Atualizar atendimento",
            description = "Atualiza um atendimento existente pelo seu ID.")
    @PutMapping("/{id}")
    public AtendimentoResponseDTO atualizar(
            @PathVariable Long id,
            @RequestBody AtendimentoRequestDTO dto
    ) {
        return atendimentoService.atualizar(id, dto);
    }

    @Operation(summary = "Deletar atendimento",
            description = "Deleta um atendimento existente pelo seu ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {

        atendimentoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}