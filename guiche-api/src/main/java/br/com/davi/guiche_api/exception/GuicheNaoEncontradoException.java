package br.com.davi.guiche_api.exception;

public class GuicheNaoEncontradoException extends RuntimeException {

    public GuicheNaoEncontradoException(Long id) {
        super("Guichê não encontrado: " + id);
    }
}