package br.com.davi.guiche_api.dto.atendimento;

import java.time.LocalDateTime;

public record AtendimentoRequestDTO(
        LocalDateTime inicio,
        LocalDateTime fim,
        Long senhaId,
        String tipo,
        Long guiche,
        Long aluno,
        Long atendente
) {
}