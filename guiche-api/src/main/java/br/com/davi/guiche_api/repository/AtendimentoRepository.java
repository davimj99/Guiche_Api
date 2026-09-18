package br.com.davi.guiche_api.repository;

import br.com.davi.guiche_api.entity.Atendimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtendimentoRepository
        extends JpaRepository<Atendimento, Long> {
}