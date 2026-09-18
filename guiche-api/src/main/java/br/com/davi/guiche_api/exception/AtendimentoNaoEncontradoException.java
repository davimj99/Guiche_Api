package br.com.davi.guiche_api.exception;

public class AtendimentoNaoEncontradoException extends RuntimeException {

    public AtendimentoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public AtendimentoNaoEncontradoException(Long id) {
        super("Atendimento não encontrado: " + id);
    }
}