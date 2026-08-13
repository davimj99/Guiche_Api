package br.com.davi.guiche_api.controller;

import br.com.davi.guiche_api.model.Guiche;
import br.com.davi.guiche_api.service.GuicheService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GuicheController {

    private final GuicheService guicheService;

    public GuicheController(GuicheService guicheService) {
        this.guicheService = guicheService;
    }

    @GetMapping("/guiches")
    public List<Guiche> listarTodos() {
        return guicheService.listarTodos();
    }
}