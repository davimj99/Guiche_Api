package br.com.davi.guiche_api.dto.fila;

public record FilaResponseDTO(
        Long id,
        String nome,
        int numero,
        String prefixo,
        boolean ativo

) {
}