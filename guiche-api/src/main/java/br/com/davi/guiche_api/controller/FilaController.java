package br.com.davi.guiche_api.controller;

import br.com.davi.guiche_api.dto.fila.FilaRequestDTO;
import br.com.davi.guiche_api.dto.fila.FilaResponseDTO;
import br.com.davi.guiche_api.service.FilaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filas")
public class FilaController {

    private final FilaService filaService;

    public FilaController(FilaService filaService) {
        this.filaService = filaService;
    }

    @Operation(summary = "Listar fila",
            description = "Retorna todos as filas cadastradas no sistema.")
    @GetMapping
    public List<FilaResponseDTO> listarTodos() {
        return filaService.listarTodos();
    }

    @Operation(summary = "Buscar filas",
            description = "Busca uma fila específica pelo seu ID")
    @GetMapping("/{id}")
    public FilaResponseDTO buscarPorId(@PathVariable Long id) {
        return filaService.buscarPorId(id);
    }

    @Operation(summary = "Cadastrar fila",
            description = "Cadastra uma nova fila no sistema.")
    @PostMapping
    public FilaResponseDTO criar(@RequestBody FilaRequestDTO dto) {
        return filaService.criar(dto);
    }

    @Operation(summary = "Deletar fila",
            description = "Deleta uma fila existente pelo seu id")
    @DeleteMapping("/{id}")
    public FilaResponseDTO deletar(@PathVariable Long id) {
        filaService.deletar(id);
        return filaService.buscarPorId(id);
    }
}