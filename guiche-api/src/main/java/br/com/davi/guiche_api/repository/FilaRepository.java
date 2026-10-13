package br.com.davi.guiche_api.repository;

//import br.com.davi.guiche_api.entity.Fila;
import br.com.davi.guiche_api.entity.FilaSpring;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilaRepository extends JpaRepository<FilaSpring, Long> {
}
