package br.com.davi.guiche_api.repository;
import br.com.davi.guiche_api.model.Guiche;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuicheRepository extends JpaRepository<Guiche, Long> {
}