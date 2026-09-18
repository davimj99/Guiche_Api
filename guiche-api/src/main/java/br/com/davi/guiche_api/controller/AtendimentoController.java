package br.com.davi.guiche_api.controller;

import br.com.davi.guiche_api.dto.atendimento.AtendimentoRequestDTO;
import br.com.davi.guiche_api.dto.atendimento.AtendimentoResponseDTO;
import br.com.davi.guiche_api.service.AtendimentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<List<AtendimentoResponseDTO>> listarTodos() {
        return ResponseEntity.ok(atendimentoService.listarTodos());
    }

    @Operation(summary = "Buscar atendimento",
            description = "Busca um atendimento específico pelo seu ID.")
    @GetMapping("/{id}")
    public ResponseEntity<AtendimentoResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(atendimentoService.buscarPorId(id));
    }

    @Operation(summary = "Cadastrar atendimento",
            description = "Cadastra um novo atendimento no sistema.")
    @PostMapping
    public ResponseEntity<AtendimentoResponseDTO> cadastrar(@RequestBody AtendimentoRequestDTO dto) {
        AtendimentoResponseDTO atendimento = atendimentoService.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(atendimento);
    }

    @Operation(summary = "Atualizar atendimento",
            description = "Atualiza um atendimento existente pelo seu ID.")
    @PutMapping("/{id}")
    public ResponseEntity<AtendimentoResponseDTO> atualizar(@PathVariable Long id,
            @RequestBody AtendimentoRequestDTO dto) {
        AtendimentoResponseDTO atendimento = atendimentoService.atualizar(id, dto);
        return ResponseEntity.ok(atendimento);
    }

    @Operation(summary = "Deletar atendimento",
            description = "Deleta um atendimento existente pelo seu ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        atendimentoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}