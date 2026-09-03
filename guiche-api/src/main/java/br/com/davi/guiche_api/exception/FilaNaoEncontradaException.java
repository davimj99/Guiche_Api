package br.com.davi.guiche_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FilaNaoEncontradaException extends RuntimeException {

    public FilaNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
    public FilaNaoEncontradaException(Long id) {
        super("fila não encontrada então pode ser deletada: " + id);
    }
}