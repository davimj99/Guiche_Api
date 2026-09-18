package br.com.davi.guiche_api.controller;

import br.com.davi.guiche_api.dto.fila.FilaRequestDTO;
import br.com.davi.guiche_api.dto.fila.FilaResponseDTO;
import br.com.davi.guiche_api.service.FilaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "FILAS")
@RequestMapping("/filas")
public class FilaController {

    private final FilaService filaService;

    public FilaController(FilaService filaService) {
        this.filaService = filaService;
    }

    @Operation(summary = "Listar filas",
            description = "Retorna todas as filas cadastradas no sistema.")
    @GetMapping
    public ResponseEntity<List<FilaResponseDTO>> listarTodos() {
        return ResponseEntity.ok(filaService.listarTodos());
    }

    @Operation(summary = "Cadastrar fila",
            description = "Cadastra uma nova fila no sistema.")
    @PostMapping
    public ResponseEntity<FilaResponseDTO> cadastrar(@RequestBody FilaRequestDTO dto) {
        FilaResponseDTO fila = filaService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(fila);
    }

    @Operation(summary = "Buscar fila",
            description = "Busca uma fila específica pelo seu ID.")
    @GetMapping("/{id}")
    public ResponseEntity<FilaResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(filaService.buscarPorId(id));
    }

    @Operation(summary = "Atualizar fila",
            description = "Atualiza uma fila existente pelo seu ID.")
    @PutMapping("/{id}")
    public ResponseEntity<FilaResponseDTO> atualizar(@PathVariable Long id, @RequestBody FilaRequestDTO dto) {
        FilaResponseDTO fila = filaService.atualizar(id, dto);
        return ResponseEntity.ok(fila);
    }

    @Operation(summary = "Deletar fila",
            description = "Deleta uma fila existente pelo seu ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        filaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}