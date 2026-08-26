package br.com.davi.guiche_api.controller;

import br.com.davi.guiche_api.dto.guiche.GuicheRequestDTO;
import br.com.davi.guiche_api.dto.guiche.GuicheResponseDTO;
import br.com.davi.guiche_api.service.GuicheService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guiches")
public class GuicheController {

    private final GuicheService guicheService;

    public GuicheController(GuicheService guicheService) {
        this.guicheService = guicheService;
    }

    @Operation(summary = "Listar guichês",
            description = "Retorna todos os guichês cadastrados no sistema.")
    @GetMapping
    public List<GuicheResponseDTO> listarTodos() {
        return guicheService.listarTodos();
    }

    @Operation(summary = "Cadastrar guichê",
            description = "Cadastra um novo guichê no sistema.")
    @PostMapping
    public GuicheResponseDTO cadastrar(@RequestBody GuicheRequestDTO dto) {
        return guicheService.cadastrar(dto);
    }

    @Operation(summary = "Buscar guichê",
            description = "Busca um guichê específico pelo seu ID")
    @GetMapping("/{id}")
    public GuicheResponseDTO buscarPorId(@PathVariable Long id) {
        return guicheService.buscarPorId(id);
    }

    @Operation(summary = "Atualizar guichê",
            description = "Atualiza o nome de um guichê existente pelo seu ID.")
    @PutMapping("/{id}")
    public GuicheResponseDTO atualizar(@PathVariable Long id, @RequestBody GuicheRequestDTO dto) {
        return guicheService.atualizar(id, dto);
    }

    @Operation(summary = "Deleta o guichê",
            description = "Deleta um guichê existente pelo seu ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        guicheService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}