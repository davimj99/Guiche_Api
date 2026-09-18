package br.com.davi.guiche_api.dto.atendimento;

import java.time.LocalDateTime;

public record AtendimentoResponseDTO(
        Long id,
        LocalDateTime inicio,
        LocalDateTime fim,
        Long senhaId,
        String tipo,
        Long guiche,
        String aluno,
        String atendente
) {
}
