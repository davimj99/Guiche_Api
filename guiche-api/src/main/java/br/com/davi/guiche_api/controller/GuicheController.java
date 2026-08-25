package br.com.davi.guiche_api.controller;


import br.com.davi.guiche_api.dto.guiche.GuicheRequestDTO;
import br.com.davi.guiche_api.dto.guiche.GuicheResponseDTO;
import br.com.davi.guiche_api.service.GuicheService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guiches")
public class GuicheController {

    private final GuicheService guicheService;

    public GuicheController(GuicheService guicheService) {
        this.guicheService = guicheService;
    }

    @GetMapping
    public List<GuicheResponseDTO> listarTodos() {
        return guicheService.listarTodos();
    }

    @PostMapping
    public GuicheResponseDTO cadastrar(@RequestBody GuicheRequestDTO dto) {
        return guicheService.cadastrar(dto);
    }

    @GetMapping("/{id}")
    public GuicheResponseDTO buscarPorId(@PathVariable Long id) {
        return guicheService.buscarPorId(id);
    }
}