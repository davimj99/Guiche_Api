package br.com.davi.guiche_api.controller;

import br.com.davi.guiche_api.dto.guiche.GuicheRequestDTO;
import br.com.davi.guiche_api.dto.guiche.GuicheResponseDTO;
import br.com.davi.guiche_api.service.GuicheService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "GUICHÊ")
@RequestMapping("/guiches")
public class GuicheController {

    private final GuicheService guicheService;

    public GuicheController(GuicheService guicheService) {
        this.guicheService = guicheService;
    }

    @Operation(summary = "Listar guichês",
            description = "Retorna todos os guichês cadastrados no sistema.")
    @GetMapping
    public ResponseEntity<List<GuicheResponseDTO>> listarTodos() {
        return ResponseEntity.ok(guicheService.listarTodos());
    }

    @Operation(summary = "Cadastrar guichê",
            description = "Cadastra um novo guichê no sistema.")
    @PostMapping
    public ResponseEntity<GuicheResponseDTO> cadastrar(@RequestBody GuicheRequestDTO dto) {
        GuicheResponseDTO guiche = guicheService.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(guiche);
    }

    @Operation(summary = "Buscar guichê",
            description = "Busca um guichê específico pelo seu ID.")
    @GetMapping("/{id}")
    public ResponseEntity<GuicheResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(guicheService.buscarPorId(id));
    }

    @Operation(summary = "Atualizar guichê",
            description = "Atualiza um guichê existente pelo seu ID."
    )
    @PutMapping("/{id}")
    public ResponseEntity<GuicheResponseDTO> atualizar(@PathVariable Long id,
            @RequestBody GuicheRequestDTO dto) {
        GuicheResponseDTO guiche = guicheService.atualizar(id, dto);
        return ResponseEntity.ok(guiche);
    }

    @Operation(summary = "Deletar guichê",
            description = "Deleta um guichê existente pelo seu ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        guicheService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}