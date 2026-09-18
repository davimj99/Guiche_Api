package br.com.davi.guiche_api.exception;

public class FilaNaoEncontradaException extends RuntimeException {

    public FilaNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
    public FilaNaoEncontradaException(Long id) {
        super("fila não encontrada: " + id);
    }
}