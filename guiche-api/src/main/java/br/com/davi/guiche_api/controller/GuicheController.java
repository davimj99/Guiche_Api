package br.com.davi.guiche_api.controller;


import br.com.davi.guiche_api.dto.guiche.GuicheResponseDTO;
import br.com.davi.guiche_api.service.GuicheService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}