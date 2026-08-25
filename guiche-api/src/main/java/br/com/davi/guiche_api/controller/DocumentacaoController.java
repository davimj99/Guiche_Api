package br.com.davi.guiche_api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DocumentacaoController {

    @GetMapping("/doc")
    public String documentacao() {
        return "redirect:/swagger-ui/index.html";
    }
}