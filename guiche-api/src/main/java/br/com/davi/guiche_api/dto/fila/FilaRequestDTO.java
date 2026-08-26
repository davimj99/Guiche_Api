package br.com.davi.guiche_api.dto.fila;

public record FilaRequestDTO(
        String nome,
        int numero,
        boolean ativo
) {
}