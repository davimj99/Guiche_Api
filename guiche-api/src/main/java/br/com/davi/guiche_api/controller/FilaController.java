package br.com.davi.guiche_api.controller;

import br.com.davi.guiche_api.model.Fila;
import br.com.davi.guiche_api.service.FilaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FilaController {

    private final FilaService filaService;

    public FilaController(FilaService filaService){
        this.filaService = filaService;
    }
    @GetMapping("/filas")
    public List<Fila> listarTodos() {
        return filaService.listarTodos();
    }
}