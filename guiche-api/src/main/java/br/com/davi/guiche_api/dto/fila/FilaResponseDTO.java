package br.com.davi.guiche_api.dto.fila;

public record FilaResponseDTO(
        Long id,
        String tipo,
        int numero,
        String prefixo,
        boolean ativo

) {
}